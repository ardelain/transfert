// Generated from Calculette2.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Calculette2Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, NEWLINE=5, WS=6, ENTIER=7, UNMATCH=8;
	public static final int
		RULE_start = 0, RULE_expr = 1;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "expr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'*'", "'/'", "'+'", "'-'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "NEWLINE", "WS", "ENTIER", "UNMATCH"
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
	public String getGrammarFileName() { return "Calculette2.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }



	    private int evalexpr (int x, String op, int y) {
	        if ( op.equals("*") ){
	            return x*y;
	        } else if ( op.equals("+") ){
	            return x+y;
	        } else {
	           System.err.println("Opérateur arithmétique inconnu : '"+op+"'");
	           throw new IllegalArgumentException("Opérateur arithmétique inconnu : '"+op+"'");
	        }
	    }
	        

	public Calculette2Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class StartContext extends ParserRuleContext {
		public String result;
		public ExprContext expr;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode EOF() { return getToken(Calculette2Parser.EOF, 0); }
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Calculette2Listener ) ((Calculette2Listener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Calculette2Listener ) ((Calculette2Listener)listener).exitStart(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4);
			((StartContext)_localctx).expr = expr(0);
			setState(5);
			match(EOF);
			System.out.println(((StartContext)_localctx).expr.result + "HALT  \n");
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

	public static class ExprContext extends ParserRuleContext {
		public String result;
		public ExprContext a;
		public Token ENTIER;
		public ExprContext b;
		public TerminalNode ENTIER() { return getToken(Calculette2Parser.ENTIER, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Calculette2Listener ) ((Calculette2Listener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Calculette2Listener ) ((Calculette2Listener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(9);
			((ExprContext)_localctx).ENTIER = match(ENTIER);
			((ExprContext)_localctx).result =  "PUSHI" + (((ExprContext)_localctx).ENTIER!=null?Integer.valueOf(((ExprContext)_localctx).ENTIER.getText()):0);
			}
			_ctx.stop = _input.LT(-1);
			setState(34);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(32);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(12);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(13);
						match(T__0);
						setState(14);
						((ExprContext)_localctx).b = expr(6);
						((ExprContext)_localctx).result =  ((ExprContext)_localctx).a.result + "\n" + ((ExprContext)_localctx).b.result +"\n" + "MUL" + "\n";
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(17);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(18);
						match(T__1);
						setState(19);
						((ExprContext)_localctx).b = expr(5);
						((ExprContext)_localctx).result =  ((ExprContext)_localctx).a.result + "\n" + ((ExprContext)_localctx).b.result +"\n" + "DIV" + "\n";
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(22);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(23);
						match(T__2);
						setState(24);
						((ExprContext)_localctx).b = expr(4);
						((ExprContext)_localctx).result =  ((ExprContext)_localctx).a.result + "\n" + ((ExprContext)_localctx).b.result +"\n" + "ADD" + "\n";
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(27);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(28);
						match(T__3);
						setState(29);
						((ExprContext)_localctx).b = expr(3);
						((ExprContext)_localctx).result =  ((ExprContext)_localctx).a.result + "\n" + ((ExprContext)_localctx).b.result +"\n" + "SUB" + "\n";
						}
						break;
					}
					} 
				}
				setState(36);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		case 1:
			return precpred(_ctx, 4);
		case 2:
			return precpred(_ctx, 3);
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\n(\4\2\t\2\4\3\t"+
		"\3\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3#\n\3\f\3\16\3&\13\3\3"+
		"\3\2\3\4\4\2\4\2\2\2)\2\6\3\2\2\2\4\n\3\2\2\2\6\7\5\4\3\2\7\b\7\2\2\3"+
		"\b\t\b\2\1\2\t\3\3\2\2\2\n\13\b\3\1\2\13\f\7\t\2\2\f\r\b\3\1\2\r$\3\2"+
		"\2\2\16\17\f\7\2\2\17\20\7\3\2\2\20\21\5\4\3\b\21\22\b\3\1\2\22#\3\2\2"+
		"\2\23\24\f\6\2\2\24\25\7\4\2\2\25\26\5\4\3\7\26\27\b\3\1\2\27#\3\2\2\2"+
		"\30\31\f\5\2\2\31\32\7\5\2\2\32\33\5\4\3\6\33\34\b\3\1\2\34#\3\2\2\2\35"+
		"\36\f\4\2\2\36\37\7\6\2\2\37 \5\4\3\5 !\b\3\1\2!#\3\2\2\2\"\16\3\2\2\2"+
		"\"\23\3\2\2\2\"\30\3\2\2\2\"\35\3\2\2\2#&\3\2\2\2$\"\3\2\2\2$%\3\2\2\2"+
		"%\5\3\2\2\2&$\3\2\2\2\4\"$";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}