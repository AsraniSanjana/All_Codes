#include<stdio.h>

#define NULL 0
// insert end , delete begining , delete end isnt working
struct node
{
    int data;
    struct node *next;
};

struct node *first = NULL;
struct node *last = NULL;

void create()
{
    int i,n;
    struct node *pnode, *p;

    printf("Enter the number of nodes required : ");
    scanf("%d",&n);

    printf("Enter the data value of each node\n");
    for(i=1; i<=n; i++)
    {
        pnode = (struct node *)malloc(sizeof(struct node));
        if(pnode == NULL)
        {
            printf("Memory overflow. Unable to create\n");
            return;
        }
        scanf("%d",&pnode->data);
        pnode->next = NULL;

        if(first==NULL)
            first = last = pnode;
        else
        {
            last->next = pnode;
            last = pnode;
        }
        last->next = first;
    }
}
void insert_Beginning(int x)
{
    struct node *pnode, *p;
    pnode = (struct node *)malloc(sizeof(struct node));

    if(pnode==NULL)
    {
        printf("Memory overflow. Unable to create\n");
            return;
    }

    pnode->data = x;
    pnode->next=first;
    first=pnode;
}
/*
void insert_end(int x)
{
     struct node *pnode, *p, *follow;
    pnode = (struct node *)malloc(sizeof(struct node));

    if(pnode==NULL)
    {
        printf("Memory overflow. Unable to create\n");
            return;
    }
else{ pnode->data=x;
    //p= first;
    //follow=NULL;
    // p is temp , ptr is pnode
    if(first==NULL)
    {
        first=pnode;
        pnode->next=first;
    }
    else{ p=first;
    while(p->next!=first)
    {
        //follow=p;
        p=p->next;

    }
    p->next=pnode;
    pnode->next=first;
   //p->next=pnode;
} }
*/
/*
int a;
a=x;
struct node *temp,*first,*p;
temp = (struct node *)malloc(sizeof(struct node));
temp->data=a;
p=first;
while(p->next!=first)
{
    p=p->next;

}
p->next=temp;
temp->next=first;
}







 */
 void insert_end(int x)
{
    struct node *pnode, *p, *follow;
    pnode = (struct node *)malloc(sizeof(struct node));

    if(pnode==NULL)
    {
        printf("Memory overflow. Unable to create\n");
            return;
    }
    pnode->data=x;
    last->next=pnode;
    last=pnode;
    last->next=first;

}
void insert_before(int x, int k)
{
    struct node *pnode, *follow, *p;
    pnode = (struct node *)malloc(sizeof(struct node));
        if(pnode == NULL)
        {
            printf("Memory overflow. Unable to create\n");
            return;
        }

        p=first;
        while(p->next!=first)
        {
            if(p->data==k)
                break;
            follow = p;
            p=p->next;
        }

        if(p->next==first)
            printf("Required node not found\n");
        else
        {
            pnode->data = x;
            if(p==first)
            {
                pnode->next = p;
                first = pnode;
            }
            else
            {
                pnode->next = p;
                follow->next=pnode;
            }
        }
}
void insert_after(int x, int k)
{
    struct node *pnode, *p;
    pnode = (struct node *)malloc(sizeof(struct node));
        if(pnode == NULL)
        {
            printf("Memory overflow. Unable to create\n");
            return;
        }

        p=first;
        while(p->next!=first)
        {
            if(p->data==k)
                break;
            p=p->next;
        }

        if(p->next==first)
            printf("Required node not found\n");
        else
        {
            pnode->data=x;
            pnode->next = p->next;
            p->next = pnode;
        }
}
void delete_node(int k)
{
    struct node *p, *follow;
    p=first;
    follow=NULL;
    while(follow!=last)
    {
        if(p->data==k)
            break;
        follow=p;
        p=p->next;
    }
    if(follow==last)
        printf("Required node not found.");
    else
    {
        if(p==first&&p==last)  //deleting the one and only node
            first=last=NULL;
        else if(p==first)      //deleting the first node
        {
            first=first->next;
            last->next=first;
        }
        else if(p==last)       //deleting the last node
        {
            last=follow;
            last->next=first;
        }
        else                      //deleting any other node
            follow->next=p->next;
        free(p);
    }
}





struct node *delete_beg(struct node *first)
{
struct node *p;
p = first;



while(p -> next != first)
p = p -> next;
p -> next = first -> next;
free(first);
first = p -> next;
return first;
}


void delete_end()
{
struct node *p, *preptr;
p = first;
while(p -> next != first)
{
preptr = p;
p = p-> next;
}
preptr -> next = p-> next;
last=preptr;
free(p);
}


void delete_before(int k)
{
struct node *p,*pnode,*follow;
p=first;
follow=NULL;
while(p!=NULL&&p->next->data!=k)
{
  follow=p;
  p=p->next;
}
if(p==NULL)
{
printf("Required node is not found\n");
}
else
  {
    follow->next=p->next;
    free(p);
  }
}
void delete_After(int k)
{
struct node *p,*pnode,*follow;
p=first;
follow=NULL;
while(p!=NULL)//while(p!=NULL && follow->data!=k)
{
    if(p->data==k)
        break;
  follow=p;
  p=p->next;
}
follow=p;
p=p->next;
if(p==NULL)
{
printf("Required node is not found\n");
return;
}
else
  {
    follow->next=p->next;
    free(p);
  }
}










void traverse()
{
    struct node *p, *follow;
    if(first==NULL)
        printf("Circular linked list is empty\n");
    else
    {
        printf("Circular linked list is as shown : ");
        p=first;
        follow=NULL;
        while(follow!=last)
        {
            printf(" %d ",p->data);
            follow=p;
            p=p->next;
        }
    }
}
void main()
{
    int x, k, ch;
    do
    {
        printf("\n Menu : \n");
        printf("1. Create Linked list.\n");
        printf("2. Add a node after a given node\n");
        printf("3. Add a node before a given node\n");
        printf("4. Add a node in the beginning\n");
        printf("5. Add a node at the end\n");
        printf("6. Delete a node\n");
        printf("7.delete the first node\n");
        printf("8.delete the last node\n");

        printf("9.delete the node before\n");
        printf("10.delete the node after\n");
        printf("11. Traverse\n");
        printf("12. Exit\n");

        printf("Enter your choice : ");
        scanf("%d",&ch);

        switch(ch)
        {
        case 1 :
            create();
            traverse();
            break;
        case 2 :
            printf("Enter the value of the new node\n");
            scanf("%d",&x);
            printf("Enter the data value after which the new node is to be inserted :");
            scanf("%d",&k);
            insert_after(x,k);
            printf("updated ");
            traverse();
            break;
        case 3 :
            printf("Enter the value of the new node\n");
            scanf("%d",&x);
            printf("Enter the data value before which the new node is to be inserted :");
            scanf("%d",&k);
            insert_before(x,k);
            printf("updated ");
            traverse();
            break;

        case 4 :
            printf("Enter the value of the new node\n");
            scanf("%d",&x);
            insert_Beginning(x);
            printf("updated ");
            traverse();
            break;
        case 5 :
            printf("Enter the value of the new node\n");
            scanf("%d",&x);
            insert_end(x);
            printf("updated ");
            traverse();
            break;

        case 6 :
            printf("Enter the value of the node to be deleted\n");
            scanf("%d",&k);
            delete_node(k);
            printf("updated ");
            traverse();
            break;
        case 7:

            first=delete_beg(first);
            printf("updated ");
            traverse();
            break;
        case 8:

           delete_end();
            printf("updated ");
            traverse();
 break;
          case 9:

        printf("\ndelete the node before node with data value:");
        scanf("%d",&k);
        delete_before(k);
      printf("updated ");
            traverse();
        break;

    case 10:

        printf("\ndelete the node after node with data value:");
        scanf("%d",&k);
        delete_After(k);
       printf("updated ");
            traverse();
        break;
     break;
        case 11 :
            traverse();
            break;
        case 12 :
            break;

        }
    }
    while(ch!=12);
}
