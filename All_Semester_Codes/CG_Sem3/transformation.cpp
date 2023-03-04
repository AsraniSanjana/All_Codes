
 #include<stdio.h>
#include<conio.h>
#include<graphics.h>
#include<math.h>
int main()
{ int shh;

int gd,gm,m,n,i,a[10][2],b[10][2],tx,ty,sx,sy;
float t;
int x,y;
 y=GetSystemMetrics(SM_CYSCREEN)  ; // h
 x=GetSystemMetrics(SM_CXSCREEN) ; //w
initwindow(x,y,"01-D7B-SANJANA ASRANI-CG-TRANSFORMATION PROGRAM",-3,-3);
//detectgraph(&gd,&gm);
//initgraph(&gd,&gm,"");
//Accepting vertices and its coordinates
printf("Accept the no of vertices of polygon - ");
scanf("%d",&n);
for(i=0;i<n;i++)
{
printf("Accept end pt coordinates of vertices:\n");
scanf("%d %d", &a[i][0],&a[i][1]);
}
// to close polygon
a[n][0]=a[0][0];
a[n][1]=a[0][1];
 //line(320,0,320,480);
 //line(0,240,640,240);
for(i=0;i<n;i++)
{
//line(320+a[i][0], 240+a[i][1], 320+a[i+1][0], 240+a[i+1][1]);
line(a[i][0], a[i][1],a[i+1][0],a[i+1][1]);
}

    int k;
    do
    {
printf("Enter your Choice\n1.Translation\n2.Scaling\n3.Rotation\n4.2D Reflection along x-axis\n5.2D Reflection along y-axis\n6.2D Reflection along y=x line.\n7.2D Reflection along y=-x line\n8.Shear Transformation.\n9.EXIT\n ");
scanf("%d", &m);
switch(m)
{
case 1:
printf("Enter translation parameters:");
scanf("%d %d",&tx,&ty);
for(i=0;i<n;i++)
{
b[i][0]=a[i][0]+tx; //x'=x+tx
b[i][1]=a[i][1]+ty; //y'=y+ty
}
//to close new poly
 b[n][0]=b[0][0];
b[n][1]=b[0][1];
//display new poly
setcolor(GREEN);
for(i=0;i<n;i++)
{
//line(320+b[i][0],240+b[i][1],320+b[i+1][0],240+b[i+1][1]);
line(b[i][0],b[i][1],b[i+1][0],b[i+1][1]);
}break;
// 2D- Scaling
case 2:
printf("Enter scaling parameters:");
scanf("%d %d",&sx,&sy);
//new poly
for(i=0;i<n;i++)
{
b[i][0]=a[i][0]*sx;//x'=Sx.x
b[i][1]=a[i][1]*sy;//y'=Sy.y
}
b[n][0]=b[0][0];
b[n][1]=b[0][1];
//Display new poly
setcolor(YELLOW);
for(i=0;i<n;i++)
{
 //line(320+b[i][0],240+b[i][1],320+b[i+1][0],240+b[i+1][1]);
  line(b[i][0], b[i][1], b[i+1][0], b[i+1][1]);
}break;
//2D Rotation
case 3:
printf("Enter angle of rotation");
scanf("%f",&t);
t=(t*3.142)/180;
for(i=0;i<n;i++)
{
b[i][0]=(a[i][0]*cos(t)-a[i][1]*sin(t)); //x'=x.cos(t)-y.sin(t)
b[i][1]=(a[i][0]*sin(t)+a[i][1]*cos(t));//y'=x.sin(t)+y.cos(t)
}
b[n][0]=b[0][0];
b[n][1]=b[0][1];
//Display new poly
setcolor(LIGHTBLUE);
for(i=0;i<n;i++)
{
//line(320+b[i][0],240+b[i][1],320+b[i+1][0],240+b[i+1][1]);
line( b[i][0], b[i][1], b[i+1][0],b[i+1][1]);
}break;
//2D reflection along x-axis
 case 4:

for(i=0;i<n;i++)
{
b[i][0]=a[i][0];//x'=x
b[i][1]=-a[i][1];//y'=-y
}
b[n][0]=b[0][0];
b[n][1]=b[0][1];
//display new poly
setcolor(RED);
for(i=0;i<n;i++)
{
//line(320+b[i][0],240+b[i][1],320+b[i+1][0],240+b[i+1][1]);
line(b[i][0],b[i][1],b[i+1][0],b[i+1][1]);
}break;
//2D reflection along y-axis
case 5:
    setcolor(RED);
for(i=0;i<n;i++)
{
b[i][0]=-a[i][0];//x'=-x
b[i][1]=a[i][1];//y'=y
}
b[n][0]=b[0][0];
b[n][1]=b[0][1];
for(i=0;i<n;i++)
 {
//line(320+b[i][0],240+b[i][1],320+b[i+1][0],240+b[i+1][1]);

line(b[i][0],b[i][1],b[i+1][0],b[i+1][1]);
}break;

case 6:  // along y=x line
     setcolor(RED);
for(i=0;i<n;i++)
{
b[i][0]=-a[i][1];//x'=y
b[i][1]=a[i][0];//y'=x
}
b[n][0]=b[0][0];
b[n][1]=b[0][1];
for(i=0;i<n;i++)
 {
//line(320+b[i][0],240+b[i][1],320+b[i+1][0],240+b[i+1][1]);

line(b[i][0],b[i][1],b[i+1][0],b[i+1][1]);
}break;


case 7:  // along y=-x line
     setcolor(RED);
for(i=0;i<n;i++)
{
b[i][0]=-a[i][1];//x'=-y
b[i][1]=-a[i][0];//y'=-x
}
b[n][0]=b[0][0];
b[n][1]=b[0][1];
for(i=0;i<n;i++)
 {
//line(320+b[i][0],240+b[i][1],320+b[i+1][0],240+b[i+1][1]);

line(b[i][0],b[i][1],b[i+1][0],b[i+1][1]);
}break;









//2D Shear Transformation along x-Axis
case 8:
printf("Enter angle of shear - ");
scanf("%f",&t);
t=t*3.142/180;
printf("press 1 for x shearing and 2 for y shearing\n");
scanf("%d",&shh);
setcolor(MAGENTA);
for(i=0;i<n;i++)
{ if (shh==1)
{   //a[i][0]=a[i][0]+sh*(a[i][1]-fy);
    b[i][0]=a[i][0]+(a[i][1]*tan(t)); //x'=x+y.tan(t)
b[i][1]=a[i][1];//y'=y
}
else if (shh==2)
{  //a[i][1]=a[i][1]+sh*(a[i][0]-fx);
      b[i][0]=a[i][0];
b[i][1]=a[i][1] + (a[i][0]*tan(t));
}

}
b[n][0]=b[0][0];
b[n][1]=b[0][1];
//Display new poly
setcolor(CYAN);
for(i=0;i<n;i++)
{
//line(320+b[i][0],240+b[i][1],320+b[i+1][0],240+b[i+1][1]);
line(b[i][0],b[i][1],b[i+1][0],b[i+1][1]);
}break;

case 9:
    break;
default:
 printf("INVALID CHOICE");
}
}while(m!=9);
getch();
return 0;
}
