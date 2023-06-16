%{
#include<stdio.h>
int p=0,s=0;
%}
%%
printf p++;
scanf s++;
%%
int yywrap() {
 return 1; 
}
int main()
{
yyin = fopen("randomFile.c", "r");
yylex();
printf("Number of printf = %d and number of scanf = %d\n",p,s);
return 0;
}