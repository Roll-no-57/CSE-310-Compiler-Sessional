%option noyywrap

%x STAR_STATE
%x PLUS_STATE


%{

#include <bits/stdc++.h>
using namespace std;

int total_char_in_line = 0;
int line_count=0;
int star_count =0;
int half_star = -1;
int plus_count =0;
int line_char = -1;

bool is_invalid = false;
bool is_star_equal = false;
bool is_plus_correct = false;
bool is_correct_eof = true;

ofstream log_file("online_log.txt");

void error(string msg){
    log_file<<"Error:" + msg<<endl;
}


void printall(){
    cout<<"half_star "<<half_star<<endl;
    cout<<"star_count "<<star_count<<endl;
    cout<<"plus_count "<<plus_count<<endl;
    cout<<"line_char "<<line_char<<endl;
    cout<<"line_count "<<line_count<<endl;
}


void check_final(){
    //printall();
    if(line_char !=  plus_count) {error("Wrong eof");return;}

}

void check_pyramid()
{

    printall();


    if(is_invalid){
        error("Invalid character");
        return;
    }

    if(line_char == -1 ){
        line_char = total_char_in_line;
    }

    cout<<"line char :"<< line_char<<"total :" <<total_char_in_line<<endl;
    // if(line_char != total_char_in_line  ){
    if(plus_count != (2*line_count-1)){
        error("Plus count doens't match");
    }
    if(half_star!=star_count){
        error("start count doens't match");
    }
    // }


    if(line_char ==  plus_count){
        log_file<<"pattern matched "<<endl;;
        return;
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
        
        check_pyramid();
        total_char_in_line=0;
        star_count=0;
        half_star=0;
        plus_count=0;
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

    . {is_invalid = true;}
}


<PLUS_STATE>{
    {NEWLINE} {
        line_count++;
        check_pyramid();
        total_char_in_line=0;
        star_count=0;
        half_star=-1;
        plus_count=0;
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

    . {is_invalid = true;}

}

<<EOF>> {
    // check_final();
    exit(0);
}

. {is_invalid = true;}

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