%x CONST_CHAR_LITERAL

%{
#include <iostream>
#include <fstream>
#include <string>
#include <cctype>
#include <cstdio>
#include "headers/2105057_SymbolTable.hpp"
#include "headers/2105057_Hash.hpp"

using namespace std;

ofstream tokenout("2105057_token.txt");
ofstream logout("2105057_log.txt");

int line_count = 1;
string current_const_char = ""; // Stores the raw lexeme (e.g., 'v')
string current_converted_char = ""; // Stores the converted character (e.g., v)

int num_of_buckets = 7;
HashFunction hashFunc = &Hash::SDBMHash;
SymbolTable* ST = new SymbolTable(num_of_buckets, hashFunc, logout, true);

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

void capitalize_letters(string& str) {
    for (char& c : str) c = toupper(c);
}

void process_keyword(string text) {
    string token = text;
    capitalize_letters(token);
    tokenout << "<" << token << ">\n";
    logout << "Line No. " << line_count << ": Token <" << token << "> Lexeme " << text << " found\n\n";
}

void write_to_token_file(TokenLexeme tl) {
    tokenout << tl.to_string() << "\n";
}

void write_to_log_file(TokenLexeme tl) {
    logout << "Line No. " << line_count << ": Token <" << tl.token << "> Lexeme " << tl.lexeme << " found\n\n";
}

void process_token_lexeme(TokenLexeme tl) {
    write_to_token_file(tl);
    write_to_log_file(tl);
    if (tl.token == "LCURL") {
        ST->enterScope(true);
    } else if (tl.token == "RCURL") {
        ST->exitScope(true);
    } else if (tl.token == "ID" || tl.token == "CONST_INT" || tl.token == "CONST_FLOAT" || tl.token == "CONST_CHAR") {
        bool succ = ST->Insert(tl.lexeme, tl.token, true);
        if (succ) {
            ST->printAllScopeTable();
        } else {
            logout << "Lexeme: " << tl.lexeme << " already exists in the table.\n";
        }
    }
}

void print_error_message(string name, string message) {
    logout << "Error at line " << line_count << ": " << name << " " << message << "\n\n";
}

// Convert escape sequences to ASCII
char get_special_character_ASCII(const string& text) {
    if (text.length() < 2) return '#';
    char ch = text[1];
    switch (ch) {
        case '0': return '\0';
        case 'v': return '\v';
        case 'b': return '\b';
        case 'r': return '\r';
        case 'f': return '\f';
        case 'a': return '\a';
        case '\'': return '\'';
        case '\\': return '\\';
        case 't': return '\t';
        case 'n': return '\n';
        default: return '#'; // Invalid escape sequence
    }
}

void handle_current_const_char() {
    if (current_converted_char.length() == 2) {
        print_error_message("EMPTY_CONST_CHAR", current_const_char);
    } else if (current_converted_char.length() > 3) {
        print_error_message("MULTICHAR_CONST_CHAR", current_const_char);
    } else {
        char ch = current_converted_char[1];
        if (ch == '#') {
            print_error_message("UNRECOGNIZED_CHAR", current_const_char);
        } else {
            process_token_lexeme(TokenLexeme("CONST_CHAR", string(1, ch)));
        }
    }
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
IDENTIFIER      [a-zA-Z_][a-zA-Z0-9_]*

DIGIT           [0-9]
FLOAT_DECIMAL   {DIGIT}*"."{DIGIT}+
FLOAT_EXPONENT  ({DIGIT}+([Ee][+-]?{DIGIT}+))|({DIGIT}*"."{DIGIT}+([Ee][+-]?{DIGIT}+))
CONST_FLOAT     {FLOAT_DECIMAL}|{FLOAT_EXPONENT}
CONST_INT       {DIGIT}+
SINGLE_QUOTE    "'"
SPECIAL_CHARACTER "\\0"|"\\v"|"\\b"|"\\r"|"\\f"|"\\a"|"\\'"|"\\\\"|"\\t"|"\\n"

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
{IDENTIFIER}    { process_token_lexeme(TokenLexeme("ID", yytext)); }
{CONST_INT}     { process_token_lexeme(TokenLexeme("CONST_INT", yytext)); }
{CONST_FLOAT}   { process_token_lexeme(TokenLexeme("CONST_FLOAT", yytext)); }

{SINGLE_QUOTE}  {
    current_const_char = yytext;
    current_converted_char = yytext;
    BEGIN CONST_CHAR_LITERAL;
}

<CONST_CHAR_LITERAL>{
    {SINGLE_QUOTE} {
        current_const_char += yytext;
        current_converted_char += yytext;
        handle_current_const_char();
        BEGIN INITIAL;
    }
    {NEWLINE} {
        print_error_message("UNFINISHED_CONST_CHAR", current_const_char);
        line_count++;
        BEGIN INITIAL;
    }
    <<EOF>> {
        print_error_message("UNFINISHED_CONST_CHAR", current_const_char);
        BEGIN INITIAL;
    }
    {SPECIAL_CHARACTER} {
        current_const_char += yytext;
        current_converted_char += get_special_character_ASCII(yytext);
    }
    \\[^0vbrfatn\\'] {
        current_const_char += yytext;
        current_converted_char += '#'; // Invalid escape sequence
    }
    [^\\'\n] {
        current_const_char += yytext;
        current_converted_char += yytext;
    }
}

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

    delete ST;
    fclose(yyin);
    tokenout.close();
    logout.close();

    return 0;
}