// drawing basic shapes using java applets

import java.awt.*;
import java.applet.*;

public class practice extends Applet
{
    public void init()
    {
        setBackground(Color.black);
        //setForeground(Color.yellow);
    }
    public void paint(Graphics g)
    {
        g.drawRect(200,10,100,50);
        // g.fillRect(200,10,100,50); will be used only when u r writing init function and setting a foreground colour
        // but all the shapes will get the same foreground colour as written in  the init function
        g.setColor(Color.blue);
        g.drawRoundRect(200,300,100,50,30,30);
        g.setColor(Color.red);
        //g.fillRect( 200, 300, 200, 300 );
        
        g.setColor(Color.yellow);
        g.drawRect(300,150,200,100);
         
     // g.fillRect( 300,150, 200, 100 );
      g.setColor(Color.green);
      g.drawString("Rectangle",300,150);
       g.setColor(Color.red);  // now default fill inside polygon color will be red
  g.drawLine(3,300,200,10);  // drawing line , hence will be red
  g.setColor(Color.magenta);  // now default fill colour is magenta 
  g.drawString("Line",100,100); // writing text, hence will be magenta

 
  
 
  g.fillOval(50,60,40,40);
  g.setColor(Color.magenta);
  g.drawString("Circle",50,60);
  
  g.setColor(Color.green);
 g.fillArc(100,200,50,50,0,180);
 
g.setColor(Color.white);
  g.fillRect( 400, 50, 200, 300 );
  g.setColor(Color.blue);
  g.drawString("Rectanffffgle",450,100);
  
  g.setColor(Color.red);
  g.drawOval(500,200,40,60);
  g.setColor(Color.yellow);
  g.fillOval(500,200,40,60);
  
  
  Font f= new Font ("sanjana " , Font.BOLD , 100);
  g.drawString("Logical Font name : " + f.getName(),610,30);
  g.drawString("Font family : " + f.getFamily(),610,50);
  g.drawString("Font Name : " + f.getFontName(), 610,70);
  g.drawString("Font Size : " + f.getSize(), 610,90);
  g.drawString("Font Style : " + f.getStyle(), 610,110);
  
  
  Color c1 = new Color(250,160,150);
        setBackground(c1); 
        Color c2 = new Color(0,0,0);
        setForeground(c2);
        g.drawString("Testing Colors ",20,20);
        
        g.setColor(Color.blue);
        g.drawString("Testing Colors ", 20,40);
        
        Color c3 = new Color(0,255,0);
        g.setColor(c3);
        g.drawString("Testing Colors ",20,60);
        
        Color c4 = new Color(23); /*Color c = new Color(int rgb);
        24 bits mix of red, green and blue
        0.7 --> blue, 8-15 --> Green, 16-23 --> red */
        g.setColor(c4);
        g.drawString(" Testing Colors ", 20,80);
  
  
  //setFont(Font font): 
  //setColor(Color c):
  //drawImage(Image img, int x, int y, ImageObserver observer):
  
  

    }}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    