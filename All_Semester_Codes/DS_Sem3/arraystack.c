#include<stdio.h>
#define STACKSIZE 4 // maximum no. of elements that can be in stack will be 4
// implementing stack ADT using arrays
struct stack
{
    int top;
    int items[STACKSIZE];
};
void push(struct stack*ps,int x)
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
int pop(struct stack *ps)
{
    if(empty(ps)){
        printf("stack underflow cannot pop\n");
        exit(1);
    }
    return ps->items[(ps->top)--];
}
int stacktop(struct stack s)
{
    if(empty(&s))
    {
        printf("stack underflow cannot peek\n");
        exit(1);
    }
    return s.items[(s.top)];
}
void show(struct stack s)
{
    int i;
    printf("elements in stack now (The left-est element is top of the stack):");
    for(i=s.top;i>=0;i--)
        printf("%d ",s.items[i]);
}
void main()
{
    int x,ch;
    struct stack s;
    s.top=-1;
    do{
        printf("\n menu:\n");
        printf("1.push\n");
        printf("2.pop\n");
        printf("3.stacktop\n");
        printf("4.exit\n");
        printf("  enter your choice no.:");
        scanf("%d",&ch);
        switch(ch)
        {
        case 1:
            printf("enter an element to be pushed\n");
            scanf("%d",&x);
            push(&s,x);
            show(s);
            break;
        case 2:
            x=pop(&s);
            printf("element which is popped is %d\n",x);
            show(s);
            break;
        case 3:
            x=stacktop(s);
            printf("top most value of stack is %d \n",x);
            break;

        case 4:
            break;
        }

    }while(ch!=4);
}


