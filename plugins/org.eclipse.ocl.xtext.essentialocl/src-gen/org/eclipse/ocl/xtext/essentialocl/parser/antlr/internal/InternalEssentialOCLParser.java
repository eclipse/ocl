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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_SIMPLE_ID", "RULE_ESCAPED_ID", "RULE_INT", "RULE_SINGLE_QUOTED_STRING", "RULE_ESCAPED_CHARACTER", "RULE_LETTER_CHARACTER", "RULE_DOUBLE_QUOTED_STRING", "RULE_ML_SINGLE_QUOTED_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'-'", "'not'", "'*'", "'/'", "'+'", "'>'", "'<'", "'>='", "'<='", "'='", "'<>'", "'and'", "'or'", "'xor'", "'implies'", "'.'", "'->'", "'?.'", "'?->'", "'Map'", "'Tuple'", "'Boolean'", "'Integer'", "'Real'", "'String'", "'UnlimitedNatural'", "'OclAny'", "'OclInvalid'", "'OclVoid'", "'Set'", "'Bag'", "'Sequence'", "'Collection'", "'OrderedSet'", "'('", "')'", "'Lambda'", "','", "':'", "'{'", "'}'", "'..'", "'++'", "'<-'", "'true'", "'false'", "'invalid'", "'null'", "'@'", "'pre'", "'['", "']'", "'in'", "'|'", "';'", "'if'", "'then'", "'else'", "'endif'", "'elseif'", "'let'", "'self'", "'|?'", "'|1'", "'?'", "'::'", "'extends'", "'&&'"
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
    public static final int T__83=83;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:868:1: ruleCollectionTypeCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleComplexTypeCS ) ) otherlv_3= ')' )? ) ;
    public final EObject ruleCollectionTypeCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:871:28: ( ( ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleComplexTypeCS ) ) otherlv_3= ')' )? ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:872:1: ( ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleComplexTypeCS ) ) otherlv_3= ')' )? )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:872:1: ( ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleComplexTypeCS ) ) otherlv_3= ')' )? )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:872:2: ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleComplexTypeCS ) ) otherlv_3= ')' )?
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:890:2: (otherlv_1= '(' ( (lv_ownedType_2_0= ruleComplexTypeCS ) ) otherlv_3= ')' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==50) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:890:4: otherlv_1= '(' ( (lv_ownedType_2_0= ruleComplexTypeCS ) ) otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,50,FollowSets000.FOLLOW_50_in_ruleCollectionTypeCS2418); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getCollectionTypeCSAccess().getLeftParenthesisKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:894:1: ( (lv_ownedType_2_0= ruleComplexTypeCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:895:1: (lv_ownedType_2_0= ruleComplexTypeCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:895:1: (lv_ownedType_2_0= ruleComplexTypeCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:896:3: lv_ownedType_2_0= ruleComplexTypeCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionTypeCSAccess().getOwnedTypeComplexTypeCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleComplexTypeCS_in_ruleCollectionTypeCS2439);
                    lv_ownedType_2_0=ruleComplexTypeCS();

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
                              		"ComplexTypeCS");
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


    // $ANTLR start "entryRuleCollectionTypeWithMultiplicityCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:924:1: entryRuleCollectionTypeWithMultiplicityCS returns [EObject current=null] : iv_ruleCollectionTypeWithMultiplicityCS= ruleCollectionTypeWithMultiplicityCS EOF ;
    public final EObject entryRuleCollectionTypeWithMultiplicityCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionTypeWithMultiplicityCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:925:2: (iv_ruleCollectionTypeWithMultiplicityCS= ruleCollectionTypeWithMultiplicityCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:926:2: iv_ruleCollectionTypeWithMultiplicityCS= ruleCollectionTypeWithMultiplicityCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCollectionTypeWithMultiplicityCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleCollectionTypeWithMultiplicityCS_in_entryRuleCollectionTypeWithMultiplicityCS2489);
            iv_ruleCollectionTypeWithMultiplicityCS=ruleCollectionTypeWithMultiplicityCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCollectionTypeWithMultiplicityCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCollectionTypeWithMultiplicityCS2499); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCollectionTypeWithMultiplicityCS"


    // $ANTLR start "ruleCollectionTypeWithMultiplicityCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:933:1: ruleCollectionTypeWithMultiplicityCS returns [EObject current=null] : (this_CollectionTypeCS_0= ruleCollectionTypeCS ( (lv_ownedMultiplicity_1_0= ruleMultiplicityCS ) )? ) ;
    public final EObject ruleCollectionTypeWithMultiplicityCS() throws RecognitionException {
        EObject current = null;

        EObject this_CollectionTypeCS_0 = null;

        EObject lv_ownedMultiplicity_1_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:936:28: ( (this_CollectionTypeCS_0= ruleCollectionTypeCS ( (lv_ownedMultiplicity_1_0= ruleMultiplicityCS ) )? ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:937:1: (this_CollectionTypeCS_0= ruleCollectionTypeCS ( (lv_ownedMultiplicity_1_0= ruleMultiplicityCS ) )? )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:937:1: (this_CollectionTypeCS_0= ruleCollectionTypeCS ( (lv_ownedMultiplicity_1_0= ruleMultiplicityCS ) )? )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:938:2: this_CollectionTypeCS_0= ruleCollectionTypeCS ( (lv_ownedMultiplicity_1_0= ruleMultiplicityCS ) )?
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getCollectionTypeWithMultiplicityCSAccess().getCollectionTypeCSParserRuleCall_0()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleCollectionTypeCS_in_ruleCollectionTypeWithMultiplicityCS2549);
            this_CollectionTypeCS_0=ruleCollectionTypeCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_CollectionTypeCS_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:949:1: ( (lv_ownedMultiplicity_1_0= ruleMultiplicityCS ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==66) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:950:1: (lv_ownedMultiplicity_1_0= ruleMultiplicityCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:950:1: (lv_ownedMultiplicity_1_0= ruleMultiplicityCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:951:3: lv_ownedMultiplicity_1_0= ruleMultiplicityCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionTypeWithMultiplicityCSAccess().getOwnedMultiplicityMultiplicityCSParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMultiplicityCS_in_ruleCollectionTypeWithMultiplicityCS2569);
                    lv_ownedMultiplicity_1_0=ruleMultiplicityCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getCollectionTypeWithMultiplicityCSRule());
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
    // $ANTLR end "ruleCollectionTypeWithMultiplicityCS"


    // $ANTLR start "entryRuleLambdaTypeCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:975:1: entryRuleLambdaTypeCS returns [EObject current=null] : iv_ruleLambdaTypeCS= ruleLambdaTypeCS EOF ;
    public final EObject entryRuleLambdaTypeCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLambdaTypeCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:976:2: (iv_ruleLambdaTypeCS= ruleLambdaTypeCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:977:2: iv_ruleLambdaTypeCS= ruleLambdaTypeCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLambdaTypeCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLambdaTypeCS_in_entryRuleLambdaTypeCS2606);
            iv_ruleLambdaTypeCS=ruleLambdaTypeCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLambdaTypeCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLambdaTypeCS2616); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLambdaTypeCS"


    // $ANTLR start "ruleLambdaTypeCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:984:1: ruleLambdaTypeCS returns [EObject current=null] : ( ( (lv_name_0_0= 'Lambda' ) ) ( (lv_ownedSignature_1_0= ruleTemplateSignatureCS ) )? otherlv_2= '(' ( ( (lv_ownedParameterTypes_3_0= ruleComplexTypeCS ) ) (otherlv_4= ',' ( (lv_ownedParameterTypes_5_0= ruleComplexTypeCS ) ) )* )? otherlv_6= ')' otherlv_7= ':' ( (lv_ownedResultType_8_0= ruleComplexTypeCS ) ) ) ;
    public final EObject ruleLambdaTypeCS() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        EObject lv_ownedSignature_1_0 = null;

        EObject lv_ownedParameterTypes_3_0 = null;

        EObject lv_ownedParameterTypes_5_0 = null;

        EObject lv_ownedResultType_8_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:987:28: ( ( ( (lv_name_0_0= 'Lambda' ) ) ( (lv_ownedSignature_1_0= ruleTemplateSignatureCS ) )? otherlv_2= '(' ( ( (lv_ownedParameterTypes_3_0= ruleComplexTypeCS ) ) (otherlv_4= ',' ( (lv_ownedParameterTypes_5_0= ruleComplexTypeCS ) ) )* )? otherlv_6= ')' otherlv_7= ':' ( (lv_ownedResultType_8_0= ruleComplexTypeCS ) ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:988:1: ( ( (lv_name_0_0= 'Lambda' ) ) ( (lv_ownedSignature_1_0= ruleTemplateSignatureCS ) )? otherlv_2= '(' ( ( (lv_ownedParameterTypes_3_0= ruleComplexTypeCS ) ) (otherlv_4= ',' ( (lv_ownedParameterTypes_5_0= ruleComplexTypeCS ) ) )* )? otherlv_6= ')' otherlv_7= ':' ( (lv_ownedResultType_8_0= ruleComplexTypeCS ) ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:988:1: ( ( (lv_name_0_0= 'Lambda' ) ) ( (lv_ownedSignature_1_0= ruleTemplateSignatureCS ) )? otherlv_2= '(' ( ( (lv_ownedParameterTypes_3_0= ruleComplexTypeCS ) ) (otherlv_4= ',' ( (lv_ownedParameterTypes_5_0= ruleComplexTypeCS ) ) )* )? otherlv_6= ')' otherlv_7= ':' ( (lv_ownedResultType_8_0= ruleComplexTypeCS ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:988:2: ( (lv_name_0_0= 'Lambda' ) ) ( (lv_ownedSignature_1_0= ruleTemplateSignatureCS ) )? otherlv_2= '(' ( ( (lv_ownedParameterTypes_3_0= ruleComplexTypeCS ) ) (otherlv_4= ',' ( (lv_ownedParameterTypes_5_0= ruleComplexTypeCS ) ) )* )? otherlv_6= ')' otherlv_7= ':' ( (lv_ownedResultType_8_0= ruleComplexTypeCS ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:988:2: ( (lv_name_0_0= 'Lambda' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:989:1: (lv_name_0_0= 'Lambda' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:989:1: (lv_name_0_0= 'Lambda' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:990:3: lv_name_0_0= 'Lambda'
            {
            lv_name_0_0=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleLambdaTypeCS2659); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      newLeafNode(lv_name_0_0, grammarAccess.getLambdaTypeCSAccess().getNameLambdaKeyword_0_0());
                  
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getLambdaTypeCSRule());
              	        }
                     		setWithLastConsumed(current, "name", lv_name_0_0, "Lambda");
              	    
            }

            }


            }

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1003:2: ( (lv_ownedSignature_1_0= ruleTemplateSignatureCS ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==22) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1004:1: (lv_ownedSignature_1_0= ruleTemplateSignatureCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1004:1: (lv_ownedSignature_1_0= ruleTemplateSignatureCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1005:3: lv_ownedSignature_1_0= ruleTemplateSignatureCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLambdaTypeCSAccess().getOwnedSignatureTemplateSignatureCSParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTemplateSignatureCS_in_ruleLambdaTypeCS2693);
                    lv_ownedSignature_1_0=ruleTemplateSignatureCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getLambdaTypeCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedSignature",
                              		lv_ownedSignature_1_0, 
                              		"TemplateSignatureCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,50,FollowSets000.FOLLOW_50_in_ruleLambdaTypeCS2706); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getLambdaTypeCSAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1025:1: ( ( (lv_ownedParameterTypes_3_0= ruleComplexTypeCS ) ) (otherlv_4= ',' ( (lv_ownedParameterTypes_5_0= ruleComplexTypeCS ) ) )* )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( ((LA13_0>=RULE_SIMPLE_ID && LA13_0<=RULE_ESCAPED_ID)||(LA13_0>=35 && LA13_0<=49)||LA13_0==52) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1025:2: ( (lv_ownedParameterTypes_3_0= ruleComplexTypeCS ) ) (otherlv_4= ',' ( (lv_ownedParameterTypes_5_0= ruleComplexTypeCS ) ) )*
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1025:2: ( (lv_ownedParameterTypes_3_0= ruleComplexTypeCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1026:1: (lv_ownedParameterTypes_3_0= ruleComplexTypeCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1026:1: (lv_ownedParameterTypes_3_0= ruleComplexTypeCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1027:3: lv_ownedParameterTypes_3_0= ruleComplexTypeCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLambdaTypeCSAccess().getOwnedParameterTypesComplexTypeCSParserRuleCall_3_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleComplexTypeCS_in_ruleLambdaTypeCS2728);
                    lv_ownedParameterTypes_3_0=ruleComplexTypeCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getLambdaTypeCSRule());
                      	        }
                             		add(
                             			current, 
                             			"ownedParameterTypes",
                              		lv_ownedParameterTypes_3_0, 
                              		"ComplexTypeCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1043:2: (otherlv_4= ',' ( (lv_ownedParameterTypes_5_0= ruleComplexTypeCS ) ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==53) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1043:4: otherlv_4= ',' ( (lv_ownedParameterTypes_5_0= ruleComplexTypeCS ) )
                    	    {
                    	    otherlv_4=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleLambdaTypeCS2741); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_4, grammarAccess.getLambdaTypeCSAccess().getCommaKeyword_3_1_0());
                    	          
                    	    }
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1047:1: ( (lv_ownedParameterTypes_5_0= ruleComplexTypeCS ) )
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1048:1: (lv_ownedParameterTypes_5_0= ruleComplexTypeCS )
                    	    {
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1048:1: (lv_ownedParameterTypes_5_0= ruleComplexTypeCS )
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1049:3: lv_ownedParameterTypes_5_0= ruleComplexTypeCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getLambdaTypeCSAccess().getOwnedParameterTypesComplexTypeCSParserRuleCall_3_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleComplexTypeCS_in_ruleLambdaTypeCS2762);
                    	    lv_ownedParameterTypes_5_0=ruleComplexTypeCS();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getLambdaTypeCSRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"ownedParameterTypes",
                    	              		lv_ownedParameterTypes_5_0, 
                    	              		"ComplexTypeCS");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,51,FollowSets000.FOLLOW_51_in_ruleLambdaTypeCS2778); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getLambdaTypeCSAccess().getRightParenthesisKeyword_4());
                  
            }
            otherlv_7=(Token)match(input,54,FollowSets000.FOLLOW_54_in_ruleLambdaTypeCS2790); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getLambdaTypeCSAccess().getColonKeyword_5());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1073:1: ( (lv_ownedResultType_8_0= ruleComplexTypeCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1074:1: (lv_ownedResultType_8_0= ruleComplexTypeCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1074:1: (lv_ownedResultType_8_0= ruleComplexTypeCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1075:3: lv_ownedResultType_8_0= ruleComplexTypeCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLambdaTypeCSAccess().getOwnedResultTypeComplexTypeCSParserRuleCall_6_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleComplexTypeCS_in_ruleLambdaTypeCS2811);
            lv_ownedResultType_8_0=ruleComplexTypeCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLambdaTypeCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedResultType",
                      		lv_ownedResultType_8_0, 
                      		"ComplexTypeCS");
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
    // $ANTLR end "ruleLambdaTypeCS"


    // $ANTLR start "entryRuleMapTypeCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1099:1: entryRuleMapTypeCS returns [EObject current=null] : iv_ruleMapTypeCS= ruleMapTypeCS EOF ;
    public final EObject entryRuleMapTypeCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMapTypeCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1100:2: (iv_ruleMapTypeCS= ruleMapTypeCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1101:2: iv_ruleMapTypeCS= ruleMapTypeCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMapTypeCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMapTypeCS_in_entryRuleMapTypeCS2847);
            iv_ruleMapTypeCS=ruleMapTypeCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMapTypeCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMapTypeCS2857); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1108:1: ruleMapTypeCS returns [EObject current=null] : ( ( (lv_name_0_0= 'Map' ) ) (otherlv_1= '(' ( (lv_ownedKeyType_2_0= ruleComplexTypeCS ) ) otherlv_3= ',' ( (lv_ownedValueType_4_0= ruleComplexTypeCS ) ) otherlv_5= ')' )? ) ;
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
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1111:28: ( ( ( (lv_name_0_0= 'Map' ) ) (otherlv_1= '(' ( (lv_ownedKeyType_2_0= ruleComplexTypeCS ) ) otherlv_3= ',' ( (lv_ownedValueType_4_0= ruleComplexTypeCS ) ) otherlv_5= ')' )? ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1112:1: ( ( (lv_name_0_0= 'Map' ) ) (otherlv_1= '(' ( (lv_ownedKeyType_2_0= ruleComplexTypeCS ) ) otherlv_3= ',' ( (lv_ownedValueType_4_0= ruleComplexTypeCS ) ) otherlv_5= ')' )? )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1112:1: ( ( (lv_name_0_0= 'Map' ) ) (otherlv_1= '(' ( (lv_ownedKeyType_2_0= ruleComplexTypeCS ) ) otherlv_3= ',' ( (lv_ownedValueType_4_0= ruleComplexTypeCS ) ) otherlv_5= ')' )? )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1112:2: ( (lv_name_0_0= 'Map' ) ) (otherlv_1= '(' ( (lv_ownedKeyType_2_0= ruleComplexTypeCS ) ) otherlv_3= ',' ( (lv_ownedValueType_4_0= ruleComplexTypeCS ) ) otherlv_5= ')' )?
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1112:2: ( (lv_name_0_0= 'Map' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1113:1: (lv_name_0_0= 'Map' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1113:1: (lv_name_0_0= 'Map' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1114:3: lv_name_0_0= 'Map'
            {
            lv_name_0_0=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleMapTypeCS2900); if (state.failed) return current;
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1127:2: (otherlv_1= '(' ( (lv_ownedKeyType_2_0= ruleComplexTypeCS ) ) otherlv_3= ',' ( (lv_ownedValueType_4_0= ruleComplexTypeCS ) ) otherlv_5= ')' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==50) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1127:4: otherlv_1= '(' ( (lv_ownedKeyType_2_0= ruleComplexTypeCS ) ) otherlv_3= ',' ( (lv_ownedValueType_4_0= ruleComplexTypeCS ) ) otherlv_5= ')'
                    {
                    otherlv_1=(Token)match(input,50,FollowSets000.FOLLOW_50_in_ruleMapTypeCS2926); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getMapTypeCSAccess().getLeftParenthesisKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1131:1: ( (lv_ownedKeyType_2_0= ruleComplexTypeCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1132:1: (lv_ownedKeyType_2_0= ruleComplexTypeCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1132:1: (lv_ownedKeyType_2_0= ruleComplexTypeCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1133:3: lv_ownedKeyType_2_0= ruleComplexTypeCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMapTypeCSAccess().getOwnedKeyTypeComplexTypeCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleComplexTypeCS_in_ruleMapTypeCS2947);
                    lv_ownedKeyType_2_0=ruleComplexTypeCS();

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
                              		"ComplexTypeCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_3=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleMapTypeCS2959); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getMapTypeCSAccess().getCommaKeyword_1_2());
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1153:1: ( (lv_ownedValueType_4_0= ruleComplexTypeCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1154:1: (lv_ownedValueType_4_0= ruleComplexTypeCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1154:1: (lv_ownedValueType_4_0= ruleComplexTypeCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1155:3: lv_ownedValueType_4_0= ruleComplexTypeCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMapTypeCSAccess().getOwnedValueTypeComplexTypeCSParserRuleCall_1_3_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleComplexTypeCS_in_ruleMapTypeCS2980);
                    lv_ownedValueType_4_0=ruleComplexTypeCS();

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
                              		"ComplexTypeCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_5=(Token)match(input,51,FollowSets000.FOLLOW_51_in_ruleMapTypeCS2992); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1183:1: entryRuleTupleTypeCS returns [EObject current=null] : iv_ruleTupleTypeCS= ruleTupleTypeCS EOF ;
    public final EObject entryRuleTupleTypeCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTupleTypeCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1184:2: (iv_ruleTupleTypeCS= ruleTupleTypeCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1185:2: iv_ruleTupleTypeCS= ruleTupleTypeCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTupleTypeCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTupleTypeCS_in_entryRuleTupleTypeCS3030);
            iv_ruleTupleTypeCS=ruleTupleTypeCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTupleTypeCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTupleTypeCS3040); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1192:1: ruleTupleTypeCS returns [EObject current=null] : ( ( (lv_name_0_0= 'Tuple' ) ) (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )? ) ;
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
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1195:28: ( ( ( (lv_name_0_0= 'Tuple' ) ) (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )? ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1196:1: ( ( (lv_name_0_0= 'Tuple' ) ) (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )? )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1196:1: ( ( (lv_name_0_0= 'Tuple' ) ) (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )? )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1196:2: ( (lv_name_0_0= 'Tuple' ) ) (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )?
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1196:2: ( (lv_name_0_0= 'Tuple' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1197:1: (lv_name_0_0= 'Tuple' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1197:1: (lv_name_0_0= 'Tuple' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1198:3: lv_name_0_0= 'Tuple'
            {
            lv_name_0_0=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleTupleTypeCS3083); if (state.failed) return current;
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1211:2: (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==50) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1211:4: otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')'
                    {
                    otherlv_1=(Token)match(input,50,FollowSets000.FOLLOW_50_in_ruleTupleTypeCS3109); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getTupleTypeCSAccess().getLeftParenthesisKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1215:1: ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( ((LA16_0>=RULE_SIMPLE_ID && LA16_0<=RULE_ESCAPED_ID)) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1215:2: ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )*
                            {
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1215:2: ( (lv_ownedParts_2_0= ruleTuplePartCS ) )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1216:1: (lv_ownedParts_2_0= ruleTuplePartCS )
                            {
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1216:1: (lv_ownedParts_2_0= ruleTuplePartCS )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1217:3: lv_ownedParts_2_0= ruleTuplePartCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getTupleTypeCSAccess().getOwnedPartsTuplePartCSParserRuleCall_1_1_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleTuplePartCS_in_ruleTupleTypeCS3131);
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

                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1233:2: (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )*
                            loop15:
                            do {
                                int alt15=2;
                                int LA15_0 = input.LA(1);

                                if ( (LA15_0==53) ) {
                                    alt15=1;
                                }


                                switch (alt15) {
                            	case 1 :
                            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1233:4: otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) )
                            	    {
                            	    otherlv_3=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleTupleTypeCS3144); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_3, grammarAccess.getTupleTypeCSAccess().getCommaKeyword_1_1_1_0());
                            	          
                            	    }
                            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1237:1: ( (lv_ownedParts_4_0= ruleTuplePartCS ) )
                            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1238:1: (lv_ownedParts_4_0= ruleTuplePartCS )
                            	    {
                            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1238:1: (lv_ownedParts_4_0= ruleTuplePartCS )
                            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1239:3: lv_ownedParts_4_0= ruleTuplePartCS
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getTupleTypeCSAccess().getOwnedPartsTuplePartCSParserRuleCall_1_1_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FollowSets000.FOLLOW_ruleTuplePartCS_in_ruleTupleTypeCS3165);
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
                            	    break loop15;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_5=(Token)match(input,51,FollowSets000.FOLLOW_51_in_ruleTupleTypeCS3181); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1267:1: entryRuleTuplePartCS returns [EObject current=null] : iv_ruleTuplePartCS= ruleTuplePartCS EOF ;
    public final EObject entryRuleTuplePartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTuplePartCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1268:2: (iv_ruleTuplePartCS= ruleTuplePartCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1269:2: iv_ruleTuplePartCS= ruleTuplePartCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTuplePartCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTuplePartCS_in_entryRuleTuplePartCS3219);
            iv_ruleTuplePartCS=ruleTuplePartCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTuplePartCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTuplePartCS3229); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1276:1: ruleTuplePartCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleComplexTypeCS ) ) ) ;
    public final EObject ruleTuplePartCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1279:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleComplexTypeCS ) ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1280:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleComplexTypeCS ) ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1280:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleComplexTypeCS ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1280:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleComplexTypeCS ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1280:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1281:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1281:1: (lv_name_0_0= ruleUnrestrictedName )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1282:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTuplePartCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleTuplePartCS3275);
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

            otherlv_1=(Token)match(input,54,FollowSets000.FOLLOW_54_in_ruleTuplePartCS3287); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getTuplePartCSAccess().getColonKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1302:1: ( (lv_ownedType_2_0= ruleComplexTypeCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1303:1: (lv_ownedType_2_0= ruleComplexTypeCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1303:1: (lv_ownedType_2_0= ruleComplexTypeCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1304:3: lv_ownedType_2_0= ruleComplexTypeCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTuplePartCSAccess().getOwnedTypeComplexTypeCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleComplexTypeCS_in_ruleTuplePartCS3308);
            lv_ownedType_2_0=ruleComplexTypeCS();

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
                      		"ComplexTypeCS");
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


    // $ANTLR start "entryRuleSimpleTypeCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1328:1: entryRuleSimpleTypeCS returns [EObject current=null] : iv_ruleSimpleTypeCS= ruleSimpleTypeCS EOF ;
    public final EObject entryRuleSimpleTypeCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleTypeCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1329:2: (iv_ruleSimpleTypeCS= ruleSimpleTypeCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1330:2: iv_ruleSimpleTypeCS= ruleSimpleTypeCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSimpleTypeCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSimpleTypeCS_in_entryRuleSimpleTypeCS3344);
            iv_ruleSimpleTypeCS=ruleSimpleTypeCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSimpleTypeCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSimpleTypeCS3354); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSimpleTypeCS"


    // $ANTLR start "ruleSimpleTypeCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1337:1: ruleSimpleTypeCS returns [EObject current=null] : (this_TypeLiteralCS_0= ruleTypeLiteralCS | this_PathTypeCS_1= rulePathTypeCS ) ;
    public final EObject ruleSimpleTypeCS() throws RecognitionException {
        EObject current = null;

        EObject this_TypeLiteralCS_0 = null;

        EObject this_PathTypeCS_1 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1340:28: ( (this_TypeLiteralCS_0= ruleTypeLiteralCS | this_PathTypeCS_1= rulePathTypeCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1341:1: (this_TypeLiteralCS_0= ruleTypeLiteralCS | this_PathTypeCS_1= rulePathTypeCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1341:1: (this_TypeLiteralCS_0= ruleTypeLiteralCS | this_PathTypeCS_1= rulePathTypeCS )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( ((LA18_0>=35 && LA18_0<=49)) ) {
                alt18=1;
            }
            else if ( ((LA18_0>=RULE_SIMPLE_ID && LA18_0<=RULE_ESCAPED_ID)) ) {
                alt18=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1342:2: this_TypeLiteralCS_0= ruleTypeLiteralCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getSimpleTypeCSAccess().getTypeLiteralCSParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralCS_in_ruleSimpleTypeCS3404);
                    this_TypeLiteralCS_0=ruleTypeLiteralCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_TypeLiteralCS_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1355:2: this_PathTypeCS_1= rulePathTypeCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getSimpleTypeCSAccess().getPathTypeCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePathTypeCS_in_ruleSimpleTypeCS3434);
                    this_PathTypeCS_1=rulePathTypeCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_PathTypeCS_1; 
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
    // $ANTLR end "ruleSimpleTypeCS"


    // $ANTLR start "entryRuleComplexTypeCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1374:1: entryRuleComplexTypeCS returns [EObject current=null] : iv_ruleComplexTypeCS= ruleComplexTypeCS EOF ;
    public final EObject entryRuleComplexTypeCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComplexTypeCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1375:2: (iv_ruleComplexTypeCS= ruleComplexTypeCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1376:2: iv_ruleComplexTypeCS= ruleComplexTypeCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getComplexTypeCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleComplexTypeCS_in_entryRuleComplexTypeCS3469);
            iv_ruleComplexTypeCS=ruleComplexTypeCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleComplexTypeCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleComplexTypeCS3479); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleComplexTypeCS"


    // $ANTLR start "ruleComplexTypeCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1383:1: ruleComplexTypeCS returns [EObject current=null] : (this_TypeLiteralWithMultiplicityCS_0= ruleTypeLiteralWithMultiplicityCS | (this_PathTypeCS_1= rulePathTypeCS ( (lv_ownedMultiplicity_2_0= ruleMultiplicityCS ) )? ) ) ;
    public final EObject ruleComplexTypeCS() throws RecognitionException {
        EObject current = null;

        EObject this_TypeLiteralWithMultiplicityCS_0 = null;

        EObject this_PathTypeCS_1 = null;

        EObject lv_ownedMultiplicity_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1386:28: ( (this_TypeLiteralWithMultiplicityCS_0= ruleTypeLiteralWithMultiplicityCS | (this_PathTypeCS_1= rulePathTypeCS ( (lv_ownedMultiplicity_2_0= ruleMultiplicityCS ) )? ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1387:1: (this_TypeLiteralWithMultiplicityCS_0= ruleTypeLiteralWithMultiplicityCS | (this_PathTypeCS_1= rulePathTypeCS ( (lv_ownedMultiplicity_2_0= ruleMultiplicityCS ) )? ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1387:1: (this_TypeLiteralWithMultiplicityCS_0= ruleTypeLiteralWithMultiplicityCS | (this_PathTypeCS_1= rulePathTypeCS ( (lv_ownedMultiplicity_2_0= ruleMultiplicityCS ) )? ) )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( ((LA20_0>=35 && LA20_0<=49)||LA20_0==52) ) {
                alt20=1;
            }
            else if ( ((LA20_0>=RULE_SIMPLE_ID && LA20_0<=RULE_ESCAPED_ID)) ) {
                alt20=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1388:2: this_TypeLiteralWithMultiplicityCS_0= ruleTypeLiteralWithMultiplicityCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getComplexTypeCSAccess().getTypeLiteralWithMultiplicityCSParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralWithMultiplicityCS_in_ruleComplexTypeCS3529);
                    this_TypeLiteralWithMultiplicityCS_0=ruleTypeLiteralWithMultiplicityCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_TypeLiteralWithMultiplicityCS_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1400:6: (this_PathTypeCS_1= rulePathTypeCS ( (lv_ownedMultiplicity_2_0= ruleMultiplicityCS ) )? )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1400:6: (this_PathTypeCS_1= rulePathTypeCS ( (lv_ownedMultiplicity_2_0= ruleMultiplicityCS ) )? )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1401:2: this_PathTypeCS_1= rulePathTypeCS ( (lv_ownedMultiplicity_2_0= ruleMultiplicityCS ) )?
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getComplexTypeCSAccess().getPathTypeCSParserRuleCall_1_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePathTypeCS_in_ruleComplexTypeCS3560);
                    this_PathTypeCS_1=rulePathTypeCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_PathTypeCS_1; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1412:1: ( (lv_ownedMultiplicity_2_0= ruleMultiplicityCS ) )?
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==66) ) {
                        alt19=1;
                    }
                    switch (alt19) {
                        case 1 :
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1413:1: (lv_ownedMultiplicity_2_0= ruleMultiplicityCS )
                            {
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1413:1: (lv_ownedMultiplicity_2_0= ruleMultiplicityCS )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1414:3: lv_ownedMultiplicity_2_0= ruleMultiplicityCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getComplexTypeCSAccess().getOwnedMultiplicityMultiplicityCSParserRuleCall_1_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleMultiplicityCS_in_ruleComplexTypeCS3580);
                            lv_ownedMultiplicity_2_0=ruleMultiplicityCS();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getComplexTypeCSRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"ownedMultiplicity",
                                      		lv_ownedMultiplicity_2_0, 
                                      		"MultiplicityCS");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }
                            break;

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
    // $ANTLR end "ruleComplexTypeCS"


    // $ANTLR start "entryRuleCollectionLiteralExpCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1438:1: entryRuleCollectionLiteralExpCS returns [EObject current=null] : iv_ruleCollectionLiteralExpCS= ruleCollectionLiteralExpCS EOF ;
    public final EObject entryRuleCollectionLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1439:2: (iv_ruleCollectionLiteralExpCS= ruleCollectionLiteralExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1440:2: iv_ruleCollectionLiteralExpCS= ruleCollectionLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCollectionLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteralExpCS_in_entryRuleCollectionLiteralExpCS3618);
            iv_ruleCollectionLiteralExpCS=ruleCollectionLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCollectionLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCollectionLiteralExpCS3628); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1447:1: ruleCollectionLiteralExpCS returns [EObject current=null] : ( ( (lv_ownedType_0_0= ruleCollectionTypeWithMultiplicityCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}' ) ;
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
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1450:28: ( ( ( (lv_ownedType_0_0= ruleCollectionTypeWithMultiplicityCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1451:1: ( ( (lv_ownedType_0_0= ruleCollectionTypeWithMultiplicityCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1451:1: ( ( (lv_ownedType_0_0= ruleCollectionTypeWithMultiplicityCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1451:2: ( (lv_ownedType_0_0= ruleCollectionTypeWithMultiplicityCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}'
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1451:2: ( (lv_ownedType_0_0= ruleCollectionTypeWithMultiplicityCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1452:1: (lv_ownedType_0_0= ruleCollectionTypeWithMultiplicityCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1452:1: (lv_ownedType_0_0= ruleCollectionTypeWithMultiplicityCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1453:3: lv_ownedType_0_0= ruleCollectionTypeWithMultiplicityCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedTypeCollectionTypeWithMultiplicityCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleCollectionTypeWithMultiplicityCS_in_ruleCollectionLiteralExpCS3674);
            lv_ownedType_0_0=ruleCollectionTypeWithMultiplicityCS();

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
                      		"CollectionTypeWithMultiplicityCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleCollectionLiteralExpCS3686); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getCollectionLiteralExpCSAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1473:1: ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( ((LA22_0>=RULE_SIMPLE_ID && LA22_0<=RULE_SINGLE_QUOTED_STRING)||(LA22_0>=16 && LA22_0<=18)||(LA22_0>=35 && LA22_0<=50)||LA22_0==52||LA22_0==54||(LA22_0>=60 && LA22_0<=63)||LA22_0==71||(LA22_0>=76 && LA22_0<=77)) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1473:2: ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )*
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1473:2: ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1474:1: (lv_ownedParts_2_0= ruleCollectionLiteralPartCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1474:1: (lv_ownedParts_2_0= ruleCollectionLiteralPartCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1475:3: lv_ownedParts_2_0= ruleCollectionLiteralPartCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedPartsCollectionLiteralPartCSParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteralPartCS_in_ruleCollectionLiteralExpCS3708);
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

                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1491:2: (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )*
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0==53) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1491:4: otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) )
                    	    {
                    	    otherlv_3=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleCollectionLiteralExpCS3721); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getCollectionLiteralExpCSAccess().getCommaKeyword_2_1_0());
                    	          
                    	    }
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1495:1: ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) )
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1496:1: (lv_ownedParts_4_0= ruleCollectionLiteralPartCS )
                    	    {
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1496:1: (lv_ownedParts_4_0= ruleCollectionLiteralPartCS )
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1497:3: lv_ownedParts_4_0= ruleCollectionLiteralPartCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedPartsCollectionLiteralPartCSParserRuleCall_2_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteralPartCS_in_ruleCollectionLiteralExpCS3742);
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
                    	    break loop21;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,56,FollowSets000.FOLLOW_56_in_ruleCollectionLiteralExpCS3758); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1525:1: entryRuleCollectionLiteralPartCS returns [EObject current=null] : iv_ruleCollectionLiteralPartCS= ruleCollectionLiteralPartCS EOF ;
    public final EObject entryRuleCollectionLiteralPartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionLiteralPartCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1526:2: (iv_ruleCollectionLiteralPartCS= ruleCollectionLiteralPartCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1527:2: iv_ruleCollectionLiteralPartCS= ruleCollectionLiteralPartCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCollectionLiteralPartCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteralPartCS_in_entryRuleCollectionLiteralPartCS3794);
            iv_ruleCollectionLiteralPartCS=ruleCollectionLiteralPartCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCollectionLiteralPartCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCollectionLiteralPartCS3804); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1534:1: ruleCollectionLiteralPartCS returns [EObject current=null] : ( ( ( (lv_ownedExpression_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_ownedLastExpression_2_0= ruleExpCS ) ) )? ) | ( (lv_ownedExpression_3_0= rulePatternExpCS ) ) ) ;
    public final EObject ruleCollectionLiteralPartCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_ownedExpression_0_0 = null;

        EObject lv_ownedLastExpression_2_0 = null;

        EObject lv_ownedExpression_3_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1537:28: ( ( ( ( (lv_ownedExpression_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_ownedLastExpression_2_0= ruleExpCS ) ) )? ) | ( (lv_ownedExpression_3_0= rulePatternExpCS ) ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1538:1: ( ( ( (lv_ownedExpression_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_ownedLastExpression_2_0= ruleExpCS ) ) )? ) | ( (lv_ownedExpression_3_0= rulePatternExpCS ) ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1538:1: ( ( ( (lv_ownedExpression_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_ownedLastExpression_2_0= ruleExpCS ) ) )? ) | ( (lv_ownedExpression_3_0= rulePatternExpCS ) ) )
            int alt24=2;
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
            case 52:
            case 60:
            case 61:
            case 62:
            case 63:
            case 71:
            case 76:
            case 77:
                {
                alt24=1;
                }
                break;
            case RULE_SIMPLE_ID:
                {
                int LA24_2 = input.LA(2);

                if ( (LA24_2==54) ) {
                    alt24=2;
                }
                else if ( (LA24_2==EOF||LA24_2==16||(LA24_2>=18 && LA24_2<=34)||LA24_2==50||LA24_2==53||(LA24_2>=55 && LA24_2<=57)||LA24_2==64||LA24_2==66||LA24_2==81) ) {
                    alt24=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 24, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_ESCAPED_ID:
                {
                int LA24_3 = input.LA(2);

                if ( (LA24_3==EOF||LA24_3==16||(LA24_3>=18 && LA24_3<=34)||LA24_3==50||LA24_3==53||(LA24_3>=55 && LA24_3<=57)||LA24_3==64||LA24_3==66||LA24_3==81) ) {
                    alt24=1;
                }
                else if ( (LA24_3==54) ) {
                    alt24=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 24, 3, input);

                    throw nvae;
                }
                }
                break;
            case 54:
                {
                alt24=2;
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1538:2: ( ( (lv_ownedExpression_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_ownedLastExpression_2_0= ruleExpCS ) ) )? )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1538:2: ( ( (lv_ownedExpression_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_ownedLastExpression_2_0= ruleExpCS ) ) )? )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1538:3: ( (lv_ownedExpression_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_ownedLastExpression_2_0= ruleExpCS ) ) )?
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1538:3: ( (lv_ownedExpression_0_0= ruleExpCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1539:1: (lv_ownedExpression_0_0= ruleExpCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1539:1: (lv_ownedExpression_0_0= ruleExpCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1540:3: lv_ownedExpression_0_0= ruleExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionLiteralPartCSAccess().getOwnedExpressionExpCSParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleCollectionLiteralPartCS3851);
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

                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1556:2: (otherlv_1= '..' ( (lv_ownedLastExpression_2_0= ruleExpCS ) ) )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0==57) ) {
                        alt23=1;
                    }
                    switch (alt23) {
                        case 1 :
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1556:4: otherlv_1= '..' ( (lv_ownedLastExpression_2_0= ruleExpCS ) )
                            {
                            otherlv_1=(Token)match(input,57,FollowSets000.FOLLOW_57_in_ruleCollectionLiteralPartCS3864); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_1, grammarAccess.getCollectionLiteralPartCSAccess().getFullStopFullStopKeyword_0_1_0());
                                  
                            }
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1560:1: ( (lv_ownedLastExpression_2_0= ruleExpCS ) )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1561:1: (lv_ownedLastExpression_2_0= ruleExpCS )
                            {
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1561:1: (lv_ownedLastExpression_2_0= ruleExpCS )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1562:3: lv_ownedLastExpression_2_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getCollectionLiteralPartCSAccess().getOwnedLastExpressionExpCSParserRuleCall_0_1_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleCollectionLiteralPartCS3885);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1579:6: ( (lv_ownedExpression_3_0= rulePatternExpCS ) )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1579:6: ( (lv_ownedExpression_3_0= rulePatternExpCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1580:1: (lv_ownedExpression_3_0= rulePatternExpCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1580:1: (lv_ownedExpression_3_0= rulePatternExpCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1581:3: lv_ownedExpression_3_0= rulePatternExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionLiteralPartCSAccess().getOwnedExpressionPatternExpCSParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePatternExpCS_in_ruleCollectionLiteralPartCS3915);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1605:1: entryRuleCollectionPatternCS returns [EObject current=null] : iv_ruleCollectionPatternCS= ruleCollectionPatternCS EOF ;
    public final EObject entryRuleCollectionPatternCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionPatternCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1606:2: (iv_ruleCollectionPatternCS= ruleCollectionPatternCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1607:2: iv_ruleCollectionPatternCS= ruleCollectionPatternCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCollectionPatternCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleCollectionPatternCS_in_entryRuleCollectionPatternCS3951);
            iv_ruleCollectionPatternCS=ruleCollectionPatternCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCollectionPatternCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCollectionPatternCS3961); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1614:1: ruleCollectionPatternCS returns [EObject current=null] : ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= rulePatternExpCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= rulePatternExpCS ) ) )* (otherlv_5= '++' ( (lv_restVariableName_6_0= ruleIdentifier ) ) ) )? otherlv_7= '}' ) ;
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
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1617:28: ( ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= rulePatternExpCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= rulePatternExpCS ) ) )* (otherlv_5= '++' ( (lv_restVariableName_6_0= ruleIdentifier ) ) ) )? otherlv_7= '}' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1618:1: ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= rulePatternExpCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= rulePatternExpCS ) ) )* (otherlv_5= '++' ( (lv_restVariableName_6_0= ruleIdentifier ) ) ) )? otherlv_7= '}' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1618:1: ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= rulePatternExpCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= rulePatternExpCS ) ) )* (otherlv_5= '++' ( (lv_restVariableName_6_0= ruleIdentifier ) ) ) )? otherlv_7= '}' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1618:2: ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= rulePatternExpCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= rulePatternExpCS ) ) )* (otherlv_5= '++' ( (lv_restVariableName_6_0= ruleIdentifier ) ) ) )? otherlv_7= '}'
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1618:2: ( (lv_ownedType_0_0= ruleCollectionTypeCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1619:1: (lv_ownedType_0_0= ruleCollectionTypeCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1619:1: (lv_ownedType_0_0= ruleCollectionTypeCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1620:3: lv_ownedType_0_0= ruleCollectionTypeCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCollectionPatternCSAccess().getOwnedTypeCollectionTypeCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleCollectionTypeCS_in_ruleCollectionPatternCS4007);
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

            otherlv_1=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleCollectionPatternCS4019); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getCollectionPatternCSAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1640:1: ( ( (lv_ownedParts_2_0= rulePatternExpCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= rulePatternExpCS ) ) )* (otherlv_5= '++' ( (lv_restVariableName_6_0= ruleIdentifier ) ) ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( ((LA26_0>=RULE_SIMPLE_ID && LA26_0<=RULE_ESCAPED_ID)||LA26_0==54) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1640:2: ( (lv_ownedParts_2_0= rulePatternExpCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= rulePatternExpCS ) ) )* (otherlv_5= '++' ( (lv_restVariableName_6_0= ruleIdentifier ) ) )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1640:2: ( (lv_ownedParts_2_0= rulePatternExpCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1641:1: (lv_ownedParts_2_0= rulePatternExpCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1641:1: (lv_ownedParts_2_0= rulePatternExpCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1642:3: lv_ownedParts_2_0= rulePatternExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionPatternCSAccess().getOwnedPartsPatternExpCSParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePatternExpCS_in_ruleCollectionPatternCS4041);
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

                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1658:2: (otherlv_3= ',' ( (lv_ownedParts_4_0= rulePatternExpCS ) ) )*
                    loop25:
                    do {
                        int alt25=2;
                        int LA25_0 = input.LA(1);

                        if ( (LA25_0==53) ) {
                            alt25=1;
                        }


                        switch (alt25) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1658:4: otherlv_3= ',' ( (lv_ownedParts_4_0= rulePatternExpCS ) )
                    	    {
                    	    otherlv_3=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleCollectionPatternCS4054); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getCollectionPatternCSAccess().getCommaKeyword_2_1_0());
                    	          
                    	    }
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1662:1: ( (lv_ownedParts_4_0= rulePatternExpCS ) )
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1663:1: (lv_ownedParts_4_0= rulePatternExpCS )
                    	    {
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1663:1: (lv_ownedParts_4_0= rulePatternExpCS )
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1664:3: lv_ownedParts_4_0= rulePatternExpCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getCollectionPatternCSAccess().getOwnedPartsPatternExpCSParserRuleCall_2_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_rulePatternExpCS_in_ruleCollectionPatternCS4075);
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
                    	    break loop25;
                        }
                    } while (true);

                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1680:4: (otherlv_5= '++' ( (lv_restVariableName_6_0= ruleIdentifier ) ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1680:6: otherlv_5= '++' ( (lv_restVariableName_6_0= ruleIdentifier ) )
                    {
                    otherlv_5=(Token)match(input,58,FollowSets000.FOLLOW_58_in_ruleCollectionPatternCS4090); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getCollectionPatternCSAccess().getPlusSignPlusSignKeyword_2_2_0());
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1684:1: ( (lv_restVariableName_6_0= ruleIdentifier ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1685:1: (lv_restVariableName_6_0= ruleIdentifier )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1685:1: (lv_restVariableName_6_0= ruleIdentifier )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1686:3: lv_restVariableName_6_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionPatternCSAccess().getRestVariableNameIdentifierParserRuleCall_2_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_ruleCollectionPatternCS4111);
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

            otherlv_7=(Token)match(input,56,FollowSets000.FOLLOW_56_in_ruleCollectionPatternCS4126); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1714:1: entryRuleShadowPartCS returns [EObject current=null] : iv_ruleShadowPartCS= ruleShadowPartCS EOF ;
    public final EObject entryRuleShadowPartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleShadowPartCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1715:2: (iv_ruleShadowPartCS= ruleShadowPartCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1716:2: iv_ruleShadowPartCS= ruleShadowPartCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getShadowPartCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleShadowPartCS_in_entryRuleShadowPartCS4162);
            iv_ruleShadowPartCS=ruleShadowPartCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleShadowPartCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleShadowPartCS4172); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1723:1: ruleShadowPartCS returns [EObject current=null] : ( ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( ( (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS ) ) ) ) ;
    public final EObject ruleShadowPartCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_ownedInitExpression_2_1 = null;

        EObject lv_ownedInitExpression_2_2 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1726:28: ( ( ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( ( (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS ) ) ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1727:1: ( ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( ( (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS ) ) ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1727:1: ( ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( ( (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS ) ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1727:2: ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( ( (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS ) ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1727:2: ( ( ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1728:1: ( ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1728:1: ( ruleUnrestrictedName )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1729:3: ruleUnrestrictedName
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
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleShadowPartCS4224);
            ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleShadowPartCS4236); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getShadowPartCSAccess().getEqualsSignKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1749:1: ( ( (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1750:1: ( (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1750:1: ( (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1751:1: (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1751:1: (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS )
            int alt27=2;
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
            case 52:
            case 60:
            case 61:
            case 62:
            case 63:
            case 71:
            case 76:
            case 77:
                {
                alt27=1;
                }
                break;
            case RULE_SIMPLE_ID:
                {
                int LA27_2 = input.LA(2);

                if ( (LA27_2==54) ) {
                    alt27=2;
                }
                else if ( (LA27_2==EOF||LA27_2==16||(LA27_2>=18 && LA27_2<=34)||LA27_2==50||LA27_2==53||(LA27_2>=55 && LA27_2<=56)||LA27_2==64||LA27_2==66||LA27_2==81) ) {
                    alt27=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 27, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_ESCAPED_ID:
                {
                int LA27_3 = input.LA(2);

                if ( (LA27_3==54) ) {
                    alt27=2;
                }
                else if ( (LA27_3==EOF||LA27_3==16||(LA27_3>=18 && LA27_3<=34)||LA27_3==50||LA27_3==53||(LA27_3>=55 && LA27_3<=56)||LA27_3==64||LA27_3==66||LA27_3==81) ) {
                    alt27=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 27, 3, input);

                    throw nvae;
                }
                }
                break;
            case 54:
                {
                alt27=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }

            switch (alt27) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1752:3: lv_ownedInitExpression_2_1= ruleExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getShadowPartCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleShadowPartCS4259);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1767:8: lv_ownedInitExpression_2_2= rulePatternExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getShadowPartCSAccess().getOwnedInitExpressionPatternExpCSParserRuleCall_2_0_1()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePatternExpCS_in_ruleShadowPartCS4278);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1793:1: entryRulePatternExpCS returns [EObject current=null] : iv_rulePatternExpCS= rulePatternExpCS EOF ;
    public final EObject entryRulePatternExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePatternExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1794:2: (iv_rulePatternExpCS= rulePatternExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1795:2: iv_rulePatternExpCS= rulePatternExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPatternExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePatternExpCS_in_entryRulePatternExpCS4317);
            iv_rulePatternExpCS=rulePatternExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePatternExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePatternExpCS4327); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1802:1: rulePatternExpCS returns [EObject current=null] : ( ( (lv_patternVariableName_0_0= ruleUnrestrictedName ) )? otherlv_1= ':' ( (lv_ownedPatternType_2_0= ruleTypeExpCS ) ) ) ;
    public final EObject rulePatternExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_patternVariableName_0_0 = null;

        EObject lv_ownedPatternType_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1805:28: ( ( ( (lv_patternVariableName_0_0= ruleUnrestrictedName ) )? otherlv_1= ':' ( (lv_ownedPatternType_2_0= ruleTypeExpCS ) ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1806:1: ( ( (lv_patternVariableName_0_0= ruleUnrestrictedName ) )? otherlv_1= ':' ( (lv_ownedPatternType_2_0= ruleTypeExpCS ) ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1806:1: ( ( (lv_patternVariableName_0_0= ruleUnrestrictedName ) )? otherlv_1= ':' ( (lv_ownedPatternType_2_0= ruleTypeExpCS ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1806:2: ( (lv_patternVariableName_0_0= ruleUnrestrictedName ) )? otherlv_1= ':' ( (lv_ownedPatternType_2_0= ruleTypeExpCS ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1806:2: ( (lv_patternVariableName_0_0= ruleUnrestrictedName ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( ((LA28_0>=RULE_SIMPLE_ID && LA28_0<=RULE_ESCAPED_ID)) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1807:1: (lv_patternVariableName_0_0= ruleUnrestrictedName )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1807:1: (lv_patternVariableName_0_0= ruleUnrestrictedName )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1808:3: lv_patternVariableName_0_0= ruleUnrestrictedName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPatternExpCSAccess().getPatternVariableNameUnrestrictedNameParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_rulePatternExpCS4373);
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

            otherlv_1=(Token)match(input,54,FollowSets000.FOLLOW_54_in_rulePatternExpCS4386); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getPatternExpCSAccess().getColonKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1828:1: ( (lv_ownedPatternType_2_0= ruleTypeExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1829:1: (lv_ownedPatternType_2_0= ruleTypeExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1829:1: (lv_ownedPatternType_2_0= ruleTypeExpCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1830:3: lv_ownedPatternType_2_0= ruleTypeExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPatternExpCSAccess().getOwnedPatternTypeTypeExpCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_rulePatternExpCS4407);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1854:1: entryRuleLambdaLiteralExpCS returns [EObject current=null] : iv_ruleLambdaLiteralExpCS= ruleLambdaLiteralExpCS EOF ;
    public final EObject entryRuleLambdaLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLambdaLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1855:2: (iv_ruleLambdaLiteralExpCS= ruleLambdaLiteralExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1856:2: iv_ruleLambdaLiteralExpCS= ruleLambdaLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLambdaLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLambdaLiteralExpCS_in_entryRuleLambdaLiteralExpCS4443);
            iv_ruleLambdaLiteralExpCS=ruleLambdaLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLambdaLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLambdaLiteralExpCS4453); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1863:1: ruleLambdaLiteralExpCS returns [EObject current=null] : ( ( (lv_name_0_0= 'Lambda' ) ) otherlv_1= '(' ( ( (lv_ownedParameters_2_0= ruleLambdaParameterCS ) ) (otherlv_3= ',' ( (lv_ownedParameters_4_0= ruleLambdaParameterCS ) ) )* )? otherlv_5= ')' otherlv_6= ':' ( (lv_ownedType_7_0= ruleComplexTypeCS ) ) otherlv_8= '{' ( (lv_ownedExpression_9_0= ruleExpCS ) ) otherlv_10= '}' ) ;
    public final EObject ruleLambdaLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject lv_ownedParameters_2_0 = null;

        EObject lv_ownedParameters_4_0 = null;

        EObject lv_ownedType_7_0 = null;

        EObject lv_ownedExpression_9_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1866:28: ( ( ( (lv_name_0_0= 'Lambda' ) ) otherlv_1= '(' ( ( (lv_ownedParameters_2_0= ruleLambdaParameterCS ) ) (otherlv_3= ',' ( (lv_ownedParameters_4_0= ruleLambdaParameterCS ) ) )* )? otherlv_5= ')' otherlv_6= ':' ( (lv_ownedType_7_0= ruleComplexTypeCS ) ) otherlv_8= '{' ( (lv_ownedExpression_9_0= ruleExpCS ) ) otherlv_10= '}' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1867:1: ( ( (lv_name_0_0= 'Lambda' ) ) otherlv_1= '(' ( ( (lv_ownedParameters_2_0= ruleLambdaParameterCS ) ) (otherlv_3= ',' ( (lv_ownedParameters_4_0= ruleLambdaParameterCS ) ) )* )? otherlv_5= ')' otherlv_6= ':' ( (lv_ownedType_7_0= ruleComplexTypeCS ) ) otherlv_8= '{' ( (lv_ownedExpression_9_0= ruleExpCS ) ) otherlv_10= '}' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1867:1: ( ( (lv_name_0_0= 'Lambda' ) ) otherlv_1= '(' ( ( (lv_ownedParameters_2_0= ruleLambdaParameterCS ) ) (otherlv_3= ',' ( (lv_ownedParameters_4_0= ruleLambdaParameterCS ) ) )* )? otherlv_5= ')' otherlv_6= ':' ( (lv_ownedType_7_0= ruleComplexTypeCS ) ) otherlv_8= '{' ( (lv_ownedExpression_9_0= ruleExpCS ) ) otherlv_10= '}' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1867:2: ( (lv_name_0_0= 'Lambda' ) ) otherlv_1= '(' ( ( (lv_ownedParameters_2_0= ruleLambdaParameterCS ) ) (otherlv_3= ',' ( (lv_ownedParameters_4_0= ruleLambdaParameterCS ) ) )* )? otherlv_5= ')' otherlv_6= ':' ( (lv_ownedType_7_0= ruleComplexTypeCS ) ) otherlv_8= '{' ( (lv_ownedExpression_9_0= ruleExpCS ) ) otherlv_10= '}'
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1867:2: ( (lv_name_0_0= 'Lambda' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1868:1: (lv_name_0_0= 'Lambda' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1868:1: (lv_name_0_0= 'Lambda' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1869:3: lv_name_0_0= 'Lambda'
            {
            lv_name_0_0=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleLambdaLiteralExpCS4496); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      newLeafNode(lv_name_0_0, grammarAccess.getLambdaLiteralExpCSAccess().getNameLambdaKeyword_0_0());
                  
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getLambdaLiteralExpCSRule());
              	        }
                     		setWithLastConsumed(current, "name", lv_name_0_0, "Lambda");
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,50,FollowSets000.FOLLOW_50_in_ruleLambdaLiteralExpCS4521); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getLambdaLiteralExpCSAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1886:1: ( ( (lv_ownedParameters_2_0= ruleLambdaParameterCS ) ) (otherlv_3= ',' ( (lv_ownedParameters_4_0= ruleLambdaParameterCS ) ) )* )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( ((LA30_0>=RULE_SIMPLE_ID && LA30_0<=RULE_ESCAPED_ID)) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1886:2: ( (lv_ownedParameters_2_0= ruleLambdaParameterCS ) ) (otherlv_3= ',' ( (lv_ownedParameters_4_0= ruleLambdaParameterCS ) ) )*
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1886:2: ( (lv_ownedParameters_2_0= ruleLambdaParameterCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1887:1: (lv_ownedParameters_2_0= ruleLambdaParameterCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1887:1: (lv_ownedParameters_2_0= ruleLambdaParameterCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1888:3: lv_ownedParameters_2_0= ruleLambdaParameterCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLambdaLiteralExpCSAccess().getOwnedParametersLambdaParameterCSParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLambdaParameterCS_in_ruleLambdaLiteralExpCS4543);
                    lv_ownedParameters_2_0=ruleLambdaParameterCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getLambdaLiteralExpCSRule());
                      	        }
                             		add(
                             			current, 
                             			"ownedParameters",
                              		lv_ownedParameters_2_0, 
                              		"LambdaParameterCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1904:2: (otherlv_3= ',' ( (lv_ownedParameters_4_0= ruleLambdaParameterCS ) ) )*
                    loop29:
                    do {
                        int alt29=2;
                        int LA29_0 = input.LA(1);

                        if ( (LA29_0==53) ) {
                            alt29=1;
                        }


                        switch (alt29) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1904:4: otherlv_3= ',' ( (lv_ownedParameters_4_0= ruleLambdaParameterCS ) )
                    	    {
                    	    otherlv_3=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleLambdaLiteralExpCS4556); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getLambdaLiteralExpCSAccess().getCommaKeyword_2_1_0());
                    	          
                    	    }
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1908:1: ( (lv_ownedParameters_4_0= ruleLambdaParameterCS ) )
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1909:1: (lv_ownedParameters_4_0= ruleLambdaParameterCS )
                    	    {
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1909:1: (lv_ownedParameters_4_0= ruleLambdaParameterCS )
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1910:3: lv_ownedParameters_4_0= ruleLambdaParameterCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getLambdaLiteralExpCSAccess().getOwnedParametersLambdaParameterCSParserRuleCall_2_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleLambdaParameterCS_in_ruleLambdaLiteralExpCS4577);
                    	    lv_ownedParameters_4_0=ruleLambdaParameterCS();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getLambdaLiteralExpCSRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"ownedParameters",
                    	              		lv_ownedParameters_4_0, 
                    	              		"LambdaParameterCS");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop29;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,51,FollowSets000.FOLLOW_51_in_ruleLambdaLiteralExpCS4593); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getLambdaLiteralExpCSAccess().getRightParenthesisKeyword_3());
                  
            }
            otherlv_6=(Token)match(input,54,FollowSets000.FOLLOW_54_in_ruleLambdaLiteralExpCS4605); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getLambdaLiteralExpCSAccess().getColonKeyword_4());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1934:1: ( (lv_ownedType_7_0= ruleComplexTypeCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1935:1: (lv_ownedType_7_0= ruleComplexTypeCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1935:1: (lv_ownedType_7_0= ruleComplexTypeCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1936:3: lv_ownedType_7_0= ruleComplexTypeCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLambdaLiteralExpCSAccess().getOwnedTypeComplexTypeCSParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleComplexTypeCS_in_ruleLambdaLiteralExpCS4626);
            lv_ownedType_7_0=ruleComplexTypeCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLambdaLiteralExpCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedType",
                      		lv_ownedType_7_0, 
                      		"ComplexTypeCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_8=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleLambdaLiteralExpCS4638); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getLambdaLiteralExpCSAccess().getLeftCurlyBracketKeyword_6());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1956:1: ( (lv_ownedExpression_9_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1957:1: (lv_ownedExpression_9_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1957:1: (lv_ownedExpression_9_0= ruleExpCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1958:3: lv_ownedExpression_9_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLambdaLiteralExpCSAccess().getOwnedExpressionExpCSParserRuleCall_7_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleLambdaLiteralExpCS4659);
            lv_ownedExpression_9_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLambdaLiteralExpCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedExpression",
                      		lv_ownedExpression_9_0, 
                      		"ExpCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_10=(Token)match(input,56,FollowSets000.FOLLOW_56_in_ruleLambdaLiteralExpCS4671); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_10, grammarAccess.getLambdaLiteralExpCSAccess().getRightCurlyBracketKeyword_8());
                  
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


    // $ANTLR start "entryRuleLambdaParameterCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1986:1: entryRuleLambdaParameterCS returns [EObject current=null] : iv_ruleLambdaParameterCS= ruleLambdaParameterCS EOF ;
    public final EObject entryRuleLambdaParameterCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLambdaParameterCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1987:2: (iv_ruleLambdaParameterCS= ruleLambdaParameterCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1988:2: iv_ruleLambdaParameterCS= ruleLambdaParameterCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLambdaParameterCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLambdaParameterCS_in_entryRuleLambdaParameterCS4707);
            iv_ruleLambdaParameterCS=ruleLambdaParameterCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLambdaParameterCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLambdaParameterCS4717); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLambdaParameterCS"


    // $ANTLR start "ruleLambdaParameterCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1995:1: ruleLambdaParameterCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleComplexTypeCS ) ) ) ;
    public final EObject ruleLambdaParameterCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1998:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleComplexTypeCS ) ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1999:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleComplexTypeCS ) ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1999:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleComplexTypeCS ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1999:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleComplexTypeCS ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1999:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2000:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2000:1: (lv_name_0_0= ruleUnrestrictedName )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2001:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLambdaParameterCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleLambdaParameterCS4763);
            lv_name_0_0=ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLambdaParameterCSRule());
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

            otherlv_1=(Token)match(input,54,FollowSets000.FOLLOW_54_in_ruleLambdaParameterCS4775); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getLambdaParameterCSAccess().getColonKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2021:1: ( (lv_ownedType_2_0= ruleComplexTypeCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2022:1: (lv_ownedType_2_0= ruleComplexTypeCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2022:1: (lv_ownedType_2_0= ruleComplexTypeCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2023:3: lv_ownedType_2_0= ruleComplexTypeCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLambdaParameterCSAccess().getOwnedTypeComplexTypeCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleComplexTypeCS_in_ruleLambdaParameterCS4796);
            lv_ownedType_2_0=ruleComplexTypeCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLambdaParameterCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedType",
                      		lv_ownedType_2_0, 
                      		"ComplexTypeCS");
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
    // $ANTLR end "ruleLambdaParameterCS"


    // $ANTLR start "entryRuleMapLiteralExpCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2047:1: entryRuleMapLiteralExpCS returns [EObject current=null] : iv_ruleMapLiteralExpCS= ruleMapLiteralExpCS EOF ;
    public final EObject entryRuleMapLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMapLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2048:2: (iv_ruleMapLiteralExpCS= ruleMapLiteralExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2049:2: iv_ruleMapLiteralExpCS= ruleMapLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMapLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMapLiteralExpCS_in_entryRuleMapLiteralExpCS4832);
            iv_ruleMapLiteralExpCS=ruleMapLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMapLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMapLiteralExpCS4842); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2056:1: ruleMapLiteralExpCS returns [EObject current=null] : ( ( (lv_ownedType_0_0= ruleMapTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleMapLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) ) )* )? otherlv_5= '}' ) ;
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
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2059:28: ( ( ( (lv_ownedType_0_0= ruleMapTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleMapLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) ) )* )? otherlv_5= '}' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2060:1: ( ( (lv_ownedType_0_0= ruleMapTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleMapLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) ) )* )? otherlv_5= '}' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2060:1: ( ( (lv_ownedType_0_0= ruleMapTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleMapLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) ) )* )? otherlv_5= '}' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2060:2: ( (lv_ownedType_0_0= ruleMapTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleMapLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) ) )* )? otherlv_5= '}'
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2060:2: ( (lv_ownedType_0_0= ruleMapTypeCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2061:1: (lv_ownedType_0_0= ruleMapTypeCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2061:1: (lv_ownedType_0_0= ruleMapTypeCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2062:3: lv_ownedType_0_0= ruleMapTypeCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMapLiteralExpCSAccess().getOwnedTypeMapTypeCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleMapTypeCS_in_ruleMapLiteralExpCS4888);
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

            otherlv_1=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleMapLiteralExpCS4900); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getMapLiteralExpCSAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2082:1: ( ( (lv_ownedParts_2_0= ruleMapLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) ) )* )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( ((LA32_0>=RULE_SIMPLE_ID && LA32_0<=RULE_SINGLE_QUOTED_STRING)||(LA32_0>=16 && LA32_0<=18)||(LA32_0>=35 && LA32_0<=50)||LA32_0==52||(LA32_0>=60 && LA32_0<=63)||LA32_0==71||(LA32_0>=76 && LA32_0<=77)) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2082:2: ( (lv_ownedParts_2_0= ruleMapLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) ) )*
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2082:2: ( (lv_ownedParts_2_0= ruleMapLiteralPartCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2083:1: (lv_ownedParts_2_0= ruleMapLiteralPartCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2083:1: (lv_ownedParts_2_0= ruleMapLiteralPartCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2084:3: lv_ownedParts_2_0= ruleMapLiteralPartCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMapLiteralExpCSAccess().getOwnedPartsMapLiteralPartCSParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMapLiteralPartCS_in_ruleMapLiteralExpCS4922);
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

                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2100:2: (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) ) )*
                    loop31:
                    do {
                        int alt31=2;
                        int LA31_0 = input.LA(1);

                        if ( (LA31_0==53) ) {
                            alt31=1;
                        }


                        switch (alt31) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2100:4: otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) )
                    	    {
                    	    otherlv_3=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleMapLiteralExpCS4935); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getMapLiteralExpCSAccess().getCommaKeyword_2_1_0());
                    	          
                    	    }
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2104:1: ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) )
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2105:1: (lv_ownedParts_4_0= ruleMapLiteralPartCS )
                    	    {
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2105:1: (lv_ownedParts_4_0= ruleMapLiteralPartCS )
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2106:3: lv_ownedParts_4_0= ruleMapLiteralPartCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getMapLiteralExpCSAccess().getOwnedPartsMapLiteralPartCSParserRuleCall_2_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleMapLiteralPartCS_in_ruleMapLiteralExpCS4956);
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
                    	    break loop31;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,56,FollowSets000.FOLLOW_56_in_ruleMapLiteralExpCS4972); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2134:1: entryRuleMapLiteralPartCS returns [EObject current=null] : iv_ruleMapLiteralPartCS= ruleMapLiteralPartCS EOF ;
    public final EObject entryRuleMapLiteralPartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMapLiteralPartCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2135:2: (iv_ruleMapLiteralPartCS= ruleMapLiteralPartCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2136:2: iv_ruleMapLiteralPartCS= ruleMapLiteralPartCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMapLiteralPartCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMapLiteralPartCS_in_entryRuleMapLiteralPartCS5008);
            iv_ruleMapLiteralPartCS=ruleMapLiteralPartCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMapLiteralPartCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMapLiteralPartCS5018); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2143:1: ruleMapLiteralPartCS returns [EObject current=null] : ( ( (lv_ownedKey_0_0= ruleExpCS ) ) otherlv_1= '<-' ( (lv_ownedValue_2_0= ruleExpCS ) ) ) ;
    public final EObject ruleMapLiteralPartCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_ownedKey_0_0 = null;

        EObject lv_ownedValue_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2146:28: ( ( ( (lv_ownedKey_0_0= ruleExpCS ) ) otherlv_1= '<-' ( (lv_ownedValue_2_0= ruleExpCS ) ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2147:1: ( ( (lv_ownedKey_0_0= ruleExpCS ) ) otherlv_1= '<-' ( (lv_ownedValue_2_0= ruleExpCS ) ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2147:1: ( ( (lv_ownedKey_0_0= ruleExpCS ) ) otherlv_1= '<-' ( (lv_ownedValue_2_0= ruleExpCS ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2147:2: ( (lv_ownedKey_0_0= ruleExpCS ) ) otherlv_1= '<-' ( (lv_ownedValue_2_0= ruleExpCS ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2147:2: ( (lv_ownedKey_0_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2148:1: (lv_ownedKey_0_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2148:1: (lv_ownedKey_0_0= ruleExpCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2149:3: lv_ownedKey_0_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMapLiteralPartCSAccess().getOwnedKeyExpCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleMapLiteralPartCS5064);
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

            otherlv_1=(Token)match(input,59,FollowSets000.FOLLOW_59_in_ruleMapLiteralPartCS5076); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getMapLiteralPartCSAccess().getLessThanSignHyphenMinusKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2169:1: ( (lv_ownedValue_2_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2170:1: (lv_ownedValue_2_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2170:1: (lv_ownedValue_2_0= ruleExpCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2171:3: lv_ownedValue_2_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMapLiteralPartCSAccess().getOwnedValueExpCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleMapLiteralPartCS5097);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2195:1: entryRulePrimitiveLiteralExpCS returns [EObject current=null] : iv_rulePrimitiveLiteralExpCS= rulePrimitiveLiteralExpCS EOF ;
    public final EObject entryRulePrimitiveLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2196:2: (iv_rulePrimitiveLiteralExpCS= rulePrimitiveLiteralExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2197:2: iv_rulePrimitiveLiteralExpCS= rulePrimitiveLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePrimitiveLiteralExpCS_in_entryRulePrimitiveLiteralExpCS5133);
            iv_rulePrimitiveLiteralExpCS=rulePrimitiveLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimitiveLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrimitiveLiteralExpCS5143); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2204:1: rulePrimitiveLiteralExpCS returns [EObject current=null] : (this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS | this_StringLiteralExpCS_1= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_5= ruleNullLiteralExpCS ) ;
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
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2207:28: ( (this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS | this_StringLiteralExpCS_1= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_5= ruleNullLiteralExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2208:1: (this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS | this_StringLiteralExpCS_1= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_5= ruleNullLiteralExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2208:1: (this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS | this_StringLiteralExpCS_1= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_5= ruleNullLiteralExpCS )
            int alt33=6;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt33=1;
                }
                break;
            case RULE_SINGLE_QUOTED_STRING:
                {
                alt33=2;
                }
                break;
            case 60:
            case 61:
                {
                alt33=3;
                }
                break;
            case 18:
                {
                alt33=4;
                }
                break;
            case 62:
                {
                alt33=5;
                }
                break;
            case 63:
                {
                alt33=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }

            switch (alt33) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2209:2: this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getNumberLiteralExpCSParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNumberLiteralExpCS_in_rulePrimitiveLiteralExpCS5193);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2222:2: this_StringLiteralExpCS_1= ruleStringLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getStringLiteralExpCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleStringLiteralExpCS_in_rulePrimitiveLiteralExpCS5223);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2235:2: this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getBooleanLiteralExpCSParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleBooleanLiteralExpCS_in_rulePrimitiveLiteralExpCS5253);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2248:2: this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getUnlimitedNaturalLiteralExpCSParserRuleCall_3()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUnlimitedNaturalLiteralExpCS_in_rulePrimitiveLiteralExpCS5283);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2261:2: this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getInvalidLiteralExpCSParserRuleCall_4()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleInvalidLiteralExpCS_in_rulePrimitiveLiteralExpCS5313);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2274:2: this_NullLiteralExpCS_5= ruleNullLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getNullLiteralExpCSParserRuleCall_5()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNullLiteralExpCS_in_rulePrimitiveLiteralExpCS5343);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2293:1: entryRuleTupleLiteralExpCS returns [EObject current=null] : iv_ruleTupleLiteralExpCS= ruleTupleLiteralExpCS EOF ;
    public final EObject entryRuleTupleLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTupleLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2294:2: (iv_ruleTupleLiteralExpCS= ruleTupleLiteralExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2295:2: iv_ruleTupleLiteralExpCS= ruleTupleLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTupleLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralExpCS_in_entryRuleTupleLiteralExpCS5378);
            iv_ruleTupleLiteralExpCS=ruleTupleLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTupleLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTupleLiteralExpCS5388); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2302:1: ruleTupleLiteralExpCS returns [EObject current=null] : (otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}' ) ;
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
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2305:28: ( (otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2306:1: (otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2306:1: (otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2306:3: otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleTupleLiteralExpCS5425); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getTupleLiteralExpCSAccess().getTupleKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleTupleLiteralExpCS5437); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getTupleLiteralExpCSAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2314:1: ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2315:1: (lv_ownedParts_2_0= ruleTupleLiteralPartCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2315:1: (lv_ownedParts_2_0= ruleTupleLiteralPartCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2316:3: lv_ownedParts_2_0= ruleTupleLiteralPartCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTupleLiteralExpCSAccess().getOwnedPartsTupleLiteralPartCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralPartCS_in_ruleTupleLiteralExpCS5458);
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2332:2: (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==53) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2332:4: otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) )
            	    {
            	    otherlv_3=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleTupleLiteralExpCS5471); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getTupleLiteralExpCSAccess().getCommaKeyword_3_0());
            	          
            	    }
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2336:1: ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) )
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2337:1: (lv_ownedParts_4_0= ruleTupleLiteralPartCS )
            	    {
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2337:1: (lv_ownedParts_4_0= ruleTupleLiteralPartCS )
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2338:3: lv_ownedParts_4_0= ruleTupleLiteralPartCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTupleLiteralExpCSAccess().getOwnedPartsTupleLiteralPartCSParserRuleCall_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralPartCS_in_ruleTupleLiteralExpCS5492);
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
            	    break loop34;
                }
            } while (true);

            otherlv_5=(Token)match(input,56,FollowSets000.FOLLOW_56_in_ruleTupleLiteralExpCS5506); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2366:1: entryRuleTupleLiteralPartCS returns [EObject current=null] : iv_ruleTupleLiteralPartCS= ruleTupleLiteralPartCS EOF ;
    public final EObject entryRuleTupleLiteralPartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTupleLiteralPartCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2367:2: (iv_ruleTupleLiteralPartCS= ruleTupleLiteralPartCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2368:2: iv_ruleTupleLiteralPartCS= ruleTupleLiteralPartCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTupleLiteralPartCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralPartCS_in_entryRuleTupleLiteralPartCS5542);
            iv_ruleTupleLiteralPartCS=ruleTupleLiteralPartCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTupleLiteralPartCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTupleLiteralPartCS5552); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2375:1: ruleTupleLiteralPartCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleComplexTypeCS ) ) )? otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) ) ;
    public final EObject ruleTupleLiteralPartCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;

        EObject lv_ownedInitExpression_4_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2378:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleComplexTypeCS ) ) )? otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2379:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleComplexTypeCS ) ) )? otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2379:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleComplexTypeCS ) ) )? otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2379:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleComplexTypeCS ) ) )? otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2379:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2380:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2380:1: (lv_name_0_0= ruleUnrestrictedName )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2381:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTupleLiteralPartCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleTupleLiteralPartCS5598);
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2397:2: (otherlv_1= ':' ( (lv_ownedType_2_0= ruleComplexTypeCS ) ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==54) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2397:4: otherlv_1= ':' ( (lv_ownedType_2_0= ruleComplexTypeCS ) )
                    {
                    otherlv_1=(Token)match(input,54,FollowSets000.FOLLOW_54_in_ruleTupleLiteralPartCS5611); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getTupleLiteralPartCSAccess().getColonKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2401:1: ( (lv_ownedType_2_0= ruleComplexTypeCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2402:1: (lv_ownedType_2_0= ruleComplexTypeCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2402:1: (lv_ownedType_2_0= ruleComplexTypeCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2403:3: lv_ownedType_2_0= ruleComplexTypeCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTupleLiteralPartCSAccess().getOwnedTypeComplexTypeCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleComplexTypeCS_in_ruleTupleLiteralPartCS5632);
                    lv_ownedType_2_0=ruleComplexTypeCS();

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
                              		"ComplexTypeCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleTupleLiteralPartCS5646); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getTupleLiteralPartCSAccess().getEqualsSignKeyword_2());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2423:1: ( (lv_ownedInitExpression_4_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2424:1: (lv_ownedInitExpression_4_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2424:1: (lv_ownedInitExpression_4_0= ruleExpCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2425:3: lv_ownedInitExpression_4_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTupleLiteralPartCSAccess().getOwnedInitExpressionExpCSParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleTupleLiteralPartCS5667);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2449:1: entryRuleNumberLiteralExpCS returns [EObject current=null] : iv_ruleNumberLiteralExpCS= ruleNumberLiteralExpCS EOF ;
    public final EObject entryRuleNumberLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2450:2: (iv_ruleNumberLiteralExpCS= ruleNumberLiteralExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2451:2: iv_ruleNumberLiteralExpCS= ruleNumberLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumberLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNumberLiteralExpCS_in_entryRuleNumberLiteralExpCS5703);
            iv_ruleNumberLiteralExpCS=ruleNumberLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumberLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNumberLiteralExpCS5713); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2458:1: ruleNumberLiteralExpCS returns [EObject current=null] : ( (lv_symbol_0_0= ruleNUMBER_LITERAL ) ) ;
    public final EObject ruleNumberLiteralExpCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_symbol_0_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2461:28: ( ( (lv_symbol_0_0= ruleNUMBER_LITERAL ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2462:1: ( (lv_symbol_0_0= ruleNUMBER_LITERAL ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2462:1: ( (lv_symbol_0_0= ruleNUMBER_LITERAL ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2463:1: (lv_symbol_0_0= ruleNUMBER_LITERAL )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2463:1: (lv_symbol_0_0= ruleNUMBER_LITERAL )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2464:3: lv_symbol_0_0= ruleNUMBER_LITERAL
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNumberLiteralExpCSAccess().getSymbolNUMBER_LITERALParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleNUMBER_LITERAL_in_ruleNumberLiteralExpCS5758);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2488:1: entryRuleStringLiteralExpCS returns [EObject current=null] : iv_ruleStringLiteralExpCS= ruleStringLiteralExpCS EOF ;
    public final EObject entryRuleStringLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2489:2: (iv_ruleStringLiteralExpCS= ruleStringLiteralExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2490:2: iv_ruleStringLiteralExpCS= ruleStringLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStringLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleStringLiteralExpCS_in_entryRuleStringLiteralExpCS5793);
            iv_ruleStringLiteralExpCS=ruleStringLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStringLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleStringLiteralExpCS5803); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2497:1: ruleStringLiteralExpCS returns [EObject current=null] : ( (lv_segments_0_0= ruleStringLiteral ) )+ ;
    public final EObject ruleStringLiteralExpCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_segments_0_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2500:28: ( ( (lv_segments_0_0= ruleStringLiteral ) )+ )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2501:1: ( (lv_segments_0_0= ruleStringLiteral ) )+
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2501:1: ( (lv_segments_0_0= ruleStringLiteral ) )+
            int cnt36=0;
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==RULE_SINGLE_QUOTED_STRING) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2502:1: (lv_segments_0_0= ruleStringLiteral )
            	    {
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2502:1: (lv_segments_0_0= ruleStringLiteral )
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2503:3: lv_segments_0_0= ruleStringLiteral
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getStringLiteralExpCSAccess().getSegmentsStringLiteralParserRuleCall_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleStringLiteral_in_ruleStringLiteralExpCS5848);
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
            	    if ( cnt36 >= 1 ) break loop36;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(36, input);
                        throw eee;
                }
                cnt36++;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2527:1: entryRuleBooleanLiteralExpCS returns [EObject current=null] : iv_ruleBooleanLiteralExpCS= ruleBooleanLiteralExpCS EOF ;
    public final EObject entryRuleBooleanLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2528:2: (iv_ruleBooleanLiteralExpCS= ruleBooleanLiteralExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2529:2: iv_ruleBooleanLiteralExpCS= ruleBooleanLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBooleanLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleBooleanLiteralExpCS_in_entryRuleBooleanLiteralExpCS5884);
            iv_ruleBooleanLiteralExpCS=ruleBooleanLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBooleanLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBooleanLiteralExpCS5894); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2536:1: ruleBooleanLiteralExpCS returns [EObject current=null] : ( ( (lv_symbol_0_0= 'true' ) ) | ( (lv_symbol_1_0= 'false' ) ) ) ;
    public final EObject ruleBooleanLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token lv_symbol_0_0=null;
        Token lv_symbol_1_0=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2539:28: ( ( ( (lv_symbol_0_0= 'true' ) ) | ( (lv_symbol_1_0= 'false' ) ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2540:1: ( ( (lv_symbol_0_0= 'true' ) ) | ( (lv_symbol_1_0= 'false' ) ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2540:1: ( ( (lv_symbol_0_0= 'true' ) ) | ( (lv_symbol_1_0= 'false' ) ) )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==60) ) {
                alt37=1;
            }
            else if ( (LA37_0==61) ) {
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2540:2: ( (lv_symbol_0_0= 'true' ) )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2540:2: ( (lv_symbol_0_0= 'true' ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2541:1: (lv_symbol_0_0= 'true' )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2541:1: (lv_symbol_0_0= 'true' )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2542:3: lv_symbol_0_0= 'true'
                    {
                    lv_symbol_0_0=(Token)match(input,60,FollowSets000.FOLLOW_60_in_ruleBooleanLiteralExpCS5937); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2556:6: ( (lv_symbol_1_0= 'false' ) )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2556:6: ( (lv_symbol_1_0= 'false' ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2557:1: (lv_symbol_1_0= 'false' )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2557:1: (lv_symbol_1_0= 'false' )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2558:3: lv_symbol_1_0= 'false'
                    {
                    lv_symbol_1_0=(Token)match(input,61,FollowSets000.FOLLOW_61_in_ruleBooleanLiteralExpCS5974); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2579:1: entryRuleUnlimitedNaturalLiteralExpCS returns [EObject current=null] : iv_ruleUnlimitedNaturalLiteralExpCS= ruleUnlimitedNaturalLiteralExpCS EOF ;
    public final EObject entryRuleUnlimitedNaturalLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnlimitedNaturalLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2580:2: (iv_ruleUnlimitedNaturalLiteralExpCS= ruleUnlimitedNaturalLiteralExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2581:2: iv_ruleUnlimitedNaturalLiteralExpCS= ruleUnlimitedNaturalLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnlimitedNaturalLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnlimitedNaturalLiteralExpCS_in_entryRuleUnlimitedNaturalLiteralExpCS6023);
            iv_ruleUnlimitedNaturalLiteralExpCS=ruleUnlimitedNaturalLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnlimitedNaturalLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnlimitedNaturalLiteralExpCS6033); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2588:1: ruleUnlimitedNaturalLiteralExpCS returns [EObject current=null] : ( () otherlv_1= '*' ) ;
    public final EObject ruleUnlimitedNaturalLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2591:28: ( ( () otherlv_1= '*' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2592:1: ( () otherlv_1= '*' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2592:1: ( () otherlv_1= '*' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2592:2: () otherlv_1= '*'
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2592:2: ()
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2593:2: 
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

            otherlv_1=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleUnlimitedNaturalLiteralExpCS6082); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2613:1: entryRuleInvalidLiteralExpCS returns [EObject current=null] : iv_ruleInvalidLiteralExpCS= ruleInvalidLiteralExpCS EOF ;
    public final EObject entryRuleInvalidLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInvalidLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2614:2: (iv_ruleInvalidLiteralExpCS= ruleInvalidLiteralExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2615:2: iv_ruleInvalidLiteralExpCS= ruleInvalidLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInvalidLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleInvalidLiteralExpCS_in_entryRuleInvalidLiteralExpCS6118);
            iv_ruleInvalidLiteralExpCS=ruleInvalidLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInvalidLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleInvalidLiteralExpCS6128); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2622:1: ruleInvalidLiteralExpCS returns [EObject current=null] : ( () otherlv_1= 'invalid' ) ;
    public final EObject ruleInvalidLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2625:28: ( ( () otherlv_1= 'invalid' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2626:1: ( () otherlv_1= 'invalid' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2626:1: ( () otherlv_1= 'invalid' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2626:2: () otherlv_1= 'invalid'
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2626:2: ()
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2627:2: 
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

            otherlv_1=(Token)match(input,62,FollowSets000.FOLLOW_62_in_ruleInvalidLiteralExpCS6177); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2647:1: entryRuleNullLiteralExpCS returns [EObject current=null] : iv_ruleNullLiteralExpCS= ruleNullLiteralExpCS EOF ;
    public final EObject entryRuleNullLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2648:2: (iv_ruleNullLiteralExpCS= ruleNullLiteralExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2649:2: iv_ruleNullLiteralExpCS= ruleNullLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNullLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNullLiteralExpCS_in_entryRuleNullLiteralExpCS6213);
            iv_ruleNullLiteralExpCS=ruleNullLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNullLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNullLiteralExpCS6223); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2656:1: ruleNullLiteralExpCS returns [EObject current=null] : ( () otherlv_1= 'null' ) ;
    public final EObject ruleNullLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2659:28: ( ( () otherlv_1= 'null' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2660:1: ( () otherlv_1= 'null' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2660:1: ( () otherlv_1= 'null' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2660:2: () otherlv_1= 'null'
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2660:2: ()
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2661:2: 
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

            otherlv_1=(Token)match(input,63,FollowSets000.FOLLOW_63_in_ruleNullLiteralExpCS6272); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2681:1: entryRuleTypeLiteralCS returns [EObject current=null] : iv_ruleTypeLiteralCS= ruleTypeLiteralCS EOF ;
    public final EObject entryRuleTypeLiteralCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeLiteralCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2682:2: (iv_ruleTypeLiteralCS= ruleTypeLiteralCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2683:2: iv_ruleTypeLiteralCS= ruleTypeLiteralCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeLiteralCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralCS_in_entryRuleTypeLiteralCS6308);
            iv_ruleTypeLiteralCS=ruleTypeLiteralCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeLiteralCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeLiteralCS6318); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2690:1: ruleTypeLiteralCS returns [EObject current=null] : (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS | this_CollectionTypeCS_1= ruleCollectionTypeCS | this_MapTypeCS_2= ruleMapTypeCS | this_TupleTypeCS_3= ruleTupleTypeCS ) ;
    public final EObject ruleTypeLiteralCS() throws RecognitionException {
        EObject current = null;

        EObject this_PrimitiveTypeCS_0 = null;

        EObject this_CollectionTypeCS_1 = null;

        EObject this_MapTypeCS_2 = null;

        EObject this_TupleTypeCS_3 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2693:28: ( (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS | this_CollectionTypeCS_1= ruleCollectionTypeCS | this_MapTypeCS_2= ruleMapTypeCS | this_TupleTypeCS_3= ruleTupleTypeCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2694:1: (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS | this_CollectionTypeCS_1= ruleCollectionTypeCS | this_MapTypeCS_2= ruleMapTypeCS | this_TupleTypeCS_3= ruleTupleTypeCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2694:1: (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS | this_CollectionTypeCS_1= ruleCollectionTypeCS | this_MapTypeCS_2= ruleMapTypeCS | this_TupleTypeCS_3= ruleTupleTypeCS )
            int alt38=4;
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
                alt38=1;
                }
                break;
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
                {
                alt38=2;
                }
                break;
            case 35:
                {
                alt38=3;
                }
                break;
            case 36:
                {
                alt38=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }

            switch (alt38) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2695:2: this_PrimitiveTypeCS_0= rulePrimitiveTypeCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeLiteralCSAccess().getPrimitiveTypeCSParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrimitiveTypeCS_in_ruleTypeLiteralCS6368);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2708:2: this_CollectionTypeCS_1= ruleCollectionTypeCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeLiteralCSAccess().getCollectionTypeCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCollectionTypeCS_in_ruleTypeLiteralCS6398);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2721:2: this_MapTypeCS_2= ruleMapTypeCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeLiteralCSAccess().getMapTypeCSParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMapTypeCS_in_ruleTypeLiteralCS6428);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2734:2: this_TupleTypeCS_3= ruleTupleTypeCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeLiteralCSAccess().getTupleTypeCSParserRuleCall_3()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTupleTypeCS_in_ruleTypeLiteralCS6458);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2753:1: entryRuleTypeLiteralWithMultiplicityCS returns [EObject current=null] : iv_ruleTypeLiteralWithMultiplicityCS= ruleTypeLiteralWithMultiplicityCS EOF ;
    public final EObject entryRuleTypeLiteralWithMultiplicityCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeLiteralWithMultiplicityCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2754:2: (iv_ruleTypeLiteralWithMultiplicityCS= ruleTypeLiteralWithMultiplicityCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2755:2: iv_ruleTypeLiteralWithMultiplicityCS= ruleTypeLiteralWithMultiplicityCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeLiteralWithMultiplicityCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralWithMultiplicityCS_in_entryRuleTypeLiteralWithMultiplicityCS6493);
            iv_ruleTypeLiteralWithMultiplicityCS=ruleTypeLiteralWithMultiplicityCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeLiteralWithMultiplicityCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeLiteralWithMultiplicityCS6503); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2762:1: ruleTypeLiteralWithMultiplicityCS returns [EObject current=null] : (this_CollectionTypeWithMultiplicityCS_0= ruleCollectionTypeWithMultiplicityCS | this_LambdaTypeCS_1= ruleLambdaTypeCS | ( (this_PrimitiveTypeCS_2= rulePrimitiveTypeCS | this_MapTypeCS_3= ruleMapTypeCS | this_TupleTypeCS_4= ruleTupleTypeCS ) ( (lv_ownedMultiplicity_5_0= ruleMultiplicityCS ) )? ) ) ;
    public final EObject ruleTypeLiteralWithMultiplicityCS() throws RecognitionException {
        EObject current = null;

        EObject this_CollectionTypeWithMultiplicityCS_0 = null;

        EObject this_LambdaTypeCS_1 = null;

        EObject this_PrimitiveTypeCS_2 = null;

        EObject this_MapTypeCS_3 = null;

        EObject this_TupleTypeCS_4 = null;

        EObject lv_ownedMultiplicity_5_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2765:28: ( (this_CollectionTypeWithMultiplicityCS_0= ruleCollectionTypeWithMultiplicityCS | this_LambdaTypeCS_1= ruleLambdaTypeCS | ( (this_PrimitiveTypeCS_2= rulePrimitiveTypeCS | this_MapTypeCS_3= ruleMapTypeCS | this_TupleTypeCS_4= ruleTupleTypeCS ) ( (lv_ownedMultiplicity_5_0= ruleMultiplicityCS ) )? ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2766:1: (this_CollectionTypeWithMultiplicityCS_0= ruleCollectionTypeWithMultiplicityCS | this_LambdaTypeCS_1= ruleLambdaTypeCS | ( (this_PrimitiveTypeCS_2= rulePrimitiveTypeCS | this_MapTypeCS_3= ruleMapTypeCS | this_TupleTypeCS_4= ruleTupleTypeCS ) ( (lv_ownedMultiplicity_5_0= ruleMultiplicityCS ) )? ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2766:1: (this_CollectionTypeWithMultiplicityCS_0= ruleCollectionTypeWithMultiplicityCS | this_LambdaTypeCS_1= ruleLambdaTypeCS | ( (this_PrimitiveTypeCS_2= rulePrimitiveTypeCS | this_MapTypeCS_3= ruleMapTypeCS | this_TupleTypeCS_4= ruleTupleTypeCS ) ( (lv_ownedMultiplicity_5_0= ruleMultiplicityCS ) )? ) )
            int alt41=3;
            switch ( input.LA(1) ) {
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
                {
                alt41=1;
                }
                break;
            case 52:
                {
                alt41=2;
                }
                break;
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
                {
                alt41=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }

            switch (alt41) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2767:2: this_CollectionTypeWithMultiplicityCS_0= ruleCollectionTypeWithMultiplicityCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeLiteralWithMultiplicityCSAccess().getCollectionTypeWithMultiplicityCSParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCollectionTypeWithMultiplicityCS_in_ruleTypeLiteralWithMultiplicityCS6553);
                    this_CollectionTypeWithMultiplicityCS_0=ruleCollectionTypeWithMultiplicityCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_CollectionTypeWithMultiplicityCS_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2780:2: this_LambdaTypeCS_1= ruleLambdaTypeCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeLiteralWithMultiplicityCSAccess().getLambdaTypeCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLambdaTypeCS_in_ruleTypeLiteralWithMultiplicityCS6583);
                    this_LambdaTypeCS_1=ruleLambdaTypeCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_LambdaTypeCS_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2792:6: ( (this_PrimitiveTypeCS_2= rulePrimitiveTypeCS | this_MapTypeCS_3= ruleMapTypeCS | this_TupleTypeCS_4= ruleTupleTypeCS ) ( (lv_ownedMultiplicity_5_0= ruleMultiplicityCS ) )? )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2792:6: ( (this_PrimitiveTypeCS_2= rulePrimitiveTypeCS | this_MapTypeCS_3= ruleMapTypeCS | this_TupleTypeCS_4= ruleTupleTypeCS ) ( (lv_ownedMultiplicity_5_0= ruleMultiplicityCS ) )? )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2792:7: (this_PrimitiveTypeCS_2= rulePrimitiveTypeCS | this_MapTypeCS_3= ruleMapTypeCS | this_TupleTypeCS_4= ruleTupleTypeCS ) ( (lv_ownedMultiplicity_5_0= ruleMultiplicityCS ) )?
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2792:7: (this_PrimitiveTypeCS_2= rulePrimitiveTypeCS | this_MapTypeCS_3= ruleMapTypeCS | this_TupleTypeCS_4= ruleTupleTypeCS )
                    int alt39=3;
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
                        alt39=1;
                        }
                        break;
                    case 35:
                        {
                        alt39=2;
                        }
                        break;
                    case 36:
                        {
                        alt39=3;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 39, 0, input);

                        throw nvae;
                    }

                    switch (alt39) {
                        case 1 :
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2793:2: this_PrimitiveTypeCS_2= rulePrimitiveTypeCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	  /* */ 
                              	
                            }
                            if ( state.backtracking==0 ) {
                               
                                      newCompositeNode(grammarAccess.getTypeLiteralWithMultiplicityCSAccess().getPrimitiveTypeCSParserRuleCall_2_0_0()); 
                                  
                            }
                            pushFollow(FollowSets000.FOLLOW_rulePrimitiveTypeCS_in_ruleTypeLiteralWithMultiplicityCS6615);
                            this_PrimitiveTypeCS_2=rulePrimitiveTypeCS();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {
                               
                                      current = this_PrimitiveTypeCS_2; 
                                      afterParserOrEnumRuleCall();
                                  
                            }

                            }
                            break;
                        case 2 :
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2806:2: this_MapTypeCS_3= ruleMapTypeCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	  /* */ 
                              	
                            }
                            if ( state.backtracking==0 ) {
                               
                                      newCompositeNode(grammarAccess.getTypeLiteralWithMultiplicityCSAccess().getMapTypeCSParserRuleCall_2_0_1()); 
                                  
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleMapTypeCS_in_ruleTypeLiteralWithMultiplicityCS6645);
                            this_MapTypeCS_3=ruleMapTypeCS();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {
                               
                                      current = this_MapTypeCS_3; 
                                      afterParserOrEnumRuleCall();
                                  
                            }

                            }
                            break;
                        case 3 :
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2819:2: this_TupleTypeCS_4= ruleTupleTypeCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	  /* */ 
                              	
                            }
                            if ( state.backtracking==0 ) {
                               
                                      newCompositeNode(grammarAccess.getTypeLiteralWithMultiplicityCSAccess().getTupleTypeCSParserRuleCall_2_0_2()); 
                                  
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleTupleTypeCS_in_ruleTypeLiteralWithMultiplicityCS6675);
                            this_TupleTypeCS_4=ruleTupleTypeCS();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {
                               
                                      current = this_TupleTypeCS_4; 
                                      afterParserOrEnumRuleCall();
                                  
                            }

                            }
                            break;

                    }

                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2830:2: ( (lv_ownedMultiplicity_5_0= ruleMultiplicityCS ) )?
                    int alt40=2;
                    int LA40_0 = input.LA(1);

                    if ( (LA40_0==66) ) {
                        alt40=1;
                    }
                    switch (alt40) {
                        case 1 :
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2831:1: (lv_ownedMultiplicity_5_0= ruleMultiplicityCS )
                            {
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2831:1: (lv_ownedMultiplicity_5_0= ruleMultiplicityCS )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2832:3: lv_ownedMultiplicity_5_0= ruleMultiplicityCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getTypeLiteralWithMultiplicityCSAccess().getOwnedMultiplicityMultiplicityCSParserRuleCall_2_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleMultiplicityCS_in_ruleTypeLiteralWithMultiplicityCS6696);
                            lv_ownedMultiplicity_5_0=ruleMultiplicityCS();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getTypeLiteralWithMultiplicityCSRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"ownedMultiplicity",
                                      		lv_ownedMultiplicity_5_0, 
                                      		"MultiplicityCS");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }
                            break;

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
    // $ANTLR end "ruleTypeLiteralWithMultiplicityCS"


    // $ANTLR start "entryRuleTypeLiteralExpCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2856:1: entryRuleTypeLiteralExpCS returns [EObject current=null] : iv_ruleTypeLiteralExpCS= ruleTypeLiteralExpCS EOF ;
    public final EObject entryRuleTypeLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2857:2: (iv_ruleTypeLiteralExpCS= ruleTypeLiteralExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2858:2: iv_ruleTypeLiteralExpCS= ruleTypeLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralExpCS_in_entryRuleTypeLiteralExpCS6734);
            iv_ruleTypeLiteralExpCS=ruleTypeLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeLiteralExpCS6744); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2865:1: ruleTypeLiteralExpCS returns [EObject current=null] : ( (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS ) ) ;
    public final EObject ruleTypeLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject lv_ownedType_0_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2868:28: ( ( (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2869:1: ( (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2869:1: ( (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2870:1: (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2870:1: (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2871:3: lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypeLiteralExpCSAccess().getOwnedTypeTypeLiteralWithMultiplicityCSParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralWithMultiplicityCS_in_ruleTypeLiteralExpCS6789);
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


    // $ANTLR start "entryRulePathExpCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2895:1: entryRulePathExpCS returns [EObject current=null] : iv_rulePathExpCS= rulePathExpCS EOF ;
    public final EObject entryRulePathExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePathExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2896:2: (iv_rulePathExpCS= rulePathExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2897:2: iv_rulePathExpCS= rulePathExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPathExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePathExpCS_in_entryRulePathExpCS6824);
            iv_rulePathExpCS=rulePathExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePathExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePathExpCS6834); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePathExpCS"


    // $ANTLR start "rulePathExpCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2904:1: rulePathExpCS returns [EObject current=null] : ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) (otherlv_1= '(' ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) ) otherlv_3= ')' )? ( ( (lv_ownedCurlyBracketedClause_4_0= ruleCurlyBracketedClauseCS ) ) (otherlv_5= '{' ( (lv_ownedPatternGuard_6_0= ruleExpCS ) ) otherlv_7= '}' )? )? ( (lv_ownedMultiplicity_8_0= ruleMultiplicityCS ) )? ) ;
    public final EObject rulePathExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_ownedPathName_0_0 = null;

        EObject lv_ownedBinding_2_0 = null;

        EObject lv_ownedCurlyBracketedClause_4_0 = null;

        EObject lv_ownedPatternGuard_6_0 = null;

        EObject lv_ownedMultiplicity_8_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2907:28: ( ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) (otherlv_1= '(' ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) ) otherlv_3= ')' )? ( ( (lv_ownedCurlyBracketedClause_4_0= ruleCurlyBracketedClauseCS ) ) (otherlv_5= '{' ( (lv_ownedPatternGuard_6_0= ruleExpCS ) ) otherlv_7= '}' )? )? ( (lv_ownedMultiplicity_8_0= ruleMultiplicityCS ) )? ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2908:1: ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) (otherlv_1= '(' ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) ) otherlv_3= ')' )? ( ( (lv_ownedCurlyBracketedClause_4_0= ruleCurlyBracketedClauseCS ) ) (otherlv_5= '{' ( (lv_ownedPatternGuard_6_0= ruleExpCS ) ) otherlv_7= '}' )? )? ( (lv_ownedMultiplicity_8_0= ruleMultiplicityCS ) )? )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2908:1: ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) (otherlv_1= '(' ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) ) otherlv_3= ')' )? ( ( (lv_ownedCurlyBracketedClause_4_0= ruleCurlyBracketedClauseCS ) ) (otherlv_5= '{' ( (lv_ownedPatternGuard_6_0= ruleExpCS ) ) otherlv_7= '}' )? )? ( (lv_ownedMultiplicity_8_0= ruleMultiplicityCS ) )? )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2908:2: ( (lv_ownedPathName_0_0= rulePathNameCS ) ) (otherlv_1= '(' ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) ) otherlv_3= ')' )? ( ( (lv_ownedCurlyBracketedClause_4_0= ruleCurlyBracketedClauseCS ) ) (otherlv_5= '{' ( (lv_ownedPatternGuard_6_0= ruleExpCS ) ) otherlv_7= '}' )? )? ( (lv_ownedMultiplicity_8_0= ruleMultiplicityCS ) )?
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2908:2: ( (lv_ownedPathName_0_0= rulePathNameCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2909:1: (lv_ownedPathName_0_0= rulePathNameCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2909:1: (lv_ownedPathName_0_0= rulePathNameCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2910:3: lv_ownedPathName_0_0= rulePathNameCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPathExpCSAccess().getOwnedPathNamePathNameCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_rulePathNameCS_in_rulePathExpCS6880);
            lv_ownedPathName_0_0=rulePathNameCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getPathExpCSRule());
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2926:2: (otherlv_1= '(' ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) ) otherlv_3= ')' )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==50) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2926:4: otherlv_1= '(' ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) ) otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,50,FollowSets000.FOLLOW_50_in_rulePathExpCS6893); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getPathExpCSAccess().getLeftParenthesisKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2930:1: ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2931:1: (lv_ownedBinding_2_0= ruleTemplateBindingCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2931:1: (lv_ownedBinding_2_0= ruleTemplateBindingCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2932:3: lv_ownedBinding_2_0= ruleTemplateBindingCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPathExpCSAccess().getOwnedBindingTemplateBindingCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTemplateBindingCS_in_rulePathExpCS6914);
                    lv_ownedBinding_2_0=ruleTemplateBindingCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPathExpCSRule());
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

                    otherlv_3=(Token)match(input,51,FollowSets000.FOLLOW_51_in_rulePathExpCS6926); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getPathExpCSAccess().getRightParenthesisKeyword_1_2());
                          
                    }

                    }
                    break;

            }

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2952:3: ( ( (lv_ownedCurlyBracketedClause_4_0= ruleCurlyBracketedClauseCS ) ) (otherlv_5= '{' ( (lv_ownedPatternGuard_6_0= ruleExpCS ) ) otherlv_7= '}' )? )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==55) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2952:4: ( (lv_ownedCurlyBracketedClause_4_0= ruleCurlyBracketedClauseCS ) ) (otherlv_5= '{' ( (lv_ownedPatternGuard_6_0= ruleExpCS ) ) otherlv_7= '}' )?
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2952:4: ( (lv_ownedCurlyBracketedClause_4_0= ruleCurlyBracketedClauseCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2953:1: (lv_ownedCurlyBracketedClause_4_0= ruleCurlyBracketedClauseCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2953:1: (lv_ownedCurlyBracketedClause_4_0= ruleCurlyBracketedClauseCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2954:3: lv_ownedCurlyBracketedClause_4_0= ruleCurlyBracketedClauseCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPathExpCSAccess().getOwnedCurlyBracketedClauseCurlyBracketedClauseCSParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCurlyBracketedClauseCS_in_rulePathExpCS6950);
                    lv_ownedCurlyBracketedClause_4_0=ruleCurlyBracketedClauseCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPathExpCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedCurlyBracketedClause",
                              		lv_ownedCurlyBracketedClause_4_0, 
                              		"CurlyBracketedClauseCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2970:2: (otherlv_5= '{' ( (lv_ownedPatternGuard_6_0= ruleExpCS ) ) otherlv_7= '}' )?
                    int alt43=2;
                    int LA43_0 = input.LA(1);

                    if ( (LA43_0==55) ) {
                        alt43=1;
                    }
                    switch (alt43) {
                        case 1 :
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2970:4: otherlv_5= '{' ( (lv_ownedPatternGuard_6_0= ruleExpCS ) ) otherlv_7= '}'
                            {
                            otherlv_5=(Token)match(input,55,FollowSets000.FOLLOW_55_in_rulePathExpCS6963); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_5, grammarAccess.getPathExpCSAccess().getLeftCurlyBracketKeyword_2_1_0());
                                  
                            }
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2974:1: ( (lv_ownedPatternGuard_6_0= ruleExpCS ) )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2975:1: (lv_ownedPatternGuard_6_0= ruleExpCS )
                            {
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2975:1: (lv_ownedPatternGuard_6_0= ruleExpCS )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2976:3: lv_ownedPatternGuard_6_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getPathExpCSAccess().getOwnedPatternGuardExpCSParserRuleCall_2_1_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_rulePathExpCS6984);
                            lv_ownedPatternGuard_6_0=ruleExpCS();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getPathExpCSRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"ownedPatternGuard",
                                      		lv_ownedPatternGuard_6_0, 
                                      		"ExpCS");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            otherlv_7=(Token)match(input,56,FollowSets000.FOLLOW_56_in_rulePathExpCS6996); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_7, grammarAccess.getPathExpCSAccess().getRightCurlyBracketKeyword_2_1_2());
                                  
                            }

                            }
                            break;

                    }


                    }
                    break;

            }

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2996:5: ( (lv_ownedMultiplicity_8_0= ruleMultiplicityCS ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==66) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2997:1: (lv_ownedMultiplicity_8_0= ruleMultiplicityCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2997:1: (lv_ownedMultiplicity_8_0= ruleMultiplicityCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2998:3: lv_ownedMultiplicity_8_0= ruleMultiplicityCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPathExpCSAccess().getOwnedMultiplicityMultiplicityCSParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMultiplicityCS_in_rulePathExpCS7021);
                    lv_ownedMultiplicity_8_0=ruleMultiplicityCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPathExpCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedMultiplicity",
                              		lv_ownedMultiplicity_8_0, 
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
    // $ANTLR end "rulePathExpCS"


    // $ANTLR start "entryRuleTypeExpCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3022:1: entryRuleTypeExpCS returns [EObject current=null] : iv_ruleTypeExpCS= ruleTypeExpCS EOF ;
    public final EObject entryRuleTypeExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3023:2: (iv_ruleTypeExpCS= ruleTypeExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3024:2: iv_ruleTypeExpCS= ruleTypeExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_entryRuleTypeExpCS7058);
            iv_ruleTypeExpCS=ruleTypeExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeExpCS7068); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3031:1: ruleTypeExpCS returns [EObject current=null] : (this_PathExpCS_0= rulePathExpCS | this_TypeLiteralWithMultiplicityCS_1= ruleTypeLiteralWithMultiplicityCS | this_CollectionPatternCS_2= ruleCollectionPatternCS ) ;
    public final EObject ruleTypeExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_PathExpCS_0 = null;

        EObject this_TypeLiteralWithMultiplicityCS_1 = null;

        EObject this_CollectionPatternCS_2 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3034:28: ( (this_PathExpCS_0= rulePathExpCS | this_TypeLiteralWithMultiplicityCS_1= ruleTypeLiteralWithMultiplicityCS | this_CollectionPatternCS_2= ruleCollectionPatternCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3035:1: (this_PathExpCS_0= rulePathExpCS | this_TypeLiteralWithMultiplicityCS_1= ruleTypeLiteralWithMultiplicityCS | this_CollectionPatternCS_2= ruleCollectionPatternCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3035:1: (this_PathExpCS_0= rulePathExpCS | this_TypeLiteralWithMultiplicityCS_1= ruleTypeLiteralWithMultiplicityCS | this_CollectionPatternCS_2= ruleCollectionPatternCS )
            int alt46=3;
            alt46 = dfa46.predict(input);
            switch (alt46) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3036:2: this_PathExpCS_0= rulePathExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeExpCSAccess().getPathExpCSParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePathExpCS_in_ruleTypeExpCS7118);
                    this_PathExpCS_0=rulePathExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_PathExpCS_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3049:2: this_TypeLiteralWithMultiplicityCS_1= ruleTypeLiteralWithMultiplicityCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeExpCSAccess().getTypeLiteralWithMultiplicityCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralWithMultiplicityCS_in_ruleTypeExpCS7148);
                    this_TypeLiteralWithMultiplicityCS_1=ruleTypeLiteralWithMultiplicityCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_TypeLiteralWithMultiplicityCS_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3062:2: this_CollectionPatternCS_2= ruleCollectionPatternCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeExpCSAccess().getCollectionPatternCSParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCollectionPatternCS_in_ruleTypeExpCS7178);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3081:1: entryRuleExpCS returns [EObject current=null] : iv_ruleExpCS= ruleExpCS EOF ;
    public final EObject entryRuleExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3082:2: (iv_ruleExpCS= ruleExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3083:2: iv_ruleExpCS= ruleExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_entryRuleExpCS7213);
            iv_ruleExpCS=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleExpCS7223); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3090:1: ruleExpCS returns [EObject current=null] : ( (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? ) | this_PrefixedLetExpCS_4= rulePrefixedLetExpCS ) ;
    public final EObject ruleExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_PrefixedPrimaryExpCS_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_ownedRight_3_0 = null;

        EObject this_PrefixedLetExpCS_4 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3093:28: ( ( (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? ) | this_PrefixedLetExpCS_4= rulePrefixedLetExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3094:1: ( (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? ) | this_PrefixedLetExpCS_4= rulePrefixedLetExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3094:1: ( (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? ) | this_PrefixedLetExpCS_4= rulePrefixedLetExpCS )
            int alt48=2;
            alt48 = dfa48.predict(input);
            switch (alt48) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3094:2: (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3094:2: (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3095:2: this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )?
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getExpCSAccess().getPrefixedPrimaryExpCSParserRuleCall_0_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrefixedPrimaryExpCS_in_ruleExpCS7274);
                    this_PrefixedPrimaryExpCS_0=rulePrefixedPrimaryExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_PrefixedPrimaryExpCS_0; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3106:1: ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )?
                    int alt47=2;
                    int LA47_0 = input.LA(1);

                    if ( (LA47_0==16||(LA47_0>=18 && LA47_0<=34)) ) {
                        alt47=1;
                    }
                    switch (alt47) {
                        case 1 :
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3106:2: () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) )
                            {
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3106:2: ()
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3107:2: 
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

                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3115:2: ( (lv_name_2_0= ruleBinaryOperatorName ) )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3116:1: (lv_name_2_0= ruleBinaryOperatorName )
                            {
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3116:1: (lv_name_2_0= ruleBinaryOperatorName )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3117:3: lv_name_2_0= ruleBinaryOperatorName
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getExpCSAccess().getNameBinaryOperatorNameParserRuleCall_0_1_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleBinaryOperatorName_in_ruleExpCS7307);
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

                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3133:2: ( (lv_ownedRight_3_0= ruleExpCS ) )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3134:1: (lv_ownedRight_3_0= ruleExpCS )
                            {
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3134:1: (lv_ownedRight_3_0= ruleExpCS )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3135:3: lv_ownedRight_3_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getExpCSAccess().getOwnedRightExpCSParserRuleCall_0_1_2_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleExpCS7328);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3153:2: this_PrefixedLetExpCS_4= rulePrefixedLetExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getExpCSAccess().getPrefixedLetExpCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrefixedLetExpCS_in_ruleExpCS7362);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3172:1: entryRulePrefixedLetExpCS returns [EObject current=null] : iv_rulePrefixedLetExpCS= rulePrefixedLetExpCS EOF ;
    public final EObject entryRulePrefixedLetExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrefixedLetExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3173:2: (iv_rulePrefixedLetExpCS= rulePrefixedLetExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3174:2: iv_rulePrefixedLetExpCS= rulePrefixedLetExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrefixedLetExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePrefixedLetExpCS_in_entryRulePrefixedLetExpCS7397);
            iv_rulePrefixedLetExpCS=rulePrefixedLetExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrefixedLetExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrefixedLetExpCS7407); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3181:1: rulePrefixedLetExpCS returns [EObject current=null] : ( ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedLetExpCS ) ) ) | this_LetExpCS_3= ruleLetExpCS ) ;
    public final EObject rulePrefixedLetExpCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_ownedRight_2_0 = null;

        EObject this_LetExpCS_3 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3184:28: ( ( ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedLetExpCS ) ) ) | this_LetExpCS_3= ruleLetExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3185:1: ( ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedLetExpCS ) ) ) | this_LetExpCS_3= ruleLetExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3185:1: ( ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedLetExpCS ) ) ) | this_LetExpCS_3= ruleLetExpCS )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( ((LA49_0>=16 && LA49_0<=17)) ) {
                alt49=1;
            }
            else if ( (LA49_0==76) ) {
                alt49=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }
            switch (alt49) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3185:2: ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedLetExpCS ) ) )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3185:2: ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedLetExpCS ) ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3185:3: () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedLetExpCS ) )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3185:3: ()
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3186:2: 
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

                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3194:2: ( (lv_name_1_0= ruleUnaryOperatorName ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3195:1: (lv_name_1_0= ruleUnaryOperatorName )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3195:1: (lv_name_1_0= ruleUnaryOperatorName )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3196:3: lv_name_1_0= ruleUnaryOperatorName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrefixedLetExpCSAccess().getNameUnaryOperatorNameParserRuleCall_0_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUnaryOperatorName_in_rulePrefixedLetExpCS7466);
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

                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3212:2: ( (lv_ownedRight_2_0= rulePrefixedLetExpCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3213:1: (lv_ownedRight_2_0= rulePrefixedLetExpCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3213:1: (lv_ownedRight_2_0= rulePrefixedLetExpCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3214:3: lv_ownedRight_2_0= rulePrefixedLetExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrefixedLetExpCSAccess().getOwnedRightPrefixedLetExpCSParserRuleCall_0_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrefixedLetExpCS_in_rulePrefixedLetExpCS7487);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3232:2: this_LetExpCS_3= ruleLetExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrefixedLetExpCSAccess().getLetExpCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLetExpCS_in_rulePrefixedLetExpCS7519);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3251:1: entryRulePrefixedPrimaryExpCS returns [EObject current=null] : iv_rulePrefixedPrimaryExpCS= rulePrefixedPrimaryExpCS EOF ;
    public final EObject entryRulePrefixedPrimaryExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrefixedPrimaryExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3252:2: (iv_rulePrefixedPrimaryExpCS= rulePrefixedPrimaryExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3253:2: iv_rulePrefixedPrimaryExpCS= rulePrefixedPrimaryExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrefixedPrimaryExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePrefixedPrimaryExpCS_in_entryRulePrefixedPrimaryExpCS7554);
            iv_rulePrefixedPrimaryExpCS=rulePrefixedPrimaryExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrefixedPrimaryExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrefixedPrimaryExpCS7564); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3260:1: rulePrefixedPrimaryExpCS returns [EObject current=null] : ( ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS ) ) ) | this_PrimaryExpCS_3= rulePrimaryExpCS ) ;
    public final EObject rulePrefixedPrimaryExpCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_ownedRight_2_0 = null;

        EObject this_PrimaryExpCS_3 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3263:28: ( ( ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS ) ) ) | this_PrimaryExpCS_3= rulePrimaryExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3264:1: ( ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS ) ) ) | this_PrimaryExpCS_3= rulePrimaryExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3264:1: ( ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS ) ) ) | this_PrimaryExpCS_3= rulePrimaryExpCS )
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( ((LA50_0>=16 && LA50_0<=17)) ) {
                alt50=1;
            }
            else if ( ((LA50_0>=RULE_SIMPLE_ID && LA50_0<=RULE_SINGLE_QUOTED_STRING)||LA50_0==18||(LA50_0>=35 && LA50_0<=50)||LA50_0==52||(LA50_0>=60 && LA50_0<=63)||LA50_0==71||LA50_0==77) ) {
                alt50=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }
            switch (alt50) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3264:2: ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS ) ) )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3264:2: ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS ) ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3264:3: () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS ) )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3264:3: ()
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3265:2: 
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

                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3273:2: ( (lv_name_1_0= ruleUnaryOperatorName ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3274:1: (lv_name_1_0= ruleUnaryOperatorName )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3274:1: (lv_name_1_0= ruleUnaryOperatorName )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3275:3: lv_name_1_0= ruleUnaryOperatorName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrefixedPrimaryExpCSAccess().getNameUnaryOperatorNameParserRuleCall_0_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUnaryOperatorName_in_rulePrefixedPrimaryExpCS7623);
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

                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3291:2: ( (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3292:1: (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3292:1: (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3293:3: lv_ownedRight_2_0= rulePrefixedPrimaryExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrefixedPrimaryExpCSAccess().getOwnedRightPrefixedPrimaryExpCSParserRuleCall_0_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrefixedPrimaryExpCS_in_rulePrefixedPrimaryExpCS7644);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3311:2: this_PrimaryExpCS_3= rulePrimaryExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrefixedPrimaryExpCSAccess().getPrimaryExpCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrimaryExpCS_in_rulePrefixedPrimaryExpCS7676);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3330:1: entryRulePrimaryExpCS returns [EObject current=null] : iv_rulePrimaryExpCS= rulePrimaryExpCS EOF ;
    public final EObject entryRulePrimaryExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3331:2: (iv_rulePrimaryExpCS= rulePrimaryExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3332:2: iv_rulePrimaryExpCS= rulePrimaryExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimaryExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePrimaryExpCS_in_entryRulePrimaryExpCS7711);
            iv_rulePrimaryExpCS=rulePrimaryExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimaryExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrimaryExpCS7721); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3339:1: rulePrimaryExpCS returns [EObject current=null] : (this_NestedExpCS_0= ruleNestedExpCS | this_IfExpCS_1= ruleIfExpCS | this_SelfExpCS_2= ruleSelfExpCS | this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS | this_MapLiteralExpCS_5= ruleMapLiteralExpCS | this_CollectionLiteralExpCS_6= ruleCollectionLiteralExpCS | this_LambdaLiteralExpCS_7= ruleLambdaLiteralExpCS | this_TypeLiteralExpCS_8= ruleTypeLiteralExpCS | this_NameExpCS_9= ruleNameExpCS ) ;
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
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3342:28: ( (this_NestedExpCS_0= ruleNestedExpCS | this_IfExpCS_1= ruleIfExpCS | this_SelfExpCS_2= ruleSelfExpCS | this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS | this_MapLiteralExpCS_5= ruleMapLiteralExpCS | this_CollectionLiteralExpCS_6= ruleCollectionLiteralExpCS | this_LambdaLiteralExpCS_7= ruleLambdaLiteralExpCS | this_TypeLiteralExpCS_8= ruleTypeLiteralExpCS | this_NameExpCS_9= ruleNameExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3343:1: (this_NestedExpCS_0= ruleNestedExpCS | this_IfExpCS_1= ruleIfExpCS | this_SelfExpCS_2= ruleSelfExpCS | this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS | this_MapLiteralExpCS_5= ruleMapLiteralExpCS | this_CollectionLiteralExpCS_6= ruleCollectionLiteralExpCS | this_LambdaLiteralExpCS_7= ruleLambdaLiteralExpCS | this_TypeLiteralExpCS_8= ruleTypeLiteralExpCS | this_NameExpCS_9= ruleNameExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3343:1: (this_NestedExpCS_0= ruleNestedExpCS | this_IfExpCS_1= ruleIfExpCS | this_SelfExpCS_2= ruleSelfExpCS | this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS | this_MapLiteralExpCS_5= ruleMapLiteralExpCS | this_CollectionLiteralExpCS_6= ruleCollectionLiteralExpCS | this_LambdaLiteralExpCS_7= ruleLambdaLiteralExpCS | this_TypeLiteralExpCS_8= ruleTypeLiteralExpCS | this_NameExpCS_9= ruleNameExpCS )
            int alt51=10;
            alt51 = dfa51.predict(input);
            switch (alt51) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3344:2: this_NestedExpCS_0= ruleNestedExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getNestedExpCSParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNestedExpCS_in_rulePrimaryExpCS7771);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3357:2: this_IfExpCS_1= ruleIfExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getIfExpCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleIfExpCS_in_rulePrimaryExpCS7801);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3370:2: this_SelfExpCS_2= ruleSelfExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getSelfExpCSParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSelfExpCS_in_rulePrimaryExpCS7831);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3383:2: this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getPrimitiveLiteralExpCSParserRuleCall_3()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrimitiveLiteralExpCS_in_rulePrimaryExpCS7861);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3396:2: this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getTupleLiteralExpCSParserRuleCall_4()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralExpCS_in_rulePrimaryExpCS7891);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3409:2: this_MapLiteralExpCS_5= ruleMapLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getMapLiteralExpCSParserRuleCall_5()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMapLiteralExpCS_in_rulePrimaryExpCS7921);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3422:2: this_CollectionLiteralExpCS_6= ruleCollectionLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getCollectionLiteralExpCSParserRuleCall_6()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteralExpCS_in_rulePrimaryExpCS7951);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3435:2: this_LambdaLiteralExpCS_7= ruleLambdaLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getLambdaLiteralExpCSParserRuleCall_7()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLambdaLiteralExpCS_in_rulePrimaryExpCS7981);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3448:2: this_TypeLiteralExpCS_8= ruleTypeLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getTypeLiteralExpCSParserRuleCall_8()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralExpCS_in_rulePrimaryExpCS8011);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3461:2: this_NameExpCS_9= ruleNameExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getNameExpCSParserRuleCall_9()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNameExpCS_in_rulePrimaryExpCS8041);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3480:1: entryRuleNameExpCS returns [EObject current=null] : iv_ruleNameExpCS= ruleNameExpCS EOF ;
    public final EObject entryRuleNameExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNameExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3481:2: (iv_ruleNameExpCS= ruleNameExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3482:2: iv_ruleNameExpCS= ruleNameExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNameExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNameExpCS_in_entryRuleNameExpCS8076);
            iv_ruleNameExpCS=ruleNameExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNameExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNameExpCS8086); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3489:1: ruleNameExpCS returns [EObject current=null] : ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( (lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS ) )* ( (lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS ) )? ( (lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS ) )? ( ( (lv_isPre_4_0= '@' ) ) otherlv_5= 'pre' )? ) ;
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
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3492:28: ( ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( (lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS ) )* ( (lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS ) )? ( (lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS ) )? ( ( (lv_isPre_4_0= '@' ) ) otherlv_5= 'pre' )? ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3493:1: ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( (lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS ) )* ( (lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS ) )? ( (lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS ) )? ( ( (lv_isPre_4_0= '@' ) ) otherlv_5= 'pre' )? )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3493:1: ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( (lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS ) )* ( (lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS ) )? ( (lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS ) )? ( ( (lv_isPre_4_0= '@' ) ) otherlv_5= 'pre' )? )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3493:2: ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( (lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS ) )* ( (lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS ) )? ( (lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS ) )? ( ( (lv_isPre_4_0= '@' ) ) otherlv_5= 'pre' )?
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3493:2: ( (lv_ownedPathName_0_0= rulePathNameCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3494:1: (lv_ownedPathName_0_0= rulePathNameCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3494:1: (lv_ownedPathName_0_0= rulePathNameCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3495:3: lv_ownedPathName_0_0= rulePathNameCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNameExpCSAccess().getOwnedPathNamePathNameCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_rulePathNameCS_in_ruleNameExpCS8132);
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3511:2: ( (lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS ) )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==66) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3512:1: (lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS )
            	    {
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3512:1: (lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS )
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3513:3: lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getNameExpCSAccess().getOwnedSquareBracketedClausesSquareBracketedClauseCSParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleSquareBracketedClauseCS_in_ruleNameExpCS8153);
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
            	    break loop52;
                }
            } while (true);

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3529:3: ( (lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS ) )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==50) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3530:1: (lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3530:1: (lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3531:3: lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNameExpCSAccess().getOwnedRoundBracketedClauseRoundBracketedClauseCSParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleRoundBracketedClauseCS_in_ruleNameExpCS8175);
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3547:3: ( (lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS ) )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==55) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3548:1: (lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3548:1: (lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3549:3: lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNameExpCSAccess().getOwnedCurlyBracketedClauseCurlyBracketedClauseCSParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCurlyBracketedClauseCS_in_ruleNameExpCS8197);
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3565:3: ( ( (lv_isPre_4_0= '@' ) ) otherlv_5= 'pre' )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==64) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3565:4: ( (lv_isPre_4_0= '@' ) ) otherlv_5= 'pre'
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3565:4: ( (lv_isPre_4_0= '@' ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3566:1: (lv_isPre_4_0= '@' )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3566:1: (lv_isPre_4_0= '@' )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3567:3: lv_isPre_4_0= '@'
                    {
                    lv_isPre_4_0=(Token)match(input,64,FollowSets000.FOLLOW_64_in_ruleNameExpCS8217); if (state.failed) return current;
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

                    otherlv_5=(Token)match(input,65,FollowSets000.FOLLOW_65_in_ruleNameExpCS8242); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3592:1: entryRuleCurlyBracketedClauseCS returns [EObject current=null] : iv_ruleCurlyBracketedClauseCS= ruleCurlyBracketedClauseCS EOF ;
    public final EObject entryRuleCurlyBracketedClauseCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCurlyBracketedClauseCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3593:2: (iv_ruleCurlyBracketedClauseCS= ruleCurlyBracketedClauseCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3594:2: iv_ruleCurlyBracketedClauseCS= ruleCurlyBracketedClauseCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCurlyBracketedClauseCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleCurlyBracketedClauseCS_in_entryRuleCurlyBracketedClauseCS8280);
            iv_ruleCurlyBracketedClauseCS=ruleCurlyBracketedClauseCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCurlyBracketedClauseCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCurlyBracketedClauseCS8290); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3601:1: ruleCurlyBracketedClauseCS returns [EObject current=null] : ( () otherlv_1= '{' ( ( (lv_value_2_0= ruleStringLiteral ) ) | ( ( (lv_ownedParts_3_0= ruleShadowPartCS ) ) (otherlv_4= ',' ( (lv_ownedParts_5_0= ruleShadowPartCS ) ) )* ) )? otherlv_6= '}' ) ;
    public final EObject ruleCurlyBracketedClauseCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_value_2_0 = null;

        EObject lv_ownedParts_3_0 = null;

        EObject lv_ownedParts_5_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3604:28: ( ( () otherlv_1= '{' ( ( (lv_value_2_0= ruleStringLiteral ) ) | ( ( (lv_ownedParts_3_0= ruleShadowPartCS ) ) (otherlv_4= ',' ( (lv_ownedParts_5_0= ruleShadowPartCS ) ) )* ) )? otherlv_6= '}' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3605:1: ( () otherlv_1= '{' ( ( (lv_value_2_0= ruleStringLiteral ) ) | ( ( (lv_ownedParts_3_0= ruleShadowPartCS ) ) (otherlv_4= ',' ( (lv_ownedParts_5_0= ruleShadowPartCS ) ) )* ) )? otherlv_6= '}' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3605:1: ( () otherlv_1= '{' ( ( (lv_value_2_0= ruleStringLiteral ) ) | ( ( (lv_ownedParts_3_0= ruleShadowPartCS ) ) (otherlv_4= ',' ( (lv_ownedParts_5_0= ruleShadowPartCS ) ) )* ) )? otherlv_6= '}' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3605:2: () otherlv_1= '{' ( ( (lv_value_2_0= ruleStringLiteral ) ) | ( ( (lv_ownedParts_3_0= ruleShadowPartCS ) ) (otherlv_4= ',' ( (lv_ownedParts_5_0= ruleShadowPartCS ) ) )* ) )? otherlv_6= '}'
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3605:2: ()
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3606:2: 
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

            otherlv_1=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleCurlyBracketedClauseCS8339); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getCurlyBracketedClauseCSAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3618:1: ( ( (lv_value_2_0= ruleStringLiteral ) ) | ( ( (lv_ownedParts_3_0= ruleShadowPartCS ) ) (otherlv_4= ',' ( (lv_ownedParts_5_0= ruleShadowPartCS ) ) )* ) )?
            int alt57=3;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==RULE_SINGLE_QUOTED_STRING) ) {
                alt57=1;
            }
            else if ( ((LA57_0>=RULE_SIMPLE_ID && LA57_0<=RULE_ESCAPED_ID)) ) {
                alt57=2;
            }
            switch (alt57) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3618:2: ( (lv_value_2_0= ruleStringLiteral ) )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3618:2: ( (lv_value_2_0= ruleStringLiteral ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3619:1: (lv_value_2_0= ruleStringLiteral )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3619:1: (lv_value_2_0= ruleStringLiteral )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3620:3: lv_value_2_0= ruleStringLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCurlyBracketedClauseCSAccess().getValueStringLiteralParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleStringLiteral_in_ruleCurlyBracketedClauseCS8361);
                    lv_value_2_0=ruleStringLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getCurlyBracketedClauseCSRule());
                      	        }
                             		set(
                             			current, 
                             			"value",
                              		lv_value_2_0, 
                              		"StringLiteral");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3637:6: ( ( (lv_ownedParts_3_0= ruleShadowPartCS ) ) (otherlv_4= ',' ( (lv_ownedParts_5_0= ruleShadowPartCS ) ) )* )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3637:6: ( ( (lv_ownedParts_3_0= ruleShadowPartCS ) ) (otherlv_4= ',' ( (lv_ownedParts_5_0= ruleShadowPartCS ) ) )* )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3637:7: ( (lv_ownedParts_3_0= ruleShadowPartCS ) ) (otherlv_4= ',' ( (lv_ownedParts_5_0= ruleShadowPartCS ) ) )*
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3637:7: ( (lv_ownedParts_3_0= ruleShadowPartCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3638:1: (lv_ownedParts_3_0= ruleShadowPartCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3638:1: (lv_ownedParts_3_0= ruleShadowPartCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3639:3: lv_ownedParts_3_0= ruleShadowPartCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCurlyBracketedClauseCSAccess().getOwnedPartsShadowPartCSParserRuleCall_2_1_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleShadowPartCS_in_ruleCurlyBracketedClauseCS8389);
                    lv_ownedParts_3_0=ruleShadowPartCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getCurlyBracketedClauseCSRule());
                      	        }
                             		add(
                             			current, 
                             			"ownedParts",
                              		lv_ownedParts_3_0, 
                              		"ShadowPartCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3655:2: (otherlv_4= ',' ( (lv_ownedParts_5_0= ruleShadowPartCS ) ) )*
                    loop56:
                    do {
                        int alt56=2;
                        int LA56_0 = input.LA(1);

                        if ( (LA56_0==53) ) {
                            alt56=1;
                        }


                        switch (alt56) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3655:4: otherlv_4= ',' ( (lv_ownedParts_5_0= ruleShadowPartCS ) )
                    	    {
                    	    otherlv_4=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleCurlyBracketedClauseCS8402); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_4, grammarAccess.getCurlyBracketedClauseCSAccess().getCommaKeyword_2_1_1_0());
                    	          
                    	    }
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3659:1: ( (lv_ownedParts_5_0= ruleShadowPartCS ) )
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3660:1: (lv_ownedParts_5_0= ruleShadowPartCS )
                    	    {
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3660:1: (lv_ownedParts_5_0= ruleShadowPartCS )
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3661:3: lv_ownedParts_5_0= ruleShadowPartCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getCurlyBracketedClauseCSAccess().getOwnedPartsShadowPartCSParserRuleCall_2_1_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleShadowPartCS_in_ruleCurlyBracketedClauseCS8423);
                    	    lv_ownedParts_5_0=ruleShadowPartCS();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getCurlyBracketedClauseCSRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"ownedParts",
                    	              		lv_ownedParts_5_0, 
                    	              		"ShadowPartCS");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop56;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,56,FollowSets000.FOLLOW_56_in_ruleCurlyBracketedClauseCS8440); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3689:1: entryRuleRoundBracketedClauseCS returns [EObject current=null] : iv_ruleRoundBracketedClauseCS= ruleRoundBracketedClauseCS EOF ;
    public final EObject entryRuleRoundBracketedClauseCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRoundBracketedClauseCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3690:2: (iv_ruleRoundBracketedClauseCS= ruleRoundBracketedClauseCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3691:2: iv_ruleRoundBracketedClauseCS= ruleRoundBracketedClauseCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRoundBracketedClauseCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleRoundBracketedClauseCS_in_entryRuleRoundBracketedClauseCS8476);
            iv_ruleRoundBracketedClauseCS=ruleRoundBracketedClauseCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRoundBracketedClauseCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRoundBracketedClauseCS8486); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3698:1: ruleRoundBracketedClauseCS returns [EObject current=null] : ( () otherlv_1= '(' ( ( (lv_ownedArguments_2_0= ruleNavigatingArgCS ) ) ( (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )* )* )? otherlv_8= ')' ) ;
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
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3701:28: ( ( () otherlv_1= '(' ( ( (lv_ownedArguments_2_0= ruleNavigatingArgCS ) ) ( (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )* )* )? otherlv_8= ')' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3702:1: ( () otherlv_1= '(' ( ( (lv_ownedArguments_2_0= ruleNavigatingArgCS ) ) ( (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )* )* )? otherlv_8= ')' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3702:1: ( () otherlv_1= '(' ( ( (lv_ownedArguments_2_0= ruleNavigatingArgCS ) ) ( (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )* )* )? otherlv_8= ')' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3702:2: () otherlv_1= '(' ( ( (lv_ownedArguments_2_0= ruleNavigatingArgCS ) ) ( (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )* )* )? otherlv_8= ')'
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3702:2: ()
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3703:2: 
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

            otherlv_1=(Token)match(input,50,FollowSets000.FOLLOW_50_in_ruleRoundBracketedClauseCS8535); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getRoundBracketedClauseCSAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3715:1: ( ( (lv_ownedArguments_2_0= ruleNavigatingArgCS ) ) ( (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )* )* )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( ((LA63_0>=RULE_SIMPLE_ID && LA63_0<=RULE_SINGLE_QUOTED_STRING)||(LA63_0>=16 && LA63_0<=18)||(LA63_0>=35 && LA63_0<=50)||LA63_0==52||LA63_0==54||(LA63_0>=60 && LA63_0<=63)||LA63_0==71||(LA63_0>=76 && LA63_0<=77)) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3715:2: ( (lv_ownedArguments_2_0= ruleNavigatingArgCS ) ) ( (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )* )*
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3715:2: ( (lv_ownedArguments_2_0= ruleNavigatingArgCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3716:1: (lv_ownedArguments_2_0= ruleNavigatingArgCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3716:1: (lv_ownedArguments_2_0= ruleNavigatingArgCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3717:3: lv_ownedArguments_2_0= ruleNavigatingArgCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingArgCSParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgCS_in_ruleRoundBracketedClauseCS8557);
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

                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3733:2: ( (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS ) )*
                    loop58:
                    do {
                        int alt58=2;
                        int LA58_0 = input.LA(1);

                        if ( (LA58_0==53) ) {
                            alt58=1;
                        }


                        switch (alt58) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3734:1: (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS )
                    	    {
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3734:1: (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS )
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3735:3: lv_ownedArguments_3_0= ruleNavigatingCommaArgCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingCommaArgCSParserRuleCall_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleNavigatingCommaArgCS_in_ruleRoundBracketedClauseCS8578);
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
                    	    break loop58;
                        }
                    } while (true);

                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3751:3: ( ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )* )?
                    int alt60=2;
                    int LA60_0 = input.LA(1);

                    if ( (LA60_0==70) ) {
                        alt60=1;
                    }
                    switch (alt60) {
                        case 1 :
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3751:4: ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )*
                            {
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3751:4: ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3752:1: (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS )
                            {
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3752:1: (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3753:3: lv_ownedArguments_4_0= ruleNavigatingSemiArgCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingSemiArgCSParserRuleCall_2_2_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleNavigatingSemiArgCS_in_ruleRoundBracketedClauseCS8601);
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

                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3769:2: ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )*
                            loop59:
                            do {
                                int alt59=2;
                                int LA59_0 = input.LA(1);

                                if ( (LA59_0==53) ) {
                                    alt59=1;
                                }


                                switch (alt59) {
                            	case 1 :
                            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3770:1: (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS )
                            	    {
                            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3770:1: (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS )
                            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3771:3: lv_ownedArguments_5_0= ruleNavigatingCommaArgCS
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingCommaArgCSParserRuleCall_2_2_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FollowSets000.FOLLOW_ruleNavigatingCommaArgCS_in_ruleRoundBracketedClauseCS8622);
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
                            	    break loop59;
                                }
                            } while (true);


                            }
                            break;

                    }

                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3787:5: ( ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )* )*
                    loop62:
                    do {
                        int alt62=2;
                        int LA62_0 = input.LA(1);

                        if ( (LA62_0==69) ) {
                            alt62=1;
                        }


                        switch (alt62) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3787:6: ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )*
                    	    {
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3787:6: ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) )
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3788:1: (lv_ownedArguments_6_0= ruleNavigatingBarArgCS )
                    	    {
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3788:1: (lv_ownedArguments_6_0= ruleNavigatingBarArgCS )
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3789:3: lv_ownedArguments_6_0= ruleNavigatingBarArgCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingBarArgCSParserRuleCall_2_3_0_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleNavigatingBarArgCS_in_ruleRoundBracketedClauseCS8647);
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

                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3805:2: ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )*
                    	    loop61:
                    	    do {
                    	        int alt61=2;
                    	        int LA61_0 = input.LA(1);

                    	        if ( (LA61_0==53) ) {
                    	            alt61=1;
                    	        }


                    	        switch (alt61) {
                    	    	case 1 :
                    	    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3806:1: (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS )
                    	    	    {
                    	    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3806:1: (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS )
                    	    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3807:3: lv_ownedArguments_7_0= ruleNavigatingCommaArgCS
                    	    	    {
                    	    	    if ( state.backtracking==0 ) {
                    	    	       
                    	    	      	        newCompositeNode(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingCommaArgCSParserRuleCall_2_3_1_0()); 
                    	    	      	    
                    	    	    }
                    	    	    pushFollow(FollowSets000.FOLLOW_ruleNavigatingCommaArgCS_in_ruleRoundBracketedClauseCS8668);
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
                    	    	    break loop61;
                    	        }
                    	    } while (true);


                    	    }
                    	    break;

                    	default :
                    	    break loop62;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_8=(Token)match(input,51,FollowSets000.FOLLOW_51_in_ruleRoundBracketedClauseCS8685); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3835:1: entryRuleSquareBracketedClauseCS returns [EObject current=null] : iv_ruleSquareBracketedClauseCS= ruleSquareBracketedClauseCS EOF ;
    public final EObject entryRuleSquareBracketedClauseCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSquareBracketedClauseCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3836:2: (iv_ruleSquareBracketedClauseCS= ruleSquareBracketedClauseCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3837:2: iv_ruleSquareBracketedClauseCS= ruleSquareBracketedClauseCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSquareBracketedClauseCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSquareBracketedClauseCS_in_entryRuleSquareBracketedClauseCS8721);
            iv_ruleSquareBracketedClauseCS=ruleSquareBracketedClauseCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSquareBracketedClauseCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSquareBracketedClauseCS8731); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3844:1: ruleSquareBracketedClauseCS returns [EObject current=null] : (otherlv_0= '[' ( (lv_ownedTerms_1_0= ruleExpCS ) ) (otherlv_2= ',' ( (lv_ownedTerms_3_0= ruleExpCS ) ) )* otherlv_4= ']' ) ;
    public final EObject ruleSquareBracketedClauseCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_ownedTerms_1_0 = null;

        EObject lv_ownedTerms_3_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3847:28: ( (otherlv_0= '[' ( (lv_ownedTerms_1_0= ruleExpCS ) ) (otherlv_2= ',' ( (lv_ownedTerms_3_0= ruleExpCS ) ) )* otherlv_4= ']' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3848:1: (otherlv_0= '[' ( (lv_ownedTerms_1_0= ruleExpCS ) ) (otherlv_2= ',' ( (lv_ownedTerms_3_0= ruleExpCS ) ) )* otherlv_4= ']' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3848:1: (otherlv_0= '[' ( (lv_ownedTerms_1_0= ruleExpCS ) ) (otherlv_2= ',' ( (lv_ownedTerms_3_0= ruleExpCS ) ) )* otherlv_4= ']' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3848:3: otherlv_0= '[' ( (lv_ownedTerms_1_0= ruleExpCS ) ) (otherlv_2= ',' ( (lv_ownedTerms_3_0= ruleExpCS ) ) )* otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,66,FollowSets000.FOLLOW_66_in_ruleSquareBracketedClauseCS8768); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getSquareBracketedClauseCSAccess().getLeftSquareBracketKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3852:1: ( (lv_ownedTerms_1_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3853:1: (lv_ownedTerms_1_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3853:1: (lv_ownedTerms_1_0= ruleExpCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3854:3: lv_ownedTerms_1_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSquareBracketedClauseCSAccess().getOwnedTermsExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleSquareBracketedClauseCS8789);
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3870:2: (otherlv_2= ',' ( (lv_ownedTerms_3_0= ruleExpCS ) ) )*
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( (LA64_0==53) ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3870:4: otherlv_2= ',' ( (lv_ownedTerms_3_0= ruleExpCS ) )
            	    {
            	    otherlv_2=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleSquareBracketedClauseCS8802); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getSquareBracketedClauseCSAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3874:1: ( (lv_ownedTerms_3_0= ruleExpCS ) )
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3875:1: (lv_ownedTerms_3_0= ruleExpCS )
            	    {
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3875:1: (lv_ownedTerms_3_0= ruleExpCS )
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3876:3: lv_ownedTerms_3_0= ruleExpCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSquareBracketedClauseCSAccess().getOwnedTermsExpCSParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleSquareBracketedClauseCS8823);
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
            	    break loop64;
                }
            } while (true);

            otherlv_4=(Token)match(input,67,FollowSets000.FOLLOW_67_in_ruleSquareBracketedClauseCS8837); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3904:1: entryRuleNavigatingArgCS returns [EObject current=null] : iv_ruleNavigatingArgCS= ruleNavigatingArgCS EOF ;
    public final EObject entryRuleNavigatingArgCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingArgCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3905:2: (iv_ruleNavigatingArgCS= ruleNavigatingArgCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3906:2: iv_ruleNavigatingArgCS= ruleNavigatingArgCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingArgCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgCS_in_entryRuleNavigatingArgCS8873);
            iv_ruleNavigatingArgCS=ruleNavigatingArgCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingArgCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigatingArgCS8883); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3913:1: ruleNavigatingArgCS returns [EObject current=null] : ( ( ( (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS ) ) ( (otherlv_1= ':' ( (lv_ownedType_2_0= ruleComplexTypeCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? ) | (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) ) )? ) | (otherlv_7= ':' ( (lv_ownedType_8_0= ruleComplexTypeCS ) ) ) ) ;
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
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3916:28: ( ( ( ( (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS ) ) ( (otherlv_1= ':' ( (lv_ownedType_2_0= ruleComplexTypeCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? ) | (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) ) )? ) | (otherlv_7= ':' ( (lv_ownedType_8_0= ruleComplexTypeCS ) ) ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3917:1: ( ( ( (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS ) ) ( (otherlv_1= ':' ( (lv_ownedType_2_0= ruleComplexTypeCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? ) | (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) ) )? ) | (otherlv_7= ':' ( (lv_ownedType_8_0= ruleComplexTypeCS ) ) ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3917:1: ( ( ( (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS ) ) ( (otherlv_1= ':' ( (lv_ownedType_2_0= ruleComplexTypeCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? ) | (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) ) )? ) | (otherlv_7= ':' ( (lv_ownedType_8_0= ruleComplexTypeCS ) ) ) )
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( ((LA67_0>=RULE_SIMPLE_ID && LA67_0<=RULE_SINGLE_QUOTED_STRING)||(LA67_0>=16 && LA67_0<=18)||(LA67_0>=35 && LA67_0<=50)||LA67_0==52||(LA67_0>=60 && LA67_0<=63)||LA67_0==71||(LA67_0>=76 && LA67_0<=77)) ) {
                alt67=1;
            }
            else if ( (LA67_0==54) ) {
                alt67=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 67, 0, input);

                throw nvae;
            }
            switch (alt67) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3917:2: ( ( (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS ) ) ( (otherlv_1= ':' ( (lv_ownedType_2_0= ruleComplexTypeCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? ) | (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) ) )? )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3917:2: ( ( (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS ) ) ( (otherlv_1= ':' ( (lv_ownedType_2_0= ruleComplexTypeCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? ) | (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) ) )? )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3917:3: ( (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS ) ) ( (otherlv_1= ':' ( (lv_ownedType_2_0= ruleComplexTypeCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? ) | (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) ) )?
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3917:3: ( (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3918:1: (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3918:1: (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3919:3: lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedNameExpressionNavigatingArgExpCSParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingArgCS8930);
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

                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3935:2: ( (otherlv_1= ':' ( (lv_ownedType_2_0= ruleComplexTypeCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? ) | (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) ) )?
                    int alt66=3;
                    int LA66_0 = input.LA(1);

                    if ( (LA66_0==54) ) {
                        alt66=1;
                    }
                    else if ( (LA66_0==68) ) {
                        alt66=2;
                    }
                    switch (alt66) {
                        case 1 :
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3935:3: (otherlv_1= ':' ( (lv_ownedType_2_0= ruleComplexTypeCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? )
                            {
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3935:3: (otherlv_1= ':' ( (lv_ownedType_2_0= ruleComplexTypeCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3935:5: otherlv_1= ':' ( (lv_ownedType_2_0= ruleComplexTypeCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )?
                            {
                            otherlv_1=(Token)match(input,54,FollowSets000.FOLLOW_54_in_ruleNavigatingArgCS8944); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_1, grammarAccess.getNavigatingArgCSAccess().getColonKeyword_0_1_0_0());
                                  
                            }
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3939:1: ( (lv_ownedType_2_0= ruleComplexTypeCS ) )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3940:1: (lv_ownedType_2_0= ruleComplexTypeCS )
                            {
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3940:1: (lv_ownedType_2_0= ruleComplexTypeCS )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3941:3: lv_ownedType_2_0= ruleComplexTypeCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedTypeComplexTypeCSParserRuleCall_0_1_0_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleComplexTypeCS_in_ruleNavigatingArgCS8965);
                            lv_ownedType_2_0=ruleComplexTypeCS();

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
                                      		"ComplexTypeCS");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3957:2: (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )?
                            int alt65=2;
                            int LA65_0 = input.LA(1);

                            if ( (LA65_0==25) ) {
                                alt65=1;
                            }
                            switch (alt65) {
                                case 1 :
                                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3957:4: otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) )
                                    {
                                    otherlv_3=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleNavigatingArgCS8978); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                          	newLeafNode(otherlv_3, grammarAccess.getNavigatingArgCSAccess().getEqualsSignKeyword_0_1_0_2_0());
                                          
                                    }
                                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3961:1: ( (lv_ownedInitExpression_4_0= ruleExpCS ) )
                                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3962:1: (lv_ownedInitExpression_4_0= ruleExpCS )
                                    {
                                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3962:1: (lv_ownedInitExpression_4_0= ruleExpCS )
                                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3963:3: lv_ownedInitExpression_4_0= ruleExpCS
                                    {
                                    if ( state.backtracking==0 ) {
                                       
                                      	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_0_1_0_2_1_0()); 
                                      	    
                                    }
                                    pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNavigatingArgCS8999);
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
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3980:6: (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) )
                            {
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3980:6: (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3980:8: otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) )
                            {
                            otherlv_5=(Token)match(input,68,FollowSets000.FOLLOW_68_in_ruleNavigatingArgCS9021); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_5, grammarAccess.getNavigatingArgCSAccess().getInKeyword_0_1_1_0());
                                  
                            }
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3984:1: ( (lv_ownedInitExpression_6_0= ruleExpCS ) )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3985:1: (lv_ownedInitExpression_6_0= ruleExpCS )
                            {
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3985:1: (lv_ownedInitExpression_6_0= ruleExpCS )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3986:3: lv_ownedInitExpression_6_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_0_1_1_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNavigatingArgCS9042);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4003:6: (otherlv_7= ':' ( (lv_ownedType_8_0= ruleComplexTypeCS ) ) )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4003:6: (otherlv_7= ':' ( (lv_ownedType_8_0= ruleComplexTypeCS ) ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4003:8: otherlv_7= ':' ( (lv_ownedType_8_0= ruleComplexTypeCS ) )
                    {
                    otherlv_7=(Token)match(input,54,FollowSets000.FOLLOW_54_in_ruleNavigatingArgCS9065); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getNavigatingArgCSAccess().getColonKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4007:1: ( (lv_ownedType_8_0= ruleComplexTypeCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4008:1: (lv_ownedType_8_0= ruleComplexTypeCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4008:1: (lv_ownedType_8_0= ruleComplexTypeCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4009:3: lv_ownedType_8_0= ruleComplexTypeCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedTypeComplexTypeCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleComplexTypeCS_in_ruleNavigatingArgCS9086);
                    lv_ownedType_8_0=ruleComplexTypeCS();

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
                              		"ComplexTypeCS");
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4033:1: entryRuleNavigatingBarArgCS returns [EObject current=null] : iv_ruleNavigatingBarArgCS= ruleNavigatingBarArgCS EOF ;
    public final EObject entryRuleNavigatingBarArgCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingBarArgCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4034:2: (iv_ruleNavigatingBarArgCS= ruleNavigatingBarArgCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4035:2: iv_ruleNavigatingBarArgCS= ruleNavigatingBarArgCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingBarArgCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingBarArgCS_in_entryRuleNavigatingBarArgCS9123);
            iv_ruleNavigatingBarArgCS=ruleNavigatingBarArgCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingBarArgCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigatingBarArgCS9133); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4042:1: ruleNavigatingBarArgCS returns [EObject current=null] : ( ( (lv_prefix_0_0= '|' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleComplexTypeCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )? ) ;
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
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4045:28: ( ( ( (lv_prefix_0_0= '|' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleComplexTypeCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )? ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4046:1: ( ( (lv_prefix_0_0= '|' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleComplexTypeCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )? )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4046:1: ( ( (lv_prefix_0_0= '|' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleComplexTypeCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )? )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4046:2: ( (lv_prefix_0_0= '|' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleComplexTypeCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )?
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4046:2: ( (lv_prefix_0_0= '|' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4047:1: (lv_prefix_0_0= '|' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4047:1: (lv_prefix_0_0= '|' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4048:3: lv_prefix_0_0= '|'
            {
            lv_prefix_0_0=(Token)match(input,69,FollowSets000.FOLLOW_69_in_ruleNavigatingBarArgCS9176); if (state.failed) return current;
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4061:2: ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4062:1: (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4062:1: (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4063:3: lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNavigatingBarArgCSAccess().getOwnedNameExpressionNavigatingArgExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingBarArgCS9210);
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4079:2: (otherlv_2= ':' ( (lv_ownedType_3_0= ruleComplexTypeCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==54) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4079:4: otherlv_2= ':' ( (lv_ownedType_3_0= ruleComplexTypeCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )?
                    {
                    otherlv_2=(Token)match(input,54,FollowSets000.FOLLOW_54_in_ruleNavigatingBarArgCS9223); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getNavigatingBarArgCSAccess().getColonKeyword_2_0());
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4083:1: ( (lv_ownedType_3_0= ruleComplexTypeCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4084:1: (lv_ownedType_3_0= ruleComplexTypeCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4084:1: (lv_ownedType_3_0= ruleComplexTypeCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4085:3: lv_ownedType_3_0= ruleComplexTypeCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingBarArgCSAccess().getOwnedTypeComplexTypeCSParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleComplexTypeCS_in_ruleNavigatingBarArgCS9244);
                    lv_ownedType_3_0=ruleComplexTypeCS();

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
                              		"ComplexTypeCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4101:2: (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )?
                    int alt68=2;
                    int LA68_0 = input.LA(1);

                    if ( (LA68_0==25) ) {
                        alt68=1;
                    }
                    switch (alt68) {
                        case 1 :
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4101:4: otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) )
                            {
                            otherlv_4=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleNavigatingBarArgCS9257); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getNavigatingBarArgCSAccess().getEqualsSignKeyword_2_2_0());
                                  
                            }
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4105:1: ( (lv_ownedInitExpression_5_0= ruleExpCS ) )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4106:1: (lv_ownedInitExpression_5_0= ruleExpCS )
                            {
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4106:1: (lv_ownedInitExpression_5_0= ruleExpCS )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4107:3: lv_ownedInitExpression_5_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getNavigatingBarArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_2_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNavigatingBarArgCS9278);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4131:1: entryRuleNavigatingCommaArgCS returns [EObject current=null] : iv_ruleNavigatingCommaArgCS= ruleNavigatingCommaArgCS EOF ;
    public final EObject entryRuleNavigatingCommaArgCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingCommaArgCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4132:2: (iv_ruleNavigatingCommaArgCS= ruleNavigatingCommaArgCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4133:2: iv_ruleNavigatingCommaArgCS= ruleNavigatingCommaArgCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingCommaArgCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingCommaArgCS_in_entryRuleNavigatingCommaArgCS9318);
            iv_ruleNavigatingCommaArgCS=ruleNavigatingCommaArgCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingCommaArgCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigatingCommaArgCS9328); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4140:1: ruleNavigatingCommaArgCS returns [EObject current=null] : ( ( (lv_prefix_0_0= ',' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) ( (otherlv_2= ':' ( (lv_ownedType_3_0= ruleComplexTypeCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? ) | (otherlv_6= 'in' ( (lv_ownedInitExpression_7_0= ruleExpCS ) ) ) )? ) ;
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
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4143:28: ( ( ( (lv_prefix_0_0= ',' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) ( (otherlv_2= ':' ( (lv_ownedType_3_0= ruleComplexTypeCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? ) | (otherlv_6= 'in' ( (lv_ownedInitExpression_7_0= ruleExpCS ) ) ) )? ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4144:1: ( ( (lv_prefix_0_0= ',' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) ( (otherlv_2= ':' ( (lv_ownedType_3_0= ruleComplexTypeCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? ) | (otherlv_6= 'in' ( (lv_ownedInitExpression_7_0= ruleExpCS ) ) ) )? )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4144:1: ( ( (lv_prefix_0_0= ',' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) ( (otherlv_2= ':' ( (lv_ownedType_3_0= ruleComplexTypeCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? ) | (otherlv_6= 'in' ( (lv_ownedInitExpression_7_0= ruleExpCS ) ) ) )? )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4144:2: ( (lv_prefix_0_0= ',' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) ( (otherlv_2= ':' ( (lv_ownedType_3_0= ruleComplexTypeCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? ) | (otherlv_6= 'in' ( (lv_ownedInitExpression_7_0= ruleExpCS ) ) ) )?
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4144:2: ( (lv_prefix_0_0= ',' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4145:1: (lv_prefix_0_0= ',' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4145:1: (lv_prefix_0_0= ',' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4146:3: lv_prefix_0_0= ','
            {
            lv_prefix_0_0=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleNavigatingCommaArgCS9371); if (state.failed) return current;
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4159:2: ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4160:1: (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4160:1: (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4161:3: lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedNameExpressionNavigatingArgExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingCommaArgCS9405);
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4177:2: ( (otherlv_2= ':' ( (lv_ownedType_3_0= ruleComplexTypeCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? ) | (otherlv_6= 'in' ( (lv_ownedInitExpression_7_0= ruleExpCS ) ) ) )?
            int alt71=3;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==54) ) {
                alt71=1;
            }
            else if ( (LA71_0==68) ) {
                alt71=2;
            }
            switch (alt71) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4177:3: (otherlv_2= ':' ( (lv_ownedType_3_0= ruleComplexTypeCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4177:3: (otherlv_2= ':' ( (lv_ownedType_3_0= ruleComplexTypeCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4177:5: otherlv_2= ':' ( (lv_ownedType_3_0= ruleComplexTypeCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )?
                    {
                    otherlv_2=(Token)match(input,54,FollowSets000.FOLLOW_54_in_ruleNavigatingCommaArgCS9419); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getNavigatingCommaArgCSAccess().getColonKeyword_2_0_0());
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4181:1: ( (lv_ownedType_3_0= ruleComplexTypeCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4182:1: (lv_ownedType_3_0= ruleComplexTypeCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4182:1: (lv_ownedType_3_0= ruleComplexTypeCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4183:3: lv_ownedType_3_0= ruleComplexTypeCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedTypeComplexTypeCSParserRuleCall_2_0_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleComplexTypeCS_in_ruleNavigatingCommaArgCS9440);
                    lv_ownedType_3_0=ruleComplexTypeCS();

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
                              		"ComplexTypeCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4199:2: (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )?
                    int alt70=2;
                    int LA70_0 = input.LA(1);

                    if ( (LA70_0==25) ) {
                        alt70=1;
                    }
                    switch (alt70) {
                        case 1 :
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4199:4: otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) )
                            {
                            otherlv_4=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleNavigatingCommaArgCS9453); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getNavigatingCommaArgCSAccess().getEqualsSignKeyword_2_0_2_0());
                                  
                            }
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4203:1: ( (lv_ownedInitExpression_5_0= ruleExpCS ) )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4204:1: (lv_ownedInitExpression_5_0= ruleExpCS )
                            {
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4204:1: (lv_ownedInitExpression_5_0= ruleExpCS )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4205:3: lv_ownedInitExpression_5_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_0_2_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNavigatingCommaArgCS9474);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4222:6: (otherlv_6= 'in' ( (lv_ownedInitExpression_7_0= ruleExpCS ) ) )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4222:6: (otherlv_6= 'in' ( (lv_ownedInitExpression_7_0= ruleExpCS ) ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4222:8: otherlv_6= 'in' ( (lv_ownedInitExpression_7_0= ruleExpCS ) )
                    {
                    otherlv_6=(Token)match(input,68,FollowSets000.FOLLOW_68_in_ruleNavigatingCommaArgCS9496); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getNavigatingCommaArgCSAccess().getInKeyword_2_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4226:1: ( (lv_ownedInitExpression_7_0= ruleExpCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4227:1: (lv_ownedInitExpression_7_0= ruleExpCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4227:1: (lv_ownedInitExpression_7_0= ruleExpCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4228:3: lv_ownedInitExpression_7_0= ruleExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNavigatingCommaArgCS9517);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4252:1: entryRuleNavigatingSemiArgCS returns [EObject current=null] : iv_ruleNavigatingSemiArgCS= ruleNavigatingSemiArgCS EOF ;
    public final EObject entryRuleNavigatingSemiArgCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingSemiArgCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4253:2: (iv_ruleNavigatingSemiArgCS= ruleNavigatingSemiArgCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4254:2: iv_ruleNavigatingSemiArgCS= ruleNavigatingSemiArgCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingSemiArgCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingSemiArgCS_in_entryRuleNavigatingSemiArgCS9556);
            iv_ruleNavigatingSemiArgCS=ruleNavigatingSemiArgCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingSemiArgCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigatingSemiArgCS9566); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4261:1: ruleNavigatingSemiArgCS returns [EObject current=null] : ( ( (lv_prefix_0_0= ';' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleComplexTypeCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )? ) ;
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
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4264:28: ( ( ( (lv_prefix_0_0= ';' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleComplexTypeCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )? ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4265:1: ( ( (lv_prefix_0_0= ';' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleComplexTypeCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )? )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4265:1: ( ( (lv_prefix_0_0= ';' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleComplexTypeCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )? )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4265:2: ( (lv_prefix_0_0= ';' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleComplexTypeCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )?
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4265:2: ( (lv_prefix_0_0= ';' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4266:1: (lv_prefix_0_0= ';' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4266:1: (lv_prefix_0_0= ';' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4267:3: lv_prefix_0_0= ';'
            {
            lv_prefix_0_0=(Token)match(input,70,FollowSets000.FOLLOW_70_in_ruleNavigatingSemiArgCS9609); if (state.failed) return current;
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4280:2: ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4281:1: (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4281:1: (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4282:3: lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNavigatingSemiArgCSAccess().getOwnedNameExpressionNavigatingArgExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingSemiArgCS9643);
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4298:2: (otherlv_2= ':' ( (lv_ownedType_3_0= ruleComplexTypeCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==54) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4298:4: otherlv_2= ':' ( (lv_ownedType_3_0= ruleComplexTypeCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )?
                    {
                    otherlv_2=(Token)match(input,54,FollowSets000.FOLLOW_54_in_ruleNavigatingSemiArgCS9656); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getNavigatingSemiArgCSAccess().getColonKeyword_2_0());
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4302:1: ( (lv_ownedType_3_0= ruleComplexTypeCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4303:1: (lv_ownedType_3_0= ruleComplexTypeCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4303:1: (lv_ownedType_3_0= ruleComplexTypeCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4304:3: lv_ownedType_3_0= ruleComplexTypeCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingSemiArgCSAccess().getOwnedTypeComplexTypeCSParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleComplexTypeCS_in_ruleNavigatingSemiArgCS9677);
                    lv_ownedType_3_0=ruleComplexTypeCS();

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
                              		"ComplexTypeCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4320:2: (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )?
                    int alt72=2;
                    int LA72_0 = input.LA(1);

                    if ( (LA72_0==25) ) {
                        alt72=1;
                    }
                    switch (alt72) {
                        case 1 :
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4320:4: otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) )
                            {
                            otherlv_4=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleNavigatingSemiArgCS9690); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getNavigatingSemiArgCSAccess().getEqualsSignKeyword_2_2_0());
                                  
                            }
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4324:1: ( (lv_ownedInitExpression_5_0= ruleExpCS ) )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4325:1: (lv_ownedInitExpression_5_0= ruleExpCS )
                            {
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4325:1: (lv_ownedInitExpression_5_0= ruleExpCS )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4326:3: lv_ownedInitExpression_5_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getNavigatingSemiArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_2_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNavigatingSemiArgCS9711);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4350:1: entryRuleNavigatingArgExpCS returns [EObject current=null] : iv_ruleNavigatingArgExpCS= ruleNavigatingArgExpCS EOF ;
    public final EObject entryRuleNavigatingArgExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingArgExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4351:2: (iv_ruleNavigatingArgExpCS= ruleNavigatingArgExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4352:2: iv_ruleNavigatingArgExpCS= ruleNavigatingArgExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingArgExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgExpCS_in_entryRuleNavigatingArgExpCS9751);
            iv_ruleNavigatingArgExpCS=ruleNavigatingArgExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingArgExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigatingArgExpCS9761); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4359:1: ruleNavigatingArgExpCS returns [EObject current=null] : this_ExpCS_0= ruleExpCS ;
    public final EObject ruleNavigatingArgExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_ExpCS_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4362:28: (this_ExpCS_0= ruleExpCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4364:2: this_ExpCS_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getNavigatingArgExpCSAccess().getExpCSParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNavigatingArgExpCS9810);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4383:1: entryRuleIfExpCS returns [EObject current=null] : iv_ruleIfExpCS= ruleIfExpCS EOF ;
    public final EObject entryRuleIfExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4384:2: (iv_ruleIfExpCS= ruleIfExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4385:2: iv_ruleIfExpCS= ruleIfExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIfExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIfExpCS_in_entryRuleIfExpCS9844);
            iv_ruleIfExpCS=ruleIfExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIfExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIfExpCS9854); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4392:1: ruleIfExpCS returns [EObject current=null] : (otherlv_0= 'if' ( ( (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS ) ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) ( (lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS ) )* otherlv_5= 'else' ( (lv_ownedElseExpression_6_0= ruleExpCS ) ) otherlv_7= 'endif' ) ;
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
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4395:28: ( (otherlv_0= 'if' ( ( (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS ) ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) ( (lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS ) )* otherlv_5= 'else' ( (lv_ownedElseExpression_6_0= ruleExpCS ) ) otherlv_7= 'endif' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4396:1: (otherlv_0= 'if' ( ( (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS ) ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) ( (lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS ) )* otherlv_5= 'else' ( (lv_ownedElseExpression_6_0= ruleExpCS ) ) otherlv_7= 'endif' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4396:1: (otherlv_0= 'if' ( ( (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS ) ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) ( (lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS ) )* otherlv_5= 'else' ( (lv_ownedElseExpression_6_0= ruleExpCS ) ) otherlv_7= 'endif' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4396:3: otherlv_0= 'if' ( ( (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS ) ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) ( (lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS ) )* otherlv_5= 'else' ( (lv_ownedElseExpression_6_0= ruleExpCS ) ) otherlv_7= 'endif'
            {
            otherlv_0=(Token)match(input,71,FollowSets000.FOLLOW_71_in_ruleIfExpCS9891); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getIfExpCSAccess().getIfKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4400:1: ( ( (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4401:1: ( (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4401:1: ( (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4402:1: (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4402:1: (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS )
            int alt74=2;
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
            case 52:
            case 60:
            case 61:
            case 62:
            case 63:
            case 71:
            case 76:
            case 77:
                {
                alt74=1;
                }
                break;
            case RULE_SIMPLE_ID:
                {
                int LA74_2 = input.LA(2);

                if ( (LA74_2==54) ) {
                    alt74=2;
                }
                else if ( (LA74_2==16||(LA74_2>=18 && LA74_2<=34)||LA74_2==50||LA74_2==55||LA74_2==64||LA74_2==66||LA74_2==72||LA74_2==81) ) {
                    alt74=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 74, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_ESCAPED_ID:
                {
                int LA74_3 = input.LA(2);

                if ( (LA74_3==16||(LA74_3>=18 && LA74_3<=34)||LA74_3==50||LA74_3==55||LA74_3==64||LA74_3==66||LA74_3==72||LA74_3==81) ) {
                    alt74=1;
                }
                else if ( (LA74_3==54) ) {
                    alt74=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 74, 3, input);

                    throw nvae;
                }
                }
                break;
            case 54:
                {
                alt74=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 74, 0, input);

                throw nvae;
            }

            switch (alt74) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4403:3: lv_ownedCondition_1_1= ruleExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getIfExpCSAccess().getOwnedConditionExpCSParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleIfExpCS9914);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4418:8: lv_ownedCondition_1_2= rulePatternExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getIfExpCSAccess().getOwnedConditionPatternExpCSParserRuleCall_1_0_1()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePatternExpCS_in_ruleIfExpCS9933);
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

            otherlv_2=(Token)match(input,72,FollowSets000.FOLLOW_72_in_ruleIfExpCS9948); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getIfExpCSAccess().getThenKeyword_2());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4440:1: ( (lv_ownedThenExpression_3_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4441:1: (lv_ownedThenExpression_3_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4441:1: (lv_ownedThenExpression_3_0= ruleExpCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4442:3: lv_ownedThenExpression_3_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIfExpCSAccess().getOwnedThenExpressionExpCSParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleIfExpCS9969);
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4458:2: ( (lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS ) )*
            loop75:
            do {
                int alt75=2;
                int LA75_0 = input.LA(1);

                if ( (LA75_0==75) ) {
                    alt75=1;
                }


                switch (alt75) {
            	case 1 :
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4459:1: (lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS )
            	    {
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4459:1: (lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS )
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4460:3: lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getIfExpCSAccess().getOwnedIfThenExpressionsElseIfThenExpCSParserRuleCall_4_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleElseIfThenExpCS_in_ruleIfExpCS9990);
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
            	    break loop75;
                }
            } while (true);

            otherlv_5=(Token)match(input,73,FollowSets000.FOLLOW_73_in_ruleIfExpCS10003); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getIfExpCSAccess().getElseKeyword_5());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4480:1: ( (lv_ownedElseExpression_6_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4481:1: (lv_ownedElseExpression_6_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4481:1: (lv_ownedElseExpression_6_0= ruleExpCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4482:3: lv_ownedElseExpression_6_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIfExpCSAccess().getOwnedElseExpressionExpCSParserRuleCall_6_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleIfExpCS10024);
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

            otherlv_7=(Token)match(input,74,FollowSets000.FOLLOW_74_in_ruleIfExpCS10036); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4510:1: entryRuleElseIfThenExpCS returns [EObject current=null] : iv_ruleElseIfThenExpCS= ruleElseIfThenExpCS EOF ;
    public final EObject entryRuleElseIfThenExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElseIfThenExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4511:2: (iv_ruleElseIfThenExpCS= ruleElseIfThenExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4512:2: iv_ruleElseIfThenExpCS= ruleElseIfThenExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getElseIfThenExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleElseIfThenExpCS_in_entryRuleElseIfThenExpCS10072);
            iv_ruleElseIfThenExpCS=ruleElseIfThenExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleElseIfThenExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleElseIfThenExpCS10082); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4519:1: ruleElseIfThenExpCS returns [EObject current=null] : (otherlv_0= 'elseif' ( (lv_ownedCondition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) ) ;
    public final EObject ruleElseIfThenExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_ownedCondition_1_0 = null;

        EObject lv_ownedThenExpression_3_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4522:28: ( (otherlv_0= 'elseif' ( (lv_ownedCondition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4523:1: (otherlv_0= 'elseif' ( (lv_ownedCondition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4523:1: (otherlv_0= 'elseif' ( (lv_ownedCondition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4523:3: otherlv_0= 'elseif' ( (lv_ownedCondition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) )
            {
            otherlv_0=(Token)match(input,75,FollowSets000.FOLLOW_75_in_ruleElseIfThenExpCS10119); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getElseIfThenExpCSAccess().getElseifKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4527:1: ( (lv_ownedCondition_1_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4528:1: (lv_ownedCondition_1_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4528:1: (lv_ownedCondition_1_0= ruleExpCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4529:3: lv_ownedCondition_1_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getElseIfThenExpCSAccess().getOwnedConditionExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleElseIfThenExpCS10140);
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

            otherlv_2=(Token)match(input,72,FollowSets000.FOLLOW_72_in_ruleElseIfThenExpCS10152); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getElseIfThenExpCSAccess().getThenKeyword_2());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4549:1: ( (lv_ownedThenExpression_3_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4550:1: (lv_ownedThenExpression_3_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4550:1: (lv_ownedThenExpression_3_0= ruleExpCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4551:3: lv_ownedThenExpression_3_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getElseIfThenExpCSAccess().getOwnedThenExpressionExpCSParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleElseIfThenExpCS10173);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4575:1: entryRuleLetExpCS returns [EObject current=null] : iv_ruleLetExpCS= ruleLetExpCS EOF ;
    public final EObject entryRuleLetExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLetExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4576:2: (iv_ruleLetExpCS= ruleLetExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4577:2: iv_ruleLetExpCS= ruleLetExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLetExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLetExpCS_in_entryRuleLetExpCS10209);
            iv_ruleLetExpCS=ruleLetExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLetExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLetExpCS10219); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4584:1: ruleLetExpCS returns [EObject current=null] : (otherlv_0= 'let' ( (lv_ownedVariables_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_ownedVariables_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_ownedInExpression_5_0= ruleExpCS ) ) ) ;
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
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4587:28: ( (otherlv_0= 'let' ( (lv_ownedVariables_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_ownedVariables_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_ownedInExpression_5_0= ruleExpCS ) ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4588:1: (otherlv_0= 'let' ( (lv_ownedVariables_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_ownedVariables_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_ownedInExpression_5_0= ruleExpCS ) ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4588:1: (otherlv_0= 'let' ( (lv_ownedVariables_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_ownedVariables_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_ownedInExpression_5_0= ruleExpCS ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4588:3: otherlv_0= 'let' ( (lv_ownedVariables_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_ownedVariables_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_ownedInExpression_5_0= ruleExpCS ) )
            {
            otherlv_0=(Token)match(input,76,FollowSets000.FOLLOW_76_in_ruleLetExpCS10256); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLetExpCSAccess().getLetKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4592:1: ( (lv_ownedVariables_1_0= ruleLetVariableCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4593:1: (lv_ownedVariables_1_0= ruleLetVariableCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4593:1: (lv_ownedVariables_1_0= ruleLetVariableCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4594:3: lv_ownedVariables_1_0= ruleLetVariableCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetExpCSAccess().getOwnedVariablesLetVariableCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleLetVariableCS_in_ruleLetExpCS10277);
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4610:2: (otherlv_2= ',' ( (lv_ownedVariables_3_0= ruleLetVariableCS ) ) )*
            loop76:
            do {
                int alt76=2;
                int LA76_0 = input.LA(1);

                if ( (LA76_0==53) ) {
                    alt76=1;
                }


                switch (alt76) {
            	case 1 :
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4610:4: otherlv_2= ',' ( (lv_ownedVariables_3_0= ruleLetVariableCS ) )
            	    {
            	    otherlv_2=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleLetExpCS10290); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getLetExpCSAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4614:1: ( (lv_ownedVariables_3_0= ruleLetVariableCS ) )
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4615:1: (lv_ownedVariables_3_0= ruleLetVariableCS )
            	    {
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4615:1: (lv_ownedVariables_3_0= ruleLetVariableCS )
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4616:3: lv_ownedVariables_3_0= ruleLetVariableCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLetExpCSAccess().getOwnedVariablesLetVariableCSParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleLetVariableCS_in_ruleLetExpCS10311);
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
            	    break loop76;
                }
            } while (true);

            otherlv_4=(Token)match(input,68,FollowSets000.FOLLOW_68_in_ruleLetExpCS10325); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getLetExpCSAccess().getInKeyword_3());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4636:1: ( (lv_ownedInExpression_5_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4637:1: (lv_ownedInExpression_5_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4637:1: (lv_ownedInExpression_5_0= ruleExpCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4638:3: lv_ownedInExpression_5_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetExpCSAccess().getOwnedInExpressionExpCSParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleLetExpCS10346);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4662:1: entryRuleLetVariableCS returns [EObject current=null] : iv_ruleLetVariableCS= ruleLetVariableCS EOF ;
    public final EObject entryRuleLetVariableCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLetVariableCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4663:2: (iv_ruleLetVariableCS= ruleLetVariableCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4664:2: iv_ruleLetVariableCS= ruleLetVariableCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLetVariableCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLetVariableCS_in_entryRuleLetVariableCS10382);
            iv_ruleLetVariableCS=ruleLetVariableCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLetVariableCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLetVariableCS10392); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4671:1: ruleLetVariableCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) ( (lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS ) )? (otherlv_2= ':' ( (lv_ownedType_3_0= ruleComplexTypeCS ) ) )? otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) ) ;
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
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4674:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) ( (lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS ) )? (otherlv_2= ':' ( (lv_ownedType_3_0= ruleComplexTypeCS ) ) )? otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4675:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) ( (lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS ) )? (otherlv_2= ':' ( (lv_ownedType_3_0= ruleComplexTypeCS ) ) )? otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4675:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) ( (lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS ) )? (otherlv_2= ':' ( (lv_ownedType_3_0= ruleComplexTypeCS ) ) )? otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4675:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) ( (lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS ) )? (otherlv_2= ':' ( (lv_ownedType_3_0= ruleComplexTypeCS ) ) )? otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4675:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4676:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4676:1: (lv_name_0_0= ruleUnrestrictedName )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4677:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetVariableCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleLetVariableCS10438);
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4693:2: ( (lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS ) )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==50) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4694:1: (lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4694:1: (lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4695:3: lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLetVariableCSAccess().getOwnedRoundBracketedClauseRoundBracketedClauseCSParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleRoundBracketedClauseCS_in_ruleLetVariableCS10459);
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4711:3: (otherlv_2= ':' ( (lv_ownedType_3_0= ruleComplexTypeCS ) ) )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==54) ) {
                alt78=1;
            }
            switch (alt78) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4711:5: otherlv_2= ':' ( (lv_ownedType_3_0= ruleComplexTypeCS ) )
                    {
                    otherlv_2=(Token)match(input,54,FollowSets000.FOLLOW_54_in_ruleLetVariableCS10473); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getLetVariableCSAccess().getColonKeyword_2_0());
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4715:1: ( (lv_ownedType_3_0= ruleComplexTypeCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4716:1: (lv_ownedType_3_0= ruleComplexTypeCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4716:1: (lv_ownedType_3_0= ruleComplexTypeCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4717:3: lv_ownedType_3_0= ruleComplexTypeCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLetVariableCSAccess().getOwnedTypeComplexTypeCSParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleComplexTypeCS_in_ruleLetVariableCS10494);
                    lv_ownedType_3_0=ruleComplexTypeCS();

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
                              		"ComplexTypeCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleLetVariableCS10508); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getLetVariableCSAccess().getEqualsSignKeyword_3());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4737:1: ( (lv_ownedInitExpression_5_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4738:1: (lv_ownedInitExpression_5_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4738:1: (lv_ownedInitExpression_5_0= ruleExpCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4739:3: lv_ownedInitExpression_5_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetVariableCSAccess().getOwnedInitExpressionExpCSParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleLetVariableCS10529);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4763:1: entryRuleNestedExpCS returns [EObject current=null] : iv_ruleNestedExpCS= ruleNestedExpCS EOF ;
    public final EObject entryRuleNestedExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNestedExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4764:2: (iv_ruleNestedExpCS= ruleNestedExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4765:2: iv_ruleNestedExpCS= ruleNestedExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNestedExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNestedExpCS_in_entryRuleNestedExpCS10565);
            iv_ruleNestedExpCS=ruleNestedExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNestedExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNestedExpCS10575); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4772:1: ruleNestedExpCS returns [EObject current=null] : (otherlv_0= '(' ( (lv_ownedExpression_1_0= ruleExpCS ) ) otherlv_2= ')' ) ;
    public final EObject ruleNestedExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_ownedExpression_1_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4775:28: ( (otherlv_0= '(' ( (lv_ownedExpression_1_0= ruleExpCS ) ) otherlv_2= ')' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4776:1: (otherlv_0= '(' ( (lv_ownedExpression_1_0= ruleExpCS ) ) otherlv_2= ')' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4776:1: (otherlv_0= '(' ( (lv_ownedExpression_1_0= ruleExpCS ) ) otherlv_2= ')' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4776:3: otherlv_0= '(' ( (lv_ownedExpression_1_0= ruleExpCS ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,50,FollowSets000.FOLLOW_50_in_ruleNestedExpCS10612); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getNestedExpCSAccess().getLeftParenthesisKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4780:1: ( (lv_ownedExpression_1_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4781:1: (lv_ownedExpression_1_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4781:1: (lv_ownedExpression_1_0= ruleExpCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4782:3: lv_ownedExpression_1_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNestedExpCSAccess().getOwnedExpressionExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNestedExpCS10633);
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

            otherlv_2=(Token)match(input,51,FollowSets000.FOLLOW_51_in_ruleNestedExpCS10645); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4810:1: entryRuleSelfExpCS returns [EObject current=null] : iv_ruleSelfExpCS= ruleSelfExpCS EOF ;
    public final EObject entryRuleSelfExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelfExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4811:2: (iv_ruleSelfExpCS= ruleSelfExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4812:2: iv_ruleSelfExpCS= ruleSelfExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSelfExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSelfExpCS_in_entryRuleSelfExpCS10681);
            iv_ruleSelfExpCS=ruleSelfExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSelfExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSelfExpCS10691); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4819:1: ruleSelfExpCS returns [EObject current=null] : ( () otherlv_1= 'self' ) ;
    public final EObject ruleSelfExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4822:28: ( ( () otherlv_1= 'self' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4823:1: ( () otherlv_1= 'self' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4823:1: ( () otherlv_1= 'self' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4823:2: () otherlv_1= 'self'
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4823:2: ()
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4824:2: 
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

            otherlv_1=(Token)match(input,77,FollowSets000.FOLLOW_77_in_ruleSelfExpCS10740); if (state.failed) return current;
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


    // $ANTLR start "entryRuleTemplateParameterActualCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4844:1: entryRuleTemplateParameterActualCS returns [EObject current=null] : iv_ruleTemplateParameterActualCS= ruleTemplateParameterActualCS EOF ;
    public final EObject entryRuleTemplateParameterActualCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTemplateParameterActualCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4845:2: (iv_ruleTemplateParameterActualCS= ruleTemplateParameterActualCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4846:2: iv_ruleTemplateParameterActualCS= ruleTemplateParameterActualCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTemplateParameterActualCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTemplateParameterActualCS_in_entryRuleTemplateParameterActualCS10776);
            iv_ruleTemplateParameterActualCS=ruleTemplateParameterActualCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTemplateParameterActualCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTemplateParameterActualCS10786); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTemplateParameterActualCS"


    // $ANTLR start "ruleTemplateParameterActualCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4853:1: ruleTemplateParameterActualCS returns [EObject current=null] : (this_ComplexTypeCS_0= ruleComplexTypeCS | this_WildcardTypeRefCS_1= ruleWildcardTypeRefCS | this_PrimitiveLiteralExpCS_2= rulePrimitiveLiteralExpCS ) ;
    public final EObject ruleTemplateParameterActualCS() throws RecognitionException {
        EObject current = null;

        EObject this_ComplexTypeCS_0 = null;

        EObject this_WildcardTypeRefCS_1 = null;

        EObject this_PrimitiveLiteralExpCS_2 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4856:28: ( (this_ComplexTypeCS_0= ruleComplexTypeCS | this_WildcardTypeRefCS_1= ruleWildcardTypeRefCS | this_PrimitiveLiteralExpCS_2= rulePrimitiveLiteralExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4857:1: (this_ComplexTypeCS_0= ruleComplexTypeCS | this_WildcardTypeRefCS_1= ruleWildcardTypeRefCS | this_PrimitiveLiteralExpCS_2= rulePrimitiveLiteralExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4857:1: (this_ComplexTypeCS_0= ruleComplexTypeCS | this_WildcardTypeRefCS_1= ruleWildcardTypeRefCS | this_PrimitiveLiteralExpCS_2= rulePrimitiveLiteralExpCS )
            int alt79=3;
            switch ( input.LA(1) ) {
            case RULE_SIMPLE_ID:
            case RULE_ESCAPED_ID:
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
            case 52:
                {
                alt79=1;
                }
                break;
            case 80:
                {
                alt79=2;
                }
                break;
            case RULE_INT:
            case RULE_SINGLE_QUOTED_STRING:
            case 18:
            case 60:
            case 61:
            case 62:
            case 63:
                {
                alt79=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 79, 0, input);

                throw nvae;
            }

            switch (alt79) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4858:2: this_ComplexTypeCS_0= ruleComplexTypeCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTemplateParameterActualCSAccess().getComplexTypeCSParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleComplexTypeCS_in_ruleTemplateParameterActualCS10836);
                    this_ComplexTypeCS_0=ruleComplexTypeCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ComplexTypeCS_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4871:2: this_WildcardTypeRefCS_1= ruleWildcardTypeRefCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTemplateParameterActualCSAccess().getWildcardTypeRefCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleWildcardTypeRefCS_in_ruleTemplateParameterActualCS10866);
                    this_WildcardTypeRefCS_1=ruleWildcardTypeRefCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_WildcardTypeRefCS_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4884:2: this_PrimitiveLiteralExpCS_2= rulePrimitiveLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTemplateParameterActualCSAccess().getPrimitiveLiteralExpCSParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrimitiveLiteralExpCS_in_ruleTemplateParameterActualCS10896);
                    this_PrimitiveLiteralExpCS_2=rulePrimitiveLiteralExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_PrimitiveLiteralExpCS_2; 
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
    // $ANTLR end "ruleTemplateParameterActualCS"


    // $ANTLR start "entryRuleMultiplicityBoundsCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4903:1: entryRuleMultiplicityBoundsCS returns [EObject current=null] : iv_ruleMultiplicityBoundsCS= ruleMultiplicityBoundsCS EOF ;
    public final EObject entryRuleMultiplicityBoundsCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicityBoundsCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4904:2: (iv_ruleMultiplicityBoundsCS= ruleMultiplicityBoundsCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4905:2: iv_ruleMultiplicityBoundsCS= ruleMultiplicityBoundsCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicityBoundsCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMultiplicityBoundsCS_in_entryRuleMultiplicityBoundsCS10931);
            iv_ruleMultiplicityBoundsCS=ruleMultiplicityBoundsCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicityBoundsCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMultiplicityBoundsCS10941); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4912:1: ruleMultiplicityBoundsCS returns [EObject current=null] : ( ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )? ) ;
    public final EObject ruleMultiplicityBoundsCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_lowerBound_0_0 = null;

        AntlrDatatypeRuleToken lv_upperBound_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4915:28: ( ( ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )? ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4916:1: ( ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )? )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4916:1: ( ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )? )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4916:2: ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )?
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4916:2: ( (lv_lowerBound_0_0= ruleLOWER ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4917:1: (lv_lowerBound_0_0= ruleLOWER )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4917:1: (lv_lowerBound_0_0= ruleLOWER )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4918:3: lv_lowerBound_0_0= ruleLOWER
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiplicityBoundsCSAccess().getLowerBoundLOWERParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleLOWER_in_ruleMultiplicityBoundsCS10987);
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4934:2: (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==57) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4934:4: otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) )
                    {
                    otherlv_1=(Token)match(input,57,FollowSets000.FOLLOW_57_in_ruleMultiplicityBoundsCS11000); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getMultiplicityBoundsCSAccess().getFullStopFullStopKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4938:1: ( (lv_upperBound_2_0= ruleUPPER ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4939:1: (lv_upperBound_2_0= ruleUPPER )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4939:1: (lv_upperBound_2_0= ruleUPPER )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4940:3: lv_upperBound_2_0= ruleUPPER
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMultiplicityBoundsCSAccess().getUpperBoundUPPERParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUPPER_in_ruleMultiplicityBoundsCS11021);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4964:1: entryRuleMultiplicityCS returns [EObject current=null] : iv_ruleMultiplicityCS= ruleMultiplicityCS EOF ;
    public final EObject entryRuleMultiplicityCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicityCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4965:2: (iv_ruleMultiplicityCS= ruleMultiplicityCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4966:2: iv_ruleMultiplicityCS= ruleMultiplicityCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicityCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMultiplicityCS_in_entryRuleMultiplicityCS11059);
            iv_ruleMultiplicityCS=ruleMultiplicityCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicityCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMultiplicityCS11069); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4973:1: ruleMultiplicityCS returns [EObject current=null] : (otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) (otherlv_3= '|?' | ( (lv_isNullFree_4_0= '|1' ) ) )? otherlv_5= ']' ) ;
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
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4976:28: ( (otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) (otherlv_3= '|?' | ( (lv_isNullFree_4_0= '|1' ) ) )? otherlv_5= ']' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4977:1: (otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) (otherlv_3= '|?' | ( (lv_isNullFree_4_0= '|1' ) ) )? otherlv_5= ']' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4977:1: (otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) (otherlv_3= '|?' | ( (lv_isNullFree_4_0= '|1' ) ) )? otherlv_5= ']' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4977:3: otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) (otherlv_3= '|?' | ( (lv_isNullFree_4_0= '|1' ) ) )? otherlv_5= ']'
            {
            otherlv_0=(Token)match(input,66,FollowSets000.FOLLOW_66_in_ruleMultiplicityCS11106); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMultiplicityCSAccess().getLeftSquareBracketKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4981:1: (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS )
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==RULE_INT) ) {
                alt81=1;
            }
            else if ( (LA81_0==18||LA81_0==20||LA81_0==80) ) {
                alt81=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 81, 0, input);

                throw nvae;
            }
            switch (alt81) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4982:2: this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getMultiplicityCSAccess().getMultiplicityBoundsCSParserRuleCall_1_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMultiplicityBoundsCS_in_ruleMultiplicityCS11132);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4995:2: this_MultiplicityStringCS_2= ruleMultiplicityStringCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getMultiplicityCSAccess().getMultiplicityStringCSParserRuleCall_1_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMultiplicityStringCS_in_ruleMultiplicityCS11162);
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5006:2: (otherlv_3= '|?' | ( (lv_isNullFree_4_0= '|1' ) ) )?
            int alt82=3;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==78) ) {
                alt82=1;
            }
            else if ( (LA82_0==79) ) {
                alt82=2;
            }
            switch (alt82) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5006:4: otherlv_3= '|?'
                    {
                    otherlv_3=(Token)match(input,78,FollowSets000.FOLLOW_78_in_ruleMultiplicityCS11175); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getMultiplicityCSAccess().getVerticalLineQuestionMarkKeyword_2_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5011:6: ( (lv_isNullFree_4_0= '|1' ) )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5011:6: ( (lv_isNullFree_4_0= '|1' ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5012:1: (lv_isNullFree_4_0= '|1' )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5012:1: (lv_isNullFree_4_0= '|1' )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5013:3: lv_isNullFree_4_0= '|1'
                    {
                    lv_isNullFree_4_0=(Token)match(input,79,FollowSets000.FOLLOW_79_in_ruleMultiplicityCS11199); if (state.failed) return current;
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

            otherlv_5=(Token)match(input,67,FollowSets000.FOLLOW_67_in_ruleMultiplicityCS11226); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5038:1: entryRuleMultiplicityStringCS returns [EObject current=null] : iv_ruleMultiplicityStringCS= ruleMultiplicityStringCS EOF ;
    public final EObject entryRuleMultiplicityStringCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicityStringCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5039:2: (iv_ruleMultiplicityStringCS= ruleMultiplicityStringCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5040:2: iv_ruleMultiplicityStringCS= ruleMultiplicityStringCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicityStringCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMultiplicityStringCS_in_entryRuleMultiplicityStringCS11262);
            iv_ruleMultiplicityStringCS=ruleMultiplicityStringCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicityStringCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMultiplicityStringCS11272); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5047:1: ruleMultiplicityStringCS returns [EObject current=null] : ( ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) ) ) ;
    public final EObject ruleMultiplicityStringCS() throws RecognitionException {
        EObject current = null;

        Token lv_stringBounds_0_1=null;
        Token lv_stringBounds_0_2=null;
        Token lv_stringBounds_0_3=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5050:28: ( ( ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5051:1: ( ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5051:1: ( ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5052:1: ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5052:1: ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5053:1: (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5053:1: (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' )
            int alt83=3;
            switch ( input.LA(1) ) {
            case 18:
                {
                alt83=1;
                }
                break;
            case 20:
                {
                alt83=2;
                }
                break;
            case 80:
                {
                alt83=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 83, 0, input);

                throw nvae;
            }

            switch (alt83) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5054:3: lv_stringBounds_0_1= '*'
                    {
                    lv_stringBounds_0_1=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleMultiplicityStringCS11316); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5066:8: lv_stringBounds_0_2= '+'
                    {
                    lv_stringBounds_0_2=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleMultiplicityStringCS11345); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5078:8: lv_stringBounds_0_3= '?'
                    {
                    lv_stringBounds_0_3=(Token)match(input,80,FollowSets000.FOLLOW_80_in_ruleMultiplicityStringCS11374); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5101:1: entryRulePathNameCS returns [EObject current=null] : iv_rulePathNameCS= rulePathNameCS EOF ;
    public final EObject entryRulePathNameCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePathNameCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5102:2: (iv_rulePathNameCS= rulePathNameCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5103:2: iv_rulePathNameCS= rulePathNameCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPathNameCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePathNameCS_in_entryRulePathNameCS11425);
            iv_rulePathNameCS=rulePathNameCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePathNameCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePathNameCS11435); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5110:1: rulePathNameCS returns [EObject current=null] : ( ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )* ) ;
    public final EObject rulePathNameCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_ownedPathElements_0_0 = null;

        EObject lv_ownedPathElements_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5113:28: ( ( ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )* ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5114:1: ( ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )* )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5114:1: ( ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )* )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5114:2: ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )*
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5114:2: ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5115:1: (lv_ownedPathElements_0_0= ruleFirstPathElementCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5115:1: (lv_ownedPathElements_0_0= ruleFirstPathElementCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5116:3: lv_ownedPathElements_0_0= ruleFirstPathElementCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPathNameCSAccess().getOwnedPathElementsFirstPathElementCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleFirstPathElementCS_in_rulePathNameCS11481);
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5132:2: (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )*
            loop84:
            do {
                int alt84=2;
                int LA84_0 = input.LA(1);

                if ( (LA84_0==81) ) {
                    alt84=1;
                }


                switch (alt84) {
            	case 1 :
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5132:4: otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) )
            	    {
            	    otherlv_1=(Token)match(input,81,FollowSets000.FOLLOW_81_in_rulePathNameCS11494); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getPathNameCSAccess().getColonColonKeyword_1_0());
            	          
            	    }
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5136:1: ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) )
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5137:1: (lv_ownedPathElements_2_0= ruleNextPathElementCS )
            	    {
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5137:1: (lv_ownedPathElements_2_0= ruleNextPathElementCS )
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5138:3: lv_ownedPathElements_2_0= ruleNextPathElementCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getPathNameCSAccess().getOwnedPathElementsNextPathElementCSParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleNextPathElementCS_in_rulePathNameCS11515);
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
            	    break loop84;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5162:1: entryRuleFirstPathElementCS returns [EObject current=null] : iv_ruleFirstPathElementCS= ruleFirstPathElementCS EOF ;
    public final EObject entryRuleFirstPathElementCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFirstPathElementCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5163:2: (iv_ruleFirstPathElementCS= ruleFirstPathElementCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5164:2: iv_ruleFirstPathElementCS= ruleFirstPathElementCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFirstPathElementCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleFirstPathElementCS_in_entryRuleFirstPathElementCS11553);
            iv_ruleFirstPathElementCS=ruleFirstPathElementCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFirstPathElementCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFirstPathElementCS11563); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5171:1: ruleFirstPathElementCS returns [EObject current=null] : ( ( ruleUnrestrictedName ) ) ;
    public final EObject ruleFirstPathElementCS() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5174:28: ( ( ( ruleUnrestrictedName ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5175:1: ( ( ruleUnrestrictedName ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5175:1: ( ( ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5176:1: ( ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5176:1: ( ruleUnrestrictedName )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5177:3: ruleUnrestrictedName
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
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleFirstPathElementCS11614);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5201:1: entryRuleNextPathElementCS returns [EObject current=null] : iv_ruleNextPathElementCS= ruleNextPathElementCS EOF ;
    public final EObject entryRuleNextPathElementCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNextPathElementCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5202:2: (iv_ruleNextPathElementCS= ruleNextPathElementCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5203:2: iv_ruleNextPathElementCS= ruleNextPathElementCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNextPathElementCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNextPathElementCS_in_entryRuleNextPathElementCS11649);
            iv_ruleNextPathElementCS=ruleNextPathElementCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNextPathElementCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNextPathElementCS11659); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5210:1: ruleNextPathElementCS returns [EObject current=null] : ( ( ruleUnreservedName ) ) ;
    public final EObject ruleNextPathElementCS() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5213:28: ( ( ( ruleUnreservedName ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5214:1: ( ( ruleUnreservedName ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5214:1: ( ( ruleUnreservedName ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5215:1: ( ruleUnreservedName )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5215:1: ( ruleUnreservedName )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5216:3: ruleUnreservedName
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
            pushFollow(FollowSets000.FOLLOW_ruleUnreservedName_in_ruleNextPathElementCS11710);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5240:1: entryRulePathTypeCS returns [EObject current=null] : iv_rulePathTypeCS= rulePathTypeCS EOF ;
    public final EObject entryRulePathTypeCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePathTypeCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5241:2: (iv_rulePathTypeCS= rulePathTypeCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5242:2: iv_rulePathTypeCS= rulePathTypeCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPathTypeCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePathTypeCS_in_entryRulePathTypeCS11745);
            iv_rulePathTypeCS=rulePathTypeCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePathTypeCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePathTypeCS11755); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5249:1: rulePathTypeCS returns [EObject current=null] : ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) (otherlv_1= '(' ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) ) otherlv_3= ')' )? ) ;
    public final EObject rulePathTypeCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_ownedPathName_0_0 = null;

        EObject lv_ownedBinding_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5252:28: ( ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) (otherlv_1= '(' ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) ) otherlv_3= ')' )? ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5253:1: ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) (otherlv_1= '(' ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) ) otherlv_3= ')' )? )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5253:1: ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) (otherlv_1= '(' ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) ) otherlv_3= ')' )? )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5253:2: ( (lv_ownedPathName_0_0= rulePathNameCS ) ) (otherlv_1= '(' ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) ) otherlv_3= ')' )?
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5253:2: ( (lv_ownedPathName_0_0= rulePathNameCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5254:1: (lv_ownedPathName_0_0= rulePathNameCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5254:1: (lv_ownedPathName_0_0= rulePathNameCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5255:3: lv_ownedPathName_0_0= rulePathNameCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPathTypeCSAccess().getOwnedPathNamePathNameCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_rulePathNameCS_in_rulePathTypeCS11801);
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5271:2: (otherlv_1= '(' ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) ) otherlv_3= ')' )?
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==50) ) {
                alt85=1;
            }
            switch (alt85) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5271:4: otherlv_1= '(' ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) ) otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,50,FollowSets000.FOLLOW_50_in_rulePathTypeCS11814); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getPathTypeCSAccess().getLeftParenthesisKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5275:1: ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5276:1: (lv_ownedBinding_2_0= ruleTemplateBindingCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5276:1: (lv_ownedBinding_2_0= ruleTemplateBindingCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5277:3: lv_ownedBinding_2_0= ruleTemplateBindingCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPathTypeCSAccess().getOwnedBindingTemplateBindingCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTemplateBindingCS_in_rulePathTypeCS11835);
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

                    otherlv_3=(Token)match(input,51,FollowSets000.FOLLOW_51_in_rulePathTypeCS11847); if (state.failed) return current;
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


    // $ANTLR start "entryRuleTemplateBindingCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5305:1: entryRuleTemplateBindingCS returns [EObject current=null] : iv_ruleTemplateBindingCS= ruleTemplateBindingCS EOF ;
    public final EObject entryRuleTemplateBindingCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTemplateBindingCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5306:2: (iv_ruleTemplateBindingCS= ruleTemplateBindingCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5307:2: iv_ruleTemplateBindingCS= ruleTemplateBindingCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTemplateBindingCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTemplateBindingCS_in_entryRuleTemplateBindingCS11885);
            iv_ruleTemplateBindingCS=ruleTemplateBindingCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTemplateBindingCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTemplateBindingCS11895); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5314:1: ruleTemplateBindingCS returns [EObject current=null] : ( ( (lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS ) ) (otherlv_1= ',' ( (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS ) ) )* ) ;
    public final EObject ruleTemplateBindingCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_ownedSubstitutions_0_0 = null;

        EObject lv_ownedSubstitutions_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5317:28: ( ( ( (lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS ) ) (otherlv_1= ',' ( (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS ) ) )* ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5318:1: ( ( (lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS ) ) (otherlv_1= ',' ( (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS ) ) )* )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5318:1: ( ( (lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS ) ) (otherlv_1= ',' ( (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS ) ) )* )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5318:2: ( (lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS ) ) (otherlv_1= ',' ( (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS ) ) )*
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5318:2: ( (lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5319:1: (lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5319:1: (lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5320:3: lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsTemplateParameterSubstitutionCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTemplateParameterSubstitutionCS_in_ruleTemplateBindingCS11941);
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5336:2: (otherlv_1= ',' ( (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS ) ) )*
            loop86:
            do {
                int alt86=2;
                int LA86_0 = input.LA(1);

                if ( (LA86_0==53) ) {
                    alt86=1;
                }


                switch (alt86) {
            	case 1 :
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5336:4: otherlv_1= ',' ( (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS ) )
            	    {
            	    otherlv_1=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleTemplateBindingCS11954); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getTemplateBindingCSAccess().getCommaKeyword_1_0());
            	          
            	    }
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5340:1: ( (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS ) )
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5341:1: (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS )
            	    {
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5341:1: (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS )
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5342:3: lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsTemplateParameterSubstitutionCSParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleTemplateParameterSubstitutionCS_in_ruleTemplateBindingCS11975);
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
            	    break loop86;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5366:1: entryRuleTemplateParameterSubstitutionCS returns [EObject current=null] : iv_ruleTemplateParameterSubstitutionCS= ruleTemplateParameterSubstitutionCS EOF ;
    public final EObject entryRuleTemplateParameterSubstitutionCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTemplateParameterSubstitutionCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5367:2: (iv_ruleTemplateParameterSubstitutionCS= ruleTemplateParameterSubstitutionCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5368:2: iv_ruleTemplateParameterSubstitutionCS= ruleTemplateParameterSubstitutionCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTemplateParameterSubstitutionCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTemplateParameterSubstitutionCS_in_entryRuleTemplateParameterSubstitutionCS12013);
            iv_ruleTemplateParameterSubstitutionCS=ruleTemplateParameterSubstitutionCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTemplateParameterSubstitutionCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTemplateParameterSubstitutionCS12023); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5375:1: ruleTemplateParameterSubstitutionCS returns [EObject current=null] : ( (lv_ownedActualParameter_0_0= ruleTemplateParameterActualCS ) ) ;
    public final EObject ruleTemplateParameterSubstitutionCS() throws RecognitionException {
        EObject current = null;

        EObject lv_ownedActualParameter_0_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5378:28: ( ( (lv_ownedActualParameter_0_0= ruleTemplateParameterActualCS ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5379:1: ( (lv_ownedActualParameter_0_0= ruleTemplateParameterActualCS ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5379:1: ( (lv_ownedActualParameter_0_0= ruleTemplateParameterActualCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5380:1: (lv_ownedActualParameter_0_0= ruleTemplateParameterActualCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5380:1: (lv_ownedActualParameter_0_0= ruleTemplateParameterActualCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5381:3: lv_ownedActualParameter_0_0= ruleTemplateParameterActualCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTemplateParameterSubstitutionCSAccess().getOwnedActualParameterTemplateParameterActualCSParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTemplateParameterActualCS_in_ruleTemplateParameterSubstitutionCS12068);
            lv_ownedActualParameter_0_0=ruleTemplateParameterActualCS();

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
                      		"TemplateParameterActualCS");
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


    // $ANTLR start "entryRuleTemplateSignatureCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5405:1: entryRuleTemplateSignatureCS returns [EObject current=null] : iv_ruleTemplateSignatureCS= ruleTemplateSignatureCS EOF ;
    public final EObject entryRuleTemplateSignatureCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTemplateSignatureCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5406:2: (iv_ruleTemplateSignatureCS= ruleTemplateSignatureCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5407:2: iv_ruleTemplateSignatureCS= ruleTemplateSignatureCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTemplateSignatureCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTemplateSignatureCS_in_entryRuleTemplateSignatureCS12103);
            iv_ruleTemplateSignatureCS=ruleTemplateSignatureCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTemplateSignatureCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTemplateSignatureCS12113); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTemplateSignatureCS"


    // $ANTLR start "ruleTemplateSignatureCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5414:1: ruleTemplateSignatureCS returns [EObject current=null] : (otherlv_0= '<' ( (lv_ownedParameters_1_0= ruleTypeParameterCS ) ) (otherlv_2= ',' ( (lv_ownedParameters_3_0= ruleTypeParameterCS ) ) )* otherlv_4= '>' ) ;
    public final EObject ruleTemplateSignatureCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_ownedParameters_1_0 = null;

        EObject lv_ownedParameters_3_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5417:28: ( (otherlv_0= '<' ( (lv_ownedParameters_1_0= ruleTypeParameterCS ) ) (otherlv_2= ',' ( (lv_ownedParameters_3_0= ruleTypeParameterCS ) ) )* otherlv_4= '>' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5418:1: (otherlv_0= '<' ( (lv_ownedParameters_1_0= ruleTypeParameterCS ) ) (otherlv_2= ',' ( (lv_ownedParameters_3_0= ruleTypeParameterCS ) ) )* otherlv_4= '>' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5418:1: (otherlv_0= '<' ( (lv_ownedParameters_1_0= ruleTypeParameterCS ) ) (otherlv_2= ',' ( (lv_ownedParameters_3_0= ruleTypeParameterCS ) ) )* otherlv_4= '>' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5418:3: otherlv_0= '<' ( (lv_ownedParameters_1_0= ruleTypeParameterCS ) ) (otherlv_2= ',' ( (lv_ownedParameters_3_0= ruleTypeParameterCS ) ) )* otherlv_4= '>'
            {
            otherlv_0=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleTemplateSignatureCS12150); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getTemplateSignatureCSAccess().getLessThanSignKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5422:1: ( (lv_ownedParameters_1_0= ruleTypeParameterCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5423:1: (lv_ownedParameters_1_0= ruleTypeParameterCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5423:1: (lv_ownedParameters_1_0= ruleTypeParameterCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5424:3: lv_ownedParameters_1_0= ruleTypeParameterCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTemplateSignatureCSAccess().getOwnedParametersTypeParameterCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeParameterCS_in_ruleTemplateSignatureCS12171);
            lv_ownedParameters_1_0=ruleTypeParameterCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTemplateSignatureCSRule());
              	        }
                     		add(
                     			current, 
                     			"ownedParameters",
                      		lv_ownedParameters_1_0, 
                      		"TypeParameterCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5440:2: (otherlv_2= ',' ( (lv_ownedParameters_3_0= ruleTypeParameterCS ) ) )*
            loop87:
            do {
                int alt87=2;
                int LA87_0 = input.LA(1);

                if ( (LA87_0==53) ) {
                    alt87=1;
                }


                switch (alt87) {
            	case 1 :
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5440:4: otherlv_2= ',' ( (lv_ownedParameters_3_0= ruleTypeParameterCS ) )
            	    {
            	    otherlv_2=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleTemplateSignatureCS12184); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getTemplateSignatureCSAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5444:1: ( (lv_ownedParameters_3_0= ruleTypeParameterCS ) )
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5445:1: (lv_ownedParameters_3_0= ruleTypeParameterCS )
            	    {
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5445:1: (lv_ownedParameters_3_0= ruleTypeParameterCS )
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5446:3: lv_ownedParameters_3_0= ruleTypeParameterCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTemplateSignatureCSAccess().getOwnedParametersTypeParameterCSParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleTypeParameterCS_in_ruleTemplateSignatureCS12205);
            	    lv_ownedParameters_3_0=ruleTypeParameterCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getTemplateSignatureCSRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedParameters",
            	              		lv_ownedParameters_3_0, 
            	              		"TypeParameterCS");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop87;
                }
            } while (true);

            otherlv_4=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleTemplateSignatureCS12219); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getTemplateSignatureCSAccess().getGreaterThanSignKeyword_3());
                  
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
    // $ANTLR end "ruleTemplateSignatureCS"


    // $ANTLR start "entryRuleTypeParameterCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5474:1: entryRuleTypeParameterCS returns [EObject current=null] : iv_ruleTypeParameterCS= ruleTypeParameterCS EOF ;
    public final EObject entryRuleTypeParameterCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeParameterCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5475:2: (iv_ruleTypeParameterCS= ruleTypeParameterCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5476:2: iv_ruleTypeParameterCS= ruleTypeParameterCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeParameterCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeParameterCS_in_entryRuleTypeParameterCS12255);
            iv_ruleTypeParameterCS=ruleTypeParameterCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeParameterCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeParameterCS12265); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5483:1: ruleTypeParameterCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleSimpleTypeCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleSimpleTypeCS ) ) )* )? ) ;
    public final EObject ruleTypeParameterCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedExtends_2_0 = null;

        EObject lv_ownedExtends_4_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5486:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleSimpleTypeCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleSimpleTypeCS ) ) )* )? ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5487:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleSimpleTypeCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleSimpleTypeCS ) ) )* )? )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5487:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleSimpleTypeCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleSimpleTypeCS ) ) )* )? )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5487:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleSimpleTypeCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleSimpleTypeCS ) ) )* )?
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5487:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5488:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5488:1: (lv_name_0_0= ruleUnrestrictedName )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5489:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypeParameterCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleTypeParameterCS12311);
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5505:2: (otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleSimpleTypeCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleSimpleTypeCS ) ) )* )?
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( (LA89_0==82) ) {
                alt89=1;
            }
            switch (alt89) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5505:4: otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleSimpleTypeCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleSimpleTypeCS ) ) )*
                    {
                    otherlv_1=(Token)match(input,82,FollowSets000.FOLLOW_82_in_ruleTypeParameterCS12324); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getTypeParameterCSAccess().getExtendsKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5509:1: ( (lv_ownedExtends_2_0= ruleSimpleTypeCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5510:1: (lv_ownedExtends_2_0= ruleSimpleTypeCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5510:1: (lv_ownedExtends_2_0= ruleSimpleTypeCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5511:3: lv_ownedExtends_2_0= ruleSimpleTypeCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsSimpleTypeCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSimpleTypeCS_in_ruleTypeParameterCS12345);
                    lv_ownedExtends_2_0=ruleSimpleTypeCS();

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
                              		"SimpleTypeCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5527:2: (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleSimpleTypeCS ) ) )*
                    loop88:
                    do {
                        int alt88=2;
                        int LA88_0 = input.LA(1);

                        if ( (LA88_0==83) ) {
                            alt88=1;
                        }


                        switch (alt88) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5527:4: otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleSimpleTypeCS ) )
                    	    {
                    	    otherlv_3=(Token)match(input,83,FollowSets000.FOLLOW_83_in_ruleTypeParameterCS12358); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getTypeParameterCSAccess().getAmpersandAmpersandKeyword_1_2_0());
                    	          
                    	    }
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5531:1: ( (lv_ownedExtends_4_0= ruleSimpleTypeCS ) )
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5532:1: (lv_ownedExtends_4_0= ruleSimpleTypeCS )
                    	    {
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5532:1: (lv_ownedExtends_4_0= ruleSimpleTypeCS )
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5533:3: lv_ownedExtends_4_0= ruleSimpleTypeCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsSimpleTypeCSParserRuleCall_1_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleSimpleTypeCS_in_ruleTypeParameterCS12379);
                    	    lv_ownedExtends_4_0=ruleSimpleTypeCS();

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
                    	              		"SimpleTypeCS");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop88;
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


    // $ANTLR start "entryRuleWildcardTypeRefCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5559:1: entryRuleWildcardTypeRefCS returns [EObject current=null] : iv_ruleWildcardTypeRefCS= ruleWildcardTypeRefCS EOF ;
    public final EObject entryRuleWildcardTypeRefCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWildcardTypeRefCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5560:2: (iv_ruleWildcardTypeRefCS= ruleWildcardTypeRefCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5561:2: iv_ruleWildcardTypeRefCS= ruleWildcardTypeRefCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getWildcardTypeRefCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleWildcardTypeRefCS_in_entryRuleWildcardTypeRefCS12421);
            iv_ruleWildcardTypeRefCS=ruleWildcardTypeRefCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleWildcardTypeRefCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleWildcardTypeRefCS12431); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5568:1: ruleWildcardTypeRefCS returns [EObject current=null] : ( () otherlv_1= '?' (otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleSimpleTypeCS ) ) )? ) ;
    public final EObject ruleWildcardTypeRefCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_ownedExtends_3_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5571:28: ( ( () otherlv_1= '?' (otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleSimpleTypeCS ) ) )? ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5572:1: ( () otherlv_1= '?' (otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleSimpleTypeCS ) ) )? )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5572:1: ( () otherlv_1= '?' (otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleSimpleTypeCS ) ) )? )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5572:2: () otherlv_1= '?' (otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleSimpleTypeCS ) ) )?
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5572:2: ()
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5573:2: 
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

            otherlv_1=(Token)match(input,80,FollowSets000.FOLLOW_80_in_ruleWildcardTypeRefCS12480); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getWildcardTypeRefCSAccess().getQuestionMarkKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5585:1: (otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleSimpleTypeCS ) ) )?
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==82) ) {
                alt90=1;
            }
            switch (alt90) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5585:3: otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleSimpleTypeCS ) )
                    {
                    otherlv_2=(Token)match(input,82,FollowSets000.FOLLOW_82_in_ruleWildcardTypeRefCS12493); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getWildcardTypeRefCSAccess().getExtendsKeyword_2_0());
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5589:1: ( (lv_ownedExtends_3_0= ruleSimpleTypeCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5590:1: (lv_ownedExtends_3_0= ruleSimpleTypeCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5590:1: (lv_ownedExtends_3_0= ruleSimpleTypeCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5591:3: lv_ownedExtends_3_0= ruleSimpleTypeCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getWildcardTypeRefCSAccess().getOwnedExtendsSimpleTypeCSParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSimpleTypeCS_in_ruleWildcardTypeRefCS12514);
                    lv_ownedExtends_3_0=ruleSimpleTypeCS();

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
                              		"SimpleTypeCS");
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5615:1: entryRuleID returns [String current=null] : iv_ruleID= ruleID EOF ;
    public final String entryRuleID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleID = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5616:2: (iv_ruleID= ruleID EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5617:2: iv_ruleID= ruleID EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIDRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleID_in_entryRuleID12553);
            iv_ruleID=ruleID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleID.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleID12564); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5624:1: ruleID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_SIMPLE_ID_0= RULE_SIMPLE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID ) ;
    public final AntlrDatatypeRuleToken ruleID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_SIMPLE_ID_0=null;
        Token this_ESCAPED_ID_1=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5627:28: ( (this_SIMPLE_ID_0= RULE_SIMPLE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5628:1: (this_SIMPLE_ID_0= RULE_SIMPLE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5628:1: (this_SIMPLE_ID_0= RULE_SIMPLE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID )
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( (LA91_0==RULE_SIMPLE_ID) ) {
                alt91=1;
            }
            else if ( (LA91_0==RULE_ESCAPED_ID) ) {
                alt91=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 91, 0, input);

                throw nvae;
            }
            switch (alt91) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5628:6: this_SIMPLE_ID_0= RULE_SIMPLE_ID
                    {
                    this_SIMPLE_ID_0=(Token)match(input,RULE_SIMPLE_ID,FollowSets000.FOLLOW_RULE_SIMPLE_ID_in_ruleID12604); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SIMPLE_ID_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SIMPLE_ID_0, grammarAccess.getIDAccess().getSIMPLE_IDTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5636:10: this_ESCAPED_ID_1= RULE_ESCAPED_ID
                    {
                    this_ESCAPED_ID_1=(Token)match(input,RULE_ESCAPED_ID,FollowSets000.FOLLOW_RULE_ESCAPED_ID_in_ruleID12630); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5651:1: entryRuleIdentifier returns [String current=null] : iv_ruleIdentifier= ruleIdentifier EOF ;
    public final String entryRuleIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdentifier = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5652:2: (iv_ruleIdentifier= ruleIdentifier EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5653:2: iv_ruleIdentifier= ruleIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIdentifierRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_entryRuleIdentifier12676);
            iv_ruleIdentifier=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIdentifier.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIdentifier12687); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5660:1: ruleIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= ruleID ;
    public final AntlrDatatypeRuleToken ruleIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_ID_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5663:28: (this_ID_0= ruleID )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5665:5: this_ID_0= ruleID
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getIdentifierAccess().getIDParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleID_in_ruleIdentifier12733);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5683:1: entryRuleLOWER returns [String current=null] : iv_ruleLOWER= ruleLOWER EOF ;
    public final String entryRuleLOWER() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLOWER = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5684:2: (iv_ruleLOWER= ruleLOWER EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5685:2: iv_ruleLOWER= ruleLOWER EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLOWERRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLOWER_in_entryRuleLOWER12778);
            iv_ruleLOWER=ruleLOWER();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLOWER.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLOWER12789); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5692:1: ruleLOWER returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INT_0= RULE_INT ;
    public final AntlrDatatypeRuleToken ruleLOWER() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5695:28: (this_INT_0= RULE_INT )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5696:5: this_INT_0= RULE_INT
            {
            this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleLOWER12828); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5711:1: entryRuleNUMBER_LITERAL returns [String current=null] : iv_ruleNUMBER_LITERAL= ruleNUMBER_LITERAL EOF ;
    public final String entryRuleNUMBER_LITERAL() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNUMBER_LITERAL = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5712:2: (iv_ruleNUMBER_LITERAL= ruleNUMBER_LITERAL EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5713:2: iv_ruleNUMBER_LITERAL= ruleNUMBER_LITERAL EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNUMBER_LITERALRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNUMBER_LITERAL_in_entryRuleNUMBER_LITERAL12873);
            iv_ruleNUMBER_LITERAL=ruleNUMBER_LITERAL();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNUMBER_LITERAL.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNUMBER_LITERAL12884); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5720:1: ruleNUMBER_LITERAL returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INT_0= RULE_INT ;
    public final AntlrDatatypeRuleToken ruleNUMBER_LITERAL() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5723:28: (this_INT_0= RULE_INT )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5724:5: this_INT_0= RULE_INT
            {
            this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleNUMBER_LITERAL12923); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5739:1: entryRuleStringLiteral returns [String current=null] : iv_ruleStringLiteral= ruleStringLiteral EOF ;
    public final String entryRuleStringLiteral() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleStringLiteral = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5740:2: (iv_ruleStringLiteral= ruleStringLiteral EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5741:2: iv_ruleStringLiteral= ruleStringLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStringLiteralRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral12968);
            iv_ruleStringLiteral=ruleStringLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStringLiteral.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleStringLiteral12979); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5748:1: ruleStringLiteral returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING ;
    public final AntlrDatatypeRuleToken ruleStringLiteral() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_SINGLE_QUOTED_STRING_0=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5751:28: (this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5752:5: this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING
            {
            this_SINGLE_QUOTED_STRING_0=(Token)match(input,RULE_SINGLE_QUOTED_STRING,FollowSets000.FOLLOW_RULE_SINGLE_QUOTED_STRING_in_ruleStringLiteral13018); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5767:1: entryRuleUPPER returns [String current=null] : iv_ruleUPPER= ruleUPPER EOF ;
    public final String entryRuleUPPER() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUPPER = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5768:2: (iv_ruleUPPER= ruleUPPER EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5769:2: iv_ruleUPPER= ruleUPPER EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUPPERRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUPPER_in_entryRuleUPPER13063);
            iv_ruleUPPER=ruleUPPER();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUPPER.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUPPER13074); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5776:1: ruleUPPER returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT | kw= '*' ) ;
    public final AntlrDatatypeRuleToken ruleUPPER() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5779:28: ( (this_INT_0= RULE_INT | kw= '*' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5780:1: (this_INT_0= RULE_INT | kw= '*' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5780:1: (this_INT_0= RULE_INT | kw= '*' )
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( (LA92_0==RULE_INT) ) {
                alt92=1;
            }
            else if ( (LA92_0==18) ) {
                alt92=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 92, 0, input);

                throw nvae;
            }
            switch (alt92) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5780:6: this_INT_0= RULE_INT
                    {
                    this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleUPPER13114); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_INT_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_INT_0, grammarAccess.getUPPERAccess().getINTTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5789:2: kw= '*'
                    {
                    kw=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleUPPER13138); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5802:1: entryRuleURI returns [String current=null] : iv_ruleURI= ruleURI EOF ;
    public final String entryRuleURI() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleURI = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5803:2: (iv_ruleURI= ruleURI EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5804:2: iv_ruleURI= ruleURI EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getURIRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleURI_in_entryRuleURI13179);
            iv_ruleURI=ruleURI();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleURI.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleURI13190); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5811:1: ruleURI returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING ;
    public final AntlrDatatypeRuleToken ruleURI() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_SINGLE_QUOTED_STRING_0=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5814:28: (this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5815:5: this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING
            {
            this_SINGLE_QUOTED_STRING_0=(Token)match(input,RULE_SINGLE_QUOTED_STRING,FollowSets000.FOLLOW_RULE_SINGLE_QUOTED_STRING_in_ruleURI13229); if (state.failed) return current;
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

    // $ANTLR start synpred81_InternalEssentialOCL
    public final void synpred81_InternalEssentialOCL_fragment() throws RecognitionException {   
        EObject this_TypeLiteralWithMultiplicityCS_1 = null;


        // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3049:2: (this_TypeLiteralWithMultiplicityCS_1= ruleTypeLiteralWithMultiplicityCS )
        // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3049:2: this_TypeLiteralWithMultiplicityCS_1= ruleTypeLiteralWithMultiplicityCS
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralWithMultiplicityCS_in_synpred81_InternalEssentialOCL7148);
        this_TypeLiteralWithMultiplicityCS_1=ruleTypeLiteralWithMultiplicityCS();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred81_InternalEssentialOCL

    // $ANTLR start synpred83_InternalEssentialOCL
    public final void synpred83_InternalEssentialOCL_fragment() throws RecognitionException {   
        EObject this_PrefixedPrimaryExpCS_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_ownedRight_3_0 = null;


        // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3094:2: ( (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? ) )
        // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3094:2: (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? )
        {
        // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3094:2: (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? )
        // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3095:2: this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )?
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_rulePrefixedPrimaryExpCS_in_synpred83_InternalEssentialOCL7274);
        this_PrefixedPrimaryExpCS_0=rulePrefixedPrimaryExpCS();

        state._fsp--;
        if (state.failed) return ;
        // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3106:1: ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )?
        int alt103=2;
        int LA103_0 = input.LA(1);

        if ( (LA103_0==16||(LA103_0>=18 && LA103_0<=34)) ) {
            alt103=1;
        }
        switch (alt103) {
            case 1 :
                // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3106:2: () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) )
                {
                // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3106:2: ()
                // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3107:2: 
                {
                if ( state.backtracking==0 ) {
                   
                  	  /* */ 
                  	
                }

                }

                // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3115:2: ( (lv_name_2_0= ruleBinaryOperatorName ) )
                // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3116:1: (lv_name_2_0= ruleBinaryOperatorName )
                {
                // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3116:1: (lv_name_2_0= ruleBinaryOperatorName )
                // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3117:3: lv_name_2_0= ruleBinaryOperatorName
                {
                if ( state.backtracking==0 ) {
                   
                  	        newCompositeNode(grammarAccess.getExpCSAccess().getNameBinaryOperatorNameParserRuleCall_0_1_1_0()); 
                  	    
                }
                pushFollow(FollowSets000.FOLLOW_ruleBinaryOperatorName_in_synpred83_InternalEssentialOCL7307);
                lv_name_2_0=ruleBinaryOperatorName();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3133:2: ( (lv_ownedRight_3_0= ruleExpCS ) )
                // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3134:1: (lv_ownedRight_3_0= ruleExpCS )
                {
                // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3134:1: (lv_ownedRight_3_0= ruleExpCS )
                // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3135:3: lv_ownedRight_3_0= ruleExpCS
                {
                if ( state.backtracking==0 ) {
                   
                  	        newCompositeNode(grammarAccess.getExpCSAccess().getOwnedRightExpCSParserRuleCall_0_1_2_0()); 
                  	    
                }
                pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_synpred83_InternalEssentialOCL7328);
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
    // $ANTLR end synpred83_InternalEssentialOCL

    // $ANTLR start synpred90_InternalEssentialOCL
    public final void synpred90_InternalEssentialOCL_fragment() throws RecognitionException {   
        EObject this_TupleLiteralExpCS_4 = null;


        // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3396:2: (this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS )
        // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3396:2: this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralExpCS_in_synpred90_InternalEssentialOCL7891);
        this_TupleLiteralExpCS_4=ruleTupleLiteralExpCS();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred90_InternalEssentialOCL

    // $ANTLR start synpred91_InternalEssentialOCL
    public final void synpred91_InternalEssentialOCL_fragment() throws RecognitionException {   
        EObject this_MapLiteralExpCS_5 = null;


        // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3409:2: (this_MapLiteralExpCS_5= ruleMapLiteralExpCS )
        // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3409:2: this_MapLiteralExpCS_5= ruleMapLiteralExpCS
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleMapLiteralExpCS_in_synpred91_InternalEssentialOCL7921);
        this_MapLiteralExpCS_5=ruleMapLiteralExpCS();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred91_InternalEssentialOCL

    // $ANTLR start synpred92_InternalEssentialOCL
    public final void synpred92_InternalEssentialOCL_fragment() throws RecognitionException {   
        EObject this_CollectionLiteralExpCS_6 = null;


        // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3422:2: (this_CollectionLiteralExpCS_6= ruleCollectionLiteralExpCS )
        // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3422:2: this_CollectionLiteralExpCS_6= ruleCollectionLiteralExpCS
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteralExpCS_in_synpred92_InternalEssentialOCL7951);
        this_CollectionLiteralExpCS_6=ruleCollectionLiteralExpCS();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred92_InternalEssentialOCL

    // $ANTLR start synpred93_InternalEssentialOCL
    public final void synpred93_InternalEssentialOCL_fragment() throws RecognitionException {   
        EObject this_LambdaLiteralExpCS_7 = null;


        // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3435:2: (this_LambdaLiteralExpCS_7= ruleLambdaLiteralExpCS )
        // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3435:2: this_LambdaLiteralExpCS_7= ruleLambdaLiteralExpCS
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleLambdaLiteralExpCS_in_synpred93_InternalEssentialOCL7981);
        this_LambdaLiteralExpCS_7=ruleLambdaLiteralExpCS();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred93_InternalEssentialOCL

    // $ANTLR start synpred94_InternalEssentialOCL
    public final void synpred94_InternalEssentialOCL_fragment() throws RecognitionException {   
        EObject this_TypeLiteralExpCS_8 = null;


        // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3448:2: (this_TypeLiteralExpCS_8= ruleTypeLiteralExpCS )
        // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3448:2: this_TypeLiteralExpCS_8= ruleTypeLiteralExpCS
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralExpCS_in_synpred94_InternalEssentialOCL8011);
        this_TypeLiteralExpCS_8=ruleTypeLiteralExpCS();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred94_InternalEssentialOCL

    // Delegated rules

    public final boolean synpred91_InternalEssentialOCL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred91_InternalEssentialOCL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred94_InternalEssentialOCL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred94_InternalEssentialOCL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred90_InternalEssentialOCL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred90_InternalEssentialOCL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred81_InternalEssentialOCL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred81_InternalEssentialOCL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred83_InternalEssentialOCL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred83_InternalEssentialOCL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred93_InternalEssentialOCL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred93_InternalEssentialOCL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred92_InternalEssentialOCL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred92_InternalEssentialOCL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA46 dfa46 = new DFA46(this);
    protected DFA48 dfa48 = new DFA48(this);
    protected DFA51 dfa51 = new DFA51(this);
    static final String DFA46_eotS =
        "\24\uffff";
    static final String DFA46_eofS =
        "\24\uffff";
    static final String DFA46_minS =
        "\1\4\2\uffff\5\0\14\uffff";
    static final String DFA46_maxS =
        "\1\64\2\uffff\5\0\14\uffff";
    static final String DFA46_acceptS =
        "\1\uffff\1\1\6\uffff\1\2\12\uffff\1\3";
    static final String DFA46_specialS =
        "\3\uffff\1\0\1\1\1\2\1\3\1\4\14\uffff}>";
    static final String[] DFA46_transitionS = {
            "\2\1\35\uffff\12\10\1\3\1\4\1\5\1\6\1\7\2\uffff\1\10",
            "",
            "",
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
            ""
    };

    static final short[] DFA46_eot = DFA.unpackEncodedString(DFA46_eotS);
    static final short[] DFA46_eof = DFA.unpackEncodedString(DFA46_eofS);
    static final char[] DFA46_min = DFA.unpackEncodedStringToUnsignedChars(DFA46_minS);
    static final char[] DFA46_max = DFA.unpackEncodedStringToUnsignedChars(DFA46_maxS);
    static final short[] DFA46_accept = DFA.unpackEncodedString(DFA46_acceptS);
    static final short[] DFA46_special = DFA.unpackEncodedString(DFA46_specialS);
    static final short[][] DFA46_transition;

    static {
        int numStates = DFA46_transitionS.length;
        DFA46_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA46_transition[i] = DFA.unpackEncodedString(DFA46_transitionS[i]);
        }
    }

    class DFA46 extends DFA {

        public DFA46(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 46;
            this.eot = DFA46_eot;
            this.eof = DFA46_eof;
            this.min = DFA46_min;
            this.max = DFA46_max;
            this.accept = DFA46_accept;
            this.special = DFA46_special;
            this.transition = DFA46_transition;
        }
        public String getDescription() {
            return "3035:1: (this_PathExpCS_0= rulePathExpCS | this_TypeLiteralWithMultiplicityCS_1= ruleTypeLiteralWithMultiplicityCS | this_CollectionPatternCS_2= ruleCollectionPatternCS )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA46_3 = input.LA(1);

                         
                        int index46_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalEssentialOCL()) ) {s = 8;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index46_3);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA46_4 = input.LA(1);

                         
                        int index46_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalEssentialOCL()) ) {s = 8;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index46_4);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA46_5 = input.LA(1);

                         
                        int index46_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalEssentialOCL()) ) {s = 8;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index46_5);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA46_6 = input.LA(1);

                         
                        int index46_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalEssentialOCL()) ) {s = 8;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index46_6);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA46_7 = input.LA(1);

                         
                        int index46_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalEssentialOCL()) ) {s = 8;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index46_7);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 46, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA48_eotS =
        "\40\uffff";
    static final String DFA48_eofS =
        "\40\uffff";
    static final String DFA48_minS =
        "\1\4\2\0\35\uffff";
    static final String DFA48_maxS =
        "\1\115\2\0\35\uffff";
    static final String DFA48_acceptS =
        "\3\uffff\1\1\33\uffff\1\2";
    static final String DFA48_specialS =
        "\1\uffff\1\0\1\1\35\uffff}>";
    static final String[] DFA48_transitionS = {
            "\4\3\10\uffff\1\1\1\2\1\3\20\uffff\20\3\1\uffff\1\3\7\uffff"+
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

    static final short[] DFA48_eot = DFA.unpackEncodedString(DFA48_eotS);
    static final short[] DFA48_eof = DFA.unpackEncodedString(DFA48_eofS);
    static final char[] DFA48_min = DFA.unpackEncodedStringToUnsignedChars(DFA48_minS);
    static final char[] DFA48_max = DFA.unpackEncodedStringToUnsignedChars(DFA48_maxS);
    static final short[] DFA48_accept = DFA.unpackEncodedString(DFA48_acceptS);
    static final short[] DFA48_special = DFA.unpackEncodedString(DFA48_specialS);
    static final short[][] DFA48_transition;

    static {
        int numStates = DFA48_transitionS.length;
        DFA48_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA48_transition[i] = DFA.unpackEncodedString(DFA48_transitionS[i]);
        }
    }

    class DFA48 extends DFA {

        public DFA48(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 48;
            this.eot = DFA48_eot;
            this.eof = DFA48_eof;
            this.min = DFA48_min;
            this.max = DFA48_max;
            this.accept = DFA48_accept;
            this.special = DFA48_special;
            this.transition = DFA48_transition;
        }
        public String getDescription() {
            return "3094:1: ( (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? ) | this_PrefixedLetExpCS_4= rulePrefixedLetExpCS )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA48_1 = input.LA(1);

                         
                        int index48_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred83_InternalEssentialOCL()) ) {s = 3;}

                        else if ( (true) ) {s = 31;}

                         
                        input.seek(index48_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA48_2 = input.LA(1);

                         
                        int index48_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred83_InternalEssentialOCL()) ) {s = 3;}

                        else if ( (true) ) {s = 31;}

                         
                        input.seek(index48_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 48, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA51_eotS =
        "\41\uffff";
    static final String DFA51_eofS =
        "\41\uffff";
    static final String DFA51_minS =
        "\1\4\12\uffff\10\0\16\uffff";
    static final String DFA51_maxS =
        "\1\115\12\uffff\10\0\16\uffff";
    static final String DFA51_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\16\uffff\1\11\7\uffff\1\12\1\uffff\1\5"+
        "\1\6\1\7\1\10";
    static final String DFA51_specialS =
        "\13\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\16\uffff}>";
    static final String[] DFA51_transitionS = {
            "\2\33\2\4\12\uffff\1\4\20\uffff\1\14\1\13\10\23\1\15\1\16\1"+
            "\17\1\20\1\21\1\1\1\uffff\1\22\7\uffff\4\4\7\uffff\1\2\5\uffff"+
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

    static final short[] DFA51_eot = DFA.unpackEncodedString(DFA51_eotS);
    static final short[] DFA51_eof = DFA.unpackEncodedString(DFA51_eofS);
    static final char[] DFA51_min = DFA.unpackEncodedStringToUnsignedChars(DFA51_minS);
    static final char[] DFA51_max = DFA.unpackEncodedStringToUnsignedChars(DFA51_maxS);
    static final short[] DFA51_accept = DFA.unpackEncodedString(DFA51_acceptS);
    static final short[] DFA51_special = DFA.unpackEncodedString(DFA51_specialS);
    static final short[][] DFA51_transition;

    static {
        int numStates = DFA51_transitionS.length;
        DFA51_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA51_transition[i] = DFA.unpackEncodedString(DFA51_transitionS[i]);
        }
    }

    class DFA51 extends DFA {

        public DFA51(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 51;
            this.eot = DFA51_eot;
            this.eof = DFA51_eof;
            this.min = DFA51_min;
            this.max = DFA51_max;
            this.accept = DFA51_accept;
            this.special = DFA51_special;
            this.transition = DFA51_transition;
        }
        public String getDescription() {
            return "3343:1: (this_NestedExpCS_0= ruleNestedExpCS | this_IfExpCS_1= ruleIfExpCS | this_SelfExpCS_2= ruleSelfExpCS | this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS | this_MapLiteralExpCS_5= ruleMapLiteralExpCS | this_CollectionLiteralExpCS_6= ruleCollectionLiteralExpCS | this_LambdaLiteralExpCS_7= ruleLambdaLiteralExpCS | this_TypeLiteralExpCS_8= ruleTypeLiteralExpCS | this_NameExpCS_9= ruleNameExpCS )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA51_11 = input.LA(1);

                         
                        int index51_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred90_InternalEssentialOCL()) ) {s = 29;}

                        else if ( (synpred94_InternalEssentialOCL()) ) {s = 19;}

                         
                        input.seek(index51_11);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA51_12 = input.LA(1);

                         
                        int index51_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred91_InternalEssentialOCL()) ) {s = 30;}

                        else if ( (synpred94_InternalEssentialOCL()) ) {s = 19;}

                         
                        input.seek(index51_12);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA51_13 = input.LA(1);

                         
                        int index51_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_InternalEssentialOCL()) ) {s = 31;}

                        else if ( (synpred94_InternalEssentialOCL()) ) {s = 19;}

                         
                        input.seek(index51_13);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA51_14 = input.LA(1);

                         
                        int index51_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_InternalEssentialOCL()) ) {s = 31;}

                        else if ( (synpred94_InternalEssentialOCL()) ) {s = 19;}

                         
                        input.seek(index51_14);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA51_15 = input.LA(1);

                         
                        int index51_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_InternalEssentialOCL()) ) {s = 31;}

                        else if ( (synpred94_InternalEssentialOCL()) ) {s = 19;}

                         
                        input.seek(index51_15);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA51_16 = input.LA(1);

                         
                        int index51_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_InternalEssentialOCL()) ) {s = 31;}

                        else if ( (synpred94_InternalEssentialOCL()) ) {s = 19;}

                         
                        input.seek(index51_16);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA51_17 = input.LA(1);

                         
                        int index51_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_InternalEssentialOCL()) ) {s = 31;}

                        else if ( (synpred94_InternalEssentialOCL()) ) {s = 19;}

                         
                        input.seek(index51_17);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA51_18 = input.LA(1);

                         
                        int index51_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred93_InternalEssentialOCL()) ) {s = 32;}

                        else if ( (synpred94_InternalEssentialOCL()) ) {s = 19;}

                         
                        input.seek(index51_18);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 51, _s, input);
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
        public static final BitSet FOLLOW_50_in_ruleCollectionTypeCS2418 = new BitSet(new long[]{0x0013FFF800000030L});
        public static final BitSet FOLLOW_ruleComplexTypeCS_in_ruleCollectionTypeCS2439 = new BitSet(new long[]{0x0008000000000000L});
        public static final BitSet FOLLOW_51_in_ruleCollectionTypeCS2451 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionTypeWithMultiplicityCS_in_entryRuleCollectionTypeWithMultiplicityCS2489 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCollectionTypeWithMultiplicityCS2499 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionTypeCS_in_ruleCollectionTypeWithMultiplicityCS2549 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
        public static final BitSet FOLLOW_ruleMultiplicityCS_in_ruleCollectionTypeWithMultiplicityCS2569 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLambdaTypeCS_in_entryRuleLambdaTypeCS2606 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLambdaTypeCS2616 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_52_in_ruleLambdaTypeCS2659 = new BitSet(new long[]{0x0004000000400000L});
        public static final BitSet FOLLOW_ruleTemplateSignatureCS_in_ruleLambdaTypeCS2693 = new BitSet(new long[]{0x0004000000000000L});
        public static final BitSet FOLLOW_50_in_ruleLambdaTypeCS2706 = new BitSet(new long[]{0x001BFFF800000030L});
        public static final BitSet FOLLOW_ruleComplexTypeCS_in_ruleLambdaTypeCS2728 = new BitSet(new long[]{0x0028000000000000L});
        public static final BitSet FOLLOW_53_in_ruleLambdaTypeCS2741 = new BitSet(new long[]{0x0013FFF800000030L});
        public static final BitSet FOLLOW_ruleComplexTypeCS_in_ruleLambdaTypeCS2762 = new BitSet(new long[]{0x0028000000000000L});
        public static final BitSet FOLLOW_51_in_ruleLambdaTypeCS2778 = new BitSet(new long[]{0x0040000000000000L});
        public static final BitSet FOLLOW_54_in_ruleLambdaTypeCS2790 = new BitSet(new long[]{0x0013FFF800000030L});
        public static final BitSet FOLLOW_ruleComplexTypeCS_in_ruleLambdaTypeCS2811 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMapTypeCS_in_entryRuleMapTypeCS2847 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMapTypeCS2857 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_ruleMapTypeCS2900 = new BitSet(new long[]{0x0004000000000002L});
        public static final BitSet FOLLOW_50_in_ruleMapTypeCS2926 = new BitSet(new long[]{0x0013FFF800000030L});
        public static final BitSet FOLLOW_ruleComplexTypeCS_in_ruleMapTypeCS2947 = new BitSet(new long[]{0x0020000000000000L});
        public static final BitSet FOLLOW_53_in_ruleMapTypeCS2959 = new BitSet(new long[]{0x0013FFF800000030L});
        public static final BitSet FOLLOW_ruleComplexTypeCS_in_ruleMapTypeCS2980 = new BitSet(new long[]{0x0008000000000000L});
        public static final BitSet FOLLOW_51_in_ruleMapTypeCS2992 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTupleTypeCS_in_entryRuleTupleTypeCS3030 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTupleTypeCS3040 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_ruleTupleTypeCS3083 = new BitSet(new long[]{0x0004000000000002L});
        public static final BitSet FOLLOW_50_in_ruleTupleTypeCS3109 = new BitSet(new long[]{0x001BFFF800000030L});
        public static final BitSet FOLLOW_ruleTuplePartCS_in_ruleTupleTypeCS3131 = new BitSet(new long[]{0x0028000000000000L});
        public static final BitSet FOLLOW_53_in_ruleTupleTypeCS3144 = new BitSet(new long[]{0x0013FFF800000030L});
        public static final BitSet FOLLOW_ruleTuplePartCS_in_ruleTupleTypeCS3165 = new BitSet(new long[]{0x0028000000000000L});
        public static final BitSet FOLLOW_51_in_ruleTupleTypeCS3181 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTuplePartCS_in_entryRuleTuplePartCS3219 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTuplePartCS3229 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleTuplePartCS3275 = new BitSet(new long[]{0x0040000000000000L});
        public static final BitSet FOLLOW_54_in_ruleTuplePartCS3287 = new BitSet(new long[]{0x0013FFF800000030L});
        public static final BitSet FOLLOW_ruleComplexTypeCS_in_ruleTuplePartCS3308 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimpleTypeCS_in_entryRuleSimpleTypeCS3344 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSimpleTypeCS3354 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralCS_in_ruleSimpleTypeCS3404 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePathTypeCS_in_ruleSimpleTypeCS3434 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleComplexTypeCS_in_entryRuleComplexTypeCS3469 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleComplexTypeCS3479 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralWithMultiplicityCS_in_ruleComplexTypeCS3529 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePathTypeCS_in_ruleComplexTypeCS3560 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
        public static final BitSet FOLLOW_ruleMultiplicityCS_in_ruleComplexTypeCS3580 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionLiteralExpCS_in_entryRuleCollectionLiteralExpCS3618 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCollectionLiteralExpCS3628 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionTypeWithMultiplicityCS_in_ruleCollectionLiteralExpCS3674 = new BitSet(new long[]{0x0080000000000000L});
        public static final BitSet FOLLOW_55_in_ruleCollectionLiteralExpCS3686 = new BitSet(new long[]{0xF157FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleCollectionLiteralPartCS_in_ruleCollectionLiteralExpCS3708 = new BitSet(new long[]{0x0120000000000000L});
        public static final BitSet FOLLOW_53_in_ruleCollectionLiteralExpCS3721 = new BitSet(new long[]{0xF057FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleCollectionLiteralPartCS_in_ruleCollectionLiteralExpCS3742 = new BitSet(new long[]{0x0120000000000000L});
        public static final BitSet FOLLOW_56_in_ruleCollectionLiteralExpCS3758 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionLiteralPartCS_in_entryRuleCollectionLiteralPartCS3794 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCollectionLiteralPartCS3804 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleCollectionLiteralPartCS3851 = new BitSet(new long[]{0x0200000000000002L});
        public static final BitSet FOLLOW_57_in_ruleCollectionLiteralPartCS3864 = new BitSet(new long[]{0xF017FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleCollectionLiteralPartCS3885 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePatternExpCS_in_ruleCollectionLiteralPartCS3915 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionPatternCS_in_entryRuleCollectionPatternCS3951 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCollectionPatternCS3961 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionTypeCS_in_ruleCollectionPatternCS4007 = new BitSet(new long[]{0x0080000000000000L});
        public static final BitSet FOLLOW_55_in_ruleCollectionPatternCS4019 = new BitSet(new long[]{0xF157FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_rulePatternExpCS_in_ruleCollectionPatternCS4041 = new BitSet(new long[]{0x0420000000000000L});
        public static final BitSet FOLLOW_53_in_ruleCollectionPatternCS4054 = new BitSet(new long[]{0xF057FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_rulePatternExpCS_in_ruleCollectionPatternCS4075 = new BitSet(new long[]{0x0420000000000000L});
        public static final BitSet FOLLOW_58_in_ruleCollectionPatternCS4090 = new BitSet(new long[]{0x0013FFF800000030L});
        public static final BitSet FOLLOW_ruleIdentifier_in_ruleCollectionPatternCS4111 = new BitSet(new long[]{0x0100000000000000L});
        public static final BitSet FOLLOW_56_in_ruleCollectionPatternCS4126 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleShadowPartCS_in_entryRuleShadowPartCS4162 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleShadowPartCS4172 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleShadowPartCS4224 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_25_in_ruleShadowPartCS4236 = new BitSet(new long[]{0xF057FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleShadowPartCS4259 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePatternExpCS_in_ruleShadowPartCS4278 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePatternExpCS_in_entryRulePatternExpCS4317 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePatternExpCS4327 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_rulePatternExpCS4373 = new BitSet(new long[]{0x0040000000000000L});
        public static final BitSet FOLLOW_54_in_rulePatternExpCS4386 = new BitSet(new long[]{0x0013FFF800000030L});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_rulePatternExpCS4407 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLambdaLiteralExpCS_in_entryRuleLambdaLiteralExpCS4443 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLambdaLiteralExpCS4453 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_52_in_ruleLambdaLiteralExpCS4496 = new BitSet(new long[]{0x0004000000000000L});
        public static final BitSet FOLLOW_50_in_ruleLambdaLiteralExpCS4521 = new BitSet(new long[]{0x001BFFF800000030L});
        public static final BitSet FOLLOW_ruleLambdaParameterCS_in_ruleLambdaLiteralExpCS4543 = new BitSet(new long[]{0x0028000000000000L});
        public static final BitSet FOLLOW_53_in_ruleLambdaLiteralExpCS4556 = new BitSet(new long[]{0x0013FFF800000030L});
        public static final BitSet FOLLOW_ruleLambdaParameterCS_in_ruleLambdaLiteralExpCS4577 = new BitSet(new long[]{0x0028000000000000L});
        public static final BitSet FOLLOW_51_in_ruleLambdaLiteralExpCS4593 = new BitSet(new long[]{0x0040000000000000L});
        public static final BitSet FOLLOW_54_in_ruleLambdaLiteralExpCS4605 = new BitSet(new long[]{0x0013FFF800000030L});
        public static final BitSet FOLLOW_ruleComplexTypeCS_in_ruleLambdaLiteralExpCS4626 = new BitSet(new long[]{0x0080000000000000L});
        public static final BitSet FOLLOW_55_in_ruleLambdaLiteralExpCS4638 = new BitSet(new long[]{0xF017FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleLambdaLiteralExpCS4659 = new BitSet(new long[]{0x0100000000000000L});
        public static final BitSet FOLLOW_56_in_ruleLambdaLiteralExpCS4671 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLambdaParameterCS_in_entryRuleLambdaParameterCS4707 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLambdaParameterCS4717 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleLambdaParameterCS4763 = new BitSet(new long[]{0x0040000000000000L});
        public static final BitSet FOLLOW_54_in_ruleLambdaParameterCS4775 = new BitSet(new long[]{0x0013FFF800000030L});
        public static final BitSet FOLLOW_ruleComplexTypeCS_in_ruleLambdaParameterCS4796 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMapLiteralExpCS_in_entryRuleMapLiteralExpCS4832 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMapLiteralExpCS4842 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMapTypeCS_in_ruleMapLiteralExpCS4888 = new BitSet(new long[]{0x0080000000000000L});
        public static final BitSet FOLLOW_55_in_ruleMapLiteralExpCS4900 = new BitSet(new long[]{0xF117FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleMapLiteralPartCS_in_ruleMapLiteralExpCS4922 = new BitSet(new long[]{0x0120000000000000L});
        public static final BitSet FOLLOW_53_in_ruleMapLiteralExpCS4935 = new BitSet(new long[]{0xF017FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleMapLiteralPartCS_in_ruleMapLiteralExpCS4956 = new BitSet(new long[]{0x0120000000000000L});
        public static final BitSet FOLLOW_56_in_ruleMapLiteralExpCS4972 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMapLiteralPartCS_in_entryRuleMapLiteralPartCS5008 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMapLiteralPartCS5018 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleMapLiteralPartCS5064 = new BitSet(new long[]{0x0800000000000000L});
        public static final BitSet FOLLOW_59_in_ruleMapLiteralPartCS5076 = new BitSet(new long[]{0xF017FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleMapLiteralPartCS5097 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveLiteralExpCS_in_entryRulePrimitiveLiteralExpCS5133 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrimitiveLiteralExpCS5143 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNumberLiteralExpCS_in_rulePrimitiveLiteralExpCS5193 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringLiteralExpCS_in_rulePrimitiveLiteralExpCS5223 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBooleanLiteralExpCS_in_rulePrimitiveLiteralExpCS5253 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnlimitedNaturalLiteralExpCS_in_rulePrimitiveLiteralExpCS5283 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInvalidLiteralExpCS_in_rulePrimitiveLiteralExpCS5313 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNullLiteralExpCS_in_rulePrimitiveLiteralExpCS5343 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTupleLiteralExpCS_in_entryRuleTupleLiteralExpCS5378 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTupleLiteralExpCS5388 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_ruleTupleLiteralExpCS5425 = new BitSet(new long[]{0x0080000000000000L});
        public static final BitSet FOLLOW_55_in_ruleTupleLiteralExpCS5437 = new BitSet(new long[]{0x0013FFF800000030L});
        public static final BitSet FOLLOW_ruleTupleLiteralPartCS_in_ruleTupleLiteralExpCS5458 = new BitSet(new long[]{0x0120000000000000L});
        public static final BitSet FOLLOW_53_in_ruleTupleLiteralExpCS5471 = new BitSet(new long[]{0x0013FFF800000030L});
        public static final BitSet FOLLOW_ruleTupleLiteralPartCS_in_ruleTupleLiteralExpCS5492 = new BitSet(new long[]{0x0120000000000000L});
        public static final BitSet FOLLOW_56_in_ruleTupleLiteralExpCS5506 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTupleLiteralPartCS_in_entryRuleTupleLiteralPartCS5542 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTupleLiteralPartCS5552 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleTupleLiteralPartCS5598 = new BitSet(new long[]{0x0040000002000000L});
        public static final BitSet FOLLOW_54_in_ruleTupleLiteralPartCS5611 = new BitSet(new long[]{0x0013FFF800000030L});
        public static final BitSet FOLLOW_ruleComplexTypeCS_in_ruleTupleLiteralPartCS5632 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_25_in_ruleTupleLiteralPartCS5646 = new BitSet(new long[]{0xF017FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleTupleLiteralPartCS5667 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNumberLiteralExpCS_in_entryRuleNumberLiteralExpCS5703 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNumberLiteralExpCS5713 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNUMBER_LITERAL_in_ruleNumberLiteralExpCS5758 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringLiteralExpCS_in_entryRuleStringLiteralExpCS5793 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteralExpCS5803 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringLiteral_in_ruleStringLiteralExpCS5848 = new BitSet(new long[]{0x0000000000000082L});
        public static final BitSet FOLLOW_ruleBooleanLiteralExpCS_in_entryRuleBooleanLiteralExpCS5884 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBooleanLiteralExpCS5894 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_60_in_ruleBooleanLiteralExpCS5937 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_61_in_ruleBooleanLiteralExpCS5974 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnlimitedNaturalLiteralExpCS_in_entryRuleUnlimitedNaturalLiteralExpCS6023 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnlimitedNaturalLiteralExpCS6033 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleUnlimitedNaturalLiteralExpCS6082 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInvalidLiteralExpCS_in_entryRuleInvalidLiteralExpCS6118 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleInvalidLiteralExpCS6128 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_62_in_ruleInvalidLiteralExpCS6177 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNullLiteralExpCS_in_entryRuleNullLiteralExpCS6213 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNullLiteralExpCS6223 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_63_in_ruleNullLiteralExpCS6272 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralCS_in_entryRuleTypeLiteralCS6308 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeLiteralCS6318 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveTypeCS_in_ruleTypeLiteralCS6368 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionTypeCS_in_ruleTypeLiteralCS6398 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMapTypeCS_in_ruleTypeLiteralCS6428 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTupleTypeCS_in_ruleTypeLiteralCS6458 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralWithMultiplicityCS_in_entryRuleTypeLiteralWithMultiplicityCS6493 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeLiteralWithMultiplicityCS6503 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionTypeWithMultiplicityCS_in_ruleTypeLiteralWithMultiplicityCS6553 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLambdaTypeCS_in_ruleTypeLiteralWithMultiplicityCS6583 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveTypeCS_in_ruleTypeLiteralWithMultiplicityCS6615 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
        public static final BitSet FOLLOW_ruleMapTypeCS_in_ruleTypeLiteralWithMultiplicityCS6645 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
        public static final BitSet FOLLOW_ruleTupleTypeCS_in_ruleTypeLiteralWithMultiplicityCS6675 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
        public static final BitSet FOLLOW_ruleMultiplicityCS_in_ruleTypeLiteralWithMultiplicityCS6696 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralExpCS_in_entryRuleTypeLiteralExpCS6734 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeLiteralExpCS6744 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralWithMultiplicityCS_in_ruleTypeLiteralExpCS6789 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePathExpCS_in_entryRulePathExpCS6824 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePathExpCS6834 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePathNameCS_in_rulePathExpCS6880 = new BitSet(new long[]{0x0084000000000002L,0x0000000000000004L});
        public static final BitSet FOLLOW_50_in_rulePathExpCS6893 = new BitSet(new long[]{0xF013FFF8000400F0L,0x0000000000010000L});
        public static final BitSet FOLLOW_ruleTemplateBindingCS_in_rulePathExpCS6914 = new BitSet(new long[]{0x0008000000000000L});
        public static final BitSet FOLLOW_51_in_rulePathExpCS6926 = new BitSet(new long[]{0x0080000000000002L,0x0000000000000004L});
        public static final BitSet FOLLOW_ruleCurlyBracketedClauseCS_in_rulePathExpCS6950 = new BitSet(new long[]{0x0080000000000002L,0x0000000000000004L});
        public static final BitSet FOLLOW_55_in_rulePathExpCS6963 = new BitSet(new long[]{0xF017FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_rulePathExpCS6984 = new BitSet(new long[]{0x0100000000000000L});
        public static final BitSet FOLLOW_56_in_rulePathExpCS6996 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
        public static final BitSet FOLLOW_ruleMultiplicityCS_in_rulePathExpCS7021 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_entryRuleTypeExpCS7058 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeExpCS7068 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePathExpCS_in_ruleTypeExpCS7118 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralWithMultiplicityCS_in_ruleTypeExpCS7148 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionPatternCS_in_ruleTypeExpCS7178 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpCS_in_entryRuleExpCS7213 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleExpCS7223 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrefixedPrimaryExpCS_in_ruleExpCS7274 = new BitSet(new long[]{0x00000007FFFD0002L});
        public static final BitSet FOLLOW_ruleBinaryOperatorName_in_ruleExpCS7307 = new BitSet(new long[]{0xF017FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleExpCS7328 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrefixedLetExpCS_in_ruleExpCS7362 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrefixedLetExpCS_in_entryRulePrefixedLetExpCS7397 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrefixedLetExpCS7407 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnaryOperatorName_in_rulePrefixedLetExpCS7466 = new BitSet(new long[]{0xF017FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_rulePrefixedLetExpCS_in_rulePrefixedLetExpCS7487 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLetExpCS_in_rulePrefixedLetExpCS7519 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrefixedPrimaryExpCS_in_entryRulePrefixedPrimaryExpCS7554 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrefixedPrimaryExpCS7564 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnaryOperatorName_in_rulePrefixedPrimaryExpCS7623 = new BitSet(new long[]{0xF017FFF8000700F0L,0x0000000000002080L});
        public static final BitSet FOLLOW_rulePrefixedPrimaryExpCS_in_rulePrefixedPrimaryExpCS7644 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimaryExpCS_in_rulePrefixedPrimaryExpCS7676 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimaryExpCS_in_entryRulePrimaryExpCS7711 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpCS7721 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedExpCS_in_rulePrimaryExpCS7771 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIfExpCS_in_rulePrimaryExpCS7801 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSelfExpCS_in_rulePrimaryExpCS7831 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveLiteralExpCS_in_rulePrimaryExpCS7861 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTupleLiteralExpCS_in_rulePrimaryExpCS7891 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMapLiteralExpCS_in_rulePrimaryExpCS7921 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionLiteralExpCS_in_rulePrimaryExpCS7951 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLambdaLiteralExpCS_in_rulePrimaryExpCS7981 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralExpCS_in_rulePrimaryExpCS8011 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNameExpCS_in_rulePrimaryExpCS8041 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNameExpCS_in_entryRuleNameExpCS8076 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNameExpCS8086 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePathNameCS_in_ruleNameExpCS8132 = new BitSet(new long[]{0x0084000000000002L,0x0000000000000005L});
        public static final BitSet FOLLOW_ruleSquareBracketedClauseCS_in_ruleNameExpCS8153 = new BitSet(new long[]{0x0084000000000002L,0x0000000000000005L});
        public static final BitSet FOLLOW_ruleRoundBracketedClauseCS_in_ruleNameExpCS8175 = new BitSet(new long[]{0x0080000000000002L,0x0000000000000001L});
        public static final BitSet FOLLOW_ruleCurlyBracketedClauseCS_in_ruleNameExpCS8197 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
        public static final BitSet FOLLOW_64_in_ruleNameExpCS8217 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
        public static final BitSet FOLLOW_65_in_ruleNameExpCS8242 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCurlyBracketedClauseCS_in_entryRuleCurlyBracketedClauseCS8280 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCurlyBracketedClauseCS8290 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_55_in_ruleCurlyBracketedClauseCS8339 = new BitSet(new long[]{0x0113FFF8000000B0L});
        public static final BitSet FOLLOW_ruleStringLiteral_in_ruleCurlyBracketedClauseCS8361 = new BitSet(new long[]{0x0100000000000000L});
        public static final BitSet FOLLOW_ruleShadowPartCS_in_ruleCurlyBracketedClauseCS8389 = new BitSet(new long[]{0x0120000000000000L});
        public static final BitSet FOLLOW_53_in_ruleCurlyBracketedClauseCS8402 = new BitSet(new long[]{0x0013FFF800000030L});
        public static final BitSet FOLLOW_ruleShadowPartCS_in_ruleCurlyBracketedClauseCS8423 = new BitSet(new long[]{0x0120000000000000L});
        public static final BitSet FOLLOW_56_in_ruleCurlyBracketedClauseCS8440 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRoundBracketedClauseCS_in_entryRuleRoundBracketedClauseCS8476 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRoundBracketedClauseCS8486 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_50_in_ruleRoundBracketedClauseCS8535 = new BitSet(new long[]{0xF05FFFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleNavigatingArgCS_in_ruleRoundBracketedClauseCS8557 = new BitSet(new long[]{0x0028000000000000L,0x0000000000000060L});
        public static final BitSet FOLLOW_ruleNavigatingCommaArgCS_in_ruleRoundBracketedClauseCS8578 = new BitSet(new long[]{0x0028000000000000L,0x0000000000000060L});
        public static final BitSet FOLLOW_ruleNavigatingSemiArgCS_in_ruleRoundBracketedClauseCS8601 = new BitSet(new long[]{0x0028000000000000L,0x0000000000000020L});
        public static final BitSet FOLLOW_ruleNavigatingCommaArgCS_in_ruleRoundBracketedClauseCS8622 = new BitSet(new long[]{0x0028000000000000L,0x0000000000000020L});
        public static final BitSet FOLLOW_ruleNavigatingBarArgCS_in_ruleRoundBracketedClauseCS8647 = new BitSet(new long[]{0x0028000000000000L,0x0000000000000020L});
        public static final BitSet FOLLOW_ruleNavigatingCommaArgCS_in_ruleRoundBracketedClauseCS8668 = new BitSet(new long[]{0x0028000000000000L,0x0000000000000020L});
        public static final BitSet FOLLOW_51_in_ruleRoundBracketedClauseCS8685 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSquareBracketedClauseCS_in_entryRuleSquareBracketedClauseCS8721 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSquareBracketedClauseCS8731 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_66_in_ruleSquareBracketedClauseCS8768 = new BitSet(new long[]{0xF017FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleSquareBracketedClauseCS8789 = new BitSet(new long[]{0x0020000000000000L,0x0000000000000008L});
        public static final BitSet FOLLOW_53_in_ruleSquareBracketedClauseCS8802 = new BitSet(new long[]{0xF017FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleSquareBracketedClauseCS8823 = new BitSet(new long[]{0x0020000000000000L,0x0000000000000008L});
        public static final BitSet FOLLOW_67_in_ruleSquareBracketedClauseCS8837 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingArgCS_in_entryRuleNavigatingArgCS8873 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigatingArgCS8883 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingArgCS8930 = new BitSet(new long[]{0x0040000000000002L,0x0000000000000010L});
        public static final BitSet FOLLOW_54_in_ruleNavigatingArgCS8944 = new BitSet(new long[]{0x0013FFF800000030L});
        public static final BitSet FOLLOW_ruleComplexTypeCS_in_ruleNavigatingArgCS8965 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_25_in_ruleNavigatingArgCS8978 = new BitSet(new long[]{0xF017FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNavigatingArgCS8999 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_68_in_ruleNavigatingArgCS9021 = new BitSet(new long[]{0xF017FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNavigatingArgCS9042 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_54_in_ruleNavigatingArgCS9065 = new BitSet(new long[]{0x0013FFF800000030L});
        public static final BitSet FOLLOW_ruleComplexTypeCS_in_ruleNavigatingArgCS9086 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingBarArgCS_in_entryRuleNavigatingBarArgCS9123 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigatingBarArgCS9133 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_69_in_ruleNavigatingBarArgCS9176 = new BitSet(new long[]{0xF017FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingBarArgCS9210 = new BitSet(new long[]{0x0040000000000002L});
        public static final BitSet FOLLOW_54_in_ruleNavigatingBarArgCS9223 = new BitSet(new long[]{0x0013FFF800000030L});
        public static final BitSet FOLLOW_ruleComplexTypeCS_in_ruleNavigatingBarArgCS9244 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_25_in_ruleNavigatingBarArgCS9257 = new BitSet(new long[]{0xF017FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNavigatingBarArgCS9278 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingCommaArgCS_in_entryRuleNavigatingCommaArgCS9318 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigatingCommaArgCS9328 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_53_in_ruleNavigatingCommaArgCS9371 = new BitSet(new long[]{0xF017FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingCommaArgCS9405 = new BitSet(new long[]{0x0040000000000002L,0x0000000000000010L});
        public static final BitSet FOLLOW_54_in_ruleNavigatingCommaArgCS9419 = new BitSet(new long[]{0x0013FFF800000030L});
        public static final BitSet FOLLOW_ruleComplexTypeCS_in_ruleNavigatingCommaArgCS9440 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_25_in_ruleNavigatingCommaArgCS9453 = new BitSet(new long[]{0xF017FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNavigatingCommaArgCS9474 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_68_in_ruleNavigatingCommaArgCS9496 = new BitSet(new long[]{0xF017FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNavigatingCommaArgCS9517 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingSemiArgCS_in_entryRuleNavigatingSemiArgCS9556 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigatingSemiArgCS9566 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_70_in_ruleNavigatingSemiArgCS9609 = new BitSet(new long[]{0xF017FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingSemiArgCS9643 = new BitSet(new long[]{0x0040000000000002L});
        public static final BitSet FOLLOW_54_in_ruleNavigatingSemiArgCS9656 = new BitSet(new long[]{0x0013FFF800000030L});
        public static final BitSet FOLLOW_ruleComplexTypeCS_in_ruleNavigatingSemiArgCS9677 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_25_in_ruleNavigatingSemiArgCS9690 = new BitSet(new long[]{0xF017FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNavigatingSemiArgCS9711 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingArgExpCS_in_entryRuleNavigatingArgExpCS9751 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigatingArgExpCS9761 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNavigatingArgExpCS9810 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIfExpCS_in_entryRuleIfExpCS9844 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIfExpCS9854 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_71_in_ruleIfExpCS9891 = new BitSet(new long[]{0xF057FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleIfExpCS9914 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
        public static final BitSet FOLLOW_rulePatternExpCS_in_ruleIfExpCS9933 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
        public static final BitSet FOLLOW_72_in_ruleIfExpCS9948 = new BitSet(new long[]{0xF017FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleIfExpCS9969 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000A00L});
        public static final BitSet FOLLOW_ruleElseIfThenExpCS_in_ruleIfExpCS9990 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000A00L});
        public static final BitSet FOLLOW_73_in_ruleIfExpCS10003 = new BitSet(new long[]{0xF017FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleIfExpCS10024 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
        public static final BitSet FOLLOW_74_in_ruleIfExpCS10036 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleElseIfThenExpCS_in_entryRuleElseIfThenExpCS10072 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleElseIfThenExpCS10082 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_75_in_ruleElseIfThenExpCS10119 = new BitSet(new long[]{0xF017FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleElseIfThenExpCS10140 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
        public static final BitSet FOLLOW_72_in_ruleElseIfThenExpCS10152 = new BitSet(new long[]{0xF017FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleElseIfThenExpCS10173 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLetExpCS_in_entryRuleLetExpCS10209 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLetExpCS10219 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_76_in_ruleLetExpCS10256 = new BitSet(new long[]{0x0013FFF800000030L});
        public static final BitSet FOLLOW_ruleLetVariableCS_in_ruleLetExpCS10277 = new BitSet(new long[]{0x0020000000000000L,0x0000000000000010L});
        public static final BitSet FOLLOW_53_in_ruleLetExpCS10290 = new BitSet(new long[]{0x0013FFF800000030L});
        public static final BitSet FOLLOW_ruleLetVariableCS_in_ruleLetExpCS10311 = new BitSet(new long[]{0x0020000000000000L,0x0000000000000010L});
        public static final BitSet FOLLOW_68_in_ruleLetExpCS10325 = new BitSet(new long[]{0xF017FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleLetExpCS10346 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLetVariableCS_in_entryRuleLetVariableCS10382 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLetVariableCS10392 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleLetVariableCS10438 = new BitSet(new long[]{0x0044000002000000L});
        public static final BitSet FOLLOW_ruleRoundBracketedClauseCS_in_ruleLetVariableCS10459 = new BitSet(new long[]{0x0040000002000000L});
        public static final BitSet FOLLOW_54_in_ruleLetVariableCS10473 = new BitSet(new long[]{0x0013FFF800000030L});
        public static final BitSet FOLLOW_ruleComplexTypeCS_in_ruleLetVariableCS10494 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_25_in_ruleLetVariableCS10508 = new BitSet(new long[]{0xF017FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleLetVariableCS10529 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedExpCS_in_entryRuleNestedExpCS10565 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNestedExpCS10575 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_50_in_ruleNestedExpCS10612 = new BitSet(new long[]{0xF017FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNestedExpCS10633 = new BitSet(new long[]{0x0008000000000000L});
        public static final BitSet FOLLOW_51_in_ruleNestedExpCS10645 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSelfExpCS_in_entryRuleSelfExpCS10681 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSelfExpCS10691 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_77_in_ruleSelfExpCS10740 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTemplateParameterActualCS_in_entryRuleTemplateParameterActualCS10776 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTemplateParameterActualCS10786 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleComplexTypeCS_in_ruleTemplateParameterActualCS10836 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWildcardTypeRefCS_in_ruleTemplateParameterActualCS10866 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveLiteralExpCS_in_ruleTemplateParameterActualCS10896 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiplicityBoundsCS_in_entryRuleMultiplicityBoundsCS10931 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicityBoundsCS10941 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLOWER_in_ruleMultiplicityBoundsCS10987 = new BitSet(new long[]{0x0200000000000002L});
        public static final BitSet FOLLOW_57_in_ruleMultiplicityBoundsCS11000 = new BitSet(new long[]{0x0000000000040040L});
        public static final BitSet FOLLOW_ruleUPPER_in_ruleMultiplicityBoundsCS11021 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiplicityCS_in_entryRuleMultiplicityCS11059 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicityCS11069 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_66_in_ruleMultiplicityCS11106 = new BitSet(new long[]{0x0000000000140040L,0x0000000000010000L});
        public static final BitSet FOLLOW_ruleMultiplicityBoundsCS_in_ruleMultiplicityCS11132 = new BitSet(new long[]{0x0000000000000000L,0x000000000000C008L});
        public static final BitSet FOLLOW_ruleMultiplicityStringCS_in_ruleMultiplicityCS11162 = new BitSet(new long[]{0x0000000000000000L,0x000000000000C008L});
        public static final BitSet FOLLOW_78_in_ruleMultiplicityCS11175 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
        public static final BitSet FOLLOW_79_in_ruleMultiplicityCS11199 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
        public static final BitSet FOLLOW_67_in_ruleMultiplicityCS11226 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiplicityStringCS_in_entryRuleMultiplicityStringCS11262 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicityStringCS11272 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleMultiplicityStringCS11316 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleMultiplicityStringCS11345 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_80_in_ruleMultiplicityStringCS11374 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePathNameCS_in_entryRulePathNameCS11425 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePathNameCS11435 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFirstPathElementCS_in_rulePathNameCS11481 = new BitSet(new long[]{0x0000000000000002L,0x0000000000020000L});
        public static final BitSet FOLLOW_81_in_rulePathNameCS11494 = new BitSet(new long[]{0x0013FFF800000030L});
        public static final BitSet FOLLOW_ruleNextPathElementCS_in_rulePathNameCS11515 = new BitSet(new long[]{0x0000000000000002L,0x0000000000020000L});
        public static final BitSet FOLLOW_ruleFirstPathElementCS_in_entryRuleFirstPathElementCS11553 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFirstPathElementCS11563 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleFirstPathElementCS11614 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNextPathElementCS_in_entryRuleNextPathElementCS11649 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNextPathElementCS11659 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnreservedName_in_ruleNextPathElementCS11710 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePathTypeCS_in_entryRulePathTypeCS11745 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePathTypeCS11755 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePathNameCS_in_rulePathTypeCS11801 = new BitSet(new long[]{0x0004000000000002L});
        public static final BitSet FOLLOW_50_in_rulePathTypeCS11814 = new BitSet(new long[]{0xF013FFF8000400F0L,0x0000000000010000L});
        public static final BitSet FOLLOW_ruleTemplateBindingCS_in_rulePathTypeCS11835 = new BitSet(new long[]{0x0008000000000000L});
        public static final BitSet FOLLOW_51_in_rulePathTypeCS11847 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTemplateBindingCS_in_entryRuleTemplateBindingCS11885 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTemplateBindingCS11895 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTemplateParameterSubstitutionCS_in_ruleTemplateBindingCS11941 = new BitSet(new long[]{0x0020000000000002L});
        public static final BitSet FOLLOW_53_in_ruleTemplateBindingCS11954 = new BitSet(new long[]{0xF013FFF8000400F0L,0x0000000000010000L});
        public static final BitSet FOLLOW_ruleTemplateParameterSubstitutionCS_in_ruleTemplateBindingCS11975 = new BitSet(new long[]{0x0020000000000002L});
        public static final BitSet FOLLOW_ruleTemplateParameterSubstitutionCS_in_entryRuleTemplateParameterSubstitutionCS12013 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTemplateParameterSubstitutionCS12023 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTemplateParameterActualCS_in_ruleTemplateParameterSubstitutionCS12068 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTemplateSignatureCS_in_entryRuleTemplateSignatureCS12103 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTemplateSignatureCS12113 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleTemplateSignatureCS12150 = new BitSet(new long[]{0x0013FFF800000030L});
        public static final BitSet FOLLOW_ruleTypeParameterCS_in_ruleTemplateSignatureCS12171 = new BitSet(new long[]{0x0020000000200000L});
        public static final BitSet FOLLOW_53_in_ruleTemplateSignatureCS12184 = new BitSet(new long[]{0x0013FFF800000030L});
        public static final BitSet FOLLOW_ruleTypeParameterCS_in_ruleTemplateSignatureCS12205 = new BitSet(new long[]{0x0020000000200000L});
        public static final BitSet FOLLOW_21_in_ruleTemplateSignatureCS12219 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeParameterCS_in_entryRuleTypeParameterCS12255 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeParameterCS12265 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleTypeParameterCS12311 = new BitSet(new long[]{0x0000000000000002L,0x0000000000040000L});
        public static final BitSet FOLLOW_82_in_ruleTypeParameterCS12324 = new BitSet(new long[]{0x0013FFF800000030L});
        public static final BitSet FOLLOW_ruleSimpleTypeCS_in_ruleTypeParameterCS12345 = new BitSet(new long[]{0x0000000000000002L,0x0000000000080000L});
        public static final BitSet FOLLOW_83_in_ruleTypeParameterCS12358 = new BitSet(new long[]{0x0013FFF800000030L});
        public static final BitSet FOLLOW_ruleSimpleTypeCS_in_ruleTypeParameterCS12379 = new BitSet(new long[]{0x0000000000000002L,0x0000000000080000L});
        public static final BitSet FOLLOW_ruleWildcardTypeRefCS_in_entryRuleWildcardTypeRefCS12421 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleWildcardTypeRefCS12431 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_80_in_ruleWildcardTypeRefCS12480 = new BitSet(new long[]{0x0000000000000002L,0x0000000000040000L});
        public static final BitSet FOLLOW_82_in_ruleWildcardTypeRefCS12493 = new BitSet(new long[]{0x0013FFF800000030L});
        public static final BitSet FOLLOW_ruleSimpleTypeCS_in_ruleWildcardTypeRefCS12514 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleID_in_entryRuleID12553 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleID12564 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_SIMPLE_ID_in_ruleID12604 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ESCAPED_ID_in_ruleID12630 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_entryRuleIdentifier12676 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIdentifier12687 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleID_in_ruleIdentifier12733 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLOWER_in_entryRuleLOWER12778 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLOWER12789 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleLOWER12828 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNUMBER_LITERAL_in_entryRuleNUMBER_LITERAL12873 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNUMBER_LITERAL12884 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleNUMBER_LITERAL12923 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral12968 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteral12979 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_SINGLE_QUOTED_STRING_in_ruleStringLiteral13018 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUPPER_in_entryRuleUPPER13063 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUPPER13074 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleUPPER13114 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleUPPER13138 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleURI_in_entryRuleURI13179 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleURI13190 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_SINGLE_QUOTED_STRING_in_ruleURI13229 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralWithMultiplicityCS_in_synpred81_InternalEssentialOCL7148 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrefixedPrimaryExpCS_in_synpred83_InternalEssentialOCL7274 = new BitSet(new long[]{0x00000007FFFD0002L});
        public static final BitSet FOLLOW_ruleBinaryOperatorName_in_synpred83_InternalEssentialOCL7307 = new BitSet(new long[]{0xF017FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_synpred83_InternalEssentialOCL7328 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTupleLiteralExpCS_in_synpred90_InternalEssentialOCL7891 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMapLiteralExpCS_in_synpred91_InternalEssentialOCL7921 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionLiteralExpCS_in_synpred92_InternalEssentialOCL7951 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLambdaLiteralExpCS_in_synpred93_InternalEssentialOCL7981 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralExpCS_in_synpred94_InternalEssentialOCL8011 = new BitSet(new long[]{0x0000000000000002L});
    }


}