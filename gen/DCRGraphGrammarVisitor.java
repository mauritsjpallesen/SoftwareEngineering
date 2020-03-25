// Generated from C:/git/SoftwareEngineering/src/main/antlr4/dk/ku/di/oodcr/parser/dcr\DCRGraphGrammar.g4 by ANTLR 4.8

import dk.ku.di.oodcr.graph.*;
import dk.ku.di.oodcr.parser.ast.*;
import java.util.*;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link DCRGraphGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface DCRGraphGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link DCRGraphGrammarParser#graph}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGraph(DCRGraphGrammarParser.GraphContext ctx);
	/**
	 * Visit a parse tree produced by {@link DCRGraphGrammarParser#eventz}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEventz(DCRGraphGrammarParser.EventzContext ctx);
	/**
	 * Visit a parse tree produced by {@link DCRGraphGrammarParser#event}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEvent(DCRGraphGrammarParser.EventContext ctx);
	/**
	 * Visit a parse tree produced by {@link DCRGraphGrammarParser#relationships}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationships(DCRGraphGrammarParser.RelationshipsContext ctx);
	/**
	 * Visit a parse tree produced by {@link DCRGraphGrammarParser#relationship}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationship(DCRGraphGrammarParser.RelationshipContext ctx);
	/**
	 * Visit a parse tree produced by {@link DCRGraphGrammarParser#conditions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditions(DCRGraphGrammarParser.ConditionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link DCRGraphGrammarParser#milestones}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMilestones(DCRGraphGrammarParser.MilestonesContext ctx);
	/**
	 * Visit a parse tree produced by {@link DCRGraphGrammarParser#responses}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResponses(DCRGraphGrammarParser.ResponsesContext ctx);
	/**
	 * Visit a parse tree produced by {@link DCRGraphGrammarParser#includes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIncludes(DCRGraphGrammarParser.IncludesContext ctx);
	/**
	 * Visit a parse tree produced by {@link DCRGraphGrammarParser#excludes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExcludes(DCRGraphGrammarParser.ExcludesContext ctx);
	/**
	 * Visit a parse tree produced by {@link DCRGraphGrammarParser#eventLabel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEventLabel(DCRGraphGrammarParser.EventLabelContext ctx);
	/**
	 * Visit a parse tree produced by {@link DCRGraphGrammarParser#idOneOrMore}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdOneOrMore(DCRGraphGrammarParser.IdOneOrMoreContext ctx);
	/**
	 * Visit a parse tree produced by {@link DCRGraphGrammarParser#idSeq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdSeq(DCRGraphGrammarParser.IdSeqContext ctx);
}