#include<stdio.h>
#include<graphics.h>
int main()
{
    int gd=DETECT,gm;
    initgraph(&gd,&gm,"");
    int x,y,xc,yc,r;
    float p;
    printf("Enter center of the circle : ");
    scanf("%d%d",&x,&y);
    printf("Enter radius of the circle : ");
    scanf("%d",&r);
    p=1-r;
    xc=0;
    yc=r;
    while(xc<=yc)
    {
         if(p<0)
    {
        xc++;
        p=p+(2*xc)+1;
    }
    else
    {
        xc++;
        yc--;
        p=p+2*(xc-yc)+1;
    }
     putpixel(xc+x,yc+y,YELLOW);
     putpixel(xc+x,y-yc,BLUE);
     putpixel(x-xc,yc+y,RED);
     putpixel(x-xc,y-yc,LIGHTCYAN);
     putpixel(x+yc,y+xc,GREEN);
     putpixel(x+yc,y-xc,WHITE);
     putpixel(x-yc,y+xc,MAGENTA);
     putpixel(x-yc,y-xc,DARKGRAY);


    }

    getch();
    closegraph();
    return 0;
}
