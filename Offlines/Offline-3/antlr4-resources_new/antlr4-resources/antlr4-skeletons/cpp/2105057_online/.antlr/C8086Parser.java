// Generated from /media/apurbo/New Volume/Academy/CSE-310-Compiler-sessional/Offlines/Offline-3/antlr4-resources_new/antlr4-resources/antlr4-skeletons/cpp/2105057_online/C8086Parser.g4 by ANTLR 4.13.1

    #include <iostream>
    #include <fstream>
    #include <string>
    #include <cstdlib>
    #include "C8086Lexer.h"
    #include "str_list.cpp"
    #include "ParseInfo.h"
    #include "headers/2105057_symbolInfo.hpp"
    #include "headers/2105057_ScopeTable.hpp"
    #include "headers/2105057_SymbolTable.hpp"  // ADD THIS LINE

    extern std::ofstream parserLogFile;
    extern std::ofstream errorFile;
    extern int syntaxErrorCount;
    extern int numOfBuckets;
    extern SymbolTable* ST;  // Move declaration here

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
		WHILE=8, DO=9, PRINTLN=10, RETURN=11, INT=12, FLOAT=13, VOID=14, STRUCT=15, 
		SWITCH=16, CASE=17, BREAK=18, CONTINUE=19, DEFAULT=20, LPAREN=21, RPAREN=22, 
		LCURL=23, RCURL=24, LTHIRD=25, RTHIRD=26, SEMICOLON=27, COLON=28, COMMA=29, 
		ADDOP=30, MULOP=31, INCOP=32, DECOP=33, NOT=34, RELOP=35, LOGICOP=36, 
		ASSIGNOP=37, ID=38, CONST_INT=39, CONST_FLOAT=40;
	public static final int
		RULE_start = 0, RULE_program = 1, RULE_unit = 2, RULE_struct_declaration = 3, 
		RULE_func_declaration = 4, RULE_func_definition = 5, RULE_parameter_list = 6, 
		RULE_compound_statement = 7, RULE_var_declaration = 8, RULE_declaration_list_err = 9, 
		RULE_type_specifier = 10, RULE_declaration_list = 11, RULE_statements = 12, 
		RULE_statement = 13, RULE_switch_cases = 14, RULE_case_statement = 15, 
		RULE_expression_statement = 16, RULE_variable = 17, RULE_expression = 18, 
		RULE_logic_expression = 19, RULE_rel_expression = 20, RULE_simple_expression = 21, 
		RULE_term = 22, RULE_unary_expression = 23, RULE_factor = 24, RULE_argument_list = 25, 
		RULE_arguments = 26;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "program", "unit", "struct_declaration", "func_declaration", 
			"func_definition", "parameter_list", "compound_statement", "var_declaration", 
			"declaration_list_err", "type_specifier", "declaration_list", "statements", 
			"statement", "switch_cases", "case_statement", "expression_statement", 
			"variable", "expression", "logic_expression", "rel_expression", "simple_expression", 
			"term", "unary_expression", "factor", "argument_list", "arguments"
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
	public String getGrammarFileName() { return "C8086Parser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }



		int numberOfBuckets = 7;  // Add type declaration
	    HashFunction hashFunc = &Hash::SDBMHash;
	    SymbolTable *ST = new SymbolTable(numberOfBuckets, hashFunc, true);  // Use numberOfBuckets, not numOfBuckets

	    int doDepth = 0;

	    void writeIntoparserLogFile(const std::string message) {
	        if (!parserLogFile) {
	            std::cout << "Error opening parserLogFile.txt" << std::endl;
	            std::cout << std::endl;
	            return;
	        }
	        parserLogFile << message << std::endl;
	        parserLogFile << std::endl;
	        parserLogFile.flush();
	    }

	    void writeIntoErrorFile(const std::string message) {
	        if (!errorFile) {
	            std::cout << "Error opening errorFile.txt" << std::endl;
	            return;
	        }
	        errorFile << message << std::endl;
	        errorFile << std::endl;
	        errorFile.flush();
	    }

	    void logLine(int line, const std::string& rule) {
	        if(line==-1)return;
	        writeIntoparserLogFile("Line " + std::to_string(line) + ": " + rule);
	    }
	    void logError(int line, const std::string& message) {
	        writeIntoErrorFile("Line " + std::to_string(line) + ": " + message);
	    }

	    // Helper to check if type is integer
	    bool isIntegerType(const std::string& type) {
	        return type == "int" || type == "CONST_INT";
	    }

	    // Helper to check type compatibility

	    bool isTypeCompatible(const std::string& left, const std::string& right) {
	        // Check if either is an array type
	        bool leftIsArray = (left.find("ARRAY,") == 0);
	        bool rightIsArray = (right.find("ARRAY,") == 0);
	        
	        // Arrays and scalars are not compatible
	        if (leftIsArray != rightIsArray) {
	            return false;
	        }
	        
	        // Get base types for comparison
	        std::string leftBase = leftIsArray ? left.substr(6) : left;
	        std::string rightBase = rightIsArray ? right.substr(6) : right;
	        
	        // Same base types are compatible
	        return leftBase == rightBase;
	    }

	    std::string getBaseType(const std::string& type) {
	        if (type.find("ARRAY,") == 0) {
	            return type.substr(6);
	        }
	        return type;
	    }


	    std::vector<std::string> extractParamTypes(const std::string& paramStr) {
	        std::vector<std::string> types;
	        std::stringstream ss(paramStr);
	        std::string param;
	        while (std::getline(ss, param, ',')) {
	            size_t start = param.find_first_not_of(" \t");
	            if (start != std::string::npos) {
	                size_t end = param.find_last_not_of(" \t");
	                param = param.substr(start, end - start + 1);
	            }

	            if (!param.empty()) {
	                types.push_back("int"); // Default assumption
	            }
	        }
	        return types;
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
			setState(54);
			program(0);

			        writeIntoparserLogFile("Parsing completed successfully with " + std::to_string(syntaxErrorCount) + " syntax errors.");
			        ST->printAllScopeTable(parserLogFile); // Print symbol table at the end
			        delete ST;  // Clean up symbol table

			        writeIntoparserLogFile("Total Error count: " + std::to_string(syntaxErrorCount));
			    
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
		public ParseInfo info;
		public ProgramContext p;
		public UnitContext u;
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
			setState(58);
			((ProgramContext)_localctx).u = unit();

			        _localctx.info.line_number = ((ProgramContext)_localctx).u.info.line_number;
			        _localctx.info.parsed_code = ((ProgramContext)_localctx).u.info.parsed_code;
			        logLine(((ProgramContext)_localctx).u.info.line_number, "program : unit");
			        writeIntoparserLogFile(_localctx.info.parsed_code);
			    
			}
			_ctx.stop = _input.LT(-1);
			setState(67);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ProgramContext(_parentctx, _parentState);
					_localctx.p = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_program);
					setState(61);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(62);
					((ProgramContext)_localctx).u = unit();

					                  _localctx.info.line_number = ((ProgramContext)_localctx).u.info.line_number;
					                  _localctx.info.parsed_code = ((ProgramContext)_localctx).p.info.parsed_code + "\n" + ((ProgramContext)_localctx).u.info.parsed_code;
					                  logLine(((ProgramContext)_localctx).u.info.line_number, "program : program unit");
					                  writeIntoparserLogFile(_localctx.info.parsed_code);
					              
					}
					} 
				}
				setState(69);
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
		public ParseInfo info;
		public Var_declarationContext var_declaration;
		public Func_declarationContext func_declaration;
		public Func_definitionContext func_definition;
		public Struct_declarationContext struct_declaration;
		public Var_declarationContext var_declaration() {
			return getRuleContext(Var_declarationContext.class,0);
		}
		public Func_declarationContext func_declaration() {
			return getRuleContext(Func_declarationContext.class,0);
		}
		public Func_definitionContext func_definition() {
			return getRuleContext(Func_definitionContext.class,0);
		}
		public Struct_declarationContext struct_declaration() {
			return getRuleContext(Struct_declarationContext.class,0);
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
			setState(82);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(70);
				((UnitContext)_localctx).var_declaration = var_declaration();

				        ((UnitContext)_localctx).info =  ((UnitContext)_localctx).var_declaration.info;
				        logLine(_localctx.info.line_number, "unit : var_declaration");
				        writeIntoparserLogFile(_localctx.info.parsed_code);
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(73);
				((UnitContext)_localctx).func_declaration = func_declaration();

				        ((UnitContext)_localctx).info =  ((UnitContext)_localctx).func_declaration.info;
				        logLine(_localctx.info.line_number, "unit : func_declaration");
				        writeIntoparserLogFile(_localctx.info.parsed_code);
				    
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(76);
				((UnitContext)_localctx).func_definition = func_definition();

				        ((UnitContext)_localctx).info =  ((UnitContext)_localctx).func_definition.info;
				        logLine(_localctx.info.line_number, "unit : func_definition");
				        writeIntoparserLogFile(_localctx.info.parsed_code);
				    
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(79);
				((UnitContext)_localctx).struct_declaration = struct_declaration();

				        ((UnitContext)_localctx).info =  ((UnitContext)_localctx).struct_declaration.info;
				        logLine(_localctx.info.line_number, "unit : struct_definition");
				        writeIntoparserLogFile(_localctx.info.parsed_code);
				    
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
	public static class Struct_declarationContext extends ParserRuleContext {
		public ParseInfo info;
		public Token ID;
		public Compound_statementContext cs;
		public TerminalNode STRUCT() { return getToken(C8086Parser.STRUCT, 0); }
		public TerminalNode ID() { return getToken(C8086Parser.ID, 0); }
		public TerminalNode SEMICOLON() { return getToken(C8086Parser.SEMICOLON, 0); }
		public Compound_statementContext compound_statement() {
			return getRuleContext(Compound_statementContext.class,0);
		}
		public Struct_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_struct_declaration; }
	}

	public final Struct_declarationContext struct_declaration() throws RecognitionException {
		Struct_declarationContext _localctx = new Struct_declarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_struct_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(STRUCT);
			setState(85);
			((Struct_declarationContext)_localctx).ID = match(ID);
			setState(86);
			((Struct_declarationContext)_localctx).cs = compound_statement();
			setState(87);
			match(SEMICOLON);

			        _localctx.info.line_number = ((Struct_declarationContext)_localctx).ID->getLine();
			        std::string code = "struct " + ((Struct_declarationContext)_localctx).ID->getText() + " " + ((Struct_declarationContext)_localctx).cs.code_string;
			        ((Struct_declarationContext)_localctx).info =  ParseInfo(((Struct_declarationContext)_localctx).ID->getLine(), code);
			        logLine(_localctx.info.line_number, "unit : STRUCT ID compound_statement");
			        writeIntoparserLogFile(_localctx.info.parsed_code);
			    
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
		public ParseInfo info;
		public Type_specifierContext ts;
		public Token ID;
		public Parameter_listContext pl;
		public Token sm;
		public TerminalNode ID() { return getToken(C8086Parser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(C8086Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(C8086Parser.RPAREN, 0); }
		public Type_specifierContext type_specifier() {
			return getRuleContext(Type_specifierContext.class,0);
		}
		public Parameter_listContext parameter_list() {
			return getRuleContext(Parameter_listContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(C8086Parser.SEMICOLON, 0); }
		public Func_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_declaration; }
	}

	public final Func_declarationContext func_declaration() throws RecognitionException {
		Func_declarationContext _localctx = new Func_declarationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_func_declaration);
		try {
			setState(105);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(90);
				((Func_declarationContext)_localctx).ts = type_specifier();
				setState(91);
				((Func_declarationContext)_localctx).ID = match(ID);
				setState(92);
				match(LPAREN);
				setState(93);
				((Func_declarationContext)_localctx).pl = parameter_list(0);
				setState(94);
				match(RPAREN);
				setState(95);
				((Func_declarationContext)_localctx).sm = match(SEMICOLON);

				        _localctx.info.line_number = ((Func_declarationContext)_localctx).sm->getLine();
				        std::string funcName = ((Func_declarationContext)_localctx).ID->getText();
				        std::string funcType = "FUNCTION," + ((Func_declarationContext)_localctx).ts.name_line + "<==(" + ((Func_declarationContext)_localctx).pl.param_string + ")>";
				        if (!ST->Insert(funcName, funcType)) {
				            logError(((Func_declarationContext)_localctx).sm->getLine(), "Multiple declaration of function " + funcName);
				            syntaxErrorCount++;
				        }
				        logLine(((Func_declarationContext)_localctx).sm->getLine(), "func_declaration : type_specifier ID LPAREN parameter_list RPAREN SEMICOLON");
				        std::string code = ((Func_declarationContext)_localctx).ts.name_line + " " + funcName + "(" + ((Func_declarationContext)_localctx).pl.param_string + ");";
				        ((Func_declarationContext)_localctx).info =  ParseInfo(((Func_declarationContext)_localctx).sm->getLine(), code);
				        writeIntoparserLogFile(code);
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(98);
				((Func_declarationContext)_localctx).ts = type_specifier();
				setState(99);
				((Func_declarationContext)_localctx).ID = match(ID);
				setState(100);
				match(LPAREN);
				setState(101);
				match(RPAREN);
				setState(102);
				((Func_declarationContext)_localctx).sm = match(SEMICOLON);

				        _localctx.info.line_number = ((Func_declarationContext)_localctx).sm->getLine();
				        std::string funcName = ((Func_declarationContext)_localctx).ID->getText();
				        std::string funcType = "FUNCTION," + ((Func_declarationContext)_localctx).ts.name_line + "<==()>";
				        if (!ST->Insert(funcName, funcType)) {
				            writeIntoErrorFile("Line " + std::to_string(((Func_declarationContext)_localctx).sm->getLine()) + ": Multiple declaration of function " + funcName);
				            syntaxErrorCount++;
				        }
				        logLine(((Func_declarationContext)_localctx).sm->getLine(), "func_declaration : type_specifier ID LPAREN RPAREN SEMICOLON");
				        std::string code = ((Func_declarationContext)_localctx).ts.name_line + " " + funcName + "();";
				        ((Func_declarationContext)_localctx).info =  ParseInfo(((Func_declarationContext)_localctx).sm->getLine(), code);
				        writeIntoparserLogFile(code);
				    
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
		public ParseInfo info;
		public Type_specifierContext ts;
		public Token ID;
		public Parameter_listContext pl;
		public Compound_statementContext cs;
		public TerminalNode ID() { return getToken(C8086Parser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(C8086Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(C8086Parser.RPAREN, 0); }
		public Type_specifierContext type_specifier() {
			return getRuleContext(Type_specifierContext.class,0);
		}
		public Parameter_listContext parameter_list() {
			return getRuleContext(Parameter_listContext.class,0);
		}
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
		enterRule(_localctx, 10, RULE_func_definition);
		try {
			setState(123);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(107);
				((Func_definitionContext)_localctx).ts = type_specifier();
				setState(108);
				((Func_definitionContext)_localctx).ID = match(ID);
				setState(109);
				match(LPAREN);
				setState(110);
				((Func_definitionContext)_localctx).pl = parameter_list(0);
				setState(111);
				match(RPAREN);
				 
				        // First check if function already declared
				        std::string funcName = ((Func_definitionContext)_localctx).ID->getText();
				        std::string funcType = "FUNCTION," + ((Func_definitionContext)_localctx).ts.name_line + "<==(" + ((Func_definitionContext)_localctx).pl.param_string + ")>";
				        SymbolInfo* existing = ST->LookUp(funcName);
				        
				        // Insert function in global scope if not exists
				        if (!existing) {
				            ST->Insert(funcName, funcType);
				        }
				        
				        // Enter function scope and insert parameters
				        ST->enterScope();
				        std::stringstream ss(((Func_definitionContext)_localctx).pl.param_string);
				        std::string param;
				        while (std::getline(ss, param, ',')) {
				            std::stringstream ps(param);
				            std::string type, name;
				            ps >> type >> name;
				            if (!name.empty()) {
				                // Insert parameter with ACTUAL TYPE, not "ID"
				                if (!ST->Insert(name, type)) {  // type is already "int", "float", etc.
				                    logError(((Func_definitionContext)_localctx).ts.line_number, "Multiple declaration of parameter " + name);
				                    syntaxErrorCount++;
				                }
				            }
				        }
				      
				setState(113);
				((Func_definitionContext)_localctx).cs = compound_statement();

				        
				        _localctx.info.line_number = ((Func_definitionContext)_localctx).ts.line_number;
				        // std::string funcName = ((Func_definitionContext)_localctx).ID->getText();
				        // std::string funcType = "FUNCTION," + ((Func_definitionContext)_localctx).ts.name_line + "<==(" + ((Func_definitionContext)_localctx).pl.param_string + ")>";
				        // SymbolInfo* existing = ST->LookUp(funcName);
				        if (existing) {
				            if (!existing->isFunctionSymbol()) {
				                logError(((Func_definitionContext)_localctx).ts.line_number, funcName + " was not declared as a function");
				                syntaxErrorCount++;
				            } else {
				                // Check return type and parameters compatibility
				                std::string existingType = existing->getOriginalType();
				                if (existingType != funcType) {
				                    logError(((Func_definitionContext)_localctx).ts.line_number, "Function definition doesn't match declaration for " + funcName);
				                    syntaxErrorCount++;
				                }
				            }
				        }
				        
				        std::string code = ((Func_definitionContext)_localctx).ts.name_line + " " + funcName + "(" + ((Func_definitionContext)_localctx).pl.param_string + ")" + ((Func_definitionContext)_localctx).cs.code_string;
				        logLine(((Func_definitionContext)_localctx).ts.line_number, "func_definition : type_specifier ID LPAREN parameter_list RPAREN compound_statement");
				        writeIntoparserLogFile(code);
				        // ST->printAllScopeTable(parserLogFile);  
				        ((Func_definitionContext)_localctx).info =  ParseInfo(((Func_definitionContext)_localctx).ts.line_number, code);
				        ST->exitScope();
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(116);
				((Func_definitionContext)_localctx).ts = type_specifier();
				setState(117);
				((Func_definitionContext)_localctx).ID = match(ID);
				setState(118);
				match(LPAREN);
				setState(119);
				match(RPAREN);
				setState(120);
				((Func_definitionContext)_localctx).cs = compound_statement();

				        _localctx.info.line_number = ((Func_definitionContext)_localctx).ts.line_number;
				        std::string funcName = ((Func_definitionContext)_localctx).ID->getText();
				        std::string funcType = "FUNCTION," + ((Func_definitionContext)_localctx).ts.name_line + "<==()>";
				        SymbolInfo* existing = ST->LookUp(funcName);
				        if (existing) {
				            if (!existing->isFunctionSymbol()) {
				                // logError(((Func_definitionContext)_localctx).ts.line_number, funcName + " was not declared as a function");
				                // syntaxErrorCount++;
				            } else if (existing->getReturnType() != ((Func_definitionContext)_localctx).ts.name_line) {
				                logError(((Func_definitionContext)_localctx).ts.line_number, "Return type mismatch for function " + funcName);
				                syntaxErrorCount++;
				            }
				        } else {
				            ST->Insert(funcName, funcType);
				        }
				        
				        std::string code = ((Func_definitionContext)_localctx).ts.name_line + " " + funcName + "()" + ((Func_definitionContext)_localctx).cs.code_string;
				        logLine(((Func_definitionContext)_localctx).ts.line_number, "func_definition : type_specifier ID LPAREN RPAREN compound_statement");
				        writeIntoparserLogFile(code);
				        ST->printAllScopeTable(parserLogFile);
				        ((Func_definitionContext)_localctx).info =  ParseInfo(((Func_definitionContext)_localctx).ts.line_number, code);
				    
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
		public std::string param_string;
		public Parameter_listContext pl;
		public Type_specifierContext ts;
		public Token ID;
		public TerminalNode ID() { return getToken(C8086Parser.ID, 0); }
		public Type_specifierContext type_specifier() {
			return getRuleContext(Type_specifierContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(C8086Parser.COMMA, 0); }
		public Parameter_listContext parameter_list() {
			return getRuleContext(Parameter_listContext.class,0);
		}
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
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_parameter_list, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(126);
				((Parameter_listContext)_localctx).ts = type_specifier();
				setState(127);
				((Parameter_listContext)_localctx).ID = match(ID);

				        ((Parameter_listContext)_localctx).param_string =  ((Parameter_listContext)_localctx).ts.name_line + " " + ((Parameter_listContext)_localctx).ID->getText();
				        logLine(((Parameter_listContext)_localctx).ID->getLine(), "parameter_list : type_specifier ID");
				        writeIntoparserLogFile(_localctx.param_string);
				    
				}
				break;
			case 2:
				{
				setState(130);
				((Parameter_listContext)_localctx).ts = type_specifier();

				        ((Parameter_listContext)_localctx).param_string =  ((Parameter_listContext)_localctx).ts.name_line;
				        logLine(((Parameter_listContext)_localctx).ts.line_number, "parameter_list : type_specifier");
				        writeIntoparserLogFile(_localctx.param_string);
				    
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(148);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(146);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new Parameter_listContext(_parentctx, _parentState);
						_localctx.pl = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_parameter_list);
						setState(135);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(136);
						match(COMMA);
						setState(137);
						((Parameter_listContext)_localctx).ts = type_specifier();
						setState(138);
						((Parameter_listContext)_localctx).ID = match(ID);

						                  ((Parameter_listContext)_localctx).param_string =  ((Parameter_listContext)_localctx).pl.param_string + "," + ((Parameter_listContext)_localctx).ts.name_line + " " + ((Parameter_listContext)_localctx).ID->getText();
						                  logLine(((Parameter_listContext)_localctx).ID->getLine(), "parameter_list : parameter_list COMMA type_specifier ID");
						                  writeIntoparserLogFile(_localctx.param_string);
						              
						}
						break;
					case 2:
						{
						_localctx = new Parameter_listContext(_parentctx, _parentState);
						_localctx.pl = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_parameter_list);
						setState(141);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(142);
						match(COMMA);
						setState(143);
						((Parameter_listContext)_localctx).ts = type_specifier();

						                  ((Parameter_listContext)_localctx).param_string =  ((Parameter_listContext)_localctx).pl.param_string + "," + ((Parameter_listContext)_localctx).ts.name_line;
						                  logLine(((Parameter_listContext)_localctx).ts.line_number, "parameter_list : parameter_list COMMA type_specifier");
						                  writeIntoparserLogFile(_localctx.param_string);
						              
						}
						break;
					}
					} 
				}
				setState(150);
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
		public std::string code_string;
		public int line_number;
		public Token LCURL;
		public StatementsContext st;
		public Token RCURL;
		public TerminalNode LCURL() { return getToken(C8086Parser.LCURL, 0); }
		public TerminalNode RCURL() { return getToken(C8086Parser.RCURL, 0); }
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public Compound_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compound_statement; }
	}

	public final Compound_statementContext compound_statement() throws RecognitionException {
		Compound_statementContext _localctx = new Compound_statementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_compound_statement);
		try {
			setState(161);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(151);
				((Compound_statementContext)_localctx).LCURL = match(LCURL);

				        ST->enterScope(); // Create new scope
				    
				setState(153);
				((Compound_statementContext)_localctx).st = statements(0);
				setState(154);
				((Compound_statementContext)_localctx).RCURL = match(RCURL);

				        ((Compound_statementContext)_localctx).code_string =  "{\n" + ((Compound_statementContext)_localctx).st.statements_string + "\n}";
				        ((Compound_statementContext)_localctx).line_number =  ((Compound_statementContext)_localctx).LCURL->getLine();
				        logLine(((Compound_statementContext)_localctx).RCURL->getLine(), "compound_statement : LCURL statements RCURL");
				        writeIntoparserLogFile(_localctx.code_string);
				        ST->printAllScopeTable(parserLogFile); // Print symbol table before exiting scope
				        ST->exitScope(); // Remove scope
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(157);
				((Compound_statementContext)_localctx).LCURL = match(LCURL);

				        ST->enterScope(); // Create new scope
				    
				setState(159);
				((Compound_statementContext)_localctx).RCURL = match(RCURL);

				        ((Compound_statementContext)_localctx).code_string =  "{\n}";
				        ((Compound_statementContext)_localctx).line_number =  ((Compound_statementContext)_localctx).LCURL->getLine();
				        logLine(((Compound_statementContext)_localctx).RCURL->getLine(), "compound_statement : LCURL RCURL");
				        writeIntoparserLogFile(_localctx.code_string);
				        ST->printAllScopeTable(parserLogFile); // Print symbol table before exiting scope
				        ST->exitScope(); // Remove scope
				    
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
		public ParseInfo info;
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
		enterRule(_localctx, 16, RULE_var_declaration);
		try {
			setState(173);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(163);
				((Var_declarationContext)_localctx).t = type_specifier();
				setState(164);
				((Var_declarationContext)_localctx).dl = declaration_list(0);
				setState(165);
				((Var_declarationContext)_localctx).sm = match(SEMICOLON);

				        int line = ((Var_declarationContext)_localctx).sm->getLine();
				        std::string code = ((Var_declarationContext)_localctx).t.name_line + " " + ((Var_declarationContext)_localctx).dl.var_list.get_list_as_string() + ";";
				        // Insert variables into symbol table with ACTUAL TYPE
				        for (const auto& var : ((Var_declarationContext)_localctx).dl.var_list.get_variables()) {
				            std::string varType;
				            std::string varName;
				            
				            if (var.find('[') != std::string::npos) {
				                // Array variable
				                varName = var.substr(0, var.find('['));
				                varType = "ARRAY," + ((Var_declarationContext)_localctx).t.name_line;  // Store actual type: ARRAY,int or ARRAY,float
				            } else {
				                // Regular variable
				                varName = var;
				                varType = ((Var_declarationContext)_localctx).t.name_line;  // Store actual type: int, float, void ,struct id,
				            }
				            
				            if (!ST->Insert(varName, varType)) {
				                writeIntoErrorFile("Line " + std::to_string(line) + ": Multiple declaration of " + varName);
				                syntaxErrorCount++;
				            }
				        }
				        logLine(line, "var_declaration : type_specifier declaration_list SEMICOLON");
				        writeIntoparserLogFile(code);
				        ((Var_declarationContext)_localctx).info =  ParseInfo(line, code);
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(168);
				((Var_declarationContext)_localctx).t = type_specifier();
				setState(169);
				((Var_declarationContext)_localctx).de = declaration_list_err();
				setState(170);
				((Var_declarationContext)_localctx).sm = match(SEMICOLON);

				        writeIntoErrorFile(
				            std::string("Line ") + std::to_string(((Var_declarationContext)_localctx).sm->getLine()) +
				            ": " + ((Var_declarationContext)_localctx).de.error_name + " - Syntax error at declaration list of variable declaration"
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
		enterRule(_localctx, 18, RULE_declaration_list_err);
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
		public std::string name_line;
		public int line_number;
		public Token INT;
		public Token FLOAT;
		public Token VOID;
		public Token STRUCT;
		public Token ID;
		public TerminalNode INT() { return getToken(C8086Parser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(C8086Parser.FLOAT, 0); }
		public TerminalNode VOID() { return getToken(C8086Parser.VOID, 0); }
		public TerminalNode STRUCT() { return getToken(C8086Parser.STRUCT, 0); }
		public TerminalNode ID() { return getToken(C8086Parser.ID, 0); }
		public Type_specifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_specifier; }
	}

	public final Type_specifierContext type_specifier() throws RecognitionException {
		Type_specifierContext _localctx = new Type_specifierContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_type_specifier);
		try {
			setState(186);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(177);
				((Type_specifierContext)_localctx).INT = match(INT);

				        ((Type_specifierContext)_localctx).name_line =  ((Type_specifierContext)_localctx).INT->getText();
				        ((Type_specifierContext)_localctx).line_number =  ((Type_specifierContext)_localctx).INT->getLine();
				        logLine(((Type_specifierContext)_localctx).INT->getLine(), "type_specifier : INT");
				        writeIntoparserLogFile(((Type_specifierContext)_localctx).INT->getText());
				    
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(179);
				((Type_specifierContext)_localctx).FLOAT = match(FLOAT);

				        ((Type_specifierContext)_localctx).name_line =  ((Type_specifierContext)_localctx).FLOAT->getText();
				        ((Type_specifierContext)_localctx).line_number =  ((Type_specifierContext)_localctx).FLOAT->getLine();
				        logLine(((Type_specifierContext)_localctx).FLOAT->getLine(), "type_specifier : FLOAT");
				        writeIntoparserLogFile(((Type_specifierContext)_localctx).FLOAT->getText());
				    
				}
				break;
			case VOID:
				enterOuterAlt(_localctx, 3);
				{
				setState(181);
				((Type_specifierContext)_localctx).VOID = match(VOID);

				        ((Type_specifierContext)_localctx).name_line =  ((Type_specifierContext)_localctx).VOID->getText();
				        ((Type_specifierContext)_localctx).line_number =  ((Type_specifierContext)_localctx).VOID->getLine();
				        logLine(((Type_specifierContext)_localctx).VOID->getLine(), "type_specifier : VOID");
				        writeIntoparserLogFile(((Type_specifierContext)_localctx).VOID->getText());
				    
				}
				break;
			case STRUCT:
				enterOuterAlt(_localctx, 4);
				{
				setState(183);
				((Type_specifierContext)_localctx).STRUCT = match(STRUCT);
				setState(184);
				((Type_specifierContext)_localctx).ID = match(ID);

				        ((Type_specifierContext)_localctx).name_line =  ((Type_specifierContext)_localctx).STRUCT->getText()+" "+ ((Type_specifierContext)_localctx).ID->getText();
				        ((Type_specifierContext)_localctx).line_number =  ((Type_specifierContext)_localctx).STRUCT->getLine();
				        logLine(((Type_specifierContext)_localctx).STRUCT->getLine(),"type_specifier : STRUCT");
				        writeIntoparserLogFile(((Type_specifierContext)_localctx).STRUCT->getText()+" "+ ((Type_specifierContext)_localctx).ID->getText());
				    
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
		public str_list var_list;
		public Declaration_listContext dl;
		public Token ID;
		public Token CONST_INT;
		public TerminalNode ID() { return getToken(C8086Parser.ID, 0); }
		public TerminalNode LTHIRD() { return getToken(C8086Parser.LTHIRD, 0); }
		public TerminalNode CONST_INT() { return getToken(C8086Parser.CONST_INT, 0); }
		public TerminalNode RTHIRD() { return getToken(C8086Parser.RTHIRD, 0); }
		public TerminalNode COMMA() { return getToken(C8086Parser.COMMA, 0); }
		public Declaration_listContext declaration_list() {
			return getRuleContext(Declaration_listContext.class,0);
		}
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
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_declaration_list, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(189);
				((Declaration_listContext)_localctx).ID = match(ID);

				        logLine(((Declaration_listContext)_localctx).ID->getLine(), "declaration_list : ID");
				        _localctx.var_list.add(((Declaration_listContext)_localctx).ID->getText());
				        writeIntoparserLogFile(((Declaration_listContext)_localctx).ID->getText());
				    
				}
				break;
			case 2:
				{
				setState(191);
				((Declaration_listContext)_localctx).ID = match(ID);
				setState(192);
				match(LTHIRD);
				setState(193);
				((Declaration_listContext)_localctx).CONST_INT = match(CONST_INT);
				setState(194);
				match(RTHIRD);

				        logLine(((Declaration_listContext)_localctx).ID->getLine(), "declaration_list : ID LTHIRD CONST_INT RTHIRD");
				        _localctx.var_list.add(((Declaration_listContext)_localctx).ID->getText() + "[" + ((Declaration_listContext)_localctx).CONST_INT->getText() + "]");
				        writeIntoparserLogFile(((Declaration_listContext)_localctx).ID->getText() + "[" + ((Declaration_listContext)_localctx).CONST_INT->getText() + "]");
				    
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(211);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(209);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
						{
						_localctx = new Declaration_listContext(_parentctx, _parentState);
						_localctx.dl = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_declaration_list);
						setState(198);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(199);
						match(COMMA);
						setState(200);
						((Declaration_listContext)_localctx).ID = match(ID);

						                  _localctx.var_list.set_variables(((Declaration_listContext)_localctx).dl.var_list.get_variables());
						                  _localctx.var_list.add(((Declaration_listContext)_localctx).ID->getText());
						                  logLine(((Declaration_listContext)_localctx).ID->getLine(), "declaration_list : declaration_list COMMA ID");
						                  writeIntoparserLogFile(_localctx.var_list.get_list_as_string());
						              
						}
						break;
					case 2:
						{
						_localctx = new Declaration_listContext(_parentctx, _parentState);
						_localctx.dl = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_declaration_list);
						setState(202);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(203);
						match(COMMA);
						setState(204);
						((Declaration_listContext)_localctx).ID = match(ID);
						setState(205);
						match(LTHIRD);
						setState(206);
						((Declaration_listContext)_localctx).CONST_INT = match(CONST_INT);
						setState(207);
						match(RTHIRD);

						                  _localctx.var_list.set_variables(((Declaration_listContext)_localctx).dl.var_list.get_variables());
						                  _localctx.var_list.add(((Declaration_listContext)_localctx).ID->getText() + "[" + ((Declaration_listContext)_localctx).CONST_INT->getText() + "]");
						                  logLine(((Declaration_listContext)_localctx).ID->getLine(), "declaration_list : declaration_list COMMA ID LTHIRD CONST_INT RTHIRD");
						                  writeIntoparserLogFile(_localctx.var_list.get_list_as_string());
						              
						}
						break;
					}
					} 
				}
				setState(213);
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
		public std::string statements_string;
		public StatementsContext sts;
		public StatementContext st;
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
			setState(215);
			((StatementsContext)_localctx).st = statement();

			        ((StatementsContext)_localctx).statements_string =  ((StatementsContext)_localctx).st.statement_string;
			        logLine(((StatementsContext)_localctx).st.line_number, "statements : statement");
			        writeIntoparserLogFile(_localctx.statements_string);

			        // writeIntoErrorFile(error);
			        if(doDepth == 0){
			            if(((StatementsContext)_localctx).st.statement_string.find("break")==0){
			                writeIntoErrorFile("Error break outside loop");
			            }
			            else if(((StatementsContext)_localctx).st.statement_string.find("continue")==0){
			                writeIntoErrorFile("Error continue outside loop");
			            }
			        }
			    
			}
			_ctx.stop = _input.LT(-1);
			setState(224);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new StatementsContext(_parentctx, _parentState);
					_localctx.sts = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_statements);
					setState(218);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(219);
					((StatementsContext)_localctx).st = statement();

					                  ((StatementsContext)_localctx).statements_string =  ((StatementsContext)_localctx).sts.statements_string + "\n" + ((StatementsContext)_localctx).st.statement_string;
					                  logLine(((StatementsContext)_localctx).st.line_number, "statements : statements statement");
					                  writeIntoparserLogFile(_localctx.statements_string);
					                  if(doDepth == 0){
					                      if(((StatementsContext)_localctx).st.statement_string.find("break")==0){
					                          writeIntoErrorFile("Error break outside loop");
					                      }
					                      else if(((StatementsContext)_localctx).st.statement_string.find("continue")==0){
					                          writeIntoErrorFile("Error continue outside loop");
					                      }
					                  }
					              
					}
					} 
				}
				setState(226);
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
		public std::string statement_string;
		public int line_number;
		public Var_declarationContext vd;
		public Expression_statementContext es;
		public Compound_statementContext cs;
		public Token FOR;
		public Expression_statementContext es1;
		public Expression_statementContext es2;
		public ExpressionContext e;
		public StatementContext st;
		public Token IF;
		public StatementContext st1;
		public StatementContext st2;
		public Token WHILE;
		public Token PRINTLN;
		public Token ID;
		public Token RETURN;
		public Token SWITCH;
		public ExpressionContext expression;
		public Switch_casesContext sc;
		public Token DO;
		public Token BREAK;
		public Token CONTINUE;
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
		public TerminalNode RPAREN() { return getToken(C8086Parser.RPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
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
		public TerminalNode SWITCH() { return getToken(C8086Parser.SWITCH, 0); }
		public TerminalNode LCURL() { return getToken(C8086Parser.LCURL, 0); }
		public TerminalNode RCURL() { return getToken(C8086Parser.RCURL, 0); }
		public Switch_casesContext switch_cases() {
			return getRuleContext(Switch_casesContext.class,0);
		}
		public TerminalNode DO() { return getToken(C8086Parser.DO, 0); }
		public TerminalNode BREAK() { return getToken(C8086Parser.BREAK, 0); }
		public TerminalNode CONTINUE() { return getToken(C8086Parser.CONTINUE, 0); }
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_statement);
		try {
			setState(304);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(227);
				((StatementContext)_localctx).vd = var_declaration();

				        ((StatementContext)_localctx).statement_string =  ((StatementContext)_localctx).vd.info.parsed_code;
				        ((StatementContext)_localctx).line_number =  ((StatementContext)_localctx).vd.info.line_number;
				        logLine(_localctx.line_number, "statement : var_declaration");
				        writeIntoparserLogFile(_localctx.statement_string);
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(230);
				((StatementContext)_localctx).es = expression_statement();

				        ((StatementContext)_localctx).statement_string =  ((StatementContext)_localctx).es.expr_string;
				        ((StatementContext)_localctx).line_number =  ((StatementContext)_localctx).es.line_number;
				        logLine(_localctx.line_number, "statement : expression_statement");
				        writeIntoparserLogFile(_localctx.statement_string);
				    
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(233);
				((StatementContext)_localctx).cs = compound_statement();

				        ((StatementContext)_localctx).statement_string =  ((StatementContext)_localctx).cs.code_string;
				        ((StatementContext)_localctx).line_number =  ((StatementContext)_localctx).cs.line_number;
				        logLine(_localctx.line_number, "statement : compound_statement");
				        writeIntoparserLogFile(_localctx.statement_string);
				    
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(236);
				((StatementContext)_localctx).FOR = match(FOR);
				setState(237);
				match(LPAREN);
				setState(238);
				((StatementContext)_localctx).es1 = expression_statement();
				setState(239);
				((StatementContext)_localctx).es2 = expression_statement();
				setState(240);
				((StatementContext)_localctx).e = expression();
				setState(241);
				match(RPAREN);
				setState(242);
				((StatementContext)_localctx).st = statement();

				        ((StatementContext)_localctx).statement_string =  "for(" + ((StatementContext)_localctx).es1.expr_string + ((StatementContext)_localctx).es2.expr_string + ((StatementContext)_localctx).e.expr_string + ")" + ((StatementContext)_localctx).st.statement_string;
				        ((StatementContext)_localctx).line_number =  ((StatementContext)_localctx).FOR->getLine();
				        logLine(_localctx.line_number, "statement : FOR LPAREN expression_statement expression_statement expression RPAREN statement");
				        writeIntoparserLogFile(_localctx.statement_string);
				    
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(245);
				((StatementContext)_localctx).IF = match(IF);
				setState(246);
				match(LPAREN);
				setState(247);
				((StatementContext)_localctx).e = expression();
				setState(248);
				match(RPAREN);
				setState(249);
				((StatementContext)_localctx).st = statement();

				        ((StatementContext)_localctx).statement_string =  "if(" + ((StatementContext)_localctx).e.expr_string + ")" + ((StatementContext)_localctx).st.statement_string;
				        ((StatementContext)_localctx).line_number =  ((StatementContext)_localctx).IF->getLine();
				        logLine(_localctx.line_number, "statement : IF LPAREN expression RPAREN statement");
				        writeIntoparserLogFile(_localctx.statement_string);
				    
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(252);
				((StatementContext)_localctx).IF = match(IF);
				setState(253);
				match(LPAREN);
				setState(254);
				((StatementContext)_localctx).e = expression();
				setState(255);
				match(RPAREN);
				setState(256);
				((StatementContext)_localctx).st1 = statement();
				setState(257);
				match(ELSE);
				setState(258);
				((StatementContext)_localctx).st2 = statement();

				        ((StatementContext)_localctx).statement_string =  "if(" + ((StatementContext)_localctx).e.expr_string + ")" + ((StatementContext)_localctx).st1.statement_string + " else " + ((StatementContext)_localctx).st2.statement_string;
				        ((StatementContext)_localctx).line_number =  ((StatementContext)_localctx).IF->getLine();
				        logLine(_localctx.line_number, "statement : IF LPAREN expression RPAREN statement ELSE statement");
				        writeIntoparserLogFile(_localctx.statement_string);
				    
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(261);
				((StatementContext)_localctx).WHILE = match(WHILE);
				setState(262);
				match(LPAREN);
				setState(263);
				((StatementContext)_localctx).e = expression();
				setState(264);
				match(RPAREN);
				setState(265);
				((StatementContext)_localctx).st = statement();

				        ((StatementContext)_localctx).statement_string =  "while(" + ((StatementContext)_localctx).e.expr_string + ")" + ((StatementContext)_localctx).st.statement_string;
				        ((StatementContext)_localctx).line_number =  ((StatementContext)_localctx).WHILE->getLine();
				        logLine(_localctx.line_number, "statement : WHILE LPAREN expression RPAREN statement");
				        writeIntoparserLogFile(_localctx.statement_string);
				    
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(268);
				((StatementContext)_localctx).PRINTLN = match(PRINTLN);
				setState(269);
				match(LPAREN);
				setState(270);
				((StatementContext)_localctx).ID = match(ID);
				setState(271);
				match(RPAREN);
				setState(272);
				match(SEMICOLON);

				        ((StatementContext)_localctx).statement_string =  "println(" + ((StatementContext)_localctx).ID->getText() + ");";
				        ((StatementContext)_localctx).line_number =  ((StatementContext)_localctx).PRINTLN->getLine();
				        if (!ST->LookUp(((StatementContext)_localctx).ID->getText())) {
				            writeIntoErrorFile("Line " + std::to_string(_localctx.line_number) + ": Undeclared variable " + ((StatementContext)_localctx).ID->getText());
				            syntaxErrorCount++;
				        }
				        logLine(_localctx.line_number, "statement : PRINTLN LPAREN ID RPAREN SEMICOLON");
				        writeIntoparserLogFile(_localctx.statement_string);
				    
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(274);
				((StatementContext)_localctx).RETURN = match(RETURN);
				setState(275);
				((StatementContext)_localctx).e = expression();
				setState(276);
				match(SEMICOLON);

				        ((StatementContext)_localctx).statement_string =  "return " + ((StatementContext)_localctx).e.expr_string + ";";
				        ((StatementContext)_localctx).line_number =  ((StatementContext)_localctx).RETURN->getLine();
				        logLine(_localctx.line_number, "statement : RETURN expression SEMICOLON");
				        writeIntoparserLogFile(_localctx.statement_string);
				    
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(279);
				((StatementContext)_localctx).SWITCH = match(SWITCH);
				setState(280);
				match(LPAREN);
				setState(281);
				((StatementContext)_localctx).expression = expression();
				setState(282);
				match(RPAREN);
				setState(283);
				match(LCURL);
				setState(284);
				((StatementContext)_localctx).sc = switch_cases(0);
				setState(285);
				match(RCURL);
				 
				        ((StatementContext)_localctx).statement_string =  "switch(" + ((StatementContext)_localctx).expression.expr_string + ") {\n" + ((StatementContext)_localctx).sc.info.parsed_code + "\n}";
				        ((StatementContext)_localctx).line_number =  ((StatementContext)_localctx).SWITCH->getLine();
				        logLine(_localctx.line_number, "statement : SWITCH LPAREN expression RPAREN LCURL switch_cases RCURL");
				        writeIntoparserLogFile(_localctx.statement_string);
				    
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(288);
				((StatementContext)_localctx).DO = match(DO);
				doDepth++;
				setState(290);
				((StatementContext)_localctx).cs = compound_statement();
				setState(291);
				match(WHILE);
				setState(292);
				match(LPAREN);
				setState(293);
				((StatementContext)_localctx).e = expression();
				setState(294);
				match(RPAREN);
				setState(295);
				match(SEMICOLON);

				        ((StatementContext)_localctx).statement_string =  "do "+((StatementContext)_localctx).cs.code_string + "while(" + ((StatementContext)_localctx).e.expr_string +");";
				        ((StatementContext)_localctx).line_number =  ((StatementContext)_localctx).DO->getLine();
				        
				        logLine(_localctx.line_number,"statement : DO compound_statement WHILE LPAREN expression RPAREN SEMICOLON");
				        writeIntoparserLogFile(_localctx.statement_string);
				        doDepth--;
				    
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(298);
				((StatementContext)_localctx).BREAK = match(BREAK);
				setState(299);
				match(SEMICOLON);

				        ((StatementContext)_localctx).statement_string =  "break;";
				        ((StatementContext)_localctx).line_number =  ((StatementContext)_localctx).BREAK->getLine();
				        logLine(_localctx.line_number, "statement : BREAK SEMICOLON");
				        writeIntoparserLogFile(_localctx.statement_string);
				     
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(301);
				((StatementContext)_localctx).CONTINUE = match(CONTINUE);
				setState(302);
				match(SEMICOLON);

				        ((StatementContext)_localctx).statement_string =  "continue;";
				        ((StatementContext)_localctx).line_number =  ((StatementContext)_localctx).CONTINUE->getLine();
				        logLine(_localctx.line_number, "statement : CONTINUE SEMICOLON");
				        writeIntoparserLogFile(_localctx.statement_string);
				     
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
	public static class Switch_casesContext extends ParserRuleContext {
		public ParseInfo info;
		public Switch_casesContext sc;
		public Case_statementContext case_statement;
		public Case_statementContext cs;
		public Case_statementContext case_statement() {
			return getRuleContext(Case_statementContext.class,0);
		}
		public Switch_casesContext switch_cases() {
			return getRuleContext(Switch_casesContext.class,0);
		}
		public Switch_casesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switch_cases; }
	}

	public final Switch_casesContext switch_cases() throws RecognitionException {
		return switch_cases(0);
	}

	private Switch_casesContext switch_cases(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Switch_casesContext _localctx = new Switch_casesContext(_ctx, _parentState);
		Switch_casesContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_switch_cases, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(307);
			((Switch_casesContext)_localctx).case_statement = case_statement();

			            _localctx.info.line_number = ((Switch_casesContext)_localctx).case_statement.info.line_number;
			            _localctx.info.parsed_code = ((Switch_casesContext)_localctx).case_statement.info.parsed_code;
			            logLine(_localctx.info.line_number, "switch_cases : case_statement");
			            writeIntoparserLogFile(_localctx.info.parsed_code);
			         
			}
			_ctx.stop = _input.LT(-1);
			setState(316);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Switch_casesContext(_parentctx, _parentState);
					_localctx.sc = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_switch_cases);
					setState(310);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(311);
					((Switch_casesContext)_localctx).cs = ((Switch_casesContext)_localctx).case_statement = case_statement();

					                      _localctx.info.line_number = ((Switch_casesContext)_localctx).cs.info.line_number;
					                      _localctx.info.parsed_code = ((Switch_casesContext)_localctx).sc.info.parsed_code + "\n" + ((Switch_casesContext)_localctx).cs.info.parsed_code;
					                      logLine(_localctx.info.line_number, "switch_cases : switch_cases case_statement");
					                      writeIntoparserLogFile(_localctx.info.parsed_code);
					                    
					}
					} 
				}
				setState(318);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
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
	public static class Case_statementContext extends ParserRuleContext {
		public ParseInfo info;
		public Token CASE;
		public ExpressionContext e;
		public StatementsContext st;
		public Token DEFAULT;
		public TerminalNode CASE() { return getToken(C8086Parser.CASE, 0); }
		public TerminalNode COLON() { return getToken(C8086Parser.COLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public TerminalNode DEFAULT() { return getToken(C8086Parser.DEFAULT, 0); }
		public Case_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_case_statement; }
	}

	public final Case_statementContext case_statement() throws RecognitionException {
		Case_statementContext _localctx = new Case_statementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_case_statement);
		try {
			setState(330);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CASE:
				enterOuterAlt(_localctx, 1);
				{
				setState(319);
				((Case_statementContext)_localctx).CASE = match(CASE);
				setState(320);
				((Case_statementContext)_localctx).e = expression();
				setState(321);
				match(COLON);
				setState(322);
				((Case_statementContext)_localctx).st = statements(0);

				        _localctx.info.line_number = ((Case_statementContext)_localctx).CASE->getLine();
				        _localctx.info.parsed_code = "case " + ((Case_statementContext)_localctx).e.expr_string + ":\n" + ((Case_statementContext)_localctx).st.statements_string;
				        logLine(_localctx.info.line_number, "case_statement : CASE expression COLON statements");
				        writeIntoparserLogFile(_localctx.info.parsed_code);
				    
				}
				break;
			case DEFAULT:
				enterOuterAlt(_localctx, 2);
				{
				setState(325);
				((Case_statementContext)_localctx).DEFAULT = match(DEFAULT);
				setState(326);
				match(COLON);
				setState(327);
				((Case_statementContext)_localctx).st = statements(0);

				        _localctx.info.line_number = ((Case_statementContext)_localctx).DEFAULT->getLine();
				        _localctx.info.parsed_code = "default:\n" + ((Case_statementContext)_localctx).st.statements_string;
				        logLine(_localctx.info.line_number, "case_statement : DEFAULT COLON statements");
				        writeIntoparserLogFile(_localctx.info.parsed_code);
				    
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
	public static class Expression_statementContext extends ParserRuleContext {
		public std::string expr_string;
		public int line_number;
		public Token SEMICOLON;
		public ExpressionContext e;
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
		enterRule(_localctx, 32, RULE_expression_statement);
		try {
			setState(338);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SEMICOLON:
				enterOuterAlt(_localctx, 1);
				{
				setState(332);
				((Expression_statementContext)_localctx).SEMICOLON = match(SEMICOLON);

				        ((Expression_statementContext)_localctx).expr_string =  ";";
				        ((Expression_statementContext)_localctx).line_number =  ((Expression_statementContext)_localctx).SEMICOLON->getLine();
				        logLine(_localctx.line_number, "expression_statement : SEMICOLON");
				        writeIntoparserLogFile(_localctx.expr_string);
				    
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
				setState(334);
				((Expression_statementContext)_localctx).e = expression();
				setState(335);
				((Expression_statementContext)_localctx).SEMICOLON = match(SEMICOLON);

				        ((Expression_statementContext)_localctx).expr_string =  ((Expression_statementContext)_localctx).e.expr_string + ";";
				        ((Expression_statementContext)_localctx).line_number =  ((Expression_statementContext)_localctx).SEMICOLON->getLine();
				        logLine(_localctx.line_number, "expression_statement : expression SEMICOLON");
				        writeIntoparserLogFile(_localctx.expr_string);
				    
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
		public std::string var_string;
		public int line_number;
		public std::string var_type;
		public Token ID;
		public ExpressionContext e;
		public TerminalNode ID() { return getToken(C8086Parser.ID, 0); }
		public TerminalNode LTHIRD() { return getToken(C8086Parser.LTHIRD, 0); }
		public TerminalNode RTHIRD() { return getToken(C8086Parser.RTHIRD, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_variable);
		try {
			setState(348);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(340);
				((VariableContext)_localctx).ID = match(ID);

				        ((VariableContext)_localctx).var_string =  ((VariableContext)_localctx).ID->getText();
				        ((VariableContext)_localctx).line_number =  ((VariableContext)_localctx).ID->getLine();
				        SymbolInfo* sym = ST->LookUp(((VariableContext)_localctx).ID->getText());
				        if (!sym) {
				            logError(_localctx.line_number, "Undeclared variable " + ((VariableContext)_localctx).ID->getText());
				            syntaxErrorCount++;
				            ((VariableContext)_localctx).var_type =  "";
				        } else {
				            std::string fullType = sym->getOriginalType(); // Use original type
				            if (fullType.find("ARRAY,") == 0) {
				                // This is array access without brackets - ERROR for assignment ONLY in assignment context
				                // For expression context, this should be allowed as array name
				                ((VariableContext)_localctx).var_type =  fullType; // Keep full array type
				            } else {
				                ((VariableContext)_localctx).var_type =  sym->getType(); // Regular variable type (int/float/void)
				            }
				        }
				        logLine(_localctx.line_number, "variable : ID");
				        writeIntoparserLogFile(_localctx.var_string);
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(342);
				((VariableContext)_localctx).ID = match(ID);
				setState(343);
				match(LTHIRD);
				setState(344);
				((VariableContext)_localctx).e = expression();
				setState(345);
				match(RTHIRD);

				        ((VariableContext)_localctx).var_string =  ((VariableContext)_localctx).ID->getText() + "[" + ((VariableContext)_localctx).e.expr_string + "]";
				        ((VariableContext)_localctx).line_number =  ((VariableContext)_localctx).ID->getLine();
				        SymbolInfo* sym = ST->LookUp(((VariableContext)_localctx).ID->getText());
				        if (!sym) {
				            writeIntoErrorFile("Line " + std::to_string(_localctx.line_number) + ": Undeclared variable " + ((VariableContext)_localctx).ID->getText());
				            syntaxErrorCount++;
				            ((VariableContext)_localctx).var_type =  "";
				        } else {
				            std::string fullType = sym->getOriginalType();
				            if (fullType.find("ARRAY,") != 0) {
				                writeIntoErrorFile("Line " + std::to_string(_localctx.line_number) + ": " + ((VariableContext)_localctx).ID->getText() + " is not an array");
				                syntaxErrorCount++;
				                ((VariableContext)_localctx).var_type =  "";
				            } else {
				                ((VariableContext)_localctx).var_type =  fullType.substr(6); // Remove "ARRAY," to get base type (int/float)
				                if (!((VariableContext)_localctx).e.is_integer) {
				                    writeIntoErrorFile("Line " + std::to_string(_localctx.line_number) + ": Expression inside third brackets not an integer");
				                    syntaxErrorCount++;
				                }
				            }
				        }
				        logLine(_localctx.line_number, "variable : ID LTHIRD expression RTHIRD");
				        writeIntoparserLogFile(_localctx.var_string);
				    
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
		public std::string expr_string;
		public int line_number;
		public std::string expr_type;
		public bool is_integer;
		public Logic_expressionContext le;
		public VariableContext v;
		public Logic_expressionContext logic_expression() {
			return getRuleContext(Logic_expressionContext.class,0);
		}
		public TerminalNode ASSIGNOP() { return getToken(C8086Parser.ASSIGNOP, 0); }
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
		enterRule(_localctx, 36, RULE_expression);
		try {
			setState(358);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(350);
				((ExpressionContext)_localctx).le = logic_expression();

				        ((ExpressionContext)_localctx).expr_string =  ((ExpressionContext)_localctx).le.expr_string;
				        ((ExpressionContext)_localctx).line_number =  ((ExpressionContext)_localctx).le.line_number;
				        ((ExpressionContext)_localctx).expr_type =  ((ExpressionContext)_localctx).le.expr_type;
				        ((ExpressionContext)_localctx).is_integer =  ((ExpressionContext)_localctx).le.is_integer;
				        logLine(_localctx.line_number, "expression : logic expression");
				        writeIntoparserLogFile(_localctx.expr_string);
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(353);
				((ExpressionContext)_localctx).v = variable();
				setState(354);
				match(ASSIGNOP);
				setState(355);
				((ExpressionContext)_localctx).le = logic_expression();

				        ((ExpressionContext)_localctx).expr_string =  ((ExpressionContext)_localctx).v.var_string + "=" + ((ExpressionContext)_localctx).le.expr_string;
				        ((ExpressionContext)_localctx).line_number =  ((ExpressionContext)_localctx).v.line_number;
				        // writeIntoErrorFile("var_type: "+ ((ExpressionContext)_localctx).v.var_type + "expression_type: " + ((ExpressionContext)_localctx).le.expr_type);
				        
				        // Check if trying to assign to array name (without index)
				        if (((ExpressionContext)_localctx).v.var_type.find("ARRAY,") == 0 && ((ExpressionContext)_localctx).v.var_string.find("[") == std::string::npos) {
				            writeIntoErrorFile("Line " + std::to_string(_localctx.line_number) + ": Type mismatch, " + ((ExpressionContext)_localctx).v.var_string + " is an array");
				            syntaxErrorCount++;
				        } else {
				            // Get the actual assignable type
				            std::string assignableType = getBaseType(((ExpressionContext)_localctx).v.var_type);
				            if (assignableType!="" &&  !isTypeCompatible(assignableType, ((ExpressionContext)_localctx).le.expr_type)) {
				                writeIntoErrorFile("Line " + std::to_string(_localctx.line_number) + ": Type Mismatch");
				                syntaxErrorCount++;
				            }
				        }
				        
				        ((ExpressionContext)_localctx).expr_type =  getBaseType(((ExpressionContext)_localctx).v.var_type);
				        ((ExpressionContext)_localctx).is_integer =  isIntegerType(_localctx.expr_type);
				        logLine(_localctx.line_number, "expression : variable ASSIGNOP logic expression");
				        writeIntoparserLogFile(_localctx.expr_string);
				    
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
		public std::string expr_string;
		public int line_number;
		public std::string expr_type;
		public bool is_integer;
		public Rel_expressionContext re;
		public Rel_expressionContext re1;
		public Token LOGICOP;
		public Rel_expressionContext re2;
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
		enterRule(_localctx, 38, RULE_logic_expression);
		try {
			setState(368);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(360);
				((Logic_expressionContext)_localctx).re = rel_expression();

				        ((Logic_expressionContext)_localctx).expr_string =  ((Logic_expressionContext)_localctx).re.expr_string;
				        ((Logic_expressionContext)_localctx).line_number =  ((Logic_expressionContext)_localctx).re.line_number;
				        ((Logic_expressionContext)_localctx).expr_type =  ((Logic_expressionContext)_localctx).re.expr_type;
				        ((Logic_expressionContext)_localctx).is_integer =  ((Logic_expressionContext)_localctx).re.is_integer;
				        logLine(_localctx.line_number, "logic expression : rel_expression");
				        writeIntoparserLogFile(_localctx.expr_string);
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(363);
				((Logic_expressionContext)_localctx).re1 = rel_expression();
				setState(364);
				((Logic_expressionContext)_localctx).LOGICOP = match(LOGICOP);
				setState(365);
				((Logic_expressionContext)_localctx).re2 = rel_expression();

				        ((Logic_expressionContext)_localctx).expr_string =  ((Logic_expressionContext)_localctx).re1.expr_string + " " + ((Logic_expressionContext)_localctx).LOGICOP->getText() + " " + ((Logic_expressionContext)_localctx).re2.expr_string;
				        ((Logic_expressionContext)_localctx).line_number =  ((Logic_expressionContext)_localctx).re1.line_number;
				        ((Logic_expressionContext)_localctx).expr_type =  "int"; // LOGICOP results in int
				        ((Logic_expressionContext)_localctx).is_integer =  true;
				        logLine(_localctx.line_number, "logic expression : rel_expression LOGICOP rel_expression");
				        writeIntoparserLogFile(_localctx.expr_string);
				    
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
		public std::string expr_string;
		public int line_number;
		public std::string expr_type;
		public bool is_integer;
		public Simple_expressionContext se;
		public Simple_expressionContext se1;
		public Token RELOP;
		public Simple_expressionContext se2;
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
		enterRule(_localctx, 40, RULE_rel_expression);
		try {
			setState(378);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(370);
				((Rel_expressionContext)_localctx).se = simple_expression(0);

				        ((Rel_expressionContext)_localctx).expr_string =  ((Rel_expressionContext)_localctx).se.expr_string;
				        ((Rel_expressionContext)_localctx).line_number =  ((Rel_expressionContext)_localctx).se.line_number;
				        ((Rel_expressionContext)_localctx).expr_type =  ((Rel_expressionContext)_localctx).se.expr_type;
				        ((Rel_expressionContext)_localctx).is_integer =  ((Rel_expressionContext)_localctx).se.is_integral;
				        logLine(_localctx.line_number, "rel_expression : simple_expression");
				        writeIntoparserLogFile(_localctx.expr_string);
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(373);
				((Rel_expressionContext)_localctx).se1 = simple_expression(0);
				setState(374);
				((Rel_expressionContext)_localctx).RELOP = match(RELOP);
				setState(375);
				((Rel_expressionContext)_localctx).se2 = simple_expression(0);

				        ((Rel_expressionContext)_localctx).expr_string =  ((Rel_expressionContext)_localctx).se1.expr_string + ((Rel_expressionContext)_localctx).RELOP->getText() + ((Rel_expressionContext)_localctx).se2.expr_string;
				        ((Rel_expressionContext)_localctx).line_number =  ((Rel_expressionContext)_localctx).se1.line_number;
				        ((Rel_expressionContext)_localctx).expr_type =  "int"; // RELOP results in int
				        ((Rel_expressionContext)_localctx).is_integer =  true;
				        logLine(_localctx.line_number, "rel_expression : simple_expression RELOP simple_expression");
				        writeIntoparserLogFile(_localctx.expr_string);
				    
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
		public std::string expr_string;
		public int line_number;
		public std::string expr_type;
		public bool is_integral;
		public Simple_expressionContext se;
		public TermContext t;
		public Token ADDOP;
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode ADDOP() { return getToken(C8086Parser.ADDOP, 0); }
		public Simple_expressionContext simple_expression() {
			return getRuleContext(Simple_expressionContext.class,0);
		}
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
		int _startState = 42;
		enterRecursionRule(_localctx, 42, RULE_simple_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(381);
			((Simple_expressionContext)_localctx).t = term(0);

			        ((Simple_expressionContext)_localctx).expr_string =  ((Simple_expressionContext)_localctx).t.expr_string;
			        ((Simple_expressionContext)_localctx).line_number =  ((Simple_expressionContext)_localctx).t.line_number;
			        ((Simple_expressionContext)_localctx).expr_type =  ((Simple_expressionContext)_localctx).t.t_type;
			        ((Simple_expressionContext)_localctx).is_integral =  ((Simple_expressionContext)_localctx).t.is_integer;
			        logLine(_localctx.line_number, "simple_expression : term");
			        writeIntoparserLogFile(_localctx.expr_string);
			    
			}
			_ctx.stop = _input.LT(-1);
			setState(391);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Simple_expressionContext(_parentctx, _parentState);
					_localctx.se = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_simple_expression);
					setState(384);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(385);
					((Simple_expressionContext)_localctx).ADDOP = match(ADDOP);
					setState(386);
					((Simple_expressionContext)_localctx).t = term(0);

					                  ((Simple_expressionContext)_localctx).expr_string =  ((Simple_expressionContext)_localctx).se.expr_string + ((Simple_expressionContext)_localctx).ADDOP->getText() + ((Simple_expressionContext)_localctx).t.expr_string;
					                  ((Simple_expressionContext)_localctx).line_number =  ((Simple_expressionContext)_localctx).se.line_number;
					                  if (((Simple_expressionContext)_localctx).se.expr_type == "float" || ((Simple_expressionContext)_localctx).t.t_type == "float") {
					                      ((Simple_expressionContext)_localctx).expr_type =  "float";
					                      ((Simple_expressionContext)_localctx).is_integral =  false;
					                  } else {
					                      ((Simple_expressionContext)_localctx).expr_type =  "int";
					                      ((Simple_expressionContext)_localctx).is_integral =  true;
					                  }
					                  logLine(_localctx.line_number, "simple_expression : simple_expression ADDOP term");
					                  writeIntoparserLogFile(_localctx.expr_string);
					              
					}
					} 
				}
				setState(393);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
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
		public std::string expr_string;
		public int line_number;
		public std::string t_type;
		public bool is_integer;
		public TermContext t;
		public Unary_expressionContext ue;
		public Token MULOP;
		public Unary_expressionContext unary_expression() {
			return getRuleContext(Unary_expressionContext.class,0);
		}
		public TerminalNode MULOP() { return getToken(C8086Parser.MULOP, 0); }
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
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
		int _startState = 44;
		enterRecursionRule(_localctx, 44, RULE_term, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(395);
			((TermContext)_localctx).ue = unary_expression();

			        ((TermContext)_localctx).expr_string =  ((TermContext)_localctx).ue.expr_string;
			        ((TermContext)_localctx).line_number =  ((TermContext)_localctx).ue.line_number;
			        ((TermContext)_localctx).t_type =  ((TermContext)_localctx).ue.expr_type;
			        ((TermContext)_localctx).is_integer =  ((TermContext)_localctx).ue.is_integer;
			        logLine(_localctx.line_number, "term : unary_expression");
			        writeIntoparserLogFile(_localctx.expr_string);
			    
			}
			_ctx.stop = _input.LT(-1);
			setState(405);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TermContext(_parentctx, _parentState);
					_localctx.t = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_term);
					setState(398);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(399);
					((TermContext)_localctx).MULOP = match(MULOP);
					setState(400);
					((TermContext)_localctx).ue = unary_expression();

					                  ((TermContext)_localctx).expr_string =  ((TermContext)_localctx).t.expr_string +  ((TermContext)_localctx).MULOP->getText() + ((TermContext)_localctx).ue.expr_string;
					                  ((TermContext)_localctx).line_number =  ((TermContext)_localctx).t.line_number;
					                  if (((TermContext)_localctx).MULOP->getText() == "%") {
					                      if (!((TermContext)_localctx).t.is_integer || !((TermContext)_localctx).ue.is_integer) {
					                          writeIntoErrorFile("Line " + std::to_string(_localctx.line_number) + ": Non-Integer operand on modulus operator");
					                          syntaxErrorCount++;
					                      }
					                      ((TermContext)_localctx).t_type =  "int";
					                      ((TermContext)_localctx).is_integer =  true;
					                  } else {
					                      if (((TermContext)_localctx).t.t_type == "float" || ((TermContext)_localctx).ue.expr_type == "float") {
					                          ((TermContext)_localctx).t_type =  "float";
					                          ((TermContext)_localctx).is_integer =  false;
					                      } else {
					                          ((TermContext)_localctx).t_type =  "int";
					                          ((TermContext)_localctx).is_integer =  true;
					                      }
					                  }
					                  logLine(_localctx.line_number, "term : term MULOP unary_expression");
					                  writeIntoparserLogFile(_localctx.expr_string);
					              
					}
					} 
				}
				setState(407);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
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
		public std::string expr_string;
		public int line_number;
		public std::string expr_type;
		public bool is_integer;
		public Token ADDOP;
		public Unary_expressionContext ue;
		public Token NOT;
		public FactorContext f;
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
		enterRule(_localctx, 46, RULE_unary_expression);
		try {
			setState(419);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ADDOP:
				enterOuterAlt(_localctx, 1);
				{
				setState(408);
				((Unary_expressionContext)_localctx).ADDOP = match(ADDOP);
				setState(409);
				((Unary_expressionContext)_localctx).ue = unary_expression();

				        ((Unary_expressionContext)_localctx).expr_string =  ((Unary_expressionContext)_localctx).ADDOP->getText() + ((Unary_expressionContext)_localctx).ue.expr_string;
				        ((Unary_expressionContext)_localctx).line_number =  ((Unary_expressionContext)_localctx).ADDOP->getLine();
				        ((Unary_expressionContext)_localctx).expr_type =  ((Unary_expressionContext)_localctx).ue.expr_type;
				        ((Unary_expressionContext)_localctx).is_integer =  ((Unary_expressionContext)_localctx).ue.is_integer;
				        logLine(_localctx.line_number, "unary_expression : ADDOP unary_expression");
				        writeIntoparserLogFile(_localctx.expr_string);
				    
				}
				break;
			case NOT:
				enterOuterAlt(_localctx, 2);
				{
				setState(412);
				((Unary_expressionContext)_localctx).NOT = match(NOT);
				setState(413);
				((Unary_expressionContext)_localctx).ue = unary_expression();

				        ((Unary_expressionContext)_localctx).expr_string =  ((Unary_expressionContext)_localctx).NOT->getText() + ((Unary_expressionContext)_localctx).ue.expr_string;
				        ((Unary_expressionContext)_localctx).line_number =  ((Unary_expressionContext)_localctx).NOT->getLine();
				        ((Unary_expressionContext)_localctx).expr_type =  "int";
				        ((Unary_expressionContext)_localctx).is_integer =  true;
				        logLine(_localctx.line_number, "unary_expression : NOT unary_expression");
				        writeIntoparserLogFile(_localctx.expr_string);
				    
				}
				break;
			case LPAREN:
			case ID:
			case CONST_INT:
			case CONST_FLOAT:
				enterOuterAlt(_localctx, 3);
				{
				setState(416);
				((Unary_expressionContext)_localctx).f = factor();

				        ((Unary_expressionContext)_localctx).expr_string =  ((Unary_expressionContext)_localctx).f.expr_string;
				        ((Unary_expressionContext)_localctx).line_number =  ((Unary_expressionContext)_localctx).f.line_number;
				        ((Unary_expressionContext)_localctx).expr_type =  ((Unary_expressionContext)_localctx).f.f_type;
				        ((Unary_expressionContext)_localctx).is_integer =  ((Unary_expressionContext)_localctx).f.is_integer;
				        logLine(_localctx.line_number, "unary_expression : factor");
				        writeIntoparserLogFile(_localctx.expr_string);
				    
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
		public std::string expr_string;
		public int line_number;
		public std::string f_type;
		public bool is_integer;
		public VariableContext v;
		public Token ID;
		public Argument_listContext al;
		public Token LPAREN;
		public ExpressionContext e;
		public Token CONST_INT;
		public Token CONST_FLOAT;
		public Token INCOP;
		public Token DECOP;
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode ID() { return getToken(C8086Parser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(C8086Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(C8086Parser.RPAREN, 0); }
		public Argument_listContext argument_list() {
			return getRuleContext(Argument_listContext.class,0);
		}
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
		enterRule(_localctx, 48, RULE_factor);
		try {
			setState(447);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(421);
				((FactorContext)_localctx).v = variable();

				        ((FactorContext)_localctx).expr_string =  ((FactorContext)_localctx).v.var_string;
				        ((FactorContext)_localctx).line_number =  ((FactorContext)_localctx).v.line_number;
				        ((FactorContext)_localctx).f_type =  ((FactorContext)_localctx).v.var_type;
				        ((FactorContext)_localctx).is_integer =  isIntegerType(((FactorContext)_localctx).v.var_type);
				        logLine(_localctx.line_number, "factor : variable");
				        writeIntoparserLogFile(_localctx.expr_string);
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(424);
				((FactorContext)_localctx).ID = match(ID);
				setState(425);
				match(LPAREN);
				setState(426);
				((FactorContext)_localctx).al = argument_list();
				setState(427);
				match(RPAREN);

				        ((FactorContext)_localctx).expr_string =  ((FactorContext)_localctx).ID->getText() + "(" + ((FactorContext)_localctx).al.args_string + ")";
				        ((FactorContext)_localctx).line_number =  ((FactorContext)_localctx).ID->getLine();
				        SymbolInfo* sym = ST->LookUp(((FactorContext)_localctx).ID->getText());
				        if (!sym) {
				            writeIntoErrorFile("Line " + std::to_string(_localctx.line_number) + ": Undeclared function " + ((FactorContext)_localctx).ID->getText());
				            syntaxErrorCount++;
				            ((FactorContext)_localctx).f_type =  "";
				        } else if (sym->isFunctionSymbol() == false) {
				            writeIntoErrorFile("Line " + std::to_string(_localctx.line_number) + ": " + ((FactorContext)_localctx).ID->getText() + " is not a function");
				            syntaxErrorCount++;
				            ((FactorContext)_localctx).f_type =  "";
				        } 
				        else {
				            // Extract return type and parameters
				            std::string funcType = sym->getOriginalType();
				            size_t comma = funcType.find(",");
				            size_t arrow = funcType.find("<==");
				            if (comma != std::string::npos && arrow != std::string::npos) {
				                ((FactorContext)_localctx).f_type =  funcType.substr(comma + 1, arrow - comma - 1);
				                if (_localctx.f_type == "void") {
				                    writeIntoErrorFile("Line " + std::to_string(_localctx.line_number) + ": Void function " + ((FactorContext)_localctx).ID->getText() + " cannot be called as part of an expression");
				                    syntaxErrorCount++;
				                }
				                // // Use SymbolInfo's paramTypes for declared types
				                std::vector<std::string> declaredTypes = sym->getParamTypes();
				                // // Use the arg_types from argument_list instead of extractParamTypes
				                std::vector<std::string> argTypes = ((FactorContext)_localctx).al.arg_types;


				                // writeIntoErrorFile("Line " + std::to_string(_localctx.line_number) + ": Function " + ((FactorContext)_localctx).ID->getText() + " called with parameters: " + ((FactorContext)_localctx).al.args_string);

				                if (declaredTypes.size() != argTypes.size()) {
				                    writeIntoErrorFile("Line " + std::to_string(_localctx.line_number) + ": Parameter count mismatch in call to " + ((FactorContext)_localctx).ID->getText());
				                    syntaxErrorCount++;
				                } else {
				                    for (size_t i = 0; i < declaredTypes.size(); ++i) {

				                        // writeIntoErrorFile("Line " + std::to_string(_localctx.line_number) + ": Argument " + std::to_string(i+1) + " type: " + argTypes[i] + ", expected: " + declaredTypes[i]);

				                        if (!isTypeCompatible(declaredTypes[i], argTypes[i])) {
				                            writeIntoErrorFile("Line " + std::to_string(_localctx.line_number) + ": Type mismatch in argument " + std::to_string(i+1) + " of call to " + ((FactorContext)_localctx).ID->getText()
				                                + " (expected: " + declaredTypes[i] + ", got: " + argTypes[i] + ")");
				                            syntaxErrorCount++;
				                            break;
				                        }
				                    }
				                }
				            } else {
				                ((FactorContext)_localctx).f_type =  "";
				            }
				        }
				        ((FactorContext)_localctx).is_integer =  isIntegerType(_localctx.f_type);
				        logLine(_localctx.line_number, "factor : ID LPAREN argument_list RPAREN");
				        writeIntoparserLogFile(_localctx.expr_string);
				    
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(430);
				((FactorContext)_localctx).LPAREN = match(LPAREN);
				setState(431);
				((FactorContext)_localctx).e = expression();
				setState(432);
				match(RPAREN);

				        ((FactorContext)_localctx).expr_string =  "(" + ((FactorContext)_localctx).e.expr_string + ")";
				        ((FactorContext)_localctx).line_number =  ((FactorContext)_localctx).LPAREN->getLine();
				        ((FactorContext)_localctx).f_type =  ((FactorContext)_localctx).e.expr_type;
				        ((FactorContext)_localctx).is_integer =  ((FactorContext)_localctx).e.is_integer;
				        logLine(_localctx.line_number, "factor : LPAREN expression RPAREN");
				        writeIntoparserLogFile(_localctx.expr_string);
				    
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(435);
				((FactorContext)_localctx).CONST_INT = match(CONST_INT);

				        ((FactorContext)_localctx).expr_string =  ((FactorContext)_localctx).CONST_INT->getText();
				        ((FactorContext)_localctx).line_number =  ((FactorContext)_localctx).CONST_INT->getLine();
				        ((FactorContext)_localctx).f_type =  "int";
				        ((FactorContext)_localctx).is_integer =  true;
				        logLine(_localctx.line_number, "factor : CONST_INT");
				        writeIntoparserLogFile(_localctx.expr_string);
				    
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(437);
				((FactorContext)_localctx).CONST_FLOAT = match(CONST_FLOAT);

				        ((FactorContext)_localctx).expr_string =  ((FactorContext)_localctx).CONST_FLOAT->getText();
				        ((FactorContext)_localctx).line_number =  ((FactorContext)_localctx).CONST_FLOAT->getLine();
				        ((FactorContext)_localctx).f_type =  "float";
				        ((FactorContext)_localctx).is_integer =  false;
				        logLine(_localctx.line_number, "factor : CONST_FLOAT");
				        writeIntoparserLogFile(_localctx.expr_string);
				    
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(439);
				((FactorContext)_localctx).v = variable();
				setState(440);
				((FactorContext)_localctx).INCOP = match(INCOP);

				        ((FactorContext)_localctx).expr_string =  ((FactorContext)_localctx).v.var_string + ((FactorContext)_localctx).INCOP->getText();
				        ((FactorContext)_localctx).line_number =  ((FactorContext)_localctx).v.line_number;
				        ((FactorContext)_localctx).f_type =  ((FactorContext)_localctx).v.var_type;
				        ((FactorContext)_localctx).is_integer =  isIntegerType(((FactorContext)_localctx).v.var_type);
				        logLine(_localctx.line_number, "factor : variable INCOP");
				        writeIntoparserLogFile(_localctx.expr_string);
				    
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(443);
				((FactorContext)_localctx).v = variable();
				setState(444);
				((FactorContext)_localctx).DECOP = match(DECOP);

				        ((FactorContext)_localctx).expr_string =  ((FactorContext)_localctx).v.var_string + ((FactorContext)_localctx).DECOP->getText();
				        ((FactorContext)_localctx).line_number =  ((FactorContext)_localctx).v.line_number;
				        ((FactorContext)_localctx).f_type =  ((FactorContext)_localctx).v.var_type;
				        ((FactorContext)_localctx).is_integer =  isIntegerType(((FactorContext)_localctx).v.var_type);
				        logLine(_localctx.line_number, "factor : variable DECOP");
				        writeIntoparserLogFile(_localctx.expr_string);
				    
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
		public std::string args_string;
		public std::vector<std::string> arg_types;
		public ArgumentsContext a;
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
		enterRule(_localctx, 50, RULE_argument_list);
		try {
			setState(453);
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
				setState(449);
				((Argument_listContext)_localctx).a = arguments(0);

				        ((Argument_listContext)_localctx).args_string =  ((Argument_listContext)_localctx).a.args_string;
				        ((Argument_listContext)_localctx).arg_types =  ((Argument_listContext)_localctx).a.arg_types;
				        logLine(((Argument_listContext)_localctx).a.line_number, "argument_list : arguments");
				        writeIntoparserLogFile(_localctx.args_string);
				    
				}
				break;
			case RPAREN:
				enterOuterAlt(_localctx, 2);
				{

				        ((Argument_listContext)_localctx).args_string =  "";
				        _localctx.arg_types.clear();
				        // logLine(-1, "argument_list :");
				        writeIntoparserLogFile(_localctx.args_string);
				    
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
		public std::string args_string;
		public int line_number;
		public std::vector<std::string> arg_types;
		public ArgumentsContext a;
		public Logic_expressionContext le;
		public Logic_expressionContext logic_expression() {
			return getRuleContext(Logic_expressionContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(C8086Parser.COMMA, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
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
		int _startState = 52;
		enterRecursionRule(_localctx, 52, RULE_arguments, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(456);
			((ArgumentsContext)_localctx).le = logic_expression();

			        ((ArgumentsContext)_localctx).args_string =  ((ArgumentsContext)_localctx).le.expr_string;
			        ((ArgumentsContext)_localctx).line_number =  ((ArgumentsContext)_localctx).le.line_number;
			        _localctx.arg_types.clear();
			        _localctx.arg_types.push_back(((ArgumentsContext)_localctx).le.expr_type);
			        logLine(_localctx.line_number, "arguments : logic expression");
			        writeIntoparserLogFile(_localctx.args_string);
			    
			}
			_ctx.stop = _input.LT(-1);
			setState(466);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ArgumentsContext(_parentctx, _parentState);
					_localctx.a = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_arguments);
					setState(459);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(460);
					match(COMMA);
					setState(461);
					((ArgumentsContext)_localctx).le = logic_expression();

					                  ((ArgumentsContext)_localctx).args_string =  ((ArgumentsContext)_localctx).a.args_string + "," + ((ArgumentsContext)_localctx).le.expr_string;
					                  ((ArgumentsContext)_localctx).line_number =  ((ArgumentsContext)_localctx).a.line_number;
					                  ((ArgumentsContext)_localctx).arg_types =  ((ArgumentsContext)_localctx).a.arg_types;
					                  _localctx.arg_types.push_back(((ArgumentsContext)_localctx).le.expr_type);
					                  logLine(_localctx.line_number, "arguments : arguments COMMA logic expression");
					                  writeIntoparserLogFile(_localctx.args_string);
					              
					}
					} 
				}
				setState(468);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
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
		case 6:
			return parameter_list_sempred((Parameter_listContext)_localctx, predIndex);
		case 11:
			return declaration_list_sempred((Declaration_listContext)_localctx, predIndex);
		case 12:
			return statements_sempred((StatementsContext)_localctx, predIndex);
		case 14:
			return switch_cases_sempred((Switch_casesContext)_localctx, predIndex);
		case 21:
			return simple_expression_sempred((Simple_expressionContext)_localctx, predIndex);
		case 22:
			return term_sempred((TermContext)_localctx, predIndex);
		case 26:
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
	private boolean switch_cases_sempred(Switch_casesContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean simple_expression_sempred(Simple_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean term_sempred(TermContext _localctx, int predIndex) {
		switch (predIndex) {
		case 8:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean arguments_sempred(ArgumentsContext _localctx, int predIndex) {
		switch (predIndex) {
		case 9:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001(\u01d6\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001B\b\u0001\n\u0001\f\u0001"+
		"E\t\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0003\u0002S\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0003\u0004j\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0003\u0005|\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u0086\b\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006"+
		"\u0093\b\u0006\n\u0006\f\u0006\u0096\t\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0003\u0007\u00a2\b\u0007\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u00ae\b\b\u0001"+
		"\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0003\n\u00bb\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u00c5"+
		"\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005"+
		"\u000b\u00d2\b\u000b\n\u000b\f\u000b\u00d5\t\u000b\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f\u00df\b\f\n\f\f\f\u00e2"+
		"\t\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u0131\b\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0005\u000e\u013b\b\u000e\n\u000e\f\u000e\u013e\t\u000e\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u014b"+
		"\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0003\u0010\u0153\b\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u015d"+
		"\b\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u0167\b\u0012\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0003\u0013\u0171\b\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u017b"+
		"\b\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0005\u0015\u0186\b\u0015\n"+
		"\u0015\f\u0015\u0189\t\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0005"+
		"\u0016\u0194\b\u0016\n\u0016\f\u0016\u0197\t\u0016\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0003\u0017\u01a4\b\u0017\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0003\u0018\u01c0\b\u0018\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0003\u0019\u01c6\b\u0019\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0005\u001a\u01d1\b\u001a\n\u001a\f\u001a\u01d4\t\u001a\u0001\u001a\u0000"+
		"\b\u0002\f\u0016\u0018\u001c*,4\u001b\u0000\u0002\u0004\u0006\b\n\f\u000e"+
		"\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.024\u0000\u0000"+
		"\u01eb\u00006\u0001\u0000\u0000\u0000\u00029\u0001\u0000\u0000\u0000\u0004"+
		"R\u0001\u0000\u0000\u0000\u0006T\u0001\u0000\u0000\u0000\bi\u0001\u0000"+
		"\u0000\u0000\n{\u0001\u0000\u0000\u0000\f\u0085\u0001\u0000\u0000\u0000"+
		"\u000e\u00a1\u0001\u0000\u0000\u0000\u0010\u00ad\u0001\u0000\u0000\u0000"+
		"\u0012\u00af\u0001\u0000\u0000\u0000\u0014\u00ba\u0001\u0000\u0000\u0000"+
		"\u0016\u00c4\u0001\u0000\u0000\u0000\u0018\u00d6\u0001\u0000\u0000\u0000"+
		"\u001a\u0130\u0001\u0000\u0000\u0000\u001c\u0132\u0001\u0000\u0000\u0000"+
		"\u001e\u014a\u0001\u0000\u0000\u0000 \u0152\u0001\u0000\u0000\u0000\""+
		"\u015c\u0001\u0000\u0000\u0000$\u0166\u0001\u0000\u0000\u0000&\u0170\u0001"+
		"\u0000\u0000\u0000(\u017a\u0001\u0000\u0000\u0000*\u017c\u0001\u0000\u0000"+
		"\u0000,\u018a\u0001\u0000\u0000\u0000.\u01a3\u0001\u0000\u0000\u00000"+
		"\u01bf\u0001\u0000\u0000\u00002\u01c5\u0001\u0000\u0000\u00004\u01c7\u0001"+
		"\u0000\u0000\u000067\u0003\u0002\u0001\u000078\u0006\u0000\uffff\uffff"+
		"\u00008\u0001\u0001\u0000\u0000\u00009:\u0006\u0001\uffff\uffff\u0000"+
		":;\u0003\u0004\u0002\u0000;<\u0006\u0001\uffff\uffff\u0000<C\u0001\u0000"+
		"\u0000\u0000=>\n\u0002\u0000\u0000>?\u0003\u0004\u0002\u0000?@\u0006\u0001"+
		"\uffff\uffff\u0000@B\u0001\u0000\u0000\u0000A=\u0001\u0000\u0000\u0000"+
		"BE\u0001\u0000\u0000\u0000CA\u0001\u0000\u0000\u0000CD\u0001\u0000\u0000"+
		"\u0000D\u0003\u0001\u0000\u0000\u0000EC\u0001\u0000\u0000\u0000FG\u0003"+
		"\u0010\b\u0000GH\u0006\u0002\uffff\uffff\u0000HS\u0001\u0000\u0000\u0000"+
		"IJ\u0003\b\u0004\u0000JK\u0006\u0002\uffff\uffff\u0000KS\u0001\u0000\u0000"+
		"\u0000LM\u0003\n\u0005\u0000MN\u0006\u0002\uffff\uffff\u0000NS\u0001\u0000"+
		"\u0000\u0000OP\u0003\u0006\u0003\u0000PQ\u0006\u0002\uffff\uffff\u0000"+
		"QS\u0001\u0000\u0000\u0000RF\u0001\u0000\u0000\u0000RI\u0001\u0000\u0000"+
		"\u0000RL\u0001\u0000\u0000\u0000RO\u0001\u0000\u0000\u0000S\u0005\u0001"+
		"\u0000\u0000\u0000TU\u0005\u000f\u0000\u0000UV\u0005&\u0000\u0000VW\u0003"+
		"\u000e\u0007\u0000WX\u0005\u001b\u0000\u0000XY\u0006\u0003\uffff\uffff"+
		"\u0000Y\u0007\u0001\u0000\u0000\u0000Z[\u0003\u0014\n\u0000[\\\u0005&"+
		"\u0000\u0000\\]\u0005\u0015\u0000\u0000]^\u0003\f\u0006\u0000^_\u0005"+
		"\u0016\u0000\u0000_`\u0005\u001b\u0000\u0000`a\u0006\u0004\uffff\uffff"+
		"\u0000aj\u0001\u0000\u0000\u0000bc\u0003\u0014\n\u0000cd\u0005&\u0000"+
		"\u0000de\u0005\u0015\u0000\u0000ef\u0005\u0016\u0000\u0000fg\u0005\u001b"+
		"\u0000\u0000gh\u0006\u0004\uffff\uffff\u0000hj\u0001\u0000\u0000\u0000"+
		"iZ\u0001\u0000\u0000\u0000ib\u0001\u0000\u0000\u0000j\t\u0001\u0000\u0000"+
		"\u0000kl\u0003\u0014\n\u0000lm\u0005&\u0000\u0000mn\u0005\u0015\u0000"+
		"\u0000no\u0003\f\u0006\u0000op\u0005\u0016\u0000\u0000pq\u0006\u0005\uffff"+
		"\uffff\u0000qr\u0003\u000e\u0007\u0000rs\u0006\u0005\uffff\uffff\u0000"+
		"s|\u0001\u0000\u0000\u0000tu\u0003\u0014\n\u0000uv\u0005&\u0000\u0000"+
		"vw\u0005\u0015\u0000\u0000wx\u0005\u0016\u0000\u0000xy\u0003\u000e\u0007"+
		"\u0000yz\u0006\u0005\uffff\uffff\u0000z|\u0001\u0000\u0000\u0000{k\u0001"+
		"\u0000\u0000\u0000{t\u0001\u0000\u0000\u0000|\u000b\u0001\u0000\u0000"+
		"\u0000}~\u0006\u0006\uffff\uffff\u0000~\u007f\u0003\u0014\n\u0000\u007f"+
		"\u0080\u0005&\u0000\u0000\u0080\u0081\u0006\u0006\uffff\uffff\u0000\u0081"+
		"\u0086\u0001\u0000\u0000\u0000\u0082\u0083\u0003\u0014\n\u0000\u0083\u0084"+
		"\u0006\u0006\uffff\uffff\u0000\u0084\u0086\u0001\u0000\u0000\u0000\u0085"+
		"}\u0001\u0000\u0000\u0000\u0085\u0082\u0001\u0000\u0000\u0000\u0086\u0094"+
		"\u0001\u0000\u0000\u0000\u0087\u0088\n\u0004\u0000\u0000\u0088\u0089\u0005"+
		"\u001d\u0000\u0000\u0089\u008a\u0003\u0014\n\u0000\u008a\u008b\u0005&"+
		"\u0000\u0000\u008b\u008c\u0006\u0006\uffff\uffff\u0000\u008c\u0093\u0001"+
		"\u0000\u0000\u0000\u008d\u008e\n\u0003\u0000\u0000\u008e\u008f\u0005\u001d"+
		"\u0000\u0000\u008f\u0090\u0003\u0014\n\u0000\u0090\u0091\u0006\u0006\uffff"+
		"\uffff\u0000\u0091\u0093\u0001\u0000\u0000\u0000\u0092\u0087\u0001\u0000"+
		"\u0000\u0000\u0092\u008d\u0001\u0000\u0000\u0000\u0093\u0096\u0001\u0000"+
		"\u0000\u0000\u0094\u0092\u0001\u0000\u0000\u0000\u0094\u0095\u0001\u0000"+
		"\u0000\u0000\u0095\r\u0001\u0000\u0000\u0000\u0096\u0094\u0001\u0000\u0000"+
		"\u0000\u0097\u0098\u0005\u0017\u0000\u0000\u0098\u0099\u0006\u0007\uffff"+
		"\uffff\u0000\u0099\u009a\u0003\u0018\f\u0000\u009a\u009b\u0005\u0018\u0000"+
		"\u0000\u009b\u009c\u0006\u0007\uffff\uffff\u0000\u009c\u00a2\u0001\u0000"+
		"\u0000\u0000\u009d\u009e\u0005\u0017\u0000\u0000\u009e\u009f\u0006\u0007"+
		"\uffff\uffff\u0000\u009f\u00a0\u0005\u0018\u0000\u0000\u00a0\u00a2\u0006"+
		"\u0007\uffff\uffff\u0000\u00a1\u0097\u0001\u0000\u0000\u0000\u00a1\u009d"+
		"\u0001\u0000\u0000\u0000\u00a2\u000f\u0001\u0000\u0000\u0000\u00a3\u00a4"+
		"\u0003\u0014\n\u0000\u00a4\u00a5\u0003\u0016\u000b\u0000\u00a5\u00a6\u0005"+
		"\u001b\u0000\u0000\u00a6\u00a7\u0006\b\uffff\uffff\u0000\u00a7\u00ae\u0001"+
		"\u0000\u0000\u0000\u00a8\u00a9\u0003\u0014\n\u0000\u00a9\u00aa\u0003\u0012"+
		"\t\u0000\u00aa\u00ab\u0005\u001b\u0000\u0000\u00ab\u00ac\u0006\b\uffff"+
		"\uffff\u0000\u00ac\u00ae\u0001\u0000\u0000\u0000\u00ad\u00a3\u0001\u0000"+
		"\u0000\u0000\u00ad\u00a8\u0001\u0000\u0000\u0000\u00ae\u0011\u0001\u0000"+
		"\u0000\u0000\u00af\u00b0\u0006\t\uffff\uffff\u0000\u00b0\u0013\u0001\u0000"+
		"\u0000\u0000\u00b1\u00b2\u0005\f\u0000\u0000\u00b2\u00bb\u0006\n\uffff"+
		"\uffff\u0000\u00b3\u00b4\u0005\r\u0000\u0000\u00b4\u00bb\u0006\n\uffff"+
		"\uffff\u0000\u00b5\u00b6\u0005\u000e\u0000\u0000\u00b6\u00bb\u0006\n\uffff"+
		"\uffff\u0000\u00b7\u00b8\u0005\u000f\u0000\u0000\u00b8\u00b9\u0005&\u0000"+
		"\u0000\u00b9\u00bb\u0006\n\uffff\uffff\u0000\u00ba\u00b1\u0001\u0000\u0000"+
		"\u0000\u00ba\u00b3\u0001\u0000\u0000\u0000\u00ba\u00b5\u0001\u0000\u0000"+
		"\u0000\u00ba\u00b7\u0001\u0000\u0000\u0000\u00bb\u0015\u0001\u0000\u0000"+
		"\u0000\u00bc\u00bd\u0006\u000b\uffff\uffff\u0000\u00bd\u00be\u0005&\u0000"+
		"\u0000\u00be\u00c5\u0006\u000b\uffff\uffff\u0000\u00bf\u00c0\u0005&\u0000"+
		"\u0000\u00c0\u00c1\u0005\u0019\u0000\u0000\u00c1\u00c2\u0005\'\u0000\u0000"+
		"\u00c2\u00c3\u0005\u001a\u0000\u0000\u00c3\u00c5\u0006\u000b\uffff\uffff"+
		"\u0000\u00c4\u00bc\u0001\u0000\u0000\u0000\u00c4\u00bf\u0001\u0000\u0000"+
		"\u0000\u00c5\u00d3\u0001\u0000\u0000\u0000\u00c6\u00c7\n\u0004\u0000\u0000"+
		"\u00c7\u00c8\u0005\u001d\u0000\u0000\u00c8\u00c9\u0005&\u0000\u0000\u00c9"+
		"\u00d2\u0006\u000b\uffff\uffff\u0000\u00ca\u00cb\n\u0003\u0000\u0000\u00cb"+
		"\u00cc\u0005\u001d\u0000\u0000\u00cc\u00cd\u0005&\u0000\u0000\u00cd\u00ce"+
		"\u0005\u0019\u0000\u0000\u00ce\u00cf\u0005\'\u0000\u0000\u00cf\u00d0\u0005"+
		"\u001a\u0000\u0000\u00d0\u00d2\u0006\u000b\uffff\uffff\u0000\u00d1\u00c6"+
		"\u0001\u0000\u0000\u0000\u00d1\u00ca\u0001\u0000\u0000\u0000\u00d2\u00d5"+
		"\u0001\u0000\u0000\u0000\u00d3\u00d1\u0001\u0000\u0000\u0000\u00d3\u00d4"+
		"\u0001\u0000\u0000\u0000\u00d4\u0017\u0001\u0000\u0000\u0000\u00d5\u00d3"+
		"\u0001\u0000\u0000\u0000\u00d6\u00d7\u0006\f\uffff\uffff\u0000\u00d7\u00d8"+
		"\u0003\u001a\r\u0000\u00d8\u00d9\u0006\f\uffff\uffff\u0000\u00d9\u00e0"+
		"\u0001\u0000\u0000\u0000\u00da\u00db\n\u0001\u0000\u0000\u00db\u00dc\u0003"+
		"\u001a\r\u0000\u00dc\u00dd\u0006\f\uffff\uffff\u0000\u00dd\u00df\u0001"+
		"\u0000\u0000\u0000\u00de\u00da\u0001\u0000\u0000\u0000\u00df\u00e2\u0001"+
		"\u0000\u0000\u0000\u00e0\u00de\u0001\u0000\u0000\u0000\u00e0\u00e1\u0001"+
		"\u0000\u0000\u0000\u00e1\u0019\u0001\u0000\u0000\u0000\u00e2\u00e0\u0001"+
		"\u0000\u0000\u0000\u00e3\u00e4\u0003\u0010\b\u0000\u00e4\u00e5\u0006\r"+
		"\uffff\uffff\u0000\u00e5\u0131\u0001\u0000\u0000\u0000\u00e6\u00e7\u0003"+
		" \u0010\u0000\u00e7\u00e8\u0006\r\uffff\uffff\u0000\u00e8\u0131\u0001"+
		"\u0000\u0000\u0000\u00e9\u00ea\u0003\u000e\u0007\u0000\u00ea\u00eb\u0006"+
		"\r\uffff\uffff\u0000\u00eb\u0131\u0001\u0000\u0000\u0000\u00ec\u00ed\u0005"+
		"\u0007\u0000\u0000\u00ed\u00ee\u0005\u0015\u0000\u0000\u00ee\u00ef\u0003"+
		" \u0010\u0000\u00ef\u00f0\u0003 \u0010\u0000\u00f0\u00f1\u0003$\u0012"+
		"\u0000\u00f1\u00f2\u0005\u0016\u0000\u0000\u00f2\u00f3\u0003\u001a\r\u0000"+
		"\u00f3\u00f4\u0006\r\uffff\uffff\u0000\u00f4\u0131\u0001\u0000\u0000\u0000"+
		"\u00f5\u00f6\u0005\u0005\u0000\u0000\u00f6\u00f7\u0005\u0015\u0000\u0000"+
		"\u00f7\u00f8\u0003$\u0012\u0000\u00f8\u00f9\u0005\u0016\u0000\u0000\u00f9"+
		"\u00fa\u0003\u001a\r\u0000\u00fa\u00fb\u0006\r\uffff\uffff\u0000\u00fb"+
		"\u0131\u0001\u0000\u0000\u0000\u00fc\u00fd\u0005\u0005\u0000\u0000\u00fd"+
		"\u00fe\u0005\u0015\u0000\u0000\u00fe\u00ff\u0003$\u0012\u0000\u00ff\u0100"+
		"\u0005\u0016\u0000\u0000\u0100\u0101\u0003\u001a\r\u0000\u0101\u0102\u0005"+
		"\u0006\u0000\u0000\u0102\u0103\u0003\u001a\r\u0000\u0103\u0104\u0006\r"+
		"\uffff\uffff\u0000\u0104\u0131\u0001\u0000\u0000\u0000\u0105\u0106\u0005"+
		"\b\u0000\u0000\u0106\u0107\u0005\u0015\u0000\u0000\u0107\u0108\u0003$"+
		"\u0012\u0000\u0108\u0109\u0005\u0016\u0000\u0000\u0109\u010a\u0003\u001a"+
		"\r\u0000\u010a\u010b\u0006\r\uffff\uffff\u0000\u010b\u0131\u0001\u0000"+
		"\u0000\u0000\u010c\u010d\u0005\n\u0000\u0000\u010d\u010e\u0005\u0015\u0000"+
		"\u0000\u010e\u010f\u0005&\u0000\u0000\u010f\u0110\u0005\u0016\u0000\u0000"+
		"\u0110\u0111\u0005\u001b\u0000\u0000\u0111\u0131\u0006\r\uffff\uffff\u0000"+
		"\u0112\u0113\u0005\u000b\u0000\u0000\u0113\u0114\u0003$\u0012\u0000\u0114"+
		"\u0115\u0005\u001b\u0000\u0000\u0115\u0116\u0006\r\uffff\uffff\u0000\u0116"+
		"\u0131\u0001\u0000\u0000\u0000\u0117\u0118\u0005\u0010\u0000\u0000\u0118"+
		"\u0119\u0005\u0015\u0000\u0000\u0119\u011a\u0003$\u0012\u0000\u011a\u011b"+
		"\u0005\u0016\u0000\u0000\u011b\u011c\u0005\u0017\u0000\u0000\u011c\u011d"+
		"\u0003\u001c\u000e\u0000\u011d\u011e\u0005\u0018\u0000\u0000\u011e\u011f"+
		"\u0006\r\uffff\uffff\u0000\u011f\u0131\u0001\u0000\u0000\u0000\u0120\u0121"+
		"\u0005\t\u0000\u0000\u0121\u0122\u0006\r\uffff\uffff\u0000\u0122\u0123"+
		"\u0003\u000e\u0007\u0000\u0123\u0124\u0005\b\u0000\u0000\u0124\u0125\u0005"+
		"\u0015\u0000\u0000\u0125\u0126\u0003$\u0012\u0000\u0126\u0127\u0005\u0016"+
		"\u0000\u0000\u0127\u0128\u0005\u001b\u0000\u0000\u0128\u0129\u0006\r\uffff"+
		"\uffff\u0000\u0129\u0131\u0001\u0000\u0000\u0000\u012a\u012b\u0005\u0012"+
		"\u0000\u0000\u012b\u012c\u0005\u001b\u0000\u0000\u012c\u0131\u0006\r\uffff"+
		"\uffff\u0000\u012d\u012e\u0005\u0013\u0000\u0000\u012e\u012f\u0005\u001b"+
		"\u0000\u0000\u012f\u0131\u0006\r\uffff\uffff\u0000\u0130\u00e3\u0001\u0000"+
		"\u0000\u0000\u0130\u00e6\u0001\u0000\u0000\u0000\u0130\u00e9\u0001\u0000"+
		"\u0000\u0000\u0130\u00ec\u0001\u0000\u0000\u0000\u0130\u00f5\u0001\u0000"+
		"\u0000\u0000\u0130\u00fc\u0001\u0000\u0000\u0000\u0130\u0105\u0001\u0000"+
		"\u0000\u0000\u0130\u010c\u0001\u0000\u0000\u0000\u0130\u0112\u0001\u0000"+
		"\u0000\u0000\u0130\u0117\u0001\u0000\u0000\u0000\u0130\u0120\u0001\u0000"+
		"\u0000\u0000\u0130\u012a\u0001\u0000\u0000\u0000\u0130\u012d\u0001\u0000"+
		"\u0000\u0000\u0131\u001b\u0001\u0000\u0000\u0000\u0132\u0133\u0006\u000e"+
		"\uffff\uffff\u0000\u0133\u0134\u0003\u001e\u000f\u0000\u0134\u0135\u0006"+
		"\u000e\uffff\uffff\u0000\u0135\u013c\u0001\u0000\u0000\u0000\u0136\u0137"+
		"\n\u0001\u0000\u0000\u0137\u0138\u0003\u001e\u000f\u0000\u0138\u0139\u0006"+
		"\u000e\uffff\uffff\u0000\u0139\u013b\u0001\u0000\u0000\u0000\u013a\u0136"+
		"\u0001\u0000\u0000\u0000\u013b\u013e\u0001\u0000\u0000\u0000\u013c\u013a"+
		"\u0001\u0000\u0000\u0000\u013c\u013d\u0001\u0000\u0000\u0000\u013d\u001d"+
		"\u0001\u0000\u0000\u0000\u013e\u013c\u0001\u0000\u0000\u0000\u013f\u0140"+
		"\u0005\u0011\u0000\u0000\u0140\u0141\u0003$\u0012\u0000\u0141\u0142\u0005"+
		"\u001c\u0000\u0000\u0142\u0143\u0003\u0018\f\u0000\u0143\u0144\u0006\u000f"+
		"\uffff\uffff\u0000\u0144\u014b\u0001\u0000\u0000\u0000\u0145\u0146\u0005"+
		"\u0014\u0000\u0000\u0146\u0147\u0005\u001c\u0000\u0000\u0147\u0148\u0003"+
		"\u0018\f\u0000\u0148\u0149\u0006\u000f\uffff\uffff\u0000\u0149\u014b\u0001"+
		"\u0000\u0000\u0000\u014a\u013f\u0001\u0000\u0000\u0000\u014a\u0145\u0001"+
		"\u0000\u0000\u0000\u014b\u001f\u0001\u0000\u0000\u0000\u014c\u014d\u0005"+
		"\u001b\u0000\u0000\u014d\u0153\u0006\u0010\uffff\uffff\u0000\u014e\u014f"+
		"\u0003$\u0012\u0000\u014f\u0150\u0005\u001b\u0000\u0000\u0150\u0151\u0006"+
		"\u0010\uffff\uffff\u0000\u0151\u0153\u0001\u0000\u0000\u0000\u0152\u014c"+
		"\u0001\u0000\u0000\u0000\u0152\u014e\u0001\u0000\u0000\u0000\u0153!\u0001"+
		"\u0000\u0000\u0000\u0154\u0155\u0005&\u0000\u0000\u0155\u015d\u0006\u0011"+
		"\uffff\uffff\u0000\u0156\u0157\u0005&\u0000\u0000\u0157\u0158\u0005\u0019"+
		"\u0000\u0000\u0158\u0159\u0003$\u0012\u0000\u0159\u015a\u0005\u001a\u0000"+
		"\u0000\u015a\u015b\u0006\u0011\uffff\uffff\u0000\u015b\u015d\u0001\u0000"+
		"\u0000\u0000\u015c\u0154\u0001\u0000\u0000\u0000\u015c\u0156\u0001\u0000"+
		"\u0000\u0000\u015d#\u0001\u0000\u0000\u0000\u015e\u015f\u0003&\u0013\u0000"+
		"\u015f\u0160\u0006\u0012\uffff\uffff\u0000\u0160\u0167\u0001\u0000\u0000"+
		"\u0000\u0161\u0162\u0003\"\u0011\u0000\u0162\u0163\u0005%\u0000\u0000"+
		"\u0163\u0164\u0003&\u0013\u0000\u0164\u0165\u0006\u0012\uffff\uffff\u0000"+
		"\u0165\u0167\u0001\u0000\u0000\u0000\u0166\u015e\u0001\u0000\u0000\u0000"+
		"\u0166\u0161\u0001\u0000\u0000\u0000\u0167%\u0001\u0000\u0000\u0000\u0168"+
		"\u0169\u0003(\u0014\u0000\u0169\u016a\u0006\u0013\uffff\uffff\u0000\u016a"+
		"\u0171\u0001\u0000\u0000\u0000\u016b\u016c\u0003(\u0014\u0000\u016c\u016d"+
		"\u0005$\u0000\u0000\u016d\u016e\u0003(\u0014\u0000\u016e\u016f\u0006\u0013"+
		"\uffff\uffff\u0000\u016f\u0171\u0001\u0000\u0000\u0000\u0170\u0168\u0001"+
		"\u0000\u0000\u0000\u0170\u016b\u0001\u0000\u0000\u0000\u0171\'\u0001\u0000"+
		"\u0000\u0000\u0172\u0173\u0003*\u0015\u0000\u0173\u0174\u0006\u0014\uffff"+
		"\uffff\u0000\u0174\u017b\u0001\u0000\u0000\u0000\u0175\u0176\u0003*\u0015"+
		"\u0000\u0176\u0177\u0005#\u0000\u0000\u0177\u0178\u0003*\u0015\u0000\u0178"+
		"\u0179\u0006\u0014\uffff\uffff\u0000\u0179\u017b\u0001\u0000\u0000\u0000"+
		"\u017a\u0172\u0001\u0000\u0000\u0000\u017a\u0175\u0001\u0000\u0000\u0000"+
		"\u017b)\u0001\u0000\u0000\u0000\u017c\u017d\u0006\u0015\uffff\uffff\u0000"+
		"\u017d\u017e\u0003,\u0016\u0000\u017e\u017f\u0006\u0015\uffff\uffff\u0000"+
		"\u017f\u0187\u0001\u0000\u0000\u0000\u0180\u0181\n\u0001\u0000\u0000\u0181"+
		"\u0182\u0005\u001e\u0000\u0000\u0182\u0183\u0003,\u0016\u0000\u0183\u0184"+
		"\u0006\u0015\uffff\uffff\u0000\u0184\u0186\u0001\u0000\u0000\u0000\u0185"+
		"\u0180\u0001\u0000\u0000\u0000\u0186\u0189\u0001\u0000\u0000\u0000\u0187"+
		"\u0185\u0001\u0000\u0000\u0000\u0187\u0188\u0001\u0000\u0000\u0000\u0188"+
		"+\u0001\u0000\u0000\u0000\u0189\u0187\u0001\u0000\u0000\u0000\u018a\u018b"+
		"\u0006\u0016\uffff\uffff\u0000\u018b\u018c\u0003.\u0017\u0000\u018c\u018d"+
		"\u0006\u0016\uffff\uffff\u0000\u018d\u0195\u0001\u0000\u0000\u0000\u018e"+
		"\u018f\n\u0001\u0000\u0000\u018f\u0190\u0005\u001f\u0000\u0000\u0190\u0191"+
		"\u0003.\u0017\u0000\u0191\u0192\u0006\u0016\uffff\uffff\u0000\u0192\u0194"+
		"\u0001\u0000\u0000\u0000\u0193\u018e\u0001\u0000\u0000\u0000\u0194\u0197"+
		"\u0001\u0000\u0000\u0000\u0195\u0193\u0001\u0000\u0000\u0000\u0195\u0196"+
		"\u0001\u0000\u0000\u0000\u0196-\u0001\u0000\u0000\u0000\u0197\u0195\u0001"+
		"\u0000\u0000\u0000\u0198\u0199\u0005\u001e\u0000\u0000\u0199\u019a\u0003"+
		".\u0017\u0000\u019a\u019b\u0006\u0017\uffff\uffff\u0000\u019b\u01a4\u0001"+
		"\u0000\u0000\u0000\u019c\u019d\u0005\"\u0000\u0000\u019d\u019e\u0003."+
		"\u0017\u0000\u019e\u019f\u0006\u0017\uffff\uffff\u0000\u019f\u01a4\u0001"+
		"\u0000\u0000\u0000\u01a0\u01a1\u00030\u0018\u0000\u01a1\u01a2\u0006\u0017"+
		"\uffff\uffff\u0000\u01a2\u01a4\u0001\u0000\u0000\u0000\u01a3\u0198\u0001"+
		"\u0000\u0000\u0000\u01a3\u019c\u0001\u0000\u0000\u0000\u01a3\u01a0\u0001"+
		"\u0000\u0000\u0000\u01a4/\u0001\u0000\u0000\u0000\u01a5\u01a6\u0003\""+
		"\u0011\u0000\u01a6\u01a7\u0006\u0018\uffff\uffff\u0000\u01a7\u01c0\u0001"+
		"\u0000\u0000\u0000\u01a8\u01a9\u0005&\u0000\u0000\u01a9\u01aa\u0005\u0015"+
		"\u0000\u0000\u01aa\u01ab\u00032\u0019\u0000\u01ab\u01ac\u0005\u0016\u0000"+
		"\u0000\u01ac\u01ad\u0006\u0018\uffff\uffff\u0000\u01ad\u01c0\u0001\u0000"+
		"\u0000\u0000\u01ae\u01af\u0005\u0015\u0000\u0000\u01af\u01b0\u0003$\u0012"+
		"\u0000\u01b0\u01b1\u0005\u0016\u0000\u0000\u01b1\u01b2\u0006\u0018\uffff"+
		"\uffff\u0000\u01b2\u01c0\u0001\u0000\u0000\u0000\u01b3\u01b4\u0005\'\u0000"+
		"\u0000\u01b4\u01c0\u0006\u0018\uffff\uffff\u0000\u01b5\u01b6\u0005(\u0000"+
		"\u0000\u01b6\u01c0\u0006\u0018\uffff\uffff\u0000\u01b7\u01b8\u0003\"\u0011"+
		"\u0000\u01b8\u01b9\u0005 \u0000\u0000\u01b9\u01ba\u0006\u0018\uffff\uffff"+
		"\u0000\u01ba\u01c0\u0001\u0000\u0000\u0000\u01bb\u01bc\u0003\"\u0011\u0000"+
		"\u01bc\u01bd\u0005!\u0000\u0000\u01bd\u01be\u0006\u0018\uffff\uffff\u0000"+
		"\u01be\u01c0\u0001\u0000\u0000\u0000\u01bf\u01a5\u0001\u0000\u0000\u0000"+
		"\u01bf\u01a8\u0001\u0000\u0000\u0000\u01bf\u01ae\u0001\u0000\u0000\u0000"+
		"\u01bf\u01b3\u0001\u0000\u0000\u0000\u01bf\u01b5\u0001\u0000\u0000\u0000"+
		"\u01bf\u01b7\u0001\u0000\u0000\u0000\u01bf\u01bb\u0001\u0000\u0000\u0000"+
		"\u01c01\u0001\u0000\u0000\u0000\u01c1\u01c2\u00034\u001a\u0000\u01c2\u01c3"+
		"\u0006\u0019\uffff\uffff\u0000\u01c3\u01c6\u0001\u0000\u0000\u0000\u01c4"+
		"\u01c6\u0006\u0019\uffff\uffff\u0000\u01c5\u01c1\u0001\u0000\u0000\u0000"+
		"\u01c5\u01c4\u0001\u0000\u0000\u0000\u01c63\u0001\u0000\u0000\u0000\u01c7"+
		"\u01c8\u0006\u001a\uffff\uffff\u0000\u01c8\u01c9\u0003&\u0013\u0000\u01c9"+
		"\u01ca\u0006\u001a\uffff\uffff\u0000\u01ca\u01d2\u0001\u0000\u0000\u0000"+
		"\u01cb\u01cc\n\u0002\u0000\u0000\u01cc\u01cd\u0005\u001d\u0000\u0000\u01cd"+
		"\u01ce\u0003&\u0013\u0000\u01ce\u01cf\u0006\u001a\uffff\uffff\u0000\u01cf"+
		"\u01d1\u0001\u0000\u0000\u0000\u01d0\u01cb\u0001\u0000\u0000\u0000\u01d1"+
		"\u01d4\u0001\u0000\u0000\u0000\u01d2\u01d0\u0001\u0000\u0000\u0000\u01d2"+
		"\u01d3\u0001\u0000\u0000\u0000\u01d35\u0001\u0000\u0000\u0000\u01d4\u01d2"+
		"\u0001\u0000\u0000\u0000\u001cCRi{\u0085\u0092\u0094\u00a1\u00ad\u00ba"+
		"\u00c4\u00d1\u00d3\u00e0\u0130\u013c\u014a\u0152\u015c\u0166\u0170\u017a"+
		"\u0187\u0195\u01a3\u01bf\u01c5\u01d2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}