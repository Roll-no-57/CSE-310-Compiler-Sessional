
    #pragma once
    #include <iostream>
    #include <fstream>
    #include <string>

    extern std::ofstream lexLogFile;


// Generated from C8086Lexer.g4 by ANTLR 4.13.2


#include "C8086Lexer.h"


using namespace antlr4;



using namespace antlr4;

namespace {

struct C8086LexerStaticData final {
  C8086LexerStaticData(std::vector<std::string> ruleNames,
                          std::vector<std::string> channelNames,
                          std::vector<std::string> modeNames,
                          std::vector<std::string> literalNames,
                          std::vector<std::string> symbolicNames)
      : ruleNames(std::move(ruleNames)), channelNames(std::move(channelNames)),
        modeNames(std::move(modeNames)), literalNames(std::move(literalNames)),
        symbolicNames(std::move(symbolicNames)),
        vocabulary(this->literalNames, this->symbolicNames) {}

  C8086LexerStaticData(const C8086LexerStaticData&) = delete;
  C8086LexerStaticData(C8086LexerStaticData&&) = delete;
  C8086LexerStaticData& operator=(const C8086LexerStaticData&) = delete;
  C8086LexerStaticData& operator=(C8086LexerStaticData&&) = delete;

  std::vector<antlr4::dfa::DFA> decisionToDFA;
  antlr4::atn::PredictionContextCache sharedContextCache;
  const std::vector<std::string> ruleNames;
  const std::vector<std::string> channelNames;
  const std::vector<std::string> modeNames;
  const std::vector<std::string> literalNames;
  const std::vector<std::string> symbolicNames;
  const antlr4::dfa::Vocabulary vocabulary;
  antlr4::atn::SerializedATNView serializedATN;
  std::unique_ptr<antlr4::atn::ATN> atn;
};

::antlr4::internal::OnceFlag c8086lexerLexerOnceFlag;
#if ANTLR4_USE_THREAD_LOCAL_CACHE
static thread_local
#endif
std::unique_ptr<C8086LexerStaticData> c8086lexerLexerStaticData = nullptr;

void c8086lexerLexerInitialize() {
#if ANTLR4_USE_THREAD_LOCAL_CACHE
  if (c8086lexerLexerStaticData != nullptr) {
    return;
  }
#else
  assert(c8086lexerLexerStaticData == nullptr);
#endif
  auto staticData = std::make_unique<C8086LexerStaticData>(
    std::vector<std::string>{
      "LINE_COMMENT", "BLOCK_COMMENT", "STRING", "WS", "IF", "ELSE", "FOR", 
      "WHILE", "DO", "PRINTLN", "RETURN", "INT", "FLOAT", "VOID", "STRUCT", 
      "SWITCH", "CASE", "BREAK", "CONTINUE", "DEFAULT", "LPAREN", "RPAREN", 
      "LCURL", "RCURL", "LTHIRD", "RTHIRD", "SEMICOLON", "COLON", "COMMA", 
      "ADDOP", "MULOP", "INCOP", "DECOP", "NOT", "RELOP", "LOGICOP", "ASSIGNOP", 
      "ID", "CONST_INT", "CONST_FLOAT"
    },
    std::vector<std::string>{
      "DEFAULT_TOKEN_CHANNEL", "HIDDEN"
    },
    std::vector<std::string>{
      "DEFAULT_MODE"
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
  	4,0,40,385,6,-1,2,0,7,0,2,1,7,1,2,2,7,2,2,3,7,3,2,4,7,4,2,5,7,5,2,6,7,
  	6,2,7,7,7,2,8,7,8,2,9,7,9,2,10,7,10,2,11,7,11,2,12,7,12,2,13,7,13,2,14,
  	7,14,2,15,7,15,2,16,7,16,2,17,7,17,2,18,7,18,2,19,7,19,2,20,7,20,2,21,
  	7,21,2,22,7,22,2,23,7,23,2,24,7,24,2,25,7,25,2,26,7,26,2,27,7,27,2,28,
  	7,28,2,29,7,29,2,30,7,30,2,31,7,31,2,32,7,32,2,33,7,33,2,34,7,34,2,35,
  	7,35,2,36,7,36,2,37,7,37,2,38,7,38,2,39,7,39,1,0,1,0,1,0,1,0,5,0,86,8,
  	0,10,0,12,0,89,9,0,1,0,1,0,1,0,1,0,1,1,1,1,1,1,1,1,1,1,5,1,100,8,1,10,
  	1,12,1,103,9,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,2,1,2,1,2,5,2,116,8,
  	2,10,2,12,2,119,9,2,1,2,1,2,1,2,1,2,1,2,1,3,4,3,127,8,3,11,3,12,3,128,
  	1,3,1,3,1,4,1,4,1,4,1,4,1,4,1,5,1,5,1,5,1,5,1,5,1,5,1,5,1,6,1,6,1,6,1,
  	6,1,6,1,6,1,7,1,7,1,7,1,7,1,7,1,7,1,7,1,7,1,8,1,8,1,8,1,8,1,8,1,9,1,9,
  	1,9,1,9,1,9,1,9,1,9,1,9,1,9,1,9,1,10,1,10,1,10,1,10,1,10,1,10,1,10,1,
  	10,1,10,1,11,1,11,1,11,1,11,1,11,1,11,1,12,1,12,1,12,1,12,1,12,1,12,1,
  	12,1,12,1,13,1,13,1,13,1,13,1,13,1,13,1,13,1,14,1,14,1,14,1,14,1,14,1,
  	14,1,14,1,14,1,14,1,15,1,15,1,15,1,15,1,15,1,15,1,15,1,15,1,15,1,16,1,
  	16,1,16,1,16,1,16,1,16,1,16,1,17,1,17,1,17,1,17,1,17,1,17,1,17,1,17,1,
  	18,1,18,1,18,1,18,1,18,1,18,1,18,1,18,1,18,1,18,1,18,1,19,1,19,1,19,1,
  	19,1,19,1,19,1,19,1,19,1,19,1,19,1,20,1,20,1,20,1,21,1,21,1,21,1,22,1,
  	22,1,22,1,23,1,23,1,23,1,24,1,24,1,24,1,25,1,25,1,25,1,26,1,26,1,26,1,
  	27,1,27,1,27,1,28,1,28,1,28,1,29,1,29,1,29,1,30,1,30,1,30,1,31,1,31,1,
  	31,1,31,1,31,1,32,1,32,1,32,1,32,1,32,1,33,1,33,1,33,1,34,1,34,1,34,1,
  	34,1,34,1,34,1,34,1,34,1,34,1,34,1,34,3,34,315,8,34,1,35,1,35,1,35,1,
  	35,1,35,1,35,3,35,323,8,35,1,36,1,36,1,36,1,37,1,37,5,37,330,8,37,10,
  	37,12,37,333,9,37,1,37,1,37,1,38,4,38,338,8,38,11,38,12,38,339,1,38,1,
  	38,1,39,4,39,345,8,39,11,39,12,39,346,1,39,1,39,5,39,351,8,39,10,39,12,
  	39,354,9,39,3,39,356,8,39,1,39,1,39,3,39,360,8,39,1,39,4,39,363,8,39,
  	11,39,12,39,364,3,39,367,8,39,1,39,1,39,1,39,4,39,372,8,39,11,39,12,39,
  	373,1,39,1,39,4,39,378,8,39,11,39,12,39,379,1,39,1,39,3,39,384,8,39,1,
  	101,0,40,1,1,3,2,5,3,7,4,9,5,11,6,13,7,15,8,17,9,19,10,21,11,23,12,25,
  	13,27,14,29,15,31,16,33,17,35,18,37,19,39,20,41,21,43,22,45,23,47,24,
  	49,25,51,26,53,27,55,28,57,29,59,30,61,31,63,32,65,33,67,34,69,35,71,
  	36,73,37,75,38,77,39,79,40,1,0,10,2,0,10,10,13,13,4,0,10,10,13,13,34,
  	34,92,92,3,0,9,10,12,13,32,32,2,0,43,43,45,45,3,0,37,37,42,42,47,47,2,
  	0,60,60,62,62,3,0,65,90,95,95,97,122,4,0,48,57,65,90,95,95,97,122,1,0,
  	48,57,2,0,69,69,101,101,407,0,1,1,0,0,0,0,3,1,0,0,0,0,5,1,0,0,0,0,7,1,
  	0,0,0,0,9,1,0,0,0,0,11,1,0,0,0,0,13,1,0,0,0,0,15,1,0,0,0,0,17,1,0,0,0,
  	0,19,1,0,0,0,0,21,1,0,0,0,0,23,1,0,0,0,0,25,1,0,0,0,0,27,1,0,0,0,0,29,
  	1,0,0,0,0,31,1,0,0,0,0,33,1,0,0,0,0,35,1,0,0,0,0,37,1,0,0,0,0,39,1,0,
  	0,0,0,41,1,0,0,0,0,43,1,0,0,0,0,45,1,0,0,0,0,47,1,0,0,0,0,49,1,0,0,0,
  	0,51,1,0,0,0,0,53,1,0,0,0,0,55,1,0,0,0,0,57,1,0,0,0,0,59,1,0,0,0,0,61,
  	1,0,0,0,0,63,1,0,0,0,0,65,1,0,0,0,0,67,1,0,0,0,0,69,1,0,0,0,0,71,1,0,
  	0,0,0,73,1,0,0,0,0,75,1,0,0,0,0,77,1,0,0,0,0,79,1,0,0,0,1,81,1,0,0,0,
  	3,94,1,0,0,0,5,111,1,0,0,0,7,126,1,0,0,0,9,132,1,0,0,0,11,137,1,0,0,0,
  	13,144,1,0,0,0,15,150,1,0,0,0,17,158,1,0,0,0,19,163,1,0,0,0,21,173,1,
  	0,0,0,23,182,1,0,0,0,25,188,1,0,0,0,27,196,1,0,0,0,29,203,1,0,0,0,31,
  	212,1,0,0,0,33,221,1,0,0,0,35,228,1,0,0,0,37,236,1,0,0,0,39,247,1,0,0,
  	0,41,257,1,0,0,0,43,260,1,0,0,0,45,263,1,0,0,0,47,266,1,0,0,0,49,269,
  	1,0,0,0,51,272,1,0,0,0,53,275,1,0,0,0,55,278,1,0,0,0,57,281,1,0,0,0,59,
  	284,1,0,0,0,61,287,1,0,0,0,63,290,1,0,0,0,65,295,1,0,0,0,67,300,1,0,0,
  	0,69,314,1,0,0,0,71,322,1,0,0,0,73,324,1,0,0,0,75,327,1,0,0,0,77,337,
  	1,0,0,0,79,383,1,0,0,0,81,82,5,47,0,0,82,83,5,47,0,0,83,87,1,0,0,0,84,
  	86,8,0,0,0,85,84,1,0,0,0,86,89,1,0,0,0,87,85,1,0,0,0,87,88,1,0,0,0,88,
  	90,1,0,0,0,89,87,1,0,0,0,90,91,6,0,0,0,91,92,1,0,0,0,92,93,6,0,1,0,93,
  	2,1,0,0,0,94,95,5,47,0,0,95,96,5,42,0,0,96,101,1,0,0,0,97,100,9,0,0,0,
  	98,100,7,0,0,0,99,97,1,0,0,0,99,98,1,0,0,0,100,103,1,0,0,0,101,102,1,
  	0,0,0,101,99,1,0,0,0,102,104,1,0,0,0,103,101,1,0,0,0,104,105,5,42,0,0,
  	105,106,5,47,0,0,106,107,1,0,0,0,107,108,6,1,2,0,108,109,1,0,0,0,109,
  	110,6,1,1,0,110,4,1,0,0,0,111,117,5,34,0,0,112,113,5,92,0,0,113,116,9,
  	0,0,0,114,116,8,1,0,0,115,112,1,0,0,0,115,114,1,0,0,0,116,119,1,0,0,0,
  	117,115,1,0,0,0,117,118,1,0,0,0,118,120,1,0,0,0,119,117,1,0,0,0,120,121,
  	5,34,0,0,121,122,6,2,3,0,122,123,1,0,0,0,123,124,6,2,1,0,124,6,1,0,0,
  	0,125,127,7,2,0,0,126,125,1,0,0,0,127,128,1,0,0,0,128,126,1,0,0,0,128,
  	129,1,0,0,0,129,130,1,0,0,0,130,131,6,3,1,0,131,8,1,0,0,0,132,133,5,105,
  	0,0,133,134,5,102,0,0,134,135,1,0,0,0,135,136,6,4,4,0,136,10,1,0,0,0,
  	137,138,5,101,0,0,138,139,5,108,0,0,139,140,5,115,0,0,140,141,5,101,0,
  	0,141,142,1,0,0,0,142,143,6,5,5,0,143,12,1,0,0,0,144,145,5,102,0,0,145,
  	146,5,111,0,0,146,147,5,114,0,0,147,148,1,0,0,0,148,149,6,6,6,0,149,14,
  	1,0,0,0,150,151,5,119,0,0,151,152,5,104,0,0,152,153,5,105,0,0,153,154,
  	5,108,0,0,154,155,5,101,0,0,155,156,1,0,0,0,156,157,6,7,7,0,157,16,1,
  	0,0,0,158,159,5,100,0,0,159,160,5,111,0,0,160,161,1,0,0,0,161,162,6,8,
  	8,0,162,18,1,0,0,0,163,164,5,112,0,0,164,165,5,114,0,0,165,166,5,105,
  	0,0,166,167,5,110,0,0,167,168,5,116,0,0,168,169,5,108,0,0,169,170,5,110,
  	0,0,170,171,1,0,0,0,171,172,6,9,9,0,172,20,1,0,0,0,173,174,5,114,0,0,
  	174,175,5,101,0,0,175,176,5,116,0,0,176,177,5,117,0,0,177,178,5,114,0,
  	0,178,179,5,110,0,0,179,180,1,0,0,0,180,181,6,10,10,0,181,22,1,0,0,0,
  	182,183,5,105,0,0,183,184,5,110,0,0,184,185,5,116,0,0,185,186,1,0,0,0,
  	186,187,6,11,11,0,187,24,1,0,0,0,188,189,5,102,0,0,189,190,5,108,0,0,
  	190,191,5,111,0,0,191,192,5,97,0,0,192,193,5,116,0,0,193,194,1,0,0,0,
  	194,195,6,12,12,0,195,26,1,0,0,0,196,197,5,118,0,0,197,198,5,111,0,0,
  	198,199,5,105,0,0,199,200,5,100,0,0,200,201,1,0,0,0,201,202,6,13,13,0,
  	202,28,1,0,0,0,203,204,5,115,0,0,204,205,5,116,0,0,205,206,5,114,0,0,
  	206,207,5,117,0,0,207,208,5,99,0,0,208,209,5,116,0,0,209,210,1,0,0,0,
  	210,211,6,14,14,0,211,30,1,0,0,0,212,213,5,115,0,0,213,214,5,119,0,0,
  	214,215,5,105,0,0,215,216,5,116,0,0,216,217,5,99,0,0,217,218,5,104,0,
  	0,218,219,1,0,0,0,219,220,6,15,15,0,220,32,1,0,0,0,221,222,5,99,0,0,222,
  	223,5,97,0,0,223,224,5,115,0,0,224,225,5,101,0,0,225,226,1,0,0,0,226,
  	227,6,16,16,0,227,34,1,0,0,0,228,229,5,98,0,0,229,230,5,114,0,0,230,231,
  	5,101,0,0,231,232,5,97,0,0,232,233,5,107,0,0,233,234,1,0,0,0,234,235,
  	6,17,17,0,235,36,1,0,0,0,236,237,5,99,0,0,237,238,5,111,0,0,238,239,5,
  	110,0,0,239,240,5,116,0,0,240,241,5,105,0,0,241,242,5,110,0,0,242,243,
  	5,117,0,0,243,244,5,101,0,0,244,245,1,0,0,0,245,246,6,18,18,0,246,38,
  	1,0,0,0,247,248,5,100,0,0,248,249,5,101,0,0,249,250,5,102,0,0,250,251,
  	5,97,0,0,251,252,5,117,0,0,252,253,5,108,0,0,253,254,5,116,0,0,254,255,
  	1,0,0,0,255,256,6,19,19,0,256,40,1,0,0,0,257,258,5,40,0,0,258,259,6,20,
  	20,0,259,42,1,0,0,0,260,261,5,41,0,0,261,262,6,21,21,0,262,44,1,0,0,0,
  	263,264,5,123,0,0,264,265,6,22,22,0,265,46,1,0,0,0,266,267,5,125,0,0,
  	267,268,6,23,23,0,268,48,1,0,0,0,269,270,5,91,0,0,270,271,6,24,24,0,271,
  	50,1,0,0,0,272,273,5,93,0,0,273,274,6,25,25,0,274,52,1,0,0,0,275,276,
  	5,59,0,0,276,277,6,26,26,0,277,54,1,0,0,0,278,279,5,58,0,0,279,280,6,
  	27,27,0,280,56,1,0,0,0,281,282,5,44,0,0,282,283,6,28,28,0,283,58,1,0,
  	0,0,284,285,7,3,0,0,285,286,6,29,29,0,286,60,1,0,0,0,287,288,7,4,0,0,
  	288,289,6,30,30,0,289,62,1,0,0,0,290,291,5,43,0,0,291,292,5,43,0,0,292,
  	293,1,0,0,0,293,294,6,31,31,0,294,64,1,0,0,0,295,296,5,45,0,0,296,297,
  	5,45,0,0,297,298,1,0,0,0,298,299,6,32,32,0,299,66,1,0,0,0,300,301,5,33,
  	0,0,301,302,6,33,33,0,302,68,1,0,0,0,303,304,5,60,0,0,304,315,5,61,0,
  	0,305,306,5,61,0,0,306,315,5,61,0,0,307,308,5,62,0,0,308,315,5,61,0,0,
  	309,315,7,5,0,0,310,311,5,33,0,0,311,312,5,61,0,0,312,313,1,0,0,0,313,
  	315,6,34,34,0,314,303,1,0,0,0,314,305,1,0,0,0,314,307,1,0,0,0,314,309,
  	1,0,0,0,314,310,1,0,0,0,315,70,1,0,0,0,316,317,5,38,0,0,317,323,5,38,
  	0,0,318,319,5,124,0,0,319,320,5,124,0,0,320,321,1,0,0,0,321,323,6,35,
  	35,0,322,316,1,0,0,0,322,318,1,0,0,0,323,72,1,0,0,0,324,325,5,61,0,0,
  	325,326,6,36,36,0,326,74,1,0,0,0,327,331,7,6,0,0,328,330,7,7,0,0,329,
  	328,1,0,0,0,330,333,1,0,0,0,331,329,1,0,0,0,331,332,1,0,0,0,332,334,1,
  	0,0,0,333,331,1,0,0,0,334,335,6,37,37,0,335,76,1,0,0,0,336,338,7,8,0,
  	0,337,336,1,0,0,0,338,339,1,0,0,0,339,337,1,0,0,0,339,340,1,0,0,0,340,
  	341,1,0,0,0,341,342,6,38,38,0,342,78,1,0,0,0,343,345,7,8,0,0,344,343,
  	1,0,0,0,345,346,1,0,0,0,346,344,1,0,0,0,346,347,1,0,0,0,347,355,1,0,0,
  	0,348,352,5,46,0,0,349,351,7,8,0,0,350,349,1,0,0,0,351,354,1,0,0,0,352,
  	350,1,0,0,0,352,353,1,0,0,0,353,356,1,0,0,0,354,352,1,0,0,0,355,348,1,
  	0,0,0,355,356,1,0,0,0,356,366,1,0,0,0,357,359,7,9,0,0,358,360,7,3,0,0,
  	359,358,1,0,0,0,359,360,1,0,0,0,360,362,1,0,0,0,361,363,7,8,0,0,362,361,
  	1,0,0,0,363,364,1,0,0,0,364,362,1,0,0,0,364,365,1,0,0,0,365,367,1,0,0,
  	0,366,357,1,0,0,0,366,367,1,0,0,0,367,368,1,0,0,0,368,384,6,39,39,0,369,
  	371,5,46,0,0,370,372,7,8,0,0,371,370,1,0,0,0,372,373,1,0,0,0,373,371,
  	1,0,0,0,373,374,1,0,0,0,374,375,1,0,0,0,375,384,6,39,40,0,376,378,7,8,
  	0,0,377,376,1,0,0,0,378,379,1,0,0,0,379,377,1,0,0,0,379,380,1,0,0,0,380,
  	381,1,0,0,0,381,382,5,46,0,0,382,384,6,39,41,0,383,344,1,0,0,0,383,369,
  	1,0,0,0,383,377,1,0,0,0,384,80,1,0,0,0,20,0,87,99,101,115,117,128,314,
  	322,331,339,346,352,355,359,364,366,373,379,383,42,1,0,0,6,0,0,1,1,1,
  	1,2,2,1,4,3,1,5,4,1,6,5,1,7,6,1,8,7,1,9,8,1,10,9,1,11,10,1,12,11,1,13,
  	12,1,14,13,1,15,14,1,16,15,1,17,16,1,18,17,1,19,18,1,20,19,1,21,20,1,
  	22,21,1,23,22,1,24,23,1,25,24,1,26,25,1,27,26,1,28,27,1,29,28,1,30,29,
  	1,31,30,1,32,31,1,33,32,1,34,33,1,35,34,1,36,35,1,37,36,1,38,37,1,39,
  	38,1,39,39,1,39,40
  };
  staticData->serializedATN = antlr4::atn::SerializedATNView(serializedATNSegment, sizeof(serializedATNSegment) / sizeof(serializedATNSegment[0]));

  antlr4::atn::ATNDeserializer deserializer;
  staticData->atn = deserializer.deserialize(staticData->serializedATN);

  const size_t count = staticData->atn->getNumberOfDecisions();
  staticData->decisionToDFA.reserve(count);
  for (size_t i = 0; i < count; i++) { 
    staticData->decisionToDFA.emplace_back(staticData->atn->getDecisionState(i), i);
  }
  c8086lexerLexerStaticData = std::move(staticData);
}

}

C8086Lexer::C8086Lexer(CharStream *input) : Lexer(input) {
  C8086Lexer::initialize();
  _interpreter = new atn::LexerATNSimulator(this, *c8086lexerLexerStaticData->atn, c8086lexerLexerStaticData->decisionToDFA, c8086lexerLexerStaticData->sharedContextCache);
}

C8086Lexer::~C8086Lexer() {
  delete _interpreter;
}

std::string C8086Lexer::getGrammarFileName() const {
  return "C8086Lexer.g4";
}

const std::vector<std::string>& C8086Lexer::getRuleNames() const {
  return c8086lexerLexerStaticData->ruleNames;
}

const std::vector<std::string>& C8086Lexer::getChannelNames() const {
  return c8086lexerLexerStaticData->channelNames;
}

const std::vector<std::string>& C8086Lexer::getModeNames() const {
  return c8086lexerLexerStaticData->modeNames;
}

const dfa::Vocabulary& C8086Lexer::getVocabulary() const {
  return c8086lexerLexerStaticData->vocabulary;
}

antlr4::atn::SerializedATNView C8086Lexer::getSerializedATN() const {
  return c8086lexerLexerStaticData->serializedATN;
}

const atn::ATN& C8086Lexer::getATN() const {
  return *c8086lexerLexerStaticData->atn;
}


void C8086Lexer::action(RuleContext *context, size_t ruleIndex, size_t actionIndex) {
  switch (ruleIndex) {
    case 0: LINE_COMMENTAction(antlrcpp::downCast<antlr4::RuleContext *>(context), actionIndex); break;
    case 1: BLOCK_COMMENTAction(antlrcpp::downCast<antlr4::RuleContext *>(context), actionIndex); break;
    case 2: STRINGAction(antlrcpp::downCast<antlr4::RuleContext *>(context), actionIndex); break;
    case 4: IFAction(antlrcpp::downCast<antlr4::RuleContext *>(context), actionIndex); break;
    case 5: ELSEAction(antlrcpp::downCast<antlr4::RuleContext *>(context), actionIndex); break;
    case 6: FORAction(antlrcpp::downCast<antlr4::RuleContext *>(context), actionIndex); break;
    case 7: WHILEAction(antlrcpp::downCast<antlr4::RuleContext *>(context), actionIndex); break;
    case 8: DOAction(antlrcpp::downCast<antlr4::RuleContext *>(context), actionIndex); break;
    case 9: PRINTLNAction(antlrcpp::downCast<antlr4::RuleContext *>(context), actionIndex); break;
    case 10: RETURNAction(antlrcpp::downCast<antlr4::RuleContext *>(context), actionIndex); break;
    case 11: INTAction(antlrcpp::downCast<antlr4::RuleContext *>(context), actionIndex); break;
    case 12: FLOATAction(antlrcpp::downCast<antlr4::RuleContext *>(context), actionIndex); break;
    case 13: VOIDAction(antlrcpp::downCast<antlr4::RuleContext *>(context), actionIndex); break;
    case 14: STRUCTAction(antlrcpp::downCast<antlr4::RuleContext *>(context), actionIndex); break;
    case 15: SWITCHAction(antlrcpp::downCast<antlr4::RuleContext *>(context), actionIndex); break;
    case 16: CASEAction(antlrcpp::downCast<antlr4::RuleContext *>(context), actionIndex); break;
    case 17: BREAKAction(antlrcpp::downCast<antlr4::RuleContext *>(context), actionIndex); break;
    case 18: CONTINUEAction(antlrcpp::downCast<antlr4::RuleContext *>(context), actionIndex); break;
    case 19: DEFAULTAction(antlrcpp::downCast<antlr4::RuleContext *>(context), actionIndex); break;
    case 20: LPARENAction(antlrcpp::downCast<antlr4::RuleContext *>(context), actionIndex); break;
    case 21: RPARENAction(antlrcpp::downCast<antlr4::RuleContext *>(context), actionIndex); break;
    case 22: LCURLAction(antlrcpp::downCast<antlr4::RuleContext *>(context), actionIndex); break;
    case 23: RCURLAction(antlrcpp::downCast<antlr4::RuleContext *>(context), actionIndex); break;
    case 24: LTHIRDAction(antlrcpp::downCast<antlr4::RuleContext *>(context), actionIndex); break;
    case 25: RTHIRDAction(antlrcpp::downCast<antlr4::RuleContext *>(context), actionIndex); break;
    case 26: SEMICOLONAction(antlrcpp::downCast<antlr4::RuleContext *>(context), actionIndex); break;
    case 27: COLONAction(antlrcpp::downCast<antlr4::RuleContext *>(context), actionIndex); break;
    case 28: COMMAAction(antlrcpp::downCast<antlr4::RuleContext *>(context), actionIndex); break;
    case 29: ADDOPAction(antlrcpp::downCast<antlr4::RuleContext *>(context), actionIndex); break;
    case 30: MULOPAction(antlrcpp::downCast<antlr4::RuleContext *>(context), actionIndex); break;
    case 31: INCOPAction(antlrcpp::downCast<antlr4::RuleContext *>(context), actionIndex); break;
    case 32: DECOPAction(antlrcpp::downCast<antlr4::RuleContext *>(context), actionIndex); break;
    case 33: NOTAction(antlrcpp::downCast<antlr4::RuleContext *>(context), actionIndex); break;
    case 34: RELOPAction(antlrcpp::downCast<antlr4::RuleContext *>(context), actionIndex); break;
    case 35: LOGICOPAction(antlrcpp::downCast<antlr4::RuleContext *>(context), actionIndex); break;
    case 36: ASSIGNOPAction(antlrcpp::downCast<antlr4::RuleContext *>(context), actionIndex); break;
    case 37: IDAction(antlrcpp::downCast<antlr4::RuleContext *>(context), actionIndex); break;
    case 38: CONST_INTAction(antlrcpp::downCast<antlr4::RuleContext *>(context), actionIndex); break;
    case 39: CONST_FLOATAction(antlrcpp::downCast<antlr4::RuleContext *>(context), actionIndex); break;

  default:
    break;
  }
}

void C8086Lexer::LINE_COMMENTAction(antlr4::RuleContext *context, size_t actionIndex) {
  switch (actionIndex) {
    case 0: 
            writeIntoLexLogFile(
              "Line# " + std::to_string(getLine())
              + ": Token <SINGLE LINE COMMENT> Lexeme "
              + getText()
            );
         break;

  default:
    break;
  }
}

void C8086Lexer::BLOCK_COMMENTAction(antlr4::RuleContext *context, size_t actionIndex) {
  switch (actionIndex) {
    case 1: 
          // extra braces create a new scope for your variables
          {
            std::string txt = getText();
            std::string content = txt.substr(2, txt.size() - 4);
            writeIntoLexLogFile(
              "Line# " + std::to_string(getLine())
              + ": Token <MULTI LINE COMMENT> Lexeme /*"
              + content + "*/"
            );
          }
         break;

  default:
    break;
  }
}

void C8086Lexer::STRINGAction(antlr4::RuleContext *context, size_t actionIndex) {
  switch (actionIndex) {
    case 2: 
            writeIntoLexLogFile(
              "Line# " + std::to_string(getLine())
              + ": Token <STRING> Lexeme " + getText()
            );
         break;

  default:
    break;
  }
}

void C8086Lexer::IFAction(antlr4::RuleContext *context, size_t actionIndex) {
  switch (actionIndex) {
    case 3:  writeIntoLexLogFile("Line# " + std::to_string(getLine()) + ": Token <IF> Lexeme " + getText());  break;

  default:
    break;
  }
}

void C8086Lexer::ELSEAction(antlr4::RuleContext *context, size_t actionIndex) {
  switch (actionIndex) {
    case 4:  writeIntoLexLogFile("Line# " + std::to_string(getLine()) + ": Token <ELSE> Lexeme " + getText());  break;

  default:
    break;
  }
}

void C8086Lexer::FORAction(antlr4::RuleContext *context, size_t actionIndex) {
  switch (actionIndex) {
    case 5:  writeIntoLexLogFile("Line# " + std::to_string(getLine()) + ": Token <FOR> Lexeme " + getText());  break;

  default:
    break;
  }
}

void C8086Lexer::WHILEAction(antlr4::RuleContext *context, size_t actionIndex) {
  switch (actionIndex) {
    case 6:  writeIntoLexLogFile("Line# " + std::to_string(getLine()) + ": Token <WHILE> Lexeme " + getText());  break;

  default:
    break;
  }
}

void C8086Lexer::DOAction(antlr4::RuleContext *context, size_t actionIndex) {
  switch (actionIndex) {
    case 7:  writeIntoLexLogFile("Line# " + std::to_string(getLine()) + ": Token <DO> Lexeme " + getText());  break;

  default:
    break;
  }
}

void C8086Lexer::PRINTLNAction(antlr4::RuleContext *context, size_t actionIndex) {
  switch (actionIndex) {
    case 8:  writeIntoLexLogFile("Line# " + std::to_string(getLine()) + ": Token <PRINTLN> Lexeme " + getText());  break;

  default:
    break;
  }
}

void C8086Lexer::RETURNAction(antlr4::RuleContext *context, size_t actionIndex) {
  switch (actionIndex) {
    case 9:  writeIntoLexLogFile("Line# " + std::to_string(getLine()) + ": Token <RETURN> Lexeme " + getText());  break;

  default:
    break;
  }
}

void C8086Lexer::INTAction(antlr4::RuleContext *context, size_t actionIndex) {
  switch (actionIndex) {
    case 10:  writeIntoLexLogFile("Line# " + std::to_string(getLine()) + ": Token <INT> Lexeme " + getText());  break;

  default:
    break;
  }
}

void C8086Lexer::FLOATAction(antlr4::RuleContext *context, size_t actionIndex) {
  switch (actionIndex) {
    case 11:  writeIntoLexLogFile("Line# " + std::to_string(getLine()) + ": Token <FLOAT> Lexeme " + getText());  break;

  default:
    break;
  }
}

void C8086Lexer::VOIDAction(antlr4::RuleContext *context, size_t actionIndex) {
  switch (actionIndex) {
    case 12:  writeIntoLexLogFile("Line# " + std::to_string(getLine()) + ": Token <VOID> Lexeme " + getText());  break;

  default:
    break;
  }
}

void C8086Lexer::STRUCTAction(antlr4::RuleContext *context, size_t actionIndex) {
  switch (actionIndex) {
    case 13: writeIntoLexLogFile("Line# " + std::to_string(getLine()) + ": Token <STRUCT> Lexeme " + getText()); break;

  default:
    break;
  }
}

void C8086Lexer::SWITCHAction(antlr4::RuleContext *context, size_t actionIndex) {
  switch (actionIndex) {
    case 14: writeIntoLexLogFile("Line# " + std::to_string(getLine()) + ": Token <SWITCH> Lexeme " + getText()); break;

  default:
    break;
  }
}

void C8086Lexer::CASEAction(antlr4::RuleContext *context, size_t actionIndex) {
  switch (actionIndex) {
    case 15: writeIntoLexLogFile("Line# " + std::to_string(getLine()) + ": Token <CASE> Lexeme " + getText()); break;

  default:
    break;
  }
}

void C8086Lexer::BREAKAction(antlr4::RuleContext *context, size_t actionIndex) {
  switch (actionIndex) {
    case 16: writeIntoLexLogFile("Line# " + std::to_string(getLine()) + ": Token <BREAK> Lexeme " + getText()); break;

  default:
    break;
  }
}

void C8086Lexer::CONTINUEAction(antlr4::RuleContext *context, size_t actionIndex) {
  switch (actionIndex) {
    case 17: writeIntoLexLogFile("Line# " + std::to_string(getLine()) + ": Token <CONTINUE> Lexeme " + getText()); break;

  default:
    break;
  }
}

void C8086Lexer::DEFAULTAction(antlr4::RuleContext *context, size_t actionIndex) {
  switch (actionIndex) {
    case 18: writeIntoLexLogFile("Line# " + std::to_string(getLine()) + ": Token <DEFAULT> Lexeme " + getText()); break;

  default:
    break;
  }
}

void C8086Lexer::LPARENAction(antlr4::RuleContext *context, size_t actionIndex) {
  switch (actionIndex) {
    case 19:  writeIntoLexLogFile("Line# " + std::to_string(getLine()) + ": Token <LPAREN> Lexeme " + getText());  break;

  default:
    break;
  }
}

void C8086Lexer::RPARENAction(antlr4::RuleContext *context, size_t actionIndex) {
  switch (actionIndex) {
    case 20:  writeIntoLexLogFile("Line# " + std::to_string(getLine()) + ": Token <RPAREN> Lexeme " + getText());  break;

  default:
    break;
  }
}

void C8086Lexer::LCURLAction(antlr4::RuleContext *context, size_t actionIndex) {
  switch (actionIndex) {
    case 21:  writeIntoLexLogFile("Line# " + std::to_string(getLine()) + ": Token <LCURL> Lexeme " + getText());  break;

  default:
    break;
  }
}

void C8086Lexer::RCURLAction(antlr4::RuleContext *context, size_t actionIndex) {
  switch (actionIndex) {
    case 22:  writeIntoLexLogFile("Line# " + std::to_string(getLine()) + ": Token <RCURL> Lexeme " + getText());  break;

  default:
    break;
  }
}

void C8086Lexer::LTHIRDAction(antlr4::RuleContext *context, size_t actionIndex) {
  switch (actionIndex) {
    case 23:  writeIntoLexLogFile("Line# " + std::to_string(getLine()) + ": Token <LTHIRD> Lexeme " + getText());  break;

  default:
    break;
  }
}

void C8086Lexer::RTHIRDAction(antlr4::RuleContext *context, size_t actionIndex) {
  switch (actionIndex) {
    case 24:  writeIntoLexLogFile("Line# " + std::to_string(getLine()) + ": Token <RTHIRD> Lexeme " + getText());  break;

  default:
    break;
  }
}

void C8086Lexer::SEMICOLONAction(antlr4::RuleContext *context, size_t actionIndex) {
  switch (actionIndex) {
    case 25:  writeIntoLexLogFile("Line# " + std::to_string(getLine()) + ": Token <SEMICOLON> Lexeme " + getText());  break;

  default:
    break;
  }
}

void C8086Lexer::COLONAction(antlr4::RuleContext *context, size_t actionIndex) {
  switch (actionIndex) {
    case 26:  writeIntoLexLogFile("Line# " + std::to_string(getLine()) + ": Token <COLON> Lexeme " + getText());  break;

  default:
    break;
  }
}

void C8086Lexer::COMMAAction(antlr4::RuleContext *context, size_t actionIndex) {
  switch (actionIndex) {
    case 27:  writeIntoLexLogFile("Line# " + std::to_string(getLine()) + ": Token <COMMA> Lexeme " + getText());  break;

  default:
    break;
  }
}

void C8086Lexer::ADDOPAction(antlr4::RuleContext *context, size_t actionIndex) {
  switch (actionIndex) {
    case 28:  writeIntoLexLogFile("Line# " + std::to_string(getLine()) + ": Token <ADDOP> Lexeme " + getText());  break;

  default:
    break;
  }
}

void C8086Lexer::MULOPAction(antlr4::RuleContext *context, size_t actionIndex) {
  switch (actionIndex) {
    case 29:  writeIntoLexLogFile("Line# " + std::to_string(getLine()) + ": Token <MULOP> Lexeme " + getText());  break;

  default:
    break;
  }
}

void C8086Lexer::INCOPAction(antlr4::RuleContext *context, size_t actionIndex) {
  switch (actionIndex) {
    case 30:  writeIntoLexLogFile("Line# " + std::to_string(getLine()) + ": Token <INCOP> Lexeme " + getText());  break;

  default:
    break;
  }
}

void C8086Lexer::DECOPAction(antlr4::RuleContext *context, size_t actionIndex) {
  switch (actionIndex) {
    case 31:  writeIntoLexLogFile("Line# " + std::to_string(getLine()) + ": Token <DECOP> Lexeme " + getText());  break;

  default:
    break;
  }
}

void C8086Lexer::NOTAction(antlr4::RuleContext *context, size_t actionIndex) {
  switch (actionIndex) {
    case 32:  writeIntoLexLogFile("Line# " + std::to_string(getLine()) + ": Token <NOT> Lexeme " + getText());  break;

  default:
    break;
  }
}

void C8086Lexer::RELOPAction(antlr4::RuleContext *context, size_t actionIndex) {
  switch (actionIndex) {
    case 33:  writeIntoLexLogFile("Line# " + std::to_string(getLine()) + ": Token <RELOP> Lexeme " + getText());  break;

  default:
    break;
  }
}

void C8086Lexer::LOGICOPAction(antlr4::RuleContext *context, size_t actionIndex) {
  switch (actionIndex) {
    case 34:  writeIntoLexLogFile("Line# " + std::to_string(getLine()) + ": Token <LOGICOP> Lexeme " + getText());  break;

  default:
    break;
  }
}

void C8086Lexer::ASSIGNOPAction(antlr4::RuleContext *context, size_t actionIndex) {
  switch (actionIndex) {
    case 35:  writeIntoLexLogFile("Line# " + std::to_string(getLine()) + ": Token <ASSIGNOP> Lexeme " + getText());  break;

  default:
    break;
  }
}

void C8086Lexer::IDAction(antlr4::RuleContext *context, size_t actionIndex) {
  switch (actionIndex) {
    case 36:  writeIntoLexLogFile("Line# " + std::to_string(getLine()) + ": Token <ID> Lexeme " + getText());  break;

  default:
    break;
  }
}

void C8086Lexer::CONST_INTAction(antlr4::RuleContext *context, size_t actionIndex) {
  switch (actionIndex) {
    case 37:  writeIntoLexLogFile("Line# " + std::to_string(getLine()) + ": Token <CONST_INT> Lexeme " + getText());  break;

  default:
    break;
  }
}

void C8086Lexer::CONST_FLOATAction(antlr4::RuleContext *context, size_t actionIndex) {
  switch (actionIndex) {
    case 38: 
            writeIntoLexLogFile(
              "Line# " + std::to_string(getLine())
              + ": Token <CONST_FLOAT> Lexeme " + getText()
            );
         break;
    case 39: 
            writeIntoLexLogFile(
              "Line# " + std::to_string(getLine())
              + ": Token <CONST_FLOAT> Lexeme " + getText()
            );
         break;
    case 40: 
            writeIntoLexLogFile(
              "Line# " + std::to_string(getLine())
              + ": Token <CONST_FLOAT> Lexeme " + getText()
            );
         break;

  default:
    break;
  }
}



void C8086Lexer::initialize() {
#if ANTLR4_USE_THREAD_LOCAL_CACHE
  c8086lexerLexerInitialize();
#else
  ::antlr4::internal::call_once(c8086lexerLexerOnceFlag, c8086lexerLexerInitialize);
#endif
}
