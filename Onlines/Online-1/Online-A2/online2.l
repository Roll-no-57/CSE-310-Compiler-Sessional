%option noyywrap

%x STAR_STATE
%x PLUS_STATE


%{

#include <bits/stdc++.h>
using namespace std;

int total_char_in_line = 0;
int line_count=1;
int star_count =0;
int half_star = -1;
int plus_count =0;
int line_char = -1;

ofstream log_file("online_log.txt");


void check_pyramid()
{
    if(line_char == -1 ){
        line_char = total_char_in_line;
    }
    
    if(line_char == total_char_in_line){
        if((half_star != star_count) || (plus_count != (2*line_count))){
            log_file<<"plus or star count doesn't match"<<endl;
        }
        else{

        }
    }
    else {
        log_file<<"Number of char incorrect"<<endl;
    }
}



%}

WHITESPACE       [ \t\f\r\v]
ADD              "+"
STAR              "*"
NEWLINE          "\n"|\r\n


%%

{WHITESPACE} {}

{STAR} {

    total_char_in_line++;
    star_count++;
    BEGIN STAR_STATE;
}

{ADD} {
    plus_count++;
    total_char_in_line++;
    BEGIN PLUS_STATE;
}

<STAR_STATE>{
    {NEWLINE} {
        line_count++;
        line_char=total_char_in_line;
        check_pyramid();
    }
    {STAR} {
        total_char_in_line++;
        star_count++;
    }

    {ADD} {
        half_star = star_count;
        total_char_in_line++;
        plus_count++;
        star_count=0;
        BEGIN PLUS_STATE;   
    }
}


<PLUS_STATE>{
    {NEWLINE} {
        line_count++;
        line_char=total_char_in_line;
        check_pyramid();
    }
    {ADD} {
        plus_count++;
        total_char_in_line++;
    }

    {STAR} {
        star_count++;
        total_char_in_line++;
        BEGIN STAR_STATE;
    }

}

<<EOF>> {
    exit(0);
}

. {}

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

/*
flex b2online.l
g++ lex.yy.c
./a.out b2_in.txt
*/




/*
***+***
**+++**
*++a++*
+++++++


***+***
**+++**
*+++++*
*+++++*


***+***
**++++**
*+++++*
+++++++



****+****
***+++***
**+++++**
*+++++++*
+++++++++


***+++***
**+++**
*+++++*
+++++++


***+***
**+++**
*+++++*
+++++++



*/