import java.awt.*;
import java.applet.*;
public class DrawCircles extends Applet 
{
public void paint(Graphics g)
{
g.drawOval(0,0,40,40);
g.drawOval(120,0,40,40);
g.drawOval(60,60,40,40);
g.drawOval(0,120,40,40);
g.drawOval(120,120,40,40);

g.fillOval(60,0,40,40);
g.fillOval(0,60,40,40);
g.fillOval(120,60,40,40);
g.fillOval(60,120,40,40);
}}