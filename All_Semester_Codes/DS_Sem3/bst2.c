#include<stdio.h>
#include<malloc.h>
struct BSTnode
{
 int data;
 struct BSTnode *left;
 struct BSTnode *right;
};
struct BSTnode *tree;
void create(struct BSTnode *);
struct BSTnode *insert_node(struct BSTnode *,int);
void pre_trav(struct BSTnode *);
void in_trav(struct BSTnode *);
void post_trav(struct BSTnode *);
int height(struct BSTnode *);
struct BSTnode *largest(struct BSTnode *);
struct BSTnode *smallest(struct BSTnode *);
int count_tot(struct BSTnode *);
int count_int(struct BSTnode *);
int count_ext(struct BSTnode *);
void mirrorimg(struct BSTnode *);
struct BSTnode *delete_node(struct BSTnode *,int);
struct BSTnode *search(struct BSTnode *,int);
int main()
{
 int c,x,y;
 struct BSTnode *p;
 create(tree);
 printf("OPERATIONS ON BINARY SEARCH TREE(BST)\n");
 printf("1 - Insert a new node\n");
 printf("2 - Preorder traversal\n");
 printf("3 - Inorder traversal\n");
 printf("4 - Postorder traversal\n");
 printf("5 - Determine the height of BST\n");
 printf("6 - Find the largest node\n");
 printf("7 - Find the smallest node\n");
 printf("8 - Find the total number of nodes\n");
 printf("9 - Find the total number of internal nodes\n");
 printf("10 - Find the total number of external nodes\n");
printf("11 - Find the mirror image of the BST\n");
 printf("12 - Delete a node\n");
 printf("13 - Search a node\n");
 printf("14 - END\n");
 while(c != 14)
 {
 printf("\nWhich operation? = ");
 scanf("%d",&c);
 switch(c)
 {
 case 1:
 tree = insert_node(tree,x);
 break;
 case 2:
 if(tree == NULL)
 {
 printf("BST is empty\n");
 break;
 }
 printf("Preorder Traversal\n");
 pre_trav(tree);
 printf("\n");
 break;
 case 3:
 if(tree == NULL)
 {
 printf("BST is empty\n");
 break;
 }
 printf("Inorder Traversal\n");
 in_trav(tree);
 printf("\n");
 break;
 case 4:
 if(tree == NULL)
 {
 printf("BST is empty\n");
 break;
 }
 printf("Postorder Traversal\n");
 post_trav(tree);
printf("\n");
 break;
 case 5:
 height(tree);
 printf("Height of the BST = %d\n",height(tree));
 break;
 case 6:
 p = largest(tree);
 printf("Largest node = %d\n",p -> data);
 break;
 case 7:
 p = smallest(tree);
 printf("Smallest node = %d\n",p -> data);
 break;
 case 8:
 count_tot(tree);
 printf("Total number of nodes = %d\n",count_tot(tree));
 break;
 case 9:
 count_int(tree);
 printf("Total number of internal nodes = %d\n",count_int(tree));
 break;
 case 10:
 count_ext(tree);
 printf("Total number of external nodes = %d\n",count_ext(tree));
 break;
 case 11:
 mirrorimg(tree);
 printf("Mirror Image of the BST\n");
 printf("\t|\n");
 printf("\tV");
 break;
 case 12:
 printf("Enter the node to be deleted = ");
 scanf("%d",&y);
 tree = delete_node(tree,y);
 break;
 case 13:
 printf("Enter the value of a node in the BST to search = ");
 scanf("%d",&y);
 //tree = search(tree,y);
 printf("%d is present in the binary tree.",search(tree,y));
break;
 case 14:
 exit(0);
 default:
 printf("Invalid case.Please enter a valid case\n");
 break;
 }
 }
 return 0;
}
void create(struct BSTnode *tree)
{
 tree = NULL;
}
struct BSTnode *insert_node(struct BSTnode *tree,int x)
{
 struct BSTnode *p,*p1,*p2;
 printf("Enter a value for the new node = ");
 scanf("%d",&x);
 p = malloc(sizeof(struct BSTnode));
 p -> data = x;
 p -> left = NULL;
 p -> right = NULL;
 if(tree == NULL)
 {
 tree = p;
 tree -> left = NULL;
 tree -> right = NULL;
 }
 else
 {
 p1 = NULL;
 p2 = tree;
 while(p2 != NULL)
 {
 p1 = p2;
 if(x < p2 -> data)
 {
 p2 = p2 -> left;
 }
else
 {
 p2 = p2 -> right;
 }
 }
 if(x < p1 -> data)
 {
 p1 -> left = p;
 }
 else
 {
 p1 -> right = p;
 }
 }
 return tree;
}
void pre_trav(struct BSTnode *tree)
{
 if(tree != NULL)
 {
 printf("%5d",tree -> data);
 pre_trav(tree -> left);
 pre_trav(tree -> right);
 }
}
void in_trav(struct BSTnode *tree)
{
 if(tree != NULL)
 {
 in_trav(tree -> left);
 printf("%5d",tree -> data);
 in_trav(tree -> right);
 }
}
void post_trav(struct BSTnode *tree)
{
 if(tree != NULL)
 {
 post_trav(tree -> left);
 post_trav(tree -> right);
 printf("%5d",tree -> data);
 }
}
int height(struct BSTnode *tree)
{
 int lheight,rheight;
 if(tree == NULL)
 {
 return 0;
 }
 else
 {
 lheight = height(tree -> left);
 rheight = height(tree -> right);
 if(lheight > rheight)
 {
 return (lheight + 1);
 }
 else
 {
 return (rheight + 1);
 }
 }
}
struct BSTnode *largest(struct BSTnode *tree)
{
 if((tree == NULL) || (tree -> right == NULL))
 {
 return tree;
 }
 else
 {
 return largest(tree -> right);
 }
}
struct BSTnode *smallest(struct BSTnode *tree)
{
 if((tree == NULL) || (tree -> left == NULL))
 {
 return tree;
 }
 else
 {
 return smallest(tree -> left);
 }
}
int count_tot(struct BSTnode *tree)
{
 if(tree == NULL)
 {
 return 0;
 }
 else
 {
 return (count_tot(tree -> left) + count_tot(tree -> right) + 1);
 }
}
int count_int(struct BSTnode *tree)
{
 if(tree == NULL)
 {
 return 0;
 }
 if((tree -> left == NULL) && (tree -> right == NULL))
 {
 return 0;
 }
 else
 {
 return (count_int(tree -> left) + count_int(tree -> right) + 1);
 }
}
int count_ext(struct BSTnode *tree)
{
 if(tree == NULL)
 {
 return 0;
 }
 else if((tree -> left == NULL) && (tree -> right == NULL))
 {
 return 1;
 }
 else
 {
 return (count_ext(tree -> left) + count_ext(tree -> right));
 }
}
void mirrorimg(struct BSTnode *tree)
{
 struct BSTnode *p;
 if(tree != NULL)
 {
 mirrorimg(tree -> left);
 mirrorimg(tree -> right);
 p = tree -> left;
 tree -> left = tree -> right;
 tree -> right = p;
 }
}
struct BSTnode *delete_node(struct BSTnode *tree,int y)
{
 struct BSTnode *p;
 if(tree == NULL)
 {
 printf("%d not found in the BST.Tree is empty.\n",y);
 }
 else if(y < tree -> data)
 {
 tree -> left = delete_node(tree -> left,y);
 }
 else if(y > tree -> data)
 {
 tree -> right = delete_node(tree -> right,y);
 }
 else
 {
 if((tree -> left) && (tree -> right))
 {
 p = largest(tree -> left);
 tree -> data = p -> data;
 tree -> left = delete_node(tree -> left,tree -> data);
 }
 else
 {
 p = tree;
 if(tree -> left == NULL)
 {
 tree = tree -> right;
 }
 if(tree -> right == NULL)
 {
 tree = tree -> left;
 }
 free(p);
 }
 }
 return tree;
}
struct BSTnode *search(struct BSTnode *tree,int y)
{
 if(tree -> data == y || tree == NULL)
 {
 printf("%d is present in the BST\n",y);
 }
 else
 {
 if(y < tree -> data)
 {
 return search(tree -> left,y);
 }
 else if(y > tree -> data)
 {
 return search(tree -> right,y);
 }
 }
}
