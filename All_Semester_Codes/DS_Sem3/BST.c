#include<stdio.h>
#include<stdlib.h>

#define NULL 0


struct node{

int data;

struct node *left,*right;
//struct node *p,*root;
};

int ncount=0;
int lcount=0;
struct node *root=NULL;
void create()
{
int x,i,n;
printf("enter number of nodes required:");
scanf("%d",&n);

printf("\nenter data value of each node:");
for(i=1;i<=n;i++)
    {scanf("%d",&x);
insert(x); }
}
void insert(int x){
struct node *pnode,*p,*follow;
pnode=(struct node*)malloc(sizeof (struct node));
if(pnode==NULL)
    {
        printf("memory overflow. unable to create.");
        return;

    }
    pnode->data=x;
    pnode->left=pnode->right=NULL;
    if(root==NULL)
        root=pnode;
    else{
        //searching for the place of insertion
        p=root;
        follow=NULL;
        while(p!=NULL)
        {
            follow=p;
            if(pnode->data< p->data)
                p=p->left;
            else
                p=p->right;
        }
        // actual insertion
        if(pnode->data<follow ->data)
            follow->left=pnode;
        else
            follow->right=pnode;

        }
    }

void inorder(struct node *root)

{

    if(root!=NULL)
 {
     inorder(root->left);
      printf("%d", root->data);
       inorder(root->right);
 }
}

void postorder(struct node *root) {

if(root!=NULL)
    {
        postorder(root->left);
postorder(root->right);
 printf("%d", root->data) ; }
  }
void preorder(struct node *p)
{

    if(root!=NULL)
    {
        printf("%d",root->data);
        preorder(root->left);
        preorder(root->right);

    }
}
void deletenode(int k)
{
    struct node *p,*follow,*t,*f;
    // searching the node to be deleted
    p=root;
    follow=NULL;
    while(p!=NULL)
    {
         if (p->data==k)
            break;
         follow=p;
         if(k<p->data)
p=p->left;
else p=p->right;

    }
    if(p==NULL)
        printf("required node not found.");
    else{
        // actual deletion
        if(p->left==NULL)
            if(p!=root)
            if(follow->left==p)
            follow->left=p->right;
        else
        follow ->right=p->right;
        else
        root=p->right;
        else if(p->right==NULL)
        if(p!=root)
            if(follow->left==p)
            follow->left=p->left;
        else
            follow->right=p->left;
        else
            root=p->left;

        else {
            // finding the inorder successor of p: finding the smallest node in right subtree of node to be deleted
            t=p->right;
            f=p;
            while(t->left!=NULL)
            {
                f=t;
                t=t->left;
                }
                // at this stage, t is the inorder successor of p and f is the father of t
                p->data=t->data;
                if(f!=p)
                    f->left=t->right;
                else
                    f->right=t->right;
                p=t;
        }
        free(p);
            }
}
void search(int k)

{ struct node *p;

/* Searching the required node */
 p=root ;
  while(p->data!=k && p!=NULL)


{

if(k<p->data)



p=p->left;

else

p=p->right;
}

if(p==NULL){
printf("Required node not Found. \n"); }
else
    printf("Node found at address %x. \n",p);
     }


/* This function will find level of a node with value k */
void levelnode(int k)
{
    int level=0; struct node *p;

/* Finding level of the node */

p=root;
 while(p->data!=k && p!=NULL)
  {
      level++;
if(k<p->data)

p=p->left;
 else
    p=p->right;
  }
if(p==NULL)

printf("Required node not found. \n");
 else

printf("Required node found at level %d. \n",level);
}

/* This function will count the total no. of nodes in the BST */
void nodecount(struct node *root)
{


if(root!=NULL)
    {
        nodecount(root->left);
        ++ncount;
nodecount(root->right);

    }}
/* This function will count the total no. of leaf nodes in the BST. Moreover, it will also display data value of leaf nodes. */ void leafnodecount(struct node *root)

void leafnodecount(struct node *root){

    if (root!=NULL)
        {
 leafnodecount(root->left);

if(root->left==NULL && root->right==NULL)
{

   ++lcount;

   printf("%d ",root->data);
 }
  leafnodecount(root->right);
  }
}

void findsmallest(struct node *root)
 {
     struct node *p;
 if(root==NULL)
     printf("Tree is empty. \n");
 else {
        p=root ;
 while(p->left!=NULL)
 p=p->left;
 printf("Smallest node's data is %d.\n",p->data);
 }
 }


void findlargest(struct node *root) {



struct node *p;

if(root==NULL)

printf("Tree is empty. \n");
else {
        p=root ;
while(p->right!=NULL)
    p=p->right;

printf("Largest node's data is %d.\n",p->data);
}
}


/*
 struct node * mirror(struct node *root)
{

struct node *pnode ;

if(root==NULL) return NULL;


pnode=(struct node*)malloc(sizeof(struct node)); pnode->data=root->data ;

pnode->left=mirror(root->right); prode->right=mirror(root->left)

return pnode ;
 }

*/



void main()
{

int x, k, ch;

do

{
printf("1.Create. \n");
printf("2.Insert a node in the bst\n");
printf("3.Preorder traversal \n");
printf("4.Inorder traversal \n");
printf("5.Postorder. \n");
printf("6.Delete a node from the bst\n");
printf("7.Search a node in the bst.\n");
printf("8.find level of a node in bst.\n");
printf("9.count number of nodes in th bst. \n");
printf("10.count number of leaf nodes in the bst. \n");
printf("11.Find smallest node in the node\n");
printf("12.Find Largest node in the node\n");
printf("13.find the height of the tree.\n");
printf("14.find the mirror image of the bst.\n");

printf("15.exit\n");

printf("Enter your choice: ");
scanf("%d",&ch);
switch(ch) {
     case 1: create();


              break;

case 2:
     printf("Enter the data value of new node: ");
      scanf("%d",&x);
       insert(x);
     break;

case 3:
     preorder(root); printf("\n");

break;

case 4:

inorder(root);
 printf("\n");
break;

case 5:
    postorder(root);
     printf("\n");
 break;

case 6:
    printf("Enter data of the node to be deleted: ");
 scanf("%d",&k);
deletenode(k);
 break;

case 7:
    printf("Enter data of the node to be searched: ");
     scanf("%d",&k);
      search(k);
       break;

case 8: printf("Enter data of the node whose level is to be found: ");
 scanf("%d",&k);
  levelnode(k);
   break;

case 9:

 nodecount(root);
  printf("No. of nodes present in the tree are %d \n",ncount);
  break;

case 10:

leafnodecount(root);
 printf("No. of Leaf nodes present in the tree are %d \n",Icount);
  break;

case 11:
     findsmallest(root);
 break;

case 12:
     findlargest(root);
      break;

case 13: /*height of the tree*/
break;

    case 14: /*mirror image of the tree*/
        break;
      case 15: break;
}}while(ch!= 15);

getch();

}
