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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:868:1: ruleCollectionTypeCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleFullTypeDeclarationCS ) ) otherlv_3= ')' )? ) ;
    public final EObject ruleCollectionTypeCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:871:28: ( ( ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleFullTypeDeclarationCS ) ) otherlv_3= ')' )? ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:872:1: ( ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleFullTypeDeclarationCS ) ) otherlv_3= ')' )? )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:872:1: ( ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleFullTypeDeclarationCS ) ) otherlv_3= ')' )? )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:872:2: ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleFullTypeDeclarationCS ) ) otherlv_3= ')' )?
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:890:2: (otherlv_1= '(' ( (lv_ownedType_2_0= ruleFullTypeDeclarationCS ) ) otherlv_3= ')' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==50) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:890:4: otherlv_1= '(' ( (lv_ownedType_2_0= ruleFullTypeDeclarationCS ) ) otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,50,FollowSets000.FOLLOW_50_in_ruleCollectionTypeCS2418); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getCollectionTypeCSAccess().getLeftParenthesisKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:894:1: ( (lv_ownedType_2_0= ruleFullTypeDeclarationCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:895:1: (lv_ownedType_2_0= ruleFullTypeDeclarationCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:895:1: (lv_ownedType_2_0= ruleFullTypeDeclarationCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:896:3: lv_ownedType_2_0= ruleFullTypeDeclarationCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionTypeCSAccess().getOwnedTypeFullTypeDeclarationCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleFullTypeDeclarationCS_in_ruleCollectionTypeCS2439);
                    lv_ownedType_2_0=ruleFullTypeDeclarationCS();

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
                              		"FullTypeDeclarationCS");
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:984:1: ruleLambdaTypeCS returns [EObject current=null] : ( ( (lv_name_0_0= 'Lambda' ) ) ( (lv_ownedSignature_1_0= ruleTemplateSignatureCS ) )? otherlv_2= '(' ( ( (lv_ownedParameterTypes_3_0= ruleFullTypeDeclarationCS ) ) (otherlv_4= ',' ( (lv_ownedParameterTypes_5_0= ruleFullTypeDeclarationCS ) ) )* )? otherlv_6= ')' otherlv_7= ':' ( (lv_ownedResultType_8_0= ruleFullTypeDeclarationCS ) ) ) ;
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
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:987:28: ( ( ( (lv_name_0_0= 'Lambda' ) ) ( (lv_ownedSignature_1_0= ruleTemplateSignatureCS ) )? otherlv_2= '(' ( ( (lv_ownedParameterTypes_3_0= ruleFullTypeDeclarationCS ) ) (otherlv_4= ',' ( (lv_ownedParameterTypes_5_0= ruleFullTypeDeclarationCS ) ) )* )? otherlv_6= ')' otherlv_7= ':' ( (lv_ownedResultType_8_0= ruleFullTypeDeclarationCS ) ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:988:1: ( ( (lv_name_0_0= 'Lambda' ) ) ( (lv_ownedSignature_1_0= ruleTemplateSignatureCS ) )? otherlv_2= '(' ( ( (lv_ownedParameterTypes_3_0= ruleFullTypeDeclarationCS ) ) (otherlv_4= ',' ( (lv_ownedParameterTypes_5_0= ruleFullTypeDeclarationCS ) ) )* )? otherlv_6= ')' otherlv_7= ':' ( (lv_ownedResultType_8_0= ruleFullTypeDeclarationCS ) ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:988:1: ( ( (lv_name_0_0= 'Lambda' ) ) ( (lv_ownedSignature_1_0= ruleTemplateSignatureCS ) )? otherlv_2= '(' ( ( (lv_ownedParameterTypes_3_0= ruleFullTypeDeclarationCS ) ) (otherlv_4= ',' ( (lv_ownedParameterTypes_5_0= ruleFullTypeDeclarationCS ) ) )* )? otherlv_6= ')' otherlv_7= ':' ( (lv_ownedResultType_8_0= ruleFullTypeDeclarationCS ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:988:2: ( (lv_name_0_0= 'Lambda' ) ) ( (lv_ownedSignature_1_0= ruleTemplateSignatureCS ) )? otherlv_2= '(' ( ( (lv_ownedParameterTypes_3_0= ruleFullTypeDeclarationCS ) ) (otherlv_4= ',' ( (lv_ownedParameterTypes_5_0= ruleFullTypeDeclarationCS ) ) )* )? otherlv_6= ')' otherlv_7= ':' ( (lv_ownedResultType_8_0= ruleFullTypeDeclarationCS ) )
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
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1025:1: ( ( (lv_ownedParameterTypes_3_0= ruleFullTypeDeclarationCS ) ) (otherlv_4= ',' ( (lv_ownedParameterTypes_5_0= ruleFullTypeDeclarationCS ) ) )* )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( ((LA13_0>=RULE_SIMPLE_ID && LA13_0<=RULE_ESCAPED_ID)||(LA13_0>=35 && LA13_0<=49)||LA13_0==52) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1025:2: ( (lv_ownedParameterTypes_3_0= ruleFullTypeDeclarationCS ) ) (otherlv_4= ',' ( (lv_ownedParameterTypes_5_0= ruleFullTypeDeclarationCS ) ) )*
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1025:2: ( (lv_ownedParameterTypes_3_0= ruleFullTypeDeclarationCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1026:1: (lv_ownedParameterTypes_3_0= ruleFullTypeDeclarationCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1026:1: (lv_ownedParameterTypes_3_0= ruleFullTypeDeclarationCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1027:3: lv_ownedParameterTypes_3_0= ruleFullTypeDeclarationCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLambdaTypeCSAccess().getOwnedParameterTypesFullTypeDeclarationCSParserRuleCall_3_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleFullTypeDeclarationCS_in_ruleLambdaTypeCS2728);
                    lv_ownedParameterTypes_3_0=ruleFullTypeDeclarationCS();

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
                              		"FullTypeDeclarationCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1043:2: (otherlv_4= ',' ( (lv_ownedParameterTypes_5_0= ruleFullTypeDeclarationCS ) ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==53) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1043:4: otherlv_4= ',' ( (lv_ownedParameterTypes_5_0= ruleFullTypeDeclarationCS ) )
                    	    {
                    	    otherlv_4=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleLambdaTypeCS2741); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_4, grammarAccess.getLambdaTypeCSAccess().getCommaKeyword_3_1_0());
                    	          
                    	    }
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1047:1: ( (lv_ownedParameterTypes_5_0= ruleFullTypeDeclarationCS ) )
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1048:1: (lv_ownedParameterTypes_5_0= ruleFullTypeDeclarationCS )
                    	    {
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1048:1: (lv_ownedParameterTypes_5_0= ruleFullTypeDeclarationCS )
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1049:3: lv_ownedParameterTypes_5_0= ruleFullTypeDeclarationCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getLambdaTypeCSAccess().getOwnedParameterTypesFullTypeDeclarationCSParserRuleCall_3_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleFullTypeDeclarationCS_in_ruleLambdaTypeCS2762);
                    	    lv_ownedParameterTypes_5_0=ruleFullTypeDeclarationCS();

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
                    	              		"FullTypeDeclarationCS");
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
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1073:1: ( (lv_ownedResultType_8_0= ruleFullTypeDeclarationCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1074:1: (lv_ownedResultType_8_0= ruleFullTypeDeclarationCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1074:1: (lv_ownedResultType_8_0= ruleFullTypeDeclarationCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1075:3: lv_ownedResultType_8_0= ruleFullTypeDeclarationCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLambdaTypeCSAccess().getOwnedResultTypeFullTypeDeclarationCSParserRuleCall_6_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleFullTypeDeclarationCS_in_ruleLambdaTypeCS2811);
            lv_ownedResultType_8_0=ruleFullTypeDeclarationCS();

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
                      		"FullTypeDeclarationCS");
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1108:1: ruleMapTypeCS returns [EObject current=null] : ( ( (lv_name_0_0= 'Map' ) ) (otherlv_1= '(' ( (lv_ownedKeyType_2_0= ruleFullTypeDeclarationCS ) ) otherlv_3= ',' ( (lv_ownedValueType_4_0= ruleFullTypeDeclarationCS ) ) otherlv_5= ')' )? ) ;
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
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1111:28: ( ( ( (lv_name_0_0= 'Map' ) ) (otherlv_1= '(' ( (lv_ownedKeyType_2_0= ruleFullTypeDeclarationCS ) ) otherlv_3= ',' ( (lv_ownedValueType_4_0= ruleFullTypeDeclarationCS ) ) otherlv_5= ')' )? ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1112:1: ( ( (lv_name_0_0= 'Map' ) ) (otherlv_1= '(' ( (lv_ownedKeyType_2_0= ruleFullTypeDeclarationCS ) ) otherlv_3= ',' ( (lv_ownedValueType_4_0= ruleFullTypeDeclarationCS ) ) otherlv_5= ')' )? )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1112:1: ( ( (lv_name_0_0= 'Map' ) ) (otherlv_1= '(' ( (lv_ownedKeyType_2_0= ruleFullTypeDeclarationCS ) ) otherlv_3= ',' ( (lv_ownedValueType_4_0= ruleFullTypeDeclarationCS ) ) otherlv_5= ')' )? )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1112:2: ( (lv_name_0_0= 'Map' ) ) (otherlv_1= '(' ( (lv_ownedKeyType_2_0= ruleFullTypeDeclarationCS ) ) otherlv_3= ',' ( (lv_ownedValueType_4_0= ruleFullTypeDeclarationCS ) ) otherlv_5= ')' )?
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1127:2: (otherlv_1= '(' ( (lv_ownedKeyType_2_0= ruleFullTypeDeclarationCS ) ) otherlv_3= ',' ( (lv_ownedValueType_4_0= ruleFullTypeDeclarationCS ) ) otherlv_5= ')' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==50) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1127:4: otherlv_1= '(' ( (lv_ownedKeyType_2_0= ruleFullTypeDeclarationCS ) ) otherlv_3= ',' ( (lv_ownedValueType_4_0= ruleFullTypeDeclarationCS ) ) otherlv_5= ')'
                    {
                    otherlv_1=(Token)match(input,50,FollowSets000.FOLLOW_50_in_ruleMapTypeCS2926); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getMapTypeCSAccess().getLeftParenthesisKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1131:1: ( (lv_ownedKeyType_2_0= ruleFullTypeDeclarationCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1132:1: (lv_ownedKeyType_2_0= ruleFullTypeDeclarationCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1132:1: (lv_ownedKeyType_2_0= ruleFullTypeDeclarationCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1133:3: lv_ownedKeyType_2_0= ruleFullTypeDeclarationCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMapTypeCSAccess().getOwnedKeyTypeFullTypeDeclarationCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleFullTypeDeclarationCS_in_ruleMapTypeCS2947);
                    lv_ownedKeyType_2_0=ruleFullTypeDeclarationCS();

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
                              		"FullTypeDeclarationCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_3=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleMapTypeCS2959); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getMapTypeCSAccess().getCommaKeyword_1_2());
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1153:1: ( (lv_ownedValueType_4_0= ruleFullTypeDeclarationCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1154:1: (lv_ownedValueType_4_0= ruleFullTypeDeclarationCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1154:1: (lv_ownedValueType_4_0= ruleFullTypeDeclarationCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1155:3: lv_ownedValueType_4_0= ruleFullTypeDeclarationCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMapTypeCSAccess().getOwnedValueTypeFullTypeDeclarationCSParserRuleCall_1_3_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleFullTypeDeclarationCS_in_ruleMapTypeCS2980);
                    lv_ownedValueType_4_0=ruleFullTypeDeclarationCS();

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
                              		"FullTypeDeclarationCS");
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1276:1: ruleTuplePartCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleFullTypeDeclarationCS ) ) ) ;
    public final EObject ruleTuplePartCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1279:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleFullTypeDeclarationCS ) ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1280:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleFullTypeDeclarationCS ) ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1280:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleFullTypeDeclarationCS ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1280:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleFullTypeDeclarationCS ) )
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
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1302:1: ( (lv_ownedType_2_0= ruleFullTypeDeclarationCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1303:1: (lv_ownedType_2_0= ruleFullTypeDeclarationCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1303:1: (lv_ownedType_2_0= ruleFullTypeDeclarationCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1304:3: lv_ownedType_2_0= ruleFullTypeDeclarationCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTuplePartCSAccess().getOwnedTypeFullTypeDeclarationCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleFullTypeDeclarationCS_in_ruleTuplePartCS3308);
            lv_ownedType_2_0=ruleFullTypeDeclarationCS();

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
                      		"FullTypeDeclarationCS");
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


    // $ANTLR start "entryRuleSimpleTypeDeclarationCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1328:1: entryRuleSimpleTypeDeclarationCS returns [EObject current=null] : iv_ruleSimpleTypeDeclarationCS= ruleSimpleTypeDeclarationCS EOF ;
    public final EObject entryRuleSimpleTypeDeclarationCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleTypeDeclarationCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1329:2: (iv_ruleSimpleTypeDeclarationCS= ruleSimpleTypeDeclarationCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1330:2: iv_ruleSimpleTypeDeclarationCS= ruleSimpleTypeDeclarationCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSimpleTypeDeclarationCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSimpleTypeDeclarationCS_in_entryRuleSimpleTypeDeclarationCS3344);
            iv_ruleSimpleTypeDeclarationCS=ruleSimpleTypeDeclarationCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSimpleTypeDeclarationCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSimpleTypeDeclarationCS3354); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1337:1: ruleSimpleTypeDeclarationCS returns [EObject current=null] : (this_TypeLiteralCS_0= ruleTypeLiteralCS | this_PathTypeCS_1= rulePathTypeCS ) ;
    public final EObject ruleSimpleTypeDeclarationCS() throws RecognitionException {
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
                       
                              newCompositeNode(grammarAccess.getSimpleTypeDeclarationCSAccess().getTypeLiteralCSParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralCS_in_ruleSimpleTypeDeclarationCS3404);
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
                       
                              newCompositeNode(grammarAccess.getSimpleTypeDeclarationCSAccess().getPathTypeCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePathTypeCS_in_ruleSimpleTypeDeclarationCS3434);
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
    // $ANTLR end "ruleSimpleTypeDeclarationCS"


    // $ANTLR start "entryRuleFullTypeDeclarationCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1374:1: entryRuleFullTypeDeclarationCS returns [EObject current=null] : iv_ruleFullTypeDeclarationCS= ruleFullTypeDeclarationCS EOF ;
    public final EObject entryRuleFullTypeDeclarationCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFullTypeDeclarationCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1375:2: (iv_ruleFullTypeDeclarationCS= ruleFullTypeDeclarationCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1376:2: iv_ruleFullTypeDeclarationCS= ruleFullTypeDeclarationCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFullTypeDeclarationCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleFullTypeDeclarationCS_in_entryRuleFullTypeDeclarationCS3469);
            iv_ruleFullTypeDeclarationCS=ruleFullTypeDeclarationCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFullTypeDeclarationCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFullTypeDeclarationCS3479); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1383:1: ruleFullTypeDeclarationCS returns [EObject current=null] : (this_TypeLiteralWithMultiplicityCS_0= ruleTypeLiteralWithMultiplicityCS | (this_PathTypeCS_1= rulePathTypeCS ( (lv_ownedMultiplicity_2_0= ruleMultiplicityCS ) )? ) ) ;
    public final EObject ruleFullTypeDeclarationCS() throws RecognitionException {
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
                       
                              newCompositeNode(grammarAccess.getFullTypeDeclarationCSAccess().getTypeLiteralWithMultiplicityCSParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralWithMultiplicityCS_in_ruleFullTypeDeclarationCS3529);
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
                       
                              newCompositeNode(grammarAccess.getFullTypeDeclarationCSAccess().getPathTypeCSParserRuleCall_1_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePathTypeCS_in_ruleFullTypeDeclarationCS3560);
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
                               
                              	        newCompositeNode(grammarAccess.getFullTypeDeclarationCSAccess().getOwnedMultiplicityMultiplicityCSParserRuleCall_1_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleMultiplicityCS_in_ruleFullTypeDeclarationCS3580);
                            lv_ownedMultiplicity_2_0=ruleMultiplicityCS();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getFullTypeDeclarationCSRule());
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
    // $ANTLR end "ruleFullTypeDeclarationCS"


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

                if ( (LA24_2==EOF||LA24_2==16||(LA24_2>=18 && LA24_2<=34)||LA24_2==50||LA24_2==53||(LA24_2>=55 && LA24_2<=57)||LA24_2==64||LA24_2==66||LA24_2==81) ) {
                    alt24=1;
                }
                else if ( (LA24_2==54) ) {
                    alt24=2;
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

                if ( (LA24_3==54) ) {
                    alt24=2;
                }
                else if ( (LA24_3==EOF||LA24_3==16||(LA24_3>=18 && LA24_3<=34)||LA24_3==50||LA24_3==53||(LA24_3>=55 && LA24_3<=57)||LA24_3==64||LA24_3==66||LA24_3==81) ) {
                    alt24=1;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1863:1: ruleLambdaLiteralExpCS returns [EObject current=null] : (otherlv_0= 'Lambda' otherlv_1= '{' ( (lv_ownedExpressionCS_2_0= ruleExpCS ) ) otherlv_3= '}' ) ;
    public final EObject ruleLambdaLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_ownedExpressionCS_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1866:28: ( (otherlv_0= 'Lambda' otherlv_1= '{' ( (lv_ownedExpressionCS_2_0= ruleExpCS ) ) otherlv_3= '}' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1867:1: (otherlv_0= 'Lambda' otherlv_1= '{' ( (lv_ownedExpressionCS_2_0= ruleExpCS ) ) otherlv_3= '}' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1867:1: (otherlv_0= 'Lambda' otherlv_1= '{' ( (lv_ownedExpressionCS_2_0= ruleExpCS ) ) otherlv_3= '}' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1867:3: otherlv_0= 'Lambda' otherlv_1= '{' ( (lv_ownedExpressionCS_2_0= ruleExpCS ) ) otherlv_3= '}'
            {
            otherlv_0=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleLambdaLiteralExpCS4490); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLambdaLiteralExpCSAccess().getLambdaKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleLambdaLiteralExpCS4502); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getLambdaLiteralExpCSAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1875:1: ( (lv_ownedExpressionCS_2_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1876:1: (lv_ownedExpressionCS_2_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1876:1: (lv_ownedExpressionCS_2_0= ruleExpCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1877:3: lv_ownedExpressionCS_2_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLambdaLiteralExpCSAccess().getOwnedExpressionCSExpCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleLambdaLiteralExpCS4523);
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

            otherlv_3=(Token)match(input,56,FollowSets000.FOLLOW_56_in_ruleLambdaLiteralExpCS4535); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1905:1: entryRuleMapLiteralExpCS returns [EObject current=null] : iv_ruleMapLiteralExpCS= ruleMapLiteralExpCS EOF ;
    public final EObject entryRuleMapLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMapLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1906:2: (iv_ruleMapLiteralExpCS= ruleMapLiteralExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1907:2: iv_ruleMapLiteralExpCS= ruleMapLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMapLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMapLiteralExpCS_in_entryRuleMapLiteralExpCS4571);
            iv_ruleMapLiteralExpCS=ruleMapLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMapLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMapLiteralExpCS4581); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1914:1: ruleMapLiteralExpCS returns [EObject current=null] : ( ( (lv_ownedType_0_0= ruleMapTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleMapLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) ) )* )? otherlv_5= '}' ) ;
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
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1917:28: ( ( ( (lv_ownedType_0_0= ruleMapTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleMapLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) ) )* )? otherlv_5= '}' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1918:1: ( ( (lv_ownedType_0_0= ruleMapTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleMapLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) ) )* )? otherlv_5= '}' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1918:1: ( ( (lv_ownedType_0_0= ruleMapTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleMapLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) ) )* )? otherlv_5= '}' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1918:2: ( (lv_ownedType_0_0= ruleMapTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleMapLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) ) )* )? otherlv_5= '}'
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1918:2: ( (lv_ownedType_0_0= ruleMapTypeCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1919:1: (lv_ownedType_0_0= ruleMapTypeCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1919:1: (lv_ownedType_0_0= ruleMapTypeCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1920:3: lv_ownedType_0_0= ruleMapTypeCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMapLiteralExpCSAccess().getOwnedTypeMapTypeCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleMapTypeCS_in_ruleMapLiteralExpCS4627);
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

            otherlv_1=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleMapLiteralExpCS4639); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getMapLiteralExpCSAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1940:1: ( ( (lv_ownedParts_2_0= ruleMapLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) ) )* )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( ((LA30_0>=RULE_SIMPLE_ID && LA30_0<=RULE_SINGLE_QUOTED_STRING)||(LA30_0>=16 && LA30_0<=18)||(LA30_0>=35 && LA30_0<=50)||LA30_0==52||(LA30_0>=60 && LA30_0<=63)||LA30_0==71||(LA30_0>=76 && LA30_0<=77)) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1940:2: ( (lv_ownedParts_2_0= ruleMapLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) ) )*
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1940:2: ( (lv_ownedParts_2_0= ruleMapLiteralPartCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1941:1: (lv_ownedParts_2_0= ruleMapLiteralPartCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1941:1: (lv_ownedParts_2_0= ruleMapLiteralPartCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1942:3: lv_ownedParts_2_0= ruleMapLiteralPartCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMapLiteralExpCSAccess().getOwnedPartsMapLiteralPartCSParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMapLiteralPartCS_in_ruleMapLiteralExpCS4661);
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

                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1958:2: (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) ) )*
                    loop29:
                    do {
                        int alt29=2;
                        int LA29_0 = input.LA(1);

                        if ( (LA29_0==53) ) {
                            alt29=1;
                        }


                        switch (alt29) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1958:4: otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) )
                    	    {
                    	    otherlv_3=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleMapLiteralExpCS4674); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getMapLiteralExpCSAccess().getCommaKeyword_2_1_0());
                    	          
                    	    }
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1962:1: ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) )
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1963:1: (lv_ownedParts_4_0= ruleMapLiteralPartCS )
                    	    {
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1963:1: (lv_ownedParts_4_0= ruleMapLiteralPartCS )
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1964:3: lv_ownedParts_4_0= ruleMapLiteralPartCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getMapLiteralExpCSAccess().getOwnedPartsMapLiteralPartCSParserRuleCall_2_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleMapLiteralPartCS_in_ruleMapLiteralExpCS4695);
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
                    	    break loop29;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,56,FollowSets000.FOLLOW_56_in_ruleMapLiteralExpCS4711); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1992:1: entryRuleMapLiteralPartCS returns [EObject current=null] : iv_ruleMapLiteralPartCS= ruleMapLiteralPartCS EOF ;
    public final EObject entryRuleMapLiteralPartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMapLiteralPartCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1993:2: (iv_ruleMapLiteralPartCS= ruleMapLiteralPartCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1994:2: iv_ruleMapLiteralPartCS= ruleMapLiteralPartCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMapLiteralPartCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMapLiteralPartCS_in_entryRuleMapLiteralPartCS4747);
            iv_ruleMapLiteralPartCS=ruleMapLiteralPartCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMapLiteralPartCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMapLiteralPartCS4757); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2001:1: ruleMapLiteralPartCS returns [EObject current=null] : ( ( (lv_ownedKey_0_0= ruleExpCS ) ) otherlv_1= '<-' ( (lv_ownedValue_2_0= ruleExpCS ) ) ) ;
    public final EObject ruleMapLiteralPartCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_ownedKey_0_0 = null;

        EObject lv_ownedValue_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2004:28: ( ( ( (lv_ownedKey_0_0= ruleExpCS ) ) otherlv_1= '<-' ( (lv_ownedValue_2_0= ruleExpCS ) ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2005:1: ( ( (lv_ownedKey_0_0= ruleExpCS ) ) otherlv_1= '<-' ( (lv_ownedValue_2_0= ruleExpCS ) ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2005:1: ( ( (lv_ownedKey_0_0= ruleExpCS ) ) otherlv_1= '<-' ( (lv_ownedValue_2_0= ruleExpCS ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2005:2: ( (lv_ownedKey_0_0= ruleExpCS ) ) otherlv_1= '<-' ( (lv_ownedValue_2_0= ruleExpCS ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2005:2: ( (lv_ownedKey_0_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2006:1: (lv_ownedKey_0_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2006:1: (lv_ownedKey_0_0= ruleExpCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2007:3: lv_ownedKey_0_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMapLiteralPartCSAccess().getOwnedKeyExpCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleMapLiteralPartCS4803);
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

            otherlv_1=(Token)match(input,59,FollowSets000.FOLLOW_59_in_ruleMapLiteralPartCS4815); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getMapLiteralPartCSAccess().getLessThanSignHyphenMinusKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2027:1: ( (lv_ownedValue_2_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2028:1: (lv_ownedValue_2_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2028:1: (lv_ownedValue_2_0= ruleExpCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2029:3: lv_ownedValue_2_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMapLiteralPartCSAccess().getOwnedValueExpCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleMapLiteralPartCS4836);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2053:1: entryRulePrimitiveLiteralExpCS returns [EObject current=null] : iv_rulePrimitiveLiteralExpCS= rulePrimitiveLiteralExpCS EOF ;
    public final EObject entryRulePrimitiveLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2054:2: (iv_rulePrimitiveLiteralExpCS= rulePrimitiveLiteralExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2055:2: iv_rulePrimitiveLiteralExpCS= rulePrimitiveLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePrimitiveLiteralExpCS_in_entryRulePrimitiveLiteralExpCS4872);
            iv_rulePrimitiveLiteralExpCS=rulePrimitiveLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimitiveLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrimitiveLiteralExpCS4882); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2062:1: rulePrimitiveLiteralExpCS returns [EObject current=null] : (this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS | this_StringLiteralExpCS_1= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_5= ruleNullLiteralExpCS ) ;
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
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2065:28: ( (this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS | this_StringLiteralExpCS_1= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_5= ruleNullLiteralExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2066:1: (this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS | this_StringLiteralExpCS_1= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_5= ruleNullLiteralExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2066:1: (this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS | this_StringLiteralExpCS_1= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_5= ruleNullLiteralExpCS )
            int alt31=6;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt31=1;
                }
                break;
            case RULE_SINGLE_QUOTED_STRING:
                {
                alt31=2;
                }
                break;
            case 60:
            case 61:
                {
                alt31=3;
                }
                break;
            case 18:
                {
                alt31=4;
                }
                break;
            case 62:
                {
                alt31=5;
                }
                break;
            case 63:
                {
                alt31=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }

            switch (alt31) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2067:2: this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getNumberLiteralExpCSParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNumberLiteralExpCS_in_rulePrimitiveLiteralExpCS4932);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2080:2: this_StringLiteralExpCS_1= ruleStringLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getStringLiteralExpCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleStringLiteralExpCS_in_rulePrimitiveLiteralExpCS4962);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2093:2: this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getBooleanLiteralExpCSParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleBooleanLiteralExpCS_in_rulePrimitiveLiteralExpCS4992);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2106:2: this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getUnlimitedNaturalLiteralExpCSParserRuleCall_3()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUnlimitedNaturalLiteralExpCS_in_rulePrimitiveLiteralExpCS5022);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2119:2: this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getInvalidLiteralExpCSParserRuleCall_4()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleInvalidLiteralExpCS_in_rulePrimitiveLiteralExpCS5052);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2132:2: this_NullLiteralExpCS_5= ruleNullLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getNullLiteralExpCSParserRuleCall_5()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNullLiteralExpCS_in_rulePrimitiveLiteralExpCS5082);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2151:1: entryRuleTupleLiteralExpCS returns [EObject current=null] : iv_ruleTupleLiteralExpCS= ruleTupleLiteralExpCS EOF ;
    public final EObject entryRuleTupleLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTupleLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2152:2: (iv_ruleTupleLiteralExpCS= ruleTupleLiteralExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2153:2: iv_ruleTupleLiteralExpCS= ruleTupleLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTupleLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralExpCS_in_entryRuleTupleLiteralExpCS5117);
            iv_ruleTupleLiteralExpCS=ruleTupleLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTupleLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTupleLiteralExpCS5127); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2160:1: ruleTupleLiteralExpCS returns [EObject current=null] : (otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}' ) ;
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
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2163:28: ( (otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2164:1: (otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2164:1: (otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2164:3: otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleTupleLiteralExpCS5164); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getTupleLiteralExpCSAccess().getTupleKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleTupleLiteralExpCS5176); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getTupleLiteralExpCSAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2172:1: ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2173:1: (lv_ownedParts_2_0= ruleTupleLiteralPartCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2173:1: (lv_ownedParts_2_0= ruleTupleLiteralPartCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2174:3: lv_ownedParts_2_0= ruleTupleLiteralPartCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTupleLiteralExpCSAccess().getOwnedPartsTupleLiteralPartCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralPartCS_in_ruleTupleLiteralExpCS5197);
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2190:2: (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==53) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2190:4: otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) )
            	    {
            	    otherlv_3=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleTupleLiteralExpCS5210); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getTupleLiteralExpCSAccess().getCommaKeyword_3_0());
            	          
            	    }
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2194:1: ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) )
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2195:1: (lv_ownedParts_4_0= ruleTupleLiteralPartCS )
            	    {
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2195:1: (lv_ownedParts_4_0= ruleTupleLiteralPartCS )
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2196:3: lv_ownedParts_4_0= ruleTupleLiteralPartCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTupleLiteralExpCSAccess().getOwnedPartsTupleLiteralPartCSParserRuleCall_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralPartCS_in_ruleTupleLiteralExpCS5231);
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
            	    break loop32;
                }
            } while (true);

            otherlv_5=(Token)match(input,56,FollowSets000.FOLLOW_56_in_ruleTupleLiteralExpCS5245); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2224:1: entryRuleTupleLiteralPartCS returns [EObject current=null] : iv_ruleTupleLiteralPartCS= ruleTupleLiteralPartCS EOF ;
    public final EObject entryRuleTupleLiteralPartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTupleLiteralPartCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2225:2: (iv_ruleTupleLiteralPartCS= ruleTupleLiteralPartCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2226:2: iv_ruleTupleLiteralPartCS= ruleTupleLiteralPartCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTupleLiteralPartCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralPartCS_in_entryRuleTupleLiteralPartCS5281);
            iv_ruleTupleLiteralPartCS=ruleTupleLiteralPartCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTupleLiteralPartCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTupleLiteralPartCS5291); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2233:1: ruleTupleLiteralPartCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) ) ;
    public final EObject ruleTupleLiteralPartCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;

        EObject lv_ownedInitExpression_4_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2236:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2237:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2237:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2237:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2237:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2238:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2238:1: (lv_name_0_0= ruleUnrestrictedName )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2239:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTupleLiteralPartCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleTupleLiteralPartCS5337);
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2255:2: (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==54) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2255:4: otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                    {
                    otherlv_1=(Token)match(input,54,FollowSets000.FOLLOW_54_in_ruleTupleLiteralPartCS5350); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getTupleLiteralPartCSAccess().getColonKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2259:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2260:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2260:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2261:3: lv_ownedType_2_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTupleLiteralPartCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleTupleLiteralPartCS5371);
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

            otherlv_3=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleTupleLiteralPartCS5385); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getTupleLiteralPartCSAccess().getEqualsSignKeyword_2());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2281:1: ( (lv_ownedInitExpression_4_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2282:1: (lv_ownedInitExpression_4_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2282:1: (lv_ownedInitExpression_4_0= ruleExpCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2283:3: lv_ownedInitExpression_4_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTupleLiteralPartCSAccess().getOwnedInitExpressionExpCSParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleTupleLiteralPartCS5406);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2307:1: entryRuleNumberLiteralExpCS returns [EObject current=null] : iv_ruleNumberLiteralExpCS= ruleNumberLiteralExpCS EOF ;
    public final EObject entryRuleNumberLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2308:2: (iv_ruleNumberLiteralExpCS= ruleNumberLiteralExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2309:2: iv_ruleNumberLiteralExpCS= ruleNumberLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumberLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNumberLiteralExpCS_in_entryRuleNumberLiteralExpCS5442);
            iv_ruleNumberLiteralExpCS=ruleNumberLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumberLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNumberLiteralExpCS5452); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2316:1: ruleNumberLiteralExpCS returns [EObject current=null] : ( (lv_symbol_0_0= ruleNUMBER_LITERAL ) ) ;
    public final EObject ruleNumberLiteralExpCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_symbol_0_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2319:28: ( ( (lv_symbol_0_0= ruleNUMBER_LITERAL ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2320:1: ( (lv_symbol_0_0= ruleNUMBER_LITERAL ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2320:1: ( (lv_symbol_0_0= ruleNUMBER_LITERAL ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2321:1: (lv_symbol_0_0= ruleNUMBER_LITERAL )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2321:1: (lv_symbol_0_0= ruleNUMBER_LITERAL )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2322:3: lv_symbol_0_0= ruleNUMBER_LITERAL
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNumberLiteralExpCSAccess().getSymbolNUMBER_LITERALParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleNUMBER_LITERAL_in_ruleNumberLiteralExpCS5497);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2346:1: entryRuleStringLiteralExpCS returns [EObject current=null] : iv_ruleStringLiteralExpCS= ruleStringLiteralExpCS EOF ;
    public final EObject entryRuleStringLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2347:2: (iv_ruleStringLiteralExpCS= ruleStringLiteralExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2348:2: iv_ruleStringLiteralExpCS= ruleStringLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStringLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleStringLiteralExpCS_in_entryRuleStringLiteralExpCS5532);
            iv_ruleStringLiteralExpCS=ruleStringLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStringLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleStringLiteralExpCS5542); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2355:1: ruleStringLiteralExpCS returns [EObject current=null] : ( (lv_segments_0_0= ruleStringLiteral ) )+ ;
    public final EObject ruleStringLiteralExpCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_segments_0_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2358:28: ( ( (lv_segments_0_0= ruleStringLiteral ) )+ )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2359:1: ( (lv_segments_0_0= ruleStringLiteral ) )+
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2359:1: ( (lv_segments_0_0= ruleStringLiteral ) )+
            int cnt34=0;
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==RULE_SINGLE_QUOTED_STRING) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2360:1: (lv_segments_0_0= ruleStringLiteral )
            	    {
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2360:1: (lv_segments_0_0= ruleStringLiteral )
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2361:3: lv_segments_0_0= ruleStringLiteral
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getStringLiteralExpCSAccess().getSegmentsStringLiteralParserRuleCall_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleStringLiteral_in_ruleStringLiteralExpCS5587);
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
            	    if ( cnt34 >= 1 ) break loop34;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(34, input);
                        throw eee;
                }
                cnt34++;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2385:1: entryRuleBooleanLiteralExpCS returns [EObject current=null] : iv_ruleBooleanLiteralExpCS= ruleBooleanLiteralExpCS EOF ;
    public final EObject entryRuleBooleanLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2386:2: (iv_ruleBooleanLiteralExpCS= ruleBooleanLiteralExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2387:2: iv_ruleBooleanLiteralExpCS= ruleBooleanLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBooleanLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleBooleanLiteralExpCS_in_entryRuleBooleanLiteralExpCS5623);
            iv_ruleBooleanLiteralExpCS=ruleBooleanLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBooleanLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBooleanLiteralExpCS5633); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2394:1: ruleBooleanLiteralExpCS returns [EObject current=null] : ( ( (lv_symbol_0_0= 'true' ) ) | ( (lv_symbol_1_0= 'false' ) ) ) ;
    public final EObject ruleBooleanLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token lv_symbol_0_0=null;
        Token lv_symbol_1_0=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2397:28: ( ( ( (lv_symbol_0_0= 'true' ) ) | ( (lv_symbol_1_0= 'false' ) ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2398:1: ( ( (lv_symbol_0_0= 'true' ) ) | ( (lv_symbol_1_0= 'false' ) ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2398:1: ( ( (lv_symbol_0_0= 'true' ) ) | ( (lv_symbol_1_0= 'false' ) ) )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==60) ) {
                alt35=1;
            }
            else if ( (LA35_0==61) ) {
                alt35=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }
            switch (alt35) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2398:2: ( (lv_symbol_0_0= 'true' ) )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2398:2: ( (lv_symbol_0_0= 'true' ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2399:1: (lv_symbol_0_0= 'true' )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2399:1: (lv_symbol_0_0= 'true' )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2400:3: lv_symbol_0_0= 'true'
                    {
                    lv_symbol_0_0=(Token)match(input,60,FollowSets000.FOLLOW_60_in_ruleBooleanLiteralExpCS5676); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2414:6: ( (lv_symbol_1_0= 'false' ) )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2414:6: ( (lv_symbol_1_0= 'false' ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2415:1: (lv_symbol_1_0= 'false' )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2415:1: (lv_symbol_1_0= 'false' )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2416:3: lv_symbol_1_0= 'false'
                    {
                    lv_symbol_1_0=(Token)match(input,61,FollowSets000.FOLLOW_61_in_ruleBooleanLiteralExpCS5713); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2437:1: entryRuleUnlimitedNaturalLiteralExpCS returns [EObject current=null] : iv_ruleUnlimitedNaturalLiteralExpCS= ruleUnlimitedNaturalLiteralExpCS EOF ;
    public final EObject entryRuleUnlimitedNaturalLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnlimitedNaturalLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2438:2: (iv_ruleUnlimitedNaturalLiteralExpCS= ruleUnlimitedNaturalLiteralExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2439:2: iv_ruleUnlimitedNaturalLiteralExpCS= ruleUnlimitedNaturalLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnlimitedNaturalLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnlimitedNaturalLiteralExpCS_in_entryRuleUnlimitedNaturalLiteralExpCS5762);
            iv_ruleUnlimitedNaturalLiteralExpCS=ruleUnlimitedNaturalLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnlimitedNaturalLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnlimitedNaturalLiteralExpCS5772); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2446:1: ruleUnlimitedNaturalLiteralExpCS returns [EObject current=null] : ( () otherlv_1= '*' ) ;
    public final EObject ruleUnlimitedNaturalLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2449:28: ( ( () otherlv_1= '*' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2450:1: ( () otherlv_1= '*' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2450:1: ( () otherlv_1= '*' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2450:2: () otherlv_1= '*'
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2450:2: ()
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2451:2: 
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

            otherlv_1=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleUnlimitedNaturalLiteralExpCS5821); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2471:1: entryRuleInvalidLiteralExpCS returns [EObject current=null] : iv_ruleInvalidLiteralExpCS= ruleInvalidLiteralExpCS EOF ;
    public final EObject entryRuleInvalidLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInvalidLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2472:2: (iv_ruleInvalidLiteralExpCS= ruleInvalidLiteralExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2473:2: iv_ruleInvalidLiteralExpCS= ruleInvalidLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInvalidLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleInvalidLiteralExpCS_in_entryRuleInvalidLiteralExpCS5857);
            iv_ruleInvalidLiteralExpCS=ruleInvalidLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInvalidLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleInvalidLiteralExpCS5867); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2480:1: ruleInvalidLiteralExpCS returns [EObject current=null] : ( () otherlv_1= 'invalid' ) ;
    public final EObject ruleInvalidLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2483:28: ( ( () otherlv_1= 'invalid' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2484:1: ( () otherlv_1= 'invalid' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2484:1: ( () otherlv_1= 'invalid' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2484:2: () otherlv_1= 'invalid'
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2484:2: ()
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2485:2: 
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

            otherlv_1=(Token)match(input,62,FollowSets000.FOLLOW_62_in_ruleInvalidLiteralExpCS5916); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2505:1: entryRuleNullLiteralExpCS returns [EObject current=null] : iv_ruleNullLiteralExpCS= ruleNullLiteralExpCS EOF ;
    public final EObject entryRuleNullLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2506:2: (iv_ruleNullLiteralExpCS= ruleNullLiteralExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2507:2: iv_ruleNullLiteralExpCS= ruleNullLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNullLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNullLiteralExpCS_in_entryRuleNullLiteralExpCS5952);
            iv_ruleNullLiteralExpCS=ruleNullLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNullLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNullLiteralExpCS5962); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2514:1: ruleNullLiteralExpCS returns [EObject current=null] : ( () otherlv_1= 'null' ) ;
    public final EObject ruleNullLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2517:28: ( ( () otherlv_1= 'null' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2518:1: ( () otherlv_1= 'null' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2518:1: ( () otherlv_1= 'null' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2518:2: () otherlv_1= 'null'
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2518:2: ()
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2519:2: 
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

            otherlv_1=(Token)match(input,63,FollowSets000.FOLLOW_63_in_ruleNullLiteralExpCS6011); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2539:1: entryRuleTypeLiteralCS returns [EObject current=null] : iv_ruleTypeLiteralCS= ruleTypeLiteralCS EOF ;
    public final EObject entryRuleTypeLiteralCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeLiteralCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2540:2: (iv_ruleTypeLiteralCS= ruleTypeLiteralCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2541:2: iv_ruleTypeLiteralCS= ruleTypeLiteralCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeLiteralCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralCS_in_entryRuleTypeLiteralCS6047);
            iv_ruleTypeLiteralCS=ruleTypeLiteralCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeLiteralCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeLiteralCS6057); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2548:1: ruleTypeLiteralCS returns [EObject current=null] : (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS | this_CollectionTypeCS_1= ruleCollectionTypeCS | this_MapTypeCS_2= ruleMapTypeCS | this_TupleTypeCS_3= ruleTupleTypeCS ) ;
    public final EObject ruleTypeLiteralCS() throws RecognitionException {
        EObject current = null;

        EObject this_PrimitiveTypeCS_0 = null;

        EObject this_CollectionTypeCS_1 = null;

        EObject this_MapTypeCS_2 = null;

        EObject this_TupleTypeCS_3 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2551:28: ( (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS | this_CollectionTypeCS_1= ruleCollectionTypeCS | this_MapTypeCS_2= ruleMapTypeCS | this_TupleTypeCS_3= ruleTupleTypeCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2552:1: (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS | this_CollectionTypeCS_1= ruleCollectionTypeCS | this_MapTypeCS_2= ruleMapTypeCS | this_TupleTypeCS_3= ruleTupleTypeCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2552:1: (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS | this_CollectionTypeCS_1= ruleCollectionTypeCS | this_MapTypeCS_2= ruleMapTypeCS | this_TupleTypeCS_3= ruleTupleTypeCS )
            int alt36=4;
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
                alt36=1;
                }
                break;
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
                {
                alt36=2;
                }
                break;
            case 35:
                {
                alt36=3;
                }
                break;
            case 36:
                {
                alt36=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }

            switch (alt36) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2553:2: this_PrimitiveTypeCS_0= rulePrimitiveTypeCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeLiteralCSAccess().getPrimitiveTypeCSParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrimitiveTypeCS_in_ruleTypeLiteralCS6107);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2566:2: this_CollectionTypeCS_1= ruleCollectionTypeCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeLiteralCSAccess().getCollectionTypeCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCollectionTypeCS_in_ruleTypeLiteralCS6137);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2579:2: this_MapTypeCS_2= ruleMapTypeCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeLiteralCSAccess().getMapTypeCSParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMapTypeCS_in_ruleTypeLiteralCS6167);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2592:2: this_TupleTypeCS_3= ruleTupleTypeCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeLiteralCSAccess().getTupleTypeCSParserRuleCall_3()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTupleTypeCS_in_ruleTypeLiteralCS6197);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2611:1: entryRuleTypeLiteralWithMultiplicityCS returns [EObject current=null] : iv_ruleTypeLiteralWithMultiplicityCS= ruleTypeLiteralWithMultiplicityCS EOF ;
    public final EObject entryRuleTypeLiteralWithMultiplicityCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeLiteralWithMultiplicityCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2612:2: (iv_ruleTypeLiteralWithMultiplicityCS= ruleTypeLiteralWithMultiplicityCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2613:2: iv_ruleTypeLiteralWithMultiplicityCS= ruleTypeLiteralWithMultiplicityCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeLiteralWithMultiplicityCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralWithMultiplicityCS_in_entryRuleTypeLiteralWithMultiplicityCS6232);
            iv_ruleTypeLiteralWithMultiplicityCS=ruleTypeLiteralWithMultiplicityCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeLiteralWithMultiplicityCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeLiteralWithMultiplicityCS6242); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2620:1: ruleTypeLiteralWithMultiplicityCS returns [EObject current=null] : (this_CollectionTypeWithMultiplicityCS_0= ruleCollectionTypeWithMultiplicityCS | this_LambdaTypeCS_1= ruleLambdaTypeCS | ( (this_PrimitiveTypeCS_2= rulePrimitiveTypeCS | this_MapTypeCS_3= ruleMapTypeCS | this_TupleTypeCS_4= ruleTupleTypeCS ) ( (lv_ownedMultiplicity_5_0= ruleMultiplicityCS ) )? ) ) ;
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
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2623:28: ( (this_CollectionTypeWithMultiplicityCS_0= ruleCollectionTypeWithMultiplicityCS | this_LambdaTypeCS_1= ruleLambdaTypeCS | ( (this_PrimitiveTypeCS_2= rulePrimitiveTypeCS | this_MapTypeCS_3= ruleMapTypeCS | this_TupleTypeCS_4= ruleTupleTypeCS ) ( (lv_ownedMultiplicity_5_0= ruleMultiplicityCS ) )? ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2624:1: (this_CollectionTypeWithMultiplicityCS_0= ruleCollectionTypeWithMultiplicityCS | this_LambdaTypeCS_1= ruleLambdaTypeCS | ( (this_PrimitiveTypeCS_2= rulePrimitiveTypeCS | this_MapTypeCS_3= ruleMapTypeCS | this_TupleTypeCS_4= ruleTupleTypeCS ) ( (lv_ownedMultiplicity_5_0= ruleMultiplicityCS ) )? ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2624:1: (this_CollectionTypeWithMultiplicityCS_0= ruleCollectionTypeWithMultiplicityCS | this_LambdaTypeCS_1= ruleLambdaTypeCS | ( (this_PrimitiveTypeCS_2= rulePrimitiveTypeCS | this_MapTypeCS_3= ruleMapTypeCS | this_TupleTypeCS_4= ruleTupleTypeCS ) ( (lv_ownedMultiplicity_5_0= ruleMultiplicityCS ) )? ) )
            int alt39=3;
            switch ( input.LA(1) ) {
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
                {
                alt39=1;
                }
                break;
            case 52:
                {
                alt39=2;
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2625:2: this_CollectionTypeWithMultiplicityCS_0= ruleCollectionTypeWithMultiplicityCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeLiteralWithMultiplicityCSAccess().getCollectionTypeWithMultiplicityCSParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCollectionTypeWithMultiplicityCS_in_ruleTypeLiteralWithMultiplicityCS6292);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2638:2: this_LambdaTypeCS_1= ruleLambdaTypeCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeLiteralWithMultiplicityCSAccess().getLambdaTypeCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLambdaTypeCS_in_ruleTypeLiteralWithMultiplicityCS6322);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2650:6: ( (this_PrimitiveTypeCS_2= rulePrimitiveTypeCS | this_MapTypeCS_3= ruleMapTypeCS | this_TupleTypeCS_4= ruleTupleTypeCS ) ( (lv_ownedMultiplicity_5_0= ruleMultiplicityCS ) )? )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2650:6: ( (this_PrimitiveTypeCS_2= rulePrimitiveTypeCS | this_MapTypeCS_3= ruleMapTypeCS | this_TupleTypeCS_4= ruleTupleTypeCS ) ( (lv_ownedMultiplicity_5_0= ruleMultiplicityCS ) )? )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2650:7: (this_PrimitiveTypeCS_2= rulePrimitiveTypeCS | this_MapTypeCS_3= ruleMapTypeCS | this_TupleTypeCS_4= ruleTupleTypeCS ) ( (lv_ownedMultiplicity_5_0= ruleMultiplicityCS ) )?
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2650:7: (this_PrimitiveTypeCS_2= rulePrimitiveTypeCS | this_MapTypeCS_3= ruleMapTypeCS | this_TupleTypeCS_4= ruleTupleTypeCS )
                    int alt37=3;
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
                        alt37=1;
                        }
                        break;
                    case 35:
                        {
                        alt37=2;
                        }
                        break;
                    case 36:
                        {
                        alt37=3;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 37, 0, input);

                        throw nvae;
                    }

                    switch (alt37) {
                        case 1 :
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2651:2: this_PrimitiveTypeCS_2= rulePrimitiveTypeCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	  /* */ 
                              	
                            }
                            if ( state.backtracking==0 ) {
                               
                                      newCompositeNode(grammarAccess.getTypeLiteralWithMultiplicityCSAccess().getPrimitiveTypeCSParserRuleCall_2_0_0()); 
                                  
                            }
                            pushFollow(FollowSets000.FOLLOW_rulePrimitiveTypeCS_in_ruleTypeLiteralWithMultiplicityCS6354);
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
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2664:2: this_MapTypeCS_3= ruleMapTypeCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	  /* */ 
                              	
                            }
                            if ( state.backtracking==0 ) {
                               
                                      newCompositeNode(grammarAccess.getTypeLiteralWithMultiplicityCSAccess().getMapTypeCSParserRuleCall_2_0_1()); 
                                  
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleMapTypeCS_in_ruleTypeLiteralWithMultiplicityCS6384);
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
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2677:2: this_TupleTypeCS_4= ruleTupleTypeCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	  /* */ 
                              	
                            }
                            if ( state.backtracking==0 ) {
                               
                                      newCompositeNode(grammarAccess.getTypeLiteralWithMultiplicityCSAccess().getTupleTypeCSParserRuleCall_2_0_2()); 
                                  
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleTupleTypeCS_in_ruleTypeLiteralWithMultiplicityCS6414);
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

                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2688:2: ( (lv_ownedMultiplicity_5_0= ruleMultiplicityCS ) )?
                    int alt38=2;
                    int LA38_0 = input.LA(1);

                    if ( (LA38_0==66) ) {
                        alt38=1;
                    }
                    switch (alt38) {
                        case 1 :
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2689:1: (lv_ownedMultiplicity_5_0= ruleMultiplicityCS )
                            {
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2689:1: (lv_ownedMultiplicity_5_0= ruleMultiplicityCS )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2690:3: lv_ownedMultiplicity_5_0= ruleMultiplicityCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getTypeLiteralWithMultiplicityCSAccess().getOwnedMultiplicityMultiplicityCSParserRuleCall_2_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleMultiplicityCS_in_ruleTypeLiteralWithMultiplicityCS6435);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2714:1: entryRuleTypeLiteralExpCS returns [EObject current=null] : iv_ruleTypeLiteralExpCS= ruleTypeLiteralExpCS EOF ;
    public final EObject entryRuleTypeLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2715:2: (iv_ruleTypeLiteralExpCS= ruleTypeLiteralExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2716:2: iv_ruleTypeLiteralExpCS= ruleTypeLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralExpCS_in_entryRuleTypeLiteralExpCS6473);
            iv_ruleTypeLiteralExpCS=ruleTypeLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeLiteralExpCS6483); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2723:1: ruleTypeLiteralExpCS returns [EObject current=null] : ( (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS ) ) ;
    public final EObject ruleTypeLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject lv_ownedType_0_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2726:28: ( ( (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2727:1: ( (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2727:1: ( (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2728:1: (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2728:1: (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2729:3: lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypeLiteralExpCSAccess().getOwnedTypeTypeLiteralWithMultiplicityCSParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralWithMultiplicityCS_in_ruleTypeLiteralExpCS6528);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2753:1: entryRuleTypeNameExpCS returns [EObject current=null] : iv_ruleTypeNameExpCS= ruleTypeNameExpCS EOF ;
    public final EObject entryRuleTypeNameExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeNameExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2754:2: (iv_ruleTypeNameExpCS= ruleTypeNameExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2755:2: iv_ruleTypeNameExpCS= ruleTypeNameExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeNameExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeNameExpCS_in_entryRuleTypeNameExpCS6563);
            iv_ruleTypeNameExpCS=ruleTypeNameExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeNameExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeNameExpCS6573); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2762:1: ruleTypeNameExpCS returns [EObject current=null] : ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( ( (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS ) ) (otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}' )? )? ( (lv_ownedMultiplicity_5_0= ruleMultiplicityCS ) )? ) ;
    public final EObject ruleTypeNameExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_ownedPathName_0_0 = null;

        EObject lv_ownedCurlyBracketedClause_1_0 = null;

        EObject lv_ownedPatternGuard_3_0 = null;

        EObject lv_ownedMultiplicity_5_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2765:28: ( ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( ( (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS ) ) (otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}' )? )? ( (lv_ownedMultiplicity_5_0= ruleMultiplicityCS ) )? ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2766:1: ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( ( (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS ) ) (otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}' )? )? ( (lv_ownedMultiplicity_5_0= ruleMultiplicityCS ) )? )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2766:1: ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( ( (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS ) ) (otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}' )? )? ( (lv_ownedMultiplicity_5_0= ruleMultiplicityCS ) )? )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2766:2: ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( ( (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS ) ) (otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}' )? )? ( (lv_ownedMultiplicity_5_0= ruleMultiplicityCS ) )?
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2766:2: ( (lv_ownedPathName_0_0= rulePathNameCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2767:1: (lv_ownedPathName_0_0= rulePathNameCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2767:1: (lv_ownedPathName_0_0= rulePathNameCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2768:3: lv_ownedPathName_0_0= rulePathNameCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypeNameExpCSAccess().getOwnedPathNamePathNameCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_rulePathNameCS_in_ruleTypeNameExpCS6619);
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2784:2: ( ( (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS ) ) (otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}' )? )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==55) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2784:3: ( (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS ) ) (otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}' )?
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2784:3: ( (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2785:1: (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2785:1: (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2786:3: lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeNameExpCSAccess().getOwnedCurlyBracketedClauseCurlyBracketedClauseCSParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCurlyBracketedClauseCS_in_ruleTypeNameExpCS6641);
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

                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2802:2: (otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}' )?
                    int alt40=2;
                    int LA40_0 = input.LA(1);

                    if ( (LA40_0==55) ) {
                        alt40=1;
                    }
                    switch (alt40) {
                        case 1 :
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2802:4: otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}'
                            {
                            otherlv_2=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleTypeNameExpCS6654); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_2, grammarAccess.getTypeNameExpCSAccess().getLeftCurlyBracketKeyword_1_1_0());
                                  
                            }
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2806:1: ( (lv_ownedPatternGuard_3_0= ruleExpCS ) )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2807:1: (lv_ownedPatternGuard_3_0= ruleExpCS )
                            {
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2807:1: (lv_ownedPatternGuard_3_0= ruleExpCS )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2808:3: lv_ownedPatternGuard_3_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getTypeNameExpCSAccess().getOwnedPatternGuardExpCSParserRuleCall_1_1_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleTypeNameExpCS6675);
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

                            otherlv_4=(Token)match(input,56,FollowSets000.FOLLOW_56_in_ruleTypeNameExpCS6687); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getTypeNameExpCSAccess().getRightCurlyBracketKeyword_1_1_2());
                                  
                            }

                            }
                            break;

                    }


                    }
                    break;

            }

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2828:5: ( (lv_ownedMultiplicity_5_0= ruleMultiplicityCS ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==66) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2829:1: (lv_ownedMultiplicity_5_0= ruleMultiplicityCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2829:1: (lv_ownedMultiplicity_5_0= ruleMultiplicityCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2830:3: lv_ownedMultiplicity_5_0= ruleMultiplicityCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeNameExpCSAccess().getOwnedMultiplicityMultiplicityCSParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMultiplicityCS_in_ruleTypeNameExpCS6712);
                    lv_ownedMultiplicity_5_0=ruleMultiplicityCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTypeNameExpCSRule());
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2854:1: entryRuleTypeExpCS returns [EObject current=null] : iv_ruleTypeExpCS= ruleTypeExpCS EOF ;
    public final EObject entryRuleTypeExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2855:2: (iv_ruleTypeExpCS= ruleTypeExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2856:2: iv_ruleTypeExpCS= ruleTypeExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_entryRuleTypeExpCS6749);
            iv_ruleTypeExpCS=ruleTypeExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeExpCS6759); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2863:1: ruleTypeExpCS returns [EObject current=null] : (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralWithMultiplicityCS_1= ruleTypeLiteralWithMultiplicityCS | this_CollectionPatternCS_2= ruleCollectionPatternCS ) ;
    public final EObject ruleTypeExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_TypeNameExpCS_0 = null;

        EObject this_TypeLiteralWithMultiplicityCS_1 = null;

        EObject this_CollectionPatternCS_2 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2866:28: ( (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralWithMultiplicityCS_1= ruleTypeLiteralWithMultiplicityCS | this_CollectionPatternCS_2= ruleCollectionPatternCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2867:1: (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralWithMultiplicityCS_1= ruleTypeLiteralWithMultiplicityCS | this_CollectionPatternCS_2= ruleCollectionPatternCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2867:1: (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralWithMultiplicityCS_1= ruleTypeLiteralWithMultiplicityCS | this_CollectionPatternCS_2= ruleCollectionPatternCS )
            int alt43=3;
            alt43 = dfa43.predict(input);
            switch (alt43) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2868:2: this_TypeNameExpCS_0= ruleTypeNameExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeExpCSAccess().getTypeNameExpCSParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeNameExpCS_in_ruleTypeExpCS6809);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2881:2: this_TypeLiteralWithMultiplicityCS_1= ruleTypeLiteralWithMultiplicityCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeExpCSAccess().getTypeLiteralWithMultiplicityCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralWithMultiplicityCS_in_ruleTypeExpCS6839);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2894:2: this_CollectionPatternCS_2= ruleCollectionPatternCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeExpCSAccess().getCollectionPatternCSParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCollectionPatternCS_in_ruleTypeExpCS6869);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2913:1: entryRuleExpCS returns [EObject current=null] : iv_ruleExpCS= ruleExpCS EOF ;
    public final EObject entryRuleExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2914:2: (iv_ruleExpCS= ruleExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2915:2: iv_ruleExpCS= ruleExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_entryRuleExpCS6904);
            iv_ruleExpCS=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleExpCS6914); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2922:1: ruleExpCS returns [EObject current=null] : ( (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? ) | this_PrefixedLetExpCS_4= rulePrefixedLetExpCS ) ;
    public final EObject ruleExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_PrefixedPrimaryExpCS_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_ownedRight_3_0 = null;

        EObject this_PrefixedLetExpCS_4 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2925:28: ( ( (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? ) | this_PrefixedLetExpCS_4= rulePrefixedLetExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2926:1: ( (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? ) | this_PrefixedLetExpCS_4= rulePrefixedLetExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2926:1: ( (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? ) | this_PrefixedLetExpCS_4= rulePrefixedLetExpCS )
            int alt45=2;
            alt45 = dfa45.predict(input);
            switch (alt45) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2926:2: (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2926:2: (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2927:2: this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )?
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getExpCSAccess().getPrefixedPrimaryExpCSParserRuleCall_0_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrefixedPrimaryExpCS_in_ruleExpCS6965);
                    this_PrefixedPrimaryExpCS_0=rulePrefixedPrimaryExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_PrefixedPrimaryExpCS_0; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2938:1: ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )?
                    int alt44=2;
                    int LA44_0 = input.LA(1);

                    if ( (LA44_0==16||(LA44_0>=18 && LA44_0<=34)) ) {
                        alt44=1;
                    }
                    switch (alt44) {
                        case 1 :
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2938:2: () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) )
                            {
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2938:2: ()
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2939:2: 
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

                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2947:2: ( (lv_name_2_0= ruleBinaryOperatorName ) )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2948:1: (lv_name_2_0= ruleBinaryOperatorName )
                            {
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2948:1: (lv_name_2_0= ruleBinaryOperatorName )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2949:3: lv_name_2_0= ruleBinaryOperatorName
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getExpCSAccess().getNameBinaryOperatorNameParserRuleCall_0_1_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleBinaryOperatorName_in_ruleExpCS6998);
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

                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2965:2: ( (lv_ownedRight_3_0= ruleExpCS ) )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2966:1: (lv_ownedRight_3_0= ruleExpCS )
                            {
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2966:1: (lv_ownedRight_3_0= ruleExpCS )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2967:3: lv_ownedRight_3_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getExpCSAccess().getOwnedRightExpCSParserRuleCall_0_1_2_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleExpCS7019);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2985:2: this_PrefixedLetExpCS_4= rulePrefixedLetExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getExpCSAccess().getPrefixedLetExpCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrefixedLetExpCS_in_ruleExpCS7053);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3004:1: entryRulePrefixedLetExpCS returns [EObject current=null] : iv_rulePrefixedLetExpCS= rulePrefixedLetExpCS EOF ;
    public final EObject entryRulePrefixedLetExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrefixedLetExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3005:2: (iv_rulePrefixedLetExpCS= rulePrefixedLetExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3006:2: iv_rulePrefixedLetExpCS= rulePrefixedLetExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrefixedLetExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePrefixedLetExpCS_in_entryRulePrefixedLetExpCS7088);
            iv_rulePrefixedLetExpCS=rulePrefixedLetExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrefixedLetExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrefixedLetExpCS7098); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3013:1: rulePrefixedLetExpCS returns [EObject current=null] : ( ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedLetExpCS ) ) ) | this_LetExpCS_3= ruleLetExpCS ) ;
    public final EObject rulePrefixedLetExpCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_ownedRight_2_0 = null;

        EObject this_LetExpCS_3 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3016:28: ( ( ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedLetExpCS ) ) ) | this_LetExpCS_3= ruleLetExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3017:1: ( ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedLetExpCS ) ) ) | this_LetExpCS_3= ruleLetExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3017:1: ( ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedLetExpCS ) ) ) | this_LetExpCS_3= ruleLetExpCS )
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( ((LA46_0>=16 && LA46_0<=17)) ) {
                alt46=1;
            }
            else if ( (LA46_0==76) ) {
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3017:2: ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedLetExpCS ) ) )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3017:2: ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedLetExpCS ) ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3017:3: () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedLetExpCS ) )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3017:3: ()
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3018:2: 
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

                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3026:2: ( (lv_name_1_0= ruleUnaryOperatorName ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3027:1: (lv_name_1_0= ruleUnaryOperatorName )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3027:1: (lv_name_1_0= ruleUnaryOperatorName )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3028:3: lv_name_1_0= ruleUnaryOperatorName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrefixedLetExpCSAccess().getNameUnaryOperatorNameParserRuleCall_0_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUnaryOperatorName_in_rulePrefixedLetExpCS7157);
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

                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3044:2: ( (lv_ownedRight_2_0= rulePrefixedLetExpCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3045:1: (lv_ownedRight_2_0= rulePrefixedLetExpCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3045:1: (lv_ownedRight_2_0= rulePrefixedLetExpCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3046:3: lv_ownedRight_2_0= rulePrefixedLetExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrefixedLetExpCSAccess().getOwnedRightPrefixedLetExpCSParserRuleCall_0_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrefixedLetExpCS_in_rulePrefixedLetExpCS7178);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3064:2: this_LetExpCS_3= ruleLetExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrefixedLetExpCSAccess().getLetExpCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLetExpCS_in_rulePrefixedLetExpCS7210);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3083:1: entryRulePrefixedPrimaryExpCS returns [EObject current=null] : iv_rulePrefixedPrimaryExpCS= rulePrefixedPrimaryExpCS EOF ;
    public final EObject entryRulePrefixedPrimaryExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrefixedPrimaryExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3084:2: (iv_rulePrefixedPrimaryExpCS= rulePrefixedPrimaryExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3085:2: iv_rulePrefixedPrimaryExpCS= rulePrefixedPrimaryExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrefixedPrimaryExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePrefixedPrimaryExpCS_in_entryRulePrefixedPrimaryExpCS7245);
            iv_rulePrefixedPrimaryExpCS=rulePrefixedPrimaryExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrefixedPrimaryExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrefixedPrimaryExpCS7255); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3092:1: rulePrefixedPrimaryExpCS returns [EObject current=null] : ( ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS ) ) ) | this_PrimaryExpCS_3= rulePrimaryExpCS ) ;
    public final EObject rulePrefixedPrimaryExpCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_ownedRight_2_0 = null;

        EObject this_PrimaryExpCS_3 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3095:28: ( ( ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS ) ) ) | this_PrimaryExpCS_3= rulePrimaryExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3096:1: ( ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS ) ) ) | this_PrimaryExpCS_3= rulePrimaryExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3096:1: ( ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS ) ) ) | this_PrimaryExpCS_3= rulePrimaryExpCS )
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( ((LA47_0>=16 && LA47_0<=17)) ) {
                alt47=1;
            }
            else if ( ((LA47_0>=RULE_SIMPLE_ID && LA47_0<=RULE_SINGLE_QUOTED_STRING)||LA47_0==18||(LA47_0>=35 && LA47_0<=50)||LA47_0==52||(LA47_0>=60 && LA47_0<=63)||LA47_0==71||LA47_0==77) ) {
                alt47=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }
            switch (alt47) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3096:2: ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS ) ) )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3096:2: ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS ) ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3096:3: () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS ) )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3096:3: ()
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3097:2: 
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

                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3105:2: ( (lv_name_1_0= ruleUnaryOperatorName ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3106:1: (lv_name_1_0= ruleUnaryOperatorName )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3106:1: (lv_name_1_0= ruleUnaryOperatorName )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3107:3: lv_name_1_0= ruleUnaryOperatorName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrefixedPrimaryExpCSAccess().getNameUnaryOperatorNameParserRuleCall_0_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUnaryOperatorName_in_rulePrefixedPrimaryExpCS7314);
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

                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3123:2: ( (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3124:1: (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3124:1: (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3125:3: lv_ownedRight_2_0= rulePrefixedPrimaryExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrefixedPrimaryExpCSAccess().getOwnedRightPrefixedPrimaryExpCSParserRuleCall_0_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrefixedPrimaryExpCS_in_rulePrefixedPrimaryExpCS7335);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3143:2: this_PrimaryExpCS_3= rulePrimaryExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrefixedPrimaryExpCSAccess().getPrimaryExpCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrimaryExpCS_in_rulePrefixedPrimaryExpCS7367);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3162:1: entryRulePrimaryExpCS returns [EObject current=null] : iv_rulePrimaryExpCS= rulePrimaryExpCS EOF ;
    public final EObject entryRulePrimaryExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3163:2: (iv_rulePrimaryExpCS= rulePrimaryExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3164:2: iv_rulePrimaryExpCS= rulePrimaryExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimaryExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePrimaryExpCS_in_entryRulePrimaryExpCS7402);
            iv_rulePrimaryExpCS=rulePrimaryExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimaryExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrimaryExpCS7412); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3171:1: rulePrimaryExpCS returns [EObject current=null] : (this_NestedExpCS_0= ruleNestedExpCS | this_IfExpCS_1= ruleIfExpCS | this_SelfExpCS_2= ruleSelfExpCS | this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS | this_MapLiteralExpCS_5= ruleMapLiteralExpCS | this_CollectionLiteralExpCS_6= ruleCollectionLiteralExpCS | this_LambdaLiteralExpCS_7= ruleLambdaLiteralExpCS | this_TypeLiteralExpCS_8= ruleTypeLiteralExpCS | this_NameExpCS_9= ruleNameExpCS ) ;
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
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3174:28: ( (this_NestedExpCS_0= ruleNestedExpCS | this_IfExpCS_1= ruleIfExpCS | this_SelfExpCS_2= ruleSelfExpCS | this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS | this_MapLiteralExpCS_5= ruleMapLiteralExpCS | this_CollectionLiteralExpCS_6= ruleCollectionLiteralExpCS | this_LambdaLiteralExpCS_7= ruleLambdaLiteralExpCS | this_TypeLiteralExpCS_8= ruleTypeLiteralExpCS | this_NameExpCS_9= ruleNameExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3175:1: (this_NestedExpCS_0= ruleNestedExpCS | this_IfExpCS_1= ruleIfExpCS | this_SelfExpCS_2= ruleSelfExpCS | this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS | this_MapLiteralExpCS_5= ruleMapLiteralExpCS | this_CollectionLiteralExpCS_6= ruleCollectionLiteralExpCS | this_LambdaLiteralExpCS_7= ruleLambdaLiteralExpCS | this_TypeLiteralExpCS_8= ruleTypeLiteralExpCS | this_NameExpCS_9= ruleNameExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3175:1: (this_NestedExpCS_0= ruleNestedExpCS | this_IfExpCS_1= ruleIfExpCS | this_SelfExpCS_2= ruleSelfExpCS | this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS | this_MapLiteralExpCS_5= ruleMapLiteralExpCS | this_CollectionLiteralExpCS_6= ruleCollectionLiteralExpCS | this_LambdaLiteralExpCS_7= ruleLambdaLiteralExpCS | this_TypeLiteralExpCS_8= ruleTypeLiteralExpCS | this_NameExpCS_9= ruleNameExpCS )
            int alt48=10;
            alt48 = dfa48.predict(input);
            switch (alt48) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3176:2: this_NestedExpCS_0= ruleNestedExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getNestedExpCSParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNestedExpCS_in_rulePrimaryExpCS7462);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3189:2: this_IfExpCS_1= ruleIfExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getIfExpCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleIfExpCS_in_rulePrimaryExpCS7492);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3202:2: this_SelfExpCS_2= ruleSelfExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getSelfExpCSParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSelfExpCS_in_rulePrimaryExpCS7522);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3215:2: this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getPrimitiveLiteralExpCSParserRuleCall_3()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrimitiveLiteralExpCS_in_rulePrimaryExpCS7552);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3228:2: this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getTupleLiteralExpCSParserRuleCall_4()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralExpCS_in_rulePrimaryExpCS7582);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3241:2: this_MapLiteralExpCS_5= ruleMapLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getMapLiteralExpCSParserRuleCall_5()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMapLiteralExpCS_in_rulePrimaryExpCS7612);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3254:2: this_CollectionLiteralExpCS_6= ruleCollectionLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getCollectionLiteralExpCSParserRuleCall_6()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteralExpCS_in_rulePrimaryExpCS7642);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3267:2: this_LambdaLiteralExpCS_7= ruleLambdaLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getLambdaLiteralExpCSParserRuleCall_7()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLambdaLiteralExpCS_in_rulePrimaryExpCS7672);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3280:2: this_TypeLiteralExpCS_8= ruleTypeLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getTypeLiteralExpCSParserRuleCall_8()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralExpCS_in_rulePrimaryExpCS7702);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3293:2: this_NameExpCS_9= ruleNameExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getNameExpCSParserRuleCall_9()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNameExpCS_in_rulePrimaryExpCS7732);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3312:1: entryRuleNameExpCS returns [EObject current=null] : iv_ruleNameExpCS= ruleNameExpCS EOF ;
    public final EObject entryRuleNameExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNameExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3313:2: (iv_ruleNameExpCS= ruleNameExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3314:2: iv_ruleNameExpCS= ruleNameExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNameExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNameExpCS_in_entryRuleNameExpCS7767);
            iv_ruleNameExpCS=ruleNameExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNameExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNameExpCS7777); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3321:1: ruleNameExpCS returns [EObject current=null] : ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( (lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS ) )* ( (lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS ) )? ( (lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS ) )? ( ( (lv_isPre_4_0= '@' ) ) otherlv_5= 'pre' )? ) ;
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
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3324:28: ( ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( (lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS ) )* ( (lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS ) )? ( (lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS ) )? ( ( (lv_isPre_4_0= '@' ) ) otherlv_5= 'pre' )? ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3325:1: ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( (lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS ) )* ( (lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS ) )? ( (lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS ) )? ( ( (lv_isPre_4_0= '@' ) ) otherlv_5= 'pre' )? )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3325:1: ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( (lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS ) )* ( (lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS ) )? ( (lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS ) )? ( ( (lv_isPre_4_0= '@' ) ) otherlv_5= 'pre' )? )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3325:2: ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( (lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS ) )* ( (lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS ) )? ( (lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS ) )? ( ( (lv_isPre_4_0= '@' ) ) otherlv_5= 'pre' )?
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3325:2: ( (lv_ownedPathName_0_0= rulePathNameCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3326:1: (lv_ownedPathName_0_0= rulePathNameCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3326:1: (lv_ownedPathName_0_0= rulePathNameCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3327:3: lv_ownedPathName_0_0= rulePathNameCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNameExpCSAccess().getOwnedPathNamePathNameCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_rulePathNameCS_in_ruleNameExpCS7823);
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3343:2: ( (lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS ) )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==66) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3344:1: (lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS )
            	    {
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3344:1: (lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS )
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3345:3: lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getNameExpCSAccess().getOwnedSquareBracketedClausesSquareBracketedClauseCSParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleSquareBracketedClauseCS_in_ruleNameExpCS7844);
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
            	    break loop49;
                }
            } while (true);

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3361:3: ( (lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS ) )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==50) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3362:1: (lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3362:1: (lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3363:3: lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNameExpCSAccess().getOwnedRoundBracketedClauseRoundBracketedClauseCSParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleRoundBracketedClauseCS_in_ruleNameExpCS7866);
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3379:3: ( (lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS ) )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==55) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3380:1: (lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3380:1: (lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3381:3: lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNameExpCSAccess().getOwnedCurlyBracketedClauseCurlyBracketedClauseCSParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCurlyBracketedClauseCS_in_ruleNameExpCS7888);
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3397:3: ( ( (lv_isPre_4_0= '@' ) ) otherlv_5= 'pre' )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==64) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3397:4: ( (lv_isPre_4_0= '@' ) ) otherlv_5= 'pre'
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3397:4: ( (lv_isPre_4_0= '@' ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3398:1: (lv_isPre_4_0= '@' )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3398:1: (lv_isPre_4_0= '@' )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3399:3: lv_isPre_4_0= '@'
                    {
                    lv_isPre_4_0=(Token)match(input,64,FollowSets000.FOLLOW_64_in_ruleNameExpCS7908); if (state.failed) return current;
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

                    otherlv_5=(Token)match(input,65,FollowSets000.FOLLOW_65_in_ruleNameExpCS7933); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3424:1: entryRuleCurlyBracketedClauseCS returns [EObject current=null] : iv_ruleCurlyBracketedClauseCS= ruleCurlyBracketedClauseCS EOF ;
    public final EObject entryRuleCurlyBracketedClauseCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCurlyBracketedClauseCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3425:2: (iv_ruleCurlyBracketedClauseCS= ruleCurlyBracketedClauseCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3426:2: iv_ruleCurlyBracketedClauseCS= ruleCurlyBracketedClauseCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCurlyBracketedClauseCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleCurlyBracketedClauseCS_in_entryRuleCurlyBracketedClauseCS7971);
            iv_ruleCurlyBracketedClauseCS=ruleCurlyBracketedClauseCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCurlyBracketedClauseCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCurlyBracketedClauseCS7981); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3433:1: ruleCurlyBracketedClauseCS returns [EObject current=null] : ( () otherlv_1= '{' ( ( (lv_value_2_0= ruleStringLiteral ) ) | ( ( (lv_ownedParts_3_0= ruleShadowPartCS ) ) (otherlv_4= ',' ( (lv_ownedParts_5_0= ruleShadowPartCS ) ) )* ) )? otherlv_6= '}' ) ;
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
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3436:28: ( ( () otherlv_1= '{' ( ( (lv_value_2_0= ruleStringLiteral ) ) | ( ( (lv_ownedParts_3_0= ruleShadowPartCS ) ) (otherlv_4= ',' ( (lv_ownedParts_5_0= ruleShadowPartCS ) ) )* ) )? otherlv_6= '}' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3437:1: ( () otherlv_1= '{' ( ( (lv_value_2_0= ruleStringLiteral ) ) | ( ( (lv_ownedParts_3_0= ruleShadowPartCS ) ) (otherlv_4= ',' ( (lv_ownedParts_5_0= ruleShadowPartCS ) ) )* ) )? otherlv_6= '}' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3437:1: ( () otherlv_1= '{' ( ( (lv_value_2_0= ruleStringLiteral ) ) | ( ( (lv_ownedParts_3_0= ruleShadowPartCS ) ) (otherlv_4= ',' ( (lv_ownedParts_5_0= ruleShadowPartCS ) ) )* ) )? otherlv_6= '}' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3437:2: () otherlv_1= '{' ( ( (lv_value_2_0= ruleStringLiteral ) ) | ( ( (lv_ownedParts_3_0= ruleShadowPartCS ) ) (otherlv_4= ',' ( (lv_ownedParts_5_0= ruleShadowPartCS ) ) )* ) )? otherlv_6= '}'
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3437:2: ()
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3438:2: 
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

            otherlv_1=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleCurlyBracketedClauseCS8030); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getCurlyBracketedClauseCSAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3450:1: ( ( (lv_value_2_0= ruleStringLiteral ) ) | ( ( (lv_ownedParts_3_0= ruleShadowPartCS ) ) (otherlv_4= ',' ( (lv_ownedParts_5_0= ruleShadowPartCS ) ) )* ) )?
            int alt54=3;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==RULE_SINGLE_QUOTED_STRING) ) {
                alt54=1;
            }
            else if ( ((LA54_0>=RULE_SIMPLE_ID && LA54_0<=RULE_ESCAPED_ID)) ) {
                alt54=2;
            }
            switch (alt54) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3450:2: ( (lv_value_2_0= ruleStringLiteral ) )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3450:2: ( (lv_value_2_0= ruleStringLiteral ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3451:1: (lv_value_2_0= ruleStringLiteral )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3451:1: (lv_value_2_0= ruleStringLiteral )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3452:3: lv_value_2_0= ruleStringLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCurlyBracketedClauseCSAccess().getValueStringLiteralParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleStringLiteral_in_ruleCurlyBracketedClauseCS8052);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3469:6: ( ( (lv_ownedParts_3_0= ruleShadowPartCS ) ) (otherlv_4= ',' ( (lv_ownedParts_5_0= ruleShadowPartCS ) ) )* )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3469:6: ( ( (lv_ownedParts_3_0= ruleShadowPartCS ) ) (otherlv_4= ',' ( (lv_ownedParts_5_0= ruleShadowPartCS ) ) )* )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3469:7: ( (lv_ownedParts_3_0= ruleShadowPartCS ) ) (otherlv_4= ',' ( (lv_ownedParts_5_0= ruleShadowPartCS ) ) )*
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3469:7: ( (lv_ownedParts_3_0= ruleShadowPartCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3470:1: (lv_ownedParts_3_0= ruleShadowPartCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3470:1: (lv_ownedParts_3_0= ruleShadowPartCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3471:3: lv_ownedParts_3_0= ruleShadowPartCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCurlyBracketedClauseCSAccess().getOwnedPartsShadowPartCSParserRuleCall_2_1_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleShadowPartCS_in_ruleCurlyBracketedClauseCS8080);
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

                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3487:2: (otherlv_4= ',' ( (lv_ownedParts_5_0= ruleShadowPartCS ) ) )*
                    loop53:
                    do {
                        int alt53=2;
                        int LA53_0 = input.LA(1);

                        if ( (LA53_0==53) ) {
                            alt53=1;
                        }


                        switch (alt53) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3487:4: otherlv_4= ',' ( (lv_ownedParts_5_0= ruleShadowPartCS ) )
                    	    {
                    	    otherlv_4=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleCurlyBracketedClauseCS8093); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_4, grammarAccess.getCurlyBracketedClauseCSAccess().getCommaKeyword_2_1_1_0());
                    	          
                    	    }
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3491:1: ( (lv_ownedParts_5_0= ruleShadowPartCS ) )
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3492:1: (lv_ownedParts_5_0= ruleShadowPartCS )
                    	    {
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3492:1: (lv_ownedParts_5_0= ruleShadowPartCS )
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3493:3: lv_ownedParts_5_0= ruleShadowPartCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getCurlyBracketedClauseCSAccess().getOwnedPartsShadowPartCSParserRuleCall_2_1_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleShadowPartCS_in_ruleCurlyBracketedClauseCS8114);
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
                    	    break loop53;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,56,FollowSets000.FOLLOW_56_in_ruleCurlyBracketedClauseCS8131); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3521:1: entryRuleRoundBracketedClauseCS returns [EObject current=null] : iv_ruleRoundBracketedClauseCS= ruleRoundBracketedClauseCS EOF ;
    public final EObject entryRuleRoundBracketedClauseCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRoundBracketedClauseCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3522:2: (iv_ruleRoundBracketedClauseCS= ruleRoundBracketedClauseCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3523:2: iv_ruleRoundBracketedClauseCS= ruleRoundBracketedClauseCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRoundBracketedClauseCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleRoundBracketedClauseCS_in_entryRuleRoundBracketedClauseCS8167);
            iv_ruleRoundBracketedClauseCS=ruleRoundBracketedClauseCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRoundBracketedClauseCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRoundBracketedClauseCS8177); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3530:1: ruleRoundBracketedClauseCS returns [EObject current=null] : ( () otherlv_1= '(' ( ( (lv_ownedArguments_2_0= ruleNavigatingArgCS ) ) ( (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )* )* )? otherlv_8= ')' ) ;
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
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3533:28: ( ( () otherlv_1= '(' ( ( (lv_ownedArguments_2_0= ruleNavigatingArgCS ) ) ( (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )* )* )? otherlv_8= ')' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3534:1: ( () otherlv_1= '(' ( ( (lv_ownedArguments_2_0= ruleNavigatingArgCS ) ) ( (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )* )* )? otherlv_8= ')' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3534:1: ( () otherlv_1= '(' ( ( (lv_ownedArguments_2_0= ruleNavigatingArgCS ) ) ( (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )* )* )? otherlv_8= ')' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3534:2: () otherlv_1= '(' ( ( (lv_ownedArguments_2_0= ruleNavigatingArgCS ) ) ( (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )* )* )? otherlv_8= ')'
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3534:2: ()
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3535:2: 
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

            otherlv_1=(Token)match(input,50,FollowSets000.FOLLOW_50_in_ruleRoundBracketedClauseCS8226); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getRoundBracketedClauseCSAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3547:1: ( ( (lv_ownedArguments_2_0= ruleNavigatingArgCS ) ) ( (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )* )* )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( ((LA60_0>=RULE_SIMPLE_ID && LA60_0<=RULE_SINGLE_QUOTED_STRING)||(LA60_0>=16 && LA60_0<=18)||(LA60_0>=35 && LA60_0<=50)||LA60_0==52||LA60_0==54||(LA60_0>=60 && LA60_0<=63)||LA60_0==71||(LA60_0>=76 && LA60_0<=77)) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3547:2: ( (lv_ownedArguments_2_0= ruleNavigatingArgCS ) ) ( (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )* )*
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3547:2: ( (lv_ownedArguments_2_0= ruleNavigatingArgCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3548:1: (lv_ownedArguments_2_0= ruleNavigatingArgCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3548:1: (lv_ownedArguments_2_0= ruleNavigatingArgCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3549:3: lv_ownedArguments_2_0= ruleNavigatingArgCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingArgCSParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgCS_in_ruleRoundBracketedClauseCS8248);
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

                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3565:2: ( (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS ) )*
                    loop55:
                    do {
                        int alt55=2;
                        int LA55_0 = input.LA(1);

                        if ( (LA55_0==53) ) {
                            alt55=1;
                        }


                        switch (alt55) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3566:1: (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS )
                    	    {
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3566:1: (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS )
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3567:3: lv_ownedArguments_3_0= ruleNavigatingCommaArgCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingCommaArgCSParserRuleCall_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleNavigatingCommaArgCS_in_ruleRoundBracketedClauseCS8269);
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
                    	    break loop55;
                        }
                    } while (true);

                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3583:3: ( ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )* )?
                    int alt57=2;
                    int LA57_0 = input.LA(1);

                    if ( (LA57_0==70) ) {
                        alt57=1;
                    }
                    switch (alt57) {
                        case 1 :
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3583:4: ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )*
                            {
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3583:4: ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3584:1: (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS )
                            {
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3584:1: (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3585:3: lv_ownedArguments_4_0= ruleNavigatingSemiArgCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingSemiArgCSParserRuleCall_2_2_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleNavigatingSemiArgCS_in_ruleRoundBracketedClauseCS8292);
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

                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3601:2: ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )*
                            loop56:
                            do {
                                int alt56=2;
                                int LA56_0 = input.LA(1);

                                if ( (LA56_0==53) ) {
                                    alt56=1;
                                }


                                switch (alt56) {
                            	case 1 :
                            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3602:1: (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS )
                            	    {
                            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3602:1: (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS )
                            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3603:3: lv_ownedArguments_5_0= ruleNavigatingCommaArgCS
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingCommaArgCSParserRuleCall_2_2_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FollowSets000.FOLLOW_ruleNavigatingCommaArgCS_in_ruleRoundBracketedClauseCS8313);
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
                            	    break loop56;
                                }
                            } while (true);


                            }
                            break;

                    }

                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3619:5: ( ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )* )*
                    loop59:
                    do {
                        int alt59=2;
                        int LA59_0 = input.LA(1);

                        if ( (LA59_0==69) ) {
                            alt59=1;
                        }


                        switch (alt59) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3619:6: ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )*
                    	    {
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3619:6: ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) )
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3620:1: (lv_ownedArguments_6_0= ruleNavigatingBarArgCS )
                    	    {
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3620:1: (lv_ownedArguments_6_0= ruleNavigatingBarArgCS )
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3621:3: lv_ownedArguments_6_0= ruleNavigatingBarArgCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingBarArgCSParserRuleCall_2_3_0_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleNavigatingBarArgCS_in_ruleRoundBracketedClauseCS8338);
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

                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3637:2: ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )*
                    	    loop58:
                    	    do {
                    	        int alt58=2;
                    	        int LA58_0 = input.LA(1);

                    	        if ( (LA58_0==53) ) {
                    	            alt58=1;
                    	        }


                    	        switch (alt58) {
                    	    	case 1 :
                    	    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3638:1: (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS )
                    	    	    {
                    	    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3638:1: (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS )
                    	    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3639:3: lv_ownedArguments_7_0= ruleNavigatingCommaArgCS
                    	    	    {
                    	    	    if ( state.backtracking==0 ) {
                    	    	       
                    	    	      	        newCompositeNode(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingCommaArgCSParserRuleCall_2_3_1_0()); 
                    	    	      	    
                    	    	    }
                    	    	    pushFollow(FollowSets000.FOLLOW_ruleNavigatingCommaArgCS_in_ruleRoundBracketedClauseCS8359);
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
                    	    	    break loop58;
                    	        }
                    	    } while (true);


                    	    }
                    	    break;

                    	default :
                    	    break loop59;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_8=(Token)match(input,51,FollowSets000.FOLLOW_51_in_ruleRoundBracketedClauseCS8376); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3667:1: entryRuleSquareBracketedClauseCS returns [EObject current=null] : iv_ruleSquareBracketedClauseCS= ruleSquareBracketedClauseCS EOF ;
    public final EObject entryRuleSquareBracketedClauseCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSquareBracketedClauseCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3668:2: (iv_ruleSquareBracketedClauseCS= ruleSquareBracketedClauseCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3669:2: iv_ruleSquareBracketedClauseCS= ruleSquareBracketedClauseCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSquareBracketedClauseCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSquareBracketedClauseCS_in_entryRuleSquareBracketedClauseCS8412);
            iv_ruleSquareBracketedClauseCS=ruleSquareBracketedClauseCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSquareBracketedClauseCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSquareBracketedClauseCS8422); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3676:1: ruleSquareBracketedClauseCS returns [EObject current=null] : (otherlv_0= '[' ( (lv_ownedTerms_1_0= ruleExpCS ) ) (otherlv_2= ',' ( (lv_ownedTerms_3_0= ruleExpCS ) ) )* otherlv_4= ']' ) ;
    public final EObject ruleSquareBracketedClauseCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_ownedTerms_1_0 = null;

        EObject lv_ownedTerms_3_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3679:28: ( (otherlv_0= '[' ( (lv_ownedTerms_1_0= ruleExpCS ) ) (otherlv_2= ',' ( (lv_ownedTerms_3_0= ruleExpCS ) ) )* otherlv_4= ']' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3680:1: (otherlv_0= '[' ( (lv_ownedTerms_1_0= ruleExpCS ) ) (otherlv_2= ',' ( (lv_ownedTerms_3_0= ruleExpCS ) ) )* otherlv_4= ']' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3680:1: (otherlv_0= '[' ( (lv_ownedTerms_1_0= ruleExpCS ) ) (otherlv_2= ',' ( (lv_ownedTerms_3_0= ruleExpCS ) ) )* otherlv_4= ']' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3680:3: otherlv_0= '[' ( (lv_ownedTerms_1_0= ruleExpCS ) ) (otherlv_2= ',' ( (lv_ownedTerms_3_0= ruleExpCS ) ) )* otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,66,FollowSets000.FOLLOW_66_in_ruleSquareBracketedClauseCS8459); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getSquareBracketedClauseCSAccess().getLeftSquareBracketKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3684:1: ( (lv_ownedTerms_1_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3685:1: (lv_ownedTerms_1_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3685:1: (lv_ownedTerms_1_0= ruleExpCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3686:3: lv_ownedTerms_1_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSquareBracketedClauseCSAccess().getOwnedTermsExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleSquareBracketedClauseCS8480);
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3702:2: (otherlv_2= ',' ( (lv_ownedTerms_3_0= ruleExpCS ) ) )*
            loop61:
            do {
                int alt61=2;
                int LA61_0 = input.LA(1);

                if ( (LA61_0==53) ) {
                    alt61=1;
                }


                switch (alt61) {
            	case 1 :
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3702:4: otherlv_2= ',' ( (lv_ownedTerms_3_0= ruleExpCS ) )
            	    {
            	    otherlv_2=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleSquareBracketedClauseCS8493); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getSquareBracketedClauseCSAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3706:1: ( (lv_ownedTerms_3_0= ruleExpCS ) )
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3707:1: (lv_ownedTerms_3_0= ruleExpCS )
            	    {
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3707:1: (lv_ownedTerms_3_0= ruleExpCS )
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3708:3: lv_ownedTerms_3_0= ruleExpCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSquareBracketedClauseCSAccess().getOwnedTermsExpCSParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleSquareBracketedClauseCS8514);
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
            	    break loop61;
                }
            } while (true);

            otherlv_4=(Token)match(input,67,FollowSets000.FOLLOW_67_in_ruleSquareBracketedClauseCS8528); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3736:1: entryRuleNavigatingArgCS returns [EObject current=null] : iv_ruleNavigatingArgCS= ruleNavigatingArgCS EOF ;
    public final EObject entryRuleNavigatingArgCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingArgCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3737:2: (iv_ruleNavigatingArgCS= ruleNavigatingArgCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3738:2: iv_ruleNavigatingArgCS= ruleNavigatingArgCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingArgCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgCS_in_entryRuleNavigatingArgCS8564);
            iv_ruleNavigatingArgCS=ruleNavigatingArgCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingArgCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigatingArgCS8574); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3745:1: ruleNavigatingArgCS returns [EObject current=null] : ( ( ( (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS ) ) ( (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? ) | (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) ) )? ) | (otherlv_7= ':' ( (lv_ownedType_8_0= ruleTypeExpCS ) ) ) ) ;
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
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3748:28: ( ( ( ( (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS ) ) ( (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? ) | (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) ) )? ) | (otherlv_7= ':' ( (lv_ownedType_8_0= ruleTypeExpCS ) ) ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3749:1: ( ( ( (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS ) ) ( (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? ) | (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) ) )? ) | (otherlv_7= ':' ( (lv_ownedType_8_0= ruleTypeExpCS ) ) ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3749:1: ( ( ( (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS ) ) ( (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? ) | (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) ) )? ) | (otherlv_7= ':' ( (lv_ownedType_8_0= ruleTypeExpCS ) ) ) )
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( ((LA64_0>=RULE_SIMPLE_ID && LA64_0<=RULE_SINGLE_QUOTED_STRING)||(LA64_0>=16 && LA64_0<=18)||(LA64_0>=35 && LA64_0<=50)||LA64_0==52||(LA64_0>=60 && LA64_0<=63)||LA64_0==71||(LA64_0>=76 && LA64_0<=77)) ) {
                alt64=1;
            }
            else if ( (LA64_0==54) ) {
                alt64=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;
            }
            switch (alt64) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3749:2: ( ( (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS ) ) ( (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? ) | (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) ) )? )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3749:2: ( ( (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS ) ) ( (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? ) | (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) ) )? )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3749:3: ( (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS ) ) ( (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? ) | (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) ) )?
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3749:3: ( (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3750:1: (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3750:1: (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3751:3: lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedNameExpressionNavigatingArgExpCSParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingArgCS8621);
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

                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3767:2: ( (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? ) | (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) ) )?
                    int alt63=3;
                    int LA63_0 = input.LA(1);

                    if ( (LA63_0==54) ) {
                        alt63=1;
                    }
                    else if ( (LA63_0==68) ) {
                        alt63=2;
                    }
                    switch (alt63) {
                        case 1 :
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3767:3: (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? )
                            {
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3767:3: (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3767:5: otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )?
                            {
                            otherlv_1=(Token)match(input,54,FollowSets000.FOLLOW_54_in_ruleNavigatingArgCS8635); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_1, grammarAccess.getNavigatingArgCSAccess().getColonKeyword_0_1_0_0());
                                  
                            }
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3771:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3772:1: (lv_ownedType_2_0= ruleTypeExpCS )
                            {
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3772:1: (lv_ownedType_2_0= ruleTypeExpCS )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3773:3: lv_ownedType_2_0= ruleTypeExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_0_1_0_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleNavigatingArgCS8656);
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

                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3789:2: (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )?
                            int alt62=2;
                            int LA62_0 = input.LA(1);

                            if ( (LA62_0==25) ) {
                                alt62=1;
                            }
                            switch (alt62) {
                                case 1 :
                                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3789:4: otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) )
                                    {
                                    otherlv_3=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleNavigatingArgCS8669); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                          	newLeafNode(otherlv_3, grammarAccess.getNavigatingArgCSAccess().getEqualsSignKeyword_0_1_0_2_0());
                                          
                                    }
                                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3793:1: ( (lv_ownedInitExpression_4_0= ruleExpCS ) )
                                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3794:1: (lv_ownedInitExpression_4_0= ruleExpCS )
                                    {
                                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3794:1: (lv_ownedInitExpression_4_0= ruleExpCS )
                                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3795:3: lv_ownedInitExpression_4_0= ruleExpCS
                                    {
                                    if ( state.backtracking==0 ) {
                                       
                                      	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_0_1_0_2_1_0()); 
                                      	    
                                    }
                                    pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNavigatingArgCS8690);
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
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3812:6: (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) )
                            {
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3812:6: (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3812:8: otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) )
                            {
                            otherlv_5=(Token)match(input,68,FollowSets000.FOLLOW_68_in_ruleNavigatingArgCS8712); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_5, grammarAccess.getNavigatingArgCSAccess().getInKeyword_0_1_1_0());
                                  
                            }
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3816:1: ( (lv_ownedInitExpression_6_0= ruleExpCS ) )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3817:1: (lv_ownedInitExpression_6_0= ruleExpCS )
                            {
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3817:1: (lv_ownedInitExpression_6_0= ruleExpCS )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3818:3: lv_ownedInitExpression_6_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_0_1_1_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNavigatingArgCS8733);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3835:6: (otherlv_7= ':' ( (lv_ownedType_8_0= ruleTypeExpCS ) ) )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3835:6: (otherlv_7= ':' ( (lv_ownedType_8_0= ruleTypeExpCS ) ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3835:8: otherlv_7= ':' ( (lv_ownedType_8_0= ruleTypeExpCS ) )
                    {
                    otherlv_7=(Token)match(input,54,FollowSets000.FOLLOW_54_in_ruleNavigatingArgCS8756); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getNavigatingArgCSAccess().getColonKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3839:1: ( (lv_ownedType_8_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3840:1: (lv_ownedType_8_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3840:1: (lv_ownedType_8_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3841:3: lv_ownedType_8_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleNavigatingArgCS8777);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3865:1: entryRuleNavigatingBarArgCS returns [EObject current=null] : iv_ruleNavigatingBarArgCS= ruleNavigatingBarArgCS EOF ;
    public final EObject entryRuleNavigatingBarArgCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingBarArgCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3866:2: (iv_ruleNavigatingBarArgCS= ruleNavigatingBarArgCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3867:2: iv_ruleNavigatingBarArgCS= ruleNavigatingBarArgCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingBarArgCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingBarArgCS_in_entryRuleNavigatingBarArgCS8814);
            iv_ruleNavigatingBarArgCS=ruleNavigatingBarArgCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingBarArgCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigatingBarArgCS8824); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3874:1: ruleNavigatingBarArgCS returns [EObject current=null] : ( ( (lv_prefix_0_0= '|' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )? ) ;
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
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3877:28: ( ( ( (lv_prefix_0_0= '|' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )? ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3878:1: ( ( (lv_prefix_0_0= '|' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )? )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3878:1: ( ( (lv_prefix_0_0= '|' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )? )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3878:2: ( (lv_prefix_0_0= '|' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )?
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3878:2: ( (lv_prefix_0_0= '|' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3879:1: (lv_prefix_0_0= '|' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3879:1: (lv_prefix_0_0= '|' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3880:3: lv_prefix_0_0= '|'
            {
            lv_prefix_0_0=(Token)match(input,69,FollowSets000.FOLLOW_69_in_ruleNavigatingBarArgCS8867); if (state.failed) return current;
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3893:2: ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3894:1: (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3894:1: (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3895:3: lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNavigatingBarArgCSAccess().getOwnedNameExpressionNavigatingArgExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingBarArgCS8901);
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3911:2: (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==54) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3911:4: otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )?
                    {
                    otherlv_2=(Token)match(input,54,FollowSets000.FOLLOW_54_in_ruleNavigatingBarArgCS8914); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getNavigatingBarArgCSAccess().getColonKeyword_2_0());
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3915:1: ( (lv_ownedType_3_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3916:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3916:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3917:3: lv_ownedType_3_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingBarArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleNavigatingBarArgCS8935);
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

                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3933:2: (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )?
                    int alt65=2;
                    int LA65_0 = input.LA(1);

                    if ( (LA65_0==25) ) {
                        alt65=1;
                    }
                    switch (alt65) {
                        case 1 :
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3933:4: otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) )
                            {
                            otherlv_4=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleNavigatingBarArgCS8948); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getNavigatingBarArgCSAccess().getEqualsSignKeyword_2_2_0());
                                  
                            }
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3937:1: ( (lv_ownedInitExpression_5_0= ruleExpCS ) )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3938:1: (lv_ownedInitExpression_5_0= ruleExpCS )
                            {
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3938:1: (lv_ownedInitExpression_5_0= ruleExpCS )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3939:3: lv_ownedInitExpression_5_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getNavigatingBarArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_2_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNavigatingBarArgCS8969);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3963:1: entryRuleNavigatingCommaArgCS returns [EObject current=null] : iv_ruleNavigatingCommaArgCS= ruleNavigatingCommaArgCS EOF ;
    public final EObject entryRuleNavigatingCommaArgCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingCommaArgCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3964:2: (iv_ruleNavigatingCommaArgCS= ruleNavigatingCommaArgCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3965:2: iv_ruleNavigatingCommaArgCS= ruleNavigatingCommaArgCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingCommaArgCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingCommaArgCS_in_entryRuleNavigatingCommaArgCS9009);
            iv_ruleNavigatingCommaArgCS=ruleNavigatingCommaArgCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingCommaArgCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigatingCommaArgCS9019); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3972:1: ruleNavigatingCommaArgCS returns [EObject current=null] : ( ( (lv_prefix_0_0= ',' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) ( (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? ) | (otherlv_6= 'in' ( (lv_ownedInitExpression_7_0= ruleExpCS ) ) ) )? ) ;
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
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3975:28: ( ( ( (lv_prefix_0_0= ',' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) ( (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? ) | (otherlv_6= 'in' ( (lv_ownedInitExpression_7_0= ruleExpCS ) ) ) )? ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3976:1: ( ( (lv_prefix_0_0= ',' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) ( (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? ) | (otherlv_6= 'in' ( (lv_ownedInitExpression_7_0= ruleExpCS ) ) ) )? )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3976:1: ( ( (lv_prefix_0_0= ',' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) ( (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? ) | (otherlv_6= 'in' ( (lv_ownedInitExpression_7_0= ruleExpCS ) ) ) )? )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3976:2: ( (lv_prefix_0_0= ',' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) ( (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? ) | (otherlv_6= 'in' ( (lv_ownedInitExpression_7_0= ruleExpCS ) ) ) )?
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3976:2: ( (lv_prefix_0_0= ',' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3977:1: (lv_prefix_0_0= ',' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3977:1: (lv_prefix_0_0= ',' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3978:3: lv_prefix_0_0= ','
            {
            lv_prefix_0_0=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleNavigatingCommaArgCS9062); if (state.failed) return current;
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3991:2: ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3992:1: (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3992:1: (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3993:3: lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedNameExpressionNavigatingArgExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingCommaArgCS9096);
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4009:2: ( (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? ) | (otherlv_6= 'in' ( (lv_ownedInitExpression_7_0= ruleExpCS ) ) ) )?
            int alt68=3;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==54) ) {
                alt68=1;
            }
            else if ( (LA68_0==68) ) {
                alt68=2;
            }
            switch (alt68) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4009:3: (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4009:3: (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4009:5: otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )?
                    {
                    otherlv_2=(Token)match(input,54,FollowSets000.FOLLOW_54_in_ruleNavigatingCommaArgCS9110); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getNavigatingCommaArgCSAccess().getColonKeyword_2_0_0());
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4013:1: ( (lv_ownedType_3_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4014:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4014:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4015:3: lv_ownedType_3_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_0_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleNavigatingCommaArgCS9131);
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

                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4031:2: (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )?
                    int alt67=2;
                    int LA67_0 = input.LA(1);

                    if ( (LA67_0==25) ) {
                        alt67=1;
                    }
                    switch (alt67) {
                        case 1 :
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4031:4: otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) )
                            {
                            otherlv_4=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleNavigatingCommaArgCS9144); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getNavigatingCommaArgCSAccess().getEqualsSignKeyword_2_0_2_0());
                                  
                            }
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4035:1: ( (lv_ownedInitExpression_5_0= ruleExpCS ) )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4036:1: (lv_ownedInitExpression_5_0= ruleExpCS )
                            {
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4036:1: (lv_ownedInitExpression_5_0= ruleExpCS )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4037:3: lv_ownedInitExpression_5_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_0_2_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNavigatingCommaArgCS9165);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4054:6: (otherlv_6= 'in' ( (lv_ownedInitExpression_7_0= ruleExpCS ) ) )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4054:6: (otherlv_6= 'in' ( (lv_ownedInitExpression_7_0= ruleExpCS ) ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4054:8: otherlv_6= 'in' ( (lv_ownedInitExpression_7_0= ruleExpCS ) )
                    {
                    otherlv_6=(Token)match(input,68,FollowSets000.FOLLOW_68_in_ruleNavigatingCommaArgCS9187); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getNavigatingCommaArgCSAccess().getInKeyword_2_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4058:1: ( (lv_ownedInitExpression_7_0= ruleExpCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4059:1: (lv_ownedInitExpression_7_0= ruleExpCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4059:1: (lv_ownedInitExpression_7_0= ruleExpCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4060:3: lv_ownedInitExpression_7_0= ruleExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNavigatingCommaArgCS9208);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4084:1: entryRuleNavigatingSemiArgCS returns [EObject current=null] : iv_ruleNavigatingSemiArgCS= ruleNavigatingSemiArgCS EOF ;
    public final EObject entryRuleNavigatingSemiArgCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingSemiArgCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4085:2: (iv_ruleNavigatingSemiArgCS= ruleNavigatingSemiArgCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4086:2: iv_ruleNavigatingSemiArgCS= ruleNavigatingSemiArgCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingSemiArgCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingSemiArgCS_in_entryRuleNavigatingSemiArgCS9247);
            iv_ruleNavigatingSemiArgCS=ruleNavigatingSemiArgCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingSemiArgCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigatingSemiArgCS9257); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4093:1: ruleNavigatingSemiArgCS returns [EObject current=null] : ( ( (lv_prefix_0_0= ';' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )? ) ;
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
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4096:28: ( ( ( (lv_prefix_0_0= ';' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )? ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4097:1: ( ( (lv_prefix_0_0= ';' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )? )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4097:1: ( ( (lv_prefix_0_0= ';' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )? )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4097:2: ( (lv_prefix_0_0= ';' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )?
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4097:2: ( (lv_prefix_0_0= ';' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4098:1: (lv_prefix_0_0= ';' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4098:1: (lv_prefix_0_0= ';' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4099:3: lv_prefix_0_0= ';'
            {
            lv_prefix_0_0=(Token)match(input,70,FollowSets000.FOLLOW_70_in_ruleNavigatingSemiArgCS9300); if (state.failed) return current;
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4112:2: ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4113:1: (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4113:1: (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4114:3: lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNavigatingSemiArgCSAccess().getOwnedNameExpressionNavigatingArgExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingSemiArgCS9334);
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4130:2: (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==54) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4130:4: otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )?
                    {
                    otherlv_2=(Token)match(input,54,FollowSets000.FOLLOW_54_in_ruleNavigatingSemiArgCS9347); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getNavigatingSemiArgCSAccess().getColonKeyword_2_0());
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4134:1: ( (lv_ownedType_3_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4135:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4135:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4136:3: lv_ownedType_3_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingSemiArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleNavigatingSemiArgCS9368);
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

                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4152:2: (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )?
                    int alt69=2;
                    int LA69_0 = input.LA(1);

                    if ( (LA69_0==25) ) {
                        alt69=1;
                    }
                    switch (alt69) {
                        case 1 :
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4152:4: otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) )
                            {
                            otherlv_4=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleNavigatingSemiArgCS9381); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getNavigatingSemiArgCSAccess().getEqualsSignKeyword_2_2_0());
                                  
                            }
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4156:1: ( (lv_ownedInitExpression_5_0= ruleExpCS ) )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4157:1: (lv_ownedInitExpression_5_0= ruleExpCS )
                            {
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4157:1: (lv_ownedInitExpression_5_0= ruleExpCS )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4158:3: lv_ownedInitExpression_5_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getNavigatingSemiArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_2_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNavigatingSemiArgCS9402);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4182:1: entryRuleNavigatingArgExpCS returns [EObject current=null] : iv_ruleNavigatingArgExpCS= ruleNavigatingArgExpCS EOF ;
    public final EObject entryRuleNavigatingArgExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingArgExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4183:2: (iv_ruleNavigatingArgExpCS= ruleNavigatingArgExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4184:2: iv_ruleNavigatingArgExpCS= ruleNavigatingArgExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingArgExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgExpCS_in_entryRuleNavigatingArgExpCS9442);
            iv_ruleNavigatingArgExpCS=ruleNavigatingArgExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingArgExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigatingArgExpCS9452); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4191:1: ruleNavigatingArgExpCS returns [EObject current=null] : this_ExpCS_0= ruleExpCS ;
    public final EObject ruleNavigatingArgExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_ExpCS_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4194:28: (this_ExpCS_0= ruleExpCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4196:2: this_ExpCS_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getNavigatingArgExpCSAccess().getExpCSParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNavigatingArgExpCS9501);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4215:1: entryRuleIfExpCS returns [EObject current=null] : iv_ruleIfExpCS= ruleIfExpCS EOF ;
    public final EObject entryRuleIfExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4216:2: (iv_ruleIfExpCS= ruleIfExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4217:2: iv_ruleIfExpCS= ruleIfExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIfExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIfExpCS_in_entryRuleIfExpCS9535);
            iv_ruleIfExpCS=ruleIfExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIfExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIfExpCS9545); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4224:1: ruleIfExpCS returns [EObject current=null] : (otherlv_0= 'if' ( ( (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS ) ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) ( (lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS ) )* otherlv_5= 'else' ( (lv_ownedElseExpression_6_0= ruleExpCS ) ) otherlv_7= 'endif' ) ;
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
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4227:28: ( (otherlv_0= 'if' ( ( (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS ) ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) ( (lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS ) )* otherlv_5= 'else' ( (lv_ownedElseExpression_6_0= ruleExpCS ) ) otherlv_7= 'endif' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4228:1: (otherlv_0= 'if' ( ( (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS ) ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) ( (lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS ) )* otherlv_5= 'else' ( (lv_ownedElseExpression_6_0= ruleExpCS ) ) otherlv_7= 'endif' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4228:1: (otherlv_0= 'if' ( ( (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS ) ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) ( (lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS ) )* otherlv_5= 'else' ( (lv_ownedElseExpression_6_0= ruleExpCS ) ) otherlv_7= 'endif' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4228:3: otherlv_0= 'if' ( ( (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS ) ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) ( (lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS ) )* otherlv_5= 'else' ( (lv_ownedElseExpression_6_0= ruleExpCS ) ) otherlv_7= 'endif'
            {
            otherlv_0=(Token)match(input,71,FollowSets000.FOLLOW_71_in_ruleIfExpCS9582); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getIfExpCSAccess().getIfKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4232:1: ( ( (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4233:1: ( (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4233:1: ( (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4234:1: (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4234:1: (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS )
            int alt71=2;
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
                alt71=1;
                }
                break;
            case RULE_SIMPLE_ID:
                {
                int LA71_2 = input.LA(2);

                if ( (LA71_2==16||(LA71_2>=18 && LA71_2<=34)||LA71_2==50||LA71_2==55||LA71_2==64||LA71_2==66||LA71_2==72||LA71_2==81) ) {
                    alt71=1;
                }
                else if ( (LA71_2==54) ) {
                    alt71=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 71, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_ESCAPED_ID:
                {
                int LA71_3 = input.LA(2);

                if ( (LA71_3==16||(LA71_3>=18 && LA71_3<=34)||LA71_3==50||LA71_3==55||LA71_3==64||LA71_3==66||LA71_3==72||LA71_3==81) ) {
                    alt71=1;
                }
                else if ( (LA71_3==54) ) {
                    alt71=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 71, 3, input);

                    throw nvae;
                }
                }
                break;
            case 54:
                {
                alt71=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 71, 0, input);

                throw nvae;
            }

            switch (alt71) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4235:3: lv_ownedCondition_1_1= ruleExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getIfExpCSAccess().getOwnedConditionExpCSParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleIfExpCS9605);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4250:8: lv_ownedCondition_1_2= rulePatternExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getIfExpCSAccess().getOwnedConditionPatternExpCSParserRuleCall_1_0_1()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePatternExpCS_in_ruleIfExpCS9624);
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

            otherlv_2=(Token)match(input,72,FollowSets000.FOLLOW_72_in_ruleIfExpCS9639); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getIfExpCSAccess().getThenKeyword_2());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4272:1: ( (lv_ownedThenExpression_3_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4273:1: (lv_ownedThenExpression_3_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4273:1: (lv_ownedThenExpression_3_0= ruleExpCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4274:3: lv_ownedThenExpression_3_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIfExpCSAccess().getOwnedThenExpressionExpCSParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleIfExpCS9660);
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4290:2: ( (lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS ) )*
            loop72:
            do {
                int alt72=2;
                int LA72_0 = input.LA(1);

                if ( (LA72_0==75) ) {
                    alt72=1;
                }


                switch (alt72) {
            	case 1 :
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4291:1: (lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS )
            	    {
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4291:1: (lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS )
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4292:3: lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getIfExpCSAccess().getOwnedIfThenExpressionsElseIfThenExpCSParserRuleCall_4_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleElseIfThenExpCS_in_ruleIfExpCS9681);
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
            	    break loop72;
                }
            } while (true);

            otherlv_5=(Token)match(input,73,FollowSets000.FOLLOW_73_in_ruleIfExpCS9694); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getIfExpCSAccess().getElseKeyword_5());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4312:1: ( (lv_ownedElseExpression_6_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4313:1: (lv_ownedElseExpression_6_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4313:1: (lv_ownedElseExpression_6_0= ruleExpCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4314:3: lv_ownedElseExpression_6_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIfExpCSAccess().getOwnedElseExpressionExpCSParserRuleCall_6_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleIfExpCS9715);
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

            otherlv_7=(Token)match(input,74,FollowSets000.FOLLOW_74_in_ruleIfExpCS9727); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4342:1: entryRuleElseIfThenExpCS returns [EObject current=null] : iv_ruleElseIfThenExpCS= ruleElseIfThenExpCS EOF ;
    public final EObject entryRuleElseIfThenExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElseIfThenExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4343:2: (iv_ruleElseIfThenExpCS= ruleElseIfThenExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4344:2: iv_ruleElseIfThenExpCS= ruleElseIfThenExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getElseIfThenExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleElseIfThenExpCS_in_entryRuleElseIfThenExpCS9763);
            iv_ruleElseIfThenExpCS=ruleElseIfThenExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleElseIfThenExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleElseIfThenExpCS9773); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4351:1: ruleElseIfThenExpCS returns [EObject current=null] : (otherlv_0= 'elseif' ( (lv_ownedCondition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) ) ;
    public final EObject ruleElseIfThenExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_ownedCondition_1_0 = null;

        EObject lv_ownedThenExpression_3_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4354:28: ( (otherlv_0= 'elseif' ( (lv_ownedCondition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4355:1: (otherlv_0= 'elseif' ( (lv_ownedCondition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4355:1: (otherlv_0= 'elseif' ( (lv_ownedCondition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4355:3: otherlv_0= 'elseif' ( (lv_ownedCondition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) )
            {
            otherlv_0=(Token)match(input,75,FollowSets000.FOLLOW_75_in_ruleElseIfThenExpCS9810); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getElseIfThenExpCSAccess().getElseifKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4359:1: ( (lv_ownedCondition_1_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4360:1: (lv_ownedCondition_1_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4360:1: (lv_ownedCondition_1_0= ruleExpCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4361:3: lv_ownedCondition_1_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getElseIfThenExpCSAccess().getOwnedConditionExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleElseIfThenExpCS9831);
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

            otherlv_2=(Token)match(input,72,FollowSets000.FOLLOW_72_in_ruleElseIfThenExpCS9843); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getElseIfThenExpCSAccess().getThenKeyword_2());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4381:1: ( (lv_ownedThenExpression_3_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4382:1: (lv_ownedThenExpression_3_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4382:1: (lv_ownedThenExpression_3_0= ruleExpCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4383:3: lv_ownedThenExpression_3_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getElseIfThenExpCSAccess().getOwnedThenExpressionExpCSParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleElseIfThenExpCS9864);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4407:1: entryRuleLetExpCS returns [EObject current=null] : iv_ruleLetExpCS= ruleLetExpCS EOF ;
    public final EObject entryRuleLetExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLetExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4408:2: (iv_ruleLetExpCS= ruleLetExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4409:2: iv_ruleLetExpCS= ruleLetExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLetExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLetExpCS_in_entryRuleLetExpCS9900);
            iv_ruleLetExpCS=ruleLetExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLetExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLetExpCS9910); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4416:1: ruleLetExpCS returns [EObject current=null] : (otherlv_0= 'let' ( (lv_ownedVariables_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_ownedVariables_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_ownedInExpression_5_0= ruleExpCS ) ) ) ;
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
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4419:28: ( (otherlv_0= 'let' ( (lv_ownedVariables_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_ownedVariables_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_ownedInExpression_5_0= ruleExpCS ) ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4420:1: (otherlv_0= 'let' ( (lv_ownedVariables_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_ownedVariables_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_ownedInExpression_5_0= ruleExpCS ) ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4420:1: (otherlv_0= 'let' ( (lv_ownedVariables_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_ownedVariables_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_ownedInExpression_5_0= ruleExpCS ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4420:3: otherlv_0= 'let' ( (lv_ownedVariables_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_ownedVariables_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_ownedInExpression_5_0= ruleExpCS ) )
            {
            otherlv_0=(Token)match(input,76,FollowSets000.FOLLOW_76_in_ruleLetExpCS9947); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLetExpCSAccess().getLetKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4424:1: ( (lv_ownedVariables_1_0= ruleLetVariableCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4425:1: (lv_ownedVariables_1_0= ruleLetVariableCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4425:1: (lv_ownedVariables_1_0= ruleLetVariableCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4426:3: lv_ownedVariables_1_0= ruleLetVariableCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetExpCSAccess().getOwnedVariablesLetVariableCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleLetVariableCS_in_ruleLetExpCS9968);
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4442:2: (otherlv_2= ',' ( (lv_ownedVariables_3_0= ruleLetVariableCS ) ) )*
            loop73:
            do {
                int alt73=2;
                int LA73_0 = input.LA(1);

                if ( (LA73_0==53) ) {
                    alt73=1;
                }


                switch (alt73) {
            	case 1 :
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4442:4: otherlv_2= ',' ( (lv_ownedVariables_3_0= ruleLetVariableCS ) )
            	    {
            	    otherlv_2=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleLetExpCS9981); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getLetExpCSAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4446:1: ( (lv_ownedVariables_3_0= ruleLetVariableCS ) )
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4447:1: (lv_ownedVariables_3_0= ruleLetVariableCS )
            	    {
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4447:1: (lv_ownedVariables_3_0= ruleLetVariableCS )
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4448:3: lv_ownedVariables_3_0= ruleLetVariableCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLetExpCSAccess().getOwnedVariablesLetVariableCSParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleLetVariableCS_in_ruleLetExpCS10002);
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
            	    break loop73;
                }
            } while (true);

            otherlv_4=(Token)match(input,68,FollowSets000.FOLLOW_68_in_ruleLetExpCS10016); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getLetExpCSAccess().getInKeyword_3());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4468:1: ( (lv_ownedInExpression_5_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4469:1: (lv_ownedInExpression_5_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4469:1: (lv_ownedInExpression_5_0= ruleExpCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4470:3: lv_ownedInExpression_5_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetExpCSAccess().getOwnedInExpressionExpCSParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleLetExpCS10037);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4494:1: entryRuleLetVariableCS returns [EObject current=null] : iv_ruleLetVariableCS= ruleLetVariableCS EOF ;
    public final EObject entryRuleLetVariableCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLetVariableCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4495:2: (iv_ruleLetVariableCS= ruleLetVariableCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4496:2: iv_ruleLetVariableCS= ruleLetVariableCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLetVariableCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLetVariableCS_in_entryRuleLetVariableCS10073);
            iv_ruleLetVariableCS=ruleLetVariableCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLetVariableCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLetVariableCS10083); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4503:1: ruleLetVariableCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) ( (lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS ) )? (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )? otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) ) ;
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
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4506:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) ( (lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS ) )? (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )? otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4507:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) ( (lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS ) )? (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )? otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4507:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) ( (lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS ) )? (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )? otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4507:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) ( (lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS ) )? (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )? otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4507:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4508:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4508:1: (lv_name_0_0= ruleUnrestrictedName )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4509:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetVariableCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleLetVariableCS10129);
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4525:2: ( (lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS ) )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==50) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4526:1: (lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4526:1: (lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4527:3: lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLetVariableCSAccess().getOwnedRoundBracketedClauseRoundBracketedClauseCSParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleRoundBracketedClauseCS_in_ruleLetVariableCS10150);
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4543:3: (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==54) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4543:5: otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) )
                    {
                    otherlv_2=(Token)match(input,54,FollowSets000.FOLLOW_54_in_ruleLetVariableCS10164); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getLetVariableCSAccess().getColonKeyword_2_0());
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4547:1: ( (lv_ownedType_3_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4548:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4548:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4549:3: lv_ownedType_3_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLetVariableCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleLetVariableCS10185);
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

            otherlv_4=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleLetVariableCS10199); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getLetVariableCSAccess().getEqualsSignKeyword_3());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4569:1: ( (lv_ownedInitExpression_5_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4570:1: (lv_ownedInitExpression_5_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4570:1: (lv_ownedInitExpression_5_0= ruleExpCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4571:3: lv_ownedInitExpression_5_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetVariableCSAccess().getOwnedInitExpressionExpCSParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleLetVariableCS10220);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4595:1: entryRuleNestedExpCS returns [EObject current=null] : iv_ruleNestedExpCS= ruleNestedExpCS EOF ;
    public final EObject entryRuleNestedExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNestedExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4596:2: (iv_ruleNestedExpCS= ruleNestedExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4597:2: iv_ruleNestedExpCS= ruleNestedExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNestedExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNestedExpCS_in_entryRuleNestedExpCS10256);
            iv_ruleNestedExpCS=ruleNestedExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNestedExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNestedExpCS10266); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4604:1: ruleNestedExpCS returns [EObject current=null] : (otherlv_0= '(' ( (lv_ownedExpression_1_0= ruleExpCS ) ) otherlv_2= ')' ) ;
    public final EObject ruleNestedExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_ownedExpression_1_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4607:28: ( (otherlv_0= '(' ( (lv_ownedExpression_1_0= ruleExpCS ) ) otherlv_2= ')' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4608:1: (otherlv_0= '(' ( (lv_ownedExpression_1_0= ruleExpCS ) ) otherlv_2= ')' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4608:1: (otherlv_0= '(' ( (lv_ownedExpression_1_0= ruleExpCS ) ) otherlv_2= ')' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4608:3: otherlv_0= '(' ( (lv_ownedExpression_1_0= ruleExpCS ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,50,FollowSets000.FOLLOW_50_in_ruleNestedExpCS10303); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getNestedExpCSAccess().getLeftParenthesisKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4612:1: ( (lv_ownedExpression_1_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4613:1: (lv_ownedExpression_1_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4613:1: (lv_ownedExpression_1_0= ruleExpCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4614:3: lv_ownedExpression_1_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNestedExpCSAccess().getOwnedExpressionExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNestedExpCS10324);
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

            otherlv_2=(Token)match(input,51,FollowSets000.FOLLOW_51_in_ruleNestedExpCS10336); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4642:1: entryRuleSelfExpCS returns [EObject current=null] : iv_ruleSelfExpCS= ruleSelfExpCS EOF ;
    public final EObject entryRuleSelfExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelfExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4643:2: (iv_ruleSelfExpCS= ruleSelfExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4644:2: iv_ruleSelfExpCS= ruleSelfExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSelfExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSelfExpCS_in_entryRuleSelfExpCS10372);
            iv_ruleSelfExpCS=ruleSelfExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSelfExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSelfExpCS10382); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4651:1: ruleSelfExpCS returns [EObject current=null] : ( () otherlv_1= 'self' ) ;
    public final EObject ruleSelfExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4654:28: ( ( () otherlv_1= 'self' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4655:1: ( () otherlv_1= 'self' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4655:1: ( () otherlv_1= 'self' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4655:2: () otherlv_1= 'self'
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4655:2: ()
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4656:2: 
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

            otherlv_1=(Token)match(input,77,FollowSets000.FOLLOW_77_in_ruleSelfExpCS10431); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4676:1: entryRuleMultiplicityBoundsCS returns [EObject current=null] : iv_ruleMultiplicityBoundsCS= ruleMultiplicityBoundsCS EOF ;
    public final EObject entryRuleMultiplicityBoundsCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicityBoundsCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4677:2: (iv_ruleMultiplicityBoundsCS= ruleMultiplicityBoundsCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4678:2: iv_ruleMultiplicityBoundsCS= ruleMultiplicityBoundsCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicityBoundsCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMultiplicityBoundsCS_in_entryRuleMultiplicityBoundsCS10467);
            iv_ruleMultiplicityBoundsCS=ruleMultiplicityBoundsCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicityBoundsCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMultiplicityBoundsCS10477); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4685:1: ruleMultiplicityBoundsCS returns [EObject current=null] : ( ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )? ) ;
    public final EObject ruleMultiplicityBoundsCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_lowerBound_0_0 = null;

        AntlrDatatypeRuleToken lv_upperBound_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4688:28: ( ( ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )? ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4689:1: ( ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )? )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4689:1: ( ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )? )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4689:2: ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )?
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4689:2: ( (lv_lowerBound_0_0= ruleLOWER ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4690:1: (lv_lowerBound_0_0= ruleLOWER )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4690:1: (lv_lowerBound_0_0= ruleLOWER )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4691:3: lv_lowerBound_0_0= ruleLOWER
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiplicityBoundsCSAccess().getLowerBoundLOWERParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleLOWER_in_ruleMultiplicityBoundsCS10523);
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4707:2: (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==57) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4707:4: otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) )
                    {
                    otherlv_1=(Token)match(input,57,FollowSets000.FOLLOW_57_in_ruleMultiplicityBoundsCS10536); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getMultiplicityBoundsCSAccess().getFullStopFullStopKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4711:1: ( (lv_upperBound_2_0= ruleUPPER ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4712:1: (lv_upperBound_2_0= ruleUPPER )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4712:1: (lv_upperBound_2_0= ruleUPPER )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4713:3: lv_upperBound_2_0= ruleUPPER
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMultiplicityBoundsCSAccess().getUpperBoundUPPERParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUPPER_in_ruleMultiplicityBoundsCS10557);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4737:1: entryRuleMultiplicityCS returns [EObject current=null] : iv_ruleMultiplicityCS= ruleMultiplicityCS EOF ;
    public final EObject entryRuleMultiplicityCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicityCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4738:2: (iv_ruleMultiplicityCS= ruleMultiplicityCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4739:2: iv_ruleMultiplicityCS= ruleMultiplicityCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicityCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMultiplicityCS_in_entryRuleMultiplicityCS10595);
            iv_ruleMultiplicityCS=ruleMultiplicityCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicityCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMultiplicityCS10605); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4746:1: ruleMultiplicityCS returns [EObject current=null] : (otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) (otherlv_3= '|?' | ( (lv_isNullFree_4_0= '|1' ) ) )? otherlv_5= ']' ) ;
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
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4749:28: ( (otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) (otherlv_3= '|?' | ( (lv_isNullFree_4_0= '|1' ) ) )? otherlv_5= ']' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4750:1: (otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) (otherlv_3= '|?' | ( (lv_isNullFree_4_0= '|1' ) ) )? otherlv_5= ']' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4750:1: (otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) (otherlv_3= '|?' | ( (lv_isNullFree_4_0= '|1' ) ) )? otherlv_5= ']' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4750:3: otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) (otherlv_3= '|?' | ( (lv_isNullFree_4_0= '|1' ) ) )? otherlv_5= ']'
            {
            otherlv_0=(Token)match(input,66,FollowSets000.FOLLOW_66_in_ruleMultiplicityCS10642); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMultiplicityCSAccess().getLeftSquareBracketKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4754:1: (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS )
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==RULE_INT) ) {
                alt77=1;
            }
            else if ( (LA77_0==18||LA77_0==20||LA77_0==80) ) {
                alt77=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 77, 0, input);

                throw nvae;
            }
            switch (alt77) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4755:2: this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getMultiplicityCSAccess().getMultiplicityBoundsCSParserRuleCall_1_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMultiplicityBoundsCS_in_ruleMultiplicityCS10668);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4768:2: this_MultiplicityStringCS_2= ruleMultiplicityStringCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getMultiplicityCSAccess().getMultiplicityStringCSParserRuleCall_1_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMultiplicityStringCS_in_ruleMultiplicityCS10698);
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4779:2: (otherlv_3= '|?' | ( (lv_isNullFree_4_0= '|1' ) ) )?
            int alt78=3;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==78) ) {
                alt78=1;
            }
            else if ( (LA78_0==79) ) {
                alt78=2;
            }
            switch (alt78) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4779:4: otherlv_3= '|?'
                    {
                    otherlv_3=(Token)match(input,78,FollowSets000.FOLLOW_78_in_ruleMultiplicityCS10711); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getMultiplicityCSAccess().getVerticalLineQuestionMarkKeyword_2_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4784:6: ( (lv_isNullFree_4_0= '|1' ) )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4784:6: ( (lv_isNullFree_4_0= '|1' ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4785:1: (lv_isNullFree_4_0= '|1' )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4785:1: (lv_isNullFree_4_0= '|1' )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4786:3: lv_isNullFree_4_0= '|1'
                    {
                    lv_isNullFree_4_0=(Token)match(input,79,FollowSets000.FOLLOW_79_in_ruleMultiplicityCS10735); if (state.failed) return current;
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

            otherlv_5=(Token)match(input,67,FollowSets000.FOLLOW_67_in_ruleMultiplicityCS10762); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4811:1: entryRuleMultiplicityStringCS returns [EObject current=null] : iv_ruleMultiplicityStringCS= ruleMultiplicityStringCS EOF ;
    public final EObject entryRuleMultiplicityStringCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicityStringCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4812:2: (iv_ruleMultiplicityStringCS= ruleMultiplicityStringCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4813:2: iv_ruleMultiplicityStringCS= ruleMultiplicityStringCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicityStringCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMultiplicityStringCS_in_entryRuleMultiplicityStringCS10798);
            iv_ruleMultiplicityStringCS=ruleMultiplicityStringCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicityStringCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMultiplicityStringCS10808); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4820:1: ruleMultiplicityStringCS returns [EObject current=null] : ( ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) ) ) ;
    public final EObject ruleMultiplicityStringCS() throws RecognitionException {
        EObject current = null;

        Token lv_stringBounds_0_1=null;
        Token lv_stringBounds_0_2=null;
        Token lv_stringBounds_0_3=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4823:28: ( ( ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4824:1: ( ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4824:1: ( ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4825:1: ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4825:1: ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4826:1: (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4826:1: (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' )
            int alt79=3;
            switch ( input.LA(1) ) {
            case 18:
                {
                alt79=1;
                }
                break;
            case 20:
                {
                alt79=2;
                }
                break;
            case 80:
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4827:3: lv_stringBounds_0_1= '*'
                    {
                    lv_stringBounds_0_1=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleMultiplicityStringCS10852); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4839:8: lv_stringBounds_0_2= '+'
                    {
                    lv_stringBounds_0_2=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleMultiplicityStringCS10881); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4851:8: lv_stringBounds_0_3= '?'
                    {
                    lv_stringBounds_0_3=(Token)match(input,80,FollowSets000.FOLLOW_80_in_ruleMultiplicityStringCS10910); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4874:1: entryRulePathNameCS returns [EObject current=null] : iv_rulePathNameCS= rulePathNameCS EOF ;
    public final EObject entryRulePathNameCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePathNameCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4875:2: (iv_rulePathNameCS= rulePathNameCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4876:2: iv_rulePathNameCS= rulePathNameCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPathNameCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePathNameCS_in_entryRulePathNameCS10961);
            iv_rulePathNameCS=rulePathNameCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePathNameCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePathNameCS10971); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4883:1: rulePathNameCS returns [EObject current=null] : ( ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )* ) ;
    public final EObject rulePathNameCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_ownedPathElements_0_0 = null;

        EObject lv_ownedPathElements_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4886:28: ( ( ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )* ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4887:1: ( ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )* )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4887:1: ( ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )* )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4887:2: ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )*
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4887:2: ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4888:1: (lv_ownedPathElements_0_0= ruleFirstPathElementCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4888:1: (lv_ownedPathElements_0_0= ruleFirstPathElementCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4889:3: lv_ownedPathElements_0_0= ruleFirstPathElementCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPathNameCSAccess().getOwnedPathElementsFirstPathElementCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleFirstPathElementCS_in_rulePathNameCS11017);
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4905:2: (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )*
            loop80:
            do {
                int alt80=2;
                int LA80_0 = input.LA(1);

                if ( (LA80_0==81) ) {
                    alt80=1;
                }


                switch (alt80) {
            	case 1 :
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4905:4: otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) )
            	    {
            	    otherlv_1=(Token)match(input,81,FollowSets000.FOLLOW_81_in_rulePathNameCS11030); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getPathNameCSAccess().getColonColonKeyword_1_0());
            	          
            	    }
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4909:1: ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) )
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4910:1: (lv_ownedPathElements_2_0= ruleNextPathElementCS )
            	    {
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4910:1: (lv_ownedPathElements_2_0= ruleNextPathElementCS )
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4911:3: lv_ownedPathElements_2_0= ruleNextPathElementCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getPathNameCSAccess().getOwnedPathElementsNextPathElementCSParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleNextPathElementCS_in_rulePathNameCS11051);
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
            	    break loop80;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4935:1: entryRuleFirstPathElementCS returns [EObject current=null] : iv_ruleFirstPathElementCS= ruleFirstPathElementCS EOF ;
    public final EObject entryRuleFirstPathElementCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFirstPathElementCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4936:2: (iv_ruleFirstPathElementCS= ruleFirstPathElementCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4937:2: iv_ruleFirstPathElementCS= ruleFirstPathElementCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFirstPathElementCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleFirstPathElementCS_in_entryRuleFirstPathElementCS11089);
            iv_ruleFirstPathElementCS=ruleFirstPathElementCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFirstPathElementCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFirstPathElementCS11099); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4944:1: ruleFirstPathElementCS returns [EObject current=null] : ( ( ruleUnrestrictedName ) ) ;
    public final EObject ruleFirstPathElementCS() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4947:28: ( ( ( ruleUnrestrictedName ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4948:1: ( ( ruleUnrestrictedName ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4948:1: ( ( ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4949:1: ( ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4949:1: ( ruleUnrestrictedName )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4950:3: ruleUnrestrictedName
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
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleFirstPathElementCS11150);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4974:1: entryRuleNextPathElementCS returns [EObject current=null] : iv_ruleNextPathElementCS= ruleNextPathElementCS EOF ;
    public final EObject entryRuleNextPathElementCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNextPathElementCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4975:2: (iv_ruleNextPathElementCS= ruleNextPathElementCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4976:2: iv_ruleNextPathElementCS= ruleNextPathElementCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNextPathElementCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNextPathElementCS_in_entryRuleNextPathElementCS11185);
            iv_ruleNextPathElementCS=ruleNextPathElementCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNextPathElementCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNextPathElementCS11195); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4983:1: ruleNextPathElementCS returns [EObject current=null] : ( ( ruleUnreservedName ) ) ;
    public final EObject ruleNextPathElementCS() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4986:28: ( ( ( ruleUnreservedName ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4987:1: ( ( ruleUnreservedName ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4987:1: ( ( ruleUnreservedName ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4988:1: ( ruleUnreservedName )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4988:1: ( ruleUnreservedName )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4989:3: ruleUnreservedName
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
            pushFollow(FollowSets000.FOLLOW_ruleUnreservedName_in_ruleNextPathElementCS11246);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5013:1: entryRulePathTypeCS returns [EObject current=null] : iv_rulePathTypeCS= rulePathTypeCS EOF ;
    public final EObject entryRulePathTypeCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePathTypeCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5014:2: (iv_rulePathTypeCS= rulePathTypeCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5015:2: iv_rulePathTypeCS= rulePathTypeCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPathTypeCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePathTypeCS_in_entryRulePathTypeCS11281);
            iv_rulePathTypeCS=rulePathTypeCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePathTypeCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePathTypeCS11291); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5022:1: rulePathTypeCS returns [EObject current=null] : ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) (otherlv_1= '(' ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) ) otherlv_3= ')' )? ) ;
    public final EObject rulePathTypeCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_ownedPathName_0_0 = null;

        EObject lv_ownedBinding_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5025:28: ( ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) (otherlv_1= '(' ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) ) otherlv_3= ')' )? ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5026:1: ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) (otherlv_1= '(' ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) ) otherlv_3= ')' )? )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5026:1: ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) (otherlv_1= '(' ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) ) otherlv_3= ')' )? )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5026:2: ( (lv_ownedPathName_0_0= rulePathNameCS ) ) (otherlv_1= '(' ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) ) otherlv_3= ')' )?
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5026:2: ( (lv_ownedPathName_0_0= rulePathNameCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5027:1: (lv_ownedPathName_0_0= rulePathNameCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5027:1: (lv_ownedPathName_0_0= rulePathNameCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5028:3: lv_ownedPathName_0_0= rulePathNameCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPathTypeCSAccess().getOwnedPathNamePathNameCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_rulePathNameCS_in_rulePathTypeCS11337);
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5044:2: (otherlv_1= '(' ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) ) otherlv_3= ')' )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==50) ) {
                alt81=1;
            }
            switch (alt81) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5044:4: otherlv_1= '(' ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) ) otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,50,FollowSets000.FOLLOW_50_in_rulePathTypeCS11350); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getPathTypeCSAccess().getLeftParenthesisKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5048:1: ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5049:1: (lv_ownedBinding_2_0= ruleTemplateBindingCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5049:1: (lv_ownedBinding_2_0= ruleTemplateBindingCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5050:3: lv_ownedBinding_2_0= ruleTemplateBindingCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPathTypeCSAccess().getOwnedBindingTemplateBindingCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTemplateBindingCS_in_rulePathTypeCS11371);
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

                    otherlv_3=(Token)match(input,51,FollowSets000.FOLLOW_51_in_rulePathTypeCS11383); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5078:1: entryRuleTemplateBindingCS returns [EObject current=null] : iv_ruleTemplateBindingCS= ruleTemplateBindingCS EOF ;
    public final EObject entryRuleTemplateBindingCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTemplateBindingCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5079:2: (iv_ruleTemplateBindingCS= ruleTemplateBindingCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5080:2: iv_ruleTemplateBindingCS= ruleTemplateBindingCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTemplateBindingCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTemplateBindingCS_in_entryRuleTemplateBindingCS11421);
            iv_ruleTemplateBindingCS=ruleTemplateBindingCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTemplateBindingCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTemplateBindingCS11431); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5087:1: ruleTemplateBindingCS returns [EObject current=null] : ( ( (lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS ) ) (otherlv_1= ',' ( (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS ) ) )* ) ;
    public final EObject ruleTemplateBindingCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_ownedSubstitutions_0_0 = null;

        EObject lv_ownedSubstitutions_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5090:28: ( ( ( (lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS ) ) (otherlv_1= ',' ( (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS ) ) )* ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5091:1: ( ( (lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS ) ) (otherlv_1= ',' ( (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS ) ) )* )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5091:1: ( ( (lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS ) ) (otherlv_1= ',' ( (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS ) ) )* )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5091:2: ( (lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS ) ) (otherlv_1= ',' ( (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS ) ) )*
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5091:2: ( (lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5092:1: (lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5092:1: (lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5093:3: lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsTemplateParameterSubstitutionCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTemplateParameterSubstitutionCS_in_ruleTemplateBindingCS11477);
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5109:2: (otherlv_1= ',' ( (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS ) ) )*
            loop82:
            do {
                int alt82=2;
                int LA82_0 = input.LA(1);

                if ( (LA82_0==53) ) {
                    alt82=1;
                }


                switch (alt82) {
            	case 1 :
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5109:4: otherlv_1= ',' ( (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS ) )
            	    {
            	    otherlv_1=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleTemplateBindingCS11490); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getTemplateBindingCSAccess().getCommaKeyword_1_0());
            	          
            	    }
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5113:1: ( (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS ) )
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5114:1: (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS )
            	    {
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5114:1: (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS )
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5115:3: lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsTemplateParameterSubstitutionCSParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleTemplateParameterSubstitutionCS_in_ruleTemplateBindingCS11511);
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
            	    break loop82;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5139:1: entryRuleTemplateParameterSubstitutionCS returns [EObject current=null] : iv_ruleTemplateParameterSubstitutionCS= ruleTemplateParameterSubstitutionCS EOF ;
    public final EObject entryRuleTemplateParameterSubstitutionCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTemplateParameterSubstitutionCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5140:2: (iv_ruleTemplateParameterSubstitutionCS= ruleTemplateParameterSubstitutionCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5141:2: iv_ruleTemplateParameterSubstitutionCS= ruleTemplateParameterSubstitutionCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTemplateParameterSubstitutionCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTemplateParameterSubstitutionCS_in_entryRuleTemplateParameterSubstitutionCS11549);
            iv_ruleTemplateParameterSubstitutionCS=ruleTemplateParameterSubstitutionCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTemplateParameterSubstitutionCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTemplateParameterSubstitutionCS11559); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5148:1: ruleTemplateParameterSubstitutionCS returns [EObject current=null] : ( (lv_ownedActualParameter_0_0= ruleTypeRefCS ) ) ;
    public final EObject ruleTemplateParameterSubstitutionCS() throws RecognitionException {
        EObject current = null;

        EObject lv_ownedActualParameter_0_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5151:28: ( ( (lv_ownedActualParameter_0_0= ruleTypeRefCS ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5152:1: ( (lv_ownedActualParameter_0_0= ruleTypeRefCS ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5152:1: ( (lv_ownedActualParameter_0_0= ruleTypeRefCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5153:1: (lv_ownedActualParameter_0_0= ruleTypeRefCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5153:1: (lv_ownedActualParameter_0_0= ruleTypeRefCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5154:3: lv_ownedActualParameter_0_0= ruleTypeRefCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTemplateParameterSubstitutionCSAccess().getOwnedActualParameterTypeRefCSParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeRefCS_in_ruleTemplateParameterSubstitutionCS11604);
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


    // $ANTLR start "entryRuleTemplateSignatureCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5178:1: entryRuleTemplateSignatureCS returns [EObject current=null] : iv_ruleTemplateSignatureCS= ruleTemplateSignatureCS EOF ;
    public final EObject entryRuleTemplateSignatureCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTemplateSignatureCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5179:2: (iv_ruleTemplateSignatureCS= ruleTemplateSignatureCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5180:2: iv_ruleTemplateSignatureCS= ruleTemplateSignatureCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTemplateSignatureCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTemplateSignatureCS_in_entryRuleTemplateSignatureCS11639);
            iv_ruleTemplateSignatureCS=ruleTemplateSignatureCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTemplateSignatureCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTemplateSignatureCS11649); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5187:1: ruleTemplateSignatureCS returns [EObject current=null] : (otherlv_0= '<' ( (lv_ownedParameters_1_0= ruleTypeParameterCS ) ) (otherlv_2= ',' ( (lv_ownedParameters_3_0= ruleTypeParameterCS ) ) )* otherlv_4= '>' ) ;
    public final EObject ruleTemplateSignatureCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_ownedParameters_1_0 = null;

        EObject lv_ownedParameters_3_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5190:28: ( (otherlv_0= '<' ( (lv_ownedParameters_1_0= ruleTypeParameterCS ) ) (otherlv_2= ',' ( (lv_ownedParameters_3_0= ruleTypeParameterCS ) ) )* otherlv_4= '>' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5191:1: (otherlv_0= '<' ( (lv_ownedParameters_1_0= ruleTypeParameterCS ) ) (otherlv_2= ',' ( (lv_ownedParameters_3_0= ruleTypeParameterCS ) ) )* otherlv_4= '>' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5191:1: (otherlv_0= '<' ( (lv_ownedParameters_1_0= ruleTypeParameterCS ) ) (otherlv_2= ',' ( (lv_ownedParameters_3_0= ruleTypeParameterCS ) ) )* otherlv_4= '>' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5191:3: otherlv_0= '<' ( (lv_ownedParameters_1_0= ruleTypeParameterCS ) ) (otherlv_2= ',' ( (lv_ownedParameters_3_0= ruleTypeParameterCS ) ) )* otherlv_4= '>'
            {
            otherlv_0=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleTemplateSignatureCS11686); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getTemplateSignatureCSAccess().getLessThanSignKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5195:1: ( (lv_ownedParameters_1_0= ruleTypeParameterCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5196:1: (lv_ownedParameters_1_0= ruleTypeParameterCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5196:1: (lv_ownedParameters_1_0= ruleTypeParameterCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5197:3: lv_ownedParameters_1_0= ruleTypeParameterCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTemplateSignatureCSAccess().getOwnedParametersTypeParameterCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeParameterCS_in_ruleTemplateSignatureCS11707);
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5213:2: (otherlv_2= ',' ( (lv_ownedParameters_3_0= ruleTypeParameterCS ) ) )*
            loop83:
            do {
                int alt83=2;
                int LA83_0 = input.LA(1);

                if ( (LA83_0==53) ) {
                    alt83=1;
                }


                switch (alt83) {
            	case 1 :
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5213:4: otherlv_2= ',' ( (lv_ownedParameters_3_0= ruleTypeParameterCS ) )
            	    {
            	    otherlv_2=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleTemplateSignatureCS11720); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getTemplateSignatureCSAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5217:1: ( (lv_ownedParameters_3_0= ruleTypeParameterCS ) )
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5218:1: (lv_ownedParameters_3_0= ruleTypeParameterCS )
            	    {
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5218:1: (lv_ownedParameters_3_0= ruleTypeParameterCS )
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5219:3: lv_ownedParameters_3_0= ruleTypeParameterCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTemplateSignatureCSAccess().getOwnedParametersTypeParameterCSParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleTypeParameterCS_in_ruleTemplateSignatureCS11741);
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
            	    break loop83;
                }
            } while (true);

            otherlv_4=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleTemplateSignatureCS11755); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5247:1: entryRuleTypeParameterCS returns [EObject current=null] : iv_ruleTypeParameterCS= ruleTypeParameterCS EOF ;
    public final EObject entryRuleTypeParameterCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeParameterCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5248:2: (iv_ruleTypeParameterCS= ruleTypeParameterCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5249:2: iv_ruleTypeParameterCS= ruleTypeParameterCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeParameterCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeParameterCS_in_entryRuleTypeParameterCS11791);
            iv_ruleTypeParameterCS=ruleTypeParameterCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeParameterCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeParameterCS11801); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5256:1: ruleTypeParameterCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleSimpleTypeDeclarationCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleSimpleTypeDeclarationCS ) ) )* )? ) ;
    public final EObject ruleTypeParameterCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedExtends_2_0 = null;

        EObject lv_ownedExtends_4_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5259:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleSimpleTypeDeclarationCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleSimpleTypeDeclarationCS ) ) )* )? ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5260:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleSimpleTypeDeclarationCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleSimpleTypeDeclarationCS ) ) )* )? )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5260:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleSimpleTypeDeclarationCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleSimpleTypeDeclarationCS ) ) )* )? )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5260:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleSimpleTypeDeclarationCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleSimpleTypeDeclarationCS ) ) )* )?
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5260:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5261:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5261:1: (lv_name_0_0= ruleUnrestrictedName )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5262:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypeParameterCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleTypeParameterCS11847);
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5278:2: (otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleSimpleTypeDeclarationCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleSimpleTypeDeclarationCS ) ) )* )?
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==82) ) {
                alt85=1;
            }
            switch (alt85) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5278:4: otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleSimpleTypeDeclarationCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleSimpleTypeDeclarationCS ) ) )*
                    {
                    otherlv_1=(Token)match(input,82,FollowSets000.FOLLOW_82_in_ruleTypeParameterCS11860); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getTypeParameterCSAccess().getExtendsKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5282:1: ( (lv_ownedExtends_2_0= ruleSimpleTypeDeclarationCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5283:1: (lv_ownedExtends_2_0= ruleSimpleTypeDeclarationCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5283:1: (lv_ownedExtends_2_0= ruleSimpleTypeDeclarationCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5284:3: lv_ownedExtends_2_0= ruleSimpleTypeDeclarationCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsSimpleTypeDeclarationCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSimpleTypeDeclarationCS_in_ruleTypeParameterCS11881);
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

                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5300:2: (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleSimpleTypeDeclarationCS ) ) )*
                    loop84:
                    do {
                        int alt84=2;
                        int LA84_0 = input.LA(1);

                        if ( (LA84_0==83) ) {
                            alt84=1;
                        }


                        switch (alt84) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5300:4: otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleSimpleTypeDeclarationCS ) )
                    	    {
                    	    otherlv_3=(Token)match(input,83,FollowSets000.FOLLOW_83_in_ruleTypeParameterCS11894); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getTypeParameterCSAccess().getAmpersandAmpersandKeyword_1_2_0());
                    	          
                    	    }
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5304:1: ( (lv_ownedExtends_4_0= ruleSimpleTypeDeclarationCS ) )
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5305:1: (lv_ownedExtends_4_0= ruleSimpleTypeDeclarationCS )
                    	    {
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5305:1: (lv_ownedExtends_4_0= ruleSimpleTypeDeclarationCS )
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5306:3: lv_ownedExtends_4_0= ruleSimpleTypeDeclarationCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsSimpleTypeDeclarationCSParserRuleCall_1_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleSimpleTypeDeclarationCS_in_ruleTypeParameterCS11915);
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
                    	    break loop84;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5330:1: entryRuleTypeRefCS returns [EObject current=null] : iv_ruleTypeRefCS= ruleTypeRefCS EOF ;
    public final EObject entryRuleTypeRefCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeRefCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5331:2: (iv_ruleTypeRefCS= ruleTypeRefCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5332:2: iv_ruleTypeRefCS= ruleTypeRefCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeRefCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeRefCS_in_entryRuleTypeRefCS11955);
            iv_ruleTypeRefCS=ruleTypeRefCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeRefCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeRefCS11965); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5339:1: ruleTypeRefCS returns [EObject current=null] : (this_SimpleTypeDeclarationCS_0= ruleSimpleTypeDeclarationCS | this_WildcardTypeRefCS_1= ruleWildcardTypeRefCS ) ;
    public final EObject ruleTypeRefCS() throws RecognitionException {
        EObject current = null;

        EObject this_SimpleTypeDeclarationCS_0 = null;

        EObject this_WildcardTypeRefCS_1 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5342:28: ( (this_SimpleTypeDeclarationCS_0= ruleSimpleTypeDeclarationCS | this_WildcardTypeRefCS_1= ruleWildcardTypeRefCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5343:1: (this_SimpleTypeDeclarationCS_0= ruleSimpleTypeDeclarationCS | this_WildcardTypeRefCS_1= ruleWildcardTypeRefCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5343:1: (this_SimpleTypeDeclarationCS_0= ruleSimpleTypeDeclarationCS | this_WildcardTypeRefCS_1= ruleWildcardTypeRefCS )
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( ((LA86_0>=RULE_SIMPLE_ID && LA86_0<=RULE_ESCAPED_ID)||(LA86_0>=35 && LA86_0<=49)) ) {
                alt86=1;
            }
            else if ( (LA86_0==80) ) {
                alt86=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 86, 0, input);

                throw nvae;
            }
            switch (alt86) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5344:2: this_SimpleTypeDeclarationCS_0= ruleSimpleTypeDeclarationCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeRefCSAccess().getSimpleTypeDeclarationCSParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSimpleTypeDeclarationCS_in_ruleTypeRefCS12015);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5357:2: this_WildcardTypeRefCS_1= ruleWildcardTypeRefCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeRefCSAccess().getWildcardTypeRefCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleWildcardTypeRefCS_in_ruleTypeRefCS12045);
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


    // $ANTLR start "entryRuleWildcardTypeRefCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5376:1: entryRuleWildcardTypeRefCS returns [EObject current=null] : iv_ruleWildcardTypeRefCS= ruleWildcardTypeRefCS EOF ;
    public final EObject entryRuleWildcardTypeRefCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWildcardTypeRefCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5377:2: (iv_ruleWildcardTypeRefCS= ruleWildcardTypeRefCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5378:2: iv_ruleWildcardTypeRefCS= ruleWildcardTypeRefCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getWildcardTypeRefCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleWildcardTypeRefCS_in_entryRuleWildcardTypeRefCS12080);
            iv_ruleWildcardTypeRefCS=ruleWildcardTypeRefCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleWildcardTypeRefCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleWildcardTypeRefCS12090); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5385:1: ruleWildcardTypeRefCS returns [EObject current=null] : ( () otherlv_1= '?' (otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleSimpleTypeDeclarationCS ) ) )? ) ;
    public final EObject ruleWildcardTypeRefCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_ownedExtends_3_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5388:28: ( ( () otherlv_1= '?' (otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleSimpleTypeDeclarationCS ) ) )? ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5389:1: ( () otherlv_1= '?' (otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleSimpleTypeDeclarationCS ) ) )? )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5389:1: ( () otherlv_1= '?' (otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleSimpleTypeDeclarationCS ) ) )? )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5389:2: () otherlv_1= '?' (otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleSimpleTypeDeclarationCS ) ) )?
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5389:2: ()
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5390:2: 
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

            otherlv_1=(Token)match(input,80,FollowSets000.FOLLOW_80_in_ruleWildcardTypeRefCS12139); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getWildcardTypeRefCSAccess().getQuestionMarkKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5402:1: (otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleSimpleTypeDeclarationCS ) ) )?
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==82) ) {
                alt87=1;
            }
            switch (alt87) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5402:3: otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleSimpleTypeDeclarationCS ) )
                    {
                    otherlv_2=(Token)match(input,82,FollowSets000.FOLLOW_82_in_ruleWildcardTypeRefCS12152); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getWildcardTypeRefCSAccess().getExtendsKeyword_2_0());
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5406:1: ( (lv_ownedExtends_3_0= ruleSimpleTypeDeclarationCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5407:1: (lv_ownedExtends_3_0= ruleSimpleTypeDeclarationCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5407:1: (lv_ownedExtends_3_0= ruleSimpleTypeDeclarationCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5408:3: lv_ownedExtends_3_0= ruleSimpleTypeDeclarationCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getWildcardTypeRefCSAccess().getOwnedExtendsSimpleTypeDeclarationCSParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSimpleTypeDeclarationCS_in_ruleWildcardTypeRefCS12173);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5432:1: entryRuleID returns [String current=null] : iv_ruleID= ruleID EOF ;
    public final String entryRuleID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleID = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5433:2: (iv_ruleID= ruleID EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5434:2: iv_ruleID= ruleID EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIDRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleID_in_entryRuleID12212);
            iv_ruleID=ruleID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleID.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleID12223); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5441:1: ruleID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_SIMPLE_ID_0= RULE_SIMPLE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID ) ;
    public final AntlrDatatypeRuleToken ruleID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_SIMPLE_ID_0=null;
        Token this_ESCAPED_ID_1=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5444:28: ( (this_SIMPLE_ID_0= RULE_SIMPLE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5445:1: (this_SIMPLE_ID_0= RULE_SIMPLE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5445:1: (this_SIMPLE_ID_0= RULE_SIMPLE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID )
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==RULE_SIMPLE_ID) ) {
                alt88=1;
            }
            else if ( (LA88_0==RULE_ESCAPED_ID) ) {
                alt88=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 88, 0, input);

                throw nvae;
            }
            switch (alt88) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5445:6: this_SIMPLE_ID_0= RULE_SIMPLE_ID
                    {
                    this_SIMPLE_ID_0=(Token)match(input,RULE_SIMPLE_ID,FollowSets000.FOLLOW_RULE_SIMPLE_ID_in_ruleID12263); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SIMPLE_ID_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SIMPLE_ID_0, grammarAccess.getIDAccess().getSIMPLE_IDTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5453:10: this_ESCAPED_ID_1= RULE_ESCAPED_ID
                    {
                    this_ESCAPED_ID_1=(Token)match(input,RULE_ESCAPED_ID,FollowSets000.FOLLOW_RULE_ESCAPED_ID_in_ruleID12289); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5468:1: entryRuleIdentifier returns [String current=null] : iv_ruleIdentifier= ruleIdentifier EOF ;
    public final String entryRuleIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdentifier = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5469:2: (iv_ruleIdentifier= ruleIdentifier EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5470:2: iv_ruleIdentifier= ruleIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIdentifierRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_entryRuleIdentifier12335);
            iv_ruleIdentifier=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIdentifier.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIdentifier12346); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5477:1: ruleIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= ruleID ;
    public final AntlrDatatypeRuleToken ruleIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_ID_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5480:28: (this_ID_0= ruleID )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5482:5: this_ID_0= ruleID
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getIdentifierAccess().getIDParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleID_in_ruleIdentifier12392);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5500:1: entryRuleLOWER returns [String current=null] : iv_ruleLOWER= ruleLOWER EOF ;
    public final String entryRuleLOWER() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLOWER = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5501:2: (iv_ruleLOWER= ruleLOWER EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5502:2: iv_ruleLOWER= ruleLOWER EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLOWERRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLOWER_in_entryRuleLOWER12437);
            iv_ruleLOWER=ruleLOWER();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLOWER.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLOWER12448); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5509:1: ruleLOWER returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INT_0= RULE_INT ;
    public final AntlrDatatypeRuleToken ruleLOWER() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5512:28: (this_INT_0= RULE_INT )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5513:5: this_INT_0= RULE_INT
            {
            this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleLOWER12487); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5528:1: entryRuleNUMBER_LITERAL returns [String current=null] : iv_ruleNUMBER_LITERAL= ruleNUMBER_LITERAL EOF ;
    public final String entryRuleNUMBER_LITERAL() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNUMBER_LITERAL = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5529:2: (iv_ruleNUMBER_LITERAL= ruleNUMBER_LITERAL EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5530:2: iv_ruleNUMBER_LITERAL= ruleNUMBER_LITERAL EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNUMBER_LITERALRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNUMBER_LITERAL_in_entryRuleNUMBER_LITERAL12532);
            iv_ruleNUMBER_LITERAL=ruleNUMBER_LITERAL();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNUMBER_LITERAL.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNUMBER_LITERAL12543); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5537:1: ruleNUMBER_LITERAL returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INT_0= RULE_INT ;
    public final AntlrDatatypeRuleToken ruleNUMBER_LITERAL() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5540:28: (this_INT_0= RULE_INT )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5541:5: this_INT_0= RULE_INT
            {
            this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleNUMBER_LITERAL12582); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5556:1: entryRuleStringLiteral returns [String current=null] : iv_ruleStringLiteral= ruleStringLiteral EOF ;
    public final String entryRuleStringLiteral() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleStringLiteral = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5557:2: (iv_ruleStringLiteral= ruleStringLiteral EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5558:2: iv_ruleStringLiteral= ruleStringLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStringLiteralRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral12627);
            iv_ruleStringLiteral=ruleStringLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStringLiteral.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleStringLiteral12638); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5565:1: ruleStringLiteral returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING ;
    public final AntlrDatatypeRuleToken ruleStringLiteral() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_SINGLE_QUOTED_STRING_0=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5568:28: (this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5569:5: this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING
            {
            this_SINGLE_QUOTED_STRING_0=(Token)match(input,RULE_SINGLE_QUOTED_STRING,FollowSets000.FOLLOW_RULE_SINGLE_QUOTED_STRING_in_ruleStringLiteral12677); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5584:1: entryRuleUPPER returns [String current=null] : iv_ruleUPPER= ruleUPPER EOF ;
    public final String entryRuleUPPER() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUPPER = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5585:2: (iv_ruleUPPER= ruleUPPER EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5586:2: iv_ruleUPPER= ruleUPPER EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUPPERRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUPPER_in_entryRuleUPPER12722);
            iv_ruleUPPER=ruleUPPER();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUPPER.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUPPER12733); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5593:1: ruleUPPER returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT | kw= '*' ) ;
    public final AntlrDatatypeRuleToken ruleUPPER() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5596:28: ( (this_INT_0= RULE_INT | kw= '*' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5597:1: (this_INT_0= RULE_INT | kw= '*' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5597:1: (this_INT_0= RULE_INT | kw= '*' )
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( (LA89_0==RULE_INT) ) {
                alt89=1;
            }
            else if ( (LA89_0==18) ) {
                alt89=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 89, 0, input);

                throw nvae;
            }
            switch (alt89) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5597:6: this_INT_0= RULE_INT
                    {
                    this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleUPPER12773); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_INT_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_INT_0, grammarAccess.getUPPERAccess().getINTTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5606:2: kw= '*'
                    {
                    kw=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleUPPER12797); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5619:1: entryRuleURI returns [String current=null] : iv_ruleURI= ruleURI EOF ;
    public final String entryRuleURI() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleURI = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5620:2: (iv_ruleURI= ruleURI EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5621:2: iv_ruleURI= ruleURI EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getURIRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleURI_in_entryRuleURI12838);
            iv_ruleURI=ruleURI();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleURI.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleURI12849); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5628:1: ruleURI returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING ;
    public final AntlrDatatypeRuleToken ruleURI() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_SINGLE_QUOTED_STRING_0=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5631:28: (this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5632:5: this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING
            {
            this_SINGLE_QUOTED_STRING_0=(Token)match(input,RULE_SINGLE_QUOTED_STRING,FollowSets000.FOLLOW_RULE_SINGLE_QUOTED_STRING_in_ruleURI12888); if (state.failed) return current;
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

    // $ANTLR start synpred78_InternalEssentialOCL
    public final void synpred78_InternalEssentialOCL_fragment() throws RecognitionException {   
        EObject this_TypeLiteralWithMultiplicityCS_1 = null;


        // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2881:2: (this_TypeLiteralWithMultiplicityCS_1= ruleTypeLiteralWithMultiplicityCS )
        // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2881:2: this_TypeLiteralWithMultiplicityCS_1= ruleTypeLiteralWithMultiplicityCS
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralWithMultiplicityCS_in_synpred78_InternalEssentialOCL6839);
        this_TypeLiteralWithMultiplicityCS_1=ruleTypeLiteralWithMultiplicityCS();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred78_InternalEssentialOCL

    // $ANTLR start synpred80_InternalEssentialOCL
    public final void synpred80_InternalEssentialOCL_fragment() throws RecognitionException {   
        EObject this_PrefixedPrimaryExpCS_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_ownedRight_3_0 = null;


        // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2926:2: ( (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? ) )
        // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2926:2: (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? )
        {
        // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2926:2: (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? )
        // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2927:2: this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )?
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_rulePrefixedPrimaryExpCS_in_synpred80_InternalEssentialOCL6965);
        this_PrefixedPrimaryExpCS_0=rulePrefixedPrimaryExpCS();

        state._fsp--;
        if (state.failed) return ;
        // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2938:1: ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )?
        int alt99=2;
        int LA99_0 = input.LA(1);

        if ( (LA99_0==16||(LA99_0>=18 && LA99_0<=34)) ) {
            alt99=1;
        }
        switch (alt99) {
            case 1 :
                // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2938:2: () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) )
                {
                // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2938:2: ()
                // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2939:2: 
                {
                if ( state.backtracking==0 ) {
                   
                  	  /* */ 
                  	
                }

                }

                // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2947:2: ( (lv_name_2_0= ruleBinaryOperatorName ) )
                // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2948:1: (lv_name_2_0= ruleBinaryOperatorName )
                {
                // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2948:1: (lv_name_2_0= ruleBinaryOperatorName )
                // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2949:3: lv_name_2_0= ruleBinaryOperatorName
                {
                if ( state.backtracking==0 ) {
                   
                  	        newCompositeNode(grammarAccess.getExpCSAccess().getNameBinaryOperatorNameParserRuleCall_0_1_1_0()); 
                  	    
                }
                pushFollow(FollowSets000.FOLLOW_ruleBinaryOperatorName_in_synpred80_InternalEssentialOCL6998);
                lv_name_2_0=ruleBinaryOperatorName();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2965:2: ( (lv_ownedRight_3_0= ruleExpCS ) )
                // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2966:1: (lv_ownedRight_3_0= ruleExpCS )
                {
                // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2966:1: (lv_ownedRight_3_0= ruleExpCS )
                // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2967:3: lv_ownedRight_3_0= ruleExpCS
                {
                if ( state.backtracking==0 ) {
                   
                  	        newCompositeNode(grammarAccess.getExpCSAccess().getOwnedRightExpCSParserRuleCall_0_1_2_0()); 
                  	    
                }
                pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_synpred80_InternalEssentialOCL7019);
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
    // $ANTLR end synpred80_InternalEssentialOCL

    // $ANTLR start synpred87_InternalEssentialOCL
    public final void synpred87_InternalEssentialOCL_fragment() throws RecognitionException {   
        EObject this_TupleLiteralExpCS_4 = null;


        // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3228:2: (this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS )
        // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3228:2: this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralExpCS_in_synpred87_InternalEssentialOCL7582);
        this_TupleLiteralExpCS_4=ruleTupleLiteralExpCS();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred87_InternalEssentialOCL

    // $ANTLR start synpred88_InternalEssentialOCL
    public final void synpred88_InternalEssentialOCL_fragment() throws RecognitionException {   
        EObject this_MapLiteralExpCS_5 = null;


        // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3241:2: (this_MapLiteralExpCS_5= ruleMapLiteralExpCS )
        // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3241:2: this_MapLiteralExpCS_5= ruleMapLiteralExpCS
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleMapLiteralExpCS_in_synpred88_InternalEssentialOCL7612);
        this_MapLiteralExpCS_5=ruleMapLiteralExpCS();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred88_InternalEssentialOCL

    // $ANTLR start synpred89_InternalEssentialOCL
    public final void synpred89_InternalEssentialOCL_fragment() throws RecognitionException {   
        EObject this_CollectionLiteralExpCS_6 = null;


        // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3254:2: (this_CollectionLiteralExpCS_6= ruleCollectionLiteralExpCS )
        // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3254:2: this_CollectionLiteralExpCS_6= ruleCollectionLiteralExpCS
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteralExpCS_in_synpred89_InternalEssentialOCL7642);
        this_CollectionLiteralExpCS_6=ruleCollectionLiteralExpCS();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred89_InternalEssentialOCL

    // $ANTLR start synpred90_InternalEssentialOCL
    public final void synpred90_InternalEssentialOCL_fragment() throws RecognitionException {   
        EObject this_LambdaLiteralExpCS_7 = null;


        // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3267:2: (this_LambdaLiteralExpCS_7= ruleLambdaLiteralExpCS )
        // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3267:2: this_LambdaLiteralExpCS_7= ruleLambdaLiteralExpCS
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleLambdaLiteralExpCS_in_synpred90_InternalEssentialOCL7672);
        this_LambdaLiteralExpCS_7=ruleLambdaLiteralExpCS();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred90_InternalEssentialOCL

    // $ANTLR start synpred91_InternalEssentialOCL
    public final void synpred91_InternalEssentialOCL_fragment() throws RecognitionException {   
        EObject this_TypeLiteralExpCS_8 = null;


        // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3280:2: (this_TypeLiteralExpCS_8= ruleTypeLiteralExpCS )
        // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3280:2: this_TypeLiteralExpCS_8= ruleTypeLiteralExpCS
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralExpCS_in_synpred91_InternalEssentialOCL7702);
        this_TypeLiteralExpCS_8=ruleTypeLiteralExpCS();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred91_InternalEssentialOCL

    // Delegated rules

    public final boolean synpred88_InternalEssentialOCL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred88_InternalEssentialOCL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
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
    public final boolean synpred89_InternalEssentialOCL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred89_InternalEssentialOCL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred87_InternalEssentialOCL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred87_InternalEssentialOCL_fragment(); // can never throw exception
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


    protected DFA43 dfa43 = new DFA43(this);
    protected DFA45 dfa45 = new DFA45(this);
    protected DFA48 dfa48 = new DFA48(this);
    static final String DFA43_eotS =
        "\24\uffff";
    static final String DFA43_eofS =
        "\24\uffff";
    static final String DFA43_minS =
        "\1\4\2\uffff\5\0\14\uffff";
    static final String DFA43_maxS =
        "\1\64\2\uffff\5\0\14\uffff";
    static final String DFA43_acceptS =
        "\1\uffff\1\1\6\uffff\1\2\12\uffff\1\3";
    static final String DFA43_specialS =
        "\3\uffff\1\0\1\1\1\2\1\3\1\4\14\uffff}>";
    static final String[] DFA43_transitionS = {
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

    static final short[] DFA43_eot = DFA.unpackEncodedString(DFA43_eotS);
    static final short[] DFA43_eof = DFA.unpackEncodedString(DFA43_eofS);
    static final char[] DFA43_min = DFA.unpackEncodedStringToUnsignedChars(DFA43_minS);
    static final char[] DFA43_max = DFA.unpackEncodedStringToUnsignedChars(DFA43_maxS);
    static final short[] DFA43_accept = DFA.unpackEncodedString(DFA43_acceptS);
    static final short[] DFA43_special = DFA.unpackEncodedString(DFA43_specialS);
    static final short[][] DFA43_transition;

    static {
        int numStates = DFA43_transitionS.length;
        DFA43_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA43_transition[i] = DFA.unpackEncodedString(DFA43_transitionS[i]);
        }
    }

    class DFA43 extends DFA {

        public DFA43(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 43;
            this.eot = DFA43_eot;
            this.eof = DFA43_eof;
            this.min = DFA43_min;
            this.max = DFA43_max;
            this.accept = DFA43_accept;
            this.special = DFA43_special;
            this.transition = DFA43_transition;
        }
        public String getDescription() {
            return "2867:1: (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralWithMultiplicityCS_1= ruleTypeLiteralWithMultiplicityCS | this_CollectionPatternCS_2= ruleCollectionPatternCS )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA43_3 = input.LA(1);

                         
                        int index43_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred78_InternalEssentialOCL()) ) {s = 8;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index43_3);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA43_4 = input.LA(1);

                         
                        int index43_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred78_InternalEssentialOCL()) ) {s = 8;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index43_4);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA43_5 = input.LA(1);

                         
                        int index43_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred78_InternalEssentialOCL()) ) {s = 8;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index43_5);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA43_6 = input.LA(1);

                         
                        int index43_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred78_InternalEssentialOCL()) ) {s = 8;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index43_6);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA43_7 = input.LA(1);

                         
                        int index43_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred78_InternalEssentialOCL()) ) {s = 8;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index43_7);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 43, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA45_eotS =
        "\40\uffff";
    static final String DFA45_eofS =
        "\40\uffff";
    static final String DFA45_minS =
        "\1\4\2\0\35\uffff";
    static final String DFA45_maxS =
        "\1\115\2\0\35\uffff";
    static final String DFA45_acceptS =
        "\3\uffff\1\1\33\uffff\1\2";
    static final String DFA45_specialS =
        "\1\uffff\1\0\1\1\35\uffff}>";
    static final String[] DFA45_transitionS = {
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

    static final short[] DFA45_eot = DFA.unpackEncodedString(DFA45_eotS);
    static final short[] DFA45_eof = DFA.unpackEncodedString(DFA45_eofS);
    static final char[] DFA45_min = DFA.unpackEncodedStringToUnsignedChars(DFA45_minS);
    static final char[] DFA45_max = DFA.unpackEncodedStringToUnsignedChars(DFA45_maxS);
    static final short[] DFA45_accept = DFA.unpackEncodedString(DFA45_acceptS);
    static final short[] DFA45_special = DFA.unpackEncodedString(DFA45_specialS);
    static final short[][] DFA45_transition;

    static {
        int numStates = DFA45_transitionS.length;
        DFA45_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA45_transition[i] = DFA.unpackEncodedString(DFA45_transitionS[i]);
        }
    }

    class DFA45 extends DFA {

        public DFA45(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 45;
            this.eot = DFA45_eot;
            this.eof = DFA45_eof;
            this.min = DFA45_min;
            this.max = DFA45_max;
            this.accept = DFA45_accept;
            this.special = DFA45_special;
            this.transition = DFA45_transition;
        }
        public String getDescription() {
            return "2926:1: ( (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? ) | this_PrefixedLetExpCS_4= rulePrefixedLetExpCS )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA45_1 = input.LA(1);

                         
                        int index45_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred80_InternalEssentialOCL()) ) {s = 3;}

                        else if ( (true) ) {s = 31;}

                         
                        input.seek(index45_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA45_2 = input.LA(1);

                         
                        int index45_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred80_InternalEssentialOCL()) ) {s = 3;}

                        else if ( (true) ) {s = 31;}

                         
                        input.seek(index45_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 45, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA48_eotS =
        "\41\uffff";
    static final String DFA48_eofS =
        "\41\uffff";
    static final String DFA48_minS =
        "\1\4\12\uffff\10\0\16\uffff";
    static final String DFA48_maxS =
        "\1\115\12\uffff\10\0\16\uffff";
    static final String DFA48_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\16\uffff\1\11\7\uffff\1\12\1\uffff\1\5"+
        "\1\6\1\7\1\10";
    static final String DFA48_specialS =
        "\13\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\16\uffff}>";
    static final String[] DFA48_transitionS = {
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
            return "3175:1: (this_NestedExpCS_0= ruleNestedExpCS | this_IfExpCS_1= ruleIfExpCS | this_SelfExpCS_2= ruleSelfExpCS | this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS | this_MapLiteralExpCS_5= ruleMapLiteralExpCS | this_CollectionLiteralExpCS_6= ruleCollectionLiteralExpCS | this_LambdaLiteralExpCS_7= ruleLambdaLiteralExpCS | this_TypeLiteralExpCS_8= ruleTypeLiteralExpCS | this_NameExpCS_9= ruleNameExpCS )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA48_11 = input.LA(1);

                         
                        int index48_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalEssentialOCL()) ) {s = 29;}

                        else if ( (synpred91_InternalEssentialOCL()) ) {s = 19;}

                         
                        input.seek(index48_11);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA48_12 = input.LA(1);

                         
                        int index48_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalEssentialOCL()) ) {s = 30;}

                        else if ( (synpred91_InternalEssentialOCL()) ) {s = 19;}

                         
                        input.seek(index48_12);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA48_13 = input.LA(1);

                         
                        int index48_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred89_InternalEssentialOCL()) ) {s = 31;}

                        else if ( (synpred91_InternalEssentialOCL()) ) {s = 19;}

                         
                        input.seek(index48_13);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA48_14 = input.LA(1);

                         
                        int index48_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred89_InternalEssentialOCL()) ) {s = 31;}

                        else if ( (synpred91_InternalEssentialOCL()) ) {s = 19;}

                         
                        input.seek(index48_14);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA48_15 = input.LA(1);

                         
                        int index48_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred89_InternalEssentialOCL()) ) {s = 31;}

                        else if ( (synpred91_InternalEssentialOCL()) ) {s = 19;}

                         
                        input.seek(index48_15);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA48_16 = input.LA(1);

                         
                        int index48_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred89_InternalEssentialOCL()) ) {s = 31;}

                        else if ( (synpred91_InternalEssentialOCL()) ) {s = 19;}

                         
                        input.seek(index48_16);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA48_17 = input.LA(1);

                         
                        int index48_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred89_InternalEssentialOCL()) ) {s = 31;}

                        else if ( (synpred91_InternalEssentialOCL()) ) {s = 19;}

                         
                        input.seek(index48_17);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA48_18 = input.LA(1);

                         
                        int index48_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred90_InternalEssentialOCL()) ) {s = 32;}

                        else if ( (synpred91_InternalEssentialOCL()) ) {s = 19;}

                         
                        input.seek(index48_18);
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
        public static final BitSet FOLLOW_ruleFullTypeDeclarationCS_in_ruleCollectionTypeCS2439 = new BitSet(new long[]{0x0008000000000000L});
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
        public static final BitSet FOLLOW_ruleFullTypeDeclarationCS_in_ruleLambdaTypeCS2728 = new BitSet(new long[]{0x0028000000000000L});
        public static final BitSet FOLLOW_53_in_ruleLambdaTypeCS2741 = new BitSet(new long[]{0x0013FFF800000030L});
        public static final BitSet FOLLOW_ruleFullTypeDeclarationCS_in_ruleLambdaTypeCS2762 = new BitSet(new long[]{0x0028000000000000L});
        public static final BitSet FOLLOW_51_in_ruleLambdaTypeCS2778 = new BitSet(new long[]{0x0040000000000000L});
        public static final BitSet FOLLOW_54_in_ruleLambdaTypeCS2790 = new BitSet(new long[]{0x0013FFF800000030L});
        public static final BitSet FOLLOW_ruleFullTypeDeclarationCS_in_ruleLambdaTypeCS2811 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMapTypeCS_in_entryRuleMapTypeCS2847 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMapTypeCS2857 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_ruleMapTypeCS2900 = new BitSet(new long[]{0x0004000000000002L});
        public static final BitSet FOLLOW_50_in_ruleMapTypeCS2926 = new BitSet(new long[]{0x0013FFF800000030L});
        public static final BitSet FOLLOW_ruleFullTypeDeclarationCS_in_ruleMapTypeCS2947 = new BitSet(new long[]{0x0020000000000000L});
        public static final BitSet FOLLOW_53_in_ruleMapTypeCS2959 = new BitSet(new long[]{0x0013FFF800000030L});
        public static final BitSet FOLLOW_ruleFullTypeDeclarationCS_in_ruleMapTypeCS2980 = new BitSet(new long[]{0x0008000000000000L});
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
        public static final BitSet FOLLOW_ruleFullTypeDeclarationCS_in_ruleTuplePartCS3308 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimpleTypeDeclarationCS_in_entryRuleSimpleTypeDeclarationCS3344 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSimpleTypeDeclarationCS3354 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralCS_in_ruleSimpleTypeDeclarationCS3404 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePathTypeCS_in_ruleSimpleTypeDeclarationCS3434 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFullTypeDeclarationCS_in_entryRuleFullTypeDeclarationCS3469 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFullTypeDeclarationCS3479 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralWithMultiplicityCS_in_ruleFullTypeDeclarationCS3529 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePathTypeCS_in_ruleFullTypeDeclarationCS3560 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
        public static final BitSet FOLLOW_ruleMultiplicityCS_in_ruleFullTypeDeclarationCS3580 = new BitSet(new long[]{0x0000000000000002L});
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
        public static final BitSet FOLLOW_52_in_ruleLambdaLiteralExpCS4490 = new BitSet(new long[]{0x0080000000000000L});
        public static final BitSet FOLLOW_55_in_ruleLambdaLiteralExpCS4502 = new BitSet(new long[]{0xF017FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleLambdaLiteralExpCS4523 = new BitSet(new long[]{0x0100000000000000L});
        public static final BitSet FOLLOW_56_in_ruleLambdaLiteralExpCS4535 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMapLiteralExpCS_in_entryRuleMapLiteralExpCS4571 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMapLiteralExpCS4581 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMapTypeCS_in_ruleMapLiteralExpCS4627 = new BitSet(new long[]{0x0080000000000000L});
        public static final BitSet FOLLOW_55_in_ruleMapLiteralExpCS4639 = new BitSet(new long[]{0xF117FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleMapLiteralPartCS_in_ruleMapLiteralExpCS4661 = new BitSet(new long[]{0x0120000000000000L});
        public static final BitSet FOLLOW_53_in_ruleMapLiteralExpCS4674 = new BitSet(new long[]{0xF017FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleMapLiteralPartCS_in_ruleMapLiteralExpCS4695 = new BitSet(new long[]{0x0120000000000000L});
        public static final BitSet FOLLOW_56_in_ruleMapLiteralExpCS4711 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMapLiteralPartCS_in_entryRuleMapLiteralPartCS4747 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMapLiteralPartCS4757 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleMapLiteralPartCS4803 = new BitSet(new long[]{0x0800000000000000L});
        public static final BitSet FOLLOW_59_in_ruleMapLiteralPartCS4815 = new BitSet(new long[]{0xF017FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleMapLiteralPartCS4836 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveLiteralExpCS_in_entryRulePrimitiveLiteralExpCS4872 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrimitiveLiteralExpCS4882 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNumberLiteralExpCS_in_rulePrimitiveLiteralExpCS4932 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringLiteralExpCS_in_rulePrimitiveLiteralExpCS4962 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBooleanLiteralExpCS_in_rulePrimitiveLiteralExpCS4992 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnlimitedNaturalLiteralExpCS_in_rulePrimitiveLiteralExpCS5022 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInvalidLiteralExpCS_in_rulePrimitiveLiteralExpCS5052 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNullLiteralExpCS_in_rulePrimitiveLiteralExpCS5082 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTupleLiteralExpCS_in_entryRuleTupleLiteralExpCS5117 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTupleLiteralExpCS5127 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_ruleTupleLiteralExpCS5164 = new BitSet(new long[]{0x0080000000000000L});
        public static final BitSet FOLLOW_55_in_ruleTupleLiteralExpCS5176 = new BitSet(new long[]{0x0013FFF800000030L});
        public static final BitSet FOLLOW_ruleTupleLiteralPartCS_in_ruleTupleLiteralExpCS5197 = new BitSet(new long[]{0x0120000000000000L});
        public static final BitSet FOLLOW_53_in_ruleTupleLiteralExpCS5210 = new BitSet(new long[]{0x0013FFF800000030L});
        public static final BitSet FOLLOW_ruleTupleLiteralPartCS_in_ruleTupleLiteralExpCS5231 = new BitSet(new long[]{0x0120000000000000L});
        public static final BitSet FOLLOW_56_in_ruleTupleLiteralExpCS5245 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTupleLiteralPartCS_in_entryRuleTupleLiteralPartCS5281 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTupleLiteralPartCS5291 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleTupleLiteralPartCS5337 = new BitSet(new long[]{0x0040000002000000L});
        public static final BitSet FOLLOW_54_in_ruleTupleLiteralPartCS5350 = new BitSet(new long[]{0x0013FFF800000030L});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleTupleLiteralPartCS5371 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_25_in_ruleTupleLiteralPartCS5385 = new BitSet(new long[]{0xF017FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleTupleLiteralPartCS5406 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNumberLiteralExpCS_in_entryRuleNumberLiteralExpCS5442 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNumberLiteralExpCS5452 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNUMBER_LITERAL_in_ruleNumberLiteralExpCS5497 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringLiteralExpCS_in_entryRuleStringLiteralExpCS5532 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteralExpCS5542 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringLiteral_in_ruleStringLiteralExpCS5587 = new BitSet(new long[]{0x0000000000000082L});
        public static final BitSet FOLLOW_ruleBooleanLiteralExpCS_in_entryRuleBooleanLiteralExpCS5623 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBooleanLiteralExpCS5633 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_60_in_ruleBooleanLiteralExpCS5676 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_61_in_ruleBooleanLiteralExpCS5713 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnlimitedNaturalLiteralExpCS_in_entryRuleUnlimitedNaturalLiteralExpCS5762 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnlimitedNaturalLiteralExpCS5772 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleUnlimitedNaturalLiteralExpCS5821 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInvalidLiteralExpCS_in_entryRuleInvalidLiteralExpCS5857 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleInvalidLiteralExpCS5867 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_62_in_ruleInvalidLiteralExpCS5916 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNullLiteralExpCS_in_entryRuleNullLiteralExpCS5952 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNullLiteralExpCS5962 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_63_in_ruleNullLiteralExpCS6011 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralCS_in_entryRuleTypeLiteralCS6047 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeLiteralCS6057 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveTypeCS_in_ruleTypeLiteralCS6107 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionTypeCS_in_ruleTypeLiteralCS6137 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMapTypeCS_in_ruleTypeLiteralCS6167 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTupleTypeCS_in_ruleTypeLiteralCS6197 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralWithMultiplicityCS_in_entryRuleTypeLiteralWithMultiplicityCS6232 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeLiteralWithMultiplicityCS6242 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionTypeWithMultiplicityCS_in_ruleTypeLiteralWithMultiplicityCS6292 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLambdaTypeCS_in_ruleTypeLiteralWithMultiplicityCS6322 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveTypeCS_in_ruleTypeLiteralWithMultiplicityCS6354 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
        public static final BitSet FOLLOW_ruleMapTypeCS_in_ruleTypeLiteralWithMultiplicityCS6384 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
        public static final BitSet FOLLOW_ruleTupleTypeCS_in_ruleTypeLiteralWithMultiplicityCS6414 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
        public static final BitSet FOLLOW_ruleMultiplicityCS_in_ruleTypeLiteralWithMultiplicityCS6435 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralExpCS_in_entryRuleTypeLiteralExpCS6473 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeLiteralExpCS6483 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralWithMultiplicityCS_in_ruleTypeLiteralExpCS6528 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeNameExpCS_in_entryRuleTypeNameExpCS6563 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeNameExpCS6573 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePathNameCS_in_ruleTypeNameExpCS6619 = new BitSet(new long[]{0x0080000000000002L,0x0000000000000004L});
        public static final BitSet FOLLOW_ruleCurlyBracketedClauseCS_in_ruleTypeNameExpCS6641 = new BitSet(new long[]{0x0080000000000002L,0x0000000000000004L});
        public static final BitSet FOLLOW_55_in_ruleTypeNameExpCS6654 = new BitSet(new long[]{0xF017FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleTypeNameExpCS6675 = new BitSet(new long[]{0x0100000000000000L});
        public static final BitSet FOLLOW_56_in_ruleTypeNameExpCS6687 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
        public static final BitSet FOLLOW_ruleMultiplicityCS_in_ruleTypeNameExpCS6712 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_entryRuleTypeExpCS6749 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeExpCS6759 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeNameExpCS_in_ruleTypeExpCS6809 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralWithMultiplicityCS_in_ruleTypeExpCS6839 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionPatternCS_in_ruleTypeExpCS6869 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpCS_in_entryRuleExpCS6904 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleExpCS6914 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrefixedPrimaryExpCS_in_ruleExpCS6965 = new BitSet(new long[]{0x00000007FFFD0002L});
        public static final BitSet FOLLOW_ruleBinaryOperatorName_in_ruleExpCS6998 = new BitSet(new long[]{0xF017FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleExpCS7019 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrefixedLetExpCS_in_ruleExpCS7053 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrefixedLetExpCS_in_entryRulePrefixedLetExpCS7088 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrefixedLetExpCS7098 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnaryOperatorName_in_rulePrefixedLetExpCS7157 = new BitSet(new long[]{0xF017FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_rulePrefixedLetExpCS_in_rulePrefixedLetExpCS7178 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLetExpCS_in_rulePrefixedLetExpCS7210 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrefixedPrimaryExpCS_in_entryRulePrefixedPrimaryExpCS7245 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrefixedPrimaryExpCS7255 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnaryOperatorName_in_rulePrefixedPrimaryExpCS7314 = new BitSet(new long[]{0xF017FFF8000700F0L,0x0000000000002080L});
        public static final BitSet FOLLOW_rulePrefixedPrimaryExpCS_in_rulePrefixedPrimaryExpCS7335 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimaryExpCS_in_rulePrefixedPrimaryExpCS7367 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimaryExpCS_in_entryRulePrimaryExpCS7402 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpCS7412 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedExpCS_in_rulePrimaryExpCS7462 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIfExpCS_in_rulePrimaryExpCS7492 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSelfExpCS_in_rulePrimaryExpCS7522 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveLiteralExpCS_in_rulePrimaryExpCS7552 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTupleLiteralExpCS_in_rulePrimaryExpCS7582 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMapLiteralExpCS_in_rulePrimaryExpCS7612 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionLiteralExpCS_in_rulePrimaryExpCS7642 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLambdaLiteralExpCS_in_rulePrimaryExpCS7672 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralExpCS_in_rulePrimaryExpCS7702 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNameExpCS_in_rulePrimaryExpCS7732 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNameExpCS_in_entryRuleNameExpCS7767 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNameExpCS7777 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePathNameCS_in_ruleNameExpCS7823 = new BitSet(new long[]{0x0084000000000002L,0x0000000000000005L});
        public static final BitSet FOLLOW_ruleSquareBracketedClauseCS_in_ruleNameExpCS7844 = new BitSet(new long[]{0x0084000000000002L,0x0000000000000005L});
        public static final BitSet FOLLOW_ruleRoundBracketedClauseCS_in_ruleNameExpCS7866 = new BitSet(new long[]{0x0080000000000002L,0x0000000000000001L});
        public static final BitSet FOLLOW_ruleCurlyBracketedClauseCS_in_ruleNameExpCS7888 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
        public static final BitSet FOLLOW_64_in_ruleNameExpCS7908 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
        public static final BitSet FOLLOW_65_in_ruleNameExpCS7933 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCurlyBracketedClauseCS_in_entryRuleCurlyBracketedClauseCS7971 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCurlyBracketedClauseCS7981 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_55_in_ruleCurlyBracketedClauseCS8030 = new BitSet(new long[]{0x0113FFF8000000B0L});
        public static final BitSet FOLLOW_ruleStringLiteral_in_ruleCurlyBracketedClauseCS8052 = new BitSet(new long[]{0x0100000000000000L});
        public static final BitSet FOLLOW_ruleShadowPartCS_in_ruleCurlyBracketedClauseCS8080 = new BitSet(new long[]{0x0120000000000000L});
        public static final BitSet FOLLOW_53_in_ruleCurlyBracketedClauseCS8093 = new BitSet(new long[]{0x0013FFF800000030L});
        public static final BitSet FOLLOW_ruleShadowPartCS_in_ruleCurlyBracketedClauseCS8114 = new BitSet(new long[]{0x0120000000000000L});
        public static final BitSet FOLLOW_56_in_ruleCurlyBracketedClauseCS8131 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRoundBracketedClauseCS_in_entryRuleRoundBracketedClauseCS8167 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRoundBracketedClauseCS8177 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_50_in_ruleRoundBracketedClauseCS8226 = new BitSet(new long[]{0xF05FFFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleNavigatingArgCS_in_ruleRoundBracketedClauseCS8248 = new BitSet(new long[]{0x0028000000000000L,0x0000000000000060L});
        public static final BitSet FOLLOW_ruleNavigatingCommaArgCS_in_ruleRoundBracketedClauseCS8269 = new BitSet(new long[]{0x0028000000000000L,0x0000000000000060L});
        public static final BitSet FOLLOW_ruleNavigatingSemiArgCS_in_ruleRoundBracketedClauseCS8292 = new BitSet(new long[]{0x0028000000000000L,0x0000000000000020L});
        public static final BitSet FOLLOW_ruleNavigatingCommaArgCS_in_ruleRoundBracketedClauseCS8313 = new BitSet(new long[]{0x0028000000000000L,0x0000000000000020L});
        public static final BitSet FOLLOW_ruleNavigatingBarArgCS_in_ruleRoundBracketedClauseCS8338 = new BitSet(new long[]{0x0028000000000000L,0x0000000000000020L});
        public static final BitSet FOLLOW_ruleNavigatingCommaArgCS_in_ruleRoundBracketedClauseCS8359 = new BitSet(new long[]{0x0028000000000000L,0x0000000000000020L});
        public static final BitSet FOLLOW_51_in_ruleRoundBracketedClauseCS8376 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSquareBracketedClauseCS_in_entryRuleSquareBracketedClauseCS8412 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSquareBracketedClauseCS8422 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_66_in_ruleSquareBracketedClauseCS8459 = new BitSet(new long[]{0xF017FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleSquareBracketedClauseCS8480 = new BitSet(new long[]{0x0020000000000000L,0x0000000000000008L});
        public static final BitSet FOLLOW_53_in_ruleSquareBracketedClauseCS8493 = new BitSet(new long[]{0xF017FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleSquareBracketedClauseCS8514 = new BitSet(new long[]{0x0020000000000000L,0x0000000000000008L});
        public static final BitSet FOLLOW_67_in_ruleSquareBracketedClauseCS8528 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingArgCS_in_entryRuleNavigatingArgCS8564 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigatingArgCS8574 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingArgCS8621 = new BitSet(new long[]{0x0040000000000002L,0x0000000000000010L});
        public static final BitSet FOLLOW_54_in_ruleNavigatingArgCS8635 = new BitSet(new long[]{0x0013FFF800000030L});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleNavigatingArgCS8656 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_25_in_ruleNavigatingArgCS8669 = new BitSet(new long[]{0xF017FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNavigatingArgCS8690 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_68_in_ruleNavigatingArgCS8712 = new BitSet(new long[]{0xF017FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNavigatingArgCS8733 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_54_in_ruleNavigatingArgCS8756 = new BitSet(new long[]{0x0013FFF800000030L});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleNavigatingArgCS8777 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingBarArgCS_in_entryRuleNavigatingBarArgCS8814 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigatingBarArgCS8824 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_69_in_ruleNavigatingBarArgCS8867 = new BitSet(new long[]{0xF017FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingBarArgCS8901 = new BitSet(new long[]{0x0040000000000002L});
        public static final BitSet FOLLOW_54_in_ruleNavigatingBarArgCS8914 = new BitSet(new long[]{0x0013FFF800000030L});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleNavigatingBarArgCS8935 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_25_in_ruleNavigatingBarArgCS8948 = new BitSet(new long[]{0xF017FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNavigatingBarArgCS8969 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingCommaArgCS_in_entryRuleNavigatingCommaArgCS9009 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigatingCommaArgCS9019 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_53_in_ruleNavigatingCommaArgCS9062 = new BitSet(new long[]{0xF017FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingCommaArgCS9096 = new BitSet(new long[]{0x0040000000000002L,0x0000000000000010L});
        public static final BitSet FOLLOW_54_in_ruleNavigatingCommaArgCS9110 = new BitSet(new long[]{0x0013FFF800000030L});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleNavigatingCommaArgCS9131 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_25_in_ruleNavigatingCommaArgCS9144 = new BitSet(new long[]{0xF017FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNavigatingCommaArgCS9165 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_68_in_ruleNavigatingCommaArgCS9187 = new BitSet(new long[]{0xF017FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNavigatingCommaArgCS9208 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingSemiArgCS_in_entryRuleNavigatingSemiArgCS9247 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigatingSemiArgCS9257 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_70_in_ruleNavigatingSemiArgCS9300 = new BitSet(new long[]{0xF017FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingSemiArgCS9334 = new BitSet(new long[]{0x0040000000000002L});
        public static final BitSet FOLLOW_54_in_ruleNavigatingSemiArgCS9347 = new BitSet(new long[]{0x0013FFF800000030L});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleNavigatingSemiArgCS9368 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_25_in_ruleNavigatingSemiArgCS9381 = new BitSet(new long[]{0xF017FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNavigatingSemiArgCS9402 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingArgExpCS_in_entryRuleNavigatingArgExpCS9442 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigatingArgExpCS9452 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNavigatingArgExpCS9501 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIfExpCS_in_entryRuleIfExpCS9535 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIfExpCS9545 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_71_in_ruleIfExpCS9582 = new BitSet(new long[]{0xF057FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleIfExpCS9605 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
        public static final BitSet FOLLOW_rulePatternExpCS_in_ruleIfExpCS9624 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
        public static final BitSet FOLLOW_72_in_ruleIfExpCS9639 = new BitSet(new long[]{0xF017FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleIfExpCS9660 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000A00L});
        public static final BitSet FOLLOW_ruleElseIfThenExpCS_in_ruleIfExpCS9681 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000A00L});
        public static final BitSet FOLLOW_73_in_ruleIfExpCS9694 = new BitSet(new long[]{0xF017FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleIfExpCS9715 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
        public static final BitSet FOLLOW_74_in_ruleIfExpCS9727 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleElseIfThenExpCS_in_entryRuleElseIfThenExpCS9763 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleElseIfThenExpCS9773 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_75_in_ruleElseIfThenExpCS9810 = new BitSet(new long[]{0xF017FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleElseIfThenExpCS9831 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
        public static final BitSet FOLLOW_72_in_ruleElseIfThenExpCS9843 = new BitSet(new long[]{0xF017FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleElseIfThenExpCS9864 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLetExpCS_in_entryRuleLetExpCS9900 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLetExpCS9910 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_76_in_ruleLetExpCS9947 = new BitSet(new long[]{0x0013FFF800000030L});
        public static final BitSet FOLLOW_ruleLetVariableCS_in_ruleLetExpCS9968 = new BitSet(new long[]{0x0020000000000000L,0x0000000000000010L});
        public static final BitSet FOLLOW_53_in_ruleLetExpCS9981 = new BitSet(new long[]{0x0013FFF800000030L});
        public static final BitSet FOLLOW_ruleLetVariableCS_in_ruleLetExpCS10002 = new BitSet(new long[]{0x0020000000000000L,0x0000000000000010L});
        public static final BitSet FOLLOW_68_in_ruleLetExpCS10016 = new BitSet(new long[]{0xF017FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleLetExpCS10037 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLetVariableCS_in_entryRuleLetVariableCS10073 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLetVariableCS10083 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleLetVariableCS10129 = new BitSet(new long[]{0x0044000002000000L});
        public static final BitSet FOLLOW_ruleRoundBracketedClauseCS_in_ruleLetVariableCS10150 = new BitSet(new long[]{0x0040000002000000L});
        public static final BitSet FOLLOW_54_in_ruleLetVariableCS10164 = new BitSet(new long[]{0x0013FFF800000030L});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleLetVariableCS10185 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_25_in_ruleLetVariableCS10199 = new BitSet(new long[]{0xF017FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleLetVariableCS10220 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedExpCS_in_entryRuleNestedExpCS10256 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNestedExpCS10266 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_50_in_ruleNestedExpCS10303 = new BitSet(new long[]{0xF017FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNestedExpCS10324 = new BitSet(new long[]{0x0008000000000000L});
        public static final BitSet FOLLOW_51_in_ruleNestedExpCS10336 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSelfExpCS_in_entryRuleSelfExpCS10372 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSelfExpCS10382 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_77_in_ruleSelfExpCS10431 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiplicityBoundsCS_in_entryRuleMultiplicityBoundsCS10467 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicityBoundsCS10477 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLOWER_in_ruleMultiplicityBoundsCS10523 = new BitSet(new long[]{0x0200000000000002L});
        public static final BitSet FOLLOW_57_in_ruleMultiplicityBoundsCS10536 = new BitSet(new long[]{0x0000000000040040L});
        public static final BitSet FOLLOW_ruleUPPER_in_ruleMultiplicityBoundsCS10557 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiplicityCS_in_entryRuleMultiplicityCS10595 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicityCS10605 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_66_in_ruleMultiplicityCS10642 = new BitSet(new long[]{0x0000000000140040L,0x0000000000010000L});
        public static final BitSet FOLLOW_ruleMultiplicityBoundsCS_in_ruleMultiplicityCS10668 = new BitSet(new long[]{0x0000000000000000L,0x000000000000C008L});
        public static final BitSet FOLLOW_ruleMultiplicityStringCS_in_ruleMultiplicityCS10698 = new BitSet(new long[]{0x0000000000000000L,0x000000000000C008L});
        public static final BitSet FOLLOW_78_in_ruleMultiplicityCS10711 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
        public static final BitSet FOLLOW_79_in_ruleMultiplicityCS10735 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
        public static final BitSet FOLLOW_67_in_ruleMultiplicityCS10762 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiplicityStringCS_in_entryRuleMultiplicityStringCS10798 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicityStringCS10808 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleMultiplicityStringCS10852 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleMultiplicityStringCS10881 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_80_in_ruleMultiplicityStringCS10910 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePathNameCS_in_entryRulePathNameCS10961 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePathNameCS10971 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFirstPathElementCS_in_rulePathNameCS11017 = new BitSet(new long[]{0x0000000000000002L,0x0000000000020000L});
        public static final BitSet FOLLOW_81_in_rulePathNameCS11030 = new BitSet(new long[]{0x0013FFF800000030L});
        public static final BitSet FOLLOW_ruleNextPathElementCS_in_rulePathNameCS11051 = new BitSet(new long[]{0x0000000000000002L,0x0000000000020000L});
        public static final BitSet FOLLOW_ruleFirstPathElementCS_in_entryRuleFirstPathElementCS11089 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFirstPathElementCS11099 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleFirstPathElementCS11150 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNextPathElementCS_in_entryRuleNextPathElementCS11185 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNextPathElementCS11195 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnreservedName_in_ruleNextPathElementCS11246 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePathTypeCS_in_entryRulePathTypeCS11281 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePathTypeCS11291 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePathNameCS_in_rulePathTypeCS11337 = new BitSet(new long[]{0x0004000000000002L});
        public static final BitSet FOLLOW_50_in_rulePathTypeCS11350 = new BitSet(new long[]{0x0013FFF800000030L,0x0000000000010000L});
        public static final BitSet FOLLOW_ruleTemplateBindingCS_in_rulePathTypeCS11371 = new BitSet(new long[]{0x0008000000000000L});
        public static final BitSet FOLLOW_51_in_rulePathTypeCS11383 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTemplateBindingCS_in_entryRuleTemplateBindingCS11421 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTemplateBindingCS11431 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTemplateParameterSubstitutionCS_in_ruleTemplateBindingCS11477 = new BitSet(new long[]{0x0020000000000002L});
        public static final BitSet FOLLOW_53_in_ruleTemplateBindingCS11490 = new BitSet(new long[]{0x0013FFF800000030L,0x0000000000010000L});
        public static final BitSet FOLLOW_ruleTemplateParameterSubstitutionCS_in_ruleTemplateBindingCS11511 = new BitSet(new long[]{0x0020000000000002L});
        public static final BitSet FOLLOW_ruleTemplateParameterSubstitutionCS_in_entryRuleTemplateParameterSubstitutionCS11549 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTemplateParameterSubstitutionCS11559 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeRefCS_in_ruleTemplateParameterSubstitutionCS11604 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTemplateSignatureCS_in_entryRuleTemplateSignatureCS11639 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTemplateSignatureCS11649 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleTemplateSignatureCS11686 = new BitSet(new long[]{0x0013FFF800000030L});
        public static final BitSet FOLLOW_ruleTypeParameterCS_in_ruleTemplateSignatureCS11707 = new BitSet(new long[]{0x0020000000200000L});
        public static final BitSet FOLLOW_53_in_ruleTemplateSignatureCS11720 = new BitSet(new long[]{0x0013FFF800000030L});
        public static final BitSet FOLLOW_ruleTypeParameterCS_in_ruleTemplateSignatureCS11741 = new BitSet(new long[]{0x0020000000200000L});
        public static final BitSet FOLLOW_21_in_ruleTemplateSignatureCS11755 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeParameterCS_in_entryRuleTypeParameterCS11791 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeParameterCS11801 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleTypeParameterCS11847 = new BitSet(new long[]{0x0000000000000002L,0x0000000000040000L});
        public static final BitSet FOLLOW_82_in_ruleTypeParameterCS11860 = new BitSet(new long[]{0x0013FFF800000030L});
        public static final BitSet FOLLOW_ruleSimpleTypeDeclarationCS_in_ruleTypeParameterCS11881 = new BitSet(new long[]{0x0000000000000002L,0x0000000000080000L});
        public static final BitSet FOLLOW_83_in_ruleTypeParameterCS11894 = new BitSet(new long[]{0x0013FFF800000030L});
        public static final BitSet FOLLOW_ruleSimpleTypeDeclarationCS_in_ruleTypeParameterCS11915 = new BitSet(new long[]{0x0000000000000002L,0x0000000000080000L});
        public static final BitSet FOLLOW_ruleTypeRefCS_in_entryRuleTypeRefCS11955 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeRefCS11965 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimpleTypeDeclarationCS_in_ruleTypeRefCS12015 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWildcardTypeRefCS_in_ruleTypeRefCS12045 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWildcardTypeRefCS_in_entryRuleWildcardTypeRefCS12080 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleWildcardTypeRefCS12090 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_80_in_ruleWildcardTypeRefCS12139 = new BitSet(new long[]{0x0000000000000002L,0x0000000000040000L});
        public static final BitSet FOLLOW_82_in_ruleWildcardTypeRefCS12152 = new BitSet(new long[]{0x0013FFF800000030L});
        public static final BitSet FOLLOW_ruleSimpleTypeDeclarationCS_in_ruleWildcardTypeRefCS12173 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleID_in_entryRuleID12212 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleID12223 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_SIMPLE_ID_in_ruleID12263 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ESCAPED_ID_in_ruleID12289 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_entryRuleIdentifier12335 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIdentifier12346 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleID_in_ruleIdentifier12392 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLOWER_in_entryRuleLOWER12437 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLOWER12448 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleLOWER12487 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNUMBER_LITERAL_in_entryRuleNUMBER_LITERAL12532 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNUMBER_LITERAL12543 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleNUMBER_LITERAL12582 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral12627 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteral12638 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_SINGLE_QUOTED_STRING_in_ruleStringLiteral12677 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUPPER_in_entryRuleUPPER12722 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUPPER12733 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleUPPER12773 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleUPPER12797 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleURI_in_entryRuleURI12838 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleURI12849 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_SINGLE_QUOTED_STRING_in_ruleURI12888 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralWithMultiplicityCS_in_synpred78_InternalEssentialOCL6839 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrefixedPrimaryExpCS_in_synpred80_InternalEssentialOCL6965 = new BitSet(new long[]{0x00000007FFFD0002L});
        public static final BitSet FOLLOW_ruleBinaryOperatorName_in_synpred80_InternalEssentialOCL6998 = new BitSet(new long[]{0xF017FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_synpred80_InternalEssentialOCL7019 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTupleLiteralExpCS_in_synpred87_InternalEssentialOCL7582 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMapLiteralExpCS_in_synpred88_InternalEssentialOCL7612 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionLiteralExpCS_in_synpred89_InternalEssentialOCL7642 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLambdaLiteralExpCS_in_synpred90_InternalEssentialOCL7672 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralExpCS_in_synpred91_InternalEssentialOCL7702 = new BitSet(new long[]{0x0000000000000002L});
    }


}