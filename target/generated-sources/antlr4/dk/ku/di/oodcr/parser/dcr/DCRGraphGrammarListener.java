// Generated from dk\ku\di\oodcr\parser\dcr\DCRGraphGrammar.g4 by ANTLR 4.3
package dk.ku.di.oodcr.parser.dcr;

import dk.ku.di.oodcr.graph.*;
import dk.ku.di.oodcr.parser.ast.*;
import java.util.*;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link DCRGraphGrammarParser}.
 */
public interface DCRGraphGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link DCRGraphGrammarParser#excludes}.
	 * @param ctx the parse tree
	 */
	void enterExcludes(@NotNull DCRGraphGrammarParser.ExcludesContext ctx);
	/**
	 * Exit a parse tree produced by {@link DCRGraphGrammarParser#excludes}.
	 * @param ctx the parse tree
	 */
	void exitExcludes(@NotNull DCRGraphGrammarParser.ExcludesContext ctx);

	/**
	 * Enter a parse tree produced by {@link DCRGraphGrammarParser#eventz}.
	 * @param ctx the parse tree
	 */
	void enterEventz(@NotNull DCRGraphGrammarParser.EventzContext ctx);
	/**
	 * Exit a parse tree produced by {@link DCRGraphGrammarParser#eventz}.
	 * @param ctx the parse tree
	 */
	void exitEventz(@NotNull DCRGraphGrammarParser.EventzContext ctx);

	/**
	 * Enter a parse tree produced by {@link DCRGraphGrammarParser#includes}.
	 * @param ctx the parse tree
	 */
	void enterIncludes(@NotNull DCRGraphGrammarParser.IncludesContext ctx);
	/**
	 * Exit a parse tree produced by {@link DCRGraphGrammarParser#includes}.
	 * @param ctx the parse tree
	 */
	void exitIncludes(@NotNull DCRGraphGrammarParser.IncludesContext ctx);

	/**
	 * Enter a parse tree produced by {@link DCRGraphGrammarParser#eventLabel}.
	 * @param ctx the parse tree
	 */
	void enterEventLabel(@NotNull DCRGraphGrammarParser.EventLabelContext ctx);
	/**
	 * Exit a parse tree produced by {@link DCRGraphGrammarParser#eventLabel}.
	 * @param ctx the parse tree
	 */
	void exitEventLabel(@NotNull DCRGraphGrammarParser.EventLabelContext ctx);

	/**
	 * Enter a parse tree produced by {@link DCRGraphGrammarParser#graph}.
	 * @param ctx the parse tree
	 */
	void enterGraph(@NotNull DCRGraphGrammarParser.GraphContext ctx);
	/**
	 * Exit a parse tree produced by {@link DCRGraphGrammarParser#graph}.
	 * @param ctx the parse tree
	 */
	void exitGraph(@NotNull DCRGraphGrammarParser.GraphContext ctx);

	/**
	 * Enter a parse tree produced by {@link DCRGraphGrammarParser#idOneOrMore}.
	 * @param ctx the parse tree
	 */
	void enterIdOneOrMore(@NotNull DCRGraphGrammarParser.IdOneOrMoreContext ctx);
	/**
	 * Exit a parse tree produced by {@link DCRGraphGrammarParser#idOneOrMore}.
	 * @param ctx the parse tree
	 */
	void exitIdOneOrMore(@NotNull DCRGraphGrammarParser.IdOneOrMoreContext ctx);

	/**
	 * Enter a parse tree produced by {@link DCRGraphGrammarParser#relationships}.
	 * @param ctx the parse tree
	 */
	void enterRelationships(@NotNull DCRGraphGrammarParser.RelationshipsContext ctx);
	/**
	 * Exit a parse tree produced by {@link DCRGraphGrammarParser#relationships}.
	 * @param ctx the parse tree
	 */
	void exitRelationships(@NotNull DCRGraphGrammarParser.RelationshipsContext ctx);

	/**
	 * Enter a parse tree produced by {@link DCRGraphGrammarParser#idSeq}.
	 * @param ctx the parse tree
	 */
	void enterIdSeq(@NotNull DCRGraphGrammarParser.IdSeqContext ctx);
	/**
	 * Exit a parse tree produced by {@link DCRGraphGrammarParser#idSeq}.
	 * @param ctx the parse tree
	 */
	void exitIdSeq(@NotNull DCRGraphGrammarParser.IdSeqContext ctx);

	/**
	 * Enter a parse tree produced by {@link DCRGraphGrammarParser#responses}.
	 * @param ctx the parse tree
	 */
	void enterResponses(@NotNull DCRGraphGrammarParser.ResponsesContext ctx);
	/**
	 * Exit a parse tree produced by {@link DCRGraphGrammarParser#responses}.
	 * @param ctx the parse tree
	 */
	void exitResponses(@NotNull DCRGraphGrammarParser.ResponsesContext ctx);

	/**
	 * Enter a parse tree produced by {@link DCRGraphGrammarParser#event}.
	 * @param ctx the parse tree
	 */
	void enterEvent(@NotNull DCRGraphGrammarParser.EventContext ctx);
	/**
	 * Exit a parse tree produced by {@link DCRGraphGrammarParser#event}.
	 * @param ctx the parse tree
	 */
	void exitEvent(@NotNull DCRGraphGrammarParser.EventContext ctx);

	/**
	 * Enter a parse tree produced by {@link DCRGraphGrammarParser#relationship}.
	 * @param ctx the parse tree
	 */
	void enterRelationship(@NotNull DCRGraphGrammarParser.RelationshipContext ctx);
	/**
	 * Exit a parse tree produced by {@link DCRGraphGrammarParser#relationship}.
	 * @param ctx the parse tree
	 */
	void exitRelationship(@NotNull DCRGraphGrammarParser.RelationshipContext ctx);

	/**
	 * Enter a parse tree produced by {@link DCRGraphGrammarParser#conditions}.
	 * @param ctx the parse tree
	 */
	void enterConditions(@NotNull DCRGraphGrammarParser.ConditionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link DCRGraphGrammarParser#conditions}.
	 * @param ctx the parse tree
	 */
	void exitConditions(@NotNull DCRGraphGrammarParser.ConditionsContext ctx);

	/**
	 * Enter a parse tree produced by {@link DCRGraphGrammarParser#milestones}.
	 * @param ctx the parse tree
	 */
	void enterMilestones(@NotNull DCRGraphGrammarParser.MilestonesContext ctx);
	/**
	 * Exit a parse tree produced by {@link DCRGraphGrammarParser#milestones}.
	 * @param ctx the parse tree
	 */
	void exitMilestones(@NotNull DCRGraphGrammarParser.MilestonesContext ctx);
}