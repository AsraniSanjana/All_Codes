#include<stdio.h>
#include<stdlib.h>
#define NULL 0
// show the linked list after each insertion or deletion.
// delete a node from certain position. i.e. data value ki zarurat ni h

// 4 insert operations: insert_after,insert_before,insert_Beginning,insert_end
// 4 delete operations: delete_after,delete_before,delete_Beginning,delete_end, delete a node with data value k
struct node
{
    int data;
    struct node *next;
};

struct node *first = NULL;

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
            first = p = pnode;
        else
        {
            p->next = pnode;
            p = pnode;
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
            pnode->next = p->next;
            p->next = pnode;
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
                first = pnode;
            }
            else
            {
                pnode->next = p;
                follow->next=pnode;
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
    pnode->next=first;
    first=pnode;
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
    p= first;
    follow=NULL;
    while(p->next!=NULL)
    {
        follow=p;
        p=p->next;
    }

    pnode->next=NULL;
    p->next=pnode;
}


// delete beginning works
void delete_beginning()
{struct node *pnode, *p;
p=pnode=first;
int x;
if(pnode==NULL)
{
    printf("linked list is empty, cant delete\n");

}
     else
     {  x=p->data;
         first=p->next;  // first will start pointing to p ka next
         p=p->next;
         free(pnode);
         printf("node deleted from beginning is %d \n",x);
     }
}

void delete_end()
{
struct node *p,*pnode,*follow;
p=first;
follow=NULL;
while(p->next!=NULL)
{
  follow=p;
  p=p->next;
}
    follow->next=NULL;
    free(p);
}

 void delete_after(int k)
 {      struct node *first, *p, *follow;
     p=first;
     follow=NULL;
    // printf("so u want to delete the node no. %d\n",k+1);

    while(p!=NULL && p->data!=k)
    {


        follow = p;
        p=p->next;
         printf("so u want to delete the node no. %d\n",k+1);
    }  printf("so u want to delete the node no. %d\n",k+1);
    if(p==NULL)
{
printf("Required node is not found\n");

}
else{
follow=p;
p=p->next;

    follow->next=p->next;
    printf("node deleted after no. %d node is %d",k,p->data);
    free(p);
    }
    }

    // delete_before works but theres a mistake
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




/*
void delete_after(int k)
{
struct node *p,*pnode,*follow;
p=first;
follow=NULL;
while(p!=NULL&&follow->next->data!=k)
{
  follow=p;
  p=p->next;
}
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

void delete_end()
{
struct node *p,*pnode,*follow;
p=first;
follow=NULL;
while(p->next!=NULL);
{
  follow=p;
  p=p->next;
}
    follow->next=NULL;
    free(p);
}
*/







void deleteanode(int k)  // here k is the data value of the node to be deleted
{                        // but we are passing position in the function call

    struct node *pnode, *p, *follow;
    p=first;
    follow=NULL;
    while(p!=NULL)
    {
        if(p->data==k)
            break;
        follow=p;
        p=p->next;
    }
    if(p==NULL)
   printf("Required node not found.");
    else
    {
        if(p==first)
            first=p->next;
        else
            follow->next = p->next;
        free(p);
    }
}

int search(int k)
{ int counter=0;
    struct node *p;
    p=first;
    while(p!=NULL)
    {
        if(p->data==k)
          {  counter ++; break;}
       else { counter++;
            p=p->next;
         }
    }
    if(p==NULL)
       {

        printf("Required node not found\n"); return;}

        return counter;
        //  printf("%d is node number: ",k,counter);

        //return counter;
      // printf("Required node is present at address = %x\n",p);

}

void traverse()
{
    struct node *p;
    p=first;
    if(first==NULL)
        printf("Linked list is empty\n");
    else
    {
        printf("Linked list is as shown :");
        while(p!=NULL)
        {
            printf(" %d ",p->data);
            p=p->next;
        }
    }
}

void count()
{
    struct node *p;
    p=first;
    int c=0;
    while(p!=NULL)
    {
        c++;
        p=p->next;
    }
    printf("Number of nodes in linked list = %d \n", c);
}

void reverse()
{
    struct node *p, *follow, *ahead;
    p=first;
    follow=ahead=NULL;
    while(p!=NULL)
    {
        ahead=p->next;
        p->next=follow;
        follow=p;
        p=ahead;
    }
    first=follow;
}

/*
void reverseLL(struct node *first)   // recursive function will hold the output until function calls are ended
{  struct *p;
  p=first;
    if(first==NULL)
    return;

    reverseLL(first->next);  // print karne se pehle call karhe isiliye print hoga nahi
    printf("%d",first->data);
}
*/
void destroy_list()
{
    struct node *p, *temp;
    p=first;
    while(p!=NULL)
    {
        temp=p;
        p=p->next;
        free(temp);
    }
    first=NULL;
}

void sortListAscend() // arrange the data values in ascending order
 {
        //Node current will point to head
        struct node *current = first, *index = NULL;
        int temp;

        if(first == NULL) {
            return;
        }
        else {
            while(current != NULL) {
                //Node index will point to node next to current
                index = current->next;

                while(index != NULL) {
                    //If current node's data is greater than index's node data, swap the data between them
                    if(current->data > index->data) {
                        temp = current->data;
                        current->data = index->data;
                        index->data = temp;
                    }
                    index = index->next;
                }
                current = current->next;
            }
        }
    } // i want to store the sequence of void sort into an array so that i can call reverse the linked list to print
      // the descending order too without creating a separate function

void sortListDescend() // arrange the data values in descending order
 {
        //Node current will point to head
        struct node *current = first, *index = NULL;
        int temp;

        if(first == NULL) {
            return;
        }
        else {
            while(current != NULL) {
                //Node index will point to node next to current
                index = current->next;

                while(index != NULL) {
                    //If current node's data is greater than index's node data, swap the data between them
                    if(current->data < index->data) {
                        temp = current->data;
                        current->data = index->data;
                        index->data = temp;
                    }
                    index = index->next;
                }
                current = current->next;
            }
        }
    }






void main()
{
    int x, k, ch;
    do
    {
        printf("\n Menu : \n");
        printf("1. Create a Linked list.\n");
        printf("2. Add a node after a given node\n");
        printf("3. Add a node before a given node\n");
        printf("4. Add a node in the beginning\n");
        printf("5. Add a node at the end\n");
        printf("6. Delete a node of data value k\n");
       /* printf("6. Delete a node from beginning \n");
        printf("6. Delete a node from end\n");
        printf("6. Delete a node after data value k\n");
        printf("6. Delete a node before data value k\n");
        */
        printf("7. Search a node with data value k\n");
        printf("8. Traverse the entire list\n");
        printf("9. Count no. of nodes in the linked list\n");
        printf("10.Reverse the list\n");
        printf("11.delete the entire list\n");
        printf("12.Sort the linked list in ascending order\n");
        printf("13.Sort the linked list in descending order\n");
        printf("14.delete a node from beginning\n");
        printf("15.delete a node from end\n");
        printf("16.delete a node after data value k\n");
        printf("17.delete a node before data value k\n");
        printf("18.exit\n");

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
            printf("updated linked list:\n");
            traverse();
            break;
        case 3 :
            printf("Enter the value of the new node\n");
            scanf("%d",&x);
            printf("Enter the data value before which the new node is to be inserted :");
            scanf("%d",&k);
            insert_before(x,k);
            printf("updated linked list:\n");
            traverse();
            break;

        case 4 :
            printf("Enter the value of the new node\n");
            scanf("%d",&x);
            insert_Beginning(x);
            printf("updated linked list:\n");
            traverse();
            break;
        case 5 :
            printf("Enter the value of the new node\n");
            scanf("%d",&x);
            insert_end(x);
            printf("updated linked list:\n");
            traverse();
            break;

        case 6 :
            printf("Enter the value of the node to be deleted\n");
            scanf("%d",&k);
            deleteanode(k);
            printf("updated linked list:\n");
            traverse();
            break;
        case 7 : traverse();

            printf("\nEnter the value of the node to be searched\n");
            scanf("%d",&k);

            printf("%d is node number: %d",k,search(k));
            break;
        case 8 :
            traverse(); break;
        case 9 : printf(" number of nodes in the linked list: ");
            count();
             break;

        case 10 : printf("linked list before reversing:\n");
             traverse();
             reverse();
           // reverseLL(first);
             printf("linked list after reversing:\n");
             traverse();
             break;
        case 11 :
             destroy_list(); break;
             printf("lets see what happens if we traverse the linked list we destroyed:");
             traverse();
             break;
        case 12 : printf("before sorting:");
        traverse();
           //  first = sort_list(first);

sortListAscend();

printf("\nafter sorting in increasing data value order: ");
             traverse();
              break;


        case 13 :printf("before sorting:");
        traverse();
           //  first = sort_list(first);

sortListDescend();

printf("\nafter sorting in decreasing data value order:");
             traverse();

            break;

  case 14: delete_beginning();
      //deleteanode(1);  k is node no. 1
            traverse();
            break;

  case 15 :
    delete_end();
    //deleteanode(count);  k is count i.e. last node
          printf(" updated linked list:\n");
          traverse();
            break;

            case 16:
                printf("delete the node after node no.:");
                scanf("%d",&k);
                delete_after(k);
               // deleteanode(k+1); k should be node no.
                printf("\n updated linked list:");
                traverse();
                 break;

            case 17: printf("delete the node before:");
            scanf("%d",&k);
            delete_before(k);
            //deleteanode(k-1); k should be node no.
                printf("after deletion:");
                traverse();
                break;
            case 18:
               break;

        }}
    while(ch!=18);

}
}
