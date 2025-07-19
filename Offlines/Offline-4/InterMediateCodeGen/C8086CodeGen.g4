parser grammar C8086CodeGen;

options {
    tokenVocab = C8086Lexer;
}

@parser::header {
    #include <iostream>
    #include <fstream>
    #include <string>
    #include <cstdlib>
    #include "C8086Lexer.h"
	#include "CodeGenerator.hpp"

    extern std::ofstream parserLogFile;
    extern std::ofstream errorFile;
	extern std::ofstream dataSectionFile;
    extern std::ofstream codeSectionFile; 

}

@parser::members {
    void writeIntoparserLogFile(const std::string message) {
        if (!parserLogFile) {
            std::cout << "Error opening parserLogFile.txt" << std::endl;
            return;
        }

        parserLogFile << message << std::endl;
        parserLogFile.flush();
    }

    void writeIntoErrorFile(const std::string message) {
        if (!errorFile) {
            std::cout << "Error opening errorFile.txt" << std::endl;
            return;
        }
        errorFile << message << std::endl;
        errorFile.flush();
    }
}


start : {

	writeIntoparserLogFile("Starting parsing process...");

	// Generate the program header and data and code section headers
	if (codeGen) {
		codeGen->GenProgramHeader();
		codeGen->GenDataSectionHeader();
		codeGen->GenCodeSectionHeader();
	}
	
	
}program
	{
		// Generate the program footer
		if(codeGen) codeGen->GenProgramFooter();
        writeIntoparserLogFile("Parsing completed successfully ");
	}
	;

program : program unit 
	| unit
	;
	
unit : var_declaration
     | {
		if(codeGen)codeGen->setIsGlobalScope(false);
	 }func_declaration{
		if(codeGen)codeGen->setIsGlobalScope(true);
	 }
     | {
		if(codeGen)codeGen->setIsGlobalScope(false);
	 }func_definition{
		if(codeGen)codeGen->setIsGlobalScope(true);
	 }
     ;
     
func_declaration : type_specifier ID LPAREN parameter_list RPAREN SEMICOLON
		| type_specifier ID LPAREN RPAREN SEMICOLON
		;
		 
func_definition : type_specifier ID LPAREN parameter_list RPAREN compound_statement
		| type_specifier ID LPAREN RPAREN compound_statement
 		;				


parameter_list  : parameter_list COMMA type_specifier ID
		| parameter_list COMMA type_specifier
 		| type_specifier ID
		| type_specifier
 		;

 		
compound_statement : LCURL statements RCURL
 		    | LCURL RCURL
 		    ;
 		    
var_declaration 
    : t=type_specifier dl=declaration_list[$t.text] sm=SEMICOLON {
        
    }

    | t=type_specifier de=declaration_list_err sm=SEMICOLON {
        writeIntoErrorFile(
            std::string("Line# ") + std::to_string($sm->getLine()) +
            " with error name: " + $de.error_name +
            " - Syntax error at declaration list of variable declaration"
        );

      }
    ;

declaration_list_err returns [std::string error_name]: {
        $error_name = "Error in declaration list";
    };

 		 
type_specifier returns [std::string text]	
        : INT {
            $text = "int";
        }
 		| FLOAT {
            $text = "float";
        }
 		| VOID {
            $text = "void";
        }
 		;
 		
declaration_list [std::string type]
    : ID {
        if(codeGen ){ 
			if(codeGen->isInGlobalScope() ){
				codeGen->GenGlobalVariableDeclaration($ID.text, $type, $ID->getLine());
			}
			else{
				codeGen->GenLocalVariableDeclaration($ID.text, $type, $ID->getLine());
			}
		}
		
      } declaration_list_rest[$type]
    | ID LTHIRD CONST_INT RTHIRD {
		if(codeGen) {
			if(codeGen->isInGlobalScope()) {
				codeGen->GenGlobalArrayDeclaration($ID.text, $type, std::stoi($CONST_INT.text), $ID->getLine());
			} else {
				codeGen->GenLocalArrayDeclaration($ID.text, $type, std::stoi($CONST_INT.text), $ID->getLine());
			}
		}
	} declaration_list_rest[$type]
    ;

declaration_list_rest [std::string type]
    : COMMA ID {
        if(codeGen ){ 
			if(codeGen->isInGlobalScope() ){
				codeGen->GenGlobalVariableDeclaration($ID.text, $type, $ID->getLine());
			}
			else{
				codeGen->GenLocalVariableDeclaration($ID.text, $type, $ID->getLine());
			}
		}
      } declaration_list_rest[$type]
    | COMMA ID LTHIRD CONST_INT RTHIRD {
		if(codeGen) {
			if(codeGen->isInGlobalScope()) {
				codeGen->GenGlobalArrayDeclaration($ID.text, $type, std::stoi($CONST_INT.text), $ID->getLine());
			} else {
				codeGen->GenLocalArrayDeclaration($ID.text, $type, std::stoi($CONST_INT.text), $ID->getLine());
			}
		}
	} declaration_list_rest[$type]
    | // empty - end of list
    ;
 		  
statements : statement
	   | statements statement
	   ;
	   
statement : var_declaration
	  | expression_statement
	  | compound_statement
	  | FOR LPAREN expression_statement expression_statement expression RPAREN statement
	  | IF LPAREN expression RPAREN statement
	  | IF LPAREN expression RPAREN statement ELSE statement
	  | WHILE LPAREN expression RPAREN statement
	  | PRINTLN LPAREN ID RPAREN SEMICOLON {
			if(codeGen) codeGen->GenPrintlnFunction();
	  }
	  | RETURN expression SEMICOLON
	  ;
	  
expression_statement 	: SEMICOLON			
			| expression SEMICOLON 
			;
	  
variable returns [std::string var_name] 
	 : ID {
		$var_name = $ID.text;
	 }
	 | ID LTHIRD expression RTHIRD {
		$var_name = $ID.text;
	 }
	 ;
	 
 expression : logic_expression	
	   | v=variable ASSIGNOP logic_expression {
		   if(codeGen) {
			   // Generate code for assignment operation
			   codeGen->GenAssignmentOp($v.var_name , "AX", $ASSIGNOP->getLine());
		   }
	   }	
	   ;
			
logic_expression : rel_expression 	
		 | rel_expression LOGICOP rel_expression 	
		 ;
			
rel_expression	: simple_expression 
		| simple_expression RELOP simple_expression	
		;
				
simple_expression : term 
		  | simple_expression ADDOP term 
		  ;
					
term :	unary_expression
     |  term MULOP unary_expression
     ;

unary_expression : ADDOP unary_expression  
		 | NOT unary_expression 
		 | factor 
		 ;
	
factor	: variable 
	| ID LPAREN argument_list RPAREN
	| LPAREN expression RPAREN
	| CONST_INT {
		// load constant value into AX
		if(codeGen)codeGen->GenLoadConstInt(std::stoi($CONST_INT.text), $CONST_INT->getLine());
	}
	| CONST_FLOAT {
		// load constant float value into AX
		if(codeGen) codeGen->writeComment(&codeSectionFile,"Load constant float value", $CONST_FLOAT->getLine());
	}
	| variable INCOP 
	| variable DECOP
	;
	
argument_list : arguments
			  |
			  ;
	
arguments : arguments COMMA logic_expression
	      | logic_expression
	      ;
