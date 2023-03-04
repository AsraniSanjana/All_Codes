#include<stdio.h>
#include<math.h>
#include<ctype.h>
#include<string.h>
#define MAX 20
float a[MAX] ;
int top = -1 ;

void push( float a[], float val ) ;
float pop ( float a[] ) ;
float evaluate ( char exp[] ) ;
int main()
{   int i=0;
int count=0;
int j=0;
    int operandcount=0;
    int operatorcount=0;
    int flag=0;
    float val ;
    char exp[50] ;
    printf(" Enter the postfix expression and put space between 2 operators/operands : ") ;
    gets(exp) ;
   // valid();
  /*
   for(int i=0;exp[i]!='\0';i++)
{
    if (isdigit(exp[i]) && isdigit(exp[i+1]) )
    {      flag=1;
          operandcount++; }

         else  if (i>1)
         {
             if  (((isdigit(exp[i-1])) &&  (exp[i+2])==' ' )
   {
       operandcount++;
   }
*/
/*
    while (exp[i]!='\0') {
        if (isdigit(exp[i])) {

            for (j = i + 1; exp[j]!='\0'; j++) {
                if (exp[j] == ' ') {
                    count++;
                    break;
                }
            }
        }

        i = j + 1;
    }

printf("\ncount is :%d", count);
*/
   //   if ((exp[i]=='+') || ( exp[i]=='-') || ( exp[i]=='*')||( exp[i]=='/')||( exp[i]=='%')|| ( exp[i]=='^')||( exp[i]=='$') )
   // operatorcount++;

 // printf("no. of operands= %d\n",operandcount);
  //  printf("no. of operators= %d\n",operatorcount);


  // if (operatorcount==operandcount-1)
  // {
        val = evaluate(exp) ;

 printf("\n The solution of the entered string is : %.3f", val) ;
  // else if (operandcount!=operatorcount-1)
  //  printf("invalid postfix expression");
    return 0 ;
}

void push( float a[], float val )
{
    if( top == MAX-1 )
    {
       printf("\n STACK OVERFLOW") ;
    }
    else
    {
        a[++top] = val ;
    }
}

float pop( float a[] )
{
    float val = -1 ;
    if( top == -1 )
    {
        printf("\n STACK UNDERFLOW\n") ;
    }
    else
    {
        val = a[top--] ;
    }

    return val ;
}

float evaluate ( char exp[] )
{
    int i=0 ;
    float op1, op2, value ;
    while( exp[i] != '\0' )
    {
        if( isdigit(exp[i]) && isdigit(exp[i+1]) ) // if 2 continuous characters are numbers
        {

            value = 10*(exp[i]-'0') + (exp[i+1]-'0') ;
            push(a, value) ;
            i++ ;
        }
        else if ( (isdigit(exp[i])) && (exp[i+1] == ' ') )  //if entered current character is something and next character is a space
        {
            push(a, (exp[i]-'0')) ;
        }
        else if ( exp[i] == ' ' )   //if current character is a space
        { }    // do nothing
        else  if ((exp[i]=='+') || ( exp[i]=='-') || ( exp[i]=='*')||( exp[i]=='/')||( exp[i]=='%')|| ( exp[i]=='^')||( exp[i]=='$') ) // current character is  a operator
        {
            op1 = pop(a) ;
            op2 = pop(a) ;

            switch( exp[i] )
            {
                case '+' :
                    value = op2 + op1 ;
                    break ;

                case '-' :
                    value = op2 - op1 ;
                    break ;

                case '*' :
                    value = op2 * op1 ;
                    break ;

                case '/' :
                    value = op2 / op1 ;
                    break ;

                case '%' :
                    value = (int)op2 % (int)op1 ;
                    break ;
                case '$' :
                case '^':
                    value = pow(op2,op1);
                    break;
                default:
                    printf("invalid operator\n");
                    break;
            }
            push (a, value) ;
        }
        i++ ;
    }

    return (pop(a)) ;

}



/*

#include <stdio.h>
#include<string.h>
#define MAX_LIMIT 20
int main()
{
    int i = 0, count = 0,j ;
    printf("Enter 2 operands:\n");
    char str[MAX_LIMIT];
    fgets(str, MAX_LIMIT, stdin);

    printf("%s", str);
   // printf("%d", strlen(str));

    for(i=0; i < strlen(str); i = j + 1) {
        printf("\nInside while: %d\n", i);
    	if (isdigit(str[i])) {
    	    printf("\ni is digit");
    		for ( j=i+1; j < strlen(str) ; j++)
    		{
    		    printf("\nInside for loop");
    			if (str[j] == ' ') {
    			    count++;
    				break;
    			}
    		}
    	}
    }

    printf("%d", count);

    return 0;
}
*/
