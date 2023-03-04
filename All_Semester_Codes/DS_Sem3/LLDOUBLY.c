#include<stdio.h>
#include<stdlib.h>
#define NULL 0

struct node
{
    int data;
    struct node *next, *prev;
};
struct node *first=NULL;
struct node *last=NULL;

void create()
{
    int i,n;
    struct node *pnode;
    printf("Enter the number of nodes required : \n");
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

        if(first==NULL)
        {
            first=last=pnode;
            pnode->prev =pnode->next=NULL;
        }
        else
        {
            last->next=pnode;
            pnode->prev=last;
            pnode->next=NULL;
            last=pnode;
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
        while(p!=NULL)
        {
            if(p->data==k)
                break;
            p=p->next;
        }

        if(p==NULL)
            printf("Required node not found\n");
        else
        {
            pnode->data=x;
            if(p==last)
            {
                p->next=pnode;
                pnode->prev=p;
                pnode->next=NULL;
                last=pnode;
            }
        else
        {
            pnode->next=p->next;
            p->next->prev=pnode;
            p->next=pnode;
            pnode->prev=p;
        }
        }
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
        while(p!=NULL)
        {
            if(p->data==k)
                break;
            follow = p;
            p=p->next;
        }

        if(p==NULL)
            printf("Required node not found\n");
        else
        {
            pnode->data = x;
            if(p==first)
            {
                pnode->next = p;
                p->prev=pnode;
                pnode->prev=NULL;
                first=pnode;
            }
            else
            {
                pnode->prev=p->prev;
                p->prev->next=pnode;
                pnode->next=p;
                p->prev=pnode;
            }
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
    if(first==NULL)
    {
        pnode->prev=pnode->next=NULL;
        first=last=pnode;
    }
    else
    {
        pnode->prev=NULL;
        pnode->next=first;
        first->prev=pnode;
        first=pnode;
    }
}

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
    pnode->next=NULL;
    last->next=pnode;
    last=pnode;
}
void delete_node(int k)
{
    struct node *p;
    p=first;
    while(p!=NULL)
    {
        if(p->data==k)
            break;
        p=p->next;
    }
    if(p==NULL)
        printf("Required node not found.");
    else
    {
        if(p==first&&p==last)  //deleting the one and only node
            first=last=NULL;
        else if(p==first)      //deleting the first node
        {
            first=p->next;
            first->prev=NULL;
        }
        else if(p==last)       //deleting the last node
        {
            last=p->prev;
            last->next=NULL;
        }
        else                      //deleting any other node
            {
                p->prev->next=p->next;
                p->next->prev=p->prev;
            }
        free(p);
    }
}
void traverse()
{
    struct node *p;
    p=first;

    if(first==NULL)
        printf("Doubly linked list is empty\n");
    else
    {
        printf("Doubly linked list is as shown : ");
        while(p!=NULL)
        {
            printf(" %d ",p->data);
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
        printf("7. Traverse\n");
        printf("8. Exit\n");

        printf("Enter your choice : ");
        scanf("%d",&ch);

        switch(ch)
        {
        case 1 :
            create();
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
        case 7 :
            traverse();
            break;
        case 8 :
            break;
        }
    }
    while(ch!=8);
}
