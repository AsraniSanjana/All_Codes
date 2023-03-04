


/* #include <stdio.h>
#include <dos.h>
#include <graphics.h>

// Function to put pixels
// at subsequence points
void drawCircle(int xc, int yc, int x, int y)
{
    putpixel(xc+x, yc+y, RED);
    putpixel(xc-x, yc+y, RED);
    putpixel(xc+x, yc-y, RED);
    putpixel(xc-x, yc-y, RED);
    putpixel(xc+y, yc+x, RED);
    putpixel(xc-y, yc+x, RED);
    putpixel(xc+y, yc-x, RED);
    putpixel(xc-y, yc-x, RED);
}

// Function for circle-generation
// using Bresenham's algorithm
void circleBres(int xc, int yc, int r)
{
    int x = 0, y = r;
    int d = 3 - 2 * r;
    drawCircle(xc, yc, x, y);
    while (y >= x)
    {
        // for each pixel we will
        // draw all eight pixels

        x++;

        // check for decision parameter
        // and correspondingly
        // update d, x, y
        if (d > 0)
        {
            y--;
            d = d + 4 * (x - y) + 10;
        }
        else
            d = d + 4 * x + 6;
        drawCircle(xc, yc, x, y);

    }
}


// Driver code
int main()
{
    int xc = 200, yc = 300, r = 50;
    int gd = DETECT, gm;
    initgraph(&gd, &gm, "");  // initialize graph
    circleBres(xc, yc, r);    // function call
    getch();
    return 0;
    closegraph();
}
*/

#include <graphics.h>
#include <stdlib.h>
#include <stdio.h>
#include <conio.h>
#include <math.h>

    void    EightWaySymmetricPlot(int xc,int yc,int x,int y)
   {
    putpixel(x+xc,y+yc,RED);
    putpixel(x+xc,-y+yc,BLUE);
    putpixel(-x+xc,-y+yc,GREEN);
    putpixel(-x+xc,y+yc,YELLOW);
    putpixel(y+xc,x+yc,GREEN);
    putpixel(y+xc,-x+yc,DARKGRAY);
    putpixel(-y+xc,-x+yc,MAGENTA);
    putpixel(-y+xc,x+yc,CYAN);
   }

    void BresenhamCircle(int xc,int yc,int r)
   {
    int x=0,y=r,d=3-(2*r);
    EightWaySymmetricPlot(xc,yc,x,y);

    while(x<=y)
     {
      if(d<=0)
             {
        d=d+(4*x)+6;
      }
     else
      {
        d=d+(4*x)-(4*y)+10;
        y=y-1;
      }
       x=x+1;
       EightWaySymmetricPlot(xc,yc,x,y);
      }
    }

    int  main(void)
   {
    /* request auto detection */
    int xc,yc,r,gdriver = DETECT, gmode, errorcode;
    /* initialize graphics and local variables */
     initgraph(&gdriver, &gmode, "");

     /* read result of initialization */
     errorcode = graphresult();

      if (errorcode != grOk)  /* an error occurred */
     {
        printf("Graphics error: %s\n", grapherrormsg(errorcode));
        printf("Press any key to halt:");
        getch();
        exit(1); /* terminate with an error code */
     }
       printf("Enter the values of xc and yc :");
       scanf("%d%d",&xc,&yc);
       printf("Enter the value of radius  :");
       scanf("%d",&r);

       BresenhamCircle(xc,yc,r);


     getch();
     closegraph();
     return 0;
    }
