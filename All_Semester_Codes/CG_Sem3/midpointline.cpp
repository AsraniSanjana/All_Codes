#include<stdio.h>
#include<graphics.h>
// cant draw all types of tilted lines
void midpoint(int x1,int y1,int x2,int y2)
   {
int dx,dy,d,x,y;
    dx = x2 - x1;
    dy = y2 - y1;


    // initialize the decision parameter
  if(dy<=dx){
   d = 2*dy - dx;

    x = x1;
    y = y1;

   putpixel(x,y,WHITE);


    while(x < x2)
      {

        x = x + 1;
        //East is chosen
        if (d < 0)
            d += 2*dy;

        // North East is chosen
        else
           {
               d += 2* (dy - dx);
            y = y + 1;
      }}}
/*
  else if(dx<dy)
  {
    // initial value of decision parameter d
    int d = dx - (dy/2);
int X1,X2,Y1,Y2;
x = X1;
 y = Y1;
    // Plot initial given point
     putpixel(x,y,WHITE);


    // iterate through value of X
    while (y < Y2)
    {
        y++;

        // E or East is chosen
        if (d < 0)
            d = d + dx;

        // NE or North East is chosen
        // NE or North East is chosen
        else
        {
            d += (dx - dy);
            x++;
        }

        putpixel(x,y,WHITE);
    }
  }
}
*/
}
int main()
{
   int x1=0,y1=0,x2=200,y2=300;

    int gdriver = DETECT,gmode;
    initgraph (&gdriver, &gmode, " ");
    midpoint(x1, y1, x2, y2);
    delay(1000);
    getch();
         closegraph();
        return 0;

    }




