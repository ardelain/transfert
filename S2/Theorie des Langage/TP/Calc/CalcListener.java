// Generated from Calc.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CalcParser}.
 */
public interface CalcListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CalcParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(CalcParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalcParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(CalcParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(CalcParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(CalcParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalcParser#somExpr}.
	 * @param ctx the parse tree
	 */
	void enterSomExpr(CalcParser.SomExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalcParser#somExpr}.
	 * @param ctx the parse tree
	 */
	void exitSomExpr(CalcParser.SomExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalcParser#multExpr}.
	 * @param ctx the parse tree
	 */
	void enterMultExpr(CalcParser.MultExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalcParser#multExpr}.
	 * @param ctx the parse tree
	 */
	void exitMultExpr(CalcParser.MultExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalcParser#opExpr}.
	 * @param ctx the parse tree
	 */
	void enterOpExpr(CalcParser.OpExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalcParser#opExpr}.
	 * @param ctx the parse tree
	 */
	void exitOpExpr(CalcParser.OpExprContext ctx);
}