
#include<stdio.h>

#include<conio.h>

#include<graphics.h>

int main()

{

int x,y;


 y=GetSystemMetrics(SM_CYSCREEN)  ; // h
 x=GetSystemMetrics(SM_CXSCREEN) ; //w
initwindow(x,y,"HEY",-3,-3);
x=getmaxx()/2;
y=getmaxy()/2;
setbkcolor(WHITE);
setcolor(BLUE);

for(int i=1;i<=8;i++)
{
    {
        setfillstyle(i,i);
        delay(500);
        circle(x,y,i*20);

        floodfill(x-2+i*20,y,BLUE);

    }
}


getch();
closegraph();


}
