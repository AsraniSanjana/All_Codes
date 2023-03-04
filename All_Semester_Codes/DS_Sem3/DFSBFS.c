
#include<stdio.h>


/*
//BFS ->
Breadth-First Traversal is also known as Level Order Traversal.
Create a matrix of size n*n where every element is 0 representing there is no edge in the graph.
Now, for every edge of the graph between the vertices i and j set mat[i][j] = 1.
After the adjacency matrix has been created and filled, find the BFS traversal of the graph .

THEORY : Breadth-first search is an algorithm for traversing or searching tree or graph data structures.
It starts at the tree root and explores all of the neighbor nodes at the present depth prior to moving on to the nodes at the next depth level.

In breadth-first search, the neighbour nodes are traversed first before the child nodes.
BFS uses queue to traverse nodes or vertex of a graph or tree.

BFS first pushes all neighbor nodes of the current depth into the queue and then visits them by following the FIFO (First In First Out) pattern.

While visiting a node, BFS simultaneously adds its unvisited neighbors to the queue.

Since the queue follows the FIFO pattern, the vertex at the highest level is popped and visited first.

More is the depth of the nodes later it will be processed by the queue, hence implementing breadth-first search traversal.
The algorithm for breadth-first search traversal is:

Select the root of the graph.
Insert the root vertex into the queue.
Pop a vertex from the queue, mark it as visited, and output its value.
Visit its unvisited neighbor vertex, push them to the queue, and mark visited.
Repeat step 3 until the queue is empty.
When the queue is empty, end the program.
The adjacency matrix is a 2D array that maps the connections between each vertex.

if adjancyM[2][3] = 1, means vertex 2 and 3 are connected otherwise not.


for eg : adjacency matrix :

V/V | 0 1 2 3
................
0   | 0 1 1 0
1   | 1 0 0 1
2   | 1 0 0 0
3   | 0 1 0 0
*/


int q[20],top=-1,front=-1,rear=-1,a[20][20],vis[20],stack[20];
int delete();
void add(int item);
void bfs(int s,int n);
void dfs(int s,int n);
void push(int item);
int pop();

void main()
{
int n,i,s,ch,j;
char c,dummy;
printf("ENTER THE NUMBER VERTICES : ");
scanf("%d",&n);
for(i=1;i<=n;i++)
{
for(j=1;j<=n;j++)
{
printf("ENTER 1 IF %d HAS A NODE WITH %d ELSE 0 : ",i,j);
scanf("%d",&a[i][j]);
}
}
printf("THE ADJACENCY MATRIX IS : \n");
for(i=1;i<=n;i++)
{
for(j=1;j<=n;j++)
{
printf(" %d",a[i][j]);
}
printf("\n");
}

do
{
for(i=1;i<=n;i++)
vis[i]=0;
printf("\nMENU");
printf("\n1.B.F.S");
printf("\n2.D.F.S");
printf("\nENTER YOUR CHOICE : ");
scanf("%d",&ch);
printf("\nENTER THE SOURCE VERTEX :");
scanf("%d",&s);

switch(ch)
{
case 1:bfs(s,n);
break;
case 2:
dfs(s,n);
break;
}
printf("\nDO U WANT TO CONTINUE(Y/N) ? ");
scanf("%c",&dummy);
scanf("%c",&c);
}while((c=='y')||(c=='Y'));
}



void bfs(int s,int n)
{
int p,i;
add(s);
vis[s]=1;
p=delete();
if(p!=0)
printf(" %d",p);
while(p!=0)
{
for(i=1;i<=n;i++)
if((a[p][i]!=0)&&(vis[i]==0))
{
add(i);
vis[i]=1;
}
p=delete();
if(p!=0)
printf(" %d ",p);
}
for(i=1;i<=n;i++)
if(vis[i]==0)
bfs(i,n);
}


void add(int item)
{
if(rear==19)
printf("QUEUE FULL");
else
{
if(rear==-1)
{
q[++rear]=item;
front++;
}
else
q[++rear]=item;
}
}
int delete()
{
int k;
if((front>rear)||(front==-1))
return(0);
else
{
k=q[front++];
return(k);
}
}


//***************DFS(depth-first search) code******************//
void dfs(int s,int n)
{
int i,k;
push(s);
vis[s]=1;
k=pop();
if(k!=0)
printf(" %d ",k);
while(k!=0)
{
for(i=1;i<=n;i++)
if((a[k][i]!=0)&&(vis[i]==0))
{
push(i);
vis[i]=1;
}
k=pop();
if(k!=0)
printf(" %d ",k);
}
for(i=1;i<=n;i++)
if(vis[i]==0)
dfs(i,n);
}
void push(int item)
{
if(top==19)
printf("Stack overflow ");
else
stack[++top]=item;
}
int pop()
{
int k;
if(top==-1)
return(0);
else
{
k=stack[top--];
return(k);
}
}
