// first fit
int main()
{
 int i,j,m,k,l,n,a[50],b[50];
 int flag[50]={0},count[50]={0};
printf("01_D7B_SANJANA ASRANI\n\n");
 printf("Enter the number of processes : ");
 scanf("%d",&m);
 printf("Enter the number of blocks : ");
 scanf("%d",&n);
 for(i=1;i<=m;i++)
 {
 printf("Enter the size of process %d : ",i);
 scanf("%d",&a[i]);
 }
 for(j=1;j<=n;j++)
 {
 printf("Enter the size of block %d : ",j);
 scanf("%d",&b[j]);
 }
 for(k=1;k<=n;k++)
 {
 for(l=1;l<=m;l++)
 {
 if(b[k]>=a[l])
 if(flag[k]==0&&count[l]==0)
 {
 printf("Process %d is allocated block %d ",l,k);
 printf("\n");
count[l]=1;
 flag[k]=1;
 }
 }
 }
return 0;
}
