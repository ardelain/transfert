// Generated from JetonsJava.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class JetonsJava extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		OPERATEUR=1, MOTCLE=2, IDENTIFIANT=3, NOMBRE=4, WHITE_SPACE=5, UNMATCH=6, 
		ACO=7, COMMENTAIRE=8, COMMENTAIRE_MULTI=9;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"OPERATEUR", "MOTCLE", "IDENTIFIANT", "NOMBRE", "WHITE_SPACE", "UNMATCH", 
			"ACO", "COMMENTAIRE", "COMMENTAIRE_MULTI"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "OPERATEUR", "MOTCLE", "IDENTIFIANT", "NOMBRE", "WHITE_SPACE", 
			"UNMATCH", "ACO", "COMMENTAIRE", "COMMENTAIRE_MULTI"
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


	public JetonsJava(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "JetonsJava.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 1:
			MOTCLE_action((RuleContext)_localctx, actionIndex);
			break;
		case 2:
			IDENTIFIANT_action((RuleContext)_localctx, actionIndex);
			break;
		case 3:
			NOMBRE_action((RuleContext)_localctx, actionIndex);
			break;
		case 6:
			ACO_action((RuleContext)_localctx, actionIndex);
			break;
		case 7:
			COMMENTAIRE_action((RuleContext)_localctx, actionIndex);
			break;
		case 8:
			COMMENTAIRE_MULTI_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void MOTCLE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			 System.out.print("\n[motclé : "+getText()+" ]"); 
			break;
		}
	}
	private void IDENTIFIANT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:
			 System.out.print(" [ident : "+getText()+" ]"); 
			break;
		}
	}
	private void NOMBRE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2:
			 System.out.print(" [NOMBRE : "+getText()+" ]"); 
			break;
		}
	}
	private void ACO_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3:
			 System.out.print("\t"); 
			break;
		}
	}
	private void COMMENTAIRE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 4:
			 System.out.print(" \n[COMENTAIRE : "+getText()+" ]"); 
			break;
		}
	}
	private void COMMENTAIRE_MULTI_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 5:
			 System.out.print("\n [COMMENTAIRE_MULTI : "+getText()+" ]"); 
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\13\u0086\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2 \n\2\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\5\3P\n\3\3\3\3\3\3\4\3\4\7\4V\n\4\f\4\16\4Y\13"+
		"\4\3\4\3\4\3\5\6\5^\n\5\r\5\16\5_\3\5\3\5\3\6\6\6e\n\6\r\6\16\6f\3\7\3"+
		"\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\7\tr\n\t\f\t\16\tu\13\t\3\t\3\t\3\n\3\n"+
		"\3\n\3\n\7\n}\n\n\f\n\16\n\u0080\13\n\3\n\3\n\3\n\3\n\3\n\3~\2\13\3\3"+
		"\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\3\2\6\5\2C\\aac|\6\2\62;C\\aac|"+
		"\5\2\13\f\17\17\"\"\4\2\13\f\17\17\2\u0097\2\3\3\2\2\2\2\5\3\2\2\2\2\7"+
		"\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2"+
		"\2\2\23\3\2\2\2\3\37\3\2\2\2\5O\3\2\2\2\7S\3\2\2\2\t]\3\2\2\2\13d\3\2"+
		"\2\2\rh\3\2\2\2\17j\3\2\2\2\21m\3\2\2\2\23x\3\2\2\2\25 \7>\2\2\26\27\7"+
		">\2\2\27 \7?\2\2\30 \7@\2\2\31\32\7@\2\2\32 \7?\2\2\33\34\7?\2\2\34 \7"+
		"?\2\2\35\36\7#\2\2\36 \7?\2\2\37\25\3\2\2\2\37\26\3\2\2\2\37\30\3\2\2"+
		"\2\37\31\3\2\2\2\37\33\3\2\2\2\37\35\3\2\2\2 \4\3\2\2\2!\"\7d\2\2\"#\7"+
		"t\2\2#$\7g\2\2$%\7c\2\2%P\7m\2\2&\'\7e\2\2\'(\7n\2\2()\7c\2\2)*\7u\2\2"+
		"*P\7u\2\2+,\7f\2\2,-\7q\2\2-.\7w\2\2./\7d\2\2/\60\7n\2\2\60P\7g\2\2\61"+
		"\62\7g\2\2\62\63\7n\2\2\63\64\7u\2\2\64P\7g\2\2\65\66\7k\2\2\66P\7h\2"+
		"\2\678\7k\2\289\7o\2\29:\7r\2\2:;\7q\2\2;<\7t\2\2<P\7v\2\2=>\7r\2\2>?"+
		"\7w\2\2?@\7d\2\2@A\7n\2\2AB\7k\2\2BP\7e\2\2CD\7u\2\2DE\7v\2\2EF\7c\2\2"+
		"FG\7v\2\2GH\7k\2\2HP\7e\2\2IJ\7v\2\2JK\7j\2\2KL\7t\2\2LM\7q\2\2MN\7y\2"+
		"\2NP\7u\2\2O!\3\2\2\2O&\3\2\2\2O+\3\2\2\2O\61\3\2\2\2O\65\3\2\2\2O\67"+
		"\3\2\2\2O=\3\2\2\2OC\3\2\2\2OI\3\2\2\2PQ\3\2\2\2QR\b\3\2\2R\6\3\2\2\2"+
		"SW\t\2\2\2TV\t\3\2\2UT\3\2\2\2VY\3\2\2\2WU\3\2\2\2WX\3\2\2\2XZ\3\2\2\2"+
		"YW\3\2\2\2Z[\b\4\3\2[\b\3\2\2\2\\^\4\62;\2]\\\3\2\2\2^_\3\2\2\2_]\3\2"+
		"\2\2_`\3\2\2\2`a\3\2\2\2ab\b\5\4\2b\n\3\2\2\2ce\t\4\2\2dc\3\2\2\2ef\3"+
		"\2\2\2fd\3\2\2\2fg\3\2\2\2g\f\3\2\2\2hi\13\2\2\2i\16\3\2\2\2jk\7}\2\2"+
		"kl\b\b\5\2l\20\3\2\2\2mn\7\61\2\2no\7\61\2\2os\3\2\2\2pr\n\5\2\2qp\3\2"+
		"\2\2ru\3\2\2\2sq\3\2\2\2st\3\2\2\2tv\3\2\2\2us\3\2\2\2vw\b\t\6\2w\22\3"+
		"\2\2\2xy\7\61\2\2yz\7,\2\2z~\3\2\2\2{}\13\2\2\2|{\3\2\2\2}\u0080\3\2\2"+
		"\2~\177\3\2\2\2~|\3\2\2\2\177\u0081\3\2\2\2\u0080~\3\2\2\2\u0081\u0082"+
		"\7,\2\2\u0082\u0083\7\61\2\2\u0083\u0084\3\2\2\2\u0084\u0085\b\n\7\2\u0085"+
		"\24\3\2\2\2\n\2\37OW_fs~\b\3\3\2\3\4\3\3\5\4\3\b\5\3\t\6\3\n\7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}