//  implement doubly linked list

#include<stdio.h>
#include<stdlib.h>
#define NULL 0
struct node
{
    int data;
    struct node *next,*prev;
};

struct node *first = NULL;
struct node *last = NULL;

void create()
{
    int i,n;
    struct node *pnode,*prev;

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
        //pnode->next = NULL;
    }
      for(i=1; i<=n; i++)
    {
    first=pnode;
        if(first==NULL)
           {
            pnode->prev=prev->next=NULL;  }
        else
        {
            last->next = pnode;
            pnode->prev=last;
            pnode->next=NULL;
            last = pnode;
        }
    }
}

void insert_after(int x, int k)   //This function will insert a node with value x after a node having value k
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
                last->next=pnode;
                pnode->prev=last;
                pnode->next=NULL;
                last=pnode;
            }
         else{
            pnode->next=p->next;
            p->next->prev=pnode;
            p->next=pnode;
            pnode->prev=p;

         }
        }
}

void insert_before(int x, int k)
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
             if (p==first)
             {
                 pnode->next=p;
                 p->prev=pnode;
                 first=pnode;
                 first->prev=NULL;

        }
        else
        {
            p->prev->next=pnode;
            pnode->prev=p->prev;
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

    void traverse_left()
      {
          struct node *p;
          if(last==NULL)
            printf("linked list empty\n");
          else
          {
              printf("LL is as shown:");
              p=last;
              while(p!=NULL)
              {
                  printf("%d",p->data);
                  p=p->prev;
             }
          }
      }

      void deletenode(int k)
      {
          struct node *p;
          p=first;
          while(p!=NULL)
          {
              if (p->data==k)

           break;
           p=p->next;

          }
          if(p==NULL)
            printf("required node not found\n");
          else

          {
              if(p==first && p==last)
            first=last=NULL;
            else if (p==first)

{
    first=p->next;
    first->prev=NULL;

}
else if (p==last)
{
    last=p->next;
    last->next=NULL;

}
else {
    p->prev->next=p->next;
    p->next->prev=p->prev;

}   free(p);
}
}
 void delete_beginning()
{

          struct node *p;
          p=first;
          if(p==NULL)
            printf("required node not found\n");
        else  if (p==first)

{
    first=p->next;
    first->prev=NULL;

}
 printf("node deleted from begining is %d:",p->data);
free(p);
}
void delete_end()
{

}
void delete_before(int k)
{

}
 void delete_after(int k)
{

}


void main()
{
    int x, k, ch;
    do
    {
        printf("\n Menu : \n");
        printf("1. Create a  doubly Linked list.\n");
        printf("2. insert a node before node of data value k\n");
        printf("3. insert a node after node of data value k\n");
        printf("4. insert a node in the beginning\n");
        printf("5. insert a node in the end\n");
        printf("6. delete a node\n");
        printf("7. delete a node before node of data value k\n");
        printf("8. delete a node after node of data value k\n");
        printf("9. delete a node in the begining\n");
        printf("10. delete a node at the end \n");
        printf("11. traverse the list leftwards \n");
        printf("12.exit\n");
        printf("Enter your choice : ");
        scanf("%d",&ch);

        switch(ch)
        {
        case 1 :
            create();
            traverse_left();
            break;

        case 2:
            printf("Enter the value of the new node\n");
            scanf("%d",&x);
            printf("Enter the data value before which the new node is to be inserted :");
            scanf("%d",&k);
            insert_before(x,k);
            printf("updated ");
            traverse_left();
            break;
        case 3 :
            printf("Enter the value of the new node\n");
            scanf("%d",&x);
            printf("Enter the data value after which the new node is to be inserted :");
            scanf("%d",&k);
            insert_after(x,k);
            printf("updated ");
            traverse_left();
            break;

        case 4:
            printf("enter the data value of the node to be inserted in the beginning:");
            scanf("%d",&k);
            insert_Beginning(k);
            printf("updated ");
            traverse_left();
            break;
              case 5:
            printf("enter the data value of the node to be inserted at the end:");
            scanf("%d",&k);
            insert_end(k);
            printf("updated ");
            traverse_left();
            break;
        case 6 :
         printf("Enter the value of the node to be deleted\n");
            scanf("%d",&k);
            deletenode(k);
            printf("updated ");
            traverse_left();
            break;

        case 7:

            printf("delete a node before node of data value");
            scanf("%d",&k);
            delete_before(k);
            printf("updated ");
            traverse_left();
            break;
        case 8:
            printf("delete a node after node of data value");
            scanf("%d",&k);
            delete_after(k);
            printf("updated ");
            traverse_left();
            break;
        case 9:
            delete_beginning();
            printf("updated ");
            traverse_left();
            break;

            case 10:
                delete_end();
                printf("updated ");
            traverse_left;
            break;

            case 11:

                traverse_left();





            case 12:  break;
       } } while(ch!=12);
    }


