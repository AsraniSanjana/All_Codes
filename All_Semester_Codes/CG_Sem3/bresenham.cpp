#include<stdio.h>
#include<math.h>
#include<graphics.h>
// is there any way i can join the 4 lines and make it 1 object
// so that moving them through arraow keys is easy
void Draw(int x1,int y1, int x2,int y2)
{
int M,p,dx,dy,x,y,t;
if((x2-x1)==0)  // undefined slope dy/0
       M = (y2-y1);
    else
        M = (y2-y1)/(x2-x1);

    if(abs(M)<1)
    {
        if(x1>x2)   // so if the end point coordinates is smaller than starting point
                    // x1-x2= negative
                     //so we just swap starting and ending coordinates so that the slope still stays positive
        {
            t = x1;
            x1 = x2;
            x2 = t;

            t = y1;
            y1 = y2;
            y2 = t;
        }
//else proceed normally , initial coordinates bigger end coordinates smaller
        dx = abs(x2-x1);
        dy = abs(y2-y1);

        p = 2*dy-dx;

        x=x1;
        y=y1;

          while(x<=x2)  // x1 to x2 , value of x is incremented
                {
            putpixel(x,y,WHITE);
              x=x+1;

              if(p>=0)
              {
                 if(M<1)   // p>=1
                    y=y+1;
                else
                    y=y-1;
                 p = p+2*dy-2*dx;
              }
              else
              {
                  y=y;
                  p = p+2*dy;
              }
            }

    }

    if(abs(M)>=1)
    {
        if(y1>y2)
        {
            t = x1;
            x1 = x2;
            x2 = t;

            t = y1;
            y1 = y2;
            y2 = t;
        }

        dx = abs(x2-x1);
        dy = abs(y2-y1);

        p = 2*dx-dy;

        x=x1;
        y=y1;


            while(y<=y2)
            {
             putpixel(x,y,WHITE);
              y=y+1;

              if(p>=0)
              {
                 if(M>=1)
                    x=x+1;
                else
                    x=x-1;
                 p = p+2*dx-2*dy;
              }
              else
              {
                  x=x;
                  p = p+2*dx;
              }
            }

    }
//delay(1000);
}



int main()
{

    int x1,y1,x2,y2;
 int M,p,dx,dy,x,y,t;
int gd=DETECT,gm;
    initgraph(&gd,&gm,"");
 // kite like
 /*
Draw(200, 50, 100, 200);// /

Draw(100, 200, 300, 200); //  _
Draw(200, 50, 300, 200); // \

Draw(200, 350, 100, 200);
Draw(300, 200, 200, 350);
*/
// parallelogram
   Draw(100, 50, 250, 50);
    Draw(50, 100, 200, 100);
     Draw(100, 50, 50, 100);
      Draw(250, 50, 200, 100);

// make a menu driven to select from one of the shapes
/*
printf("enter coordinates to draw a square or rectangle(cant draw rhomb or parall):\n");
printf("enter top left:");
scanf("%d%d",&x1,&y1);
printf("\n enter bottom right:");
scanf("%d%d",&x2,&y2);
Draw(x1,y1,x2,y1);
Draw(x1,y1,x1,y2);
Draw(x1,y2,x2,y2);
Draw(x2,y1,x2,y2);
*/
//Draw(100,200,300,400);



getch();
closegraph();
return 0;



}


