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
    
    // Declare the file streams 
    std::ofstream* parserLogFile;
    std::ofstream* errorFile;
    std::ofstream* dataSectionFile;
    std::ofstream* codeSectionFile;

    // Symbol table for managing variables and functions
    int numberOfBuckets;
    SymbolTable* symbolTable ;
    

    // Stack management for function calls
    int currentStackOffset ;

    // boolean to check if we are in the global scope or not 
    bool isGlobalScope = true;


public:
    // Constructor
    CodeGenerator(std::ofstream* parserLogFile, 
                  std::ofstream* errorFile , std::ofstream* dataSectionFile, std::ofstream* codeSectionFile);
    
    // Destructor
    ~CodeGenerator();


    // Initialization
    void initializeSymbolTable();

    // This Function will generate the header of 8086 assembly code in the dataSectionFile
    void GenProgramHeader();



    // This portion is for Data Section
    void GenDataSectionHeader();


    // This portion is for Code Section
    void GenCodeSectionHeader();


    // Checks if we are currently in global scope or not
    bool isInGlobalScope() const {
        return isGlobalScope;
    }

    // set the status of global scope
    void setIsGlobalScope(bool status) {
        isGlobalScope = status;
    }

    int getCurrentStackOffset() const {
        return currentStackOffset;
    }

    void setCurrentStackOffset(int offset) {
        currentStackOffset = offset;
    }

    
    //========================== Data handling functions ==========================



    // Constants handling functions
    void GenLoadConstInt(int value, int lineNumber);
    void GenLoadConstFloat(float value, int lineNumber);

    
    // Non-array variables handling
    void GenGlobalVariableDeclaration(const std::string& name, const std::string& type, int lineNumber) ;
    void GenLocalVariableDeclaration(const std::string& name,const std::string& tyep,int lineNumber);
    // void GenLoadVariable(const std::string& name, int lineNumber);
    // void GenStoreVariable(const std::string& name ,int lineNumber);


    // Array variables handling
    void GenGlobalArrayDeclaration(const std::string& name, const std::string& type, int size, int lineNumber);
    void GenLocalArrayDeclaration(const std::string& name, const std::string& type, int size, int lineNumber);
    // void GenLoadArrayElement(const std::string& name, int lineNumber);
    // void GenStoreArrayElement(const std::string& name, int lineNumber);


    // Variable access helpers
    std::string getVariableAddress(const std::string& name);
    // int getVariableStackOffset(const std::string& name);




    // Assignment operation
    void GenAssignmentOp(const std::string& varname, const std::string& reg, int lineNumber) ;






    // Stack operation Functions
    void GenPushToStack(const std::string& reg, int lineNumber);
    void GenPopFromStack(const std::string& reg, int lineNumber);
    void GenAllocateStackSpace(int bytes,int lineNumber);
    void GenDeallocateStackSpace(int bytes,int lineNumber);








    //prints a variable 
    void GenPrintlnFunction();


    // This Function will generate the footer of 8086 assembly code in the codeSectionFile
    void GenProgramFooter();




    //============================ Helper functions===========================

    // Helper functions for code generation
    // This will write to file like :
    // MOV AX, 5    ; line 10
    void writeToFile(std::ofstream* file,const std::string& code , int lineNumber , bool lineComment = false);
    
    // Helper function for comment 
    void writeComment(std::ofstream* file, const std::string& comment, int lineNumber);
    

};


// Global instance (to be used in parser)
extern CodeGenerator* codeGen;

// Helper functions for parser to create CodeGenerator instance 
void initializeCodeGenerator(std::ofstream* parserLogFile, std::ofstream* errorFile,std::ofstream* dataSectionFile, std::ofstream* codeSectionFile);


// Function to finalize or clean up the CodeGenerator instance
void finalizeCodeGenerator();




#endif // CODEGEN_HPP