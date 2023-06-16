%{
    #include<stdio.h>
    int num;
    int flag;  // flag=0 means even
%}

%%

[0-9]+     {num=atoi(yytext);
           if(num%2==0) { flag=0;}
           else { flag=0;}
                
}

%%
int yywrap() {
    return 1;
}

int main() {
printf("enter an integer: ");
yylex();
if (flag==0) {
printf("%d is an even integer.\n",num); }
else printf("%d is an even integer.\n",num); 

	return 0;

}


