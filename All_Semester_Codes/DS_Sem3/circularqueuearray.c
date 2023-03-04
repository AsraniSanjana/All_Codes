#include<stdio.h>
 #define QUEUESIZE 5
// implementing circular queue ADT using arrays
 struct queue
 {int front,rear;
 int items[QUEUESIZE];  // Queue of all integer integers
int count;             // count is like the index of array
 };

 void insert(struct queue *pq,int x)
 {

     if(pq->count==QUEUESIZE)
     {
         printf("Queue overflow,cannot insert the element\n");
        return;
     }
     (pq->count)++;
     if(pq->rear==QUEUESIZE-1)
        pq->rear=0;
     else
     (pq->rear)++;

        pq->items[pq->rear]=x;

 }

     int removes(struct queue *pq)
     {
 int t;
         if(empty(pq))
         {
             printf("queue underflow,cannot remove the element\n");
             return;
         }

    t= pq->items[pq->front];
    (pq->count)--;
    if(pq->front==QUEUESIZE-1)
        pq->front=0;
    else
        (pq->front)++;
    return t;

 }
int empty(struct queue *pq) // function that checks if the queue is empty or not
{

if(pq->count==0)
    return 1;
else
    return 0;
}

void show(struct queue q) // function to print all the elments of the queue from left to right i.e. from front end to rear end
{   int i;
    printf("queue from the frontmost element is as shown \n");

 if(q.count!=0)

 {  if(q.front<=q.rear)
    {

      for(i=q.front;i<=q.rear;i++)
    printf("%d\t",q.items[i]);

    }
   else //if(pq->front>pq->rear)
    {
          for(i=q.front;i<=QUEUESIZE-1;i++)
    printf("%d",q.items[i]);
    for(i=0;i<=q.rear;i++)
    printf("%d",q.items[i]);
    }
}
}
int main()
{
     int x , ch;

 struct queue q;
     q.rear = -1;
     q.front= 0;
     q.count= 0;

     do
     {   // making operations menu driven
         printf("\n MENU:\n");
         printf(" 1:INSERT:\n");
         printf(" 2:REMOVE:\n");
         printf(" 3:EXIT\n");
         printf(" ENTER YOUR CHOICE:");
         scanf("%d",&ch);
          switch(ch)
          {
           case 1:
            printf("Enter an element to be inserted:");
            scanf("%d",&x);
            insert(&q,x);
            show(q);  // printing all the elements after the insertion
            break;

            case 2:
                x=removes(&q);
                printf("Element removed is :%d\n",x);
                show(q);   // printing all the elements after the deletion
                break;

            case 3:
                break;
                }
     }  while(ch!=3);
     return 0;
}



