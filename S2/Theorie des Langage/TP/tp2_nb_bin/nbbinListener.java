// Generated from nbbin.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link nbbinParser}.
 */
public interface nbbinListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link nbbinParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(nbbinParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link nbbinParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(nbbinParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link nbbinParser#nbbin}.
	 * @param ctx the parse tree
	 */
	void enterNbbin(nbbinParser.NbbinContext ctx);
	/**
	 * Exit a parse tree produced by {@link nbbinParser#nbbin}.
	 * @param ctx the parse tree
	 */
	void exitNbbin(nbbinParser.NbbinContext ctx);
	/**
	 * Enter a parse tree produced by {@link nbbinParser#suitenbbin}.
	 * @param ctx the parse tree
	 */
	void enterSuitenbbin(nbbinParser.SuitenbbinContext ctx);
	/**
	 * Exit a parse tree produced by {@link nbbinParser#suitenbbin}.
	 * @param ctx the parse tree
	 */
	void exitSuitenbbin(nbbinParser.SuitenbbinContext ctx);
	/**
	 * Enter a parse tree produced by {@link nbbinParser#ret}.
	 * @param ctx the parse tree
	 */
	void enterRet(nbbinParser.RetContext ctx);
	/**
	 * Exit a parse tree produced by {@link nbbinParser#ret}.
	 * @param ctx the parse tree
	 */
	void exitRet(nbbinParser.RetContext ctx);
}