#include <stdio.h>
#include<time.h>
#include <conio.h>
#include <graphics.h>
int main()
{
 int n,i,j,k,gd,gm,dy,dx;
 int x,y,temp;
 int a[20][2],xi[20];
 float slope[20];
 printf("Enter the no. of edges of polygon : ");
 scanf("%d",&n);
 printf("\nEnter the coordinates of polygon :\n ");
 for(i=0;i<n;i++)
 {
 printf("\nX%d Y%d : ",i,i);
 scanf("%d %d",&a[i][0],&a[i][1]);
 }
 a[n][0]=a[0][0];
 a[n][1]=a[0][1];
 detectgraph(&gd,&gm);
 initgraph(&gd,&gm,"");
 setcolor(YELLOW);

 for(i=0;i<n;i++)
 {


 line(a[i][0],a[i][1],a[i+1][0],a[i+1][1]);
 for(i=0;i<n;i++)
 {
 dy=a[i+1][1]-a[i][1];
 dx=a[i+1][0]-a[i][0];
 if(dy==0)
 slope[i]=1.0;
 if(dx==0)
 slope[i]=0.0;
 if((dy!=0)&&(dx!=0))
 slope[i]=(float) dx/dy;
 }
 for(y=0;y<480;y++)
 {
 k=0;
 for(i=0;i<n;i++)
 {
 if(((a[i][1]<=y)&&(a[i+1][1]>y))||((a[i][1]>y)&&(a[i+1][1]<=y)))
 {
 xi[k]=(int)(a[i][0]+slope[i]*(y-a[i][1]));
 k++;
 }
 }
 for(j=0;j<k-1;j++)
 {
 for(i=0;i<k-1;i++)
 {if(xi[i]>xi[i+1])
 {
 temp=xi[i];
 xi[i]=xi[i+1];
 xi[i+1]=temp;
 }
 }
 }
 //setcolor(RED);
 for(i=0;i<k;i+=2)
 {  setcolor(GREEN); // will fill green colur inside the triangle
 line(xi[i],y,xi[i+1]+1,y);
/*
        Enter the no. of edges of polygon : 6
        Enter the cordinates of polygon :
        X0 Y0 : 200,50
        X1 Y1 : 150,100
        X2 Y2 : 150,150
        X3 Y3 : 200,200
        X4 Y4 : 250,150
        X5 Y5 : 250,100

*/


 delay(16);
 }
 }

 getch();
 closegraph();
 return 0;
}
}
