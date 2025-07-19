%{
#include <iostream>
#include <stack>
#include <string>
using namespace std;

stack<char> brace_stack;
bool error_found = false;
bool expecting_key = true;     // true for key, false for value
bool expecting_colon = false;
bool expecting_comma_or_close = false;

void report_error(const string& message) {
    if (!error_found) {
        cout << "Error: " << message << endl;
        error_found = true;
    }
}

void reset_expectations() {
    expecting_key = true;
    expecting_colon = false;
    expecting_comma_or_close = false;
}
%}

%option noyywrap
%option c++

WHITESPACE  [ \t\n\r]
STRING      \"[^\"]*\"
DIGIT       [0-9]

%%

"{"             { 
    brace_stack.push('{');
    reset_expectations();
}

"}"             { 
    if (brace_stack.empty()) {
        report_error("unmatched {");
        return 0;
    }
    brace_stack.pop();
    expecting_comma_or_close = false;
}

{STRING}        {
    if (expecting_key) {
        expecting_key = false;
        expecting_colon = true;
    } else if (!expecting_colon && !expecting_comma_or_close) {
        expecting_comma_or_close = true;
    } else {
        report_error("unexpected string");
        return 0;
    }
}

":"             {
    if (!expecting_colon) {
        report_error("Missing separator");
        return 0;
    }
    expecting_colon = false;
}

","             {
    if (!expecting_comma_or_close) {
        report_error("unexpected comma");
        return 0;
    }
    expecting_key = true;
    expecting_comma_or_close = false;
}

{DIGIT}+        {
    report_error("must be a quoted string");
    return 0;
}

[a-zA-Z_][a-zA-Z0-9_]*  {
    report_error("must be a quoted string");
    return 0;
}

{WHITESPACE}+   { /* ignore whitespace */ }

<<EOF>>         {
    if (error_found) {
        return 0;
    }
    if (!brace_stack.empty()) {
        report_error("unmatched {");
    } else {
        cout << "Valid JSON Structure" << endl;
    }
    return 0;
}

.               {
    report_error("invalid character");
    return 0;
}

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

    fclose(yyin);

    return 0;
}