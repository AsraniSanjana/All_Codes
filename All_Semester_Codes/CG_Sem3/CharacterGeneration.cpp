#include<stdio.h>
#include<conio.h>
#include<graphics.h>
void main()
{
int gd=DETECT,gm,i,j;
int a[20][20]=
{{0,0,0,1,1,1,0,0,0,0,0,0,0,0,1,1,1,1,0,0},
{0,0,1,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,1,0},
{0,1,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,1},
{1,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0},
{1,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0},
{1,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,1,1,1,0},
{1,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0},
{0,1,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,1,0},
{0,0,1,0,0,0,1,0,0,0,0,0,1,0,0,0,0,1,0,0},
{0,0,0,1,1,1,0,0,0,0,0,0,0,1,1,1,1,0,0,0}};
initgraph(&gd,&gm,"c:\\turboc3\\bgi");
for(i=0;i<19;i++)
{
2 / 2
for(j=0;j<19;j++)
{
if(a[i][j]==1)
putpixel(100+j,200+i,WHITE);
}
}
getch();
}