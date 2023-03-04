import java.awt.*;
import java.applet.*;
public class house extends Applet
{ public void paint (Graphics g)
{
//g.drawString ("Hello World !", 25, 50);
g.drawLine(150,200,500,200);
g.drawLine(100,300,500,300);
g.drawLine(150,200,100,300);
g.drawLine(150,200,200,300);

g.drawLine(500,300,500,200);
g.drawLine(100,300,100,500);
g.drawLine(500,300,500,500);
g.drawLine(100,500,500,500);
g.drawLine(200,300,200,500);

g.drawLine(250,350,450,350);
g.drawLine(250,450,450,450);
g.drawLine(250,350,250,450);
g.drawLine(450,350,450,450);

g.drawLine(250,350,450,450);
g.drawLine(450,350,250,450);

g.drawLine(100,300,125,350);
g.drawLine(100,500,125,450);
g.drawLine(200,300,175,350);
g.drawLine(200,500,175,450);
g.drawLine(125,350,125,450);
g.drawLine(175,350,175,450);

g.drawOval(135,250,30,30);
g.setColor(Color.red);
g.fillOval(135,250,30,30);
//g.setColor(Color.brown);

g.fillRect( 150,200, 200, 100 );






showStatus("Drawing a house");
}}