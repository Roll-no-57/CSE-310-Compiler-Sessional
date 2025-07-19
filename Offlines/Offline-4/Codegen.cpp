#ifndef CODEGEN_HPP
#define CODEGEN_HPP

#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <stack>
#include <map>
#include <utility>
#include "headers/2105057_symbolInfo.hpp"
#include "headers/2105057_Hash.hpp"
#include "headers/2105057_SymbolTable.hpp"

class CodeGenerator {
private:
    // File streams
    std::ofstream* asmFile;
    std::ofstream* parserLogFile;
    std::ofstream* errorFile;
    
    // Symbol table for managing variables and scope
    // SymbolTable*;
    int numberOfBuckets = 7;  // Add type declaration
    HashFunction hashFunc = &Hash::SDBMHash;
    SymbolTable * symbolTable= new SymbolTable(numberOfBuckets, hashFunc, true);  // Use numberOfBuckets, not numOfBuckets
    
    // Stack management
    int currentStackOffset;
    std::stack<int> stackOffsetStack;
    std::map<std::string, int> variableOffsets;
    
    // Label generation
    int labelCounter;
    
    // Function context
    std::string currentFunction;
    bool inFunction;
    
    // Error tracking
    int* syntaxErrorCount;

public:
    // Constructor
    CodeGenerator(std::ofstream* asmFile, std::ofstream* parserLogFile, 
                  std::ofstream* errorFile, int* syntaxErrorCount);
    
    // Destructor
    ~CodeGenerator();
    
    // Initialization
    void initializeSymbolTable();
    void generateProgramHeader();
    void generateProgramFooter();
    
    // Scope management
    void enterNewScope();
    void exitCurrentScope();
    
    // Function context management
    void enterFunction(const std::string& functionName);
    void exitFunction();
    
    // Variable management
    bool declareVariable(const std::string& name, const std::string& type, 
                        int arraySize = -1, int lineNo = -1);
    int getVariableOffset(const std::string& varName);
    bool isVariableDeclared(const std::string& varName);
    
    // Code generation utilities
    void writeAssembly(const std::string& code, int lineNo = -1);
    void writeComment(const std::string& comment, int lineNo = -1);
    std::string generateLabel();
    
    // Assembly code generation
    void generateDataSegmentHeader();
    void generateDataSegmentFooter();
    void generatePrintOutputProcedure();
    void generateNewLineProcedure();
    
    // Variable operations
    void generateVariableDeclaration(const std::string& type, 
                                   const std::vector<std::pair<std::string, int>>& variables,
                                   int lineNo = -1);
    void generateVariableAssignment(const std::string& varName, 
                                  const std::string& value, int lineNo = -1);
    void generateArrayAccess(const std::string& arrayName, 
                           const std::string& indexReg = "BX");
    
    // Expression code generation
    void generateConstantLoad(int value);
    void generateConstantLoad(float value);
    void generateVariableLoad(const std::string& varName);
    void generateVariableStore(const std::string& varName);
    
    // Statement code generation
    void generatePrintStatement(const std::string& varName, int lineNo = -1);
    void generateReturnStatement(int lineNo = -1);
    
    // Stack operations
    void generateStackAllocation(int size);
    void generateStackDeallocation(int size);
    
    // Logging utilities
    void writeParserLog(const std::string& message);
    void writeError(const std::string& message);
    
    // Utility functions
    std::string getVariableAccessCode(const std::string& varName);
    std::string getArrayAccessCode(const std::string& arrayName, 
                                 const std::string& indexReg = "BX");
    int calculateVariableSize(const std::string& type, int arraySize = -1);
};

// Global instance (to be used in parser)
extern CodeGenerator* codeGen;

// Helper functions for parser
void initializeCodeGenerator(std::ofstream* asmFile, std::ofstream* parserLogFile, 
                           std::ofstream* errorFile, int* syntaxErrorCount);
void finalizeCodeGenerator();

#endif // CODEGEN_HPP
