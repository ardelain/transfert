// Generated from CalculetteC.g4 by ANTLR 4.7.2
 import java.util.HashMap;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CalculetteCParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, NEWLINE=9, 
		WS=10, ENTIER=11, TYPE=12, IDENTIFIANT=13, UNMATCH=14;
	public static final int
		RULE_start = 0, RULE_calcul = 1, RULE_expr = 2, RULE_decl = 3, RULE_instruction = 4, 
		RULE_assignation = 5, RULE_finInstruction = 6;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "calcul", "expr", "decl", "instruction", "assignation", "finInstruction"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'*'", "'/'", "'+'", "'-'", "'='", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, "NEWLINE", "WS", 
			"ENTIER", "TYPE", "IDENTIFIANT", "UNMATCH"
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
	public String getGrammarFileName() { return "CalculetteC.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	 HashMap<String, Integer> memory = new HashMap<String, Integer>();

		int gp ;
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

	public CalculetteCParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class StartContext extends ParserRuleContext {
		public String resultat;
		public CalculContext calcul() {
			return getRuleContext(CalculContext.class,0);
		}
		public TerminalNode EOF() { return getToken(CalculetteCParser.EOF, 0); }
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteCListener ) ((CalculetteCListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteCListener ) ((CalculetteCListener)listener).exitStart(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(14);
			calcul();
			setState(15);
			match(EOF);
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

	public static class CalculContext extends ParserRuleContext {
		public String code;
		public DeclContext decl;
		public InstructionContext instruction;
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(CalculetteCParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CalculetteCParser.NEWLINE, i);
		}
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public CalculContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_calcul; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteCListener ) ((CalculetteCListener)listener).enterCalcul(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteCListener ) ((CalculetteCListener)listener).exitCalcul(this);
		}
	}

	public final CalculContext calcul() throws RecognitionException {
		CalculContext _localctx = new CalculContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_calcul);
		 ((CalculContext)_localctx).code =  new String(); 
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(22);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TYPE) {
				{
				{
				setState(17);
				((CalculContext)_localctx).decl = decl();
				 _localctx.code += ((CalculContext)_localctx).decl.code; 
				}
				}
				setState(24);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(28);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(25);
				match(NEWLINE);
				}
				}
				setState(30);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(36);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__7) | (1L << ENTIER) | (1L << IDENTIFIANT))) != 0)) {
				{
				{
				setState(31);
				((CalculContext)_localctx).instruction = instruction();
				 _localctx.code += ((CalculContext)_localctx).instruction.code; 
				}
				}
				setState(38);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			 _localctx.code += "  HALT\n"; 
			}
			_ctx.stop = _input.LT(-1);
			 System.out.println(_localctx.code); 
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
		public String resultat;
		public ExprContext a;
		public ExprContext expr;
		public Token ENTIER;
		public ExprContext b;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode ENTIER() { return getToken(CalculetteCParser.ENTIER, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteCListener ) ((CalculetteCListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteCListener ) ((CalculetteCListener)listener).exitExpr(this);
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
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				{
				setState(42);
				match(T__0);
				setState(43);
				((ExprContext)_localctx).expr = expr(0);
				setState(44);
				match(T__1);
				((ExprContext)_localctx).resultat =  ((ExprContext)_localctx).expr.resultat;
				}
				break;
			case ENTIER:
				{
				setState(47);
				((ExprContext)_localctx).ENTIER = match(ENTIER);
				 ((ExprContext)_localctx).resultat =  "PUSHI" + (((ExprContext)_localctx).ENTIER!=null?Integer.valueOf(((ExprContext)_localctx).ENTIER.getText()):0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(73);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(71);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(51);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(52);
						match(T__2);
						setState(53);
						((ExprContext)_localctx).b = ((ExprContext)_localctx).expr = expr(6);
						 ((ExprContext)_localctx).resultat =  ((ExprContext)_localctx).a.resultat  + "\n" + ((ExprContext)_localctx).b.resultat + "\n" + "MUL" + "\n";
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(56);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(57);
						match(T__3);
						setState(58);
						((ExprContext)_localctx).b = ((ExprContext)_localctx).expr = expr(5);
						 ((ExprContext)_localctx).resultat =  ((ExprContext)_localctx).a.resultat  + "\n" + ((ExprContext)_localctx).b.resultat + "\n" + "DIV" + "\n";
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(61);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(62);
						match(T__4);
						setState(63);
						((ExprContext)_localctx).b = ((ExprContext)_localctx).expr = expr(4);
						 ((ExprContext)_localctx).resultat =  ((ExprContext)_localctx).a.resultat  + "\n" + ((ExprContext)_localctx).b.resultat + "\n" + "ADD" + "\n";
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(66);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(67);
						match(T__5);
						setState(68);
						((ExprContext)_localctx).b = ((ExprContext)_localctx).expr = expr(3);
						 ((ExprContext)_localctx).resultat =  ((ExprContext)_localctx).a.resultat  + "\n" + ((ExprContext)_localctx).b.resultat + "\n" + "SUB" + "\n";
						}
						break;
					}
					} 
				}
				setState(75);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
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

	public static class DeclContext extends ParserRuleContext {
		public String code;
		public Token IDENTIFIANT;
		public TerminalNode TYPE() { return getToken(CalculetteCParser.TYPE, 0); }
		public TerminalNode IDENTIFIANT() { return getToken(CalculetteCParser.IDENTIFIANT, 0); }
		public FinInstructionContext finInstruction() {
			return getRuleContext(FinInstructionContext.class,0);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteCListener ) ((CalculetteCListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteCListener ) ((CalculetteCListener)listener).exitDecl(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			match(TYPE);
			setState(77);
			((DeclContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
			setState(78);
			finInstruction();

			            memory.put( (((DeclContext)_localctx).IDENTIFIANT!=null?((DeclContext)_localctx).IDENTIFIANT.getText():null), gp);
			            gp++;
			            
			            ((DeclContext)_localctx).code =  "PUSHI 0\n";
			        
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

	public static class InstructionContext extends ParserRuleContext {
		public String code;
		public ExprContext expr;
		public AssignationContext assignation;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public FinInstructionContext finInstruction() {
			return getRuleContext(FinInstructionContext.class,0);
		}
		public AssignationContext assignation() {
			return getRuleContext(AssignationContext.class,0);
		}
		public InstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteCListener ) ((CalculetteCListener)listener).enterInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteCListener ) ((CalculetteCListener)listener).exitInstruction(this);
		}
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_instruction);
		try {
			setState(92);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case ENTIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(81);
				((InstructionContext)_localctx).expr = expr(0);
				setState(82);
				finInstruction();
				 
				            ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).expr.resultat;
				        
				}
				break;
			case IDENTIFIANT:
				enterOuterAlt(_localctx, 2);
				{
				setState(85);
				((InstructionContext)_localctx).assignation = assignation();
				setState(86);
				finInstruction();
				 
				            ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).assignation.code;
				        
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 3);
				{
				setState(89);
				finInstruction();

				            ((InstructionContext)_localctx).code =  "\n";
				        
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

	public static class AssignationContext extends ParserRuleContext {
		public String code;
		public Token IDENTIFIANT;
		public ExprContext expr;
		public TerminalNode IDENTIFIANT() { return getToken(CalculetteCParser.IDENTIFIANT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteCListener ) ((CalculetteCListener)listener).enterAssignation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteCListener ) ((CalculetteCListener)listener).exitAssignation(this);
		}
	}

	public final AssignationContext assignation() throws RecognitionException {
		AssignationContext _localctx = new AssignationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_assignation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			((AssignationContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
			setState(95);
			match(T__6);
			setState(96);
			((AssignationContext)_localctx).expr = expr(0);
			  		
			        	/*if( memory.get( (((AssignationContext)_localctx).IDENTIFIANT!=null?((AssignationContext)_localctx).IDENTIFIANT.getText():null)) == null ){
			        	
			        		//System.out.println("cette variable n'existe pas!");
			        		System.out.println("ici!");
			        		System.exit(0); 
			        	}*/
			        	
			        	 ((AssignationContext)_localctx).code =  ((AssignationContext)_localctx).expr.resultat + "\n" + "STORG " + memory.get( (((AssignationContext)_localctx).IDENTIFIANT!=null?((AssignationContext)_localctx).IDENTIFIANT.getText():null));
			        
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

	public static class FinInstructionContext extends ParserRuleContext {
		public FinInstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_finInstruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteCListener ) ((CalculetteCListener)listener).enterFinInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteCListener ) ((CalculetteCListener)listener).exitFinInstruction(this);
		}
	}

	public final FinInstructionContext finInstruction() throws RecognitionException {
		FinInstructionContext _localctx = new FinInstructionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_finInstruction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			match(T__7);
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
		case 2:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\20h\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\2\3\3\3\3\3\3\7\3"+
		"\27\n\3\f\3\16\3\32\13\3\3\3\7\3\35\n\3\f\3\16\3 \13\3\3\3\3\3\3\3\7\3"+
		"%\n\3\f\3\16\3(\13\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\64\n"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\7\4J\n\4\f\4\16\4M\13\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6_\n\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3"+
		"\b\2\3\6\t\2\4\6\b\n\f\16\2\2\2j\2\20\3\2\2\2\4\30\3\2\2\2\6\63\3\2\2"+
		"\2\bN\3\2\2\2\n^\3\2\2\2\f`\3\2\2\2\16e\3\2\2\2\20\21\5\4\3\2\21\22\7"+
		"\2\2\3\22\3\3\2\2\2\23\24\5\b\5\2\24\25\b\3\1\2\25\27\3\2\2\2\26\23\3"+
		"\2\2\2\27\32\3\2\2\2\30\26\3\2\2\2\30\31\3\2\2\2\31\36\3\2\2\2\32\30\3"+
		"\2\2\2\33\35\7\13\2\2\34\33\3\2\2\2\35 \3\2\2\2\36\34\3\2\2\2\36\37\3"+
		"\2\2\2\37&\3\2\2\2 \36\3\2\2\2!\"\5\n\6\2\"#\b\3\1\2#%\3\2\2\2$!\3\2\2"+
		"\2%(\3\2\2\2&$\3\2\2\2&\'\3\2\2\2\')\3\2\2\2(&\3\2\2\2)*\b\3\1\2*\5\3"+
		"\2\2\2+,\b\4\1\2,-\7\3\2\2-.\5\6\4\2./\7\4\2\2/\60\b\4\1\2\60\64\3\2\2"+
		"\2\61\62\7\r\2\2\62\64\b\4\1\2\63+\3\2\2\2\63\61\3\2\2\2\64K\3\2\2\2\65"+
		"\66\f\7\2\2\66\67\7\5\2\2\678\5\6\4\b89\b\4\1\29J\3\2\2\2:;\f\6\2\2;<"+
		"\7\6\2\2<=\5\6\4\7=>\b\4\1\2>J\3\2\2\2?@\f\5\2\2@A\7\7\2\2AB\5\6\4\6B"+
		"C\b\4\1\2CJ\3\2\2\2DE\f\4\2\2EF\7\b\2\2FG\5\6\4\5GH\b\4\1\2HJ\3\2\2\2"+
		"I\65\3\2\2\2I:\3\2\2\2I?\3\2\2\2ID\3\2\2\2JM\3\2\2\2KI\3\2\2\2KL\3\2\2"+
		"\2L\7\3\2\2\2MK\3\2\2\2NO\7\16\2\2OP\7\17\2\2PQ\5\16\b\2QR\b\5\1\2R\t"+
		"\3\2\2\2ST\5\6\4\2TU\5\16\b\2UV\b\6\1\2V_\3\2\2\2WX\5\f\7\2XY\5\16\b\2"+
		"YZ\b\6\1\2Z_\3\2\2\2[\\\5\16\b\2\\]\b\6\1\2]_\3\2\2\2^S\3\2\2\2^W\3\2"+
		"\2\2^[\3\2\2\2_\13\3\2\2\2`a\7\17\2\2ab\7\t\2\2bc\5\6\4\2cd\b\7\1\2d\r"+
		"\3\2\2\2ef\7\n\2\2f\17\3\2\2\2\t\30\36&\63IK^";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}