%option noyywrap

%{
#include <iostream>
#include <fstream>
#include <string>
#include <cctype>
#include <cstdio>
#include "headers/2105057_SymbolTable.hpp" // Include your SymbolTable and Hash header
#include "headers/2105057_Hash.hpp"

using namespace std;

// Output stream files
ofstream tokenout("2105057_token.txt");
ofstream logout("2105057_log.txt");

int line_count = 1;

// Symbol table initialization
int num_of_buckets = 7;
HashFunction hashFunc = &Hash::SDBMHash;
SymbolTable* ST = new SymbolTable(num_of_buckets, hashFunc, logout, true);

// Class for token-lexeme pairs
class TokenLexeme {
public:
    string token, lexeme;
    TokenLexeme(string token, string lexeme) {
        this->token = token;
        this->lexeme = lexeme;
    }
    string to_string() {
        return "<" + token + "," + lexeme + ">";
    }
};

// Converts all letters of a string to uppercase
void capitalize_letters(string& str) {
    for (char& c : str) c = toupper(c);
}

// Handles keywords (e.g., if, else)
void process_keyword(string text) {
    string token = text;
    capitalize_letters(token);

    tokenout << "<" << token << ">\n";
    logout << "Line No. " << line_count << ": Token <" << token << "> Lexeme " << text << " found\n\n";
}

// Writes token to token file
void write_to_token_file(TokenLexeme tl) {
    tokenout << tl.to_string() << "\n";
}

// Writes token log
void write_to_log_file(TokenLexeme tl) {
    logout << "Line No. " << line_count << ": Token <" << tl.token << "> Lexeme " << tl.lexeme << " found\n\n";
}

// Handles general token processing
void process_token_lexeme(TokenLexeme tl) {
    write_to_token_file(tl);
    write_to_log_file(tl);

    if (tl.token == "LCURL") {
        ST->enterScope(true);
    } else if (tl.token == "RCURL") {
        ST->exitScope(true);
    }
}

// Prints lexical error messages
void print_error_message(string name, string message) {
    logout << "Error at line " << line_count << ": " << name << " " << message << "\n\n";
}
%}

KEYWORD         "if"|"else"|"goto"|"for"|"while"|"long"|"do"|"break"|"short"|"int"|"char"|"static"|"float"|"double"|"unsigned"|"void"|"return"|"switch"|"case"|"default"|"continue"
ADDOP           "+"|"-"
MULOP           "*"|"/"|"%"
INCOP           "++"|"--"
RELOP           "<"|"<="|">"|">="|"=="|"!="
ASSIGNOP        "="
LOGICOP         "&&"|"||"
NOT             "!"
LPAREN          "("
RPAREN          ")"
LCURL           "{"
RCURL           "}"
LTHIRD          "["
RTHIRD          "]"
COMMA           ","
SEMICOLON       ";"
WHITESPACE      [ \t\f\r\v]
NEWLINE         "\n"|\r\n

%%

{WHITESPACE}    { /* ignore */ }

{NEWLINE}       { line_count++; }

{KEYWORD}       { process_keyword(yytext); }

{ADDOP}         { process_token_lexeme(TokenLexeme("ADDOP", yytext)); }
{MULOP}         { process_token_lexeme(TokenLexeme("MULOP", yytext)); }
{INCOP}         { process_token_lexeme(TokenLexeme("INCOP", yytext)); }
{RELOP}         { process_token_lexeme(TokenLexeme("RELOP", yytext)); }
{ASSIGNOP}      { process_token_lexeme(TokenLexeme("ASSIGNOP", yytext)); }
{LOGICOP}       { process_token_lexeme(TokenLexeme("LOGICOP", yytext)); }
{NOT}           { process_token_lexeme(TokenLexeme("NOT", yytext)); }
{LPAREN}        { process_token_lexeme(TokenLexeme("LPAREN", yytext)); }
{RPAREN}        { process_token_lexeme(TokenLexeme("RPAREN", yytext)); }
{LCURL}         { process_token_lexeme(TokenLexeme("LCURL", yytext)); }
{RCURL}         { process_token_lexeme(TokenLexeme("RCURL", yytext)); }
{LTHIRD}        { process_token_lexeme(TokenLexeme("LTHIRD", yytext)); }
{RTHIRD}        { process_token_lexeme(TokenLexeme("RTHIRD", yytext)); }
{COMMA}         { process_token_lexeme(TokenLexeme("COMMA", yytext)); }
{SEMICOLON}     { process_token_lexeme(TokenLexeme("SEMICOLON", yytext)); }

.               { print_error_message("Unrecognized character", yytext); }

%%

int main(int argc, char *argv[]) {
    if (argc != 2) {
        cout << "Sorry! Name of the input file must be provided" << endl;
        return 0;
    }

    FILE* fin = fopen(argv[1], "r");
    if (!fin) {
        cout << "File cannot be found" << endl;
        return 0;
    }

    yyin = fin;
    yylex();

    logout << "Total lines: " << line_count << endl;

    fclose(yyin);
    tokenout.close();
    logout.close();

    delete ST; // prevent memory leak

    return 0;
}
