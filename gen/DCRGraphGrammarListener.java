// Generated from C:/git/SoftwareEngineering/src/main/antlr4/dk/ku/di/oodcr/parser/dcr\DCRGraphGrammar.g4 by ANTLR 4.8

import dk.ku.di.oodcr.graph.*;
import dk.ku.di.oodcr.parser.ast.*;
import java.util.*;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link DCRGraphGrammarParser}.
 */
public interface DCRGraphGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link DCRGraphGrammarParser#graph}.
	 * @param ctx the parse tree
	 */
	void enterGraph(DCRGraphGrammarParser.GraphContext ctx);
	/**
	 * Exit a parse tree produced by {@link DCRGraphGrammarParser#graph}.
	 * @param ctx the parse tree
	 */
	void exitGraph(DCRGraphGrammarParser.GraphContext ctx);
	/**
	 * Enter a parse tree produced by {@link DCRGraphGrammarParser#eventz}.
	 * @param ctx the parse tree
	 */
	void enterEventz(DCRGraphGrammarParser.EventzContext ctx);
	/**
	 * Exit a parse tree produced by {@link DCRGraphGrammarParser#eventz}.
	 * @param ctx the parse tree
	 */
	void exitEventz(DCRGraphGrammarParser.EventzContext ctx);
	/**
	 * Enter a parse tree produced by {@link DCRGraphGrammarParser#event}.
	 * @param ctx the parse tree
	 */
	void enterEvent(DCRGraphGrammarParser.EventContext ctx);
	/**
	 * Exit a parse tree produced by {@link DCRGraphGrammarParser#event}.
	 * @param ctx the parse tree
	 */
	void exitEvent(DCRGraphGrammarParser.EventContext ctx);
	/**
	 * Enter a parse tree produced by {@link DCRGraphGrammarParser#relationships}.
	 * @param ctx the parse tree
	 */
	void enterRelationships(DCRGraphGrammarParser.RelationshipsContext ctx);
	/**
	 * Exit a parse tree produced by {@link DCRGraphGrammarParser#relationships}.
	 * @param ctx the parse tree
	 */
	void exitRelationships(DCRGraphGrammarParser.RelationshipsContext ctx);
	/**
	 * Enter a parse tree produced by {@link DCRGraphGrammarParser#relationship}.
	 * @param ctx the parse tree
	 */
	void enterRelationship(DCRGraphGrammarParser.RelationshipContext ctx);
	/**
	 * Exit a parse tree produced by {@link DCRGraphGrammarParser#relationship}.
	 * @param ctx the parse tree
	 */
	void exitRelationship(DCRGraphGrammarParser.RelationshipContext ctx);
	/**
	 * Enter a parse tree produced by {@link DCRGraphGrammarParser#conditions}.
	 * @param ctx the parse tree
	 */
	void enterConditions(DCRGraphGrammarParser.ConditionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link DCRGraphGrammarParser#conditions}.
	 * @param ctx the parse tree
	 */
	void exitConditions(DCRGraphGrammarParser.ConditionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link DCRGraphGrammarParser#milestones}.
	 * @param ctx the parse tree
	 */
	void enterMilestones(DCRGraphGrammarParser.MilestonesContext ctx);
	/**
	 * Exit a parse tree produced by {@link DCRGraphGrammarParser#milestones}.
	 * @param ctx the parse tree
	 */
	void exitMilestones(DCRGraphGrammarParser.MilestonesContext ctx);
	/**
	 * Enter a parse tree produced by {@link DCRGraphGrammarParser#responses}.
	 * @param ctx the parse tree
	 */
	void enterResponses(DCRGraphGrammarParser.ResponsesContext ctx);
	/**
	 * Exit a parse tree produced by {@link DCRGraphGrammarParser#responses}.
	 * @param ctx the parse tree
	 */
	void exitResponses(DCRGraphGrammarParser.ResponsesContext ctx);
	/**
	 * Enter a parse tree produced by {@link DCRGraphGrammarParser#includes}.
	 * @param ctx the parse tree
	 */
	void enterIncludes(DCRGraphGrammarParser.IncludesContext ctx);
	/**
	 * Exit a parse tree produced by {@link DCRGraphGrammarParser#includes}.
	 * @param ctx the parse tree
	 */
	void exitIncludes(DCRGraphGrammarParser.IncludesContext ctx);
	/**
	 * Enter a parse tree produced by {@link DCRGraphGrammarParser#excludes}.
	 * @param ctx the parse tree
	 */
	void enterExcludes(DCRGraphGrammarParser.ExcludesContext ctx);
	/**
	 * Exit a parse tree produced by {@link DCRGraphGrammarParser#excludes}.
	 * @param ctx the parse tree
	 */
	void exitExcludes(DCRGraphGrammarParser.ExcludesContext ctx);
	/**
	 * Enter a parse tree produced by {@link DCRGraphGrammarParser#eventLabel}.
	 * @param ctx the parse tree
	 */
	void enterEventLabel(DCRGraphGrammarParser.EventLabelContext ctx);
	/**
	 * Exit a parse tree produced by {@link DCRGraphGrammarParser#eventLabel}.
	 * @param ctx the parse tree
	 */
	void exitEventLabel(DCRGraphGrammarParser.EventLabelContext ctx);
	/**
	 * Enter a parse tree produced by {@link DCRGraphGrammarParser#idOneOrMore}.
	 * @param ctx the parse tree
	 */
	void enterIdOneOrMore(DCRGraphGrammarParser.IdOneOrMoreContext ctx);
	/**
	 * Exit a parse tree produced by {@link DCRGraphGrammarParser#idOneOrMore}.
	 * @param ctx the parse tree
	 */
	void exitIdOneOrMore(DCRGraphGrammarParser.IdOneOrMoreContext ctx);
	/**
	 * Enter a parse tree produced by {@link DCRGraphGrammarParser#idSeq}.
	 * @param ctx the parse tree
	 */
	void enterIdSeq(DCRGraphGrammarParser.IdSeqContext ctx);
	/**
	 * Exit a parse tree produced by {@link DCRGraphGrammarParser#idSeq}.
	 * @param ctx the parse tree
	 */
	void exitIdSeq(DCRGraphGrammarParser.IdSeqContext ctx);
}