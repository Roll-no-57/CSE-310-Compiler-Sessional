%option noyywrap

%x PROCESSING_VECTOR

%{

/* Commands to compile and run 
    flex -o lex.yy.c 2105060.l
    g++ lex.yy.c -lfl -o 2105060.out
    ./2105060.out input.txt
Or just use make file
    make INPUT=<input_file_name>
*/

#include<bits/stdc++.h>
using namespace std;

ofstream token_file("token.txt");
ofstream log_file("log.txt");

int line_count = 1;
int depth = 0;
bool error_line = false;
string vector_lexeme = "";

bool seen_opening = false;
bool seen_vector = false;
bool seen_type = false;

%}

WHITESPACE 		    [ \t\f\r\v]
ALPHABET		    [a-zA-Z]
DIGIT 			    [0-9]
ALPHANUMERIC	    {ALPHABET}|{DIGIT}	
NEWLINE             "\n"|"\r\n"

CONTROL_CHARACTER           "\n"|"\t"|"\\"|"\""|"\'"|"\a"|"\f"|"\r"|"\b"|"\v"|"\0"
ESCAPED_CONTROL_CHARACTER   "\\n"|"\\t"|"\\\\"|"\\\""|"\\\'"|"\\a"|"\\f"|"\\r"|"\\b"|"\\v"|"\\0"

VECTOR              "vector"
TYPES               "int"|"float"|"double"|"char"


%%

{WHITESPACE}    { /* Ignore whitespace */ }

{NEWLINE}       {  line_count++; }

"vector"        {
                    seen_opening = false;
                    seen_vector = false;
                    seen_type = false;
                    vector_lexeme = "vector";
                    BEGIN PROCESSING_VECTOR;
                }

<PROCESSING_VECTOR>{    
    {WHITESPACE}    { /* Ignore whitespace */ }

    {NEWLINE}       {                      
                        seen_opening = false;
                        seen_vector = false;
                        seen_type = false;

                        line_count++;
                        error_line = false; 
                    }

    "vector"        {

                        if(!error_line)
                        {
                            if(seen_vector || seen_type)
                            {
                                log_file << "Line No. " << line_count << ": Error in <VECTOR_TYPE> declaration" << endl;
                                error_line = true;
                            }
                            seen_vector = true;
                            seen_opening = false;

                            vector_lexeme += yytext;
                        }
                    }

    "<"             {

                        if(!error_line)
                        {
                            if(seen_type)
                            {
                                log_file << "Line No. " << line_count << ": Error in <VECTOR_TYPE> declaration" << endl;
                                error_line = true;
                            }
                            seen_opening = true;
                            seen
                            depth++;    
                            vector_lexeme += yytext;
                        }
                    }

    ">"             {   
                        if(!error_line)
                        {
                            if(!seen_type)
                            {
                                log_file << "Line No. " << line_count << ": Error in <VECTOR_TYPE> declaration" << endl;
                                error_line = true;
                            }
                            depth--;
                            if(depth < 0)
                            {
                                log_file << "Line No. " << line_count << ": Error in <VECTOR_TYPE> declaration" << endl;
                                error_line = true;
                            }    
                            vector_lexeme += yytext;
                            if(depth == 0)
                            {
                                token_file << "Line No. " << line_count << ": Token <VECTOR_TYPE> Lexeme " << vector_lexeme << " found" << endl;
                                BEGIN INITIAL;
                            }
                        }
                    }

    {TYPES}         {

                        if(!error_line)
                        {
                            if(seen_type || seen_vector)
                            {
                                log_file << "Line No. " << line_count << ": Error in <VECTOR_TYPE> declaration" << endl;
                                error_line = true;
                            }

                            seen_opening = false;
                            seen_vector = false;
                            seen_type = true;

                            vector_lexeme += yytext;
                        }
                    }
}

.               {  }   

%%

int main(int argc,char *argv[]){

	if(argc < 2)
    {
		printf("Please provide input file name and try again\n");
		return 0;
	}
    
    FILE *input_file = fopen(argv[1],"r");

	if (input_file == NULL)
    {
		printf("Cannot open specified file : %s \n", argv[1]);
		return 0;
	}

	yyin = input_file;
	yylex();

	fclose(yyin);

    log_file << "Total lines: " << line_count << "\n";

	token_file.close();
    log_file.close();
    
	return 0;
}