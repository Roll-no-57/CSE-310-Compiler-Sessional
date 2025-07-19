#include "CodeGenerator.hpp"

// Global instance
CodeGenerator* codeGen = nullptr;

// Constructor
CodeGenerator::CodeGenerator(std::ofstream* asmFile, std::ofstream* parserLogFile, 
                           std::ofstream* errorFile, int* syntaxErrorCount) 
    : asmFile(asmFile), parserLogFile(parserLogFile), errorFile(errorFile),
      symbolTable(nullptr), currentStackOffset(0), labelCounter(0),
      currentFunction(""), inFunction(false), syntaxErrorCount(syntaxErrorCount) {
}

// Destructor
CodeGenerator::~CodeGenerator() {
    if (symbolTable) {
        delete symbolTable;
    }
}

// Initialize symbol table
void CodeGenerator::initializeSymbolTable() {
    symbolTable = new SymbolTable(31); // 31 buckets
}

// Generate program header
void CodeGenerator::generateProgramHeader() {
    generateDataSegmentHeader();
}

// Generate program footer
void CodeGenerator::generateProgramFooter() {
    generateDataSegmentFooter();
}

// Enter new scope
void CodeGenerator::enterNewScope() {
    if (symbolTable) {
        symbolTable->enterScope();
    }
    stackOffsetStack.push(currentStackOffset);
}

// Exit current scope
void CodeGenerator::exitCurrentScope() {
    if (symbolTable) {
        symbolTable->exitScope();
    }
    if (!stackOffsetStack.empty()) {
        currentStackOffset = stackOffsetStack.top();
        stackOffsetStack.pop();
    }
}

// Enter function context
void CodeGenerator::enterFunction(const std::string& functionName) {
    currentFunction = functionName;
    inFunction = true;
    enterNewScope();
}

// Exit function context
void CodeGenerator::exitFunction() {
    exitCurrentScope();
    inFunction = false;
    currentFunction = "";
}

// Declare a variable
bool CodeGenerator::declareVariable(const std::string& name, const std::string& type, 
                                  int arraySize, int lineNo) {
    if (!symbolTable) {
        writeError("Symbol table not initialized");
        return false;
    }
    
    // Create symbol type string
    std::string symbolType = type;
    if (arraySize > 0) {
        symbolType += "[" + std::to_string(arraySize) + "]";
    }
    
    // Try to insert into symbol table
    if (symbolTable->Insert(name, symbolType)) {
        // Calculate space needed
        int spaceNeeded = calculateVariableSize(type, arraySize);
        currentStackOffset += spaceNeeded;
        
        // Store variable offset
        variableOffsets[name] = currentStackOffset;
        
        // Generate stack allocation
        generateStackAllocation(spaceNeeded);
        writeComment("Allocate space for " + name, lineNo);
        
        writeParserLog("Variable " + name + " allocated at stack offset " + 
                      std::to_string(currentStackOffset));
        return true;
    } else {
        writeError("Variable " + name + " already declared");
        if (syntaxErrorCount) {
            (*syntaxErrorCount)++;
        }
        return false;
    }
}

// Get variable offset
int CodeGenerator::getVariableOffset(const std::string& varName) {
    auto it = variableOffsets.find(varName);
    if (it != variableOffsets.end()) {
        return it->second;
    }
    return -1;
}

// Check if variable is declared
bool CodeGenerator::isVariableDeclared(const std::string& varName) {
    if (!symbolTable) {
        return false;
    }
    return symbolTable->LookUp(varName) != nullptr;
}

// Write assembly code
void CodeGenerator::writeAssembly(const std::string& code, int lineNo) {
    if (!asmFile) {
        std::cout << "Error: Assembly file not open" << std::endl;
        return;
    }
    
    if (lineNo != -1) {
        *asmFile << "; Line " << lineNo << std::endl;
    }
    *asmFile << code << std::endl;
    asmFile->flush();
}

// Write comment
void CodeGenerator::writeComment(const std::string& comment, int lineNo) {
    if (!asmFile) return;
    
    if (lineNo != -1) {
        *asmFile << "; Line " << lineNo << ": " << comment << std::endl;
    } else {
        *asmFile << "; " << comment << std::endl;
    }
}

// Generate unique label
std::string CodeGenerator::generateLabel() {
    return "L" + std::to_string(labelCounter++);
}

// Generate data segment header
void CodeGenerator::generateDataSegmentHeader() {
    writeAssembly(".MODEL SMALL");
    writeAssembly(".STACK 100H");
    writeAssembly(".DATA");
    writeAssembly("    number DB \"00000$\"");
    writeAssembly(".CODE");
    writeAssembly("MAIN PROC");
    writeAssembly("    MOV AX, @DATA");
    writeAssembly("    MOV DS, AX");
    writeAssembly("    MOV BP, SP");
    writeAssembly("");
}

// Generate data segment footer
void CodeGenerator::generateDataSegmentFooter() {
    writeAssembly("");
    writeAssembly("main_end:");
    writeAssembly("    MOV AH, 4CH");
    writeAssembly("    INT 21H");
    writeAssembly("MAIN ENDP");
    writeAssembly("");
    
    // Add utility procedures
    writeComment("Utility procedures");
    generatePrintOutputProcedure();
    generateNewLineProcedure();
    
    writeAssembly("END MAIN");
}

// Generate print_output procedure
void CodeGenerator::generatePrintOutputProcedure() {
    writeAssembly("print_output PROC");
    writeAssembly("    push ax");
    writeAssembly("    push bx");
    writeAssembly("    push cx");
    writeAssembly("    push dx");
    writeAssembly("    push si");
    writeAssembly("    lea si,number");
    writeAssembly("    mov bx,10");
    writeAssembly("    add si,4");
    writeAssembly("    cmp ax,0");
    writeAssembly("    jnge negate");
    writeAssembly("print:");
    writeAssembly("    xor dx,dx");
    writeAssembly("    div bx");
    writeAssembly("    mov [si],dl");
    writeAssembly("    add [si],'0'");
    writeAssembly("    dec si");
    writeAssembly("    cmp ax,0");
    writeAssembly("    jne print");
    writeAssembly("    inc si");
    writeAssembly("    lea dx,si");
    writeAssembly("    mov ah,9");
    writeAssembly("    int 21h");
    writeAssembly("    pop si");
    writeAssembly("    pop dx");
    writeAssembly("    pop cx");
    writeAssembly("    pop bx");
    writeAssembly("    pop ax");
    writeAssembly("    ret");
    writeAssembly("negate:");
    writeAssembly("    push ax");
    writeAssembly("    mov ah,2");
    writeAssembly("    mov dl,'-'");
    writeAssembly("    int 21h");
    writeAssembly("    pop ax");
    writeAssembly("    neg ax");
    writeAssembly("    jmp print");
    writeAssembly("print_output ENDP");
}

// Generate new_line procedure
void CodeGenerator::generateNewLineProcedure() {
    writeAssembly("new_line PROC");
    writeAssembly("    push ax");
    writeAssembly("    push dx");
    writeAssembly("    mov ah,2");
    writeAssembly("    mov dl,0Dh");
    writeAssembly("    int 21h");
    writeAssembly("    mov ah,2");
    writeAssembly("    mov dl,0Ah");
    writeAssembly("    int 21h");
    writeAssembly("    pop dx");
    writeAssembly("    pop ax");
    writeAssembly("    ret");
    writeAssembly("new_line ENDP");
}

// Generate variable declaration
void CodeGenerator::generateVariableDeclaration(const std::string& type, 
                                               const std::vector<std::pair<std::string, int>>& variables,
                                               int lineNo) {
    writeComment("Variable declaration", lineNo);
    
    for (const auto& varInfo : variables) {
        std::string varName = varInfo.first;
        int arraySize = varInfo.second;
        
        declareVariable(varName, type, arraySize, lineNo);
    }
}

// Generate variable assignment
void CodeGenerator::generateVariableAssignment(const std::string& varName, 
                                             const std::string& value, int lineNo) {
    writeComment("Assignment to " + varName, lineNo);
    
    // For now, assume value is a constant integer
    try {
        int intValue = std::stoi(value);
        writeAssembly("    MOV AX, " + std::to_string(intValue));
        writeAssembly("    MOV " + getVariableAccessCode(varName) + ", AX");
    } catch (const std::exception& e) {
        writeError("Invalid assignment value: " + value);
    }
}

// Generate constant load
void CodeGenerator::generateConstantLoad(int value) {
    writeAssembly("    MOV AX, " + std::to_string(value));
}

void CodeGenerator::generateConstantLoad(float value) {
    // For now, we'll handle floats as integers (truncated)
    writeAssembly("    MOV AX, " + std::to_string(static_cast<int>(value)));
}

// Generate variable load
void CodeGenerator::generateVariableLoad(const std::string& varName) {
    if (isVariableDeclared(varName)) {
        writeAssembly("    MOV AX, " + getVariableAccessCode(varName));
    } else {
        writeError("Undefined variable: " + varName);
        if (syntaxErrorCount) {
            (*syntaxErrorCount)++;
        }
    }
}

// Generate variable store
void CodeGenerator::generateVariableStore(const std::string& varName) {
    if (isVariableDeclared(varName)) {
        writeAssembly("    MOV " + getVariableAccessCode(varName) + ", AX");
    } else {
        writeError("Undefined variable: " + varName);
        if (syntaxErrorCount) {
            (*syntaxErrorCount)++;
        }
    }
}

// Generate print statement
void CodeGenerator::generatePrintStatement(const std::string& varName, int lineNo) {
    writeComment("println(" + varName + ")", lineNo);
    
    if (isVariableDeclared(varName)) {
        generateVariableLoad(varName);
        writeAssembly("    CALL print_output");
        writeAssembly("    CALL new_line");
    } else {
        writeError("Undefined variable: " + varName);
        if (syntaxErrorCount) {
            (*syntaxErrorCount)++;
        }
    }
}

// Generate return statement
void CodeGenerator::generateReturnStatement(int lineNo) {
    writeComment("return statement", lineNo);
    // Jump to main_end label
    writeAssembly("    JMP main_end");
}

// Generate stack allocation
void CodeGenerator::generateStackAllocation(int size) {
    writeAssembly("    SUB SP, " + std::to_string(size));
}

// Generate stack deallocation
void CodeGenerator::generateStackDeallocation(int size) {
    writeAssembly("    ADD SP, " + std::to_string(size));
}

// Write parser log
void CodeGenerator::writeParserLog(const std::string& message) {
    if (!parserLogFile) return;
    *parserLogFile << message << std::endl;
    parserLogFile->flush();
}

// Write error
void CodeGenerator::writeError(const std::string& message) {
    if (!errorFile) return;
    *errorFile << message << std::endl;
    errorFile->flush();
}

// Get variable access code
std::string CodeGenerator::getVariableAccessCode(const std::string& varName) {
    int offset = getVariableOffset(varName);
    if (offset != -1) {
        return "[BP-" + std::to_string(offset) + "]";
    }
    return "ERROR_UNKNOWN_VAR";
}

// Get array access code
std::string CodeGenerator::getArrayAccessCode(const std::string& arrayName, 
                                            const std::string& indexReg) {
    int offset = getVariableOffset(arrayName);
    if (offset != -1) {
        return "[BP-" + std::to_string(offset) + "+" + indexReg + "]";
    }
    return "ERROR_UNKNOWN_ARRAY";
}

// Calculate variable size
int CodeGenerator::calculateVariableSize(const std::string& type, int arraySize) {
    int baseSize = 2; // Default to 2 bytes for int
    
    if (type == "int") {
        baseSize = 2;
    } else if (type == "float") {
        baseSize = 4;
    } else if (type == "void") {
        baseSize = 0;
    }
    
    if (arraySize > 0) {
        return baseSize * arraySize;
    }
    
    return baseSize;
}

// Helper functions for parser
void initializeCodeGenerator(std::ofstream* asmFile, std::ofstream* parserLogFile, 
                           std::ofstream* errorFile, int* syntaxErrorCount) {
    codeGen = new CodeGenerator(asmFile, parserLogFile, errorFile, syntaxErrorCount);
    codeGen->initializeSymbolTable();
}

void finalizeCodeGenerator() {
    if (codeGen) {
        delete codeGen;
        codeGen = nullptr;
    }
}
