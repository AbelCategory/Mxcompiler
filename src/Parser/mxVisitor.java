// Generated from D:/complier/mx_compiler/src/Parser\mx.g4 by ANTLR 4.12.0
package Parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link mxParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface mxVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link mxParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(mxParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link mxParser#mainFn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMainFn(mxParser.MainFnContext ctx);
	/**
	 * Visit a parse tree produced by {@link mxParser#varDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDef(mxParser.VarDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link mxParser#varTerm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarTerm(mxParser.VarTermContext ctx);
	/**
	 * Visit a parse tree produced by {@link mxParser#classDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDef(mxParser.ClassDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link mxParser#funcDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDef(mxParser.FuncDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link mxParser#suite}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuite(mxParser.SuiteContext ctx);
	/**
	 * Visit a parse tree produced by {@link mxParser#constructStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructStat(mxParser.ConstructStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code def_statement}
	 * labeled alternative in {@link mxParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDef_statement(mxParser.Def_statementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code suite_statement}
	 * labeled alternative in {@link mxParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuite_statement(mxParser.Suite_statementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code if_statement}
	 * labeled alternative in {@link mxParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_statement(mxParser.If_statementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code break_statement}
	 * labeled alternative in {@link mxParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreak_statement(mxParser.Break_statementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code continue_statement}
	 * labeled alternative in {@link mxParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinue_statement(mxParser.Continue_statementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code return_statement}
	 * labeled alternative in {@link mxParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn_statement(mxParser.Return_statementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code while_statement}
	 * labeled alternative in {@link mxParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_statement(mxParser.While_statementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forExp_statement}
	 * labeled alternative in {@link mxParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForExp_statement(mxParser.ForExp_statementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forDef_statement}
	 * labeled alternative in {@link mxParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForDef_statement(mxParser.ForDef_statementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expression_statement}
	 * labeled alternative in {@link mxParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression_statement(mxParser.Expression_statementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code empty_statement}
	 * labeled alternative in {@link mxParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmpty_statement(mxParser.Empty_statementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code memberExp}
	 * labeled alternative in {@link mxParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberExp(mxParser.MemberExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code conditional}
	 * labeled alternative in {@link mxParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditional(mxParser.ConditionalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code memberFun}
	 * labeled alternative in {@link mxParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberFun(mxParser.MemberFunContext ctx);
	/**
	 * Visit a parse tree produced by the {@code functionCall}
	 * labeled alternative in {@link mxParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(mxParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binary}
	 * labeled alternative in {@link mxParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinary(mxParser.BinaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code right_inc_dec}
	 * labeled alternative in {@link mxParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRight_inc_dec(mxParser.Right_inc_decContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unary}
	 * labeled alternative in {@link mxParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnary(mxParser.UnaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayIndex}
	 * labeled alternative in {@link mxParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayIndex(mxParser.ArrayIndexContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parent_expression}
	 * labeled alternative in {@link mxParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParent_expression(mxParser.Parent_expressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code left_inc_dec}
	 * labeled alternative in {@link mxParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeft_inc_dec(mxParser.Left_inc_decContext ctx);
	/**
	 * Visit a parse tree produced by the {@code basic_expression}
	 * labeled alternative in {@link mxParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasic_expression(mxParser.Basic_expressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link mxParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(mxParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code constvalue}
	 * labeled alternative in {@link mxParser#basic_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstvalue(mxParser.ConstvalueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code variable}
	 * labeled alternative in {@link mxParser#basic_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(mxParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code new_expression}
	 * labeled alternative in {@link mxParser#basic_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNew_expression(mxParser.New_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link mxParser#argu}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgu(mxParser.ArguContext ctx);
	/**
	 * Visit a parse tree produced by {@link mxParser#para}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPara(mxParser.ParaContext ctx);
	/**
	 * Visit a parse tree produced by {@link mxParser#const}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConst(mxParser.ConstContext ctx);
	/**
	 * Visit a parse tree produced by {@link mxParser#typename}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypename(mxParser.TypenameContext ctx);
	/**
	 * Visit a parse tree produced by {@link mxParser#bracket}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBracket(mxParser.BracketContext ctx);
}