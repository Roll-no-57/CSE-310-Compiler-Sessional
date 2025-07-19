%x VECTOR_STATE

%{
    #include<bits/stdc++.h>
    using namespace std;
    bool flag=false;
    stack<string>st;
    int line_count=0;
    string current_lexeme;
%}
NEWLINE          "\n"
WHITESPACE 		 [ \t\f\r\v]
TYPE            "int"|"float"|"double"

%%
{NEWLINE} {
    line_count++;
}
{WHITESPACE}*"vector"{WHITESPACE}*"<" {
    current_lexeme=yytext;
    st.push("<");
    BEGIN(VECTOR_STATE);
}
<VECTOR_STATE>"vector"{WHITESPACE}*"<" {
    current_lexeme+=yytext;
    st.push("<");
}
<VECTOR_STATE>{TYPE} {
    current_lexeme+=yytext;
}
<VECTOR_STATE>">" {
    if(!st.empty()){
        current_lexeme+=">";
        string s=st.top();
        st.pop();
    }
    else{
        flag=true;
    }
}

<VECTOR_STATE>{WHITESPACE}* {
    current_lexeme+=yytext;
}
<VECTOR_STATE>{NEWLINE} {
    line_count++;
    if(!st.empty()){
        cout<<"ERROR OCCURS"<<endl;
        flag=true;
    }
}
<VECTOR_STATE>. {
    flag=true;
}

{WHITESPACE}   {
    current_lexeme+=yytext;
}

%%
int yywrap(){
    return 1;
}


int main(){
    yylex();
    cout<<line_count<<endl;
    if(flag){
        cout<<"Error"<<endl;
    }
    else{
        cout<<current_lexeme<<endl;
    }
}