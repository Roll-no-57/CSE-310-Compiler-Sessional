%option noyywrap
%x CONST_CHAR_LITERAL
%x STRING_LITERAL
%x DOUBLE_SLASH_COMMENT
%x SLASH_STAR_COMMENT


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
int error_count = 0;


string current_const_char_text = "";  // stores the contents of yytext while in TOKENIZING_CONST_CHAR state
string current_converted_text = "";


string current_string = "";


string current_comment = "";

// Symbol table initialization
int num_of_buckets = 7;
HashFunction hashFunc = &Hash::SDBMHash;
SymbolTable* ST = new SymbolTable(num_of_buckets, hashFunc, logout, false);

// Class for token-lexeme pairs
class TokenLexeme {
public:
    string token, lexeme;
    TokenLexeme(string token, string lexeme) {
        this->token = token;
        this->lexeme = lexeme;
    }
    string to_string() {
        return "<" + token + ", " + lexeme + "> ";
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

    tokenout << "<" << token << "> ";
    logout << "Line no " << line_count << ": Token <" << token << "> Lexeme " << text << " found\n\n";
}

// Writes token to token file
void write_to_token_file(TokenLexeme tl) {
    tokenout << tl.to_string();
}

// Writes token log
void write_to_log_file(TokenLexeme tl) {
	if(tl.token == "CONST_CHAR"){
		logout << "Line no " << line_count << ": Token <" << tl.token << "> Lexeme " << current_const_char_text << " found --> "<<tl.to_string()<<"\n\n";
	}
	else{
		logout << "Line no " << line_count << ": Token <" << tl.token << "> Lexeme " << tl.lexeme << " found\n\n";
	}
}

// Handles general token processing
void process_token_lexeme(TokenLexeme tl) {
    write_to_token_file(tl);
    write_to_log_file(tl);

    if (tl.token == "LCURL") {
        ST->enterScope(false);
    } else if (tl.token == "RCURL") {
        ST->exitScope(false);
    }


// int bucket, chainPos;
//         bool succ = ST->Insert(tl.lexeme, tl.token, bucket, chainPos, false);
//         if (succ) {
//             ST->printAllScopeTable();
//             logout << "\n";
//         } else {
//             logout << "< " << tl.lexeme << " : " << tl.token << " > already exists in ScopeTable# "
//                    << ST->getCurrentScope()->getId() << " at position " << (bucket + 1) << ", " << chainPos << "\n\n";
//         }





    if(tl.token == "ID" || tl.token =="CONST_INT" || tl.token =="CONST_FLOAT" ){
        bool succ = ST->Insert(tl.lexeme,tl.token,false);
        if(succ){
            ST->printAllScopeTable();
			logout<<"\n";
        }
        else{
            logout<<"Lexeme: "<<tl.lexeme<<" already exists in the table\n";
        }
    }
	if(tl.token == "CONST_CHAR"){
		bool succ = ST->Insert(current_const_char_text,tl.token,false);
        if(succ){
            ST->printAllScopeTable();
			logout<<"\n";
        }
        else{
            logout<<"Lexeme: "<<tl.lexeme<<" already exists in the table\n";
        }
	}
	else{
		return;
	}

}



char get_special_character_ASCII(string text)
{
	char ascii;
	char ch = text[1];
	switch(ch)
	{
		case '0': ascii = '\0'; break;
		case 'v': ascii = '\v'; break;
		case 'b': ascii = '\b'; break;
		case 'r': ascii = '\r'; break;
		case 'f': ascii = '\f'; break;
		case 'a': ascii = '\a'; break;
		case '\'': ascii = '\''; break;
		case '\\': ascii = '\\'; break;
		case 't': ascii = '\t'; break;
		case 'n': ascii = '\n'; break;
		case '\"': ascii = '\"'; break;
		default : ascii = '#';          // this is a marker for wrongly formed special character
	}
	return ascii;
}

// Prints lexical error messages
void print_error_message(string name, string message) {
	error_count++;
    logout << "Error at line " << line_count << ": " << name << " " << message << "\n\n";
}

void handle_current_const_char()
{
	int len = current_converted_text.length();
	if(len == 2)
	{
		print_error_message("EMPTY_CONST_CHAR", current_const_char_text);
	}
	else if(len > 3)
	{
        print_error_message("MULTICHAR_CONST_CHAR", current_const_char_text);
	}
	else 
	{
		char ch = current_converted_text[1];
		if(ch == '#')
		{
            print_error_message("UNRECOGNIZED_CHAR",current_const_char_text);
		}
		else
		{
            process_token_lexeme(TokenLexeme("CONST_CHAR",string(1,current_converted_text[1])));
		}
	}
}

void process_double_slash_comment(){
	write_to_log_file(TokenLexeme("DOUBLE_SLASH_LINE_COMMENT",current_comment));
}

void process_slash_star_comment(){
	write_to_log_file(TokenLexeme("SLASH_START_LINE_COMMENT",current_comment));
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

/* SINGLE_QOUTE    "\'" */
BACKSLASH				"\\"
NON_BACKSLASH			[^\\]
SINGLE_QUOTE			"\'"
SPECIAL_CHARACTER	    "\\0"|"\\v"|"\\b"|"\\r"|"\\f"|"\\a"|"\\\'"|"\\\\"|"\\t"|"\\n"|"\""

/* MULTICHAR_LITERAL		'[{NON_BACKSLASH}|{SPECIAL_CHARACTER}]{2,}'	 */

DOUBLE_QUOTE			"\""

DOUBLE_SLASH	"\/\/"
SLASH_STAR		"\/\*"
STAR_SLASH		"\*\/"

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
{IDENTIFIER}    { process_token_lexeme(TokenLexeme("ID", yytext));}
{CONST_INT}     { process_token_lexeme(TokenLexeme("CONST_INT", yytext));}
{CONST_FLOAT}   { process_token_lexeme(TokenLexeme("CONST_FLOAT", yytext));}

{SINGLE_QUOTE}	{
                    cout<<"before hello "<<current_const_char_text<<endl;
                    cout<<"before state yytext: "<<yytext<<endl;
					BEGIN CONST_CHAR_LITERAL;
					current_const_char_text = yytext;
					current_converted_text = yytext;
                    cout<<"after state: "<<current_const_char_text<<endl;
                    cout<<"after state yytext: "<<yytext<<endl;
				} 

<CONST_CHAR_LITERAL>{

	{SINGLE_QUOTE}	{
                        cout<<"Inside state yytext: "<<yytext<<endl;
						current_const_char_text += yytext;
						current_converted_text += yytext;
                        cout<<"Inside state: "<<current_const_char_text<<endl;
						handle_current_const_char();
						BEGIN INITIAL;			// end this state
					}
	{NEWLINE}	{
					print_error_message("UNFINISHED_CONST_CHAR",current_const_char_text);
					cout<<"NewLIne error"<<endl;
					line_count++;
					BEGIN INITIAL;
				}
	<<EOF>>		{
					print_error_message("UNFINISHED_CONST_CHAR",current_const_char_text);
					cout<<"EOF error"<<endl;
					BEGIN INITIAL;
				}
	{SPECIAL_CHARACTER}	{
                            cout<<"special :"<<yytext<<endl;
							current_const_char_text += yytext;
							current_converted_text += get_special_character_ASCII(yytext);
                            cout<<"special converted "<<current_converted_text<<endl;
						}
	{BACKSLASH}{NON_BACKSLASH}	{
                            cout<<"Inside \\ non-back yytext: "<<yytext<<endl;
							current_const_char_text += yytext;
							current_converted_text += get_special_character_ASCII(yytext);
                            cout<<"Inside \\ non-back current_const_char: "<<current_const_char_text<<endl;
						}
	{NON_BACKSLASH}	{
                        cout<<"Inside non-back yytext: "<<yytext<<endl;
						current_const_char_text += yytext;
						current_converted_text += yytext;
                        cout<<"Inside non-back current_const_char: "<<current_const_char_text<<endl;
					}
}


{DOUBLE_QUOTE}  {
					current_string=yytext;
					BEGIN STRING_LITERAL;
				}

<STRING_LITERAL>{

	{DOUBLE_QUOTE}	{
						current_string+=yytext;
						process_token_lexeme(TokenLexeme("STRING",current_string));
						BEGIN INITIAL;
					}
	{NEWLINE}		{
						print_error_message("Unfinished string for new line :",current_string);
						line_count++;
						BEGIN INITIAL;
					}
	<<EOF>>			{
						print_error_message("Unfinished string for EOF :",current_string);
						BEGIN INITIAL;
					}
	{SPECIAL_CHARACTER}	{
						current_string+=get_special_character_ASCII(yytext);
						cout<<"Special conversion "<< current_string<<endl;
					}
	{BACKSLASH}{NEWLINE}			{
						current_string += yytext;
						line_count++;
					}
	.				{
						current_string+=yytext;
					}
}

{DOUBLE_SLASH}	{
					current_comment=yytext;
					BEGIN DOUBLE_SLASH_COMMENT;
				}

<DOUBLE_SLASH_COMMENT>{

	{NEWLINE}	{
					line_count++;
					process_double_slash_comment();
					BEGIN INITIAL;
				}
	<<EOF>>		{
					process_double_slash_comment();
					BEGIN INITIAL;
				}
	{BACKSLASH}{NEWLINE}	{
								current_comment+=yytext;
								line_count++;
							}
	.			{
					current_comment+=yytext;

				}
}

{SLASH_STAR}	{
					current_comment=yytext;
					BEGIN SLASH_STAR_COMMENT;
				}

<SLASH_STAR_COMMENT>{

	{STAR_SLASH}	{
						current_comment+=yytext;
						process_slash_star_comment();
						BEGIN INITIAL;
					}
	{NEWLINE}		{
						current_comment+=yytext;
						line_count++;
					}
	<<EOF>>			{
						print_error_message("COMMENT UNFINISHED",current_comment);
					}
	.				{
						current_comment+=yytext;
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
	logout << "Total errors: "<<error_count<<endl;

    delete ST; // prevent memory leak

    fclose(yyin);
    tokenout.close();
    logout.close();


    return 0;
}
