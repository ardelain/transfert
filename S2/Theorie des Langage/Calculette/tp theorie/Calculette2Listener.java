// Generated from Calculette2.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link Calculette2Parser}.
 */
public interface Calculette2Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link Calculette2Parser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(Calculette2Parser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link Calculette2Parser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(Calculette2Parser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link Calculette2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(Calculette2Parser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link Calculette2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(Calculette2Parser.ExprContext ctx);
}