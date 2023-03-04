 #include<stdio.h>
 #define QUEUESIZE 5

// implementing queue ADT using arrays , without structures
 int front,rear;
 int items[QUEUESIZE];  // Queue of all integer integers

void insert(int x)
 {

     if(rear==QUEUESIZE-1)
     {
         printf("Queue overflow,cannot insert the element\n");
        exit(1); // terminates the program
     } items[++rear]=x;
 }


int removes()
     {

         if(empty())
         {
             printf("queue underflow,cannot remove the element\n");
             exit(1);
         }

     return (items[front++]);
 }

int empty() // function that checks if the queue is empty or not
{

if(rear<front)
    return 1;
else
    return 0;
}
void show() // function to print all the elments of the queue from left to right i.e. from front end to rear end
{   int i;
    printf("queue from the frontmost element is as shown \n");
    for(i=front;i<=rear;i++)
    printf("%d\t",items[i]);

}
int main()
{
     int x , ch;
     rear= -1;
     front =0;
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
            insert(x);
            show();  // printing all the elements after the insertion
            break;

            case 2:
                x=removes();
                printf("Element removed is :%d\n",x);
                show();   // printing all the elements after the deletion
                break;

            case 3:
                break;
                }
     }  while(ch!=3);
     return 0;
}








