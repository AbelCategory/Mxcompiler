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
		T__0=1, Int=2, Bool=3, Void=4, String=5, If=6, Else=7, For=8, While=9, 
		Break=10, Continue=11, Return=12, Class=13, New=14, True=15, False=16, 
		Null=17, This=18, ID=19, Num=20, Str=21, LineCom=22, BlockCom=23, LeftPa=24, 
		RightPa=25, LeftBracket=26, RightBracket=27, LeftBrace=28, RightBrace=29, 
		Plus=30, Minus=31, Mul=32, Div=33, Mod=34, Gr=35, Le=36, Greq=37, Leeq=38, 
		Eq=39, Neq=40, LogicAnd=41, LogicOr=42, LogicNot=43, BitAnd=44, BitOr=45, 
		BitXor=46, BitNot=47, Lsh=48, Rsh=49, Assign=50, Inc=51, Dec=52, Dot=53, 
		Arrow=54, Que=55, Colon=56, Semi=57, Comma=58, Quo=59, WhiteSpace=60, 
		NewLine=61;
	public static final int
		RULE_program = 0, RULE_mainFn = 1, RULE_varDef = 2, RULE_varTerm = 3, 
		RULE_classDef = 4, RULE_funcDef = 5, RULE_suite = 6, RULE_constructStat = 7, 
		RULE_stat = 8, RULE_expr = 9, RULE_basic_expr = 10, RULE_argu = 11, RULE_para = 12, 
		RULE_const = 13, RULE_typename = 14, RULE_primitivetype = 15, RULE_bracket = 16, 
		RULE_exprbracket = 17, RULE_new_expr = 18, RULE_newTypename = 19;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "mainFn", "varDef", "varTerm", "classDef", "funcDef", "suite", 
			"constructStat", "stat", "expr", "basic_expr", "argu", "para", "const", 
			"typename", "primitivetype", "bracket", "exprbracket", "new_expr", "newTypename"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'main'", "'int'", "'bool'", "'void'", "'string'", "'if'", "'else'", 
			"'for'", "'while'", "'break'", "'continue'", "'return'", "'class'", "'new'", 
			"'true'", "'false'", "'null'", "'this'", null, null, null, null, null, 
			"'('", "')'", "'['", "']'", "'{'", "'}'", "'+'", "'-'", "'*'", "'/'", 
			"'%'", "'>'", "'<'", "'>='", "'<='", "'=='", "'!='", "'&&'", "'||'", 
			"'!'", "'&'", "'|'", "'^'", "'~'", "'<<'", "'>>'", "'='", "'++'", "'--'", 
			"'.'", "'->'", "'?'", "':'", "';'", "','", "'\"'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "Int", "Bool", "Void", "String", "If", "Else", "For", "While", 
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
		public MainFnContext mainFn() {
			return getRuleContext(MainFnContext.class,0);
		}
		public List<ClassDefContext> classDef() {
			return getRuleContexts(ClassDefContext.class);
		}
		public ClassDefContext classDef(int i) {
			return getRuleContext(ClassDefContext.class,i);
		}
		public List<FuncDefContext> funcDef() {
			return getRuleContexts(FuncDefContext.class);
		}
		public FuncDefContext funcDef(int i) {
			return getRuleContext(FuncDefContext.class,i);
		}
		public List<VarDefContext> varDef() {
			return getRuleContexts(VarDefContext.class);
		}
		public VarDefContext varDef(int i) {
			return getRuleContext(VarDefContext.class,i);
		}
		public List<TerminalNode> Semi() { return getTokens(mxParser.Semi); }
		public TerminalNode Semi(int i) {
			return getToken(mxParser.Semi, i);
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
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(45);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
					case 1:
						{
						setState(40);
						classDef();
						}
						break;
					case 2:
						{
						setState(41);
						funcDef();
						}
						break;
					case 3:
						{
						{
						setState(42);
						varDef();
						setState(43);
						match(Semi);
						}
						}
						break;
					}
					} 
				}
				setState(49);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(50);
			mainFn();
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
	public static class MainFnContext extends ParserRuleContext {
		public TerminalNode Int() { return getToken(mxParser.Int, 0); }
		public TerminalNode LeftPa() { return getToken(mxParser.LeftPa, 0); }
		public TerminalNode RightPa() { return getToken(mxParser.RightPa, 0); }
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
		}
		public TerminalNode EOF() { return getToken(mxParser.EOF, 0); }
		public MainFnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mainFn; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterMainFn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitMainFn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitMainFn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MainFnContext mainFn() throws RecognitionException {
		MainFnContext _localctx = new MainFnContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_mainFn);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			match(Int);
			setState(53);
			match(T__0);
			setState(54);
			match(LeftPa);
			setState(55);
			match(RightPa);
			setState(56);
			suite();
			setState(57);
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
			setState(59);
			typename();
			setState(60);
			varTerm();
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(61);
				match(Comma);
				setState(62);
				varTerm();
				}
				}
				setState(67);
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
			setState(68);
			match(ID);
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Assign) {
				{
				setState(69);
				match(Assign);
				setState(70);
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
	public static class ClassDefContext extends ParserRuleContext {
		public TerminalNode Class() { return getToken(mxParser.Class, 0); }
		public TerminalNode ID() { return getToken(mxParser.ID, 0); }
		public TerminalNode LeftBrace() { return getToken(mxParser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(mxParser.RightBrace, 0); }
		public List<TerminalNode> Semi() { return getTokens(mxParser.Semi); }
		public TerminalNode Semi(int i) {
			return getToken(mxParser.Semi, i);
		}
		public List<VarDefContext> varDef() {
			return getRuleContexts(VarDefContext.class);
		}
		public VarDefContext varDef(int i) {
			return getRuleContext(VarDefContext.class,i);
		}
		public List<FuncDefContext> funcDef() {
			return getRuleContexts(FuncDefContext.class);
		}
		public FuncDefContext funcDef(int i) {
			return getRuleContext(FuncDefContext.class,i);
		}
		public List<ConstructStatContext> constructStat() {
			return getRuleContexts(ConstructStatContext.class);
		}
		public ConstructStatContext constructStat(int i) {
			return getRuleContext(ConstructStatContext.class,i);
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
		enterRule(_localctx, 8, RULE_classDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			match(Class);
			setState(74);
			match(ID);
			setState(75);
			match(LeftBrace);
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 524348L) != 0)) {
				{
				setState(81);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(76);
					varDef();
					setState(77);
					match(Semi);
					}
					break;
				case 2:
					{
					setState(79);
					funcDef();
					}
					break;
				case 3:
					{
					setState(80);
					constructStat();
					}
					break;
				}
				}
				setState(85);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(86);
			match(RightBrace);
			setState(87);
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
		enterRule(_localctx, 10, RULE_funcDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			typename();
			setState(90);
			match(ID);
			setState(91);
			match(LeftPa);
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 524348L) != 0)) {
				{
				setState(92);
				para();
				}
			}

			setState(95);
			match(RightPa);
			setState(96);
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
		enterRule(_localctx, 12, RULE_suite);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			match(LeftBrace);
			setState(102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 151020124608913276L) != 0)) {
				{
				{
				setState(99);
				stat();
				}
				}
				setState(104);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(105);
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
		enterRule(_localctx, 14, RULE_constructStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(ID);
			setState(108);
			match(LeftPa);
			setState(109);
			match(RightPa);
			setState(110);
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
		enterRule(_localctx, 16, RULE_stat);
		int _la;
		try {
			setState(174);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				_localctx = new Def_statementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(112);
				varDef();
				setState(113);
				match(Semi);
				}
				break;
			case 2:
				_localctx = new Suite_statementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(115);
				suite();
				}
				break;
			case 3:
				_localctx = new If_statementContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(116);
				match(If);
				setState(117);
				match(LeftPa);
				setState(118);
				expr(0);
				setState(119);
				match(RightPa);
				{
				setState(120);
				((If_statementContext)_localctx).ifstat = stat();
				}
				setState(123);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
				case 1:
					{
					setState(121);
					match(Else);
					{
					setState(122);
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
				setState(125);
				match(Break);
				setState(126);
				match(Semi);
				}
				break;
			case 5:
				_localctx = new Continue_statementContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(127);
				match(Continue);
				setState(128);
				match(Semi);
				}
				break;
			case 6:
				_localctx = new Return_statementContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(129);
				match(Return);
				setState(131);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6904936264613888L) != 0)) {
					{
					setState(130);
					expr(0);
					}
				}

				setState(133);
				match(Semi);
				}
				break;
			case 7:
				_localctx = new While_statementContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(134);
				match(While);
				setState(135);
				match(LeftPa);
				setState(136);
				expr(0);
				setState(137);
				match(RightPa);
				setState(138);
				stat();
				}
				break;
			case 8:
				_localctx = new ForExp_statementContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(140);
				match(For);
				setState(141);
				match(LeftPa);
				setState(143);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6904936264613888L) != 0)) {
					{
					setState(142);
					((ForExp_statementContext)_localctx).init = expr(0);
					}
				}

				setState(145);
				match(Semi);
				setState(147);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6904936264613888L) != 0)) {
					{
					setState(146);
					((ForExp_statementContext)_localctx).cond = expr(0);
					}
				}

				setState(149);
				match(Semi);
				setState(151);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6904936264613888L) != 0)) {
					{
					setState(150);
					((ForExp_statementContext)_localctx).step = expr(0);
					}
				}

				setState(153);
				match(RightPa);
				setState(154);
				stat();
				}
				break;
			case 9:
				_localctx = new ForDef_statementContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(155);
				match(For);
				setState(156);
				match(LeftPa);
				setState(158);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 524348L) != 0)) {
					{
					setState(157);
					((ForDef_statementContext)_localctx).init = varDef();
					}
				}

				setState(160);
				match(Semi);
				setState(162);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6904936264613888L) != 0)) {
					{
					setState(161);
					((ForDef_statementContext)_localctx).cond = expr(0);
					}
				}

				setState(164);
				match(Semi);
				setState(166);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6904936264613888L) != 0)) {
					{
					setState(165);
					((ForDef_statementContext)_localctx).step = expr(0);
					}
				}

				setState(168);
				match(RightPa);
				setState(169);
				stat();
				}
				break;
			case 10:
				_localctx = new Expression_statementContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(170);
				expr(0);
				setState(171);
				match(Semi);
				}
				break;
			case 11:
				_localctx = new Empty_statementContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(173);
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
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				_localctx = new Basic_expressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(177);
				basic_expr();
				}
				break;
			case 2:
				{
				_localctx = new Parent_expressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(178);
				match(LeftPa);
				setState(179);
				expr(0);
				setState(180);
				match(RightPa);
				}
				break;
			case 3:
				{
				_localctx = new FunctionCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(182);
				match(ID);
				setState(183);
				match(LeftPa);
				setState(185);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6904936264613888L) != 0)) {
					{
					setState(184);
					argu();
					}
				}

				setState(187);
				match(RightPa);
				}
				break;
			case 4:
				{
				_localctx = new Right_inc_decContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(188);
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
				setState(189);
				expr(15);
				}
				break;
			case 5:
				{
				_localctx = new UnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(190);
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
				setState(191);
				expr(14);
				}
				break;
			case 6:
				{
				_localctx = new UnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(192);
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
				setState(193);
				expr(13);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(255);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(253);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(196);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(197);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 30064771072L) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(198);
						expr(13);
						}
						break;
					case 2:
						{
						_localctx = new BinaryContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(199);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(200);
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
						setState(201);
						expr(12);
						}
						break;
					case 3:
						{
						_localctx = new BinaryContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(202);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(203);
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
						setState(204);
						expr(11);
						}
						break;
					case 4:
						{
						_localctx = new BinaryContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(205);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(206);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 515396075520L) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(207);
						expr(10);
						}
						break;
					case 5:
						{
						_localctx = new BinaryContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(208);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(209);
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
						setState(210);
						expr(9);
						}
						break;
					case 6:
						{
						_localctx = new BinaryContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(211);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(212);
						((BinaryContext)_localctx).op = match(BitAnd);
						setState(213);
						expr(8);
						}
						break;
					case 7:
						{
						_localctx = new BinaryContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(214);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(215);
						((BinaryContext)_localctx).op = match(BitXor);
						setState(216);
						expr(7);
						}
						break;
					case 8:
						{
						_localctx = new BinaryContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(217);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(218);
						((BinaryContext)_localctx).op = match(BitOr);
						setState(219);
						expr(6);
						}
						break;
					case 9:
						{
						_localctx = new BinaryContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(220);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(221);
						((BinaryContext)_localctx).op = match(LogicAnd);
						setState(222);
						expr(5);
						}
						break;
					case 10:
						{
						_localctx = new BinaryContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(223);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(224);
						((BinaryContext)_localctx).op = match(LogicOr);
						setState(225);
						expr(4);
						}
						break;
					case 11:
						{
						_localctx = new ConditionalContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(226);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(227);
						match(Que);
						setState(228);
						expr(0);
						setState(229);
						match(Colon);
						setState(230);
						expr(2);
						}
						break;
					case 12:
						{
						_localctx = new AssignContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(232);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(233);
						match(Assign);
						setState(234);
						expr(1);
						}
						break;
					case 13:
						{
						_localctx = new ArrayIndexContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(235);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(236);
						match(LeftBracket);
						setState(237);
						expr(0);
						setState(238);
						match(RightBracket);
						}
						break;
					case 14:
						{
						_localctx = new MemberExpContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(240);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(241);
						match(Dot);
						setState(242);
						((MemberExpContext)_localctx).varName = match(ID);
						}
						break;
					case 15:
						{
						_localctx = new MemberFunContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(243);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(244);
						match(Dot);
						setState(245);
						((MemberFunContext)_localctx).funName = match(ID);
						setState(246);
						match(LeftPa);
						setState(248);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6904936264613888L) != 0)) {
							{
							setState(247);
							argu();
							}
						}

						setState(250);
						match(RightPa);
						}
						break;
					case 16:
						{
						_localctx = new Left_inc_decContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(251);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(252);
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
				setState(257);
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
		enterRule(_localctx, 20, RULE_basic_expr);
		try {
			setState(261);
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
				setState(258);
				const_();
				}
				break;
			case ID:
				_localctx = new VariableContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(259);
				match(ID);
				}
				break;
			case New:
				_localctx = new New_expressionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(260);
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
		enterRule(_localctx, 22, RULE_argu);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
			expr(0);
			setState(268);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(264);
				match(Comma);
				setState(265);
				expr(0);
				}
				}
				setState(270);
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
		enterRule(_localctx, 24, RULE_para);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
			typename();
			setState(272);
			match(ID);
			setState(279);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(273);
				match(Comma);
				setState(274);
				typename();
				setState(275);
				match(ID);
				}
				}
				setState(281);
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
		enterRule(_localctx, 26, RULE_const);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(282);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 3637248L) != 0)) ) {
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
		enterRule(_localctx, 28, RULE_typename);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(284);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 524348L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(288);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LeftBracket) {
				{
				{
				setState(285);
				bracket();
				}
				}
				setState(290);
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
		enterRule(_localctx, 30, RULE_primitivetype);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(291);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 60L) != 0)) ) {
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
		enterRule(_localctx, 32, RULE_bracket);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(293);
			match(LeftBracket);
			setState(294);
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
		enterRule(_localctx, 34, RULE_exprbracket);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(296);
			match(LeftBracket);
			setState(297);
			expr(0);
			setState(298);
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
		enterRule(_localctx, 36, RULE_new_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(300);
			match(New);
			setState(301);
			newTypename();
			setState(304);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				{
				setState(302);
				match(LeftPa);
				setState(303);
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
		enterRule(_localctx, 38, RULE_newTypename);
		try {
			int _alt;
			setState(331);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				_localctx = new NewClassContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(306);
				match(ID);
				}
				break;
			case 2:
				_localctx = new NewClassArrayContext(_localctx);
				enterOuterAlt(_localctx, 2);
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
			case 3:
				_localctx = new PrimitiveArrayContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(319);
				primitivetype();
				setState(321); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(320);
						exprbracket();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(323); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(328);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(325);
						bracket();
						}
						} 
					}
					setState(330);
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
		case 9:
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
		"\u0004\u0001=\u014e\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0005\u0000.\b\u0000\n\u0000\f\u00001\t\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0005\u0002@\b\u0002\n\u0002\f\u0002C\t\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0003\u0003H\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004"+
		"R\b\u0004\n\u0004\f\u0004U\t\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005^\b\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0005\u0006"+
		"e\b\u0006\n\u0006\f\u0006h\t\u0006\u0001\u0006\u0001\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003"+
		"\b|\b\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u0084"+
		"\b\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0003\b\u0090\b\b\u0001\b\u0001\b\u0003\b\u0094\b\b\u0001\b"+
		"\u0001\b\u0003\b\u0098\b\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003"+
		"\b\u009f\b\b\u0001\b\u0001\b\u0003\b\u00a3\b\b\u0001\b\u0001\b\u0003\b"+
		"\u00a7\b\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u00af"+
		"\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0003\t\u00ba\b\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0003\t\u00c3\b\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0003\t\u00f9\b\t\u0001\t\u0001\t\u0001\t\u0005\t\u00fe\b\t\n\t\f\t"+
		"\u0101\t\t\u0001\n\u0001\n\u0001\n\u0003\n\u0106\b\n\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0005\u000b\u010b\b\u000b\n\u000b\f\u000b\u010e\t\u000b"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f\u0116\b\f\n\f"+
		"\f\f\u0119\t\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0005\u000e\u011f"+
		"\b\u000e\n\u000e\f\u000e\u0122\t\u000e\u0001\u000f\u0001\u000f\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u0131\b\u0012"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0004\u0013\u0136\b\u0013\u000b\u0013"+
		"\f\u0013\u0137\u0001\u0013\u0005\u0013\u013b\b\u0013\n\u0013\f\u0013\u013e"+
		"\t\u0013\u0001\u0013\u0001\u0013\u0004\u0013\u0142\b\u0013\u000b\u0013"+
		"\f\u0013\u0143\u0001\u0013\u0005\u0013\u0147\b\u0013\n\u0013\f\u0013\u014a"+
		"\t\u0013\u0003\u0013\u014c\b\u0013\u0001\u0013\u0000\u0001\u0012\u0014"+
		"\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a"+
		"\u001c\u001e \"$&\u0000\n\u0001\u000034\u0001\u0000\u001e\u001f\u0002"+
		"\u0000++//\u0001\u0000 \"\u0001\u000001\u0001\u0000#&\u0001\u0000\'(\u0002"+
		"\u0000\u000f\u0012\u0014\u0015\u0002\u0000\u0002\u0005\u0013\u0013\u0001"+
		"\u0000\u0002\u0005\u0178\u0000/\u0001\u0000\u0000\u0000\u00024\u0001\u0000"+
		"\u0000\u0000\u0004;\u0001\u0000\u0000\u0000\u0006D\u0001\u0000\u0000\u0000"+
		"\bI\u0001\u0000\u0000\u0000\nY\u0001\u0000\u0000\u0000\fb\u0001\u0000"+
		"\u0000\u0000\u000ek\u0001\u0000\u0000\u0000\u0010\u00ae\u0001\u0000\u0000"+
		"\u0000\u0012\u00c2\u0001\u0000\u0000\u0000\u0014\u0105\u0001\u0000\u0000"+
		"\u0000\u0016\u0107\u0001\u0000\u0000\u0000\u0018\u010f\u0001\u0000\u0000"+
		"\u0000\u001a\u011a\u0001\u0000\u0000\u0000\u001c\u011c\u0001\u0000\u0000"+
		"\u0000\u001e\u0123\u0001\u0000\u0000\u0000 \u0125\u0001\u0000\u0000\u0000"+
		"\"\u0128\u0001\u0000\u0000\u0000$\u012c\u0001\u0000\u0000\u0000&\u014b"+
		"\u0001\u0000\u0000\u0000(.\u0003\b\u0004\u0000).\u0003\n\u0005\u0000*"+
		"+\u0003\u0004\u0002\u0000+,\u00059\u0000\u0000,.\u0001\u0000\u0000\u0000"+
		"-(\u0001\u0000\u0000\u0000-)\u0001\u0000\u0000\u0000-*\u0001\u0000\u0000"+
		"\u0000.1\u0001\u0000\u0000\u0000/-\u0001\u0000\u0000\u0000/0\u0001\u0000"+
		"\u0000\u000002\u0001\u0000\u0000\u00001/\u0001\u0000\u0000\u000023\u0003"+
		"\u0002\u0001\u00003\u0001\u0001\u0000\u0000\u000045\u0005\u0002\u0000"+
		"\u000056\u0005\u0001\u0000\u000067\u0005\u0018\u0000\u000078\u0005\u0019"+
		"\u0000\u000089\u0003\f\u0006\u00009:\u0005\u0000\u0000\u0001:\u0003\u0001"+
		"\u0000\u0000\u0000;<\u0003\u001c\u000e\u0000<A\u0003\u0006\u0003\u0000"+
		"=>\u0005:\u0000\u0000>@\u0003\u0006\u0003\u0000?=\u0001\u0000\u0000\u0000"+
		"@C\u0001\u0000\u0000\u0000A?\u0001\u0000\u0000\u0000AB\u0001\u0000\u0000"+
		"\u0000B\u0005\u0001\u0000\u0000\u0000CA\u0001\u0000\u0000\u0000DG\u0005"+
		"\u0013\u0000\u0000EF\u00052\u0000\u0000FH\u0003\u0012\t\u0000GE\u0001"+
		"\u0000\u0000\u0000GH\u0001\u0000\u0000\u0000H\u0007\u0001\u0000\u0000"+
		"\u0000IJ\u0005\r\u0000\u0000JK\u0005\u0013\u0000\u0000KS\u0005\u001c\u0000"+
		"\u0000LM\u0003\u0004\u0002\u0000MN\u00059\u0000\u0000NR\u0001\u0000\u0000"+
		"\u0000OR\u0003\n\u0005\u0000PR\u0003\u000e\u0007\u0000QL\u0001\u0000\u0000"+
		"\u0000QO\u0001\u0000\u0000\u0000QP\u0001\u0000\u0000\u0000RU\u0001\u0000"+
		"\u0000\u0000SQ\u0001\u0000\u0000\u0000ST\u0001\u0000\u0000\u0000TV\u0001"+
		"\u0000\u0000\u0000US\u0001\u0000\u0000\u0000VW\u0005\u001d\u0000\u0000"+
		"WX\u00059\u0000\u0000X\t\u0001\u0000\u0000\u0000YZ\u0003\u001c\u000e\u0000"+
		"Z[\u0005\u0013\u0000\u0000[]\u0005\u0018\u0000\u0000\\^\u0003\u0018\f"+
		"\u0000]\\\u0001\u0000\u0000\u0000]^\u0001\u0000\u0000\u0000^_\u0001\u0000"+
		"\u0000\u0000_`\u0005\u0019\u0000\u0000`a\u0003\f\u0006\u0000a\u000b\u0001"+
		"\u0000\u0000\u0000bf\u0005\u001c\u0000\u0000ce\u0003\u0010\b\u0000dc\u0001"+
		"\u0000\u0000\u0000eh\u0001\u0000\u0000\u0000fd\u0001\u0000\u0000\u0000"+
		"fg\u0001\u0000\u0000\u0000gi\u0001\u0000\u0000\u0000hf\u0001\u0000\u0000"+
		"\u0000ij\u0005\u001d\u0000\u0000j\r\u0001\u0000\u0000\u0000kl\u0005\u0013"+
		"\u0000\u0000lm\u0005\u0018\u0000\u0000mn\u0005\u0019\u0000\u0000no\u0003"+
		"\f\u0006\u0000o\u000f\u0001\u0000\u0000\u0000pq\u0003\u0004\u0002\u0000"+
		"qr\u00059\u0000\u0000r\u00af\u0001\u0000\u0000\u0000s\u00af\u0003\f\u0006"+
		"\u0000tu\u0005\u0006\u0000\u0000uv\u0005\u0018\u0000\u0000vw\u0003\u0012"+
		"\t\u0000wx\u0005\u0019\u0000\u0000x{\u0003\u0010\b\u0000yz\u0005\u0007"+
		"\u0000\u0000z|\u0003\u0010\b\u0000{y\u0001\u0000\u0000\u0000{|\u0001\u0000"+
		"\u0000\u0000|\u00af\u0001\u0000\u0000\u0000}~\u0005\n\u0000\u0000~\u00af"+
		"\u00059\u0000\u0000\u007f\u0080\u0005\u000b\u0000\u0000\u0080\u00af\u0005"+
		"9\u0000\u0000\u0081\u0083\u0005\f\u0000\u0000\u0082\u0084\u0003\u0012"+
		"\t\u0000\u0083\u0082\u0001\u0000\u0000\u0000\u0083\u0084\u0001\u0000\u0000"+
		"\u0000\u0084\u0085\u0001\u0000\u0000\u0000\u0085\u00af\u00059\u0000\u0000"+
		"\u0086\u0087\u0005\t\u0000\u0000\u0087\u0088\u0005\u0018\u0000\u0000\u0088"+
		"\u0089\u0003\u0012\t\u0000\u0089\u008a\u0005\u0019\u0000\u0000\u008a\u008b"+
		"\u0003\u0010\b\u0000\u008b\u00af\u0001\u0000\u0000\u0000\u008c\u008d\u0005"+
		"\b\u0000\u0000\u008d\u008f\u0005\u0018\u0000\u0000\u008e\u0090\u0003\u0012"+
		"\t\u0000\u008f\u008e\u0001\u0000\u0000\u0000\u008f\u0090\u0001\u0000\u0000"+
		"\u0000\u0090\u0091\u0001\u0000\u0000\u0000\u0091\u0093\u00059\u0000\u0000"+
		"\u0092\u0094\u0003\u0012\t\u0000\u0093\u0092\u0001\u0000\u0000\u0000\u0093"+
		"\u0094\u0001\u0000\u0000\u0000\u0094\u0095\u0001\u0000\u0000\u0000\u0095"+
		"\u0097\u00059\u0000\u0000\u0096\u0098\u0003\u0012\t\u0000\u0097\u0096"+
		"\u0001\u0000\u0000\u0000\u0097\u0098\u0001\u0000\u0000\u0000\u0098\u0099"+
		"\u0001\u0000\u0000\u0000\u0099\u009a\u0005\u0019\u0000\u0000\u009a\u00af"+
		"\u0003\u0010\b\u0000\u009b\u009c\u0005\b\u0000\u0000\u009c\u009e\u0005"+
		"\u0018\u0000\u0000\u009d\u009f\u0003\u0004\u0002\u0000\u009e\u009d\u0001"+
		"\u0000\u0000\u0000\u009e\u009f\u0001\u0000\u0000\u0000\u009f\u00a0\u0001"+
		"\u0000\u0000\u0000\u00a0\u00a2\u00059\u0000\u0000\u00a1\u00a3\u0003\u0012"+
		"\t\u0000\u00a2\u00a1\u0001\u0000\u0000\u0000\u00a2\u00a3\u0001\u0000\u0000"+
		"\u0000\u00a3\u00a4\u0001\u0000\u0000\u0000\u00a4\u00a6\u00059\u0000\u0000"+
		"\u00a5\u00a7\u0003\u0012\t\u0000\u00a6\u00a5\u0001\u0000\u0000\u0000\u00a6"+
		"\u00a7\u0001\u0000\u0000\u0000\u00a7\u00a8\u0001\u0000\u0000\u0000\u00a8"+
		"\u00a9\u0005\u0019\u0000\u0000\u00a9\u00af\u0003\u0010\b\u0000\u00aa\u00ab"+
		"\u0003\u0012\t\u0000\u00ab\u00ac\u00059\u0000\u0000\u00ac\u00af\u0001"+
		"\u0000\u0000\u0000\u00ad\u00af\u00059\u0000\u0000\u00aep\u0001\u0000\u0000"+
		"\u0000\u00aes\u0001\u0000\u0000\u0000\u00aet\u0001\u0000\u0000\u0000\u00ae"+
		"}\u0001\u0000\u0000\u0000\u00ae\u007f\u0001\u0000\u0000\u0000\u00ae\u0081"+
		"\u0001\u0000\u0000\u0000\u00ae\u0086\u0001\u0000\u0000\u0000\u00ae\u008c"+
		"\u0001\u0000\u0000\u0000\u00ae\u009b\u0001\u0000\u0000\u0000\u00ae\u00aa"+
		"\u0001\u0000\u0000\u0000\u00ae\u00ad\u0001\u0000\u0000\u0000\u00af\u0011"+
		"\u0001\u0000\u0000\u0000\u00b0\u00b1\u0006\t\uffff\uffff\u0000\u00b1\u00c3"+
		"\u0003\u0014\n\u0000\u00b2\u00b3\u0005\u0018\u0000\u0000\u00b3\u00b4\u0003"+
		"\u0012\t\u0000\u00b4\u00b5\u0005\u0019\u0000\u0000\u00b5\u00c3\u0001\u0000"+
		"\u0000\u0000\u00b6\u00b7\u0005\u0013\u0000\u0000\u00b7\u00b9\u0005\u0018"+
		"\u0000\u0000\u00b8\u00ba\u0003\u0016\u000b\u0000\u00b9\u00b8\u0001\u0000"+
		"\u0000\u0000\u00b9\u00ba\u0001\u0000\u0000\u0000\u00ba\u00bb\u0001\u0000"+
		"\u0000\u0000\u00bb\u00c3\u0005\u0019\u0000\u0000\u00bc\u00bd\u0007\u0000"+
		"\u0000\u0000\u00bd\u00c3\u0003\u0012\t\u000f\u00be\u00bf\u0007\u0001\u0000"+
		"\u0000\u00bf\u00c3\u0003\u0012\t\u000e\u00c0\u00c1\u0007\u0002\u0000\u0000"+
		"\u00c1\u00c3\u0003\u0012\t\r\u00c2\u00b0\u0001\u0000\u0000\u0000\u00c2"+
		"\u00b2\u0001\u0000\u0000\u0000\u00c2\u00b6\u0001\u0000\u0000\u0000\u00c2"+
		"\u00bc\u0001\u0000\u0000\u0000\u00c2\u00be\u0001\u0000\u0000\u0000\u00c2"+
		"\u00c0\u0001\u0000\u0000\u0000\u00c3\u00ff\u0001\u0000\u0000\u0000\u00c4"+
		"\u00c5\n\f\u0000\u0000\u00c5\u00c6\u0007\u0003\u0000\u0000\u00c6\u00fe"+
		"\u0003\u0012\t\r\u00c7\u00c8\n\u000b\u0000\u0000\u00c8\u00c9\u0007\u0001"+
		"\u0000\u0000\u00c9\u00fe\u0003\u0012\t\f\u00ca\u00cb\n\n\u0000\u0000\u00cb"+
		"\u00cc\u0007\u0004\u0000\u0000\u00cc\u00fe\u0003\u0012\t\u000b\u00cd\u00ce"+
		"\n\t\u0000\u0000\u00ce\u00cf\u0007\u0005\u0000\u0000\u00cf\u00fe\u0003"+
		"\u0012\t\n\u00d0\u00d1\n\b\u0000\u0000\u00d1\u00d2\u0007\u0006\u0000\u0000"+
		"\u00d2\u00fe\u0003\u0012\t\t\u00d3\u00d4\n\u0007\u0000\u0000\u00d4\u00d5"+
		"\u0005,\u0000\u0000\u00d5\u00fe\u0003\u0012\t\b\u00d6\u00d7\n\u0006\u0000"+
		"\u0000\u00d7\u00d8\u0005.\u0000\u0000\u00d8\u00fe\u0003\u0012\t\u0007"+
		"\u00d9\u00da\n\u0005\u0000\u0000\u00da\u00db\u0005-\u0000\u0000\u00db"+
		"\u00fe\u0003\u0012\t\u0006\u00dc\u00dd\n\u0004\u0000\u0000\u00dd\u00de"+
		"\u0005)\u0000\u0000\u00de\u00fe\u0003\u0012\t\u0005\u00df\u00e0\n\u0003"+
		"\u0000\u0000\u00e0\u00e1\u0005*\u0000\u0000\u00e1\u00fe\u0003\u0012\t"+
		"\u0004\u00e2\u00e3\n\u0002\u0000\u0000\u00e3\u00e4\u00057\u0000\u0000"+
		"\u00e4\u00e5\u0003\u0012\t\u0000\u00e5\u00e6\u00058\u0000\u0000\u00e6"+
		"\u00e7\u0003\u0012\t\u0002\u00e7\u00fe\u0001\u0000\u0000\u0000\u00e8\u00e9"+
		"\n\u0001\u0000\u0000\u00e9\u00ea\u00052\u0000\u0000\u00ea\u00fe\u0003"+
		"\u0012\t\u0001\u00eb\u00ec\n\u0013\u0000\u0000\u00ec\u00ed\u0005\u001a"+
		"\u0000\u0000\u00ed\u00ee\u0003\u0012\t\u0000\u00ee\u00ef\u0005\u001b\u0000"+
		"\u0000\u00ef\u00fe\u0001\u0000\u0000\u0000\u00f0\u00f1\n\u0012\u0000\u0000"+
		"\u00f1\u00f2\u00055\u0000\u0000\u00f2\u00fe\u0005\u0013\u0000\u0000\u00f3"+
		"\u00f4\n\u0011\u0000\u0000\u00f4\u00f5\u00055\u0000\u0000\u00f5\u00f6"+
		"\u0005\u0013\u0000\u0000\u00f6\u00f8\u0005\u0018\u0000\u0000\u00f7\u00f9"+
		"\u0003\u0016\u000b\u0000\u00f8\u00f7\u0001\u0000\u0000\u0000\u00f8\u00f9"+
		"\u0001\u0000\u0000\u0000\u00f9\u00fa\u0001\u0000\u0000\u0000\u00fa\u00fe"+
		"\u0005\u0019\u0000\u0000\u00fb\u00fc\n\u0010\u0000\u0000\u00fc\u00fe\u0007"+
		"\u0000\u0000\u0000\u00fd\u00c4\u0001\u0000\u0000\u0000\u00fd\u00c7\u0001"+
		"\u0000\u0000\u0000\u00fd\u00ca\u0001\u0000\u0000\u0000\u00fd\u00cd\u0001"+
		"\u0000\u0000\u0000\u00fd\u00d0\u0001\u0000\u0000\u0000\u00fd\u00d3\u0001"+
		"\u0000\u0000\u0000\u00fd\u00d6\u0001\u0000\u0000\u0000\u00fd\u00d9\u0001"+
		"\u0000\u0000\u0000\u00fd\u00dc\u0001\u0000\u0000\u0000\u00fd\u00df\u0001"+
		"\u0000\u0000\u0000\u00fd\u00e2\u0001\u0000\u0000\u0000\u00fd\u00e8\u0001"+
		"\u0000\u0000\u0000\u00fd\u00eb\u0001\u0000\u0000\u0000\u00fd\u00f0\u0001"+
		"\u0000\u0000\u0000\u00fd\u00f3\u0001\u0000\u0000\u0000\u00fd\u00fb\u0001"+
		"\u0000\u0000\u0000\u00fe\u0101\u0001\u0000\u0000\u0000\u00ff\u00fd\u0001"+
		"\u0000\u0000\u0000\u00ff\u0100\u0001\u0000\u0000\u0000\u0100\u0013\u0001"+
		"\u0000\u0000\u0000\u0101\u00ff\u0001\u0000\u0000\u0000\u0102\u0106\u0003"+
		"\u001a\r\u0000\u0103\u0106\u0005\u0013\u0000\u0000\u0104\u0106\u0003$"+
		"\u0012\u0000\u0105\u0102\u0001\u0000\u0000\u0000\u0105\u0103\u0001\u0000"+
		"\u0000\u0000\u0105\u0104\u0001\u0000\u0000\u0000\u0106\u0015\u0001\u0000"+
		"\u0000\u0000\u0107\u010c\u0003\u0012\t\u0000\u0108\u0109\u0005:\u0000"+
		"\u0000\u0109\u010b\u0003\u0012\t\u0000\u010a\u0108\u0001\u0000\u0000\u0000"+
		"\u010b\u010e\u0001\u0000\u0000\u0000\u010c\u010a\u0001\u0000\u0000\u0000"+
		"\u010c\u010d\u0001\u0000\u0000\u0000\u010d\u0017\u0001\u0000\u0000\u0000"+
		"\u010e\u010c\u0001\u0000\u0000\u0000\u010f\u0110\u0003\u001c\u000e\u0000"+
		"\u0110\u0117\u0005\u0013\u0000\u0000\u0111\u0112\u0005:\u0000\u0000\u0112"+
		"\u0113\u0003\u001c\u000e\u0000\u0113\u0114\u0005\u0013\u0000\u0000\u0114"+
		"\u0116\u0001\u0000\u0000\u0000\u0115\u0111\u0001\u0000\u0000\u0000\u0116"+
		"\u0119\u0001\u0000\u0000\u0000\u0117\u0115\u0001\u0000\u0000\u0000\u0117"+
		"\u0118\u0001\u0000\u0000\u0000\u0118\u0019\u0001\u0000\u0000\u0000\u0119"+
		"\u0117\u0001\u0000\u0000\u0000\u011a\u011b\u0007\u0007\u0000\u0000\u011b"+
		"\u001b\u0001\u0000\u0000\u0000\u011c\u0120\u0007\b\u0000\u0000\u011d\u011f"+
		"\u0003 \u0010\u0000\u011e\u011d\u0001\u0000\u0000\u0000\u011f\u0122\u0001"+
		"\u0000\u0000\u0000\u0120\u011e\u0001\u0000\u0000\u0000\u0120\u0121\u0001"+
		"\u0000\u0000\u0000\u0121\u001d\u0001\u0000\u0000\u0000\u0122\u0120\u0001"+
		"\u0000\u0000\u0000\u0123\u0124\u0007\t\u0000\u0000\u0124\u001f\u0001\u0000"+
		"\u0000\u0000\u0125\u0126\u0005\u001a\u0000\u0000\u0126\u0127\u0005\u001b"+
		"\u0000\u0000\u0127!\u0001\u0000\u0000\u0000\u0128\u0129\u0005\u001a\u0000"+
		"\u0000\u0129\u012a\u0003\u0012\t\u0000\u012a\u012b\u0005\u001b\u0000\u0000"+
		"\u012b#\u0001\u0000\u0000\u0000\u012c\u012d\u0005\u000e\u0000\u0000\u012d"+
		"\u0130\u0003&\u0013\u0000\u012e\u012f\u0005\u0018\u0000\u0000\u012f\u0131"+
		"\u0005\u0019\u0000\u0000\u0130\u012e\u0001\u0000\u0000\u0000\u0130\u0131"+
		"\u0001\u0000\u0000\u0000\u0131%\u0001\u0000\u0000\u0000\u0132\u014c\u0005"+
		"\u0013\u0000\u0000\u0133\u0135\u0005\u0013\u0000\u0000\u0134\u0136\u0003"+
		"\"\u0011\u0000\u0135\u0134\u0001\u0000\u0000\u0000\u0136\u0137\u0001\u0000"+
		"\u0000\u0000\u0137\u0135\u0001\u0000\u0000\u0000\u0137\u0138\u0001\u0000"+
		"\u0000\u0000\u0138\u013c\u0001\u0000\u0000\u0000\u0139\u013b\u0003 \u0010"+
		"\u0000\u013a\u0139\u0001\u0000\u0000\u0000\u013b\u013e\u0001\u0000\u0000"+
		"\u0000\u013c\u013a\u0001\u0000\u0000\u0000\u013c\u013d\u0001\u0000\u0000"+
		"\u0000\u013d\u014c\u0001\u0000\u0000\u0000\u013e\u013c\u0001\u0000\u0000"+
		"\u0000\u013f\u0141\u0003\u001e\u000f\u0000\u0140\u0142\u0003\"\u0011\u0000"+
		"\u0141\u0140\u0001\u0000\u0000\u0000\u0142\u0143\u0001\u0000\u0000\u0000"+
		"\u0143\u0141\u0001\u0000\u0000\u0000\u0143\u0144\u0001\u0000\u0000\u0000"+
		"\u0144\u0148\u0001\u0000\u0000\u0000\u0145\u0147\u0003 \u0010\u0000\u0146"+
		"\u0145\u0001\u0000\u0000\u0000\u0147\u014a\u0001\u0000\u0000\u0000\u0148"+
		"\u0146\u0001\u0000\u0000\u0000\u0148\u0149\u0001\u0000\u0000\u0000\u0149"+
		"\u014c\u0001\u0000\u0000\u0000\u014a\u0148\u0001\u0000\u0000\u0000\u014b"+
		"\u0132\u0001\u0000\u0000\u0000\u014b\u0133\u0001\u0000\u0000\u0000\u014b"+
		"\u013f\u0001\u0000\u0000\u0000\u014c\'\u0001\u0000\u0000\u0000 -/AGQS"+
		"]f{\u0083\u008f\u0093\u0097\u009e\u00a2\u00a6\u00ae\u00b9\u00c2\u00f8"+
		"\u00fd\u00ff\u0105\u010c\u0117\u0120\u0130\u0137\u013c\u0143\u0148\u014b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}