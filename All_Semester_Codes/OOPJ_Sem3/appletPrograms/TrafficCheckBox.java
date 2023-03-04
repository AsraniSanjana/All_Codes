
import java.awt.event.*; 
import java.applet.*; 
import java.awt.*;

public class TrafficCheckBox extends Applet implements ItemListener  {
String msg = "";
Checkbox red,green,yellow; 
CheckboxGroup cbg;
public void init() {
cbg = new CheckboxGroup();
red = new Checkbox("Red", cbg, false); 
green = new Checkbox("Green", cbg, false);
yellow = new Checkbox("Yellow", cbg, false); 
add(red);
add(yellow);
add(green);
red.addItemListener(this);
yellow.addItemListener(this);
green.addItemListener(this);
}
public void itemStateChanged(ItemEvent ie) 
{ 
repaint();
}
public void paint(Graphics g) 
{
Color color;
color=Color.BLACK;
g.setColor(color); 
g.drawOval(50, 50, 52, 52); 
g.drawOval(50, 103, 52, 52);
g.drawOval(50, 156, 52, 52);
String col = cbg.getSelectedCheckbox().getLabel();
System.out.println(col);
if(col.equalsIgnoreCase("Green"))
{
color= Color.GREEN; 
g.setColor(color); 
g.fillOval(50, 156, 52, 52); 
g.drawString("GO",110,190);
}
if(col.equalsIgnoreCase("Red"))
{
color=Color.RED;
g.setColor(color); 
g.fillOval(51, 51, 51, 51); 
g.drawString("STOP",110,80);
}
if(col.equalsIgnoreCase("Yellow"))
{
color=Color.YELLOW;
g.setColor(color);
g.fillOval(50, 103, 51, 51);
color= Color.BLACK; 
g.setColor(color);
g.drawString("READY",110,140);
}
}
}



/*
import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class Traffic extends Applet implements Runnable
{
Thread t;
int i=0,a=0,j=0;
public void start()
{
t=new Thread(this);
t.start();
}
public void run()
{

for( int i=20;i>=0;i--)// countdown
{
try
{
Thread.sleep(1000);
}
catch(Exception e)
{
System.out.println(e);
}
if(i<=20 && i>3)//red
{
a=1;
repaint();
}
else
if(i<=3 && i>0)//yelloe
{
a=2;
repaint();
}
else
if(i==0)//green
{
for(j=0;j<20;j++)
{
a=3;
try
{
Thread.sleep(1000);
}
catch(Exception e)
{
System.out.println(e);
}
repaint();
}
if(j==20)//end of green(return to red)
{
run();
}
}
}
repaint();
}
// graphical design of traffic light 
public void paint(Graphics g)
{
g.setColor(Color.black);//pole top
g.fillRect(150,150,50,150);
g.drawRect(150,150,50,150);
g.setColor(Color.black);//POLE UP
g.fillRect(150,150,50,150);
g.drawRect(150,150,50,150);
g.setColor(Color.black);//POLE DOWN
g.fillRect(165,300,20,155);
g.drawRect(165,300,20,155);
g.drawOval(150,150,50,50);//RED
g.drawOval(150,200,50,50);//YELLOW
g.drawOval(150,250,50,50);//GREEN
g.setColor(Color.red);//COUNTDOWN STOP
g.drawString(""+i,50,50);
if(a==1)//REDSIGNAL
{
g.setColor(Color.red);
g.fillOval(150,150,50,50);
g.drawOval(150,150,50,50);
g.drawString("STOP',50,150);
}
if(a==2)//YELLOWSIGNAL
{
g.setColor(Color.yellow);
g.fillOval(150,200,50,50);
g.drawOval(150,200,50,50);
g.drawString(“READY”,50,200);
}
if(a==3)//GREENSIGNAL
{
g.setColor(Color.blue);//countdown
g.drawString(“”+j,150,50);
g.setColor(Color.green);
g.fillOval(150,250,50,50);
g.drawOval(150,250,50,50);
g.drawString(“GO”,50,250);
}
}
}

*/