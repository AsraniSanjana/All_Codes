#include<stdio.h>
#include<math.h>
#include<graphics.h>
#define PI 3.14

int main()
{  int random=0;

    int x1,y1,x2,y2,r=26;
 int M,p,dx,dy,x,y,t;
int gd=DETECT,gm;
    initgraph(&gd,&gm,"");



//printf("enter radius of circle: ");
//scanf("%d",&r);
//printf("\n enter center of the circle:");
//printf("\n x:");
//scanf("%d",&x);
//printf("\n y:");
//scanf("%d",&y);
//r=50;x=200;y=300;
//circle(x,y,r);
int a=100;  // x coordinate of rec +diff bw ENDPOINT OF RECTANGLE/2
int b=125;

line(x,y,x+(r*sin(PI/6)),y-r*cos(PI/6));
line(x,y,x+(r*sin(2*PI/6)),y-r*cos(2*PI/6));
line(x,y,x+(r*sin(3*PI/6)),y-r*cos(3*PI/6));
line(x,y,x+(r*sin(4*PI/6)),y-r*cos(4*PI/6));
line(x,y,x+(r*sin(5*PI/6)),y-r*cos(5*PI/6));
line(x,y,x+(r*sin(6*PI/6)),y-r*cos(6*PI/6));
line(x,y,x+(r*sin(7*PI/6)),y-r*cos(7*PI/6));
line(x,y,x+(r*sin(8*PI/6)),y-r*cos(8*PI/6));
line(x,y,x+(r*sin(9*PI/6)),y-r*cos(9*PI/6));
line(x,y,x+(r*sin(10*PI/6)),y-r*cos(10*PI/6));
line(x,y,x+(r*sin(11*PI/6)),y-r*cos(11*PI/6));
line(x,y,x+(r*sin(12*PI/6)),y-r*cos(12*PI/6));



/*
//ASHOKA CHAKRA
for(int i=0;i<=360;i=i+15)
{
    x=r*sin(i*PI/180);
     y=r*cos(i*PI/180);
     setcolor(BLUE);
     line(a,b,a+x,b-y);
}
circle(a,b,r);

setcolor(WHITE);
/*
rectangle(30,50,170,50);
//floodfill(a,b,100);
rectangle(30,100,170,100);
rectangle(30,150,170,150);
rectangle(30,200,170,200);
rectangle(30,50,170,50);
rectangle(30,50,170,200);

*/
/*
// flag other way
for(int i=0;i<=150;i++)
{  for(int j=0;j<=200;j=j+50)
   {

    line(30+i,50+j,170+i,50+j);
}}
line(30,50,30,400);

*/
/*
line(0,215,650,215);
line(315,0,315,500);
circle(315,215,20);
outtextxy(315,217,"(315,215)");
line(0,0,328,500);
line(642,-6,303,500);
line(0,215,315,0);
line(315,0,650,220);
line(0,480,315,215);
*/
//make avengers logo

// making objects move
// normal object generation code
//moving them
/*
for(int i=0;i<700;i++)
{
     circle(20+i,200,10);
line(20+i,210,20+i,250);
line(20+i,250,10+i,300);

line(20+i,220,10+i,250);
line(20+i,220,30+i,250);

line(20+i,250,30+i,300);
line(20+i,250,10+i,300);
line(0,300,700,300); // ground wont move
// rain
x=getmaxx();
y=getmaxy();
//line(x,0,0,y); // diagonal across the screen /
//line(0,0,x,y); // diagonal across the screen \


for(int j=0;j<100;j++)
{outtextxy(rand()%x,(rand()-150)%y,"!"); // subtract 150 so rain is 150 above ground

}
delay(10);
cleardevice();
}


/*

//int x;
x=getmaxx();
y=getmaxy();
setcolor(BLUE);
for(int j=0;j<150;j++)
{
for(int i=0;i<x;i++)
{
setfillstyle(SOLID_FILL,BLUE);

circle(0+i+j,300,50);  // horizontally moving circle
floodfill(i,300,BLUE); // MAKING A BLUE CIRCLE ROLL
delay(10);
cleardevice();
}  }

/*
int y;
y=getmaxy();
for(int j=0;j<150;j++) // j loop is to make the shape come back to screen
{
    for(int i=0;i<y;i++)
    {
    //rectangle(200,300+2*i-y,300,400+2*i-y); // vertically moving rectangle

line(200,50+2*i-y,100,200+2*i-y);
line(100,200+2*i-y,300,200+2*i-y);
line(200,50+2*i-y,300,200+2*i-y);
//circle(0,300,50+i+j); // expanding circle
//circle(200,300+2*i-y,50);  // vertically moving circle
delay(5);
cleardevice();
} }
*/

// make a bouncy ball
// expanding rectangle

//y=getmaxy();

//x=getmaxx();
/*
for(int j=0;j<y;j++)
{


for(int i=0;i<x;i++)
    {

  //  rectangle(i,i,j,j); expand rectan
//rectangle(200+2*i-x,300,300+2*i-x,400); // horiz move rect
//circle(i,i,10); // diagonally moving
//rectangle(i,j,i+x,j+y); // scan

   delay(5);
cleardevice(); }}
*/
/*
for(int j=0;j<1000;j++)
{

for(int i=0;i<1000;i=i+10)
{


//rectangle(i,j,50+i,50+j);  game falling squares i=i+50,j+50
//rectangle(i,i,i+50,i+50); // same size moving rectangle
//rectangle(50+i,50+i,i+100,i+100);  // chain of 2 squares moving diag

//rectangle(i,i,2*i,2*i);// increasing size moving rectangles

delay(10);
cleardevice();
}}



*/


// matrix
/*
for(int j=0;j<1000;j=j+50)
{


for(int i=0;i<1000;i=i+50)
{
rectangle(0+i,0+i,50+i,50+i);
rectangle(0+i,0+j,50+i,50+j);
}}
*/
// make a shape move diagonally


for(int j=0;j<y;j++)
{


for(int i=0;i<x;i++)
    {

  //  rectangle(i,i,j,j); expand rectan
rectangle(200+2*i-x,300,300+2*i-x,400); // horiz move rect
//circle(i,i,10); // diagonally moving
//rectangle(i,j,i+x,j+y); // scan

   delay(5);
cleardevice(); }}

 getch();
closegraph();
return 0;
}


/*
//random animation


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





*/

