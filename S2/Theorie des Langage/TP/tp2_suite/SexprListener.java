// Generated from Sexpr.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SexprParser}.
 */
public interface SexprListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SexprParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(SexprParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link SexprParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(SexprParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link SexprParser#sexpr}.
	 * @param ctx the parse tree
	 */
	void enterSexpr(SexprParser.SexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SexprParser#sexpr}.
	 * @param ctx the parse tree
	 */
	void exitSexpr(SexprParser.SexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link SexprParser#suiteSexpr}.
	 * @param ctx the parse tree
	 */
	void enterSuiteSexpr(SexprParser.SuiteSexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SexprParser#suiteSexpr}.
	 * @param ctx the parse tree
	 */
	void exitSuiteSexpr(SexprParser.SuiteSexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link SexprParser#liste}.
	 * @param ctx the parse tree
	 */
	void enterListe(SexprParser.ListeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SexprParser#liste}.
	 * @param ctx the parse tree
	 */
	void exitListe(SexprParser.ListeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SexprParser#suiteListe}.
	 * @param ctx the parse tree
	 */
	void enterSuiteListe(SexprParser.SuiteListeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SexprParser#suiteListe}.
	 * @param ctx the parse tree
	 */
	void exitSuiteListe(SexprParser.SuiteListeContext ctx);
}