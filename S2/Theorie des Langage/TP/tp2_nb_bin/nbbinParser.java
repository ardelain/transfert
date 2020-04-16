// Generated from nbbin.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class nbbinParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, F=2, V=3, PT=4, UNMATCH=5;
	public static final int
		RULE_start = 0, RULE_nbbin = 1, RULE_suitenbbin = 2, RULE_ret = 3;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "nbbin", "suitenbbin", "ret"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'.'", "'0'", "'1'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "F", "V", "PT", "UNMATCH"
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
	public String getGrammarFileName() { return "nbbin.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public nbbinParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class StartContext extends ParserRuleContext {
		public float lg;
		public NbbinContext nbbin;
		public RetContext ret;
		public NbbinContext nbbin() {
			return getRuleContext(NbbinContext.class,0);
		}
		public RetContext ret() {
			return getRuleContext(RetContext.class,0);
		}
		public TerminalNode EOF() { return getToken(nbbinParser.EOF, 0); }
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof nbbinListener ) ((nbbinListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof nbbinListener ) ((nbbinListener)listener).exitStart(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(8);
			((StartContext)_localctx).nbbin = nbbin(0);
			setState(9);
			((StartContext)_localctx).ret = ret();
			setState(10);
			match(EOF);
			 ((StartContext)_localctx).lg =  ((StartContext)_localctx).nbbin.lg + ((StartContext)_localctx).ret.lg ; System.out.println("start "+_localctx.lg); 
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

	public static class NbbinContext extends ParserRuleContext {
		public float lg;
		public int t;
		public NbbinContext nbbin1;
		public SuitenbbinContext suitenbbin;
		public SuitenbbinContext suitenbbin() {
			return getRuleContext(SuitenbbinContext.class,0);
		}
		public NbbinContext nbbin() {
			return getRuleContext(NbbinContext.class,0);
		}
		public NbbinContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nbbin; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof nbbinListener ) ((nbbinListener)listener).enterNbbin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof nbbinListener ) ((nbbinListener)listener).exitNbbin(this);
		}
	}

	public final NbbinContext nbbin() throws RecognitionException {
		return nbbin(0);
	}

	private NbbinContext nbbin(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		NbbinContext _localctx = new NbbinContext(_ctx, _parentState);
		NbbinContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_nbbin, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(14);
			((NbbinContext)_localctx).suitenbbin = suitenbbin();
			 ((NbbinContext)_localctx).lg = ((NbbinContext)_localctx).suitenbbin.lg; ((NbbinContext)_localctx).t =  1; System.out.println("nbbin "+_localctx.lg+" t "+_localctx.t);
			}
			_ctx.stop = _input.LT(-1);
			setState(23);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new NbbinContext(_parentctx, _parentState);
					_localctx.nbbin1 = _prevctx;
					_localctx.nbbin1 = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_nbbin);
					setState(17);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(18);
					((NbbinContext)_localctx).suitenbbin = suitenbbin();
					 ((NbbinContext)_localctx).lg =  2*((NbbinContext)_localctx).nbbin1.lg+((NbbinContext)_localctx).suitenbbin.lg ; ((NbbinContext)_localctx).t =  ((NbbinContext)_localctx).nbbin1.t+1; System.out.println("==nbbin2 "+_localctx.lg+" = "+2*((NbbinContext)_localctx).nbbin1.lg+"+"+((NbbinContext)_localctx).suitenbbin.lg+" t "+_localctx.t);
					}
					} 
				}
				setState(25);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class SuitenbbinContext extends ParserRuleContext {
		public int lg;
		public TerminalNode F() { return getToken(nbbinParser.F, 0); }
		public TerminalNode V() { return getToken(nbbinParser.V, 0); }
		public SuitenbbinContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_suitenbbin; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof nbbinListener ) ((nbbinListener)listener).enterSuitenbbin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof nbbinListener ) ((nbbinListener)listener).exitSuitenbbin(this);
		}
	}

	public final SuitenbbinContext suitenbbin() throws RecognitionException {
		SuitenbbinContext _localctx = new SuitenbbinContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_suitenbbin);
		try {
			setState(30);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case F:
				enterOuterAlt(_localctx, 1);
				{
				setState(26);
				match(F);
				 ((SuitenbbinContext)_localctx).lg =  0;System.out.println("suitenbbin 0");
				}
				break;
			case V:
				enterOuterAlt(_localctx, 2);
				{
				setState(28);
				match(V);
				 ((SuitenbbinContext)_localctx).lg =  1;System.out.println("suitenbbin 1");
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

	public static class RetContext extends ParserRuleContext {
		public float lg;
		public NbbinContext nbbin;
		public NbbinContext nbbin() {
			return getRuleContext(NbbinContext.class,0);
		}
		public RetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ret; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof nbbinListener ) ((nbbinListener)listener).enterRet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof nbbinListener ) ((nbbinListener)listener).exitRet(this);
		}
	}

	public final RetContext ret() throws RecognitionException {
		RetContext _localctx = new RetContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_ret);
		try {
			setState(37);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EOF:
				enterOuterAlt(_localctx, 1);
				{
				 ((RetContext)_localctx).lg =  0; System.out.println("ret " +_localctx.lg );
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				setState(33);
				match(T__0);
				setState(34);
				((RetContext)_localctx).nbbin = nbbin(0);
				 ((RetContext)_localctx).lg =  ((RetContext)_localctx).nbbin.lg /  (float)Math.pow(2,((RetContext)_localctx).nbbin.t); System.out.println("ret2 " +_localctx.lg +" c "+((RetContext)_localctx).nbbin.lg +" /p " + (float)Math.pow(2,((RetContext)_localctx).nbbin.t));
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return nbbin_sempred((NbbinContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean nbbin_sempred(NbbinContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\7*\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\7\3\30\n\3\f\3\16\3\33\13\3\3\4\3\4\3\4\3\4\5\4!\n\4\3\5\3\5\3\5\3\5"+
		"\3\5\5\5(\n\5\3\5\2\3\4\6\2\4\6\b\2\2\2(\2\n\3\2\2\2\4\17\3\2\2\2\6 \3"+
		"\2\2\2\b\'\3\2\2\2\n\13\5\4\3\2\13\f\5\b\5\2\f\r\7\2\2\3\r\16\b\2\1\2"+
		"\16\3\3\2\2\2\17\20\b\3\1\2\20\21\5\6\4\2\21\22\b\3\1\2\22\31\3\2\2\2"+
		"\23\24\f\3\2\2\24\25\5\6\4\2\25\26\b\3\1\2\26\30\3\2\2\2\27\23\3\2\2\2"+
		"\30\33\3\2\2\2\31\27\3\2\2\2\31\32\3\2\2\2\32\5\3\2\2\2\33\31\3\2\2\2"+
		"\34\35\7\4\2\2\35!\b\4\1\2\36\37\7\5\2\2\37!\b\4\1\2 \34\3\2\2\2 \36\3"+
		"\2\2\2!\7\3\2\2\2\"(\b\5\1\2#$\7\3\2\2$%\5\4\3\2%&\b\5\1\2&(\3\2\2\2\'"+
		"\"\3\2\2\2\'#\3\2\2\2(\t\3\2\2\2\5\31 \'";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}