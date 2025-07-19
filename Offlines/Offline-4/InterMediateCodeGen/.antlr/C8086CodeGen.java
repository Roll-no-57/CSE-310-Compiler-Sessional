// Generated from /media/apurbo/New Volume/Academy/CSE-310-Compiler-sessional/Offlines/Offline-4/InterMediateCodeGen/C8086CodeGen.g4 by ANTLR 4.13.1

    #include <iostream>
    #include <fstream>
    #include <string>
    #include <cstdlib>
    #include "C8086Lexer.h"
	#include "CodeGenerator.hpp"

    extern std::ofstream parserLogFile;
    extern std::ofstream errorFile;
	extern std::ofstream dataSectionFile;
    extern std::ofstream codeSectionFile; 


import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class C8086CodeGen extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LINE_COMMENT=1, BLOCK_COMMENT=2, STRING=3, WS=4, IF=5, ELSE=6, FOR=7, 
		WHILE=8, DO=9, PRINTLN=10, RETURN=11, INT=12, FLOAT=13, VOID=14, STRUCT=15, 
		SWITCH=16, CASE=17, BREAK=18, CONTINUE=19, DEFAULT=20, LPAREN=21, RPAREN=22, 
		LCURL=23, RCURL=24, LTHIRD=25, RTHIRD=26, SEMICOLON=27, COLON=28, COMMA=29, 
		ADDOP=30, MULOP=31, INCOP=32, DECOP=33, NOT=34, RELOP=35, LOGICOP=36, 
		ASSIGNOP=37, ID=38, CONST_INT=39, CONST_FLOAT=40;
	public static final int
		RULE_start = 0, RULE_program = 1, RULE_unit = 2, RULE_func_declaration = 3, 
		RULE_func_definition = 4, RULE_parameter_list = 5, RULE_compound_statement = 6, 
		RULE_var_declaration = 7, RULE_declaration_list_err = 8, RULE_type_specifier = 9, 
		RULE_declaration_list = 10, RULE_declaration_list_rest = 11, RULE_statements = 12, 
		RULE_statement = 13, RULE_expression_statement = 14, RULE_variable = 15, 
		RULE_expression = 16, RULE_logic_expression = 17, RULE_rel_expression = 18, 
		RULE_simple_expression = 19, RULE_term = 20, RULE_unary_expression = 21, 
		RULE_factor = 22, RULE_argument_list = 23, RULE_arguments = 24;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "program", "unit", "func_declaration", "func_definition", "parameter_list", 
			"compound_statement", "var_declaration", "declaration_list_err", "type_specifier", 
			"declaration_list", "declaration_list_rest", "statements", "statement", 
			"expression_statement", "variable", "expression", "logic_expression", 
			"rel_expression", "simple_expression", "term", "unary_expression", "factor", 
			"argument_list", "arguments"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, "'if'", "'else'", "'for'", "'while'", "'do'", 
			"'println'", "'return'", "'int'", "'float'", "'void'", "'struct'", "'switch'", 
			"'case'", "'break'", "'continue'", "'default'", "'('", "')'", "'{'", 
			"'}'", "'['", "']'", "';'", "':'", "','", null, null, "'++'", "'--'", 
			"'!'", null, null, "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LINE_COMMENT", "BLOCK_COMMENT", "STRING", "WS", "IF", "ELSE", 
			"FOR", "WHILE", "DO", "PRINTLN", "RETURN", "INT", "FLOAT", "VOID", "STRUCT", 
			"SWITCH", "CASE", "BREAK", "CONTINUE", "DEFAULT", "LPAREN", "RPAREN", 
			"LCURL", "RCURL", "LTHIRD", "RTHIRD", "SEMICOLON", "COLON", "COMMA", 
			"ADDOP", "MULOP", "INCOP", "DECOP", "NOT", "RELOP", "LOGICOP", "ASSIGNOP", 
			"ID", "CONST_INT", "CONST_FLOAT"
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
	public String getGrammarFileName() { return "C8086CodeGen.g4"; }

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

	public C8086CodeGen(TokenStream input) {
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


				writeIntoparserLogFile("Starting parsing process...");

				// Generate the program header and data and code section headers
				if (codeGen) {
					codeGen->GenProgramHeader();
					codeGen->GenDataSectionHeader();
					codeGen->GenCodeSectionHeader();
				}
				
				

			setState(51);
			program(0);

					// Generate the program footer
					if(codeGen) codeGen->GenProgramFooter();
			        writeIntoparserLogFile("Parsing completed successfully ");
				
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
			setState(55);
			unit();
			}
			_ctx.stop = _input.LT(-1);
			setState(61);
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
					setState(57);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(58);
					unit();
					}
					} 
				}
				setState(63);
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
			setState(73);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(64);
				var_declaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{

						if(codeGen)codeGen->setIsGlobalScope(false);
					 
				setState(66);
				func_declaration();

						if(codeGen)codeGen->setIsGlobalScope(true);
					 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{

						if(codeGen)codeGen->setIsGlobalScope(false);
					 
				setState(70);
				func_definition();

						if(codeGen)codeGen->setIsGlobalScope(true);
					 
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
		public TerminalNode ID() { return getToken(C8086CodeGen.ID, 0); }
		public TerminalNode LPAREN() { return getToken(C8086CodeGen.LPAREN, 0); }
		public Parameter_listContext parameter_list() {
			return getRuleContext(Parameter_listContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(C8086CodeGen.RPAREN, 0); }
		public TerminalNode SEMICOLON() { return getToken(C8086CodeGen.SEMICOLON, 0); }
		public Func_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_declaration; }
	}

	public final Func_declarationContext func_declaration() throws RecognitionException {
		Func_declarationContext _localctx = new Func_declarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_func_declaration);
		try {
			setState(88);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(75);
				type_specifier();
				setState(76);
				match(ID);
				setState(77);
				match(LPAREN);
				setState(78);
				parameter_list(0);
				setState(79);
				match(RPAREN);
				setState(80);
				match(SEMICOLON);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(82);
				type_specifier();
				setState(83);
				match(ID);
				setState(84);
				match(LPAREN);
				setState(85);
				match(RPAREN);
				setState(86);
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
		public TerminalNode ID() { return getToken(C8086CodeGen.ID, 0); }
		public TerminalNode LPAREN() { return getToken(C8086CodeGen.LPAREN, 0); }
		public Parameter_listContext parameter_list() {
			return getRuleContext(Parameter_listContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(C8086CodeGen.RPAREN, 0); }
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
			setState(103);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(90);
				type_specifier();
				setState(91);
				match(ID);
				setState(92);
				match(LPAREN);
				setState(93);
				parameter_list(0);
				setState(94);
				match(RPAREN);
				setState(95);
				compound_statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(97);
				type_specifier();
				setState(98);
				match(ID);
				setState(99);
				match(LPAREN);
				setState(100);
				match(RPAREN);
				setState(101);
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
		public TerminalNode ID() { return getToken(C8086CodeGen.ID, 0); }
		public Parameter_listContext parameter_list() {
			return getRuleContext(Parameter_listContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(C8086CodeGen.COMMA, 0); }
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
			setState(110);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(106);
				type_specifier();
				setState(107);
				match(ID);
				}
				break;
			case 2:
				{
				setState(109);
				type_specifier();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(122);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(120);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new Parameter_listContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_parameter_list);
						setState(112);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(113);
						match(COMMA);
						setState(114);
						type_specifier();
						setState(115);
						match(ID);
						}
						break;
					case 2:
						{
						_localctx = new Parameter_listContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_parameter_list);
						setState(117);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(118);
						match(COMMA);
						setState(119);
						type_specifier();
						}
						break;
					}
					} 
				}
				setState(124);
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
		public TerminalNode LCURL() { return getToken(C8086CodeGen.LCURL, 0); }
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public TerminalNode RCURL() { return getToken(C8086CodeGen.RCURL, 0); }
		public Compound_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compound_statement; }
	}

	public final Compound_statementContext compound_statement() throws RecognitionException {
		Compound_statementContext _localctx = new Compound_statementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_compound_statement);
		try {
			setState(131);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(125);
				match(LCURL);
				setState(126);
				statements(0);
				setState(127);
				match(RCURL);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(129);
				match(LCURL);
				setState(130);
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
		public TerminalNode SEMICOLON() { return getToken(C8086CodeGen.SEMICOLON, 0); }
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
			setState(143);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(133);
				((Var_declarationContext)_localctx).t = type_specifier();
				setState(134);
				((Var_declarationContext)_localctx).dl = declaration_list(((Var_declarationContext)_localctx).t.text);
				setState(135);
				((Var_declarationContext)_localctx).sm = match(SEMICOLON);

				        
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(138);
				((Var_declarationContext)_localctx).t = type_specifier();
				setState(139);
				((Var_declarationContext)_localctx).de = declaration_list_err();
				setState(140);
				((Var_declarationContext)_localctx).sm = match(SEMICOLON);

				        writeIntoErrorFile(
				            std::string("Line# ") + std::to_string(((Var_declarationContext)_localctx).sm->getLine()) +
				            " with error name: " + ((Var_declarationContext)_localctx).de.error_name +
				            " - Syntax error at declaration list of variable declaration"
				        );

				      
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
		public std::string text;
		public TerminalNode INT() { return getToken(C8086CodeGen.INT, 0); }
		public TerminalNode FLOAT() { return getToken(C8086CodeGen.FLOAT, 0); }
		public TerminalNode VOID() { return getToken(C8086CodeGen.VOID, 0); }
		public Type_specifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_specifier; }
	}

	public final Type_specifierContext type_specifier() throws RecognitionException {
		Type_specifierContext _localctx = new Type_specifierContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_type_specifier);
		try {
			setState(153);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(147);
				match(INT);

				            ((Type_specifierContext)_localctx).text =  "int";
				        
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(149);
				match(FLOAT);

				            ((Type_specifierContext)_localctx).text =  "float";
				        
				}
				break;
			case VOID:
				enterOuterAlt(_localctx, 3);
				{
				setState(151);
				match(VOID);

				            ((Type_specifierContext)_localctx).text =  "void";
				        
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
		public std::string type;
		public Token ID;
		public Token CONST_INT;
		public TerminalNode ID() { return getToken(C8086CodeGen.ID, 0); }
		public Declaration_list_restContext declaration_list_rest() {
			return getRuleContext(Declaration_list_restContext.class,0);
		}
		public TerminalNode LTHIRD() { return getToken(C8086CodeGen.LTHIRD, 0); }
		public TerminalNode CONST_INT() { return getToken(C8086CodeGen.CONST_INT, 0); }
		public TerminalNode RTHIRD() { return getToken(C8086CodeGen.RTHIRD, 0); }
		public Declaration_listContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Declaration_listContext(ParserRuleContext parent, int invokingState, std::string type) {
			super(parent, invokingState);
			this.type = type;
		}
		@Override public int getRuleIndex() { return RULE_declaration_list; }
	}

	public final Declaration_listContext declaration_list(std::string type) throws RecognitionException {
		Declaration_listContext _localctx = new Declaration_listContext(_ctx, getState(), type);
		enterRule(_localctx, 20, RULE_declaration_list);
		try {
			setState(164);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(155);
				((Declaration_listContext)_localctx).ID = match(ID);

				        if(codeGen ){ 
							if(codeGen->isInGlobalScope() ){
								codeGen->GenGlobalVariableDeclaration((((Declaration_listContext)_localctx).ID!=null?((Declaration_listContext)_localctx).ID.getText():null), _localctx.type, ((Declaration_listContext)_localctx).ID->getLine());
							}
							else{
								codeGen->GenLocalVariableDeclaration((((Declaration_listContext)_localctx).ID!=null?((Declaration_listContext)_localctx).ID.getText():null), _localctx.type, ((Declaration_listContext)_localctx).ID->getLine());
							}
						}
						
				      
				setState(157);
				declaration_list_rest(_localctx.type);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(158);
				((Declaration_listContext)_localctx).ID = match(ID);
				setState(159);
				match(LTHIRD);
				setState(160);
				((Declaration_listContext)_localctx).CONST_INT = match(CONST_INT);
				setState(161);
				match(RTHIRD);

						if(codeGen) {
							if(codeGen->isInGlobalScope()) {
								codeGen->GenGlobalArrayDeclaration((((Declaration_listContext)_localctx).ID!=null?((Declaration_listContext)_localctx).ID.getText():null), _localctx.type, std::stoi((((Declaration_listContext)_localctx).CONST_INT!=null?((Declaration_listContext)_localctx).CONST_INT.getText():null)), ((Declaration_listContext)_localctx).ID->getLine());
							} else {
								codeGen->GenLocalArrayDeclaration((((Declaration_listContext)_localctx).ID!=null?((Declaration_listContext)_localctx).ID.getText():null), _localctx.type, std::stoi((((Declaration_listContext)_localctx).CONST_INT!=null?((Declaration_listContext)_localctx).CONST_INT.getText():null)), ((Declaration_listContext)_localctx).ID->getLine());
							}
						}
					
				setState(163);
				declaration_list_rest(_localctx.type);
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
	public static class Declaration_list_restContext extends ParserRuleContext {
		public std::string type;
		public Token ID;
		public Token CONST_INT;
		public TerminalNode COMMA() { return getToken(C8086CodeGen.COMMA, 0); }
		public TerminalNode ID() { return getToken(C8086CodeGen.ID, 0); }
		public Declaration_list_restContext declaration_list_rest() {
			return getRuleContext(Declaration_list_restContext.class,0);
		}
		public TerminalNode LTHIRD() { return getToken(C8086CodeGen.LTHIRD, 0); }
		public TerminalNode CONST_INT() { return getToken(C8086CodeGen.CONST_INT, 0); }
		public TerminalNode RTHIRD() { return getToken(C8086CodeGen.RTHIRD, 0); }
		public Declaration_list_restContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Declaration_list_restContext(ParserRuleContext parent, int invokingState, std::string type) {
			super(parent, invokingState);
			this.type = type;
		}
		@Override public int getRuleIndex() { return RULE_declaration_list_rest; }
	}

	public final Declaration_list_restContext declaration_list_rest(std::string type) throws RecognitionException {
		Declaration_list_restContext _localctx = new Declaration_list_restContext(_ctx, getState(), type);
		enterRule(_localctx, 22, RULE_declaration_list_rest);
		try {
			setState(178);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(166);
				match(COMMA);
				setState(167);
				((Declaration_list_restContext)_localctx).ID = match(ID);

				        if(codeGen ){ 
							if(codeGen->isInGlobalScope() ){
								codeGen->GenGlobalVariableDeclaration((((Declaration_list_restContext)_localctx).ID!=null?((Declaration_list_restContext)_localctx).ID.getText():null), _localctx.type, ((Declaration_list_restContext)_localctx).ID->getLine());
							}
							else{
								codeGen->GenLocalVariableDeclaration((((Declaration_list_restContext)_localctx).ID!=null?((Declaration_list_restContext)_localctx).ID.getText():null), _localctx.type, ((Declaration_list_restContext)_localctx).ID->getLine());
							}
						}
				      
				setState(169);
				declaration_list_rest(_localctx.type);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(170);
				match(COMMA);
				setState(171);
				((Declaration_list_restContext)_localctx).ID = match(ID);
				setState(172);
				match(LTHIRD);
				setState(173);
				((Declaration_list_restContext)_localctx).CONST_INT = match(CONST_INT);
				setState(174);
				match(RTHIRD);

						if(codeGen) {
							if(codeGen->isInGlobalScope()) {
								codeGen->GenGlobalArrayDeclaration((((Declaration_list_restContext)_localctx).ID!=null?((Declaration_list_restContext)_localctx).ID.getText():null), _localctx.type, std::stoi((((Declaration_list_restContext)_localctx).CONST_INT!=null?((Declaration_list_restContext)_localctx).CONST_INT.getText():null)), ((Declaration_list_restContext)_localctx).ID->getLine());
							} else {
								codeGen->GenLocalArrayDeclaration((((Declaration_list_restContext)_localctx).ID!=null?((Declaration_list_restContext)_localctx).ID.getText():null), _localctx.type, std::stoi((((Declaration_list_restContext)_localctx).CONST_INT!=null?((Declaration_list_restContext)_localctx).CONST_INT.getText():null)), ((Declaration_list_restContext)_localctx).ID->getLine());
							}
						}
					
				setState(176);
				declaration_list_rest(_localctx.type);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
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
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_statements, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(181);
			statement();
			}
			_ctx.stop = _input.LT(-1);
			setState(187);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new StatementsContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_statements);
					setState(183);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(184);
					statement();
					}
					} 
				}
				setState(189);
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
		public TerminalNode FOR() { return getToken(C8086CodeGen.FOR, 0); }
		public TerminalNode LPAREN() { return getToken(C8086CodeGen.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(C8086CodeGen.RPAREN, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode IF() { return getToken(C8086CodeGen.IF, 0); }
		public TerminalNode ELSE() { return getToken(C8086CodeGen.ELSE, 0); }
		public TerminalNode WHILE() { return getToken(C8086CodeGen.WHILE, 0); }
		public TerminalNode PRINTLN() { return getToken(C8086CodeGen.PRINTLN, 0); }
		public TerminalNode ID() { return getToken(C8086CodeGen.ID, 0); }
		public TerminalNode SEMICOLON() { return getToken(C8086CodeGen.SEMICOLON, 0); }
		public TerminalNode RETURN() { return getToken(C8086CodeGen.RETURN, 0); }
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_statement);
		try {
			setState(231);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(190);
				var_declaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(191);
				expression_statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(192);
				compound_statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(193);
				match(FOR);
				setState(194);
				match(LPAREN);
				setState(195);
				expression_statement();
				setState(196);
				expression_statement();
				setState(197);
				expression();
				setState(198);
				match(RPAREN);
				setState(199);
				statement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(201);
				match(IF);
				setState(202);
				match(LPAREN);
				setState(203);
				expression();
				setState(204);
				match(RPAREN);
				setState(205);
				statement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(207);
				match(IF);
				setState(208);
				match(LPAREN);
				setState(209);
				expression();
				setState(210);
				match(RPAREN);
				setState(211);
				statement();
				setState(212);
				match(ELSE);
				setState(213);
				statement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(215);
				match(WHILE);
				setState(216);
				match(LPAREN);
				setState(217);
				expression();
				setState(218);
				match(RPAREN);
				setState(219);
				statement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(221);
				match(PRINTLN);
				setState(222);
				match(LPAREN);
				setState(223);
				match(ID);
				setState(224);
				match(RPAREN);
				setState(225);
				match(SEMICOLON);

							if(codeGen) codeGen->GenPrintlnFunction();
					  
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(227);
				match(RETURN);
				setState(228);
				expression();
				setState(229);
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
		public TerminalNode SEMICOLON() { return getToken(C8086CodeGen.SEMICOLON, 0); }
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
		enterRule(_localctx, 28, RULE_expression_statement);
		try {
			setState(237);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SEMICOLON:
				enterOuterAlt(_localctx, 1);
				{
				setState(233);
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
				setState(234);
				expression();
				setState(235);
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
		public std::string var_name;
		public Token ID;
		public TerminalNode ID() { return getToken(C8086CodeGen.ID, 0); }
		public TerminalNode LTHIRD() { return getToken(C8086CodeGen.LTHIRD, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RTHIRD() { return getToken(C8086CodeGen.RTHIRD, 0); }
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_variable);
		try {
			setState(247);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(239);
				((VariableContext)_localctx).ID = match(ID);

						((VariableContext)_localctx).var_name =  (((VariableContext)_localctx).ID!=null?((VariableContext)_localctx).ID.getText():null);
					 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(241);
				((VariableContext)_localctx).ID = match(ID);
				setState(242);
				match(LTHIRD);
				setState(243);
				expression();
				setState(244);
				match(RTHIRD);

						((VariableContext)_localctx).var_name =  (((VariableContext)_localctx).ID!=null?((VariableContext)_localctx).ID.getText():null);
					 
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
		public VariableContext v;
		public Token ASSIGNOP;
		public Logic_expressionContext logic_expression() {
			return getRuleContext(Logic_expressionContext.class,0);
		}
		public TerminalNode ASSIGNOP() { return getToken(C8086CodeGen.ASSIGNOP, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_expression);
		try {
			setState(255);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(249);
				logic_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(250);
				((ExpressionContext)_localctx).v = variable();
				setState(251);
				((ExpressionContext)_localctx).ASSIGNOP = match(ASSIGNOP);
				setState(252);
				logic_expression();

						   if(codeGen) {
							   // Generate code for assignment operation
							   codeGen->GenAssignmentOp(((ExpressionContext)_localctx).v.var_name , "AX", ((ExpressionContext)_localctx).ASSIGNOP->getLine());
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
	public static class Logic_expressionContext extends ParserRuleContext {
		public List<Rel_expressionContext> rel_expression() {
			return getRuleContexts(Rel_expressionContext.class);
		}
		public Rel_expressionContext rel_expression(int i) {
			return getRuleContext(Rel_expressionContext.class,i);
		}
		public TerminalNode LOGICOP() { return getToken(C8086CodeGen.LOGICOP, 0); }
		public Logic_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logic_expression; }
	}

	public final Logic_expressionContext logic_expression() throws RecognitionException {
		Logic_expressionContext _localctx = new Logic_expressionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_logic_expression);
		try {
			setState(262);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(257);
				rel_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(258);
				rel_expression();
				setState(259);
				match(LOGICOP);
				setState(260);
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
		public TerminalNode RELOP() { return getToken(C8086CodeGen.RELOP, 0); }
		public Rel_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rel_expression; }
	}

	public final Rel_expressionContext rel_expression() throws RecognitionException {
		Rel_expressionContext _localctx = new Rel_expressionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_rel_expression);
		try {
			setState(269);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(264);
				simple_expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(265);
				simple_expression(0);
				setState(266);
				match(RELOP);
				setState(267);
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
		public TerminalNode ADDOP() { return getToken(C8086CodeGen.ADDOP, 0); }
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
		int _startState = 38;
		enterRecursionRule(_localctx, 38, RULE_simple_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(272);
			term(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(279);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Simple_expressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_simple_expression);
					setState(274);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(275);
					match(ADDOP);
					setState(276);
					term(0);
					}
					} 
				}
				setState(281);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
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
		public TerminalNode MULOP() { return getToken(C8086CodeGen.MULOP, 0); }
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
		int _startState = 40;
		enterRecursionRule(_localctx, 40, RULE_term, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(283);
			unary_expression();
			}
			_ctx.stop = _input.LT(-1);
			setState(290);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TermContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_term);
					setState(285);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(286);
					match(MULOP);
					setState(287);
					unary_expression();
					}
					} 
				}
				setState(292);
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
	public static class Unary_expressionContext extends ParserRuleContext {
		public TerminalNode ADDOP() { return getToken(C8086CodeGen.ADDOP, 0); }
		public Unary_expressionContext unary_expression() {
			return getRuleContext(Unary_expressionContext.class,0);
		}
		public TerminalNode NOT() { return getToken(C8086CodeGen.NOT, 0); }
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
		enterRule(_localctx, 42, RULE_unary_expression);
		try {
			setState(298);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ADDOP:
				enterOuterAlt(_localctx, 1);
				{
				setState(293);
				match(ADDOP);
				setState(294);
				unary_expression();
				}
				break;
			case NOT:
				enterOuterAlt(_localctx, 2);
				{
				setState(295);
				match(NOT);
				setState(296);
				unary_expression();
				}
				break;
			case LPAREN:
			case ID:
			case CONST_INT:
			case CONST_FLOAT:
				enterOuterAlt(_localctx, 3);
				{
				setState(297);
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
		public Token CONST_INT;
		public Token CONST_FLOAT;
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode ID() { return getToken(C8086CodeGen.ID, 0); }
		public TerminalNode LPAREN() { return getToken(C8086CodeGen.LPAREN, 0); }
		public Argument_listContext argument_list() {
			return getRuleContext(Argument_listContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(C8086CodeGen.RPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode CONST_INT() { return getToken(C8086CodeGen.CONST_INT, 0); }
		public TerminalNode CONST_FLOAT() { return getToken(C8086CodeGen.CONST_FLOAT, 0); }
		public TerminalNode INCOP() { return getToken(C8086CodeGen.INCOP, 0); }
		public TerminalNode DECOP() { return getToken(C8086CodeGen.DECOP, 0); }
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_factor);
		try {
			setState(320);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(300);
				variable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(301);
				match(ID);
				setState(302);
				match(LPAREN);
				setState(303);
				argument_list();
				setState(304);
				match(RPAREN);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(306);
				match(LPAREN);
				setState(307);
				expression();
				setState(308);
				match(RPAREN);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(310);
				((FactorContext)_localctx).CONST_INT = match(CONST_INT);

						// load constant value into AX
						if(codeGen)codeGen->GenLoadConstInt(std::stoi((((FactorContext)_localctx).CONST_INT!=null?((FactorContext)_localctx).CONST_INT.getText():null)), ((FactorContext)_localctx).CONST_INT->getLine());
					
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(312);
				((FactorContext)_localctx).CONST_FLOAT = match(CONST_FLOAT);

						// load constant float value into AX
						if(codeGen) codeGen->writeComment(&codeSectionFile,"Load constant float value", ((FactorContext)_localctx).CONST_FLOAT->getLine());
					
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(314);
				variable();
				setState(315);
				match(INCOP);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(317);
				variable();
				setState(318);
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
		enterRule(_localctx, 46, RULE_argument_list);
		try {
			setState(324);
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
				setState(322);
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
		public TerminalNode COMMA() { return getToken(C8086CodeGen.COMMA, 0); }
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
		int _startState = 48;
		enterRecursionRule(_localctx, 48, RULE_arguments, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(327);
			logic_expression();
			}
			_ctx.stop = _input.LT(-1);
			setState(334);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ArgumentsContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_arguments);
					setState(329);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(330);
					match(COMMA);
					setState(331);
					logic_expression();
					}
					} 
				}
				setState(336);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
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
		case 12:
			return statements_sempred((StatementsContext)_localctx, predIndex);
		case 19:
			return simple_expression_sempred((Simple_expressionContext)_localctx, predIndex);
		case 20:
			return term_sempred((TermContext)_localctx, predIndex);
		case 24:
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
	private boolean statements_sempred(StatementsContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean simple_expression_sempred(Simple_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean term_sempred(TermContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean arguments_sempred(ArgumentsContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001(\u0152\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001<\b\u0001\n\u0001\f\u0001"+
		"?\t\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002J\b\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0003\u0003Y\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004h\b\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005"+
		"o\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005y\b\u0005\n\u0005\f\u0005"+
		"|\t\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0003\u0006\u0084\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0003\u0007\u0090\b\u0007\u0001\b\u0001\b\u0001\t\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u009a\b\t\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u00a5\b\n\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003"+
		"\u000b\u00b3\b\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f\u00ba"+
		"\b\f\n\f\f\f\u00bd\t\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r"+
		"\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003"+
		"\r\u00e8\b\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e"+
		"\u00ee\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u00f8\b\u000f\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010"+
		"\u0100\b\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0003\u0011\u0107\b\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0003\u0012\u010e\b\u0012\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0005\u0013\u0116\b\u0013\n\u0013"+
		"\f\u0013\u0119\t\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0005\u0014\u0121\b\u0014\n\u0014\f\u0014\u0124"+
		"\t\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0003"+
		"\u0015\u012b\b\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0003\u0016\u0141\b\u0016\u0001"+
		"\u0017\u0001\u0017\u0003\u0017\u0145\b\u0017\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0005\u0018\u014d\b\u0018\n"+
		"\u0018\f\u0018\u0150\t\u0018\u0001\u0018\u0000\u0006\u0002\n\u0018&(0"+
		"\u0019\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018"+
		"\u001a\u001c\u001e \"$&(*,.0\u0000\u0000\u0161\u00002\u0001\u0000\u0000"+
		"\u0000\u00026\u0001\u0000\u0000\u0000\u0004I\u0001\u0000\u0000\u0000\u0006"+
		"X\u0001\u0000\u0000\u0000\bg\u0001\u0000\u0000\u0000\nn\u0001\u0000\u0000"+
		"\u0000\f\u0083\u0001\u0000\u0000\u0000\u000e\u008f\u0001\u0000\u0000\u0000"+
		"\u0010\u0091\u0001\u0000\u0000\u0000\u0012\u0099\u0001\u0000\u0000\u0000"+
		"\u0014\u00a4\u0001\u0000\u0000\u0000\u0016\u00b2\u0001\u0000\u0000\u0000"+
		"\u0018\u00b4\u0001\u0000\u0000\u0000\u001a\u00e7\u0001\u0000\u0000\u0000"+
		"\u001c\u00ed\u0001\u0000\u0000\u0000\u001e\u00f7\u0001\u0000\u0000\u0000"+
		" \u00ff\u0001\u0000\u0000\u0000\"\u0106\u0001\u0000\u0000\u0000$\u010d"+
		"\u0001\u0000\u0000\u0000&\u010f\u0001\u0000\u0000\u0000(\u011a\u0001\u0000"+
		"\u0000\u0000*\u012a\u0001\u0000\u0000\u0000,\u0140\u0001\u0000\u0000\u0000"+
		".\u0144\u0001\u0000\u0000\u00000\u0146\u0001\u0000\u0000\u000023\u0006"+
		"\u0000\uffff\uffff\u000034\u0003\u0002\u0001\u000045\u0006\u0000\uffff"+
		"\uffff\u00005\u0001\u0001\u0000\u0000\u000067\u0006\u0001\uffff\uffff"+
		"\u000078\u0003\u0004\u0002\u00008=\u0001\u0000\u0000\u00009:\n\u0002\u0000"+
		"\u0000:<\u0003\u0004\u0002\u0000;9\u0001\u0000\u0000\u0000<?\u0001\u0000"+
		"\u0000\u0000=;\u0001\u0000\u0000\u0000=>\u0001\u0000\u0000\u0000>\u0003"+
		"\u0001\u0000\u0000\u0000?=\u0001\u0000\u0000\u0000@J\u0003\u000e\u0007"+
		"\u0000AB\u0006\u0002\uffff\uffff\u0000BC\u0003\u0006\u0003\u0000CD\u0006"+
		"\u0002\uffff\uffff\u0000DJ\u0001\u0000\u0000\u0000EF\u0006\u0002\uffff"+
		"\uffff\u0000FG\u0003\b\u0004\u0000GH\u0006\u0002\uffff\uffff\u0000HJ\u0001"+
		"\u0000\u0000\u0000I@\u0001\u0000\u0000\u0000IA\u0001\u0000\u0000\u0000"+
		"IE\u0001\u0000\u0000\u0000J\u0005\u0001\u0000\u0000\u0000KL\u0003\u0012"+
		"\t\u0000LM\u0005&\u0000\u0000MN\u0005\u0015\u0000\u0000NO\u0003\n\u0005"+
		"\u0000OP\u0005\u0016\u0000\u0000PQ\u0005\u001b\u0000\u0000QY\u0001\u0000"+
		"\u0000\u0000RS\u0003\u0012\t\u0000ST\u0005&\u0000\u0000TU\u0005\u0015"+
		"\u0000\u0000UV\u0005\u0016\u0000\u0000VW\u0005\u001b\u0000\u0000WY\u0001"+
		"\u0000\u0000\u0000XK\u0001\u0000\u0000\u0000XR\u0001\u0000\u0000\u0000"+
		"Y\u0007\u0001\u0000\u0000\u0000Z[\u0003\u0012\t\u0000[\\\u0005&\u0000"+
		"\u0000\\]\u0005\u0015\u0000\u0000]^\u0003\n\u0005\u0000^_\u0005\u0016"+
		"\u0000\u0000_`\u0003\f\u0006\u0000`h\u0001\u0000\u0000\u0000ab\u0003\u0012"+
		"\t\u0000bc\u0005&\u0000\u0000cd\u0005\u0015\u0000\u0000de\u0005\u0016"+
		"\u0000\u0000ef\u0003\f\u0006\u0000fh\u0001\u0000\u0000\u0000gZ\u0001\u0000"+
		"\u0000\u0000ga\u0001\u0000\u0000\u0000h\t\u0001\u0000\u0000\u0000ij\u0006"+
		"\u0005\uffff\uffff\u0000jk\u0003\u0012\t\u0000kl\u0005&\u0000\u0000lo"+
		"\u0001\u0000\u0000\u0000mo\u0003\u0012\t\u0000ni\u0001\u0000\u0000\u0000"+
		"nm\u0001\u0000\u0000\u0000oz\u0001\u0000\u0000\u0000pq\n\u0004\u0000\u0000"+
		"qr\u0005\u001d\u0000\u0000rs\u0003\u0012\t\u0000st\u0005&\u0000\u0000"+
		"ty\u0001\u0000\u0000\u0000uv\n\u0003\u0000\u0000vw\u0005\u001d\u0000\u0000"+
		"wy\u0003\u0012\t\u0000xp\u0001\u0000\u0000\u0000xu\u0001\u0000\u0000\u0000"+
		"y|\u0001\u0000\u0000\u0000zx\u0001\u0000\u0000\u0000z{\u0001\u0000\u0000"+
		"\u0000{\u000b\u0001\u0000\u0000\u0000|z\u0001\u0000\u0000\u0000}~\u0005"+
		"\u0017\u0000\u0000~\u007f\u0003\u0018\f\u0000\u007f\u0080\u0005\u0018"+
		"\u0000\u0000\u0080\u0084\u0001\u0000\u0000\u0000\u0081\u0082\u0005\u0017"+
		"\u0000\u0000\u0082\u0084\u0005\u0018\u0000\u0000\u0083}\u0001\u0000\u0000"+
		"\u0000\u0083\u0081\u0001\u0000\u0000\u0000\u0084\r\u0001\u0000\u0000\u0000"+
		"\u0085\u0086\u0003\u0012\t\u0000\u0086\u0087\u0003\u0014\n\u0000\u0087"+
		"\u0088\u0005\u001b\u0000\u0000\u0088\u0089\u0006\u0007\uffff\uffff\u0000"+
		"\u0089\u0090\u0001\u0000\u0000\u0000\u008a\u008b\u0003\u0012\t\u0000\u008b"+
		"\u008c\u0003\u0010\b\u0000\u008c\u008d\u0005\u001b\u0000\u0000\u008d\u008e"+
		"\u0006\u0007\uffff\uffff\u0000\u008e\u0090\u0001\u0000\u0000\u0000\u008f"+
		"\u0085\u0001\u0000\u0000\u0000\u008f\u008a\u0001\u0000\u0000\u0000\u0090"+
		"\u000f\u0001\u0000\u0000\u0000\u0091\u0092\u0006\b\uffff\uffff\u0000\u0092"+
		"\u0011\u0001\u0000\u0000\u0000\u0093\u0094\u0005\f\u0000\u0000\u0094\u009a"+
		"\u0006\t\uffff\uffff\u0000\u0095\u0096\u0005\r\u0000\u0000\u0096\u009a"+
		"\u0006\t\uffff\uffff\u0000\u0097\u0098\u0005\u000e\u0000\u0000\u0098\u009a"+
		"\u0006\t\uffff\uffff\u0000\u0099\u0093\u0001\u0000\u0000\u0000\u0099\u0095"+
		"\u0001\u0000\u0000\u0000\u0099\u0097\u0001\u0000\u0000\u0000\u009a\u0013"+
		"\u0001\u0000\u0000\u0000\u009b\u009c\u0005&\u0000\u0000\u009c\u009d\u0006"+
		"\n\uffff\uffff\u0000\u009d\u00a5\u0003\u0016\u000b\u0000\u009e\u009f\u0005"+
		"&\u0000\u0000\u009f\u00a0\u0005\u0019\u0000\u0000\u00a0\u00a1\u0005\'"+
		"\u0000\u0000\u00a1\u00a2\u0005\u001a\u0000\u0000\u00a2\u00a3\u0006\n\uffff"+
		"\uffff\u0000\u00a3\u00a5\u0003\u0016\u000b\u0000\u00a4\u009b\u0001\u0000"+
		"\u0000\u0000\u00a4\u009e\u0001\u0000\u0000\u0000\u00a5\u0015\u0001\u0000"+
		"\u0000\u0000\u00a6\u00a7\u0005\u001d\u0000\u0000\u00a7\u00a8\u0005&\u0000"+
		"\u0000\u00a8\u00a9\u0006\u000b\uffff\uffff\u0000\u00a9\u00b3\u0003\u0016"+
		"\u000b\u0000\u00aa\u00ab\u0005\u001d\u0000\u0000\u00ab\u00ac\u0005&\u0000"+
		"\u0000\u00ac\u00ad\u0005\u0019\u0000\u0000\u00ad\u00ae\u0005\'\u0000\u0000"+
		"\u00ae\u00af\u0005\u001a\u0000\u0000\u00af\u00b0\u0006\u000b\uffff\uffff"+
		"\u0000\u00b0\u00b3\u0003\u0016\u000b\u0000\u00b1\u00b3\u0001\u0000\u0000"+
		"\u0000\u00b2\u00a6\u0001\u0000\u0000\u0000\u00b2\u00aa\u0001\u0000\u0000"+
		"\u0000\u00b2\u00b1\u0001\u0000\u0000\u0000\u00b3\u0017\u0001\u0000\u0000"+
		"\u0000\u00b4\u00b5\u0006\f\uffff\uffff\u0000\u00b5\u00b6\u0003\u001a\r"+
		"\u0000\u00b6\u00bb\u0001\u0000\u0000\u0000\u00b7\u00b8\n\u0001\u0000\u0000"+
		"\u00b8\u00ba\u0003\u001a\r\u0000\u00b9\u00b7\u0001\u0000\u0000\u0000\u00ba"+
		"\u00bd\u0001\u0000\u0000\u0000\u00bb\u00b9\u0001\u0000\u0000\u0000\u00bb"+
		"\u00bc\u0001\u0000\u0000\u0000\u00bc\u0019\u0001\u0000\u0000\u0000\u00bd"+
		"\u00bb\u0001\u0000\u0000\u0000\u00be\u00e8\u0003\u000e\u0007\u0000\u00bf"+
		"\u00e8\u0003\u001c\u000e\u0000\u00c0\u00e8\u0003\f\u0006\u0000\u00c1\u00c2"+
		"\u0005\u0007\u0000\u0000\u00c2\u00c3\u0005\u0015\u0000\u0000\u00c3\u00c4"+
		"\u0003\u001c\u000e\u0000\u00c4\u00c5\u0003\u001c\u000e\u0000\u00c5\u00c6"+
		"\u0003 \u0010\u0000\u00c6\u00c7\u0005\u0016\u0000\u0000\u00c7\u00c8\u0003"+
		"\u001a\r\u0000\u00c8\u00e8\u0001\u0000\u0000\u0000\u00c9\u00ca\u0005\u0005"+
		"\u0000\u0000\u00ca\u00cb\u0005\u0015\u0000\u0000\u00cb\u00cc\u0003 \u0010"+
		"\u0000\u00cc\u00cd\u0005\u0016\u0000\u0000\u00cd\u00ce\u0003\u001a\r\u0000"+
		"\u00ce\u00e8\u0001\u0000\u0000\u0000\u00cf\u00d0\u0005\u0005\u0000\u0000"+
		"\u00d0\u00d1\u0005\u0015\u0000\u0000\u00d1\u00d2\u0003 \u0010\u0000\u00d2"+
		"\u00d3\u0005\u0016\u0000\u0000\u00d3\u00d4\u0003\u001a\r\u0000\u00d4\u00d5"+
		"\u0005\u0006\u0000\u0000\u00d5\u00d6\u0003\u001a\r\u0000\u00d6\u00e8\u0001"+
		"\u0000\u0000\u0000\u00d7\u00d8\u0005\b\u0000\u0000\u00d8\u00d9\u0005\u0015"+
		"\u0000\u0000\u00d9\u00da\u0003 \u0010\u0000\u00da\u00db\u0005\u0016\u0000"+
		"\u0000\u00db\u00dc\u0003\u001a\r\u0000\u00dc\u00e8\u0001\u0000\u0000\u0000"+
		"\u00dd\u00de\u0005\n\u0000\u0000\u00de\u00df\u0005\u0015\u0000\u0000\u00df"+
		"\u00e0\u0005&\u0000\u0000\u00e0\u00e1\u0005\u0016\u0000\u0000\u00e1\u00e2"+
		"\u0005\u001b\u0000\u0000\u00e2\u00e8\u0006\r\uffff\uffff\u0000\u00e3\u00e4"+
		"\u0005\u000b\u0000\u0000\u00e4\u00e5\u0003 \u0010\u0000\u00e5\u00e6\u0005"+
		"\u001b\u0000\u0000\u00e6\u00e8\u0001\u0000\u0000\u0000\u00e7\u00be\u0001"+
		"\u0000\u0000\u0000\u00e7\u00bf\u0001\u0000\u0000\u0000\u00e7\u00c0\u0001"+
		"\u0000\u0000\u0000\u00e7\u00c1\u0001\u0000\u0000\u0000\u00e7\u00c9\u0001"+
		"\u0000\u0000\u0000\u00e7\u00cf\u0001\u0000\u0000\u0000\u00e7\u00d7\u0001"+
		"\u0000\u0000\u0000\u00e7\u00dd\u0001\u0000\u0000\u0000\u00e7\u00e3\u0001"+
		"\u0000\u0000\u0000\u00e8\u001b\u0001\u0000\u0000\u0000\u00e9\u00ee\u0005"+
		"\u001b\u0000\u0000\u00ea\u00eb\u0003 \u0010\u0000\u00eb\u00ec\u0005\u001b"+
		"\u0000\u0000\u00ec\u00ee\u0001\u0000\u0000\u0000\u00ed\u00e9\u0001\u0000"+
		"\u0000\u0000\u00ed\u00ea\u0001\u0000\u0000\u0000\u00ee\u001d\u0001\u0000"+
		"\u0000\u0000\u00ef\u00f0\u0005&\u0000\u0000\u00f0\u00f8\u0006\u000f\uffff"+
		"\uffff\u0000\u00f1\u00f2\u0005&\u0000\u0000\u00f2\u00f3\u0005\u0019\u0000"+
		"\u0000\u00f3\u00f4\u0003 \u0010\u0000\u00f4\u00f5\u0005\u001a\u0000\u0000"+
		"\u00f5\u00f6\u0006\u000f\uffff\uffff\u0000\u00f6\u00f8\u0001\u0000\u0000"+
		"\u0000\u00f7\u00ef\u0001\u0000\u0000\u0000\u00f7\u00f1\u0001\u0000\u0000"+
		"\u0000\u00f8\u001f\u0001\u0000\u0000\u0000\u00f9\u0100\u0003\"\u0011\u0000"+
		"\u00fa\u00fb\u0003\u001e\u000f\u0000\u00fb\u00fc\u0005%\u0000\u0000\u00fc"+
		"\u00fd\u0003\"\u0011\u0000\u00fd\u00fe\u0006\u0010\uffff\uffff\u0000\u00fe"+
		"\u0100\u0001\u0000\u0000\u0000\u00ff\u00f9\u0001\u0000\u0000\u0000\u00ff"+
		"\u00fa\u0001\u0000\u0000\u0000\u0100!\u0001\u0000\u0000\u0000\u0101\u0107"+
		"\u0003$\u0012\u0000\u0102\u0103\u0003$\u0012\u0000\u0103\u0104\u0005$"+
		"\u0000\u0000\u0104\u0105\u0003$\u0012\u0000\u0105\u0107\u0001\u0000\u0000"+
		"\u0000\u0106\u0101\u0001\u0000\u0000\u0000\u0106\u0102\u0001\u0000\u0000"+
		"\u0000\u0107#\u0001\u0000\u0000\u0000\u0108\u010e\u0003&\u0013\u0000\u0109"+
		"\u010a\u0003&\u0013\u0000\u010a\u010b\u0005#\u0000\u0000\u010b\u010c\u0003"+
		"&\u0013\u0000\u010c\u010e\u0001\u0000\u0000\u0000\u010d\u0108\u0001\u0000"+
		"\u0000\u0000\u010d\u0109\u0001\u0000\u0000\u0000\u010e%\u0001\u0000\u0000"+
		"\u0000\u010f\u0110\u0006\u0013\uffff\uffff\u0000\u0110\u0111\u0003(\u0014"+
		"\u0000\u0111\u0117\u0001\u0000\u0000\u0000\u0112\u0113\n\u0001\u0000\u0000"+
		"\u0113\u0114\u0005\u001e\u0000\u0000\u0114\u0116\u0003(\u0014\u0000\u0115"+
		"\u0112\u0001\u0000\u0000\u0000\u0116\u0119\u0001\u0000\u0000\u0000\u0117"+
		"\u0115\u0001\u0000\u0000\u0000\u0117\u0118\u0001\u0000\u0000\u0000\u0118"+
		"\'\u0001\u0000\u0000\u0000\u0119\u0117\u0001\u0000\u0000\u0000\u011a\u011b"+
		"\u0006\u0014\uffff\uffff\u0000\u011b\u011c\u0003*\u0015\u0000\u011c\u0122"+
		"\u0001\u0000\u0000\u0000\u011d\u011e\n\u0001\u0000\u0000\u011e\u011f\u0005"+
		"\u001f\u0000\u0000\u011f\u0121\u0003*\u0015\u0000\u0120\u011d\u0001\u0000"+
		"\u0000\u0000\u0121\u0124\u0001\u0000\u0000\u0000\u0122\u0120\u0001\u0000"+
		"\u0000\u0000\u0122\u0123\u0001\u0000\u0000\u0000\u0123)\u0001\u0000\u0000"+
		"\u0000\u0124\u0122\u0001\u0000\u0000\u0000\u0125\u0126\u0005\u001e\u0000"+
		"\u0000\u0126\u012b\u0003*\u0015\u0000\u0127\u0128\u0005\"\u0000\u0000"+
		"\u0128\u012b\u0003*\u0015\u0000\u0129\u012b\u0003,\u0016\u0000\u012a\u0125"+
		"\u0001\u0000\u0000\u0000\u012a\u0127\u0001\u0000\u0000\u0000\u012a\u0129"+
		"\u0001\u0000\u0000\u0000\u012b+\u0001\u0000\u0000\u0000\u012c\u0141\u0003"+
		"\u001e\u000f\u0000\u012d\u012e\u0005&\u0000\u0000\u012e\u012f\u0005\u0015"+
		"\u0000\u0000\u012f\u0130\u0003.\u0017\u0000\u0130\u0131\u0005\u0016\u0000"+
		"\u0000\u0131\u0141\u0001\u0000\u0000\u0000\u0132\u0133\u0005\u0015\u0000"+
		"\u0000\u0133\u0134\u0003 \u0010\u0000\u0134\u0135\u0005\u0016\u0000\u0000"+
		"\u0135\u0141\u0001\u0000\u0000\u0000\u0136\u0137\u0005\'\u0000\u0000\u0137"+
		"\u0141\u0006\u0016\uffff\uffff\u0000\u0138\u0139\u0005(\u0000\u0000\u0139"+
		"\u0141\u0006\u0016\uffff\uffff\u0000\u013a\u013b\u0003\u001e\u000f\u0000"+
		"\u013b\u013c\u0005 \u0000\u0000\u013c\u0141\u0001\u0000\u0000\u0000\u013d"+
		"\u013e\u0003\u001e\u000f\u0000\u013e\u013f\u0005!\u0000\u0000\u013f\u0141"+
		"\u0001\u0000\u0000\u0000\u0140\u012c\u0001\u0000\u0000\u0000\u0140\u012d"+
		"\u0001\u0000\u0000\u0000\u0140\u0132\u0001\u0000\u0000\u0000\u0140\u0136"+
		"\u0001\u0000\u0000\u0000\u0140\u0138\u0001\u0000\u0000\u0000\u0140\u013a"+
		"\u0001\u0000\u0000\u0000\u0140\u013d\u0001\u0000\u0000\u0000\u0141-\u0001"+
		"\u0000\u0000\u0000\u0142\u0145\u00030\u0018\u0000\u0143\u0145\u0001\u0000"+
		"\u0000\u0000\u0144\u0142\u0001\u0000\u0000\u0000\u0144\u0143\u0001\u0000"+
		"\u0000\u0000\u0145/\u0001\u0000\u0000\u0000\u0146\u0147\u0006\u0018\uffff"+
		"\uffff\u0000\u0147\u0148\u0003\"\u0011\u0000\u0148\u014e\u0001\u0000\u0000"+
		"\u0000\u0149\u014a\n\u0002\u0000\u0000\u014a\u014b\u0005\u001d\u0000\u0000"+
		"\u014b\u014d\u0003\"\u0011\u0000\u014c\u0149\u0001\u0000\u0000\u0000\u014d"+
		"\u0150\u0001\u0000\u0000\u0000\u014e\u014c\u0001\u0000\u0000\u0000\u014e"+
		"\u014f\u0001\u0000\u0000\u0000\u014f1\u0001\u0000\u0000\u0000\u0150\u014e"+
		"\u0001\u0000\u0000\u0000\u0019=IXgnxz\u0083\u008f\u0099\u00a4\u00b2\u00bb"+
		"\u00e7\u00ed\u00f7\u00ff\u0106\u010d\u0117\u0122\u012a\u0140\u0144\u014e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}