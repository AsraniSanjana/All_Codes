// DDA LINE DRAWING ALGORITHM
#include<stdio.h>
#include<graphics.h>
#include<math.h>

int abs (int n)
{return ( (n>0) ? n : ( n * (-1)));
}
void DDA(int X0, int Y0, int X1, int Y1)
{
	int dx = X1 - X0;
	int dy = Y1 - Y0;
    int steps = abs(dx) > abs(dy) ? abs(dx) : abs(dy);
	float Xinc = dx / (float) steps;
	float Yinc = dy / (float) steps;
    float X = X0;
	float Y = Y0;
	float m;
	for (int i = 0; i <= steps; i++)
	{ //if (m<5) // dash line <1 for dotted
		//{
		    putpixel (round(X),round(Y),WHITE);
		X += Xinc;
		Y += Yinc;
		//m++;}
		//else
         //{

        //  X += Xinc;
		//Y += Yinc;
	//	m=0;}
	}
		//}

}
int main()
{int gd = DETECT, gm;
    initgraph (&gd, &gm, "");

	int X0,Y0,X1,Y1;
	printf("enter coordinates of the two points:");
	printf("enter x1,y1:");
	scanf("%d%d",&X0,&Y0);
	printf("enter x2,y2:");
	scanf("%d%d",&X1,&Y1);
	DDA(X0,Y0,X1,Y1);



	//function calls for triangle
    //DDA(200, 50, 100, 200);
	//DDA(100, 200, 300, 200);
	//DDA(200, 50, 300, 200);

	delay(100);
	getch();
    closegraph();
    return 0;
}

	// DDA(0,0,1080,815); FOR \ small window
	// for \ full screen window : x2= 1400; y2=760;
	// GetSystemMetrices(SM_CXSCREEN);   // WIDTH/XAXISLENGTH,1280
	// GetSystemMetrices(SM_CYSCREEN);   // HEIGHT/YAXISLENGTH,720
	// initwindow(w,h,"DDA LINE DRAWING ALGO");



/*// dashed line
#include<stdio.h>
#include<graphics.h>
#include<math.h>

int main()
{
    int x1, y1, x2, y2, i; int m=0;
    float x, y, dx, dy, length;
    int gd=DETECT,gm;
    initgraph(&gd,&gm, "");
    printf("Enter coordinates of starting point :");
    scanf("%d%d",&x1,&y1);
    printf("Enter coordinates of end point :");
    scanf("%d%d",&x2,&y2);
    if(abs(x2>x1)>abs(y2-y1))
        length=abs(x2-x1);
    else
        length=abs(y2-y1);
    dx=(x2-x1)/length;
    dy=(y2-y1)/length;

    putpixel(x1,y1,15);
    putpixel(x2,y2,15);

    i=1;
    while(i<=length)
    {
        if(m<4)
        {
            x1=x1+dx;
            y1=y1+dy;
            putpixel(x1,y1,15);
            delay(50);
            m=m+1;
        }
        else
        {
            x1=x1+dx;
            y1=y1+dx;
            m=0;
        }
        i=i+1;
    }
getch();
closegraph();
return 0;
}
*/
/* // dotted line dda
#include<stdio.h>
#include<graphics.h>
#include<math.h>
int main()
{
    int x1, y1, x2, y2, i; int m=0;
    float x, y, dx, dy, length;
    int gd=DETECT,gm;
    initgraph(&gd,&gm, "");
    printf("Enter coordinates of starting point :");
    scanf("%d%d",&x1,&y1);
    printf("Enter coordinates of end point :");
    scanf("%d%d",&x2,&y2);
    if(abs(x2>x1)>abs(y2-y1))
        length=abs(x2-x1);
    else
        length=abs(y2-y1);
    dx=(x2-x1)/length;
    dy=(y2-y1)/length;

    putpixel(x1,y1,WHITE);
    putpixel(x2,y2,WHITE);

    i=1;
    while(i<=length)
    {
        if(m<1)
        {
            x1=x1+dx;
            y1=y1+dy;
            putpixel(x1,y1,WHITE);
            delay(50);
            m=m+1;
        }
        else
        {
            x1=x1+dx;
            y1=y1+dx;
            m=0;
        }
        i=i+1;
    }
getch();
closegraph();
return 0;
}
*/
