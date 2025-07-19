
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


// Generated from C8086Parser.g4 by ANTLR 4.13.2

#pragma once


#include "antlr4-runtime.h"




class  C8086Parser : public antlr4::Parser {
public:
  enum {
    LINE_COMMENT = 1, BLOCK_COMMENT = 2, STRING = 3, WS = 4, IF = 5, ELSE = 6, 
    FOR = 7, WHILE = 8, DO = 9, PRINTLN = 10, RETURN = 11, INT = 12, FLOAT = 13, 
    VOID = 14, STRUCT = 15, SWITCH = 16, CASE = 17, BREAK = 18, CONTINUE = 19, 
    DEFAULT = 20, LPAREN = 21, RPAREN = 22, LCURL = 23, RCURL = 24, LTHIRD = 25, 
    RTHIRD = 26, SEMICOLON = 27, COLON = 28, COMMA = 29, ADDOP = 30, MULOP = 31, 
    INCOP = 32, DECOP = 33, NOT = 34, RELOP = 35, LOGICOP = 36, ASSIGNOP = 37, 
    ID = 38, CONST_INT = 39, CONST_FLOAT = 40
  };

  enum {
    RuleStart = 0, RuleProgram = 1, RuleUnit = 2, RuleStruct_declaration = 3, 
    RuleFunc_declaration = 4, RuleFunc_definition = 5, RuleParameter_list = 6, 
    RuleCompound_statement = 7, RuleVar_declaration = 8, RuleDeclaration_list_err = 9, 
    RuleType_specifier = 10, RuleDeclaration_list = 11, RuleStatements = 12, 
    RuleStatement = 13, RuleSwitch_cases = 14, RuleCase_statement = 15, 
    RuleExpression_statement = 16, RuleVariable = 17, RuleExpression = 18, 
    RuleLogic_expression = 19, RuleRel_expression = 20, RuleSimple_expression = 21, 
    RuleTerm = 22, RuleUnary_expression = 23, RuleFactor = 24, RuleArgument_list = 25, 
    RuleArguments = 26
  };

  explicit C8086Parser(antlr4::TokenStream *input);

  C8086Parser(antlr4::TokenStream *input, const antlr4::atn::ParserATNSimulatorOptions &options);

  ~C8086Parser() override;

  std::string getGrammarFileName() const override;

  const antlr4::atn::ATN& getATN() const override;

  const std::vector<std::string>& getRuleNames() const override;

  const antlr4::dfa::Vocabulary& getVocabulary() const override;

  antlr4::atn::SerializedATNView getSerializedATN() const override;



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


  class StartContext;
  class ProgramContext;
  class UnitContext;
  class Struct_declarationContext;
  class Func_declarationContext;
  class Func_definitionContext;
  class Parameter_listContext;
  class Compound_statementContext;
  class Var_declarationContext;
  class Declaration_list_errContext;
  class Type_specifierContext;
  class Declaration_listContext;
  class StatementsContext;
  class StatementContext;
  class Switch_casesContext;
  class Case_statementContext;
  class Expression_statementContext;
  class VariableContext;
  class ExpressionContext;
  class Logic_expressionContext;
  class Rel_expressionContext;
  class Simple_expressionContext;
  class TermContext;
  class Unary_expressionContext;
  class FactorContext;
  class Argument_listContext;
  class ArgumentsContext; 

  class  StartContext : public antlr4::ParserRuleContext {
  public:
    StartContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    ProgramContext *program();

    virtual void enterRule(antlr4::tree::ParseTreeListener *listener) override;
    virtual void exitRule(antlr4::tree::ParseTreeListener *listener) override;
   
  };

  StartContext* start();

  class  ProgramContext : public antlr4::ParserRuleContext {
  public:
    ParseInfo info;
    C8086Parser::ProgramContext *p = nullptr;
    C8086Parser::UnitContext *u = nullptr;
    ProgramContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    UnitContext *unit();
    ProgramContext *program();

    virtual void enterRule(antlr4::tree::ParseTreeListener *listener) override;
    virtual void exitRule(antlr4::tree::ParseTreeListener *listener) override;
   
  };

  ProgramContext* program();
  ProgramContext* program(int precedence);
  class  UnitContext : public antlr4::ParserRuleContext {
  public:
    ParseInfo info;
    C8086Parser::Var_declarationContext *var_declarationContext = nullptr;
    C8086Parser::Func_declarationContext *func_declarationContext = nullptr;
    C8086Parser::Func_definitionContext *func_definitionContext = nullptr;
    C8086Parser::Struct_declarationContext *struct_declarationContext = nullptr;
    UnitContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    Var_declarationContext *var_declaration();
    Func_declarationContext *func_declaration();
    Func_definitionContext *func_definition();
    Struct_declarationContext *struct_declaration();

    virtual void enterRule(antlr4::tree::ParseTreeListener *listener) override;
    virtual void exitRule(antlr4::tree::ParseTreeListener *listener) override;
   
  };

  UnitContext* unit();

  class  Struct_declarationContext : public antlr4::ParserRuleContext {
  public:
    ParseInfo info;
    antlr4::Token *idToken = nullptr;
    C8086Parser::Compound_statementContext *cs = nullptr;
    Struct_declarationContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    antlr4::tree::TerminalNode *STRUCT();
    antlr4::tree::TerminalNode *ID();
    antlr4::tree::TerminalNode *SEMICOLON();
    Compound_statementContext *compound_statement();

    virtual void enterRule(antlr4::tree::ParseTreeListener *listener) override;
    virtual void exitRule(antlr4::tree::ParseTreeListener *listener) override;
   
  };

  Struct_declarationContext* struct_declaration();

  class  Func_declarationContext : public antlr4::ParserRuleContext {
  public:
    ParseInfo info;
    C8086Parser::Type_specifierContext *ts = nullptr;
    antlr4::Token *idToken = nullptr;
    C8086Parser::Parameter_listContext *pl = nullptr;
    antlr4::Token *sm = nullptr;
    Func_declarationContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    antlr4::tree::TerminalNode *ID();
    antlr4::tree::TerminalNode *LPAREN();
    antlr4::tree::TerminalNode *RPAREN();
    Type_specifierContext *type_specifier();
    Parameter_listContext *parameter_list();
    antlr4::tree::TerminalNode *SEMICOLON();

    virtual void enterRule(antlr4::tree::ParseTreeListener *listener) override;
    virtual void exitRule(antlr4::tree::ParseTreeListener *listener) override;
   
  };

  Func_declarationContext* func_declaration();

  class  Func_definitionContext : public antlr4::ParserRuleContext {
  public:
    ParseInfo info;
    C8086Parser::Type_specifierContext *ts = nullptr;
    antlr4::Token *idToken = nullptr;
    C8086Parser::Parameter_listContext *pl = nullptr;
    C8086Parser::Compound_statementContext *cs = nullptr;
    Func_definitionContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    antlr4::tree::TerminalNode *ID();
    antlr4::tree::TerminalNode *LPAREN();
    antlr4::tree::TerminalNode *RPAREN();
    Type_specifierContext *type_specifier();
    Parameter_listContext *parameter_list();
    Compound_statementContext *compound_statement();

    virtual void enterRule(antlr4::tree::ParseTreeListener *listener) override;
    virtual void exitRule(antlr4::tree::ParseTreeListener *listener) override;
   
  };

  Func_definitionContext* func_definition();

  class  Parameter_listContext : public antlr4::ParserRuleContext {
  public:
    std::string param_string;
    C8086Parser::Parameter_listContext *pl = nullptr;
    C8086Parser::Type_specifierContext *ts = nullptr;
    antlr4::Token *idToken = nullptr;
    Parameter_listContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    antlr4::tree::TerminalNode *ID();
    Type_specifierContext *type_specifier();
    antlr4::tree::TerminalNode *COMMA();
    Parameter_listContext *parameter_list();

    virtual void enterRule(antlr4::tree::ParseTreeListener *listener) override;
    virtual void exitRule(antlr4::tree::ParseTreeListener *listener) override;
   
  };

  Parameter_listContext* parameter_list();
  Parameter_listContext* parameter_list(int precedence);
  class  Compound_statementContext : public antlr4::ParserRuleContext {
  public:
    std::string code_string;
    int line_number;
    antlr4::Token *lcurlToken = nullptr;
    C8086Parser::StatementsContext *st = nullptr;
    antlr4::Token *rcurlToken = nullptr;
    Compound_statementContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    antlr4::tree::TerminalNode *LCURL();
    antlr4::tree::TerminalNode *RCURL();
    StatementsContext *statements();

    virtual void enterRule(antlr4::tree::ParseTreeListener *listener) override;
    virtual void exitRule(antlr4::tree::ParseTreeListener *listener) override;
   
  };

  Compound_statementContext* compound_statement();

  class  Var_declarationContext : public antlr4::ParserRuleContext {
  public:
    ParseInfo info;
    C8086Parser::Type_specifierContext *t = nullptr;
    C8086Parser::Declaration_listContext *dl = nullptr;
    antlr4::Token *sm = nullptr;
    C8086Parser::Declaration_list_errContext *de = nullptr;
    Var_declarationContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    Type_specifierContext *type_specifier();
    Declaration_listContext *declaration_list();
    antlr4::tree::TerminalNode *SEMICOLON();
    Declaration_list_errContext *declaration_list_err();

    virtual void enterRule(antlr4::tree::ParseTreeListener *listener) override;
    virtual void exitRule(antlr4::tree::ParseTreeListener *listener) override;
   
  };

  Var_declarationContext* var_declaration();

  class  Declaration_list_errContext : public antlr4::ParserRuleContext {
  public:
    std::string error_name;
    Declaration_list_errContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;

    virtual void enterRule(antlr4::tree::ParseTreeListener *listener) override;
    virtual void exitRule(antlr4::tree::ParseTreeListener *listener) override;
   
  };

  Declaration_list_errContext* declaration_list_err();

  class  Type_specifierContext : public antlr4::ParserRuleContext {
  public:
    std::string name_line;
    int line_number;
    antlr4::Token *intToken = nullptr;
    antlr4::Token *floatToken = nullptr;
    antlr4::Token *voidToken = nullptr;
    antlr4::Token *structToken = nullptr;
    antlr4::Token *idToken = nullptr;
    Type_specifierContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    antlr4::tree::TerminalNode *INT();
    antlr4::tree::TerminalNode *FLOAT();
    antlr4::tree::TerminalNode *VOID();
    antlr4::tree::TerminalNode *STRUCT();
    antlr4::tree::TerminalNode *ID();

    virtual void enterRule(antlr4::tree::ParseTreeListener *listener) override;
    virtual void exitRule(antlr4::tree::ParseTreeListener *listener) override;
   
  };

  Type_specifierContext* type_specifier();

  class  Declaration_listContext : public antlr4::ParserRuleContext {
  public:
    str_list var_list;
    C8086Parser::Declaration_listContext *dl = nullptr;
    antlr4::Token *idToken = nullptr;
    antlr4::Token *const_intToken = nullptr;
    Declaration_listContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    antlr4::tree::TerminalNode *ID();
    antlr4::tree::TerminalNode *LTHIRD();
    antlr4::tree::TerminalNode *CONST_INT();
    antlr4::tree::TerminalNode *RTHIRD();
    antlr4::tree::TerminalNode *COMMA();
    Declaration_listContext *declaration_list();

    virtual void enterRule(antlr4::tree::ParseTreeListener *listener) override;
    virtual void exitRule(antlr4::tree::ParseTreeListener *listener) override;
   
  };

  Declaration_listContext* declaration_list();
  Declaration_listContext* declaration_list(int precedence);
  class  StatementsContext : public antlr4::ParserRuleContext {
  public:
    std::string statements_string;
    C8086Parser::StatementsContext *sts = nullptr;
    C8086Parser::StatementContext *st = nullptr;
    StatementsContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    StatementContext *statement();
    StatementsContext *statements();

    virtual void enterRule(antlr4::tree::ParseTreeListener *listener) override;
    virtual void exitRule(antlr4::tree::ParseTreeListener *listener) override;
   
  };

  StatementsContext* statements();
  StatementsContext* statements(int precedence);
  class  StatementContext : public antlr4::ParserRuleContext {
  public:
    std::string statement_string;
    int line_number;
    C8086Parser::Var_declarationContext *vd = nullptr;
    C8086Parser::Expression_statementContext *es = nullptr;
    C8086Parser::Compound_statementContext *cs = nullptr;
    antlr4::Token *forToken = nullptr;
    C8086Parser::Expression_statementContext *es1 = nullptr;
    C8086Parser::Expression_statementContext *es2 = nullptr;
    C8086Parser::ExpressionContext *e = nullptr;
    C8086Parser::StatementContext *st = nullptr;
    antlr4::Token *ifToken = nullptr;
    C8086Parser::StatementContext *st1 = nullptr;
    C8086Parser::StatementContext *st2 = nullptr;
    antlr4::Token *whileToken = nullptr;
    antlr4::Token *printlnToken = nullptr;
    antlr4::Token *idToken = nullptr;
    antlr4::Token *returnToken = nullptr;
    antlr4::Token *switchToken = nullptr;
    C8086Parser::ExpressionContext *expressionContext = nullptr;
    C8086Parser::Switch_casesContext *sc = nullptr;
    antlr4::Token *doToken = nullptr;
    antlr4::Token *breakToken = nullptr;
    antlr4::Token *continueToken = nullptr;
    StatementContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    Var_declarationContext *var_declaration();
    std::vector<Expression_statementContext *> expression_statement();
    Expression_statementContext* expression_statement(size_t i);
    Compound_statementContext *compound_statement();
    antlr4::tree::TerminalNode *FOR();
    antlr4::tree::TerminalNode *LPAREN();
    antlr4::tree::TerminalNode *RPAREN();
    ExpressionContext *expression();
    std::vector<StatementContext *> statement();
    StatementContext* statement(size_t i);
    antlr4::tree::TerminalNode *IF();
    antlr4::tree::TerminalNode *ELSE();
    antlr4::tree::TerminalNode *WHILE();
    antlr4::tree::TerminalNode *PRINTLN();
    antlr4::tree::TerminalNode *ID();
    antlr4::tree::TerminalNode *SEMICOLON();
    antlr4::tree::TerminalNode *RETURN();
    antlr4::tree::TerminalNode *SWITCH();
    antlr4::tree::TerminalNode *LCURL();
    antlr4::tree::TerminalNode *RCURL();
    Switch_casesContext *switch_cases();
    antlr4::tree::TerminalNode *DO();
    antlr4::tree::TerminalNode *BREAK();
    antlr4::tree::TerminalNode *CONTINUE();

    virtual void enterRule(antlr4::tree::ParseTreeListener *listener) override;
    virtual void exitRule(antlr4::tree::ParseTreeListener *listener) override;
   
  };

  StatementContext* statement();

  class  Switch_casesContext : public antlr4::ParserRuleContext {
  public:
    ParseInfo info;
    C8086Parser::Switch_casesContext *sc = nullptr;
    C8086Parser::Case_statementContext *case_statementContext = nullptr;
    C8086Parser::Case_statementContext *cs = nullptr;
    Switch_casesContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    Case_statementContext *case_statement();
    Switch_casesContext *switch_cases();

    virtual void enterRule(antlr4::tree::ParseTreeListener *listener) override;
    virtual void exitRule(antlr4::tree::ParseTreeListener *listener) override;
   
  };

  Switch_casesContext* switch_cases();
  Switch_casesContext* switch_cases(int precedence);
  class  Case_statementContext : public antlr4::ParserRuleContext {
  public:
    ParseInfo info;
    antlr4::Token *caseToken = nullptr;
    C8086Parser::ExpressionContext *e = nullptr;
    C8086Parser::StatementsContext *st = nullptr;
    antlr4::Token *defaultToken = nullptr;
    Case_statementContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    antlr4::tree::TerminalNode *CASE();
    antlr4::tree::TerminalNode *COLON();
    ExpressionContext *expression();
    StatementsContext *statements();
    antlr4::tree::TerminalNode *DEFAULT();

    virtual void enterRule(antlr4::tree::ParseTreeListener *listener) override;
    virtual void exitRule(antlr4::tree::ParseTreeListener *listener) override;
   
  };

  Case_statementContext* case_statement();

  class  Expression_statementContext : public antlr4::ParserRuleContext {
  public:
    std::string expr_string;
    int line_number;
    antlr4::Token *semicolonToken = nullptr;
    C8086Parser::ExpressionContext *e = nullptr;
    Expression_statementContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    antlr4::tree::TerminalNode *SEMICOLON();
    ExpressionContext *expression();

    virtual void enterRule(antlr4::tree::ParseTreeListener *listener) override;
    virtual void exitRule(antlr4::tree::ParseTreeListener *listener) override;
   
  };

  Expression_statementContext* expression_statement();

  class  VariableContext : public antlr4::ParserRuleContext {
  public:
    std::string var_string;
    int line_number;
    std::string var_type;
    antlr4::Token *idToken = nullptr;
    C8086Parser::ExpressionContext *e = nullptr;
    VariableContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    antlr4::tree::TerminalNode *ID();
    antlr4::tree::TerminalNode *LTHIRD();
    antlr4::tree::TerminalNode *RTHIRD();
    ExpressionContext *expression();

    virtual void enterRule(antlr4::tree::ParseTreeListener *listener) override;
    virtual void exitRule(antlr4::tree::ParseTreeListener *listener) override;
   
  };

  VariableContext* variable();

  class  ExpressionContext : public antlr4::ParserRuleContext {
  public:
    std::string expr_string;
    int line_number;
    std::string expr_type;
    bool is_integer;
    C8086Parser::Logic_expressionContext *le = nullptr;
    C8086Parser::VariableContext *v = nullptr;
    ExpressionContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    Logic_expressionContext *logic_expression();
    antlr4::tree::TerminalNode *ASSIGNOP();
    VariableContext *variable();

    virtual void enterRule(antlr4::tree::ParseTreeListener *listener) override;
    virtual void exitRule(antlr4::tree::ParseTreeListener *listener) override;
   
  };

  ExpressionContext* expression();

  class  Logic_expressionContext : public antlr4::ParserRuleContext {
  public:
    std::string expr_string;
    int line_number;
    std::string expr_type;
    bool is_integer;
    C8086Parser::Rel_expressionContext *re = nullptr;
    C8086Parser::Rel_expressionContext *re1 = nullptr;
    antlr4::Token *logicopToken = nullptr;
    C8086Parser::Rel_expressionContext *re2 = nullptr;
    Logic_expressionContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    std::vector<Rel_expressionContext *> rel_expression();
    Rel_expressionContext* rel_expression(size_t i);
    antlr4::tree::TerminalNode *LOGICOP();

    virtual void enterRule(antlr4::tree::ParseTreeListener *listener) override;
    virtual void exitRule(antlr4::tree::ParseTreeListener *listener) override;
   
  };

  Logic_expressionContext* logic_expression();

  class  Rel_expressionContext : public antlr4::ParserRuleContext {
  public:
    std::string expr_string;
    int line_number;
    std::string expr_type;
    bool is_integer;
    C8086Parser::Simple_expressionContext *se = nullptr;
    C8086Parser::Simple_expressionContext *se1 = nullptr;
    antlr4::Token *relopToken = nullptr;
    C8086Parser::Simple_expressionContext *se2 = nullptr;
    Rel_expressionContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    std::vector<Simple_expressionContext *> simple_expression();
    Simple_expressionContext* simple_expression(size_t i);
    antlr4::tree::TerminalNode *RELOP();

    virtual void enterRule(antlr4::tree::ParseTreeListener *listener) override;
    virtual void exitRule(antlr4::tree::ParseTreeListener *listener) override;
   
  };

  Rel_expressionContext* rel_expression();

  class  Simple_expressionContext : public antlr4::ParserRuleContext {
  public:
    std::string expr_string;
    int line_number;
    std::string expr_type;
    bool is_integral;
    C8086Parser::Simple_expressionContext *se = nullptr;
    C8086Parser::TermContext *t = nullptr;
    antlr4::Token *addopToken = nullptr;
    Simple_expressionContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    TermContext *term();
    antlr4::tree::TerminalNode *ADDOP();
    Simple_expressionContext *simple_expression();

    virtual void enterRule(antlr4::tree::ParseTreeListener *listener) override;
    virtual void exitRule(antlr4::tree::ParseTreeListener *listener) override;
   
  };

  Simple_expressionContext* simple_expression();
  Simple_expressionContext* simple_expression(int precedence);
  class  TermContext : public antlr4::ParserRuleContext {
  public:
    std::string expr_string;
    int line_number;
    std::string t_type;
    bool is_integer;
    C8086Parser::TermContext *t = nullptr;
    C8086Parser::Unary_expressionContext *ue = nullptr;
    antlr4::Token *mulopToken = nullptr;
    TermContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    Unary_expressionContext *unary_expression();
    antlr4::tree::TerminalNode *MULOP();
    TermContext *term();

    virtual void enterRule(antlr4::tree::ParseTreeListener *listener) override;
    virtual void exitRule(antlr4::tree::ParseTreeListener *listener) override;
   
  };

  TermContext* term();
  TermContext* term(int precedence);
  class  Unary_expressionContext : public antlr4::ParserRuleContext {
  public:
    std::string expr_string;
    int line_number;
    std::string expr_type;
    bool is_integer;
    antlr4::Token *addopToken = nullptr;
    C8086Parser::Unary_expressionContext *ue = nullptr;
    antlr4::Token *notToken = nullptr;
    C8086Parser::FactorContext *f = nullptr;
    Unary_expressionContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    antlr4::tree::TerminalNode *ADDOP();
    Unary_expressionContext *unary_expression();
    antlr4::tree::TerminalNode *NOT();
    FactorContext *factor();

    virtual void enterRule(antlr4::tree::ParseTreeListener *listener) override;
    virtual void exitRule(antlr4::tree::ParseTreeListener *listener) override;
   
  };

  Unary_expressionContext* unary_expression();

  class  FactorContext : public antlr4::ParserRuleContext {
  public:
    std::string expr_string;
    int line_number;
    std::string f_type;
    bool is_integer;
    C8086Parser::VariableContext *v = nullptr;
    antlr4::Token *idToken = nullptr;
    C8086Parser::Argument_listContext *al = nullptr;
    antlr4::Token *lparenToken = nullptr;
    C8086Parser::ExpressionContext *e = nullptr;
    antlr4::Token *const_intToken = nullptr;
    antlr4::Token *const_floatToken = nullptr;
    antlr4::Token *incopToken = nullptr;
    antlr4::Token *decopToken = nullptr;
    FactorContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    VariableContext *variable();
    antlr4::tree::TerminalNode *ID();
    antlr4::tree::TerminalNode *LPAREN();
    antlr4::tree::TerminalNode *RPAREN();
    Argument_listContext *argument_list();
    ExpressionContext *expression();
    antlr4::tree::TerminalNode *CONST_INT();
    antlr4::tree::TerminalNode *CONST_FLOAT();
    antlr4::tree::TerminalNode *INCOP();
    antlr4::tree::TerminalNode *DECOP();

    virtual void enterRule(antlr4::tree::ParseTreeListener *listener) override;
    virtual void exitRule(antlr4::tree::ParseTreeListener *listener) override;
   
  };

  FactorContext* factor();

  class  Argument_listContext : public antlr4::ParserRuleContext {
  public:
    std::string args_string;
    std::vector<std::string> arg_types;
    C8086Parser::ArgumentsContext *a = nullptr;
    Argument_listContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    ArgumentsContext *arguments();

    virtual void enterRule(antlr4::tree::ParseTreeListener *listener) override;
    virtual void exitRule(antlr4::tree::ParseTreeListener *listener) override;
   
  };

  Argument_listContext* argument_list();

  class  ArgumentsContext : public antlr4::ParserRuleContext {
  public:
    std::string args_string;
    int line_number;
    std::vector<std::string> arg_types;
    C8086Parser::ArgumentsContext *a = nullptr;
    C8086Parser::Logic_expressionContext *le = nullptr;
    ArgumentsContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    Logic_expressionContext *logic_expression();
    antlr4::tree::TerminalNode *COMMA();
    ArgumentsContext *arguments();

    virtual void enterRule(antlr4::tree::ParseTreeListener *listener) override;
    virtual void exitRule(antlr4::tree::ParseTreeListener *listener) override;
   
  };

  ArgumentsContext* arguments();
  ArgumentsContext* arguments(int precedence);

  bool sempred(antlr4::RuleContext *_localctx, size_t ruleIndex, size_t predicateIndex) override;

  bool programSempred(ProgramContext *_localctx, size_t predicateIndex);
  bool parameter_listSempred(Parameter_listContext *_localctx, size_t predicateIndex);
  bool declaration_listSempred(Declaration_listContext *_localctx, size_t predicateIndex);
  bool statementsSempred(StatementsContext *_localctx, size_t predicateIndex);
  bool switch_casesSempred(Switch_casesContext *_localctx, size_t predicateIndex);
  bool simple_expressionSempred(Simple_expressionContext *_localctx, size_t predicateIndex);
  bool termSempred(TermContext *_localctx, size_t predicateIndex);
  bool argumentsSempred(ArgumentsContext *_localctx, size_t predicateIndex);

  // By default the static state used to implement the parser is lazily initialized during the first
  // call to the constructor. You can call this function if you wish to initialize the static state
  // ahead of time.
  static void initialize();

private:
};

