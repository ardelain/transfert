// Generated from Calc.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CalcParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, NEWLINE=7, COMMNENT=8, 
		WS=9, ENTIER=10, UNMATCH=11;
	public static final int
		RULE_start = 0, RULE_expr = 1, RULE_somExpr = 2, RULE_multExpr = 3, RULE_opExpr = 4;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "expr", "somExpr", "multExpr", "opExpr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'+'", "'-'", "'*'", "'/'", "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, "NEWLINE", "COMMNENT", "WS", 
			"ENTIER", "UNMATCH"
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
	public String getGrammarFileName() { return "Calc.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	  
	    private int evalexpr (int x, String op, int y) {
		System.out.println("evalexpr x"+x+" op"+op+" y "+y);
	        if ( op.equals("*") ){
	            return x*y;
	        } else if ( op.equals("+") ){
	            return x+y;
	        } else {
	           System.err.println("Opérateur arithmétique inconnu : '"+op+"'");
	           throw new IllegalArgumentException("Opérateur arithmétique inconnu : '"+op+"'");
	        }
	    }
	        

	public CalcParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class StartContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode EOF() { return getToken(CalcParser.EOF, 0); }
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalcListener ) ((CalcListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalcListener ) ((CalcListener)listener).exitStart(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(10);
			expr();
			setState(11);
			match(EOF);
			System.out.println("HALT ");
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
		public double val;
		public SomExprContext exp;
		public SomExprContext somExpr() {
			return getRuleContext(SomExprContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalcListener ) ((CalcListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalcListener ) ((CalcListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(14);
			((ExprContext)_localctx).exp = somExpr();
			((ExprContext)_localctx).val =  ((ExprContext)_localctx).exp.val;System.out.println("WRITE ");
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

	public static class SomExprContext extends ParserRuleContext {
		public double val;
		public MultExprContext m1;
		public MultExprContext m2;
		public List<MultExprContext> multExpr() {
			return getRuleContexts(MultExprContext.class);
		}
		public MultExprContext multExpr(int i) {
			return getRuleContext(MultExprContext.class,i);
		}
		public SomExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_somExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalcListener ) ((CalcListener)listener).enterSomExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalcListener ) ((CalcListener)listener).exitSomExpr(this);
		}
	}

	public final SomExprContext somExpr() throws RecognitionException {
		SomExprContext _localctx = new SomExprContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_somExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(17);
			((SomExprContext)_localctx).m1 = multExpr();
			((SomExprContext)_localctx).val =   ((SomExprContext)_localctx).m1.val;
			setState(29);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0 || _la==T__1) {
				{
				setState(27);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__0:
					{
					setState(19);
					match(T__0);
					setState(20);
					((SomExprContext)_localctx).m2 = multExpr();
					_localctx.val += ((SomExprContext)_localctx).m2.val;System.out.println("ADD ");
					}
					break;
				case T__1:
					{
					setState(23);
					match(T__1);
					setState(24);
					((SomExprContext)_localctx).m2 = multExpr();
					_localctx.val -= ((SomExprContext)_localctx).m2.val;System.out.println("SUB ");
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(31);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	public static class MultExprContext extends ParserRuleContext {
		public double val;
		public OpExprContext a1;
		public OpExprContext a2;
		public List<OpExprContext> opExpr() {
			return getRuleContexts(OpExprContext.class);
		}
		public OpExprContext opExpr(int i) {
			return getRuleContext(OpExprContext.class,i);
		}
		public MultExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalcListener ) ((CalcListener)listener).enterMultExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalcListener ) ((CalcListener)listener).exitMultExpr(this);
		}
	}

	public final MultExprContext multExpr() throws RecognitionException {
		MultExprContext _localctx = new MultExprContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_multExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			((MultExprContext)_localctx).a1 = opExpr();
			((MultExprContext)_localctx).val =   ((MultExprContext)_localctx).a1.val;
			setState(44);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2 || _la==T__3) {
				{
				setState(42);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__2:
					{
					setState(34);
					match(T__2);
					setState(35);
					((MultExprContext)_localctx).a2 = opExpr();
					_localctx.val *= ((MultExprContext)_localctx).a2.val;System.out.println("MUL ");
					}
					break;
				case T__3:
					{
					setState(38);
					match(T__3);
					setState(39);
					((MultExprContext)_localctx).a2 = opExpr();
					_localctx.val /= ((MultExprContext)_localctx).a2.val;System.out.println("DIV ");
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(46);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	public static class OpExprContext extends ParserRuleContext {
		public double val;
		public Token n;
		public SomExprContext exp;
		public TerminalNode ENTIER() { return getToken(CalcParser.ENTIER, 0); }
		public SomExprContext somExpr() {
			return getRuleContext(SomExprContext.class,0);
		}
		public OpExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalcListener ) ((CalcListener)listener).enterOpExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalcListener ) ((CalcListener)listener).exitOpExpr(this);
		}
	}

	public final OpExprContext opExpr() throws RecognitionException {
		OpExprContext _localctx = new OpExprContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_opExpr);
		try {
			setState(54);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ENTIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(47);
				((OpExprContext)_localctx).n = match(ENTIER);
				((OpExprContext)_localctx).val =  Double.parseDouble((((OpExprContext)_localctx).n!=null?((OpExprContext)_localctx).n.getText():null));System.out.println("PUSHI "+_localctx.val);
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(49);
				match(T__4);
				setState(50);
				((OpExprContext)_localctx).exp = somExpr();
				setState(51);
				match(T__5);
				((OpExprContext)_localctx).val =  ((OpExprContext)_localctx).exp.val;
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\r;\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\7\4\36\n\4\f\4\16\4!\13\4\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\7\5-\n\5\f\5\16\5\60\13\5\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\5\69\n\6\3\6\2\2\7\2\4\6\b\n\2\2\2:\2\f\3\2\2\2\4\20\3\2\2\2\6\23"+
		"\3\2\2\2\b\"\3\2\2\2\n8\3\2\2\2\f\r\5\4\3\2\r\16\7\2\2\3\16\17\b\2\1\2"+
		"\17\3\3\2\2\2\20\21\5\6\4\2\21\22\b\3\1\2\22\5\3\2\2\2\23\24\5\b\5\2\24"+
		"\37\b\4\1\2\25\26\7\3\2\2\26\27\5\b\5\2\27\30\b\4\1\2\30\36\3\2\2\2\31"+
		"\32\7\4\2\2\32\33\5\b\5\2\33\34\b\4\1\2\34\36\3\2\2\2\35\25\3\2\2\2\35"+
		"\31\3\2\2\2\36!\3\2\2\2\37\35\3\2\2\2\37 \3\2\2\2 \7\3\2\2\2!\37\3\2\2"+
		"\2\"#\5\n\6\2#.\b\5\1\2$%\7\5\2\2%&\5\n\6\2&\'\b\5\1\2\'-\3\2\2\2()\7"+
		"\6\2\2)*\5\n\6\2*+\b\5\1\2+-\3\2\2\2,$\3\2\2\2,(\3\2\2\2-\60\3\2\2\2."+
		",\3\2\2\2./\3\2\2\2/\t\3\2\2\2\60.\3\2\2\2\61\62\7\f\2\2\629\b\6\1\2\63"+
		"\64\7\7\2\2\64\65\5\6\4\2\65\66\7\b\2\2\66\67\b\6\1\2\679\3\2\2\28\61"+
		"\3\2\2\28\63\3\2\2\29\13\3\2\2\2\7\35\37,.8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}