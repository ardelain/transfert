// Generated from CalculetteC.g4 by ANTLR 4.7.2
 import java.util.HashMap;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CalculetteCParser}.
 */
public interface CalculetteCListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CalculetteCParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(CalculetteCParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculetteCParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(CalculetteCParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculetteCParser#calcul}.
	 * @param ctx the parse tree
	 */
	void enterCalcul(CalculetteCParser.CalculContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculetteCParser#calcul}.
	 * @param ctx the parse tree
	 */
	void exitCalcul(CalculetteCParser.CalculContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculetteCParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(CalculetteCParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculetteCParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(CalculetteCParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculetteCParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(CalculetteCParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculetteCParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(CalculetteCParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculetteCParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterInstruction(CalculetteCParser.InstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculetteCParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitInstruction(CalculetteCParser.InstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculetteCParser#assignation}.
	 * @param ctx the parse tree
	 */
	void enterAssignation(CalculetteCParser.AssignationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculetteCParser#assignation}.
	 * @param ctx the parse tree
	 */
	void exitAssignation(CalculetteCParser.AssignationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculetteCParser#finInstruction}.
	 * @param ctx the parse tree
	 */
	void enterFinInstruction(CalculetteCParser.FinInstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculetteCParser#finInstruction}.
	 * @param ctx the parse tree
	 */
	void exitFinInstruction(CalculetteCParser.FinInstructionContext ctx);
}