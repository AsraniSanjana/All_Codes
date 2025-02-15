%{
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
char * createT(); // Declaration for creating the temporary variables
int tempcount=0; // Global variable to track the number of temporary varaiables
%}
%union { char str[30]; }

// Redefining the datatype of yylval using union declaration, which is int by default

%left '+'
%left '-'
%left '*'
%left '/'
%token <str> Var // Defining the datatype of Tokens as str
%token <str> Num
%type <str> s // Defining the datatypes of Non-Terminals
%type <str> exp
%%
s : Var '=' exp {printf("\n%s=%s\n",$1,$3);}
exp : '(' exp ')' {strcpy($$,$2);}
	| exp '+' exp {strcpy($$ ,createT()); printf("\n%s=%s+%s",$$,$1,$3);}
	| exp '-' exp {strcpy($$ ,createT()); printf("\n%s=%s-%s",$$,$1,$3);}
	| exp '*' exp {strcpy($$ , createT()); printf("\n%s=%s*%s",$$,$1,$3);}
	| exp '/' exp {strcpy($$ , createT()); printf("\n%s=%s/%s",$$,$1,$3);}
	| Num {strcpy($$,$1);}
	| Var {strcpy($$, $1);}
;
%%
char * createT()
{
char snum[30],*ptr; // Declaring the string array and pointer variable
sprintf(snum,"t%d",tempcount); // Returning a formatted String
ptr=snum; // Intializing the pointer with formatted string
tempcount++; // Temporary count
return ptr; // Returning the pointer
}
int main()
{
yyparse();
return 0;
}
int yyerror(char *err)
{
printf("\nInvalid");
exit(0);
}
