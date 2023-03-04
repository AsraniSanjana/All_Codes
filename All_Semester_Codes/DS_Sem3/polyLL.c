
#include<stdio.h>
#define NULL 0
struct node{
int c;
int pw;
struct node *next;
};

struct node *first1,*first2,*first3;

void create(int flag)
{
     int i,n;
     struct node *pnode,*p;
     struct node *first=NULL;
     printf("enter the number of terms in the polynomial:");
     scanf("%d",&n);
     printf("enter the coefficient and power of each term(higher to lower):\n");
     for(i=1;i<=n;i++)
     {
          pnode=(struct node*)malloc(sizeof(struct node));
          scanf("%d%d",&pnode->c,&pnode->pw);
          pnode->next=NULL;
          if(first==NULL)
          {
              first=p=pnode;
          }
          else
          {
              p->next=pnode;
              p=pnode;
          }

          }

if (flag==1)
    first1=first;
if(flag==2)
    first2=first;
}
 void add()
 {
     struct node *p,*p1,*p2,*pnode;
     if(first1==NULL && first2==NULL)
        return;
     p1=first1;
     p2=first2;
     while(p1!=NULL && p2!=NULL)
     {
         pnode=(struct node *)malloc(sizeof(struct node));
         pnode->next=NULL;
         if(first3==NULL)
            first3=p=pnode;
         else{
            p->next=pnode;
            p=pnode;

         }
         if(p1->pw==p2->pw)
         {
              p->c=p1->c + p2->c;
              p->pw=p1->pw;
              p1=p1->next;
              p2=p2->next;
         }
         else if(p1->pw>p2->pw)
            {
             p->c=p1->c;
            p->pw=p1->pw;
            p2=p->next;
         }
         else{
            p->c=p2->c;
            p->pw=p2->pw;
            p2=p2->next;
         }
     }

     //Elements remaining in polynomial 1 but not 2
while(p1!=NULL)
{
 pnode=(struct node*)malloc(sizeof(struct     node));
 pnode->next=NULL ;

 if (first3==NULL)
       first3=p=pnode;
 else
 {
        p->next=pnode ;
        p=pnode ;
 }

 p->c=p1->c ;
 p->pw=p1->pw ;

 p1=p1->next ;
}

//Elements remaining in polynomial 2 but not 1
while(p2!=NULL)
{
 pnode=(struct node*) malloc( sizeof( struct node)) ;
 pnode->next=NULL ;

 if(first3==NULL)
        first3=p=pnode ;
 else
 {
      p->next=pnode ;
      p=pnode ;
 }
 p->c=p2->c ;
 p->pw=p2->pw ;

 p2=p2->next ;
 }
 }

 void subtract()
 {
     struct node *p,*p1,*p2,*pnode;
     if(first1==NULL && first2==NULL)
        return;
     p1=first1;
     p2=first2;
     while(p1!=NULL && p2!=NULL)
     {
         pnode=(struct node *)malloc(sizeof(struct node));
         pnode->next=NULL;
         if(first3==NULL)
            first3=p=pnode;
         else{
            p->next=pnode;
            p=pnode;

         }
         if(p1->pw==p2->pw)
         {
              p->c=p1->c - p2->c;
              p->pw=p1->pw;
              p1=p1->next;
              p2=p2->next;
         }
         else if(p1->pw>p2->pw)
            {
             p->c=p1->c;
            p->pw=p1->pw;
            p2=p->next;
         }
         else{
            p->c=p2->c;
            p->pw=p2->pw;
            p2=p2->next;
         }
     }

     //Elements remaining in polynomial 1 but not 2
while(p1!=NULL)
{
 pnode=(struct node*)malloc(sizeof(struct     node));
 pnode->next=NULL ;

 if (first3==NULL)
       first3=p=pnode;
 else
 {
        p->next=pnode ;
        p=pnode ;
 }

 p->c=p1->c ;
 p->pw=p1->pw ;

 p1=p1->next ;
}

//Elements remaining in polynomial 2 but not 1
while(p2!=NULL)
{
 pnode=(struct node*) malloc( sizeof( struct node)) ;
 pnode->next=NULL ;

 if(first3==NULL)
        first3=p=pnode ;
 else
 {
      p->next=pnode ;
      p=pnode ;
 }
 p->c=p2->c ;
 p->pw=p2->pw ;

 p2=p2->next ;
 }
 }
     void traverse(struct node *first)
     {
          struct node *p;
          if(first==NULL)
            printf("polynomial empty.\n");
          else{
            p=first;
            while(p->next!=NULL)
            {
                printf("%dx^%d+",p->c,p->pw);
                p=p->next;
            }
            printf("%dx^%d",p->c,p->pw);
            printf("\n");
          }
     }

     void main()
     {  int p;
         first1=first2=first3=NULL;
         printf("creating first polynomial:\n");
         create(1);
         traverse(first1);
         printf("creating second polynomial:\n");
         create(2);
         traverse(first2);
     printf("enter 1 to add these polynomials:\n");
     printf("enter 2 to subtract:\n");
     scanf("%d",&p);
     if(p==1)
       {  printf("sum of the two polynomials:\n");
         add();
         traverse(first3); }
         else if(p==2)
         {printf("difference of the two polynomials:\n");
         subtract();
         traverse(first3);
         }

     }



