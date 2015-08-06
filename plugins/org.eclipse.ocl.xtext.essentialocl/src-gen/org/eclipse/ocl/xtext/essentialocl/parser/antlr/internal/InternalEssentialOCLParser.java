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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_SIMPLE_ID", "RULE_ESCAPED_ID", "RULE_INT", "RULE_SINGLE_QUOTED_STRING", "RULE_ESCAPED_CHARACTER", "RULE_LETTER_CHARACTER", "RULE_DOUBLE_QUOTED_STRING", "RULE_ML_SINGLE_QUOTED_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'-'", "'not'", "'*'", "'/'", "'+'", "'>'", "'<'", "'>='", "'<='", "'='", "'<>'", "'and'", "'or'", "'xor'", "'implies'", "'.'", "'->'", "'?.'", "'?->'", "'Map'", "'Tuple'", "'Boolean'", "'Integer'", "'Real'", "'String'", "'UnlimitedNatural'", "'OclAny'", "'OclInvalid'", "'OclVoid'", "'Set'", "'Bag'", "'Sequence'", "'Collection'", "'OrderedSet'", "'('", "')'", "','", "':'", "'{'", "'}'", "'..'", "'++'", "'Lambda'", "'<-'", "'true'", "'false'", "'invalid'", "'null'", "'@'", "'pre'", "'['", "']'", "'in'", "'|'", "';'", "'if'", "'then'", "'else'", "'endif'", "'elseif'", "'let'", "'self'", "'|?'", "'|1'", "'?'", "'::'", "'extends'", "'&&'"
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:868:1: ruleCollectionTypeCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )? ( (lv_ownedMultiplicity_4_0= ruleMultiplicityCS ) )? ) ;
    public final EObject ruleCollectionTypeCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;

        EObject lv_ownedMultiplicity_4_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:871:28: ( ( ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )? ( (lv_ownedMultiplicity_4_0= ruleMultiplicityCS ) )? ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:872:1: ( ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )? ( (lv_ownedMultiplicity_4_0= ruleMultiplicityCS ) )? )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:872:1: ( ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )? ( (lv_ownedMultiplicity_4_0= ruleMultiplicityCS ) )? )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:872:2: ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )? ( (lv_ownedMultiplicity_4_0= ruleMultiplicityCS ) )?
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:916:3: ( (lv_ownedMultiplicity_4_0= ruleMultiplicityCS ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==66) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:917:1: (lv_ownedMultiplicity_4_0= ruleMultiplicityCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:917:1: (lv_ownedMultiplicity_4_0= ruleMultiplicityCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:918:3: lv_ownedMultiplicity_4_0= ruleMultiplicityCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionTypeCSAccess().getOwnedMultiplicityMultiplicityCSParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMultiplicityCS_in_ruleCollectionTypeCS2474);
                    lv_ownedMultiplicity_4_0=ruleMultiplicityCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getCollectionTypeCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedMultiplicity",
                              		lv_ownedMultiplicity_4_0, 
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
    // $ANTLR end "ruleCollectionTypeCS"


    // $ANTLR start "entryRuleMapTypeCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:942:1: entryRuleMapTypeCS returns [EObject current=null] : iv_ruleMapTypeCS= ruleMapTypeCS EOF ;
    public final EObject entryRuleMapTypeCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMapTypeCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:943:2: (iv_ruleMapTypeCS= ruleMapTypeCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:944:2: iv_ruleMapTypeCS= ruleMapTypeCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMapTypeCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMapTypeCS_in_entryRuleMapTypeCS2511);
            iv_ruleMapTypeCS=ruleMapTypeCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMapTypeCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMapTypeCS2521); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:951:1: ruleMapTypeCS returns [EObject current=null] : ( ( (lv_name_0_0= 'Map' ) ) (otherlv_1= '(' ( (lv_ownedKeyType_2_0= ruleTypeExpCS ) ) otherlv_3= ',' ( (lv_ownedValueType_4_0= ruleTypeExpCS ) ) otherlv_5= ')' )? ) ;
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
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:954:28: ( ( ( (lv_name_0_0= 'Map' ) ) (otherlv_1= '(' ( (lv_ownedKeyType_2_0= ruleTypeExpCS ) ) otherlv_3= ',' ( (lv_ownedValueType_4_0= ruleTypeExpCS ) ) otherlv_5= ')' )? ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:955:1: ( ( (lv_name_0_0= 'Map' ) ) (otherlv_1= '(' ( (lv_ownedKeyType_2_0= ruleTypeExpCS ) ) otherlv_3= ',' ( (lv_ownedValueType_4_0= ruleTypeExpCS ) ) otherlv_5= ')' )? )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:955:1: ( ( (lv_name_0_0= 'Map' ) ) (otherlv_1= '(' ( (lv_ownedKeyType_2_0= ruleTypeExpCS ) ) otherlv_3= ',' ( (lv_ownedValueType_4_0= ruleTypeExpCS ) ) otherlv_5= ')' )? )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:955:2: ( (lv_name_0_0= 'Map' ) ) (otherlv_1= '(' ( (lv_ownedKeyType_2_0= ruleTypeExpCS ) ) otherlv_3= ',' ( (lv_ownedValueType_4_0= ruleTypeExpCS ) ) otherlv_5= ')' )?
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:955:2: ( (lv_name_0_0= 'Map' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:956:1: (lv_name_0_0= 'Map' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:956:1: (lv_name_0_0= 'Map' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:957:3: lv_name_0_0= 'Map'
            {
            lv_name_0_0=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleMapTypeCS2564); if (state.failed) return current;
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:970:2: (otherlv_1= '(' ( (lv_ownedKeyType_2_0= ruleTypeExpCS ) ) otherlv_3= ',' ( (lv_ownedValueType_4_0= ruleTypeExpCS ) ) otherlv_5= ')' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==50) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:970:4: otherlv_1= '(' ( (lv_ownedKeyType_2_0= ruleTypeExpCS ) ) otherlv_3= ',' ( (lv_ownedValueType_4_0= ruleTypeExpCS ) ) otherlv_5= ')'
                    {
                    otherlv_1=(Token)match(input,50,FollowSets000.FOLLOW_50_in_ruleMapTypeCS2590); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getMapTypeCSAccess().getLeftParenthesisKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:974:1: ( (lv_ownedKeyType_2_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:975:1: (lv_ownedKeyType_2_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:975:1: (lv_ownedKeyType_2_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:976:3: lv_ownedKeyType_2_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMapTypeCSAccess().getOwnedKeyTypeTypeExpCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleMapTypeCS2611);
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

                    otherlv_3=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleMapTypeCS2623); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getMapTypeCSAccess().getCommaKeyword_1_2());
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:996:1: ( (lv_ownedValueType_4_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:997:1: (lv_ownedValueType_4_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:997:1: (lv_ownedValueType_4_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:998:3: lv_ownedValueType_4_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMapTypeCSAccess().getOwnedValueTypeTypeExpCSParserRuleCall_1_3_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleMapTypeCS2644);
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

                    otherlv_5=(Token)match(input,51,FollowSets000.FOLLOW_51_in_ruleMapTypeCS2656); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1026:1: entryRuleTupleTypeCS returns [EObject current=null] : iv_ruleTupleTypeCS= ruleTupleTypeCS EOF ;
    public final EObject entryRuleTupleTypeCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTupleTypeCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1027:2: (iv_ruleTupleTypeCS= ruleTupleTypeCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1028:2: iv_ruleTupleTypeCS= ruleTupleTypeCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTupleTypeCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTupleTypeCS_in_entryRuleTupleTypeCS2694);
            iv_ruleTupleTypeCS=ruleTupleTypeCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTupleTypeCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTupleTypeCS2704); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1035:1: ruleTupleTypeCS returns [EObject current=null] : ( ( (lv_name_0_0= 'Tuple' ) ) (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )? ) ;
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
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1038:28: ( ( ( (lv_name_0_0= 'Tuple' ) ) (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )? ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1039:1: ( ( (lv_name_0_0= 'Tuple' ) ) (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )? )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1039:1: ( ( (lv_name_0_0= 'Tuple' ) ) (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )? )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1039:2: ( (lv_name_0_0= 'Tuple' ) ) (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )?
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1039:2: ( (lv_name_0_0= 'Tuple' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1040:1: (lv_name_0_0= 'Tuple' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1040:1: (lv_name_0_0= 'Tuple' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1041:3: lv_name_0_0= 'Tuple'
            {
            lv_name_0_0=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleTupleTypeCS2747); if (state.failed) return current;
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1054:2: (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==50) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1054:4: otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')'
                    {
                    otherlv_1=(Token)match(input,50,FollowSets000.FOLLOW_50_in_ruleTupleTypeCS2773); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getTupleTypeCSAccess().getLeftParenthesisKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1058:1: ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( ((LA13_0>=RULE_SIMPLE_ID && LA13_0<=RULE_ESCAPED_ID)) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1058:2: ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )*
                            {
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1058:2: ( (lv_ownedParts_2_0= ruleTuplePartCS ) )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1059:1: (lv_ownedParts_2_0= ruleTuplePartCS )
                            {
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1059:1: (lv_ownedParts_2_0= ruleTuplePartCS )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1060:3: lv_ownedParts_2_0= ruleTuplePartCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getTupleTypeCSAccess().getOwnedPartsTuplePartCSParserRuleCall_1_1_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleTuplePartCS_in_ruleTupleTypeCS2795);
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

                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1076:2: (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )*
                            loop12:
                            do {
                                int alt12=2;
                                int LA12_0 = input.LA(1);

                                if ( (LA12_0==52) ) {
                                    alt12=1;
                                }


                                switch (alt12) {
                            	case 1 :
                            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1076:4: otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) )
                            	    {
                            	    otherlv_3=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleTupleTypeCS2808); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_3, grammarAccess.getTupleTypeCSAccess().getCommaKeyword_1_1_1_0());
                            	          
                            	    }
                            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1080:1: ( (lv_ownedParts_4_0= ruleTuplePartCS ) )
                            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1081:1: (lv_ownedParts_4_0= ruleTuplePartCS )
                            	    {
                            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1081:1: (lv_ownedParts_4_0= ruleTuplePartCS )
                            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1082:3: lv_ownedParts_4_0= ruleTuplePartCS
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getTupleTypeCSAccess().getOwnedPartsTuplePartCSParserRuleCall_1_1_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FollowSets000.FOLLOW_ruleTuplePartCS_in_ruleTupleTypeCS2829);
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
                            	    break loop12;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_5=(Token)match(input,51,FollowSets000.FOLLOW_51_in_ruleTupleTypeCS2845); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1110:1: entryRuleTuplePartCS returns [EObject current=null] : iv_ruleTuplePartCS= ruleTuplePartCS EOF ;
    public final EObject entryRuleTuplePartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTuplePartCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1111:2: (iv_ruleTuplePartCS= ruleTuplePartCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1112:2: iv_ruleTuplePartCS= ruleTuplePartCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTuplePartCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTuplePartCS_in_entryRuleTuplePartCS2883);
            iv_ruleTuplePartCS=ruleTuplePartCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTuplePartCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTuplePartCS2893); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1119:1: ruleTuplePartCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) ) ;
    public final EObject ruleTuplePartCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1122:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1123:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1123:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1123:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1123:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1124:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1124:1: (lv_name_0_0= ruleUnrestrictedName )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1125:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTuplePartCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleTuplePartCS2939);
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

            otherlv_1=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleTuplePartCS2951); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getTuplePartCSAccess().getColonKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1145:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1146:1: (lv_ownedType_2_0= ruleTypeExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1146:1: (lv_ownedType_2_0= ruleTypeExpCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1147:3: lv_ownedType_2_0= ruleTypeExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTuplePartCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleTuplePartCS2972);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1171:1: entryRuleCollectionLiteralExpCS returns [EObject current=null] : iv_ruleCollectionLiteralExpCS= ruleCollectionLiteralExpCS EOF ;
    public final EObject entryRuleCollectionLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1172:2: (iv_ruleCollectionLiteralExpCS= ruleCollectionLiteralExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1173:2: iv_ruleCollectionLiteralExpCS= ruleCollectionLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCollectionLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteralExpCS_in_entryRuleCollectionLiteralExpCS3008);
            iv_ruleCollectionLiteralExpCS=ruleCollectionLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCollectionLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCollectionLiteralExpCS3018); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1180:1: ruleCollectionLiteralExpCS returns [EObject current=null] : ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}' ) ;
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
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1183:28: ( ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1184:1: ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1184:1: ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1184:2: ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}'
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1184:2: ( (lv_ownedType_0_0= ruleCollectionTypeCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1185:1: (lv_ownedType_0_0= ruleCollectionTypeCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1185:1: (lv_ownedType_0_0= ruleCollectionTypeCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1186:3: lv_ownedType_0_0= ruleCollectionTypeCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedTypeCollectionTypeCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleCollectionTypeCS_in_ruleCollectionLiteralExpCS3064);
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

            otherlv_1=(Token)match(input,54,FollowSets000.FOLLOW_54_in_ruleCollectionLiteralExpCS3076); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getCollectionLiteralExpCSAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1206:1: ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( ((LA16_0>=RULE_SIMPLE_ID && LA16_0<=RULE_SINGLE_QUOTED_STRING)||(LA16_0>=16 && LA16_0<=18)||(LA16_0>=35 && LA16_0<=50)||LA16_0==53||LA16_0==58||(LA16_0>=60 && LA16_0<=63)||LA16_0==71||(LA16_0>=76 && LA16_0<=77)) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1206:2: ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )*
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1206:2: ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1207:1: (lv_ownedParts_2_0= ruleCollectionLiteralPartCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1207:1: (lv_ownedParts_2_0= ruleCollectionLiteralPartCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1208:3: lv_ownedParts_2_0= ruleCollectionLiteralPartCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedPartsCollectionLiteralPartCSParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteralPartCS_in_ruleCollectionLiteralExpCS3098);
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

                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1224:2: (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==52) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1224:4: otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) )
                    	    {
                    	    otherlv_3=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleCollectionLiteralExpCS3111); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getCollectionLiteralExpCSAccess().getCommaKeyword_2_1_0());
                    	          
                    	    }
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1228:1: ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) )
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1229:1: (lv_ownedParts_4_0= ruleCollectionLiteralPartCS )
                    	    {
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1229:1: (lv_ownedParts_4_0= ruleCollectionLiteralPartCS )
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1230:3: lv_ownedParts_4_0= ruleCollectionLiteralPartCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedPartsCollectionLiteralPartCSParserRuleCall_2_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteralPartCS_in_ruleCollectionLiteralExpCS3132);
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
                    	    break loop15;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleCollectionLiteralExpCS3148); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1258:1: entryRuleCollectionLiteralPartCS returns [EObject current=null] : iv_ruleCollectionLiteralPartCS= ruleCollectionLiteralPartCS EOF ;
    public final EObject entryRuleCollectionLiteralPartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionLiteralPartCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1259:2: (iv_ruleCollectionLiteralPartCS= ruleCollectionLiteralPartCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1260:2: iv_ruleCollectionLiteralPartCS= ruleCollectionLiteralPartCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCollectionLiteralPartCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteralPartCS_in_entryRuleCollectionLiteralPartCS3184);
            iv_ruleCollectionLiteralPartCS=ruleCollectionLiteralPartCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCollectionLiteralPartCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCollectionLiteralPartCS3194); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1267:1: ruleCollectionLiteralPartCS returns [EObject current=null] : ( ( ( (lv_ownedExpression_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_ownedLastExpression_2_0= ruleExpCS ) ) )? ) | ( (lv_ownedExpression_3_0= rulePatternExpCS ) ) ) ;
    public final EObject ruleCollectionLiteralPartCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_ownedExpression_0_0 = null;

        EObject lv_ownedLastExpression_2_0 = null;

        EObject lv_ownedExpression_3_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1270:28: ( ( ( ( (lv_ownedExpression_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_ownedLastExpression_2_0= ruleExpCS ) ) )? ) | ( (lv_ownedExpression_3_0= rulePatternExpCS ) ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1271:1: ( ( ( (lv_ownedExpression_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_ownedLastExpression_2_0= ruleExpCS ) ) )? ) | ( (lv_ownedExpression_3_0= rulePatternExpCS ) ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1271:1: ( ( ( (lv_ownedExpression_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_ownedLastExpression_2_0= ruleExpCS ) ) )? ) | ( (lv_ownedExpression_3_0= rulePatternExpCS ) ) )
            int alt18=2;
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
                alt18=1;
                }
                break;
            case RULE_SIMPLE_ID:
                {
                int LA18_2 = input.LA(2);

                if ( (LA18_2==EOF||LA18_2==16||(LA18_2>=18 && LA18_2<=34)||LA18_2==50||LA18_2==52||(LA18_2>=54 && LA18_2<=56)||LA18_2==64||LA18_2==66||LA18_2==81) ) {
                    alt18=1;
                }
                else if ( (LA18_2==53) ) {
                    alt18=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 18, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_ESCAPED_ID:
                {
                int LA18_3 = input.LA(2);

                if ( (LA18_3==EOF||LA18_3==16||(LA18_3>=18 && LA18_3<=34)||LA18_3==50||LA18_3==52||(LA18_3>=54 && LA18_3<=56)||LA18_3==64||LA18_3==66||LA18_3==81) ) {
                    alt18=1;
                }
                else if ( (LA18_3==53) ) {
                    alt18=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 18, 3, input);

                    throw nvae;
                }
                }
                break;
            case 53:
                {
                alt18=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1271:2: ( ( (lv_ownedExpression_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_ownedLastExpression_2_0= ruleExpCS ) ) )? )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1271:2: ( ( (lv_ownedExpression_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_ownedLastExpression_2_0= ruleExpCS ) ) )? )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1271:3: ( (lv_ownedExpression_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_ownedLastExpression_2_0= ruleExpCS ) ) )?
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1271:3: ( (lv_ownedExpression_0_0= ruleExpCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1272:1: (lv_ownedExpression_0_0= ruleExpCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1272:1: (lv_ownedExpression_0_0= ruleExpCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1273:3: lv_ownedExpression_0_0= ruleExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionLiteralPartCSAccess().getOwnedExpressionExpCSParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleCollectionLiteralPartCS3241);
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

                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1289:2: (otherlv_1= '..' ( (lv_ownedLastExpression_2_0= ruleExpCS ) ) )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==56) ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1289:4: otherlv_1= '..' ( (lv_ownedLastExpression_2_0= ruleExpCS ) )
                            {
                            otherlv_1=(Token)match(input,56,FollowSets000.FOLLOW_56_in_ruleCollectionLiteralPartCS3254); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_1, grammarAccess.getCollectionLiteralPartCSAccess().getFullStopFullStopKeyword_0_1_0());
                                  
                            }
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1293:1: ( (lv_ownedLastExpression_2_0= ruleExpCS ) )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1294:1: (lv_ownedLastExpression_2_0= ruleExpCS )
                            {
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1294:1: (lv_ownedLastExpression_2_0= ruleExpCS )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1295:3: lv_ownedLastExpression_2_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getCollectionLiteralPartCSAccess().getOwnedLastExpressionExpCSParserRuleCall_0_1_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleCollectionLiteralPartCS3275);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1312:6: ( (lv_ownedExpression_3_0= rulePatternExpCS ) )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1312:6: ( (lv_ownedExpression_3_0= rulePatternExpCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1313:1: (lv_ownedExpression_3_0= rulePatternExpCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1313:1: (lv_ownedExpression_3_0= rulePatternExpCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1314:3: lv_ownedExpression_3_0= rulePatternExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionLiteralPartCSAccess().getOwnedExpressionPatternExpCSParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePatternExpCS_in_ruleCollectionLiteralPartCS3305);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1338:1: entryRuleCollectionPatternCS returns [EObject current=null] : iv_ruleCollectionPatternCS= ruleCollectionPatternCS EOF ;
    public final EObject entryRuleCollectionPatternCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionPatternCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1339:2: (iv_ruleCollectionPatternCS= ruleCollectionPatternCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1340:2: iv_ruleCollectionPatternCS= ruleCollectionPatternCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCollectionPatternCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleCollectionPatternCS_in_entryRuleCollectionPatternCS3341);
            iv_ruleCollectionPatternCS=ruleCollectionPatternCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCollectionPatternCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCollectionPatternCS3351); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1347:1: ruleCollectionPatternCS returns [EObject current=null] : ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= rulePatternExpCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= rulePatternExpCS ) ) )* (otherlv_5= '++' ( (lv_restVariableName_6_0= ruleIdentifier ) ) ) )? otherlv_7= '}' ) ;
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
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1350:28: ( ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= rulePatternExpCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= rulePatternExpCS ) ) )* (otherlv_5= '++' ( (lv_restVariableName_6_0= ruleIdentifier ) ) ) )? otherlv_7= '}' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1351:1: ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= rulePatternExpCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= rulePatternExpCS ) ) )* (otherlv_5= '++' ( (lv_restVariableName_6_0= ruleIdentifier ) ) ) )? otherlv_7= '}' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1351:1: ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= rulePatternExpCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= rulePatternExpCS ) ) )* (otherlv_5= '++' ( (lv_restVariableName_6_0= ruleIdentifier ) ) ) )? otherlv_7= '}' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1351:2: ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= rulePatternExpCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= rulePatternExpCS ) ) )* (otherlv_5= '++' ( (lv_restVariableName_6_0= ruleIdentifier ) ) ) )? otherlv_7= '}'
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1351:2: ( (lv_ownedType_0_0= ruleCollectionTypeCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1352:1: (lv_ownedType_0_0= ruleCollectionTypeCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1352:1: (lv_ownedType_0_0= ruleCollectionTypeCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1353:3: lv_ownedType_0_0= ruleCollectionTypeCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCollectionPatternCSAccess().getOwnedTypeCollectionTypeCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleCollectionTypeCS_in_ruleCollectionPatternCS3397);
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

            otherlv_1=(Token)match(input,54,FollowSets000.FOLLOW_54_in_ruleCollectionPatternCS3409); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getCollectionPatternCSAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1373:1: ( ( (lv_ownedParts_2_0= rulePatternExpCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= rulePatternExpCS ) ) )* (otherlv_5= '++' ( (lv_restVariableName_6_0= ruleIdentifier ) ) ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( ((LA20_0>=RULE_SIMPLE_ID && LA20_0<=RULE_ESCAPED_ID)||LA20_0==53) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1373:2: ( (lv_ownedParts_2_0= rulePatternExpCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= rulePatternExpCS ) ) )* (otherlv_5= '++' ( (lv_restVariableName_6_0= ruleIdentifier ) ) )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1373:2: ( (lv_ownedParts_2_0= rulePatternExpCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1374:1: (lv_ownedParts_2_0= rulePatternExpCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1374:1: (lv_ownedParts_2_0= rulePatternExpCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1375:3: lv_ownedParts_2_0= rulePatternExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionPatternCSAccess().getOwnedPartsPatternExpCSParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePatternExpCS_in_ruleCollectionPatternCS3431);
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

                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1391:2: (otherlv_3= ',' ( (lv_ownedParts_4_0= rulePatternExpCS ) ) )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==52) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1391:4: otherlv_3= ',' ( (lv_ownedParts_4_0= rulePatternExpCS ) )
                    	    {
                    	    otherlv_3=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleCollectionPatternCS3444); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getCollectionPatternCSAccess().getCommaKeyword_2_1_0());
                    	          
                    	    }
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1395:1: ( (lv_ownedParts_4_0= rulePatternExpCS ) )
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1396:1: (lv_ownedParts_4_0= rulePatternExpCS )
                    	    {
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1396:1: (lv_ownedParts_4_0= rulePatternExpCS )
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1397:3: lv_ownedParts_4_0= rulePatternExpCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getCollectionPatternCSAccess().getOwnedPartsPatternExpCSParserRuleCall_2_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_rulePatternExpCS_in_ruleCollectionPatternCS3465);
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
                    	    break loop19;
                        }
                    } while (true);

                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1413:4: (otherlv_5= '++' ( (lv_restVariableName_6_0= ruleIdentifier ) ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1413:6: otherlv_5= '++' ( (lv_restVariableName_6_0= ruleIdentifier ) )
                    {
                    otherlv_5=(Token)match(input,57,FollowSets000.FOLLOW_57_in_ruleCollectionPatternCS3480); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getCollectionPatternCSAccess().getPlusSignPlusSignKeyword_2_2_0());
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1417:1: ( (lv_restVariableName_6_0= ruleIdentifier ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1418:1: (lv_restVariableName_6_0= ruleIdentifier )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1418:1: (lv_restVariableName_6_0= ruleIdentifier )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1419:3: lv_restVariableName_6_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionPatternCSAccess().getRestVariableNameIdentifierParserRuleCall_2_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_ruleCollectionPatternCS3501);
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

            otherlv_7=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleCollectionPatternCS3516); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1447:1: entryRuleShadowPartCS returns [EObject current=null] : iv_ruleShadowPartCS= ruleShadowPartCS EOF ;
    public final EObject entryRuleShadowPartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleShadowPartCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1448:2: (iv_ruleShadowPartCS= ruleShadowPartCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1449:2: iv_ruleShadowPartCS= ruleShadowPartCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getShadowPartCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleShadowPartCS_in_entryRuleShadowPartCS3552);
            iv_ruleShadowPartCS=ruleShadowPartCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleShadowPartCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleShadowPartCS3562); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1456:1: ruleShadowPartCS returns [EObject current=null] : ( ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( ( (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS ) ) ) ) ;
    public final EObject ruleShadowPartCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_ownedInitExpression_2_1 = null;

        EObject lv_ownedInitExpression_2_2 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1459:28: ( ( ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( ( (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS ) ) ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1460:1: ( ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( ( (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS ) ) ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1460:1: ( ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( ( (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS ) ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1460:2: ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( ( (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS ) ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1460:2: ( ( ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1461:1: ( ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1461:1: ( ruleUnrestrictedName )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1462:3: ruleUnrestrictedName
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
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleShadowPartCS3614);
            ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleShadowPartCS3626); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getShadowPartCSAccess().getEqualsSignKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1482:1: ( ( (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1483:1: ( (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1483:1: ( (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1484:1: (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1484:1: (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS )
            int alt21=2;
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
                alt21=1;
                }
                break;
            case RULE_SIMPLE_ID:
                {
                int LA21_2 = input.LA(2);

                if ( (LA21_2==53) ) {
                    alt21=2;
                }
                else if ( (LA21_2==EOF||LA21_2==16||(LA21_2>=18 && LA21_2<=34)||LA21_2==50||LA21_2==52||(LA21_2>=54 && LA21_2<=55)||LA21_2==64||LA21_2==66||LA21_2==81) ) {
                    alt21=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 21, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_ESCAPED_ID:
                {
                int LA21_3 = input.LA(2);

                if ( (LA21_3==EOF||LA21_3==16||(LA21_3>=18 && LA21_3<=34)||LA21_3==50||LA21_3==52||(LA21_3>=54 && LA21_3<=55)||LA21_3==64||LA21_3==66||LA21_3==81) ) {
                    alt21=1;
                }
                else if ( (LA21_3==53) ) {
                    alt21=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 21, 3, input);

                    throw nvae;
                }
                }
                break;
            case 53:
                {
                alt21=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1485:3: lv_ownedInitExpression_2_1= ruleExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getShadowPartCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleShadowPartCS3649);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1500:8: lv_ownedInitExpression_2_2= rulePatternExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getShadowPartCSAccess().getOwnedInitExpressionPatternExpCSParserRuleCall_2_0_1()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePatternExpCS_in_ruleShadowPartCS3668);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1526:1: entryRulePatternExpCS returns [EObject current=null] : iv_rulePatternExpCS= rulePatternExpCS EOF ;
    public final EObject entryRulePatternExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePatternExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1527:2: (iv_rulePatternExpCS= rulePatternExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1528:2: iv_rulePatternExpCS= rulePatternExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPatternExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePatternExpCS_in_entryRulePatternExpCS3707);
            iv_rulePatternExpCS=rulePatternExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePatternExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePatternExpCS3717); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1535:1: rulePatternExpCS returns [EObject current=null] : ( ( (lv_patternVariableName_0_0= ruleUnrestrictedName ) )? otherlv_1= ':' ( (lv_ownedPatternType_2_0= ruleTypeExpCS ) ) ) ;
    public final EObject rulePatternExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_patternVariableName_0_0 = null;

        EObject lv_ownedPatternType_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1538:28: ( ( ( (lv_patternVariableName_0_0= ruleUnrestrictedName ) )? otherlv_1= ':' ( (lv_ownedPatternType_2_0= ruleTypeExpCS ) ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1539:1: ( ( (lv_patternVariableName_0_0= ruleUnrestrictedName ) )? otherlv_1= ':' ( (lv_ownedPatternType_2_0= ruleTypeExpCS ) ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1539:1: ( ( (lv_patternVariableName_0_0= ruleUnrestrictedName ) )? otherlv_1= ':' ( (lv_ownedPatternType_2_0= ruleTypeExpCS ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1539:2: ( (lv_patternVariableName_0_0= ruleUnrestrictedName ) )? otherlv_1= ':' ( (lv_ownedPatternType_2_0= ruleTypeExpCS ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1539:2: ( (lv_patternVariableName_0_0= ruleUnrestrictedName ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( ((LA22_0>=RULE_SIMPLE_ID && LA22_0<=RULE_ESCAPED_ID)) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1540:1: (lv_patternVariableName_0_0= ruleUnrestrictedName )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1540:1: (lv_patternVariableName_0_0= ruleUnrestrictedName )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1541:3: lv_patternVariableName_0_0= ruleUnrestrictedName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPatternExpCSAccess().getPatternVariableNameUnrestrictedNameParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_rulePatternExpCS3763);
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

            otherlv_1=(Token)match(input,53,FollowSets000.FOLLOW_53_in_rulePatternExpCS3776); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getPatternExpCSAccess().getColonKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1561:1: ( (lv_ownedPatternType_2_0= ruleTypeExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1562:1: (lv_ownedPatternType_2_0= ruleTypeExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1562:1: (lv_ownedPatternType_2_0= ruleTypeExpCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1563:3: lv_ownedPatternType_2_0= ruleTypeExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPatternExpCSAccess().getOwnedPatternTypeTypeExpCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_rulePatternExpCS3797);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1587:1: entryRuleLambdaLiteralExpCS returns [EObject current=null] : iv_ruleLambdaLiteralExpCS= ruleLambdaLiteralExpCS EOF ;
    public final EObject entryRuleLambdaLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLambdaLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1588:2: (iv_ruleLambdaLiteralExpCS= ruleLambdaLiteralExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1589:2: iv_ruleLambdaLiteralExpCS= ruleLambdaLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLambdaLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLambdaLiteralExpCS_in_entryRuleLambdaLiteralExpCS3833);
            iv_ruleLambdaLiteralExpCS=ruleLambdaLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLambdaLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLambdaLiteralExpCS3843); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1596:1: ruleLambdaLiteralExpCS returns [EObject current=null] : (otherlv_0= 'Lambda' otherlv_1= '{' ( (lv_ownedExpressionCS_2_0= ruleExpCS ) ) otherlv_3= '}' ) ;
    public final EObject ruleLambdaLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_ownedExpressionCS_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1599:28: ( (otherlv_0= 'Lambda' otherlv_1= '{' ( (lv_ownedExpressionCS_2_0= ruleExpCS ) ) otherlv_3= '}' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1600:1: (otherlv_0= 'Lambda' otherlv_1= '{' ( (lv_ownedExpressionCS_2_0= ruleExpCS ) ) otherlv_3= '}' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1600:1: (otherlv_0= 'Lambda' otherlv_1= '{' ( (lv_ownedExpressionCS_2_0= ruleExpCS ) ) otherlv_3= '}' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1600:3: otherlv_0= 'Lambda' otherlv_1= '{' ( (lv_ownedExpressionCS_2_0= ruleExpCS ) ) otherlv_3= '}'
            {
            otherlv_0=(Token)match(input,58,FollowSets000.FOLLOW_58_in_ruleLambdaLiteralExpCS3880); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLambdaLiteralExpCSAccess().getLambdaKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,54,FollowSets000.FOLLOW_54_in_ruleLambdaLiteralExpCS3892); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getLambdaLiteralExpCSAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1608:1: ( (lv_ownedExpressionCS_2_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1609:1: (lv_ownedExpressionCS_2_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1609:1: (lv_ownedExpressionCS_2_0= ruleExpCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1610:3: lv_ownedExpressionCS_2_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLambdaLiteralExpCSAccess().getOwnedExpressionCSExpCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleLambdaLiteralExpCS3913);
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

            otherlv_3=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleLambdaLiteralExpCS3925); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1638:1: entryRuleMapLiteralExpCS returns [EObject current=null] : iv_ruleMapLiteralExpCS= ruleMapLiteralExpCS EOF ;
    public final EObject entryRuleMapLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMapLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1639:2: (iv_ruleMapLiteralExpCS= ruleMapLiteralExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1640:2: iv_ruleMapLiteralExpCS= ruleMapLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMapLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMapLiteralExpCS_in_entryRuleMapLiteralExpCS3961);
            iv_ruleMapLiteralExpCS=ruleMapLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMapLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMapLiteralExpCS3971); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1647:1: ruleMapLiteralExpCS returns [EObject current=null] : ( ( (lv_ownedType_0_0= ruleMapTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleMapLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) ) )* )? otherlv_5= '}' ) ;
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
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1650:28: ( ( ( (lv_ownedType_0_0= ruleMapTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleMapLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) ) )* )? otherlv_5= '}' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1651:1: ( ( (lv_ownedType_0_0= ruleMapTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleMapLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) ) )* )? otherlv_5= '}' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1651:1: ( ( (lv_ownedType_0_0= ruleMapTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleMapLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) ) )* )? otherlv_5= '}' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1651:2: ( (lv_ownedType_0_0= ruleMapTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleMapLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) ) )* )? otherlv_5= '}'
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1651:2: ( (lv_ownedType_0_0= ruleMapTypeCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1652:1: (lv_ownedType_0_0= ruleMapTypeCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1652:1: (lv_ownedType_0_0= ruleMapTypeCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1653:3: lv_ownedType_0_0= ruleMapTypeCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMapLiteralExpCSAccess().getOwnedTypeMapTypeCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleMapTypeCS_in_ruleMapLiteralExpCS4017);
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

            otherlv_1=(Token)match(input,54,FollowSets000.FOLLOW_54_in_ruleMapLiteralExpCS4029); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getMapLiteralExpCSAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1673:1: ( ( (lv_ownedParts_2_0= ruleMapLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) ) )* )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( ((LA24_0>=RULE_SIMPLE_ID && LA24_0<=RULE_SINGLE_QUOTED_STRING)||(LA24_0>=16 && LA24_0<=18)||(LA24_0>=35 && LA24_0<=50)||LA24_0==58||(LA24_0>=60 && LA24_0<=63)||LA24_0==71||(LA24_0>=76 && LA24_0<=77)) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1673:2: ( (lv_ownedParts_2_0= ruleMapLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) ) )*
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1673:2: ( (lv_ownedParts_2_0= ruleMapLiteralPartCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1674:1: (lv_ownedParts_2_0= ruleMapLiteralPartCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1674:1: (lv_ownedParts_2_0= ruleMapLiteralPartCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1675:3: lv_ownedParts_2_0= ruleMapLiteralPartCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMapLiteralExpCSAccess().getOwnedPartsMapLiteralPartCSParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMapLiteralPartCS_in_ruleMapLiteralExpCS4051);
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

                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1691:2: (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) ) )*
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==52) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1691:4: otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) )
                    	    {
                    	    otherlv_3=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleMapLiteralExpCS4064); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getMapLiteralExpCSAccess().getCommaKeyword_2_1_0());
                    	          
                    	    }
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1695:1: ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) )
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1696:1: (lv_ownedParts_4_0= ruleMapLiteralPartCS )
                    	    {
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1696:1: (lv_ownedParts_4_0= ruleMapLiteralPartCS )
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1697:3: lv_ownedParts_4_0= ruleMapLiteralPartCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getMapLiteralExpCSAccess().getOwnedPartsMapLiteralPartCSParserRuleCall_2_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleMapLiteralPartCS_in_ruleMapLiteralExpCS4085);
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
                    	    break loop23;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleMapLiteralExpCS4101); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1725:1: entryRuleMapLiteralPartCS returns [EObject current=null] : iv_ruleMapLiteralPartCS= ruleMapLiteralPartCS EOF ;
    public final EObject entryRuleMapLiteralPartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMapLiteralPartCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1726:2: (iv_ruleMapLiteralPartCS= ruleMapLiteralPartCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1727:2: iv_ruleMapLiteralPartCS= ruleMapLiteralPartCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMapLiteralPartCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMapLiteralPartCS_in_entryRuleMapLiteralPartCS4137);
            iv_ruleMapLiteralPartCS=ruleMapLiteralPartCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMapLiteralPartCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMapLiteralPartCS4147); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1734:1: ruleMapLiteralPartCS returns [EObject current=null] : ( ( (lv_ownedKey_0_0= ruleExpCS ) ) otherlv_1= '<-' ( (lv_ownedValue_2_0= ruleExpCS ) ) ) ;
    public final EObject ruleMapLiteralPartCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_ownedKey_0_0 = null;

        EObject lv_ownedValue_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1737:28: ( ( ( (lv_ownedKey_0_0= ruleExpCS ) ) otherlv_1= '<-' ( (lv_ownedValue_2_0= ruleExpCS ) ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1738:1: ( ( (lv_ownedKey_0_0= ruleExpCS ) ) otherlv_1= '<-' ( (lv_ownedValue_2_0= ruleExpCS ) ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1738:1: ( ( (lv_ownedKey_0_0= ruleExpCS ) ) otherlv_1= '<-' ( (lv_ownedValue_2_0= ruleExpCS ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1738:2: ( (lv_ownedKey_0_0= ruleExpCS ) ) otherlv_1= '<-' ( (lv_ownedValue_2_0= ruleExpCS ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1738:2: ( (lv_ownedKey_0_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1739:1: (lv_ownedKey_0_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1739:1: (lv_ownedKey_0_0= ruleExpCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1740:3: lv_ownedKey_0_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMapLiteralPartCSAccess().getOwnedKeyExpCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleMapLiteralPartCS4193);
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

            otherlv_1=(Token)match(input,59,FollowSets000.FOLLOW_59_in_ruleMapLiteralPartCS4205); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getMapLiteralPartCSAccess().getLessThanSignHyphenMinusKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1760:1: ( (lv_ownedValue_2_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1761:1: (lv_ownedValue_2_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1761:1: (lv_ownedValue_2_0= ruleExpCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1762:3: lv_ownedValue_2_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMapLiteralPartCSAccess().getOwnedValueExpCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleMapLiteralPartCS4226);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1786:1: entryRulePrimitiveLiteralExpCS returns [EObject current=null] : iv_rulePrimitiveLiteralExpCS= rulePrimitiveLiteralExpCS EOF ;
    public final EObject entryRulePrimitiveLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1787:2: (iv_rulePrimitiveLiteralExpCS= rulePrimitiveLiteralExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1788:2: iv_rulePrimitiveLiteralExpCS= rulePrimitiveLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePrimitiveLiteralExpCS_in_entryRulePrimitiveLiteralExpCS4262);
            iv_rulePrimitiveLiteralExpCS=rulePrimitiveLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimitiveLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrimitiveLiteralExpCS4272); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1795:1: rulePrimitiveLiteralExpCS returns [EObject current=null] : (this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS | this_StringLiteralExpCS_1= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_5= ruleNullLiteralExpCS ) ;
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
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1798:28: ( (this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS | this_StringLiteralExpCS_1= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_5= ruleNullLiteralExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1799:1: (this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS | this_StringLiteralExpCS_1= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_5= ruleNullLiteralExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1799:1: (this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS | this_StringLiteralExpCS_1= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_5= ruleNullLiteralExpCS )
            int alt25=6;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt25=1;
                }
                break;
            case RULE_SINGLE_QUOTED_STRING:
                {
                alt25=2;
                }
                break;
            case 60:
            case 61:
                {
                alt25=3;
                }
                break;
            case 18:
                {
                alt25=4;
                }
                break;
            case 62:
                {
                alt25=5;
                }
                break;
            case 63:
                {
                alt25=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }

            switch (alt25) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1800:2: this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getNumberLiteralExpCSParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNumberLiteralExpCS_in_rulePrimitiveLiteralExpCS4322);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1813:2: this_StringLiteralExpCS_1= ruleStringLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getStringLiteralExpCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleStringLiteralExpCS_in_rulePrimitiveLiteralExpCS4352);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1826:2: this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getBooleanLiteralExpCSParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleBooleanLiteralExpCS_in_rulePrimitiveLiteralExpCS4382);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1839:2: this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getUnlimitedNaturalLiteralExpCSParserRuleCall_3()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUnlimitedNaturalLiteralExpCS_in_rulePrimitiveLiteralExpCS4412);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1852:2: this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getInvalidLiteralExpCSParserRuleCall_4()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleInvalidLiteralExpCS_in_rulePrimitiveLiteralExpCS4442);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1865:2: this_NullLiteralExpCS_5= ruleNullLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getNullLiteralExpCSParserRuleCall_5()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNullLiteralExpCS_in_rulePrimitiveLiteralExpCS4472);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1884:1: entryRuleTupleLiteralExpCS returns [EObject current=null] : iv_ruleTupleLiteralExpCS= ruleTupleLiteralExpCS EOF ;
    public final EObject entryRuleTupleLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTupleLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1885:2: (iv_ruleTupleLiteralExpCS= ruleTupleLiteralExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1886:2: iv_ruleTupleLiteralExpCS= ruleTupleLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTupleLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralExpCS_in_entryRuleTupleLiteralExpCS4507);
            iv_ruleTupleLiteralExpCS=ruleTupleLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTupleLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTupleLiteralExpCS4517); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1893:1: ruleTupleLiteralExpCS returns [EObject current=null] : (otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}' ) ;
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
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1896:28: ( (otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1897:1: (otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1897:1: (otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1897:3: otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleTupleLiteralExpCS4554); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getTupleLiteralExpCSAccess().getTupleKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,54,FollowSets000.FOLLOW_54_in_ruleTupleLiteralExpCS4566); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getTupleLiteralExpCSAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1905:1: ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1906:1: (lv_ownedParts_2_0= ruleTupleLiteralPartCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1906:1: (lv_ownedParts_2_0= ruleTupleLiteralPartCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1907:3: lv_ownedParts_2_0= ruleTupleLiteralPartCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTupleLiteralExpCSAccess().getOwnedPartsTupleLiteralPartCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralPartCS_in_ruleTupleLiteralExpCS4587);
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1923:2: (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==52) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1923:4: otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) )
            	    {
            	    otherlv_3=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleTupleLiteralExpCS4600); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getTupleLiteralExpCSAccess().getCommaKeyword_3_0());
            	          
            	    }
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1927:1: ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) )
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1928:1: (lv_ownedParts_4_0= ruleTupleLiteralPartCS )
            	    {
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1928:1: (lv_ownedParts_4_0= ruleTupleLiteralPartCS )
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1929:3: lv_ownedParts_4_0= ruleTupleLiteralPartCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTupleLiteralExpCSAccess().getOwnedPartsTupleLiteralPartCSParserRuleCall_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralPartCS_in_ruleTupleLiteralExpCS4621);
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
            	    break loop26;
                }
            } while (true);

            otherlv_5=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleTupleLiteralExpCS4635); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1957:1: entryRuleTupleLiteralPartCS returns [EObject current=null] : iv_ruleTupleLiteralPartCS= ruleTupleLiteralPartCS EOF ;
    public final EObject entryRuleTupleLiteralPartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTupleLiteralPartCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1958:2: (iv_ruleTupleLiteralPartCS= ruleTupleLiteralPartCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1959:2: iv_ruleTupleLiteralPartCS= ruleTupleLiteralPartCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTupleLiteralPartCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralPartCS_in_entryRuleTupleLiteralPartCS4671);
            iv_ruleTupleLiteralPartCS=ruleTupleLiteralPartCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTupleLiteralPartCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTupleLiteralPartCS4681); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1966:1: ruleTupleLiteralPartCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) ) ;
    public final EObject ruleTupleLiteralPartCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;

        EObject lv_ownedInitExpression_4_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1969:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1970:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1970:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1970:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1970:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1971:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1971:1: (lv_name_0_0= ruleUnrestrictedName )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1972:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTupleLiteralPartCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleTupleLiteralPartCS4727);
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1988:2: (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==53) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1988:4: otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                    {
                    otherlv_1=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleTupleLiteralPartCS4740); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getTupleLiteralPartCSAccess().getColonKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1992:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1993:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1993:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1994:3: lv_ownedType_2_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTupleLiteralPartCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleTupleLiteralPartCS4761);
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

            otherlv_3=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleTupleLiteralPartCS4775); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getTupleLiteralPartCSAccess().getEqualsSignKeyword_2());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2014:1: ( (lv_ownedInitExpression_4_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2015:1: (lv_ownedInitExpression_4_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2015:1: (lv_ownedInitExpression_4_0= ruleExpCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2016:3: lv_ownedInitExpression_4_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTupleLiteralPartCSAccess().getOwnedInitExpressionExpCSParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleTupleLiteralPartCS4796);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2040:1: entryRuleNumberLiteralExpCS returns [EObject current=null] : iv_ruleNumberLiteralExpCS= ruleNumberLiteralExpCS EOF ;
    public final EObject entryRuleNumberLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2041:2: (iv_ruleNumberLiteralExpCS= ruleNumberLiteralExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2042:2: iv_ruleNumberLiteralExpCS= ruleNumberLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumberLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNumberLiteralExpCS_in_entryRuleNumberLiteralExpCS4832);
            iv_ruleNumberLiteralExpCS=ruleNumberLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumberLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNumberLiteralExpCS4842); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2049:1: ruleNumberLiteralExpCS returns [EObject current=null] : ( (lv_symbol_0_0= ruleNUMBER_LITERAL ) ) ;
    public final EObject ruleNumberLiteralExpCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_symbol_0_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2052:28: ( ( (lv_symbol_0_0= ruleNUMBER_LITERAL ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2053:1: ( (lv_symbol_0_0= ruleNUMBER_LITERAL ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2053:1: ( (lv_symbol_0_0= ruleNUMBER_LITERAL ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2054:1: (lv_symbol_0_0= ruleNUMBER_LITERAL )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2054:1: (lv_symbol_0_0= ruleNUMBER_LITERAL )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2055:3: lv_symbol_0_0= ruleNUMBER_LITERAL
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNumberLiteralExpCSAccess().getSymbolNUMBER_LITERALParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleNUMBER_LITERAL_in_ruleNumberLiteralExpCS4887);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2079:1: entryRuleStringLiteralExpCS returns [EObject current=null] : iv_ruleStringLiteralExpCS= ruleStringLiteralExpCS EOF ;
    public final EObject entryRuleStringLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2080:2: (iv_ruleStringLiteralExpCS= ruleStringLiteralExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2081:2: iv_ruleStringLiteralExpCS= ruleStringLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStringLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleStringLiteralExpCS_in_entryRuleStringLiteralExpCS4922);
            iv_ruleStringLiteralExpCS=ruleStringLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStringLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleStringLiteralExpCS4932); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2088:1: ruleStringLiteralExpCS returns [EObject current=null] : ( (lv_segments_0_0= ruleStringLiteral ) )+ ;
    public final EObject ruleStringLiteralExpCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_segments_0_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2091:28: ( ( (lv_segments_0_0= ruleStringLiteral ) )+ )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2092:1: ( (lv_segments_0_0= ruleStringLiteral ) )+
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2092:1: ( (lv_segments_0_0= ruleStringLiteral ) )+
            int cnt28=0;
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==RULE_SINGLE_QUOTED_STRING) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2093:1: (lv_segments_0_0= ruleStringLiteral )
            	    {
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2093:1: (lv_segments_0_0= ruleStringLiteral )
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2094:3: lv_segments_0_0= ruleStringLiteral
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getStringLiteralExpCSAccess().getSegmentsStringLiteralParserRuleCall_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleStringLiteral_in_ruleStringLiteralExpCS4977);
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
            	    if ( cnt28 >= 1 ) break loop28;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(28, input);
                        throw eee;
                }
                cnt28++;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2118:1: entryRuleBooleanLiteralExpCS returns [EObject current=null] : iv_ruleBooleanLiteralExpCS= ruleBooleanLiteralExpCS EOF ;
    public final EObject entryRuleBooleanLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2119:2: (iv_ruleBooleanLiteralExpCS= ruleBooleanLiteralExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2120:2: iv_ruleBooleanLiteralExpCS= ruleBooleanLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBooleanLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleBooleanLiteralExpCS_in_entryRuleBooleanLiteralExpCS5013);
            iv_ruleBooleanLiteralExpCS=ruleBooleanLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBooleanLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBooleanLiteralExpCS5023); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2127:1: ruleBooleanLiteralExpCS returns [EObject current=null] : ( ( (lv_symbol_0_0= 'true' ) ) | ( (lv_symbol_1_0= 'false' ) ) ) ;
    public final EObject ruleBooleanLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token lv_symbol_0_0=null;
        Token lv_symbol_1_0=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2130:28: ( ( ( (lv_symbol_0_0= 'true' ) ) | ( (lv_symbol_1_0= 'false' ) ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2131:1: ( ( (lv_symbol_0_0= 'true' ) ) | ( (lv_symbol_1_0= 'false' ) ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2131:1: ( ( (lv_symbol_0_0= 'true' ) ) | ( (lv_symbol_1_0= 'false' ) ) )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==60) ) {
                alt29=1;
            }
            else if ( (LA29_0==61) ) {
                alt29=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2131:2: ( (lv_symbol_0_0= 'true' ) )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2131:2: ( (lv_symbol_0_0= 'true' ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2132:1: (lv_symbol_0_0= 'true' )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2132:1: (lv_symbol_0_0= 'true' )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2133:3: lv_symbol_0_0= 'true'
                    {
                    lv_symbol_0_0=(Token)match(input,60,FollowSets000.FOLLOW_60_in_ruleBooleanLiteralExpCS5066); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2147:6: ( (lv_symbol_1_0= 'false' ) )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2147:6: ( (lv_symbol_1_0= 'false' ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2148:1: (lv_symbol_1_0= 'false' )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2148:1: (lv_symbol_1_0= 'false' )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2149:3: lv_symbol_1_0= 'false'
                    {
                    lv_symbol_1_0=(Token)match(input,61,FollowSets000.FOLLOW_61_in_ruleBooleanLiteralExpCS5103); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2170:1: entryRuleUnlimitedNaturalLiteralExpCS returns [EObject current=null] : iv_ruleUnlimitedNaturalLiteralExpCS= ruleUnlimitedNaturalLiteralExpCS EOF ;
    public final EObject entryRuleUnlimitedNaturalLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnlimitedNaturalLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2171:2: (iv_ruleUnlimitedNaturalLiteralExpCS= ruleUnlimitedNaturalLiteralExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2172:2: iv_ruleUnlimitedNaturalLiteralExpCS= ruleUnlimitedNaturalLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnlimitedNaturalLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnlimitedNaturalLiteralExpCS_in_entryRuleUnlimitedNaturalLiteralExpCS5152);
            iv_ruleUnlimitedNaturalLiteralExpCS=ruleUnlimitedNaturalLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnlimitedNaturalLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnlimitedNaturalLiteralExpCS5162); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2179:1: ruleUnlimitedNaturalLiteralExpCS returns [EObject current=null] : ( () otherlv_1= '*' ) ;
    public final EObject ruleUnlimitedNaturalLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2182:28: ( ( () otherlv_1= '*' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2183:1: ( () otherlv_1= '*' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2183:1: ( () otherlv_1= '*' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2183:2: () otherlv_1= '*'
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2183:2: ()
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2184:2: 
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

            otherlv_1=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleUnlimitedNaturalLiteralExpCS5211); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2204:1: entryRuleInvalidLiteralExpCS returns [EObject current=null] : iv_ruleInvalidLiteralExpCS= ruleInvalidLiteralExpCS EOF ;
    public final EObject entryRuleInvalidLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInvalidLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2205:2: (iv_ruleInvalidLiteralExpCS= ruleInvalidLiteralExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2206:2: iv_ruleInvalidLiteralExpCS= ruleInvalidLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInvalidLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleInvalidLiteralExpCS_in_entryRuleInvalidLiteralExpCS5247);
            iv_ruleInvalidLiteralExpCS=ruleInvalidLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInvalidLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleInvalidLiteralExpCS5257); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2213:1: ruleInvalidLiteralExpCS returns [EObject current=null] : ( () otherlv_1= 'invalid' ) ;
    public final EObject ruleInvalidLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2216:28: ( ( () otherlv_1= 'invalid' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2217:1: ( () otherlv_1= 'invalid' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2217:1: ( () otherlv_1= 'invalid' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2217:2: () otherlv_1= 'invalid'
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2217:2: ()
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2218:2: 
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

            otherlv_1=(Token)match(input,62,FollowSets000.FOLLOW_62_in_ruleInvalidLiteralExpCS5306); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2238:1: entryRuleNullLiteralExpCS returns [EObject current=null] : iv_ruleNullLiteralExpCS= ruleNullLiteralExpCS EOF ;
    public final EObject entryRuleNullLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2239:2: (iv_ruleNullLiteralExpCS= ruleNullLiteralExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2240:2: iv_ruleNullLiteralExpCS= ruleNullLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNullLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNullLiteralExpCS_in_entryRuleNullLiteralExpCS5342);
            iv_ruleNullLiteralExpCS=ruleNullLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNullLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNullLiteralExpCS5352); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2247:1: ruleNullLiteralExpCS returns [EObject current=null] : ( () otherlv_1= 'null' ) ;
    public final EObject ruleNullLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2250:28: ( ( () otherlv_1= 'null' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2251:1: ( () otherlv_1= 'null' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2251:1: ( () otherlv_1= 'null' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2251:2: () otherlv_1= 'null'
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2251:2: ()
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2252:2: 
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

            otherlv_1=(Token)match(input,63,FollowSets000.FOLLOW_63_in_ruleNullLiteralExpCS5401); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2272:1: entryRuleTypeLiteralCS returns [EObject current=null] : iv_ruleTypeLiteralCS= ruleTypeLiteralCS EOF ;
    public final EObject entryRuleTypeLiteralCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeLiteralCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2273:2: (iv_ruleTypeLiteralCS= ruleTypeLiteralCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2274:2: iv_ruleTypeLiteralCS= ruleTypeLiteralCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeLiteralCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralCS_in_entryRuleTypeLiteralCS5437);
            iv_ruleTypeLiteralCS=ruleTypeLiteralCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeLiteralCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeLiteralCS5447); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2281:1: ruleTypeLiteralCS returns [EObject current=null] : ( (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS ( (lv_ownedMultiplicity_1_0= ruleSimpleMultiplicityCS ) )? ) | this_CollectionTypeCS_2= ruleCollectionTypeCS | (this_MapTypeCS_3= ruleMapTypeCS ( (lv_ownedMultiplicity_4_0= ruleSimpleMultiplicityCS ) )? ) | (this_TupleTypeCS_5= ruleTupleTypeCS ( (lv_ownedMultiplicity_6_0= ruleSimpleMultiplicityCS ) )? ) ) ;
    public final EObject ruleTypeLiteralCS() throws RecognitionException {
        EObject current = null;

        EObject this_PrimitiveTypeCS_0 = null;

        EObject lv_ownedMultiplicity_1_0 = null;

        EObject this_CollectionTypeCS_2 = null;

        EObject this_MapTypeCS_3 = null;

        EObject lv_ownedMultiplicity_4_0 = null;

        EObject this_TupleTypeCS_5 = null;

        EObject lv_ownedMultiplicity_6_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2284:28: ( ( (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS ( (lv_ownedMultiplicity_1_0= ruleSimpleMultiplicityCS ) )? ) | this_CollectionTypeCS_2= ruleCollectionTypeCS | (this_MapTypeCS_3= ruleMapTypeCS ( (lv_ownedMultiplicity_4_0= ruleSimpleMultiplicityCS ) )? ) | (this_TupleTypeCS_5= ruleTupleTypeCS ( (lv_ownedMultiplicity_6_0= ruleSimpleMultiplicityCS ) )? ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2285:1: ( (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS ( (lv_ownedMultiplicity_1_0= ruleSimpleMultiplicityCS ) )? ) | this_CollectionTypeCS_2= ruleCollectionTypeCS | (this_MapTypeCS_3= ruleMapTypeCS ( (lv_ownedMultiplicity_4_0= ruleSimpleMultiplicityCS ) )? ) | (this_TupleTypeCS_5= ruleTupleTypeCS ( (lv_ownedMultiplicity_6_0= ruleSimpleMultiplicityCS ) )? ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2285:1: ( (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS ( (lv_ownedMultiplicity_1_0= ruleSimpleMultiplicityCS ) )? ) | this_CollectionTypeCS_2= ruleCollectionTypeCS | (this_MapTypeCS_3= ruleMapTypeCS ( (lv_ownedMultiplicity_4_0= ruleSimpleMultiplicityCS ) )? ) | (this_TupleTypeCS_5= ruleTupleTypeCS ( (lv_ownedMultiplicity_6_0= ruleSimpleMultiplicityCS ) )? ) )
            int alt33=4;
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
                alt33=1;
                }
                break;
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
                {
                alt33=2;
                }
                break;
            case 35:
                {
                alt33=3;
                }
                break;
            case 36:
                {
                alt33=4;
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2285:2: (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS ( (lv_ownedMultiplicity_1_0= ruleSimpleMultiplicityCS ) )? )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2285:2: (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS ( (lv_ownedMultiplicity_1_0= ruleSimpleMultiplicityCS ) )? )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2286:2: this_PrimitiveTypeCS_0= rulePrimitiveTypeCS ( (lv_ownedMultiplicity_1_0= ruleSimpleMultiplicityCS ) )?
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeLiteralCSAccess().getPrimitiveTypeCSParserRuleCall_0_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrimitiveTypeCS_in_ruleTypeLiteralCS5498);
                    this_PrimitiveTypeCS_0=rulePrimitiveTypeCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_PrimitiveTypeCS_0; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2297:1: ( (lv_ownedMultiplicity_1_0= ruleSimpleMultiplicityCS ) )?
                    int alt30=2;
                    int LA30_0 = input.LA(1);

                    if ( (LA30_0==66) ) {
                        alt30=1;
                    }
                    switch (alt30) {
                        case 1 :
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2298:1: (lv_ownedMultiplicity_1_0= ruleSimpleMultiplicityCS )
                            {
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2298:1: (lv_ownedMultiplicity_1_0= ruleSimpleMultiplicityCS )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2299:3: lv_ownedMultiplicity_1_0= ruleSimpleMultiplicityCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getTypeLiteralCSAccess().getOwnedMultiplicitySimpleMultiplicityCSParserRuleCall_0_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleSimpleMultiplicityCS_in_ruleTypeLiteralCS5518);
                            lv_ownedMultiplicity_1_0=ruleSimpleMultiplicityCS();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getTypeLiteralCSRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"ownedMultiplicity",
                                      		lv_ownedMultiplicity_1_0, 
                                      		"SimpleMultiplicityCS");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2317:2: this_CollectionTypeCS_2= ruleCollectionTypeCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeLiteralCSAccess().getCollectionTypeCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCollectionTypeCS_in_ruleTypeLiteralCS5551);
                    this_CollectionTypeCS_2=ruleCollectionTypeCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_CollectionTypeCS_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2329:6: (this_MapTypeCS_3= ruleMapTypeCS ( (lv_ownedMultiplicity_4_0= ruleSimpleMultiplicityCS ) )? )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2329:6: (this_MapTypeCS_3= ruleMapTypeCS ( (lv_ownedMultiplicity_4_0= ruleSimpleMultiplicityCS ) )? )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2330:2: this_MapTypeCS_3= ruleMapTypeCS ( (lv_ownedMultiplicity_4_0= ruleSimpleMultiplicityCS ) )?
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeLiteralCSAccess().getMapTypeCSParserRuleCall_2_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMapTypeCS_in_ruleTypeLiteralCS5582);
                    this_MapTypeCS_3=ruleMapTypeCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_MapTypeCS_3; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2341:1: ( (lv_ownedMultiplicity_4_0= ruleSimpleMultiplicityCS ) )?
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==66) ) {
                        alt31=1;
                    }
                    switch (alt31) {
                        case 1 :
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2342:1: (lv_ownedMultiplicity_4_0= ruleSimpleMultiplicityCS )
                            {
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2342:1: (lv_ownedMultiplicity_4_0= ruleSimpleMultiplicityCS )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2343:3: lv_ownedMultiplicity_4_0= ruleSimpleMultiplicityCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getTypeLiteralCSAccess().getOwnedMultiplicitySimpleMultiplicityCSParserRuleCall_2_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleSimpleMultiplicityCS_in_ruleTypeLiteralCS5602);
                            lv_ownedMultiplicity_4_0=ruleSimpleMultiplicityCS();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getTypeLiteralCSRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"ownedMultiplicity",
                                      		lv_ownedMultiplicity_4_0, 
                                      		"SimpleMultiplicityCS");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 4 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2360:6: (this_TupleTypeCS_5= ruleTupleTypeCS ( (lv_ownedMultiplicity_6_0= ruleSimpleMultiplicityCS ) )? )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2360:6: (this_TupleTypeCS_5= ruleTupleTypeCS ( (lv_ownedMultiplicity_6_0= ruleSimpleMultiplicityCS ) )? )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2361:2: this_TupleTypeCS_5= ruleTupleTypeCS ( (lv_ownedMultiplicity_6_0= ruleSimpleMultiplicityCS ) )?
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeLiteralCSAccess().getTupleTypeCSParserRuleCall_3_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTupleTypeCS_in_ruleTypeLiteralCS5636);
                    this_TupleTypeCS_5=ruleTupleTypeCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_TupleTypeCS_5; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2372:1: ( (lv_ownedMultiplicity_6_0= ruleSimpleMultiplicityCS ) )?
                    int alt32=2;
                    int LA32_0 = input.LA(1);

                    if ( (LA32_0==66) ) {
                        alt32=1;
                    }
                    switch (alt32) {
                        case 1 :
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2373:1: (lv_ownedMultiplicity_6_0= ruleSimpleMultiplicityCS )
                            {
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2373:1: (lv_ownedMultiplicity_6_0= ruleSimpleMultiplicityCS )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2374:3: lv_ownedMultiplicity_6_0= ruleSimpleMultiplicityCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getTypeLiteralCSAccess().getOwnedMultiplicitySimpleMultiplicityCSParserRuleCall_3_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleSimpleMultiplicityCS_in_ruleTypeLiteralCS5656);
                            lv_ownedMultiplicity_6_0=ruleSimpleMultiplicityCS();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getTypeLiteralCSRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"ownedMultiplicity",
                                      		lv_ownedMultiplicity_6_0, 
                                      		"SimpleMultiplicityCS");
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
    // $ANTLR end "ruleTypeLiteralCS"


    // $ANTLR start "entryRuleTypeLiteralExpCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2398:1: entryRuleTypeLiteralExpCS returns [EObject current=null] : iv_ruleTypeLiteralExpCS= ruleTypeLiteralExpCS EOF ;
    public final EObject entryRuleTypeLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeLiteralExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2399:2: (iv_ruleTypeLiteralExpCS= ruleTypeLiteralExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2400:2: iv_ruleTypeLiteralExpCS= ruleTypeLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralExpCS_in_entryRuleTypeLiteralExpCS5694);
            iv_ruleTypeLiteralExpCS=ruleTypeLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeLiteralExpCS5704); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2407:1: ruleTypeLiteralExpCS returns [EObject current=null] : ( (lv_ownedType_0_0= ruleTypeLiteralCS ) ) ;
    public final EObject ruleTypeLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject lv_ownedType_0_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2410:28: ( ( (lv_ownedType_0_0= ruleTypeLiteralCS ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2411:1: ( (lv_ownedType_0_0= ruleTypeLiteralCS ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2411:1: ( (lv_ownedType_0_0= ruleTypeLiteralCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2412:1: (lv_ownedType_0_0= ruleTypeLiteralCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2412:1: (lv_ownedType_0_0= ruleTypeLiteralCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2413:3: lv_ownedType_0_0= ruleTypeLiteralCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypeLiteralExpCSAccess().getOwnedTypeTypeLiteralCSParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralCS_in_ruleTypeLiteralExpCS5749);
            lv_ownedType_0_0=ruleTypeLiteralCS();

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
                      		"TypeLiteralCS");
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2437:1: entryRuleTypeNameExpCS returns [EObject current=null] : iv_ruleTypeNameExpCS= ruleTypeNameExpCS EOF ;
    public final EObject entryRuleTypeNameExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeNameExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2438:2: (iv_ruleTypeNameExpCS= ruleTypeNameExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2439:2: iv_ruleTypeNameExpCS= ruleTypeNameExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeNameExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeNameExpCS_in_entryRuleTypeNameExpCS5784);
            iv_ruleTypeNameExpCS=ruleTypeNameExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeNameExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeNameExpCS5794); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2446:1: ruleTypeNameExpCS returns [EObject current=null] : ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( ( (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS ) ) (otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}' )? )? ( (lv_ownedMultiplicity_5_0= ruleSimpleMultiplicityCS ) )? ) ;
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
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2449:28: ( ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( ( (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS ) ) (otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}' )? )? ( (lv_ownedMultiplicity_5_0= ruleSimpleMultiplicityCS ) )? ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2450:1: ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( ( (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS ) ) (otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}' )? )? ( (lv_ownedMultiplicity_5_0= ruleSimpleMultiplicityCS ) )? )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2450:1: ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( ( (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS ) ) (otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}' )? )? ( (lv_ownedMultiplicity_5_0= ruleSimpleMultiplicityCS ) )? )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2450:2: ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( ( (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS ) ) (otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}' )? )? ( (lv_ownedMultiplicity_5_0= ruleSimpleMultiplicityCS ) )?
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2450:2: ( (lv_ownedPathName_0_0= rulePathNameCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2451:1: (lv_ownedPathName_0_0= rulePathNameCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2451:1: (lv_ownedPathName_0_0= rulePathNameCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2452:3: lv_ownedPathName_0_0= rulePathNameCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypeNameExpCSAccess().getOwnedPathNamePathNameCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_rulePathNameCS_in_ruleTypeNameExpCS5840);
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2468:2: ( ( (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS ) ) (otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}' )? )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==54) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2468:3: ( (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS ) ) (otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}' )?
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2468:3: ( (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2469:1: (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2469:1: (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2470:3: lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeNameExpCSAccess().getOwnedCurlyBracketedClauseCurlyBracketedClauseCSParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCurlyBracketedClauseCS_in_ruleTypeNameExpCS5862);
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

                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2486:2: (otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}' )?
                    int alt34=2;
                    int LA34_0 = input.LA(1);

                    if ( (LA34_0==54) ) {
                        alt34=1;
                    }
                    switch (alt34) {
                        case 1 :
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2486:4: otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}'
                            {
                            otherlv_2=(Token)match(input,54,FollowSets000.FOLLOW_54_in_ruleTypeNameExpCS5875); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_2, grammarAccess.getTypeNameExpCSAccess().getLeftCurlyBracketKeyword_1_1_0());
                                  
                            }
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2490:1: ( (lv_ownedPatternGuard_3_0= ruleExpCS ) )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2491:1: (lv_ownedPatternGuard_3_0= ruleExpCS )
                            {
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2491:1: (lv_ownedPatternGuard_3_0= ruleExpCS )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2492:3: lv_ownedPatternGuard_3_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getTypeNameExpCSAccess().getOwnedPatternGuardExpCSParserRuleCall_1_1_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleTypeNameExpCS5896);
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

                            otherlv_4=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleTypeNameExpCS5908); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getTypeNameExpCSAccess().getRightCurlyBracketKeyword_1_1_2());
                                  
                            }

                            }
                            break;

                    }


                    }
                    break;

            }

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2512:5: ( (lv_ownedMultiplicity_5_0= ruleSimpleMultiplicityCS ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==66) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2513:1: (lv_ownedMultiplicity_5_0= ruleSimpleMultiplicityCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2513:1: (lv_ownedMultiplicity_5_0= ruleSimpleMultiplicityCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2514:3: lv_ownedMultiplicity_5_0= ruleSimpleMultiplicityCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeNameExpCSAccess().getOwnedMultiplicitySimpleMultiplicityCSParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSimpleMultiplicityCS_in_ruleTypeNameExpCS5933);
                    lv_ownedMultiplicity_5_0=ruleSimpleMultiplicityCS();

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
                              		"SimpleMultiplicityCS");
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2538:1: entryRuleTypeExpCS returns [EObject current=null] : iv_ruleTypeExpCS= ruleTypeExpCS EOF ;
    public final EObject entryRuleTypeExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2539:2: (iv_ruleTypeExpCS= ruleTypeExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2540:2: iv_ruleTypeExpCS= ruleTypeExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_entryRuleTypeExpCS5970);
            iv_ruleTypeExpCS=ruleTypeExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeExpCS5980); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2547:1: ruleTypeExpCS returns [EObject current=null] : (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS | this_CollectionPatternCS_2= ruleCollectionPatternCS ) ;
    public final EObject ruleTypeExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_TypeNameExpCS_0 = null;

        EObject this_TypeLiteralCS_1 = null;

        EObject this_CollectionPatternCS_2 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2550:28: ( (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS | this_CollectionPatternCS_2= ruleCollectionPatternCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2551:1: (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS | this_CollectionPatternCS_2= ruleCollectionPatternCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2551:1: (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS | this_CollectionPatternCS_2= ruleCollectionPatternCS )
            int alt37=3;
            alt37 = dfa37.predict(input);
            switch (alt37) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2552:2: this_TypeNameExpCS_0= ruleTypeNameExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeExpCSAccess().getTypeNameExpCSParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeNameExpCS_in_ruleTypeExpCS6030);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2565:2: this_TypeLiteralCS_1= ruleTypeLiteralCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeExpCSAccess().getTypeLiteralCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralCS_in_ruleTypeExpCS6060);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2578:2: this_CollectionPatternCS_2= ruleCollectionPatternCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeExpCSAccess().getCollectionPatternCSParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCollectionPatternCS_in_ruleTypeExpCS6090);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2597:1: entryRuleExpCS returns [EObject current=null] : iv_ruleExpCS= ruleExpCS EOF ;
    public final EObject entryRuleExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2598:2: (iv_ruleExpCS= ruleExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2599:2: iv_ruleExpCS= ruleExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_entryRuleExpCS6125);
            iv_ruleExpCS=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleExpCS6135); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2606:1: ruleExpCS returns [EObject current=null] : ( (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? ) | this_PrefixedLetExpCS_4= rulePrefixedLetExpCS ) ;
    public final EObject ruleExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_PrefixedPrimaryExpCS_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_ownedRight_3_0 = null;

        EObject this_PrefixedLetExpCS_4 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2609:28: ( ( (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? ) | this_PrefixedLetExpCS_4= rulePrefixedLetExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2610:1: ( (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? ) | this_PrefixedLetExpCS_4= rulePrefixedLetExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2610:1: ( (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? ) | this_PrefixedLetExpCS_4= rulePrefixedLetExpCS )
            int alt39=2;
            alt39 = dfa39.predict(input);
            switch (alt39) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2610:2: (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2610:2: (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2611:2: this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )?
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getExpCSAccess().getPrefixedPrimaryExpCSParserRuleCall_0_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrefixedPrimaryExpCS_in_ruleExpCS6186);
                    this_PrefixedPrimaryExpCS_0=rulePrefixedPrimaryExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_PrefixedPrimaryExpCS_0; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2622:1: ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )?
                    int alt38=2;
                    int LA38_0 = input.LA(1);

                    if ( (LA38_0==16||(LA38_0>=18 && LA38_0<=34)) ) {
                        alt38=1;
                    }
                    switch (alt38) {
                        case 1 :
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2622:2: () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) )
                            {
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2622:2: ()
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2623:2: 
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

                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2631:2: ( (lv_name_2_0= ruleBinaryOperatorName ) )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2632:1: (lv_name_2_0= ruleBinaryOperatorName )
                            {
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2632:1: (lv_name_2_0= ruleBinaryOperatorName )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2633:3: lv_name_2_0= ruleBinaryOperatorName
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getExpCSAccess().getNameBinaryOperatorNameParserRuleCall_0_1_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleBinaryOperatorName_in_ruleExpCS6219);
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

                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2649:2: ( (lv_ownedRight_3_0= ruleExpCS ) )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2650:1: (lv_ownedRight_3_0= ruleExpCS )
                            {
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2650:1: (lv_ownedRight_3_0= ruleExpCS )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2651:3: lv_ownedRight_3_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getExpCSAccess().getOwnedRightExpCSParserRuleCall_0_1_2_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleExpCS6240);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2669:2: this_PrefixedLetExpCS_4= rulePrefixedLetExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getExpCSAccess().getPrefixedLetExpCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrefixedLetExpCS_in_ruleExpCS6274);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2688:1: entryRulePrefixedLetExpCS returns [EObject current=null] : iv_rulePrefixedLetExpCS= rulePrefixedLetExpCS EOF ;
    public final EObject entryRulePrefixedLetExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrefixedLetExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2689:2: (iv_rulePrefixedLetExpCS= rulePrefixedLetExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2690:2: iv_rulePrefixedLetExpCS= rulePrefixedLetExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrefixedLetExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePrefixedLetExpCS_in_entryRulePrefixedLetExpCS6309);
            iv_rulePrefixedLetExpCS=rulePrefixedLetExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrefixedLetExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrefixedLetExpCS6319); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2697:1: rulePrefixedLetExpCS returns [EObject current=null] : ( ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedLetExpCS ) ) ) | this_LetExpCS_3= ruleLetExpCS ) ;
    public final EObject rulePrefixedLetExpCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_ownedRight_2_0 = null;

        EObject this_LetExpCS_3 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2700:28: ( ( ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedLetExpCS ) ) ) | this_LetExpCS_3= ruleLetExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2701:1: ( ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedLetExpCS ) ) ) | this_LetExpCS_3= ruleLetExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2701:1: ( ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedLetExpCS ) ) ) | this_LetExpCS_3= ruleLetExpCS )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( ((LA40_0>=16 && LA40_0<=17)) ) {
                alt40=1;
            }
            else if ( (LA40_0==76) ) {
                alt40=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2701:2: ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedLetExpCS ) ) )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2701:2: ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedLetExpCS ) ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2701:3: () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedLetExpCS ) )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2701:3: ()
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2702:2: 
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

                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2710:2: ( (lv_name_1_0= ruleUnaryOperatorName ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2711:1: (lv_name_1_0= ruleUnaryOperatorName )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2711:1: (lv_name_1_0= ruleUnaryOperatorName )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2712:3: lv_name_1_0= ruleUnaryOperatorName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrefixedLetExpCSAccess().getNameUnaryOperatorNameParserRuleCall_0_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUnaryOperatorName_in_rulePrefixedLetExpCS6378);
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

                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2728:2: ( (lv_ownedRight_2_0= rulePrefixedLetExpCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2729:1: (lv_ownedRight_2_0= rulePrefixedLetExpCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2729:1: (lv_ownedRight_2_0= rulePrefixedLetExpCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2730:3: lv_ownedRight_2_0= rulePrefixedLetExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrefixedLetExpCSAccess().getOwnedRightPrefixedLetExpCSParserRuleCall_0_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrefixedLetExpCS_in_rulePrefixedLetExpCS6399);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2748:2: this_LetExpCS_3= ruleLetExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrefixedLetExpCSAccess().getLetExpCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLetExpCS_in_rulePrefixedLetExpCS6431);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2767:1: entryRulePrefixedPrimaryExpCS returns [EObject current=null] : iv_rulePrefixedPrimaryExpCS= rulePrefixedPrimaryExpCS EOF ;
    public final EObject entryRulePrefixedPrimaryExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrefixedPrimaryExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2768:2: (iv_rulePrefixedPrimaryExpCS= rulePrefixedPrimaryExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2769:2: iv_rulePrefixedPrimaryExpCS= rulePrefixedPrimaryExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrefixedPrimaryExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePrefixedPrimaryExpCS_in_entryRulePrefixedPrimaryExpCS6466);
            iv_rulePrefixedPrimaryExpCS=rulePrefixedPrimaryExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrefixedPrimaryExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrefixedPrimaryExpCS6476); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2776:1: rulePrefixedPrimaryExpCS returns [EObject current=null] : ( ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS ) ) ) | this_PrimaryExpCS_3= rulePrimaryExpCS ) ;
    public final EObject rulePrefixedPrimaryExpCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_ownedRight_2_0 = null;

        EObject this_PrimaryExpCS_3 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2779:28: ( ( ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS ) ) ) | this_PrimaryExpCS_3= rulePrimaryExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2780:1: ( ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS ) ) ) | this_PrimaryExpCS_3= rulePrimaryExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2780:1: ( ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS ) ) ) | this_PrimaryExpCS_3= rulePrimaryExpCS )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( ((LA41_0>=16 && LA41_0<=17)) ) {
                alt41=1;
            }
            else if ( ((LA41_0>=RULE_SIMPLE_ID && LA41_0<=RULE_SINGLE_QUOTED_STRING)||LA41_0==18||(LA41_0>=35 && LA41_0<=50)||LA41_0==58||(LA41_0>=60 && LA41_0<=63)||LA41_0==71||LA41_0==77) ) {
                alt41=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }
            switch (alt41) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2780:2: ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS ) ) )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2780:2: ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS ) ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2780:3: () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS ) )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2780:3: ()
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2781:2: 
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

                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2789:2: ( (lv_name_1_0= ruleUnaryOperatorName ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2790:1: (lv_name_1_0= ruleUnaryOperatorName )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2790:1: (lv_name_1_0= ruleUnaryOperatorName )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2791:3: lv_name_1_0= ruleUnaryOperatorName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrefixedPrimaryExpCSAccess().getNameUnaryOperatorNameParserRuleCall_0_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUnaryOperatorName_in_rulePrefixedPrimaryExpCS6535);
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

                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2807:2: ( (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2808:1: (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2808:1: (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2809:3: lv_ownedRight_2_0= rulePrefixedPrimaryExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrefixedPrimaryExpCSAccess().getOwnedRightPrefixedPrimaryExpCSParserRuleCall_0_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrefixedPrimaryExpCS_in_rulePrefixedPrimaryExpCS6556);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2827:2: this_PrimaryExpCS_3= rulePrimaryExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrefixedPrimaryExpCSAccess().getPrimaryExpCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrimaryExpCS_in_rulePrefixedPrimaryExpCS6588);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2846:1: entryRulePrimaryExpCS returns [EObject current=null] : iv_rulePrimaryExpCS= rulePrimaryExpCS EOF ;
    public final EObject entryRulePrimaryExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2847:2: (iv_rulePrimaryExpCS= rulePrimaryExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2848:2: iv_rulePrimaryExpCS= rulePrimaryExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimaryExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePrimaryExpCS_in_entryRulePrimaryExpCS6623);
            iv_rulePrimaryExpCS=rulePrimaryExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimaryExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrimaryExpCS6633); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2855:1: rulePrimaryExpCS returns [EObject current=null] : (this_NestedExpCS_0= ruleNestedExpCS | this_IfExpCS_1= ruleIfExpCS | this_SelfExpCS_2= ruleSelfExpCS | this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS | this_MapLiteralExpCS_5= ruleMapLiteralExpCS | this_CollectionLiteralExpCS_6= ruleCollectionLiteralExpCS | this_LambdaLiteralExpCS_7= ruleLambdaLiteralExpCS | this_TypeLiteralExpCS_8= ruleTypeLiteralExpCS | this_NameExpCS_9= ruleNameExpCS ) ;
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
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2858:28: ( (this_NestedExpCS_0= ruleNestedExpCS | this_IfExpCS_1= ruleIfExpCS | this_SelfExpCS_2= ruleSelfExpCS | this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS | this_MapLiteralExpCS_5= ruleMapLiteralExpCS | this_CollectionLiteralExpCS_6= ruleCollectionLiteralExpCS | this_LambdaLiteralExpCS_7= ruleLambdaLiteralExpCS | this_TypeLiteralExpCS_8= ruleTypeLiteralExpCS | this_NameExpCS_9= ruleNameExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2859:1: (this_NestedExpCS_0= ruleNestedExpCS | this_IfExpCS_1= ruleIfExpCS | this_SelfExpCS_2= ruleSelfExpCS | this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS | this_MapLiteralExpCS_5= ruleMapLiteralExpCS | this_CollectionLiteralExpCS_6= ruleCollectionLiteralExpCS | this_LambdaLiteralExpCS_7= ruleLambdaLiteralExpCS | this_TypeLiteralExpCS_8= ruleTypeLiteralExpCS | this_NameExpCS_9= ruleNameExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2859:1: (this_NestedExpCS_0= ruleNestedExpCS | this_IfExpCS_1= ruleIfExpCS | this_SelfExpCS_2= ruleSelfExpCS | this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS | this_MapLiteralExpCS_5= ruleMapLiteralExpCS | this_CollectionLiteralExpCS_6= ruleCollectionLiteralExpCS | this_LambdaLiteralExpCS_7= ruleLambdaLiteralExpCS | this_TypeLiteralExpCS_8= ruleTypeLiteralExpCS | this_NameExpCS_9= ruleNameExpCS )
            int alt42=10;
            alt42 = dfa42.predict(input);
            switch (alt42) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2860:2: this_NestedExpCS_0= ruleNestedExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getNestedExpCSParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNestedExpCS_in_rulePrimaryExpCS6683);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2873:2: this_IfExpCS_1= ruleIfExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getIfExpCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleIfExpCS_in_rulePrimaryExpCS6713);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2886:2: this_SelfExpCS_2= ruleSelfExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getSelfExpCSParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSelfExpCS_in_rulePrimaryExpCS6743);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2899:2: this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getPrimitiveLiteralExpCSParserRuleCall_3()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrimitiveLiteralExpCS_in_rulePrimaryExpCS6773);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2912:2: this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getTupleLiteralExpCSParserRuleCall_4()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralExpCS_in_rulePrimaryExpCS6803);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2925:2: this_MapLiteralExpCS_5= ruleMapLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getMapLiteralExpCSParserRuleCall_5()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMapLiteralExpCS_in_rulePrimaryExpCS6833);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2938:2: this_CollectionLiteralExpCS_6= ruleCollectionLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getCollectionLiteralExpCSParserRuleCall_6()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteralExpCS_in_rulePrimaryExpCS6863);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2951:2: this_LambdaLiteralExpCS_7= ruleLambdaLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getLambdaLiteralExpCSParserRuleCall_7()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLambdaLiteralExpCS_in_rulePrimaryExpCS6893);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2964:2: this_TypeLiteralExpCS_8= ruleTypeLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getTypeLiteralExpCSParserRuleCall_8()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralExpCS_in_rulePrimaryExpCS6923);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2977:2: this_NameExpCS_9= ruleNameExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getNameExpCSParserRuleCall_9()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNameExpCS_in_rulePrimaryExpCS6953);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2996:1: entryRuleNameExpCS returns [EObject current=null] : iv_ruleNameExpCS= ruleNameExpCS EOF ;
    public final EObject entryRuleNameExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNameExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2997:2: (iv_ruleNameExpCS= ruleNameExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2998:2: iv_ruleNameExpCS= ruleNameExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNameExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNameExpCS_in_entryRuleNameExpCS6988);
            iv_ruleNameExpCS=ruleNameExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNameExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNameExpCS6998); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3005:1: ruleNameExpCS returns [EObject current=null] : ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( (lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS ) )* ( (lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS ) )? ( (lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS ) )? ( ( (lv_isPre_4_0= '@' ) ) otherlv_5= 'pre' )? ) ;
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
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3008:28: ( ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( (lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS ) )* ( (lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS ) )? ( (lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS ) )? ( ( (lv_isPre_4_0= '@' ) ) otherlv_5= 'pre' )? ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3009:1: ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( (lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS ) )* ( (lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS ) )? ( (lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS ) )? ( ( (lv_isPre_4_0= '@' ) ) otherlv_5= 'pre' )? )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3009:1: ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( (lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS ) )* ( (lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS ) )? ( (lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS ) )? ( ( (lv_isPre_4_0= '@' ) ) otherlv_5= 'pre' )? )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3009:2: ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( (lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS ) )* ( (lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS ) )? ( (lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS ) )? ( ( (lv_isPre_4_0= '@' ) ) otherlv_5= 'pre' )?
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3009:2: ( (lv_ownedPathName_0_0= rulePathNameCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3010:1: (lv_ownedPathName_0_0= rulePathNameCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3010:1: (lv_ownedPathName_0_0= rulePathNameCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3011:3: lv_ownedPathName_0_0= rulePathNameCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNameExpCSAccess().getOwnedPathNamePathNameCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_rulePathNameCS_in_ruleNameExpCS7044);
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3027:2: ( (lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS ) )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==66) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3028:1: (lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS )
            	    {
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3028:1: (lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS )
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3029:3: lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getNameExpCSAccess().getOwnedSquareBracketedClausesSquareBracketedClauseCSParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleSquareBracketedClauseCS_in_ruleNameExpCS7065);
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
            	    break loop43;
                }
            } while (true);

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3045:3: ( (lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==50) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3046:1: (lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3046:1: (lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3047:3: lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNameExpCSAccess().getOwnedRoundBracketedClauseRoundBracketedClauseCSParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleRoundBracketedClauseCS_in_ruleNameExpCS7087);
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3063:3: ( (lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==54) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3064:1: (lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3064:1: (lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3065:3: lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNameExpCSAccess().getOwnedCurlyBracketedClauseCurlyBracketedClauseCSParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCurlyBracketedClauseCS_in_ruleNameExpCS7109);
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3081:3: ( ( (lv_isPre_4_0= '@' ) ) otherlv_5= 'pre' )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==64) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3081:4: ( (lv_isPre_4_0= '@' ) ) otherlv_5= 'pre'
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3081:4: ( (lv_isPre_4_0= '@' ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3082:1: (lv_isPre_4_0= '@' )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3082:1: (lv_isPre_4_0= '@' )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3083:3: lv_isPre_4_0= '@'
                    {
                    lv_isPre_4_0=(Token)match(input,64,FollowSets000.FOLLOW_64_in_ruleNameExpCS7129); if (state.failed) return current;
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

                    otherlv_5=(Token)match(input,65,FollowSets000.FOLLOW_65_in_ruleNameExpCS7154); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3108:1: entryRuleCurlyBracketedClauseCS returns [EObject current=null] : iv_ruleCurlyBracketedClauseCS= ruleCurlyBracketedClauseCS EOF ;
    public final EObject entryRuleCurlyBracketedClauseCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCurlyBracketedClauseCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3109:2: (iv_ruleCurlyBracketedClauseCS= ruleCurlyBracketedClauseCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3110:2: iv_ruleCurlyBracketedClauseCS= ruleCurlyBracketedClauseCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCurlyBracketedClauseCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleCurlyBracketedClauseCS_in_entryRuleCurlyBracketedClauseCS7192);
            iv_ruleCurlyBracketedClauseCS=ruleCurlyBracketedClauseCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCurlyBracketedClauseCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCurlyBracketedClauseCS7202); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3117:1: ruleCurlyBracketedClauseCS returns [EObject current=null] : ( () otherlv_1= '{' ( ( (lv_value_2_0= ruleStringLiteral ) ) | ( ( (lv_ownedParts_3_0= ruleShadowPartCS ) ) (otherlv_4= ',' ( (lv_ownedParts_5_0= ruleShadowPartCS ) ) )* ) )? otherlv_6= '}' ) ;
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
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3120:28: ( ( () otherlv_1= '{' ( ( (lv_value_2_0= ruleStringLiteral ) ) | ( ( (lv_ownedParts_3_0= ruleShadowPartCS ) ) (otherlv_4= ',' ( (lv_ownedParts_5_0= ruleShadowPartCS ) ) )* ) )? otherlv_6= '}' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3121:1: ( () otherlv_1= '{' ( ( (lv_value_2_0= ruleStringLiteral ) ) | ( ( (lv_ownedParts_3_0= ruleShadowPartCS ) ) (otherlv_4= ',' ( (lv_ownedParts_5_0= ruleShadowPartCS ) ) )* ) )? otherlv_6= '}' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3121:1: ( () otherlv_1= '{' ( ( (lv_value_2_0= ruleStringLiteral ) ) | ( ( (lv_ownedParts_3_0= ruleShadowPartCS ) ) (otherlv_4= ',' ( (lv_ownedParts_5_0= ruleShadowPartCS ) ) )* ) )? otherlv_6= '}' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3121:2: () otherlv_1= '{' ( ( (lv_value_2_0= ruleStringLiteral ) ) | ( ( (lv_ownedParts_3_0= ruleShadowPartCS ) ) (otherlv_4= ',' ( (lv_ownedParts_5_0= ruleShadowPartCS ) ) )* ) )? otherlv_6= '}'
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3121:2: ()
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3122:2: 
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

            otherlv_1=(Token)match(input,54,FollowSets000.FOLLOW_54_in_ruleCurlyBracketedClauseCS7251); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getCurlyBracketedClauseCSAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3134:1: ( ( (lv_value_2_0= ruleStringLiteral ) ) | ( ( (lv_ownedParts_3_0= ruleShadowPartCS ) ) (otherlv_4= ',' ( (lv_ownedParts_5_0= ruleShadowPartCS ) ) )* ) )?
            int alt48=3;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==RULE_SINGLE_QUOTED_STRING) ) {
                alt48=1;
            }
            else if ( ((LA48_0>=RULE_SIMPLE_ID && LA48_0<=RULE_ESCAPED_ID)) ) {
                alt48=2;
            }
            switch (alt48) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3134:2: ( (lv_value_2_0= ruleStringLiteral ) )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3134:2: ( (lv_value_2_0= ruleStringLiteral ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3135:1: (lv_value_2_0= ruleStringLiteral )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3135:1: (lv_value_2_0= ruleStringLiteral )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3136:3: lv_value_2_0= ruleStringLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCurlyBracketedClauseCSAccess().getValueStringLiteralParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleStringLiteral_in_ruleCurlyBracketedClauseCS7273);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3153:6: ( ( (lv_ownedParts_3_0= ruleShadowPartCS ) ) (otherlv_4= ',' ( (lv_ownedParts_5_0= ruleShadowPartCS ) ) )* )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3153:6: ( ( (lv_ownedParts_3_0= ruleShadowPartCS ) ) (otherlv_4= ',' ( (lv_ownedParts_5_0= ruleShadowPartCS ) ) )* )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3153:7: ( (lv_ownedParts_3_0= ruleShadowPartCS ) ) (otherlv_4= ',' ( (lv_ownedParts_5_0= ruleShadowPartCS ) ) )*
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3153:7: ( (lv_ownedParts_3_0= ruleShadowPartCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3154:1: (lv_ownedParts_3_0= ruleShadowPartCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3154:1: (lv_ownedParts_3_0= ruleShadowPartCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3155:3: lv_ownedParts_3_0= ruleShadowPartCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCurlyBracketedClauseCSAccess().getOwnedPartsShadowPartCSParserRuleCall_2_1_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleShadowPartCS_in_ruleCurlyBracketedClauseCS7301);
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

                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3171:2: (otherlv_4= ',' ( (lv_ownedParts_5_0= ruleShadowPartCS ) ) )*
                    loop47:
                    do {
                        int alt47=2;
                        int LA47_0 = input.LA(1);

                        if ( (LA47_0==52) ) {
                            alt47=1;
                        }


                        switch (alt47) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3171:4: otherlv_4= ',' ( (lv_ownedParts_5_0= ruleShadowPartCS ) )
                    	    {
                    	    otherlv_4=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleCurlyBracketedClauseCS7314); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_4, grammarAccess.getCurlyBracketedClauseCSAccess().getCommaKeyword_2_1_1_0());
                    	          
                    	    }
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3175:1: ( (lv_ownedParts_5_0= ruleShadowPartCS ) )
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3176:1: (lv_ownedParts_5_0= ruleShadowPartCS )
                    	    {
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3176:1: (lv_ownedParts_5_0= ruleShadowPartCS )
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3177:3: lv_ownedParts_5_0= ruleShadowPartCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getCurlyBracketedClauseCSAccess().getOwnedPartsShadowPartCSParserRuleCall_2_1_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleShadowPartCS_in_ruleCurlyBracketedClauseCS7335);
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
                    	    break loop47;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleCurlyBracketedClauseCS7352); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3205:1: entryRuleRoundBracketedClauseCS returns [EObject current=null] : iv_ruleRoundBracketedClauseCS= ruleRoundBracketedClauseCS EOF ;
    public final EObject entryRuleRoundBracketedClauseCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRoundBracketedClauseCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3206:2: (iv_ruleRoundBracketedClauseCS= ruleRoundBracketedClauseCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3207:2: iv_ruleRoundBracketedClauseCS= ruleRoundBracketedClauseCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRoundBracketedClauseCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleRoundBracketedClauseCS_in_entryRuleRoundBracketedClauseCS7388);
            iv_ruleRoundBracketedClauseCS=ruleRoundBracketedClauseCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRoundBracketedClauseCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRoundBracketedClauseCS7398); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3214:1: ruleRoundBracketedClauseCS returns [EObject current=null] : ( () otherlv_1= '(' ( ( (lv_ownedArguments_2_0= ruleNavigatingArgCS ) ) ( (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )* )* )? otherlv_8= ')' ) ;
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
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3217:28: ( ( () otherlv_1= '(' ( ( (lv_ownedArguments_2_0= ruleNavigatingArgCS ) ) ( (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )* )* )? otherlv_8= ')' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3218:1: ( () otherlv_1= '(' ( ( (lv_ownedArguments_2_0= ruleNavigatingArgCS ) ) ( (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )* )* )? otherlv_8= ')' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3218:1: ( () otherlv_1= '(' ( ( (lv_ownedArguments_2_0= ruleNavigatingArgCS ) ) ( (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )* )* )? otherlv_8= ')' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3218:2: () otherlv_1= '(' ( ( (lv_ownedArguments_2_0= ruleNavigatingArgCS ) ) ( (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )* )* )? otherlv_8= ')'
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3218:2: ()
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3219:2: 
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

            otherlv_1=(Token)match(input,50,FollowSets000.FOLLOW_50_in_ruleRoundBracketedClauseCS7447); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getRoundBracketedClauseCSAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3231:1: ( ( (lv_ownedArguments_2_0= ruleNavigatingArgCS ) ) ( (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )* )* )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( ((LA54_0>=RULE_SIMPLE_ID && LA54_0<=RULE_SINGLE_QUOTED_STRING)||(LA54_0>=16 && LA54_0<=18)||(LA54_0>=35 && LA54_0<=50)||LA54_0==53||LA54_0==58||(LA54_0>=60 && LA54_0<=63)||LA54_0==71||(LA54_0>=76 && LA54_0<=77)) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3231:2: ( (lv_ownedArguments_2_0= ruleNavigatingArgCS ) ) ( (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )* )*
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3231:2: ( (lv_ownedArguments_2_0= ruleNavigatingArgCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3232:1: (lv_ownedArguments_2_0= ruleNavigatingArgCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3232:1: (lv_ownedArguments_2_0= ruleNavigatingArgCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3233:3: lv_ownedArguments_2_0= ruleNavigatingArgCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingArgCSParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgCS_in_ruleRoundBracketedClauseCS7469);
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

                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3249:2: ( (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS ) )*
                    loop49:
                    do {
                        int alt49=2;
                        int LA49_0 = input.LA(1);

                        if ( (LA49_0==52) ) {
                            alt49=1;
                        }


                        switch (alt49) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3250:1: (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS )
                    	    {
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3250:1: (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS )
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3251:3: lv_ownedArguments_3_0= ruleNavigatingCommaArgCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingCommaArgCSParserRuleCall_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleNavigatingCommaArgCS_in_ruleRoundBracketedClauseCS7490);
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
                    	    break loop49;
                        }
                    } while (true);

                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3267:3: ( ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )* )?
                    int alt51=2;
                    int LA51_0 = input.LA(1);

                    if ( (LA51_0==70) ) {
                        alt51=1;
                    }
                    switch (alt51) {
                        case 1 :
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3267:4: ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )*
                            {
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3267:4: ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3268:1: (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS )
                            {
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3268:1: (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3269:3: lv_ownedArguments_4_0= ruleNavigatingSemiArgCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingSemiArgCSParserRuleCall_2_2_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleNavigatingSemiArgCS_in_ruleRoundBracketedClauseCS7513);
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

                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3285:2: ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )*
                            loop50:
                            do {
                                int alt50=2;
                                int LA50_0 = input.LA(1);

                                if ( (LA50_0==52) ) {
                                    alt50=1;
                                }


                                switch (alt50) {
                            	case 1 :
                            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3286:1: (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS )
                            	    {
                            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3286:1: (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS )
                            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3287:3: lv_ownedArguments_5_0= ruleNavigatingCommaArgCS
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingCommaArgCSParserRuleCall_2_2_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FollowSets000.FOLLOW_ruleNavigatingCommaArgCS_in_ruleRoundBracketedClauseCS7534);
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
                            	    break loop50;
                                }
                            } while (true);


                            }
                            break;

                    }

                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3303:5: ( ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )* )*
                    loop53:
                    do {
                        int alt53=2;
                        int LA53_0 = input.LA(1);

                        if ( (LA53_0==69) ) {
                            alt53=1;
                        }


                        switch (alt53) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3303:6: ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )*
                    	    {
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3303:6: ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) )
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3304:1: (lv_ownedArguments_6_0= ruleNavigatingBarArgCS )
                    	    {
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3304:1: (lv_ownedArguments_6_0= ruleNavigatingBarArgCS )
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3305:3: lv_ownedArguments_6_0= ruleNavigatingBarArgCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingBarArgCSParserRuleCall_2_3_0_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleNavigatingBarArgCS_in_ruleRoundBracketedClauseCS7559);
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

                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3321:2: ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )*
                    	    loop52:
                    	    do {
                    	        int alt52=2;
                    	        int LA52_0 = input.LA(1);

                    	        if ( (LA52_0==52) ) {
                    	            alt52=1;
                    	        }


                    	        switch (alt52) {
                    	    	case 1 :
                    	    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3322:1: (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS )
                    	    	    {
                    	    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3322:1: (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS )
                    	    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3323:3: lv_ownedArguments_7_0= ruleNavigatingCommaArgCS
                    	    	    {
                    	    	    if ( state.backtracking==0 ) {
                    	    	       
                    	    	      	        newCompositeNode(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingCommaArgCSParserRuleCall_2_3_1_0()); 
                    	    	      	    
                    	    	    }
                    	    	    pushFollow(FollowSets000.FOLLOW_ruleNavigatingCommaArgCS_in_ruleRoundBracketedClauseCS7580);
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
                    	    	    break loop52;
                    	        }
                    	    } while (true);


                    	    }
                    	    break;

                    	default :
                    	    break loop53;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_8=(Token)match(input,51,FollowSets000.FOLLOW_51_in_ruleRoundBracketedClauseCS7597); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3351:1: entryRuleSquareBracketedClauseCS returns [EObject current=null] : iv_ruleSquareBracketedClauseCS= ruleSquareBracketedClauseCS EOF ;
    public final EObject entryRuleSquareBracketedClauseCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSquareBracketedClauseCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3352:2: (iv_ruleSquareBracketedClauseCS= ruleSquareBracketedClauseCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3353:2: iv_ruleSquareBracketedClauseCS= ruleSquareBracketedClauseCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSquareBracketedClauseCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSquareBracketedClauseCS_in_entryRuleSquareBracketedClauseCS7633);
            iv_ruleSquareBracketedClauseCS=ruleSquareBracketedClauseCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSquareBracketedClauseCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSquareBracketedClauseCS7643); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3360:1: ruleSquareBracketedClauseCS returns [EObject current=null] : (otherlv_0= '[' ( (lv_ownedTerms_1_0= ruleExpCS ) ) (otherlv_2= ',' ( (lv_ownedTerms_3_0= ruleExpCS ) ) )* otherlv_4= ']' ) ;
    public final EObject ruleSquareBracketedClauseCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_ownedTerms_1_0 = null;

        EObject lv_ownedTerms_3_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3363:28: ( (otherlv_0= '[' ( (lv_ownedTerms_1_0= ruleExpCS ) ) (otherlv_2= ',' ( (lv_ownedTerms_3_0= ruleExpCS ) ) )* otherlv_4= ']' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3364:1: (otherlv_0= '[' ( (lv_ownedTerms_1_0= ruleExpCS ) ) (otherlv_2= ',' ( (lv_ownedTerms_3_0= ruleExpCS ) ) )* otherlv_4= ']' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3364:1: (otherlv_0= '[' ( (lv_ownedTerms_1_0= ruleExpCS ) ) (otherlv_2= ',' ( (lv_ownedTerms_3_0= ruleExpCS ) ) )* otherlv_4= ']' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3364:3: otherlv_0= '[' ( (lv_ownedTerms_1_0= ruleExpCS ) ) (otherlv_2= ',' ( (lv_ownedTerms_3_0= ruleExpCS ) ) )* otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,66,FollowSets000.FOLLOW_66_in_ruleSquareBracketedClauseCS7680); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getSquareBracketedClauseCSAccess().getLeftSquareBracketKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3368:1: ( (lv_ownedTerms_1_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3369:1: (lv_ownedTerms_1_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3369:1: (lv_ownedTerms_1_0= ruleExpCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3370:3: lv_ownedTerms_1_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSquareBracketedClauseCSAccess().getOwnedTermsExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleSquareBracketedClauseCS7701);
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3386:2: (otherlv_2= ',' ( (lv_ownedTerms_3_0= ruleExpCS ) ) )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==52) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3386:4: otherlv_2= ',' ( (lv_ownedTerms_3_0= ruleExpCS ) )
            	    {
            	    otherlv_2=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleSquareBracketedClauseCS7714); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getSquareBracketedClauseCSAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3390:1: ( (lv_ownedTerms_3_0= ruleExpCS ) )
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3391:1: (lv_ownedTerms_3_0= ruleExpCS )
            	    {
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3391:1: (lv_ownedTerms_3_0= ruleExpCS )
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3392:3: lv_ownedTerms_3_0= ruleExpCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSquareBracketedClauseCSAccess().getOwnedTermsExpCSParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleSquareBracketedClauseCS7735);
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
            	    break loop55;
                }
            } while (true);

            otherlv_4=(Token)match(input,67,FollowSets000.FOLLOW_67_in_ruleSquareBracketedClauseCS7749); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3420:1: entryRuleNavigatingArgCS returns [EObject current=null] : iv_ruleNavigatingArgCS= ruleNavigatingArgCS EOF ;
    public final EObject entryRuleNavigatingArgCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingArgCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3421:2: (iv_ruleNavigatingArgCS= ruleNavigatingArgCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3422:2: iv_ruleNavigatingArgCS= ruleNavigatingArgCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingArgCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgCS_in_entryRuleNavigatingArgCS7785);
            iv_ruleNavigatingArgCS=ruleNavigatingArgCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingArgCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigatingArgCS7795); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3429:1: ruleNavigatingArgCS returns [EObject current=null] : ( ( ( (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS ) ) ( (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? ) | (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) ) )? ) | (otherlv_7= ':' ( (lv_ownedType_8_0= ruleTypeExpCS ) ) ) ) ;
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
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3432:28: ( ( ( ( (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS ) ) ( (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? ) | (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) ) )? ) | (otherlv_7= ':' ( (lv_ownedType_8_0= ruleTypeExpCS ) ) ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3433:1: ( ( ( (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS ) ) ( (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? ) | (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) ) )? ) | (otherlv_7= ':' ( (lv_ownedType_8_0= ruleTypeExpCS ) ) ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3433:1: ( ( ( (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS ) ) ( (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? ) | (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) ) )? ) | (otherlv_7= ':' ( (lv_ownedType_8_0= ruleTypeExpCS ) ) ) )
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( ((LA58_0>=RULE_SIMPLE_ID && LA58_0<=RULE_SINGLE_QUOTED_STRING)||(LA58_0>=16 && LA58_0<=18)||(LA58_0>=35 && LA58_0<=50)||LA58_0==58||(LA58_0>=60 && LA58_0<=63)||LA58_0==71||(LA58_0>=76 && LA58_0<=77)) ) {
                alt58=1;
            }
            else if ( (LA58_0==53) ) {
                alt58=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;
            }
            switch (alt58) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3433:2: ( ( (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS ) ) ( (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? ) | (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) ) )? )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3433:2: ( ( (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS ) ) ( (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? ) | (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) ) )? )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3433:3: ( (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS ) ) ( (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? ) | (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) ) )?
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3433:3: ( (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3434:1: (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3434:1: (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3435:3: lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedNameExpressionNavigatingArgExpCSParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingArgCS7842);
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

                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3451:2: ( (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? ) | (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) ) )?
                    int alt57=3;
                    int LA57_0 = input.LA(1);

                    if ( (LA57_0==53) ) {
                        alt57=1;
                    }
                    else if ( (LA57_0==68) ) {
                        alt57=2;
                    }
                    switch (alt57) {
                        case 1 :
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3451:3: (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? )
                            {
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3451:3: (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3451:5: otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )?
                            {
                            otherlv_1=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleNavigatingArgCS7856); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_1, grammarAccess.getNavigatingArgCSAccess().getColonKeyword_0_1_0_0());
                                  
                            }
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3455:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3456:1: (lv_ownedType_2_0= ruleTypeExpCS )
                            {
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3456:1: (lv_ownedType_2_0= ruleTypeExpCS )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3457:3: lv_ownedType_2_0= ruleTypeExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_0_1_0_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleNavigatingArgCS7877);
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

                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3473:2: (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )?
                            int alt56=2;
                            int LA56_0 = input.LA(1);

                            if ( (LA56_0==25) ) {
                                alt56=1;
                            }
                            switch (alt56) {
                                case 1 :
                                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3473:4: otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) )
                                    {
                                    otherlv_3=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleNavigatingArgCS7890); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                          	newLeafNode(otherlv_3, grammarAccess.getNavigatingArgCSAccess().getEqualsSignKeyword_0_1_0_2_0());
                                          
                                    }
                                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3477:1: ( (lv_ownedInitExpression_4_0= ruleExpCS ) )
                                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3478:1: (lv_ownedInitExpression_4_0= ruleExpCS )
                                    {
                                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3478:1: (lv_ownedInitExpression_4_0= ruleExpCS )
                                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3479:3: lv_ownedInitExpression_4_0= ruleExpCS
                                    {
                                    if ( state.backtracking==0 ) {
                                       
                                      	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_0_1_0_2_1_0()); 
                                      	    
                                    }
                                    pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNavigatingArgCS7911);
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
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3496:6: (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) )
                            {
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3496:6: (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3496:8: otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) )
                            {
                            otherlv_5=(Token)match(input,68,FollowSets000.FOLLOW_68_in_ruleNavigatingArgCS7933); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_5, grammarAccess.getNavigatingArgCSAccess().getInKeyword_0_1_1_0());
                                  
                            }
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3500:1: ( (lv_ownedInitExpression_6_0= ruleExpCS ) )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3501:1: (lv_ownedInitExpression_6_0= ruleExpCS )
                            {
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3501:1: (lv_ownedInitExpression_6_0= ruleExpCS )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3502:3: lv_ownedInitExpression_6_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_0_1_1_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNavigatingArgCS7954);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3519:6: (otherlv_7= ':' ( (lv_ownedType_8_0= ruleTypeExpCS ) ) )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3519:6: (otherlv_7= ':' ( (lv_ownedType_8_0= ruleTypeExpCS ) ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3519:8: otherlv_7= ':' ( (lv_ownedType_8_0= ruleTypeExpCS ) )
                    {
                    otherlv_7=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleNavigatingArgCS7977); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getNavigatingArgCSAccess().getColonKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3523:1: ( (lv_ownedType_8_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3524:1: (lv_ownedType_8_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3524:1: (lv_ownedType_8_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3525:3: lv_ownedType_8_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleNavigatingArgCS7998);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3549:1: entryRuleNavigatingBarArgCS returns [EObject current=null] : iv_ruleNavigatingBarArgCS= ruleNavigatingBarArgCS EOF ;
    public final EObject entryRuleNavigatingBarArgCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingBarArgCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3550:2: (iv_ruleNavigatingBarArgCS= ruleNavigatingBarArgCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3551:2: iv_ruleNavigatingBarArgCS= ruleNavigatingBarArgCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingBarArgCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingBarArgCS_in_entryRuleNavigatingBarArgCS8035);
            iv_ruleNavigatingBarArgCS=ruleNavigatingBarArgCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingBarArgCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigatingBarArgCS8045); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3558:1: ruleNavigatingBarArgCS returns [EObject current=null] : ( ( (lv_prefix_0_0= '|' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )? ) ;
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
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3561:28: ( ( ( (lv_prefix_0_0= '|' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )? ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3562:1: ( ( (lv_prefix_0_0= '|' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )? )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3562:1: ( ( (lv_prefix_0_0= '|' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )? )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3562:2: ( (lv_prefix_0_0= '|' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )?
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3562:2: ( (lv_prefix_0_0= '|' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3563:1: (lv_prefix_0_0= '|' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3563:1: (lv_prefix_0_0= '|' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3564:3: lv_prefix_0_0= '|'
            {
            lv_prefix_0_0=(Token)match(input,69,FollowSets000.FOLLOW_69_in_ruleNavigatingBarArgCS8088); if (state.failed) return current;
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3577:2: ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3578:1: (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3578:1: (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3579:3: lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNavigatingBarArgCSAccess().getOwnedNameExpressionNavigatingArgExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingBarArgCS8122);
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3595:2: (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==53) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3595:4: otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )?
                    {
                    otherlv_2=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleNavigatingBarArgCS8135); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getNavigatingBarArgCSAccess().getColonKeyword_2_0());
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3599:1: ( (lv_ownedType_3_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3600:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3600:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3601:3: lv_ownedType_3_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingBarArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleNavigatingBarArgCS8156);
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

                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3617:2: (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )?
                    int alt59=2;
                    int LA59_0 = input.LA(1);

                    if ( (LA59_0==25) ) {
                        alt59=1;
                    }
                    switch (alt59) {
                        case 1 :
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3617:4: otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) )
                            {
                            otherlv_4=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleNavigatingBarArgCS8169); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getNavigatingBarArgCSAccess().getEqualsSignKeyword_2_2_0());
                                  
                            }
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3621:1: ( (lv_ownedInitExpression_5_0= ruleExpCS ) )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3622:1: (lv_ownedInitExpression_5_0= ruleExpCS )
                            {
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3622:1: (lv_ownedInitExpression_5_0= ruleExpCS )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3623:3: lv_ownedInitExpression_5_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getNavigatingBarArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_2_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNavigatingBarArgCS8190);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3647:1: entryRuleNavigatingCommaArgCS returns [EObject current=null] : iv_ruleNavigatingCommaArgCS= ruleNavigatingCommaArgCS EOF ;
    public final EObject entryRuleNavigatingCommaArgCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingCommaArgCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3648:2: (iv_ruleNavigatingCommaArgCS= ruleNavigatingCommaArgCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3649:2: iv_ruleNavigatingCommaArgCS= ruleNavigatingCommaArgCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingCommaArgCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingCommaArgCS_in_entryRuleNavigatingCommaArgCS8230);
            iv_ruleNavigatingCommaArgCS=ruleNavigatingCommaArgCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingCommaArgCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigatingCommaArgCS8240); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3656:1: ruleNavigatingCommaArgCS returns [EObject current=null] : ( ( (lv_prefix_0_0= ',' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) ( (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? ) | (otherlv_6= 'in' ( (lv_ownedInitExpression_7_0= ruleExpCS ) ) ) )? ) ;
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
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3659:28: ( ( ( (lv_prefix_0_0= ',' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) ( (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? ) | (otherlv_6= 'in' ( (lv_ownedInitExpression_7_0= ruleExpCS ) ) ) )? ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3660:1: ( ( (lv_prefix_0_0= ',' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) ( (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? ) | (otherlv_6= 'in' ( (lv_ownedInitExpression_7_0= ruleExpCS ) ) ) )? )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3660:1: ( ( (lv_prefix_0_0= ',' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) ( (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? ) | (otherlv_6= 'in' ( (lv_ownedInitExpression_7_0= ruleExpCS ) ) ) )? )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3660:2: ( (lv_prefix_0_0= ',' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) ( (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? ) | (otherlv_6= 'in' ( (lv_ownedInitExpression_7_0= ruleExpCS ) ) ) )?
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3660:2: ( (lv_prefix_0_0= ',' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3661:1: (lv_prefix_0_0= ',' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3661:1: (lv_prefix_0_0= ',' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3662:3: lv_prefix_0_0= ','
            {
            lv_prefix_0_0=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleNavigatingCommaArgCS8283); if (state.failed) return current;
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3675:2: ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3676:1: (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3676:1: (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3677:3: lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedNameExpressionNavigatingArgExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingCommaArgCS8317);
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3693:2: ( (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? ) | (otherlv_6= 'in' ( (lv_ownedInitExpression_7_0= ruleExpCS ) ) ) )?
            int alt62=3;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==53) ) {
                alt62=1;
            }
            else if ( (LA62_0==68) ) {
                alt62=2;
            }
            switch (alt62) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3693:3: (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3693:3: (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3693:5: otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )?
                    {
                    otherlv_2=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleNavigatingCommaArgCS8331); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getNavigatingCommaArgCSAccess().getColonKeyword_2_0_0());
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3697:1: ( (lv_ownedType_3_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3698:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3698:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3699:3: lv_ownedType_3_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_0_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleNavigatingCommaArgCS8352);
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

                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3715:2: (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )?
                    int alt61=2;
                    int LA61_0 = input.LA(1);

                    if ( (LA61_0==25) ) {
                        alt61=1;
                    }
                    switch (alt61) {
                        case 1 :
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3715:4: otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) )
                            {
                            otherlv_4=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleNavigatingCommaArgCS8365); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getNavigatingCommaArgCSAccess().getEqualsSignKeyword_2_0_2_0());
                                  
                            }
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3719:1: ( (lv_ownedInitExpression_5_0= ruleExpCS ) )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3720:1: (lv_ownedInitExpression_5_0= ruleExpCS )
                            {
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3720:1: (lv_ownedInitExpression_5_0= ruleExpCS )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3721:3: lv_ownedInitExpression_5_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_0_2_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNavigatingCommaArgCS8386);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3738:6: (otherlv_6= 'in' ( (lv_ownedInitExpression_7_0= ruleExpCS ) ) )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3738:6: (otherlv_6= 'in' ( (lv_ownedInitExpression_7_0= ruleExpCS ) ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3738:8: otherlv_6= 'in' ( (lv_ownedInitExpression_7_0= ruleExpCS ) )
                    {
                    otherlv_6=(Token)match(input,68,FollowSets000.FOLLOW_68_in_ruleNavigatingCommaArgCS8408); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getNavigatingCommaArgCSAccess().getInKeyword_2_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3742:1: ( (lv_ownedInitExpression_7_0= ruleExpCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3743:1: (lv_ownedInitExpression_7_0= ruleExpCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3743:1: (lv_ownedInitExpression_7_0= ruleExpCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3744:3: lv_ownedInitExpression_7_0= ruleExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNavigatingCommaArgCS8429);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3768:1: entryRuleNavigatingSemiArgCS returns [EObject current=null] : iv_ruleNavigatingSemiArgCS= ruleNavigatingSemiArgCS EOF ;
    public final EObject entryRuleNavigatingSemiArgCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingSemiArgCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3769:2: (iv_ruleNavigatingSemiArgCS= ruleNavigatingSemiArgCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3770:2: iv_ruleNavigatingSemiArgCS= ruleNavigatingSemiArgCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingSemiArgCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingSemiArgCS_in_entryRuleNavigatingSemiArgCS8468);
            iv_ruleNavigatingSemiArgCS=ruleNavigatingSemiArgCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingSemiArgCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigatingSemiArgCS8478); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3777:1: ruleNavigatingSemiArgCS returns [EObject current=null] : ( ( (lv_prefix_0_0= ';' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )? ) ;
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
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3780:28: ( ( ( (lv_prefix_0_0= ';' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )? ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3781:1: ( ( (lv_prefix_0_0= ';' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )? )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3781:1: ( ( (lv_prefix_0_0= ';' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )? )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3781:2: ( (lv_prefix_0_0= ';' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )?
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3781:2: ( (lv_prefix_0_0= ';' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3782:1: (lv_prefix_0_0= ';' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3782:1: (lv_prefix_0_0= ';' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3783:3: lv_prefix_0_0= ';'
            {
            lv_prefix_0_0=(Token)match(input,70,FollowSets000.FOLLOW_70_in_ruleNavigatingSemiArgCS8521); if (state.failed) return current;
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3796:2: ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3797:1: (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3797:1: (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3798:3: lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNavigatingSemiArgCSAccess().getOwnedNameExpressionNavigatingArgExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingSemiArgCS8555);
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3814:2: (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==53) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3814:4: otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )?
                    {
                    otherlv_2=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleNavigatingSemiArgCS8568); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getNavigatingSemiArgCSAccess().getColonKeyword_2_0());
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3818:1: ( (lv_ownedType_3_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3819:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3819:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3820:3: lv_ownedType_3_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingSemiArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleNavigatingSemiArgCS8589);
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

                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3836:2: (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )?
                    int alt63=2;
                    int LA63_0 = input.LA(1);

                    if ( (LA63_0==25) ) {
                        alt63=1;
                    }
                    switch (alt63) {
                        case 1 :
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3836:4: otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) )
                            {
                            otherlv_4=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleNavigatingSemiArgCS8602); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getNavigatingSemiArgCSAccess().getEqualsSignKeyword_2_2_0());
                                  
                            }
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3840:1: ( (lv_ownedInitExpression_5_0= ruleExpCS ) )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3841:1: (lv_ownedInitExpression_5_0= ruleExpCS )
                            {
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3841:1: (lv_ownedInitExpression_5_0= ruleExpCS )
                            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3842:3: lv_ownedInitExpression_5_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getNavigatingSemiArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_2_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNavigatingSemiArgCS8623);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3866:1: entryRuleNavigatingArgExpCS returns [EObject current=null] : iv_ruleNavigatingArgExpCS= ruleNavigatingArgExpCS EOF ;
    public final EObject entryRuleNavigatingArgExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingArgExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3867:2: (iv_ruleNavigatingArgExpCS= ruleNavigatingArgExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3868:2: iv_ruleNavigatingArgExpCS= ruleNavigatingArgExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingArgExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgExpCS_in_entryRuleNavigatingArgExpCS8663);
            iv_ruleNavigatingArgExpCS=ruleNavigatingArgExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingArgExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigatingArgExpCS8673); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3875:1: ruleNavigatingArgExpCS returns [EObject current=null] : this_ExpCS_0= ruleExpCS ;
    public final EObject ruleNavigatingArgExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_ExpCS_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3878:28: (this_ExpCS_0= ruleExpCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3880:2: this_ExpCS_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getNavigatingArgExpCSAccess().getExpCSParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNavigatingArgExpCS8722);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3899:1: entryRuleIfExpCS returns [EObject current=null] : iv_ruleIfExpCS= ruleIfExpCS EOF ;
    public final EObject entryRuleIfExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3900:2: (iv_ruleIfExpCS= ruleIfExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3901:2: iv_ruleIfExpCS= ruleIfExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIfExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIfExpCS_in_entryRuleIfExpCS8756);
            iv_ruleIfExpCS=ruleIfExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIfExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIfExpCS8766); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3908:1: ruleIfExpCS returns [EObject current=null] : (otherlv_0= 'if' ( ( (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS ) ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) ( (lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS ) )* otherlv_5= 'else' ( (lv_ownedElseExpression_6_0= ruleExpCS ) ) otherlv_7= 'endif' ) ;
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
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3911:28: ( (otherlv_0= 'if' ( ( (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS ) ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) ( (lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS ) )* otherlv_5= 'else' ( (lv_ownedElseExpression_6_0= ruleExpCS ) ) otherlv_7= 'endif' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3912:1: (otherlv_0= 'if' ( ( (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS ) ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) ( (lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS ) )* otherlv_5= 'else' ( (lv_ownedElseExpression_6_0= ruleExpCS ) ) otherlv_7= 'endif' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3912:1: (otherlv_0= 'if' ( ( (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS ) ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) ( (lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS ) )* otherlv_5= 'else' ( (lv_ownedElseExpression_6_0= ruleExpCS ) ) otherlv_7= 'endif' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3912:3: otherlv_0= 'if' ( ( (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS ) ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) ( (lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS ) )* otherlv_5= 'else' ( (lv_ownedElseExpression_6_0= ruleExpCS ) ) otherlv_7= 'endif'
            {
            otherlv_0=(Token)match(input,71,FollowSets000.FOLLOW_71_in_ruleIfExpCS8803); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getIfExpCSAccess().getIfKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3916:1: ( ( (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3917:1: ( (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3917:1: ( (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3918:1: (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3918:1: (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS )
            int alt65=2;
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
                alt65=1;
                }
                break;
            case RULE_SIMPLE_ID:
                {
                int LA65_2 = input.LA(2);

                if ( (LA65_2==16||(LA65_2>=18 && LA65_2<=34)||LA65_2==50||LA65_2==54||LA65_2==64||LA65_2==66||LA65_2==72||LA65_2==81) ) {
                    alt65=1;
                }
                else if ( (LA65_2==53) ) {
                    alt65=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 65, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_ESCAPED_ID:
                {
                int LA65_3 = input.LA(2);

                if ( (LA65_3==53) ) {
                    alt65=2;
                }
                else if ( (LA65_3==16||(LA65_3>=18 && LA65_3<=34)||LA65_3==50||LA65_3==54||LA65_3==64||LA65_3==66||LA65_3==72||LA65_3==81) ) {
                    alt65=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 65, 3, input);

                    throw nvae;
                }
                }
                break;
            case 53:
                {
                alt65=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 65, 0, input);

                throw nvae;
            }

            switch (alt65) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3919:3: lv_ownedCondition_1_1= ruleExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getIfExpCSAccess().getOwnedConditionExpCSParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleIfExpCS8826);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3934:8: lv_ownedCondition_1_2= rulePatternExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getIfExpCSAccess().getOwnedConditionPatternExpCSParserRuleCall_1_0_1()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePatternExpCS_in_ruleIfExpCS8845);
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

            otherlv_2=(Token)match(input,72,FollowSets000.FOLLOW_72_in_ruleIfExpCS8860); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getIfExpCSAccess().getThenKeyword_2());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3956:1: ( (lv_ownedThenExpression_3_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3957:1: (lv_ownedThenExpression_3_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3957:1: (lv_ownedThenExpression_3_0= ruleExpCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3958:3: lv_ownedThenExpression_3_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIfExpCSAccess().getOwnedThenExpressionExpCSParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleIfExpCS8881);
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3974:2: ( (lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS ) )*
            loop66:
            do {
                int alt66=2;
                int LA66_0 = input.LA(1);

                if ( (LA66_0==75) ) {
                    alt66=1;
                }


                switch (alt66) {
            	case 1 :
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3975:1: (lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS )
            	    {
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3975:1: (lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS )
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3976:3: lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getIfExpCSAccess().getOwnedIfThenExpressionsElseIfThenExpCSParserRuleCall_4_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleElseIfThenExpCS_in_ruleIfExpCS8902);
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
            	    break loop66;
                }
            } while (true);

            otherlv_5=(Token)match(input,73,FollowSets000.FOLLOW_73_in_ruleIfExpCS8915); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getIfExpCSAccess().getElseKeyword_5());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3996:1: ( (lv_ownedElseExpression_6_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3997:1: (lv_ownedElseExpression_6_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3997:1: (lv_ownedElseExpression_6_0= ruleExpCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3998:3: lv_ownedElseExpression_6_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIfExpCSAccess().getOwnedElseExpressionExpCSParserRuleCall_6_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleIfExpCS8936);
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

            otherlv_7=(Token)match(input,74,FollowSets000.FOLLOW_74_in_ruleIfExpCS8948); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4026:1: entryRuleElseIfThenExpCS returns [EObject current=null] : iv_ruleElseIfThenExpCS= ruleElseIfThenExpCS EOF ;
    public final EObject entryRuleElseIfThenExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElseIfThenExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4027:2: (iv_ruleElseIfThenExpCS= ruleElseIfThenExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4028:2: iv_ruleElseIfThenExpCS= ruleElseIfThenExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getElseIfThenExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleElseIfThenExpCS_in_entryRuleElseIfThenExpCS8984);
            iv_ruleElseIfThenExpCS=ruleElseIfThenExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleElseIfThenExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleElseIfThenExpCS8994); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4035:1: ruleElseIfThenExpCS returns [EObject current=null] : (otherlv_0= 'elseif' ( (lv_ownedCondition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) ) ;
    public final EObject ruleElseIfThenExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_ownedCondition_1_0 = null;

        EObject lv_ownedThenExpression_3_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4038:28: ( (otherlv_0= 'elseif' ( (lv_ownedCondition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4039:1: (otherlv_0= 'elseif' ( (lv_ownedCondition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4039:1: (otherlv_0= 'elseif' ( (lv_ownedCondition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4039:3: otherlv_0= 'elseif' ( (lv_ownedCondition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) )
            {
            otherlv_0=(Token)match(input,75,FollowSets000.FOLLOW_75_in_ruleElseIfThenExpCS9031); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getElseIfThenExpCSAccess().getElseifKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4043:1: ( (lv_ownedCondition_1_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4044:1: (lv_ownedCondition_1_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4044:1: (lv_ownedCondition_1_0= ruleExpCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4045:3: lv_ownedCondition_1_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getElseIfThenExpCSAccess().getOwnedConditionExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleElseIfThenExpCS9052);
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

            otherlv_2=(Token)match(input,72,FollowSets000.FOLLOW_72_in_ruleElseIfThenExpCS9064); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getElseIfThenExpCSAccess().getThenKeyword_2());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4065:1: ( (lv_ownedThenExpression_3_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4066:1: (lv_ownedThenExpression_3_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4066:1: (lv_ownedThenExpression_3_0= ruleExpCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4067:3: lv_ownedThenExpression_3_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getElseIfThenExpCSAccess().getOwnedThenExpressionExpCSParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleElseIfThenExpCS9085);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4091:1: entryRuleLetExpCS returns [EObject current=null] : iv_ruleLetExpCS= ruleLetExpCS EOF ;
    public final EObject entryRuleLetExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLetExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4092:2: (iv_ruleLetExpCS= ruleLetExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4093:2: iv_ruleLetExpCS= ruleLetExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLetExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLetExpCS_in_entryRuleLetExpCS9121);
            iv_ruleLetExpCS=ruleLetExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLetExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLetExpCS9131); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4100:1: ruleLetExpCS returns [EObject current=null] : (otherlv_0= 'let' ( (lv_ownedVariables_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_ownedVariables_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_ownedInExpression_5_0= ruleExpCS ) ) ) ;
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
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4103:28: ( (otherlv_0= 'let' ( (lv_ownedVariables_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_ownedVariables_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_ownedInExpression_5_0= ruleExpCS ) ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4104:1: (otherlv_0= 'let' ( (lv_ownedVariables_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_ownedVariables_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_ownedInExpression_5_0= ruleExpCS ) ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4104:1: (otherlv_0= 'let' ( (lv_ownedVariables_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_ownedVariables_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_ownedInExpression_5_0= ruleExpCS ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4104:3: otherlv_0= 'let' ( (lv_ownedVariables_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_ownedVariables_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_ownedInExpression_5_0= ruleExpCS ) )
            {
            otherlv_0=(Token)match(input,76,FollowSets000.FOLLOW_76_in_ruleLetExpCS9168); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLetExpCSAccess().getLetKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4108:1: ( (lv_ownedVariables_1_0= ruleLetVariableCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4109:1: (lv_ownedVariables_1_0= ruleLetVariableCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4109:1: (lv_ownedVariables_1_0= ruleLetVariableCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4110:3: lv_ownedVariables_1_0= ruleLetVariableCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetExpCSAccess().getOwnedVariablesLetVariableCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleLetVariableCS_in_ruleLetExpCS9189);
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4126:2: (otherlv_2= ',' ( (lv_ownedVariables_3_0= ruleLetVariableCS ) ) )*
            loop67:
            do {
                int alt67=2;
                int LA67_0 = input.LA(1);

                if ( (LA67_0==52) ) {
                    alt67=1;
                }


                switch (alt67) {
            	case 1 :
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4126:4: otherlv_2= ',' ( (lv_ownedVariables_3_0= ruleLetVariableCS ) )
            	    {
            	    otherlv_2=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleLetExpCS9202); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getLetExpCSAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4130:1: ( (lv_ownedVariables_3_0= ruleLetVariableCS ) )
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4131:1: (lv_ownedVariables_3_0= ruleLetVariableCS )
            	    {
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4131:1: (lv_ownedVariables_3_0= ruleLetVariableCS )
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4132:3: lv_ownedVariables_3_0= ruleLetVariableCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLetExpCSAccess().getOwnedVariablesLetVariableCSParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleLetVariableCS_in_ruleLetExpCS9223);
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
            	    break loop67;
                }
            } while (true);

            otherlv_4=(Token)match(input,68,FollowSets000.FOLLOW_68_in_ruleLetExpCS9237); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getLetExpCSAccess().getInKeyword_3());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4152:1: ( (lv_ownedInExpression_5_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4153:1: (lv_ownedInExpression_5_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4153:1: (lv_ownedInExpression_5_0= ruleExpCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4154:3: lv_ownedInExpression_5_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetExpCSAccess().getOwnedInExpressionExpCSParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleLetExpCS9258);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4178:1: entryRuleLetVariableCS returns [EObject current=null] : iv_ruleLetVariableCS= ruleLetVariableCS EOF ;
    public final EObject entryRuleLetVariableCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLetVariableCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4179:2: (iv_ruleLetVariableCS= ruleLetVariableCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4180:2: iv_ruleLetVariableCS= ruleLetVariableCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLetVariableCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLetVariableCS_in_entryRuleLetVariableCS9294);
            iv_ruleLetVariableCS=ruleLetVariableCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLetVariableCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLetVariableCS9304); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4187:1: ruleLetVariableCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) ( (lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS ) )? (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )? otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) ) ;
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
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4190:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) ( (lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS ) )? (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )? otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4191:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) ( (lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS ) )? (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )? otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4191:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) ( (lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS ) )? (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )? otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4191:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) ( (lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS ) )? (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )? otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4191:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4192:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4192:1: (lv_name_0_0= ruleUnrestrictedName )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4193:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetVariableCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleLetVariableCS9350);
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4209:2: ( (lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS ) )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==50) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4210:1: (lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4210:1: (lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4211:3: lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLetVariableCSAccess().getOwnedRoundBracketedClauseRoundBracketedClauseCSParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleRoundBracketedClauseCS_in_ruleLetVariableCS9371);
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4227:3: (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==53) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4227:5: otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) )
                    {
                    otherlv_2=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleLetVariableCS9385); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getLetVariableCSAccess().getColonKeyword_2_0());
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4231:1: ( (lv_ownedType_3_0= ruleTypeExpCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4232:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4232:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4233:3: lv_ownedType_3_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLetVariableCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleLetVariableCS9406);
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

            otherlv_4=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleLetVariableCS9420); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getLetVariableCSAccess().getEqualsSignKeyword_3());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4253:1: ( (lv_ownedInitExpression_5_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4254:1: (lv_ownedInitExpression_5_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4254:1: (lv_ownedInitExpression_5_0= ruleExpCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4255:3: lv_ownedInitExpression_5_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetVariableCSAccess().getOwnedInitExpressionExpCSParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleLetVariableCS9441);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4279:1: entryRuleNestedExpCS returns [EObject current=null] : iv_ruleNestedExpCS= ruleNestedExpCS EOF ;
    public final EObject entryRuleNestedExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNestedExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4280:2: (iv_ruleNestedExpCS= ruleNestedExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4281:2: iv_ruleNestedExpCS= ruleNestedExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNestedExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNestedExpCS_in_entryRuleNestedExpCS9477);
            iv_ruleNestedExpCS=ruleNestedExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNestedExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNestedExpCS9487); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4288:1: ruleNestedExpCS returns [EObject current=null] : (otherlv_0= '(' ( (lv_ownedExpression_1_0= ruleExpCS ) ) otherlv_2= ')' ) ;
    public final EObject ruleNestedExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_ownedExpression_1_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4291:28: ( (otherlv_0= '(' ( (lv_ownedExpression_1_0= ruleExpCS ) ) otherlv_2= ')' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4292:1: (otherlv_0= '(' ( (lv_ownedExpression_1_0= ruleExpCS ) ) otherlv_2= ')' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4292:1: (otherlv_0= '(' ( (lv_ownedExpression_1_0= ruleExpCS ) ) otherlv_2= ')' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4292:3: otherlv_0= '(' ( (lv_ownedExpression_1_0= ruleExpCS ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,50,FollowSets000.FOLLOW_50_in_ruleNestedExpCS9524); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getNestedExpCSAccess().getLeftParenthesisKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4296:1: ( (lv_ownedExpression_1_0= ruleExpCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4297:1: (lv_ownedExpression_1_0= ruleExpCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4297:1: (lv_ownedExpression_1_0= ruleExpCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4298:3: lv_ownedExpression_1_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNestedExpCSAccess().getOwnedExpressionExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNestedExpCS9545);
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

            otherlv_2=(Token)match(input,51,FollowSets000.FOLLOW_51_in_ruleNestedExpCS9557); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4326:1: entryRuleSelfExpCS returns [EObject current=null] : iv_ruleSelfExpCS= ruleSelfExpCS EOF ;
    public final EObject entryRuleSelfExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelfExpCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4327:2: (iv_ruleSelfExpCS= ruleSelfExpCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4328:2: iv_ruleSelfExpCS= ruleSelfExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSelfExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSelfExpCS_in_entryRuleSelfExpCS9593);
            iv_ruleSelfExpCS=ruleSelfExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSelfExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSelfExpCS9603); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4335:1: ruleSelfExpCS returns [EObject current=null] : ( () otherlv_1= 'self' ) ;
    public final EObject ruleSelfExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4338:28: ( ( () otherlv_1= 'self' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4339:1: ( () otherlv_1= 'self' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4339:1: ( () otherlv_1= 'self' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4339:2: () otherlv_1= 'self'
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4339:2: ()
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4340:2: 
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

            otherlv_1=(Token)match(input,77,FollowSets000.FOLLOW_77_in_ruleSelfExpCS9652); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4360:1: entryRuleMultiplicityBoundsCS returns [EObject current=null] : iv_ruleMultiplicityBoundsCS= ruleMultiplicityBoundsCS EOF ;
    public final EObject entryRuleMultiplicityBoundsCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicityBoundsCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4361:2: (iv_ruleMultiplicityBoundsCS= ruleMultiplicityBoundsCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4362:2: iv_ruleMultiplicityBoundsCS= ruleMultiplicityBoundsCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicityBoundsCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMultiplicityBoundsCS_in_entryRuleMultiplicityBoundsCS9688);
            iv_ruleMultiplicityBoundsCS=ruleMultiplicityBoundsCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicityBoundsCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMultiplicityBoundsCS9698); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4369:1: ruleMultiplicityBoundsCS returns [EObject current=null] : ( ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )? ) ;
    public final EObject ruleMultiplicityBoundsCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_lowerBound_0_0 = null;

        AntlrDatatypeRuleToken lv_upperBound_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4372:28: ( ( ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )? ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4373:1: ( ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )? )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4373:1: ( ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )? )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4373:2: ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )?
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4373:2: ( (lv_lowerBound_0_0= ruleLOWER ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4374:1: (lv_lowerBound_0_0= ruleLOWER )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4374:1: (lv_lowerBound_0_0= ruleLOWER )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4375:3: lv_lowerBound_0_0= ruleLOWER
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiplicityBoundsCSAccess().getLowerBoundLOWERParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleLOWER_in_ruleMultiplicityBoundsCS9744);
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4391:2: (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==56) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4391:4: otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) )
                    {
                    otherlv_1=(Token)match(input,56,FollowSets000.FOLLOW_56_in_ruleMultiplicityBoundsCS9757); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getMultiplicityBoundsCSAccess().getFullStopFullStopKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4395:1: ( (lv_upperBound_2_0= ruleUPPER ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4396:1: (lv_upperBound_2_0= ruleUPPER )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4396:1: (lv_upperBound_2_0= ruleUPPER )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4397:3: lv_upperBound_2_0= ruleUPPER
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMultiplicityBoundsCSAccess().getUpperBoundUPPERParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUPPER_in_ruleMultiplicityBoundsCS9778);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4421:1: entryRuleMultiplicityCS returns [EObject current=null] : iv_ruleMultiplicityCS= ruleMultiplicityCS EOF ;
    public final EObject entryRuleMultiplicityCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicityCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4422:2: (iv_ruleMultiplicityCS= ruleMultiplicityCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4423:2: iv_ruleMultiplicityCS= ruleMultiplicityCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicityCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMultiplicityCS_in_entryRuleMultiplicityCS9816);
            iv_ruleMultiplicityCS=ruleMultiplicityCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicityCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMultiplicityCS9826); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4430:1: ruleMultiplicityCS returns [EObject current=null] : (otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) (otherlv_3= '|?' | ( (lv_isNullFree_4_0= '|1' ) ) )? otherlv_5= ']' ) ;
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
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4433:28: ( (otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) (otherlv_3= '|?' | ( (lv_isNullFree_4_0= '|1' ) ) )? otherlv_5= ']' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4434:1: (otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) (otherlv_3= '|?' | ( (lv_isNullFree_4_0= '|1' ) ) )? otherlv_5= ']' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4434:1: (otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) (otherlv_3= '|?' | ( (lv_isNullFree_4_0= '|1' ) ) )? otherlv_5= ']' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4434:3: otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) (otherlv_3= '|?' | ( (lv_isNullFree_4_0= '|1' ) ) )? otherlv_5= ']'
            {
            otherlv_0=(Token)match(input,66,FollowSets000.FOLLOW_66_in_ruleMultiplicityCS9863); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMultiplicityCSAccess().getLeftSquareBracketKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4438:1: (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS )
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==RULE_INT) ) {
                alt71=1;
            }
            else if ( (LA71_0==18||LA71_0==20||LA71_0==80) ) {
                alt71=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 71, 0, input);

                throw nvae;
            }
            switch (alt71) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4439:2: this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getMultiplicityCSAccess().getMultiplicityBoundsCSParserRuleCall_1_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMultiplicityBoundsCS_in_ruleMultiplicityCS9889);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4452:2: this_MultiplicityStringCS_2= ruleMultiplicityStringCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getMultiplicityCSAccess().getMultiplicityStringCSParserRuleCall_1_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMultiplicityStringCS_in_ruleMultiplicityCS9919);
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4463:2: (otherlv_3= '|?' | ( (lv_isNullFree_4_0= '|1' ) ) )?
            int alt72=3;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==78) ) {
                alt72=1;
            }
            else if ( (LA72_0==79) ) {
                alt72=2;
            }
            switch (alt72) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4463:4: otherlv_3= '|?'
                    {
                    otherlv_3=(Token)match(input,78,FollowSets000.FOLLOW_78_in_ruleMultiplicityCS9932); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getMultiplicityCSAccess().getVerticalLineQuestionMarkKeyword_2_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4468:6: ( (lv_isNullFree_4_0= '|1' ) )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4468:6: ( (lv_isNullFree_4_0= '|1' ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4469:1: (lv_isNullFree_4_0= '|1' )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4469:1: (lv_isNullFree_4_0= '|1' )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4470:3: lv_isNullFree_4_0= '|1'
                    {
                    lv_isNullFree_4_0=(Token)match(input,79,FollowSets000.FOLLOW_79_in_ruleMultiplicityCS9956); if (state.failed) return current;
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

            otherlv_5=(Token)match(input,67,FollowSets000.FOLLOW_67_in_ruleMultiplicityCS9983); if (state.failed) return current;
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


    // $ANTLR start "entryRuleSimpleMultiplicityCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4495:1: entryRuleSimpleMultiplicityCS returns [EObject current=null] : iv_ruleSimpleMultiplicityCS= ruleSimpleMultiplicityCS EOF ;
    public final EObject entryRuleSimpleMultiplicityCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleMultiplicityCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4496:2: (iv_ruleSimpleMultiplicityCS= ruleSimpleMultiplicityCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4497:2: iv_ruleSimpleMultiplicityCS= ruleSimpleMultiplicityCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSimpleMultiplicityCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSimpleMultiplicityCS_in_entryRuleSimpleMultiplicityCS10019);
            iv_ruleSimpleMultiplicityCS=ruleSimpleMultiplicityCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSimpleMultiplicityCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSimpleMultiplicityCS10029); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSimpleMultiplicityCS"


    // $ANTLR start "ruleSimpleMultiplicityCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4504:1: ruleSimpleMultiplicityCS returns [EObject current=null] : (otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) otherlv_3= ']' ) ;
    public final EObject ruleSimpleMultiplicityCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        EObject this_MultiplicityBoundsCS_1 = null;

        EObject this_MultiplicityStringCS_2 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4507:28: ( (otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) otherlv_3= ']' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4508:1: (otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) otherlv_3= ']' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4508:1: (otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) otherlv_3= ']' )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4508:3: otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) otherlv_3= ']'
            {
            otherlv_0=(Token)match(input,66,FollowSets000.FOLLOW_66_in_ruleSimpleMultiplicityCS10066); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getSimpleMultiplicityCSAccess().getLeftSquareBracketKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4512:1: (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS )
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==RULE_INT) ) {
                alt73=1;
            }
            else if ( (LA73_0==18||LA73_0==20||LA73_0==80) ) {
                alt73=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 73, 0, input);

                throw nvae;
            }
            switch (alt73) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4513:2: this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getSimpleMultiplicityCSAccess().getMultiplicityBoundsCSParserRuleCall_1_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMultiplicityBoundsCS_in_ruleSimpleMultiplicityCS10092);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4526:2: this_MultiplicityStringCS_2= ruleMultiplicityStringCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getSimpleMultiplicityCSAccess().getMultiplicityStringCSParserRuleCall_1_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMultiplicityStringCS_in_ruleSimpleMultiplicityCS10122);
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

            otherlv_3=(Token)match(input,67,FollowSets000.FOLLOW_67_in_ruleSimpleMultiplicityCS10134); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getSimpleMultiplicityCSAccess().getRightSquareBracketKeyword_2());
                  
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
    // $ANTLR end "ruleSimpleMultiplicityCS"


    // $ANTLR start "entryRuleMultiplicityStringCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4549:1: entryRuleMultiplicityStringCS returns [EObject current=null] : iv_ruleMultiplicityStringCS= ruleMultiplicityStringCS EOF ;
    public final EObject entryRuleMultiplicityStringCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicityStringCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4550:2: (iv_ruleMultiplicityStringCS= ruleMultiplicityStringCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4551:2: iv_ruleMultiplicityStringCS= ruleMultiplicityStringCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicityStringCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMultiplicityStringCS_in_entryRuleMultiplicityStringCS10170);
            iv_ruleMultiplicityStringCS=ruleMultiplicityStringCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicityStringCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMultiplicityStringCS10180); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4558:1: ruleMultiplicityStringCS returns [EObject current=null] : ( ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) ) ) ;
    public final EObject ruleMultiplicityStringCS() throws RecognitionException {
        EObject current = null;

        Token lv_stringBounds_0_1=null;
        Token lv_stringBounds_0_2=null;
        Token lv_stringBounds_0_3=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4561:28: ( ( ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4562:1: ( ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4562:1: ( ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4563:1: ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4563:1: ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4564:1: (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4564:1: (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' )
            int alt74=3;
            switch ( input.LA(1) ) {
            case 18:
                {
                alt74=1;
                }
                break;
            case 20:
                {
                alt74=2;
                }
                break;
            case 80:
                {
                alt74=3;
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4565:3: lv_stringBounds_0_1= '*'
                    {
                    lv_stringBounds_0_1=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleMultiplicityStringCS10224); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4577:8: lv_stringBounds_0_2= '+'
                    {
                    lv_stringBounds_0_2=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleMultiplicityStringCS10253); if (state.failed) return current;
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4589:8: lv_stringBounds_0_3= '?'
                    {
                    lv_stringBounds_0_3=(Token)match(input,80,FollowSets000.FOLLOW_80_in_ruleMultiplicityStringCS10282); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4612:1: entryRulePathNameCS returns [EObject current=null] : iv_rulePathNameCS= rulePathNameCS EOF ;
    public final EObject entryRulePathNameCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePathNameCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4613:2: (iv_rulePathNameCS= rulePathNameCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4614:2: iv_rulePathNameCS= rulePathNameCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPathNameCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePathNameCS_in_entryRulePathNameCS10333);
            iv_rulePathNameCS=rulePathNameCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePathNameCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePathNameCS10343); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4621:1: rulePathNameCS returns [EObject current=null] : ( ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )* ) ;
    public final EObject rulePathNameCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_ownedPathElements_0_0 = null;

        EObject lv_ownedPathElements_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4624:28: ( ( ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )* ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4625:1: ( ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )* )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4625:1: ( ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )* )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4625:2: ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )*
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4625:2: ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4626:1: (lv_ownedPathElements_0_0= ruleFirstPathElementCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4626:1: (lv_ownedPathElements_0_0= ruleFirstPathElementCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4627:3: lv_ownedPathElements_0_0= ruleFirstPathElementCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPathNameCSAccess().getOwnedPathElementsFirstPathElementCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleFirstPathElementCS_in_rulePathNameCS10389);
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4643:2: (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )*
            loop75:
            do {
                int alt75=2;
                int LA75_0 = input.LA(1);

                if ( (LA75_0==81) ) {
                    alt75=1;
                }


                switch (alt75) {
            	case 1 :
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4643:4: otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) )
            	    {
            	    otherlv_1=(Token)match(input,81,FollowSets000.FOLLOW_81_in_rulePathNameCS10402); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getPathNameCSAccess().getColonColonKeyword_1_0());
            	          
            	    }
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4647:1: ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) )
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4648:1: (lv_ownedPathElements_2_0= ruleNextPathElementCS )
            	    {
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4648:1: (lv_ownedPathElements_2_0= ruleNextPathElementCS )
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4649:3: lv_ownedPathElements_2_0= ruleNextPathElementCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getPathNameCSAccess().getOwnedPathElementsNextPathElementCSParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleNextPathElementCS_in_rulePathNameCS10423);
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
            	    break loop75;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4673:1: entryRuleFirstPathElementCS returns [EObject current=null] : iv_ruleFirstPathElementCS= ruleFirstPathElementCS EOF ;
    public final EObject entryRuleFirstPathElementCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFirstPathElementCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4674:2: (iv_ruleFirstPathElementCS= ruleFirstPathElementCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4675:2: iv_ruleFirstPathElementCS= ruleFirstPathElementCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFirstPathElementCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleFirstPathElementCS_in_entryRuleFirstPathElementCS10461);
            iv_ruleFirstPathElementCS=ruleFirstPathElementCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFirstPathElementCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFirstPathElementCS10471); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4682:1: ruleFirstPathElementCS returns [EObject current=null] : ( ( ruleUnrestrictedName ) ) ;
    public final EObject ruleFirstPathElementCS() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4685:28: ( ( ( ruleUnrestrictedName ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4686:1: ( ( ruleUnrestrictedName ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4686:1: ( ( ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4687:1: ( ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4687:1: ( ruleUnrestrictedName )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4688:3: ruleUnrestrictedName
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
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleFirstPathElementCS10522);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4712:1: entryRuleNextPathElementCS returns [EObject current=null] : iv_ruleNextPathElementCS= ruleNextPathElementCS EOF ;
    public final EObject entryRuleNextPathElementCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNextPathElementCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4713:2: (iv_ruleNextPathElementCS= ruleNextPathElementCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4714:2: iv_ruleNextPathElementCS= ruleNextPathElementCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNextPathElementCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNextPathElementCS_in_entryRuleNextPathElementCS10557);
            iv_ruleNextPathElementCS=ruleNextPathElementCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNextPathElementCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNextPathElementCS10567); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4721:1: ruleNextPathElementCS returns [EObject current=null] : ( ( ruleUnreservedName ) ) ;
    public final EObject ruleNextPathElementCS() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4724:28: ( ( ( ruleUnreservedName ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4725:1: ( ( ruleUnreservedName ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4725:1: ( ( ruleUnreservedName ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4726:1: ( ruleUnreservedName )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4726:1: ( ruleUnreservedName )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4727:3: ruleUnreservedName
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
            pushFollow(FollowSets000.FOLLOW_ruleUnreservedName_in_ruleNextPathElementCS10618);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4751:1: entryRuleTemplateBindingCS returns [EObject current=null] : iv_ruleTemplateBindingCS= ruleTemplateBindingCS EOF ;
    public final EObject entryRuleTemplateBindingCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTemplateBindingCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4752:2: (iv_ruleTemplateBindingCS= ruleTemplateBindingCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4753:2: iv_ruleTemplateBindingCS= ruleTemplateBindingCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTemplateBindingCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTemplateBindingCS_in_entryRuleTemplateBindingCS10653);
            iv_ruleTemplateBindingCS=ruleTemplateBindingCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTemplateBindingCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTemplateBindingCS10663); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4760:1: ruleTemplateBindingCS returns [EObject current=null] : ( ( (lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS ) ) (otherlv_1= ',' ( (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS ) ) )* ) ;
    public final EObject ruleTemplateBindingCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_ownedSubstitutions_0_0 = null;

        EObject lv_ownedSubstitutions_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4763:28: ( ( ( (lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS ) ) (otherlv_1= ',' ( (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS ) ) )* ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4764:1: ( ( (lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS ) ) (otherlv_1= ',' ( (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS ) ) )* )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4764:1: ( ( (lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS ) ) (otherlv_1= ',' ( (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS ) ) )* )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4764:2: ( (lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS ) ) (otherlv_1= ',' ( (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS ) ) )*
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4764:2: ( (lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4765:1: (lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4765:1: (lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4766:3: lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsTemplateParameterSubstitutionCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTemplateParameterSubstitutionCS_in_ruleTemplateBindingCS10709);
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4782:2: (otherlv_1= ',' ( (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS ) ) )*
            loop76:
            do {
                int alt76=2;
                int LA76_0 = input.LA(1);

                if ( (LA76_0==52) ) {
                    alt76=1;
                }


                switch (alt76) {
            	case 1 :
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4782:4: otherlv_1= ',' ( (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS ) )
            	    {
            	    otherlv_1=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleTemplateBindingCS10722); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getTemplateBindingCSAccess().getCommaKeyword_1_0());
            	          
            	    }
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4786:1: ( (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS ) )
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4787:1: (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS )
            	    {
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4787:1: (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS )
            	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4788:3: lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsTemplateParameterSubstitutionCSParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleTemplateParameterSubstitutionCS_in_ruleTemplateBindingCS10743);
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
            	    break loop76;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4812:1: entryRuleTemplateParameterSubstitutionCS returns [EObject current=null] : iv_ruleTemplateParameterSubstitutionCS= ruleTemplateParameterSubstitutionCS EOF ;
    public final EObject entryRuleTemplateParameterSubstitutionCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTemplateParameterSubstitutionCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4813:2: (iv_ruleTemplateParameterSubstitutionCS= ruleTemplateParameterSubstitutionCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4814:2: iv_ruleTemplateParameterSubstitutionCS= ruleTemplateParameterSubstitutionCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTemplateParameterSubstitutionCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTemplateParameterSubstitutionCS_in_entryRuleTemplateParameterSubstitutionCS10781);
            iv_ruleTemplateParameterSubstitutionCS=ruleTemplateParameterSubstitutionCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTemplateParameterSubstitutionCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTemplateParameterSubstitutionCS10791); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4821:1: ruleTemplateParameterSubstitutionCS returns [EObject current=null] : ( (lv_ownedActualParameter_0_0= ruleTypeRefCS ) ) ;
    public final EObject ruleTemplateParameterSubstitutionCS() throws RecognitionException {
        EObject current = null;

        EObject lv_ownedActualParameter_0_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4824:28: ( ( (lv_ownedActualParameter_0_0= ruleTypeRefCS ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4825:1: ( (lv_ownedActualParameter_0_0= ruleTypeRefCS ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4825:1: ( (lv_ownedActualParameter_0_0= ruleTypeRefCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4826:1: (lv_ownedActualParameter_0_0= ruleTypeRefCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4826:1: (lv_ownedActualParameter_0_0= ruleTypeRefCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4827:3: lv_ownedActualParameter_0_0= ruleTypeRefCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTemplateParameterSubstitutionCSAccess().getOwnedActualParameterTypeRefCSParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeRefCS_in_ruleTemplateParameterSubstitutionCS10836);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4853:1: entryRuleTypeParameterCS returns [EObject current=null] : iv_ruleTypeParameterCS= ruleTypeParameterCS EOF ;
    public final EObject entryRuleTypeParameterCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeParameterCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4854:2: (iv_ruleTypeParameterCS= ruleTypeParameterCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4855:2: iv_ruleTypeParameterCS= ruleTypeParameterCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeParameterCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeParameterCS_in_entryRuleTypeParameterCS10873);
            iv_ruleTypeParameterCS=ruleTypeParameterCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeParameterCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeParameterCS10883); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4862:1: ruleTypeParameterCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleTypedRefCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) ) )* )? ) ;
    public final EObject ruleTypeParameterCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedExtends_2_0 = null;

        EObject lv_ownedExtends_4_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4865:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleTypedRefCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) ) )* )? ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4866:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleTypedRefCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) ) )* )? )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4866:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleTypedRefCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) ) )* )? )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4866:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleTypedRefCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) ) )* )?
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4866:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4867:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4867:1: (lv_name_0_0= ruleUnrestrictedName )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4868:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypeParameterCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleTypeParameterCS10929);
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4884:2: (otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleTypedRefCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) ) )* )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==82) ) {
                alt78=1;
            }
            switch (alt78) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4884:4: otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleTypedRefCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) ) )*
                    {
                    otherlv_1=(Token)match(input,82,FollowSets000.FOLLOW_82_in_ruleTypeParameterCS10942); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getTypeParameterCSAccess().getExtendsKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4888:1: ( (lv_ownedExtends_2_0= ruleTypedRefCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4889:1: (lv_ownedExtends_2_0= ruleTypedRefCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4889:1: (lv_ownedExtends_2_0= ruleTypedRefCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4890:3: lv_ownedExtends_2_0= ruleTypedRefCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsTypedRefCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypedRefCS_in_ruleTypeParameterCS10963);
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

                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4906:2: (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) ) )*
                    loop77:
                    do {
                        int alt77=2;
                        int LA77_0 = input.LA(1);

                        if ( (LA77_0==83) ) {
                            alt77=1;
                        }


                        switch (alt77) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4906:4: otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) )
                    	    {
                    	    otherlv_3=(Token)match(input,83,FollowSets000.FOLLOW_83_in_ruleTypeParameterCS10976); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getTypeParameterCSAccess().getAmpersandAmpersandKeyword_1_2_0());
                    	          
                    	    }
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4910:1: ( (lv_ownedExtends_4_0= ruleTypedRefCS ) )
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4911:1: (lv_ownedExtends_4_0= ruleTypedRefCS )
                    	    {
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4911:1: (lv_ownedExtends_4_0= ruleTypedRefCS )
                    	    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4912:3: lv_ownedExtends_4_0= ruleTypedRefCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsTypedRefCSParserRuleCall_1_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleTypedRefCS_in_ruleTypeParameterCS10997);
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
                    	    break loop77;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4936:1: entryRuleTypeRefCS returns [EObject current=null] : iv_ruleTypeRefCS= ruleTypeRefCS EOF ;
    public final EObject entryRuleTypeRefCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeRefCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4937:2: (iv_ruleTypeRefCS= ruleTypeRefCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4938:2: iv_ruleTypeRefCS= ruleTypeRefCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeRefCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeRefCS_in_entryRuleTypeRefCS11037);
            iv_ruleTypeRefCS=ruleTypeRefCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeRefCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeRefCS11047); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4945:1: ruleTypeRefCS returns [EObject current=null] : (this_TypedRefCS_0= ruleTypedRefCS | this_WildcardTypeRefCS_1= ruleWildcardTypeRefCS ) ;
    public final EObject ruleTypeRefCS() throws RecognitionException {
        EObject current = null;

        EObject this_TypedRefCS_0 = null;

        EObject this_WildcardTypeRefCS_1 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4948:28: ( (this_TypedRefCS_0= ruleTypedRefCS | this_WildcardTypeRefCS_1= ruleWildcardTypeRefCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4949:1: (this_TypedRefCS_0= ruleTypedRefCS | this_WildcardTypeRefCS_1= ruleWildcardTypeRefCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4949:1: (this_TypedRefCS_0= ruleTypedRefCS | this_WildcardTypeRefCS_1= ruleWildcardTypeRefCS )
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( ((LA79_0>=RULE_SIMPLE_ID && LA79_0<=RULE_ESCAPED_ID)) ) {
                alt79=1;
            }
            else if ( (LA79_0==80) ) {
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4950:2: this_TypedRefCS_0= ruleTypedRefCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeRefCSAccess().getTypedRefCSParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypedRefCS_in_ruleTypeRefCS11097);
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
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4963:2: this_WildcardTypeRefCS_1= ruleWildcardTypeRefCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeRefCSAccess().getWildcardTypeRefCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleWildcardTypeRefCS_in_ruleTypeRefCS11127);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4982:1: entryRuleTypedRefCS returns [EObject current=null] : iv_ruleTypedRefCS= ruleTypedRefCS EOF ;
    public final EObject entryRuleTypedRefCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypedRefCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4983:2: (iv_ruleTypedRefCS= ruleTypedRefCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4984:2: iv_ruleTypedRefCS= ruleTypedRefCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypedRefCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypedRefCS_in_entryRuleTypedRefCS11162);
            iv_ruleTypedRefCS=ruleTypedRefCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypedRefCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypedRefCS11172); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4991:1: ruleTypedRefCS returns [EObject current=null] : this_TypedTypeRefCS_0= ruleTypedTypeRefCS ;
    public final EObject ruleTypedRefCS() throws RecognitionException {
        EObject current = null;

        EObject this_TypedTypeRefCS_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4994:28: (this_TypedTypeRefCS_0= ruleTypedTypeRefCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4996:2: this_TypedTypeRefCS_0= ruleTypedTypeRefCS
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getTypedRefCSAccess().getTypedTypeRefCSParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypedTypeRefCS_in_ruleTypedRefCS11221);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5015:1: entryRuleTypedTypeRefCS returns [EObject current=null] : iv_ruleTypedTypeRefCS= ruleTypedTypeRefCS EOF ;
    public final EObject entryRuleTypedTypeRefCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypedTypeRefCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5016:2: (iv_ruleTypedTypeRefCS= ruleTypedTypeRefCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5017:2: iv_ruleTypedTypeRefCS= ruleTypedTypeRefCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypedTypeRefCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypedTypeRefCS_in_entryRuleTypedTypeRefCS11255);
            iv_ruleTypedTypeRefCS=ruleTypedTypeRefCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypedTypeRefCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypedTypeRefCS11265); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5024:1: ruleTypedTypeRefCS returns [EObject current=null] : ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) (otherlv_1= '(' ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) ) otherlv_3= ')' )? ) ;
    public final EObject ruleTypedTypeRefCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_ownedPathName_0_0 = null;

        EObject lv_ownedBinding_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5027:28: ( ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) (otherlv_1= '(' ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) ) otherlv_3= ')' )? ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5028:1: ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) (otherlv_1= '(' ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) ) otherlv_3= ')' )? )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5028:1: ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) (otherlv_1= '(' ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) ) otherlv_3= ')' )? )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5028:2: ( (lv_ownedPathName_0_0= rulePathNameCS ) ) (otherlv_1= '(' ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) ) otherlv_3= ')' )?
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5028:2: ( (lv_ownedPathName_0_0= rulePathNameCS ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5029:1: (lv_ownedPathName_0_0= rulePathNameCS )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5029:1: (lv_ownedPathName_0_0= rulePathNameCS )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5030:3: lv_ownedPathName_0_0= rulePathNameCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypedTypeRefCSAccess().getOwnedPathNamePathNameCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_rulePathNameCS_in_ruleTypedTypeRefCS11311);
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

            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5046:2: (otherlv_1= '(' ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) ) otherlv_3= ')' )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==50) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5046:4: otherlv_1= '(' ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) ) otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,50,FollowSets000.FOLLOW_50_in_ruleTypedTypeRefCS11324); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getTypedTypeRefCSAccess().getLeftParenthesisKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5050:1: ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5051:1: (lv_ownedBinding_2_0= ruleTemplateBindingCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5051:1: (lv_ownedBinding_2_0= ruleTemplateBindingCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5052:3: lv_ownedBinding_2_0= ruleTemplateBindingCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypedTypeRefCSAccess().getOwnedBindingTemplateBindingCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTemplateBindingCS_in_ruleTypedTypeRefCS11345);
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

                    otherlv_3=(Token)match(input,51,FollowSets000.FOLLOW_51_in_ruleTypedTypeRefCS11357); if (state.failed) return current;
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


    // $ANTLR start "entryRuleWildcardTypeRefCS"
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5080:1: entryRuleWildcardTypeRefCS returns [EObject current=null] : iv_ruleWildcardTypeRefCS= ruleWildcardTypeRefCS EOF ;
    public final EObject entryRuleWildcardTypeRefCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWildcardTypeRefCS = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5081:2: (iv_ruleWildcardTypeRefCS= ruleWildcardTypeRefCS EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5082:2: iv_ruleWildcardTypeRefCS= ruleWildcardTypeRefCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getWildcardTypeRefCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleWildcardTypeRefCS_in_entryRuleWildcardTypeRefCS11395);
            iv_ruleWildcardTypeRefCS=ruleWildcardTypeRefCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleWildcardTypeRefCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleWildcardTypeRefCS11405); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5089:1: ruleWildcardTypeRefCS returns [EObject current=null] : ( () otherlv_1= '?' (otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleTypedRefCS ) ) )? ) ;
    public final EObject ruleWildcardTypeRefCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_ownedExtends_3_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5092:28: ( ( () otherlv_1= '?' (otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleTypedRefCS ) ) )? ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5093:1: ( () otherlv_1= '?' (otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleTypedRefCS ) ) )? )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5093:1: ( () otherlv_1= '?' (otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleTypedRefCS ) ) )? )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5093:2: () otherlv_1= '?' (otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleTypedRefCS ) ) )?
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5093:2: ()
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5094:2: 
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

            otherlv_1=(Token)match(input,80,FollowSets000.FOLLOW_80_in_ruleWildcardTypeRefCS11454); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getWildcardTypeRefCSAccess().getQuestionMarkKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5106:1: (otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleTypedRefCS ) ) )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==82) ) {
                alt81=1;
            }
            switch (alt81) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5106:3: otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleTypedRefCS ) )
                    {
                    otherlv_2=(Token)match(input,82,FollowSets000.FOLLOW_82_in_ruleWildcardTypeRefCS11467); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getWildcardTypeRefCSAccess().getExtendsKeyword_2_0());
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5110:1: ( (lv_ownedExtends_3_0= ruleTypedRefCS ) )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5111:1: (lv_ownedExtends_3_0= ruleTypedRefCS )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5111:1: (lv_ownedExtends_3_0= ruleTypedRefCS )
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5112:3: lv_ownedExtends_3_0= ruleTypedRefCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getWildcardTypeRefCSAccess().getOwnedExtendsTypedRefCSParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypedRefCS_in_ruleWildcardTypeRefCS11488);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5136:1: entryRuleID returns [String current=null] : iv_ruleID= ruleID EOF ;
    public final String entryRuleID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleID = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5137:2: (iv_ruleID= ruleID EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5138:2: iv_ruleID= ruleID EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIDRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleID_in_entryRuleID11527);
            iv_ruleID=ruleID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleID.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleID11538); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5145:1: ruleID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_SIMPLE_ID_0= RULE_SIMPLE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID ) ;
    public final AntlrDatatypeRuleToken ruleID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_SIMPLE_ID_0=null;
        Token this_ESCAPED_ID_1=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5148:28: ( (this_SIMPLE_ID_0= RULE_SIMPLE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5149:1: (this_SIMPLE_ID_0= RULE_SIMPLE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5149:1: (this_SIMPLE_ID_0= RULE_SIMPLE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID )
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==RULE_SIMPLE_ID) ) {
                alt82=1;
            }
            else if ( (LA82_0==RULE_ESCAPED_ID) ) {
                alt82=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 82, 0, input);

                throw nvae;
            }
            switch (alt82) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5149:6: this_SIMPLE_ID_0= RULE_SIMPLE_ID
                    {
                    this_SIMPLE_ID_0=(Token)match(input,RULE_SIMPLE_ID,FollowSets000.FOLLOW_RULE_SIMPLE_ID_in_ruleID11578); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SIMPLE_ID_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SIMPLE_ID_0, grammarAccess.getIDAccess().getSIMPLE_IDTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5157:10: this_ESCAPED_ID_1= RULE_ESCAPED_ID
                    {
                    this_ESCAPED_ID_1=(Token)match(input,RULE_ESCAPED_ID,FollowSets000.FOLLOW_RULE_ESCAPED_ID_in_ruleID11604); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5172:1: entryRuleIdentifier returns [String current=null] : iv_ruleIdentifier= ruleIdentifier EOF ;
    public final String entryRuleIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdentifier = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5173:2: (iv_ruleIdentifier= ruleIdentifier EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5174:2: iv_ruleIdentifier= ruleIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIdentifierRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_entryRuleIdentifier11650);
            iv_ruleIdentifier=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIdentifier.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIdentifier11661); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5181:1: ruleIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= ruleID ;
    public final AntlrDatatypeRuleToken ruleIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_ID_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5184:28: (this_ID_0= ruleID )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5186:5: this_ID_0= ruleID
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getIdentifierAccess().getIDParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleID_in_ruleIdentifier11707);
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5204:1: entryRuleLOWER returns [String current=null] : iv_ruleLOWER= ruleLOWER EOF ;
    public final String entryRuleLOWER() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLOWER = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5205:2: (iv_ruleLOWER= ruleLOWER EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5206:2: iv_ruleLOWER= ruleLOWER EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLOWERRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLOWER_in_entryRuleLOWER11752);
            iv_ruleLOWER=ruleLOWER();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLOWER.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLOWER11763); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5213:1: ruleLOWER returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INT_0= RULE_INT ;
    public final AntlrDatatypeRuleToken ruleLOWER() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5216:28: (this_INT_0= RULE_INT )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5217:5: this_INT_0= RULE_INT
            {
            this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleLOWER11802); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5232:1: entryRuleNUMBER_LITERAL returns [String current=null] : iv_ruleNUMBER_LITERAL= ruleNUMBER_LITERAL EOF ;
    public final String entryRuleNUMBER_LITERAL() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNUMBER_LITERAL = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5233:2: (iv_ruleNUMBER_LITERAL= ruleNUMBER_LITERAL EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5234:2: iv_ruleNUMBER_LITERAL= ruleNUMBER_LITERAL EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNUMBER_LITERALRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNUMBER_LITERAL_in_entryRuleNUMBER_LITERAL11847);
            iv_ruleNUMBER_LITERAL=ruleNUMBER_LITERAL();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNUMBER_LITERAL.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNUMBER_LITERAL11858); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5241:1: ruleNUMBER_LITERAL returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INT_0= RULE_INT ;
    public final AntlrDatatypeRuleToken ruleNUMBER_LITERAL() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5244:28: (this_INT_0= RULE_INT )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5245:5: this_INT_0= RULE_INT
            {
            this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleNUMBER_LITERAL11897); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5260:1: entryRuleStringLiteral returns [String current=null] : iv_ruleStringLiteral= ruleStringLiteral EOF ;
    public final String entryRuleStringLiteral() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleStringLiteral = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5261:2: (iv_ruleStringLiteral= ruleStringLiteral EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5262:2: iv_ruleStringLiteral= ruleStringLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStringLiteralRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral11942);
            iv_ruleStringLiteral=ruleStringLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStringLiteral.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleStringLiteral11953); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5269:1: ruleStringLiteral returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING ;
    public final AntlrDatatypeRuleToken ruleStringLiteral() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_SINGLE_QUOTED_STRING_0=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5272:28: (this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5273:5: this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING
            {
            this_SINGLE_QUOTED_STRING_0=(Token)match(input,RULE_SINGLE_QUOTED_STRING,FollowSets000.FOLLOW_RULE_SINGLE_QUOTED_STRING_in_ruleStringLiteral11992); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5288:1: entryRuleUPPER returns [String current=null] : iv_ruleUPPER= ruleUPPER EOF ;
    public final String entryRuleUPPER() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUPPER = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5289:2: (iv_ruleUPPER= ruleUPPER EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5290:2: iv_ruleUPPER= ruleUPPER EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUPPERRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUPPER_in_entryRuleUPPER12037);
            iv_ruleUPPER=ruleUPPER();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUPPER.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUPPER12048); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5297:1: ruleUPPER returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT | kw= '*' ) ;
    public final AntlrDatatypeRuleToken ruleUPPER() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5300:28: ( (this_INT_0= RULE_INT | kw= '*' ) )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5301:1: (this_INT_0= RULE_INT | kw= '*' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5301:1: (this_INT_0= RULE_INT | kw= '*' )
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==RULE_INT) ) {
                alt83=1;
            }
            else if ( (LA83_0==18) ) {
                alt83=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 83, 0, input);

                throw nvae;
            }
            switch (alt83) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5301:6: this_INT_0= RULE_INT
                    {
                    this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleUPPER12088); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_INT_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_INT_0, grammarAccess.getUPPERAccess().getINTTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5310:2: kw= '*'
                    {
                    kw=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleUPPER12112); if (state.failed) return current;
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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5323:1: entryRuleURI returns [String current=null] : iv_ruleURI= ruleURI EOF ;
    public final String entryRuleURI() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleURI = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5324:2: (iv_ruleURI= ruleURI EOF )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5325:2: iv_ruleURI= ruleURI EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getURIRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleURI_in_entryRuleURI12153);
            iv_ruleURI=ruleURI();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleURI.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleURI12164); if (state.failed) return current;

            }

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
    // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5332:1: ruleURI returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING ;
    public final AntlrDatatypeRuleToken ruleURI() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_SINGLE_QUOTED_STRING_0=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5335:28: (this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING )
            // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:5336:5: this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING
            {
            this_SINGLE_QUOTED_STRING_0=(Token)match(input,RULE_SINGLE_QUOTED_STRING,FollowSets000.FOLLOW_RULE_SINGLE_QUOTED_STRING_in_ruleURI12203); if (state.failed) return current;
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

    // $ANTLR start synpred70_InternalEssentialOCL
    public final void synpred70_InternalEssentialOCL_fragment() throws RecognitionException {   
        EObject this_TypeLiteralCS_1 = null;


        // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2565:2: (this_TypeLiteralCS_1= ruleTypeLiteralCS )
        // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2565:2: this_TypeLiteralCS_1= ruleTypeLiteralCS
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralCS_in_synpred70_InternalEssentialOCL6060);
        this_TypeLiteralCS_1=ruleTypeLiteralCS();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred70_InternalEssentialOCL

    // $ANTLR start synpred72_InternalEssentialOCL
    public final void synpred72_InternalEssentialOCL_fragment() throws RecognitionException {   
        EObject this_PrefixedPrimaryExpCS_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_ownedRight_3_0 = null;


        // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2610:2: ( (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? ) )
        // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2610:2: (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? )
        {
        // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2610:2: (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? )
        // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2611:2: this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )?
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_rulePrefixedPrimaryExpCS_in_synpred72_InternalEssentialOCL6186);
        this_PrefixedPrimaryExpCS_0=rulePrefixedPrimaryExpCS();

        state._fsp--;
        if (state.failed) return ;
        // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2622:1: ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )?
        int alt94=2;
        int LA94_0 = input.LA(1);

        if ( (LA94_0==16||(LA94_0>=18 && LA94_0<=34)) ) {
            alt94=1;
        }
        switch (alt94) {
            case 1 :
                // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2622:2: () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) )
                {
                // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2622:2: ()
                // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2623:2: 
                {
                if ( state.backtracking==0 ) {
                   
                  	  /* */ 
                  	
                }

                }

                // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2631:2: ( (lv_name_2_0= ruleBinaryOperatorName ) )
                // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2632:1: (lv_name_2_0= ruleBinaryOperatorName )
                {
                // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2632:1: (lv_name_2_0= ruleBinaryOperatorName )
                // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2633:3: lv_name_2_0= ruleBinaryOperatorName
                {
                if ( state.backtracking==0 ) {
                   
                  	        newCompositeNode(grammarAccess.getExpCSAccess().getNameBinaryOperatorNameParserRuleCall_0_1_1_0()); 
                  	    
                }
                pushFollow(FollowSets000.FOLLOW_ruleBinaryOperatorName_in_synpred72_InternalEssentialOCL6219);
                lv_name_2_0=ruleBinaryOperatorName();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2649:2: ( (lv_ownedRight_3_0= ruleExpCS ) )
                // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2650:1: (lv_ownedRight_3_0= ruleExpCS )
                {
                // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2650:1: (lv_ownedRight_3_0= ruleExpCS )
                // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2651:3: lv_ownedRight_3_0= ruleExpCS
                {
                if ( state.backtracking==0 ) {
                   
                  	        newCompositeNode(grammarAccess.getExpCSAccess().getOwnedRightExpCSParserRuleCall_0_1_2_0()); 
                  	    
                }
                pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_synpred72_InternalEssentialOCL6240);
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
    // $ANTLR end synpred72_InternalEssentialOCL

    // $ANTLR start synpred79_InternalEssentialOCL
    public final void synpred79_InternalEssentialOCL_fragment() throws RecognitionException {   
        EObject this_TupleLiteralExpCS_4 = null;


        // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2912:2: (this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS )
        // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2912:2: this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralExpCS_in_synpred79_InternalEssentialOCL6803);
        this_TupleLiteralExpCS_4=ruleTupleLiteralExpCS();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred79_InternalEssentialOCL

    // $ANTLR start synpred80_InternalEssentialOCL
    public final void synpred80_InternalEssentialOCL_fragment() throws RecognitionException {   
        EObject this_MapLiteralExpCS_5 = null;


        // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2925:2: (this_MapLiteralExpCS_5= ruleMapLiteralExpCS )
        // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2925:2: this_MapLiteralExpCS_5= ruleMapLiteralExpCS
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleMapLiteralExpCS_in_synpred80_InternalEssentialOCL6833);
        this_MapLiteralExpCS_5=ruleMapLiteralExpCS();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred80_InternalEssentialOCL

    // $ANTLR start synpred81_InternalEssentialOCL
    public final void synpred81_InternalEssentialOCL_fragment() throws RecognitionException {   
        EObject this_CollectionLiteralExpCS_6 = null;


        // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2938:2: (this_CollectionLiteralExpCS_6= ruleCollectionLiteralExpCS )
        // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2938:2: this_CollectionLiteralExpCS_6= ruleCollectionLiteralExpCS
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteralExpCS_in_synpred81_InternalEssentialOCL6863);
        this_CollectionLiteralExpCS_6=ruleCollectionLiteralExpCS();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred81_InternalEssentialOCL

    // $ANTLR start synpred83_InternalEssentialOCL
    public final void synpred83_InternalEssentialOCL_fragment() throws RecognitionException {   
        EObject this_TypeLiteralExpCS_8 = null;


        // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2964:2: (this_TypeLiteralExpCS_8= ruleTypeLiteralExpCS )
        // ../../plugins/org.eclipse.ocl.xtext.essentialocl/src-gen/org/eclipse/ocl/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2964:2: this_TypeLiteralExpCS_8= ruleTypeLiteralExpCS
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralExpCS_in_synpred83_InternalEssentialOCL6923);
        this_TypeLiteralExpCS_8=ruleTypeLiteralExpCS();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred83_InternalEssentialOCL

    // Delegated rules

    public final boolean synpred70_InternalEssentialOCL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred70_InternalEssentialOCL_fragment(); // can never throw exception
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
    public final boolean synpred79_InternalEssentialOCL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred79_InternalEssentialOCL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred72_InternalEssentialOCL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred72_InternalEssentialOCL_fragment(); // can never throw exception
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


    protected DFA37 dfa37 = new DFA37(this);
    protected DFA39 dfa39 = new DFA39(this);
    protected DFA42 dfa42 = new DFA42(this);
    static final String DFA37_eotS =
        "\23\uffff";
    static final String DFA37_eofS =
        "\23\uffff";
    static final String DFA37_minS =
        "\1\4\12\uffff\5\0\3\uffff";
    static final String DFA37_maxS =
        "\1\61\12\uffff\5\0\3\uffff";
    static final String DFA37_acceptS =
        "\1\uffff\1\1\1\uffff\1\2\16\uffff\1\3";
    static final String DFA37_specialS =
        "\13\uffff\1\0\1\1\1\2\1\3\1\4\3\uffff}>";
    static final String[] DFA37_transitionS = {
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

    static final short[] DFA37_eot = DFA.unpackEncodedString(DFA37_eotS);
    static final short[] DFA37_eof = DFA.unpackEncodedString(DFA37_eofS);
    static final char[] DFA37_min = DFA.unpackEncodedStringToUnsignedChars(DFA37_minS);
    static final char[] DFA37_max = DFA.unpackEncodedStringToUnsignedChars(DFA37_maxS);
    static final short[] DFA37_accept = DFA.unpackEncodedString(DFA37_acceptS);
    static final short[] DFA37_special = DFA.unpackEncodedString(DFA37_specialS);
    static final short[][] DFA37_transition;

    static {
        int numStates = DFA37_transitionS.length;
        DFA37_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA37_transition[i] = DFA.unpackEncodedString(DFA37_transitionS[i]);
        }
    }

    class DFA37 extends DFA {

        public DFA37(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 37;
            this.eot = DFA37_eot;
            this.eof = DFA37_eof;
            this.min = DFA37_min;
            this.max = DFA37_max;
            this.accept = DFA37_accept;
            this.special = DFA37_special;
            this.transition = DFA37_transition;
        }
        public String getDescription() {
            return "2551:1: (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS | this_CollectionPatternCS_2= ruleCollectionPatternCS )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA37_11 = input.LA(1);

                         
                        int index37_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred70_InternalEssentialOCL()) ) {s = 3;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index37_11);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA37_12 = input.LA(1);

                         
                        int index37_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred70_InternalEssentialOCL()) ) {s = 3;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index37_12);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA37_13 = input.LA(1);

                         
                        int index37_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred70_InternalEssentialOCL()) ) {s = 3;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index37_13);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA37_14 = input.LA(1);

                         
                        int index37_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred70_InternalEssentialOCL()) ) {s = 3;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index37_14);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA37_15 = input.LA(1);

                         
                        int index37_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred70_InternalEssentialOCL()) ) {s = 3;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index37_15);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 37, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA39_eotS =
        "\40\uffff";
    static final String DFA39_eofS =
        "\40\uffff";
    static final String DFA39_minS =
        "\1\4\2\0\35\uffff";
    static final String DFA39_maxS =
        "\1\115\2\0\35\uffff";
    static final String DFA39_acceptS =
        "\3\uffff\1\1\33\uffff\1\2";
    static final String DFA39_specialS =
        "\1\uffff\1\0\1\1\35\uffff}>";
    static final String[] DFA39_transitionS = {
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
            return "2610:1: ( (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? ) | this_PrefixedLetExpCS_4= rulePrefixedLetExpCS )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA39_1 = input.LA(1);

                         
                        int index39_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred72_InternalEssentialOCL()) ) {s = 3;}

                        else if ( (true) ) {s = 31;}

                         
                        input.seek(index39_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA39_2 = input.LA(1);

                         
                        int index39_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred72_InternalEssentialOCL()) ) {s = 3;}

                        else if ( (true) ) {s = 31;}

                         
                        input.seek(index39_2);
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
    static final String DFA42_eotS =
        "\40\uffff";
    static final String DFA42_eofS =
        "\40\uffff";
    static final String DFA42_minS =
        "\1\4\12\uffff\7\0\16\uffff";
    static final String DFA42_maxS =
        "\1\115\12\uffff\7\0\16\uffff";
    static final String DFA42_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\15\uffff\1\10\1\11\7\uffff\1\12\1\uffff"+
        "\1\5\1\6\1\7";
    static final String DFA42_specialS =
        "\13\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\16\uffff}>";
    static final String[] DFA42_transitionS = {
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

    static final short[] DFA42_eot = DFA.unpackEncodedString(DFA42_eotS);
    static final short[] DFA42_eof = DFA.unpackEncodedString(DFA42_eofS);
    static final char[] DFA42_min = DFA.unpackEncodedStringToUnsignedChars(DFA42_minS);
    static final char[] DFA42_max = DFA.unpackEncodedStringToUnsignedChars(DFA42_maxS);
    static final short[] DFA42_accept = DFA.unpackEncodedString(DFA42_acceptS);
    static final short[] DFA42_special = DFA.unpackEncodedString(DFA42_specialS);
    static final short[][] DFA42_transition;

    static {
        int numStates = DFA42_transitionS.length;
        DFA42_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA42_transition[i] = DFA.unpackEncodedString(DFA42_transitionS[i]);
        }
    }

    class DFA42 extends DFA {

        public DFA42(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 42;
            this.eot = DFA42_eot;
            this.eof = DFA42_eof;
            this.min = DFA42_min;
            this.max = DFA42_max;
            this.accept = DFA42_accept;
            this.special = DFA42_special;
            this.transition = DFA42_transition;
        }
        public String getDescription() {
            return "2859:1: (this_NestedExpCS_0= ruleNestedExpCS | this_IfExpCS_1= ruleIfExpCS | this_SelfExpCS_2= ruleSelfExpCS | this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS | this_MapLiteralExpCS_5= ruleMapLiteralExpCS | this_CollectionLiteralExpCS_6= ruleCollectionLiteralExpCS | this_LambdaLiteralExpCS_7= ruleLambdaLiteralExpCS | this_TypeLiteralExpCS_8= ruleTypeLiteralExpCS | this_NameExpCS_9= ruleNameExpCS )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA42_11 = input.LA(1);

                         
                        int index42_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred79_InternalEssentialOCL()) ) {s = 29;}

                        else if ( (synpred83_InternalEssentialOCL()) ) {s = 19;}

                         
                        input.seek(index42_11);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA42_12 = input.LA(1);

                         
                        int index42_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred80_InternalEssentialOCL()) ) {s = 30;}

                        else if ( (synpred83_InternalEssentialOCL()) ) {s = 19;}

                         
                        input.seek(index42_12);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA42_13 = input.LA(1);

                         
                        int index42_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalEssentialOCL()) ) {s = 31;}

                        else if ( (synpred83_InternalEssentialOCL()) ) {s = 19;}

                         
                        input.seek(index42_13);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA42_14 = input.LA(1);

                         
                        int index42_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalEssentialOCL()) ) {s = 31;}

                        else if ( (synpred83_InternalEssentialOCL()) ) {s = 19;}

                         
                        input.seek(index42_14);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA42_15 = input.LA(1);

                         
                        int index42_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalEssentialOCL()) ) {s = 31;}

                        else if ( (synpred83_InternalEssentialOCL()) ) {s = 19;}

                         
                        input.seek(index42_15);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA42_16 = input.LA(1);

                         
                        int index42_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalEssentialOCL()) ) {s = 31;}

                        else if ( (synpred83_InternalEssentialOCL()) ) {s = 19;}

                         
                        input.seek(index42_16);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA42_17 = input.LA(1);

                         
                        int index42_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalEssentialOCL()) ) {s = 31;}

                        else if ( (synpred83_InternalEssentialOCL()) ) {s = 19;}

                         
                        input.seek(index42_17);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 42, _s, input);
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
        public static final BitSet FOLLOW_ruleCollectionTypeIdentifier_in_ruleCollectionTypeCS2405 = new BitSet(new long[]{0x0004000000000002L,0x0000000000000004L});
        public static final BitSet FOLLOW_50_in_ruleCollectionTypeCS2418 = new BitSet(new long[]{0x0003FFF800000030L});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleCollectionTypeCS2439 = new BitSet(new long[]{0x0008000000000000L});
        public static final BitSet FOLLOW_51_in_ruleCollectionTypeCS2451 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
        public static final BitSet FOLLOW_ruleMultiplicityCS_in_ruleCollectionTypeCS2474 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMapTypeCS_in_entryRuleMapTypeCS2511 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMapTypeCS2521 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_ruleMapTypeCS2564 = new BitSet(new long[]{0x0004000000000002L});
        public static final BitSet FOLLOW_50_in_ruleMapTypeCS2590 = new BitSet(new long[]{0x0003FFF800000030L});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleMapTypeCS2611 = new BitSet(new long[]{0x0010000000000000L});
        public static final BitSet FOLLOW_52_in_ruleMapTypeCS2623 = new BitSet(new long[]{0x0003FFF800000030L});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleMapTypeCS2644 = new BitSet(new long[]{0x0008000000000000L});
        public static final BitSet FOLLOW_51_in_ruleMapTypeCS2656 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTupleTypeCS_in_entryRuleTupleTypeCS2694 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTupleTypeCS2704 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_ruleTupleTypeCS2747 = new BitSet(new long[]{0x0004000000000002L});
        public static final BitSet FOLLOW_50_in_ruleTupleTypeCS2773 = new BitSet(new long[]{0x0008000000000030L});
        public static final BitSet FOLLOW_ruleTuplePartCS_in_ruleTupleTypeCS2795 = new BitSet(new long[]{0x0018000000000000L});
        public static final BitSet FOLLOW_52_in_ruleTupleTypeCS2808 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleTuplePartCS_in_ruleTupleTypeCS2829 = new BitSet(new long[]{0x0018000000000000L});
        public static final BitSet FOLLOW_51_in_ruleTupleTypeCS2845 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTuplePartCS_in_entryRuleTuplePartCS2883 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTuplePartCS2893 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleTuplePartCS2939 = new BitSet(new long[]{0x0020000000000000L});
        public static final BitSet FOLLOW_53_in_ruleTuplePartCS2951 = new BitSet(new long[]{0x0003FFF800000030L});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleTuplePartCS2972 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionLiteralExpCS_in_entryRuleCollectionLiteralExpCS3008 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCollectionLiteralExpCS3018 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionTypeCS_in_ruleCollectionLiteralExpCS3064 = new BitSet(new long[]{0x0040000000000000L});
        public static final BitSet FOLLOW_54_in_ruleCollectionLiteralExpCS3076 = new BitSet(new long[]{0xF4A7FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleCollectionLiteralPartCS_in_ruleCollectionLiteralExpCS3098 = new BitSet(new long[]{0x0090000000000000L});
        public static final BitSet FOLLOW_52_in_ruleCollectionLiteralExpCS3111 = new BitSet(new long[]{0xF427FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleCollectionLiteralPartCS_in_ruleCollectionLiteralExpCS3132 = new BitSet(new long[]{0x0090000000000000L});
        public static final BitSet FOLLOW_55_in_ruleCollectionLiteralExpCS3148 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionLiteralPartCS_in_entryRuleCollectionLiteralPartCS3184 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCollectionLiteralPartCS3194 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleCollectionLiteralPartCS3241 = new BitSet(new long[]{0x0100000000000002L});
        public static final BitSet FOLLOW_56_in_ruleCollectionLiteralPartCS3254 = new BitSet(new long[]{0xF407FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleCollectionLiteralPartCS3275 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePatternExpCS_in_ruleCollectionLiteralPartCS3305 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionPatternCS_in_entryRuleCollectionPatternCS3341 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCollectionPatternCS3351 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionTypeCS_in_ruleCollectionPatternCS3397 = new BitSet(new long[]{0x0040000000000000L});
        public static final BitSet FOLLOW_54_in_ruleCollectionPatternCS3409 = new BitSet(new long[]{0xF4A7FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_rulePatternExpCS_in_ruleCollectionPatternCS3431 = new BitSet(new long[]{0x0210000000000000L});
        public static final BitSet FOLLOW_52_in_ruleCollectionPatternCS3444 = new BitSet(new long[]{0xF427FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_rulePatternExpCS_in_ruleCollectionPatternCS3465 = new BitSet(new long[]{0x0210000000000000L});
        public static final BitSet FOLLOW_57_in_ruleCollectionPatternCS3480 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleIdentifier_in_ruleCollectionPatternCS3501 = new BitSet(new long[]{0x0080000000000000L});
        public static final BitSet FOLLOW_55_in_ruleCollectionPatternCS3516 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleShadowPartCS_in_entryRuleShadowPartCS3552 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleShadowPartCS3562 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleShadowPartCS3614 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_25_in_ruleShadowPartCS3626 = new BitSet(new long[]{0xF427FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleShadowPartCS3649 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePatternExpCS_in_ruleShadowPartCS3668 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePatternExpCS_in_entryRulePatternExpCS3707 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePatternExpCS3717 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_rulePatternExpCS3763 = new BitSet(new long[]{0x0020000000000000L});
        public static final BitSet FOLLOW_53_in_rulePatternExpCS3776 = new BitSet(new long[]{0x0003FFF800000030L});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_rulePatternExpCS3797 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLambdaLiteralExpCS_in_entryRuleLambdaLiteralExpCS3833 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLambdaLiteralExpCS3843 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_58_in_ruleLambdaLiteralExpCS3880 = new BitSet(new long[]{0x0040000000000000L});
        public static final BitSet FOLLOW_54_in_ruleLambdaLiteralExpCS3892 = new BitSet(new long[]{0xF407FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleLambdaLiteralExpCS3913 = new BitSet(new long[]{0x0080000000000000L});
        public static final BitSet FOLLOW_55_in_ruleLambdaLiteralExpCS3925 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMapLiteralExpCS_in_entryRuleMapLiteralExpCS3961 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMapLiteralExpCS3971 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMapTypeCS_in_ruleMapLiteralExpCS4017 = new BitSet(new long[]{0x0040000000000000L});
        public static final BitSet FOLLOW_54_in_ruleMapLiteralExpCS4029 = new BitSet(new long[]{0xF487FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleMapLiteralPartCS_in_ruleMapLiteralExpCS4051 = new BitSet(new long[]{0x0090000000000000L});
        public static final BitSet FOLLOW_52_in_ruleMapLiteralExpCS4064 = new BitSet(new long[]{0xF407FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleMapLiteralPartCS_in_ruleMapLiteralExpCS4085 = new BitSet(new long[]{0x0090000000000000L});
        public static final BitSet FOLLOW_55_in_ruleMapLiteralExpCS4101 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMapLiteralPartCS_in_entryRuleMapLiteralPartCS4137 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMapLiteralPartCS4147 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleMapLiteralPartCS4193 = new BitSet(new long[]{0x0800000000000000L});
        public static final BitSet FOLLOW_59_in_ruleMapLiteralPartCS4205 = new BitSet(new long[]{0xF407FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleMapLiteralPartCS4226 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveLiteralExpCS_in_entryRulePrimitiveLiteralExpCS4262 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrimitiveLiteralExpCS4272 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNumberLiteralExpCS_in_rulePrimitiveLiteralExpCS4322 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringLiteralExpCS_in_rulePrimitiveLiteralExpCS4352 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBooleanLiteralExpCS_in_rulePrimitiveLiteralExpCS4382 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnlimitedNaturalLiteralExpCS_in_rulePrimitiveLiteralExpCS4412 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInvalidLiteralExpCS_in_rulePrimitiveLiteralExpCS4442 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNullLiteralExpCS_in_rulePrimitiveLiteralExpCS4472 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTupleLiteralExpCS_in_entryRuleTupleLiteralExpCS4507 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTupleLiteralExpCS4517 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_ruleTupleLiteralExpCS4554 = new BitSet(new long[]{0x0040000000000000L});
        public static final BitSet FOLLOW_54_in_ruleTupleLiteralExpCS4566 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleTupleLiteralPartCS_in_ruleTupleLiteralExpCS4587 = new BitSet(new long[]{0x0090000000000000L});
        public static final BitSet FOLLOW_52_in_ruleTupleLiteralExpCS4600 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleTupleLiteralPartCS_in_ruleTupleLiteralExpCS4621 = new BitSet(new long[]{0x0090000000000000L});
        public static final BitSet FOLLOW_55_in_ruleTupleLiteralExpCS4635 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTupleLiteralPartCS_in_entryRuleTupleLiteralPartCS4671 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTupleLiteralPartCS4681 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleTupleLiteralPartCS4727 = new BitSet(new long[]{0x0020000002000000L});
        public static final BitSet FOLLOW_53_in_ruleTupleLiteralPartCS4740 = new BitSet(new long[]{0x0003FFF800000030L});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleTupleLiteralPartCS4761 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_25_in_ruleTupleLiteralPartCS4775 = new BitSet(new long[]{0xF407FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleTupleLiteralPartCS4796 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNumberLiteralExpCS_in_entryRuleNumberLiteralExpCS4832 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNumberLiteralExpCS4842 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNUMBER_LITERAL_in_ruleNumberLiteralExpCS4887 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringLiteralExpCS_in_entryRuleStringLiteralExpCS4922 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteralExpCS4932 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringLiteral_in_ruleStringLiteralExpCS4977 = new BitSet(new long[]{0x0000000000000082L});
        public static final BitSet FOLLOW_ruleBooleanLiteralExpCS_in_entryRuleBooleanLiteralExpCS5013 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBooleanLiteralExpCS5023 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_60_in_ruleBooleanLiteralExpCS5066 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_61_in_ruleBooleanLiteralExpCS5103 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnlimitedNaturalLiteralExpCS_in_entryRuleUnlimitedNaturalLiteralExpCS5152 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnlimitedNaturalLiteralExpCS5162 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleUnlimitedNaturalLiteralExpCS5211 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInvalidLiteralExpCS_in_entryRuleInvalidLiteralExpCS5247 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleInvalidLiteralExpCS5257 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_62_in_ruleInvalidLiteralExpCS5306 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNullLiteralExpCS_in_entryRuleNullLiteralExpCS5342 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNullLiteralExpCS5352 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_63_in_ruleNullLiteralExpCS5401 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralCS_in_entryRuleTypeLiteralCS5437 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeLiteralCS5447 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveTypeCS_in_ruleTypeLiteralCS5498 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
        public static final BitSet FOLLOW_ruleSimpleMultiplicityCS_in_ruleTypeLiteralCS5518 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionTypeCS_in_ruleTypeLiteralCS5551 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMapTypeCS_in_ruleTypeLiteralCS5582 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
        public static final BitSet FOLLOW_ruleSimpleMultiplicityCS_in_ruleTypeLiteralCS5602 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTupleTypeCS_in_ruleTypeLiteralCS5636 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
        public static final BitSet FOLLOW_ruleSimpleMultiplicityCS_in_ruleTypeLiteralCS5656 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralExpCS_in_entryRuleTypeLiteralExpCS5694 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeLiteralExpCS5704 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralCS_in_ruleTypeLiteralExpCS5749 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeNameExpCS_in_entryRuleTypeNameExpCS5784 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeNameExpCS5794 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePathNameCS_in_ruleTypeNameExpCS5840 = new BitSet(new long[]{0x0040000000000002L,0x0000000000000004L});
        public static final BitSet FOLLOW_ruleCurlyBracketedClauseCS_in_ruleTypeNameExpCS5862 = new BitSet(new long[]{0x0040000000000002L,0x0000000000000004L});
        public static final BitSet FOLLOW_54_in_ruleTypeNameExpCS5875 = new BitSet(new long[]{0xF407FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleTypeNameExpCS5896 = new BitSet(new long[]{0x0080000000000000L});
        public static final BitSet FOLLOW_55_in_ruleTypeNameExpCS5908 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
        public static final BitSet FOLLOW_ruleSimpleMultiplicityCS_in_ruleTypeNameExpCS5933 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_entryRuleTypeExpCS5970 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeExpCS5980 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeNameExpCS_in_ruleTypeExpCS6030 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralCS_in_ruleTypeExpCS6060 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionPatternCS_in_ruleTypeExpCS6090 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpCS_in_entryRuleExpCS6125 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleExpCS6135 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrefixedPrimaryExpCS_in_ruleExpCS6186 = new BitSet(new long[]{0x00000007FFFD0002L});
        public static final BitSet FOLLOW_ruleBinaryOperatorName_in_ruleExpCS6219 = new BitSet(new long[]{0xF407FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleExpCS6240 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrefixedLetExpCS_in_ruleExpCS6274 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrefixedLetExpCS_in_entryRulePrefixedLetExpCS6309 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrefixedLetExpCS6319 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnaryOperatorName_in_rulePrefixedLetExpCS6378 = new BitSet(new long[]{0xF407FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_rulePrefixedLetExpCS_in_rulePrefixedLetExpCS6399 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLetExpCS_in_rulePrefixedLetExpCS6431 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrefixedPrimaryExpCS_in_entryRulePrefixedPrimaryExpCS6466 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrefixedPrimaryExpCS6476 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnaryOperatorName_in_rulePrefixedPrimaryExpCS6535 = new BitSet(new long[]{0xF407FFF8000700F0L,0x0000000000002080L});
        public static final BitSet FOLLOW_rulePrefixedPrimaryExpCS_in_rulePrefixedPrimaryExpCS6556 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimaryExpCS_in_rulePrefixedPrimaryExpCS6588 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimaryExpCS_in_entryRulePrimaryExpCS6623 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpCS6633 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedExpCS_in_rulePrimaryExpCS6683 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIfExpCS_in_rulePrimaryExpCS6713 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSelfExpCS_in_rulePrimaryExpCS6743 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveLiteralExpCS_in_rulePrimaryExpCS6773 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTupleLiteralExpCS_in_rulePrimaryExpCS6803 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMapLiteralExpCS_in_rulePrimaryExpCS6833 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionLiteralExpCS_in_rulePrimaryExpCS6863 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLambdaLiteralExpCS_in_rulePrimaryExpCS6893 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralExpCS_in_rulePrimaryExpCS6923 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNameExpCS_in_rulePrimaryExpCS6953 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNameExpCS_in_entryRuleNameExpCS6988 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNameExpCS6998 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePathNameCS_in_ruleNameExpCS7044 = new BitSet(new long[]{0x0044000000000002L,0x0000000000000005L});
        public static final BitSet FOLLOW_ruleSquareBracketedClauseCS_in_ruleNameExpCS7065 = new BitSet(new long[]{0x0044000000000002L,0x0000000000000005L});
        public static final BitSet FOLLOW_ruleRoundBracketedClauseCS_in_ruleNameExpCS7087 = new BitSet(new long[]{0x0040000000000002L,0x0000000000000001L});
        public static final BitSet FOLLOW_ruleCurlyBracketedClauseCS_in_ruleNameExpCS7109 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
        public static final BitSet FOLLOW_64_in_ruleNameExpCS7129 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
        public static final BitSet FOLLOW_65_in_ruleNameExpCS7154 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCurlyBracketedClauseCS_in_entryRuleCurlyBracketedClauseCS7192 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCurlyBracketedClauseCS7202 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_54_in_ruleCurlyBracketedClauseCS7251 = new BitSet(new long[]{0x00800000000000B0L});
        public static final BitSet FOLLOW_ruleStringLiteral_in_ruleCurlyBracketedClauseCS7273 = new BitSet(new long[]{0x0080000000000000L});
        public static final BitSet FOLLOW_ruleShadowPartCS_in_ruleCurlyBracketedClauseCS7301 = new BitSet(new long[]{0x0090000000000000L});
        public static final BitSet FOLLOW_52_in_ruleCurlyBracketedClauseCS7314 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleShadowPartCS_in_ruleCurlyBracketedClauseCS7335 = new BitSet(new long[]{0x0090000000000000L});
        public static final BitSet FOLLOW_55_in_ruleCurlyBracketedClauseCS7352 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRoundBracketedClauseCS_in_entryRuleRoundBracketedClauseCS7388 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRoundBracketedClauseCS7398 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_50_in_ruleRoundBracketedClauseCS7447 = new BitSet(new long[]{0xF42FFFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleNavigatingArgCS_in_ruleRoundBracketedClauseCS7469 = new BitSet(new long[]{0x0018000000000000L,0x0000000000000060L});
        public static final BitSet FOLLOW_ruleNavigatingCommaArgCS_in_ruleRoundBracketedClauseCS7490 = new BitSet(new long[]{0x0018000000000000L,0x0000000000000060L});
        public static final BitSet FOLLOW_ruleNavigatingSemiArgCS_in_ruleRoundBracketedClauseCS7513 = new BitSet(new long[]{0x0018000000000000L,0x0000000000000020L});
        public static final BitSet FOLLOW_ruleNavigatingCommaArgCS_in_ruleRoundBracketedClauseCS7534 = new BitSet(new long[]{0x0018000000000000L,0x0000000000000020L});
        public static final BitSet FOLLOW_ruleNavigatingBarArgCS_in_ruleRoundBracketedClauseCS7559 = new BitSet(new long[]{0x0018000000000000L,0x0000000000000020L});
        public static final BitSet FOLLOW_ruleNavigatingCommaArgCS_in_ruleRoundBracketedClauseCS7580 = new BitSet(new long[]{0x0018000000000000L,0x0000000000000020L});
        public static final BitSet FOLLOW_51_in_ruleRoundBracketedClauseCS7597 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSquareBracketedClauseCS_in_entryRuleSquareBracketedClauseCS7633 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSquareBracketedClauseCS7643 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_66_in_ruleSquareBracketedClauseCS7680 = new BitSet(new long[]{0xF407FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleSquareBracketedClauseCS7701 = new BitSet(new long[]{0x0010000000000000L,0x0000000000000008L});
        public static final BitSet FOLLOW_52_in_ruleSquareBracketedClauseCS7714 = new BitSet(new long[]{0xF407FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleSquareBracketedClauseCS7735 = new BitSet(new long[]{0x0010000000000000L,0x0000000000000008L});
        public static final BitSet FOLLOW_67_in_ruleSquareBracketedClauseCS7749 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingArgCS_in_entryRuleNavigatingArgCS7785 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigatingArgCS7795 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingArgCS7842 = new BitSet(new long[]{0x0020000000000002L,0x0000000000000010L});
        public static final BitSet FOLLOW_53_in_ruleNavigatingArgCS7856 = new BitSet(new long[]{0x0003FFF800000030L});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleNavigatingArgCS7877 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_25_in_ruleNavigatingArgCS7890 = new BitSet(new long[]{0xF407FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNavigatingArgCS7911 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_68_in_ruleNavigatingArgCS7933 = new BitSet(new long[]{0xF407FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNavigatingArgCS7954 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_53_in_ruleNavigatingArgCS7977 = new BitSet(new long[]{0x0003FFF800000030L});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleNavigatingArgCS7998 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingBarArgCS_in_entryRuleNavigatingBarArgCS8035 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigatingBarArgCS8045 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_69_in_ruleNavigatingBarArgCS8088 = new BitSet(new long[]{0xF407FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingBarArgCS8122 = new BitSet(new long[]{0x0020000000000002L});
        public static final BitSet FOLLOW_53_in_ruleNavigatingBarArgCS8135 = new BitSet(new long[]{0x0003FFF800000030L});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleNavigatingBarArgCS8156 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_25_in_ruleNavigatingBarArgCS8169 = new BitSet(new long[]{0xF407FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNavigatingBarArgCS8190 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingCommaArgCS_in_entryRuleNavigatingCommaArgCS8230 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigatingCommaArgCS8240 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_52_in_ruleNavigatingCommaArgCS8283 = new BitSet(new long[]{0xF407FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingCommaArgCS8317 = new BitSet(new long[]{0x0020000000000002L,0x0000000000000010L});
        public static final BitSet FOLLOW_53_in_ruleNavigatingCommaArgCS8331 = new BitSet(new long[]{0x0003FFF800000030L});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleNavigatingCommaArgCS8352 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_25_in_ruleNavigatingCommaArgCS8365 = new BitSet(new long[]{0xF407FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNavigatingCommaArgCS8386 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_68_in_ruleNavigatingCommaArgCS8408 = new BitSet(new long[]{0xF407FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNavigatingCommaArgCS8429 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingSemiArgCS_in_entryRuleNavigatingSemiArgCS8468 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigatingSemiArgCS8478 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_70_in_ruleNavigatingSemiArgCS8521 = new BitSet(new long[]{0xF407FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingSemiArgCS8555 = new BitSet(new long[]{0x0020000000000002L});
        public static final BitSet FOLLOW_53_in_ruleNavigatingSemiArgCS8568 = new BitSet(new long[]{0x0003FFF800000030L});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleNavigatingSemiArgCS8589 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_25_in_ruleNavigatingSemiArgCS8602 = new BitSet(new long[]{0xF407FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNavigatingSemiArgCS8623 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingArgExpCS_in_entryRuleNavigatingArgExpCS8663 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigatingArgExpCS8673 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNavigatingArgExpCS8722 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIfExpCS_in_entryRuleIfExpCS8756 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIfExpCS8766 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_71_in_ruleIfExpCS8803 = new BitSet(new long[]{0xF427FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleIfExpCS8826 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
        public static final BitSet FOLLOW_rulePatternExpCS_in_ruleIfExpCS8845 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
        public static final BitSet FOLLOW_72_in_ruleIfExpCS8860 = new BitSet(new long[]{0xF407FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleIfExpCS8881 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000A00L});
        public static final BitSet FOLLOW_ruleElseIfThenExpCS_in_ruleIfExpCS8902 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000A00L});
        public static final BitSet FOLLOW_73_in_ruleIfExpCS8915 = new BitSet(new long[]{0xF407FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleIfExpCS8936 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
        public static final BitSet FOLLOW_74_in_ruleIfExpCS8948 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleElseIfThenExpCS_in_entryRuleElseIfThenExpCS8984 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleElseIfThenExpCS8994 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_75_in_ruleElseIfThenExpCS9031 = new BitSet(new long[]{0xF407FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleElseIfThenExpCS9052 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
        public static final BitSet FOLLOW_72_in_ruleElseIfThenExpCS9064 = new BitSet(new long[]{0xF407FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleElseIfThenExpCS9085 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLetExpCS_in_entryRuleLetExpCS9121 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLetExpCS9131 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_76_in_ruleLetExpCS9168 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleLetVariableCS_in_ruleLetExpCS9189 = new BitSet(new long[]{0x0010000000000000L,0x0000000000000010L});
        public static final BitSet FOLLOW_52_in_ruleLetExpCS9202 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleLetVariableCS_in_ruleLetExpCS9223 = new BitSet(new long[]{0x0010000000000000L,0x0000000000000010L});
        public static final BitSet FOLLOW_68_in_ruleLetExpCS9237 = new BitSet(new long[]{0xF407FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleLetExpCS9258 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLetVariableCS_in_entryRuleLetVariableCS9294 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLetVariableCS9304 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleLetVariableCS9350 = new BitSet(new long[]{0x0024000002000000L});
        public static final BitSet FOLLOW_ruleRoundBracketedClauseCS_in_ruleLetVariableCS9371 = new BitSet(new long[]{0x0020000002000000L});
        public static final BitSet FOLLOW_53_in_ruleLetVariableCS9385 = new BitSet(new long[]{0x0003FFF800000030L});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleLetVariableCS9406 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_25_in_ruleLetVariableCS9420 = new BitSet(new long[]{0xF407FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleLetVariableCS9441 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedExpCS_in_entryRuleNestedExpCS9477 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNestedExpCS9487 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_50_in_ruleNestedExpCS9524 = new BitSet(new long[]{0xF407FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNestedExpCS9545 = new BitSet(new long[]{0x0008000000000000L});
        public static final BitSet FOLLOW_51_in_ruleNestedExpCS9557 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSelfExpCS_in_entryRuleSelfExpCS9593 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSelfExpCS9603 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_77_in_ruleSelfExpCS9652 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiplicityBoundsCS_in_entryRuleMultiplicityBoundsCS9688 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicityBoundsCS9698 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLOWER_in_ruleMultiplicityBoundsCS9744 = new BitSet(new long[]{0x0100000000000002L});
        public static final BitSet FOLLOW_56_in_ruleMultiplicityBoundsCS9757 = new BitSet(new long[]{0x0000000000040040L});
        public static final BitSet FOLLOW_ruleUPPER_in_ruleMultiplicityBoundsCS9778 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiplicityCS_in_entryRuleMultiplicityCS9816 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicityCS9826 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_66_in_ruleMultiplicityCS9863 = new BitSet(new long[]{0x0000000000140040L,0x0000000000010000L});
        public static final BitSet FOLLOW_ruleMultiplicityBoundsCS_in_ruleMultiplicityCS9889 = new BitSet(new long[]{0x0000000000000000L,0x000000000000C008L});
        public static final BitSet FOLLOW_ruleMultiplicityStringCS_in_ruleMultiplicityCS9919 = new BitSet(new long[]{0x0000000000000000L,0x000000000000C008L});
        public static final BitSet FOLLOW_78_in_ruleMultiplicityCS9932 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
        public static final BitSet FOLLOW_79_in_ruleMultiplicityCS9956 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
        public static final BitSet FOLLOW_67_in_ruleMultiplicityCS9983 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimpleMultiplicityCS_in_entryRuleSimpleMultiplicityCS10019 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSimpleMultiplicityCS10029 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_66_in_ruleSimpleMultiplicityCS10066 = new BitSet(new long[]{0x0000000000140040L,0x0000000000010000L});
        public static final BitSet FOLLOW_ruleMultiplicityBoundsCS_in_ruleSimpleMultiplicityCS10092 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
        public static final BitSet FOLLOW_ruleMultiplicityStringCS_in_ruleSimpleMultiplicityCS10122 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
        public static final BitSet FOLLOW_67_in_ruleSimpleMultiplicityCS10134 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiplicityStringCS_in_entryRuleMultiplicityStringCS10170 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicityStringCS10180 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleMultiplicityStringCS10224 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleMultiplicityStringCS10253 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_80_in_ruleMultiplicityStringCS10282 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePathNameCS_in_entryRulePathNameCS10333 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePathNameCS10343 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFirstPathElementCS_in_rulePathNameCS10389 = new BitSet(new long[]{0x0000000000000002L,0x0000000000020000L});
        public static final BitSet FOLLOW_81_in_rulePathNameCS10402 = new BitSet(new long[]{0x0003FFF800000030L});
        public static final BitSet FOLLOW_ruleNextPathElementCS_in_rulePathNameCS10423 = new BitSet(new long[]{0x0000000000000002L,0x0000000000020000L});
        public static final BitSet FOLLOW_ruleFirstPathElementCS_in_entryRuleFirstPathElementCS10461 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFirstPathElementCS10471 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleFirstPathElementCS10522 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNextPathElementCS_in_entryRuleNextPathElementCS10557 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNextPathElementCS10567 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnreservedName_in_ruleNextPathElementCS10618 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTemplateBindingCS_in_entryRuleTemplateBindingCS10653 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTemplateBindingCS10663 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTemplateParameterSubstitutionCS_in_ruleTemplateBindingCS10709 = new BitSet(new long[]{0x0010000000000002L});
        public static final BitSet FOLLOW_52_in_ruleTemplateBindingCS10722 = new BitSet(new long[]{0x0000000000000030L,0x0000000000010000L});
        public static final BitSet FOLLOW_ruleTemplateParameterSubstitutionCS_in_ruleTemplateBindingCS10743 = new BitSet(new long[]{0x0010000000000002L});
        public static final BitSet FOLLOW_ruleTemplateParameterSubstitutionCS_in_entryRuleTemplateParameterSubstitutionCS10781 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTemplateParameterSubstitutionCS10791 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeRefCS_in_ruleTemplateParameterSubstitutionCS10836 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeParameterCS_in_entryRuleTypeParameterCS10873 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeParameterCS10883 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleTypeParameterCS10929 = new BitSet(new long[]{0x0000000000000002L,0x0000000000040000L});
        public static final BitSet FOLLOW_82_in_ruleTypeParameterCS10942 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleTypedRefCS_in_ruleTypeParameterCS10963 = new BitSet(new long[]{0x0000000000000002L,0x0000000000080000L});
        public static final BitSet FOLLOW_83_in_ruleTypeParameterCS10976 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleTypedRefCS_in_ruleTypeParameterCS10997 = new BitSet(new long[]{0x0000000000000002L,0x0000000000080000L});
        public static final BitSet FOLLOW_ruleTypeRefCS_in_entryRuleTypeRefCS11037 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeRefCS11047 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypedRefCS_in_ruleTypeRefCS11097 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWildcardTypeRefCS_in_ruleTypeRefCS11127 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypedRefCS_in_entryRuleTypedRefCS11162 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypedRefCS11172 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypedTypeRefCS_in_ruleTypedRefCS11221 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypedTypeRefCS_in_entryRuleTypedTypeRefCS11255 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypedTypeRefCS11265 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePathNameCS_in_ruleTypedTypeRefCS11311 = new BitSet(new long[]{0x0004000000000002L});
        public static final BitSet FOLLOW_50_in_ruleTypedTypeRefCS11324 = new BitSet(new long[]{0x0000000000000030L,0x0000000000010000L});
        public static final BitSet FOLLOW_ruleTemplateBindingCS_in_ruleTypedTypeRefCS11345 = new BitSet(new long[]{0x0008000000000000L});
        public static final BitSet FOLLOW_51_in_ruleTypedTypeRefCS11357 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWildcardTypeRefCS_in_entryRuleWildcardTypeRefCS11395 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleWildcardTypeRefCS11405 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_80_in_ruleWildcardTypeRefCS11454 = new BitSet(new long[]{0x0000000000000002L,0x0000000000040000L});
        public static final BitSet FOLLOW_82_in_ruleWildcardTypeRefCS11467 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleTypedRefCS_in_ruleWildcardTypeRefCS11488 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleID_in_entryRuleID11527 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleID11538 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_SIMPLE_ID_in_ruleID11578 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ESCAPED_ID_in_ruleID11604 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_entryRuleIdentifier11650 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIdentifier11661 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleID_in_ruleIdentifier11707 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLOWER_in_entryRuleLOWER11752 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLOWER11763 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleLOWER11802 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNUMBER_LITERAL_in_entryRuleNUMBER_LITERAL11847 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNUMBER_LITERAL11858 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleNUMBER_LITERAL11897 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral11942 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteral11953 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_SINGLE_QUOTED_STRING_in_ruleStringLiteral11992 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUPPER_in_entryRuleUPPER12037 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUPPER12048 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleUPPER12088 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleUPPER12112 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleURI_in_entryRuleURI12153 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleURI12164 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_SINGLE_QUOTED_STRING_in_ruleURI12203 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralCS_in_synpred70_InternalEssentialOCL6060 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrefixedPrimaryExpCS_in_synpred72_InternalEssentialOCL6186 = new BitSet(new long[]{0x00000007FFFD0002L});
        public static final BitSet FOLLOW_ruleBinaryOperatorName_in_synpred72_InternalEssentialOCL6219 = new BitSet(new long[]{0xF407FFF8000700F0L,0x0000000000003080L});
        public static final BitSet FOLLOW_ruleExpCS_in_synpred72_InternalEssentialOCL6240 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTupleLiteralExpCS_in_synpred79_InternalEssentialOCL6803 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMapLiteralExpCS_in_synpred80_InternalEssentialOCL6833 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionLiteralExpCS_in_synpred81_InternalEssentialOCL6863 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralExpCS_in_synpred83_InternalEssentialOCL6923 = new BitSet(new long[]{0x0000000000000002L});
    }


}