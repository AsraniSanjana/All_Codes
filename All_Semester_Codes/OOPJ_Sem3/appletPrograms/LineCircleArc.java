import java.awt.*;
import java.applet.*;
public class LineCircleArc extends Applet

{
    public void init() {
        // Here we change the default grey color background of an 
        // applet to yellow background.
        setBackground(Color.cyan);
    }
    
 public void paint (Graphics g)
{

 

    // ARC
    g.setColor(Color.blue);
    g.drawString("An arc", 100, 70);
    
    g.setColor(Color.black);
    g.drawArc(30,5, 200, 200, 0, -90); //Syntax For:- drawArc(int xTopLeft, int yTopLeft, int width, int height, int startAngle, int arcAngle);
    
    Color mycolorpurple = new Color(203, 195, 227 );
    g.setColor(mycolorpurple);
    g.fillArc(30, 5, 200, 200, 0, -90);  //Syntax For:- fillArc(int xTopLeft, int yTopLeft, int width, int height, int startAngle, int arcAngle);
    
    
    // LINE
    
    g.setColor(Color.black);
    g.drawString("A line", 500, 70);
    g.setColor(Color.red);
    g.drawLine(305, 20,805,20);
    
    // CIRCLE

 g.setColor(Color.orange);
 g.drawString("A Circle", 900, 70);
 
 g.setColor(Color.black);
 g.drawOval(1010,30,100,100);
 g.setColor(Color.green);
 g.fillOval(1010,30,100,100);
       
       
    
    
    
    
  }
} 