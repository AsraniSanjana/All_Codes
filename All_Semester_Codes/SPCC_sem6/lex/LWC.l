%{
#include <stdio.h>
#include <string.h>
int word_count = 0, char_count = 0, line_count = 0;
%}

%%
[A-Za-z]+ { word_count++; char_count += strlen(yytext); }
. { char_count++; }
\n { line_count++; }
%%

int yywrap() {
 return 1; 
}

int main() {
 yylex();
 printf("Word count: %d\nCharacter count: %d\nLine count: %d\n ", word_count, char_count, line_count);
 return 0;
}
