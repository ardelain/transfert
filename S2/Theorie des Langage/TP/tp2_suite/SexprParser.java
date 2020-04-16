// Generated from Sexpr.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SexprParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		AT=1, PO=2, PF=3, WS=4;
	public static final int
		RULE_start = 0, RULE_sexpr = 1, RULE_suiteSexpr = 2, RULE_liste = 3, RULE_suiteListe = 4;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "sexpr", "suiteSexpr", "liste", "suiteListe"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "AT", "PO", "PF", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Sexpr.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SexprParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class StartContext extends ParserRuleContext {
		public int lg;
		public SexprContext sexpr;
		public SexprContext sexpr() {
			return getRuleContext(SexprContext.class,0);
		}
		public TerminalNode EOF() { return getToken(SexprParser.EOF, 0); }
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SexprListener ) ((SexprListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SexprListener ) ((SexprListener)listener).exitStart(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(10);
			((StartContext)_localctx).sexpr = sexpr();
			setState(11);
			match(EOF);
			 ((StartContext)_localctx).lg =  ((StartContext)_localctx).sexpr.lg  ; System.out.println("start "+_localctx.lg); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SexprContext extends ParserRuleContext {
		public int lg;
		public SuiteSexprContext suiteSexpr;
		public TerminalNode AT() { return getToken(SexprParser.AT, 0); }
		public TerminalNode PO() { return getToken(SexprParser.PO, 0); }
		public SuiteSexprContext suiteSexpr() {
			return getRuleContext(SuiteSexprContext.class,0);
		}
		public SexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SexprListener ) ((SexprListener)listener).enterSexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SexprListener ) ((SexprListener)listener).exitSexpr(this);
		}
	}

	public final SexprContext sexpr() throws RecognitionException {
		SexprContext _localctx = new SexprContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_sexpr);
		try {
			setState(20);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AT:
				enterOuterAlt(_localctx, 1);
				{
				setState(14);
				match(AT);
				 ((SexprContext)_localctx).lg =  1; System.out.println("sexpr "+_localctx.lg);
				}
				break;
			case PO:
				enterOuterAlt(_localctx, 2);
				{
				setState(16);
				match(PO);
				setState(17);
				((SexprContext)_localctx).suiteSexpr = suiteSexpr();
				 ((SexprContext)_localctx).lg =  ((SexprContext)_localctx).suiteSexpr.lg ;  System.out.println("sexpr2 "+_localctx.lg);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SuiteSexprContext extends ParserRuleContext {
		public int lg;
		public ListeContext liste;
		public TerminalNode PF() { return getToken(SexprParser.PF, 0); }
		public ListeContext liste() {
			return getRuleContext(ListeContext.class,0);
		}
		public SuiteSexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_suiteSexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SexprListener ) ((SexprListener)listener).enterSuiteSexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SexprListener ) ((SexprListener)listener).exitSuiteSexpr(this);
		}
	}

	public final SuiteSexprContext suiteSexpr() throws RecognitionException {
		SuiteSexprContext _localctx = new SuiteSexprContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_suiteSexpr);
		try {
			setState(28);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PF:
				enterOuterAlt(_localctx, 1);
				{
				setState(22);
				match(PF);
				 ((SuiteSexprContext)_localctx).lg =  0;
				}
				break;
			case AT:
			case PO:
				enterOuterAlt(_localctx, 2);
				{
				setState(24);
				((SuiteSexprContext)_localctx).liste = liste();
				setState(25);
				match(PF);
				System.out.println("suiteSexpr "+_localctx.lg+" = "+((SuiteSexprContext)_localctx).liste.lg); ((SuiteSexprContext)_localctx).lg =  ((SuiteSexprContext)_localctx).liste.lg;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ListeContext extends ParserRuleContext {
		public int lg;
		public SexprContext sexpr;
		public SuiteListeContext suiteListe;
		public SexprContext sexpr() {
			return getRuleContext(SexprContext.class,0);
		}
		public SuiteListeContext suiteListe() {
			return getRuleContext(SuiteListeContext.class,0);
		}
		public ListeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_liste; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SexprListener ) ((SexprListener)listener).enterListe(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SexprListener ) ((SexprListener)listener).exitListe(this);
		}
	}

	public final ListeContext liste() throws RecognitionException {
		ListeContext _localctx = new ListeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_liste);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			((ListeContext)_localctx).sexpr = sexpr();
			setState(31);
			((ListeContext)_localctx).suiteListe = suiteListe();
			 System.out.println("liste "+_localctx.lg+" = "+((ListeContext)_localctx).suiteListe.lg+" + "+ ((ListeContext)_localctx).sexpr.lg);((ListeContext)_localctx).lg =  ((ListeContext)_localctx).suiteListe.lg + ((ListeContext)_localctx).sexpr.lg ; 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SuiteListeContext extends ParserRuleContext {
		public int lg;
		public ListeContext liste;
		public ListeContext liste() {
			return getRuleContext(ListeContext.class,0);
		}
		public SuiteListeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_suiteListe; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SexprListener ) ((SexprListener)listener).enterSuiteListe(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SexprListener ) ((SexprListener)listener).exitSuiteListe(this);
		}
	}

	public final SuiteListeContext suiteListe() throws RecognitionException {
		SuiteListeContext _localctx = new SuiteListeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_suiteListe);
		try {
			setState(38);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PF:
				enterOuterAlt(_localctx, 1);
				{
				 ((SuiteListeContext)_localctx).lg =  0; 
				}
				break;
			case AT:
			case PO:
				enterOuterAlt(_localctx, 2);
				{
				setState(35);
				((SuiteListeContext)_localctx).liste = liste();
				 System.out.println("suiteListe "+_localctx.lg+" = "+((SuiteListeContext)_localctx).liste.lg);((SuiteListeContext)_localctx).lg =  ((SuiteListeContext)_localctx).liste.lg; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\6+\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\5\3"+
		"\27\n\3\3\4\3\4\3\4\3\4\3\4\3\4\5\4\37\n\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6"+
		"\3\6\5\6)\n\6\3\6\2\2\7\2\4\6\b\n\2\2\2(\2\f\3\2\2\2\4\26\3\2\2\2\6\36"+
		"\3\2\2\2\b \3\2\2\2\n(\3\2\2\2\f\r\5\4\3\2\r\16\7\2\2\3\16\17\b\2\1\2"+
		"\17\3\3\2\2\2\20\21\7\3\2\2\21\27\b\3\1\2\22\23\7\4\2\2\23\24\5\6\4\2"+
		"\24\25\b\3\1\2\25\27\3\2\2\2\26\20\3\2\2\2\26\22\3\2\2\2\27\5\3\2\2\2"+
		"\30\31\7\5\2\2\31\37\b\4\1\2\32\33\5\b\5\2\33\34\7\5\2\2\34\35\b\4\1\2"+
		"\35\37\3\2\2\2\36\30\3\2\2\2\36\32\3\2\2\2\37\7\3\2\2\2 !\5\4\3\2!\"\5"+
		"\n\6\2\"#\b\5\1\2#\t\3\2\2\2$)\b\6\1\2%&\5\b\5\2&\'\b\6\1\2\')\3\2\2\2"+
		"($\3\2\2\2(%\3\2\2\2)\13\3\2\2\2\5\26\36(";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}