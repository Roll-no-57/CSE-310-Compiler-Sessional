#include <iostream>
#include <fstream>
#include <string>
#include "antlr4-runtime.h"
#include "C8086Lexer.h"
#include "C8086CodeGen.h"
#include "CodeGenerator.hpp"

using namespace antlr4;
using namespace std;

ofstream parserLogFile; // global output stream
ofstream errorFile; // global error stream
ofstream lexLogFile; // global lexer log stream
ofstream dataSectionFile; // global data section file
ofstream codeSectionFile; // global code section file



int main(int argc, const char* argv[]) {
    if (argc < 2) {
        cerr << "Usage: " << argv[0] << " <input_file>" << endl;
        return 1;
    }

    // ---- Input File ----
    ifstream inputFile(argv[1]);
    if (!inputFile.is_open()) {
        cerr << "Error opening input file: " << argv[1] << endl;
        return 1;
    }

    string outputDirectory = "output/";
    string parserLogFileName = outputDirectory + "parserLog.txt";
    string errorFileName = outputDirectory + "errorLog.txt";
    string lexLogFileName = outputDirectory + "lexerLog.txt";
    string assemblyFileName = outputDirectory + "AssemblyCode.asm";
    string tempDataFileName = outputDirectory + "temp_data.asm";
    string tempCodeFileName = outputDirectory + "temp_code.asm";




    // create output directory if it doesn't exist
    system(("mkdir -p " + outputDirectory).c_str());

    // ---- Output Files ----
    parserLogFile.open(parserLogFileName);
    if (!parserLogFile.is_open()) {
        cerr << "Error opening parser log file: " << parserLogFileName << endl;
        return 1;
    }

    errorFile.open(errorFileName);
    if (!errorFile.is_open()) {
        cerr << "Error opening error log file: " << errorFileName << endl;
        return 1;
    }

    lexLogFile.open(lexLogFileName);
    if (!lexLogFile.is_open()) {
        cerr << "Error opening lexer log file: " << lexLogFileName << endl;
        return 1;
    }


    dataSectionFile.open(tempDataFileName);
    if (!dataSectionFile.is_open()) {
        cerr << "Error opening dataSection file: " << tempDataFileName << endl;
        return 1;
    }


    codeSectionFile.open(tempCodeFileName);
    if (!codeSectionFile.is_open()) {
        cerr << "Error opening codeSection file: " << tempCodeFileName << endl;
        return 1;
    }







    // ---- Initialize Code Generator ----
    initializeCodeGenerator(&parserLogFile, &errorFile , &dataSectionFile, &codeSectionFile);
   
    // ---- Parsing Flow ----
    ANTLRInputStream input(inputFile);
    C8086Lexer lexer(&input);
    CommonTokenStream tokens(&lexer);
    C8086CodeGen parser(&tokens);

    // this is necessary to avoid the default error listener and use our custom error handling
    parser.removeErrorListeners();

    try {
        // start parsing at the 'start' rule
        parser.start();
        
        cout << "Parsing completed successfully!" << endl;
        cout << "Generated files:" << endl;
        cout << "  - Assembly code: " << assemblyFileName << endl;
        cout << "  - Parser log: " << parserLogFileName << endl;
        cout << "  - Error log: " << errorFileName << endl;
        cout << "  - Lexer log: " << lexLogFileName << endl;
        
    } catch (const exception& e) {
        cerr << "Error during parsing: " << e.what() << endl;
        return 1;
    }

    // ---- Cleanup ----
    finalizeCodeGenerator();
    
    inputFile.close();
    parserLogFile.close();
    errorFile.close();
    lexLogFile.close();
    dataSectionFile.close();
    codeSectionFile.close();

    // Now merge the temporary data and code files into the final assembly file
    std::ifstream tempData(tempDataFileName);
    std::ifstream tempCode(tempCodeFileName);
    std::ofstream assemblyFile(assemblyFileName);

    assemblyFile << tempData.rdbuf();
    assemblyFile << tempCode.rdbuf();

    tempData.close();
    tempCode.close();
    assemblyFile.close();

    // Clean up temporary files
    std::remove(tempDataFileName.c_str());
    std::remove(tempCodeFileName.c_str());

    cout << "Final assembly code written to: " << assemblyFileName << endl;

    return 0;
}