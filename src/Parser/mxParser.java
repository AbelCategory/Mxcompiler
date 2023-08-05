// Generated from D:/complier/mx_compiler/src/Parser\mx.g4 by ANTLR 4.12.0
package Parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class mxParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Int=1, Bool=2, Void=3, String=4, If=5, Else=6, For=7, While=8, Break=9, 
		Continue=10, Return=11, Class=12, New=13, True=14, False=15, Null=16, 
		This=17, ID=18, Num=19, Str=20, LineCom=21, BlockCom=22, LeftPa=23, RightPa=24, 
		LeftBracket=25, RightBracket=26, LeftBrace=27, RightBrace=28, Plus=29, 
		Minus=30, Mul=31, Div=32, Mod=33, Gr=34, Le=35, Greq=36, Leeq=37, Eq=38, 
		Neq=39, LogicAnd=40, LogicOr=41, LogicNot=42, BitAnd=43, BitOr=44, BitXor=45, 
		BitNot=46, Lsh=47, Rsh=48, Assign=49, Inc=50, Dec=51, Dot=52, Arrow=53, 
		Que=54, Colon=55, Semi=56, Comma=57, Quo=58, WhiteSpace=59, NewLine=60;
	public static final int
		RULE_program = 0, RULE_def = 1, RULE_varDef = 2, RULE_varTerm = 3, RULE_cdef = 4, 
		RULE_classDef = 5, RULE_funcDef = 6, RULE_suite = 7, RULE_constructStat = 8, 
		RULE_stat = 9, RULE_expr = 10, RULE_basic_expr = 11, RULE_argu = 12, RULE_para = 13, 
		RULE_const = 14, RULE_typename = 15, RULE_primitivetype = 16, RULE_bracket = 17, 
		RULE_exprbracket = 18, RULE_new_expr = 19, RULE_newTypename = 20;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "def", "varDef", "varTerm", "cdef", "classDef", "funcDef", 
			"suite", "constructStat", "stat", "expr", "basic_expr", "argu", "para", 
			"const", "typename", "primitivetype", "bracket", "exprbracket", "new_expr", 
			"newTypename"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'int'", "'bool'", "'void'", "'string'", "'if'", "'else'", "'for'", 
			"'while'", "'break'", "'continue'", "'return'", "'class'", "'new'", "'true'", 
			"'false'", "'null'", "'this'", null, null, null, null, null, "'('", "')'", 
			"'['", "']'", "'{'", "'}'", "'+'", "'-'", "'*'", "'/'", "'%'", "'>'", 
			"'<'", "'>='", "'<='", "'=='", "'!='", "'&&'", "'||'", "'!'", "'&'", 
			"'|'", "'^'", "'~'", "'<<'", "'>>'", "'='", "'++'", "'--'", "'.'", "'->'", 
			"'?'", "':'", "';'", "','", "'\"'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "Int", "Bool", "Void", "String", "If", "Else", "For", "While", 
			"Break", "Continue", "Return", "Class", "New", "True", "False", "Null", 
			"This", "ID", "Num", "Str", "LineCom", "BlockCom", "LeftPa", "RightPa", 
			"LeftBracket", "RightBracket", "LeftBrace", "RightBrace", "Plus", "Minus", 
			"Mul", "Div", "Mod", "Gr", "Le", "Greq", "Leeq", "Eq", "Neq", "LogicAnd", 
			"LogicOr", "LogicNot", "BitAnd", "BitOr", "BitXor", "BitNot", "Lsh", 
			"Rsh", "Assign", "Inc", "Dec", "Dot", "Arrow", "Que", "Colon", "Semi", 
			"Comma", "Quo", "WhiteSpace", "NewLine"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "mx.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public mxParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(mxParser.EOF, 0); }
		public List<DefContext> def() {
			return getRuleContexts(DefContext.class);
		}
		public DefContext def(int i) {
			return getRuleContext(DefContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 266270L) != 0)) {
				{
				{
				setState(42);
				def();
				}
				}
				setState(47);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(48);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DefContext extends ParserRuleContext {
		public ClassDefContext classDef() {
			return getRuleContext(ClassDefContext.class,0);
		}
		public FuncDefContext funcDef() {
			return getRuleContext(FuncDefContext.class,0);
		}
		public VarDefContext varDef() {
			return getRuleContext(VarDefContext.class,0);
		}
		public TerminalNode Semi() { return getToken(mxParser.Semi, 0); }
		public DefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefContext def() throws RecognitionException {
		DefContext _localctx = new DefContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_def);
		try {
			setState(55);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(50);
				classDef();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(51);
				funcDef();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(52);
				varDef();
				setState(53);
				match(Semi);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VarDefContext extends ParserRuleContext {
		public TypenameContext typename() {
			return getRuleContext(TypenameContext.class,0);
		}
		public List<VarTermContext> varTerm() {
			return getRuleContexts(VarTermContext.class);
		}
		public VarTermContext varTerm(int i) {
			return getRuleContext(VarTermContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(mxParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(mxParser.Comma, i);
		}
		public VarDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterVarDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitVarDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitVarDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDefContext varDef() throws RecognitionException {
		VarDefContext _localctx = new VarDefContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_varDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			typename();
			setState(58);
			varTerm();
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(59);
				match(Comma);
				setState(60);
				varTerm();
				}
				}
				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VarTermContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(mxParser.ID, 0); }
		public TerminalNode Assign() { return getToken(mxParser.Assign, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public VarTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varTerm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterVarTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitVarTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitVarTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarTermContext varTerm() throws RecognitionException {
		VarTermContext _localctx = new VarTermContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_varTerm);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			match(ID);
			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Assign) {
				{
				setState(67);
				match(Assign);
				setState(68);
				expr(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CdefContext extends ParserRuleContext {
		public VarDefContext varDef() {
			return getRuleContext(VarDefContext.class,0);
		}
		public TerminalNode Semi() { return getToken(mxParser.Semi, 0); }
		public FuncDefContext funcDef() {
			return getRuleContext(FuncDefContext.class,0);
		}
		public ConstructStatContext constructStat() {
			return getRuleContext(ConstructStatContext.class,0);
		}
		public CdefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cdef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterCdef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitCdef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitCdef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CdefContext cdef() throws RecognitionException {
		CdefContext _localctx = new CdefContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_cdef);
		try {
			setState(76);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(71);
				varDef();
				setState(72);
				match(Semi);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(74);
				funcDef();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(75);
				constructStat();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ClassDefContext extends ParserRuleContext {
		public TerminalNode Class() { return getToken(mxParser.Class, 0); }
		public TerminalNode ID() { return getToken(mxParser.ID, 0); }
		public TerminalNode LeftBrace() { return getToken(mxParser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(mxParser.RightBrace, 0); }
		public TerminalNode Semi() { return getToken(mxParser.Semi, 0); }
		public List<CdefContext> cdef() {
			return getRuleContexts(CdefContext.class);
		}
		public CdefContext cdef(int i) {
			return getRuleContext(CdefContext.class,i);
		}
		public ClassDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterClassDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitClassDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitClassDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDefContext classDef() throws RecognitionException {
		ClassDefContext _localctx = new ClassDefContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_classDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			match(Class);
			setState(79);
			match(ID);
			setState(80);
			match(LeftBrace);
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 262174L) != 0)) {
				{
				{
				setState(81);
				cdef();
				}
				}
				setState(86);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(87);
			match(RightBrace);
			setState(88);
			match(Semi);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FuncDefContext extends ParserRuleContext {
		public TypenameContext typename() {
			return getRuleContext(TypenameContext.class,0);
		}
		public TerminalNode ID() { return getToken(mxParser.ID, 0); }
		public TerminalNode LeftPa() { return getToken(mxParser.LeftPa, 0); }
		public TerminalNode RightPa() { return getToken(mxParser.RightPa, 0); }
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
		}
		public ParaContext para() {
			return getRuleContext(ParaContext.class,0);
		}
		public FuncDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterFuncDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitFuncDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitFuncDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncDefContext funcDef() throws RecognitionException {
		FuncDefContext _localctx = new FuncDefContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_funcDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			typename();
			setState(91);
			match(ID);
			setState(92);
			match(LeftPa);
			setState(94);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 262174L) != 0)) {
				{
				setState(93);
				para();
				}
			}

			setState(96);
			match(RightPa);
			setState(97);
			suite();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SuiteContext extends ParserRuleContext {
		public TerminalNode LeftBrace() { return getToken(mxParser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(mxParser.RightBrace, 0); }
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public SuiteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_suite; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterSuite(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitSuite(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitSuite(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SuiteContext suite() throws RecognitionException {
		SuiteContext _localctx = new SuiteContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_suite);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			match(LeftBrace);
			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 75510062304456638L) != 0)) {
				{
				{
				setState(100);
				stat();
				}
				}
				setState(105);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(106);
			match(RightBrace);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConstructStatContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(mxParser.ID, 0); }
		public TerminalNode LeftPa() { return getToken(mxParser.LeftPa, 0); }
		public TerminalNode RightPa() { return getToken(mxParser.RightPa, 0); }
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
		}
		public ConstructStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterConstructStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitConstructStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitConstructStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstructStatContext constructStat() throws RecognitionException {
		ConstructStatContext _localctx = new ConstructStatContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_constructStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			match(ID);
			setState(109);
			match(LeftPa);
			setState(110);
			match(RightPa);
			setState(111);
			suite();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatContext extends ParserRuleContext {
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
	 
		public StatContext() { }
		public void copyFrom(StatContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Suite_statementContext extends StatContext {
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
		}
		public Suite_statementContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterSuite_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitSuite_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitSuite_statement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Continue_statementContext extends StatContext {
		public TerminalNode Continue() { return getToken(mxParser.Continue, 0); }
		public TerminalNode Semi() { return getToken(mxParser.Semi, 0); }
		public Continue_statementContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterContinue_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitContinue_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitContinue_statement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ForExp_statementContext extends StatContext {
		public ExprContext init;
		public ExprContext cond;
		public ExprContext step;
		public TerminalNode For() { return getToken(mxParser.For, 0); }
		public TerminalNode LeftPa() { return getToken(mxParser.LeftPa, 0); }
		public List<TerminalNode> Semi() { return getTokens(mxParser.Semi); }
		public TerminalNode Semi(int i) {
			return getToken(mxParser.Semi, i);
		}
		public TerminalNode RightPa() { return getToken(mxParser.RightPa, 0); }
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ForExp_statementContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterForExp_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitForExp_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitForExp_statement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Expression_statementContext extends StatContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode Semi() { return getToken(mxParser.Semi, 0); }
		public Expression_statementContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterExpression_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitExpression_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitExpression_statement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Def_statementContext extends StatContext {
		public VarDefContext varDef() {
			return getRuleContext(VarDefContext.class,0);
		}
		public TerminalNode Semi() { return getToken(mxParser.Semi, 0); }
		public Def_statementContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterDef_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitDef_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitDef_statement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class If_statementContext extends StatContext {
		public StatContext ifstat;
		public StatContext elsestat;
		public TerminalNode If() { return getToken(mxParser.If, 0); }
		public TerminalNode LeftPa() { return getToken(mxParser.LeftPa, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RightPa() { return getToken(mxParser.RightPa, 0); }
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public TerminalNode Else() { return getToken(mxParser.Else, 0); }
		public If_statementContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterIf_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitIf_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitIf_statement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class While_statementContext extends StatContext {
		public TerminalNode While() { return getToken(mxParser.While, 0); }
		public TerminalNode LeftPa() { return getToken(mxParser.LeftPa, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RightPa() { return getToken(mxParser.RightPa, 0); }
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public While_statementContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterWhile_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitWhile_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitWhile_statement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ForDef_statementContext extends StatContext {
		public VarDefContext init;
		public ExprContext cond;
		public ExprContext step;
		public TerminalNode For() { return getToken(mxParser.For, 0); }
		public TerminalNode LeftPa() { return getToken(mxParser.LeftPa, 0); }
		public List<TerminalNode> Semi() { return getTokens(mxParser.Semi); }
		public TerminalNode Semi(int i) {
			return getToken(mxParser.Semi, i);
		}
		public TerminalNode RightPa() { return getToken(mxParser.RightPa, 0); }
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public VarDefContext varDef() {
			return getRuleContext(VarDefContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ForDef_statementContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterForDef_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitForDef_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitForDef_statement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Break_statementContext extends StatContext {
		public TerminalNode Break() { return getToken(mxParser.Break, 0); }
		public TerminalNode Semi() { return getToken(mxParser.Semi, 0); }
		public Break_statementContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterBreak_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitBreak_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitBreak_statement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Return_statementContext extends StatContext {
		public TerminalNode Return() { return getToken(mxParser.Return, 0); }
		public TerminalNode Semi() { return getToken(mxParser.Semi, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Return_statementContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterReturn_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitReturn_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitReturn_statement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Empty_statementContext extends StatContext {
		public TerminalNode Semi() { return getToken(mxParser.Semi, 0); }
		public Empty_statementContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterEmpty_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitEmpty_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitEmpty_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_stat);
		int _la;
		try {
			setState(175);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				_localctx = new Def_statementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(113);
				varDef();
				setState(114);
				match(Semi);
				}
				break;
			case 2:
				_localctx = new Suite_statementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(116);
				suite();
				}
				break;
			case 3:
				_localctx = new If_statementContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(117);
				match(If);
				setState(118);
				match(LeftPa);
				setState(119);
				expr(0);
				setState(120);
				match(RightPa);
				{
				setState(121);
				((If_statementContext)_localctx).ifstat = stat();
				}
				setState(124);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
				case 1:
					{
					setState(122);
					match(Else);
					{
					setState(123);
					((If_statementContext)_localctx).elsestat = stat();
					}
					}
					break;
				}
				}
				break;
			case 4:
				_localctx = new Break_statementContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(126);
				match(Break);
				setState(127);
				match(Semi);
				}
				break;
			case 5:
				_localctx = new Continue_statementContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(128);
				match(Continue);
				setState(129);
				match(Semi);
				}
				break;
			case 6:
				_localctx = new Return_statementContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(130);
				match(Return);
				setState(132);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3452468132306944L) != 0)) {
					{
					setState(131);
					expr(0);
					}
				}

				setState(134);
				match(Semi);
				}
				break;
			case 7:
				_localctx = new While_statementContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(135);
				match(While);
				setState(136);
				match(LeftPa);
				setState(137);
				expr(0);
				setState(138);
				match(RightPa);
				setState(139);
				stat();
				}
				break;
			case 8:
				_localctx = new ForExp_statementContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(141);
				match(For);
				setState(142);
				match(LeftPa);
				setState(144);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3452468132306944L) != 0)) {
					{
					setState(143);
					((ForExp_statementContext)_localctx).init = expr(0);
					}
				}

				setState(146);
				match(Semi);
				setState(148);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3452468132306944L) != 0)) {
					{
					setState(147);
					((ForExp_statementContext)_localctx).cond = expr(0);
					}
				}

				setState(150);
				match(Semi);
				setState(152);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3452468132306944L) != 0)) {
					{
					setState(151);
					((ForExp_statementContext)_localctx).step = expr(0);
					}
				}

				setState(154);
				match(RightPa);
				setState(155);
				stat();
				}
				break;
			case 9:
				_localctx = new ForDef_statementContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(156);
				match(For);
				setState(157);
				match(LeftPa);
				setState(159);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 262174L) != 0)) {
					{
					setState(158);
					((ForDef_statementContext)_localctx).init = varDef();
					}
				}

				setState(161);
				match(Semi);
				setState(163);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3452468132306944L) != 0)) {
					{
					setState(162);
					((ForDef_statementContext)_localctx).cond = expr(0);
					}
				}

				setState(165);
				match(Semi);
				setState(167);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3452468132306944L) != 0)) {
					{
					setState(166);
					((ForDef_statementContext)_localctx).step = expr(0);
					}
				}

				setState(169);
				match(RightPa);
				setState(170);
				stat();
				}
				break;
			case 10:
				_localctx = new Expression_statementContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(171);
				expr(0);
				setState(172);
				match(Semi);
				}
				break;
			case 11:
				_localctx = new Empty_statementContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(174);
				match(Semi);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MemberExpContext extends ExprContext {
		public Token varName;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode Dot() { return getToken(mxParser.Dot, 0); }
		public TerminalNode ID() { return getToken(mxParser.ID, 0); }
		public MemberExpContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterMemberExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitMemberExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitMemberExp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ConditionalContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode Que() { return getToken(mxParser.Que, 0); }
		public TerminalNode Colon() { return getToken(mxParser.Colon, 0); }
		public ConditionalContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterConditional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitConditional(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitConditional(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MemberFunContext extends ExprContext {
		public Token funName;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode Dot() { return getToken(mxParser.Dot, 0); }
		public TerminalNode LeftPa() { return getToken(mxParser.LeftPa, 0); }
		public TerminalNode RightPa() { return getToken(mxParser.RightPa, 0); }
		public TerminalNode ID() { return getToken(mxParser.ID, 0); }
		public ArguContext argu() {
			return getRuleContext(ArguContext.class,0);
		}
		public MemberFunContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterMemberFun(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitMemberFun(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitMemberFun(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunctionCallContext extends ExprContext {
		public TerminalNode ID() { return getToken(mxParser.ID, 0); }
		public TerminalNode LeftPa() { return getToken(mxParser.LeftPa, 0); }
		public TerminalNode RightPa() { return getToken(mxParser.RightPa, 0); }
		public ArguContext argu() {
			return getRuleContext(ArguContext.class,0);
		}
		public FunctionCallContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitFunctionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BinaryContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode Mul() { return getToken(mxParser.Mul, 0); }
		public TerminalNode Div() { return getToken(mxParser.Div, 0); }
		public TerminalNode Mod() { return getToken(mxParser.Mod, 0); }
		public TerminalNode Plus() { return getToken(mxParser.Plus, 0); }
		public TerminalNode Minus() { return getToken(mxParser.Minus, 0); }
		public TerminalNode Lsh() { return getToken(mxParser.Lsh, 0); }
		public TerminalNode Rsh() { return getToken(mxParser.Rsh, 0); }
		public TerminalNode Le() { return getToken(mxParser.Le, 0); }
		public TerminalNode Leeq() { return getToken(mxParser.Leeq, 0); }
		public TerminalNode Gr() { return getToken(mxParser.Gr, 0); }
		public TerminalNode Greq() { return getToken(mxParser.Greq, 0); }
		public TerminalNode Eq() { return getToken(mxParser.Eq, 0); }
		public TerminalNode Neq() { return getToken(mxParser.Neq, 0); }
		public TerminalNode BitAnd() { return getToken(mxParser.BitAnd, 0); }
		public TerminalNode BitXor() { return getToken(mxParser.BitXor, 0); }
		public TerminalNode BitOr() { return getToken(mxParser.BitOr, 0); }
		public TerminalNode LogicAnd() { return getToken(mxParser.LogicAnd, 0); }
		public TerminalNode LogicOr() { return getToken(mxParser.LogicOr, 0); }
		public BinaryContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterBinary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitBinary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitBinary(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Right_inc_decContext extends ExprContext {
		public Token op;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode Dec() { return getToken(mxParser.Dec, 0); }
		public TerminalNode Inc() { return getToken(mxParser.Inc, 0); }
		public Right_inc_decContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterRight_inc_dec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitRight_inc_dec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitRight_inc_dec(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UnaryContext extends ExprContext {
		public Token op;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode Plus() { return getToken(mxParser.Plus, 0); }
		public TerminalNode Minus() { return getToken(mxParser.Minus, 0); }
		public TerminalNode LogicNot() { return getToken(mxParser.LogicNot, 0); }
		public TerminalNode BitNot() { return getToken(mxParser.BitNot, 0); }
		public UnaryContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterUnary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitUnary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitUnary(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArrayIndexContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LeftBracket() { return getToken(mxParser.LeftBracket, 0); }
		public TerminalNode RightBracket() { return getToken(mxParser.RightBracket, 0); }
		public ArrayIndexContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterArrayIndex(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitArrayIndex(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitArrayIndex(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Parent_expressionContext extends ExprContext {
		public TerminalNode LeftPa() { return getToken(mxParser.LeftPa, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RightPa() { return getToken(mxParser.RightPa, 0); }
		public Parent_expressionContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterParent_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitParent_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitParent_expression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Left_inc_decContext extends ExprContext {
		public Token op;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode Dec() { return getToken(mxParser.Dec, 0); }
		public TerminalNode Inc() { return getToken(mxParser.Inc, 0); }
		public Left_inc_decContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterLeft_inc_dec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitLeft_inc_dec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitLeft_inc_dec(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Basic_expressionContext extends ExprContext {
		public Basic_exprContext basic_expr() {
			return getRuleContext(Basic_exprContext.class,0);
		}
		public Basic_expressionContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterBasic_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitBasic_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitBasic_expression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AssignContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode Assign() { return getToken(mxParser.Assign, 0); }
		public AssignContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				_localctx = new Basic_expressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(178);
				basic_expr();
				}
				break;
			case 2:
				{
				_localctx = new Parent_expressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(179);
				match(LeftPa);
				setState(180);
				expr(0);
				setState(181);
				match(RightPa);
				}
				break;
			case 3:
				{
				_localctx = new FunctionCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(183);
				match(ID);
				setState(184);
				match(LeftPa);
				setState(186);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3452468132306944L) != 0)) {
					{
					setState(185);
					argu();
					}
				}

				setState(188);
				match(RightPa);
				}
				break;
			case 4:
				{
				_localctx = new Right_inc_decContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(189);
				((Right_inc_decContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==Inc || _la==Dec) ) {
					((Right_inc_decContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(190);
				expr(15);
				}
				break;
			case 5:
				{
				_localctx = new UnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(191);
				((UnaryContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==Plus || _la==Minus) ) {
					((UnaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(192);
				expr(14);
				}
				break;
			case 6:
				{
				_localctx = new UnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(193);
				((UnaryContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==LogicNot || _la==BitNot) ) {
					((UnaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(194);
				expr(13);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(256);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(254);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(197);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(198);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 15032385536L) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(199);
						expr(13);
						}
						break;
					case 2:
						{
						_localctx = new BinaryContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(200);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(201);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==Plus || _la==Minus) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(202);
						expr(12);
						}
						break;
					case 3:
						{
						_localctx = new BinaryContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(203);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(204);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==Lsh || _la==Rsh) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(205);
						expr(11);
						}
						break;
					case 4:
						{
						_localctx = new BinaryContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(206);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(207);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 257698037760L) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(208);
						expr(10);
						}
						break;
					case 5:
						{
						_localctx = new BinaryContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(209);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(210);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==Eq || _la==Neq) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(211);
						expr(9);
						}
						break;
					case 6:
						{
						_localctx = new BinaryContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(212);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(213);
						((BinaryContext)_localctx).op = match(BitAnd);
						setState(214);
						expr(8);
						}
						break;
					case 7:
						{
						_localctx = new BinaryContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(215);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(216);
						((BinaryContext)_localctx).op = match(BitXor);
						setState(217);
						expr(7);
						}
						break;
					case 8:
						{
						_localctx = new BinaryContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(218);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(219);
						((BinaryContext)_localctx).op = match(BitOr);
						setState(220);
						expr(6);
						}
						break;
					case 9:
						{
						_localctx = new BinaryContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(221);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(222);
						((BinaryContext)_localctx).op = match(LogicAnd);
						setState(223);
						expr(5);
						}
						break;
					case 10:
						{
						_localctx = new BinaryContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(224);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(225);
						((BinaryContext)_localctx).op = match(LogicOr);
						setState(226);
						expr(4);
						}
						break;
					case 11:
						{
						_localctx = new ConditionalContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(227);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(228);
						match(Que);
						setState(229);
						expr(0);
						setState(230);
						match(Colon);
						setState(231);
						expr(2);
						}
						break;
					case 12:
						{
						_localctx = new AssignContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(233);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(234);
						match(Assign);
						setState(235);
						expr(1);
						}
						break;
					case 13:
						{
						_localctx = new ArrayIndexContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(236);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(237);
						match(LeftBracket);
						setState(238);
						expr(0);
						setState(239);
						match(RightBracket);
						}
						break;
					case 14:
						{
						_localctx = new MemberExpContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(241);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(242);
						match(Dot);
						setState(243);
						((MemberExpContext)_localctx).varName = match(ID);
						}
						break;
					case 15:
						{
						_localctx = new MemberFunContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(244);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(245);
						match(Dot);
						setState(246);
						((MemberFunContext)_localctx).funName = match(ID);
						setState(247);
						match(LeftPa);
						setState(249);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3452468132306944L) != 0)) {
							{
							setState(248);
							argu();
							}
						}

						setState(251);
						match(RightPa);
						}
						break;
					case 16:
						{
						_localctx = new Left_inc_decContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(252);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(253);
						((Left_inc_decContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==Inc || _la==Dec) ) {
							((Left_inc_decContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						break;
					}
					} 
				}
				setState(258);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Basic_exprContext extends ParserRuleContext {
		public Basic_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_basic_expr; }
	 
		public Basic_exprContext() { }
		public void copyFrom(Basic_exprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ConstvalueContext extends Basic_exprContext {
		public ConstContext const_() {
			return getRuleContext(ConstContext.class,0);
		}
		public ConstvalueContext(Basic_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterConstvalue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitConstvalue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitConstvalue(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VariableContext extends Basic_exprContext {
		public TerminalNode ID() { return getToken(mxParser.ID, 0); }
		public VariableContext(Basic_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class New_expressionContext extends Basic_exprContext {
		public New_exprContext new_expr() {
			return getRuleContext(New_exprContext.class,0);
		}
		public New_expressionContext(Basic_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterNew_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitNew_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitNew_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Basic_exprContext basic_expr() throws RecognitionException {
		Basic_exprContext _localctx = new Basic_exprContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_basic_expr);
		try {
			setState(262);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case True:
			case False:
			case Null:
			case This:
			case Num:
			case Str:
				_localctx = new ConstvalueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(259);
				const_();
				}
				break;
			case ID:
				_localctx = new VariableContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(260);
				match(ID);
				}
				break;
			case New:
				_localctx = new New_expressionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(261);
				new_expr();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArguContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(mxParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(mxParser.Comma, i);
		}
		public ArguContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argu; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterArgu(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitArgu(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitArgu(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArguContext argu() throws RecognitionException {
		ArguContext _localctx = new ArguContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_argu);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
			expr(0);
			setState(269);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(265);
				match(Comma);
				setState(266);
				expr(0);
				}
				}
				setState(271);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParaContext extends ParserRuleContext {
		public List<TypenameContext> typename() {
			return getRuleContexts(TypenameContext.class);
		}
		public TypenameContext typename(int i) {
			return getRuleContext(TypenameContext.class,i);
		}
		public List<TerminalNode> ID() { return getTokens(mxParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(mxParser.ID, i);
		}
		public List<TerminalNode> Comma() { return getTokens(mxParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(mxParser.Comma, i);
		}
		public ParaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_para; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterPara(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitPara(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitPara(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParaContext para() throws RecognitionException {
		ParaContext _localctx = new ParaContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_para);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(272);
			typename();
			setState(273);
			match(ID);
			setState(280);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(274);
				match(Comma);
				setState(275);
				typename();
				setState(276);
				match(ID);
				}
				}
				setState(282);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConstContext extends ParserRuleContext {
		public TerminalNode Num() { return getToken(mxParser.Num, 0); }
		public TerminalNode True() { return getToken(mxParser.True, 0); }
		public TerminalNode False() { return getToken(mxParser.False, 0); }
		public TerminalNode Str() { return getToken(mxParser.Str, 0); }
		public TerminalNode Null() { return getToken(mxParser.Null, 0); }
		public TerminalNode This() { return getToken(mxParser.This, 0); }
		public ConstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_const; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterConst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitConst(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitConst(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstContext const_() throws RecognitionException {
		ConstContext _localctx = new ConstContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_const);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(283);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1818624L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypenameContext extends ParserRuleContext {
		public TerminalNode Int() { return getToken(mxParser.Int, 0); }
		public TerminalNode Bool() { return getToken(mxParser.Bool, 0); }
		public TerminalNode Void() { return getToken(mxParser.Void, 0); }
		public TerminalNode String() { return getToken(mxParser.String, 0); }
		public TerminalNode ID() { return getToken(mxParser.ID, 0); }
		public List<BracketContext> bracket() {
			return getRuleContexts(BracketContext.class);
		}
		public BracketContext bracket(int i) {
			return getRuleContext(BracketContext.class,i);
		}
		public TypenameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typename; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterTypename(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitTypename(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitTypename(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypenameContext typename() throws RecognitionException {
		TypenameContext _localctx = new TypenameContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_typename);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 262174L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(289);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LeftBracket) {
				{
				{
				setState(286);
				bracket();
				}
				}
				setState(291);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrimitivetypeContext extends ParserRuleContext {
		public TerminalNode Int() { return getToken(mxParser.Int, 0); }
		public TerminalNode Bool() { return getToken(mxParser.Bool, 0); }
		public TerminalNode Void() { return getToken(mxParser.Void, 0); }
		public TerminalNode String() { return getToken(mxParser.String, 0); }
		public PrimitivetypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitivetype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterPrimitivetype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitPrimitivetype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitPrimitivetype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimitivetypeContext primitivetype() throws RecognitionException {
		PrimitivetypeContext _localctx = new PrimitivetypeContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_primitivetype);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(292);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 30L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BracketContext extends ParserRuleContext {
		public TerminalNode LeftBracket() { return getToken(mxParser.LeftBracket, 0); }
		public TerminalNode RightBracket() { return getToken(mxParser.RightBracket, 0); }
		public BracketContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bracket; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterBracket(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitBracket(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitBracket(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BracketContext bracket() throws RecognitionException {
		BracketContext _localctx = new BracketContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_bracket);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(294);
			match(LeftBracket);
			setState(295);
			match(RightBracket);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprbracketContext extends ParserRuleContext {
		public TerminalNode LeftBracket() { return getToken(mxParser.LeftBracket, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RightBracket() { return getToken(mxParser.RightBracket, 0); }
		public ExprbracketContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprbracket; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterExprbracket(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitExprbracket(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitExprbracket(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprbracketContext exprbracket() throws RecognitionException {
		ExprbracketContext _localctx = new ExprbracketContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_exprbracket);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(297);
			match(LeftBracket);
			setState(298);
			expr(0);
			setState(299);
			match(RightBracket);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class New_exprContext extends ParserRuleContext {
		public TerminalNode New() { return getToken(mxParser.New, 0); }
		public NewTypenameContext newTypename() {
			return getRuleContext(NewTypenameContext.class,0);
		}
		public TerminalNode LeftPa() { return getToken(mxParser.LeftPa, 0); }
		public TerminalNode RightPa() { return getToken(mxParser.RightPa, 0); }
		public New_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_new_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterNew_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitNew_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitNew_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final New_exprContext new_expr() throws RecognitionException {
		New_exprContext _localctx = new New_exprContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_new_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(301);
			match(New);
			setState(302);
			newTypename();
			setState(305);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				{
				setState(303);
				match(LeftPa);
				setState(304);
				match(RightPa);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NewTypenameContext extends ParserRuleContext {
		public NewTypenameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newTypename; }
	 
		public NewTypenameContext() { }
		public void copyFrom(NewTypenameContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NewClassContext extends NewTypenameContext {
		public TerminalNode ID() { return getToken(mxParser.ID, 0); }
		public NewClassContext(NewTypenameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterNewClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitNewClass(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitNewClass(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NewClassArrayContext extends NewTypenameContext {
		public TerminalNode ID() { return getToken(mxParser.ID, 0); }
		public List<ExprbracketContext> exprbracket() {
			return getRuleContexts(ExprbracketContext.class);
		}
		public ExprbracketContext exprbracket(int i) {
			return getRuleContext(ExprbracketContext.class,i);
		}
		public List<BracketContext> bracket() {
			return getRuleContexts(BracketContext.class);
		}
		public BracketContext bracket(int i) {
			return getRuleContext(BracketContext.class,i);
		}
		public NewClassArrayContext(NewTypenameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterNewClassArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitNewClassArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitNewClassArray(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrimitiveArrayContext extends NewTypenameContext {
		public PrimitivetypeContext primitivetype() {
			return getRuleContext(PrimitivetypeContext.class,0);
		}
		public List<ExprbracketContext> exprbracket() {
			return getRuleContexts(ExprbracketContext.class);
		}
		public ExprbracketContext exprbracket(int i) {
			return getRuleContext(ExprbracketContext.class,i);
		}
		public List<BracketContext> bracket() {
			return getRuleContexts(BracketContext.class);
		}
		public BracketContext bracket(int i) {
			return getRuleContext(BracketContext.class,i);
		}
		public PrimitiveArrayContext(NewTypenameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterPrimitiveArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitPrimitiveArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitPrimitiveArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NewTypenameContext newTypename() throws RecognitionException {
		NewTypenameContext _localctx = new NewTypenameContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_newTypename);
		try {
			int _alt;
			setState(332);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				_localctx = new NewClassArrayContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(307);
				match(ID);
				setState(309); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(308);
						exprbracket();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(311); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(316);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(313);
						bracket();
						}
						} 
					}
					setState(318);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
				}
				}
				break;
			case 2:
				_localctx = new NewClassContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(319);
				match(ID);
				}
				break;
			case 3:
				_localctx = new PrimitiveArrayContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(320);
				primitivetype();
				setState(322); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(321);
						exprbracket();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(324); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(329);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(326);
						bracket();
						}
						} 
					}
					setState(331);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 10:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 12);
		case 1:
			return precpred(_ctx, 11);
		case 2:
			return precpred(_ctx, 10);
		case 3:
			return precpred(_ctx, 9);
		case 4:
			return precpred(_ctx, 8);
		case 5:
			return precpred(_ctx, 7);
		case 6:
			return precpred(_ctx, 6);
		case 7:
			return precpred(_ctx, 5);
		case 8:
			return precpred(_ctx, 4);
		case 9:
			return precpred(_ctx, 3);
		case 10:
			return precpred(_ctx, 2);
		case 11:
			return precpred(_ctx, 1);
		case 12:
			return precpred(_ctx, 19);
		case 13:
			return precpred(_ctx, 18);
		case 14:
			return precpred(_ctx, 17);
		case 15:
			return precpred(_ctx, 16);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001<\u014f\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0001\u0000\u0005\u0000"+
		",\b\u0000\n\u0000\f\u0000/\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u00018\b\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002>\b\u0002"+
		"\n\u0002\f\u0002A\t\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003"+
		"F\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0003\u0004M\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0005\u0005S\b\u0005\n\u0005\f\u0005V\t\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006"+
		"_\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007"+
		"\u0005\u0007f\b\u0007\n\u0007\f\u0007i\t\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t}\b"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u0085\b\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0003\t\u0091\b\t\u0001\t\u0001\t\u0003\t\u0095\b\t\u0001\t\u0001\t"+
		"\u0003\t\u0099\b\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u00a0"+
		"\b\t\u0001\t\u0001\t\u0003\t\u00a4\b\t\u0001\t\u0001\t\u0003\t\u00a8\b"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u00b0\b\t\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003"+
		"\n\u00bb\b\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003"+
		"\n\u00c4\b\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003"+
		"\n\u00fa\b\n\u0001\n\u0001\n\u0001\n\u0005\n\u00ff\b\n\n\n\f\n\u0102\t"+
		"\n\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u0107\b\u000b\u0001"+
		"\f\u0001\f\u0001\f\u0005\f\u010c\b\f\n\f\f\f\u010f\t\f\u0001\r\u0001\r"+
		"\u0001\r\u0001\r\u0001\r\u0001\r\u0005\r\u0117\b\r\n\r\f\r\u011a\t\r\u0001"+
		"\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0005\u000f\u0120\b\u000f\n"+
		"\u000f\f\u000f\u0123\t\u000f\u0001\u0010\u0001\u0010\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u0132\b\u0013\u0001"+
		"\u0014\u0001\u0014\u0004\u0014\u0136\b\u0014\u000b\u0014\f\u0014\u0137"+
		"\u0001\u0014\u0005\u0014\u013b\b\u0014\n\u0014\f\u0014\u013e\t\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0004\u0014\u0143\b\u0014\u000b\u0014\f"+
		"\u0014\u0144\u0001\u0014\u0005\u0014\u0148\b\u0014\n\u0014\f\u0014\u014b"+
		"\t\u0014\u0003\u0014\u014d\b\u0014\u0001\u0014\u0000\u0001\u0014\u0015"+
		"\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a"+
		"\u001c\u001e \"$&(\u0000\n\u0001\u000023\u0001\u0000\u001d\u001e\u0002"+
		"\u0000**..\u0001\u0000\u001f!\u0001\u0000/0\u0001\u0000\"%\u0001\u0000"+
		"&\'\u0002\u0000\u000e\u0011\u0013\u0014\u0002\u0000\u0001\u0004\u0012"+
		"\u0012\u0001\u0000\u0001\u0004\u0178\u0000-\u0001\u0000\u0000\u0000\u0002"+
		"7\u0001\u0000\u0000\u0000\u00049\u0001\u0000\u0000\u0000\u0006B\u0001"+
		"\u0000\u0000\u0000\bL\u0001\u0000\u0000\u0000\nN\u0001\u0000\u0000\u0000"+
		"\fZ\u0001\u0000\u0000\u0000\u000ec\u0001\u0000\u0000\u0000\u0010l\u0001"+
		"\u0000\u0000\u0000\u0012\u00af\u0001\u0000\u0000\u0000\u0014\u00c3\u0001"+
		"\u0000\u0000\u0000\u0016\u0106\u0001\u0000\u0000\u0000\u0018\u0108\u0001"+
		"\u0000\u0000\u0000\u001a\u0110\u0001\u0000\u0000\u0000\u001c\u011b\u0001"+
		"\u0000\u0000\u0000\u001e\u011d\u0001\u0000\u0000\u0000 \u0124\u0001\u0000"+
		"\u0000\u0000\"\u0126\u0001\u0000\u0000\u0000$\u0129\u0001\u0000\u0000"+
		"\u0000&\u012d\u0001\u0000\u0000\u0000(\u014c\u0001\u0000\u0000\u0000*"+
		",\u0003\u0002\u0001\u0000+*\u0001\u0000\u0000\u0000,/\u0001\u0000\u0000"+
		"\u0000-+\u0001\u0000\u0000\u0000-.\u0001\u0000\u0000\u0000.0\u0001\u0000"+
		"\u0000\u0000/-\u0001\u0000\u0000\u000001\u0005\u0000\u0000\u00011\u0001"+
		"\u0001\u0000\u0000\u000028\u0003\n\u0005\u000038\u0003\f\u0006\u00004"+
		"5\u0003\u0004\u0002\u000056\u00058\u0000\u000068\u0001\u0000\u0000\u0000"+
		"72\u0001\u0000\u0000\u000073\u0001\u0000\u0000\u000074\u0001\u0000\u0000"+
		"\u00008\u0003\u0001\u0000\u0000\u00009:\u0003\u001e\u000f\u0000:?\u0003"+
		"\u0006\u0003\u0000;<\u00059\u0000\u0000<>\u0003\u0006\u0003\u0000=;\u0001"+
		"\u0000\u0000\u0000>A\u0001\u0000\u0000\u0000?=\u0001\u0000\u0000\u0000"+
		"?@\u0001\u0000\u0000\u0000@\u0005\u0001\u0000\u0000\u0000A?\u0001\u0000"+
		"\u0000\u0000BE\u0005\u0012\u0000\u0000CD\u00051\u0000\u0000DF\u0003\u0014"+
		"\n\u0000EC\u0001\u0000\u0000\u0000EF\u0001\u0000\u0000\u0000F\u0007\u0001"+
		"\u0000\u0000\u0000GH\u0003\u0004\u0002\u0000HI\u00058\u0000\u0000IM\u0001"+
		"\u0000\u0000\u0000JM\u0003\f\u0006\u0000KM\u0003\u0010\b\u0000LG\u0001"+
		"\u0000\u0000\u0000LJ\u0001\u0000\u0000\u0000LK\u0001\u0000\u0000\u0000"+
		"M\t\u0001\u0000\u0000\u0000NO\u0005\f\u0000\u0000OP\u0005\u0012\u0000"+
		"\u0000PT\u0005\u001b\u0000\u0000QS\u0003\b\u0004\u0000RQ\u0001\u0000\u0000"+
		"\u0000SV\u0001\u0000\u0000\u0000TR\u0001\u0000\u0000\u0000TU\u0001\u0000"+
		"\u0000\u0000UW\u0001\u0000\u0000\u0000VT\u0001\u0000\u0000\u0000WX\u0005"+
		"\u001c\u0000\u0000XY\u00058\u0000\u0000Y\u000b\u0001\u0000\u0000\u0000"+
		"Z[\u0003\u001e\u000f\u0000[\\\u0005\u0012\u0000\u0000\\^\u0005\u0017\u0000"+
		"\u0000]_\u0003\u001a\r\u0000^]\u0001\u0000\u0000\u0000^_\u0001\u0000\u0000"+
		"\u0000_`\u0001\u0000\u0000\u0000`a\u0005\u0018\u0000\u0000ab\u0003\u000e"+
		"\u0007\u0000b\r\u0001\u0000\u0000\u0000cg\u0005\u001b\u0000\u0000df\u0003"+
		"\u0012\t\u0000ed\u0001\u0000\u0000\u0000fi\u0001\u0000\u0000\u0000ge\u0001"+
		"\u0000\u0000\u0000gh\u0001\u0000\u0000\u0000hj\u0001\u0000\u0000\u0000"+
		"ig\u0001\u0000\u0000\u0000jk\u0005\u001c\u0000\u0000k\u000f\u0001\u0000"+
		"\u0000\u0000lm\u0005\u0012\u0000\u0000mn\u0005\u0017\u0000\u0000no\u0005"+
		"\u0018\u0000\u0000op\u0003\u000e\u0007\u0000p\u0011\u0001\u0000\u0000"+
		"\u0000qr\u0003\u0004\u0002\u0000rs\u00058\u0000\u0000s\u00b0\u0001\u0000"+
		"\u0000\u0000t\u00b0\u0003\u000e\u0007\u0000uv\u0005\u0005\u0000\u0000"+
		"vw\u0005\u0017\u0000\u0000wx\u0003\u0014\n\u0000xy\u0005\u0018\u0000\u0000"+
		"y|\u0003\u0012\t\u0000z{\u0005\u0006\u0000\u0000{}\u0003\u0012\t\u0000"+
		"|z\u0001\u0000\u0000\u0000|}\u0001\u0000\u0000\u0000}\u00b0\u0001\u0000"+
		"\u0000\u0000~\u007f\u0005\t\u0000\u0000\u007f\u00b0\u00058\u0000\u0000"+
		"\u0080\u0081\u0005\n\u0000\u0000\u0081\u00b0\u00058\u0000\u0000\u0082"+
		"\u0084\u0005\u000b\u0000\u0000\u0083\u0085\u0003\u0014\n\u0000\u0084\u0083"+
		"\u0001\u0000\u0000\u0000\u0084\u0085\u0001\u0000\u0000\u0000\u0085\u0086"+
		"\u0001\u0000\u0000\u0000\u0086\u00b0\u00058\u0000\u0000\u0087\u0088\u0005"+
		"\b\u0000\u0000\u0088\u0089\u0005\u0017\u0000\u0000\u0089\u008a\u0003\u0014"+
		"\n\u0000\u008a\u008b\u0005\u0018\u0000\u0000\u008b\u008c\u0003\u0012\t"+
		"\u0000\u008c\u00b0\u0001\u0000\u0000\u0000\u008d\u008e\u0005\u0007\u0000"+
		"\u0000\u008e\u0090\u0005\u0017\u0000\u0000\u008f\u0091\u0003\u0014\n\u0000"+
		"\u0090\u008f\u0001\u0000\u0000\u0000\u0090\u0091\u0001\u0000\u0000\u0000"+
		"\u0091\u0092\u0001\u0000\u0000\u0000\u0092\u0094\u00058\u0000\u0000\u0093"+
		"\u0095\u0003\u0014\n\u0000\u0094\u0093\u0001\u0000\u0000\u0000\u0094\u0095"+
		"\u0001\u0000\u0000\u0000\u0095\u0096\u0001\u0000\u0000\u0000\u0096\u0098"+
		"\u00058\u0000\u0000\u0097\u0099\u0003\u0014\n\u0000\u0098\u0097\u0001"+
		"\u0000\u0000\u0000\u0098\u0099\u0001\u0000\u0000\u0000\u0099\u009a\u0001"+
		"\u0000\u0000\u0000\u009a\u009b\u0005\u0018\u0000\u0000\u009b\u00b0\u0003"+
		"\u0012\t\u0000\u009c\u009d\u0005\u0007\u0000\u0000\u009d\u009f\u0005\u0017"+
		"\u0000\u0000\u009e\u00a0\u0003\u0004\u0002\u0000\u009f\u009e\u0001\u0000"+
		"\u0000\u0000\u009f\u00a0\u0001\u0000\u0000\u0000\u00a0\u00a1\u0001\u0000"+
		"\u0000\u0000\u00a1\u00a3\u00058\u0000\u0000\u00a2\u00a4\u0003\u0014\n"+
		"\u0000\u00a3\u00a2\u0001\u0000\u0000\u0000\u00a3\u00a4\u0001\u0000\u0000"+
		"\u0000\u00a4\u00a5\u0001\u0000\u0000\u0000\u00a5\u00a7\u00058\u0000\u0000"+
		"\u00a6\u00a8\u0003\u0014\n\u0000\u00a7\u00a6\u0001\u0000\u0000\u0000\u00a7"+
		"\u00a8\u0001\u0000\u0000\u0000\u00a8\u00a9\u0001\u0000\u0000\u0000\u00a9"+
		"\u00aa\u0005\u0018\u0000\u0000\u00aa\u00b0\u0003\u0012\t\u0000\u00ab\u00ac"+
		"\u0003\u0014\n\u0000\u00ac\u00ad\u00058\u0000\u0000\u00ad\u00b0\u0001"+
		"\u0000\u0000\u0000\u00ae\u00b0\u00058\u0000\u0000\u00afq\u0001\u0000\u0000"+
		"\u0000\u00aft\u0001\u0000\u0000\u0000\u00afu\u0001\u0000\u0000\u0000\u00af"+
		"~\u0001\u0000\u0000\u0000\u00af\u0080\u0001\u0000\u0000\u0000\u00af\u0082"+
		"\u0001\u0000\u0000\u0000\u00af\u0087\u0001\u0000\u0000\u0000\u00af\u008d"+
		"\u0001\u0000\u0000\u0000\u00af\u009c\u0001\u0000\u0000\u0000\u00af\u00ab"+
		"\u0001\u0000\u0000\u0000\u00af\u00ae\u0001\u0000\u0000\u0000\u00b0\u0013"+
		"\u0001\u0000\u0000\u0000\u00b1\u00b2\u0006\n\uffff\uffff\u0000\u00b2\u00c4"+
		"\u0003\u0016\u000b\u0000\u00b3\u00b4\u0005\u0017\u0000\u0000\u00b4\u00b5"+
		"\u0003\u0014\n\u0000\u00b5\u00b6\u0005\u0018\u0000\u0000\u00b6\u00c4\u0001"+
		"\u0000\u0000\u0000\u00b7\u00b8\u0005\u0012\u0000\u0000\u00b8\u00ba\u0005"+
		"\u0017\u0000\u0000\u00b9\u00bb\u0003\u0018\f\u0000\u00ba\u00b9\u0001\u0000"+
		"\u0000\u0000\u00ba\u00bb\u0001\u0000\u0000\u0000\u00bb\u00bc\u0001\u0000"+
		"\u0000\u0000\u00bc\u00c4\u0005\u0018\u0000\u0000\u00bd\u00be\u0007\u0000"+
		"\u0000\u0000\u00be\u00c4\u0003\u0014\n\u000f\u00bf\u00c0\u0007\u0001\u0000"+
		"\u0000\u00c0\u00c4\u0003\u0014\n\u000e\u00c1\u00c2\u0007\u0002\u0000\u0000"+
		"\u00c2\u00c4\u0003\u0014\n\r\u00c3\u00b1\u0001\u0000\u0000\u0000\u00c3"+
		"\u00b3\u0001\u0000\u0000\u0000\u00c3\u00b7\u0001\u0000\u0000\u0000\u00c3"+
		"\u00bd\u0001\u0000\u0000\u0000\u00c3\u00bf\u0001\u0000\u0000\u0000\u00c3"+
		"\u00c1\u0001\u0000\u0000\u0000\u00c4\u0100\u0001\u0000\u0000\u0000\u00c5"+
		"\u00c6\n\f\u0000\u0000\u00c6\u00c7\u0007\u0003\u0000\u0000\u00c7\u00ff"+
		"\u0003\u0014\n\r\u00c8\u00c9\n\u000b\u0000\u0000\u00c9\u00ca\u0007\u0001"+
		"\u0000\u0000\u00ca\u00ff\u0003\u0014\n\f\u00cb\u00cc\n\n\u0000\u0000\u00cc"+
		"\u00cd\u0007\u0004\u0000\u0000\u00cd\u00ff\u0003\u0014\n\u000b\u00ce\u00cf"+
		"\n\t\u0000\u0000\u00cf\u00d0\u0007\u0005\u0000\u0000\u00d0\u00ff\u0003"+
		"\u0014\n\n\u00d1\u00d2\n\b\u0000\u0000\u00d2\u00d3\u0007\u0006\u0000\u0000"+
		"\u00d3\u00ff\u0003\u0014\n\t\u00d4\u00d5\n\u0007\u0000\u0000\u00d5\u00d6"+
		"\u0005+\u0000\u0000\u00d6\u00ff\u0003\u0014\n\b\u00d7\u00d8\n\u0006\u0000"+
		"\u0000\u00d8\u00d9\u0005-\u0000\u0000\u00d9\u00ff\u0003\u0014\n\u0007"+
		"\u00da\u00db\n\u0005\u0000\u0000\u00db\u00dc\u0005,\u0000\u0000\u00dc"+
		"\u00ff\u0003\u0014\n\u0006\u00dd\u00de\n\u0004\u0000\u0000\u00de\u00df"+
		"\u0005(\u0000\u0000\u00df\u00ff\u0003\u0014\n\u0005\u00e0\u00e1\n\u0003"+
		"\u0000\u0000\u00e1\u00e2\u0005)\u0000\u0000\u00e2\u00ff\u0003\u0014\n"+
		"\u0004\u00e3\u00e4\n\u0002\u0000\u0000\u00e4\u00e5\u00056\u0000\u0000"+
		"\u00e5\u00e6\u0003\u0014\n\u0000\u00e6\u00e7\u00057\u0000\u0000\u00e7"+
		"\u00e8\u0003\u0014\n\u0002\u00e8\u00ff\u0001\u0000\u0000\u0000\u00e9\u00ea"+
		"\n\u0001\u0000\u0000\u00ea\u00eb\u00051\u0000\u0000\u00eb\u00ff\u0003"+
		"\u0014\n\u0001\u00ec\u00ed\n\u0013\u0000\u0000\u00ed\u00ee\u0005\u0019"+
		"\u0000\u0000\u00ee\u00ef\u0003\u0014\n\u0000\u00ef\u00f0\u0005\u001a\u0000"+
		"\u0000\u00f0\u00ff\u0001\u0000\u0000\u0000\u00f1\u00f2\n\u0012\u0000\u0000"+
		"\u00f2\u00f3\u00054\u0000\u0000\u00f3\u00ff\u0005\u0012\u0000\u0000\u00f4"+
		"\u00f5\n\u0011\u0000\u0000\u00f5\u00f6\u00054\u0000\u0000\u00f6\u00f7"+
		"\u0005\u0012\u0000\u0000\u00f7\u00f9\u0005\u0017\u0000\u0000\u00f8\u00fa"+
		"\u0003\u0018\f\u0000\u00f9\u00f8\u0001\u0000\u0000\u0000\u00f9\u00fa\u0001"+
		"\u0000\u0000\u0000\u00fa\u00fb\u0001\u0000\u0000\u0000\u00fb\u00ff\u0005"+
		"\u0018\u0000\u0000\u00fc\u00fd\n\u0010\u0000\u0000\u00fd\u00ff\u0007\u0000"+
		"\u0000\u0000\u00fe\u00c5\u0001\u0000\u0000\u0000\u00fe\u00c8\u0001\u0000"+
		"\u0000\u0000\u00fe\u00cb\u0001\u0000\u0000\u0000\u00fe\u00ce\u0001\u0000"+
		"\u0000\u0000\u00fe\u00d1\u0001\u0000\u0000\u0000\u00fe\u00d4\u0001\u0000"+
		"\u0000\u0000\u00fe\u00d7\u0001\u0000\u0000\u0000\u00fe\u00da\u0001\u0000"+
		"\u0000\u0000\u00fe\u00dd\u0001\u0000\u0000\u0000\u00fe\u00e0\u0001\u0000"+
		"\u0000\u0000\u00fe\u00e3\u0001\u0000\u0000\u0000\u00fe\u00e9\u0001\u0000"+
		"\u0000\u0000\u00fe\u00ec\u0001\u0000\u0000\u0000\u00fe\u00f1\u0001\u0000"+
		"\u0000\u0000\u00fe\u00f4\u0001\u0000\u0000\u0000\u00fe\u00fc\u0001\u0000"+
		"\u0000\u0000\u00ff\u0102\u0001\u0000\u0000\u0000\u0100\u00fe\u0001\u0000"+
		"\u0000\u0000\u0100\u0101\u0001\u0000\u0000\u0000\u0101\u0015\u0001\u0000"+
		"\u0000\u0000\u0102\u0100\u0001\u0000\u0000\u0000\u0103\u0107\u0003\u001c"+
		"\u000e\u0000\u0104\u0107\u0005\u0012\u0000\u0000\u0105\u0107\u0003&\u0013"+
		"\u0000\u0106\u0103\u0001\u0000\u0000\u0000\u0106\u0104\u0001\u0000\u0000"+
		"\u0000\u0106\u0105\u0001\u0000\u0000\u0000\u0107\u0017\u0001\u0000\u0000"+
		"\u0000\u0108\u010d\u0003\u0014\n\u0000\u0109\u010a\u00059\u0000\u0000"+
		"\u010a\u010c\u0003\u0014\n\u0000\u010b\u0109\u0001\u0000\u0000\u0000\u010c"+
		"\u010f\u0001\u0000\u0000\u0000\u010d\u010b\u0001\u0000\u0000\u0000\u010d"+
		"\u010e\u0001\u0000\u0000\u0000\u010e\u0019\u0001\u0000\u0000\u0000\u010f"+
		"\u010d\u0001\u0000\u0000\u0000\u0110\u0111\u0003\u001e\u000f\u0000\u0111"+
		"\u0118\u0005\u0012\u0000\u0000\u0112\u0113\u00059\u0000\u0000\u0113\u0114"+
		"\u0003\u001e\u000f\u0000\u0114\u0115\u0005\u0012\u0000\u0000\u0115\u0117"+
		"\u0001\u0000\u0000\u0000\u0116\u0112\u0001\u0000\u0000\u0000\u0117\u011a"+
		"\u0001\u0000\u0000\u0000\u0118\u0116\u0001\u0000\u0000\u0000\u0118\u0119"+
		"\u0001\u0000\u0000\u0000\u0119\u001b\u0001\u0000\u0000\u0000\u011a\u0118"+
		"\u0001\u0000\u0000\u0000\u011b\u011c\u0007\u0007\u0000\u0000\u011c\u001d"+
		"\u0001\u0000\u0000\u0000\u011d\u0121\u0007\b\u0000\u0000\u011e\u0120\u0003"+
		"\"\u0011\u0000\u011f\u011e\u0001\u0000\u0000\u0000\u0120\u0123\u0001\u0000"+
		"\u0000\u0000\u0121\u011f\u0001\u0000\u0000\u0000\u0121\u0122\u0001\u0000"+
		"\u0000\u0000\u0122\u001f\u0001\u0000\u0000\u0000\u0123\u0121\u0001\u0000"+
		"\u0000\u0000\u0124\u0125\u0007\t\u0000\u0000\u0125!\u0001\u0000\u0000"+
		"\u0000\u0126\u0127\u0005\u0019\u0000\u0000\u0127\u0128\u0005\u001a\u0000"+
		"\u0000\u0128#\u0001\u0000\u0000\u0000\u0129\u012a\u0005\u0019\u0000\u0000"+
		"\u012a\u012b\u0003\u0014\n\u0000\u012b\u012c\u0005\u001a\u0000\u0000\u012c"+
		"%\u0001\u0000\u0000\u0000\u012d\u012e\u0005\r\u0000\u0000\u012e\u0131"+
		"\u0003(\u0014\u0000\u012f\u0130\u0005\u0017\u0000\u0000\u0130\u0132\u0005"+
		"\u0018\u0000\u0000\u0131\u012f\u0001\u0000\u0000\u0000\u0131\u0132\u0001"+
		"\u0000\u0000\u0000\u0132\'\u0001\u0000\u0000\u0000\u0133\u0135\u0005\u0012"+
		"\u0000\u0000\u0134\u0136\u0003$\u0012\u0000\u0135\u0134\u0001\u0000\u0000"+
		"\u0000\u0136\u0137\u0001\u0000\u0000\u0000\u0137\u0135\u0001\u0000\u0000"+
		"\u0000\u0137\u0138\u0001\u0000\u0000\u0000\u0138\u013c\u0001\u0000\u0000"+
		"\u0000\u0139\u013b\u0003\"\u0011\u0000\u013a\u0139\u0001\u0000\u0000\u0000"+
		"\u013b\u013e\u0001\u0000\u0000\u0000\u013c\u013a\u0001\u0000\u0000\u0000"+
		"\u013c\u013d\u0001\u0000\u0000\u0000\u013d\u014d\u0001\u0000\u0000\u0000"+
		"\u013e\u013c\u0001\u0000\u0000\u0000\u013f\u014d\u0005\u0012\u0000\u0000"+
		"\u0140\u0142\u0003 \u0010\u0000\u0141\u0143\u0003$\u0012\u0000\u0142\u0141"+
		"\u0001\u0000\u0000\u0000\u0143\u0144\u0001\u0000\u0000\u0000\u0144\u0142"+
		"\u0001\u0000\u0000\u0000\u0144\u0145\u0001\u0000\u0000\u0000\u0145\u0149"+
		"\u0001\u0000\u0000\u0000\u0146\u0148\u0003\"\u0011\u0000\u0147\u0146\u0001"+
		"\u0000\u0000\u0000\u0148\u014b\u0001\u0000\u0000\u0000\u0149\u0147\u0001"+
		"\u0000\u0000\u0000\u0149\u014a\u0001\u0000\u0000\u0000\u014a\u014d\u0001"+
		"\u0000\u0000\u0000\u014b\u0149\u0001\u0000\u0000\u0000\u014c\u0133\u0001"+
		"\u0000\u0000\u0000\u014c\u013f\u0001\u0000\u0000\u0000\u014c\u0140\u0001"+
		"\u0000\u0000\u0000\u014d)\u0001\u0000\u0000\u0000 -7?ELT^g|\u0084\u0090"+
		"\u0094\u0098\u009f\u00a3\u00a7\u00af\u00ba\u00c3\u00f9\u00fe\u0100\u0106"+
		"\u010d\u0118\u0121\u0131\u0137\u013c\u0144\u0149\u014c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}