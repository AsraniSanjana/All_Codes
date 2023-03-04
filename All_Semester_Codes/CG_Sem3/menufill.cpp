
/*

 boundary_ fill (x,y, f_color, b_color)
{
if ( getpixel (x,y) != b_color && getpixel (x,y) != f_color)
putpixel(x,y,f_color)
boundary_fill( x+1, y, f_color, b_color);
boundary_fill( x, y+1, f_color, b_color);
boundary_fill( x-1, y, f_color, b_color);
boundary_fill( x, y-1, f_color, b_color);
}
Flood Fill Algorithm:
void flood_ fill (x,y, old_color, new_color)
{
putpixel(x,y,new_color)
flood_ fill (x+1, y, old_color, new_color)
flood_ fill (x-1, y, old_color, new_color)
flood_ fill (x, y+1, old_color, new_color)
flood_ fill (x, y-1, old_color, new_color)
flood_ fill (x+1, y+1, old_color, new_color)
flood_ fill (x-1, y-1, old_color, new_color)
flood_ fill (x+1, y-1, old_color, new_color)
flood_ fill (x-1, y+1, old_color, new_color)
}


*/

//Program:
#include<conio.h>
 #include<stdio.h>
 #include<graphics.h>
 void flood(int,int,int,int);
void Boundary(int,int,int,int);
int main()
{
int gd=DETECT,gm; int choice,i;
initgraph(&gd,&gm,"C:\\TC\\BGI"); rectangle(250,250,300,300);
printf("1.Flood fill\n2.Boundary fill\nEnter choice:"); scanf("%d",&choice);
switch(choice)
{
case 1:
printf("Enter fill colour:\n"); printf("1.Blue\n2.Green\n3.Yellow:"); scanf("%d",&i);
switch(i)
{
case 1:
flood(260,260,BLUE,0);
break; case 2:
flood(260,260,GREEN,0);
break; case 3:
flood(260,260,YELLOW,0);
default:
printf("Invalid choice:");
}
break; case 2:
printf("Enter the colour with which you want to fill the square:\n"); printf("1.Blue\n2.Yellow\n3.Red:");
scanf("%d",&i);
switch(i)
{
case 1: Boundary(260,260,BLUE,15);
break;
 case 2:
Boundary(260,260,YELLOW,15);
break; case 3:
Boundary(260,260,RED,15);
break; default:
printf("Invalid choice:");
}
break;
default:
printf("Invalid choice:");
}
delay(10);
getch();
return 0;
}
void flood(int x,int y,int fillColor,int defaultColor)
{
if(getpixel(x,y)==defaultColor)
{
delay(1); putpixel(x,y,fillColor);
flood(x+1,y,fillColor,defaultColor); flood(x-1,y,fillColor,defaultColor); flood(x,y+1,fillColor,defaultColor); flood(x,y-1,fillColor,defaultColor);
}
}
void Boundary(int x,int y, int newcolor,int edge)
{ delay(10);
int current=getpixel(x,y); if(current!=edge&&current!=newcolor)
{
putpixel(x,y,newcolor);
Boundary(x+1,y,newcolor,edge);
Boundary(x+1,y+1,newcolor,edge);
Boundary(x-1,y,newcolor,edge);
Boundary(x-1,y+1,newcolor,edge);
Boundary(x,y+1,newcolor,edge);
Boundary(x,y-1,newcolor,edge);
Boundary(x-1,y-1,newcolor,edge);
Boundary(x+1,y-1,newcolor,edge);
}}
