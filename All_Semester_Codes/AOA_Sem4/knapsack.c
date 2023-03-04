
#include<stdio.h>
void fractional_knapsack()
{
void knapsack(int n, float weight[], float profit[], float capacity) {
 float x[20], tp = 0;
 int i, j, u;
 u = capacity;
 for (i = 0; i < n; i++)
 x[i] = 0.0;
 for (i = 0; i < n; i++) {
 if (weight[i] > u)
 break;
 else {
 x[i] = 1.0;
 tp = tp + profit[i];
 u = u - weight[i];
 }
 }
 if (i < n)
 x[i] = u / weight[i];
 tp = tp + (x[i] * profit[i]);
 printf("\nThe result vector is:- ");
 for (i = 0; i < n; i++)
 printf("%f\t", x[i]);
 printf("\nMaximum profit is:- %f", tp);
}
 float weight[20], profit[20], capacity;
 int num, i, j;
 float ratio[20], temp;
 printf("\nEnter the number of objects:- ");
 scanf("%d", &num);
 printf("\nEnter the weights and profits of each object:- \n");
 for (i = 0; i < num; i++) {
 scanf("%f %f", &weight[i], &profit[i]);
 }
 printf("\nEnter the capacity of knapsack:- ");
 scanf("%f", &capacity);
 for (i = 0; i < num; i++) {
 ratio[i] = profit[i] / weight[i];
 }
 for (i = 0; i < num; i++) {
 for (j = i + 1; j < num; j++) {
 if (ratio[i] < ratio[j]) {
 temp = ratio[j];
 ratio[j] = ratio[i];
 ratio[i] = temp;
 temp = weight[j];
 weight[j] = weight[i];
 weight[i] = temp;
 temp = profit[j];
 profit[j] = profit[i];
 profit[i] = temp;
 }
 }
 }
 knapsack(num, weight, profit, capacity);
}
void binary_knapsack()
{
 int max(int a, int b) { return (a > b)? a : b; }
int knapSack(int W, int wt[], int val[], int n)
{
 int i, w;
 int K[n+1][W+1];
 for (i = 0; i <= n; i++)
 {
 for (w = 0; w <= W; w++)
 {
 if (i==0 || w==0)
 K[i][w] = 0;
 else if (wt[i-1] <= w)
 K[i][w] = max(val[i-1] + K[i-1][w-wt[i-1]], K[i-1][w]);
 else
 K[i][w] = K[i-1][w];
 }
 }
 return K[n][W];
}
 int i, n, val[20], wt[20], W;
 printf("Enter number of items: ");
 scanf("%d", &n);
 printf("Enter value and weight of items:\n");
 for(i = 0;i < n; ++i){
 scanf("%d%d", &val[i], &wt[i]);
 }
 printf("Enter size of knapsack:");
 scanf("%d", &W);
 printf("\n Profit is : %d", knapSack(W, wt, val, n));
}
void main()
{
 printf("01_SANJANA ASRANI_D7B");
 int choice;
do
{
printf("\n\n The variants of knapsack problem are : ");
printf("\n1. Fractional Knapsack.\n");
printf("2. Binary Knapsack.\n");
printf("3. Exit. \n");
printf("Enter your choice : \n");
scanf("%d",&choice);
switch(choice)
{
case 1 :
 fractional_knapsack();
 break;
case 2 :
 binary_knapsack();
 break;
case 3 :
 break;
}
}
while(choice!=3);
}
/*

#include<stdio.h>
int w[10],p[10],v[10][10],n,i,j,cap,x[10]= {0};
int max(int i,int j) {
	return ((i>j)?i:j);
}
int knap(int i,int j) {
	int value;
	if(v[i][j]<0) {
		if(j<w[i])
		   value=knap(i-1,j); else
		   value=max(knap(i-1,j),p[i]+knap(i-1,j-w[i]));
		v[i][j]=value;
	}
	return(v[i][j]);
}
void main() {
	int profit,count=0;
		printf("\nEnter the number of elements\n");
	scanf("%d",&n);
	printf("Enter the profit and weights of the elements\n");
	for (i=1;i<=n;i++) {
		printf("For item no %d\n",i);
		scanf("%d%d",&p[i],&w[i]);
	}
	printf("\nEnter the capacity \n");
	scanf("%d",&cap);
	for (i=0;i<=n;i++)
	  for (j=0;j<=cap;j++)
	   if((i==0)||(j==0))
	    v[i][j]=0; else
	    v[i][j]=-1;
	profit=knap(n,cap);
	i=n;
	j=cap;
	while(j!=0&&i!=0) {
		if(v[i][j]!=v[i-1][j]) {
			x[i]=1;
			j=j-w[i];
			i--;
		} else
		   i--;
	}
	printf("Items included are\n");
	printf("Sl.no\tweight\tprofit\n");
	for (i=1;i<=n;i++)
	  if(x[i])
	   printf("%d\t%d\t%d\n",++count,w[i],p[i]);
	printf("Total profit = %d\n",profit);

}



*/
