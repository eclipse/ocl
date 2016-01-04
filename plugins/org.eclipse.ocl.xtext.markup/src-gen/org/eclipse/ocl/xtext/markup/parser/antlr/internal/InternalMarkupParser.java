package org.eclipse.ocl.xtext.markup.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.ocl.xtext.markup.services.MarkupGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
/*******************************************************************************
 * Copyright (c) 2011, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
@SuppressWarnings("all")
public class InternalMarkupParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_ID", "RULE_STRING", "RULE_NL", "RULE_WORD", "RULE_WS", "RULE_NUMBER", "RULE_LETTER", "RULE_ESCAPED", "RULE_VERTICAL_WS", "RULE_HORIZONTAL_WS", "RULE_ANY_OTHER", "'b'", "'e'", "'bullet'", "'figure'", "'figureRef'", "'footnote'", "'heading'", "'oclCode'", "'oclEval'", "'oclText'", "':'", "'['", "']'", "'#'", "','"
    };
    public static final int RULE_ESCAPED=12;
    public static final int RULE_WORD=8;
    public static final int RULE_STRING=6;
    public static final int RULE_VERTICAL_WS=13;
    public static final int T__19=19;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int RULE_ID=5;
    public static final int RULE_WS=9;
    public static final int RULE_HORIZONTAL_WS=14;
    public static final int RULE_ANY_OTHER=15;
    public static final int RULE_NUMBER=10;
    public static final int RULE_LETTER=11;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=4;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int RULE_NL=7;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalMarkupParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalMarkupParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalMarkupParser.tokenNames; }
    public String getGrammarFileName() { return "../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */
     
     	private MarkupGrammarAccess grammarAccess;
     	
        public InternalMarkupParser(TokenStream input, MarkupGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Markup";	
       	}
       	
       	@Override
       	protected MarkupGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleMarkup"
    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:80:1: entryRuleMarkup returns [EObject current=null] : iv_ruleMarkup= ruleMarkup EOF ;
    public final EObject entryRuleMarkup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMarkup = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:81:2: (iv_ruleMarkup= ruleMarkup EOF )
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:82:2: iv_ruleMarkup= ruleMarkup EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMarkupRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMarkup_in_entryRuleMarkup81);
            iv_ruleMarkup=ruleMarkup();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMarkup; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMarkup91); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMarkup"


    // $ANTLR start "ruleMarkup"
    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:89:1: ruleMarkup returns [EObject current=null] : ( (lv_elements_0_0= ruleMarkupElement ) )* ;
    public final EObject ruleMarkup() throws RecognitionException {
        EObject current = null;

        EObject lv_elements_0_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:92:28: ( ( (lv_elements_0_0= ruleMarkupElement ) )* )
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:93:1: ( (lv_elements_0_0= ruleMarkupElement ) )*
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:93:1: ( (lv_elements_0_0= ruleMarkupElement ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=RULE_INT && LA1_0<=RULE_ID)||(LA1_0>=RULE_NL && LA1_0<=RULE_WS)||(LA1_0>=16 && LA1_0<=27)||(LA1_0>=29 && LA1_0<=30)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:94:1: (lv_elements_0_0= ruleMarkupElement )
            	    {
            	    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:94:1: (lv_elements_0_0= ruleMarkupElement )
            	    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:95:3: lv_elements_0_0= ruleMarkupElement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMarkupAccess().getElementsMarkupElementParserRuleCall_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleMarkupElement_in_ruleMarkup136);
            	    lv_elements_0_0=ruleMarkupElement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getMarkupRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"elements",
            	              		lv_elements_0_0, 
            	              		"MarkupElement");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
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
    // $ANTLR end "ruleMarkup"


    // $ANTLR start "entryRuleMarkupKeyword"
    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:119:1: entryRuleMarkupKeyword returns [String current=null] : iv_ruleMarkupKeyword= ruleMarkupKeyword EOF ;
    public final String entryRuleMarkupKeyword() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMarkupKeyword = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:120:2: (iv_ruleMarkupKeyword= ruleMarkupKeyword EOF )
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:121:2: iv_ruleMarkupKeyword= ruleMarkupKeyword EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMarkupKeywordRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMarkupKeyword_in_entryRuleMarkupKeyword173);
            iv_ruleMarkupKeyword=ruleMarkupKeyword();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMarkupKeyword.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMarkupKeyword184); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMarkupKeyword"


    // $ANTLR start "ruleMarkupKeyword"
    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:128:1: ruleMarkupKeyword returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'b' | kw= 'e' | kw= 'bullet' | kw= 'figure' | kw= 'figureRef' | kw= 'footnote' | kw= 'heading' | kw= 'oclCode' | kw= 'oclEval' | kw= 'oclText' ) ;
    public final AntlrDatatypeRuleToken ruleMarkupKeyword() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:131:28: ( (kw= 'b' | kw= 'e' | kw= 'bullet' | kw= 'figure' | kw= 'figureRef' | kw= 'footnote' | kw= 'heading' | kw= 'oclCode' | kw= 'oclEval' | kw= 'oclText' ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:132:1: (kw= 'b' | kw= 'e' | kw= 'bullet' | kw= 'figure' | kw= 'figureRef' | kw= 'footnote' | kw= 'heading' | kw= 'oclCode' | kw= 'oclEval' | kw= 'oclText' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:132:1: (kw= 'b' | kw= 'e' | kw= 'bullet' | kw= 'figure' | kw= 'figureRef' | kw= 'footnote' | kw= 'heading' | kw= 'oclCode' | kw= 'oclEval' | kw= 'oclText' )
            int alt2=10;
            switch ( input.LA(1) ) {
            case 16:
                {
                alt2=1;
                }
                break;
            case 17:
                {
                alt2=2;
                }
                break;
            case 18:
                {
                alt2=3;
                }
                break;
            case 19:
                {
                alt2=4;
                }
                break;
            case 20:
                {
                alt2=5;
                }
                break;
            case 21:
                {
                alt2=6;
                }
                break;
            case 22:
                {
                alt2=7;
                }
                break;
            case 23:
                {
                alt2=8;
                }
                break;
            case 24:
                {
                alt2=9;
                }
                break;
            case 25:
                {
                alt2=10;
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
                    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:133:2: kw= 'b'
                    {
                    kw=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleMarkupKeyword222); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getMarkupKeywordAccess().getBKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:140:2: kw= 'e'
                    {
                    kw=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleMarkupKeyword241); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getMarkupKeywordAccess().getEKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:147:2: kw= 'bullet'
                    {
                    kw=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleMarkupKeyword260); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getMarkupKeywordAccess().getBulletKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:154:2: kw= 'figure'
                    {
                    kw=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleMarkupKeyword279); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getMarkupKeywordAccess().getFigureKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:161:2: kw= 'figureRef'
                    {
                    kw=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleMarkupKeyword298); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getMarkupKeywordAccess().getFigureRefKeyword_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:168:2: kw= 'footnote'
                    {
                    kw=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleMarkupKeyword317); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getMarkupKeywordAccess().getFootnoteKeyword_5()); 
                          
                    }

                    }
                    break;
                case 7 :
                    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:175:2: kw= 'heading'
                    {
                    kw=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleMarkupKeyword336); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getMarkupKeywordAccess().getHeadingKeyword_6()); 
                          
                    }

                    }
                    break;
                case 8 :
                    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:182:2: kw= 'oclCode'
                    {
                    kw=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleMarkupKeyword355); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getMarkupKeywordAccess().getOclCodeKeyword_7()); 
                          
                    }

                    }
                    break;
                case 9 :
                    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:189:2: kw= 'oclEval'
                    {
                    kw=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleMarkupKeyword374); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getMarkupKeywordAccess().getOclEvalKeyword_8()); 
                          
                    }

                    }
                    break;
                case 10 :
                    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:196:2: kw= 'oclText'
                    {
                    kw=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleMarkupKeyword393); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getMarkupKeywordAccess().getOclTextKeyword_9()); 
                          
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
    // $ANTLR end "ruleMarkupKeyword"


    // $ANTLR start "entryRuleMarkupElement"
    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:209:1: entryRuleMarkupElement returns [EObject current=null] : iv_ruleMarkupElement= ruleMarkupElement EOF ;
    public final EObject entryRuleMarkupElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMarkupElement = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:210:2: (iv_ruleMarkupElement= ruleMarkupElement EOF )
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:211:2: iv_ruleMarkupElement= ruleMarkupElement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMarkupElementRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMarkupElement_in_entryRuleMarkupElement433);
            iv_ruleMarkupElement=ruleMarkupElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMarkupElement; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMarkupElement443); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMarkupElement"


    // $ANTLR start "ruleMarkupElement"
    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:218:1: ruleMarkupElement returns [EObject current=null] : (this_FontElement_0= ruleFontElement | this_NewLineElement_1= ruleNewLineElement | this_BulletElement_2= ruleBulletElement | this_FigureElement_3= ruleFigureElement | this_FigureRefElement_4= ruleFigureRefElement | this_FootnoteElement_5= ruleFootnoteElement | this_HeadingElement_6= ruleHeadingElement | this_NullElement_7= ruleNullElement | this_OCLCodeElement_8= ruleOCLCodeElement | this_OCLEvalElement_9= ruleOCLEvalElement | this_OCLTextElement_10= ruleOCLTextElement | this_TextElement_11= ruleTextElement ) ;
    public final EObject ruleMarkupElement() throws RecognitionException {
        EObject current = null;

        EObject this_FontElement_0 = null;

        EObject this_NewLineElement_1 = null;

        EObject this_BulletElement_2 = null;

        EObject this_FigureElement_3 = null;

        EObject this_FigureRefElement_4 = null;

        EObject this_FootnoteElement_5 = null;

        EObject this_HeadingElement_6 = null;

        EObject this_NullElement_7 = null;

        EObject this_OCLCodeElement_8 = null;

        EObject this_OCLEvalElement_9 = null;

        EObject this_OCLTextElement_10 = null;

        EObject this_TextElement_11 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:221:28: ( (this_FontElement_0= ruleFontElement | this_NewLineElement_1= ruleNewLineElement | this_BulletElement_2= ruleBulletElement | this_FigureElement_3= ruleFigureElement | this_FigureRefElement_4= ruleFigureRefElement | this_FootnoteElement_5= ruleFootnoteElement | this_HeadingElement_6= ruleHeadingElement | this_NullElement_7= ruleNullElement | this_OCLCodeElement_8= ruleOCLCodeElement | this_OCLEvalElement_9= ruleOCLEvalElement | this_OCLTextElement_10= ruleOCLTextElement | this_TextElement_11= ruleTextElement ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:222:1: (this_FontElement_0= ruleFontElement | this_NewLineElement_1= ruleNewLineElement | this_BulletElement_2= ruleBulletElement | this_FigureElement_3= ruleFigureElement | this_FigureRefElement_4= ruleFigureRefElement | this_FootnoteElement_5= ruleFootnoteElement | this_HeadingElement_6= ruleHeadingElement | this_NullElement_7= ruleNullElement | this_OCLCodeElement_8= ruleOCLCodeElement | this_OCLEvalElement_9= ruleOCLEvalElement | this_OCLTextElement_10= ruleOCLTextElement | this_TextElement_11= ruleTextElement )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:222:1: (this_FontElement_0= ruleFontElement | this_NewLineElement_1= ruleNewLineElement | this_BulletElement_2= ruleBulletElement | this_FigureElement_3= ruleFigureElement | this_FigureRefElement_4= ruleFigureRefElement | this_FootnoteElement_5= ruleFootnoteElement | this_HeadingElement_6= ruleHeadingElement | this_NullElement_7= ruleNullElement | this_OCLCodeElement_8= ruleOCLCodeElement | this_OCLEvalElement_9= ruleOCLEvalElement | this_OCLTextElement_10= ruleOCLTextElement | this_TextElement_11= ruleTextElement )
            int alt3=12;
            alt3 = dfa3.predict(input);
            switch (alt3) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:223:2: this_FontElement_0= ruleFontElement
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getMarkupElementAccess().getFontElementParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleFontElement_in_ruleMarkupElement493);
                    this_FontElement_0=ruleFontElement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_FontElement_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:236:2: this_NewLineElement_1= ruleNewLineElement
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getMarkupElementAccess().getNewLineElementParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNewLineElement_in_ruleMarkupElement523);
                    this_NewLineElement_1=ruleNewLineElement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_NewLineElement_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:249:2: this_BulletElement_2= ruleBulletElement
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getMarkupElementAccess().getBulletElementParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleBulletElement_in_ruleMarkupElement553);
                    this_BulletElement_2=ruleBulletElement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_BulletElement_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:262:2: this_FigureElement_3= ruleFigureElement
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getMarkupElementAccess().getFigureElementParserRuleCall_3()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleFigureElement_in_ruleMarkupElement583);
                    this_FigureElement_3=ruleFigureElement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_FigureElement_3; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 5 :
                    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:275:2: this_FigureRefElement_4= ruleFigureRefElement
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getMarkupElementAccess().getFigureRefElementParserRuleCall_4()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleFigureRefElement_in_ruleMarkupElement613);
                    this_FigureRefElement_4=ruleFigureRefElement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_FigureRefElement_4; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 6 :
                    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:288:2: this_FootnoteElement_5= ruleFootnoteElement
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getMarkupElementAccess().getFootnoteElementParserRuleCall_5()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleFootnoteElement_in_ruleMarkupElement643);
                    this_FootnoteElement_5=ruleFootnoteElement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_FootnoteElement_5; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 7 :
                    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:301:2: this_HeadingElement_6= ruleHeadingElement
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getMarkupElementAccess().getHeadingElementParserRuleCall_6()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleHeadingElement_in_ruleMarkupElement673);
                    this_HeadingElement_6=ruleHeadingElement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_HeadingElement_6; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 8 :
                    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:314:2: this_NullElement_7= ruleNullElement
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getMarkupElementAccess().getNullElementParserRuleCall_7()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNullElement_in_ruleMarkupElement703);
                    this_NullElement_7=ruleNullElement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_NullElement_7; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 9 :
                    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:327:2: this_OCLCodeElement_8= ruleOCLCodeElement
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getMarkupElementAccess().getOCLCodeElementParserRuleCall_8()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleOCLCodeElement_in_ruleMarkupElement733);
                    this_OCLCodeElement_8=ruleOCLCodeElement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_OCLCodeElement_8; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 10 :
                    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:340:2: this_OCLEvalElement_9= ruleOCLEvalElement
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getMarkupElementAccess().getOCLEvalElementParserRuleCall_9()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleOCLEvalElement_in_ruleMarkupElement763);
                    this_OCLEvalElement_9=ruleOCLEvalElement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_OCLEvalElement_9; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 11 :
                    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:353:2: this_OCLTextElement_10= ruleOCLTextElement
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getMarkupElementAccess().getOCLTextElementParserRuleCall_10()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleOCLTextElement_in_ruleMarkupElement793);
                    this_OCLTextElement_10=ruleOCLTextElement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_OCLTextElement_10; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 12 :
                    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:366:2: this_TextElement_11= ruleTextElement
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getMarkupElementAccess().getTextElementParserRuleCall_11()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTextElement_in_ruleMarkupElement823);
                    this_TextElement_11=ruleTextElement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_TextElement_11; 
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
    // $ANTLR end "ruleMarkupElement"


    // $ANTLR start "entryRuleBulletElement"
    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:385:1: entryRuleBulletElement returns [EObject current=null] : iv_ruleBulletElement= ruleBulletElement EOF ;
    public final EObject entryRuleBulletElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBulletElement = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:386:2: (iv_ruleBulletElement= ruleBulletElement EOF )
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:387:2: iv_ruleBulletElement= ruleBulletElement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBulletElementRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleBulletElement_in_entryRuleBulletElement858);
            iv_ruleBulletElement=ruleBulletElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBulletElement; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBulletElement868); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBulletElement"


    // $ANTLR start "ruleBulletElement"
    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:394:1: ruleBulletElement returns [EObject current=null] : ( () otherlv_1= 'bullet' (otherlv_2= ':' ( (lv_level_3_0= RULE_INT ) ) )? otherlv_4= '[' ( (lv_elements_5_0= ruleMarkupElement ) )* otherlv_6= ']' ) ;
    public final EObject ruleBulletElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_level_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_elements_5_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:397:28: ( ( () otherlv_1= 'bullet' (otherlv_2= ':' ( (lv_level_3_0= RULE_INT ) ) )? otherlv_4= '[' ( (lv_elements_5_0= ruleMarkupElement ) )* otherlv_6= ']' ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:398:1: ( () otherlv_1= 'bullet' (otherlv_2= ':' ( (lv_level_3_0= RULE_INT ) ) )? otherlv_4= '[' ( (lv_elements_5_0= ruleMarkupElement ) )* otherlv_6= ']' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:398:1: ( () otherlv_1= 'bullet' (otherlv_2= ':' ( (lv_level_3_0= RULE_INT ) ) )? otherlv_4= '[' ( (lv_elements_5_0= ruleMarkupElement ) )* otherlv_6= ']' )
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:398:2: () otherlv_1= 'bullet' (otherlv_2= ':' ( (lv_level_3_0= RULE_INT ) ) )? otherlv_4= '[' ( (lv_elements_5_0= ruleMarkupElement ) )* otherlv_6= ']'
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:398:2: ()
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:399:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getBulletElementAccess().getBulletElementAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleBulletElement917); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getBulletElementAccess().getBulletKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:411:1: (otherlv_2= ':' ( (lv_level_3_0= RULE_INT ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==26) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:411:3: otherlv_2= ':' ( (lv_level_3_0= RULE_INT ) )
                    {
                    otherlv_2=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleBulletElement930); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getBulletElementAccess().getColonKeyword_2_0());
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:415:1: ( (lv_level_3_0= RULE_INT ) )
                    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:416:1: (lv_level_3_0= RULE_INT )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:416:1: (lv_level_3_0= RULE_INT )
                    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:417:3: lv_level_3_0= RULE_INT
                    {
                    lv_level_3_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleBulletElement947); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_level_3_0, grammarAccess.getBulletElementAccess().getLevelINTTerminalRuleCall_2_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBulletElementRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"level",
                              		lv_level_3_0, 
                              		"INT");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleBulletElement966); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getBulletElementAccess().getLeftSquareBracketKeyword_3());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:437:1: ( (lv_elements_5_0= ruleMarkupElement ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>=RULE_INT && LA5_0<=RULE_ID)||(LA5_0>=RULE_NL && LA5_0<=RULE_WS)||(LA5_0>=16 && LA5_0<=27)||(LA5_0>=29 && LA5_0<=30)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:438:1: (lv_elements_5_0= ruleMarkupElement )
            	    {
            	    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:438:1: (lv_elements_5_0= ruleMarkupElement )
            	    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:439:3: lv_elements_5_0= ruleMarkupElement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getBulletElementAccess().getElementsMarkupElementParserRuleCall_4_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleMarkupElement_in_ruleBulletElement987);
            	    lv_elements_5_0=ruleMarkupElement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getBulletElementRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"elements",
            	              		lv_elements_5_0, 
            	              		"MarkupElement");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            otherlv_6=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleBulletElement1000); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getBulletElementAccess().getRightSquareBracketKeyword_5());
                  
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
    // $ANTLR end "ruleBulletElement"


    // $ANTLR start "entryRuleFontElement"
    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:467:1: entryRuleFontElement returns [EObject current=null] : iv_ruleFontElement= ruleFontElement EOF ;
    public final EObject entryRuleFontElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFontElement = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:468:2: (iv_ruleFontElement= ruleFontElement EOF )
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:469:2: iv_ruleFontElement= ruleFontElement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFontElementRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleFontElement_in_entryRuleFontElement1036);
            iv_ruleFontElement=ruleFontElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFontElement; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFontElement1046); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFontElement"


    // $ANTLR start "ruleFontElement"
    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:476:1: ruleFontElement returns [EObject current=null] : ( ( ( (lv_font_0_1= 'b' | lv_font_0_2= 'e' ) ) ) otherlv_1= '[' ( (lv_elements_2_0= ruleMarkupElement ) )* otherlv_3= ']' ) ;
    public final EObject ruleFontElement() throws RecognitionException {
        EObject current = null;

        Token lv_font_0_1=null;
        Token lv_font_0_2=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_elements_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:479:28: ( ( ( ( (lv_font_0_1= 'b' | lv_font_0_2= 'e' ) ) ) otherlv_1= '[' ( (lv_elements_2_0= ruleMarkupElement ) )* otherlv_3= ']' ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:480:1: ( ( ( (lv_font_0_1= 'b' | lv_font_0_2= 'e' ) ) ) otherlv_1= '[' ( (lv_elements_2_0= ruleMarkupElement ) )* otherlv_3= ']' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:480:1: ( ( ( (lv_font_0_1= 'b' | lv_font_0_2= 'e' ) ) ) otherlv_1= '[' ( (lv_elements_2_0= ruleMarkupElement ) )* otherlv_3= ']' )
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:480:2: ( ( (lv_font_0_1= 'b' | lv_font_0_2= 'e' ) ) ) otherlv_1= '[' ( (lv_elements_2_0= ruleMarkupElement ) )* otherlv_3= ']'
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:480:2: ( ( (lv_font_0_1= 'b' | lv_font_0_2= 'e' ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:481:1: ( (lv_font_0_1= 'b' | lv_font_0_2= 'e' ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:481:1: ( (lv_font_0_1= 'b' | lv_font_0_2= 'e' ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:482:1: (lv_font_0_1= 'b' | lv_font_0_2= 'e' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:482:1: (lv_font_0_1= 'b' | lv_font_0_2= 'e' )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==16) ) {
                alt6=1;
            }
            else if ( (LA6_0==17) ) {
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
                    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:483:3: lv_font_0_1= 'b'
                    {
                    lv_font_0_1=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleFontElement1091); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_font_0_1, grammarAccess.getFontElementAccess().getFontBKeyword_0_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getFontElementRule());
                      	        }
                             		setWithLastConsumed(current, "font", lv_font_0_1, null);
                      	    
                    }

                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:495:8: lv_font_0_2= 'e'
                    {
                    lv_font_0_2=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleFontElement1120); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_font_0_2, grammarAccess.getFontElementAccess().getFontEKeyword_0_0_1());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getFontElementRule());
                      	        }
                             		setWithLastConsumed(current, "font", lv_font_0_2, null);
                      	    
                    }

                    }
                    break;

            }


            }


            }

            otherlv_1=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleFontElement1148); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getFontElementAccess().getLeftSquareBracketKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:514:1: ( (lv_elements_2_0= ruleMarkupElement ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>=RULE_INT && LA7_0<=RULE_ID)||(LA7_0>=RULE_NL && LA7_0<=RULE_WS)||(LA7_0>=16 && LA7_0<=27)||(LA7_0>=29 && LA7_0<=30)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:515:1: (lv_elements_2_0= ruleMarkupElement )
            	    {
            	    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:515:1: (lv_elements_2_0= ruleMarkupElement )
            	    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:516:3: lv_elements_2_0= ruleMarkupElement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getFontElementAccess().getElementsMarkupElementParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleMarkupElement_in_ruleFontElement1169);
            	    lv_elements_2_0=ruleMarkupElement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getFontElementRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"elements",
            	              		lv_elements_2_0, 
            	              		"MarkupElement");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            otherlv_3=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleFontElement1182); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getFontElementAccess().getRightSquareBracketKeyword_3());
                  
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
    // $ANTLR end "ruleFontElement"


    // $ANTLR start "entryRuleFigureElement"
    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:544:1: entryRuleFigureElement returns [EObject current=null] : iv_ruleFigureElement= ruleFigureElement EOF ;
    public final EObject entryRuleFigureElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFigureElement = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:545:2: (iv_ruleFigureElement= ruleFigureElement EOF )
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:546:2: iv_ruleFigureElement= ruleFigureElement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFigureElementRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleFigureElement_in_entryRuleFigureElement1218);
            iv_ruleFigureElement=ruleFigureElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFigureElement; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFigureElement1228); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFigureElement"


    // $ANTLR start "ruleFigureElement"
    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:553:1: ruleFigureElement returns [EObject current=null] : (otherlv_0= 'figure' (otherlv_1= '#' ( (lv_def_2_0= RULE_ID ) ) )? otherlv_3= '[' ( (lv_src_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_alt_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_requiredWidth_8_0= RULE_INT ) ) (otherlv_9= ',' ( (lv_requiredHeight_10_0= RULE_INT ) ) )? )? )? otherlv_11= ']' ) ;
    public final EObject ruleFigureElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_def_2_0=null;
        Token otherlv_3=null;
        Token lv_src_4_0=null;
        Token otherlv_5=null;
        Token lv_alt_6_0=null;
        Token otherlv_7=null;
        Token lv_requiredWidth_8_0=null;
        Token otherlv_9=null;
        Token lv_requiredHeight_10_0=null;
        Token otherlv_11=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:556:28: ( (otherlv_0= 'figure' (otherlv_1= '#' ( (lv_def_2_0= RULE_ID ) ) )? otherlv_3= '[' ( (lv_src_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_alt_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_requiredWidth_8_0= RULE_INT ) ) (otherlv_9= ',' ( (lv_requiredHeight_10_0= RULE_INT ) ) )? )? )? otherlv_11= ']' ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:557:1: (otherlv_0= 'figure' (otherlv_1= '#' ( (lv_def_2_0= RULE_ID ) ) )? otherlv_3= '[' ( (lv_src_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_alt_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_requiredWidth_8_0= RULE_INT ) ) (otherlv_9= ',' ( (lv_requiredHeight_10_0= RULE_INT ) ) )? )? )? otherlv_11= ']' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:557:1: (otherlv_0= 'figure' (otherlv_1= '#' ( (lv_def_2_0= RULE_ID ) ) )? otherlv_3= '[' ( (lv_src_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_alt_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_requiredWidth_8_0= RULE_INT ) ) (otherlv_9= ',' ( (lv_requiredHeight_10_0= RULE_INT ) ) )? )? )? otherlv_11= ']' )
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:557:3: otherlv_0= 'figure' (otherlv_1= '#' ( (lv_def_2_0= RULE_ID ) ) )? otherlv_3= '[' ( (lv_src_4_0= RULE_STRING ) ) (otherlv_5= ',' ( (lv_alt_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_requiredWidth_8_0= RULE_INT ) ) (otherlv_9= ',' ( (lv_requiredHeight_10_0= RULE_INT ) ) )? )? )? otherlv_11= ']'
            {
            otherlv_0=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleFigureElement1265); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getFigureElementAccess().getFigureKeyword_0());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:561:1: (otherlv_1= '#' ( (lv_def_2_0= RULE_ID ) ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==29) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:561:3: otherlv_1= '#' ( (lv_def_2_0= RULE_ID ) )
                    {
                    otherlv_1=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleFigureElement1278); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getFigureElementAccess().getNumberSignKeyword_1_0());
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:565:1: ( (lv_def_2_0= RULE_ID ) )
                    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:566:1: (lv_def_2_0= RULE_ID )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:566:1: (lv_def_2_0= RULE_ID )
                    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:567:3: lv_def_2_0= RULE_ID
                    {
                    lv_def_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFigureElement1295); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_def_2_0, grammarAccess.getFigureElementAccess().getDefIDTerminalRuleCall_1_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getFigureElementRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"def",
                              		lv_def_2_0, 
                              		"ID");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleFigureElement1314); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getFigureElementAccess().getLeftSquareBracketKeyword_2());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:587:1: ( (lv_src_4_0= RULE_STRING ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:588:1: (lv_src_4_0= RULE_STRING )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:588:1: (lv_src_4_0= RULE_STRING )
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:589:3: lv_src_4_0= RULE_STRING
            {
            lv_src_4_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleFigureElement1331); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_src_4_0, grammarAccess.getFigureElementAccess().getSrcSTRINGTerminalRuleCall_3_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getFigureElementRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"src",
                      		lv_src_4_0, 
                      		"STRING");
              	    
            }

            }


            }

            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:605:2: (otherlv_5= ',' ( (lv_alt_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_requiredWidth_8_0= RULE_INT ) ) (otherlv_9= ',' ( (lv_requiredHeight_10_0= RULE_INT ) ) )? )? )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==30) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:605:4: otherlv_5= ',' ( (lv_alt_6_0= RULE_STRING ) ) (otherlv_7= ',' ( (lv_requiredWidth_8_0= RULE_INT ) ) (otherlv_9= ',' ( (lv_requiredHeight_10_0= RULE_INT ) ) )? )?
                    {
                    otherlv_5=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleFigureElement1349); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getFigureElementAccess().getCommaKeyword_4_0());
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:609:1: ( (lv_alt_6_0= RULE_STRING ) )
                    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:610:1: (lv_alt_6_0= RULE_STRING )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:610:1: (lv_alt_6_0= RULE_STRING )
                    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:611:3: lv_alt_6_0= RULE_STRING
                    {
                    lv_alt_6_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleFigureElement1366); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_alt_6_0, grammarAccess.getFigureElementAccess().getAltSTRINGTerminalRuleCall_4_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getFigureElementRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"alt",
                              		lv_alt_6_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }

                    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:627:2: (otherlv_7= ',' ( (lv_requiredWidth_8_0= RULE_INT ) ) (otherlv_9= ',' ( (lv_requiredHeight_10_0= RULE_INT ) ) )? )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==30) ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:627:4: otherlv_7= ',' ( (lv_requiredWidth_8_0= RULE_INT ) ) (otherlv_9= ',' ( (lv_requiredHeight_10_0= RULE_INT ) ) )?
                            {
                            otherlv_7=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleFigureElement1384); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_7, grammarAccess.getFigureElementAccess().getCommaKeyword_4_2_0());
                                  
                            }
                            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:631:1: ( (lv_requiredWidth_8_0= RULE_INT ) )
                            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:632:1: (lv_requiredWidth_8_0= RULE_INT )
                            {
                            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:632:1: (lv_requiredWidth_8_0= RULE_INT )
                            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:633:3: lv_requiredWidth_8_0= RULE_INT
                            {
                            lv_requiredWidth_8_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleFigureElement1401); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_requiredWidth_8_0, grammarAccess.getFigureElementAccess().getRequiredWidthINTTerminalRuleCall_4_2_1_0()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getFigureElementRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"requiredWidth",
                                      		lv_requiredWidth_8_0, 
                                      		"INT");
                              	    
                            }

                            }


                            }

                            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:649:2: (otherlv_9= ',' ( (lv_requiredHeight_10_0= RULE_INT ) ) )?
                            int alt9=2;
                            int LA9_0 = input.LA(1);

                            if ( (LA9_0==30) ) {
                                alt9=1;
                            }
                            switch (alt9) {
                                case 1 :
                                    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:649:4: otherlv_9= ',' ( (lv_requiredHeight_10_0= RULE_INT ) )
                                    {
                                    otherlv_9=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleFigureElement1419); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                          	newLeafNode(otherlv_9, grammarAccess.getFigureElementAccess().getCommaKeyword_4_2_2_0());
                                          
                                    }
                                    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:653:1: ( (lv_requiredHeight_10_0= RULE_INT ) )
                                    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:654:1: (lv_requiredHeight_10_0= RULE_INT )
                                    {
                                    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:654:1: (lv_requiredHeight_10_0= RULE_INT )
                                    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:655:3: lv_requiredHeight_10_0= RULE_INT
                                    {
                                    lv_requiredHeight_10_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleFigureElement1436); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      			newLeafNode(lv_requiredHeight_10_0, grammarAccess.getFigureElementAccess().getRequiredHeightINTTerminalRuleCall_4_2_2_1_0()); 
                                      		
                                    }
                                    if ( state.backtracking==0 ) {

                                      	        if (current==null) {
                                      	            current = createModelElement(grammarAccess.getFigureElementRule());
                                      	        }
                                             		setWithLastConsumed(
                                             			current, 
                                             			"requiredHeight",
                                              		lv_requiredHeight_10_0, 
                                              		"INT");
                                      	    
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
                    break;

            }

            otherlv_11=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleFigureElement1459); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_11, grammarAccess.getFigureElementAccess().getRightSquareBracketKeyword_5());
                  
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
    // $ANTLR end "ruleFigureElement"


    // $ANTLR start "entryRuleFigureRefElement"
    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:683:1: entryRuleFigureRefElement returns [EObject current=null] : iv_ruleFigureRefElement= ruleFigureRefElement EOF ;
    public final EObject entryRuleFigureRefElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFigureRefElement = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:684:2: (iv_ruleFigureRefElement= ruleFigureRefElement EOF )
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:685:2: iv_ruleFigureRefElement= ruleFigureRefElement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFigureRefElementRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleFigureRefElement_in_entryRuleFigureRefElement1495);
            iv_ruleFigureRefElement=ruleFigureRefElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFigureRefElement; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFigureRefElement1505); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFigureRefElement"


    // $ANTLR start "ruleFigureRefElement"
    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:692:1: ruleFigureRefElement returns [EObject current=null] : (otherlv_0= 'figureRef' otherlv_1= '[' ( (otherlv_2= RULE_ID ) ) otherlv_3= ']' ) ;
    public final EObject ruleFigureRefElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:695:28: ( (otherlv_0= 'figureRef' otherlv_1= '[' ( (otherlv_2= RULE_ID ) ) otherlv_3= ']' ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:696:1: (otherlv_0= 'figureRef' otherlv_1= '[' ( (otherlv_2= RULE_ID ) ) otherlv_3= ']' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:696:1: (otherlv_0= 'figureRef' otherlv_1= '[' ( (otherlv_2= RULE_ID ) ) otherlv_3= ']' )
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:696:3: otherlv_0= 'figureRef' otherlv_1= '[' ( (otherlv_2= RULE_ID ) ) otherlv_3= ']'
            {
            otherlv_0=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleFigureRefElement1542); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getFigureRefElementAccess().getFigureRefKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleFigureRefElement1554); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getFigureRefElementAccess().getLeftSquareBracketKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:704:1: ( (otherlv_2= RULE_ID ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:705:1: (otherlv_2= RULE_ID )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:705:1: (otherlv_2= RULE_ID )
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:706:3: otherlv_2= RULE_ID
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getFigureRefElementRule());
              	        }
                      
            }
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFigureRefElement1578); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_2, grammarAccess.getFigureRefElementAccess().getRefFigureElementCrossReference_2_0()); 
              	
            }

            }


            }

            otherlv_3=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleFigureRefElement1590); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getFigureRefElementAccess().getRightSquareBracketKeyword_3());
                  
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
    // $ANTLR end "ruleFigureRefElement"


    // $ANTLR start "entryRuleFootnoteElement"
    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:732:1: entryRuleFootnoteElement returns [EObject current=null] : iv_ruleFootnoteElement= ruleFootnoteElement EOF ;
    public final EObject entryRuleFootnoteElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFootnoteElement = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:733:2: (iv_ruleFootnoteElement= ruleFootnoteElement EOF )
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:734:2: iv_ruleFootnoteElement= ruleFootnoteElement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFootnoteElementRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleFootnoteElement_in_entryRuleFootnoteElement1626);
            iv_ruleFootnoteElement=ruleFootnoteElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFootnoteElement; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFootnoteElement1636); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFootnoteElement"


    // $ANTLR start "ruleFootnoteElement"
    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:741:1: ruleFootnoteElement returns [EObject current=null] : ( () otherlv_1= 'footnote' otherlv_2= '[' ( (lv_elements_3_0= ruleMarkupElement ) )* otherlv_4= ']' ) ;
    public final EObject ruleFootnoteElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_elements_3_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:744:28: ( ( () otherlv_1= 'footnote' otherlv_2= '[' ( (lv_elements_3_0= ruleMarkupElement ) )* otherlv_4= ']' ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:745:1: ( () otherlv_1= 'footnote' otherlv_2= '[' ( (lv_elements_3_0= ruleMarkupElement ) )* otherlv_4= ']' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:745:1: ( () otherlv_1= 'footnote' otherlv_2= '[' ( (lv_elements_3_0= ruleMarkupElement ) )* otherlv_4= ']' )
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:745:2: () otherlv_1= 'footnote' otherlv_2= '[' ( (lv_elements_3_0= ruleMarkupElement ) )* otherlv_4= ']'
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:745:2: ()
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:746:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getFootnoteElementAccess().getFootnoteElementAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleFootnoteElement1685); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getFootnoteElementAccess().getFootnoteKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleFootnoteElement1697); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getFootnoteElementAccess().getLeftSquareBracketKeyword_2());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:762:1: ( (lv_elements_3_0= ruleMarkupElement ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>=RULE_INT && LA12_0<=RULE_ID)||(LA12_0>=RULE_NL && LA12_0<=RULE_WS)||(LA12_0>=16 && LA12_0<=27)||(LA12_0>=29 && LA12_0<=30)) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:763:1: (lv_elements_3_0= ruleMarkupElement )
            	    {
            	    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:763:1: (lv_elements_3_0= ruleMarkupElement )
            	    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:764:3: lv_elements_3_0= ruleMarkupElement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getFootnoteElementAccess().getElementsMarkupElementParserRuleCall_3_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleMarkupElement_in_ruleFootnoteElement1718);
            	    lv_elements_3_0=ruleMarkupElement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getFootnoteElementRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"elements",
            	              		lv_elements_3_0, 
            	              		"MarkupElement");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            otherlv_4=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleFootnoteElement1731); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getFootnoteElementAccess().getRightSquareBracketKeyword_4());
                  
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
    // $ANTLR end "ruleFootnoteElement"


    // $ANTLR start "entryRuleHeadingElement"
    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:792:1: entryRuleHeadingElement returns [EObject current=null] : iv_ruleHeadingElement= ruleHeadingElement EOF ;
    public final EObject entryRuleHeadingElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHeadingElement = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:793:2: (iv_ruleHeadingElement= ruleHeadingElement EOF )
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:794:2: iv_ruleHeadingElement= ruleHeadingElement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getHeadingElementRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleHeadingElement_in_entryRuleHeadingElement1767);
            iv_ruleHeadingElement=ruleHeadingElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleHeadingElement; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleHeadingElement1777); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHeadingElement"


    // $ANTLR start "ruleHeadingElement"
    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:801:1: ruleHeadingElement returns [EObject current=null] : ( () otherlv_1= 'heading' (otherlv_2= ':' ( (lv_level_3_0= RULE_INT ) ) )? otherlv_4= '[' ( (lv_elements_5_0= ruleMarkupElement ) )* otherlv_6= ']' ) ;
    public final EObject ruleHeadingElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_level_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_elements_5_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:804:28: ( ( () otherlv_1= 'heading' (otherlv_2= ':' ( (lv_level_3_0= RULE_INT ) ) )? otherlv_4= '[' ( (lv_elements_5_0= ruleMarkupElement ) )* otherlv_6= ']' ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:805:1: ( () otherlv_1= 'heading' (otherlv_2= ':' ( (lv_level_3_0= RULE_INT ) ) )? otherlv_4= '[' ( (lv_elements_5_0= ruleMarkupElement ) )* otherlv_6= ']' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:805:1: ( () otherlv_1= 'heading' (otherlv_2= ':' ( (lv_level_3_0= RULE_INT ) ) )? otherlv_4= '[' ( (lv_elements_5_0= ruleMarkupElement ) )* otherlv_6= ']' )
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:805:2: () otherlv_1= 'heading' (otherlv_2= ':' ( (lv_level_3_0= RULE_INT ) ) )? otherlv_4= '[' ( (lv_elements_5_0= ruleMarkupElement ) )* otherlv_6= ']'
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:805:2: ()
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:806:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getHeadingElementAccess().getHeadingElementAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleHeadingElement1826); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getHeadingElementAccess().getHeadingKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:818:1: (otherlv_2= ':' ( (lv_level_3_0= RULE_INT ) ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==26) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:818:3: otherlv_2= ':' ( (lv_level_3_0= RULE_INT ) )
                    {
                    otherlv_2=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleHeadingElement1839); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getHeadingElementAccess().getColonKeyword_2_0());
                          
                    }
                    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:822:1: ( (lv_level_3_0= RULE_INT ) )
                    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:823:1: (lv_level_3_0= RULE_INT )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:823:1: (lv_level_3_0= RULE_INT )
                    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:824:3: lv_level_3_0= RULE_INT
                    {
                    lv_level_3_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleHeadingElement1856); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_level_3_0, grammarAccess.getHeadingElementAccess().getLevelINTTerminalRuleCall_2_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getHeadingElementRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"level",
                              		lv_level_3_0, 
                              		"INT");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleHeadingElement1875); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getHeadingElementAccess().getLeftSquareBracketKeyword_3());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:844:1: ( (lv_elements_5_0= ruleMarkupElement ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0>=RULE_INT && LA14_0<=RULE_ID)||(LA14_0>=RULE_NL && LA14_0<=RULE_WS)||(LA14_0>=16 && LA14_0<=27)||(LA14_0>=29 && LA14_0<=30)) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:845:1: (lv_elements_5_0= ruleMarkupElement )
            	    {
            	    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:845:1: (lv_elements_5_0= ruleMarkupElement )
            	    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:846:3: lv_elements_5_0= ruleMarkupElement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getHeadingElementAccess().getElementsMarkupElementParserRuleCall_4_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleMarkupElement_in_ruleHeadingElement1896);
            	    lv_elements_5_0=ruleMarkupElement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getHeadingElementRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"elements",
            	              		lv_elements_5_0, 
            	              		"MarkupElement");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            otherlv_6=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleHeadingElement1909); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getHeadingElementAccess().getRightSquareBracketKeyword_5());
                  
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
    // $ANTLR end "ruleHeadingElement"


    // $ANTLR start "entryRuleNewLineElement"
    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:874:1: entryRuleNewLineElement returns [EObject current=null] : iv_ruleNewLineElement= ruleNewLineElement EOF ;
    public final EObject entryRuleNewLineElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNewLineElement = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:875:2: (iv_ruleNewLineElement= ruleNewLineElement EOF )
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:876:2: iv_ruleNewLineElement= ruleNewLineElement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNewLineElementRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNewLineElement_in_entryRuleNewLineElement1945);
            iv_ruleNewLineElement=ruleNewLineElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNewLineElement; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNewLineElement1955); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNewLineElement"


    // $ANTLR start "ruleNewLineElement"
    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:883:1: ruleNewLineElement returns [EObject current=null] : ( (lv_text_0_0= RULE_NL ) ) ;
    public final EObject ruleNewLineElement() throws RecognitionException {
        EObject current = null;

        Token lv_text_0_0=null;

         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:886:28: ( ( (lv_text_0_0= RULE_NL ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:887:1: ( (lv_text_0_0= RULE_NL ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:887:1: ( (lv_text_0_0= RULE_NL ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:888:1: (lv_text_0_0= RULE_NL )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:888:1: (lv_text_0_0= RULE_NL )
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:889:3: lv_text_0_0= RULE_NL
            {
            lv_text_0_0=(Token)match(input,RULE_NL,FollowSets000.FOLLOW_RULE_NL_in_ruleNewLineElement1996); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_text_0_0, grammarAccess.getNewLineElementAccess().getTextNLTerminalRuleCall_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getNewLineElementRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"text",
                      		lv_text_0_0, 
                      		"NL");
              	    
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
    // $ANTLR end "ruleNewLineElement"


    // $ANTLR start "entryRuleNullElement"
    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:913:1: entryRuleNullElement returns [EObject current=null] : iv_ruleNullElement= ruleNullElement EOF ;
    public final EObject entryRuleNullElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullElement = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:914:2: (iv_ruleNullElement= ruleNullElement EOF )
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:915:2: iv_ruleNullElement= ruleNullElement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNullElementRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNullElement_in_entryRuleNullElement2036);
            iv_ruleNullElement=ruleNullElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNullElement; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNullElement2046); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNullElement"


    // $ANTLR start "ruleNullElement"
    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:922:1: ruleNullElement returns [EObject current=null] : ( () otherlv_1= '[' ( (lv_elements_2_0= ruleMarkupElement ) )* otherlv_3= ']' ) ;
    public final EObject ruleNullElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_elements_2_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:925:28: ( ( () otherlv_1= '[' ( (lv_elements_2_0= ruleMarkupElement ) )* otherlv_3= ']' ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:926:1: ( () otherlv_1= '[' ( (lv_elements_2_0= ruleMarkupElement ) )* otherlv_3= ']' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:926:1: ( () otherlv_1= '[' ( (lv_elements_2_0= ruleMarkupElement ) )* otherlv_3= ']' )
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:926:2: () otherlv_1= '[' ( (lv_elements_2_0= ruleMarkupElement ) )* otherlv_3= ']'
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:926:2: ()
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:927:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getNullElementAccess().getNullElementAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleNullElement2095); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getNullElementAccess().getLeftSquareBracketKeyword_1());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:939:1: ( (lv_elements_2_0= ruleMarkupElement ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>=RULE_INT && LA15_0<=RULE_ID)||(LA15_0>=RULE_NL && LA15_0<=RULE_WS)||(LA15_0>=16 && LA15_0<=27)||(LA15_0>=29 && LA15_0<=30)) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:940:1: (lv_elements_2_0= ruleMarkupElement )
            	    {
            	    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:940:1: (lv_elements_2_0= ruleMarkupElement )
            	    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:941:3: lv_elements_2_0= ruleMarkupElement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getNullElementAccess().getElementsMarkupElementParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleMarkupElement_in_ruleNullElement2116);
            	    lv_elements_2_0=ruleMarkupElement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getNullElementRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"elements",
            	              		lv_elements_2_0, 
            	              		"MarkupElement");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            otherlv_3=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleNullElement2129); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getNullElementAccess().getRightSquareBracketKeyword_3());
                  
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
    // $ANTLR end "ruleNullElement"


    // $ANTLR start "entryRuleOCLCodeElement"
    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:969:1: entryRuleOCLCodeElement returns [EObject current=null] : iv_ruleOCLCodeElement= ruleOCLCodeElement EOF ;
    public final EObject entryRuleOCLCodeElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOCLCodeElement = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:970:2: (iv_ruleOCLCodeElement= ruleOCLCodeElement EOF )
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:971:2: iv_ruleOCLCodeElement= ruleOCLCodeElement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOCLCodeElementRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleOCLCodeElement_in_entryRuleOCLCodeElement2165);
            iv_ruleOCLCodeElement=ruleOCLCodeElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOCLCodeElement; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOCLCodeElement2175); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOCLCodeElement"


    // $ANTLR start "ruleOCLCodeElement"
    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:978:1: ruleOCLCodeElement returns [EObject current=null] : ( () otherlv_1= 'oclCode' otherlv_2= '[' ( (lv_elements_3_0= ruleMarkupElement ) )* otherlv_4= ']' ) ;
    public final EObject ruleOCLCodeElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_elements_3_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:981:28: ( ( () otherlv_1= 'oclCode' otherlv_2= '[' ( (lv_elements_3_0= ruleMarkupElement ) )* otherlv_4= ']' ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:982:1: ( () otherlv_1= 'oclCode' otherlv_2= '[' ( (lv_elements_3_0= ruleMarkupElement ) )* otherlv_4= ']' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:982:1: ( () otherlv_1= 'oclCode' otherlv_2= '[' ( (lv_elements_3_0= ruleMarkupElement ) )* otherlv_4= ']' )
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:982:2: () otherlv_1= 'oclCode' otherlv_2= '[' ( (lv_elements_3_0= ruleMarkupElement ) )* otherlv_4= ']'
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:982:2: ()
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:983:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getOCLCodeElementAccess().getOCLCodeElementAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleOCLCodeElement2224); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getOCLCodeElementAccess().getOclCodeKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleOCLCodeElement2236); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getOCLCodeElementAccess().getLeftSquareBracketKeyword_2());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:999:1: ( (lv_elements_3_0= ruleMarkupElement ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0>=RULE_INT && LA16_0<=RULE_ID)||(LA16_0>=RULE_NL && LA16_0<=RULE_WS)||(LA16_0>=16 && LA16_0<=27)||(LA16_0>=29 && LA16_0<=30)) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:1000:1: (lv_elements_3_0= ruleMarkupElement )
            	    {
            	    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:1000:1: (lv_elements_3_0= ruleMarkupElement )
            	    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:1001:3: lv_elements_3_0= ruleMarkupElement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getOCLCodeElementAccess().getElementsMarkupElementParserRuleCall_3_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleMarkupElement_in_ruleOCLCodeElement2257);
            	    lv_elements_3_0=ruleMarkupElement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getOCLCodeElementRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"elements",
            	              		lv_elements_3_0, 
            	              		"MarkupElement");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            otherlv_4=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleOCLCodeElement2270); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getOCLCodeElementAccess().getRightSquareBracketKeyword_4());
                  
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
    // $ANTLR end "ruleOCLCodeElement"


    // $ANTLR start "entryRuleOCLEvalElement"
    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:1029:1: entryRuleOCLEvalElement returns [EObject current=null] : iv_ruleOCLEvalElement= ruleOCLEvalElement EOF ;
    public final EObject entryRuleOCLEvalElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOCLEvalElement = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:1030:2: (iv_ruleOCLEvalElement= ruleOCLEvalElement EOF )
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:1031:2: iv_ruleOCLEvalElement= ruleOCLEvalElement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOCLEvalElementRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleOCLEvalElement_in_entryRuleOCLEvalElement2306);
            iv_ruleOCLEvalElement=ruleOCLEvalElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOCLEvalElement; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOCLEvalElement2316); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOCLEvalElement"


    // $ANTLR start "ruleOCLEvalElement"
    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:1038:1: ruleOCLEvalElement returns [EObject current=null] : ( () otherlv_1= 'oclEval' otherlv_2= '[' ( (lv_elements_3_0= ruleMarkupElement ) )* otherlv_4= ']' ) ;
    public final EObject ruleOCLEvalElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_elements_3_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:1041:28: ( ( () otherlv_1= 'oclEval' otherlv_2= '[' ( (lv_elements_3_0= ruleMarkupElement ) )* otherlv_4= ']' ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:1042:1: ( () otherlv_1= 'oclEval' otherlv_2= '[' ( (lv_elements_3_0= ruleMarkupElement ) )* otherlv_4= ']' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:1042:1: ( () otherlv_1= 'oclEval' otherlv_2= '[' ( (lv_elements_3_0= ruleMarkupElement ) )* otherlv_4= ']' )
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:1042:2: () otherlv_1= 'oclEval' otherlv_2= '[' ( (lv_elements_3_0= ruleMarkupElement ) )* otherlv_4= ']'
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:1042:2: ()
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:1043:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getOCLEvalElementAccess().getOCLEvalElementAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleOCLEvalElement2365); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getOCLEvalElementAccess().getOclEvalKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleOCLEvalElement2377); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getOCLEvalElementAccess().getLeftSquareBracketKeyword_2());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:1059:1: ( (lv_elements_3_0= ruleMarkupElement ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>=RULE_INT && LA17_0<=RULE_ID)||(LA17_0>=RULE_NL && LA17_0<=RULE_WS)||(LA17_0>=16 && LA17_0<=27)||(LA17_0>=29 && LA17_0<=30)) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:1060:1: (lv_elements_3_0= ruleMarkupElement )
            	    {
            	    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:1060:1: (lv_elements_3_0= ruleMarkupElement )
            	    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:1061:3: lv_elements_3_0= ruleMarkupElement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getOCLEvalElementAccess().getElementsMarkupElementParserRuleCall_3_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleMarkupElement_in_ruleOCLEvalElement2398);
            	    lv_elements_3_0=ruleMarkupElement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getOCLEvalElementRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"elements",
            	              		lv_elements_3_0, 
            	              		"MarkupElement");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            otherlv_4=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleOCLEvalElement2411); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getOCLEvalElementAccess().getRightSquareBracketKeyword_4());
                  
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
    // $ANTLR end "ruleOCLEvalElement"


    // $ANTLR start "entryRuleOCLTextElement"
    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:1089:1: entryRuleOCLTextElement returns [EObject current=null] : iv_ruleOCLTextElement= ruleOCLTextElement EOF ;
    public final EObject entryRuleOCLTextElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOCLTextElement = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:1090:2: (iv_ruleOCLTextElement= ruleOCLTextElement EOF )
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:1091:2: iv_ruleOCLTextElement= ruleOCLTextElement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOCLTextElementRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleOCLTextElement_in_entryRuleOCLTextElement2447);
            iv_ruleOCLTextElement=ruleOCLTextElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOCLTextElement; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOCLTextElement2457); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOCLTextElement"


    // $ANTLR start "ruleOCLTextElement"
    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:1098:1: ruleOCLTextElement returns [EObject current=null] : ( () otherlv_1= 'oclText' otherlv_2= '[' ( (lv_elements_3_0= ruleMarkupElement ) )* otherlv_4= ']' ) ;
    public final EObject ruleOCLTextElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_elements_3_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:1101:28: ( ( () otherlv_1= 'oclText' otherlv_2= '[' ( (lv_elements_3_0= ruleMarkupElement ) )* otherlv_4= ']' ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:1102:1: ( () otherlv_1= 'oclText' otherlv_2= '[' ( (lv_elements_3_0= ruleMarkupElement ) )* otherlv_4= ']' )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:1102:1: ( () otherlv_1= 'oclText' otherlv_2= '[' ( (lv_elements_3_0= ruleMarkupElement ) )* otherlv_4= ']' )
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:1102:2: () otherlv_1= 'oclText' otherlv_2= '[' ( (lv_elements_3_0= ruleMarkupElement ) )* otherlv_4= ']'
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:1102:2: ()
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:1103:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getOCLTextElementAccess().getOCLTextElementAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleOCLTextElement2506); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getOCLTextElementAccess().getOclTextKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleOCLTextElement2518); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getOCLTextElementAccess().getLeftSquareBracketKeyword_2());
                  
            }
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:1119:1: ( (lv_elements_3_0= ruleMarkupElement ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0>=RULE_INT && LA18_0<=RULE_ID)||(LA18_0>=RULE_NL && LA18_0<=RULE_WS)||(LA18_0>=16 && LA18_0<=27)||(LA18_0>=29 && LA18_0<=30)) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:1120:1: (lv_elements_3_0= ruleMarkupElement )
            	    {
            	    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:1120:1: (lv_elements_3_0= ruleMarkupElement )
            	    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:1121:3: lv_elements_3_0= ruleMarkupElement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getOCLTextElementAccess().getElementsMarkupElementParserRuleCall_3_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleMarkupElement_in_ruleOCLTextElement2539);
            	    lv_elements_3_0=ruleMarkupElement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getOCLTextElementRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"elements",
            	              		lv_elements_3_0, 
            	              		"MarkupElement");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            otherlv_4=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleOCLTextElement2552); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getOCLTextElementAccess().getRightSquareBracketKeyword_4());
                  
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
    // $ANTLR end "ruleOCLTextElement"


    // $ANTLR start "entryRuleTextElement"
    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:1149:1: entryRuleTextElement returns [EObject current=null] : iv_ruleTextElement= ruleTextElement EOF ;
    public final EObject entryRuleTextElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTextElement = null;


        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:1150:2: (iv_ruleTextElement= ruleTextElement EOF )
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:1151:2: iv_ruleTextElement= ruleTextElement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTextElementRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTextElement_in_entryRuleTextElement2588);
            iv_ruleTextElement=ruleTextElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTextElement; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTextElement2598); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTextElement"


    // $ANTLR start "ruleTextElement"
    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:1158:1: ruleTextElement returns [EObject current=null] : ( ( ( (lv_text_0_1= RULE_ID | lv_text_0_2= RULE_WORD | lv_text_0_3= RULE_INT | lv_text_0_4= RULE_WS | lv_text_0_5= ':' | lv_text_0_6= '#' | lv_text_0_7= ',' ) ) )+ | ( (lv_text_1_0= ruleMarkupKeyword ) ) ) ;
    public final EObject ruleTextElement() throws RecognitionException {
        EObject current = null;

        Token lv_text_0_1=null;
        Token lv_text_0_2=null;
        Token lv_text_0_3=null;
        Token lv_text_0_4=null;
        Token lv_text_0_5=null;
        Token lv_text_0_6=null;
        Token lv_text_0_7=null;
        AntlrDatatypeRuleToken lv_text_1_0 = null;


         enterRule(); 
            
        try {
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:1161:28: ( ( ( ( (lv_text_0_1= RULE_ID | lv_text_0_2= RULE_WORD | lv_text_0_3= RULE_INT | lv_text_0_4= RULE_WS | lv_text_0_5= ':' | lv_text_0_6= '#' | lv_text_0_7= ',' ) ) )+ | ( (lv_text_1_0= ruleMarkupKeyword ) ) ) )
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:1162:1: ( ( ( (lv_text_0_1= RULE_ID | lv_text_0_2= RULE_WORD | lv_text_0_3= RULE_INT | lv_text_0_4= RULE_WS | lv_text_0_5= ':' | lv_text_0_6= '#' | lv_text_0_7= ',' ) ) )+ | ( (lv_text_1_0= ruleMarkupKeyword ) ) )
            {
            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:1162:1: ( ( ( (lv_text_0_1= RULE_ID | lv_text_0_2= RULE_WORD | lv_text_0_3= RULE_INT | lv_text_0_4= RULE_WS | lv_text_0_5= ':' | lv_text_0_6= '#' | lv_text_0_7= ',' ) ) )+ | ( (lv_text_1_0= ruleMarkupKeyword ) ) )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( ((LA21_0>=RULE_INT && LA21_0<=RULE_ID)||(LA21_0>=RULE_WORD && LA21_0<=RULE_WS)||LA21_0==26||(LA21_0>=29 && LA21_0<=30)) ) {
                alt21=1;
            }
            else if ( ((LA21_0>=16 && LA21_0<=25)) ) {
                alt21=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:1162:2: ( ( (lv_text_0_1= RULE_ID | lv_text_0_2= RULE_WORD | lv_text_0_3= RULE_INT | lv_text_0_4= RULE_WS | lv_text_0_5= ':' | lv_text_0_6= '#' | lv_text_0_7= ',' ) ) )+
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:1162:2: ( ( (lv_text_0_1= RULE_ID | lv_text_0_2= RULE_WORD | lv_text_0_3= RULE_INT | lv_text_0_4= RULE_WS | lv_text_0_5= ':' | lv_text_0_6= '#' | lv_text_0_7= ',' ) ) )+
                    int cnt20=0;
                    loop20:
                    do {
                        int alt20=2;
                        alt20 = dfa20.predict(input);
                        switch (alt20) {
                    	case 1 :
                    	    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:1163:1: ( (lv_text_0_1= RULE_ID | lv_text_0_2= RULE_WORD | lv_text_0_3= RULE_INT | lv_text_0_4= RULE_WS | lv_text_0_5= ':' | lv_text_0_6= '#' | lv_text_0_7= ',' ) )
                    	    {
                    	    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:1163:1: ( (lv_text_0_1= RULE_ID | lv_text_0_2= RULE_WORD | lv_text_0_3= RULE_INT | lv_text_0_4= RULE_WS | lv_text_0_5= ':' | lv_text_0_6= '#' | lv_text_0_7= ',' ) )
                    	    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:1164:1: (lv_text_0_1= RULE_ID | lv_text_0_2= RULE_WORD | lv_text_0_3= RULE_INT | lv_text_0_4= RULE_WS | lv_text_0_5= ':' | lv_text_0_6= '#' | lv_text_0_7= ',' )
                    	    {
                    	    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:1164:1: (lv_text_0_1= RULE_ID | lv_text_0_2= RULE_WORD | lv_text_0_3= RULE_INT | lv_text_0_4= RULE_WS | lv_text_0_5= ':' | lv_text_0_6= '#' | lv_text_0_7= ',' )
                    	    int alt19=7;
                    	    switch ( input.LA(1) ) {
                    	    case RULE_ID:
                    	        {
                    	        alt19=1;
                    	        }
                    	        break;
                    	    case RULE_WORD:
                    	        {
                    	        alt19=2;
                    	        }
                    	        break;
                    	    case RULE_INT:
                    	        {
                    	        alt19=3;
                    	        }
                    	        break;
                    	    case RULE_WS:
                    	        {
                    	        alt19=4;
                    	        }
                    	        break;
                    	    case 26:
                    	        {
                    	        alt19=5;
                    	        }
                    	        break;
                    	    case 29:
                    	        {
                    	        alt19=6;
                    	        }
                    	        break;
                    	    case 30:
                    	        {
                    	        alt19=7;
                    	        }
                    	        break;
                    	    default:
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 19, 0, input);

                    	        throw nvae;
                    	    }

                    	    switch (alt19) {
                    	        case 1 :
                    	            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:1165:3: lv_text_0_1= RULE_ID
                    	            {
                    	            lv_text_0_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTextElement2642); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              			newLeafNode(lv_text_0_1, grammarAccess.getTextElementAccess().getTextIDTerminalRuleCall_0_0_0()); 
                    	              		
                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElement(grammarAccess.getTextElementRule());
                    	              	        }
                    	                     		addWithLastConsumed(
                    	                     			current, 
                    	                     			"text",
                    	                      		lv_text_0_1, 
                    	                      		"ID");
                    	              	    
                    	            }

                    	            }
                    	            break;
                    	        case 2 :
                    	            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:1180:8: lv_text_0_2= RULE_WORD
                    	            {
                    	            lv_text_0_2=(Token)match(input,RULE_WORD,FollowSets000.FOLLOW_RULE_WORD_in_ruleTextElement2662); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              			newLeafNode(lv_text_0_2, grammarAccess.getTextElementAccess().getTextWORDTerminalRuleCall_0_0_1()); 
                    	              		
                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElement(grammarAccess.getTextElementRule());
                    	              	        }
                    	                     		addWithLastConsumed(
                    	                     			current, 
                    	                     			"text",
                    	                      		lv_text_0_2, 
                    	                      		"WORD");
                    	              	    
                    	            }

                    	            }
                    	            break;
                    	        case 3 :
                    	            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:1195:8: lv_text_0_3= RULE_INT
                    	            {
                    	            lv_text_0_3=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleTextElement2682); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              			newLeafNode(lv_text_0_3, grammarAccess.getTextElementAccess().getTextINTTerminalRuleCall_0_0_2()); 
                    	              		
                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElement(grammarAccess.getTextElementRule());
                    	              	        }
                    	                     		addWithLastConsumed(
                    	                     			current, 
                    	                     			"text",
                    	                      		lv_text_0_3, 
                    	                      		"INT");
                    	              	    
                    	            }

                    	            }
                    	            break;
                    	        case 4 :
                    	            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:1210:8: lv_text_0_4= RULE_WS
                    	            {
                    	            lv_text_0_4=(Token)match(input,RULE_WS,FollowSets000.FOLLOW_RULE_WS_in_ruleTextElement2702); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              			newLeafNode(lv_text_0_4, grammarAccess.getTextElementAccess().getTextWSTerminalRuleCall_0_0_3()); 
                    	              		
                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElement(grammarAccess.getTextElementRule());
                    	              	        }
                    	                     		addWithLastConsumed(
                    	                     			current, 
                    	                     			"text",
                    	                      		lv_text_0_4, 
                    	                      		"WS");
                    	              	    
                    	            }

                    	            }
                    	            break;
                    	        case 5 :
                    	            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:1225:8: lv_text_0_5= ':'
                    	            {
                    	            lv_text_0_5=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleTextElement2723); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	                      newLeafNode(lv_text_0_5, grammarAccess.getTextElementAccess().getTextColonKeyword_0_0_4());
                    	                  
                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElement(grammarAccess.getTextElementRule());
                    	              	        }
                    	                     		addWithLastConsumed(current, "text", lv_text_0_5, null);
                    	              	    
                    	            }

                    	            }
                    	            break;
                    	        case 6 :
                    	            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:1237:8: lv_text_0_6= '#'
                    	            {
                    	            lv_text_0_6=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleTextElement2752); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	                      newLeafNode(lv_text_0_6, grammarAccess.getTextElementAccess().getTextNumberSignKeyword_0_0_5());
                    	                  
                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElement(grammarAccess.getTextElementRule());
                    	              	        }
                    	                     		addWithLastConsumed(current, "text", lv_text_0_6, null);
                    	              	    
                    	            }

                    	            }
                    	            break;
                    	        case 7 :
                    	            // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:1249:8: lv_text_0_7= ','
                    	            {
                    	            lv_text_0_7=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleTextElement2781); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	                      newLeafNode(lv_text_0_7, grammarAccess.getTextElementAccess().getTextCommaKeyword_0_0_6());
                    	                  
                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElement(grammarAccess.getTextElementRule());
                    	              	        }
                    	                     		addWithLastConsumed(current, "text", lv_text_0_7, null);
                    	              	    
                    	            }

                    	            }
                    	            break;

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt20 >= 1 ) break loop20;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(20, input);
                                throw eee;
                        }
                        cnt20++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:1265:6: ( (lv_text_1_0= ruleMarkupKeyword ) )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:1265:6: ( (lv_text_1_0= ruleMarkupKeyword ) )
                    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:1266:1: (lv_text_1_0= ruleMarkupKeyword )
                    {
                    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:1266:1: (lv_text_1_0= ruleMarkupKeyword )
                    // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:1267:3: lv_text_1_0= ruleMarkupKeyword
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTextElementAccess().getTextMarkupKeywordParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMarkupKeyword_in_ruleTextElement2825);
                    lv_text_1_0=ruleMarkupKeyword();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTextElementRule());
                      	        }
                             		add(
                             			current, 
                             			"text",
                              		lv_text_1_0, 
                              		"MarkupKeyword");
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
    // $ANTLR end "ruleTextElement"

    // $ANTLR start synpred11_InternalMarkup
    public final void synpred11_InternalMarkup_fragment() throws RecognitionException {   
        EObject this_FontElement_0 = null;


        // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:223:2: (this_FontElement_0= ruleFontElement )
        // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:223:2: this_FontElement_0= ruleFontElement
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleFontElement_in_synpred11_InternalMarkup493);
        this_FontElement_0=ruleFontElement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred11_InternalMarkup

    // $ANTLR start synpred13_InternalMarkup
    public final void synpred13_InternalMarkup_fragment() throws RecognitionException {   
        EObject this_BulletElement_2 = null;


        // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:249:2: (this_BulletElement_2= ruleBulletElement )
        // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:249:2: this_BulletElement_2= ruleBulletElement
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleBulletElement_in_synpred13_InternalMarkup553);
        this_BulletElement_2=ruleBulletElement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred13_InternalMarkup

    // $ANTLR start synpred14_InternalMarkup
    public final void synpred14_InternalMarkup_fragment() throws RecognitionException {   
        EObject this_FigureElement_3 = null;


        // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:262:2: (this_FigureElement_3= ruleFigureElement )
        // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:262:2: this_FigureElement_3= ruleFigureElement
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleFigureElement_in_synpred14_InternalMarkup583);
        this_FigureElement_3=ruleFigureElement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred14_InternalMarkup

    // $ANTLR start synpred15_InternalMarkup
    public final void synpred15_InternalMarkup_fragment() throws RecognitionException {   
        EObject this_FigureRefElement_4 = null;


        // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:275:2: (this_FigureRefElement_4= ruleFigureRefElement )
        // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:275:2: this_FigureRefElement_4= ruleFigureRefElement
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleFigureRefElement_in_synpred15_InternalMarkup613);
        this_FigureRefElement_4=ruleFigureRefElement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred15_InternalMarkup

    // $ANTLR start synpred16_InternalMarkup
    public final void synpred16_InternalMarkup_fragment() throws RecognitionException {   
        EObject this_FootnoteElement_5 = null;


        // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:288:2: (this_FootnoteElement_5= ruleFootnoteElement )
        // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:288:2: this_FootnoteElement_5= ruleFootnoteElement
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleFootnoteElement_in_synpred16_InternalMarkup643);
        this_FootnoteElement_5=ruleFootnoteElement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred16_InternalMarkup

    // $ANTLR start synpred17_InternalMarkup
    public final void synpred17_InternalMarkup_fragment() throws RecognitionException {   
        EObject this_HeadingElement_6 = null;


        // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:301:2: (this_HeadingElement_6= ruleHeadingElement )
        // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:301:2: this_HeadingElement_6= ruleHeadingElement
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleHeadingElement_in_synpred17_InternalMarkup673);
        this_HeadingElement_6=ruleHeadingElement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred17_InternalMarkup

    // $ANTLR start synpred19_InternalMarkup
    public final void synpred19_InternalMarkup_fragment() throws RecognitionException {   
        EObject this_OCLCodeElement_8 = null;


        // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:327:2: (this_OCLCodeElement_8= ruleOCLCodeElement )
        // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:327:2: this_OCLCodeElement_8= ruleOCLCodeElement
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleOCLCodeElement_in_synpred19_InternalMarkup733);
        this_OCLCodeElement_8=ruleOCLCodeElement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred19_InternalMarkup

    // $ANTLR start synpred20_InternalMarkup
    public final void synpred20_InternalMarkup_fragment() throws RecognitionException {   
        EObject this_OCLEvalElement_9 = null;


        // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:340:2: (this_OCLEvalElement_9= ruleOCLEvalElement )
        // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:340:2: this_OCLEvalElement_9= ruleOCLEvalElement
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleOCLEvalElement_in_synpred20_InternalMarkup763);
        this_OCLEvalElement_9=ruleOCLEvalElement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred20_InternalMarkup

    // $ANTLR start synpred21_InternalMarkup
    public final void synpred21_InternalMarkup_fragment() throws RecognitionException {   
        EObject this_OCLTextElement_10 = null;


        // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:353:2: (this_OCLTextElement_10= ruleOCLTextElement )
        // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:353:2: this_OCLTextElement_10= ruleOCLTextElement
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleOCLTextElement_in_synpred21_InternalMarkup793);
        this_OCLTextElement_10=ruleOCLTextElement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred21_InternalMarkup

    // $ANTLR start synpred43_InternalMarkup
    public final void synpred43_InternalMarkup_fragment() throws RecognitionException {   
        Token lv_text_0_1=null;
        Token lv_text_0_2=null;
        Token lv_text_0_3=null;
        Token lv_text_0_4=null;
        Token lv_text_0_5=null;
        Token lv_text_0_6=null;
        Token lv_text_0_7=null;

        // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:1163:1: ( ( (lv_text_0_1= RULE_ID | lv_text_0_2= RULE_WORD | lv_text_0_3= RULE_INT | lv_text_0_4= RULE_WS | lv_text_0_5= ':' | lv_text_0_6= '#' | lv_text_0_7= ',' ) ) )
        // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:1163:1: ( (lv_text_0_1= RULE_ID | lv_text_0_2= RULE_WORD | lv_text_0_3= RULE_INT | lv_text_0_4= RULE_WS | lv_text_0_5= ':' | lv_text_0_6= '#' | lv_text_0_7= ',' ) )
        {
        // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:1163:1: ( (lv_text_0_1= RULE_ID | lv_text_0_2= RULE_WORD | lv_text_0_3= RULE_INT | lv_text_0_4= RULE_WS | lv_text_0_5= ':' | lv_text_0_6= '#' | lv_text_0_7= ',' ) )
        // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:1164:1: (lv_text_0_1= RULE_ID | lv_text_0_2= RULE_WORD | lv_text_0_3= RULE_INT | lv_text_0_4= RULE_WS | lv_text_0_5= ':' | lv_text_0_6= '#' | lv_text_0_7= ',' )
        {
        // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:1164:1: (lv_text_0_1= RULE_ID | lv_text_0_2= RULE_WORD | lv_text_0_3= RULE_INT | lv_text_0_4= RULE_WS | lv_text_0_5= ':' | lv_text_0_6= '#' | lv_text_0_7= ',' )
        int alt25=7;
        switch ( input.LA(1) ) {
        case RULE_ID:
            {
            alt25=1;
            }
            break;
        case RULE_WORD:
            {
            alt25=2;
            }
            break;
        case RULE_INT:
            {
            alt25=3;
            }
            break;
        case RULE_WS:
            {
            alt25=4;
            }
            break;
        case 26:
            {
            alt25=5;
            }
            break;
        case 29:
            {
            alt25=6;
            }
            break;
        case 30:
            {
            alt25=7;
            }
            break;
        default:
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 25, 0, input);

            throw nvae;
        }

        switch (alt25) {
            case 1 :
                // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:1165:3: lv_text_0_1= RULE_ID
                {
                lv_text_0_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_synpred43_InternalMarkup2642); if (state.failed) return ;

                }
                break;
            case 2 :
                // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:1180:8: lv_text_0_2= RULE_WORD
                {
                lv_text_0_2=(Token)match(input,RULE_WORD,FollowSets000.FOLLOW_RULE_WORD_in_synpred43_InternalMarkup2662); if (state.failed) return ;

                }
                break;
            case 3 :
                // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:1195:8: lv_text_0_3= RULE_INT
                {
                lv_text_0_3=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_synpred43_InternalMarkup2682); if (state.failed) return ;

                }
                break;
            case 4 :
                // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:1210:8: lv_text_0_4= RULE_WS
                {
                lv_text_0_4=(Token)match(input,RULE_WS,FollowSets000.FOLLOW_RULE_WS_in_synpred43_InternalMarkup2702); if (state.failed) return ;

                }
                break;
            case 5 :
                // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:1225:8: lv_text_0_5= ':'
                {
                lv_text_0_5=(Token)match(input,26,FollowSets000.FOLLOW_26_in_synpred43_InternalMarkup2723); if (state.failed) return ;

                }
                break;
            case 6 :
                // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:1237:8: lv_text_0_6= '#'
                {
                lv_text_0_6=(Token)match(input,29,FollowSets000.FOLLOW_29_in_synpred43_InternalMarkup2752); if (state.failed) return ;

                }
                break;
            case 7 :
                // ../../plugins/org.eclipse.ocl.xtext.markup/src-gen/org/eclipse/ocl/xtext/markup/parser/antlr/internal/InternalMarkup.g:1249:8: lv_text_0_7= ','
                {
                lv_text_0_7=(Token)match(input,30,FollowSets000.FOLLOW_30_in_synpred43_InternalMarkup2781); if (state.failed) return ;

                }
                break;

        }


        }


        }
    }
    // $ANTLR end synpred43_InternalMarkup

    // Delegated rules

    public final boolean synpred16_InternalMarkup() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred16_InternalMarkup_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred43_InternalMarkup() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred43_InternalMarkup_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred15_InternalMarkup() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred15_InternalMarkup_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred11_InternalMarkup() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred11_InternalMarkup_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred13_InternalMarkup() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred13_InternalMarkup_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred20_InternalMarkup() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred20_InternalMarkup_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred14_InternalMarkup() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred14_InternalMarkup_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred21_InternalMarkup() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred21_InternalMarkup_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred17_InternalMarkup() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred17_InternalMarkup_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred19_InternalMarkup() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred19_InternalMarkup_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA3 dfa3 = new DFA3(this);
    protected DFA20 dfa20 = new DFA20(this);
    static final String DFA3_eotS =
        "\35\uffff";
    static final String DFA3_eofS =
        "\35\uffff";
    static final String DFA3_minS =
        "\1\4\2\0\1\uffff\5\0\1\uffff\3\0\20\uffff";
    static final String DFA3_maxS =
        "\1\36\2\0\1\uffff\5\0\1\uffff\3\0\20\uffff";
    static final String DFA3_acceptS =
        "\3\uffff\1\2\5\uffff\1\10\3\uffff\1\14\6\uffff\1\1\1\3\1\4\1\5"+
        "\1\6\1\7\1\11\1\12\1\13";
    static final String DFA3_specialS =
        "\1\uffff\1\0\1\1\1\uffff\1\2\1\3\1\4\1\5\1\6\1\uffff\1\7\1\10\1"+
        "\11\20\uffff}>";
    static final String[] DFA3_transitionS = {
            "\2\15\1\uffff\1\3\2\15\6\uffff\1\1\1\2\1\4\1\5\1\6\1\7\1\10"+
            "\1\12\1\13\1\14\1\15\1\11\1\uffff\2\15",
            "\1\uffff",
            "\1\uffff",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
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
            "",
            "",
            ""
    };

    static final short[] DFA3_eot = DFA.unpackEncodedString(DFA3_eotS);
    static final short[] DFA3_eof = DFA.unpackEncodedString(DFA3_eofS);
    static final char[] DFA3_min = DFA.unpackEncodedStringToUnsignedChars(DFA3_minS);
    static final char[] DFA3_max = DFA.unpackEncodedStringToUnsignedChars(DFA3_maxS);
    static final short[] DFA3_accept = DFA.unpackEncodedString(DFA3_acceptS);
    static final short[] DFA3_special = DFA.unpackEncodedString(DFA3_specialS);
    static final short[][] DFA3_transition;

    static {
        int numStates = DFA3_transitionS.length;
        DFA3_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA3_transition[i] = DFA.unpackEncodedString(DFA3_transitionS[i]);
        }
    }

    class DFA3 extends DFA {

        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 3;
            this.eot = DFA3_eot;
            this.eof = DFA3_eof;
            this.min = DFA3_min;
            this.max = DFA3_max;
            this.accept = DFA3_accept;
            this.special = DFA3_special;
            this.transition = DFA3_transition;
        }
        public String getDescription() {
            return "222:1: (this_FontElement_0= ruleFontElement | this_NewLineElement_1= ruleNewLineElement | this_BulletElement_2= ruleBulletElement | this_FigureElement_3= ruleFigureElement | this_FigureRefElement_4= ruleFigureRefElement | this_FootnoteElement_5= ruleFootnoteElement | this_HeadingElement_6= ruleHeadingElement | this_NullElement_7= ruleNullElement | this_OCLCodeElement_8= ruleOCLCodeElement | this_OCLEvalElement_9= ruleOCLEvalElement | this_OCLTextElement_10= ruleOCLTextElement | this_TextElement_11= ruleTextElement )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA3_1 = input.LA(1);

                         
                        int index3_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_InternalMarkup()) ) {s = 20;}

                        else if ( (true) ) {s = 13;}

                         
                        input.seek(index3_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA3_2 = input.LA(1);

                         
                        int index3_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_InternalMarkup()) ) {s = 20;}

                        else if ( (true) ) {s = 13;}

                         
                        input.seek(index3_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA3_4 = input.LA(1);

                         
                        int index3_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred13_InternalMarkup()) ) {s = 21;}

                        else if ( (true) ) {s = 13;}

                         
                        input.seek(index3_4);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA3_5 = input.LA(1);

                         
                        int index3_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_InternalMarkup()) ) {s = 22;}

                        else if ( (true) ) {s = 13;}

                         
                        input.seek(index3_5);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA3_6 = input.LA(1);

                         
                        int index3_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred15_InternalMarkup()) ) {s = 23;}

                        else if ( (true) ) {s = 13;}

                         
                        input.seek(index3_6);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA3_7 = input.LA(1);

                         
                        int index3_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred16_InternalMarkup()) ) {s = 24;}

                        else if ( (true) ) {s = 13;}

                         
                        input.seek(index3_7);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA3_8 = input.LA(1);

                         
                        int index3_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_InternalMarkup()) ) {s = 25;}

                        else if ( (true) ) {s = 13;}

                         
                        input.seek(index3_8);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA3_10 = input.LA(1);

                         
                        int index3_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred19_InternalMarkup()) ) {s = 26;}

                        else if ( (true) ) {s = 13;}

                         
                        input.seek(index3_10);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA3_11 = input.LA(1);

                         
                        int index3_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred20_InternalMarkup()) ) {s = 27;}

                        else if ( (true) ) {s = 13;}

                         
                        input.seek(index3_11);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA3_12 = input.LA(1);

                         
                        int index3_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred21_InternalMarkup()) ) {s = 28;}

                        else if ( (true) ) {s = 13;}

                         
                        input.seek(index3_12);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 3, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA20_eotS =
        "\12\uffff";
    static final String DFA20_eofS =
        "\1\1\11\uffff";
    static final String DFA20_minS =
        "\1\4\1\uffff\7\0\1\uffff";
    static final String DFA20_maxS =
        "\1\36\1\uffff\7\0\1\uffff";
    static final String DFA20_acceptS =
        "\1\uffff\1\2\7\uffff\1\1";
    static final String DFA20_specialS =
        "\2\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\uffff}>";
    static final String[] DFA20_transitionS = {
            "\1\4\1\2\1\uffff\1\1\1\3\1\5\6\uffff\12\1\1\6\2\1\1\7\1\10",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            ""
    };

    static final short[] DFA20_eot = DFA.unpackEncodedString(DFA20_eotS);
    static final short[] DFA20_eof = DFA.unpackEncodedString(DFA20_eofS);
    static final char[] DFA20_min = DFA.unpackEncodedStringToUnsignedChars(DFA20_minS);
    static final char[] DFA20_max = DFA.unpackEncodedStringToUnsignedChars(DFA20_maxS);
    static final short[] DFA20_accept = DFA.unpackEncodedString(DFA20_acceptS);
    static final short[] DFA20_special = DFA.unpackEncodedString(DFA20_specialS);
    static final short[][] DFA20_transition;

    static {
        int numStates = DFA20_transitionS.length;
        DFA20_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA20_transition[i] = DFA.unpackEncodedString(DFA20_transitionS[i]);
        }
    }

    class DFA20 extends DFA {

        public DFA20(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 20;
            this.eot = DFA20_eot;
            this.eof = DFA20_eof;
            this.min = DFA20_min;
            this.max = DFA20_max;
            this.accept = DFA20_accept;
            this.special = DFA20_special;
            this.transition = DFA20_transition;
        }
        public String getDescription() {
            return "()+ loopback of 1162:2: ( ( (lv_text_0_1= RULE_ID | lv_text_0_2= RULE_WORD | lv_text_0_3= RULE_INT | lv_text_0_4= RULE_WS | lv_text_0_5= ':' | lv_text_0_6= '#' | lv_text_0_7= ',' ) ) )+";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA20_2 = input.LA(1);

                         
                        int index20_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalMarkup()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index20_2);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA20_3 = input.LA(1);

                         
                        int index20_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalMarkup()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index20_3);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA20_4 = input.LA(1);

                         
                        int index20_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalMarkup()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index20_4);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA20_5 = input.LA(1);

                         
                        int index20_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalMarkup()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index20_5);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA20_6 = input.LA(1);

                         
                        int index20_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalMarkup()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index20_6);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA20_7 = input.LA(1);

                         
                        int index20_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalMarkup()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index20_7);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA20_8 = input.LA(1);

                         
                        int index20_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalMarkup()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index20_8);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 20, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleMarkup_in_entryRuleMarkup81 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMarkup91 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMarkupElement_in_ruleMarkup136 = new BitSet(new long[]{0x000000006FFF03B2L});
        public static final BitSet FOLLOW_ruleMarkupKeyword_in_entryRuleMarkupKeyword173 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMarkupKeyword184 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleMarkupKeyword222 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleMarkupKeyword241 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleMarkupKeyword260 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleMarkupKeyword279 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleMarkupKeyword298 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_ruleMarkupKeyword317 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleMarkupKeyword336 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_ruleMarkupKeyword355 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_ruleMarkupKeyword374 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_ruleMarkupKeyword393 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMarkupElement_in_entryRuleMarkupElement433 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMarkupElement443 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFontElement_in_ruleMarkupElement493 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNewLineElement_in_ruleMarkupElement523 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBulletElement_in_ruleMarkupElement553 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFigureElement_in_ruleMarkupElement583 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFigureRefElement_in_ruleMarkupElement613 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFootnoteElement_in_ruleMarkupElement643 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleHeadingElement_in_ruleMarkupElement673 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNullElement_in_ruleMarkupElement703 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOCLCodeElement_in_ruleMarkupElement733 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOCLEvalElement_in_ruleMarkupElement763 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOCLTextElement_in_ruleMarkupElement793 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTextElement_in_ruleMarkupElement823 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBulletElement_in_entryRuleBulletElement858 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBulletElement868 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleBulletElement917 = new BitSet(new long[]{0x000000000C000000L});
        public static final BitSet FOLLOW_26_in_ruleBulletElement930 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleBulletElement947 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_27_in_ruleBulletElement966 = new BitSet(new long[]{0x000000007FFF03B0L});
        public static final BitSet FOLLOW_ruleMarkupElement_in_ruleBulletElement987 = new BitSet(new long[]{0x000000007FFF03B0L});
        public static final BitSet FOLLOW_28_in_ruleBulletElement1000 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFontElement_in_entryRuleFontElement1036 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFontElement1046 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleFontElement1091 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_17_in_ruleFontElement1120 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_27_in_ruleFontElement1148 = new BitSet(new long[]{0x000000007FFF03B0L});
        public static final BitSet FOLLOW_ruleMarkupElement_in_ruleFontElement1169 = new BitSet(new long[]{0x000000007FFF03B0L});
        public static final BitSet FOLLOW_28_in_ruleFontElement1182 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFigureElement_in_entryRuleFigureElement1218 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFigureElement1228 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleFigureElement1265 = new BitSet(new long[]{0x0000000028000000L});
        public static final BitSet FOLLOW_29_in_ruleFigureElement1278 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFigureElement1295 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_27_in_ruleFigureElement1314 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleFigureElement1331 = new BitSet(new long[]{0x0000000050000000L});
        public static final BitSet FOLLOW_30_in_ruleFigureElement1349 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleFigureElement1366 = new BitSet(new long[]{0x0000000050000000L});
        public static final BitSet FOLLOW_30_in_ruleFigureElement1384 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleFigureElement1401 = new BitSet(new long[]{0x0000000050000000L});
        public static final BitSet FOLLOW_30_in_ruleFigureElement1419 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleFigureElement1436 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_28_in_ruleFigureElement1459 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFigureRefElement_in_entryRuleFigureRefElement1495 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFigureRefElement1505 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleFigureRefElement1542 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_27_in_ruleFigureRefElement1554 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFigureRefElement1578 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_28_in_ruleFigureRefElement1590 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFootnoteElement_in_entryRuleFootnoteElement1626 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFootnoteElement1636 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_ruleFootnoteElement1685 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_27_in_ruleFootnoteElement1697 = new BitSet(new long[]{0x000000007FFF03B0L});
        public static final BitSet FOLLOW_ruleMarkupElement_in_ruleFootnoteElement1718 = new BitSet(new long[]{0x000000007FFF03B0L});
        public static final BitSet FOLLOW_28_in_ruleFootnoteElement1731 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleHeadingElement_in_entryRuleHeadingElement1767 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleHeadingElement1777 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleHeadingElement1826 = new BitSet(new long[]{0x000000000C000000L});
        public static final BitSet FOLLOW_26_in_ruleHeadingElement1839 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleHeadingElement1856 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_27_in_ruleHeadingElement1875 = new BitSet(new long[]{0x000000007FFF03B0L});
        public static final BitSet FOLLOW_ruleMarkupElement_in_ruleHeadingElement1896 = new BitSet(new long[]{0x000000007FFF03B0L});
        public static final BitSet FOLLOW_28_in_ruleHeadingElement1909 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNewLineElement_in_entryRuleNewLineElement1945 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNewLineElement1955 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_NL_in_ruleNewLineElement1996 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNullElement_in_entryRuleNullElement2036 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNullElement2046 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_ruleNullElement2095 = new BitSet(new long[]{0x000000007FFF03B0L});
        public static final BitSet FOLLOW_ruleMarkupElement_in_ruleNullElement2116 = new BitSet(new long[]{0x000000007FFF03B0L});
        public static final BitSet FOLLOW_28_in_ruleNullElement2129 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOCLCodeElement_in_entryRuleOCLCodeElement2165 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOCLCodeElement2175 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_ruleOCLCodeElement2224 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_27_in_ruleOCLCodeElement2236 = new BitSet(new long[]{0x000000007FFF03B0L});
        public static final BitSet FOLLOW_ruleMarkupElement_in_ruleOCLCodeElement2257 = new BitSet(new long[]{0x000000007FFF03B0L});
        public static final BitSet FOLLOW_28_in_ruleOCLCodeElement2270 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOCLEvalElement_in_entryRuleOCLEvalElement2306 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOCLEvalElement2316 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_ruleOCLEvalElement2365 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_27_in_ruleOCLEvalElement2377 = new BitSet(new long[]{0x000000007FFF03B0L});
        public static final BitSet FOLLOW_ruleMarkupElement_in_ruleOCLEvalElement2398 = new BitSet(new long[]{0x000000007FFF03B0L});
        public static final BitSet FOLLOW_28_in_ruleOCLEvalElement2411 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOCLTextElement_in_entryRuleOCLTextElement2447 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOCLTextElement2457 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_ruleOCLTextElement2506 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_27_in_ruleOCLTextElement2518 = new BitSet(new long[]{0x000000007FFF03B0L});
        public static final BitSet FOLLOW_ruleMarkupElement_in_ruleOCLTextElement2539 = new BitSet(new long[]{0x000000007FFF03B0L});
        public static final BitSet FOLLOW_28_in_ruleOCLTextElement2552 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTextElement_in_entryRuleTextElement2588 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTextElement2598 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTextElement2642 = new BitSet(new long[]{0x0000000064000332L});
        public static final BitSet FOLLOW_RULE_WORD_in_ruleTextElement2662 = new BitSet(new long[]{0x0000000064000332L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleTextElement2682 = new BitSet(new long[]{0x0000000064000332L});
        public static final BitSet FOLLOW_RULE_WS_in_ruleTextElement2702 = new BitSet(new long[]{0x0000000064000332L});
        public static final BitSet FOLLOW_26_in_ruleTextElement2723 = new BitSet(new long[]{0x0000000064000332L});
        public static final BitSet FOLLOW_29_in_ruleTextElement2752 = new BitSet(new long[]{0x0000000064000332L});
        public static final BitSet FOLLOW_30_in_ruleTextElement2781 = new BitSet(new long[]{0x0000000064000332L});
        public static final BitSet FOLLOW_ruleMarkupKeyword_in_ruleTextElement2825 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFontElement_in_synpred11_InternalMarkup493 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBulletElement_in_synpred13_InternalMarkup553 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFigureElement_in_synpred14_InternalMarkup583 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFigureRefElement_in_synpred15_InternalMarkup613 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFootnoteElement_in_synpred16_InternalMarkup643 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleHeadingElement_in_synpred17_InternalMarkup673 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOCLCodeElement_in_synpred19_InternalMarkup733 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOCLEvalElement_in_synpred20_InternalMarkup763 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOCLTextElement_in_synpred21_InternalMarkup793 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_synpred43_InternalMarkup2642 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_WORD_in_synpred43_InternalMarkup2662 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_synpred43_InternalMarkup2682 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_WS_in_synpred43_InternalMarkup2702 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_synpred43_InternalMarkup2723 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_synpred43_InternalMarkup2752 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_synpred43_InternalMarkup2781 = new BitSet(new long[]{0x0000000000000002L});
    }


}