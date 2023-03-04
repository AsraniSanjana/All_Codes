import java.awt.*;
import java.applet.*;
public class Smiley extends Applet{
    public void paint(Graphics g)
    {
        g.drawOval(0,0,300,400);
        g.setColor(Color.red);
        g.fillOval(75,75,20,50);
        g.fillOval(220,75,20,50);
        int x[]={150,200,100};
        int y[]={180,230,230};
        int no=3;
        g.drawPolygon(x,y,no);
        g.setColor(Color.orange);
        g.drawArc(70,230,170,120,0,-180);
    }}