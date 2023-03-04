import java.awt.*;
import java.applet.*;
public class housefilled extends Applet

{
    // have an image as a background.
   
 public void paint (Graphics g)
{

//setBackground(Color.yellow);
Color mycolorskyblue = new Color(51,153,255);
setBackground(mycolorskyblue);
 
      g.setColor(Color.black); // lines black banarhi mei
	
	  int x[] = { 150,200,100};
      int y[] = { 200,300,300};
      int numberofpoints = 3;
      g.drawPolygon(x, y, numberofpoints);
      
Color mycolorbrown = new Color(150, 75, 0);
g.setColor(mycolorbrown);
g.fillPolygon(x,y,3);

 g.setColor(Color.black);
int m[] = { 200,500,500,200};
int n[] = { 300,300,500,500};
g.drawPolygon(m,n,4);

Color mycolorpurple = new Color(203, 195, 227 );
g.setColor(mycolorpurple);
g.fillPolygon(m,n,4);

    g.setColor(Color.black);
int m1[] = {100,125,125,100};
int n1[] = {300,350,450,500};
g.drawPolygon(m1,n1,4);

Color mycolorlightbrown = new Color(196, 164, 132);
g.setColor(mycolorlightbrown);
g.fillPolygon(m1,n1,4);

 g.setColor(Color.black);
int m2[] = {200,175,175,200};
int n2[] = {300,350,450,500};
g.drawPolygon(m2,n2,4);
g.setColor(mycolorlightbrown);
g.fillPolygon(m2,n2,4);

     g.setColor(Color.black);
int m3[] = {150,500,500,200};
int n3[] = {200,200,300,300};
g.drawPolygon(m3,n3,4);

g.setColor(Color.green);
g.fillPolygon(m3,n3,4);

//..............
   g.setColor(Color.black);
int m4[] = {250,450,450,250};
int n4[] = {350,350,450,450};
g.drawPolygon(m4,n4,4);

g.setColor(Color.yellow);
g.fillPolygon(m4,n4,4);

g.setColor(Color.black);
g.drawLine(250,350,450,450); 
g.drawLine(450,350,250,450);

g.setColor(Color.black);
g.drawOval(135,250,30,30);
g.setColor(Color.white);
g.fillOval(135,250,30,30);
g.setColor(Color.black);
g.drawLine(100,500,200,500);

for(int i=150;i<=500;i=i+20)
{ int j=i+50;
// g.drawLine(200+i,300,i,200);
if(j>500)break;
 g.drawLine(i,200,j,300);
}

showStatus("Drawing and colouring a house");
}}