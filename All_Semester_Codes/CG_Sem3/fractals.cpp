
// do while menu all fractals

#include<conio.h>
#include<stdio.h>
#include<graphics.h>
#include<math.h>
#define PI 3.14
int a;
void koch ( int x1 , int y1 , int x2 , int y2 , int it)
{
float angle = 60 * PI /180 ;
int x3 = ( 2 * x1 + x2 ) / 3 ;
int y3 = ( 2 * y1 + y2 ) / 3 ;

int x4 = ( x1 + 2 * x2 ) / 3 ;
int y4 = ( y1 + 2 * y2 ) / 3 ;

int x = x3 + ( x4 - x3 ) * cos ( angle ) + ( y4 - y3 ) * sin ( angle ) ;
int y = y3 - ( x4-x3 ) * sin ( angle ) + ( y4 - y3 ) * cos ( angle ) ;
if ( it > 0 ) {
koch ( x1 , y1 , x3 , y3 , it - 1 ) ;
koch ( x3 , y3 , x , y , it - 1 ) ;
 koch ( x , y , x4 , y4 , it - 1 ) ;
 koch ( x4 , y4 , x2 , y2 , it - 1 ) ;
}
else {
 line ( x1 , y1 , x3 , y3 ) ;
line ( x3 , y3 , x , y ) ;
 line ( x , y , x4 , y4 ) ;
line ( x4 , y4 , x2 , y2 ) ;
} }


void drawfern(int x,int y,int l,int arg,int n)
{
int x1,y1,i;
int l1,xpt,ypt;

if(n>0&&!kbhit())
 {
 x1=(int)(x-l*sin(arg*3.14/180));
 y1=(int)(y-l*cos(arg*3.14/180));
 line(x,y,x1,y1);
 l1=(int)(l/5);
 for(i=1;i<8;i++) // i is number of branch a branch has
  {
  xpt=(int)(x-i*l1*sin(arg*3.14/180));
  ypt=(int)(y-i*l1*cos(arg*3.14/180) );
  drawfern(xpt,ypt,(int)(l/(i+1)),arg+a,n-1);
  drawfern(xpt,ypt,(int)(l/(i+1)),arg-a,n-1);
  }

 }
}




 int main()
{
int gd=DETECT,gm; int choice,i;
int x,y,l,x1,y1;
double d;



 y1=GetSystemMetrics(SM_CYSCREEN)  ; // h
 x1=GetSystemMetrics(SM_CXSCREEN) ; //w
initwindow(x1,y1,"01_D7B_SANJANA ASRANI_CG_Fractals",-3,-3);

x=getmaxx()/2;
y=getmaxy()/2;
l=150;
a=45;

printf("program to perform animations on fractals!\n");
do{
printf("1.fern \n2.mendelbrots set\n3.koch curve\n4.serpensiki's triangle\n5.Exit\nChoose an option:");
scanf("%d",&choice);
switch(choice)
{

case 1: cleardevice();
    {
setcolor(LIGHTCYAN);
drawfern(x+200,y,l,0,5);
break;}


case 2:  cleardevice();
    {

int i,A,B;
double a,b,t,n=70,x,y;
for (B=0;B<=4*n;B++)
{

    b=2-(B/n);
    for(A=0;A<=4*n;A++){

        a=-2+(A/n);
        x=0;
        y=0;
       for(i=1;i<=1000;i++){

        t=x;
        x=(x*x)-(y*y)+a;
        y=(2*t*y)+b;

        if((x*x)+(y*y)>4)
        {

           break;
        }}


       if(i==1001)
       {
        for(int j=0;j<50;j++){
                int x3=100;
        putpixel(A+70*j + x3*j,B+50*j,j);
        x3++;}
//putpixel(A+100,B,GREEN);

       }
    } }
 break ;
 }

case 3: cleardevice();
     {
outtextxy(700, 50, "A general Koch curve : ");
koch ( 700 ,100, 900 , 400,2 );

outtextxy(40, 50, "A snowflake using Koch curves : ");
/*
koch ( 200 ,100, 300 , 100,2 );
koch ( 300 ,100, 400 , 200,2 );
koch ( 400 ,200, 300 , 300,2 );
koch ( 300 ,300, 200 , 300,2 );
koch ( 200 ,300, 100 , 200,2 );
koch ( 100 ,200, 200 , 100,2 );
*/

koch ( 200 ,100, 400 , 100,2 );
koch ( 400 ,100, 400 , 300,2 );
koch ( 400 ,300, 200 , 300,2 );
koch ( 200 ,300, 200 , 100,2 );

break;

 case 4 :
      cleardevice();

     {

//delay(2000);
for(int i=0;i<10000000;i++)
{

    d=rand()%3;
    if(d==0){
        x=(x+650)/2;
        y=y/2;

    }
    else if(d==1)
    {

        x=(x+1300)/2;
        y=(y+650)/2;
    }
        else if(d==2)
    {

        x=(x)/2;
        y=(y+650)/2;
    }
    putpixel(x,y,GREEN);
    if(i%100==0) {}
       // delay(1);
}

break; }
case 5 :
    break;
} } }while(choice!=5);
getch();
closegraph();
return 0;
}

