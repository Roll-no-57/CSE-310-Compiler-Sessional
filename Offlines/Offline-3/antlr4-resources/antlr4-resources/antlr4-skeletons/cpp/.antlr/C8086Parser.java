// Generated from /media/apurbo/New Volume/Academy/CSE-310-Compiler-sessional/Offlines/Offline-3/antlr4-resources/antlr4-resources/antlr4-skeletons/cpp/C8086Parser.g4 by ANTLR 4.13.1

    #include <iostream>
    #include <fstream>
    #include <string>
    #include <cstdlib>
    #include "C8086Lexer.h"
	#include "str_list.cpp"
	#include "rule.cpp"

    extern std::ofstream parserLogFile;
    extern std::ofstream errorFile;

    extern int syntaxErrorCount;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class C8086Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LINE_COMMENT=1, BLOCK_COMMENT=2, STRING=3, WS=4, IF=5, ELSE=6, FOR=7, 
		WHILE=8, PRINTLN=9, RETURN=10, INT=11, FLOAT=12, VOID=13, LPAREN=14, RPAREN=15, 
		LCURL=16, RCURL=17, LTHIRD=18, RTHIRD=19, SEMICOLON=20, COMMA=21, ADDOP=22, 
		SUBOP=23, MULOP=24, INCOP=25, DECOP=26, NOT=27, RELOP=28, LOGICOP=29, 
		ASSIGNOP=30, ID=31, CONST_INT=32, CONST_FLOAT=33;
	public static final int
		RULE_start = 0, RULE_program = 1, RULE_unit = 2, RULE_func_declaration = 3, 
		RULE_func_definition = 4, RULE_parameter_list = 5, RULE_compound_statement = 6, 
		RULE_var_declaration = 7, RULE_declaration_list_err = 8, RULE_type_specifier = 9, 
		RULE_declaration_list = 10, RULE_statements = 11, RULE_statement = 12, 
		RULE_expression_statement = 13, RULE_variable = 14, RULE_expression = 15, 
		RULE_logic_expression = 16, RULE_rel_expression = 17, RULE_simple_expression = 18, 
		RULE_term = 19, RULE_unary_expression = 20, RULE_factor = 21, RULE_argument_list = 22, 
		RULE_arguments = 23;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "program", "unit", "func_declaration", "func_definition", "parameter_list", 
			"compound_statement", "var_declaration", "declaration_list_err", "type_specifier", 
			"declaration_list", "statements", "statement", "expression_statement", 
			"variable", "expression", "logic_expression", "rel_expression", "simple_expression", 
			"term", "unary_expression", "factor", "argument_list", "arguments"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, "'if'", "'else'", "'for'", "'while'", "'println'", 
			"'return'", "'int'", "'float'", "'void'", "'('", "')'", "'{'", "'}'", 
			"'['", "']'", "';'", "','", null, null, null, "'++'", "'--'", "'!'", 
			null, null, "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LINE_COMMENT", "BLOCK_COMMENT", "STRING", "WS", "IF", "ELSE", 
			"FOR", "WHILE", "PRINTLN", "RETURN", "INT", "FLOAT", "VOID", "LPAREN", 
			"RPAREN", "LCURL", "RCURL", "LTHIRD", "RTHIRD", "SEMICOLON", "COMMA", 
			"ADDOP", "SUBOP", "MULOP", "INCOP", "DECOP", "NOT", "RELOP", "LOGICOP", 
			"ASSIGNOP", "ID", "CONST_INT", "CONST_FLOAT"
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
	public String getGrammarFileName() { return "C8086Parser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    void writeIntoparserLogFile(const std::string message) {
	        if (!parserLogFile) {
	            std::cout << "Error opening parserLogFile.txt" << std::endl;
	            return;
	        }

	        parserLogFile << message << std::endl;
	        parserLogFile.flush();
	    }

	    void writeIntoErrorFile(const std::string message) {
	        if (!errorFile) {
	            std::cout << "Error opening errorFile.txt" << std::endl;
	            return;
	        }
	        errorFile << message << std::endl;
	        errorFile.flush();
	    }

		void logRule(const rule& r) {
	        writeIntoparserLogFile(r.toLogString());
	        writeIntoparserLogFile(r.getAppliedCodeLog());
	    }

	public C8086Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StartContext extends ParserRuleContext {
		public ProgramContext program() {
			return getRuleContext(ProgramContext.class,0);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			program(0);

			        writeIntoparserLogFile("Parsing completed successfully with " + std::to_string(syntaxErrorCount) + " syntax errors.");
				
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
	public static class ProgramContext extends ParserRuleContext {
		public UnitContext unit() {
			return getRuleContext(UnitContext.class,0);
		}
		public ProgramContext program() {
			return getRuleContext(ProgramContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		return program(0);
	}

	private ProgramContext program(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ProgramContext _localctx = new ProgramContext(_ctx, _parentState);
		ProgramContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_program, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(52);
			unit();
			}
			_ctx.stop = _input.LT(-1);
			setState(58);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ProgramContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_program);
					setState(54);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(55);
					unit();
					}
					} 
				}
				setState(60);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
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
	public static class UnitContext extends ParserRuleContext {
		public Var_declarationContext var_declaration() {
			return getRuleContext(Var_declarationContext.class,0);
		}
		public Func_declarationContext func_declaration() {
			return getRuleContext(Func_declarationContext.class,0);
		}
		public Func_definitionContext func_definition() {
			return getRuleContext(Func_definitionContext.class,0);
		}
		public UnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unit; }
	}

	public final UnitContext unit() throws RecognitionException {
		UnitContext _localctx = new UnitContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_unit);
		try {
			setState(64);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(61);
				var_declaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(62);
				func_declaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(63);
				func_definition();
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
	public static class Func_declarationContext extends ParserRuleContext {
		public Type_specifierContext type_specifier() {
			return getRuleContext(Type_specifierContext.class,0);
		}
		public TerminalNode ID() { return getToken(C8086Parser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(C8086Parser.LPAREN, 0); }
		public Parameter_listContext parameter_list() {
			return getRuleContext(Parameter_listContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(C8086Parser.RPAREN, 0); }
		public TerminalNode SEMICOLON() { return getToken(C8086Parser.SEMICOLON, 0); }
		public Func_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_declaration; }
	}

	public final Func_declarationContext func_declaration() throws RecognitionException {
		Func_declarationContext _localctx = new Func_declarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_func_declaration);
		try {
			setState(79);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(66);
				type_specifier();
				setState(67);
				match(ID);
				setState(68);
				match(LPAREN);
				setState(69);
				parameter_list(0);
				setState(70);
				match(RPAREN);
				setState(71);
				match(SEMICOLON);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(73);
				type_specifier();
				setState(74);
				match(ID);
				setState(75);
				match(LPAREN);
				setState(76);
				match(RPAREN);
				setState(77);
				match(SEMICOLON);
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
	public static class Func_definitionContext extends ParserRuleContext {
		public Type_specifierContext type_specifier() {
			return getRuleContext(Type_specifierContext.class,0);
		}
		public TerminalNode ID() { return getToken(C8086Parser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(C8086Parser.LPAREN, 0); }
		public Parameter_listContext parameter_list() {
			return getRuleContext(Parameter_listContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(C8086Parser.RPAREN, 0); }
		public Compound_statementContext compound_statement() {
			return getRuleContext(Compound_statementContext.class,0);
		}
		public Func_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_definition; }
	}

	public final Func_definitionContext func_definition() throws RecognitionException {
		Func_definitionContext _localctx = new Func_definitionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_func_definition);
		try {
			setState(94);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(81);
				type_specifier();
				setState(82);
				match(ID);
				setState(83);
				match(LPAREN);
				setState(84);
				parameter_list(0);
				setState(85);
				match(RPAREN);
				setState(86);
				compound_statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(88);
				type_specifier();
				setState(89);
				match(ID);
				setState(90);
				match(LPAREN);
				setState(91);
				match(RPAREN);
				setState(92);
				compound_statement();
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
	public static class Parameter_listContext extends ParserRuleContext {
		public Type_specifierContext type_specifier() {
			return getRuleContext(Type_specifierContext.class,0);
		}
		public TerminalNode ID() { return getToken(C8086Parser.ID, 0); }
		public Parameter_listContext parameter_list() {
			return getRuleContext(Parameter_listContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(C8086Parser.COMMA, 0); }
		public Parameter_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter_list; }
	}

	public final Parameter_listContext parameter_list() throws RecognitionException {
		return parameter_list(0);
	}

	private Parameter_listContext parameter_list(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Parameter_listContext _localctx = new Parameter_listContext(_ctx, _parentState);
		Parameter_listContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_parameter_list, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(97);
				type_specifier();
				setState(98);
				match(ID);
				}
				break;
			case 2:
				{
				setState(100);
				type_specifier();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(113);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(111);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new Parameter_listContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_parameter_list);
						setState(103);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(104);
						match(COMMA);
						setState(105);
						type_specifier();
						setState(106);
						match(ID);
						}
						break;
					case 2:
						{
						_localctx = new Parameter_listContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_parameter_list);
						setState(108);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(109);
						match(COMMA);
						setState(110);
						type_specifier();
						}
						break;
					}
					} 
				}
				setState(115);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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
	public static class Compound_statementContext extends ParserRuleContext {
		public TerminalNode LCURL() { return getToken(C8086Parser.LCURL, 0); }
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public TerminalNode RCURL() { return getToken(C8086Parser.RCURL, 0); }
		public Compound_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compound_statement; }
	}

	public final Compound_statementContext compound_statement() throws RecognitionException {
		Compound_statementContext _localctx = new Compound_statementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_compound_statement);
		try {
			setState(122);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(116);
				match(LCURL);
				setState(117);
				statements(0);
				setState(118);
				match(RCURL);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(120);
				match(LCURL);
				setState(121);
				match(RCURL);
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
	public static class Var_declarationContext extends ParserRuleContext {
		public rule vt;
		public Type_specifierContext t;
		public Declaration_listContext dl;
		public Token sm;
		public Declaration_list_errContext de;
		public Type_specifierContext type_specifier() {
			return getRuleContext(Type_specifierContext.class,0);
		}
		public Declaration_listContext declaration_list() {
			return getRuleContext(Declaration_listContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(C8086Parser.SEMICOLON, 0); }
		public Declaration_list_errContext declaration_list_err() {
			return getRuleContext(Declaration_list_errContext.class,0);
		}
		public Var_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_declaration; }
	}

	public final Var_declarationContext var_declaration() throws RecognitionException {
		Var_declarationContext _localctx = new Var_declarationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_var_declaration);
		try {
			setState(134);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(124);
				((Var_declarationContext)_localctx).t = type_specifier();
				setState(125);
				((Var_declarationContext)_localctx).dl = declaration_list(0);
				setState(126);
				((Var_declarationContext)_localctx).sm = match(SEMICOLON);

						((Var_declarationContext)_localctx).vt =  rule(((Var_declarationContext)_localctx).sm.getLine(), "var_declaration","type_specifier declaration_list SEMICOLON",t.getAppliedCodeLog() + dl.getAppliedCodeLog() + ((Var_declarationContext)_localctx).sm.getText());
						logRule(_localctx.vt);
				      
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(129);
				((Var_declarationContext)_localctx).t = type_specifier();
				setState(130);
				((Var_declarationContext)_localctx).de = declaration_list_err();
				setState(131);
				((Var_declarationContext)_localctx).sm = match(SEMICOLON);

				        writeIntoErrorFile(
				            std::string("Line# ") + std::to_string(((Var_declarationContext)_localctx).sm->getLine()) +
				            " with error name: " + ((Var_declarationContext)_localctx).de.error_name +
				            " - Syntax error at declaration list of variable declaration"
				        );
				        syntaxErrorCount++;
				      
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
	public static class Declaration_list_errContext extends ParserRuleContext {
		public std::string error_name;
		public Declaration_list_errContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration_list_err; }
	}

	public final Declaration_list_errContext declaration_list_err() throws RecognitionException {
		Declaration_list_errContext _localctx = new Declaration_list_errContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_declaration_list_err);
		try {
			enterOuterAlt(_localctx, 1);
			{

			        ((Declaration_list_errContext)_localctx).error_name =  "Error in declaration list";
			    
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
	public static class Type_specifierContext extends ParserRuleContext {
		public rule t;
		public Token INT;
		public Token FLOAT;
		public Token VOID;
		public TerminalNode INT() { return getToken(C8086Parser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(C8086Parser.FLOAT, 0); }
		public TerminalNode VOID() { return getToken(C8086Parser.VOID, 0); }
		public Type_specifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_specifier; }
	}

	public final Type_specifierContext type_specifier() throws RecognitionException {
		Type_specifierContext _localctx = new Type_specifierContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_type_specifier);
		try {
			setState(144);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(138);
				((Type_specifierContext)_localctx).INT = match(INT);

				        ((Type_specifierContext)_localctx).t =  rule(((Type_specifierContext)_localctx).INT->getLine(), "type_specifier", "INT", ((Type_specifierContext)_localctx).INT->getText());
				        logRule(_localctx.t);
				    
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(140);
				((Type_specifierContext)_localctx).FLOAT = match(FLOAT);

				        ((Type_specifierContext)_localctx).t =  rule(((Type_specifierContext)_localctx).FLOAT->getLine(), "type_specifier", "FLOAT", ((Type_specifierContext)_localctx).FLOAT->getText());
				        logRule(_localctx.t);
				    
				}
				break;
			case VOID:
				enterOuterAlt(_localctx, 3);
				{
				setState(142);
				((Type_specifierContext)_localctx).VOID = match(VOID);

				        ((Type_specifierContext)_localctx).t =  rule(((Type_specifierContext)_localctx).VOID->getLine(), "type_specifier", "VOID", ((Type_specifierContext)_localctx).VOID->getText());
				        logRule(_localctx.t);
				    
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
	public static class Declaration_listContext extends ParserRuleContext {
		public rule dt;
		public Token ID;
		public TerminalNode ID() { return getToken(C8086Parser.ID, 0); }
		public TerminalNode LTHIRD() { return getToken(C8086Parser.LTHIRD, 0); }
		public TerminalNode CONST_INT() { return getToken(C8086Parser.CONST_INT, 0); }
		public TerminalNode RTHIRD() { return getToken(C8086Parser.RTHIRD, 0); }
		public Declaration_listContext declaration_list() {
			return getRuleContext(Declaration_listContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(C8086Parser.COMMA, 0); }
		public Declaration_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration_list; }
	}

	public final Declaration_listContext declaration_list() throws RecognitionException {
		return declaration_list(0);
	}

	private Declaration_listContext declaration_list(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Declaration_listContext _localctx = new Declaration_listContext(_ctx, _parentState);
		Declaration_listContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_declaration_list, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(147);
				((Declaration_listContext)_localctx).ID = match(ID);

									((Declaration_listContext)_localctx).dt =  rule(((Declaration_listContext)_localctx).ID->getLine(), "declaration_list", "ID", ((Declaration_listContext)_localctx).ID->getText());
									logRule(_localctx.dt);
								  
				}
				break;
			case 2:
				{
				setState(149);
				((Declaration_listContext)_localctx).ID = match(ID);
				setState(150);
				match(LTHIRD);
				setState(151);
				match(CONST_INT);
				setState(152);
				match(RTHIRD);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(167);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(165);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
						{
						_localctx = new Declaration_listContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_declaration_list);
						setState(155);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(156);
						match(COMMA);
						setState(157);
						((Declaration_listContext)_localctx).ID = match(ID);

						          					((Declaration_listContext)_localctx).dt =  rule(((Declaration_listContext)_localctx).ID->getLine(), "declaration_list", "declaration_list COMMA ID", ((Declaration_listContext)_localctx).ID->getText());
						          					logRule(_localctx.dt);
						          				 
						}
						break;
					case 2:
						{
						_localctx = new Declaration_listContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_declaration_list);
						setState(159);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(160);
						match(COMMA);
						setState(161);
						((Declaration_listContext)_localctx).ID = match(ID);
						setState(162);
						match(LTHIRD);
						setState(163);
						match(CONST_INT);
						setState(164);
						match(RTHIRD);
						}
						break;
					}
					} 
				}
				setState(169);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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
	public static class StatementsContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
	}

	public final StatementsContext statements() throws RecognitionException {
		return statements(0);
	}

	private StatementsContext statements(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		StatementsContext _localctx = new StatementsContext(_ctx, _parentState);
		StatementsContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_statements, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(171);
			statement();
			}
			_ctx.stop = _input.LT(-1);
			setState(177);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new StatementsContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_statements);
					setState(173);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(174);
					statement();
					}
					} 
				}
				setState(179);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
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
	public static class StatementContext extends ParserRuleContext {
		public Var_declarationContext var_declaration() {
			return getRuleContext(Var_declarationContext.class,0);
		}
		public List<Expression_statementContext> expression_statement() {
			return getRuleContexts(Expression_statementContext.class);
		}
		public Expression_statementContext expression_statement(int i) {
			return getRuleContext(Expression_statementContext.class,i);
		}
		public Compound_statementContext compound_statement() {
			return getRuleContext(Compound_statementContext.class,0);
		}
		public TerminalNode FOR() { return getToken(C8086Parser.FOR, 0); }
		public TerminalNode LPAREN() { return getToken(C8086Parser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(C8086Parser.RPAREN, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode IF() { return getToken(C8086Parser.IF, 0); }
		public TerminalNode ELSE() { return getToken(C8086Parser.ELSE, 0); }
		public TerminalNode WHILE() { return getToken(C8086Parser.WHILE, 0); }
		public TerminalNode PRINTLN() { return getToken(C8086Parser.PRINTLN, 0); }
		public TerminalNode ID() { return getToken(C8086Parser.ID, 0); }
		public TerminalNode SEMICOLON() { return getToken(C8086Parser.SEMICOLON, 0); }
		public TerminalNode RETURN() { return getToken(C8086Parser.RETURN, 0); }
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_statement);
		try {
			setState(220);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(180);
				var_declaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(181);
				expression_statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(182);
				compound_statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(183);
				match(FOR);
				setState(184);
				match(LPAREN);
				setState(185);
				expression_statement();
				setState(186);
				expression_statement();
				setState(187);
				expression();
				setState(188);
				match(RPAREN);
				setState(189);
				statement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(191);
				match(IF);
				setState(192);
				match(LPAREN);
				setState(193);
				expression();
				setState(194);
				match(RPAREN);
				setState(195);
				statement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(197);
				match(IF);
				setState(198);
				match(LPAREN);
				setState(199);
				expression();
				setState(200);
				match(RPAREN);
				setState(201);
				statement();
				setState(202);
				match(ELSE);
				setState(203);
				statement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(205);
				match(WHILE);
				setState(206);
				match(LPAREN);
				setState(207);
				expression();
				setState(208);
				match(RPAREN);
				setState(209);
				statement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(211);
				match(PRINTLN);
				setState(212);
				match(LPAREN);
				setState(213);
				match(ID);
				setState(214);
				match(RPAREN);
				setState(215);
				match(SEMICOLON);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(216);
				match(RETURN);
				setState(217);
				expression();
				setState(218);
				match(SEMICOLON);
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
	public static class Expression_statementContext extends ParserRuleContext {
		public TerminalNode SEMICOLON() { return getToken(C8086Parser.SEMICOLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Expression_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression_statement; }
	}

	public final Expression_statementContext expression_statement() throws RecognitionException {
		Expression_statementContext _localctx = new Expression_statementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_expression_statement);
		try {
			setState(226);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SEMICOLON:
				enterOuterAlt(_localctx, 1);
				{
				setState(222);
				match(SEMICOLON);
				}
				break;
			case LPAREN:
			case ADDOP:
			case NOT:
			case ID:
			case CONST_INT:
			case CONST_FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(223);
				expression();
				setState(224);
				match(SEMICOLON);
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
	public static class VariableContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(C8086Parser.ID, 0); }
		public TerminalNode LTHIRD() { return getToken(C8086Parser.LTHIRD, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RTHIRD() { return getToken(C8086Parser.RTHIRD, 0); }
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_variable);
		try {
			setState(234);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(228);
				match(ID);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(229);
				match(ID);
				setState(230);
				match(LTHIRD);
				setState(231);
				expression();
				setState(232);
				match(RTHIRD);
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
	public static class ExpressionContext extends ParserRuleContext {
		public Logic_expressionContext logic_expression() {
			return getRuleContext(Logic_expressionContext.class,0);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode ASSIGNOP() { return getToken(C8086Parser.ASSIGNOP, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_expression);
		try {
			setState(241);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(236);
				logic_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(237);
				variable();
				setState(238);
				match(ASSIGNOP);
				setState(239);
				logic_expression();
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
	public static class Logic_expressionContext extends ParserRuleContext {
		public List<Rel_expressionContext> rel_expression() {
			return getRuleContexts(Rel_expressionContext.class);
		}
		public Rel_expressionContext rel_expression(int i) {
			return getRuleContext(Rel_expressionContext.class,i);
		}
		public TerminalNode LOGICOP() { return getToken(C8086Parser.LOGICOP, 0); }
		public Logic_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logic_expression; }
	}

	public final Logic_expressionContext logic_expression() throws RecognitionException {
		Logic_expressionContext _localctx = new Logic_expressionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_logic_expression);
		try {
			setState(248);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(243);
				rel_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(244);
				rel_expression();
				setState(245);
				match(LOGICOP);
				setState(246);
				rel_expression();
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
	public static class Rel_expressionContext extends ParserRuleContext {
		public List<Simple_expressionContext> simple_expression() {
			return getRuleContexts(Simple_expressionContext.class);
		}
		public Simple_expressionContext simple_expression(int i) {
			return getRuleContext(Simple_expressionContext.class,i);
		}
		public TerminalNode RELOP() { return getToken(C8086Parser.RELOP, 0); }
		public Rel_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rel_expression; }
	}

	public final Rel_expressionContext rel_expression() throws RecognitionException {
		Rel_expressionContext _localctx = new Rel_expressionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_rel_expression);
		try {
			setState(255);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(250);
				simple_expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(251);
				simple_expression(0);
				setState(252);
				match(RELOP);
				setState(253);
				simple_expression(0);
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
	public static class Simple_expressionContext extends ParserRuleContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public Simple_expressionContext simple_expression() {
			return getRuleContext(Simple_expressionContext.class,0);
		}
		public TerminalNode ADDOP() { return getToken(C8086Parser.ADDOP, 0); }
		public Simple_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_expression; }
	}

	public final Simple_expressionContext simple_expression() throws RecognitionException {
		return simple_expression(0);
	}

	private Simple_expressionContext simple_expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Simple_expressionContext _localctx = new Simple_expressionContext(_ctx, _parentState);
		Simple_expressionContext _prevctx = _localctx;
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_simple_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(258);
			term(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(265);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Simple_expressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_simple_expression);
					setState(260);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(261);
					match(ADDOP);
					setState(262);
					term(0);
					}
					} 
				}
				setState(267);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
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
	public static class TermContext extends ParserRuleContext {
		public Unary_expressionContext unary_expression() {
			return getRuleContext(Unary_expressionContext.class,0);
		}
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode MULOP() { return getToken(C8086Parser.MULOP, 0); }
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
	}

	public final TermContext term() throws RecognitionException {
		return term(0);
	}

	private TermContext term(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TermContext _localctx = new TermContext(_ctx, _parentState);
		TermContext _prevctx = _localctx;
		int _startState = 38;
		enterRecursionRule(_localctx, 38, RULE_term, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(269);
			unary_expression();
			}
			_ctx.stop = _input.LT(-1);
			setState(276);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TermContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_term);
					setState(271);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(272);
					match(MULOP);
					setState(273);
					unary_expression();
					}
					} 
				}
				setState(278);
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
	public static class Unary_expressionContext extends ParserRuleContext {
		public TerminalNode ADDOP() { return getToken(C8086Parser.ADDOP, 0); }
		public Unary_expressionContext unary_expression() {
			return getRuleContext(Unary_expressionContext.class,0);
		}
		public TerminalNode NOT() { return getToken(C8086Parser.NOT, 0); }
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public Unary_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_expression; }
	}

	public final Unary_expressionContext unary_expression() throws RecognitionException {
		Unary_expressionContext _localctx = new Unary_expressionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_unary_expression);
		try {
			setState(284);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ADDOP:
				enterOuterAlt(_localctx, 1);
				{
				setState(279);
				match(ADDOP);
				setState(280);
				unary_expression();
				}
				break;
			case NOT:
				enterOuterAlt(_localctx, 2);
				{
				setState(281);
				match(NOT);
				setState(282);
				unary_expression();
				}
				break;
			case LPAREN:
			case ID:
			case CONST_INT:
			case CONST_FLOAT:
				enterOuterAlt(_localctx, 3);
				{
				setState(283);
				factor();
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
	public static class FactorContext extends ParserRuleContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode ID() { return getToken(C8086Parser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(C8086Parser.LPAREN, 0); }
		public Argument_listContext argument_list() {
			return getRuleContext(Argument_listContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(C8086Parser.RPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode CONST_INT() { return getToken(C8086Parser.CONST_INT, 0); }
		public TerminalNode CONST_FLOAT() { return getToken(C8086Parser.CONST_FLOAT, 0); }
		public TerminalNode INCOP() { return getToken(C8086Parser.INCOP, 0); }
		public TerminalNode DECOP() { return getToken(C8086Parser.DECOP, 0); }
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_factor);
		try {
			setState(304);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(286);
				variable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(287);
				match(ID);
				setState(288);
				match(LPAREN);
				setState(289);
				argument_list();
				setState(290);
				match(RPAREN);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(292);
				match(LPAREN);
				setState(293);
				expression();
				setState(294);
				match(RPAREN);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(296);
				match(CONST_INT);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(297);
				match(CONST_FLOAT);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(298);
				variable();
				setState(299);
				match(INCOP);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(301);
				variable();
				setState(302);
				match(DECOP);
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
	public static class Argument_listContext extends ParserRuleContext {
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public Argument_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument_list; }
	}

	public final Argument_listContext argument_list() throws RecognitionException {
		Argument_listContext _localctx = new Argument_listContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_argument_list);
		try {
			setState(308);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
			case ADDOP:
			case NOT:
			case ID:
			case CONST_INT:
			case CONST_FLOAT:
				enterOuterAlt(_localctx, 1);
				{
				setState(306);
				arguments(0);
				}
				break;
			case RPAREN:
				enterOuterAlt(_localctx, 2);
				{
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
	public static class ArgumentsContext extends ParserRuleContext {
		public Logic_expressionContext logic_expression() {
			return getRuleContext(Logic_expressionContext.class,0);
		}
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(C8086Parser.COMMA, 0); }
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		return arguments(0);
	}

	private ArgumentsContext arguments(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, _parentState);
		ArgumentsContext _prevctx = _localctx;
		int _startState = 46;
		enterRecursionRule(_localctx, 46, RULE_arguments, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(311);
			logic_expression();
			}
			_ctx.stop = _input.LT(-1);
			setState(318);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ArgumentsContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_arguments);
					setState(313);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(314);
					match(COMMA);
					setState(315);
					logic_expression();
					}
					} 
				}
				setState(320);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return program_sempred((ProgramContext)_localctx, predIndex);
		case 5:
			return parameter_list_sempred((Parameter_listContext)_localctx, predIndex);
		case 10:
			return declaration_list_sempred((Declaration_listContext)_localctx, predIndex);
		case 11:
			return statements_sempred((StatementsContext)_localctx, predIndex);
		case 18:
			return simple_expression_sempred((Simple_expressionContext)_localctx, predIndex);
		case 19:
			return term_sempred((TermContext)_localctx, predIndex);
		case 23:
			return arguments_sempred((ArgumentsContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean program_sempred(ProgramContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean parameter_list_sempred(Parameter_listContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 4);
		case 2:
			return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean declaration_list_sempred(Declaration_listContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 4);
		case 4:
			return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean statements_sempred(StatementsContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean simple_expression_sempred(Simple_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean term_sempred(TermContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean arguments_sempred(ArgumentsContext _localctx, int predIndex) {
		switch (predIndex) {
		case 8:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001!\u0142\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0005\u00019\b\u0001\n\u0001\f\u0001<\t\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0003\u0002A\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003P\b\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0003\u0004_\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0003\u0005f\b\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0005\u0005p\b\u0005\n\u0005\f\u0005s\t\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006{\b\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u0087\b\u0007"+
		"\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003"+
		"\t\u0091\b\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003"+
		"\n\u009a\b\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0005\n\u00a6\b\n\n\n\f\n\u00a9\t\n\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u00b0\b\u000b\n"+
		"\u000b\f\u000b\u00b3\t\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u00dd"+
		"\b\f\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u00e3\b\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u00eb"+
		"\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003"+
		"\u000f\u00f2\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0003\u0010\u00f9\b\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0003\u0011\u0100\b\u0011\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0005\u0012\u0108\b\u0012\n"+
		"\u0012\f\u0012\u010b\t\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0005\u0013\u0113\b\u0013\n\u0013\f\u0013"+
		"\u0116\t\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0003\u0014\u011d\b\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0003\u0015\u0131\b\u0015\u0001\u0016\u0001\u0016"+
		"\u0003\u0016\u0135\b\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0005\u0017\u013d\b\u0017\n\u0017\f\u0017\u0140"+
		"\t\u0017\u0001\u0017\u0000\u0007\u0002\n\u0014\u0016$&.\u0018\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e"+
		" \"$&(*,.\u0000\u0000\u0152\u00000\u0001\u0000\u0000\u0000\u00023\u0001"+
		"\u0000\u0000\u0000\u0004@\u0001\u0000\u0000\u0000\u0006O\u0001\u0000\u0000"+
		"\u0000\b^\u0001\u0000\u0000\u0000\ne\u0001\u0000\u0000\u0000\fz\u0001"+
		"\u0000\u0000\u0000\u000e\u0086\u0001\u0000\u0000\u0000\u0010\u0088\u0001"+
		"\u0000\u0000\u0000\u0012\u0090\u0001\u0000\u0000\u0000\u0014\u0099\u0001"+
		"\u0000\u0000\u0000\u0016\u00aa\u0001\u0000\u0000\u0000\u0018\u00dc\u0001"+
		"\u0000\u0000\u0000\u001a\u00e2\u0001\u0000\u0000\u0000\u001c\u00ea\u0001"+
		"\u0000\u0000\u0000\u001e\u00f1\u0001\u0000\u0000\u0000 \u00f8\u0001\u0000"+
		"\u0000\u0000\"\u00ff\u0001\u0000\u0000\u0000$\u0101\u0001\u0000\u0000"+
		"\u0000&\u010c\u0001\u0000\u0000\u0000(\u011c\u0001\u0000\u0000\u0000*"+
		"\u0130\u0001\u0000\u0000\u0000,\u0134\u0001\u0000\u0000\u0000.\u0136\u0001"+
		"\u0000\u0000\u000001\u0003\u0002\u0001\u000012\u0006\u0000\uffff\uffff"+
		"\u00002\u0001\u0001\u0000\u0000\u000034\u0006\u0001\uffff\uffff\u0000"+
		"45\u0003\u0004\u0002\u00005:\u0001\u0000\u0000\u000067\n\u0002\u0000\u0000"+
		"79\u0003\u0004\u0002\u000086\u0001\u0000\u0000\u00009<\u0001\u0000\u0000"+
		"\u0000:8\u0001\u0000\u0000\u0000:;\u0001\u0000\u0000\u0000;\u0003\u0001"+
		"\u0000\u0000\u0000<:\u0001\u0000\u0000\u0000=A\u0003\u000e\u0007\u0000"+
		">A\u0003\u0006\u0003\u0000?A\u0003\b\u0004\u0000@=\u0001\u0000\u0000\u0000"+
		"@>\u0001\u0000\u0000\u0000@?\u0001\u0000\u0000\u0000A\u0005\u0001\u0000"+
		"\u0000\u0000BC\u0003\u0012\t\u0000CD\u0005\u001f\u0000\u0000DE\u0005\u000e"+
		"\u0000\u0000EF\u0003\n\u0005\u0000FG\u0005\u000f\u0000\u0000GH\u0005\u0014"+
		"\u0000\u0000HP\u0001\u0000\u0000\u0000IJ\u0003\u0012\t\u0000JK\u0005\u001f"+
		"\u0000\u0000KL\u0005\u000e\u0000\u0000LM\u0005\u000f\u0000\u0000MN\u0005"+
		"\u0014\u0000\u0000NP\u0001\u0000\u0000\u0000OB\u0001\u0000\u0000\u0000"+
		"OI\u0001\u0000\u0000\u0000P\u0007\u0001\u0000\u0000\u0000QR\u0003\u0012"+
		"\t\u0000RS\u0005\u001f\u0000\u0000ST\u0005\u000e\u0000\u0000TU\u0003\n"+
		"\u0005\u0000UV\u0005\u000f\u0000\u0000VW\u0003\f\u0006\u0000W_\u0001\u0000"+
		"\u0000\u0000XY\u0003\u0012\t\u0000YZ\u0005\u001f\u0000\u0000Z[\u0005\u000e"+
		"\u0000\u0000[\\\u0005\u000f\u0000\u0000\\]\u0003\f\u0006\u0000]_\u0001"+
		"\u0000\u0000\u0000^Q\u0001\u0000\u0000\u0000^X\u0001\u0000\u0000\u0000"+
		"_\t\u0001\u0000\u0000\u0000`a\u0006\u0005\uffff\uffff\u0000ab\u0003\u0012"+
		"\t\u0000bc\u0005\u001f\u0000\u0000cf\u0001\u0000\u0000\u0000df\u0003\u0012"+
		"\t\u0000e`\u0001\u0000\u0000\u0000ed\u0001\u0000\u0000\u0000fq\u0001\u0000"+
		"\u0000\u0000gh\n\u0004\u0000\u0000hi\u0005\u0015\u0000\u0000ij\u0003\u0012"+
		"\t\u0000jk\u0005\u001f\u0000\u0000kp\u0001\u0000\u0000\u0000lm\n\u0003"+
		"\u0000\u0000mn\u0005\u0015\u0000\u0000np\u0003\u0012\t\u0000og\u0001\u0000"+
		"\u0000\u0000ol\u0001\u0000\u0000\u0000ps\u0001\u0000\u0000\u0000qo\u0001"+
		"\u0000\u0000\u0000qr\u0001\u0000\u0000\u0000r\u000b\u0001\u0000\u0000"+
		"\u0000sq\u0001\u0000\u0000\u0000tu\u0005\u0010\u0000\u0000uv\u0003\u0016"+
		"\u000b\u0000vw\u0005\u0011\u0000\u0000w{\u0001\u0000\u0000\u0000xy\u0005"+
		"\u0010\u0000\u0000y{\u0005\u0011\u0000\u0000zt\u0001\u0000\u0000\u0000"+
		"zx\u0001\u0000\u0000\u0000{\r\u0001\u0000\u0000\u0000|}\u0003\u0012\t"+
		"\u0000}~\u0003\u0014\n\u0000~\u007f\u0005\u0014\u0000\u0000\u007f\u0080"+
		"\u0006\u0007\uffff\uffff\u0000\u0080\u0087\u0001\u0000\u0000\u0000\u0081"+
		"\u0082\u0003\u0012\t\u0000\u0082\u0083\u0003\u0010\b\u0000\u0083\u0084"+
		"\u0005\u0014\u0000\u0000\u0084\u0085\u0006\u0007\uffff\uffff\u0000\u0085"+
		"\u0087\u0001\u0000\u0000\u0000\u0086|\u0001\u0000\u0000\u0000\u0086\u0081"+
		"\u0001\u0000\u0000\u0000\u0087\u000f\u0001\u0000\u0000\u0000\u0088\u0089"+
		"\u0006\b\uffff\uffff\u0000\u0089\u0011\u0001\u0000\u0000\u0000\u008a\u008b"+
		"\u0005\u000b\u0000\u0000\u008b\u0091\u0006\t\uffff\uffff\u0000\u008c\u008d"+
		"\u0005\f\u0000\u0000\u008d\u0091\u0006\t\uffff\uffff\u0000\u008e\u008f"+
		"\u0005\r\u0000\u0000\u008f\u0091\u0006\t\uffff\uffff\u0000\u0090\u008a"+
		"\u0001\u0000\u0000\u0000\u0090\u008c\u0001\u0000\u0000\u0000\u0090\u008e"+
		"\u0001\u0000\u0000\u0000\u0091\u0013\u0001\u0000\u0000\u0000\u0092\u0093"+
		"\u0006\n\uffff\uffff\u0000\u0093\u0094\u0005\u001f\u0000\u0000\u0094\u009a"+
		"\u0006\n\uffff\uffff\u0000\u0095\u0096\u0005\u001f\u0000\u0000\u0096\u0097"+
		"\u0005\u0012\u0000\u0000\u0097\u0098\u0005 \u0000\u0000\u0098\u009a\u0005"+
		"\u0013\u0000\u0000\u0099\u0092\u0001\u0000\u0000\u0000\u0099\u0095\u0001"+
		"\u0000\u0000\u0000\u009a\u00a7\u0001\u0000\u0000\u0000\u009b\u009c\n\u0004"+
		"\u0000\u0000\u009c\u009d\u0005\u0015\u0000\u0000\u009d\u009e\u0005\u001f"+
		"\u0000\u0000\u009e\u00a6\u0006\n\uffff\uffff\u0000\u009f\u00a0\n\u0003"+
		"\u0000\u0000\u00a0\u00a1\u0005\u0015\u0000\u0000\u00a1\u00a2\u0005\u001f"+
		"\u0000\u0000\u00a2\u00a3\u0005\u0012\u0000\u0000\u00a3\u00a4\u0005 \u0000"+
		"\u0000\u00a4\u00a6\u0005\u0013\u0000\u0000\u00a5\u009b\u0001\u0000\u0000"+
		"\u0000\u00a5\u009f\u0001\u0000\u0000\u0000\u00a6\u00a9\u0001\u0000\u0000"+
		"\u0000\u00a7\u00a5\u0001\u0000\u0000\u0000\u00a7\u00a8\u0001\u0000\u0000"+
		"\u0000\u00a8\u0015\u0001\u0000\u0000\u0000\u00a9\u00a7\u0001\u0000\u0000"+
		"\u0000\u00aa\u00ab\u0006\u000b\uffff\uffff\u0000\u00ab\u00ac\u0003\u0018"+
		"\f\u0000\u00ac\u00b1\u0001\u0000\u0000\u0000\u00ad\u00ae\n\u0001\u0000"+
		"\u0000\u00ae\u00b0\u0003\u0018\f\u0000\u00af\u00ad\u0001\u0000\u0000\u0000"+
		"\u00b0\u00b3\u0001\u0000\u0000\u0000\u00b1\u00af\u0001\u0000\u0000\u0000"+
		"\u00b1\u00b2\u0001\u0000\u0000\u0000\u00b2\u0017\u0001\u0000\u0000\u0000"+
		"\u00b3\u00b1\u0001\u0000\u0000\u0000\u00b4\u00dd\u0003\u000e\u0007\u0000"+
		"\u00b5\u00dd\u0003\u001a\r\u0000\u00b6\u00dd\u0003\f\u0006\u0000\u00b7"+
		"\u00b8\u0005\u0007\u0000\u0000\u00b8\u00b9\u0005\u000e\u0000\u0000\u00b9"+
		"\u00ba\u0003\u001a\r\u0000\u00ba\u00bb\u0003\u001a\r\u0000\u00bb\u00bc"+
		"\u0003\u001e\u000f\u0000\u00bc\u00bd\u0005\u000f\u0000\u0000\u00bd\u00be"+
		"\u0003\u0018\f\u0000\u00be\u00dd\u0001\u0000\u0000\u0000\u00bf\u00c0\u0005"+
		"\u0005\u0000\u0000\u00c0\u00c1\u0005\u000e\u0000\u0000\u00c1\u00c2\u0003"+
		"\u001e\u000f\u0000\u00c2\u00c3\u0005\u000f\u0000\u0000\u00c3\u00c4\u0003"+
		"\u0018\f\u0000\u00c4\u00dd\u0001\u0000\u0000\u0000\u00c5\u00c6\u0005\u0005"+
		"\u0000\u0000\u00c6\u00c7\u0005\u000e\u0000\u0000\u00c7\u00c8\u0003\u001e"+
		"\u000f\u0000\u00c8\u00c9\u0005\u000f\u0000\u0000\u00c9\u00ca\u0003\u0018"+
		"\f\u0000\u00ca\u00cb\u0005\u0006\u0000\u0000\u00cb\u00cc\u0003\u0018\f"+
		"\u0000\u00cc\u00dd\u0001\u0000\u0000\u0000\u00cd\u00ce\u0005\b\u0000\u0000"+
		"\u00ce\u00cf\u0005\u000e\u0000\u0000\u00cf\u00d0\u0003\u001e\u000f\u0000"+
		"\u00d0\u00d1\u0005\u000f\u0000\u0000\u00d1\u00d2\u0003\u0018\f\u0000\u00d2"+
		"\u00dd\u0001\u0000\u0000\u0000\u00d3\u00d4\u0005\t\u0000\u0000\u00d4\u00d5"+
		"\u0005\u000e\u0000\u0000\u00d5\u00d6\u0005\u001f\u0000\u0000\u00d6\u00d7"+
		"\u0005\u000f\u0000\u0000\u00d7\u00dd\u0005\u0014\u0000\u0000\u00d8\u00d9"+
		"\u0005\n\u0000\u0000\u00d9\u00da\u0003\u001e\u000f\u0000\u00da\u00db\u0005"+
		"\u0014\u0000\u0000\u00db\u00dd\u0001\u0000\u0000\u0000\u00dc\u00b4\u0001"+
		"\u0000\u0000\u0000\u00dc\u00b5\u0001\u0000\u0000\u0000\u00dc\u00b6\u0001"+
		"\u0000\u0000\u0000\u00dc\u00b7\u0001\u0000\u0000\u0000\u00dc\u00bf\u0001"+
		"\u0000\u0000\u0000\u00dc\u00c5\u0001\u0000\u0000\u0000\u00dc\u00cd\u0001"+
		"\u0000\u0000\u0000\u00dc\u00d3\u0001\u0000\u0000\u0000\u00dc\u00d8\u0001"+
		"\u0000\u0000\u0000\u00dd\u0019\u0001\u0000\u0000\u0000\u00de\u00e3\u0005"+
		"\u0014\u0000\u0000\u00df\u00e0\u0003\u001e\u000f\u0000\u00e0\u00e1\u0005"+
		"\u0014\u0000\u0000\u00e1\u00e3\u0001\u0000\u0000\u0000\u00e2\u00de\u0001"+
		"\u0000\u0000\u0000\u00e2\u00df\u0001\u0000\u0000\u0000\u00e3\u001b\u0001"+
		"\u0000\u0000\u0000\u00e4\u00eb\u0005\u001f\u0000\u0000\u00e5\u00e6\u0005"+
		"\u001f\u0000\u0000\u00e6\u00e7\u0005\u0012\u0000\u0000\u00e7\u00e8\u0003"+
		"\u001e\u000f\u0000\u00e8\u00e9\u0005\u0013\u0000\u0000\u00e9\u00eb\u0001"+
		"\u0000\u0000\u0000\u00ea\u00e4\u0001\u0000\u0000\u0000\u00ea\u00e5\u0001"+
		"\u0000\u0000\u0000\u00eb\u001d\u0001\u0000\u0000\u0000\u00ec\u00f2\u0003"+
		" \u0010\u0000\u00ed\u00ee\u0003\u001c\u000e\u0000\u00ee\u00ef\u0005\u001e"+
		"\u0000\u0000\u00ef\u00f0\u0003 \u0010\u0000\u00f0\u00f2\u0001\u0000\u0000"+
		"\u0000\u00f1\u00ec\u0001\u0000\u0000\u0000\u00f1\u00ed\u0001\u0000\u0000"+
		"\u0000\u00f2\u001f\u0001\u0000\u0000\u0000\u00f3\u00f9\u0003\"\u0011\u0000"+
		"\u00f4\u00f5\u0003\"\u0011\u0000\u00f5\u00f6\u0005\u001d\u0000\u0000\u00f6"+
		"\u00f7\u0003\"\u0011\u0000\u00f7\u00f9\u0001\u0000\u0000\u0000\u00f8\u00f3"+
		"\u0001\u0000\u0000\u0000\u00f8\u00f4\u0001\u0000\u0000\u0000\u00f9!\u0001"+
		"\u0000\u0000\u0000\u00fa\u0100\u0003$\u0012\u0000\u00fb\u00fc\u0003$\u0012"+
		"\u0000\u00fc\u00fd\u0005\u001c\u0000\u0000\u00fd\u00fe\u0003$\u0012\u0000"+
		"\u00fe\u0100\u0001\u0000\u0000\u0000\u00ff\u00fa\u0001\u0000\u0000\u0000"+
		"\u00ff\u00fb\u0001\u0000\u0000\u0000\u0100#\u0001\u0000\u0000\u0000\u0101"+
		"\u0102\u0006\u0012\uffff\uffff\u0000\u0102\u0103\u0003&\u0013\u0000\u0103"+
		"\u0109\u0001\u0000\u0000\u0000\u0104\u0105\n\u0001\u0000\u0000\u0105\u0106"+
		"\u0005\u0016\u0000\u0000\u0106\u0108\u0003&\u0013\u0000\u0107\u0104\u0001"+
		"\u0000\u0000\u0000\u0108\u010b\u0001\u0000\u0000\u0000\u0109\u0107\u0001"+
		"\u0000\u0000\u0000\u0109\u010a\u0001\u0000\u0000\u0000\u010a%\u0001\u0000"+
		"\u0000\u0000\u010b\u0109\u0001\u0000\u0000\u0000\u010c\u010d\u0006\u0013"+
		"\uffff\uffff\u0000\u010d\u010e\u0003(\u0014\u0000\u010e\u0114\u0001\u0000"+
		"\u0000\u0000\u010f\u0110\n\u0001\u0000\u0000\u0110\u0111\u0005\u0018\u0000"+
		"\u0000\u0111\u0113\u0003(\u0014\u0000\u0112\u010f\u0001\u0000\u0000\u0000"+
		"\u0113\u0116\u0001\u0000\u0000\u0000\u0114\u0112\u0001\u0000\u0000\u0000"+
		"\u0114\u0115\u0001\u0000\u0000\u0000\u0115\'\u0001\u0000\u0000\u0000\u0116"+
		"\u0114\u0001\u0000\u0000\u0000\u0117\u0118\u0005\u0016\u0000\u0000\u0118"+
		"\u011d\u0003(\u0014\u0000\u0119\u011a\u0005\u001b\u0000\u0000\u011a\u011d"+
		"\u0003(\u0014\u0000\u011b\u011d\u0003*\u0015\u0000\u011c\u0117\u0001\u0000"+
		"\u0000\u0000\u011c\u0119\u0001\u0000\u0000\u0000\u011c\u011b\u0001\u0000"+
		"\u0000\u0000\u011d)\u0001\u0000\u0000\u0000\u011e\u0131\u0003\u001c\u000e"+
		"\u0000\u011f\u0120\u0005\u001f\u0000\u0000\u0120\u0121\u0005\u000e\u0000"+
		"\u0000\u0121\u0122\u0003,\u0016\u0000\u0122\u0123\u0005\u000f\u0000\u0000"+
		"\u0123\u0131\u0001\u0000\u0000\u0000\u0124\u0125\u0005\u000e\u0000\u0000"+
		"\u0125\u0126\u0003\u001e\u000f\u0000\u0126\u0127\u0005\u000f\u0000\u0000"+
		"\u0127\u0131\u0001\u0000\u0000\u0000\u0128\u0131\u0005 \u0000\u0000\u0129"+
		"\u0131\u0005!\u0000\u0000\u012a\u012b\u0003\u001c\u000e\u0000\u012b\u012c"+
		"\u0005\u0019\u0000\u0000\u012c\u0131\u0001\u0000\u0000\u0000\u012d\u012e"+
		"\u0003\u001c\u000e\u0000\u012e\u012f\u0005\u001a\u0000\u0000\u012f\u0131"+
		"\u0001\u0000\u0000\u0000\u0130\u011e\u0001\u0000\u0000\u0000\u0130\u011f"+
		"\u0001\u0000\u0000\u0000\u0130\u0124\u0001\u0000\u0000\u0000\u0130\u0128"+
		"\u0001\u0000\u0000\u0000\u0130\u0129\u0001\u0000\u0000\u0000\u0130\u012a"+
		"\u0001\u0000\u0000\u0000\u0130\u012d\u0001\u0000\u0000\u0000\u0131+\u0001"+
		"\u0000\u0000\u0000\u0132\u0135\u0003.\u0017\u0000\u0133\u0135\u0001\u0000"+
		"\u0000\u0000\u0134\u0132\u0001\u0000\u0000\u0000\u0134\u0133\u0001\u0000"+
		"\u0000\u0000\u0135-\u0001\u0000\u0000\u0000\u0136\u0137\u0006\u0017\uffff"+
		"\uffff\u0000\u0137\u0138\u0003 \u0010\u0000\u0138\u013e\u0001\u0000\u0000"+
		"\u0000\u0139\u013a\n\u0002\u0000\u0000\u013a\u013b\u0005\u0015\u0000\u0000"+
		"\u013b\u013d\u0003 \u0010\u0000\u013c\u0139\u0001\u0000\u0000\u0000\u013d"+
		"\u0140\u0001\u0000\u0000\u0000\u013e\u013c\u0001\u0000\u0000\u0000\u013e"+
		"\u013f\u0001\u0000\u0000\u0000\u013f/\u0001\u0000\u0000\u0000\u0140\u013e"+
		"\u0001\u0000\u0000\u0000\u001a:@O^eoqz\u0086\u0090\u0099\u00a5\u00a7\u00b1"+
		"\u00dc\u00e2\u00ea\u00f1\u00f8\u00ff\u0109\u0114\u011c\u0130\u0134\u013e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}