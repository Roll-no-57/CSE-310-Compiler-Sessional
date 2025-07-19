
    #pragma once
    #include <iostream>
    #include <fstream>
    #include <string>

    extern std::ofstream lexLogFile;


// Generated from C8086Lexer.g4 by ANTLR 4.13.2

#pragma once


#include "antlr4-runtime.h"




class  C8086Lexer : public antlr4::Lexer {
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

  explicit C8086Lexer(antlr4::CharStream *input);

  ~C8086Lexer() override;


      void writeIntoLexLogFile(const std::string &message) {
          if (!lexLogFile.is_open()) {
              lexLogFile.open("lexLogFile.txt", std::ios::app);
              if (!lexLogFile) {
                  std::cerr << "Error opening lexLogFile.txt" << std::endl;
                  return;
              }
          }
          lexLogFile << message << std::endl;
          lexLogFile.flush();
      }


  std::string getGrammarFileName() const override;

  const std::vector<std::string>& getRuleNames() const override;

  const std::vector<std::string>& getChannelNames() const override;

  const std::vector<std::string>& getModeNames() const override;

  const antlr4::dfa::Vocabulary& getVocabulary() const override;

  antlr4::atn::SerializedATNView getSerializedATN() const override;

  const antlr4::atn::ATN& getATN() const override;

  void action(antlr4::RuleContext *context, size_t ruleIndex, size_t actionIndex) override;

  // By default the static state used to implement the lexer is lazily initialized during the first
  // call to the constructor. You can call this function if you wish to initialize the static state
  // ahead of time.
  static void initialize();

private:

  // Individual action functions triggered by action() above.
  void LINE_COMMENTAction(antlr4::RuleContext *context, size_t actionIndex);
  void BLOCK_COMMENTAction(antlr4::RuleContext *context, size_t actionIndex);
  void STRINGAction(antlr4::RuleContext *context, size_t actionIndex);
  void IFAction(antlr4::RuleContext *context, size_t actionIndex);
  void ELSEAction(antlr4::RuleContext *context, size_t actionIndex);
  void FORAction(antlr4::RuleContext *context, size_t actionIndex);
  void WHILEAction(antlr4::RuleContext *context, size_t actionIndex);
  void DOAction(antlr4::RuleContext *context, size_t actionIndex);
  void PRINTLNAction(antlr4::RuleContext *context, size_t actionIndex);
  void RETURNAction(antlr4::RuleContext *context, size_t actionIndex);
  void INTAction(antlr4::RuleContext *context, size_t actionIndex);
  void FLOATAction(antlr4::RuleContext *context, size_t actionIndex);
  void VOIDAction(antlr4::RuleContext *context, size_t actionIndex);
  void STRUCTAction(antlr4::RuleContext *context, size_t actionIndex);
  void SWITCHAction(antlr4::RuleContext *context, size_t actionIndex);
  void CASEAction(antlr4::RuleContext *context, size_t actionIndex);
  void BREAKAction(antlr4::RuleContext *context, size_t actionIndex);
  void CONTINUEAction(antlr4::RuleContext *context, size_t actionIndex);
  void DEFAULTAction(antlr4::RuleContext *context, size_t actionIndex);
  void LPARENAction(antlr4::RuleContext *context, size_t actionIndex);
  void RPARENAction(antlr4::RuleContext *context, size_t actionIndex);
  void LCURLAction(antlr4::RuleContext *context, size_t actionIndex);
  void RCURLAction(antlr4::RuleContext *context, size_t actionIndex);
  void LTHIRDAction(antlr4::RuleContext *context, size_t actionIndex);
  void RTHIRDAction(antlr4::RuleContext *context, size_t actionIndex);
  void SEMICOLONAction(antlr4::RuleContext *context, size_t actionIndex);
  void COLONAction(antlr4::RuleContext *context, size_t actionIndex);
  void COMMAAction(antlr4::RuleContext *context, size_t actionIndex);
  void ADDOPAction(antlr4::RuleContext *context, size_t actionIndex);
  void MULOPAction(antlr4::RuleContext *context, size_t actionIndex);
  void INCOPAction(antlr4::RuleContext *context, size_t actionIndex);
  void DECOPAction(antlr4::RuleContext *context, size_t actionIndex);
  void NOTAction(antlr4::RuleContext *context, size_t actionIndex);
  void RELOPAction(antlr4::RuleContext *context, size_t actionIndex);
  void LOGICOPAction(antlr4::RuleContext *context, size_t actionIndex);
  void ASSIGNOPAction(antlr4::RuleContext *context, size_t actionIndex);
  void IDAction(antlr4::RuleContext *context, size_t actionIndex);
  void CONST_INTAction(antlr4::RuleContext *context, size_t actionIndex);
  void CONST_FLOATAction(antlr4::RuleContext *context, size_t actionIndex);

  // Individual semantic predicate functions triggered by sempred() above.

};

