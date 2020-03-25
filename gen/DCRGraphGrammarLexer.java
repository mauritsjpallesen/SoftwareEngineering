// Generated from C:/git/SoftwareEngineering/src/main/antlr4/dk/ku/di/oodcr/parser/dcr\DCRGraphGrammar.g4 by ANTLR 4.8

import dk.ku.di.oodcr.graph.*;
import dk.ku.di.oodcr.parser.ast.*;
import java.util.*;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DCRGraphGrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, ONEorZERO=13, ID=14, CHAR=15, INT=16, NEWLINE=17, 
		WS=18;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "ONEorZERO", "ID", "CHAR", "INT", "NEWLINE", 
			"WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "','", "'('", "')'", "'{'", "'}'", "'-->*'", "'--><>'", "'*-->'", 
			"'-->+'", "'-->%'", "'<'", "'>'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "ONEorZERO", "ID", "CHAR", "INT", "NEWLINE", "WS"
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


	    HashMap<String,List<SimpleEntry<RelationshipType,String>>> srcToTrgts = new HashMap<>();
	    HashMap<String, Event> allEvents = new HashMap<String, Event>();


	public DCRGraphGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "DCRGraphGrammar.g4"; }

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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\24h\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13"+
		"\3\13\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\6\17T\n\17\r"+
		"\17\16\17U\3\20\6\20Y\n\20\r\20\16\20Z\3\21\6\21^\n\21\r\21\16\21_\3\22"+
		"\5\22c\n\22\3\22\3\22\3\23\3\23\2\2\24\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\3\2\4\5\2C\\aa"+
		"c|\4\2\13\13\"\"\2l\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2"+
		"\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3"+
		"\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2"+
		"\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\3\'\3\2\2\2\5)\3\2\2\2\7+\3\2\2\2"+
		"\t-\3\2\2\2\13/\3\2\2\2\r\61\3\2\2\2\17\66\3\2\2\2\21<\3\2\2\2\23A\3\2"+
		"\2\2\25F\3\2\2\2\27K\3\2\2\2\31M\3\2\2\2\33O\3\2\2\2\35S\3\2\2\2\37X\3"+
		"\2\2\2!]\3\2\2\2#b\3\2\2\2%f\3\2\2\2\'(\7.\2\2(\4\3\2\2\2)*\7*\2\2*\6"+
		"\3\2\2\2+,\7+\2\2,\b\3\2\2\2-.\7}\2\2.\n\3\2\2\2/\60\7\177\2\2\60\f\3"+
		"\2\2\2\61\62\7/\2\2\62\63\7/\2\2\63\64\7@\2\2\64\65\7,\2\2\65\16\3\2\2"+
		"\2\66\67\7/\2\2\678\7/\2\289\7@\2\29:\7>\2\2:;\7@\2\2;\20\3\2\2\2<=\7"+
		",\2\2=>\7/\2\2>?\7/\2\2?@\7@\2\2@\22\3\2\2\2AB\7/\2\2BC\7/\2\2CD\7@\2"+
		"\2DE\7-\2\2E\24\3\2\2\2FG\7/\2\2GH\7/\2\2HI\7@\2\2IJ\7\'\2\2J\26\3\2\2"+
		"\2KL\7>\2\2L\30\3\2\2\2MN\7@\2\2N\32\3\2\2\2OP\4\62\63\2P\34\3\2\2\2Q"+
		"T\5\37\20\2RT\5!\21\2SQ\3\2\2\2SR\3\2\2\2TU\3\2\2\2US\3\2\2\2UV\3\2\2"+
		"\2V\36\3\2\2\2WY\t\2\2\2XW\3\2\2\2YZ\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[ \3\2"+
		"\2\2\\^\4\62;\2]\\\3\2\2\2^_\3\2\2\2_]\3\2\2\2_`\3\2\2\2`\"\3\2\2\2ac"+
		"\7\17\2\2ba\3\2\2\2bc\3\2\2\2cd\3\2\2\2de\7\f\2\2e$\3\2\2\2fg\t\3\2\2"+
		"g&\3\2\2\2\b\2SUZ_b\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}