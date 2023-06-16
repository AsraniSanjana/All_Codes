
%{
    int vow_count=0;
    int const_count =0;
%}
 
%%
[aeiouAEIOU] {vow_count++;}
[a-zA-Z] {const_count++;}
%%
int yywrap(void) {
return 1;
}
int main()
{
    printf("Enter the string of vowels and consonants:");
    yylex();
    printf("Number of vowels and consonants are:  %d & %d", vow_count,const_count);
    return 0;
}