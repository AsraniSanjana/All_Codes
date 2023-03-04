import java.awt.*;
import java.applet.*;
public class DrawingFan extends Applet
{ public void paint (Graphics g)
{
for(int i=0;i<=400;i=i+20)
{
g.drawLine(200,200,i,0);
showStatus("Drawing fan");
}}}