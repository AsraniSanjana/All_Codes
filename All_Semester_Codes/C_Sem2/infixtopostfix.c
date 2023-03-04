#include <stdio.h>

#define STACKSIZE 50

struct stack
 {
 int top;
 char items[STACKSIZE] ;
};
void postfix(char ie[ ], char oe[]);
int isoperand(char c);
int prcd(char st , char cs) ;
int empty(struct stack *ps);
char pop(struct stack *ps);
void push(struct stack *ps , char x);
char stacktop(struct stack *ps);

void main()
{

char ie[50], oe[50]; // ie means infix expression and oe means postfix expression

printf("Enter the expression in infix form:\n");
scanf("%s",ie);
postfix(ie,oe);
printf("Equivalent postfix expression is:\n%s",oe);
}

void postfix (char ie[],char oe[])
{ int i,j;
char ts,cs;

struct stack s;
s.top=-1;

for(i=0, j=0;(cs=ie[i])!='\0'; i++)
 if(isoperand(cs))
 oe[j++]=cs;
else
{


while( !empty(&s) && prcd(stacktop(&s),cs) )
{


ts=pop(&s);

oe[j++]=ts ; }

if(empty(&s)||cs!=')')
push(&s,cs);

else

ts=pop(&s);

}

while(!empty(&s))

oe[j++]=pop(&s);

oe[j]='\0';
}
 int prcd(char st,char cs)  // function to check precedence of operators
{
switch(st)
{ case '+' :
  case '-' :
  if (cs=='+'|| cs=='-') return 1;

  if (cs=='*'|| cs=='$'|| (cs=='(' ))    // $ is exponential , it is mathematically equal to power function (raise to)
  return 0;

  break;
  case '$':
  if (cs=='+'|| cs=='-' || cs=='*'|| cs=='/' || cs==')' )
  return 1;
  if (cs=='('|| cs=='$')
  return 0;
  break;

  case '*' :
  case '/' :
  if (cs=='+'|| cs=='-' ||cs=='*')
  return 1;

  if (cs=='$' || cs=='(' )
  return 0;
  break;
  }


}



 int isoperand(char c)
  {
  if(c>='A'&&c<='Z'||c>='a'&&c<='z'||c>='0'&&c<='9')
  return 1;

else

return 0;
 }

int empty(struct stack *ps)
{ if(ps->top==-1)

return 1;
 else

return 0;
}

char pop(struct stack *ps)
 {

return (ps->items[(ps->top)--]);
}

char stacktop(struct stack *ps)
{

return (ps->items[ps->top]) ;
 }

void push(struct stack *ps , char x)
{
 if(ps->top==STACKSIZE-1)
  {
       printf("Stack Overflow, Cannot push \n");
   exit(1);
    }
     ps->items[++(ps->top)]=x ;
}
//code for infix to postfix
