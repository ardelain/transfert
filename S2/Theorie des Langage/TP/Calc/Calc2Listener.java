// Generated from Calc2.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link Calc2Parser}.
 */
public interface Calc2Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code Parens}
	 * labeled alternative in {@link Calc2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParens(Calc2Parser.ParensContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Parens}
	 * labeled alternative in {@link Calc2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParens(Calc2Parser.ParensContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link Calc2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddSub(Calc2Parser.AddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link Calc2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddSub(Calc2Parser.AddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Int}
	 * labeled alternative in {@link Calc2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterInt(Calc2Parser.IntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Int}
	 * labeled alternative in {@link Calc2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitInt(Calc2Parser.IntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link Calc2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMulDiv(Calc2Parser.MulDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link Calc2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMulDiv(Calc2Parser.MulDivContext ctx);
}