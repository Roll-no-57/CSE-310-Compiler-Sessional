%{
#include<bits/stdc++.h>
using namespace std;

std::stack<char> bracketStack;
bool matched = true;  // Flag to track if brackets are matched

// Function to check if brackets match
bool isMatchingPair(char opening, char closing) {
    return ((opening == '(' && closing == ')') ||
            (opening == '{' && closing == '}') ||
            (opening == '[' && closing == ']'));
}

std::ofstream logFile;
%}

%%

"("     { bracketStack.push('('); }
"{"     { bracketStack.push('{'); }
"["     { bracketStack.push('['); }

")"     { 
    if (bracketStack.empty() || !isMatchingPair(bracketStack.top(), ')')) {
        matched = false;
    } else {
        bracketStack.pop();
    }
}

"}"     { 
    if (bracketStack.empty() || !isMatchingPair(bracketStack.top(), '}')) {
        matched = false;
    } else {
        bracketStack.pop();
    }
}

"]"     { 
    if (bracketStack.empty() || !isMatchingPair(bracketStack.top(), ']')) {
        matched = false;
    } else {
        bracketStack.pop();
    }
}

[ \t\n] { /* Ignore whitespace */ }

.       { /* Ignore any other characters */ }

%%

int yywrap() {
    return 1;
}

int main() {
    logFile.open("log.txt");
    if (!logFile.is_open()) {
        std::cout << "Error: Could not create log file." << std::endl;
        return 1;
    }
    
    // Initialize variables
    matched = true;
    // Stack is automatically empty when created
    
    // Process input
    yylex();
    
    // Check final result
    if (matched && bracketStack.empty()) {
        logFile << "Brackets are matched." << std::endl;
    } else {
        logFile << "Unmatched brackets." << std::endl;
    }
    
    logFile.close();
    return 0;
}





/* ONLINE C1 ----------------------------------------------------ONLINE C1 */
/* ####################################################################### */


%option noyywrap

%{
#include <iostream>
#include <stack>
#include <string>
using namespace std;

stack<string> tagStack;
bool error_found = false;

void report_error(const string& message) {
    cout << "Invalid HTML: " << message << endl;
    error_found = true;
}
%}

OPEN_HTML     "<html>"
CLOSE_HTML    "</html>"
OPEN_HEAD     "<head>"
CLOSE_HEAD    "</head>"
OPEN_BODY     "<body>"
CLOSE_BODY    "</body>"
OPEN_P        "<p>"
CLOSE_P       "</p>"

%%

{OPEN_HTML}   { if (error_found) return 0; tagStack.push("html"); }
{CLOSE_HTML}  {
    if (error_found) return 0;
    if (tagStack.empty() || tagStack.top() != "html") {
        report_error("tag mismatch </html>");
        return 0;
    }
    tagStack.pop();
}

{OPEN_HEAD}   { if (error_found) return 0; tagStack.push("head"); }
{CLOSE_HEAD}  {
    if (error_found) return 0;
    if (tagStack.empty() || tagStack.top() != "head") {
        report_error("tag mismatch </head>");
        return 0;
    }
    tagStack.pop();
}

{OPEN_BODY}   { if (error_found) return 0; tagStack.push("body"); }
{CLOSE_BODY}  {
    if (error_found) return 0;
    if (tagStack.empty() || tagStack.top() != "body") {
        report_error("tag mismatch </body>");
        return 0;
    }
    tagStack.pop();
}

{OPEN_P}      { if (error_found) return 0; tagStack.push("p"); }
{CLOSE_P}     {
    if (error_found) return 0;
    if (tagStack.empty() || tagStack.top() != "p") {
        report_error("tag mismatch </p>");
        return 0;
    }
    tagStack.pop();
}

"<"[^>]*">"   { if (!error_found) report_error("invalid tag"); return 0; }

[^<]+         ;  // ignore text between tags

%%

int main() {
    yylex();
    if (!error_found) {
        if (!tagStack.empty()) {
            cout << "Invalid HTML: missing closing tag for <" << tagStack.top() << ">" << endl;
        } else {
            cout << "Valid HTML structure" << endl;
        }
    }
    return 0;
}




/* ################################################################ */
/*                       ONLINE A1 SOLUTION                         */



%{
#include<iostream>              // Include input/output stream library
#include<string>                // Include string library
#include<cstdio>                // Include C standard I/O library
#include<stack>                 // Include stack library for bracket matching

using namespace std;            // Use the standard namespace

int line_count=1;               // Initialize line counter to 1
string current_lexeme="";       // String to store the current lexeme being processed
stack<int> bracket_stack;       // Stack to keep track of nested angle brackets
bool is_valid=true;             // Flag to check if the vector type is valid
bool processed_vector=false;    // Flag to check if a vector type was processed in the current line
bool reported=false;            // Flag to check if an error or token was already reported for the current line

// Function to reset the state variables for a new line or after processing a vector type
void reset_state(){
    current_lexeme="";          // Clear the current lexeme
    while(!bracket_stack.empty()){
        bracket_stack.pop();    // Empty the bracket stack
    }
    is_valid=true;              // Reset validity flag
}

%}

%option noyywrap                

%x VECTOR_STATE                 

WHITESPACE [ \t]                
NEWLINE \n|\r\n                 
TYPE int|float|double|char      
%%
^{WHITESPACE}*"vector"{WHITESPACE}*"<" {
    // Start of a vector type declaration at the beginning of a line
    current_lexeme=yytext;          // Store the matched text
    bracket_stack.push(1);          // Push to stack for '<'
    is_valid=true;                  // Assume valid until proven otherwise
    processed_vector=true;          // Mark that a vector is being processed
    reported=false;                 // Reset reported flag
    BEGIN(VECTOR_STATE);            // Switch to VECTOR_STATE for further parsing
}

<VECTOR_STATE>"vector"{WHITESPACE}*"<" {
    // Nested vector type inside another vector
    current_lexeme+=yytext;         // Append matched text to current lexeme
    bracket_stack.push(1);          // Push to stack for nested '<'
}
<VECTOR_STATE>"<" {
    // Handle additional nested '<'
    current_lexeme+="<";            // Append '<' to current lexeme
    bracket_stack.push(1);          // Push to stack
}

<VECTOR_STATE>">" {
    // Handle closing '>'
    current_lexeme+=">";            // Append '>' to current lexeme
    if(!bracket_stack.empty()){
        bracket_stack.pop();        // Pop from stack for matching '>'
        if(bracket_stack.empty()){
            // All brackets matched, end of vector type
            if(is_valid){
                cout<< "Line No. " <<line_count <<": Token <VECTOR_TYPE> Lexeme " <<current_lexeme << " found" <<endl;
            }
            else{
                cout<< "Line No. " <<line_count << ": Error in <VECTOR_TYPE> declaration" <<endl;
            }
            reported=true;          // Mark as reported
            reset_state();          // Reset state for next input
            BEGIN(INITIAL);         // Return to INITIAL state
        }
    }
}
<VECTOR_STATE>{TYPE} {
    // Match valid type inside vector
    current_lexeme+=yytext;         // Append type to current lexeme
}

<VECTOR_STATE>{WHITESPACE}+ {
    // Match and append whitespace inside vector
    current_lexeme+=yytext;         // Append whitespace to current lexeme
}
<VECTOR_STATE>. {
    // Any other character inside vector is invalid
    current_lexeme+=yytext;         // Append invalid character
    is_valid=false;                 // Mark as invalid
}

{WHITESPACE}+ {
    // Ignore whitespace outside vector type
}

{NEWLINE} {
    // Handle end of line
    if(!bracket_stack.empty()){
        // If brackets are not balanced, report error
        cout << "Line No. " << line_count << ": Error in <VECTOR_TYPE> declaration" << endl;
    }
    else if(!processed_vector && !reported){
        // If no vector processed and nothing reported, input is invalid
        cout << "Line No. " << line_count << ": Invalid input" << endl;
    }
    line_count++;                   // Move to next line
    processed_vector=false;         // Reset processed_vector flag
    reported=false;                 // Reset reported flag
    BEGIN(INITIAL);                 // Return to INITIAL state
}

. {
    // Any other character outside vector type
    if(!processed_vector && !reported){
        cout << "Line No. " << line_count << ": Invalid input" << endl;
        reported=true;              // Mark as reported
    }
}

%%

int main(int argc, char **argv) {
    if (argc != 3) {            // Check for correct number of arguments
        cerr << "Usage: " << argv[0] << " input_file output_file" << endl;
        return 1;
    }

    FILE *inputFile = fopen(argv[1], "r"); // Open input file for reading
    if (inputFile == NULL) {    // Check if file opened successfully
        cerr << "Error opening input file." << endl;
        return 1;
    }

    if (freopen(argv[2], "w", stdout) == NULL) { // Redirect stdout to output file
        cerr << "Error opening output file." << endl;
        fclose(inputFile);
        return 1;
    }

    yyin = inputFile;           // Set lex input to input file
    yylex();                    // Start lexical analysis

    fclose(inputFile);          // Close input file
    fclose(stdout);             // Close output file

    return 0;                   // Exit program
}