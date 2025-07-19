
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


#include "C8086ParserListener.h"

#include "C8086Parser.h"


using namespace antlrcpp;

using namespace antlr4;

namespace {

struct C8086ParserStaticData final {
  C8086ParserStaticData(std::vector<std::string> ruleNames,
                        std::vector<std::string> literalNames,
                        std::vector<std::string> symbolicNames)
      : ruleNames(std::move(ruleNames)), literalNames(std::move(literalNames)),
        symbolicNames(std::move(symbolicNames)),
        vocabulary(this->literalNames, this->symbolicNames) {}

  C8086ParserStaticData(const C8086ParserStaticData&) = delete;
  C8086ParserStaticData(C8086ParserStaticData&&) = delete;
  C8086ParserStaticData& operator=(const C8086ParserStaticData&) = delete;
  C8086ParserStaticData& operator=(C8086ParserStaticData&&) = delete;

  std::vector<antlr4::dfa::DFA> decisionToDFA;
  antlr4::atn::PredictionContextCache sharedContextCache;
  const std::vector<std::string> ruleNames;
  const std::vector<std::string> literalNames;
  const std::vector<std::string> symbolicNames;
  const antlr4::dfa::Vocabulary vocabulary;
  antlr4::atn::SerializedATNView serializedATN;
  std::unique_ptr<antlr4::atn::ATN> atn;
};

::antlr4::internal::OnceFlag c8086parserParserOnceFlag;
#if ANTLR4_USE_THREAD_LOCAL_CACHE
static thread_local
#endif
std::unique_ptr<C8086ParserStaticData> c8086parserParserStaticData = nullptr;

void c8086parserParserInitialize() {
#if ANTLR4_USE_THREAD_LOCAL_CACHE
  if (c8086parserParserStaticData != nullptr) {
    return;
  }
#else
  assert(c8086parserParserStaticData == nullptr);
#endif
  auto staticData = std::make_unique<C8086ParserStaticData>(
    std::vector<std::string>{
      "start", "program", "unit", "struct_declaration", "func_declaration", 
      "func_definition", "parameter_list", "compound_statement", "var_declaration", 
      "declaration_list_err", "type_specifier", "declaration_list", "statements", 
      "statement", "switch_cases", "case_statement", "expression_statement", 
      "variable", "expression", "logic_expression", "rel_expression", "simple_expression", 
      "term", "unary_expression", "factor", "argument_list", "arguments"
    },
    std::vector<std::string>{
      "", "", "", "", "", "'if'", "'else'", "'for'", "'while'", "'do'", 
      "'println'", "'return'", "'int'", "'float'", "'void'", "'struct'", 
      "'switch'", "'case'", "'break'", "'continue'", "'default'", "'('", 
      "')'", "'{'", "'}'", "'['", "']'", "';'", "':'", "','", "", "", "'++'", 
      "'--'", "'!'", "", "", "'='"
    },
    std::vector<std::string>{
      "", "LINE_COMMENT", "BLOCK_COMMENT", "STRING", "WS", "IF", "ELSE", 
      "FOR", "WHILE", "DO", "PRINTLN", "RETURN", "INT", "FLOAT", "VOID", 
      "STRUCT", "SWITCH", "CASE", "BREAK", "CONTINUE", "DEFAULT", "LPAREN", 
      "RPAREN", "LCURL", "RCURL", "LTHIRD", "RTHIRD", "SEMICOLON", "COLON", 
      "COMMA", "ADDOP", "MULOP", "INCOP", "DECOP", "NOT", "RELOP", "LOGICOP", 
      "ASSIGNOP", "ID", "CONST_INT", "CONST_FLOAT"
    }
  );
  static const int32_t serializedATNSegment[] = {
  	4,1,40,470,2,0,7,0,2,1,7,1,2,2,7,2,2,3,7,3,2,4,7,4,2,5,7,5,2,6,7,6,2,
  	7,7,7,2,8,7,8,2,9,7,9,2,10,7,10,2,11,7,11,2,12,7,12,2,13,7,13,2,14,7,
  	14,2,15,7,15,2,16,7,16,2,17,7,17,2,18,7,18,2,19,7,19,2,20,7,20,2,21,7,
  	21,2,22,7,22,2,23,7,23,2,24,7,24,2,25,7,25,2,26,7,26,1,0,1,0,1,0,1,1,
  	1,1,1,1,1,1,1,1,1,1,1,1,1,1,5,1,66,8,1,10,1,12,1,69,9,1,1,2,1,2,1,2,1,
  	2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,3,2,83,8,2,1,3,1,3,1,3,1,3,1,3,1,3,
  	1,4,1,4,1,4,1,4,1,4,1,4,1,4,1,4,1,4,1,4,1,4,1,4,1,4,1,4,1,4,3,4,106,8,
  	4,1,5,1,5,1,5,1,5,1,5,1,5,1,5,1,5,1,5,1,5,1,5,1,5,1,5,1,5,1,5,1,5,3,5,
  	124,8,5,1,6,1,6,1,6,1,6,1,6,1,6,1,6,1,6,3,6,134,8,6,1,6,1,6,1,6,1,6,1,
  	6,1,6,1,6,1,6,1,6,1,6,1,6,5,6,147,8,6,10,6,12,6,150,9,6,1,7,1,7,1,7,1,
  	7,1,7,1,7,1,7,1,7,1,7,1,7,3,7,162,8,7,1,8,1,8,1,8,1,8,1,8,1,8,1,8,1,8,
  	1,8,1,8,3,8,174,8,8,1,9,1,9,1,10,1,10,1,10,1,10,1,10,1,10,1,10,1,10,1,
  	10,3,10,187,8,10,1,11,1,11,1,11,1,11,1,11,1,11,1,11,1,11,3,11,197,8,11,
  	1,11,1,11,1,11,1,11,1,11,1,11,1,11,1,11,1,11,1,11,1,11,5,11,210,8,11,
  	10,11,12,11,213,9,11,1,12,1,12,1,12,1,12,1,12,1,12,1,12,1,12,5,12,223,
  	8,12,10,12,12,12,226,9,12,1,13,1,13,1,13,1,13,1,13,1,13,1,13,1,13,1,13,
  	1,13,1,13,1,13,1,13,1,13,1,13,1,13,1,13,1,13,1,13,1,13,1,13,1,13,1,13,
  	1,13,1,13,1,13,1,13,1,13,1,13,1,13,1,13,1,13,1,13,1,13,1,13,1,13,1,13,
  	1,13,1,13,1,13,1,13,1,13,1,13,1,13,1,13,1,13,1,13,1,13,1,13,1,13,1,13,
  	1,13,1,13,1,13,1,13,1,13,1,13,1,13,1,13,1,13,1,13,1,13,1,13,1,13,1,13,
  	1,13,1,13,1,13,1,13,1,13,1,13,1,13,1,13,1,13,1,13,1,13,1,13,3,13,305,
  	8,13,1,14,1,14,1,14,1,14,1,14,1,14,1,14,1,14,5,14,315,8,14,10,14,12,14,
  	318,9,14,1,15,1,15,1,15,1,15,1,15,1,15,1,15,1,15,1,15,1,15,1,15,3,15,
  	331,8,15,1,16,1,16,1,16,1,16,1,16,1,16,3,16,339,8,16,1,17,1,17,1,17,1,
  	17,1,17,1,17,1,17,1,17,3,17,349,8,17,1,18,1,18,1,18,1,18,1,18,1,18,1,
  	18,1,18,3,18,359,8,18,1,19,1,19,1,19,1,19,1,19,1,19,1,19,1,19,3,19,369,
  	8,19,1,20,1,20,1,20,1,20,1,20,1,20,1,20,1,20,3,20,379,8,20,1,21,1,21,
  	1,21,1,21,1,21,1,21,1,21,1,21,1,21,5,21,390,8,21,10,21,12,21,393,9,21,
  	1,22,1,22,1,22,1,22,1,22,1,22,1,22,1,22,1,22,5,22,404,8,22,10,22,12,22,
  	407,9,22,1,23,1,23,1,23,1,23,1,23,1,23,1,23,1,23,1,23,1,23,1,23,3,23,
  	420,8,23,1,24,1,24,1,24,1,24,1,24,1,24,1,24,1,24,1,24,1,24,1,24,1,24,
  	1,24,1,24,1,24,1,24,1,24,1,24,1,24,1,24,1,24,1,24,1,24,1,24,1,24,1,24,
  	3,24,448,8,24,1,25,1,25,1,25,1,25,3,25,454,8,25,1,26,1,26,1,26,1,26,1,
  	26,1,26,1,26,1,26,1,26,5,26,465,8,26,10,26,12,26,468,9,26,1,26,0,8,2,
  	12,22,24,28,42,44,52,27,0,2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,
  	34,36,38,40,42,44,46,48,50,52,0,0,491,0,54,1,0,0,0,2,57,1,0,0,0,4,82,
  	1,0,0,0,6,84,1,0,0,0,8,105,1,0,0,0,10,123,1,0,0,0,12,133,1,0,0,0,14,161,
  	1,0,0,0,16,173,1,0,0,0,18,175,1,0,0,0,20,186,1,0,0,0,22,196,1,0,0,0,24,
  	214,1,0,0,0,26,304,1,0,0,0,28,306,1,0,0,0,30,330,1,0,0,0,32,338,1,0,0,
  	0,34,348,1,0,0,0,36,358,1,0,0,0,38,368,1,0,0,0,40,378,1,0,0,0,42,380,
  	1,0,0,0,44,394,1,0,0,0,46,419,1,0,0,0,48,447,1,0,0,0,50,453,1,0,0,0,52,
  	455,1,0,0,0,54,55,3,2,1,0,55,56,6,0,-1,0,56,1,1,0,0,0,57,58,6,1,-1,0,
  	58,59,3,4,2,0,59,60,6,1,-1,0,60,67,1,0,0,0,61,62,10,2,0,0,62,63,3,4,2,
  	0,63,64,6,1,-1,0,64,66,1,0,0,0,65,61,1,0,0,0,66,69,1,0,0,0,67,65,1,0,
  	0,0,67,68,1,0,0,0,68,3,1,0,0,0,69,67,1,0,0,0,70,71,3,16,8,0,71,72,6,2,
  	-1,0,72,83,1,0,0,0,73,74,3,8,4,0,74,75,6,2,-1,0,75,83,1,0,0,0,76,77,3,
  	10,5,0,77,78,6,2,-1,0,78,83,1,0,0,0,79,80,3,6,3,0,80,81,6,2,-1,0,81,83,
  	1,0,0,0,82,70,1,0,0,0,82,73,1,0,0,0,82,76,1,0,0,0,82,79,1,0,0,0,83,5,
  	1,0,0,0,84,85,5,15,0,0,85,86,5,38,0,0,86,87,3,14,7,0,87,88,5,27,0,0,88,
  	89,6,3,-1,0,89,7,1,0,0,0,90,91,3,20,10,0,91,92,5,38,0,0,92,93,5,21,0,
  	0,93,94,3,12,6,0,94,95,5,22,0,0,95,96,5,27,0,0,96,97,6,4,-1,0,97,106,
  	1,0,0,0,98,99,3,20,10,0,99,100,5,38,0,0,100,101,5,21,0,0,101,102,5,22,
  	0,0,102,103,5,27,0,0,103,104,6,4,-1,0,104,106,1,0,0,0,105,90,1,0,0,0,
  	105,98,1,0,0,0,106,9,1,0,0,0,107,108,3,20,10,0,108,109,5,38,0,0,109,110,
  	5,21,0,0,110,111,3,12,6,0,111,112,5,22,0,0,112,113,6,5,-1,0,113,114,3,
  	14,7,0,114,115,6,5,-1,0,115,124,1,0,0,0,116,117,3,20,10,0,117,118,5,38,
  	0,0,118,119,5,21,0,0,119,120,5,22,0,0,120,121,3,14,7,0,121,122,6,5,-1,
  	0,122,124,1,0,0,0,123,107,1,0,0,0,123,116,1,0,0,0,124,11,1,0,0,0,125,
  	126,6,6,-1,0,126,127,3,20,10,0,127,128,5,38,0,0,128,129,6,6,-1,0,129,
  	134,1,0,0,0,130,131,3,20,10,0,131,132,6,6,-1,0,132,134,1,0,0,0,133,125,
  	1,0,0,0,133,130,1,0,0,0,134,148,1,0,0,0,135,136,10,4,0,0,136,137,5,29,
  	0,0,137,138,3,20,10,0,138,139,5,38,0,0,139,140,6,6,-1,0,140,147,1,0,0,
  	0,141,142,10,3,0,0,142,143,5,29,0,0,143,144,3,20,10,0,144,145,6,6,-1,
  	0,145,147,1,0,0,0,146,135,1,0,0,0,146,141,1,0,0,0,147,150,1,0,0,0,148,
  	146,1,0,0,0,148,149,1,0,0,0,149,13,1,0,0,0,150,148,1,0,0,0,151,152,5,
  	23,0,0,152,153,6,7,-1,0,153,154,3,24,12,0,154,155,5,24,0,0,155,156,6,
  	7,-1,0,156,162,1,0,0,0,157,158,5,23,0,0,158,159,6,7,-1,0,159,160,5,24,
  	0,0,160,162,6,7,-1,0,161,151,1,0,0,0,161,157,1,0,0,0,162,15,1,0,0,0,163,
  	164,3,20,10,0,164,165,3,22,11,0,165,166,5,27,0,0,166,167,6,8,-1,0,167,
  	174,1,0,0,0,168,169,3,20,10,0,169,170,3,18,9,0,170,171,5,27,0,0,171,172,
  	6,8,-1,0,172,174,1,0,0,0,173,163,1,0,0,0,173,168,1,0,0,0,174,17,1,0,0,
  	0,175,176,6,9,-1,0,176,19,1,0,0,0,177,178,5,12,0,0,178,187,6,10,-1,0,
  	179,180,5,13,0,0,180,187,6,10,-1,0,181,182,5,14,0,0,182,187,6,10,-1,0,
  	183,184,5,15,0,0,184,185,5,38,0,0,185,187,6,10,-1,0,186,177,1,0,0,0,186,
  	179,1,0,0,0,186,181,1,0,0,0,186,183,1,0,0,0,187,21,1,0,0,0,188,189,6,
  	11,-1,0,189,190,5,38,0,0,190,197,6,11,-1,0,191,192,5,38,0,0,192,193,5,
  	25,0,0,193,194,5,39,0,0,194,195,5,26,0,0,195,197,6,11,-1,0,196,188,1,
  	0,0,0,196,191,1,0,0,0,197,211,1,0,0,0,198,199,10,4,0,0,199,200,5,29,0,
  	0,200,201,5,38,0,0,201,210,6,11,-1,0,202,203,10,3,0,0,203,204,5,29,0,
  	0,204,205,5,38,0,0,205,206,5,25,0,0,206,207,5,39,0,0,207,208,5,26,0,0,
  	208,210,6,11,-1,0,209,198,1,0,0,0,209,202,1,0,0,0,210,213,1,0,0,0,211,
  	209,1,0,0,0,211,212,1,0,0,0,212,23,1,0,0,0,213,211,1,0,0,0,214,215,6,
  	12,-1,0,215,216,3,26,13,0,216,217,6,12,-1,0,217,224,1,0,0,0,218,219,10,
  	1,0,0,219,220,3,26,13,0,220,221,6,12,-1,0,221,223,1,0,0,0,222,218,1,0,
  	0,0,223,226,1,0,0,0,224,222,1,0,0,0,224,225,1,0,0,0,225,25,1,0,0,0,226,
  	224,1,0,0,0,227,228,3,16,8,0,228,229,6,13,-1,0,229,305,1,0,0,0,230,231,
  	3,32,16,0,231,232,6,13,-1,0,232,305,1,0,0,0,233,234,3,14,7,0,234,235,
  	6,13,-1,0,235,305,1,0,0,0,236,237,5,7,0,0,237,238,5,21,0,0,238,239,3,
  	32,16,0,239,240,3,32,16,0,240,241,3,36,18,0,241,242,5,22,0,0,242,243,
  	3,26,13,0,243,244,6,13,-1,0,244,305,1,0,0,0,245,246,5,5,0,0,246,247,5,
  	21,0,0,247,248,3,36,18,0,248,249,5,22,0,0,249,250,3,26,13,0,250,251,6,
  	13,-1,0,251,305,1,0,0,0,252,253,5,5,0,0,253,254,5,21,0,0,254,255,3,36,
  	18,0,255,256,5,22,0,0,256,257,3,26,13,0,257,258,5,6,0,0,258,259,3,26,
  	13,0,259,260,6,13,-1,0,260,305,1,0,0,0,261,262,5,8,0,0,262,263,5,21,0,
  	0,263,264,3,36,18,0,264,265,5,22,0,0,265,266,3,26,13,0,266,267,6,13,-1,
  	0,267,305,1,0,0,0,268,269,5,10,0,0,269,270,5,21,0,0,270,271,5,38,0,0,
  	271,272,5,22,0,0,272,273,5,27,0,0,273,305,6,13,-1,0,274,275,5,11,0,0,
  	275,276,3,36,18,0,276,277,5,27,0,0,277,278,6,13,-1,0,278,305,1,0,0,0,
  	279,280,5,16,0,0,280,281,5,21,0,0,281,282,3,36,18,0,282,283,5,22,0,0,
  	283,284,5,23,0,0,284,285,3,28,14,0,285,286,5,24,0,0,286,287,6,13,-1,0,
  	287,305,1,0,0,0,288,289,5,9,0,0,289,290,6,13,-1,0,290,291,3,14,7,0,291,
  	292,5,8,0,0,292,293,5,21,0,0,293,294,3,36,18,0,294,295,5,22,0,0,295,296,
  	5,27,0,0,296,297,6,13,-1,0,297,305,1,0,0,0,298,299,5,18,0,0,299,300,5,
  	27,0,0,300,305,6,13,-1,0,301,302,5,19,0,0,302,303,5,27,0,0,303,305,6,
  	13,-1,0,304,227,1,0,0,0,304,230,1,0,0,0,304,233,1,0,0,0,304,236,1,0,0,
  	0,304,245,1,0,0,0,304,252,1,0,0,0,304,261,1,0,0,0,304,268,1,0,0,0,304,
  	274,1,0,0,0,304,279,1,0,0,0,304,288,1,0,0,0,304,298,1,0,0,0,304,301,1,
  	0,0,0,305,27,1,0,0,0,306,307,6,14,-1,0,307,308,3,30,15,0,308,309,6,14,
  	-1,0,309,316,1,0,0,0,310,311,10,1,0,0,311,312,3,30,15,0,312,313,6,14,
  	-1,0,313,315,1,0,0,0,314,310,1,0,0,0,315,318,1,0,0,0,316,314,1,0,0,0,
  	316,317,1,0,0,0,317,29,1,0,0,0,318,316,1,0,0,0,319,320,5,17,0,0,320,321,
  	3,36,18,0,321,322,5,28,0,0,322,323,3,24,12,0,323,324,6,15,-1,0,324,331,
  	1,0,0,0,325,326,5,20,0,0,326,327,5,28,0,0,327,328,3,24,12,0,328,329,6,
  	15,-1,0,329,331,1,0,0,0,330,319,1,0,0,0,330,325,1,0,0,0,331,31,1,0,0,
  	0,332,333,5,27,0,0,333,339,6,16,-1,0,334,335,3,36,18,0,335,336,5,27,0,
  	0,336,337,6,16,-1,0,337,339,1,0,0,0,338,332,1,0,0,0,338,334,1,0,0,0,339,
  	33,1,0,0,0,340,341,5,38,0,0,341,349,6,17,-1,0,342,343,5,38,0,0,343,344,
  	5,25,0,0,344,345,3,36,18,0,345,346,5,26,0,0,346,347,6,17,-1,0,347,349,
  	1,0,0,0,348,340,1,0,0,0,348,342,1,0,0,0,349,35,1,0,0,0,350,351,3,38,19,
  	0,351,352,6,18,-1,0,352,359,1,0,0,0,353,354,3,34,17,0,354,355,5,37,0,
  	0,355,356,3,38,19,0,356,357,6,18,-1,0,357,359,1,0,0,0,358,350,1,0,0,0,
  	358,353,1,0,0,0,359,37,1,0,0,0,360,361,3,40,20,0,361,362,6,19,-1,0,362,
  	369,1,0,0,0,363,364,3,40,20,0,364,365,5,36,0,0,365,366,3,40,20,0,366,
  	367,6,19,-1,0,367,369,1,0,0,0,368,360,1,0,0,0,368,363,1,0,0,0,369,39,
  	1,0,0,0,370,371,3,42,21,0,371,372,6,20,-1,0,372,379,1,0,0,0,373,374,3,
  	42,21,0,374,375,5,35,0,0,375,376,3,42,21,0,376,377,6,20,-1,0,377,379,
  	1,0,0,0,378,370,1,0,0,0,378,373,1,0,0,0,379,41,1,0,0,0,380,381,6,21,-1,
  	0,381,382,3,44,22,0,382,383,6,21,-1,0,383,391,1,0,0,0,384,385,10,1,0,
  	0,385,386,5,30,0,0,386,387,3,44,22,0,387,388,6,21,-1,0,388,390,1,0,0,
  	0,389,384,1,0,0,0,390,393,1,0,0,0,391,389,1,0,0,0,391,392,1,0,0,0,392,
  	43,1,0,0,0,393,391,1,0,0,0,394,395,6,22,-1,0,395,396,3,46,23,0,396,397,
  	6,22,-1,0,397,405,1,0,0,0,398,399,10,1,0,0,399,400,5,31,0,0,400,401,3,
  	46,23,0,401,402,6,22,-1,0,402,404,1,0,0,0,403,398,1,0,0,0,404,407,1,0,
  	0,0,405,403,1,0,0,0,405,406,1,0,0,0,406,45,1,0,0,0,407,405,1,0,0,0,408,
  	409,5,30,0,0,409,410,3,46,23,0,410,411,6,23,-1,0,411,420,1,0,0,0,412,
  	413,5,34,0,0,413,414,3,46,23,0,414,415,6,23,-1,0,415,420,1,0,0,0,416,
  	417,3,48,24,0,417,418,6,23,-1,0,418,420,1,0,0,0,419,408,1,0,0,0,419,412,
  	1,0,0,0,419,416,1,0,0,0,420,47,1,0,0,0,421,422,3,34,17,0,422,423,6,24,
  	-1,0,423,448,1,0,0,0,424,425,5,38,0,0,425,426,5,21,0,0,426,427,3,50,25,
  	0,427,428,5,22,0,0,428,429,6,24,-1,0,429,448,1,0,0,0,430,431,5,21,0,0,
  	431,432,3,36,18,0,432,433,5,22,0,0,433,434,6,24,-1,0,434,448,1,0,0,0,
  	435,436,5,39,0,0,436,448,6,24,-1,0,437,438,5,40,0,0,438,448,6,24,-1,0,
  	439,440,3,34,17,0,440,441,5,32,0,0,441,442,6,24,-1,0,442,448,1,0,0,0,
  	443,444,3,34,17,0,444,445,5,33,0,0,445,446,6,24,-1,0,446,448,1,0,0,0,
  	447,421,1,0,0,0,447,424,1,0,0,0,447,430,1,0,0,0,447,435,1,0,0,0,447,437,
  	1,0,0,0,447,439,1,0,0,0,447,443,1,0,0,0,448,49,1,0,0,0,449,450,3,52,26,
  	0,450,451,6,25,-1,0,451,454,1,0,0,0,452,454,6,25,-1,0,453,449,1,0,0,0,
  	453,452,1,0,0,0,454,51,1,0,0,0,455,456,6,26,-1,0,456,457,3,38,19,0,457,
  	458,6,26,-1,0,458,466,1,0,0,0,459,460,10,2,0,0,460,461,5,29,0,0,461,462,
  	3,38,19,0,462,463,6,26,-1,0,463,465,1,0,0,0,464,459,1,0,0,0,465,468,1,
  	0,0,0,466,464,1,0,0,0,466,467,1,0,0,0,467,53,1,0,0,0,468,466,1,0,0,0,
  	28,67,82,105,123,133,146,148,161,173,186,196,209,211,224,304,316,330,
  	338,348,358,368,378,391,405,419,447,453,466
  };
  staticData->serializedATN = antlr4::atn::SerializedATNView(serializedATNSegment, sizeof(serializedATNSegment) / sizeof(serializedATNSegment[0]));

  antlr4::atn::ATNDeserializer deserializer;
  staticData->atn = deserializer.deserialize(staticData->serializedATN);

  const size_t count = staticData->atn->getNumberOfDecisions();
  staticData->decisionToDFA.reserve(count);
  for (size_t i = 0; i < count; i++) { 
    staticData->decisionToDFA.emplace_back(staticData->atn->getDecisionState(i), i);
  }
  c8086parserParserStaticData = std::move(staticData);
}

}

C8086Parser::C8086Parser(TokenStream *input) : C8086Parser(input, antlr4::atn::ParserATNSimulatorOptions()) {}

C8086Parser::C8086Parser(TokenStream *input, const antlr4::atn::ParserATNSimulatorOptions &options) : Parser(input) {
  C8086Parser::initialize();
  _interpreter = new atn::ParserATNSimulator(this, *c8086parserParserStaticData->atn, c8086parserParserStaticData->decisionToDFA, c8086parserParserStaticData->sharedContextCache, options);
}

C8086Parser::~C8086Parser() {
  delete _interpreter;
}

const atn::ATN& C8086Parser::getATN() const {
  return *c8086parserParserStaticData->atn;
}

std::string C8086Parser::getGrammarFileName() const {
  return "C8086Parser.g4";
}

const std::vector<std::string>& C8086Parser::getRuleNames() const {
  return c8086parserParserStaticData->ruleNames;
}

const dfa::Vocabulary& C8086Parser::getVocabulary() const {
  return c8086parserParserStaticData->vocabulary;
}

antlr4::atn::SerializedATNView C8086Parser::getSerializedATN() const {
  return c8086parserParserStaticData->serializedATN;
}


//----------------- StartContext ------------------------------------------------------------------

C8086Parser::StartContext::StartContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

C8086Parser::ProgramContext* C8086Parser::StartContext::program() {
  return getRuleContext<C8086Parser::ProgramContext>(0);
}


size_t C8086Parser::StartContext::getRuleIndex() const {
  return C8086Parser::RuleStart;
}

void C8086Parser::StartContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterStart(this);
}

void C8086Parser::StartContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitStart(this);
}

C8086Parser::StartContext* C8086Parser::start() {
  StartContext *_localctx = _tracker.createInstance<StartContext>(_ctx, getState());
  enterRule(_localctx, 0, C8086Parser::RuleStart);

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    exitRule();
  });
  try {
    enterOuterAlt(_localctx, 1);
    setState(54);
    program(0);

            writeIntoparserLogFile("Parsing completed successfully with " + std::to_string(syntaxErrorCount) + " syntax errors.");
            ST->printAllScopeTable(parserLogFile); // Print symbol table at the end
            delete ST;  // Clean up symbol table

            writeIntoparserLogFile("Total Error count: " + std::to_string(syntaxErrorCount));
        
   
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }

  return _localctx;
}

//----------------- ProgramContext ------------------------------------------------------------------

C8086Parser::ProgramContext::ProgramContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

C8086Parser::UnitContext* C8086Parser::ProgramContext::unit() {
  return getRuleContext<C8086Parser::UnitContext>(0);
}

C8086Parser::ProgramContext* C8086Parser::ProgramContext::program() {
  return getRuleContext<C8086Parser::ProgramContext>(0);
}


size_t C8086Parser::ProgramContext::getRuleIndex() const {
  return C8086Parser::RuleProgram;
}

void C8086Parser::ProgramContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterProgram(this);
}

void C8086Parser::ProgramContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitProgram(this);
}


C8086Parser::ProgramContext* C8086Parser::program() {
   return program(0);
}

C8086Parser::ProgramContext* C8086Parser::program(int precedence) {
  ParserRuleContext *parentContext = _ctx;
  size_t parentState = getState();
  C8086Parser::ProgramContext *_localctx = _tracker.createInstance<ProgramContext>(_ctx, parentState);
  C8086Parser::ProgramContext *previousContext = _localctx;
  (void)previousContext; // Silence compiler, in case the context is not used by generated code.
  size_t startState = 2;
  enterRecursionRule(_localctx, 2, C8086Parser::RuleProgram, precedence);

    

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    unrollRecursionContexts(parentContext);
  });
  try {
    size_t alt;
    enterOuterAlt(_localctx, 1);
    setState(58);
    antlrcpp::downCast<ProgramContext *>(_localctx)->u = unit();

            _localctx->info.line_number = antlrcpp::downCast<ProgramContext *>(_localctx)->u->info.line_number;
            _localctx->info.parsed_code = antlrcpp::downCast<ProgramContext *>(_localctx)->u->info.parsed_code;
            logLine(antlrcpp::downCast<ProgramContext *>(_localctx)->u->info.line_number, "program : unit");
            writeIntoparserLogFile(_localctx->info.parsed_code);
        
    _ctx->stop = _input->LT(-1);
    setState(67);
    _errHandler->sync(this);
    alt = getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 0, _ctx);
    while (alt != 2 && alt != atn::ATN::INVALID_ALT_NUMBER) {
      if (alt == 1) {
        if (!_parseListeners.empty())
          triggerExitRuleEvent();
        previousContext = _localctx;
        _localctx = _tracker.createInstance<ProgramContext>(parentContext, parentState);
        _localctx->p = previousContext;
        pushNewRecursionContext(_localctx, startState, RuleProgram);
        setState(61);

        if (!(precpred(_ctx, 2))) throw FailedPredicateException(this, "precpred(_ctx, 2)");
        setState(62);
        antlrcpp::downCast<ProgramContext *>(_localctx)->u = unit();

                          _localctx->info.line_number = antlrcpp::downCast<ProgramContext *>(_localctx)->u->info.line_number;
                          _localctx->info.parsed_code = antlrcpp::downCast<ProgramContext *>(_localctx)->p->info.parsed_code + "\n" + antlrcpp::downCast<ProgramContext *>(_localctx)->u->info.parsed_code;
                          logLine(antlrcpp::downCast<ProgramContext *>(_localctx)->u->info.line_number, "program : program unit");
                          writeIntoparserLogFile(_localctx->info.parsed_code);
                       
      }
      setState(69);
      _errHandler->sync(this);
      alt = getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 0, _ctx);
    }
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }
  return _localctx;
}

//----------------- UnitContext ------------------------------------------------------------------

C8086Parser::UnitContext::UnitContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

C8086Parser::Var_declarationContext* C8086Parser::UnitContext::var_declaration() {
  return getRuleContext<C8086Parser::Var_declarationContext>(0);
}

C8086Parser::Func_declarationContext* C8086Parser::UnitContext::func_declaration() {
  return getRuleContext<C8086Parser::Func_declarationContext>(0);
}

C8086Parser::Func_definitionContext* C8086Parser::UnitContext::func_definition() {
  return getRuleContext<C8086Parser::Func_definitionContext>(0);
}

C8086Parser::Struct_declarationContext* C8086Parser::UnitContext::struct_declaration() {
  return getRuleContext<C8086Parser::Struct_declarationContext>(0);
}


size_t C8086Parser::UnitContext::getRuleIndex() const {
  return C8086Parser::RuleUnit;
}

void C8086Parser::UnitContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterUnit(this);
}

void C8086Parser::UnitContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitUnit(this);
}

C8086Parser::UnitContext* C8086Parser::unit() {
  UnitContext *_localctx = _tracker.createInstance<UnitContext>(_ctx, getState());
  enterRule(_localctx, 4, C8086Parser::RuleUnit);

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    exitRule();
  });
  try {
    setState(82);
    _errHandler->sync(this);
    switch (getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 1, _ctx)) {
    case 1: {
      enterOuterAlt(_localctx, 1);
      setState(70);
      antlrcpp::downCast<UnitContext *>(_localctx)->var_declarationContext = var_declaration();

              antlrcpp::downCast<UnitContext *>(_localctx)->info =  antlrcpp::downCast<UnitContext *>(_localctx)->var_declarationContext->info;
              logLine(_localctx->info.line_number, "unit : var_declaration");
              writeIntoparserLogFile(_localctx->info.parsed_code);
          
      break;
    }

    case 2: {
      enterOuterAlt(_localctx, 2);
      setState(73);
      antlrcpp::downCast<UnitContext *>(_localctx)->func_declarationContext = func_declaration();

              antlrcpp::downCast<UnitContext *>(_localctx)->info =  antlrcpp::downCast<UnitContext *>(_localctx)->func_declarationContext->info;
              logLine(_localctx->info.line_number, "unit : func_declaration");
              writeIntoparserLogFile(_localctx->info.parsed_code);
          
      break;
    }

    case 3: {
      enterOuterAlt(_localctx, 3);
      setState(76);
      antlrcpp::downCast<UnitContext *>(_localctx)->func_definitionContext = func_definition();

              antlrcpp::downCast<UnitContext *>(_localctx)->info =  antlrcpp::downCast<UnitContext *>(_localctx)->func_definitionContext->info;
              logLine(_localctx->info.line_number, "unit : func_definition");
              writeIntoparserLogFile(_localctx->info.parsed_code);
          
      break;
    }

    case 4: {
      enterOuterAlt(_localctx, 4);
      setState(79);
      antlrcpp::downCast<UnitContext *>(_localctx)->struct_declarationContext = struct_declaration();

              antlrcpp::downCast<UnitContext *>(_localctx)->info =  antlrcpp::downCast<UnitContext *>(_localctx)->struct_declarationContext->info;
              logLine(_localctx->info.line_number, "unit : struct_definition");
              writeIntoparserLogFile(_localctx->info.parsed_code);
          
      break;
    }

    default:
      break;
    }
   
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }

  return _localctx;
}

//----------------- Struct_declarationContext ------------------------------------------------------------------

C8086Parser::Struct_declarationContext::Struct_declarationContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

tree::TerminalNode* C8086Parser::Struct_declarationContext::STRUCT() {
  return getToken(C8086Parser::STRUCT, 0);
}

tree::TerminalNode* C8086Parser::Struct_declarationContext::ID() {
  return getToken(C8086Parser::ID, 0);
}

tree::TerminalNode* C8086Parser::Struct_declarationContext::SEMICOLON() {
  return getToken(C8086Parser::SEMICOLON, 0);
}

C8086Parser::Compound_statementContext* C8086Parser::Struct_declarationContext::compound_statement() {
  return getRuleContext<C8086Parser::Compound_statementContext>(0);
}


size_t C8086Parser::Struct_declarationContext::getRuleIndex() const {
  return C8086Parser::RuleStruct_declaration;
}

void C8086Parser::Struct_declarationContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterStruct_declaration(this);
}

void C8086Parser::Struct_declarationContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitStruct_declaration(this);
}

C8086Parser::Struct_declarationContext* C8086Parser::struct_declaration() {
  Struct_declarationContext *_localctx = _tracker.createInstance<Struct_declarationContext>(_ctx, getState());
  enterRule(_localctx, 6, C8086Parser::RuleStruct_declaration);

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    exitRule();
  });
  try {
    enterOuterAlt(_localctx, 1);
    setState(84);
    match(C8086Parser::STRUCT);
    setState(85);
    antlrcpp::downCast<Struct_declarationContext *>(_localctx)->idToken = match(C8086Parser::ID);
    setState(86);
    antlrcpp::downCast<Struct_declarationContext *>(_localctx)->cs = compound_statement();
    setState(87);
    match(C8086Parser::SEMICOLON);

            _localctx->info.line_number = antlrcpp::downCast<Struct_declarationContext *>(_localctx)->idToken->getLine();
            std::string code = "struct " + antlrcpp::downCast<Struct_declarationContext *>(_localctx)->idToken->getText() + " " + antlrcpp::downCast<Struct_declarationContext *>(_localctx)->cs->code_string;
            antlrcpp::downCast<Struct_declarationContext *>(_localctx)->info =  ParseInfo(antlrcpp::downCast<Struct_declarationContext *>(_localctx)->idToken->getLine(), code);
            logLine(_localctx->info.line_number, "unit : STRUCT ID compound_statement");
            writeIntoparserLogFile(_localctx->info.parsed_code);
        
   
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }

  return _localctx;
}

//----------------- Func_declarationContext ------------------------------------------------------------------

C8086Parser::Func_declarationContext::Func_declarationContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

tree::TerminalNode* C8086Parser::Func_declarationContext::ID() {
  return getToken(C8086Parser::ID, 0);
}

tree::TerminalNode* C8086Parser::Func_declarationContext::LPAREN() {
  return getToken(C8086Parser::LPAREN, 0);
}

tree::TerminalNode* C8086Parser::Func_declarationContext::RPAREN() {
  return getToken(C8086Parser::RPAREN, 0);
}

C8086Parser::Type_specifierContext* C8086Parser::Func_declarationContext::type_specifier() {
  return getRuleContext<C8086Parser::Type_specifierContext>(0);
}

C8086Parser::Parameter_listContext* C8086Parser::Func_declarationContext::parameter_list() {
  return getRuleContext<C8086Parser::Parameter_listContext>(0);
}

tree::TerminalNode* C8086Parser::Func_declarationContext::SEMICOLON() {
  return getToken(C8086Parser::SEMICOLON, 0);
}


size_t C8086Parser::Func_declarationContext::getRuleIndex() const {
  return C8086Parser::RuleFunc_declaration;
}

void C8086Parser::Func_declarationContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterFunc_declaration(this);
}

void C8086Parser::Func_declarationContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitFunc_declaration(this);
}

C8086Parser::Func_declarationContext* C8086Parser::func_declaration() {
  Func_declarationContext *_localctx = _tracker.createInstance<Func_declarationContext>(_ctx, getState());
  enterRule(_localctx, 8, C8086Parser::RuleFunc_declaration);

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    exitRule();
  });
  try {
    setState(105);
    _errHandler->sync(this);
    switch (getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 2, _ctx)) {
    case 1: {
      enterOuterAlt(_localctx, 1);
      setState(90);
      antlrcpp::downCast<Func_declarationContext *>(_localctx)->ts = type_specifier();
      setState(91);
      antlrcpp::downCast<Func_declarationContext *>(_localctx)->idToken = match(C8086Parser::ID);
      setState(92);
      match(C8086Parser::LPAREN);
      setState(93);
      antlrcpp::downCast<Func_declarationContext *>(_localctx)->pl = parameter_list(0);
      setState(94);
      match(C8086Parser::RPAREN);
      setState(95);
      antlrcpp::downCast<Func_declarationContext *>(_localctx)->sm = match(C8086Parser::SEMICOLON);

              _localctx->info.line_number = antlrcpp::downCast<Func_declarationContext *>(_localctx)->sm->getLine();
              std::string funcName = antlrcpp::downCast<Func_declarationContext *>(_localctx)->idToken->getText();
              std::string funcType = "FUNCTION," + antlrcpp::downCast<Func_declarationContext *>(_localctx)->ts->name_line + "<==(" + antlrcpp::downCast<Func_declarationContext *>(_localctx)->pl->param_string + ")>";
              if (!ST->Insert(funcName, funcType)) {
                  logError(antlrcpp::downCast<Func_declarationContext *>(_localctx)->sm->getLine(), "Multiple declaration of function " + funcName);
                  syntaxErrorCount++;
              }
              logLine(antlrcpp::downCast<Func_declarationContext *>(_localctx)->sm->getLine(), "func_declaration : type_specifier ID LPAREN parameter_list RPAREN SEMICOLON");
              std::string code = antlrcpp::downCast<Func_declarationContext *>(_localctx)->ts->name_line + " " + funcName + "(" + antlrcpp::downCast<Func_declarationContext *>(_localctx)->pl->param_string + ");";
              antlrcpp::downCast<Func_declarationContext *>(_localctx)->info =  ParseInfo(antlrcpp::downCast<Func_declarationContext *>(_localctx)->sm->getLine(), code);
              writeIntoparserLogFile(code);
          
      break;
    }

    case 2: {
      enterOuterAlt(_localctx, 2);
      setState(98);
      antlrcpp::downCast<Func_declarationContext *>(_localctx)->ts = type_specifier();
      setState(99);
      antlrcpp::downCast<Func_declarationContext *>(_localctx)->idToken = match(C8086Parser::ID);
      setState(100);
      match(C8086Parser::LPAREN);
      setState(101);
      match(C8086Parser::RPAREN);
      setState(102);
      antlrcpp::downCast<Func_declarationContext *>(_localctx)->sm = match(C8086Parser::SEMICOLON);

              _localctx->info.line_number = antlrcpp::downCast<Func_declarationContext *>(_localctx)->sm->getLine();
              std::string funcName = antlrcpp::downCast<Func_declarationContext *>(_localctx)->idToken->getText();
              std::string funcType = "FUNCTION," + antlrcpp::downCast<Func_declarationContext *>(_localctx)->ts->name_line + "<==()>";
              if (!ST->Insert(funcName, funcType)) {
                  writeIntoErrorFile("Line " + std::to_string(antlrcpp::downCast<Func_declarationContext *>(_localctx)->sm->getLine()) + ": Multiple declaration of function " + funcName);
                  syntaxErrorCount++;
              }
              logLine(antlrcpp::downCast<Func_declarationContext *>(_localctx)->sm->getLine(), "func_declaration : type_specifier ID LPAREN RPAREN SEMICOLON");
              std::string code = antlrcpp::downCast<Func_declarationContext *>(_localctx)->ts->name_line + " " + funcName + "();";
              antlrcpp::downCast<Func_declarationContext *>(_localctx)->info =  ParseInfo(antlrcpp::downCast<Func_declarationContext *>(_localctx)->sm->getLine(), code);
              writeIntoparserLogFile(code);
          
      break;
    }

    default:
      break;
    }
   
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }

  return _localctx;
}

//----------------- Func_definitionContext ------------------------------------------------------------------

C8086Parser::Func_definitionContext::Func_definitionContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

tree::TerminalNode* C8086Parser::Func_definitionContext::ID() {
  return getToken(C8086Parser::ID, 0);
}

tree::TerminalNode* C8086Parser::Func_definitionContext::LPAREN() {
  return getToken(C8086Parser::LPAREN, 0);
}

tree::TerminalNode* C8086Parser::Func_definitionContext::RPAREN() {
  return getToken(C8086Parser::RPAREN, 0);
}

C8086Parser::Type_specifierContext* C8086Parser::Func_definitionContext::type_specifier() {
  return getRuleContext<C8086Parser::Type_specifierContext>(0);
}

C8086Parser::Parameter_listContext* C8086Parser::Func_definitionContext::parameter_list() {
  return getRuleContext<C8086Parser::Parameter_listContext>(0);
}

C8086Parser::Compound_statementContext* C8086Parser::Func_definitionContext::compound_statement() {
  return getRuleContext<C8086Parser::Compound_statementContext>(0);
}


size_t C8086Parser::Func_definitionContext::getRuleIndex() const {
  return C8086Parser::RuleFunc_definition;
}

void C8086Parser::Func_definitionContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterFunc_definition(this);
}

void C8086Parser::Func_definitionContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitFunc_definition(this);
}

C8086Parser::Func_definitionContext* C8086Parser::func_definition() {
  Func_definitionContext *_localctx = _tracker.createInstance<Func_definitionContext>(_ctx, getState());
  enterRule(_localctx, 10, C8086Parser::RuleFunc_definition);

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    exitRule();
  });
  try {
    setState(123);
    _errHandler->sync(this);
    switch (getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 3, _ctx)) {
    case 1: {
      enterOuterAlt(_localctx, 1);
      setState(107);
      antlrcpp::downCast<Func_definitionContext *>(_localctx)->ts = type_specifier();
      setState(108);
      antlrcpp::downCast<Func_definitionContext *>(_localctx)->idToken = match(C8086Parser::ID);
      setState(109);
      match(C8086Parser::LPAREN);
      setState(110);
      antlrcpp::downCast<Func_definitionContext *>(_localctx)->pl = parameter_list(0);
      setState(111);
      match(C8086Parser::RPAREN);
       
              // First check if function already declared
              std::string funcName = antlrcpp::downCast<Func_definitionContext *>(_localctx)->idToken->getText();
              std::string funcType = "FUNCTION," + antlrcpp::downCast<Func_definitionContext *>(_localctx)->ts->name_line + "<==(" + antlrcpp::downCast<Func_definitionContext *>(_localctx)->pl->param_string + ")>";
              SymbolInfo* existing = ST->LookUp(funcName);
              
              // Insert function in global scope if not exists
              if (!existing) {
                  ST->Insert(funcName, funcType);
              }
              
              // Enter function scope and insert parameters
              ST->enterScope();
              std::stringstream ss(antlrcpp::downCast<Func_definitionContext *>(_localctx)->pl->param_string);
              std::string param;
              while (std::getline(ss, param, ',')) {
                  std::stringstream ps(param);
                  std::string type, name;
                  ps >> type >> name;
                  if (!name.empty()) {
                      // Insert parameter with ACTUAL TYPE, not "ID"
                      if (!ST->Insert(name, type)) {  // type is already "int", "float", etc.
                          logError(antlrcpp::downCast<Func_definitionContext *>(_localctx)->ts->line_number, "Multiple declaration of parameter " + name);
                          syntaxErrorCount++;
                      }
                  }
              }
            
      setState(113);
      antlrcpp::downCast<Func_definitionContext *>(_localctx)->cs = compound_statement();

              
              _localctx->info.line_number = antlrcpp::downCast<Func_definitionContext *>(_localctx)->ts->line_number;
              // std::string funcName = antlrcpp::downCast<Func_definitionContext *>(_localctx)->idToken->getText();
              // std::string funcType = "FUNCTION," + antlrcpp::downCast<Func_definitionContext *>(_localctx)->ts->name_line + "<==(" + antlrcpp::downCast<Func_definitionContext *>(_localctx)->pl->param_string + ")>";
              // SymbolInfo* existing = ST->LookUp(funcName);
              if (existing) {
                  if (!existing->isFunctionSymbol()) {
                      logError(antlrcpp::downCast<Func_definitionContext *>(_localctx)->ts->line_number, funcName + " was not declared as a function");
                      syntaxErrorCount++;
                  } else {
                      // Check return type and parameters compatibility
                      std::string existingType = existing->getOriginalType();
                      if (existingType != funcType) {
                          logError(antlrcpp::downCast<Func_definitionContext *>(_localctx)->ts->line_number, "Function definition doesn't match declaration for " + funcName);
                          syntaxErrorCount++;
                      }
                  }
              }
              
              std::string code = antlrcpp::downCast<Func_definitionContext *>(_localctx)->ts->name_line + " " + funcName + "(" + antlrcpp::downCast<Func_definitionContext *>(_localctx)->pl->param_string + ")" + antlrcpp::downCast<Func_definitionContext *>(_localctx)->cs->code_string;
              logLine(antlrcpp::downCast<Func_definitionContext *>(_localctx)->ts->line_number, "func_definition : type_specifier ID LPAREN parameter_list RPAREN compound_statement");
              writeIntoparserLogFile(code);
              // ST->printAllScopeTable(parserLogFile);  
              antlrcpp::downCast<Func_definitionContext *>(_localctx)->info =  ParseInfo(antlrcpp::downCast<Func_definitionContext *>(_localctx)->ts->line_number, code);
              ST->exitScope();
          
      break;
    }

    case 2: {
      enterOuterAlt(_localctx, 2);
      setState(116);
      antlrcpp::downCast<Func_definitionContext *>(_localctx)->ts = type_specifier();
      setState(117);
      antlrcpp::downCast<Func_definitionContext *>(_localctx)->idToken = match(C8086Parser::ID);
      setState(118);
      match(C8086Parser::LPAREN);
      setState(119);
      match(C8086Parser::RPAREN);
      setState(120);
      antlrcpp::downCast<Func_definitionContext *>(_localctx)->cs = compound_statement();

              _localctx->info.line_number = antlrcpp::downCast<Func_definitionContext *>(_localctx)->ts->line_number;
              std::string funcName = antlrcpp::downCast<Func_definitionContext *>(_localctx)->idToken->getText();
              std::string funcType = "FUNCTION," + antlrcpp::downCast<Func_definitionContext *>(_localctx)->ts->name_line + "<==()>";
              SymbolInfo* existing = ST->LookUp(funcName);
              if (existing) {
                  if (!existing->isFunctionSymbol()) {
                      // logError(antlrcpp::downCast<Func_definitionContext *>(_localctx)->ts->line_number, funcName + " was not declared as a function");
                      // syntaxErrorCount++;
                  } else if (existing->getReturnType() != antlrcpp::downCast<Func_definitionContext *>(_localctx)->ts->name_line) {
                      logError(antlrcpp::downCast<Func_definitionContext *>(_localctx)->ts->line_number, "Return type mismatch for function " + funcName);
                      syntaxErrorCount++;
                  }
              } else {
                  ST->Insert(funcName, funcType);
              }
              
              std::string code = antlrcpp::downCast<Func_definitionContext *>(_localctx)->ts->name_line + " " + funcName + "()" + antlrcpp::downCast<Func_definitionContext *>(_localctx)->cs->code_string;
              logLine(antlrcpp::downCast<Func_definitionContext *>(_localctx)->ts->line_number, "func_definition : type_specifier ID LPAREN RPAREN compound_statement");
              writeIntoparserLogFile(code);
              ST->printAllScopeTable(parserLogFile);
              antlrcpp::downCast<Func_definitionContext *>(_localctx)->info =  ParseInfo(antlrcpp::downCast<Func_definitionContext *>(_localctx)->ts->line_number, code);
          
      break;
    }

    default:
      break;
    }
   
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }

  return _localctx;
}

//----------------- Parameter_listContext ------------------------------------------------------------------

C8086Parser::Parameter_listContext::Parameter_listContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

tree::TerminalNode* C8086Parser::Parameter_listContext::ID() {
  return getToken(C8086Parser::ID, 0);
}

C8086Parser::Type_specifierContext* C8086Parser::Parameter_listContext::type_specifier() {
  return getRuleContext<C8086Parser::Type_specifierContext>(0);
}

tree::TerminalNode* C8086Parser::Parameter_listContext::COMMA() {
  return getToken(C8086Parser::COMMA, 0);
}

C8086Parser::Parameter_listContext* C8086Parser::Parameter_listContext::parameter_list() {
  return getRuleContext<C8086Parser::Parameter_listContext>(0);
}


size_t C8086Parser::Parameter_listContext::getRuleIndex() const {
  return C8086Parser::RuleParameter_list;
}

void C8086Parser::Parameter_listContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterParameter_list(this);
}

void C8086Parser::Parameter_listContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitParameter_list(this);
}


C8086Parser::Parameter_listContext* C8086Parser::parameter_list() {
   return parameter_list(0);
}

C8086Parser::Parameter_listContext* C8086Parser::parameter_list(int precedence) {
  ParserRuleContext *parentContext = _ctx;
  size_t parentState = getState();
  C8086Parser::Parameter_listContext *_localctx = _tracker.createInstance<Parameter_listContext>(_ctx, parentState);
  C8086Parser::Parameter_listContext *previousContext = _localctx;
  (void)previousContext; // Silence compiler, in case the context is not used by generated code.
  size_t startState = 12;
  enterRecursionRule(_localctx, 12, C8086Parser::RuleParameter_list, precedence);

    

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    unrollRecursionContexts(parentContext);
  });
  try {
    size_t alt;
    enterOuterAlt(_localctx, 1);
    setState(133);
    _errHandler->sync(this);
    switch (getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 4, _ctx)) {
    case 1: {
      setState(126);
      antlrcpp::downCast<Parameter_listContext *>(_localctx)->ts = type_specifier();
      setState(127);
      antlrcpp::downCast<Parameter_listContext *>(_localctx)->idToken = match(C8086Parser::ID);

              antlrcpp::downCast<Parameter_listContext *>(_localctx)->param_string =  antlrcpp::downCast<Parameter_listContext *>(_localctx)->ts->name_line + " " + antlrcpp::downCast<Parameter_listContext *>(_localctx)->idToken->getText();
              logLine(antlrcpp::downCast<Parameter_listContext *>(_localctx)->idToken->getLine(), "parameter_list : type_specifier ID");
              writeIntoparserLogFile(_localctx->param_string);
          
      break;
    }

    case 2: {
      setState(130);
      antlrcpp::downCast<Parameter_listContext *>(_localctx)->ts = type_specifier();

              antlrcpp::downCast<Parameter_listContext *>(_localctx)->param_string =  antlrcpp::downCast<Parameter_listContext *>(_localctx)->ts->name_line;
              logLine(antlrcpp::downCast<Parameter_listContext *>(_localctx)->ts->line_number, "parameter_list : type_specifier");
              writeIntoparserLogFile(_localctx->param_string);
          
      break;
    }

    default:
      break;
    }
    _ctx->stop = _input->LT(-1);
    setState(148);
    _errHandler->sync(this);
    alt = getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 6, _ctx);
    while (alt != 2 && alt != atn::ATN::INVALID_ALT_NUMBER) {
      if (alt == 1) {
        if (!_parseListeners.empty())
          triggerExitRuleEvent();
        previousContext = _localctx;
        setState(146);
        _errHandler->sync(this);
        switch (getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 5, _ctx)) {
        case 1: {
          _localctx = _tracker.createInstance<Parameter_listContext>(parentContext, parentState);
          _localctx->pl = previousContext;
          pushNewRecursionContext(_localctx, startState, RuleParameter_list);
          setState(135);

          if (!(precpred(_ctx, 4))) throw FailedPredicateException(this, "precpred(_ctx, 4)");
          setState(136);
          match(C8086Parser::COMMA);
          setState(137);
          antlrcpp::downCast<Parameter_listContext *>(_localctx)->ts = type_specifier();
          setState(138);
          antlrcpp::downCast<Parameter_listContext *>(_localctx)->idToken = match(C8086Parser::ID);

                            antlrcpp::downCast<Parameter_listContext *>(_localctx)->param_string =  antlrcpp::downCast<Parameter_listContext *>(_localctx)->pl->param_string + "," + antlrcpp::downCast<Parameter_listContext *>(_localctx)->ts->name_line + " " + antlrcpp::downCast<Parameter_listContext *>(_localctx)->idToken->getText();
                            logLine(antlrcpp::downCast<Parameter_listContext *>(_localctx)->idToken->getLine(), "parameter_list : parameter_list COMMA type_specifier ID");
                            writeIntoparserLogFile(_localctx->param_string);
                        
          break;
        }

        case 2: {
          _localctx = _tracker.createInstance<Parameter_listContext>(parentContext, parentState);
          _localctx->pl = previousContext;
          pushNewRecursionContext(_localctx, startState, RuleParameter_list);
          setState(141);

          if (!(precpred(_ctx, 3))) throw FailedPredicateException(this, "precpred(_ctx, 3)");
          setState(142);
          match(C8086Parser::COMMA);
          setState(143);
          antlrcpp::downCast<Parameter_listContext *>(_localctx)->ts = type_specifier();

                            antlrcpp::downCast<Parameter_listContext *>(_localctx)->param_string =  antlrcpp::downCast<Parameter_listContext *>(_localctx)->pl->param_string + "," + antlrcpp::downCast<Parameter_listContext *>(_localctx)->ts->name_line;
                            logLine(antlrcpp::downCast<Parameter_listContext *>(_localctx)->ts->line_number, "parameter_list : parameter_list COMMA type_specifier");
                            writeIntoparserLogFile(_localctx->param_string);
                        
          break;
        }

        default:
          break;
        } 
      }
      setState(150);
      _errHandler->sync(this);
      alt = getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 6, _ctx);
    }
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }
  return _localctx;
}

//----------------- Compound_statementContext ------------------------------------------------------------------

C8086Parser::Compound_statementContext::Compound_statementContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

tree::TerminalNode* C8086Parser::Compound_statementContext::LCURL() {
  return getToken(C8086Parser::LCURL, 0);
}

tree::TerminalNode* C8086Parser::Compound_statementContext::RCURL() {
  return getToken(C8086Parser::RCURL, 0);
}

C8086Parser::StatementsContext* C8086Parser::Compound_statementContext::statements() {
  return getRuleContext<C8086Parser::StatementsContext>(0);
}


size_t C8086Parser::Compound_statementContext::getRuleIndex() const {
  return C8086Parser::RuleCompound_statement;
}

void C8086Parser::Compound_statementContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterCompound_statement(this);
}

void C8086Parser::Compound_statementContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitCompound_statement(this);
}

C8086Parser::Compound_statementContext* C8086Parser::compound_statement() {
  Compound_statementContext *_localctx = _tracker.createInstance<Compound_statementContext>(_ctx, getState());
  enterRule(_localctx, 14, C8086Parser::RuleCompound_statement);

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    exitRule();
  });
  try {
    setState(161);
    _errHandler->sync(this);
    switch (getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 7, _ctx)) {
    case 1: {
      enterOuterAlt(_localctx, 1);
      setState(151);
      antlrcpp::downCast<Compound_statementContext *>(_localctx)->lcurlToken = match(C8086Parser::LCURL);

              ST->enterScope(); // Create new scope
          
      setState(153);
      antlrcpp::downCast<Compound_statementContext *>(_localctx)->st = statements(0);
      setState(154);
      antlrcpp::downCast<Compound_statementContext *>(_localctx)->rcurlToken = match(C8086Parser::RCURL);

              antlrcpp::downCast<Compound_statementContext *>(_localctx)->code_string =  "{\n" + antlrcpp::downCast<Compound_statementContext *>(_localctx)->st->statements_string + "\n}";
              antlrcpp::downCast<Compound_statementContext *>(_localctx)->line_number =  antlrcpp::downCast<Compound_statementContext *>(_localctx)->lcurlToken->getLine();
              logLine(antlrcpp::downCast<Compound_statementContext *>(_localctx)->rcurlToken->getLine(), "compound_statement : LCURL statements RCURL");
              writeIntoparserLogFile(_localctx->code_string);
              ST->printAllScopeTable(parserLogFile); // Print symbol table before exiting scope
              ST->exitScope(); // Remove scope
          
      break;
    }

    case 2: {
      enterOuterAlt(_localctx, 2);
      setState(157);
      antlrcpp::downCast<Compound_statementContext *>(_localctx)->lcurlToken = match(C8086Parser::LCURL);

              ST->enterScope(); // Create new scope
          
      setState(159);
      antlrcpp::downCast<Compound_statementContext *>(_localctx)->rcurlToken = match(C8086Parser::RCURL);

              antlrcpp::downCast<Compound_statementContext *>(_localctx)->code_string =  "{\n}";
              antlrcpp::downCast<Compound_statementContext *>(_localctx)->line_number =  antlrcpp::downCast<Compound_statementContext *>(_localctx)->lcurlToken->getLine();
              logLine(antlrcpp::downCast<Compound_statementContext *>(_localctx)->rcurlToken->getLine(), "compound_statement : LCURL RCURL");
              writeIntoparserLogFile(_localctx->code_string);
              ST->printAllScopeTable(parserLogFile); // Print symbol table before exiting scope
              ST->exitScope(); // Remove scope
          
      break;
    }

    default:
      break;
    }
   
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }

  return _localctx;
}

//----------------- Var_declarationContext ------------------------------------------------------------------

C8086Parser::Var_declarationContext::Var_declarationContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

C8086Parser::Type_specifierContext* C8086Parser::Var_declarationContext::type_specifier() {
  return getRuleContext<C8086Parser::Type_specifierContext>(0);
}

C8086Parser::Declaration_listContext* C8086Parser::Var_declarationContext::declaration_list() {
  return getRuleContext<C8086Parser::Declaration_listContext>(0);
}

tree::TerminalNode* C8086Parser::Var_declarationContext::SEMICOLON() {
  return getToken(C8086Parser::SEMICOLON, 0);
}

C8086Parser::Declaration_list_errContext* C8086Parser::Var_declarationContext::declaration_list_err() {
  return getRuleContext<C8086Parser::Declaration_list_errContext>(0);
}


size_t C8086Parser::Var_declarationContext::getRuleIndex() const {
  return C8086Parser::RuleVar_declaration;
}

void C8086Parser::Var_declarationContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterVar_declaration(this);
}

void C8086Parser::Var_declarationContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitVar_declaration(this);
}

C8086Parser::Var_declarationContext* C8086Parser::var_declaration() {
  Var_declarationContext *_localctx = _tracker.createInstance<Var_declarationContext>(_ctx, getState());
  enterRule(_localctx, 16, C8086Parser::RuleVar_declaration);

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    exitRule();
  });
  try {
    setState(173);
    _errHandler->sync(this);
    switch (getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 8, _ctx)) {
    case 1: {
      enterOuterAlt(_localctx, 1);
      setState(163);
      antlrcpp::downCast<Var_declarationContext *>(_localctx)->t = type_specifier();
      setState(164);
      antlrcpp::downCast<Var_declarationContext *>(_localctx)->dl = declaration_list(0);
      setState(165);
      antlrcpp::downCast<Var_declarationContext *>(_localctx)->sm = match(C8086Parser::SEMICOLON);

              int line = antlrcpp::downCast<Var_declarationContext *>(_localctx)->sm->getLine();
              std::string code = antlrcpp::downCast<Var_declarationContext *>(_localctx)->t->name_line + " " + antlrcpp::downCast<Var_declarationContext *>(_localctx)->dl->var_list.get_list_as_string() + ";";
              // Insert variables into symbol table with ACTUAL TYPE
              for (const auto& var : antlrcpp::downCast<Var_declarationContext *>(_localctx)->dl->var_list.get_variables()) {
                  std::string varType;
                  std::string varName;
                  
                  if (var.find('[') != std::string::npos) {
                      // Array variable
                      varName = var.substr(0, var.find('['));
                      varType = "ARRAY," + antlrcpp::downCast<Var_declarationContext *>(_localctx)->t->name_line;  // Store actual type: ARRAY,int or ARRAY,float
                  } else {
                      // Regular variable
                      varName = var;
                      varType = antlrcpp::downCast<Var_declarationContext *>(_localctx)->t->name_line;  // Store actual type: int, float, void ,struct id,
                  }
                  
                  if (!ST->Insert(varName, varType)) {
                      writeIntoErrorFile("Line " + std::to_string(line) + ": Multiple declaration of " + varName);
                      syntaxErrorCount++;
                  }
              }
              logLine(line, "var_declaration : type_specifier declaration_list SEMICOLON");
              writeIntoparserLogFile(code);
              antlrcpp::downCast<Var_declarationContext *>(_localctx)->info =  ParseInfo(line, code);
          
      break;
    }

    case 2: {
      enterOuterAlt(_localctx, 2);
      setState(168);
      antlrcpp::downCast<Var_declarationContext *>(_localctx)->t = type_specifier();
      setState(169);
      antlrcpp::downCast<Var_declarationContext *>(_localctx)->de = declaration_list_err();
      setState(170);
      antlrcpp::downCast<Var_declarationContext *>(_localctx)->sm = match(C8086Parser::SEMICOLON);

              writeIntoErrorFile(
                  std::string("Line ") + std::to_string(antlrcpp::downCast<Var_declarationContext *>(_localctx)->sm->getLine()) +
                  ": " + antlrcpp::downCast<Var_declarationContext *>(_localctx)->de->error_name + " - Syntax error at declaration list of variable declaration"
              );
              syntaxErrorCount++;
          
      break;
    }

    default:
      break;
    }
   
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }

  return _localctx;
}

//----------------- Declaration_list_errContext ------------------------------------------------------------------

C8086Parser::Declaration_list_errContext::Declaration_list_errContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}


size_t C8086Parser::Declaration_list_errContext::getRuleIndex() const {
  return C8086Parser::RuleDeclaration_list_err;
}

void C8086Parser::Declaration_list_errContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterDeclaration_list_err(this);
}

void C8086Parser::Declaration_list_errContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitDeclaration_list_err(this);
}

C8086Parser::Declaration_list_errContext* C8086Parser::declaration_list_err() {
  Declaration_list_errContext *_localctx = _tracker.createInstance<Declaration_list_errContext>(_ctx, getState());
  enterRule(_localctx, 18, C8086Parser::RuleDeclaration_list_err);

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    exitRule();
  });
  try {
    enterOuterAlt(_localctx, 1);

            antlrcpp::downCast<Declaration_list_errContext *>(_localctx)->error_name =  "Error in declaration list";
        
   
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }

  return _localctx;
}

//----------------- Type_specifierContext ------------------------------------------------------------------

C8086Parser::Type_specifierContext::Type_specifierContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

tree::TerminalNode* C8086Parser::Type_specifierContext::INT() {
  return getToken(C8086Parser::INT, 0);
}

tree::TerminalNode* C8086Parser::Type_specifierContext::FLOAT() {
  return getToken(C8086Parser::FLOAT, 0);
}

tree::TerminalNode* C8086Parser::Type_specifierContext::VOID() {
  return getToken(C8086Parser::VOID, 0);
}

tree::TerminalNode* C8086Parser::Type_specifierContext::STRUCT() {
  return getToken(C8086Parser::STRUCT, 0);
}

tree::TerminalNode* C8086Parser::Type_specifierContext::ID() {
  return getToken(C8086Parser::ID, 0);
}


size_t C8086Parser::Type_specifierContext::getRuleIndex() const {
  return C8086Parser::RuleType_specifier;
}

void C8086Parser::Type_specifierContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterType_specifier(this);
}

void C8086Parser::Type_specifierContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitType_specifier(this);
}

C8086Parser::Type_specifierContext* C8086Parser::type_specifier() {
  Type_specifierContext *_localctx = _tracker.createInstance<Type_specifierContext>(_ctx, getState());
  enterRule(_localctx, 20, C8086Parser::RuleType_specifier);

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    exitRule();
  });
  try {
    setState(186);
    _errHandler->sync(this);
    switch (_input->LA(1)) {
      case C8086Parser::INT: {
        enterOuterAlt(_localctx, 1);
        setState(177);
        antlrcpp::downCast<Type_specifierContext *>(_localctx)->intToken = match(C8086Parser::INT);

                antlrcpp::downCast<Type_specifierContext *>(_localctx)->name_line =  antlrcpp::downCast<Type_specifierContext *>(_localctx)->intToken->getText();
                antlrcpp::downCast<Type_specifierContext *>(_localctx)->line_number =  antlrcpp::downCast<Type_specifierContext *>(_localctx)->intToken->getLine();
                logLine(antlrcpp::downCast<Type_specifierContext *>(_localctx)->intToken->getLine(), "type_specifier : INT");
                writeIntoparserLogFile(antlrcpp::downCast<Type_specifierContext *>(_localctx)->intToken->getText());
            
        break;
      }

      case C8086Parser::FLOAT: {
        enterOuterAlt(_localctx, 2);
        setState(179);
        antlrcpp::downCast<Type_specifierContext *>(_localctx)->floatToken = match(C8086Parser::FLOAT);

                antlrcpp::downCast<Type_specifierContext *>(_localctx)->name_line =  antlrcpp::downCast<Type_specifierContext *>(_localctx)->floatToken->getText();
                antlrcpp::downCast<Type_specifierContext *>(_localctx)->line_number =  antlrcpp::downCast<Type_specifierContext *>(_localctx)->floatToken->getLine();
                logLine(antlrcpp::downCast<Type_specifierContext *>(_localctx)->floatToken->getLine(), "type_specifier : FLOAT");
                writeIntoparserLogFile(antlrcpp::downCast<Type_specifierContext *>(_localctx)->floatToken->getText());
            
        break;
      }

      case C8086Parser::VOID: {
        enterOuterAlt(_localctx, 3);
        setState(181);
        antlrcpp::downCast<Type_specifierContext *>(_localctx)->voidToken = match(C8086Parser::VOID);

                antlrcpp::downCast<Type_specifierContext *>(_localctx)->name_line =  antlrcpp::downCast<Type_specifierContext *>(_localctx)->voidToken->getText();
                antlrcpp::downCast<Type_specifierContext *>(_localctx)->line_number =  antlrcpp::downCast<Type_specifierContext *>(_localctx)->voidToken->getLine();
                logLine(antlrcpp::downCast<Type_specifierContext *>(_localctx)->voidToken->getLine(), "type_specifier : VOID");
                writeIntoparserLogFile(antlrcpp::downCast<Type_specifierContext *>(_localctx)->voidToken->getText());
            
        break;
      }

      case C8086Parser::STRUCT: {
        enterOuterAlt(_localctx, 4);
        setState(183);
        antlrcpp::downCast<Type_specifierContext *>(_localctx)->structToken = match(C8086Parser::STRUCT);
        setState(184);
        antlrcpp::downCast<Type_specifierContext *>(_localctx)->idToken = match(C8086Parser::ID);

                antlrcpp::downCast<Type_specifierContext *>(_localctx)->name_line =  antlrcpp::downCast<Type_specifierContext *>(_localctx)->structToken->getText()+" "+ antlrcpp::downCast<Type_specifierContext *>(_localctx)->idToken->getText();
                antlrcpp::downCast<Type_specifierContext *>(_localctx)->line_number =  antlrcpp::downCast<Type_specifierContext *>(_localctx)->structToken->getLine();
                logLine(antlrcpp::downCast<Type_specifierContext *>(_localctx)->structToken->getLine(),"type_specifier : STRUCT");
                writeIntoparserLogFile(antlrcpp::downCast<Type_specifierContext *>(_localctx)->structToken->getText()+" "+ antlrcpp::downCast<Type_specifierContext *>(_localctx)->idToken->getText());
            
        break;
      }

    default:
      throw NoViableAltException(this);
    }
   
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }

  return _localctx;
}

//----------------- Declaration_listContext ------------------------------------------------------------------

C8086Parser::Declaration_listContext::Declaration_listContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

tree::TerminalNode* C8086Parser::Declaration_listContext::ID() {
  return getToken(C8086Parser::ID, 0);
}

tree::TerminalNode* C8086Parser::Declaration_listContext::LTHIRD() {
  return getToken(C8086Parser::LTHIRD, 0);
}

tree::TerminalNode* C8086Parser::Declaration_listContext::CONST_INT() {
  return getToken(C8086Parser::CONST_INT, 0);
}

tree::TerminalNode* C8086Parser::Declaration_listContext::RTHIRD() {
  return getToken(C8086Parser::RTHIRD, 0);
}

tree::TerminalNode* C8086Parser::Declaration_listContext::COMMA() {
  return getToken(C8086Parser::COMMA, 0);
}

C8086Parser::Declaration_listContext* C8086Parser::Declaration_listContext::declaration_list() {
  return getRuleContext<C8086Parser::Declaration_listContext>(0);
}


size_t C8086Parser::Declaration_listContext::getRuleIndex() const {
  return C8086Parser::RuleDeclaration_list;
}

void C8086Parser::Declaration_listContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterDeclaration_list(this);
}

void C8086Parser::Declaration_listContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitDeclaration_list(this);
}


C8086Parser::Declaration_listContext* C8086Parser::declaration_list() {
   return declaration_list(0);
}

C8086Parser::Declaration_listContext* C8086Parser::declaration_list(int precedence) {
  ParserRuleContext *parentContext = _ctx;
  size_t parentState = getState();
  C8086Parser::Declaration_listContext *_localctx = _tracker.createInstance<Declaration_listContext>(_ctx, parentState);
  C8086Parser::Declaration_listContext *previousContext = _localctx;
  (void)previousContext; // Silence compiler, in case the context is not used by generated code.
  size_t startState = 22;
  enterRecursionRule(_localctx, 22, C8086Parser::RuleDeclaration_list, precedence);

    

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    unrollRecursionContexts(parentContext);
  });
  try {
    size_t alt;
    enterOuterAlt(_localctx, 1);
    setState(196);
    _errHandler->sync(this);
    switch (getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 10, _ctx)) {
    case 1: {
      setState(189);
      antlrcpp::downCast<Declaration_listContext *>(_localctx)->idToken = match(C8086Parser::ID);

              logLine(antlrcpp::downCast<Declaration_listContext *>(_localctx)->idToken->getLine(), "declaration_list : ID");
              _localctx->var_list.add(antlrcpp::downCast<Declaration_listContext *>(_localctx)->idToken->getText());
              writeIntoparserLogFile(antlrcpp::downCast<Declaration_listContext *>(_localctx)->idToken->getText());
          
      break;
    }

    case 2: {
      setState(191);
      antlrcpp::downCast<Declaration_listContext *>(_localctx)->idToken = match(C8086Parser::ID);
      setState(192);
      match(C8086Parser::LTHIRD);
      setState(193);
      antlrcpp::downCast<Declaration_listContext *>(_localctx)->const_intToken = match(C8086Parser::CONST_INT);
      setState(194);
      match(C8086Parser::RTHIRD);

              logLine(antlrcpp::downCast<Declaration_listContext *>(_localctx)->idToken->getLine(), "declaration_list : ID LTHIRD CONST_INT RTHIRD");
              _localctx->var_list.add(antlrcpp::downCast<Declaration_listContext *>(_localctx)->idToken->getText() + "[" + antlrcpp::downCast<Declaration_listContext *>(_localctx)->const_intToken->getText() + "]");
              writeIntoparserLogFile(antlrcpp::downCast<Declaration_listContext *>(_localctx)->idToken->getText() + "[" + antlrcpp::downCast<Declaration_listContext *>(_localctx)->const_intToken->getText() + "]");
          
      break;
    }

    default:
      break;
    }
    _ctx->stop = _input->LT(-1);
    setState(211);
    _errHandler->sync(this);
    alt = getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 12, _ctx);
    while (alt != 2 && alt != atn::ATN::INVALID_ALT_NUMBER) {
      if (alt == 1) {
        if (!_parseListeners.empty())
          triggerExitRuleEvent();
        previousContext = _localctx;
        setState(209);
        _errHandler->sync(this);
        switch (getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 11, _ctx)) {
        case 1: {
          _localctx = _tracker.createInstance<Declaration_listContext>(parentContext, parentState);
          _localctx->dl = previousContext;
          pushNewRecursionContext(_localctx, startState, RuleDeclaration_list);
          setState(198);

          if (!(precpred(_ctx, 4))) throw FailedPredicateException(this, "precpred(_ctx, 4)");
          setState(199);
          match(C8086Parser::COMMA);
          setState(200);
          antlrcpp::downCast<Declaration_listContext *>(_localctx)->idToken = match(C8086Parser::ID);

                            _localctx->var_list.set_variables(antlrcpp::downCast<Declaration_listContext *>(_localctx)->dl->var_list.get_variables());
                            _localctx->var_list.add(antlrcpp::downCast<Declaration_listContext *>(_localctx)->idToken->getText());
                            logLine(antlrcpp::downCast<Declaration_listContext *>(_localctx)->idToken->getLine(), "declaration_list : declaration_list COMMA ID");
                            writeIntoparserLogFile(_localctx->var_list.get_list_as_string());
                        
          break;
        }

        case 2: {
          _localctx = _tracker.createInstance<Declaration_listContext>(parentContext, parentState);
          _localctx->dl = previousContext;
          pushNewRecursionContext(_localctx, startState, RuleDeclaration_list);
          setState(202);

          if (!(precpred(_ctx, 3))) throw FailedPredicateException(this, "precpred(_ctx, 3)");
          setState(203);
          match(C8086Parser::COMMA);
          setState(204);
          antlrcpp::downCast<Declaration_listContext *>(_localctx)->idToken = match(C8086Parser::ID);
          setState(205);
          match(C8086Parser::LTHIRD);
          setState(206);
          antlrcpp::downCast<Declaration_listContext *>(_localctx)->const_intToken = match(C8086Parser::CONST_INT);
          setState(207);
          match(C8086Parser::RTHIRD);

                            _localctx->var_list.set_variables(antlrcpp::downCast<Declaration_listContext *>(_localctx)->dl->var_list.get_variables());
                            _localctx->var_list.add(antlrcpp::downCast<Declaration_listContext *>(_localctx)->idToken->getText() + "[" + antlrcpp::downCast<Declaration_listContext *>(_localctx)->const_intToken->getText() + "]");
                            logLine(antlrcpp::downCast<Declaration_listContext *>(_localctx)->idToken->getLine(), "declaration_list : declaration_list COMMA ID LTHIRD CONST_INT RTHIRD");
                            writeIntoparserLogFile(_localctx->var_list.get_list_as_string());
                        
          break;
        }

        default:
          break;
        } 
      }
      setState(213);
      _errHandler->sync(this);
      alt = getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 12, _ctx);
    }
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }
  return _localctx;
}

//----------------- StatementsContext ------------------------------------------------------------------

C8086Parser::StatementsContext::StatementsContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

C8086Parser::StatementContext* C8086Parser::StatementsContext::statement() {
  return getRuleContext<C8086Parser::StatementContext>(0);
}

C8086Parser::StatementsContext* C8086Parser::StatementsContext::statements() {
  return getRuleContext<C8086Parser::StatementsContext>(0);
}


size_t C8086Parser::StatementsContext::getRuleIndex() const {
  return C8086Parser::RuleStatements;
}

void C8086Parser::StatementsContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterStatements(this);
}

void C8086Parser::StatementsContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitStatements(this);
}


C8086Parser::StatementsContext* C8086Parser::statements() {
   return statements(0);
}

C8086Parser::StatementsContext* C8086Parser::statements(int precedence) {
  ParserRuleContext *parentContext = _ctx;
  size_t parentState = getState();
  C8086Parser::StatementsContext *_localctx = _tracker.createInstance<StatementsContext>(_ctx, parentState);
  C8086Parser::StatementsContext *previousContext = _localctx;
  (void)previousContext; // Silence compiler, in case the context is not used by generated code.
  size_t startState = 24;
  enterRecursionRule(_localctx, 24, C8086Parser::RuleStatements, precedence);

    

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    unrollRecursionContexts(parentContext);
  });
  try {
    size_t alt;
    enterOuterAlt(_localctx, 1);
    setState(215);
    antlrcpp::downCast<StatementsContext *>(_localctx)->st = statement();

            antlrcpp::downCast<StatementsContext *>(_localctx)->statements_string =  antlrcpp::downCast<StatementsContext *>(_localctx)->st->statement_string;
            logLine(antlrcpp::downCast<StatementsContext *>(_localctx)->st->line_number, "statements : statement");
            writeIntoparserLogFile(_localctx->statements_string);

            // writeIntoErrorFile(error);
            if(doDepth == 0){
                if(antlrcpp::downCast<StatementsContext *>(_localctx)->st->statement_string.find("break")==0){
                    writeIntoErrorFile("Error break outside loop");
                }
                else if(antlrcpp::downCast<StatementsContext *>(_localctx)->st->statement_string.find("continue")==0){
                    writeIntoErrorFile("Error continue outside loop");
                }
            }
        
    _ctx->stop = _input->LT(-1);
    setState(224);
    _errHandler->sync(this);
    alt = getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 13, _ctx);
    while (alt != 2 && alt != atn::ATN::INVALID_ALT_NUMBER) {
      if (alt == 1) {
        if (!_parseListeners.empty())
          triggerExitRuleEvent();
        previousContext = _localctx;
        _localctx = _tracker.createInstance<StatementsContext>(parentContext, parentState);
        _localctx->sts = previousContext;
        pushNewRecursionContext(_localctx, startState, RuleStatements);
        setState(218);

        if (!(precpred(_ctx, 1))) throw FailedPredicateException(this, "precpred(_ctx, 1)");
        setState(219);
        antlrcpp::downCast<StatementsContext *>(_localctx)->st = statement();

                          antlrcpp::downCast<StatementsContext *>(_localctx)->statements_string =  antlrcpp::downCast<StatementsContext *>(_localctx)->sts->statements_string + "\n" + antlrcpp::downCast<StatementsContext *>(_localctx)->st->statement_string;
                          logLine(antlrcpp::downCast<StatementsContext *>(_localctx)->st->line_number, "statements : statements statement");
                          writeIntoparserLogFile(_localctx->statements_string);
                          if(doDepth == 0){
                              if(antlrcpp::downCast<StatementsContext *>(_localctx)->st->statement_string.find("break")==0){
                                  writeIntoErrorFile("Error break outside loop");
                              }
                              else if(antlrcpp::downCast<StatementsContext *>(_localctx)->st->statement_string.find("continue")==0){
                                  writeIntoErrorFile("Error continue outside loop");
                              }
                          }
                       
      }
      setState(226);
      _errHandler->sync(this);
      alt = getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 13, _ctx);
    }
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }
  return _localctx;
}

//----------------- StatementContext ------------------------------------------------------------------

C8086Parser::StatementContext::StatementContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

C8086Parser::Var_declarationContext* C8086Parser::StatementContext::var_declaration() {
  return getRuleContext<C8086Parser::Var_declarationContext>(0);
}

std::vector<C8086Parser::Expression_statementContext *> C8086Parser::StatementContext::expression_statement() {
  return getRuleContexts<C8086Parser::Expression_statementContext>();
}

C8086Parser::Expression_statementContext* C8086Parser::StatementContext::expression_statement(size_t i) {
  return getRuleContext<C8086Parser::Expression_statementContext>(i);
}

C8086Parser::Compound_statementContext* C8086Parser::StatementContext::compound_statement() {
  return getRuleContext<C8086Parser::Compound_statementContext>(0);
}

tree::TerminalNode* C8086Parser::StatementContext::FOR() {
  return getToken(C8086Parser::FOR, 0);
}

tree::TerminalNode* C8086Parser::StatementContext::LPAREN() {
  return getToken(C8086Parser::LPAREN, 0);
}

tree::TerminalNode* C8086Parser::StatementContext::RPAREN() {
  return getToken(C8086Parser::RPAREN, 0);
}

C8086Parser::ExpressionContext* C8086Parser::StatementContext::expression() {
  return getRuleContext<C8086Parser::ExpressionContext>(0);
}

std::vector<C8086Parser::StatementContext *> C8086Parser::StatementContext::statement() {
  return getRuleContexts<C8086Parser::StatementContext>();
}

C8086Parser::StatementContext* C8086Parser::StatementContext::statement(size_t i) {
  return getRuleContext<C8086Parser::StatementContext>(i);
}

tree::TerminalNode* C8086Parser::StatementContext::IF() {
  return getToken(C8086Parser::IF, 0);
}

tree::TerminalNode* C8086Parser::StatementContext::ELSE() {
  return getToken(C8086Parser::ELSE, 0);
}

tree::TerminalNode* C8086Parser::StatementContext::WHILE() {
  return getToken(C8086Parser::WHILE, 0);
}

tree::TerminalNode* C8086Parser::StatementContext::PRINTLN() {
  return getToken(C8086Parser::PRINTLN, 0);
}

tree::TerminalNode* C8086Parser::StatementContext::ID() {
  return getToken(C8086Parser::ID, 0);
}

tree::TerminalNode* C8086Parser::StatementContext::SEMICOLON() {
  return getToken(C8086Parser::SEMICOLON, 0);
}

tree::TerminalNode* C8086Parser::StatementContext::RETURN() {
  return getToken(C8086Parser::RETURN, 0);
}

tree::TerminalNode* C8086Parser::StatementContext::SWITCH() {
  return getToken(C8086Parser::SWITCH, 0);
}

tree::TerminalNode* C8086Parser::StatementContext::LCURL() {
  return getToken(C8086Parser::LCURL, 0);
}

tree::TerminalNode* C8086Parser::StatementContext::RCURL() {
  return getToken(C8086Parser::RCURL, 0);
}

C8086Parser::Switch_casesContext* C8086Parser::StatementContext::switch_cases() {
  return getRuleContext<C8086Parser::Switch_casesContext>(0);
}

tree::TerminalNode* C8086Parser::StatementContext::DO() {
  return getToken(C8086Parser::DO, 0);
}

tree::TerminalNode* C8086Parser::StatementContext::BREAK() {
  return getToken(C8086Parser::BREAK, 0);
}

tree::TerminalNode* C8086Parser::StatementContext::CONTINUE() {
  return getToken(C8086Parser::CONTINUE, 0);
}


size_t C8086Parser::StatementContext::getRuleIndex() const {
  return C8086Parser::RuleStatement;
}

void C8086Parser::StatementContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterStatement(this);
}

void C8086Parser::StatementContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitStatement(this);
}

C8086Parser::StatementContext* C8086Parser::statement() {
  StatementContext *_localctx = _tracker.createInstance<StatementContext>(_ctx, getState());
  enterRule(_localctx, 26, C8086Parser::RuleStatement);

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    exitRule();
  });
  try {
    setState(304);
    _errHandler->sync(this);
    switch (getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 14, _ctx)) {
    case 1: {
      enterOuterAlt(_localctx, 1);
      setState(227);
      antlrcpp::downCast<StatementContext *>(_localctx)->vd = var_declaration();

              antlrcpp::downCast<StatementContext *>(_localctx)->statement_string =  antlrcpp::downCast<StatementContext *>(_localctx)->vd->info.parsed_code;
              antlrcpp::downCast<StatementContext *>(_localctx)->line_number =  antlrcpp::downCast<StatementContext *>(_localctx)->vd->info.line_number;
              logLine(_localctx->line_number, "statement : var_declaration");
              writeIntoparserLogFile(_localctx->statement_string);
          
      break;
    }

    case 2: {
      enterOuterAlt(_localctx, 2);
      setState(230);
      antlrcpp::downCast<StatementContext *>(_localctx)->es = expression_statement();

              antlrcpp::downCast<StatementContext *>(_localctx)->statement_string =  antlrcpp::downCast<StatementContext *>(_localctx)->es->expr_string;
              antlrcpp::downCast<StatementContext *>(_localctx)->line_number =  antlrcpp::downCast<StatementContext *>(_localctx)->es->line_number;
              logLine(_localctx->line_number, "statement : expression_statement");
              writeIntoparserLogFile(_localctx->statement_string);
          
      break;
    }

    case 3: {
      enterOuterAlt(_localctx, 3);
      setState(233);
      antlrcpp::downCast<StatementContext *>(_localctx)->cs = compound_statement();

              antlrcpp::downCast<StatementContext *>(_localctx)->statement_string =  antlrcpp::downCast<StatementContext *>(_localctx)->cs->code_string;
              antlrcpp::downCast<StatementContext *>(_localctx)->line_number =  antlrcpp::downCast<StatementContext *>(_localctx)->cs->line_number;
              logLine(_localctx->line_number, "statement : compound_statement");
              writeIntoparserLogFile(_localctx->statement_string);
          
      break;
    }

    case 4: {
      enterOuterAlt(_localctx, 4);
      setState(236);
      antlrcpp::downCast<StatementContext *>(_localctx)->forToken = match(C8086Parser::FOR);
      setState(237);
      match(C8086Parser::LPAREN);
      setState(238);
      antlrcpp::downCast<StatementContext *>(_localctx)->es1 = expression_statement();
      setState(239);
      antlrcpp::downCast<StatementContext *>(_localctx)->es2 = expression_statement();
      setState(240);
      antlrcpp::downCast<StatementContext *>(_localctx)->e = expression();
      setState(241);
      match(C8086Parser::RPAREN);
      setState(242);
      antlrcpp::downCast<StatementContext *>(_localctx)->st = statement();

              antlrcpp::downCast<StatementContext *>(_localctx)->statement_string =  "for(" + antlrcpp::downCast<StatementContext *>(_localctx)->es1->expr_string + antlrcpp::downCast<StatementContext *>(_localctx)->es2->expr_string + antlrcpp::downCast<StatementContext *>(_localctx)->e->expr_string + ")" + antlrcpp::downCast<StatementContext *>(_localctx)->st->statement_string;
              antlrcpp::downCast<StatementContext *>(_localctx)->line_number =  antlrcpp::downCast<StatementContext *>(_localctx)->forToken->getLine();
              logLine(_localctx->line_number, "statement : FOR LPAREN expression_statement expression_statement expression RPAREN statement");
              writeIntoparserLogFile(_localctx->statement_string);
          
      break;
    }

    case 5: {
      enterOuterAlt(_localctx, 5);
      setState(245);
      antlrcpp::downCast<StatementContext *>(_localctx)->ifToken = match(C8086Parser::IF);
      setState(246);
      match(C8086Parser::LPAREN);
      setState(247);
      antlrcpp::downCast<StatementContext *>(_localctx)->e = expression();
      setState(248);
      match(C8086Parser::RPAREN);
      setState(249);
      antlrcpp::downCast<StatementContext *>(_localctx)->st = statement();

              antlrcpp::downCast<StatementContext *>(_localctx)->statement_string =  "if(" + antlrcpp::downCast<StatementContext *>(_localctx)->e->expr_string + ")" + antlrcpp::downCast<StatementContext *>(_localctx)->st->statement_string;
              antlrcpp::downCast<StatementContext *>(_localctx)->line_number =  antlrcpp::downCast<StatementContext *>(_localctx)->ifToken->getLine();
              logLine(_localctx->line_number, "statement : IF LPAREN expression RPAREN statement");
              writeIntoparserLogFile(_localctx->statement_string);
          
      break;
    }

    case 6: {
      enterOuterAlt(_localctx, 6);
      setState(252);
      antlrcpp::downCast<StatementContext *>(_localctx)->ifToken = match(C8086Parser::IF);
      setState(253);
      match(C8086Parser::LPAREN);
      setState(254);
      antlrcpp::downCast<StatementContext *>(_localctx)->e = expression();
      setState(255);
      match(C8086Parser::RPAREN);
      setState(256);
      antlrcpp::downCast<StatementContext *>(_localctx)->st1 = statement();
      setState(257);
      match(C8086Parser::ELSE);
      setState(258);
      antlrcpp::downCast<StatementContext *>(_localctx)->st2 = statement();

              antlrcpp::downCast<StatementContext *>(_localctx)->statement_string =  "if(" + antlrcpp::downCast<StatementContext *>(_localctx)->e->expr_string + ")" + antlrcpp::downCast<StatementContext *>(_localctx)->st1->statement_string + " else " + antlrcpp::downCast<StatementContext *>(_localctx)->st2->statement_string;
              antlrcpp::downCast<StatementContext *>(_localctx)->line_number =  antlrcpp::downCast<StatementContext *>(_localctx)->ifToken->getLine();
              logLine(_localctx->line_number, "statement : IF LPAREN expression RPAREN statement ELSE statement");
              writeIntoparserLogFile(_localctx->statement_string);
          
      break;
    }

    case 7: {
      enterOuterAlt(_localctx, 7);
      setState(261);
      antlrcpp::downCast<StatementContext *>(_localctx)->whileToken = match(C8086Parser::WHILE);
      setState(262);
      match(C8086Parser::LPAREN);
      setState(263);
      antlrcpp::downCast<StatementContext *>(_localctx)->e = expression();
      setState(264);
      match(C8086Parser::RPAREN);
      setState(265);
      antlrcpp::downCast<StatementContext *>(_localctx)->st = statement();

              antlrcpp::downCast<StatementContext *>(_localctx)->statement_string =  "while(" + antlrcpp::downCast<StatementContext *>(_localctx)->e->expr_string + ")" + antlrcpp::downCast<StatementContext *>(_localctx)->st->statement_string;
              antlrcpp::downCast<StatementContext *>(_localctx)->line_number =  antlrcpp::downCast<StatementContext *>(_localctx)->whileToken->getLine();
              logLine(_localctx->line_number, "statement : WHILE LPAREN expression RPAREN statement");
              writeIntoparserLogFile(_localctx->statement_string);
          
      break;
    }

    case 8: {
      enterOuterAlt(_localctx, 8);
      setState(268);
      antlrcpp::downCast<StatementContext *>(_localctx)->printlnToken = match(C8086Parser::PRINTLN);
      setState(269);
      match(C8086Parser::LPAREN);
      setState(270);
      antlrcpp::downCast<StatementContext *>(_localctx)->idToken = match(C8086Parser::ID);
      setState(271);
      match(C8086Parser::RPAREN);
      setState(272);
      match(C8086Parser::SEMICOLON);

              antlrcpp::downCast<StatementContext *>(_localctx)->statement_string =  "println(" + antlrcpp::downCast<StatementContext *>(_localctx)->idToken->getText() + ");";
              antlrcpp::downCast<StatementContext *>(_localctx)->line_number =  antlrcpp::downCast<StatementContext *>(_localctx)->printlnToken->getLine();
              if (!ST->LookUp(antlrcpp::downCast<StatementContext *>(_localctx)->idToken->getText())) {
                  writeIntoErrorFile("Line " + std::to_string(_localctx->line_number) + ": Undeclared variable " + antlrcpp::downCast<StatementContext *>(_localctx)->idToken->getText());
                  syntaxErrorCount++;
              }
              logLine(_localctx->line_number, "statement : PRINTLN LPAREN ID RPAREN SEMICOLON");
              writeIntoparserLogFile(_localctx->statement_string);
          
      break;
    }

    case 9: {
      enterOuterAlt(_localctx, 9);
      setState(274);
      antlrcpp::downCast<StatementContext *>(_localctx)->returnToken = match(C8086Parser::RETURN);
      setState(275);
      antlrcpp::downCast<StatementContext *>(_localctx)->e = expression();
      setState(276);
      match(C8086Parser::SEMICOLON);

              antlrcpp::downCast<StatementContext *>(_localctx)->statement_string =  "return " + antlrcpp::downCast<StatementContext *>(_localctx)->e->expr_string + ";";
              antlrcpp::downCast<StatementContext *>(_localctx)->line_number =  antlrcpp::downCast<StatementContext *>(_localctx)->returnToken->getLine();
              logLine(_localctx->line_number, "statement : RETURN expression SEMICOLON");
              writeIntoparserLogFile(_localctx->statement_string);
          
      break;
    }

    case 10: {
      enterOuterAlt(_localctx, 10);
      setState(279);
      antlrcpp::downCast<StatementContext *>(_localctx)->switchToken = match(C8086Parser::SWITCH);
      setState(280);
      match(C8086Parser::LPAREN);
      setState(281);
      antlrcpp::downCast<StatementContext *>(_localctx)->expressionContext = expression();
      setState(282);
      match(C8086Parser::RPAREN);
      setState(283);
      match(C8086Parser::LCURL);
      setState(284);
      antlrcpp::downCast<StatementContext *>(_localctx)->sc = switch_cases(0);
      setState(285);
      match(C8086Parser::RCURL);
       
              antlrcpp::downCast<StatementContext *>(_localctx)->statement_string =  "switch(" + antlrcpp::downCast<StatementContext *>(_localctx)->expressionContext->expr_string + ") {\n" + antlrcpp::downCast<StatementContext *>(_localctx)->sc->info.parsed_code + "\n}";
              antlrcpp::downCast<StatementContext *>(_localctx)->line_number =  antlrcpp::downCast<StatementContext *>(_localctx)->switchToken->getLine();
              logLine(_localctx->line_number, "statement : SWITCH LPAREN expression RPAREN LCURL switch_cases RCURL");
              writeIntoparserLogFile(_localctx->statement_string);
          
      break;
    }

    case 11: {
      enterOuterAlt(_localctx, 11);
      setState(288);
      antlrcpp::downCast<StatementContext *>(_localctx)->doToken = match(C8086Parser::DO);
      doDepth++;
      setState(290);
      antlrcpp::downCast<StatementContext *>(_localctx)->cs = compound_statement();
      setState(291);
      match(C8086Parser::WHILE);
      setState(292);
      match(C8086Parser::LPAREN);
      setState(293);
      antlrcpp::downCast<StatementContext *>(_localctx)->e = expression();
      setState(294);
      match(C8086Parser::RPAREN);
      setState(295);
      match(C8086Parser::SEMICOLON);

              antlrcpp::downCast<StatementContext *>(_localctx)->statement_string =  "do "+antlrcpp::downCast<StatementContext *>(_localctx)->cs->code_string + "while(" + antlrcpp::downCast<StatementContext *>(_localctx)->e->expr_string +");";
              antlrcpp::downCast<StatementContext *>(_localctx)->line_number =  antlrcpp::downCast<StatementContext *>(_localctx)->doToken->getLine();
              
              logLine(_localctx->line_number,"statement : DO compound_statement WHILE LPAREN expression RPAREN SEMICOLON");
              writeIntoparserLogFile(_localctx->statement_string);
              doDepth--;
          
      break;
    }

    case 12: {
      enterOuterAlt(_localctx, 12);
      setState(298);
      antlrcpp::downCast<StatementContext *>(_localctx)->breakToken = match(C8086Parser::BREAK);
      setState(299);
      match(C8086Parser::SEMICOLON);

              antlrcpp::downCast<StatementContext *>(_localctx)->statement_string =  "break;";
              antlrcpp::downCast<StatementContext *>(_localctx)->line_number =  antlrcpp::downCast<StatementContext *>(_localctx)->breakToken->getLine();
              logLine(_localctx->line_number, "statement : BREAK SEMICOLON");
              writeIntoparserLogFile(_localctx->statement_string);
           
      break;
    }

    case 13: {
      enterOuterAlt(_localctx, 13);
      setState(301);
      antlrcpp::downCast<StatementContext *>(_localctx)->continueToken = match(C8086Parser::CONTINUE);
      setState(302);
      match(C8086Parser::SEMICOLON);

              antlrcpp::downCast<StatementContext *>(_localctx)->statement_string =  "continue;";
              antlrcpp::downCast<StatementContext *>(_localctx)->line_number =  antlrcpp::downCast<StatementContext *>(_localctx)->continueToken->getLine();
              logLine(_localctx->line_number, "statement : CONTINUE SEMICOLON");
              writeIntoparserLogFile(_localctx->statement_string);
           
      break;
    }

    default:
      break;
    }
   
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }

  return _localctx;
}

//----------------- Switch_casesContext ------------------------------------------------------------------

C8086Parser::Switch_casesContext::Switch_casesContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

C8086Parser::Case_statementContext* C8086Parser::Switch_casesContext::case_statement() {
  return getRuleContext<C8086Parser::Case_statementContext>(0);
}

C8086Parser::Switch_casesContext* C8086Parser::Switch_casesContext::switch_cases() {
  return getRuleContext<C8086Parser::Switch_casesContext>(0);
}


size_t C8086Parser::Switch_casesContext::getRuleIndex() const {
  return C8086Parser::RuleSwitch_cases;
}

void C8086Parser::Switch_casesContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterSwitch_cases(this);
}

void C8086Parser::Switch_casesContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitSwitch_cases(this);
}


C8086Parser::Switch_casesContext* C8086Parser::switch_cases() {
   return switch_cases(0);
}

C8086Parser::Switch_casesContext* C8086Parser::switch_cases(int precedence) {
  ParserRuleContext *parentContext = _ctx;
  size_t parentState = getState();
  C8086Parser::Switch_casesContext *_localctx = _tracker.createInstance<Switch_casesContext>(_ctx, parentState);
  C8086Parser::Switch_casesContext *previousContext = _localctx;
  (void)previousContext; // Silence compiler, in case the context is not used by generated code.
  size_t startState = 28;
  enterRecursionRule(_localctx, 28, C8086Parser::RuleSwitch_cases, precedence);

    

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    unrollRecursionContexts(parentContext);
  });
  try {
    size_t alt;
    enterOuterAlt(_localctx, 1);
    setState(307);
    antlrcpp::downCast<Switch_casesContext *>(_localctx)->case_statementContext = case_statement();

                _localctx->info.line_number = antlrcpp::downCast<Switch_casesContext *>(_localctx)->case_statementContext->info.line_number;
                _localctx->info.parsed_code = antlrcpp::downCast<Switch_casesContext *>(_localctx)->case_statementContext->info.parsed_code;
                logLine(_localctx->info.line_number, "switch_cases : case_statement");
                writeIntoparserLogFile(_localctx->info.parsed_code);
             
    _ctx->stop = _input->LT(-1);
    setState(316);
    _errHandler->sync(this);
    alt = getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 15, _ctx);
    while (alt != 2 && alt != atn::ATN::INVALID_ALT_NUMBER) {
      if (alt == 1) {
        if (!_parseListeners.empty())
          triggerExitRuleEvent();
        previousContext = _localctx;
        _localctx = _tracker.createInstance<Switch_casesContext>(parentContext, parentState);
        _localctx->sc = previousContext;
        pushNewRecursionContext(_localctx, startState, RuleSwitch_cases);
        setState(310);

        if (!(precpred(_ctx, 1))) throw FailedPredicateException(this, "precpred(_ctx, 1)");
        setState(311);
        antlrcpp::downCast<Switch_casesContext *>(_localctx)->cs = antlrcpp::downCast<Switch_casesContext *>(_localctx)->case_statementContext = case_statement();

                              _localctx->info.line_number = antlrcpp::downCast<Switch_casesContext *>(_localctx)->cs->info.line_number;
                              _localctx->info.parsed_code = antlrcpp::downCast<Switch_casesContext *>(_localctx)->sc->info.parsed_code + "\n" + antlrcpp::downCast<Switch_casesContext *>(_localctx)->cs->info.parsed_code;
                              logLine(_localctx->info.line_number, "switch_cases : switch_cases case_statement");
                              writeIntoparserLogFile(_localctx->info.parsed_code);
                             
      }
      setState(318);
      _errHandler->sync(this);
      alt = getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 15, _ctx);
    }
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }
  return _localctx;
}

//----------------- Case_statementContext ------------------------------------------------------------------

C8086Parser::Case_statementContext::Case_statementContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

tree::TerminalNode* C8086Parser::Case_statementContext::CASE() {
  return getToken(C8086Parser::CASE, 0);
}

tree::TerminalNode* C8086Parser::Case_statementContext::COLON() {
  return getToken(C8086Parser::COLON, 0);
}

C8086Parser::ExpressionContext* C8086Parser::Case_statementContext::expression() {
  return getRuleContext<C8086Parser::ExpressionContext>(0);
}

C8086Parser::StatementsContext* C8086Parser::Case_statementContext::statements() {
  return getRuleContext<C8086Parser::StatementsContext>(0);
}

tree::TerminalNode* C8086Parser::Case_statementContext::DEFAULT() {
  return getToken(C8086Parser::DEFAULT, 0);
}


size_t C8086Parser::Case_statementContext::getRuleIndex() const {
  return C8086Parser::RuleCase_statement;
}

void C8086Parser::Case_statementContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterCase_statement(this);
}

void C8086Parser::Case_statementContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitCase_statement(this);
}

C8086Parser::Case_statementContext* C8086Parser::case_statement() {
  Case_statementContext *_localctx = _tracker.createInstance<Case_statementContext>(_ctx, getState());
  enterRule(_localctx, 30, C8086Parser::RuleCase_statement);

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    exitRule();
  });
  try {
    setState(330);
    _errHandler->sync(this);
    switch (_input->LA(1)) {
      case C8086Parser::CASE: {
        enterOuterAlt(_localctx, 1);
        setState(319);
        antlrcpp::downCast<Case_statementContext *>(_localctx)->caseToken = match(C8086Parser::CASE);
        setState(320);
        antlrcpp::downCast<Case_statementContext *>(_localctx)->e = expression();
        setState(321);
        match(C8086Parser::COLON);
        setState(322);
        antlrcpp::downCast<Case_statementContext *>(_localctx)->st = statements(0);

                _localctx->info.line_number = antlrcpp::downCast<Case_statementContext *>(_localctx)->caseToken->getLine();
                _localctx->info.parsed_code = "case " + antlrcpp::downCast<Case_statementContext *>(_localctx)->e->expr_string + ":\n" + antlrcpp::downCast<Case_statementContext *>(_localctx)->st->statements_string;
                logLine(_localctx->info.line_number, "case_statement : CASE expression COLON statements");
                writeIntoparserLogFile(_localctx->info.parsed_code);
            
        break;
      }

      case C8086Parser::DEFAULT: {
        enterOuterAlt(_localctx, 2);
        setState(325);
        antlrcpp::downCast<Case_statementContext *>(_localctx)->defaultToken = match(C8086Parser::DEFAULT);
        setState(326);
        match(C8086Parser::COLON);
        setState(327);
        antlrcpp::downCast<Case_statementContext *>(_localctx)->st = statements(0);

                _localctx->info.line_number = antlrcpp::downCast<Case_statementContext *>(_localctx)->defaultToken->getLine();
                _localctx->info.parsed_code = "default:\n" + antlrcpp::downCast<Case_statementContext *>(_localctx)->st->statements_string;
                logLine(_localctx->info.line_number, "case_statement : DEFAULT COLON statements");
                writeIntoparserLogFile(_localctx->info.parsed_code);
            
        break;
      }

    default:
      throw NoViableAltException(this);
    }
   
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }

  return _localctx;
}

//----------------- Expression_statementContext ------------------------------------------------------------------

C8086Parser::Expression_statementContext::Expression_statementContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

tree::TerminalNode* C8086Parser::Expression_statementContext::SEMICOLON() {
  return getToken(C8086Parser::SEMICOLON, 0);
}

C8086Parser::ExpressionContext* C8086Parser::Expression_statementContext::expression() {
  return getRuleContext<C8086Parser::ExpressionContext>(0);
}


size_t C8086Parser::Expression_statementContext::getRuleIndex() const {
  return C8086Parser::RuleExpression_statement;
}

void C8086Parser::Expression_statementContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterExpression_statement(this);
}

void C8086Parser::Expression_statementContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitExpression_statement(this);
}

C8086Parser::Expression_statementContext* C8086Parser::expression_statement() {
  Expression_statementContext *_localctx = _tracker.createInstance<Expression_statementContext>(_ctx, getState());
  enterRule(_localctx, 32, C8086Parser::RuleExpression_statement);

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    exitRule();
  });
  try {
    setState(338);
    _errHandler->sync(this);
    switch (_input->LA(1)) {
      case C8086Parser::SEMICOLON: {
        enterOuterAlt(_localctx, 1);
        setState(332);
        antlrcpp::downCast<Expression_statementContext *>(_localctx)->semicolonToken = match(C8086Parser::SEMICOLON);

                antlrcpp::downCast<Expression_statementContext *>(_localctx)->expr_string =  ";";
                antlrcpp::downCast<Expression_statementContext *>(_localctx)->line_number =  antlrcpp::downCast<Expression_statementContext *>(_localctx)->semicolonToken->getLine();
                logLine(_localctx->line_number, "expression_statement : SEMICOLON");
                writeIntoparserLogFile(_localctx->expr_string);
            
        break;
      }

      case C8086Parser::LPAREN:
      case C8086Parser::ADDOP:
      case C8086Parser::NOT:
      case C8086Parser::ID:
      case C8086Parser::CONST_INT:
      case C8086Parser::CONST_FLOAT: {
        enterOuterAlt(_localctx, 2);
        setState(334);
        antlrcpp::downCast<Expression_statementContext *>(_localctx)->e = expression();
        setState(335);
        antlrcpp::downCast<Expression_statementContext *>(_localctx)->semicolonToken = match(C8086Parser::SEMICOLON);

                antlrcpp::downCast<Expression_statementContext *>(_localctx)->expr_string =  antlrcpp::downCast<Expression_statementContext *>(_localctx)->e->expr_string + ";";
                antlrcpp::downCast<Expression_statementContext *>(_localctx)->line_number =  antlrcpp::downCast<Expression_statementContext *>(_localctx)->semicolonToken->getLine();
                logLine(_localctx->line_number, "expression_statement : expression SEMICOLON");
                writeIntoparserLogFile(_localctx->expr_string);
            
        break;
      }

    default:
      throw NoViableAltException(this);
    }
   
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }

  return _localctx;
}

//----------------- VariableContext ------------------------------------------------------------------

C8086Parser::VariableContext::VariableContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

tree::TerminalNode* C8086Parser::VariableContext::ID() {
  return getToken(C8086Parser::ID, 0);
}

tree::TerminalNode* C8086Parser::VariableContext::LTHIRD() {
  return getToken(C8086Parser::LTHIRD, 0);
}

tree::TerminalNode* C8086Parser::VariableContext::RTHIRD() {
  return getToken(C8086Parser::RTHIRD, 0);
}

C8086Parser::ExpressionContext* C8086Parser::VariableContext::expression() {
  return getRuleContext<C8086Parser::ExpressionContext>(0);
}


size_t C8086Parser::VariableContext::getRuleIndex() const {
  return C8086Parser::RuleVariable;
}

void C8086Parser::VariableContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterVariable(this);
}

void C8086Parser::VariableContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitVariable(this);
}

C8086Parser::VariableContext* C8086Parser::variable() {
  VariableContext *_localctx = _tracker.createInstance<VariableContext>(_ctx, getState());
  enterRule(_localctx, 34, C8086Parser::RuleVariable);

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    exitRule();
  });
  try {
    setState(348);
    _errHandler->sync(this);
    switch (getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 18, _ctx)) {
    case 1: {
      enterOuterAlt(_localctx, 1);
      setState(340);
      antlrcpp::downCast<VariableContext *>(_localctx)->idToken = match(C8086Parser::ID);

              antlrcpp::downCast<VariableContext *>(_localctx)->var_string =  antlrcpp::downCast<VariableContext *>(_localctx)->idToken->getText();
              antlrcpp::downCast<VariableContext *>(_localctx)->line_number =  antlrcpp::downCast<VariableContext *>(_localctx)->idToken->getLine();
              SymbolInfo* sym = ST->LookUp(antlrcpp::downCast<VariableContext *>(_localctx)->idToken->getText());
              if (!sym) {
                  logError(_localctx->line_number, "Undeclared variable " + antlrcpp::downCast<VariableContext *>(_localctx)->idToken->getText());
                  syntaxErrorCount++;
                  antlrcpp::downCast<VariableContext *>(_localctx)->var_type =  "";
              } else {
                  std::string fullType = sym->getOriginalType(); // Use original type
                  if (fullType.find("ARRAY,") == 0) {
                      // This is array access without brackets - ERROR for assignment ONLY in assignment context
                      // For expression context, this should be allowed as array name
                      antlrcpp::downCast<VariableContext *>(_localctx)->var_type =  fullType; // Keep full array type
                  } else {
                      antlrcpp::downCast<VariableContext *>(_localctx)->var_type =  sym->getType(); // Regular variable type (int/float/void)
                  }
              }
              logLine(_localctx->line_number, "variable : ID");
              writeIntoparserLogFile(_localctx->var_string);
          
      break;
    }

    case 2: {
      enterOuterAlt(_localctx, 2);
      setState(342);
      antlrcpp::downCast<VariableContext *>(_localctx)->idToken = match(C8086Parser::ID);
      setState(343);
      match(C8086Parser::LTHIRD);
      setState(344);
      antlrcpp::downCast<VariableContext *>(_localctx)->e = expression();
      setState(345);
      match(C8086Parser::RTHIRD);

              antlrcpp::downCast<VariableContext *>(_localctx)->var_string =  antlrcpp::downCast<VariableContext *>(_localctx)->idToken->getText() + "[" + antlrcpp::downCast<VariableContext *>(_localctx)->e->expr_string + "]";
              antlrcpp::downCast<VariableContext *>(_localctx)->line_number =  antlrcpp::downCast<VariableContext *>(_localctx)->idToken->getLine();
              SymbolInfo* sym = ST->LookUp(antlrcpp::downCast<VariableContext *>(_localctx)->idToken->getText());
              if (!sym) {
                  writeIntoErrorFile("Line " + std::to_string(_localctx->line_number) + ": Undeclared variable " + antlrcpp::downCast<VariableContext *>(_localctx)->idToken->getText());
                  syntaxErrorCount++;
                  antlrcpp::downCast<VariableContext *>(_localctx)->var_type =  "";
              } else {
                  std::string fullType = sym->getOriginalType();
                  if (fullType.find("ARRAY,") != 0) {
                      writeIntoErrorFile("Line " + std::to_string(_localctx->line_number) + ": " + antlrcpp::downCast<VariableContext *>(_localctx)->idToken->getText() + " is not an array");
                      syntaxErrorCount++;
                      antlrcpp::downCast<VariableContext *>(_localctx)->var_type =  "";
                  } else {
                      antlrcpp::downCast<VariableContext *>(_localctx)->var_type =  fullType.substr(6); // Remove "ARRAY," to get base type (int/float)
                      if (!antlrcpp::downCast<VariableContext *>(_localctx)->e->is_integer) {
                          writeIntoErrorFile("Line " + std::to_string(_localctx->line_number) + ": Expression inside third brackets not an integer");
                          syntaxErrorCount++;
                      }
                  }
              }
              logLine(_localctx->line_number, "variable : ID LTHIRD expression RTHIRD");
              writeIntoparserLogFile(_localctx->var_string);
          
      break;
    }

    default:
      break;
    }
   
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }

  return _localctx;
}

//----------------- ExpressionContext ------------------------------------------------------------------

C8086Parser::ExpressionContext::ExpressionContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

C8086Parser::Logic_expressionContext* C8086Parser::ExpressionContext::logic_expression() {
  return getRuleContext<C8086Parser::Logic_expressionContext>(0);
}

tree::TerminalNode* C8086Parser::ExpressionContext::ASSIGNOP() {
  return getToken(C8086Parser::ASSIGNOP, 0);
}

C8086Parser::VariableContext* C8086Parser::ExpressionContext::variable() {
  return getRuleContext<C8086Parser::VariableContext>(0);
}


size_t C8086Parser::ExpressionContext::getRuleIndex() const {
  return C8086Parser::RuleExpression;
}

void C8086Parser::ExpressionContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterExpression(this);
}

void C8086Parser::ExpressionContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitExpression(this);
}

C8086Parser::ExpressionContext* C8086Parser::expression() {
  ExpressionContext *_localctx = _tracker.createInstance<ExpressionContext>(_ctx, getState());
  enterRule(_localctx, 36, C8086Parser::RuleExpression);

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    exitRule();
  });
  try {
    setState(358);
    _errHandler->sync(this);
    switch (getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 19, _ctx)) {
    case 1: {
      enterOuterAlt(_localctx, 1);
      setState(350);
      antlrcpp::downCast<ExpressionContext *>(_localctx)->le = logic_expression();

              antlrcpp::downCast<ExpressionContext *>(_localctx)->expr_string =  antlrcpp::downCast<ExpressionContext *>(_localctx)->le->expr_string;
              antlrcpp::downCast<ExpressionContext *>(_localctx)->line_number =  antlrcpp::downCast<ExpressionContext *>(_localctx)->le->line_number;
              antlrcpp::downCast<ExpressionContext *>(_localctx)->expr_type =  antlrcpp::downCast<ExpressionContext *>(_localctx)->le->expr_type;
              antlrcpp::downCast<ExpressionContext *>(_localctx)->is_integer =  antlrcpp::downCast<ExpressionContext *>(_localctx)->le->is_integer;
              logLine(_localctx->line_number, "expression : logic expression");
              writeIntoparserLogFile(_localctx->expr_string);
          
      break;
    }

    case 2: {
      enterOuterAlt(_localctx, 2);
      setState(353);
      antlrcpp::downCast<ExpressionContext *>(_localctx)->v = variable();
      setState(354);
      match(C8086Parser::ASSIGNOP);
      setState(355);
      antlrcpp::downCast<ExpressionContext *>(_localctx)->le = logic_expression();

              antlrcpp::downCast<ExpressionContext *>(_localctx)->expr_string =  antlrcpp::downCast<ExpressionContext *>(_localctx)->v->var_string + "=" + antlrcpp::downCast<ExpressionContext *>(_localctx)->le->expr_string;
              antlrcpp::downCast<ExpressionContext *>(_localctx)->line_number =  antlrcpp::downCast<ExpressionContext *>(_localctx)->v->line_number;
              // writeIntoErrorFile("var_type: "+ antlrcpp::downCast<ExpressionContext *>(_localctx)->v->var_type + "expression_type: " + antlrcpp::downCast<ExpressionContext *>(_localctx)->le->expr_type);
              
              // Check if trying to assign to array name (without index)
              if (antlrcpp::downCast<ExpressionContext *>(_localctx)->v->var_type.find("ARRAY,") == 0 && antlrcpp::downCast<ExpressionContext *>(_localctx)->v->var_string.find("[") == std::string::npos) {
                  writeIntoErrorFile("Line " + std::to_string(_localctx->line_number) + ": Type mismatch, " + antlrcpp::downCast<ExpressionContext *>(_localctx)->v->var_string + " is an array");
                  syntaxErrorCount++;
              } else {
                  // Get the actual assignable type
                  std::string assignableType = getBaseType(antlrcpp::downCast<ExpressionContext *>(_localctx)->v->var_type);
                  if (assignableType!="" &&  !isTypeCompatible(assignableType, antlrcpp::downCast<ExpressionContext *>(_localctx)->le->expr_type)) {
                      writeIntoErrorFile("Line " + std::to_string(_localctx->line_number) + ": Type Mismatch");
                      syntaxErrorCount++;
                  }
              }
              
              antlrcpp::downCast<ExpressionContext *>(_localctx)->expr_type =  getBaseType(antlrcpp::downCast<ExpressionContext *>(_localctx)->v->var_type);
              antlrcpp::downCast<ExpressionContext *>(_localctx)->is_integer =  isIntegerType(_localctx->expr_type);
              logLine(_localctx->line_number, "expression : variable ASSIGNOP logic expression");
              writeIntoparserLogFile(_localctx->expr_string);
          
      break;
    }

    default:
      break;
    }
   
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }

  return _localctx;
}

//----------------- Logic_expressionContext ------------------------------------------------------------------

C8086Parser::Logic_expressionContext::Logic_expressionContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

std::vector<C8086Parser::Rel_expressionContext *> C8086Parser::Logic_expressionContext::rel_expression() {
  return getRuleContexts<C8086Parser::Rel_expressionContext>();
}

C8086Parser::Rel_expressionContext* C8086Parser::Logic_expressionContext::rel_expression(size_t i) {
  return getRuleContext<C8086Parser::Rel_expressionContext>(i);
}

tree::TerminalNode* C8086Parser::Logic_expressionContext::LOGICOP() {
  return getToken(C8086Parser::LOGICOP, 0);
}


size_t C8086Parser::Logic_expressionContext::getRuleIndex() const {
  return C8086Parser::RuleLogic_expression;
}

void C8086Parser::Logic_expressionContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterLogic_expression(this);
}

void C8086Parser::Logic_expressionContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitLogic_expression(this);
}

C8086Parser::Logic_expressionContext* C8086Parser::logic_expression() {
  Logic_expressionContext *_localctx = _tracker.createInstance<Logic_expressionContext>(_ctx, getState());
  enterRule(_localctx, 38, C8086Parser::RuleLogic_expression);

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    exitRule();
  });
  try {
    setState(368);
    _errHandler->sync(this);
    switch (getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 20, _ctx)) {
    case 1: {
      enterOuterAlt(_localctx, 1);
      setState(360);
      antlrcpp::downCast<Logic_expressionContext *>(_localctx)->re = rel_expression();

              antlrcpp::downCast<Logic_expressionContext *>(_localctx)->expr_string =  antlrcpp::downCast<Logic_expressionContext *>(_localctx)->re->expr_string;
              antlrcpp::downCast<Logic_expressionContext *>(_localctx)->line_number =  antlrcpp::downCast<Logic_expressionContext *>(_localctx)->re->line_number;
              antlrcpp::downCast<Logic_expressionContext *>(_localctx)->expr_type =  antlrcpp::downCast<Logic_expressionContext *>(_localctx)->re->expr_type;
              antlrcpp::downCast<Logic_expressionContext *>(_localctx)->is_integer =  antlrcpp::downCast<Logic_expressionContext *>(_localctx)->re->is_integer;
              logLine(_localctx->line_number, "logic expression : rel_expression");
              writeIntoparserLogFile(_localctx->expr_string);
          
      break;
    }

    case 2: {
      enterOuterAlt(_localctx, 2);
      setState(363);
      antlrcpp::downCast<Logic_expressionContext *>(_localctx)->re1 = rel_expression();
      setState(364);
      antlrcpp::downCast<Logic_expressionContext *>(_localctx)->logicopToken = match(C8086Parser::LOGICOP);
      setState(365);
      antlrcpp::downCast<Logic_expressionContext *>(_localctx)->re2 = rel_expression();

              antlrcpp::downCast<Logic_expressionContext *>(_localctx)->expr_string =  antlrcpp::downCast<Logic_expressionContext *>(_localctx)->re1->expr_string + " " + antlrcpp::downCast<Logic_expressionContext *>(_localctx)->logicopToken->getText() + " " + antlrcpp::downCast<Logic_expressionContext *>(_localctx)->re2->expr_string;
              antlrcpp::downCast<Logic_expressionContext *>(_localctx)->line_number =  antlrcpp::downCast<Logic_expressionContext *>(_localctx)->re1->line_number;
              antlrcpp::downCast<Logic_expressionContext *>(_localctx)->expr_type =  "int"; // LOGICOP results in int
              antlrcpp::downCast<Logic_expressionContext *>(_localctx)->is_integer =  true;
              logLine(_localctx->line_number, "logic expression : rel_expression LOGICOP rel_expression");
              writeIntoparserLogFile(_localctx->expr_string);
          
      break;
    }

    default:
      break;
    }
   
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }

  return _localctx;
}

//----------------- Rel_expressionContext ------------------------------------------------------------------

C8086Parser::Rel_expressionContext::Rel_expressionContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

std::vector<C8086Parser::Simple_expressionContext *> C8086Parser::Rel_expressionContext::simple_expression() {
  return getRuleContexts<C8086Parser::Simple_expressionContext>();
}

C8086Parser::Simple_expressionContext* C8086Parser::Rel_expressionContext::simple_expression(size_t i) {
  return getRuleContext<C8086Parser::Simple_expressionContext>(i);
}

tree::TerminalNode* C8086Parser::Rel_expressionContext::RELOP() {
  return getToken(C8086Parser::RELOP, 0);
}


size_t C8086Parser::Rel_expressionContext::getRuleIndex() const {
  return C8086Parser::RuleRel_expression;
}

void C8086Parser::Rel_expressionContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterRel_expression(this);
}

void C8086Parser::Rel_expressionContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitRel_expression(this);
}

C8086Parser::Rel_expressionContext* C8086Parser::rel_expression() {
  Rel_expressionContext *_localctx = _tracker.createInstance<Rel_expressionContext>(_ctx, getState());
  enterRule(_localctx, 40, C8086Parser::RuleRel_expression);

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    exitRule();
  });
  try {
    setState(378);
    _errHandler->sync(this);
    switch (getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 21, _ctx)) {
    case 1: {
      enterOuterAlt(_localctx, 1);
      setState(370);
      antlrcpp::downCast<Rel_expressionContext *>(_localctx)->se = simple_expression(0);

              antlrcpp::downCast<Rel_expressionContext *>(_localctx)->expr_string =  antlrcpp::downCast<Rel_expressionContext *>(_localctx)->se->expr_string;
              antlrcpp::downCast<Rel_expressionContext *>(_localctx)->line_number =  antlrcpp::downCast<Rel_expressionContext *>(_localctx)->se->line_number;
              antlrcpp::downCast<Rel_expressionContext *>(_localctx)->expr_type =  antlrcpp::downCast<Rel_expressionContext *>(_localctx)->se->expr_type;
              antlrcpp::downCast<Rel_expressionContext *>(_localctx)->is_integer =  antlrcpp::downCast<Rel_expressionContext *>(_localctx)->se->is_integral;
              logLine(_localctx->line_number, "rel_expression : simple_expression");
              writeIntoparserLogFile(_localctx->expr_string);
          
      break;
    }

    case 2: {
      enterOuterAlt(_localctx, 2);
      setState(373);
      antlrcpp::downCast<Rel_expressionContext *>(_localctx)->se1 = simple_expression(0);
      setState(374);
      antlrcpp::downCast<Rel_expressionContext *>(_localctx)->relopToken = match(C8086Parser::RELOP);
      setState(375);
      antlrcpp::downCast<Rel_expressionContext *>(_localctx)->se2 = simple_expression(0);

              antlrcpp::downCast<Rel_expressionContext *>(_localctx)->expr_string =  antlrcpp::downCast<Rel_expressionContext *>(_localctx)->se1->expr_string + antlrcpp::downCast<Rel_expressionContext *>(_localctx)->relopToken->getText() + antlrcpp::downCast<Rel_expressionContext *>(_localctx)->se2->expr_string;
              antlrcpp::downCast<Rel_expressionContext *>(_localctx)->line_number =  antlrcpp::downCast<Rel_expressionContext *>(_localctx)->se1->line_number;
              antlrcpp::downCast<Rel_expressionContext *>(_localctx)->expr_type =  "int"; // RELOP results in int
              antlrcpp::downCast<Rel_expressionContext *>(_localctx)->is_integer =  true;
              logLine(_localctx->line_number, "rel_expression : simple_expression RELOP simple_expression");
              writeIntoparserLogFile(_localctx->expr_string);
          
      break;
    }

    default:
      break;
    }
   
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }

  return _localctx;
}

//----------------- Simple_expressionContext ------------------------------------------------------------------

C8086Parser::Simple_expressionContext::Simple_expressionContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

C8086Parser::TermContext* C8086Parser::Simple_expressionContext::term() {
  return getRuleContext<C8086Parser::TermContext>(0);
}

tree::TerminalNode* C8086Parser::Simple_expressionContext::ADDOP() {
  return getToken(C8086Parser::ADDOP, 0);
}

C8086Parser::Simple_expressionContext* C8086Parser::Simple_expressionContext::simple_expression() {
  return getRuleContext<C8086Parser::Simple_expressionContext>(0);
}


size_t C8086Parser::Simple_expressionContext::getRuleIndex() const {
  return C8086Parser::RuleSimple_expression;
}

void C8086Parser::Simple_expressionContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterSimple_expression(this);
}

void C8086Parser::Simple_expressionContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitSimple_expression(this);
}


C8086Parser::Simple_expressionContext* C8086Parser::simple_expression() {
   return simple_expression(0);
}

C8086Parser::Simple_expressionContext* C8086Parser::simple_expression(int precedence) {
  ParserRuleContext *parentContext = _ctx;
  size_t parentState = getState();
  C8086Parser::Simple_expressionContext *_localctx = _tracker.createInstance<Simple_expressionContext>(_ctx, parentState);
  C8086Parser::Simple_expressionContext *previousContext = _localctx;
  (void)previousContext; // Silence compiler, in case the context is not used by generated code.
  size_t startState = 42;
  enterRecursionRule(_localctx, 42, C8086Parser::RuleSimple_expression, precedence);

    

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    unrollRecursionContexts(parentContext);
  });
  try {
    size_t alt;
    enterOuterAlt(_localctx, 1);
    setState(381);
    antlrcpp::downCast<Simple_expressionContext *>(_localctx)->t = term(0);

            antlrcpp::downCast<Simple_expressionContext *>(_localctx)->expr_string =  antlrcpp::downCast<Simple_expressionContext *>(_localctx)->t->expr_string;
            antlrcpp::downCast<Simple_expressionContext *>(_localctx)->line_number =  antlrcpp::downCast<Simple_expressionContext *>(_localctx)->t->line_number;
            antlrcpp::downCast<Simple_expressionContext *>(_localctx)->expr_type =  antlrcpp::downCast<Simple_expressionContext *>(_localctx)->t->t_type;
            antlrcpp::downCast<Simple_expressionContext *>(_localctx)->is_integral =  antlrcpp::downCast<Simple_expressionContext *>(_localctx)->t->is_integer;
            logLine(_localctx->line_number, "simple_expression : term");
            writeIntoparserLogFile(_localctx->expr_string);
        
    _ctx->stop = _input->LT(-1);
    setState(391);
    _errHandler->sync(this);
    alt = getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 22, _ctx);
    while (alt != 2 && alt != atn::ATN::INVALID_ALT_NUMBER) {
      if (alt == 1) {
        if (!_parseListeners.empty())
          triggerExitRuleEvent();
        previousContext = _localctx;
        _localctx = _tracker.createInstance<Simple_expressionContext>(parentContext, parentState);
        _localctx->se = previousContext;
        pushNewRecursionContext(_localctx, startState, RuleSimple_expression);
        setState(384);

        if (!(precpred(_ctx, 1))) throw FailedPredicateException(this, "precpred(_ctx, 1)");
        setState(385);
        antlrcpp::downCast<Simple_expressionContext *>(_localctx)->addopToken = match(C8086Parser::ADDOP);
        setState(386);
        antlrcpp::downCast<Simple_expressionContext *>(_localctx)->t = term(0);

                          antlrcpp::downCast<Simple_expressionContext *>(_localctx)->expr_string =  antlrcpp::downCast<Simple_expressionContext *>(_localctx)->se->expr_string + antlrcpp::downCast<Simple_expressionContext *>(_localctx)->addopToken->getText() + antlrcpp::downCast<Simple_expressionContext *>(_localctx)->t->expr_string;
                          antlrcpp::downCast<Simple_expressionContext *>(_localctx)->line_number =  antlrcpp::downCast<Simple_expressionContext *>(_localctx)->se->line_number;
                          if (antlrcpp::downCast<Simple_expressionContext *>(_localctx)->se->expr_type == "float" || antlrcpp::downCast<Simple_expressionContext *>(_localctx)->t->t_type == "float") {
                              antlrcpp::downCast<Simple_expressionContext *>(_localctx)->expr_type =  "float";
                              antlrcpp::downCast<Simple_expressionContext *>(_localctx)->is_integral =  false;
                          } else {
                              antlrcpp::downCast<Simple_expressionContext *>(_localctx)->expr_type =  "int";
                              antlrcpp::downCast<Simple_expressionContext *>(_localctx)->is_integral =  true;
                          }
                          logLine(_localctx->line_number, "simple_expression : simple_expression ADDOP term");
                          writeIntoparserLogFile(_localctx->expr_string);
                       
      }
      setState(393);
      _errHandler->sync(this);
      alt = getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 22, _ctx);
    }
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }
  return _localctx;
}

//----------------- TermContext ------------------------------------------------------------------

C8086Parser::TermContext::TermContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

C8086Parser::Unary_expressionContext* C8086Parser::TermContext::unary_expression() {
  return getRuleContext<C8086Parser::Unary_expressionContext>(0);
}

tree::TerminalNode* C8086Parser::TermContext::MULOP() {
  return getToken(C8086Parser::MULOP, 0);
}

C8086Parser::TermContext* C8086Parser::TermContext::term() {
  return getRuleContext<C8086Parser::TermContext>(0);
}


size_t C8086Parser::TermContext::getRuleIndex() const {
  return C8086Parser::RuleTerm;
}

void C8086Parser::TermContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterTerm(this);
}

void C8086Parser::TermContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitTerm(this);
}


C8086Parser::TermContext* C8086Parser::term() {
   return term(0);
}

C8086Parser::TermContext* C8086Parser::term(int precedence) {
  ParserRuleContext *parentContext = _ctx;
  size_t parentState = getState();
  C8086Parser::TermContext *_localctx = _tracker.createInstance<TermContext>(_ctx, parentState);
  C8086Parser::TermContext *previousContext = _localctx;
  (void)previousContext; // Silence compiler, in case the context is not used by generated code.
  size_t startState = 44;
  enterRecursionRule(_localctx, 44, C8086Parser::RuleTerm, precedence);

    

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    unrollRecursionContexts(parentContext);
  });
  try {
    size_t alt;
    enterOuterAlt(_localctx, 1);
    setState(395);
    antlrcpp::downCast<TermContext *>(_localctx)->ue = unary_expression();

            antlrcpp::downCast<TermContext *>(_localctx)->expr_string =  antlrcpp::downCast<TermContext *>(_localctx)->ue->expr_string;
            antlrcpp::downCast<TermContext *>(_localctx)->line_number =  antlrcpp::downCast<TermContext *>(_localctx)->ue->line_number;
            antlrcpp::downCast<TermContext *>(_localctx)->t_type =  antlrcpp::downCast<TermContext *>(_localctx)->ue->expr_type;
            antlrcpp::downCast<TermContext *>(_localctx)->is_integer =  antlrcpp::downCast<TermContext *>(_localctx)->ue->is_integer;
            logLine(_localctx->line_number, "term : unary_expression");
            writeIntoparserLogFile(_localctx->expr_string);
        
    _ctx->stop = _input->LT(-1);
    setState(405);
    _errHandler->sync(this);
    alt = getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 23, _ctx);
    while (alt != 2 && alt != atn::ATN::INVALID_ALT_NUMBER) {
      if (alt == 1) {
        if (!_parseListeners.empty())
          triggerExitRuleEvent();
        previousContext = _localctx;
        _localctx = _tracker.createInstance<TermContext>(parentContext, parentState);
        _localctx->t = previousContext;
        pushNewRecursionContext(_localctx, startState, RuleTerm);
        setState(398);

        if (!(precpred(_ctx, 1))) throw FailedPredicateException(this, "precpred(_ctx, 1)");
        setState(399);
        antlrcpp::downCast<TermContext *>(_localctx)->mulopToken = match(C8086Parser::MULOP);
        setState(400);
        antlrcpp::downCast<TermContext *>(_localctx)->ue = unary_expression();

                          antlrcpp::downCast<TermContext *>(_localctx)->expr_string =  antlrcpp::downCast<TermContext *>(_localctx)->t->expr_string +  antlrcpp::downCast<TermContext *>(_localctx)->mulopToken->getText() + antlrcpp::downCast<TermContext *>(_localctx)->ue->expr_string;
                          antlrcpp::downCast<TermContext *>(_localctx)->line_number =  antlrcpp::downCast<TermContext *>(_localctx)->t->line_number;
                          if (antlrcpp::downCast<TermContext *>(_localctx)->mulopToken->getText() == "%") {
                              if (!antlrcpp::downCast<TermContext *>(_localctx)->t->is_integer || !antlrcpp::downCast<TermContext *>(_localctx)->ue->is_integer) {
                                  writeIntoErrorFile("Line " + std::to_string(_localctx->line_number) + ": Non-Integer operand on modulus operator");
                                  syntaxErrorCount++;
                              }
                              antlrcpp::downCast<TermContext *>(_localctx)->t_type =  "int";
                              antlrcpp::downCast<TermContext *>(_localctx)->is_integer =  true;
                          } else {
                              if (antlrcpp::downCast<TermContext *>(_localctx)->t->t_type == "float" || antlrcpp::downCast<TermContext *>(_localctx)->ue->expr_type == "float") {
                                  antlrcpp::downCast<TermContext *>(_localctx)->t_type =  "float";
                                  antlrcpp::downCast<TermContext *>(_localctx)->is_integer =  false;
                              } else {
                                  antlrcpp::downCast<TermContext *>(_localctx)->t_type =  "int";
                                  antlrcpp::downCast<TermContext *>(_localctx)->is_integer =  true;
                              }
                          }
                          logLine(_localctx->line_number, "term : term MULOP unary_expression");
                          writeIntoparserLogFile(_localctx->expr_string);
                       
      }
      setState(407);
      _errHandler->sync(this);
      alt = getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 23, _ctx);
    }
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }
  return _localctx;
}

//----------------- Unary_expressionContext ------------------------------------------------------------------

C8086Parser::Unary_expressionContext::Unary_expressionContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

tree::TerminalNode* C8086Parser::Unary_expressionContext::ADDOP() {
  return getToken(C8086Parser::ADDOP, 0);
}

C8086Parser::Unary_expressionContext* C8086Parser::Unary_expressionContext::unary_expression() {
  return getRuleContext<C8086Parser::Unary_expressionContext>(0);
}

tree::TerminalNode* C8086Parser::Unary_expressionContext::NOT() {
  return getToken(C8086Parser::NOT, 0);
}

C8086Parser::FactorContext* C8086Parser::Unary_expressionContext::factor() {
  return getRuleContext<C8086Parser::FactorContext>(0);
}


size_t C8086Parser::Unary_expressionContext::getRuleIndex() const {
  return C8086Parser::RuleUnary_expression;
}

void C8086Parser::Unary_expressionContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterUnary_expression(this);
}

void C8086Parser::Unary_expressionContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitUnary_expression(this);
}

C8086Parser::Unary_expressionContext* C8086Parser::unary_expression() {
  Unary_expressionContext *_localctx = _tracker.createInstance<Unary_expressionContext>(_ctx, getState());
  enterRule(_localctx, 46, C8086Parser::RuleUnary_expression);

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    exitRule();
  });
  try {
    setState(419);
    _errHandler->sync(this);
    switch (_input->LA(1)) {
      case C8086Parser::ADDOP: {
        enterOuterAlt(_localctx, 1);
        setState(408);
        antlrcpp::downCast<Unary_expressionContext *>(_localctx)->addopToken = match(C8086Parser::ADDOP);
        setState(409);
        antlrcpp::downCast<Unary_expressionContext *>(_localctx)->ue = unary_expression();

                antlrcpp::downCast<Unary_expressionContext *>(_localctx)->expr_string =  antlrcpp::downCast<Unary_expressionContext *>(_localctx)->addopToken->getText() + antlrcpp::downCast<Unary_expressionContext *>(_localctx)->ue->expr_string;
                antlrcpp::downCast<Unary_expressionContext *>(_localctx)->line_number =  antlrcpp::downCast<Unary_expressionContext *>(_localctx)->addopToken->getLine();
                antlrcpp::downCast<Unary_expressionContext *>(_localctx)->expr_type =  antlrcpp::downCast<Unary_expressionContext *>(_localctx)->ue->expr_type;
                antlrcpp::downCast<Unary_expressionContext *>(_localctx)->is_integer =  antlrcpp::downCast<Unary_expressionContext *>(_localctx)->ue->is_integer;
                logLine(_localctx->line_number, "unary_expression : ADDOP unary_expression");
                writeIntoparserLogFile(_localctx->expr_string);
            
        break;
      }

      case C8086Parser::NOT: {
        enterOuterAlt(_localctx, 2);
        setState(412);
        antlrcpp::downCast<Unary_expressionContext *>(_localctx)->notToken = match(C8086Parser::NOT);
        setState(413);
        antlrcpp::downCast<Unary_expressionContext *>(_localctx)->ue = unary_expression();

                antlrcpp::downCast<Unary_expressionContext *>(_localctx)->expr_string =  antlrcpp::downCast<Unary_expressionContext *>(_localctx)->notToken->getText() + antlrcpp::downCast<Unary_expressionContext *>(_localctx)->ue->expr_string;
                antlrcpp::downCast<Unary_expressionContext *>(_localctx)->line_number =  antlrcpp::downCast<Unary_expressionContext *>(_localctx)->notToken->getLine();
                antlrcpp::downCast<Unary_expressionContext *>(_localctx)->expr_type =  "int";
                antlrcpp::downCast<Unary_expressionContext *>(_localctx)->is_integer =  true;
                logLine(_localctx->line_number, "unary_expression : NOT unary_expression");
                writeIntoparserLogFile(_localctx->expr_string);
            
        break;
      }

      case C8086Parser::LPAREN:
      case C8086Parser::ID:
      case C8086Parser::CONST_INT:
      case C8086Parser::CONST_FLOAT: {
        enterOuterAlt(_localctx, 3);
        setState(416);
        antlrcpp::downCast<Unary_expressionContext *>(_localctx)->f = factor();

                antlrcpp::downCast<Unary_expressionContext *>(_localctx)->expr_string =  antlrcpp::downCast<Unary_expressionContext *>(_localctx)->f->expr_string;
                antlrcpp::downCast<Unary_expressionContext *>(_localctx)->line_number =  antlrcpp::downCast<Unary_expressionContext *>(_localctx)->f->line_number;
                antlrcpp::downCast<Unary_expressionContext *>(_localctx)->expr_type =  antlrcpp::downCast<Unary_expressionContext *>(_localctx)->f->f_type;
                antlrcpp::downCast<Unary_expressionContext *>(_localctx)->is_integer =  antlrcpp::downCast<Unary_expressionContext *>(_localctx)->f->is_integer;
                logLine(_localctx->line_number, "unary_expression : factor");
                writeIntoparserLogFile(_localctx->expr_string);
            
        break;
      }

    default:
      throw NoViableAltException(this);
    }
   
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }

  return _localctx;
}

//----------------- FactorContext ------------------------------------------------------------------

C8086Parser::FactorContext::FactorContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

C8086Parser::VariableContext* C8086Parser::FactorContext::variable() {
  return getRuleContext<C8086Parser::VariableContext>(0);
}

tree::TerminalNode* C8086Parser::FactorContext::ID() {
  return getToken(C8086Parser::ID, 0);
}

tree::TerminalNode* C8086Parser::FactorContext::LPAREN() {
  return getToken(C8086Parser::LPAREN, 0);
}

tree::TerminalNode* C8086Parser::FactorContext::RPAREN() {
  return getToken(C8086Parser::RPAREN, 0);
}

C8086Parser::Argument_listContext* C8086Parser::FactorContext::argument_list() {
  return getRuleContext<C8086Parser::Argument_listContext>(0);
}

C8086Parser::ExpressionContext* C8086Parser::FactorContext::expression() {
  return getRuleContext<C8086Parser::ExpressionContext>(0);
}

tree::TerminalNode* C8086Parser::FactorContext::CONST_INT() {
  return getToken(C8086Parser::CONST_INT, 0);
}

tree::TerminalNode* C8086Parser::FactorContext::CONST_FLOAT() {
  return getToken(C8086Parser::CONST_FLOAT, 0);
}

tree::TerminalNode* C8086Parser::FactorContext::INCOP() {
  return getToken(C8086Parser::INCOP, 0);
}

tree::TerminalNode* C8086Parser::FactorContext::DECOP() {
  return getToken(C8086Parser::DECOP, 0);
}


size_t C8086Parser::FactorContext::getRuleIndex() const {
  return C8086Parser::RuleFactor;
}

void C8086Parser::FactorContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterFactor(this);
}

void C8086Parser::FactorContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitFactor(this);
}

C8086Parser::FactorContext* C8086Parser::factor() {
  FactorContext *_localctx = _tracker.createInstance<FactorContext>(_ctx, getState());
  enterRule(_localctx, 48, C8086Parser::RuleFactor);

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    exitRule();
  });
  try {
    setState(447);
    _errHandler->sync(this);
    switch (getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 25, _ctx)) {
    case 1: {
      enterOuterAlt(_localctx, 1);
      setState(421);
      antlrcpp::downCast<FactorContext *>(_localctx)->v = variable();

              antlrcpp::downCast<FactorContext *>(_localctx)->expr_string =  antlrcpp::downCast<FactorContext *>(_localctx)->v->var_string;
              antlrcpp::downCast<FactorContext *>(_localctx)->line_number =  antlrcpp::downCast<FactorContext *>(_localctx)->v->line_number;
              antlrcpp::downCast<FactorContext *>(_localctx)->f_type =  antlrcpp::downCast<FactorContext *>(_localctx)->v->var_type;
              antlrcpp::downCast<FactorContext *>(_localctx)->is_integer =  isIntegerType(antlrcpp::downCast<FactorContext *>(_localctx)->v->var_type);
              logLine(_localctx->line_number, "factor : variable");
              writeIntoparserLogFile(_localctx->expr_string);
          
      break;
    }

    case 2: {
      enterOuterAlt(_localctx, 2);
      setState(424);
      antlrcpp::downCast<FactorContext *>(_localctx)->idToken = match(C8086Parser::ID);
      setState(425);
      match(C8086Parser::LPAREN);
      setState(426);
      antlrcpp::downCast<FactorContext *>(_localctx)->al = argument_list();
      setState(427);
      match(C8086Parser::RPAREN);

              antlrcpp::downCast<FactorContext *>(_localctx)->expr_string =  antlrcpp::downCast<FactorContext *>(_localctx)->idToken->getText() + "(" + antlrcpp::downCast<FactorContext *>(_localctx)->al->args_string + ")";
              antlrcpp::downCast<FactorContext *>(_localctx)->line_number =  antlrcpp::downCast<FactorContext *>(_localctx)->idToken->getLine();
              SymbolInfo* sym = ST->LookUp(antlrcpp::downCast<FactorContext *>(_localctx)->idToken->getText());
              if (!sym) {
                  writeIntoErrorFile("Line " + std::to_string(_localctx->line_number) + ": Undeclared function " + antlrcpp::downCast<FactorContext *>(_localctx)->idToken->getText());
                  syntaxErrorCount++;
                  antlrcpp::downCast<FactorContext *>(_localctx)->f_type =  "";
              } else if (sym->isFunctionSymbol() == false) {
                  writeIntoErrorFile("Line " + std::to_string(_localctx->line_number) + ": " + antlrcpp::downCast<FactorContext *>(_localctx)->idToken->getText() + " is not a function");
                  syntaxErrorCount++;
                  antlrcpp::downCast<FactorContext *>(_localctx)->f_type =  "";
              } 
              else {
                  // Extract return type and parameters
                  std::string funcType = sym->getOriginalType();
                  size_t comma = funcType.find(",");
                  size_t arrow = funcType.find("<==");
                  if (comma != std::string::npos && arrow != std::string::npos) {
                      antlrcpp::downCast<FactorContext *>(_localctx)->f_type =  funcType.substr(comma + 1, arrow - comma - 1);
                      if (_localctx->f_type == "void") {
                          writeIntoErrorFile("Line " + std::to_string(_localctx->line_number) + ": Void function " + antlrcpp::downCast<FactorContext *>(_localctx)->idToken->getText() + " cannot be called as part of an expression");
                          syntaxErrorCount++;
                      }
                      // // Use SymbolInfo's paramTypes for declared types
                      std::vector<std::string> declaredTypes = sym->getParamTypes();
                      // // Use the arg_types from argument_list instead of extractParamTypes
                      std::vector<std::string> argTypes = antlrcpp::downCast<FactorContext *>(_localctx)->al->arg_types;


                      // writeIntoErrorFile("Line " + std::to_string(_localctx->line_number) + ": Function " + antlrcpp::downCast<FactorContext *>(_localctx)->idToken->getText() + " called with parameters: " + antlrcpp::downCast<FactorContext *>(_localctx)->al->args_string);

                      if (declaredTypes.size() != argTypes.size()) {
                          writeIntoErrorFile("Line " + std::to_string(_localctx->line_number) + ": Parameter count mismatch in call to " + antlrcpp::downCast<FactorContext *>(_localctx)->idToken->getText());
                          syntaxErrorCount++;
                      } else {
                          for (size_t i = 0; i < declaredTypes.size(); ++i) {

                              // writeIntoErrorFile("Line " + std::to_string(_localctx->line_number) + ": Argument " + std::to_string(i+1) + " type: " + argTypes[i] + ", expected: " + declaredTypes[i]);

                              if (!isTypeCompatible(declaredTypes[i], argTypes[i])) {
                                  writeIntoErrorFile("Line " + std::to_string(_localctx->line_number) + ": Type mismatch in argument " + std::to_string(i+1) + " of call to " + antlrcpp::downCast<FactorContext *>(_localctx)->idToken->getText()
                                      + " (expected: " + declaredTypes[i] + ", got: " + argTypes[i] + ")");
                                  syntaxErrorCount++;
                                  break;
                              }
                          }
                      }
                  } else {
                      antlrcpp::downCast<FactorContext *>(_localctx)->f_type =  "";
                  }
              }
              antlrcpp::downCast<FactorContext *>(_localctx)->is_integer =  isIntegerType(_localctx->f_type);
              logLine(_localctx->line_number, "factor : ID LPAREN argument_list RPAREN");
              writeIntoparserLogFile(_localctx->expr_string);
          
      break;
    }

    case 3: {
      enterOuterAlt(_localctx, 3);
      setState(430);
      antlrcpp::downCast<FactorContext *>(_localctx)->lparenToken = match(C8086Parser::LPAREN);
      setState(431);
      antlrcpp::downCast<FactorContext *>(_localctx)->e = expression();
      setState(432);
      match(C8086Parser::RPAREN);

              antlrcpp::downCast<FactorContext *>(_localctx)->expr_string =  "(" + antlrcpp::downCast<FactorContext *>(_localctx)->e->expr_string + ")";
              antlrcpp::downCast<FactorContext *>(_localctx)->line_number =  antlrcpp::downCast<FactorContext *>(_localctx)->lparenToken->getLine();
              antlrcpp::downCast<FactorContext *>(_localctx)->f_type =  antlrcpp::downCast<FactorContext *>(_localctx)->e->expr_type;
              antlrcpp::downCast<FactorContext *>(_localctx)->is_integer =  antlrcpp::downCast<FactorContext *>(_localctx)->e->is_integer;
              logLine(_localctx->line_number, "factor : LPAREN expression RPAREN");
              writeIntoparserLogFile(_localctx->expr_string);
          
      break;
    }

    case 4: {
      enterOuterAlt(_localctx, 4);
      setState(435);
      antlrcpp::downCast<FactorContext *>(_localctx)->const_intToken = match(C8086Parser::CONST_INT);

              antlrcpp::downCast<FactorContext *>(_localctx)->expr_string =  antlrcpp::downCast<FactorContext *>(_localctx)->const_intToken->getText();
              antlrcpp::downCast<FactorContext *>(_localctx)->line_number =  antlrcpp::downCast<FactorContext *>(_localctx)->const_intToken->getLine();
              antlrcpp::downCast<FactorContext *>(_localctx)->f_type =  "int";
              antlrcpp::downCast<FactorContext *>(_localctx)->is_integer =  true;
              logLine(_localctx->line_number, "factor : CONST_INT");
              writeIntoparserLogFile(_localctx->expr_string);
          
      break;
    }

    case 5: {
      enterOuterAlt(_localctx, 5);
      setState(437);
      antlrcpp::downCast<FactorContext *>(_localctx)->const_floatToken = match(C8086Parser::CONST_FLOAT);

              antlrcpp::downCast<FactorContext *>(_localctx)->expr_string =  antlrcpp::downCast<FactorContext *>(_localctx)->const_floatToken->getText();
              antlrcpp::downCast<FactorContext *>(_localctx)->line_number =  antlrcpp::downCast<FactorContext *>(_localctx)->const_floatToken->getLine();
              antlrcpp::downCast<FactorContext *>(_localctx)->f_type =  "float";
              antlrcpp::downCast<FactorContext *>(_localctx)->is_integer =  false;
              logLine(_localctx->line_number, "factor : CONST_FLOAT");
              writeIntoparserLogFile(_localctx->expr_string);
          
      break;
    }

    case 6: {
      enterOuterAlt(_localctx, 6);
      setState(439);
      antlrcpp::downCast<FactorContext *>(_localctx)->v = variable();
      setState(440);
      antlrcpp::downCast<FactorContext *>(_localctx)->incopToken = match(C8086Parser::INCOP);

              antlrcpp::downCast<FactorContext *>(_localctx)->expr_string =  antlrcpp::downCast<FactorContext *>(_localctx)->v->var_string + antlrcpp::downCast<FactorContext *>(_localctx)->incopToken->getText();
              antlrcpp::downCast<FactorContext *>(_localctx)->line_number =  antlrcpp::downCast<FactorContext *>(_localctx)->v->line_number;
              antlrcpp::downCast<FactorContext *>(_localctx)->f_type =  antlrcpp::downCast<FactorContext *>(_localctx)->v->var_type;
              antlrcpp::downCast<FactorContext *>(_localctx)->is_integer =  isIntegerType(antlrcpp::downCast<FactorContext *>(_localctx)->v->var_type);
              logLine(_localctx->line_number, "factor : variable INCOP");
              writeIntoparserLogFile(_localctx->expr_string);
          
      break;
    }

    case 7: {
      enterOuterAlt(_localctx, 7);
      setState(443);
      antlrcpp::downCast<FactorContext *>(_localctx)->v = variable();
      setState(444);
      antlrcpp::downCast<FactorContext *>(_localctx)->decopToken = match(C8086Parser::DECOP);

              antlrcpp::downCast<FactorContext *>(_localctx)->expr_string =  antlrcpp::downCast<FactorContext *>(_localctx)->v->var_string + antlrcpp::downCast<FactorContext *>(_localctx)->decopToken->getText();
              antlrcpp::downCast<FactorContext *>(_localctx)->line_number =  antlrcpp::downCast<FactorContext *>(_localctx)->v->line_number;
              antlrcpp::downCast<FactorContext *>(_localctx)->f_type =  antlrcpp::downCast<FactorContext *>(_localctx)->v->var_type;
              antlrcpp::downCast<FactorContext *>(_localctx)->is_integer =  isIntegerType(antlrcpp::downCast<FactorContext *>(_localctx)->v->var_type);
              logLine(_localctx->line_number, "factor : variable DECOP");
              writeIntoparserLogFile(_localctx->expr_string);
          
      break;
    }

    default:
      break;
    }
   
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }

  return _localctx;
}

//----------------- Argument_listContext ------------------------------------------------------------------

C8086Parser::Argument_listContext::Argument_listContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

C8086Parser::ArgumentsContext* C8086Parser::Argument_listContext::arguments() {
  return getRuleContext<C8086Parser::ArgumentsContext>(0);
}


size_t C8086Parser::Argument_listContext::getRuleIndex() const {
  return C8086Parser::RuleArgument_list;
}

void C8086Parser::Argument_listContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterArgument_list(this);
}

void C8086Parser::Argument_listContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitArgument_list(this);
}

C8086Parser::Argument_listContext* C8086Parser::argument_list() {
  Argument_listContext *_localctx = _tracker.createInstance<Argument_listContext>(_ctx, getState());
  enterRule(_localctx, 50, C8086Parser::RuleArgument_list);

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    exitRule();
  });
  try {
    setState(453);
    _errHandler->sync(this);
    switch (_input->LA(1)) {
      case C8086Parser::LPAREN:
      case C8086Parser::ADDOP:
      case C8086Parser::NOT:
      case C8086Parser::ID:
      case C8086Parser::CONST_INT:
      case C8086Parser::CONST_FLOAT: {
        enterOuterAlt(_localctx, 1);
        setState(449);
        antlrcpp::downCast<Argument_listContext *>(_localctx)->a = arguments(0);

                antlrcpp::downCast<Argument_listContext *>(_localctx)->args_string =  antlrcpp::downCast<Argument_listContext *>(_localctx)->a->args_string;
                antlrcpp::downCast<Argument_listContext *>(_localctx)->arg_types =  antlrcpp::downCast<Argument_listContext *>(_localctx)->a->arg_types;
                logLine(antlrcpp::downCast<Argument_listContext *>(_localctx)->a->line_number, "argument_list : arguments");
                writeIntoparserLogFile(_localctx->args_string);
            
        break;
      }

      case C8086Parser::RPAREN: {
        enterOuterAlt(_localctx, 2);

                antlrcpp::downCast<Argument_listContext *>(_localctx)->args_string =  "";
                _localctx->arg_types.clear();
                // logLine(-1, "argument_list :");
                writeIntoparserLogFile(_localctx->args_string);
            
        break;
      }

    default:
      throw NoViableAltException(this);
    }
   
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }

  return _localctx;
}

//----------------- ArgumentsContext ------------------------------------------------------------------

C8086Parser::ArgumentsContext::ArgumentsContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

C8086Parser::Logic_expressionContext* C8086Parser::ArgumentsContext::logic_expression() {
  return getRuleContext<C8086Parser::Logic_expressionContext>(0);
}

tree::TerminalNode* C8086Parser::ArgumentsContext::COMMA() {
  return getToken(C8086Parser::COMMA, 0);
}

C8086Parser::ArgumentsContext* C8086Parser::ArgumentsContext::arguments() {
  return getRuleContext<C8086Parser::ArgumentsContext>(0);
}


size_t C8086Parser::ArgumentsContext::getRuleIndex() const {
  return C8086Parser::RuleArguments;
}

void C8086Parser::ArgumentsContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterArguments(this);
}

void C8086Parser::ArgumentsContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitArguments(this);
}


C8086Parser::ArgumentsContext* C8086Parser::arguments() {
   return arguments(0);
}

C8086Parser::ArgumentsContext* C8086Parser::arguments(int precedence) {
  ParserRuleContext *parentContext = _ctx;
  size_t parentState = getState();
  C8086Parser::ArgumentsContext *_localctx = _tracker.createInstance<ArgumentsContext>(_ctx, parentState);
  C8086Parser::ArgumentsContext *previousContext = _localctx;
  (void)previousContext; // Silence compiler, in case the context is not used by generated code.
  size_t startState = 52;
  enterRecursionRule(_localctx, 52, C8086Parser::RuleArguments, precedence);

    

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    unrollRecursionContexts(parentContext);
  });
  try {
    size_t alt;
    enterOuterAlt(_localctx, 1);
    setState(456);
    antlrcpp::downCast<ArgumentsContext *>(_localctx)->le = logic_expression();

            antlrcpp::downCast<ArgumentsContext *>(_localctx)->args_string =  antlrcpp::downCast<ArgumentsContext *>(_localctx)->le->expr_string;
            antlrcpp::downCast<ArgumentsContext *>(_localctx)->line_number =  antlrcpp::downCast<ArgumentsContext *>(_localctx)->le->line_number;
            _localctx->arg_types.clear();
            _localctx->arg_types.push_back(antlrcpp::downCast<ArgumentsContext *>(_localctx)->le->expr_type);
            logLine(_localctx->line_number, "arguments : logic expression");
            writeIntoparserLogFile(_localctx->args_string);
        
    _ctx->stop = _input->LT(-1);
    setState(466);
    _errHandler->sync(this);
    alt = getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 27, _ctx);
    while (alt != 2 && alt != atn::ATN::INVALID_ALT_NUMBER) {
      if (alt == 1) {
        if (!_parseListeners.empty())
          triggerExitRuleEvent();
        previousContext = _localctx;
        _localctx = _tracker.createInstance<ArgumentsContext>(parentContext, parentState);
        _localctx->a = previousContext;
        pushNewRecursionContext(_localctx, startState, RuleArguments);
        setState(459);

        if (!(precpred(_ctx, 2))) throw FailedPredicateException(this, "precpred(_ctx, 2)");
        setState(460);
        match(C8086Parser::COMMA);
        setState(461);
        antlrcpp::downCast<ArgumentsContext *>(_localctx)->le = logic_expression();

                          antlrcpp::downCast<ArgumentsContext *>(_localctx)->args_string =  antlrcpp::downCast<ArgumentsContext *>(_localctx)->a->args_string + "," + antlrcpp::downCast<ArgumentsContext *>(_localctx)->le->expr_string;
                          antlrcpp::downCast<ArgumentsContext *>(_localctx)->line_number =  antlrcpp::downCast<ArgumentsContext *>(_localctx)->a->line_number;
                          antlrcpp::downCast<ArgumentsContext *>(_localctx)->arg_types =  antlrcpp::downCast<ArgumentsContext *>(_localctx)->a->arg_types;
                          _localctx->arg_types.push_back(antlrcpp::downCast<ArgumentsContext *>(_localctx)->le->expr_type);
                          logLine(_localctx->line_number, "arguments : arguments COMMA logic expression");
                          writeIntoparserLogFile(_localctx->args_string);
                       
      }
      setState(468);
      _errHandler->sync(this);
      alt = getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 27, _ctx);
    }
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }
  return _localctx;
}

bool C8086Parser::sempred(RuleContext *context, size_t ruleIndex, size_t predicateIndex) {
  switch (ruleIndex) {
    case 1: return programSempred(antlrcpp::downCast<ProgramContext *>(context), predicateIndex);
    case 6: return parameter_listSempred(antlrcpp::downCast<Parameter_listContext *>(context), predicateIndex);
    case 11: return declaration_listSempred(antlrcpp::downCast<Declaration_listContext *>(context), predicateIndex);
    case 12: return statementsSempred(antlrcpp::downCast<StatementsContext *>(context), predicateIndex);
    case 14: return switch_casesSempred(antlrcpp::downCast<Switch_casesContext *>(context), predicateIndex);
    case 21: return simple_expressionSempred(antlrcpp::downCast<Simple_expressionContext *>(context), predicateIndex);
    case 22: return termSempred(antlrcpp::downCast<TermContext *>(context), predicateIndex);
    case 26: return argumentsSempred(antlrcpp::downCast<ArgumentsContext *>(context), predicateIndex);

  default:
    break;
  }
  return true;
}

bool C8086Parser::programSempred(ProgramContext *_localctx, size_t predicateIndex) {
  switch (predicateIndex) {
    case 0: return precpred(_ctx, 2);

  default:
    break;
  }
  return true;
}

bool C8086Parser::parameter_listSempred(Parameter_listContext *_localctx, size_t predicateIndex) {
  switch (predicateIndex) {
    case 1: return precpred(_ctx, 4);
    case 2: return precpred(_ctx, 3);

  default:
    break;
  }
  return true;
}

bool C8086Parser::declaration_listSempred(Declaration_listContext *_localctx, size_t predicateIndex) {
  switch (predicateIndex) {
    case 3: return precpred(_ctx, 4);
    case 4: return precpred(_ctx, 3);

  default:
    break;
  }
  return true;
}

bool C8086Parser::statementsSempred(StatementsContext *_localctx, size_t predicateIndex) {
  switch (predicateIndex) {
    case 5: return precpred(_ctx, 1);

  default:
    break;
  }
  return true;
}

bool C8086Parser::switch_casesSempred(Switch_casesContext *_localctx, size_t predicateIndex) {
  switch (predicateIndex) {
    case 6: return precpred(_ctx, 1);

  default:
    break;
  }
  return true;
}

bool C8086Parser::simple_expressionSempred(Simple_expressionContext *_localctx, size_t predicateIndex) {
  switch (predicateIndex) {
    case 7: return precpred(_ctx, 1);

  default:
    break;
  }
  return true;
}

bool C8086Parser::termSempred(TermContext *_localctx, size_t predicateIndex) {
  switch (predicateIndex) {
    case 8: return precpred(_ctx, 1);

  default:
    break;
  }
  return true;
}

bool C8086Parser::argumentsSempred(ArgumentsContext *_localctx, size_t predicateIndex) {
  switch (predicateIndex) {
    case 9: return precpred(_ctx, 2);

  default:
    break;
  }
  return true;
}

void C8086Parser::initialize() {
#if ANTLR4_USE_THREAD_LOCAL_CACHE
  c8086parserParserInitialize();
#else
  ::antlr4::internal::call_once(c8086parserParserOnceFlag, c8086parserParserInitialize);
#endif
}
