%option noyywrap
%x KEYWORD_STATE
%x BRACE_STATE

%{
#include <bits/stdc++.h>
using namespace std;

ofstream log_file("b2_log.txt");

bool is_unsupported = false;
bool is_not_followed_by_brace = false;
bool is_unmatched = false;

stack<char> braces;

void handle_char_stream()
{
    is_unmatched = !braces.empty();

    if (is_unsupported) {
        log_file << "Error: unsupported command" << endl;
    }
    else if (is_not_followed_by_brace) {
        log_file << "Error: command not followed by brace block" << endl;
    }
    else if (is_unmatched) {
        log_file << "Error: unmatched " << braces.top() << endl;
    }
    else {
        log_file << "Valid LaTeX syntax" << endl;
    }
}
%}

WHITESPACE          [ \t\f\r\v]
KEYWORD             \\(textbf|textit|section)
LCURL               \{
RCURL               \}
INVALID_KEYWORD     \\[a-zA-Z]+

%%

{WHITESPACE} {}

{KEYWORD}   {
    // Reset flags for each keyword
    is_unsupported = false;
    is_not_followed_by_brace = false;
    BEGIN KEYWORD_STATE;
}

{INVALID_KEYWORD}   {
    is_unsupported = true;
}

<KEYWORD_STATE>{
    {LCURL} {
        braces.push('{');
        BEGIN BRACE_STATE;
    }
    <<EOF>> {
        is_not_followed_by_brace = true;
        handle_char_stream();
        exit(0);
    }
    \n|\r|\t|[^ \t\f\r\v\{] {
        is_not_followed_by_brace = true;
    }
}

<BRACE_STATE>{
    {LCURL} {
        braces.push('{');
    }
    {RCURL} {
        if (!braces.empty() && braces.top() == '{') {
            braces.pop();
        } else {
            is_unmatched = true;
        }

        if (braces.empty()) {
            BEGIN INITIAL;
        }
    }
    {KEYWORD} {
        // Handle nested keyword
        is_unsupported = false;
        is_not_followed_by_brace = false;
        BEGIN KEYWORD_STATE;
    }
    {INVALID_KEYWORD} {
        is_unsupported = true;
    }
    <<EOF>> {
        is_not_followed_by_brace = true;
        handle_char_stream();
        exit(0);
    }
    . {}
}

<<EOF>> {
    handle_char_stream();
    exit(0);
}

. {}

%%

int main(int argc, char* argv[])
{
    if (argc != 2) {
        cout << "Please provide the input file name as a command line argument." << '\n';
        return 1;
    }

    FILE* input_file = fopen(argv[1], "r");
    if (input_file == NULL) {
        cout << "Error opening input file." << '\n';
        return 1;
    }

    if (!log_file.is_open()) {
        cerr << "Error: Failed to open output files!" << endl;
        exit(1);
    }

    yyin = input_file;
    yylex();

    fclose(input_file);
    log_file.close();

    return 0;
}
