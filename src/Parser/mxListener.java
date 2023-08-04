// Generated from D:/complier/mx_compiler/src/Parser\mx.g4 by ANTLR 4.12.0
package Parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link mxParser}.
 */
public interface mxListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link mxParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(mxParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link mxParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(mxParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link mxParser#mainFn}.
	 * @param ctx the parse tree
	 */
	void enterMainFn(mxParser.MainFnContext ctx);
	/**
	 * Exit a parse tree produced by {@link mxParser#mainFn}.
	 * @param ctx the parse tree
	 */
	void exitMainFn(mxParser.MainFnContext ctx);
	/**
	 * Enter a parse tree produced by {@link mxParser#varDef}.
	 * @param ctx the parse tree
	 */
	void enterVarDef(mxParser.VarDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link mxParser#varDef}.
	 * @param ctx the parse tree
	 */
	void exitVarDef(mxParser.VarDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link mxParser#varTerm}.
	 * @param ctx the parse tree
	 */
	void enterVarTerm(mxParser.VarTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link mxParser#varTerm}.
	 * @param ctx the parse tree
	 */
	void exitVarTerm(mxParser.VarTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link mxParser#classDef}.
	 * @param ctx the parse tree
	 */
	void enterClassDef(mxParser.ClassDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link mxParser#classDef}.
	 * @param ctx the parse tree
	 */
	void exitClassDef(mxParser.ClassDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link mxParser#funcDef}.
	 * @param ctx the parse tree
	 */
	void enterFuncDef(mxParser.FuncDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link mxParser#funcDef}.
	 * @param ctx the parse tree
	 */
	void exitFuncDef(mxParser.FuncDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link mxParser#suite}.
	 * @param ctx the parse tree
	 */
	void enterSuite(mxParser.SuiteContext ctx);
	/**
	 * Exit a parse tree produced by {@link mxParser#suite}.
	 * @param ctx the parse tree
	 */
	void exitSuite(mxParser.SuiteContext ctx);
	/**
	 * Enter a parse tree produced by {@link mxParser#constructStat}.
	 * @param ctx the parse tree
	 */
	void enterConstructStat(mxParser.ConstructStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link mxParser#constructStat}.
	 * @param ctx the parse tree
	 */
	void exitConstructStat(mxParser.ConstructStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code def_statement}
	 * labeled alternative in {@link mxParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterDef_statement(mxParser.Def_statementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code def_statement}
	 * labeled alternative in {@link mxParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitDef_statement(mxParser.Def_statementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code suite_statement}
	 * labeled alternative in {@link mxParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterSuite_statement(mxParser.Suite_statementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code suite_statement}
	 * labeled alternative in {@link mxParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitSuite_statement(mxParser.Suite_statementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code if_statement}
	 * labeled alternative in {@link mxParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterIf_statement(mxParser.If_statementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code if_statement}
	 * labeled alternative in {@link mxParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitIf_statement(mxParser.If_statementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code break_statement}
	 * labeled alternative in {@link mxParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterBreak_statement(mxParser.Break_statementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code break_statement}
	 * labeled alternative in {@link mxParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitBreak_statement(mxParser.Break_statementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code continue_statement}
	 * labeled alternative in {@link mxParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterContinue_statement(mxParser.Continue_statementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code continue_statement}
	 * labeled alternative in {@link mxParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitContinue_statement(mxParser.Continue_statementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code return_statement}
	 * labeled alternative in {@link mxParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterReturn_statement(mxParser.Return_statementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code return_statement}
	 * labeled alternative in {@link mxParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitReturn_statement(mxParser.Return_statementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code while_statement}
	 * labeled alternative in {@link mxParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterWhile_statement(mxParser.While_statementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code while_statement}
	 * labeled alternative in {@link mxParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitWhile_statement(mxParser.While_statementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code forExp_statement}
	 * labeled alternative in {@link mxParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterForExp_statement(mxParser.ForExp_statementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code forExp_statement}
	 * labeled alternative in {@link mxParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitForExp_statement(mxParser.ForExp_statementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code forDef_statement}
	 * labeled alternative in {@link mxParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterForDef_statement(mxParser.ForDef_statementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code forDef_statement}
	 * labeled alternative in {@link mxParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitForDef_statement(mxParser.ForDef_statementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expression_statement}
	 * labeled alternative in {@link mxParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterExpression_statement(mxParser.Expression_statementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expression_statement}
	 * labeled alternative in {@link mxParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitExpression_statement(mxParser.Expression_statementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code empty_statement}
	 * labeled alternative in {@link mxParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterEmpty_statement(mxParser.Empty_statementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code empty_statement}
	 * labeled alternative in {@link mxParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitEmpty_statement(mxParser.Empty_statementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code memberExp}
	 * labeled alternative in {@link mxParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMemberExp(mxParser.MemberExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code memberExp}
	 * labeled alternative in {@link mxParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMemberExp(mxParser.MemberExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code conditional}
	 * labeled alternative in {@link mxParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterConditional(mxParser.ConditionalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code conditional}
	 * labeled alternative in {@link mxParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitConditional(mxParser.ConditionalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code memberFun}
	 * labeled alternative in {@link mxParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMemberFun(mxParser.MemberFunContext ctx);
	/**
	 * Exit a parse tree produced by the {@code memberFun}
	 * labeled alternative in {@link mxParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMemberFun(mxParser.MemberFunContext ctx);
	/**
	 * Enter a parse tree produced by the {@code functionCall}
	 * labeled alternative in {@link mxParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(mxParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functionCall}
	 * labeled alternative in {@link mxParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(mxParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binary}
	 * labeled alternative in {@link mxParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBinary(mxParser.BinaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binary}
	 * labeled alternative in {@link mxParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBinary(mxParser.BinaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code right_inc_dec}
	 * labeled alternative in {@link mxParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterRight_inc_dec(mxParser.Right_inc_decContext ctx);
	/**
	 * Exit a parse tree produced by the {@code right_inc_dec}
	 * labeled alternative in {@link mxParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitRight_inc_dec(mxParser.Right_inc_decContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unary}
	 * labeled alternative in {@link mxParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterUnary(mxParser.UnaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unary}
	 * labeled alternative in {@link mxParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitUnary(mxParser.UnaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayIndex}
	 * labeled alternative in {@link mxParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterArrayIndex(mxParser.ArrayIndexContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayIndex}
	 * labeled alternative in {@link mxParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitArrayIndex(mxParser.ArrayIndexContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parent_expression}
	 * labeled alternative in {@link mxParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParent_expression(mxParser.Parent_expressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parent_expression}
	 * labeled alternative in {@link mxParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParent_expression(mxParser.Parent_expressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code left_inc_dec}
	 * labeled alternative in {@link mxParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLeft_inc_dec(mxParser.Left_inc_decContext ctx);
	/**
	 * Exit a parse tree produced by the {@code left_inc_dec}
	 * labeled alternative in {@link mxParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLeft_inc_dec(mxParser.Left_inc_decContext ctx);
	/**
	 * Enter a parse tree produced by the {@code basic_expression}
	 * labeled alternative in {@link mxParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBasic_expression(mxParser.Basic_expressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code basic_expression}
	 * labeled alternative in {@link mxParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBasic_expression(mxParser.Basic_expressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assign}
	 * labeled alternative in {@link mxParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAssign(mxParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link mxParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAssign(mxParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code constvalue}
	 * labeled alternative in {@link mxParser#basic_expr}.
	 * @param ctx the parse tree
	 */
	void enterConstvalue(mxParser.ConstvalueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code constvalue}
	 * labeled alternative in {@link mxParser#basic_expr}.
	 * @param ctx the parse tree
	 */
	void exitConstvalue(mxParser.ConstvalueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code variable}
	 * labeled alternative in {@link mxParser#basic_expr}.
	 * @param ctx the parse tree
	 */
	void enterVariable(mxParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code variable}
	 * labeled alternative in {@link mxParser#basic_expr}.
	 * @param ctx the parse tree
	 */
	void exitVariable(mxParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code new_expression}
	 * labeled alternative in {@link mxParser#basic_expr}.
	 * @param ctx the parse tree
	 */
	void enterNew_expression(mxParser.New_expressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code new_expression}
	 * labeled alternative in {@link mxParser#basic_expr}.
	 * @param ctx the parse tree
	 */
	void exitNew_expression(mxParser.New_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link mxParser#argu}.
	 * @param ctx the parse tree
	 */
	void enterArgu(mxParser.ArguContext ctx);
	/**
	 * Exit a parse tree produced by {@link mxParser#argu}.
	 * @param ctx the parse tree
	 */
	void exitArgu(mxParser.ArguContext ctx);
	/**
	 * Enter a parse tree produced by {@link mxParser#para}.
	 * @param ctx the parse tree
	 */
	void enterPara(mxParser.ParaContext ctx);
	/**
	 * Exit a parse tree produced by {@link mxParser#para}.
	 * @param ctx the parse tree
	 */
	void exitPara(mxParser.ParaContext ctx);
	/**
	 * Enter a parse tree produced by {@link mxParser#const}.
	 * @param ctx the parse tree
	 */
	void enterConst(mxParser.ConstContext ctx);
	/**
	 * Exit a parse tree produced by {@link mxParser#const}.
	 * @param ctx the parse tree
	 */
	void exitConst(mxParser.ConstContext ctx);
	/**
	 * Enter a parse tree produced by {@link mxParser#typename}.
	 * @param ctx the parse tree
	 */
	void enterTypename(mxParser.TypenameContext ctx);
	/**
	 * Exit a parse tree produced by {@link mxParser#typename}.
	 * @param ctx the parse tree
	 */
	void exitTypename(mxParser.TypenameContext ctx);
	/**
	 * Enter a parse tree produced by {@link mxParser#primitivetype}.
	 * @param ctx the parse tree
	 */
	void enterPrimitivetype(mxParser.PrimitivetypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link mxParser#primitivetype}.
	 * @param ctx the parse tree
	 */
	void exitPrimitivetype(mxParser.PrimitivetypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link mxParser#bracket}.
	 * @param ctx the parse tree
	 */
	void enterBracket(mxParser.BracketContext ctx);
	/**
	 * Exit a parse tree produced by {@link mxParser#bracket}.
	 * @param ctx the parse tree
	 */
	void exitBracket(mxParser.BracketContext ctx);
	/**
	 * Enter a parse tree produced by {@link mxParser#exprbracket}.
	 * @param ctx the parse tree
	 */
	void enterExprbracket(mxParser.ExprbracketContext ctx);
	/**
	 * Exit a parse tree produced by {@link mxParser#exprbracket}.
	 * @param ctx the parse tree
	 */
	void exitExprbracket(mxParser.ExprbracketContext ctx);
	/**
	 * Enter a parse tree produced by {@link mxParser#new_expr}.
	 * @param ctx the parse tree
	 */
	void enterNew_expr(mxParser.New_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link mxParser#new_expr}.
	 * @param ctx the parse tree
	 */
	void exitNew_expr(mxParser.New_exprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newClass}
	 * labeled alternative in {@link mxParser#newTypename}.
	 * @param ctx the parse tree
	 */
	void enterNewClass(mxParser.NewClassContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newClass}
	 * labeled alternative in {@link mxParser#newTypename}.
	 * @param ctx the parse tree
	 */
	void exitNewClass(mxParser.NewClassContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newClassArray}
	 * labeled alternative in {@link mxParser#newTypename}.
	 * @param ctx the parse tree
	 */
	void enterNewClassArray(mxParser.NewClassArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newClassArray}
	 * labeled alternative in {@link mxParser#newTypename}.
	 * @param ctx the parse tree
	 */
	void exitNewClassArray(mxParser.NewClassArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primitiveArray}
	 * labeled alternative in {@link mxParser#newTypename}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveArray(mxParser.PrimitiveArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primitiveArray}
	 * labeled alternative in {@link mxParser#newTypename}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveArray(mxParser.PrimitiveArrayContext ctx);
}