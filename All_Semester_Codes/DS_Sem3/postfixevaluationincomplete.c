/*
#include<stdio.h>
#include<math.h>
#define STACKSIZE 50
// 1. check if entered postfix expression is correct or not..validilty
// 2. make the program work for 2 digit numbers
//3. or simply consider the whole thing a character until a space is scanned
// i.e. 3 4 + -> this way would work for  13 181 * too
// i have  made a count variable to keep count for number of operands and operators , how do i access them
// how do i make this program run and ask for postfix exp to evaluate again and again, until i press a certain key
 struct stack
 {
 int top;
 float items[STACKSIZE];
};
int ct=0;
int cd=0;
int operand=0;
int opertor=0;
int cp,cpp;

float evaluate(char e[]);
int isoperand(char c);
float oper(char c,float op1, float op2);
int empty(struct stack *ps);
float pop(struct stack *ps);
void push(struct stack *ps,float x);
int countoperand(char cd); //cd
int countoperator(char ct);  // ct // 34+

int main()
{

char e[50];

printf("Enter the expression in postfix form:\n");
gets(e);

for(int i=0;e[i]!='\o';i++)
{
    cp=countoperand(e[i]);
    cpp=countoperator(e[i]);
}
if (cp==cpp+1 )

printf("Value of the expression is: %f", evaluate(e));

else

    printf("invalid postfix evaluation");
return 0;
}

int countoperand(char cd)
{  if (isoperand(cd))
    operand++;
    printf(operand);
    return operand;
}
int countoperator(char ct)
{    if(!isoperand(ct))
    opertor++;
    printf(opertor);
    return opertor;
}

// This function will return true if the given character is an operand

int isoperand(char c) // if the scanned character of input string is a number
{
    if(c>='0'&&c<='9')
{
return 1;}

 else

return 0;
}

void push(struct stack *ps,float x)
{

    if(ps->top==STACKSIZE-1)
    {
        printf("stackoverflow cannot push\n");
        exit(1);
    }
    ps->items[++(ps->top)]=x;
}

int empty(struct stack *ps)
{
    if(ps->top==-1)
        return 1;
    else
        return 0;
}

float pop(struct stack *ps)
{
    if(empty(ps)){
        printf("stack underflow cannot pop\n");
        exit(1);
    }
    return ps->items[(ps->top)--];
}
float evaluate(char e[])
{
int i;
float op1,op2,value,x;
struct stack s;
s.top=-1;
for (i=0;e[i]!='\0';i++)
{if (isoperand(e[i]))
{
     x=e[i]-'0'; // converting charaters numbers to numbers
     // how will we convert the charcter number to number if char num is 2 digit or 3 digit...
push(&s,x);

}
else  {
    // the current string character is a operator i.e. +,-/*

        op2=pop(&s);
op1=pop(&s);
value=oper(e[i],op1,op2);
push(&s,value);
}
}
return (pop(&s));
}
float oper(char c,float op1,float op2)
{  switch(c)
{ case '+' : return (op1+op2); break;
case '-' : return (op1-op2);break;
case '*' : return (op1*op2);break;
case '/' : return (op1/op2);break;
case '%' : return ((pow(op1,op2)));break;  // % means raise to

default: printf("\n illegal operation,");
exit(1);
}
}
*/
/******************************************************************************

                            Online C Compiler.
                Code, Compile, Run and Debug C program online.
Write your code in this editor and press "Run" button to compile and execute it.

*******************************************************************************/

#include<stdio.h>
#include<math.h>
#define STACKSIZE 50

 struct stack
 {
 int top;
 float items[STACKSIZE];
};

float evaluate(char e[]);
int isoperand(char c);
float oper(char c,float op1, float op2);
int empty(struct stack *ps);
float pop(struct stack *ps);
void push(struct stack *ps,float x);


int main()
{

char e[50];

printf("Enter the expression in postfix form:\n");
gets(e);
printf("Value of the expression is: %f", evaluate(e));

return 0;
}

/* This function will return true if the given character is an operand */

int isoperand(char c) // if the scanned character of input string is a number
{
    if(c>='0'&&c<='9')
{
return 1;}

 else

return 0;
}

void push(struct stack *ps,float x)
{

    if(ps->top==STACKSIZE-1)
    {
        printf("stackoverflow cannot push\n");
        exit(1);
    }
    ps->items[++(ps->top)]=x;
}

int empty(struct stack *ps)
{
    if(ps->top==-1)
        return 1;
    else
        return 0;
}

float pop(struct stack *ps)
{
    if(empty(ps)){
        printf("stack underflow cannot pop\n");
        exit(1);
    }
    return ps->items[(ps->top)--];
}
float evaluate(char e[])
{
int i;
float op1,op2,value,x;
struct stack s;
s.top=-1;
for (i=0;e[i]!='\0';i++)
{if (isoperand(e[i]))
{
     x=e[i]-'0';
push(&s,x);

}
else  {   // the current string character is a operator i.e. +,-*/%

        op2=pop(&s);
op1=pop(&s);
value=oper(e[i],op1,op2);
push(&s,value);
}
}
return (pop(&s));
}
float oper(char c,float op1,float op2)
{  switch(c)
{ case '+' : return (op1+op2); break;
case '-' : return (op1-op2);break;
case '*' : return (op1*op2);break;
case '/' : return (op1/op2);break;
case '%' : return ((pow(op1,op2)));break;

default: printf("\n illegal operation,");
exit(1);
}
}
