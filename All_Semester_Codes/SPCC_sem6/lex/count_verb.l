%{
#include <stdio.h>
#include <string.h>
int verb_count = 0;
int adverb_count = 0;
int adjective_count = 0;
int noun_count = 0;
%}

%x verb_token
%x adverb_token
%x adjective_token
%x noun_token

%%

"run"|"walk"|"jump"|"swim"|"fly"|"eat"|"drink"|"sleep"|"play"|"work" {
    verb_count++;
    BEGIN(verb_token);
}

"quickly"|"slowly"|"happily"|"angrily"|"carefully"|"loudly"|"softly"|"well"|"badly"|"hard" {
    adverb_count++;
    BEGIN(adverb_token);
}
"happy"|"sad"|"angry"|"excited"|"tired"|"strong"|"weak"|"big"|"small"|"fast" {
    adjective_count++;
    BEGIN(adjective_token);
}
"dog"|"cat"|"bird"|"car"|"house"|"tree"|"flower"|"book"|"pencil"|"computer" {
    noun_count++;
    BEGIN(noun_token);
}
<verb_token>.|\n { BEGIN(INITIAL); }
<adverb_token>.|\n { BEGIN(INITIAL); }
<adjective_token>.|\n { BEGIN(INITIAL); }
<noun_token>.|\n { BEGIN(INITIAL); }
%%
int yywrap(){
    return 1;
}
int main(int argc, char *argv[])
{
    yylex();
    printf("Number of verbs: %d\nNumber of adverbs: %d\nNumber of adjectives: %d\nNumber of nouns: %d\n", verb_count, adverb_count,adjective_count,noun_count);
    return 0;
}