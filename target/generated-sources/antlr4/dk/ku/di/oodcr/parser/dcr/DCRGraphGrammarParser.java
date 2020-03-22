// Generated from dk\ku\di\oodcr\parser\dcr\DCRGraphGrammar.g4 by ANTLR 4.3
package dk.ku.di.oodcr.parser.dcr;

import dk.ku.di.oodcr.graph.*;
import dk.ku.di.oodcr.parser.ast.*;
import java.util.*;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DCRGraphGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__11=1, T__10=2, T__9=3, T__8=4, T__7=5, T__6=6, T__5=7, T__4=8, T__3=9, 
		T__2=10, T__1=11, T__0=12, ONEorZERO=13, ID=14, CHAR=15, INT=16, NEWLINE=17, 
		WS=18;
	public static final String[] tokenNames = {
		"<INVALID>", "'-->+'", "'*-->'", "'--><>'", "'-->*'", "'('", "'-->%'", 
		"')'", "'{'", "'<'", "','", "'}'", "'>'", "ONEorZERO", "ID", "CHAR", "INT", 
		"NEWLINE", "WS"
	};
	public static final int
		RULE_graph = 0, RULE_eventz = 1, RULE_event = 2, RULE_relationships = 3, 
		RULE_relationship = 4, RULE_conditions = 5, RULE_milestones = 6, RULE_responses = 7, 
		RULE_includes = 8, RULE_excludes = 9, RULE_eventLabel = 10, RULE_idOneOrMore = 11, 
		RULE_idSeq = 12;
	public static final String[] ruleNames = {
		"graph", "eventz", "event", "relationships", "relationship", "conditions", 
		"milestones", "responses", "includes", "excludes", "eventLabel", "idOneOrMore", 
		"idSeq"
	};

	@Override
	public String getGrammarFileName() { return "DCRGraphGrammar.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    HashMap<String,List<SimpleEntry<RelationshipType,String>>> srcToTrgts = new HashMap<>();
	    HashMap<String, Event> allEvents = new HashMap<String, Event>();

	public DCRGraphGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class GraphContext extends ParserRuleContext {
		public DCRGraph value;
		public EventContext e;
		public EventzContext es;
		public TerminalNode WS(int i) {
			return getToken(DCRGraphGrammarParser.WS, i);
		}
		public EventzContext eventz() {
			return getRuleContext(EventzContext.class,0);
		}
		public List<TerminalNode> WS() { return getTokens(DCRGraphGrammarParser.WS); }
		public TerminalNode EOF() { return getToken(DCRGraphGrammarParser.EOF, 0); }
		public EventContext event() {
			return getRuleContext(EventContext.class,0);
		}
		public GraphContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_graph; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DCRGraphGrammarListener ) ((DCRGraphGrammarListener)listener).enterGraph(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DCRGraphGrammarListener ) ((DCRGraphGrammarListener)listener).exitGraph(this);
		}
	}

	public final GraphContext graph() throws RecognitionException {
		GraphContext _localctx = new GraphContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_graph);

		    ((GraphContext)_localctx).value =  new DCRGraph();

		int _la;
		try {
			setState(37);
			switch (_input.LA(1)) {
			case ID:
			case WS:
				enterOuterAlt(_localctx, 1);
				{
				setState(29);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(26); match(WS);
					}
					}
					setState(31);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(32); ((GraphContext)_localctx).e = event();
				setState(33); ((GraphContext)_localctx).es = eventz();

				            _localctx.value.addEvent(((GraphContext)_localctx).e.value);
				            ((GraphContext)_localctx).es.value.forEach(e -> _localctx.value.addEvent(e));


				            for (Entry<String, List<SimpleEntry<RelationshipType,String>>> srcTrgtsPair : srcToTrgts.entrySet()) {
				                Event sourceEvent = allEvents.get(srcTrgtsPair.getKey());
				                for (SimpleEntry<RelationshipType,String> relToTrgt  : srcTrgtsPair.getValue()) {
				                    RelationshipType relationshipType = relToTrgt.getKey();
				                    Event targetEvent = allEvents.get(relToTrgt.getValue());
				                    sourceEvent.addRelationship(relationshipType, targetEvent);
				                }
				            }
				        
				}
				break;
			case EOF:
				enterOuterAlt(_localctx, 2);
				{
				setState(36); match(EOF);
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

	public static class EventzContext extends ParserRuleContext {
		public List<Event> value;
		public EventContext e;
		public EventzContext ez;
		public TerminalNode WS(int i) {
			return getToken(DCRGraphGrammarParser.WS, i);
		}
		public EventzContext eventz() {
			return getRuleContext(EventzContext.class,0);
		}
		public List<TerminalNode> WS() { return getTokens(DCRGraphGrammarParser.WS); }
		public TerminalNode EOF() { return getToken(DCRGraphGrammarParser.EOF, 0); }
		public TerminalNode NEWLINE() { return getToken(DCRGraphGrammarParser.NEWLINE, 0); }
		public EventContext event() {
			return getRuleContext(EventContext.class,0);
		}
		public EventzContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eventz; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DCRGraphGrammarListener ) ((DCRGraphGrammarListener)listener).enterEventz(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DCRGraphGrammarListener ) ((DCRGraphGrammarListener)listener).exitEventz(this);
		}
	}

	public final EventzContext eventz() throws RecognitionException {
		EventzContext _localctx = new EventzContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_eventz);

		    ((EventzContext)_localctx).value =  new ArrayList<Event>();

		int _la;
		try {
			setState(58);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(39); match(T__2);
				setState(43);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(40); match(WS);
					}
					}
					setState(45);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(46); match(NEWLINE);
				setState(50);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(47); match(WS);
					}
					}
					setState(52);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(53); ((EventzContext)_localctx).e = event();
				setState(54); ((EventzContext)_localctx).ez = eventz();

				            _localctx.value.add(((EventzContext)_localctx).e.value);
				            _localctx.value.addAll(((EventzContext)_localctx).ez.value);
				        
				}
				break;
			case EOF:
				enterOuterAlt(_localctx, 2);
				{
				setState(57); match(EOF);
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

	public static class EventContext extends ParserRuleContext {
		public Event value;
		public Token ID;
		public EventLabelContext el;
		public Token ex;
		public Token in;
		public Token pen;
		public RelationshipsContext rs;
		public TerminalNode ID() { return getToken(DCRGraphGrammarParser.ID, 0); }
		public RelationshipsContext relationships() {
			return getRuleContext(RelationshipsContext.class,0);
		}
		public TerminalNode WS(int i) {
			return getToken(DCRGraphGrammarParser.WS, i);
		}
		public List<TerminalNode> ONEorZERO() { return getTokens(DCRGraphGrammarParser.ONEorZERO); }
		public TerminalNode ONEorZERO(int i) {
			return getToken(DCRGraphGrammarParser.ONEorZERO, i);
		}
		public List<TerminalNode> WS() { return getTokens(DCRGraphGrammarParser.WS); }
		public TerminalNode NEWLINE() { return getToken(DCRGraphGrammarParser.NEWLINE, 0); }
		public EventLabelContext eventLabel() {
			return getRuleContext(EventLabelContext.class,0);
		}
		public EventContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_event; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DCRGraphGrammarListener ) ((DCRGraphGrammarListener)listener).enterEvent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DCRGraphGrammarListener ) ((DCRGraphGrammarListener)listener).exitEvent(this);
		}
	}

	public final EventContext event() throws RecognitionException {
		EventContext _localctx = new EventContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_event);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(60); ((EventContext)_localctx).ID = match(ID);
			setState(64);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS) {
				{
				{
				setState(61); match(WS);
				}
				}
				setState(66);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(68);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(67); ((EventContext)_localctx).el = eventLabel();
				}
			}

			setState(70); match(T__7);
			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS) {
				{
				{
				setState(71); match(WS);
				}
				}
				setState(76);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(77); ((EventContext)_localctx).ex = match(ONEorZERO);
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS) {
				{
				{
				setState(78); match(WS);
				}
				}
				setState(83);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(84); match(T__2);
			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS) {
				{
				{
				setState(85); match(WS);
				}
				}
				setState(90);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(91); ((EventContext)_localctx).in = match(ONEorZERO);
			setState(95);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS) {
				{
				{
				setState(92); match(WS);
				}
				}
				setState(97);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(98); match(T__2);
			setState(102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS) {
				{
				{
				setState(99); match(WS);
				}
				}
				setState(104);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(105); ((EventContext)_localctx).pen = match(ONEorZERO);
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS) {
				{
				{
				setState(106); match(WS);
				}
				}
				setState(111);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(112); match(T__5);
			setState(116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS) {
				{
				{
				setState(113); match(WS);
				}
				}
				setState(118);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(135);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(119); match(T__4);
				setState(120); match(NEWLINE);
				setState(124);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(121); match(WS);
						}
						} 
					}
					setState(126);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
				}
				setState(127); ((EventContext)_localctx).rs = relationships();
				setState(128); match(T__1);
				setState(132);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(129); match(WS);
					}
					}
					setState(134);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}



			            ((EventContext)_localctx).value =  (_localctx.el == null) ? new Event((((EventContext)_localctx).ID!=null?((EventContext)_localctx).ID.getText():null)) : new Event((((EventContext)_localctx).ID!=null?((EventContext)_localctx).ID.getText():null), ((EventContext)_localctx).el.value);

			            _localctx.value.marking.executed = Integer.parseInt((((EventContext)_localctx).ex!=null?((EventContext)_localctx).ex.getText():null)) == 1;
			            _localctx.value.marking.included = Integer.parseInt((((EventContext)_localctx).in!=null?((EventContext)_localctx).in.getText():null)) == 1;
			            _localctx.value.marking.pending = Integer.parseInt((((EventContext)_localctx).pen!=null?((EventContext)_localctx).pen.getText():null)) == 1;

			            allEvents.put(_localctx.value.name, _localctx.value);

			            if (_localctx.rs != null) {
			                for (OneSidedRelationship rel : ((EventContext)_localctx).rs.value) {
			                    if (rel.getVertexType() == VertexType.TARGET) { // _localctx.value is source then
			                        srcToTrgts.putIfAbsent(_localctx.value.name, new ArrayList<SimpleEntry<RelationshipType,String>>());

			                        RelationshipType relType = rel.getRelationshipType();

			                        for (String target : rel.getVertexNames()) {
			                            srcToTrgts.get(_localctx.value.name).add(new SimpleEntry<RelationshipType,String>(relType, target));
			                        }

			                    } else { // _localctx.value is target then
			                        RelationshipType relType = rel.getRelationshipType();

			                        for (String source : rel.getVertexNames()) {
			                            srcToTrgts.putIfAbsent(source, new ArrayList<SimpleEntry<RelationshipType,String>>());

			                            srcToTrgts.get(source).add(new SimpleEntry<RelationshipType,String>(relType, _localctx.value.name));
			                        }
			                    }
			                }
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

	public static class RelationshipsContext extends ParserRuleContext {
		public List<OneSidedRelationship> value;
		public RelationshipContext r;
		public RelationshipsContext rs;
		public RelationshipsContext relationships() {
			return getRuleContext(RelationshipsContext.class,0);
		}
		public TerminalNode WS(int i) {
			return getToken(DCRGraphGrammarParser.WS, i);
		}
		public List<TerminalNode> WS() { return getTokens(DCRGraphGrammarParser.WS); }
		public TerminalNode NEWLINE() { return getToken(DCRGraphGrammarParser.NEWLINE, 0); }
		public RelationshipContext relationship() {
			return getRuleContext(RelationshipContext.class,0);
		}
		public RelationshipsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationships; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DCRGraphGrammarListener ) ((DCRGraphGrammarListener)listener).enterRelationships(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DCRGraphGrammarListener ) ((DCRGraphGrammarListener)listener).exitRelationships(this);
		}
	}

	public final RelationshipsContext relationships() throws RecognitionException {
		RelationshipsContext _localctx = new RelationshipsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_relationships);

		    ((RelationshipsContext)_localctx).value =  new ArrayList<OneSidedRelationship>();

		int _la;
		try {
			int _alt;
			setState(156);
			switch (_input.LA(1)) {
			case T__11:
			case T__10:
			case T__9:
			case T__8:
			case T__7:
			case T__6:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(139); ((RelationshipsContext)_localctx).r = relationship();
				setState(140); match(NEWLINE);
				setState(144);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(141); match(WS);
						}
						} 
					}
					setState(146);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
				}
				setState(147); ((RelationshipsContext)_localctx).rs = relationships();
				 _localctx.value.add(((RelationshipsContext)_localctx).r.value); _localctx.value.addAll(((RelationshipsContext)_localctx).rs.value); 
				}
				break;
			case T__1:
			case WS:
				enterOuterAlt(_localctx, 2);
				{
				setState(153);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(150); match(WS);
					}
					}
					setState(155);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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

	public static class RelationshipContext extends ParserRuleContext {
		public OneSidedRelationship value;
		public ConditionsContext c;
		public MilestonesContext m;
		public ResponsesContext r;
		public IncludesContext i;
		public ExcludesContext e;
		public ConditionsContext conditions() {
			return getRuleContext(ConditionsContext.class,0);
		}
		public ExcludesContext excludes() {
			return getRuleContext(ExcludesContext.class,0);
		}
		public ResponsesContext responses() {
			return getRuleContext(ResponsesContext.class,0);
		}
		public MilestonesContext milestones() {
			return getRuleContext(MilestonesContext.class,0);
		}
		public IncludesContext includes() {
			return getRuleContext(IncludesContext.class,0);
		}
		public RelationshipContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationship; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DCRGraphGrammarListener ) ((DCRGraphGrammarListener)listener).enterRelationship(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DCRGraphGrammarListener ) ((DCRGraphGrammarListener)listener).exitRelationship(this);
		}
	}

	public final RelationshipContext relationship() throws RecognitionException {
		RelationshipContext _localctx = new RelationshipContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_relationship);
		try {
			setState(173);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(158); ((RelationshipContext)_localctx).c = conditions();
				 ((RelationshipContext)_localctx).value =  ((RelationshipContext)_localctx).c.value; 
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(161); ((RelationshipContext)_localctx).m = milestones();
				 ((RelationshipContext)_localctx).value =  ((RelationshipContext)_localctx).m.value; 
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(164); ((RelationshipContext)_localctx).r = responses();
				 ((RelationshipContext)_localctx).value =  ((RelationshipContext)_localctx).r.value; 
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(167); ((RelationshipContext)_localctx).i = includes();
				 ((RelationshipContext)_localctx).value =  ((RelationshipContext)_localctx).i.value; 
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(170); ((RelationshipContext)_localctx).e = excludes();
				 ((RelationshipContext)_localctx).value =  ((RelationshipContext)_localctx).e.value; 
				}
				break;
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

	public static class ConditionsContext extends ParserRuleContext {
		public OneSidedRelationship value;
		public IdOneOrMoreContext ids;
		public TerminalNode WS(int i) {
			return getToken(DCRGraphGrammarParser.WS, i);
		}
		public List<TerminalNode> WS() { return getTokens(DCRGraphGrammarParser.WS); }
		public IdOneOrMoreContext idOneOrMore() {
			return getRuleContext(IdOneOrMoreContext.class,0);
		}
		public ConditionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DCRGraphGrammarListener ) ((DCRGraphGrammarListener)listener).enterConditions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DCRGraphGrammarListener ) ((DCRGraphGrammarListener)listener).exitConditions(this);
		}
	}

	public final ConditionsContext conditions() throws RecognitionException {
		ConditionsContext _localctx = new ConditionsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_conditions);
		int _la;
		try {
			setState(195);
			switch (_input.LA(1)) {
			case T__7:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(175); ((ConditionsContext)_localctx).ids = idOneOrMore();
				setState(176); match(T__8);
				setState(180);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(177); match(WS);
					}
					}
					setState(182);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				 ((ConditionsContext)_localctx).value =  new OneSidedRelationship(RelationshipType.CONDITIONS, VertexType.SOURCE, ((ConditionsContext)_localctx).ids.value); 
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				setState(185); match(T__8);
				setState(189);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(186); match(WS);
					}
					}
					setState(191);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(192); ((ConditionsContext)_localctx).ids = idOneOrMore();
				 ((ConditionsContext)_localctx).value =  new OneSidedRelationship(RelationshipType.CONDITIONS, VertexType.TARGET, ((ConditionsContext)_localctx).ids.value); 
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

	public static class MilestonesContext extends ParserRuleContext {
		public OneSidedRelationship value;
		public IdOneOrMoreContext ids;
		public TerminalNode WS(int i) {
			return getToken(DCRGraphGrammarParser.WS, i);
		}
		public List<TerminalNode> WS() { return getTokens(DCRGraphGrammarParser.WS); }
		public IdOneOrMoreContext idOneOrMore() {
			return getRuleContext(IdOneOrMoreContext.class,0);
		}
		public MilestonesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_milestones; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DCRGraphGrammarListener ) ((DCRGraphGrammarListener)listener).enterMilestones(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DCRGraphGrammarListener ) ((DCRGraphGrammarListener)listener).exitMilestones(this);
		}
	}

	public final MilestonesContext milestones() throws RecognitionException {
		MilestonesContext _localctx = new MilestonesContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_milestones);
		int _la;
		try {
			setState(217);
			switch (_input.LA(1)) {
			case T__7:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(197); ((MilestonesContext)_localctx).ids = idOneOrMore();
				setState(198); match(T__9);
				setState(202);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(199); match(WS);
					}
					}
					setState(204);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				 ((MilestonesContext)_localctx).value =  new OneSidedRelationship(RelationshipType.MILESTONES, VertexType.SOURCE, ((MilestonesContext)_localctx).ids.value); 
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 2);
				{
				setState(207); match(T__9);
				setState(211);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(208); match(WS);
					}
					}
					setState(213);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(214); ((MilestonesContext)_localctx).ids = idOneOrMore();
				 ((MilestonesContext)_localctx).value =  new OneSidedRelationship(RelationshipType.MILESTONES, VertexType.TARGET, ((MilestonesContext)_localctx).ids.value); 
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

	public static class ResponsesContext extends ParserRuleContext {
		public OneSidedRelationship value;
		public IdOneOrMoreContext ids;
		public TerminalNode WS(int i) {
			return getToken(DCRGraphGrammarParser.WS, i);
		}
		public List<TerminalNode> WS() { return getTokens(DCRGraphGrammarParser.WS); }
		public IdOneOrMoreContext idOneOrMore() {
			return getRuleContext(IdOneOrMoreContext.class,0);
		}
		public ResponsesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_responses; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DCRGraphGrammarListener ) ((DCRGraphGrammarListener)listener).enterResponses(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DCRGraphGrammarListener ) ((DCRGraphGrammarListener)listener).exitResponses(this);
		}
	}

	public final ResponsesContext responses() throws RecognitionException {
		ResponsesContext _localctx = new ResponsesContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_responses);
		int _la;
		try {
			setState(239);
			switch (_input.LA(1)) {
			case T__7:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(219); ((ResponsesContext)_localctx).ids = idOneOrMore();
				setState(220); match(T__10);
				setState(224);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(221); match(WS);
					}
					}
					setState(226);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				 ((ResponsesContext)_localctx).value =  new OneSidedRelationship(RelationshipType.RESPONSES, VertexType.SOURCE, ((ResponsesContext)_localctx).ids.value); 
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 2);
				{
				setState(229); match(T__10);
				setState(233);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(230); match(WS);
					}
					}
					setState(235);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(236); ((ResponsesContext)_localctx).ids = idOneOrMore();
				 ((ResponsesContext)_localctx).value =  new OneSidedRelationship(RelationshipType.RESPONSES, VertexType.TARGET, ((ResponsesContext)_localctx).ids.value); 
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

	public static class IncludesContext extends ParserRuleContext {
		public OneSidedRelationship value;
		public IdOneOrMoreContext ids;
		public TerminalNode WS(int i) {
			return getToken(DCRGraphGrammarParser.WS, i);
		}
		public List<TerminalNode> WS() { return getTokens(DCRGraphGrammarParser.WS); }
		public IdOneOrMoreContext idOneOrMore() {
			return getRuleContext(IdOneOrMoreContext.class,0);
		}
		public IncludesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_includes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DCRGraphGrammarListener ) ((DCRGraphGrammarListener)listener).enterIncludes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DCRGraphGrammarListener ) ((DCRGraphGrammarListener)listener).exitIncludes(this);
		}
	}

	public final IncludesContext includes() throws RecognitionException {
		IncludesContext _localctx = new IncludesContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_includes);
		int _la;
		try {
			setState(261);
			switch (_input.LA(1)) {
			case T__7:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(241); ((IncludesContext)_localctx).ids = idOneOrMore();
				setState(242); match(T__11);
				setState(246);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(243); match(WS);
					}
					}
					setState(248);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				 ((IncludesContext)_localctx).value =  new OneSidedRelationship(RelationshipType.INCLUDES, VertexType.SOURCE, ((IncludesContext)_localctx).ids.value); 
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 2);
				{
				setState(251); match(T__11);
				setState(255);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(252); match(WS);
					}
					}
					setState(257);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(258); ((IncludesContext)_localctx).ids = idOneOrMore();
				 ((IncludesContext)_localctx).value =  new OneSidedRelationship(RelationshipType.INCLUDES, VertexType.TARGET, ((IncludesContext)_localctx).ids.value); 
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

	public static class ExcludesContext extends ParserRuleContext {
		public OneSidedRelationship value;
		public IdOneOrMoreContext ids;
		public TerminalNode WS(int i) {
			return getToken(DCRGraphGrammarParser.WS, i);
		}
		public List<TerminalNode> WS() { return getTokens(DCRGraphGrammarParser.WS); }
		public IdOneOrMoreContext idOneOrMore() {
			return getRuleContext(IdOneOrMoreContext.class,0);
		}
		public ExcludesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_excludes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DCRGraphGrammarListener ) ((DCRGraphGrammarListener)listener).enterExcludes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DCRGraphGrammarListener ) ((DCRGraphGrammarListener)listener).exitExcludes(this);
		}
	}

	public final ExcludesContext excludes() throws RecognitionException {
		ExcludesContext _localctx = new ExcludesContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_excludes);
		int _la;
		try {
			setState(283);
			switch (_input.LA(1)) {
			case T__7:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(263); ((ExcludesContext)_localctx).ids = idOneOrMore();
				setState(264); match(T__6);
				setState(268);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(265); match(WS);
					}
					}
					setState(270);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				 ((ExcludesContext)_localctx).value =  new OneSidedRelationship(RelationshipType.EXCLUDES, VertexType.SOURCE, ((ExcludesContext)_localctx).ids.value); 
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				setState(273); match(T__6);
				setState(277);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(274); match(WS);
					}
					}
					setState(279);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(280); ((ExcludesContext)_localctx).ids = idOneOrMore();
				 ((ExcludesContext)_localctx).value =  new OneSidedRelationship(RelationshipType.EXCLUDES, VertexType.TARGET, ((ExcludesContext)_localctx).ids.value); 
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

	public static class EventLabelContext extends ParserRuleContext {
		public String value;
		public Token ID;
		public TerminalNode ID() { return getToken(DCRGraphGrammarParser.ID, 0); }
		public TerminalNode WS(int i) {
			return getToken(DCRGraphGrammarParser.WS, i);
		}
		public List<TerminalNode> WS() { return getTokens(DCRGraphGrammarParser.WS); }
		public EventLabelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eventLabel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DCRGraphGrammarListener ) ((DCRGraphGrammarListener)listener).enterEventLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DCRGraphGrammarListener ) ((DCRGraphGrammarListener)listener).exitEventLabel(this);
		}
	}

	public final EventLabelContext eventLabel() throws RecognitionException {
		EventLabelContext _localctx = new EventLabelContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_eventLabel);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285); match(T__3);
			setState(289);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS) {
				{
				{
				setState(286); match(WS);
				}
				}
				setState(291);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(292); ((EventLabelContext)_localctx).ID = match(ID);
			setState(296);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS) {
				{
				{
				setState(293); match(WS);
				}
				}
				setState(298);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(299); match(T__0);
			setState(303);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS) {
				{
				{
				setState(300); match(WS);
				}
				}
				setState(305);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			 ((EventLabelContext)_localctx).value =  (((EventLabelContext)_localctx).ID!=null?((EventLabelContext)_localctx).ID.getText():null); 
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

	public static class IdOneOrMoreContext extends ParserRuleContext {
		public List<String> value;
		public Token ID;
		public IdSeqContext i;
		public TerminalNode ID() { return getToken(DCRGraphGrammarParser.ID, 0); }
		public TerminalNode WS(int i) {
			return getToken(DCRGraphGrammarParser.WS, i);
		}
		public List<TerminalNode> WS() { return getTokens(DCRGraphGrammarParser.WS); }
		public IdSeqContext idSeq() {
			return getRuleContext(IdSeqContext.class,0);
		}
		public IdOneOrMoreContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_idOneOrMore; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DCRGraphGrammarListener ) ((DCRGraphGrammarListener)listener).enterIdOneOrMore(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DCRGraphGrammarListener ) ((DCRGraphGrammarListener)listener).exitIdOneOrMore(this);
		}
	}

	public final IdOneOrMoreContext idOneOrMore() throws RecognitionException {
		IdOneOrMoreContext _localctx = new IdOneOrMoreContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_idOneOrMore);

		    ((IdOneOrMoreContext)_localctx).value =  new ArrayList<String>();

		int _la;
		try {
			int _alt;
			setState(340);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(308); ((IdOneOrMoreContext)_localctx).ID = match(ID);
				setState(312);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(309); match(WS);
					}
					}
					setState(314);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				 _localctx.value.add((((IdOneOrMoreContext)_localctx).ID!=null?((IdOneOrMoreContext)_localctx).ID.getText():null)); 
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 2);
				{
				setState(316); match(T__7);
				setState(320);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(317); match(WS);
					}
					}
					setState(322);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(323); ((IdOneOrMoreContext)_localctx).ID = match(ID);
				setState(327);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(324); match(WS);
						}
						} 
					}
					setState(329);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
				}
				setState(330); ((IdOneOrMoreContext)_localctx).i = idSeq();
				setState(331); match(T__5);
				setState(335);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(332); match(WS);
					}
					}
					setState(337);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				 _localctx.value.add((((IdOneOrMoreContext)_localctx).ID!=null?((IdOneOrMoreContext)_localctx).ID.getText():null)); _localctx.value.addAll(((IdOneOrMoreContext)_localctx).i.value); 
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

	public static class IdSeqContext extends ParserRuleContext {
		public List<String> value;
		public Token ID;
		public IdSeqContext is;
		public TerminalNode ID() { return getToken(DCRGraphGrammarParser.ID, 0); }
		public TerminalNode WS(int i) {
			return getToken(DCRGraphGrammarParser.WS, i);
		}
		public List<TerminalNode> WS() { return getTokens(DCRGraphGrammarParser.WS); }
		public IdSeqContext idSeq() {
			return getRuleContext(IdSeqContext.class,0);
		}
		public IdSeqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_idSeq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DCRGraphGrammarListener ) ((DCRGraphGrammarListener)listener).enterIdSeq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DCRGraphGrammarListener ) ((DCRGraphGrammarListener)listener).exitIdSeq(this);
		}
	}

	public final IdSeqContext idSeq() throws RecognitionException {
		IdSeqContext _localctx = new IdSeqContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_idSeq);

		    ((IdSeqContext)_localctx).value =  new ArrayList<String>();

		int _la;
		try {
			int _alt;
			setState(365);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(342); match(T__2);
				setState(346);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(343); match(WS);
					}
					}
					setState(348);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(349); ((IdSeqContext)_localctx).ID = match(ID);
				setState(353);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(350); match(WS);
						}
						} 
					}
					setState(355);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
				}
				setState(356); ((IdSeqContext)_localctx).is = idSeq();
				 _localctx.value.add((((IdSeqContext)_localctx).ID!=null?((IdSeqContext)_localctx).ID.getText():null)); _localctx.value.addAll(((IdSeqContext)_localctx).is.value); 
				}
				break;
			case T__5:
			case WS:
				enterOuterAlt(_localctx, 2);
				{
				setState(362);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(359); match(WS);
					}
					}
					setState(364);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\24\u0172\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\7\2\36\n\2\f\2\16\2!\13\2\3\2\3\2"+
		"\3\2\3\2\3\2\5\2(\n\2\3\3\3\3\7\3,\n\3\f\3\16\3/\13\3\3\3\3\3\7\3\63\n"+
		"\3\f\3\16\3\66\13\3\3\3\3\3\3\3\3\3\3\3\5\3=\n\3\3\4\3\4\7\4A\n\4\f\4"+
		"\16\4D\13\4\3\4\5\4G\n\4\3\4\3\4\7\4K\n\4\f\4\16\4N\13\4\3\4\3\4\7\4R"+
		"\n\4\f\4\16\4U\13\4\3\4\3\4\7\4Y\n\4\f\4\16\4\\\13\4\3\4\3\4\7\4`\n\4"+
		"\f\4\16\4c\13\4\3\4\3\4\7\4g\n\4\f\4\16\4j\13\4\3\4\3\4\7\4n\n\4\f\4\16"+
		"\4q\13\4\3\4\3\4\7\4u\n\4\f\4\16\4x\13\4\3\4\3\4\3\4\7\4}\n\4\f\4\16\4"+
		"\u0080\13\4\3\4\3\4\3\4\7\4\u0085\n\4\f\4\16\4\u0088\13\4\5\4\u008a\n"+
		"\4\3\4\3\4\3\5\3\5\3\5\7\5\u0091\n\5\f\5\16\5\u0094\13\5\3\5\3\5\3\5\3"+
		"\5\7\5\u009a\n\5\f\5\16\5\u009d\13\5\5\5\u009f\n\5\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u00b0\n\6\3\7\3\7\3\7\7\7"+
		"\u00b5\n\7\f\7\16\7\u00b8\13\7\3\7\3\7\3\7\3\7\7\7\u00be\n\7\f\7\16\7"+
		"\u00c1\13\7\3\7\3\7\3\7\5\7\u00c6\n\7\3\b\3\b\3\b\7\b\u00cb\n\b\f\b\16"+
		"\b\u00ce\13\b\3\b\3\b\3\b\3\b\7\b\u00d4\n\b\f\b\16\b\u00d7\13\b\3\b\3"+
		"\b\3\b\5\b\u00dc\n\b\3\t\3\t\3\t\7\t\u00e1\n\t\f\t\16\t\u00e4\13\t\3\t"+
		"\3\t\3\t\3\t\7\t\u00ea\n\t\f\t\16\t\u00ed\13\t\3\t\3\t\3\t\5\t\u00f2\n"+
		"\t\3\n\3\n\3\n\7\n\u00f7\n\n\f\n\16\n\u00fa\13\n\3\n\3\n\3\n\3\n\7\n\u0100"+
		"\n\n\f\n\16\n\u0103\13\n\3\n\3\n\3\n\5\n\u0108\n\n\3\13\3\13\3\13\7\13"+
		"\u010d\n\13\f\13\16\13\u0110\13\13\3\13\3\13\3\13\3\13\7\13\u0116\n\13"+
		"\f\13\16\13\u0119\13\13\3\13\3\13\3\13\5\13\u011e\n\13\3\f\3\f\7\f\u0122"+
		"\n\f\f\f\16\f\u0125\13\f\3\f\3\f\7\f\u0129\n\f\f\f\16\f\u012c\13\f\3\f"+
		"\3\f\7\f\u0130\n\f\f\f\16\f\u0133\13\f\3\f\3\f\3\r\3\r\7\r\u0139\n\r\f"+
		"\r\16\r\u013c\13\r\3\r\3\r\3\r\7\r\u0141\n\r\f\r\16\r\u0144\13\r\3\r\3"+
		"\r\7\r\u0148\n\r\f\r\16\r\u014b\13\r\3\r\3\r\3\r\7\r\u0150\n\r\f\r\16"+
		"\r\u0153\13\r\3\r\3\r\5\r\u0157\n\r\3\16\3\16\7\16\u015b\n\16\f\16\16"+
		"\16\u015e\13\16\3\16\3\16\7\16\u0162\n\16\f\16\16\16\u0165\13\16\3\16"+
		"\3\16\3\16\3\16\7\16\u016b\n\16\f\16\16\16\u016e\13\16\5\16\u0170\n\16"+
		"\3\16\2\2\17\2\4\6\b\n\f\16\20\22\24\26\30\32\2\2\u0197\2\'\3\2\2\2\4"+
		"<\3\2\2\2\6>\3\2\2\2\b\u009e\3\2\2\2\n\u00af\3\2\2\2\f\u00c5\3\2\2\2\16"+
		"\u00db\3\2\2\2\20\u00f1\3\2\2\2\22\u0107\3\2\2\2\24\u011d\3\2\2\2\26\u011f"+
		"\3\2\2\2\30\u0156\3\2\2\2\32\u016f\3\2\2\2\34\36\7\24\2\2\35\34\3\2\2"+
		"\2\36!\3\2\2\2\37\35\3\2\2\2\37 \3\2\2\2 \"\3\2\2\2!\37\3\2\2\2\"#\5\6"+
		"\4\2#$\5\4\3\2$%\b\2\1\2%(\3\2\2\2&(\7\2\2\3\'\37\3\2\2\2\'&\3\2\2\2("+
		"\3\3\2\2\2)-\7\f\2\2*,\7\24\2\2+*\3\2\2\2,/\3\2\2\2-+\3\2\2\2-.\3\2\2"+
		"\2.\60\3\2\2\2/-\3\2\2\2\60\64\7\23\2\2\61\63\7\24\2\2\62\61\3\2\2\2\63"+
		"\66\3\2\2\2\64\62\3\2\2\2\64\65\3\2\2\2\65\67\3\2\2\2\66\64\3\2\2\2\67"+
		"8\5\6\4\289\5\4\3\29:\b\3\1\2:=\3\2\2\2;=\7\2\2\3<)\3\2\2\2<;\3\2\2\2"+
		"=\5\3\2\2\2>B\7\20\2\2?A\7\24\2\2@?\3\2\2\2AD\3\2\2\2B@\3\2\2\2BC\3\2"+
		"\2\2CF\3\2\2\2DB\3\2\2\2EG\5\26\f\2FE\3\2\2\2FG\3\2\2\2GH\3\2\2\2HL\7"+
		"\7\2\2IK\7\24\2\2JI\3\2\2\2KN\3\2\2\2LJ\3\2\2\2LM\3\2\2\2MO\3\2\2\2NL"+
		"\3\2\2\2OS\7\17\2\2PR\7\24\2\2QP\3\2\2\2RU\3\2\2\2SQ\3\2\2\2ST\3\2\2\2"+
		"TV\3\2\2\2US\3\2\2\2VZ\7\f\2\2WY\7\24\2\2XW\3\2\2\2Y\\\3\2\2\2ZX\3\2\2"+
		"\2Z[\3\2\2\2[]\3\2\2\2\\Z\3\2\2\2]a\7\17\2\2^`\7\24\2\2_^\3\2\2\2`c\3"+
		"\2\2\2a_\3\2\2\2ab\3\2\2\2bd\3\2\2\2ca\3\2\2\2dh\7\f\2\2eg\7\24\2\2fe"+
		"\3\2\2\2gj\3\2\2\2hf\3\2\2\2hi\3\2\2\2ik\3\2\2\2jh\3\2\2\2ko\7\17\2\2"+
		"ln\7\24\2\2ml\3\2\2\2nq\3\2\2\2om\3\2\2\2op\3\2\2\2pr\3\2\2\2qo\3\2\2"+
		"\2rv\7\t\2\2su\7\24\2\2ts\3\2\2\2ux\3\2\2\2vt\3\2\2\2vw\3\2\2\2w\u0089"+
		"\3\2\2\2xv\3\2\2\2yz\7\n\2\2z~\7\23\2\2{}\7\24\2\2|{\3\2\2\2}\u0080\3"+
		"\2\2\2~|\3\2\2\2~\177\3\2\2\2\177\u0081\3\2\2\2\u0080~\3\2\2\2\u0081\u0082"+
		"\5\b\5\2\u0082\u0086\7\r\2\2\u0083\u0085\7\24\2\2\u0084\u0083\3\2\2\2"+
		"\u0085\u0088\3\2\2\2\u0086\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u008a"+
		"\3\2\2\2\u0088\u0086\3\2\2\2\u0089y\3\2\2\2\u0089\u008a\3\2\2\2\u008a"+
		"\u008b\3\2\2\2\u008b\u008c\b\4\1\2\u008c\7\3\2\2\2\u008d\u008e\5\n\6\2"+
		"\u008e\u0092\7\23\2\2\u008f\u0091\7\24\2\2\u0090\u008f\3\2\2\2\u0091\u0094"+
		"\3\2\2\2\u0092\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0095\3\2\2\2\u0094"+
		"\u0092\3\2\2\2\u0095\u0096\5\b\5\2\u0096\u0097\b\5\1\2\u0097\u009f\3\2"+
		"\2\2\u0098\u009a\7\24\2\2\u0099\u0098\3\2\2\2\u009a\u009d\3\2\2\2\u009b"+
		"\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009f\3\2\2\2\u009d\u009b\3\2"+
		"\2\2\u009e\u008d\3\2\2\2\u009e\u009b\3\2\2\2\u009f\t\3\2\2\2\u00a0\u00a1"+
		"\5\f\7\2\u00a1\u00a2\b\6\1\2\u00a2\u00b0\3\2\2\2\u00a3\u00a4\5\16\b\2"+
		"\u00a4\u00a5\b\6\1\2\u00a5\u00b0\3\2\2\2\u00a6\u00a7\5\20\t\2\u00a7\u00a8"+
		"\b\6\1\2\u00a8\u00b0\3\2\2\2\u00a9\u00aa\5\22\n\2\u00aa\u00ab\b\6\1\2"+
		"\u00ab\u00b0\3\2\2\2\u00ac\u00ad\5\24\13\2\u00ad\u00ae\b\6\1\2\u00ae\u00b0"+
		"\3\2\2\2\u00af\u00a0\3\2\2\2\u00af\u00a3\3\2\2\2\u00af\u00a6\3\2\2\2\u00af"+
		"\u00a9\3\2\2\2\u00af\u00ac\3\2\2\2\u00b0\13\3\2\2\2\u00b1\u00b2\5\30\r"+
		"\2\u00b2\u00b6\7\6\2\2\u00b3\u00b5\7\24\2\2\u00b4\u00b3\3\2\2\2\u00b5"+
		"\u00b8\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b9\3\2"+
		"\2\2\u00b8\u00b6\3\2\2\2\u00b9\u00ba\b\7\1\2\u00ba\u00c6\3\2\2\2\u00bb"+
		"\u00bf\7\6\2\2\u00bc\u00be\7\24\2\2\u00bd\u00bc\3\2\2\2\u00be\u00c1\3"+
		"\2\2\2\u00bf\u00bd\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c2\3\2\2\2\u00c1"+
		"\u00bf\3\2\2\2\u00c2\u00c3\5\30\r\2\u00c3\u00c4\b\7\1\2\u00c4\u00c6\3"+
		"\2\2\2\u00c5\u00b1\3\2\2\2\u00c5\u00bb\3\2\2\2\u00c6\r\3\2\2\2\u00c7\u00c8"+
		"\5\30\r\2\u00c8\u00cc\7\5\2\2\u00c9\u00cb\7\24\2\2\u00ca\u00c9\3\2\2\2"+
		"\u00cb\u00ce\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00cf"+
		"\3\2\2\2\u00ce\u00cc\3\2\2\2\u00cf\u00d0\b\b\1\2\u00d0\u00dc\3\2\2\2\u00d1"+
		"\u00d5\7\5\2\2\u00d2\u00d4\7\24\2\2\u00d3\u00d2\3\2\2\2\u00d4\u00d7\3"+
		"\2\2\2\u00d5\u00d3\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d8\3\2\2\2\u00d7"+
		"\u00d5\3\2\2\2\u00d8\u00d9\5\30\r\2\u00d9\u00da\b\b\1\2\u00da\u00dc\3"+
		"\2\2\2\u00db\u00c7\3\2\2\2\u00db\u00d1\3\2\2\2\u00dc\17\3\2\2\2\u00dd"+
		"\u00de\5\30\r\2\u00de\u00e2\7\4\2\2\u00df\u00e1\7\24\2\2\u00e0\u00df\3"+
		"\2\2\2\u00e1\u00e4\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3"+
		"\u00e5\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e5\u00e6\b\t\1\2\u00e6\u00f2\3\2"+
		"\2\2\u00e7\u00eb\7\4\2\2\u00e8\u00ea\7\24\2\2\u00e9\u00e8\3\2\2\2\u00ea"+
		"\u00ed\3\2\2\2\u00eb\u00e9\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00ee\3\2"+
		"\2\2\u00ed\u00eb\3\2\2\2\u00ee\u00ef\5\30\r\2\u00ef\u00f0\b\t\1\2\u00f0"+
		"\u00f2\3\2\2\2\u00f1\u00dd\3\2\2\2\u00f1\u00e7\3\2\2\2\u00f2\21\3\2\2"+
		"\2\u00f3\u00f4\5\30\r\2\u00f4\u00f8\7\3\2\2\u00f5\u00f7\7\24\2\2\u00f6"+
		"\u00f5\3\2\2\2\u00f7\u00fa\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f8\u00f9\3\2"+
		"\2\2\u00f9\u00fb\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fb\u00fc\b\n\1\2\u00fc"+
		"\u0108\3\2\2\2\u00fd\u0101\7\3\2\2\u00fe\u0100\7\24\2\2\u00ff\u00fe\3"+
		"\2\2\2\u0100\u0103\3\2\2\2\u0101\u00ff\3\2\2\2\u0101\u0102\3\2\2\2\u0102"+
		"\u0104\3\2\2\2\u0103\u0101\3\2\2\2\u0104\u0105\5\30\r\2\u0105\u0106\b"+
		"\n\1\2\u0106\u0108\3\2\2\2\u0107\u00f3\3\2\2\2\u0107\u00fd\3\2\2\2\u0108"+
		"\23\3\2\2\2\u0109\u010a\5\30\r\2\u010a\u010e\7\b\2\2\u010b\u010d\7\24"+
		"\2\2\u010c\u010b\3\2\2\2\u010d\u0110\3\2\2\2\u010e\u010c\3\2\2\2\u010e"+
		"\u010f\3\2\2\2\u010f\u0111\3\2\2\2\u0110\u010e\3\2\2\2\u0111\u0112\b\13"+
		"\1\2\u0112\u011e\3\2\2\2\u0113\u0117\7\b\2\2\u0114\u0116\7\24\2\2\u0115"+
		"\u0114\3\2\2\2\u0116\u0119\3\2\2\2\u0117\u0115\3\2\2\2\u0117\u0118\3\2"+
		"\2\2\u0118\u011a\3\2\2\2\u0119\u0117\3\2\2\2\u011a\u011b\5\30\r\2\u011b"+
		"\u011c\b\13\1\2\u011c\u011e\3\2\2\2\u011d\u0109\3\2\2\2\u011d\u0113\3"+
		"\2\2\2\u011e\25\3\2\2\2\u011f\u0123\7\13\2\2\u0120\u0122\7\24\2\2\u0121"+
		"\u0120\3\2\2\2\u0122\u0125\3\2\2\2\u0123\u0121\3\2\2\2\u0123\u0124\3\2"+
		"\2\2\u0124\u0126\3\2\2\2\u0125\u0123\3\2\2\2\u0126\u012a\7\20\2\2\u0127"+
		"\u0129\7\24\2\2\u0128\u0127\3\2\2\2\u0129\u012c\3\2\2\2\u012a\u0128\3"+
		"\2\2\2\u012a\u012b\3\2\2\2\u012b\u012d\3\2\2\2\u012c\u012a\3\2\2\2\u012d"+
		"\u0131\7\16\2\2\u012e\u0130\7\24\2\2\u012f\u012e\3\2\2\2\u0130\u0133\3"+
		"\2\2\2\u0131\u012f\3\2\2\2\u0131\u0132\3\2\2\2\u0132\u0134\3\2\2\2\u0133"+
		"\u0131\3\2\2\2\u0134\u0135\b\f\1\2\u0135\27\3\2\2\2\u0136\u013a\7\20\2"+
		"\2\u0137\u0139\7\24\2\2\u0138\u0137\3\2\2\2\u0139\u013c\3\2\2\2\u013a"+
		"\u0138\3\2\2\2\u013a\u013b\3\2\2\2\u013b\u013d\3\2\2\2\u013c\u013a\3\2"+
		"\2\2\u013d\u0157\b\r\1\2\u013e\u0142\7\7\2\2\u013f\u0141\7\24\2\2\u0140"+
		"\u013f\3\2\2\2\u0141\u0144\3\2\2\2\u0142\u0140\3\2\2\2\u0142\u0143\3\2"+
		"\2\2\u0143\u0145\3\2\2\2\u0144\u0142\3\2\2\2\u0145\u0149\7\20\2\2\u0146"+
		"\u0148\7\24\2\2\u0147\u0146\3\2\2\2\u0148\u014b\3\2\2\2\u0149\u0147\3"+
		"\2\2\2\u0149\u014a\3\2\2\2\u014a\u014c\3\2\2\2\u014b\u0149\3\2\2\2\u014c"+
		"\u014d\5\32\16\2\u014d\u0151\7\t\2\2\u014e\u0150\7\24\2\2\u014f\u014e"+
		"\3\2\2\2\u0150\u0153\3\2\2\2\u0151\u014f\3\2\2\2\u0151\u0152\3\2\2\2\u0152"+
		"\u0154\3\2\2\2\u0153\u0151\3\2\2\2\u0154\u0155\b\r\1\2\u0155\u0157\3\2"+
		"\2\2\u0156\u0136\3\2\2\2\u0156\u013e\3\2\2\2\u0157\31\3\2\2\2\u0158\u015c"+
		"\7\f\2\2\u0159\u015b\7\24\2\2\u015a\u0159\3\2\2\2\u015b\u015e\3\2\2\2"+
		"\u015c\u015a\3\2\2\2\u015c\u015d\3\2\2\2\u015d\u015f\3\2\2\2\u015e\u015c"+
		"\3\2\2\2\u015f\u0163\7\20\2\2\u0160\u0162\7\24\2\2\u0161\u0160\3\2\2\2"+
		"\u0162\u0165\3\2\2\2\u0163\u0161\3\2\2\2\u0163\u0164\3\2\2\2\u0164\u0166"+
		"\3\2\2\2\u0165\u0163\3\2\2\2\u0166\u0167\5\32\16\2\u0167\u0168\b\16\1"+
		"\2\u0168\u0170\3\2\2\2\u0169\u016b\7\24\2\2\u016a\u0169\3\2\2\2\u016b"+
		"\u016e\3\2\2\2\u016c\u016a\3\2\2\2\u016c\u016d\3\2\2\2\u016d\u0170\3\2"+
		"\2\2\u016e\u016c\3\2\2\2\u016f\u0158\3\2\2\2\u016f\u016c\3\2\2\2\u0170"+
		"\33\3\2\2\2\62\37\'-\64<BFLSZahov~\u0086\u0089\u0092\u009b\u009e\u00af"+
		"\u00b6\u00bf\u00c5\u00cc\u00d5\u00db\u00e2\u00eb\u00f1\u00f8\u0101\u0107"+
		"\u010e\u0117\u011d\u0123\u012a\u0131\u013a\u0142\u0149\u0151\u0156\u015c"+
		"\u0163\u016c\u016f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}