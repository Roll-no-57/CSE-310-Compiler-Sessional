parser grammar test_solution;

options {
    tokenVocab = C8086Lexer;
}

@parser::header {
    #include <iostream>
    #include <fstream>
    #include <string>
    #include <vector>
    #include <cstdlib>
    #include "C8086Lexer.h"
    #include "2105057_Hash.hpp"
    #include "2105057_symbolInfo.hpp"
    #include "2105057_ScopeTable.hpp"
    #include "2105057_SymbolTable.hpp"

    extern std::ofstream parserLogFile;
    extern std::ofstream errorFile;
    extern int syntaxErrorCount;
    extern int semanticErrorCount;
    extern int totalLines;
}

@parser::members {
    // Symbol table initialization
    int num_of_buckets = 7;
    HashFunction hashFunc = &Hash::SDBMHash;
    SymbolTable* ST = new SymbolTable(num_of_buckets, hashFunc, parserLogFile, true);
    
    // Current function info for return type checking
    std::string currentFunctionReturnType = "";
    bool insideFunction = false;

    void writeIntoParserLogFile(const std::string& message) {
        if (!parserLogFile) {
            std::cout << "Error opening parserLogFile.txt" << std::endl;
            return;
        }
        parserLogFile << message << std::endl;
        parserLogFile.flush();
    }

    void writeIntoErrorFile(const std::string& message) {
        if (!errorFile) {
            std::cout << "Error opening errorFile.txt" << std::endl;
            return;
        }
        errorFile << message << std::endl;
        errorFile.flush();
        semanticErrorCount++;
    }

    void logRule(const std::string& ruleName, const std::string& ruleContent) {
        writeIntoParserLogFile(ruleName + " : " + ruleContent);
    }

    std::string getTypeFromExpression(const std::string& expr) {
        // Simple type inference based on constants
        if (expr.find("CONST_INT") != std::string::npos) return "INT";
        if (expr.find("CONST_FLOAT") != std::string::npos) return "FLOAT";
        return "INT"; // Default for unknown expressions
    }

    bool isCompatibleType(const std::string& type1, const std::string& type2) {
        if (type1 == type2) return true;
        // Allow implicit conversion from INT to FLOAT
        if ((type1 == "INT" && type2 == "FLOAT") || (type1 == "FLOAT" && type2 == "INT")) {
            return true;
        }
        return false;
    }

    std::string inferExpressionType(const std::string& leftType, const std::string& rightType, const std::string& op) {
        if (leftType == "FLOAT" || rightType == "FLOAT") {
            return "FLOAT";
        }
        return "INT";
    }
}

start : program {
        writeIntoParserLogFile("start : program");
        writeIntoParserLogFile("");
        writeIntoParserLogFile("Symbol Table:");
        ST->printAllScopeTable();
        writeIntoParserLogFile("");
        writeIntoParserLogFile("Total lines: " + std::to_string(totalLines));
        writeIntoParserLogFile("Total errors: " + std::to_string(syntaxErrorCount + semanticErrorCount));
        
        // Cleanup
        if(ST) {
            delete ST;
            ST = nullptr;
        }
    }
    ;

program : program unit {
        logRule("program", "program unit");
    }
    | unit {
        logRule("program", "unit");
    }
    ;

unit : var_declaration {
        logRule("unit", "var_declaration");
    }
    | func_declaration {
        logRule("unit", "func_declaration");
    }
    | func_definition {
        logRule("unit", "func_definition");
    }
    ;

func_declaration 
    : type_specifier ID LPAREN parameter_list RPAREN SEMICOLON {
        std::string ruleStr = $type_specifier.text + " " + $ID.text + "(" + $parameter_list.text + ");";
        logRule("func_declaration", ruleStr);
        
        // Extract parameter information
        std::vector<std::string> paramTypes = $parameter_list.paramTypes;
        std::vector<std::string> paramNames = $parameter_list.paramNames;
        
        // Insert function into symbol table
        if (!ST->insertFunction($ID.text, $type_specifier.dataType, paramTypes, paramNames, false, $ID->getLine())) {
            writeIntoErrorFile("Line# " + std::to_string($ID->getLine()) + ": Multiple declaration of function '" + $ID.text + "'");
        }
    }
    | type_specifier ID LPAREN RPAREN SEMICOLON {
        std::string ruleStr = $type_specifier.text + " " + $ID.text + "();";
        logRule("func_declaration", ruleStr);
        
        std::vector<std::string> emptyTypes, emptyNames;
        if (!ST->insertFunction($ID.text, $type_specifier.dataType, emptyTypes, emptyNames, false, $ID->getLine())) {
            writeIntoErrorFile("Line# " + std::to_string($ID->getLine()) + ": Multiple declaration of function '" + $ID.text + "'");
        }
    }
    ;

func_definition 
    : type_specifier ID LPAREN parameter_list RPAREN {
        // Set current function context
        currentFunctionReturnType = $type_specifier.dataType;
        insideFunction = true;
        
        // Insert function into global scope
        std::vector<std::string> paramTypes = $parameter_list.paramTypes;
        std::vector<std::string> paramNames = $parameter_list.paramNames;
        
        if (!ST->insertFunction($ID.text, $type_specifier.dataType, paramTypes, paramNames, true, $ID->getLine())) {
            writeIntoErrorFile("Line# " + std::to_string($ID->getLine()) + ": Multiple definition of function '" + $ID.text + "'");
        }
        
        // Enter new scope for function body
        ST->EnterScope();
        
        // Insert parameters into function scope
        for (size_t i = 0; i < paramNames.size(); i++) {
            ST->insertVariable(paramNames[i], paramTypes[i], false, 0, $ID->getLine());
        }
    } compound_statement {
        std::string ruleStr = $type_specifier.text + " " + $ID.text + "(" + $parameter_list.text + ")" + $compound_statement.text;
        logRule("func_definition", ruleStr);
        
        // Exit function scope
        ST->ExitScope();
        insideFunction = false;
        currentFunctionReturnType = "";
    }
    | type_specifier ID LPAREN RPAREN {
        // Set current function context
        currentFunctionReturnType = $type_specifier.dataType;
        insideFunction = true;
        
        // Insert function into global scope
        std::vector<std::string> emptyTypes, emptyNames;
        if (!ST->insertFunction($ID.text, $type_specifier.dataType, emptyTypes, emptyNames, true, $ID->getLine())) {
            writeIntoErrorFile("Line# " + std::to_string($ID->getLine()) + ": Multiple definition of function '" + $ID.text + "'");
        }
        
        // Enter new scope for function body
        ST->EnterScope();
    } compound_statement {
        std::string ruleStr = $type_specifier.text + " " + $ID.text + "()" + $compound_statement.text;
        logRule("func_definition", ruleStr);
        
        // Exit function scope
        ST->ExitScope();
        insideFunction = false;
        currentFunctionReturnType = "";
    }
    ;

parameter_list returns [std::vector<std::string> paramTypes, std::vector<std::string> paramNames, std::string text]
    : parameter_list COMMA type_specifier ID {
        $paramTypes = $parameter_list.paramTypes;
        $paramNames = $parameter_list.paramNames;
        $paramTypes.push_back($type_specifier.dataType);
        $paramNames.push_back($ID.text);
        $text = $parameter_list.text + "," + $type_specifier.text + " " + $ID.text;
    }
    | parameter_list COMMA type_specifier {
        $paramTypes = $parameter_list.paramTypes;
        $paramNames = $parameter_list.paramNames;
        $paramTypes.push_back($type_specifier.dataType);
        $paramNames.push_back(""); // Anonymous parameter
        $text = $parameter_list.text + "," + $type_specifier.text;
    }
    | type_specifier ID {
        $paramTypes.push_back($type_specifier.dataType);
        $paramNames.push_back($ID.text);
        $text = $type_specifier.text + " " + $ID.text;
    }
    | type_specifier {
        $paramTypes.push_back($type_specifier.dataType);
        $paramNames.push_back(""); // Anonymous parameter
        $text = $type_specifier.text;
    }
    ;

compound_statement returns [std::string text]
    : LCURL {
        ST->EnterScope();
    } statements RCURL {
        $text = "{" + $statements.text + "}";
        logRule("compound_statement", $text);
        ST->ExitScope();
    }
    | LCURL {
        ST->EnterScope();
    } RCURL {
        $text = "{}";
        logRule("compound_statement", $text);
        ST->ExitScope();
    }
    ;

var_declaration returns [std::string text]
    : type_specifier declaration_list SEMICOLON {
        $text = $type_specifier.text + " " + $declaration_list.text + ";";
        logRule("var_declaration", $text);
        
        // Insert variables into symbol table
        for (const auto& varInfo : $declaration_list.variables) {
            if (!ST->insertVariable(varInfo.name, $type_specifier.dataType, varInfo.isArray, varInfo.arraySize, $type_specifier.line)) {
                writeIntoErrorFile("Line# " + std::to_string($type_specifier.line) + ": Multiple declaration of variable '" + varInfo.name + "'");
            }
        }
    }
    ;

declaration_list returns [std::vector<struct {std::string name; bool isArray; int arraySize;}> variables, std::string text]
    : declaration_list COMMA ID {
        $variables = $declaration_list.variables;
        $variables.push_back({$ID.text, false, 0});
        $text = $declaration_list.text + "," + $ID.text;
    }
    | declaration_list COMMA ID LTHIRD CONST_INT RTHIRD {
        $variables = $declaration_list.variables;
        int size = std::stoi($CONST_INT.text);
        $variables.push_back({$ID.text, true, size});
        $text = $declaration_list.text + "," + $ID.text + "[" + $CONST_INT.text + "]";
    }
    | ID {
        $variables.push_back({$ID.text, false, 0});
        $text = $ID.text;
    }
    | ID LTHIRD CONST_INT RTHIRD {
        int size = std::stoi($CONST_INT.text);
        $variables.push_back({$ID.text, true, size});
        $text = $ID.text + "[" + $CONST_INT.text + "]";
    }
    ;

type_specifier returns [std::string text, std::string dataType, int line]
    : INT {
        $text = $INT.text;
        $dataType = "INT";
        $line = $INT->getLine();
    }
    | FLOAT {
        $text = $FLOAT.text;
        $dataType = "FLOAT";
        $line = $FLOAT->getLine();
    }
    | VOID {
        $text = $VOID.text;
        $dataType = "VOID";
        $line = $VOID->getLine();
    }
    ;

statements returns [std::string text]
    : statement {
        $text = $statement.text;
        logRule("statements", $text);
    }
    | statements statement {
        $text = $statements.text + " " + $statement.text;
        logRule("statements", $text);
    }
    ;

statement returns [std::string text]
    : var_declaration {
        $text = $var_declaration.text;
        logRule("statement", $text);
    }
    | expression_statement {
        $text = $expression_statement.text;
        logRule("statement", $text);
    }
    | compound_statement {
        $text = $compound_statement.text;
        logRule("statement", $text);
    }
    | FOR LPAREN expression_statement expression_statement expression RPAREN statement {
        $text = "for(" + $expression_statement.text + " " + $expression_statement.text + " " + $expression.text + ")" + $statement.text;
        logRule("statement", $text);
    }
    | IF LPAREN expression RPAREN statement {
        $text = "if(" + $expression.text + ")" + $statement.text;
        logRule("statement", $text);
    }
    | IF LPAREN expression RPAREN statement ELSE statement {
        $text = "if(" + $expression.text + ")" + $statement.text + " else " + $statement.text;
        logRule("statement", $text);
    }
    | WHILE LPAREN expression RPAREN statement {
        $text = "while(" + $expression.text + ")" + $statement.text;
        logRule("statement", $text);
    }
    | PRINTLN LPAREN ID RPAREN SEMICOLON {
        $text = "println(" + $ID.text + ");";
        logRule("statement", $text);
        
        // Check if variable exists
        SymbolInfo* symbol = ST->LookUp($ID.text, false);
        if (symbol == nullptr) {
            writeIntoErrorFile("Line# " + std::to_string($ID->getLine()) + ": Undeclared variable '" + $ID.text + "'");
        }
    }
    | RETURN expression SEMICOLON {
        $text = "return " + $expression.text + ";";
        logRule("statement", $text);
        
        // Check return type compatibility
        if (insideFunction) {
            if (currentFunctionReturnType == "VOID") {
                writeIntoErrorFile("Line# " + std::to_string($RETURN->getLine()) + ": Void function cannot return a value");
            } else if (!isCompatibleType($expression.dataType, currentFunctionReturnType)) {
                writeIntoErrorFile("Line# " + std::to_string($RETURN->getLine()) + ": Return type mismatch");
            }
        }
    }
    ;

expression_statement returns [std::string text]
    : SEMICOLON {
        $text = ";";
        logRule("expression_statement", $text);
    }
    | expression SEMICOLON {
        $text = $expression.text + ";";
        logRule("expression_statement", $text);
    }
    ;

variable returns [std::string text, std::string dataType, bool isArray]
    : ID {
        $text = $ID.text;
        
        // Check if variable is declared
        SymbolInfo* symbol = ST->LookUp($ID.text, false);
        if (symbol == nullptr) {
            writeIntoErrorFile("Line# " + std::to_string($ID->getLine()) + ": Undeclared variable '" + $ID.text + "'");
            $dataType = "INT"; // Default
            $isArray = false;
        } else if (symbol->get_isFunction()) {
            writeIntoErrorFile("Line# " + std::to_string($ID->getLine()) + ": '" + $ID.text + "' is not a variable");
            $dataType = "INT"; // Default
            $isArray = false;
        } else {
            $dataType = symbol->get_dataType();
            $isArray = symbol->get_isArray();
            
            // Check if array is used without index
            if (symbol->get_isArray()) {
                writeIntoErrorFile("Line# " + std::to_string($ID->getLine()) + ": Array '" + $ID.text + "' used without index");
            }
        }
    }
    | ID LTHIRD expression RTHIRD {
        $text = $ID.text + "[" + $expression.text + "]";
        
        // Check if variable is declared
        SymbolInfo* symbol = ST->LookUp($ID.text, false);
        if (symbol == nullptr) {
            writeIntoErrorFile("Line# " + std::to_string($ID->getLine()) + ": Undeclared variable '" + $ID.text + "'");
            $dataType = "INT"; // Default
        } else if (symbol->get_isFunction()) {
            writeIntoErrorFile("Line# " + std::to_string($ID->getLine()) + ": '" + $ID.text + "' is not a variable");
            $dataType = "INT"; // Default
        } else {
            $dataType = symbol->get_dataType();
            
            // Check if non-array is indexed
            if (!symbol->get_isArray()) {
                writeIntoErrorFile("Line# " + std::to_string($ID->getLine()) + ": '" + $ID.text + "' is not an array");
            }
            
            // Check if index is integer
            if ($expression.dataType != "INT") {
                writeIntoErrorFile("Line# " + std::to_string($ID->getLine()) + ": Array index must be integer");
            }
        }
        $isArray = false; // Result of array access is not an array
    }
    ;

expression returns [std::string text, std::string dataType]
    : logic_expression {
        $text = $logic_expression.text;
        $dataType = $logic_expression.dataType;
        logRule("expression", $text);
    }
    | variable ASSIGNOP logic_expression {
        $text = $variable.text + "=" + $logic_expression.text;
        logRule("expression", $text);
        
        // Type checking for assignment
        if (!isCompatibleType($logic_expression.dataType, $variable.dataType)) {
            writeIntoErrorFile("Line# " + std::to_string($ASSIGNOP->getLine()) + ": Type mismatch in assignment");
        }
        
        // Warning for float to int assignment
        if ($logic_expression.dataType == "FLOAT" && $variable.dataType == "INT") {
            writeIntoErrorFile("Line# " + std::to_string($ASSIGNOP->getLine()) + ": Warning: Possible loss of data in assignment from FLOAT to INT");
        }
        
        $dataType = $variable.dataType;
    }
    ;

logic_expression returns [std::string text, std::string dataType]
    : rel_expression {
        $text = $rel_expression.text;
        $dataType = $rel_expression.dataType;
        logRule("logic_expression", $text);
    }
    | rel_expression LOGICOP rel_expression {
        $text = $rel_expression.text + " " + $LOGICOP.text + " " + $rel_expression.text;
        logRule("logic_expression", $text);
        $dataType = "INT"; // Logical operations return integer
    }
    ;

rel_expression returns [std::string text, std::string dataType]
    : simple_expression {
        $text = $simple_expression.text;
        $dataType = $simple_expression.dataType;
        logRule("rel_expression", $text);
    }
    | simple_expression RELOP simple_expression {
        $text = $simple_expression.text + " " + $RELOP.text + " " + $simple_expression.text;
        logRule("rel_expression", $text);
        $dataType = "INT"; // Relational operations return integer
    }
    ;

simple_expression returns [std::string text, std::string dataType]
    : term {
        $text = $term.text;
        $dataType = $term.dataType;
        logRule("simple_expression", $text);
    }
    | simple_expression ADDOP term {
        $text = $simple_expression.text + " " + $ADDOP.text + " " + $term.text;
        logRule("simple_expression", $text);
        $dataType = inferExpressionType($simple_expression.dataType, $term.dataType, $ADDOP.text);
    }
    ;

term returns [std::string text, std::string dataType]
    : unary_expression {
        $text = $unary_expression.text;
        $dataType = $unary_expression.dataType;
        logRule("term", $text);
    }
    | term MULOP unary_expression {
        $text = $term.text + " " + $MULOP.text + " " + $unary_expression.text;
        logRule("term", $text);
        
        // Check modulus operator
        if ($MULOP.text == "%") {
            if ($term.dataType != "INT" || $unary_expression.dataType != "INT") {
                writeIntoErrorFile("Line# " + std::to_string($MULOP->getLine()) + ": Operands of modulus must be integers");
            }
            $dataType = "INT";
        } else {
            $dataType = inferExpressionType($term.dataType, $unary_expression.dataType, $MULOP.text);
        }
    }
    ;

unary_expression returns [std::string text, std::string dataType]
    : ADDOP unary_expression {
        $text = $ADDOP.text + $unary_expression.text;
        $dataType = $unary_expression.dataType;
        logRule("unary_expression", $text);
    }
    | NOT unary_expression {
        $text = "!" + $unary_expression.text;
        $dataType = "INT"; // NOT operation returns integer
        logRule("unary_expression", $text);
    }
    | factor {
        $text = $factor.text;
        $dataType = $factor.dataType;
        logRule("unary_expression", $text);
    }
    ;

factor returns [std::string text, std::string dataType]
    : variable {
        $text = $variable.text;
        $dataType = $variable.dataType;
        logRule("factor", $text);
    }
    | ID LPAREN argument_list RPAREN {
        $text = $ID.text + "(" + $argument_list.text + ")";
        logRule("factor", $text);
        
        // Check function call
        SymbolInfo* funcSymbol = ST->getFunctionInfo($ID.text);
        if (funcSymbol == nullptr) {
            writeIntoErrorFile("Line# " + std::to_string($ID->getLine()) + ": Undeclared function '" + $ID.text + "'");
            $dataType = "INT"; // Default
        } else {
            FunctionInfo* funcInfo = funcSymbol->get_functionInfo();
            $dataType = funcInfo->returnType;
            
            // Check if void function used in expression
            if (funcInfo->returnType == "VOID") {
                writeIntoErrorFile("Line# " + std::to_string($ID->getLine()) + ": Void function cannot be used in expression");
            }
            
            // Check argument count and types
            if ($argument_list.argTypes.size() != funcInfo->parameterTypes.size()) {
                writeIntoErrorFile("Line# " + std::to_string($ID->getLine()) + ": Argument count mismatch in function call");
            } else {
                for (size_t i = 0; i < $argument_list.argTypes.size(); i++) {
                    if (!isCompatibleType($argument_list.argTypes[i], funcInfo->parameterTypes[i])) {
                        writeIntoErrorFile("Line# " + std::to_string($ID->getLine()) + ": Argument type mismatch in function call");
                    }
                }
            }
        }
    }
    | LPAREN expression RPAREN {
        $text = "(" + $expression.text + ")";
        $dataType = $expression.dataType;
        logRule("factor", $text);
    }
    | CONST_INT {
        $text = $CONST_INT.text;
        $dataType = "INT";
        logRule("factor", $text);
    }
    | CONST_FLOAT {
        $text = $CONST_FLOAT.text;
        $dataType = "FLOAT";
        logRule("factor", $text);
    }
    | variable INCOP {
        $text = $variable.text + "++";
        $dataType = $variable.dataType;
        logRule("factor", $text);
    }
    | variable DECOP {
        $text = $variable.text + "--";
        $dataType = $variable.dataType;
        logRule("factor", $text);
    }
    ;

argument_list returns [std::vector<std::string> argTypes, std::string text]
    : arguments {
        $argTypes = $arguments.argTypes;
        $text = $arguments.text;
    }
    | {
        // Empty argument list
        $text = "";
    }
    ;

arguments returns [std::vector<std::string> argTypes, std::string text]
    : arguments COMMA logic_expression {
        $argTypes = $arguments.argTypes;
        $argTypes.push_back($logic_expression.dataType);
        $text = $arguments.text + "," + $logic_expression.text;
    }
    | logic_expression {
        $argTypes.push_back($logic_expression.dataType);
        $text = $logic_expression.text;
    }
    ;

// Precedence rules to resolve if-else ambiguity
// %precedence LOWER_THAN_ELSE
// %precedence ELSE