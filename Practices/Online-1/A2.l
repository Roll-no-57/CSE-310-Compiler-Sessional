%option noyywrap

%x EXPECT_KEY
%x EXPECT_COLON
%x EXPECT_VALUE
%x EXPECT_COMMA_OR_CLOSE

%{
#include <bits/stdc++.h>
using namespace std;

stack<char> braces;

bool is_qouted_string = false;  // Note: Keeping original typo from provided code
bool is_missing_operator = false;
bool is_unmatched = false;

ofstream log_file("A2_log.txt");

void handle_char_stream()
{
    is_unmatched = !braces.empty();

    if(is_qouted_string)
    {
        log_file << "Error: must be a quoted string";
    }
    else if(is_missing_operator)
    {
        log_file << "Error: Missing separator";
    }
    else if(is_unmatched)
    {
        log_file << "Error: unmatched " << braces.top();
    }
    else
    {
        log_file << "Valid JSON Structure";  // Adjusted to match sample output
    }
}
%}

WHITESPACE      [ \t\f\r\v\n]+
QUOTED_STRING   \"[^\"]*\"
COLON           :
COMMA           ,
LCURL           \{
RCURL           \}

%%

{WHITESPACE} {}

<INITIAL>{
    {LCURL} {
        braces.push('{');
        BEGIN EXPECT_KEY;
    }

    . {
        is_unmatched =true;
      }
}

<EXPECT_KEY>{
    {QUOTED_STRING} { BEGIN EXPECT_COLON; }
    {RCURL}         {
                        if (!braces.empty()) {
                            braces.pop();
                            if (!braces.empty()) {
                                BEGIN EXPECT_COMMA_OR_CLOSE;
                            } else {
                                BEGIN INITIAL;  // JSON fully parsed
                            }
                        } else {
                            is_unmatched = true;
                        }
                    }

    {WHITESPACE}    { /* Ignore whitespace */ }

    .               { is_unmatched = true; }
}

<EXPECT_COLON>{
    {COLON}         { BEGIN EXPECT_VALUE; }
    {WHITESPACE}    { /* Ignore whitespace */ }
    .               { is_missing_operator = true; }
}

<EXPECT_VALUE>{
    {QUOTED_STRING} { BEGIN EXPECT_COMMA_OR_CLOSE; }
    {LCURL} {
        braces.push('{');
        BEGIN EXPECT_KEY;
    }
    {WHITESPACE}    { /* Ignore whitespace */ }
    .               { is_qouted_string = false; }
}

<EXPECT_COMMA_OR_CLOSE>{
    {COMMA}         { BEGIN EXPECT_KEY; }
    {RCURL}         {
                        if (!braces.empty()) {
                            braces.pop();
                            if (!braces.empty()) {
                                BEGIN EXPECT_COMMA_OR_CLOSE;
                            } else {
                                BEGIN INITIAL;  // JSON fully parsed
                            }
                        } else {
                            is_unmatched = true;
                        }
                    }
    {WHITESPACE}    { /* Ignore whitespace */ }
    .               { is_unmatched = true; }
}

<<EOF>> {
    handle_char_stream();
    exit(0);
}

%%

int main(int argc, char* argv[])
{
    if(argc != 2)
    {
        cout << "Please provide the input file name as a command line argument." << '\n';
        return 1;
    }

    FILE* input_file = fopen(argv[1], "r");
    if(input_file == NULL)
    {
        cout << "Error opening input file." << '\n';
        return 1;
    }

    if(!log_file.is_open()) 
    {
        cerr << "Error: Failed to open output files!" << endl;
        exit(1);
    }

    yyin = input_file;

    yylex();

    fclose(input_file);
    log_file.close();

    return 0;
}