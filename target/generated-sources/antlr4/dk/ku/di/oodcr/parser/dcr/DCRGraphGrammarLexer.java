// Generated from dk\ku\di\oodcr\parser\dcr\DCRGraphGrammar.g4 by ANTLR 4.3
package dk.ku.di.oodcr.parser.dcr;

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
	static { RuntimeMetaData.checkVersion("4.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__11=1, T__10=2, T__9=3, T__8=4, T__7=5, T__6=6, T__5=7, T__4=8, T__3=9, 
		T__2=10, T__1=11, T__0=12, ONEorZERO=13, ID=14, CHAR=15, INT=16, NEWLINE=17, 
		WS=18;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'"
	};
	public static final String[] ruleNames = {
		"T__11", "T__10", "T__9", "T__8", "T__7", "T__6", "T__5", "T__4", "T__3", 
		"T__2", "T__1", "T__0", "ONEorZERO", "ID", "CHAR", "INT", "NEWLINE", "WS"
	};


	    HashMap<String,List<SimpleEntry<RelationshipType,String>>> srcToTrgts = new HashMap<>();
	    HashMap<String, Event> allEvents = new HashMap<String, Event>();


	public DCRGraphGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "DCRGraphGrammar.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\24h\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3"+
		"\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\6\17T\n\17\r\17\16"+
		"\17U\3\20\6\20Y\n\20\r\20\16\20Z\3\21\6\21^\n\21\r\21\16\21_\3\22\5\22"+
		"c\n\22\3\22\3\22\3\23\3\23\2\2\24\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23"+
		"\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\3\2\4\4\2C\\c|\4\2\13"+
		"\13\"\"l\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2"+
		"\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\3\'\3\2\2\2\5,\3\2\2\2\7\61\3\2\2\2\t\67\3\2"+
		"\2\2\13<\3\2\2\2\r>\3\2\2\2\17C\3\2\2\2\21E\3\2\2\2\23G\3\2\2\2\25I\3"+
		"\2\2\2\27K\3\2\2\2\31M\3\2\2\2\33O\3\2\2\2\35S\3\2\2\2\37X\3\2\2\2!]\3"+
		"\2\2\2#b\3\2\2\2%f\3\2\2\2\'(\7/\2\2()\7/\2\2)*\7@\2\2*+\7-\2\2+\4\3\2"+
		"\2\2,-\7,\2\2-.\7/\2\2./\7/\2\2/\60\7@\2\2\60\6\3\2\2\2\61\62\7/\2\2\62"+
		"\63\7/\2\2\63\64\7@\2\2\64\65\7>\2\2\65\66\7@\2\2\66\b\3\2\2\2\678\7/"+
		"\2\289\7/\2\29:\7@\2\2:;\7,\2\2;\n\3\2\2\2<=\7*\2\2=\f\3\2\2\2>?\7/\2"+
		"\2?@\7/\2\2@A\7@\2\2AB\7\'\2\2B\16\3\2\2\2CD\7+\2\2D\20\3\2\2\2EF\7}\2"+
		"\2F\22\3\2\2\2GH\7>\2\2H\24\3\2\2\2IJ\7.\2\2J\26\3\2\2\2KL\7\177\2\2L"+
		"\30\3\2\2\2MN\7@\2\2N\32\3\2\2\2OP\4\62\63\2P\34\3\2\2\2QT\5\37\20\2R"+
		"T\5!\21\2SQ\3\2\2\2SR\3\2\2\2TU\3\2\2\2US\3\2\2\2UV\3\2\2\2V\36\3\2\2"+
		"\2WY\t\2\2\2XW\3\2\2\2YZ\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[ \3\2\2\2\\^\4\62"+
		";\2]\\\3\2\2\2^_\3\2\2\2_]\3\2\2\2_`\3\2\2\2`\"\3\2\2\2ac\7\17\2\2ba\3"+
		"\2\2\2bc\3\2\2\2cd\3\2\2\2de\7\f\2\2e$\3\2\2\2fg\t\3\2\2g&\3\2\2\2\b\2"+
		"SUZ_b\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}